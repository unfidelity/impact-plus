/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioImpl;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.Log;

public class Music {
    private /* synthetic */ float fadeEndGain;
    private /* synthetic */ Audio sound;
    private /* synthetic */ float requiredPosition;
    private static /* synthetic */ Music currentMusic;
    private /* synthetic */ int fadeTime;
    private /* synthetic */ int fadeDuration;
    private /* synthetic */ ArrayList<MusicListener> listeners;
    private /* synthetic */ float fadeStartGain;
    private /* synthetic */ boolean stopAfterFade;
    private /* synthetic */ boolean positioning;
    private /* synthetic */ boolean playing;
    private /* synthetic */ float volume;

    public Music(URL llllllllllllllllIIIlIIllIllllIll) throws SlickException {
        llllllllllllllllIIIlIIllIlllllII(llllllllllllllllIIIlIIllIllllIll, false);
        Music llllllllllllllllIIIlIIllIlllllII;
    }

    private void fireMusicEnded() {
        Music llllllllllllllllIIIlIIllIlIIIIll;
        llllllllllllllllIIIlIIllIlIIIIll.playing = false;
        for (int llllllllllllllllIIIlIIllIlIIIlIl = 0; llllllllllllllllIIIlIIllIlIIIlIl < llllllllllllllllIIIlIIllIlIIIIll.listeners.size(); ++llllllllllllllllIIIlIIllIlIIIlIl) {
            llllllllllllllllIIIlIIllIlIIIIll.listeners.get(llllllllllllllllIIIlIIllIlIIIlIl).musicEnded(llllllllllllllllIIIlIIllIlIIIIll);
        }
    }

    public float getPosition() {
        Music llllllllllllllllIIIlIIlIllIlllll;
        return llllllllllllllllIIIlIIlIllIlllll.sound.getPosition();
    }

    public void loop() {
        Music llllllllllllllllIIIlIIllIIllIlll;
        llllllllllllllllIIIlIIllIIllIlll.loop(1.0f, 1.0f);
    }

    public boolean setPosition(float llllllllllllllllIIIlIIlIlllIIlIl) {
        Music llllllllllllllllIIIlIIlIlllIIllI;
        if (llllllllllllllllIIIlIIlIlllIIllI.playing) {
            llllllllllllllllIIIlIIlIlllIIllI.requiredPosition = -1.0f;
            llllllllllllllllIIIlIIlIlllIIllI.positioning = true;
            llllllllllllllllIIIlIIlIlllIIllI.playing = false;
            boolean llllllllllllllllIIIlIIlIlllIIlll = llllllllllllllllIIIlIIlIlllIIllI.sound.setPosition(llllllllllllllllIIIlIIlIlllIIlIl);
            llllllllllllllllIIIlIIlIlllIIllI.playing = true;
            llllllllllllllllIIIlIIlIlllIIllI.positioning = false;
            return llllllllllllllllIIIlIIlIlllIIlll;
        }
        llllllllllllllllIIIlIIlIlllIIllI.requiredPosition = llllllllllllllllIIIlIIlIlllIIlIl;
        return false;
    }

    void update(int llllllllllllllllIIIlIIlIlllIllII) {
        Music llllllllllllllllIIIlIIlIlllIllIl;
        if (!llllllllllllllllIIIlIIlIlllIllIl.playing) {
            return;
        }
        if (llllllllllllllllIIIlIIlIlllIllIl.fadeTime > 0) {
            llllllllllllllllIIIlIIlIlllIllIl.fadeTime -= llllllllllllllllIIIlIIlIlllIllII;
            if (llllllllllllllllIIIlIIlIlllIllIl.fadeTime <= 0) {
                llllllllllllllllIIIlIIlIlllIllIl.fadeTime = 0;
                if (llllllllllllllllIIIlIIlIlllIllIl.stopAfterFade) {
                    llllllllllllllllIIIlIIlIlllIllIl.stop();
                    return;
                }
            }
            float llllllllllllllllIIIlIIlIllllIIII = (llllllllllllllllIIIlIIlIlllIllIl.fadeEndGain - llllllllllllllllIIIlIIlIlllIllIl.fadeStartGain) * (1.0f - (float)llllllllllllllllIIIlIIlIlllIllIl.fadeTime / (float)llllllllllllllllIIIlIIlIlllIllIl.fadeDuration);
            llllllllllllllllIIIlIIlIlllIllIl.setVolume(llllllllllllllllIIIlIIlIlllIllIl.fadeStartGain + llllllllllllllllIIIlIIlIllllIIII);
        }
    }

