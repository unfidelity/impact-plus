/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.openal.AL10
 */
package org.newdawn.slick.openal;

import ibxm.Module;
import ibxm.OpenALMODPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.newdawn.slick.openal.AudioImpl;
import org.newdawn.slick.openal.SoundStore;

public class MODSound
extends AudioImpl {
    private /* synthetic */ SoundStore store;
    private static /* synthetic */ OpenALMODPlayer player;
    private /* synthetic */ Module module;

    @Override
    public int playAsMusic(float lllllllllllllllIllllIIllllllIIll, float lllllllllllllllIllllIIlllllIlllI, boolean lllllllllllllllIllllIIllllllIIIl) {
        MODSound lllllllllllllllIllllIIllllllIlII;
        lllllllllllllllIllllIIllllllIlII.cleanUpSource();
        player.play(lllllllllllllllIllllIIllllllIlII.module, lllllllllllllllIllllIIllllllIlII.store.getSource(0), lllllllllllllllIllllIIllllllIIIl, SoundStore.get().isMusicOn());
        player.setup(lllllllllllllllIllllIIllllllIIll, 1.0f);
        lllllllllllllllIllllIIllllllIlII.store.setCurrentMusicVolume(lllllllllllllllIllllIIlllllIlllI);
        lllllllllllllllIllllIIllllllIlII.store.setMOD(lllllllllllllllIllllIIllllllIlII);
        return lllllllllllllllIllllIIllllllIlII.store.getSource(0);
    }

    private void cleanUpSource() {
        MODSound lllllllllllllllIllllIIlllllIIllI;
        AL10.alSourceStop((int)lllllllllllllllIllllIIlllllIIllI.store.getSource(0));
        IntBuffer lllllllllllllllIllllIIlllllIlIII = BufferUtils.createIntBuffer((int)1);
        for (int lllllllllllllllIllllIIlllllIIlll = AL10.alGetSourcei((int)lllllllllllllllIllllIIlllllIIllI.store.getSource(0), (int)4117); lllllllllllllllIllllIIlllllIIlll > 0; --lllllllllllllllIllllIIlllllIIlll) {
            AL10.alSourceUnqueueBuffers((int)lllllllllllllllIllllIIlllllIIllI.store.getSource(0), (IntBuffer)lllllllllllllllIllllIIlllllIlIII);
        }
        AL10.alSourcei((int)lllllllllllllllIllllIIlllllIIllI.store.getSource(0), (int)4105, (int)0);
    }

    @Override
    public float getPosition() {
        throw new RuntimeException("Positioning on modules is not currently supported");
    }

    @Override
    public boolean setPosition(float lllllllllllllllIllllIIllllIllIIl) {
        throw new RuntimeException("Positioning on modules is not currently supported");
    }

    public void poll() {
        player.update();
    }

    static {
        player = new OpenALMODPlayer();
    }

    public MODSound(SoundStore lllllllllllllllIllllIIllllllllIl, InputStream lllllllllllllllIllllIIllllllllII) throws IOException {
        MODSound lllllllllllllllIllllIIlllllllllI;
        lllllllllllllllIllllIIlllllllllI.store = lllllllllllllllIllllIIllllllllIl;
        lllllllllllllllIllllIIlllllllllI.module = OpenALMODPlayer.loadModule(lllllllllllllllIllllIIllllllllII);
    }

    @Override
    public void stop() {
        MODSound lllllllllllllllIllllIIllllIlllIl;
        lllllllllllllllIllllIIllllIlllIl.store.setMOD(null);
    }

    @Override
    public int playAsSoundEffect(float lllllllllllllllIllllIIlllllIIIIl, float lllllllllllllllIllllIIlllllIIIII, boolean lllllllllllllllIllllIIllllIlllll) {
        return -1;
    }
}

