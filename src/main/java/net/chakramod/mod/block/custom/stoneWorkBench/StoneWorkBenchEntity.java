package net.chakramod.mod.block.custom.stoneWorkBench;


import net.chakramod.mod.ChakraMod;
import net.chakramod.mod.block.custom.ModBlockEntities;
import net.chakramod.mod.recipes.StoneWorkBenchRecipe;
import net.chakramod.mod.screen.StoneWorkBenchScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class StoneWorkBenchEntity extends BlockEntity implements NamedScreenHandlerFactory, StoneWorkBenchImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 63;

    public StoneWorkBenchEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STONE_WORK_BENCH_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            public int get(int index){
                switch (index){
                    case 0: return StoneWorkBenchEntity.this.progress;
                    case 1: return StoneWorkBenchEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0: StoneWorkBenchEntity.this.progress = value; break;
                    case 1: StoneWorkBenchEntity.this.maxProgress = value; break;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Stone Work Bench");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new StoneWorkBenchScreenHandler(syncId, inv, this, this.propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems(){
        return inventory;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, inventory);
        super.writeNbt(nbt);
    }

    public static void tick(World world, BlockPos pos, BlockState state, StoneWorkBenchEntity entity) {
        System.out.println("WHY ARE YOU NOT CALLING ME BACK?!");

        if(hasRecipe(entity)){
            entity.progress++;
            if(entity.progress > entity.maxProgress){
                craftItem(entity);
            }
        }else {
            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(StoneWorkBenchEntity entity){
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for(int i = 0; i < entity.inventory.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<StoneWorkBenchRecipe> match = world.getRecipeManager()
                .getFirstMatch(StoneWorkBenchRecipe.Type.INSTANCE, inventory, world);

        return match.isPresent() && canInsetAmountIntoOutputSlot(inventory)
                && canInsertItemIntoOutputSlot(inventory, match.get().getOutput());
    }

    private static void craftItem(StoneWorkBenchEntity entity){
        World world = entity.world;
        SimpleInventory inventory = new SimpleInventory(entity.inventory.size());
        for(int i = 0; i < entity.inventory.size(); i++){
            inventory.setStack(i, entity.getStack(i));
        }

        Optional<StoneWorkBenchRecipe> match = world.getRecipeManager().getFirstMatch(StoneWorkBenchRecipe.Type.INSTANCE, inventory, world);

        if(match.isPresent()){
            entity.removeStack(0,1);
            entity.removeStack(1,1);
            entity.setStack(2, new ItemStack(match.get().getOutput().getItem(),
                    entity.getStack(2).getCount() + 1));

            entity.resetProgress();
        }
    }

    private void resetProgress(){
        this.progress = 0;
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleInventory inventory, ItemStack output){
        return inventory.getStack(2).getItem() == output.getItem() || inventory.getStack(2).isEmpty();
    }

    private static boolean canInsetAmountIntoOutputSlot(SimpleInventory inventory){
        return inventory.getStack(2).getMaxCount() > inventory.getStack(2).getCount();
    }
}
