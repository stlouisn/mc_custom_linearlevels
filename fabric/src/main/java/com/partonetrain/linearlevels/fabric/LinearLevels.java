package com.partonetrain.linearlevels.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import com.partonetrain.linearlevels.LinearLevelsCommon;
import com.partonetrain.linearlevels.LinearLevelsCommonClient;

@SuppressWarnings("unused")
public final class LinearLevels implements ModInitializer, ClientModInitializer {

	@Override
	public void onInitialize() {
		LinearLevelsCommon.commonInit();
	}

	@Override
	public void onInitializeClient() {
		LinearLevelsCommonClient.commonClientInit();
	}

}