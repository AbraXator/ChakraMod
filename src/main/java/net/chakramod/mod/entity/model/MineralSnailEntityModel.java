package net.chakramod.mod.entity.model;

import net.chakramod.mod.entity.MineralSnailEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class MineralSnailEntityModel extends AnimatedGeoModel<MineralSnailEntity> {
    public static final String ModID = "chakramod";

    @Override
    public Identifier getModelLocation(MineralSnailEntity object)
    {
        return new Identifier(ModID, "geo/mineral_snail.geo.json");
    }

    @Override
    public Identifier getTextureLocation(MineralSnailEntity object)
    {
        return new Identifier(ModID, "textures/entity/mineral_snail/mineral_snail.png");
    }

    @Override
    public Identifier getAnimationFileLocation(MineralSnailEntity object)
    {
        return new Identifier(ModID, "animations/mineral_snail.animation.json");
    }
}
