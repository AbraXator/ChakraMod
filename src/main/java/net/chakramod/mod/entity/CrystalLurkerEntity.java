package net.chakramod.mod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.EnumSet;
import java.util.Random;

public class CrystalLurkerEntity extends PathAwareEntity implements IAnimatable {
    protected static final TrackedData<Byte> CRYSTAL_LURKER_FLAGS;

    private AnimationFactory factory = new AnimationFactory(this);

    public CrystalLurkerEntity(EntityType<? extends CrystalLurkerEntity> entityType, World world) {
        super(entityType, world);
        this.ignoreCameraFrustum = true;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(event.isMoving()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("move", true));
            return PlayState.CONTINUE;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected void initGoals() {
        super.initGoals();
        //this.goalSelector.add(10, new CrystalLurkerEntity.Attack());
        this.goalSelector.add(3, new CrystalLurkerEntity.Surrender());
    }

    protected void initDataTracker(){
        super.initDataTracker();
        this.dataTracker.startTracking(CRYSTAL_LURKER_FLAGS, (byte)0);
    }

    private boolean areFlagsSet(int mask){
        int i = (Byte)this.dataTracker.get(CRYSTAL_LURKER_FLAGS);
        return (i & mask) != 0;
    }

    private void setCrystalLurkerFlags(int mask, boolean value){
        int i = (Byte)this.dataTracker.get(CRYSTAL_LURKER_FLAGS);
        if(value){
            i = i | mask;
        }else {
            i = i & ~mask;
        }

        this.dataTracker.set(CRYSTAL_LURKER_FLAGS, (byte)(i & 255));
    }

    public boolean isCharging(){
        return this.areFlagsSet(1);
    }

    public void setCharging(boolean charging){
        this.setCrystalLurkerFlags(1, charging);
    }

    static {
         CRYSTAL_LURKER_FLAGS = DataTracker.registerData(CrystalLurkerEntity.class, TrackedDataHandlerRegistry.BYTE);
    }

    public class Attack extends Goal{
        public Attack(){
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            if(CrystalLurkerEntity.this.getTarget() != null && !CrystalLurkerEntity.this.getMoveControl().isMoving() && CrystalLurkerEntity.this.random.nextInt(toGoalTicks(7)) == 0){
                return CrystalLurkerEntity.this.squaredDistanceTo(CrystalLurkerEntity.this.getTarget()) > 4.0D;
            }else {
                return false;
            }
        }

        @Override
        public boolean shouldContinue() {
            return CrystalLurkerEntity.this.getMoveControl().isMoving() && CrystalLurkerEntity.this.getTarget() != null && CrystalLurkerEntity.this.getTarget().isAlive();
        }

        @Override
        public void start() {
            LivingEntity livingEntity = CrystalLurkerEntity.this.getTarget();
            if(livingEntity != null){
                Vec3d vec3d = livingEntity.getEyePos();
                CrystalLurkerEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
            }

            CrystalLurkerEntity.this.setCharging(true);
        }

        @Override
        public void stop() {
            CrystalLurkerEntity.this.setCharging(false);
        }

        @Override
        public boolean shouldRunEveryTick() {
            return true;
        }

        public void tick(){
            PlayerEntity livingEntity = (PlayerEntity) CrystalLurkerEntity.this.getTarget();
            if(livingEntity != null){
                if(CrystalLurkerEntity.this.getBoundingBox().intersects(livingEntity.getBoundingBox())){
                    CrystalLurkerEntity.this.tryAttack(livingEntity);
                    CrystalLurkerEntity.this.setCharging(false);
                }else {
                    double d = CrystalLurkerEntity.this.squaredDistanceTo(livingEntity);
                    if(livingEntity.isSprinting()){
                        if(d < 5.0D){
                            Vec3d vec3d = livingEntity.getEyePos();
                            CrystalLurkerEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
                        }
                    }else {
                        if(d < 3.0D) {
                            Vec3d vec3d = livingEntity.getEyePos();
                            CrystalLurkerEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
                        }
                    }if(livingEntity.isInSneakingPose()){
                        if(d < 1.0D) {
                            Vec3d vec3d = livingEntity.getEyePos();
                            CrystalLurkerEntity.this.moveControl.moveTo(vec3d.x, vec3d.y, vec3d.z, 1.0D);
                        }
                    }
                }
            }
        }
    }

    private class Surrender extends Goal{
        public Surrender(){
            this.setControls(EnumSet.of(Control.MOVE));
        }

        @Override
        public boolean canStart() {
            if(CrystalLurkerEntity.this.getHealth() <= 5){
                return true;
            }else {
                return false;
            }
        }

        @Override
        public boolean shouldContinue() {
            return true;
        }

        public void start(){
            Vec3d pos = CrystalLurkerEntity.this.getPos();
            Random random = new Random();
            if(CrystalLurkerEntity.this.getHealth() <= 5.0F){
                int direction = random.nextInt(2);
                switch (direction){
                    case 1:
                        CrystalLurkerEntity.this.getNavigation().startMovingTo(pos.x + random.nextInt(20 + 1 - 10) + 10, pos.y + random.nextInt(20 + 1 - 10) + 10, pos.z + random.nextInt(20 + 1 - 10) + 10, 0.7D);
                    case 2:
                        CrystalLurkerEntity.this.getNavigation().startMovingTo(pos.x + random.nextInt(0 + 1 - (-20)) + (-20), pos.y + random.nextInt(0 + 1 - (-20)) + (-20), pos.z + random.nextInt(0 + 1 - (-20)) + (-20), 0.7D);
                }
            }
        }

        @Override
        public void stop() {
            super.stop();
        }
    }
}
