package net.chakramod.mod;

import net.chakramod.mod.block.ModBlocks;
import net.chakramod.mod.block.custom.ModBlockEntities;
import net.chakramod.mod.entity.CrystalLurkerEntity;
import net.chakramod.mod.entity.MineralSnailEntity;
import net.chakramod.mod.gen.ModWorldGen;
import net.chakramod.mod.item.ModItems;
import net.chakramod.mod.recipes.ModRecipes;
import net.chakramod.mod.screen.StoneWorkBenchScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

public class ChakraMod implements ModInitializer {
	public static final String MOD_ID = "chakramod";
	// a public identifier for multiple parts of our bigger chest
	public static final Identifier CHAKRAMOD = new Identifier(MOD_ID, "stone_work_bench");

//----------PARTICLES------------

	public static final DefaultParticleType GLOWSTONE_CRYSTAL_PARTICLE = FabricParticleTypes.simple();

//----------GEN--------------



//-------------SPAWN EGG-------------

	//public static final Item MINERAL_SNAIL_SPAWN_EGG = new SpawnEggItem(ChakraMod.MINERAL_SNAIL, 16770508, 7758668, new Item.Settings().group(ModItemGroup.MALACHIT));

//--------------ENTITY------------------------

	public static final EntityType<MineralSnailEntity> MINERAL_SNAIL =
			Registry.register(
					Registry.ENTITY_TYPE,
					new Identifier("chakramod", "mineral_snail"),
					FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, MineralSnailEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.6F)).build()
			);

	public static final EntityType<CrystalLurkerEntity> CRYSTAL_LURKER =
			Registry.register(
					Registry.ENTITY_TYPE,
					new Identifier("chakramod", "crystal_lurker"),
					FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, CrystalLurkerEntity::new).dimensions(EntityDimensions.fixed(0.4F, 0.6F)).build()
			);

	/*public static final EntityType<ChakraVillagerEntity> CHAKRA_VILLAGER =
			Registry.register(
					Registry.ENTITY_TYPE,
					new Identifier("chakramod", "chakra_villager"),
					FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, ChakraVillagerEntity::new).dimensions(EntityDimensions.fixed(1.0F, 2.0F)).build()
			);*/

//------------ORE GENERATION--------------



//-------------BIOME--------------------



//-----------------VAR------------------

	public static final Logger LOGGER = LogManager.getLogger("chakraMod");

//--------------------BLOCK REG------------------------


//---------------SCREEN-------------

	public static ScreenHandlerType<StoneWorkBenchScreenHandler> STONE_WORK_BENCH_SCREEN_HANDLER =
			ScreenHandlerRegistry.registerSimple(new Identifier(ChakraMod.MOD_ID, "stone_work_bench"),
					StoneWorkBenchScreenHandler::new);

//--------------BLOCK ENTITY----------------


//---------------INIT---------------

	@Override
	public void onInitialize() {
//---------RECIPE INIT-------------

		ModRecipes.register();

//-----------GEN INIT-------------

		//ModConfiguredFeatures.registerConfiguredFeatures();
		//ModBiomes.initBiomes();
		//ModBiomes.registerBiomes();
		ModWorldGen.generateModWorldGen();

//------------PARTICLE INIT--------------

		Registry.register(Registry.PARTICLE_TYPE, new Identifier("chakramod", "glowstone_crystal_particle"), GLOWSTONE_CRYSTAL_PARTICLE);

//------------ENTITY SPAWN EGG INIT------------

		//Registry.register(Registry.ITEM, new Identifier("chakramod", "mineral_snail_spawn_egg"), MINERAL_SNAIL_SPAWN_EGG);

//---------------ENTITY INIT-----------

		FabricDefaultAttributeRegistry.register(MINERAL_SNAIL, MineralSnailEntity.createLivingAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 5).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2F));
		//FabricDefaultAttributeRegistry.register(CHAKRA_VILLAGER, ChakraVillagerEntity.createLivingAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 1.0F));
		FabricDefaultAttributeRegistry.register(CRYSTAL_LURKER, CrystalLurkerEntity.createLivingAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 25).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 10).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8F));


//--------------GECKO_LIB INIT-----------

		GeckoLib.initialize();

//-------------REG INIT-----------

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

//---------BLOCK REG INIT-------

		ModBlockEntities.registerBlockEntities();

//--------BLOCK GEN INIT---------



//--------LOGGER INIT------

		LOGGER.info("Hello world!");
	}
}
