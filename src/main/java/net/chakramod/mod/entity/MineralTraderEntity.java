//package net.chakramod.mod.entity;
//
//import net.minecraft.entity.EntityType;
//import net.minecraft.entity.ai.goal.*;
//import net.minecraft.entity.mob.MobEntity;
//import net.minecraft.entity.passive.MerchantEntity;
//import net.minecraft.entity.passive.PassiveEntity;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.Items;
//import net.minecraft.server.world.ServerWorld;
//import net.minecraft.stat.Stats;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.Hand;
//import net.minecraft.village.TradeOffer;
//import net.minecraft.village.TradeOffers;
//import net.minecraft.world.World;
//import org.jetbrains.annotations.Nullable;
//import software.bernie.geckolib3.core.IAnimatable;
//import software.bernie.geckolib3.core.manager.AnimationData;
//import software.bernie.geckolib3.core.manager.AnimationFactory;
//
//import static net.chakramod.mod.ChakraMod.MINERAL_TRADER;
//
//public class MineralTraderEntity extends MerchantEntity implements IAnimatable {
//    public MineralTraderEntity(EntityType<? extends MerchantEntity> entityType, World world) {
//        super((EntityType<? extends MerchantEntity>)entityType, world);
//    }
//
//    @Override
//    protected void initGoals(){
//        this.goalSelector.add(0, new SwimGoal(this));
//        this.goalSelector.add(1, new StopFollowingCustomerGoal(this));
//        this.goalSelector.add(1, new LookAtCustomerGoal(this));
//        this.goalSelector.add(2, new WanderToTargetGoal(this, 4.0f, 0.5f));
//        this.goalSelector.add(3, new MeleeAttackGoal(this, 0.6F, false));
//        this.goalSelector.add(4, new GoToWalkTargetGoal(this, 0.5f));
//        this.goalSelector.add(8, new WanderAroundFarGoal(this, 0.4d));
//        this.goalSelector.add(9, new StopAndLookAtEntityGoal(this, PlayerEntity.class, 3.0f, 1.0f));
//        this.goalSelector.add(10, new LookAtEntityGoal(this, MobEntity.class, 8.0f));
//    }
//
//    @Nullable
//    @Override
//    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
//        return null;
//    }
//
//    @Override
//    public boolean isLeveledMerchant() {
//        return false;
//    }
//
//    @Override
//    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
//        ItemStack itemStack = player.getStackInHand(hand);
//        if(!itemStack.isOf(Items.VILLAGER_SPAWN_EGG) && this.isAlive() && !this.hasCustomer() && !this.isBaby()){
//            if(hand == Hand.MAIN_HAND){
//                player.incrementStat(Stats.TALKED_TO_VILLAGER);
//            }
//            if(this.getOffers().isEmpty()){
//                return ActionResult.success(this.world.isClient);
//            }
//            if(!this.world.isClient){
//                this.setCurrentCustomer(player);
//                this.sendOffers(player, this.getDisplayName(), 1);
//            }
//            return ActionResult.success(this.world.isClient);
//        }
//        return super.interactMob(player, hand);
//    }
//
//    public static void init(){
//        TradeOffers.WANDERING_TRADER_TRADES.put(
//                MINERAL_TRADER, Util.copyToFastUtilMap.of(
//                        1,
//                        new TradeOffers.Factory[]{
//                                new MineralTraderEntity()
//                        }
//                )
//        )
//    }
//
//    @Override
//    protected void fillRecipes(){
//        TradeOffers.Factory[] factorys = (TradeOffers.Factory[])TradeOffers.
//    }
//
//    @Override
//    protected void afterUsing(TradeOffer offer) {
//
//    }
//
//    @Override
//    protected void fillRecipes() {
//
//    }
//
//    @Override
//    public void registerControllers(AnimationData animationData) {
//
//    }
//
//    @Override
//    public AnimationFactory getFactory() {
//        return null;
//    }
//}
