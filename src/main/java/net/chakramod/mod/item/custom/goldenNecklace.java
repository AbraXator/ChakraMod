package net.chakramod.mod.item.custom;

import com.eliotlash.mclib.math.functions.classic.Mod;
import net.chakramod.mod.item.ModItemGroup;
import net.chakramod.mod.item.ModItems;
import net.chakramod.mod.util.ModTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class goldenNecklace extends Item {
    public static String[] stones = {
        "malachite", "amazonite", "rhodonite"
    };

    public goldenNecklace(Settings settings) {
        super(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(1).fireproof().rarity(Rarity.UNCOMMON));
        //NecklaceColorProvider.colorProvider();
    }



    public void addNbt(PlayerEntity player){
        ItemStack goldenNeklace = player.getInventory().getStack(firstStackInInventory(player, ModItems.GOLDEN_NECKLACE));
        NbtCompound nbtCompound = new NbtCompound();
        nbtCompound.putString("Stone", stones[1]);

        goldenNeklace.setNbt(nbtCompound);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(stack.hasNbt()){
            tooltip.add(new LiteralText(stones[1]));
        }
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        NbtCompound nbtCompound = new NbtCompound();
        nbtCompound.putString("ABC", stones[1]);
        stack.setNbt(nbtCompound);
        EntityType.EXPERIENCE_ORB.spawn(world, )
    }

    //@Override
    //public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
    //    ItemStack stack = user.getStackInHand(hand);
    //    if(hand.equals(Hand.MAIN_HAND)){
    //        addNbt(user);
    //    }
    //    System.out.println(user.getActiveStatusEffects());
    //    System.out.println(stack.getNbt());
    //    return TypedActionResult.success(stack);
    //}

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    private boolean hasGNecklace(PlayerEntity player){
        return stackInInventory(player, ModItems.GOLDEN_NECKLACE);
    }

    private boolean stackInInventory(PlayerEntity player, Item item){
        for(int i = 0; i < player.getInventory().size(); i++){
            ItemStack currentS = player.getInventory().getStack(i);
            if(!currentS.isEmpty() && currentS.isItemEqualIgnoreDamage(new ItemStack(item))){
                return true;
            }
        }
        return false;
    }

    private int firstStackInInventory(PlayerEntity player, Item item){
        for(int i = 0; i < player.getInventory().size(); i++){
            ItemStack currentStack = player.getInventory().getStack(i);
            if(!currentStack.isEmpty() && currentStack.isItemEqualIgnoreDamage(new ItemStack(item))){
                return i;
            }
        }
        return -1;
    }

    public void malachit(ItemStack stack, PlayerEntity player){
        if(hasGNecklace(player)){
            if(stack.getNbt().contains("Chakra Type")){
                player.setStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 100), player);
            }
        }
    }
}
