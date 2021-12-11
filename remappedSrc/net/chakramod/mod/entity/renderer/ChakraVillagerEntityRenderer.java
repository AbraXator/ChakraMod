package net.chakramod.mod.entity.renderer;

import net.chakramod.mod.entity.ChakraVillagerEntity;
import net.chakramod.mod.entity.model.ChakraVillagerEntityModel;
import net.chakramod.mod.entity.model.MineralSnailEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ChakraVillagerEntityRenderer extends GeoEntityRenderer<ChakraVillagerEntity> {
    public ChakraVillagerEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new ChakraVillagerEntityModel());
        this.shadowRadius = 0.6F;
    }
}
