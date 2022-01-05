package net.chakramod.mod.block;

import net.chakramod.mod.ChakraMod;
import net.chakramod.mod.block.custom.ModStairsBlock;
import net.chakramod.mod.block.custom.glowstoneCrystal.GlowstoneCrystalSpecial;
import net.chakramod.mod.block.custom.greenCrystal.GreenCrystalSpecial;
import net.chakramod.mod.block.custom.stoneWorkBench.StoneWorkBench;
import net.chakramod.mod.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block HEART_ORE = registerBlock("heart_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()));
    public static final Block THROAT_ORE = registerBlock("throat_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()));
    public static final Block ROOT_ORE = registerBlock("root_ore", new Block(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()));
    public static final Block STONE_WORK_BENCH = registerBlock("stone_work_bench", new StoneWorkBench(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()));
    public static final Block GLOWSTONE_CRYSTAL = registerBlock("glowstone_crystal", new GlowstoneCrystalSpecial(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool().luminance((state) -> 8)));
    public static final Block GREEN_CRYSTAL = registerBlock("green_crystal", new GreenCrystalSpecial(FabricBlockSettings.of(Material.STONE).strength(4.0f).requiresTool()));
    public static final Block BLACK_MINERAL_STONE = registerBlock("black_mineral", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block BLACK_MINERAL_STONE_STAIRS = registerBlock("black_mineral_stairs", new ModStairsBlock(ModBlocks.BLACK_MINERAL_STONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block BLACK_MINERAL_STONE_SLAB = registerBlock("black_mineral_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block BLACK_MINERAL_STONE_WALL = registerBlock("black_mineral_wall", new WallBlock(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block BLACK_MINERAL_CRACKED_STONE_BRICKS = registerBlock("black_mineral_cracked_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block BLACK_MINERAL_STONE_BRICKS = registerBlock("black_mineral_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block BLACK_MINERAL_STONE_BRICK_STAIRS = registerBlock("black_mineral_brick_stairs", new ModStairsBlock(ModBlocks.BLACK_MINERAL_STONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block BLACK_MINERAL_STONE_BRICK_SLAB = registerBlock("black_mineral_brick_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block BLACK_MINERAL_STONE_BRICK_WALL = registerBlock("black_mineral_brick_wall", new WallBlock(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block BLACK_MINERAL_SMOOTH_STONE = registerBlock("black_smooth_mineral", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_STONE = registerBlock("green_mineral", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_STONE_STAIRS = registerBlock("green_mineral_stairs", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_STONE_SLAB = registerBlock("green_mineral_slab", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_STONE_WALL = registerBlock("green_mineral_wall", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_CRACKED_STONE_BRICKS = registerBlock("green_mineral_cracked_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_STONE_BRICKS = registerBlock("green_mineral_bricks", new Block(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_STONE_BRICK_STAIRS = registerBlock("green_mineral_brick_stairs", new ModStairsBlock(ModBlocks.GREEN_MINERAL_STONE.getDefaultState(), FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_STONE_BRICK_SLAB = registerBlock("green_mineral_brick_slab", new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_STONE_BRICK_WALL = registerBlock("green_mineral_brick_wall", new WallBlock(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));
    public static final Block GREEN_MINERAL_SMOOTH_STONE = registerBlock("green_smooth_mineral", new WallBlock(FabricBlockSettings.of(Material.STONE).strength(5.0F).requiresTool()));


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