    public Music(InputStream llllllllllllllllIIIlIIllIlllIIIl, String llllllllllllllllIIIlIIllIlllIIII) throws SlickException {
        block6: {
            Music llllllllllllllllIIIlIIllIlllIlIl;
            llllllllllllllllIIIlIIllIlllIlIl.listeners = new ArrayList();
            llllllllllllllllIIIlIIllIlllIlIl.volume = 1.0f;
            llllllllllllllllIIIlIIllIlllIlIl.requiredPosition = -1.0f;
            SoundStore.get().init();
            try {
                if (llllllllllllllllIIIlIIllIlllIIII.toLowerCase().endsWith(".ogg")) {
                    llllllllllllllllIIIlIIllIlllIlIl.sound = SoundStore.get().getOgg(llllllllllllllllIIIlIIllIlllIIIl);
                    break block6;
                }
                if (llllllllllllllllIIIlIIllIlllIIII.toLowerCase().endsWith(".wav")) {
                    llllllllllllllllIIIlIIllIlllIlIl.sound = SoundStore.get().getWAV(llllllllllllllllIIIlIIllIlllIIIl);
                    break block6;
                }
                if (llllllllllllllllIIIlIIllIlllIIII.toLowerCase().endsWith(".xm") || llllllllllllllllIIIlIIllIlllIIII.toLowerCase().endsWith(".mod")) {
                    llllllllllllllllIIIlIIllIlllIlIl.sound = SoundStore.get().getMOD(llllllllllllllllIIIlIIllIlllIIIl);
                    break block6;
                }
                if (llllllllllllllllIIIlIIllIlllIIII.toLowerCase().endsWith(".aif") || llllllllllllllllIIIlIIllIlllIIII.toLowerCase().endsWith(".aiff")) {
                    llllllllllllllllIIIlIIllIlllIlIl.sound = SoundStore.get().getAIF(llllllllllllllllIIIlIIllIlllIIIl);
                    break block6;
                }
                throw new SlickException("Only .xm, .mod, .ogg, and .aif/f are currently supported.");
            }
            catch (Exception llllllllllllllllIIIlIIllIlllIllI) {
                Log.error(llllllllllllllllIIIlIIllIlllIllI);
                throw new SlickException(String.valueOf(new StringBuilder().append("Failed to load music: ").append(llllllllllllllllIIIlIIllIlllIIII)));
            }
        }
    }

    public boolean playing() {
        Music llllllllllllllllIIIlIIllIIIIlIIl;
        return currentMusic == llllllllllllllllIIIlIIllIIIIlIIl && llllllllllllllllIIIlIIllIIIIlIIl.playing;
    }

