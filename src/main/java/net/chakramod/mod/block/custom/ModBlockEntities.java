package net.chakramod.mod.block.custom;

import net.chakramod.mod.block.ModBlocks;
import net.chakramod.mod.block.custom.stoneWorkBench.StoneWorkBenchEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlockEntities {
    public static BlockEntityType<StoneWorkBenchEntity> STONE_WORK_BENCH_ENTITY;

    public static void registerBlockEntities() {
        STONE_WORK_BENCH_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "chakramod:stone_work_bench_entity",
                FabricBlockEntityTypeBuilder.create(StoneWorkBenchEntity::new, ModBlocks.STONE_WORK_BENCH).build(null));

    }
}
