//package net.chakramod.mod.gen.features;
//
//import net.chakramod.mod.ChakraMod;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;
//import net.minecraft.util.registry.RegistryKey;
//import net.minecraft.world.gen.feature.ConfiguredFeature;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
//import org.lwjgl.system.CallbackI;
//
//public class ModConfiguredFeatures {
//    private static final Feature<SingleStateFeatureConfig> HEART_FEATURE = new HeartFeature(SingleStateFeatureConfig.CODEC);
//
//    public static final RegistryKey<ConfiguredFeature<?, ?>> HEART_FEATURE_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(ChakraMod.MOD_ID, "heart_feature"));
//
//    public static final ConfiguredFeature<?, ?> HEART_FEATURE_CONFIG = HEART_FEATURE.configure(new SingleStateFeatureConfig(B));
//}
//