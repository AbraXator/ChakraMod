package net.chakramod.mod.Structures;

//import com.mojang.serialization.Codec;
//import net.minecraft.structure.StructureGeneratorFactory;
//import net.minecraft.structure.StructurePiecesCollector;
//import net.minecraft.structure.StructurePiecesGenerator;
//import net.minecraft.util.BlockRotation;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.Heightmap;
//import net.minecraft.world.gen.feature.DefaultFeatureConfig;
//import net.minecraft.world.gen.feature.StructureFeature;
//
//public class RuinFeature extends StructureFeature<DefaultFeatureConfig> {
//    public RuinFeature(Codec<DefaultFeatureConfig> configCodec) {
//        super(configCodec, StructureGeneratorFactory.simple(StructureGeneratorFactory.checkForBiomeOnTop(Heightmap.Type.WORLD_SURFACE_WG), RuinFeature::addPieces));
//    }
//
//    private static void addPieces(StructurePiecesCollector collector, StructurePiecesGenerator.Context<DefaultFeatureConfig> context){
//        BlockPos blockPos = new BlockPos(context.chunkPos().getStartX(), 90, context.chunkPos().getStartZ());
//        BlockRotation blockRotation = BlockRotation.random(context.random());
//        RuinGenerator.addPieces(context.structureManager(), blockPos, blockRotation, collector, context.random());
//    }
//
//    public static class Start extends StructureSta
//}
