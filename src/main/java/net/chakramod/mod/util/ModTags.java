package net.chakramod.mod.util;

import net.chakramod.mod.ChakraMod;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{

    }

    public static class Items{
        public static final Tag<Item> HEART_STONES = createTag("heart_stones");
        public static final Tag<Item> ARMOR = createTag("armor");

        private static Tag<Item> createTag(String name) {
            return TagRegistry.item(new Identifier(ChakraMod.MOD_ID, name));
        }

        private static Tag<Item> createCommonTag(String name) {
            return TagRegistry.item(new Identifier("c", name));
        }
    }
}
