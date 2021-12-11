package net.chakramod.mod.gen.features;

import net.chakramod.mod.ChakraMod;
import net.chakramod.mod.block.ModBlocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> HEART_ORE_KEY = registerKey("heart_ore");

    public static final ConfiguredFeature<?, ?> HEART_ORE = register(Feature.ORE.configure(
                    new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, ModBlocks.HEART_ORE.getDefaultState(), 8))
            .range(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.aboveBottom(2), YOffset.fixed(45))))
            .spreadHorizontally().repeat(6), HEART_ORE_KEY);

    private static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ChakraMod.MOD_ID, name));
    }

    private static ConfiguredFeature<?, ?> register(ConfiguredFeature<?, ?> configuredFeature,
                                                    RegistryKey<ConfiguredFeature<?, ?>> key) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), configuredFeature);
    }

    public static void registerConfiguredFeatures() {
        System.out.println("Registering ModConfiguredFeatures for " + ChakraMod.MOD_ID);
    }
}
