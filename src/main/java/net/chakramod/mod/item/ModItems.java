package net.chakramod.mod.item;

import net.chakramod.mod.ChakraMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;

import net.minecraft.util.registry.*;

public class ModItems {

    public static final Item MALACHIT = registerItem("malachit",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));

    public static final Item MAGNETIT = registerItem("magnetit",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));

    public static final Item AMAZONITE = registerItem("amazonite",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));

    public static final Item RHODONITE = registerItem("rhodonite",
            new Item(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(64)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ChakraMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        System.out.println("tvoje máma");
    }
}
