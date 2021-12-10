package net.chakramod.mod;

import net.chakramod.mod.block.ModBlocks;
import net.chakramod.mod.screen.StoneWorkBenchScreen;
import net.chakramod.mod.entity.renderer.MineralSnailEntityRenderer;
import net.chakramod.mod.screen.StoneWorkBenchScreenHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ChakraModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
//-------------SCREEN INIT------------------------

        ScreenRegistry.register(ChakraMod.STONE_WORK_BENCH_SCREEN_HANDLER, StoneWorkBenchScreen::new);

//--------------PARTICLE INIT--------------

        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register(((atlasTexture, registry) -> registry.register(new Identifier("chakramod", "glowstone_crystal_particle"))));
        ParticleFactoryRegistry.getInstance().register(ChakraMod.GLOWSTONE_CRYSTAL_PARTICLE, FlameParticle.Factory::new);

//---------------ENTITY INIT---------------

        EntityRendererRegistry.register(ChakraMod.MINERAL_SNAIL, MineralSnailEntityRenderer::new);
        //EntityRendererRegistry.register(ChakraMod.CHAKRA_VILLAGER, ChakraVillagerEntityRenderer::new);

//---------------RENDERLAYER INIT---------------

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLOWSTONE_CRYSTAL, RenderLayer.getCutout());
    }
}
