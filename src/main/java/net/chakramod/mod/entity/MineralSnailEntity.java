package net.chakramod.mod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Random;

public class MineralSnailEntity extends PathAwareEntity implements IAnimatable {

    private AnimationFactory factory = new AnimationFactory(this);

    Random random = new Random();

    public MineralSnailEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.ignoreCameraFrustum = true;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(event.isMoving()){
        event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
        return PlayState.CONTINUE;
    }
        return PlayState.CONTINUE;
}

    @Override
    public void registerControllers(AnimationData data){
        data.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    public boolean isPushable() {
        return false;
    }

    protected void pushAway(Entity entity) {
    }

    @Override
    public AnimationFactory getFactory(){
        return this.factory;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 0.3f, 2));
    }
}
