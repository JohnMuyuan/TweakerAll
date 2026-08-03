/*
 * This file is part of TweakerAll, licensed under the
 * GNU Lesser General Public License v3.0 only.
 * Copyright (C) 2026 JohnMuyuan
 */
package dev.tweakerall.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;

import dev.tweakerall.config.TweakerAllConfigs;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractClientPlayer.class)
abstract class AbstractClientPlayerMixin {
    @WrapOperation(
            method = "getFieldOfViewModifier",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/player/AbstractClientPlayer;getAttributeValue(Lnet/minecraft/core/Holder;)D"))
    private double tweakerall$disableSpeedFovEffect(
            AbstractClientPlayer player, Holder<Attribute> attribute, Operation<Double> original) {
        if (TweakerAllConfigs.DISABLE_SPEED_FOV_EFFECT.getBooleanValue()
                && attribute.equals(Attributes.MOVEMENT_SPEED)) {
            return player.getAbilities().getWalkingSpeed();
        }
        return original.call(player, attribute);
    }
}
