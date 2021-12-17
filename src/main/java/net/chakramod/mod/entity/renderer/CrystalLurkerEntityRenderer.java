package net.chakramod.mod.entity.renderer;

import net.chakramod.mod.entity.CrystalLurkerEntity;
import net.chakramod.mod.entity.model.CrystalLurkerEntityModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CrystalLurkerEntityRenderer extends GeoEntityRenderer<CrystalLurkerEntity> {
    public CrystalLurkerEntityRenderer(EntityRendererFactory.Context context)
    {
        super(context, new CrystalLurkerEntityModel());
        this.shadowRadius = 0.3F;
    }
}
