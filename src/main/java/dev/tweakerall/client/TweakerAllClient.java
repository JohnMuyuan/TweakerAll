/*
 * This file is part of TweakerAll, licensed under the
 * GNU Lesser General Public License v3.0 only.
 * Copyright (C) 2026 JohnMuyuan
 */
package dev.tweakerall.client;

import fi.dy.masa.malilib.event.InitializationHandler;
import fi.dy.masa.malilib.registry.Registry;
import fi.dy.masa.malilib.util.data.ModInfo;
import fi.dy.masa.tweakeroo.config.Hotkeys;
import me.fallenbreath.tweakermore.config.TweakerMoreConfigs;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.Minecraft;
import xyz.eclipseisoffline.eclipsestweakeroo.client.config.EclipsesHotkeys;

public final class TweakerAllClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Registry.CONFIG_SCREEN.registerConfigScreenFactory(
                new ModInfo("tweakerall", "TweakerAll", () -> new TweakerAllConfigScreen(null)));
        InitializationHandler.getInstance().registerInitializationHandler(TweakerAllClient::configureConfigHotkeys);
    }

    private static void configureConfigHotkeys() {
        Hotkeys.OPEN_CONFIG_GUI.getKeybind().setCallback((action, key) -> open());
        TweakerMoreConfigs.OPEN_TWEAKERMORE_CONFIG_GUI.setCallBack(null);
        EclipsesHotkeys.OPEN_CONFIG_GUI.getKeybind().setCallback(null);
    }

    private static boolean open() {
        Minecraft minecraft = Minecraft.getInstance();
        minecraft.setScreen(new TweakerAllConfigScreen(minecraft.screen));
        return true;
    }
}