    public Music(String llllllllllllllllIIIlIIllIlIlIllI, boolean llllllllllllllllIIIlIIllIlIlIlIl) throws SlickException {
        block6: {
            Music llllllllllllllllIIIlIIllIlIllIlI;
            llllllllllllllllIIIlIIllIlIllIlI.listeners = new ArrayList();
            llllllllllllllllIIIlIIllIlIllIlI.volume = 1.0f;
            llllllllllllllllIIIlIIllIlIllIlI.requiredPosition = -1.0f;
            SoundStore.get().init();
            try {
                if (llllllllllllllllIIIlIIllIlIlIllI.toLowerCase().endsWith(".ogg")) {
                    llllllllllllllllIIIlIIllIlIllIlI.sound = llllllllllllllllIIIlIIllIlIlIlIl ? SoundStore.get().getOggStream(llllllllllllllllIIIlIIllIlIlIllI) : SoundStore.get().getOgg(llllllllllllllllIIIlIIllIlIlIllI);
                    break block6;
                }
                if (llllllllllllllllIIIlIIllIlIlIllI.toLowerCase().endsWith(".wav")) {
                    llllllllllllllllIIIlIIllIlIllIlI.sound = SoundStore.get().getWAV(llllllllllllllllIIIlIIllIlIlIllI);
                    break block6;
                }
                if (llllllllllllllllIIIlIIllIlIlIllI.toLowerCase().endsWith(".xm") || llllllllllllllllIIIlIIllIlIlIllI.toLowerCase().endsWith(".mod")) {
                    llllllllllllllllIIIlIIllIlIllIlI.sound = SoundStore.get().getMOD(llllllllllllllllIIIlIIllIlIlIllI);
                    break block6;
                }
                if (llllllllllllllllIIIlIIllIlIlIllI.toLowerCase().endsWith(".aif") || llllllllllllllllIIIlIIllIlIlIllI.toLowerCase().endsWith(".aiff")) {
                    llllllllllllllllIIIlIIllIlIllIlI.sound = SoundStore.get().getAIF(llllllllllllllllIIIlIIllIlIlIllI);
                    break block6;
                }
                throw new SlickException("Only .xm, .mod, .ogg, and .aif/f are currently supported.");
            }
            catch (Exception llllllllllllllllIIIlIIllIlIllIll) {
                Log.error(llllllllllllllllIIIlIIllIlIllIll);
                throw new SlickException(String.valueOf(new StringBuilder().append("Failed to load sound: ").append(llllllllllllllllIIIlIIllIlIlIllI)));
            }
        }
    }

    public void pause() {
        llllllllllllllllIIIlIIllIIIlIIll.playing = false;
        AudioImpl.pauseMusic();
    }

    public void removeListener(MusicListener llllllllllllllllIIIlIIllIlIIlIII) {
        Music llllllllllllllllIIIlIIllIlIIlIll;
        llllllllllllllllIIIlIIllIlIIlIll.listeners.remove(llllllllllllllllIIIlIIllIlIIlIII);
    }

    private void fireMusicSwapped(Music llllllllllllllllIIIlIIllIIllllII) {
        Music llllllllllllllllIIIlIIllIIlllIll;
        llllllllllllllllIIIlIIllIIlllIll.playing = false;
        for (int llllllllllllllllIIIlIIllIIlllllI = 0; llllllllllllllllIIIlIIllIIlllllI < llllllllllllllllIIIlIIllIIlllIll.listeners.size(); ++llllllllllllllllIIIlIIllIIlllllI) {
            llllllllllllllllIIIlIIllIIlllIll.listeners.get(llllllllllllllllIIIlIIllIIlllllI).musicSwapped(llllllllllllllllIIIlIIllIIlllIll, llllllllllllllllIIIlIIllIIllllII);
        }
    }

    public void setVolume(float llllllllllllllllIIIlIIllIIIIIlIl) {
        Music llllllllllllllllIIIlIIllIIIIIllI;
        if (llllllllllllllllIIIlIIllIIIIIlIl > 1.0f) {
            llllllllllllllllIIIlIIllIIIIIlIl = 1.0f;
        } else if (llllllllllllllllIIIlIIllIIIIIlIl < 0.0f) {
            llllllllllllllllIIIlIIllIIIIIlIl = 0.0f;
        }
        llllllllllllllllIIIlIIllIIIIIllI.volume = llllllllllllllllIIIlIIllIIIIIlIl;
        if (currentMusic == llllllllllllllllIIIlIIllIIIIIllI) {
            SoundStore.get().setCurrentMusicVolume(llllllllllllllllIIIlIIllIIIIIlIl);
        }
    }

