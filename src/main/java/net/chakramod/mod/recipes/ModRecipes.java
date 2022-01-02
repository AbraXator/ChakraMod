package net.chakramod.mod.recipes;

import net.chakramod.mod.ChakraMod;
import net.chakramod.mod.recipes.stoneWorkBench.StoneWorkBenchRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipes {
    public static void register() {
        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(ChakraMod.MOD_ID, StoneWorkBenchRecipe.Serializer.ID), StoneWorkBenchRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier(ChakraMod.MOD_ID, StoneWorkBenchRecipe.Type.ID), StoneWorkBenchRecipe.Type.INSTANCE);
    }
}