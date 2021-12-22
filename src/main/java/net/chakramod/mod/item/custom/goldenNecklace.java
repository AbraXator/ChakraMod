package net.chakramod.mod.item.custom;

import net.chakramod.mod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Rarity;

public class goldenNecklace extends Item {

    public goldenNecklace(Settings settings) {
        super(new FabricItemSettings().group(ModItemGroup.MALACHIT).maxCount(1).fireproof().rarity(Rarity.EPIC));
    }


}
