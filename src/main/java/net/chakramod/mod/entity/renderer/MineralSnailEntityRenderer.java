package net.chakramod.mod.entity.renderer;

import net.chakramod.mod.entity.MineralSnailEntity;
import net.chakramod.mod.entity.model.MineralSnailEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MineralSnailEntityRenderer extends GeoEntityRenderer<MineralSnailEntity> {
    public MineralSnailEntityRenderer(EntityRendererFactory.Context context)
    {
        super(context, new MineralSnailEntityModel());
        this.shadowRadius = 0.3F;

    }
}
