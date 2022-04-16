/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.audio.SoundHandler
 *  net.minecraft.client.audio.SoundManager
 *  net.minecraftforge.fml.common.ObfuscationReflectionHelper
 */
package me.axua.impactplus.module.modules.misc;

import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class ReloadSound
extends Module {
    @Override
    public void onEnable() {
        ReloadSound lIIIIIlllIIIIl;
        try {
            SoundManager lIIIIIlllIIlII = (SoundManager)ObfuscationReflectionHelper.getPrivateValue(SoundHandler.class, (Object)mc.getSoundHandler(), (String[])new String[]{"sndManager", "field_147694_f"});
            lIIIIIlllIIlII.reloadSoundSystem();
            Command.sendClientMessage("Reloaded Sound System!");
        }
        catch (Exception lIIIIIlllIIIll) {
            lIIIIIlllIIIll.printStackTrace();
            Command.sendClientMessage("Could not Reload Sound System!");
        }
        lIIIIIlllIIIIl.disable();
    }

    public ReloadSound() {
        super("ReloadSound", Module.Category.MISC);
        ReloadSound lIIIIIlllIIlll;
    }
}

