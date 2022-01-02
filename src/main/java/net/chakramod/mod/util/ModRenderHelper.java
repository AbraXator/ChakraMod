package net.chakramod.mod.util;

import net.chakramod.mod.block.ModBlocks;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ModRenderHelper {
    public static void setRenderLayer(){
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_CRYSTAL, RenderLayer.getCutout());
    }
}
