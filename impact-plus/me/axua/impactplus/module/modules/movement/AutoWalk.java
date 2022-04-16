/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.module.modules.movement;

import me.axua.impactplus.module.Module;
import net.minecraft.client.Minecraft;

public class AutoWalk
extends Module {
    @Override
    public void onDisable() {
        Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = false;
    }

    @Override
    public void onUpdate() {
        if (!Minecraft.getMinecraft().gameSettings.keyBindForward.isPressed()) {
            Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = true;
        }
        Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = true;
    }

    public AutoWalk() {
        super("AutoWalk", Module.Category.MOVEMENT);
        AutoWalk llllllllllllllllIlIlIllllIIIIIll;
    }
}

