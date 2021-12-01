package net.chakramod.mod.block;

import net.chakramod.mod.ChakraMod;
import net.chakramod.mod.block.custom.glowstoneCrystal.GlowstoneCrystalSpecial;
import net.chakramod.mod.block.custom.stoneWorkBench.StoneWorkBench;
import net.chakramod.mod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class ModBlocks extends Block{

    public static final Block HEART_ORE = registerBlock("heart_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block STONE_WORK_BENCH = registerBlock("stone_work_bench",
            new StoneWorkBench(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()));
    public static final Block CHAKRA_STONE = registerBlock("chakra_stone",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block CHAKRA_GRASS = registerBlock("chakra_grass",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block CHAKRA_GRAVEL = registerBlock("chakra_gravel",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).breakByTool(FabricToolTags.PICKAXES, 4).requiresTool()));
    public static final Block GLOWSTONE_CRYSTAL = registerBlock("glowstone_crystal",
            new GlowstoneCrystalSpecial(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool().luminance((state) -> 8)));

    public ModBlocks(Settings settings) {
        super(settings);
    }

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(ChakraMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registry.ITEM, new Identifier(ChakraMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.MALACHIT)));
    }

    public static void registerModBlocks(){
        System.out.println("tvoje máma");
    }
}