    public static void poll(int llllllllllllllllIIIlIIlllIIIlIII) {
        if (currentMusic != null) {
            SoundStore.get().poll(llllllllllllllllIIIlIIlllIIIlIII);
            if (!SoundStore.get().isMusicPlaying()) {
                if (!Music.currentMusic.positioning) {
                    Music llllllllllllllllIIIlIIlllIIIlIlI = currentMusic;
                    currentMusic = null;
                    llllllllllllllllIIIlIIlllIIIlIlI.fireMusicEnded();
                }
            } else {
                currentMusic.update(llllllllllllllllIIIlIIlllIIIlIII);
            }
        }
    }

    public void addListener(MusicListener llllllllllllllllIIIlIIllIlIIlllI) {
        Music llllllllllllllllIIIlIIllIlIIllll;
        llllllllllllllllIIIlIIllIlIIllll.listeners.add(llllllllllllllllIIIlIIllIlIIlllI);
    }

    public void play(float llllllllllllllllIIIlIIllIIlIlIll, float llllllllllllllllIIIlIIllIIlIllIl) {
        Music llllllllllllllllIIIlIIllIIlIllll;
        llllllllllllllllIIIlIIllIIlIllll.startMusic(llllllllllllllllIIIlIIllIIlIlIll, llllllllllllllllIIIlIIllIIlIllIl, false);
    }

    public void resume() {
        llllllllllllllllIIIlIIllIIIIllII.playing = true;
        AudioImpl.restartMusic();
    }

    public void loop(float llllllllllllllllIIIlIIllIIlIIIlI, float llllllllllllllllIIIlIIllIIlIIlII) {
        Music llllllllllllllllIIIlIIllIIlIIllI;
        llllllllllllllllIIIlIIllIIlIIllI.startMusic(llllllllllllllllIIIlIIllIIlIIIlI, llllllllllllllllIIIlIIllIIlIIlII, true);
    }

    public void play() {
        Music llllllllllllllllIIIlIIllIIllIIll;
        llllllllllllllllIIIlIIllIIllIIll.play(1.0f, 1.0f);
    }

    public Music(URL llllllllllllllllIIIlIIllIllIIIll, boolean llllllllllllllllIIIlIIllIllIIllI) throws SlickException {
        block6: {
            Music llllllllllllllllIIIlIIllIllIIlII;
            llllllllllllllllIIIlIIllIllIIlII.listeners = new ArrayList();
            llllllllllllllllIIIlIIllIllIIlII.volume = 1.0f;
            llllllllllllllllIIIlIIllIllIIlII.requiredPosition = -1.0f;
            SoundStore.get().init();
            String llllllllllllllllIIIlIIllIllIIlIl = llllllllllllllllIIIlIIllIllIIIll.getFile();
            try {
                if (llllllllllllllllIIIlIIllIllIIlIl.toLowerCase().endsWith(".ogg")) {
                    llllllllllllllllIIIlIIllIllIIlII.sound = llllllllllllllllIIIlIIllIllIIllI ? SoundStore.get().getOggStream(llllllllllllllllIIIlIIllIllIIIll) : SoundStore.get().getOgg(llllllllllllllllIIIlIIllIllIIIll.openStream());
                    break block6;
                }
                if (llllllllllllllllIIIlIIllIllIIlIl.toLowerCase().endsWith(".wav")) {
                    llllllllllllllllIIIlIIllIllIIlII.sound = SoundStore.get().getWAV(llllllllllllllllIIIlIIllIllIIIll.openStream());
                    break block6;
                }
                if (llllllllllllllllIIIlIIllIllIIlIl.toLowerCase().endsWith(".xm") || llllllllllllllllIIIlIIllIllIIlIl.toLowerCase().endsWith(".mod")) {
                    llllllllllllllllIIIlIIllIllIIlII.sound = SoundStore.get().getMOD(llllllllllllllllIIIlIIllIllIIIll.openStream());
                    break block6;
                }
                if (llllllllllllllllIIIlIIllIllIIlIl.toLowerCase().endsWith(".aif") || llllllllllllllllIIIlIIllIllIIlIl.toLowerCase().endsWith(".aiff")) {
                    llllllllllllllllIIIlIIllIllIIlII.sound = SoundStore.get().getAIF(llllllllllllllllIIIlIIllIllIIIll.openStream());
                    break block6;
                }
                throw new SlickException("Only .xm, .mod, .ogg, and .aif/f are currently supported.");
            }
            catch (Exception llllllllllllllllIIIlIIllIllIlIIl) {
                Log.error(llllllllllllllllIIIlIIllIllIlIIl);
                throw new SlickException(String.valueOf(new StringBuilder().append("Failed to load sound: ").append(llllllllllllllllIIIlIIllIllIIIll)));
            }
        }
    }

