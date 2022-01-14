package net.chakramod.mod.gen.features;


import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
//import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
//import net.minecraft.world.gen.feature.DefaultFeatureConfig;
//import net.minecraft.world.gen.feature.Feature;
//import net.minecraft.world.gen.feature.SingleStateFeatureConfig;
//import net.minecraft.world.gen.feature.util.FeatureContext;
//
//import java.util.Random;
//
//public class HeartFeature extends Feature<DefaultFeatureConfig> {
//    public HeartFeature(Codec<DefaultFeatureConfig> configCodec) {
//        super(configCodec);
//    }
//
//    @Override
//    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
//        BlockState blockState;
//        BlockPos blockPos = context.getOrigin();
//        StructureWorldAccess structureWorldAccess = context.getWorld();
//        Random random = context.getRandom();
//        DefaultFeatureConfig heartFeatureConfig = context.getConfig();
//        for(int blockState2 = 0; blockState2 < 3; ++blockState2){
//            int i = random.nextInt(2);
//            int j = random.nextInt(2);
//            int k = random.nextInt(2);
//            float f = (float)(i + j + k) * 0.333F + 0.5F;
//            for (BlockPos blockPos2 : BlockPos.iterate(blockPos.add(-i, -j, -k), blockPos.add(i, j, k))){
//                if(!(blockPos2.getSquaredDistance(blockPos2) <= (double)(f * f))) continue;
//                structureWorldAccess.setBlockState(blockPos2, heartFeatureConfig.state, Block.NOTIFY_ALL);
//            }
//            blockPos = blockPos.add(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
//        }
//        return true;
//    }
//}
