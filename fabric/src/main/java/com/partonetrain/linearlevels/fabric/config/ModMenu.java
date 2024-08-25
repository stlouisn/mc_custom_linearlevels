package com.partonetrain.linearlevels.fabric.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.autoconfig.AutoConfig;

import com.partonetrain.linearlevels.config.LinearLevelsConfig;

@SuppressWarnings("unused")
public class ModMenu implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> AutoConfig.getConfigScreen(LinearLevelsConfig.class, parent).get();
	}

}