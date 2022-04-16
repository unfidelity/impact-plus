/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.io.InputStream;
import java.net.URL;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.Log;

public class Sound {
    private /* synthetic */ Audio sound;

    public void playAt(float llIlIIIIlllIIlI, float llIlIIIIllIllIl, float llIlIIIIllIllII) {
        Sound llIlIIIIlllIIll;
        llIlIIIIlllIIll.playAt(1.0f, 1.0f, llIlIIIIlllIIlI, llIlIIIIllIllIl, llIlIIIIllIllII);
    }

    public void play() {
        Sound llIlIIIlIIIIIIl;
        llIlIIIlIIIIIIl.play(1.0f, 1.0f);
    }

    public boolean playing() {
        Sound llIlIIIIlIIlIll;
        return llIlIIIIlIIlIll.sound.isPlaying();
    }

    public void stop() {
        Sound llIlIIIIlIIlIII;
        llIlIIIIlIIlIII.sound.stop();
    }

    public void play(float llIlIIIIllllIIl, float llIlIIIIllllIII) {
        Sound llIlIIIIllllIlI;
        llIlIIIIllllIlI.sound.playAsSoundEffect(llIlIIIIllllIIl, llIlIIIIllllIII * SoundStore.get().getSoundVolume(), false);
    }

    public void loop(float llIlIIIIlIIllll, float llIlIIIIlIIlllI) {
        Sound llIlIIIIlIlIIll;
        llIlIIIIlIlIIll.sound.playAsSoundEffect(llIlIIIIlIIllll, llIlIIIIlIIlllI * SoundStore.get().getSoundVolume(), true);
    }

    public void loop() {
        Sound llIlIIIIlIllIII;
        llIlIIIIlIllIII.loop(1.0f, 1.0f);
    }

    public Sound(String llIlIIIlIIIIlIl) throws SlickException {
        block6: {
            Sound llIlIIIlIIIlIII;
            SoundStore.get().init();
            try {
                if (llIlIIIlIIIIlIl.toLowerCase().endsWith(".ogg")) {
                    llIlIIIlIIIlIII.sound = SoundStore.get().getOgg(llIlIIIlIIIIlIl);
                    break block6;
                }
                if (llIlIIIlIIIIlIl.toLowerCase().endsWith(".wav")) {
                    llIlIIIlIIIlIII.sound = SoundStore.get().getWAV(llIlIIIlIIIIlIl);
                    break block6;
                }
                if (llIlIIIlIIIIlIl.toLowerCase().endsWith(".aif")) {
                    llIlIIIlIIIlIII.sound = SoundStore.get().getAIF(llIlIIIlIIIIlIl);
                    break block6;
                }
                if (llIlIIIlIIIIlIl.toLowerCase().endsWith(".xm") || llIlIIIlIIIIlIl.toLowerCase().endsWith(".mod")) {
                    llIlIIIlIIIlIII.sound = SoundStore.get().getMOD(llIlIIIlIIIIlIl);
                    break block6;
                }
                throw new SlickException("Only .xm, .mod, .aif, .wav and .ogg are currently supported.");
            }
            catch (Exception llIlIIIlIIIlIIl) {
                Log.error(llIlIIIlIIIlIIl);
                throw new SlickException(String.valueOf(new StringBuilder().append("Failed to load sound: ").append(llIlIIIlIIIIlIl)));
            }
        }
    }

    public void playAt(float llIlIIIIllIIlII, float llIlIIIIllIIIll, float llIlIIIIlIlllII, float llIlIIIIllIIIIl, float llIlIIIIlIllIlI) {
        Sound llIlIIIIllIIlIl;
        llIlIIIIllIIlIl.sound.playAsSoundEffect(llIlIIIIllIIlII, llIlIIIIllIIIll * SoundStore.get().getSoundVolume(), false, llIlIIIIlIlllII, llIlIIIIllIIIIl, llIlIIIIlIllIlI);
    }

    public Sound(InputStream llIlIIIlIIllIll, String llIlIIIlIIllIlI) throws SlickException {
        block6: {
            Sound llIlIIIlIIlllII;
            SoundStore.get().init();
            try {
                if (llIlIIIlIIllIlI.toLowerCase().endsWith(".ogg")) {
                    llIlIIIlIIlllII.sound = SoundStore.get().getOgg(llIlIIIlIIllIll);
                    break block6;
                }
                if (llIlIIIlIIllIlI.toLowerCase().endsWith(".wav")) {
                    llIlIIIlIIlllII.sound = SoundStore.get().getWAV(llIlIIIlIIllIll);
                    break block6;
                }
                if (llIlIIIlIIllIlI.toLowerCase().endsWith(".aif")) {
                    llIlIIIlIIlllII.sound = SoundStore.get().getAIF(llIlIIIlIIllIll);
                    break block6;
                }
                if (llIlIIIlIIllIlI.toLowerCase().endsWith(".xm") || llIlIIIlIIllIlI.toLowerCase().endsWith(".mod")) {
                    llIlIIIlIIlllII.sound = SoundStore.get().getMOD(llIlIIIlIIllIll);
                    break block6;
                }
                throw new SlickException("Only .xm, .mod, .aif, .wav and .ogg are currently supported.");
            }
            catch (Exception llIlIIIlIlIIIII) {
                Log.error(llIlIIIlIlIIIII);
                throw new SlickException(String.valueOf(new StringBuilder().append("Failed to load sound: ").append(llIlIIIlIIllIlI)));
            }
        }
    }

    public Sound(URL llIlIIIlIIlIIlI) throws SlickException {
        block6: {
            Sound llIlIIIlIIlIIII;
            SoundStore.get().init();
            String llIlIIIlIIlIIIl = llIlIIIlIIlIIlI.getFile();
            try {
                if (llIlIIIlIIlIIIl.toLowerCase().endsWith(".ogg")) {
                    llIlIIIlIIlIIII.sound = SoundStore.get().getOgg(llIlIIIlIIlIIlI.openStream());
                    break block6;
                }
                if (llIlIIIlIIlIIIl.toLowerCase().endsWith(".wav")) {
                    llIlIIIlIIlIIII.sound = SoundStore.get().getWAV(llIlIIIlIIlIIlI.openStream());
                    break block6;
                }
                if (llIlIIIlIIlIIIl.toLowerCase().endsWith(".aif")) {
                    llIlIIIlIIlIIII.sound = SoundStore.get().getAIF(llIlIIIlIIlIIlI.openStream());
                    break block6;
                }
                if (llIlIIIlIIlIIIl.toLowerCase().endsWith(".xm") || llIlIIIlIIlIIIl.toLowerCase().endsWith(".mod")) {
                    llIlIIIlIIlIIII.sound = SoundStore.get().getMOD(llIlIIIlIIlIIlI.openStream());
                    break block6;
                }
                throw new SlickException("Only .xm, .mod, .aif, .wav and .ogg are currently supported.");
            }
            catch (Exception llIlIIIlIIlIlII) {
                Log.error(llIlIIIlIIlIlII);
                throw new SlickException(String.valueOf(new StringBuilder().append("Failed to load sound: ").append(llIlIIIlIIlIIIl)));
            }
        }
    }
}

