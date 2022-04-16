/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.openal;

import org.newdawn.slick.openal.Audio;

public class NullAudio
implements Audio {
    @Override
    public int playAsSoundEffect(float llllllllllllllllIllIllIIIIIIIIll, float llllllllllllllllIllIllIIIIIIIIlI, boolean llllllllllllllllIllIllIIIIIIIIIl, float llllllllllllllllIllIllIIIIIIIIII, float llllllllllllllllIllIlIllllllllll, float llllllllllllllllIllIlIlllllllllI) {
        return 0;
    }

    public NullAudio() {
        NullAudio llllllllllllllllIllIllIIIIIlIIII;
    }

    @Override
    public int playAsMusic(float llllllllllllllllIllIllIIIIIIlIll, float llllllllllllllllIllIllIIIIIIlIlI, boolean llllllllllllllllIllIllIIIIIIlIIl) {
        return 0;
    }

    @Override
    public int getBufferID() {
        return 0;
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public void stop() {
    }

    @Override
    public float getPosition() {
        return 0.0f;
    }

    @Override
    public boolean setPosition(float llllllllllllllllIllIlIllllllllII) {
        return false;
    }

    @Override
    public int playAsSoundEffect(float llllllllllllllllIllIllIIIIIIIlll, float llllllllllllllllIllIllIIIIIIIllI, boolean llllllllllllllllIllIllIIIIIIIlIl) {
        return 0;
    }
}

