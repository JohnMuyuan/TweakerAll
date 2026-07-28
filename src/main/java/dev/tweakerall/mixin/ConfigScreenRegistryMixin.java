/*
 * This file is part of TweakerAll, licensed under the
 * GNU Lesser General Public License v3.0 only.
 * Copyright (C) 2026 JohnMuyuan
 */
package dev.tweakerall.mixin;

import fi.dy.masa.malilib.gui.config.registry.ConfigScreenRegistry;
import fi.dy.masa.malilib.util.data.ModInfo;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ConfigScreenRegistry.class, remap = false)
public abstract class ConfigScreenRegistryMixin {
    @Inject(method = "registerConfigScreenFactory", at = @At("HEAD"), cancellable = true)
    private void tweakerall$hideMergedConfigScreens(ModInfo mod, CallbackInfo ci) {
        switch (mod.modId()) {
            case "tweakeroo", "tweakermore", "eclipsestweakeroo" -> ci.cancel();
        }
    }
}
