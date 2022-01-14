package net.chakramod.mod.item;

import net.chakramod.mod.ChakraMod;
import net.chakramod.mod.item.custom.goldenNecklace;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item AMAZONITE = registerItem("amazonite",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item AQUAMARINE = registerItem("aquamarine",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item BLUE_HOWLITE = registerItem("blue_howlite",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item BLUE_LACE_AGATE = registerItem("blue_lace_agate",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item GREEN_OPAL = registerItem("green_opal",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item HELIOTROP = registerItem("heliotrop",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item KARNEOL = registerItem("karneol",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item KYANITE = registerItem("kyanite",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item MAHOGANY = registerItem("mahogany",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item MAGNETIT = registerItem("magnetit",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item MALACHIT = registerItem("malachit",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item RHODONITE = registerItem("rhodonite",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));
    public static final Item TOURMELIN = registerItem("tourmaline",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));

    public static final SpawnEggItem MINERAL_SNAIL_SPAWN_EGG = (SpawnEggItem) registerItem("mineral_snail_spawn_egg",
            new SpawnEggItem(ChakraMod.MINERAL_SNAIL, 16770508, 7758668,
                    new Item.Settings().group(ModItemGroup.MALACHIT)));
    public static final Item GOLDEN_NECKLACE = registerItem("golden_necklace",
            new goldenNecklace(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(1).fireproof().rarity(Rarity.UNCOMMON)));
    public static final Item DIAMOND_NECKLACE = registerItem("diamond_necklace",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(1).fireproof().rarity(Rarity.RARE)));
    public static final Item NETHERITE_NECKLACE = registerItem("netherite_necklace",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(1).fireproof().rarity(Rarity.EPIC)));
    public static final Item CRYSTAL_NECKLACE = registerItem("crystal_necklace",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(1).fireproof().rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ChakraMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        System.out.println("tvoje máma");
    }
}
