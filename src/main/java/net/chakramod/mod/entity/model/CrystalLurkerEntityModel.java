package net.chakramod.mod.entity.model;

import net.chakramod.mod.entity.CrystalLurkerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CrystalLurkerEntityModel extends AnimatedGeoModel<CrystalLurkerEntity> {
    public static final String ModID = "chakramod";


    @Override
    public Identifier getModelLocation(CrystalLurkerEntity object) {
        return new Identifier(ModID, "geo/crystal_lurker.geo.json");
    }

    @Override
    public Identifier getTextureLocation(CrystalLurkerEntity object) {
        return new Identifier(ModID, "textures/entity/crystal_lurker/crystal_lurker.png");
    }

    @Override
    public Identifier getAnimationFileLocation(CrystalLurkerEntity animatable) {
        return new Identifier(ModID, "animations/crystal_lurker.animation.json");
    }
}
