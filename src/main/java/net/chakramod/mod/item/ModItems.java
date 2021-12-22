package net.chakramod.mod.item;

import net.chakramod.mod.ChakraMod;
import net.chakramod.mod.item.custom.goldenNecklace;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item MALACHIT = registerItem("malachit",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item MAGNETIT = registerItem("magnetit",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item AMAZONITE = registerItem("amazonite",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item RHODONITE = registerItem("rhodonite",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final SpawnEggItem MINERAL_SNAIL_SPAWN_EGG = (SpawnEggItem) registerItem("mineral_snail_spawn_egg",
            new SpawnEggItem(ChakraMod.MINERAL_SNAIL, 16770508, 7758668,
                    new Item.Settings().group(ModItemGroup.MALACHIT)));
    public static final Item NECKLACE_OF_CHAKRA = registerItem("necklace_of_chakra",
            new goldenNecklace(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(1).fireproof()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ChakraMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        System.out.println("tvoje máma");
    }
}
