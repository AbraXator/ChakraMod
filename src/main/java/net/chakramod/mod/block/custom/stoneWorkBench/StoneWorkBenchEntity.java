package net.chakramod.mod.block.custom.stoneWorkBench;


import net.chakramod.mod.ChakraMod;
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
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class StoneWorkBenchEntity extends BlockEntity implements NamedScreenHandlerFactory, StoneWorkBenchImplementedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(3, ItemStack.EMPTY);

    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public StoneWorkBenchEntity(BlockPos pos, BlockState state) {
            super(ChakraMod.STONE_WORK_BENCH_ENTITY, pos, state);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        super.writeNbt(nbt);
    }

    @Override
    public Text getDisplayName() {
        return new LiteralText("Stone Work Bench");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new StoneWorkBenchScreenHandler(syncId, inv, this);
    }

    public static void hasRecipe(StoneWorkBenchEntity entity){
        World world = entity.world;
    }
}
