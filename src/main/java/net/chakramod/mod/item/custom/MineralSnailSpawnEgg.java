package net.chakramod.mod.item.custom;

import net.chakramod.mod.ChakraMod;
import net.chakramod.mod.item.ModItemGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

public class MineralSnailSpawnEgg extends SpawnEggItem {
    public MineralSnailSpawnEgg(EntityType<? extends MobEntity> type, int primaryColor, int secondaryColor, Settings settings) {
        super(ChakraMod.MINERAL_SNAIL, 16770508, 7758668, new Item.Settings().group(ModItemGroup.MALACHIT));
    }
}
