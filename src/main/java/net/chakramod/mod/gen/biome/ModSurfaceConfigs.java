package net.chakramod.mod.gen.biome;

import com.eliotlash.mclib.math.functions.classic.Mod;
import net.chakramod.mod.ChakraMod;
import net.chakramod.mod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceConfig;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import org.lwjgl.system.CallbackI;

public class ModSurfaceConfigs {
    public static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CHAKRA_SURFACE_BUILDER = register("chakra_surface",
            SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(
                    Blocks.GRASS_BLOCK.getDefaultState(),
                    ModBlocks.BLACK_MINERAL_STONE.getDefaultState(),
                    ModBlocks.HEART_ORE.getDefaultState())));

    private static <T extends SurfaceConfig> ConfiguredSurfaceBuilder<T> register(String name,
                                                                                  ConfiguredSurfaceBuilder<T> surfaceBuilder){
        return Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER,
                new Identifier(ChakraMod.MOD_ID, name), surfaceBuilder);
    }
}
