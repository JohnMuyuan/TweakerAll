/*
 * This file is part of TweakerAll, licensed under the
 * GNU Lesser General Public License v3.0 only.
 * Copyright (C) 2026 JohnMuyuan
 */
package dev.tweakerall.config;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import fi.dy.masa.malilib.config.ConfigUtils;
import fi.dy.masa.malilib.config.IConfigHandler;
import fi.dy.masa.malilib.config.options.ConfigBooleanHotkeyed;
import fi.dy.masa.malilib.util.FileUtils;
import fi.dy.masa.malilib.util.data.json.JsonUtils;

public final class TweakerAllConfigs implements IConfigHandler {
    private static final Path CONFIG_FILE = FileUtils.getConfigDirectory().resolve("tweakerall.json");

    public static final ConfigBooleanHotkeyed DISABLE_SPEED_FOV_EFFECT = new ConfigBooleanHotkeyed(
            "disableSpeedFovEffect", false, "", "tweakerall.config.disableSpeedFovEffect.comment");
    public static final List<ConfigBooleanHotkeyed> DISABLE_OPTIONS = List.of(DISABLE_SPEED_FOV_EFFECT);

    static {
        DISABLE_SPEED_FOV_EFFECT.setTranslatedName("tweakerall.config.disableSpeedFovEffect.name");
    }

    @Override
    public void load() {
        if (!Files.isReadable(CONFIG_FILE)) return;
        JsonElement config = JsonUtils.parseJsonFile(CONFIG_FILE);
        if (config != null && config.isJsonObject()) {
            ConfigUtils.readHotkeyToggleOptions(
                    config.getAsJsonObject(), "disable_hotkeys", "disable", DISABLE_OPTIONS);
        }
    }

    @Override
    public void save() {
        FileUtils.createDirectoriesIfMissing(CONFIG_FILE.getParent());
        JsonObject root = new JsonObject();
        ConfigUtils.writeHotkeyToggleOptions(root, "disable_hotkeys", "disable", DISABLE_OPTIONS);
        JsonUtils.writeJsonToFile(root, CONFIG_FILE);
    }
}
