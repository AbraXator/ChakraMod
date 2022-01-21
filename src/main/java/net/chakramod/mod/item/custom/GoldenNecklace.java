package net.chakramod.mod.item.custom;

import com.eliotlash.mclib.math.functions.classic.Mod;
import net.chakramod.mod.block.ModBlocks;
import net.chakramod.mod.enchants.ModEnchants;
import net.chakramod.mod.item.ModItemGroup;
import net.chakramod.mod.item.ModItems;
import net.chakramod.mod.util.ModTags;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.BundleTooltipData;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.tag.Tag;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.*;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.CallbackI;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class GoldenNecklace extends Item {
    private static final String ITEMS_KEY = "Items";
    public static final int MAX_STORAGE = 2;
    private static final int ITEM_BAR_COLOR = MathHelper.packRgb(233, 177, 21);
    public static String[] minerals;

    public GoldenNecklace(Settings settings) {
        super(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(1).fireproof().rarity(Rarity.UNCOMMON));
    }

    public static float getAmountFilled(ItemStack stack){
        return (float)GoldenNecklace.getNecklaceOccupancy(stack) / 2.0f;
    }

    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if(clickType != ClickType.RIGHT){
            return false;
        }
        ItemStack itemStack = slot.getStack();
        if(itemStack.isEmpty()){
            GoldenNecklace.removeFirstStack(stack).ifPresent(removedStack -> GoldenNecklace.addToNecklace(stack, slot.insertStack((ItemStack)removedStack)));
        }else if(itemStack.getItem().canBeNested()){
            int i = (64 - GoldenNecklace.getNecklaceOccupancy(stack)) / GoldenNecklace.getItemOccupancy(itemStack);
            int j = GoldenNecklace.addToNecklace(stack, slot.takeStackRange(itemStack.getCount(), i, player));
            if(j > 0){
            }
        }
        return true;
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference){
        if(clickType != ClickType.RIGHT || !slot.canTakePartial(player)){
            return false;
        }
        if(otherStack.isEmpty()){
            GoldenNecklace.removeFirstStack(stack).ifPresent(itemStack -> {
            cursorStackReference.set((ItemStack)itemStack);
            });
        }else {
            int i = GoldenNecklace.addToNecklace(stack, otherStack);
            if(i > 0){
                otherStack.decrement(i);
            }
        }
        return true;
    }

    @Override
    public boolean isItemBarVisible(ItemStack stack){
        return GoldenNecklace.getNecklaceOccupancy(stack) > 0;
    }

    @Override
    public int getItemBarStep(ItemStack stack){
        return Math.min(1 + 12 * GoldenNecklace.getNecklaceOccupancy(stack) / 2, 13);
    }

    @Override
    public int getItemBarColor(ItemStack stack) {
        return ITEM_BAR_COLOR;
    }

    static boolean isInTag(ItemStack stack, Tag<ModTags.Items> tag){
        return tag.values().contains(stack.getItem());
    }

    private static int addToNecklace(ItemStack necklace, ItemStack stack){
        if(stack.isEmpty() || !stack.getItem().canBeNested()){
            return 0;
        }
        NbtCompound nbtCompound = necklace.getOrCreateNbt();
        if(!nbtCompound.contains(ITEMS_KEY)){
            nbtCompound.put(ITEMS_KEY, new NbtList());
        }
        int i = GoldenNecklace.getNecklaceOccupancy(necklace);
        int j = GoldenNecklace.getItemOccupancy(stack);
        int k = Math.min(stack.getCount(), (2 - i) / j);
        if(k == 0){
            return 0;
        }
        NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
        Optional<NbtCompound> optional = GoldenNecklace.canMergeStack(stack, nbtList);
        if(optional.isPresent()){
            NbtCompound nbtCompound2 = optional.get();
            ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
            itemStack.increment(k);
            itemStack.writeNbt(nbtCompound2);
            nbtList.remove(nbtCompound2);
            nbtList.add(0, nbtCompound2);
        }else {
            ItemStack nbtCompound2 = stack.copy();
            nbtCompound2.setCount(k);
            NbtCompound itemStack = new NbtCompound();
            nbtCompound2.writeNbt(itemStack);
            nbtList.add(0, itemStack);
        }
        return k;
    }

    private static Optional<NbtCompound> canMergeStack(ItemStack stack, NbtList items){
        if(stack.isOf(ModItems.GOLDEN_NECKLACE)){
            return Optional.empty();
        }
        return items.stream().filter(NbtCompound.class::isInstance).map(NbtCompound.class::cast).filter(item -> ItemStack.canCombine(ItemStack.fromNbt(item), stack)).findFirst();
    }

    private static int getItemOccupancy(ItemStack stack){
        NbtCompound nbtCompound;
        if(stack.isOf(ModItems.GOLDEN_NECKLACE)){
            return 4 + GoldenNecklace.getNecklaceOccupancy(stack);
        }
        return 64 / stack.getMaxCount();
    }

    private static int getNecklaceOccupancy(ItemStack stack){
        return GoldenNecklace.getStacks(stack).mapToInt(itemStack -> GoldenNecklace.getItemOccupancy(itemStack) * itemStack.getCount()).sum();
    }

    private static Optional<ItemStack> removeFirstStack(ItemStack stack){
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        if(!nbtCompound.contains(ITEMS_KEY)){
            return Optional.empty();
        }
        NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
        if(nbtList.isEmpty()){
            return Optional.empty();
        }
        boolean i = false;
        NbtCompound nbtCompound2 = nbtList.getCompound(0);
        ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
        nbtList.remove(0);
        if (nbtList.isEmpty()) {
            stack.removeSubNbt(ITEMS_KEY);
        }
        return Optional.of(itemStack);
    }

    private static boolean dropAllItems(ItemStack stack, PlayerEntity player){
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        if(!nbtCompound.contains(ITEMS_KEY)){
            return false;
        }
        if(player instanceof ServerPlayerEntity){
            NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
            for (int i = 0; i < nbtList.size(); ++i){
                NbtCompound nbtCompound2 = nbtList.getCompound(i);
                ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
                player.dropItem(itemStack, true);
            }
        }
        stack.removeSubNbt(ITEMS_KEY);
        return true;
    }

    private static Stream<ItemStack> getStacks(ItemStack stack){
        NbtCompound nbtCompound = stack.getNbt();
        if(nbtCompound == null){
            return Stream.empty();
        }
        NbtList nbtList = nbtCompound.getList(ITEMS_KEY, 10);
        return nbtList.stream().map(NbtCompound.class::cast).map(ItemStack::fromNbt);
    }

    @Override
    public Optional<TooltipData> getTooltipData(ItemStack stack){
        DefaultedList<ItemStack> defaultedList = DefaultedList.of();
        GoldenNecklace.getStacks(stack).forEach(defaultedList::add);
        return Optional.of(new BundleTooltipData(defaultedList, GoldenNecklace.getNecklaceOccupancy(stack)));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("Fullness", GoldenNecklace.getNecklaceOccupancy(stack), 2).formatted(Formatting.GRAY));
    }

    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        ItemUsage.spawnItemContents(entity, GoldenNecklace.getStacks(entity.getStack()));
    }
}
