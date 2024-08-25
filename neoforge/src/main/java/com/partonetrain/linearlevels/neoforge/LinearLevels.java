package com.partonetrain.linearlevels.neoforge;

import net.neoforged.fml.common.Mod;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import me.shedaniel.autoconfig.AutoConfig;

import com.partonetrain.linearlevels.LinearLevelsCommon;
import com.partonetrain.linearlevels.LinearLevelsCommonClient;
import com.partonetrain.linearlevels.config.LinearLevelsConfig;

@Mod(LinearLevelsCommon.MOD_ID)
public class LinearLevels {

    public LinearLevels(IEventBus modBus) {

        modBus.addListener(this::commonSetup);
        modBus.addListener(this::clientSetup);

        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () ->
                (client, parent) -> AutoConfig.getConfigScreen(LinearLevelsConfig.class, parent).get());

    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(LinearLevelsCommon::commonInit);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(LinearLevelsCommonClient::commonClientInit);
    }

}