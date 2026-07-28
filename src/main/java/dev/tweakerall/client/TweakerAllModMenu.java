/*
 * This file is part of TweakerAll, licensed under the
 * GNU Lesser General Public License v3.0 only.
 * Copyright (C) 2026 JohnMuyuan
 */
package dev.tweakerall.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

public final class TweakerAllModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return TweakerAllConfigScreen::new;
    }
}
