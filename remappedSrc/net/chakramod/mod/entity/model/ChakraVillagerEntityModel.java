package net.chakramod.mod.entity.model;

import net.chakramod.mod.entity.ChakraVillagerEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChakraVillagerEntityModel extends AnimatedGeoModel<ChakraVillagerEntity> {
    public static final String ModID = "chakramod";

    @Override
    public Identifier getModelLocation(ChakraVillagerEntity object) {
        return new Identifier(ModID, "geo/chakra_villager.geo.json");
    }

    @Override
    public Identifier getTextureLocation(ChakraVillagerEntity object) {
        return new Identifier(ModID, "textures/entity/chakra_villager/chakra_villager.png");
    }

    @Override
    public Identifier getAnimationFileLocation(ChakraVillagerEntity animatable) {
        return new Identifier(ModID, "animations/chakra_villager.animation.json");
    }
}