    public void fade(int llllllllllllllllIIIlIIlIllllIllI, float llllllllllllllllIIIlIIlIllllIlIl, boolean llllllllllllllllIIIlIIlIlllllIII) {
        Music llllllllllllllllIIIlIIlIllllIlll;
        llllllllllllllllIIIlIIlIllllIlll.stopAfterFade = llllllllllllllllIIIlIIlIlllllIII;
        llllllllllllllllIIIlIIlIllllIlll.fadeStartGain = llllllllllllllllIIIlIIlIllllIlll.volume;
        llllllllllllllllIIIlIIlIllllIlll.fadeEndGain = llllllllllllllllIIIlIIlIllllIlIl;
        llllllllllllllllIIIlIIlIllllIlll.fadeDuration = llllllllllllllllIIIlIIlIllllIllI;
        llllllllllllllllIIIlIIlIllllIlll.fadeTime = llllllllllllllllIIIlIIlIllllIllI;
    }

    private void startMusic(float llllllllllllllllIIIlIIllIIIllIll, float llllllllllllllllIIIlIIllIIIllIlI, boolean llllllllllllllllIIIlIIllIIIllIIl) {
        Music llllllllllllllllIIIlIIllIIIllIII;
        if (currentMusic != null) {
            currentMusic.stop();
            currentMusic.fireMusicSwapped(llllllllllllllllIIIlIIllIIIllIII);
        }
        currentMusic = llllllllllllllllIIIlIIllIIIllIII;
        if (llllllllllllllllIIIlIIllIIIllIlI < 0.0f) {
            llllllllllllllllIIIlIIllIIIllIlI = 0.0f;
        }
        if (llllllllllllllllIIIlIIllIIIllIlI > 1.0f) {
            llllllllllllllllIIIlIIllIIIllIlI = 1.0f;
        }
        llllllllllllllllIIIlIIllIIIllIII.sound.playAsMusic(llllllllllllllllIIIlIIllIIIllIll, llllllllllllllllIIIlIIllIIIllIlI, llllllllllllllllIIIlIIllIIIllIIl);
        llllllllllllllllIIIlIIllIIIllIII.playing = true;
        llllllllllllllllIIIlIIllIIIllIII.setVolume(llllllllllllllllIIIlIIllIIIllIlI);
        if (llllllllllllllllIIIlIIllIIIllIII.requiredPosition != -1.0f) {
            llllllllllllllllIIIlIIllIIIllIII.setPosition(llllllllllllllllIIIlIIllIIIllIII.requiredPosition);
        }
    }

    public Music(String llllllllllllllllIIIlIIlllIIIIIll) throws SlickException {
        llllllllllllllllIIIlIIlllIIIIlII(llllllllllllllllIIIlIIlllIIIIIll, false);
        Music llllllllllllllllIIIlIIlllIIIIlII;
    }

    public void stop() {
        Music llllllllllllllllIIIlIIllIIIIllll;
        llllllllllllllllIIIlIIllIIIIllll.playing = false;
        llllllllllllllllIIIlIIllIIIIllll.sound.stop();
    }

    public float getVolume() {
        Music llllllllllllllllIIIlIIllIIIIIIII;
        return llllllllllllllllIIIlIIllIIIIIIII.volume;
    }
}

