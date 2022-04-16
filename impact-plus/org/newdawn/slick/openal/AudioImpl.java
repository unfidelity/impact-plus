/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.openal.AL10
 */
package org.newdawn.slick.openal;

import org.lwjgl.openal.AL10;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.SoundStore;

public class AudioImpl
implements Audio {
    private /* synthetic */ float length;
    private /* synthetic */ int buffer;
    private /* synthetic */ SoundStore store;
    private /* synthetic */ int index;

    @Override
    public boolean isPlaying() {
        AudioImpl llllllllllllllllIIllIIllIllIllIl;
        if (llllllllllllllllIIllIIllIllIllIl.index != -1) {
            return llllllllllllllllIIllIIllIllIllIl.store.isPlaying(llllllllllllllllIIllIIllIllIllIl.index);
        }
        return false;
    }

    public static void restartMusic() {
        SoundStore.get().restartLoop();
    }

    @Override
    public int getBufferID() {
        AudioImpl llllllllllllllllIIllIIllIlllIlIl;
        return llllllllllllllllIIllIIllIlllIlIl.buffer;
    }

    public static void pauseMusic() {
        SoundStore.get().pauseLoop();
    }

    protected AudioImpl() {
        AudioImpl llllllllllllllllIIllIIllIlllIIlI;
        llllllllllllllllIIllIIllIlllIIlI.index = -1;
    }

    @Override
    public int playAsMusic(float llllllllllllllllIIllIIllIlIIIIIl, float llllllllllllllllIIllIIllIlIIIIII, boolean llllllllllllllllIIllIIllIlIIIIll) {
        AudioImpl llllllllllllllllIIllIIllIlIIIllI;
        llllllllllllllllIIllIIllIlIIIllI.store.playAsMusic(llllllllllllllllIIllIIllIlIIIllI.buffer, llllllllllllllllIIllIIllIlIIIIIl, llllllllllllllllIIllIIllIlIIIIII, llllllllllllllllIIllIIllIlIIIIll);
        llllllllllllllllIIllIIllIlIIIllI.index = 0;
        return llllllllllllllllIIllIIllIlIIIllI.store.getSource(0);
    }

    @Override
    public int playAsSoundEffect(float llllllllllllllllIIllIIllIlIlIIII, float llllllllllllllllIIllIIllIlIIllll, boolean llllllllllllllllIIllIIllIlIIlllI, float llllllllllllllllIIllIIllIlIIllIl, float llllllllllllllllIIllIIllIlIlIIll, float llllllllllllllllIIllIIllIlIlIIlI) {
        AudioImpl llllllllllllllllIIllIIllIlIlIIIl;
        llllllllllllllllIIllIIllIlIlIIIl.index = llllllllllllllllIIllIIllIlIlIIIl.store.playAsSoundAt(llllllllllllllllIIllIIllIlIlIIIl.buffer, llllllllllllllllIIllIIllIlIlIIII, llllllllllllllllIIllIIllIlIIllll, llllllllllllllllIIllIIllIlIIlllI, llllllllllllllllIIllIIllIlIIllIl, llllllllllllllllIIllIIllIlIlIIll, llllllllllllllllIIllIIllIlIlIIlI);
        return llllllllllllllllIIllIIllIlIlIIIl.store.getSource(llllllllllllllllIIllIIllIlIlIIIl.index);
    }

    @Override
    public void stop() {
        AudioImpl llllllllllllllllIIllIIllIlllIIII;
        if (llllllllllllllllIIllIIllIlllIIII.index != -1) {
            llllllllllllllllIIllIIllIlllIIII.store.stopSource(llllllllllllllllIIllIIllIlllIIII.index);
            llllllllllllllllIIllIIllIlllIIII.index = -1;
        }
    }

    @Override
    public boolean setPosition(float llllllllllllllllIIllIIllIIlllIIl) {
        AudioImpl llllllllllllllllIIllIIllIIllllII;
        AL10.alSourcef((int)llllllllllllllllIIllIIllIIllllII.store.getSource(llllllllllllllllIIllIIllIIllllII.index), (int)4132, (float)(llllllllllllllllIIllIIllIIlllIIl %= llllllllllllllllIIllIIllIIllllII.length));
        return AL10.alGetError() == 0;
    }

    @Override
    public int playAsSoundEffect(float llllllllllllllllIIllIIllIllIIllI, float llllllllllllllllIIllIIllIllIIlIl, boolean llllllllllllllllIIllIIllIllIIlII) {
        AudioImpl llllllllllllllllIIllIIllIllIIlll;
        llllllllllllllllIIllIIllIllIIlll.index = llllllllllllllllIIllIIllIllIIlll.store.playAsSound(llllllllllllllllIIllIIllIllIIlll.buffer, llllllllllllllllIIllIIllIllIIllI, llllllllllllllllIIllIIllIllIIlIl, llllllllllllllllIIllIIllIllIIlII);
        return llllllllllllllllIIllIIllIllIIlll.store.getSource(llllllllllllllllIIllIIllIllIIlll.index);
    }

    @Override
    public float getPosition() {
        AudioImpl llllllllllllllllIIllIIllIIllIllI;
        return AL10.alGetSourcef((int)llllllllllllllllIIllIIllIIllIllI.store.getSource(llllllllllllllllIIllIIllIIllIllI.index), (int)4132);
    }

    AudioImpl(SoundStore llllllllllllllllIIllIIllIllllllI, int llllllllllllllllIIllIIllIlllllIl) {
        AudioImpl llllllllllllllllIIllIIllIlllllll;
        llllllllllllllllIIllIIllIlllllll.index = -1;
        llllllllllllllllIIllIIllIlllllll.store = llllllllllllllllIIllIIllIllllllI;
        llllllllllllllllIIllIIllIlllllll.buffer = llllllllllllllllIIllIIllIlllllIl;
        int llllllllllllllllIIllIIlllIIIIlII = AL10.alGetBufferi((int)llllllllllllllllIIllIIllIlllllIl, (int)8196);
        int llllllllllllllllIIllIIlllIIIIIll = AL10.alGetBufferi((int)llllllllllllllllIIllIIllIlllllIl, (int)8194);
        int llllllllllllllllIIllIIlllIIIIIlI = AL10.alGetBufferi((int)llllllllllllllllIIllIIllIlllllIl, (int)8195);
        int llllllllllllllllIIllIIlllIIIIIIl = AL10.alGetBufferi((int)llllllllllllllllIIllIIllIlllllIl, (int)8193);
        int llllllllllllllllIIllIIlllIIIIIII = llllllllllllllllIIllIIlllIIIIlII / (llllllllllllllllIIllIIlllIIIIIll / 8);
        llllllllllllllllIIllIIllIlllllll.length = (float)llllllllllllllllIIllIIlllIIIIIII / (float)llllllllllllllllIIllIIlllIIIIIIl / (float)llllllllllllllllIIllIIlllIIIIIlI;
    }
}

