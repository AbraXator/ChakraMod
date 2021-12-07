package net.chakramod.mod.block.custom.stoneWorkBench;


import net.chakramod.mod.ChakraMod;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class StoneWorkBenchEntity extends BlockEntity {
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
}
