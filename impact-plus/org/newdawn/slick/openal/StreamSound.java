/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.openal.AL10
 */
package org.newdawn.slick.openal;

import java.io.IOException;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.newdawn.slick.openal.AudioImpl;
import org.newdawn.slick.openal.OpenALStreamPlayer;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.Log;

public class StreamSound
extends AudioImpl {
    private /* synthetic */ OpenALStreamPlayer player;

    @Override
    public int playAsSoundEffect(float lIllIlIIIIlllII, float lIllIlIIIIlIlll, boolean lIllIlIIIIlIllI) {
        StreamSound lIllIlIIIIllIIl;
        return lIllIlIIIIllIIl.playAsMusic(lIllIlIIIIlllII, lIllIlIIIIlIlll, lIllIlIIIIlIllI);
    }

    @Override
    public void stop() {
        SoundStore.get().setStream(null);
    }

    @Override
    public boolean setPosition(float lIllIlIIIIIllll) {
        StreamSound lIllIlIIIIlIIII;
        return lIllIlIIIIlIIII.player.setPosition(lIllIlIIIIIllll);
    }

    private void cleanUpSource() {
        SoundStore lIllIlIIIllIllI = SoundStore.get();
        AL10.alSourceStop((int)lIllIlIIIllIllI.getSource(0));
        IntBuffer lIllIlIIIllIlIl = BufferUtils.createIntBuffer((int)1);
        for (int lIllIlIIIllIlII = AL10.alGetSourcei((int)lIllIlIIIllIllI.getSource(0), (int)4117); lIllIlIIIllIlII > 0; --lIllIlIIIllIlII) {
            AL10.alSourceUnqueueBuffers((int)lIllIlIIIllIllI.getSource(0), (IntBuffer)lIllIlIIIllIlIl);
        }
        AL10.alSourcei((int)lIllIlIIIllIllI.getSource(0), (int)4105, (int)0);
    }

    @Override
    public int playAsMusic(float lIllIlIIlIIIIIl, float lIllIlIIlIIIIII, boolean lIllIlIIIllllll) {
        StreamSound lIllIlIIlIIIIlI;
        try {
            lIllIlIIlIIIIlI.cleanUpSource();
            lIllIlIIlIIIIlI.player.setup(lIllIlIIlIIIIIl);
            lIllIlIIlIIIIlI.player.play(lIllIlIIIllllll);
            SoundStore.get().setStream(lIllIlIIlIIIIlI.player);
        }
        catch (IOException lIllIlIIlIIIIll) {
            Log.error(String.valueOf(new StringBuilder().append("Failed to read OGG source: ").append(lIllIlIIlIIIIlI.player.getSource())));
        }
        return SoundStore.get().getSource(0);
    }

    @Override
    public boolean isPlaying() {
        StreamSound lIllIlIIlIIlIII;
        return SoundStore.get().isPlaying(lIllIlIIlIIlIII.player);
    }

    public StreamSound(OpenALStreamPlayer lIllIlIIlIIlIll) {
        StreamSound lIllIlIIlIIlllI;
        lIllIlIIlIIlllI.player = lIllIlIIlIIlIll;
    }

    @Override
    public int playAsSoundEffect(float lIllIlIIIlIlIll, float lIllIlIIIlIlIlI, boolean lIllIlIIIlIIIlI, float lIllIlIIIlIlIII, float lIllIlIIIlIIlll, float lIllIlIIIlIIllI) {
        StreamSound lIllIlIIIlIIlIl;
        return lIllIlIIIlIIlIl.playAsMusic(lIllIlIIIlIlIll, lIllIlIIIlIlIlI, lIllIlIIIlIIIlI);
    }

    @Override
    public float getPosition() {
        StreamSound lIllIlIIIIIllIl;
        return lIllIlIIIIIllIl.player.getPosition();
    }
}

