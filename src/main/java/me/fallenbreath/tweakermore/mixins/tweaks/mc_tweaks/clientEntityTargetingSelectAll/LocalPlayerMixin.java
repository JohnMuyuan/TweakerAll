/*
 * This file is part of the TweakerMore project, licensed under the
 * GNU Lesser General Public License v3.0.
 */
package me.fallenbreath.tweakermore.mixins.tweaks.mc_tweaks.clientEntityTargetingSelectAll;

import me.fallenbreath.tweakermore.util.mixin.DummyClass;
import org.spongepowered.asm.mixin.Mixin;

/**
 * The 26.1.2 implementation moved to MinecraftClient_pickEntityMixin.
 * Keeping the old LocalPlayer injection causes ambiguous @Local capture.
 */
@Mixin(DummyClass.class)
public abstract class LocalPlayerMixin {
}
