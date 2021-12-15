package net.chakramod.mod.gen.biome;

import net.chakramod.mod.ChakraMod;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.SpawnSettings.Builder;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.jetbrains.annotations.Nullable;

public class ModBiomes {
    public static final RegistryKey<Biome> MINERAL_CAVERNS_KEY = registerKey("mineral_caverns");
    public static final Biome MINERAL_CAVERNS = createMineralCaverns();

    public static int getSkyColor(float temperature) {
        float g = temperature / 3.0F;
        g = MathHelper.clamp(g, -1F, 1F);
        return MathHelper.hsvToRgb(0, 0, 0);
    }

    public static BiomeEffects.Builder genericEffectBuilder(float temperature) {
        return new BiomeEffects.Builder()
                .waterColor(2038043)
                .waterFogColor(5061955)
                .fogColor(5061955)
                .skyColor(getSkyColor(temperature))
                .moodSound(BiomeMoodSound.CAVE)
                .music(null);
    }

    public static Biome createBiome(Biome.Precipitation precipitation, Biome.Category category, float temperature, float downfall, SpawnSettings spawnSettings, GenerationSettings genSettings, @Nullable MusicSound music) {
        return createBiome(category, precipitation, temperature, downfall, spawnSettings, genSettings, genericEffectBuilder(temperature).build());
    }

    public static Biome createBiome(Biome.Category category, Biome.Precipitation precipitation, float temperature, float downfall, int waterColor, int waterFogColor, int fogColor, SpawnSettings spawnSettings, GenerationSettings genSettings, @Nullable MusicSound music) {
        return createBiome(category, precipitation, temperature, downfall, spawnSettings, genSettings,
                new BiomeEffects.Builder()
                        .waterColor(waterColor)
                        .waterFogColor(waterFogColor)
                        .fogColor(fogColor)
                        .skyColor(getSkyColor(temperature))
                        .moodSound(BiomeMoodSound.CAVE)
                        .build()
        );
    }

    public static Biome createBiome(Biome.Category category, Biome.Precipitation precipitation, float temperature, float downfall, SpawnSettings spawnSettings, GenerationSettings genSettings, BiomeEffects effects) {
        return new Biome.Builder()
                .precipitation(precipitation)
                .category(category)
                .temperature(temperature)
                .downfall(downfall)
                .effects(effects)
                .spawnSettings(spawnSettings)
                .generationSettings(genSettings)
                .build();
    }

    public static Biome createMineralCaverns() {
        Builder builder = new Builder();
        DefaultBiomeFeatures.addDripstoneCaveMobs(builder);
        GenerationSettings.Builder builder2 = new GenerationSettings.Builder();
        addBasicFeatures(builder2);
        DefaultBiomeFeatures.addPlainsTallGrass(builder2);
        DefaultBiomeFeatures.addDefaultOres(builder2, true);
        DefaultBiomeFeatures.addDefaultDisks(builder2);
        DefaultBiomeFeatures.addPlainsFeatures(builder2);
        DefaultBiomeFeatures.addDefaultMushrooms(builder2);
        DefaultBiomeFeatures.addDefaultVegetation(builder2);
        DefaultBiomeFeatures.addDripstone(builder2);
        return null;
        //return createBiome(Biome.Category.UNDERGROUND, Biome.Precipitation.NONE, 0.8F, 0.4F, builder, builder2));
    }

    private static void addBasicFeatures(GenerationSettings.Builder generationSettings){
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDefaultOres(generationSettings, false);
    }

    public static RegistryKey<Biome> registerKey(String name){
        return RegistryKey.of(Registry.BIOME_KEY, new Identifier(ChakraMod.MOD_ID, name));
    }

    public static void registerBiomes() {
        Registry.register(BuiltinRegistries.BIOME, MINERAL_CAVERNS_KEY.getValue(), MINERAL_CAVERNS);

        //OverworldBiomes.addContinentalBiome(LAVA_LAND_KEY, OverworldClimate.DRY, 1D);
    }

    public static void initBiomes() {
        System.out.println("Registering ModBiomes for " + ChakraMod.MOD_ID);
    }
}
