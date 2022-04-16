/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.Sys
 *  org.lwjgl.openal.AL
 *  org.lwjgl.openal.AL10
 *  org.lwjgl.openal.OpenALException
 */
package org.newdawn.slick.openal;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import org.lwjgl.BufferUtils;
import org.lwjgl.Sys;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.OpenALException;
import org.newdawn.slick.openal.AiffData;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioImpl;
import org.newdawn.slick.openal.DeferredSound;
import org.newdawn.slick.openal.MODSound;
import org.newdawn.slick.openal.NullAudio;
import org.newdawn.slick.openal.OggData;
import org.newdawn.slick.openal.OggDecoder;
import org.newdawn.slick.openal.OpenALStreamPlayer;
import org.newdawn.slick.openal.StreamSound;
import org.newdawn.slick.openal.WaveData;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

public class SoundStore {
    private /* synthetic */ boolean music;
    private /* synthetic */ FloatBuffer sourcePos;
    private /* synthetic */ boolean deferred;
    private /* synthetic */ OpenALStreamPlayer stream;
    private /* synthetic */ float musicVolume;
    private /* synthetic */ boolean paused;
    private static /* synthetic */ SoundStore store;
    private /* synthetic */ boolean soundWorks;
    private /* synthetic */ int currentMusic;
    private /* synthetic */ boolean inited;
    private /* synthetic */ float lastCurrentMusicVolume;
    private /* synthetic */ FloatBuffer sourceVel;
    private /* synthetic */ boolean sounds;
    private /* synthetic */ MODSound mod;
    private /* synthetic */ IntBuffer sources;
    private /* synthetic */ int maxSources;
    private /* synthetic */ HashMap loaded;
    private /* synthetic */ float soundVolume;
    private /* synthetic */ int nextSource;
    private /* synthetic */ int sourceCount;

    public Audio getMOD(InputStream lIIlIIlIIll) throws IOException {
        SoundStore lIIlIIlIlII;
        return lIIlIIlIlII.getMOD(lIIlIIlIIll.toString(), lIIlIIlIIll);
    }

    public void init() {
        SoundStore lIlIIlllIlI;
        if (lIlIIlllIlI.inited) {
            return;
        }
        Log.info("Initialising sounds..");
        lIlIIlllIlI.inited = true;
        AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                1 lIlllllIllIlIll;
                try {
                    AL.create();
                    lIlllllIllIlIll.SoundStore.this.soundWorks = true;
                    lIlllllIllIlIll.SoundStore.this.sounds = true;
                    lIlllllIllIlIll.SoundStore.this.music = true;
                    Log.info("- Sound works");
                }
                catch (Exception lIlllllIllIllIl) {
                    Log.error("Sound initialisation failure.");
                    Log.error(lIlllllIllIllIl);
                    lIlllllIllIlIll.SoundStore.this.soundWorks = false;
                    lIlllllIllIlIll.SoundStore.this.sounds = false;
                    lIlllllIllIlIll.SoundStore.this.music = false;
                }
                return null;
            }
            {
                1 lIlllllIlllIIll;
            }
        });
        if (lIlIIlllIlI.soundWorks) {
            lIlIIlllIlI.sourceCount = 0;
            lIlIIlllIlI.sources = BufferUtils.createIntBuffer((int)lIlIIlllIlI.maxSources);
            while (AL10.alGetError() == 0) {
                IntBuffer lIlIlIIIIII = BufferUtils.createIntBuffer((int)1);
                try {
                    AL10.alGenSources((IntBuffer)lIlIlIIIIII);
                    if (AL10.alGetError() != 0) continue;
                    ++lIlIIlllIlI.sourceCount;
                    lIlIIlllIlI.sources.put(lIlIlIIIIII.get(0));
                    if (lIlIIlllIlI.sourceCount <= lIlIIlllIlI.maxSources - 1) continue;
                }
                catch (OpenALException lIlIlIIIIlI) {}
                break;
            }
            Log.info(String.valueOf(new StringBuilder().append("- ").append(lIlIIlllIlI.sourceCount).append(" OpenAL source available")));
            if (AL10.alGetError() != 0) {
                lIlIIlllIlI.sounds = false;
                lIlIIlllIlI.music = false;
                lIlIIlllIlI.soundWorks = false;
                Log.error("- AL init failed");
            } else {
                FloatBuffer lIlIIlllllI = BufferUtils.createFloatBuffer((int)6).put(new float[]{0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f});
                FloatBuffer lIlIIllllII = BufferUtils.createFloatBuffer((int)3).put(new float[]{0.0f, 0.0f, 0.0f});
                FloatBuffer lIlIIlllIll = BufferUtils.createFloatBuffer((int)3).put(new float[]{0.0f, 0.0f, 0.0f});
                lIlIIlllIll.flip();
                lIlIIllllII.flip();
                lIlIIlllllI.flip();
                AL10.alListener((int)4100, (FloatBuffer)lIlIIlllIll);
                AL10.alListener((int)4102, (FloatBuffer)lIlIIllllII);
                AL10.alListener((int)4111, (FloatBuffer)lIlIIlllllI);
                Log.info("- Sounds source generated");
            }
        }
    }

    void playAsMusic(int lIIlIlllIIl, float lIIlIllIIll, float lIIlIllIlll, boolean lIIlIllIIlI) {
        SoundStore lIIlIllIlIl;
        lIIlIllIlIl.paused = false;
        lIIlIllIlIl.setMOD(null);
        if (lIIlIllIlIl.soundWorks) {
            if (lIIlIllIlIl.currentMusic != -1) {
                AL10.alSourceStop((int)lIIlIllIlIl.sources.get(0));
            }
            lIIlIllIlIl.getMusicSource();
            AL10.alSourcei((int)lIIlIllIlIl.sources.get(0), (int)4105, (int)lIIlIlllIIl);
            AL10.alSourcef((int)lIIlIllIlIl.sources.get(0), (int)4099, (float)lIIlIllIIll);
            AL10.alSourcei((int)lIIlIllIlIl.sources.get(0), (int)4103, (int)(lIIlIllIIlI ? 1 : 0));
            lIIlIllIlIl.currentMusic = lIIlIllIlIl.sources.get(0);
            if (!lIIlIllIlIl.music) {
                lIIlIllIlIl.pauseLoop();
            } else {
                AL10.alSourcePlay((int)lIIlIllIlIl.sources.get(0));
            }
        }
    }

    public void setCurrentMusicVolume(float lIlIllllIll) {
        SoundStore lIlIlllllII;
        if (lIlIllllIll < 0.0f) {
            lIlIllllIll = 0.0f;
        }
        if (lIlIllllIll > 1.0f) {
            lIlIllllIll = 1.0f;
        }
        if (lIlIlllllII.soundWorks) {
            lIlIlllllII.lastCurrentMusicVolume = lIlIllllIll;
            AL10.alSourcef((int)lIlIlllllII.sources.get(0), (int)4106, (float)(lIlIlllllII.lastCurrentMusicVolume * lIlIlllllII.musicVolume));
        }
    }

    public Audio getMOD(String lIIlIIIlIIl, InputStream lIIlIIIlIII) throws IOException {
        SoundStore lIIlIIIllIl;
        if (!lIIlIIIllIl.soundWorks) {
            return new NullAudio();
        }
        if (!lIIlIIIllIl.inited) {
            throw new RuntimeException("Can't load sounds until SoundStore is init(). Use the container init() method.");
        }
        if (lIIlIIIllIl.deferred) {
            return new DeferredSound(lIIlIIIlIIl, lIIlIIIlIII, 3);
        }
        return new MODSound(lIIlIIIllIl, lIIlIIIlIII);
    }

    public Audio getAIF(InputStream lIIIllllllI) throws IOException {
        SoundStore lIIIlllllIl;
        return lIIIlllllIl.getAIF(lIIIllllllI.toString(), lIIIllllllI);
    }

    public Audio getAIF(String lIIlIIIIIlI) throws IOException {
        SoundStore lIIlIIIIIll;
        return lIIlIIIIIll.getAIF(lIIlIIIIIlI, ResourceLoader.getResourceAsStream(lIIlIIIIIlI));
    }

    void setStream(OpenALStreamPlayer lIIIIIIlIll) {
        SoundStore lIIIIIIllII;
        if (!lIIIIIIllII.soundWorks) {
            return;
        }
        lIIIIIIllII.currentMusic = lIIIIIIllII.sources.get(0);
        lIIIIIIllII.stream = lIIIIIIlIll;
        if (lIIIIIIlIll != null) {
            lIIIIIIllII.mod = null;
        }
        lIIIIIIllII.paused = false;
    }

    static {
        store = new SoundStore();
    }

    public Audio getOgg(String lIIIIIlllII, InputStream lIIIIIlllll) throws IOException {
        SoundStore lIIIIlIIIIl;
        if (!lIIIIlIIIIl.soundWorks) {
            return new NullAudio();
        }
        if (!lIIIIlIIIIl.inited) {
            throw new RuntimeException("Can't load sounds until SoundStore is init(). Use the container init() method.");
        }
        if (lIIIIlIIIIl.deferred) {
            return new DeferredSound(lIIIIIlllII, lIIIIIlllll, 1);
        }
        int lIIIIIllllI = -1;
        if (lIIIIlIIIIl.loaded.get(lIIIIIlllII) != null) {
            lIIIIIllllI = (Integer)lIIIIlIIIIl.loaded.get(lIIIIIlllII);
        } else {
            try {
                IntBuffer lIIIIlIIlIl = BufferUtils.createIntBuffer((int)1);
                OggDecoder lIIIIlIIlII = new OggDecoder();
                OggData lIIIIlIIIll = lIIIIlIIlII.getData(lIIIIIlllll);
                AL10.alGenBuffers((IntBuffer)lIIIIlIIlIl);
                AL10.alBufferData((int)lIIIIlIIlIl.get(0), (int)(lIIIIlIIIll.channels > 1 ? 4355 : 4353), (ByteBuffer)lIIIIlIIIll.data, (int)lIIIIlIIIll.rate);
                lIIIIlIIIIl.loaded.put(lIIIIIlllII, new Integer(lIIIIlIIlIl.get(0)));
                lIIIIIllllI = lIIIIlIIlIl.get(0);
            }
            catch (Exception lIIIIlIIIlI) {
                Log.error(lIIIIlIIIlI);
                Sys.alert((String)"Error", (String)String.valueOf(new StringBuilder().append("Failed to load: ").append(lIIIIIlllII).append(" - ").append(lIIIIlIIIlI.getMessage())));
                throw new IOException(String.valueOf(new StringBuilder().append("Unable to load: ").append(lIIIIIlllII)));
            }
        }
        if (lIIIIIllllI == -1) {
            throw new IOException(String.valueOf(new StringBuilder().append("Unable to load: ").append(lIIIIIlllII)));
        }
        return new AudioImpl(lIIIIlIIIIl, lIIIIIllllI);
    }

    public Audio getOggStream(URL lIIIIlllIll) throws IOException {
        SoundStore lIIIIllllII;
        if (!lIIIIllllII.soundWorks) {
            return new NullAudio();
        }
        lIIIIllllII.setMOD(null);
        lIIIIllllII.setStream(null);
        if (lIIIIllllII.currentMusic != -1) {
            AL10.alSourceStop((int)lIIIIllllII.sources.get(0));
        }
        lIIIIllllII.getMusicSource();
        lIIIIllllII.currentMusic = lIIIIllllII.sources.get(0);
        return new StreamSound(new OpenALStreamPlayer(lIIIIllllII.currentMusic, lIIIIlllIll));
    }

    public void setMusicVolume(float lIllIIIIIlI) {
        SoundStore lIllIIIIIll;
        if (lIllIIIIIlI < 0.0f) {
            lIllIIIIIlI = 0.0f;
        }
        if (lIllIIIIIlI > 1.0f) {
            lIllIIIIIlI = 1.0f;
        }
        lIllIIIIIll.musicVolume = lIllIIIIIlI;
        if (lIllIIIIIll.soundWorks) {
            AL10.alSourcef((int)lIllIIIIIll.sources.get(0), (int)4106, (float)(lIllIIIIIll.lastCurrentMusicVolume * lIllIIIIIll.musicVolume));
        }
    }

    public boolean isMusicOn() {
        SoundStore lIllIIIlIII;
        return lIllIIIlIII.music;
    }

    public boolean soundWorks() {
        SoundStore lIlIlllIIII;
        return lIlIlllIIII.soundWorks;
    }

    boolean isPlaying(OpenALStreamPlayer lIIlIIlllIl) {
        SoundStore lIIlIlIIIII;
        return lIIlIlIIIII.stream == lIIlIIlllIl;
    }

    public void poll(int lIIIIIIIlIl) {
        SoundStore lIIIIIIIllI;
        if (!lIIIIIIIllI.soundWorks) {
            return;
        }
        if (lIIIIIIIllI.paused) {
            return;
        }
        if (lIIIIIIIllI.music) {
            if (lIIIIIIIllI.mod != null) {
                try {
                    lIIIIIIIllI.mod.poll();
                }
                catch (OpenALException lIIIIIIlIII) {
                    Log.error("Error with OpenGL MOD Player on this this platform");
                    Log.error(lIIIIIIlIII);
                    lIIIIIIIllI.mod = null;
                }
            }
            if (lIIIIIIIllI.stream != null) {
                try {
                    lIIIIIIIllI.stream.update();
                }
                catch (OpenALException lIIIIIIIlll) {
                    Log.error("Error with OpenGL Streaming Player on this this platform");
                    Log.error(lIIIIIIIlll);
                    lIIIIIIIllI.mod = null;
                }
            }
        }
    }

    public void pauseLoop() {
        SoundStore lIIlIlIIllI;
        if (lIIlIlIIllI.soundWorks && lIIlIlIIllI.currentMusic != -1) {
            lIIlIlIIllI.paused = true;
            AL10.alSourcePause((int)lIIlIlIIllI.currentMusic);
        }
    }

    public Audio getWAV(String lIIIlIlIIII, InputStream lIIIlIIllll) throws IOException {
        SoundStore lIIIlIlIIIl;
        if (!lIIIlIlIIIl.soundWorks) {
            return new NullAudio();
        }
        if (!lIIIlIlIIIl.inited) {
            throw new RuntimeException("Can't load sounds until SoundStore is init(). Use the container init() method.");
        }
        if (lIIIlIlIIIl.deferred) {
            return new DeferredSound(lIIIlIlIIII, lIIIlIIllll, 2);
        }
        int lIIIlIIlllI = -1;
        if (lIIIlIlIIIl.loaded.get(lIIIlIlIIII) != null) {
            lIIIlIIlllI = (Integer)lIIIlIlIIIl.loaded.get(lIIIlIlIIII);
        } else {
            try {
                IntBuffer lIIIlIlIlIl = BufferUtils.createIntBuffer((int)1);
                WaveData lIIIlIlIlII = WaveData.create(lIIIlIIllll);
                AL10.alGenBuffers((IntBuffer)lIIIlIlIlIl);
                AL10.alBufferData((int)lIIIlIlIlIl.get(0), (int)lIIIlIlIlII.format, (ByteBuffer)lIIIlIlIlII.data, (int)lIIIlIlIlII.samplerate);
                lIIIlIlIIIl.loaded.put(lIIIlIlIIII, new Integer(lIIIlIlIlIl.get(0)));
                lIIIlIIlllI = lIIIlIlIlIl.get(0);
            }
            catch (Exception lIIIlIlIIlI) {
                Log.error(lIIIlIlIIlI);
                IOException lIIIlIlIIll = new IOException(String.valueOf(new StringBuilder().append("Failed to load: ").append(lIIIlIlIIII)));
                lIIIlIlIIll.initCause(lIIIlIlIIlI);
                throw lIIIlIlIIll;
            }
        }
        if (lIIIlIIlllI == -1) {
            throw new IOException(String.valueOf(new StringBuilder().append("Unable to load: ").append(lIIIlIlIIII)));
        }
        return new AudioImpl(lIIIlIlIIIl, lIIIlIIlllI);
    }

    public Audio getOgg(InputStream lIIIIlIllll) throws IOException {
        SoundStore lIIIIllIIII;
        return lIIIIllIIII.getOgg(lIIIIlIllll.toString(), lIIIIlIllll);
    }

    public Audio getWAV(String lIIIllIIIlI) throws IOException {
        SoundStore lIIIllIIIll;
        return lIIIllIIIll.getWAV(lIIIllIIIlI, ResourceLoader.getResourceAsStream(lIIIllIIIlI));
    }

    private int getMusicSource() {
        SoundStore lIIlIllIIII;
        return lIIlIllIIII.sources.get(0);
    }

    public float getSoundVolume() {
        SoundStore lIlIllIlIlI;
        return lIlIllIlIlI.soundVolume;
    }

    public void setMaxSources(int lIlIlIlIIlI) {
        lIlIlIlIlIl.maxSources = lIlIlIlIIlI;
    }

    public boolean isMusicPlaying() {
        SoundStore lIIIIIIIIII;
        if (!lIIIIIIIIII.soundWorks) {
            return false;
        }
        int llllllllll = AL10.alGetSourcei((int)lIIIIIIIIII.sources.get(0), (int)4112);
        return llllllllll == 4114 || llllllllll == 4115;
    }

    private int findFreeSource() {
        SoundStore lIIllIlllIl;
        for (int lIIllIllllI = 1; lIIllIllllI < lIIllIlllIl.sourceCount - 1; ++lIIllIllllI) {
            int lIIlllIIIII = AL10.alGetSourcei((int)lIIllIlllIl.sources.get(lIIllIllllI), (int)4112);
            if (lIIlllIIIII == 4114 || lIIlllIIIII == 4115) continue;
            return lIIllIllllI;
        }
        return -1;
    }

    int playAsSoundAt(int lIlIIIIIlll, float lIlIIIIIllI, float lIlIIIIllIl, boolean lIlIIIIIlII, float lIlIIIIIIll, float lIlIIIIIIlI, float lIlIIIIIIIl) {
        SoundStore lIlIIIlIIII;
        if ((lIlIIIIllIl *= lIlIIIlIIII.soundVolume) == 0.0f) {
            lIlIIIIllIl = 0.001f;
        }
        if (lIlIIIlIIII.soundWorks && lIlIIIlIIII.sounds) {
            int lIlIIIlIIIl = lIlIIIlIIII.findFreeSource();
            if (lIlIIIlIIIl == -1) {
                return -1;
            }
            AL10.alSourceStop((int)lIlIIIlIIII.sources.get(lIlIIIlIIIl));
            AL10.alSourcei((int)lIlIIIlIIII.sources.get(lIlIIIlIIIl), (int)4105, (int)lIlIIIIIlll);
            AL10.alSourcef((int)lIlIIIlIIII.sources.get(lIlIIIlIIIl), (int)4099, (float)lIlIIIIIllI);
            AL10.alSourcef((int)lIlIIIlIIII.sources.get(lIlIIIlIIIl), (int)4106, (float)lIlIIIIllIl);
            AL10.alSourcei((int)lIlIIIlIIII.sources.get(lIlIIIlIIIl), (int)4103, (int)(lIlIIIIIlII ? 1 : 0));
            lIlIIIlIIII.sourcePos.clear();
            lIlIIIlIIII.sourceVel.clear();
            lIlIIIlIIII.sourceVel.put(new float[]{0.0f, 0.0f, 0.0f});
            lIlIIIlIIII.sourcePos.put(new float[]{lIlIIIIIIll, lIlIIIIIIlI, lIlIIIIIIIl});
            lIlIIIlIIII.sourcePos.flip();
            lIlIIIlIIII.sourceVel.flip();
            AL10.alSource((int)lIlIIIlIIII.sources.get(lIlIIIlIIIl), (int)4100, (FloatBuffer)lIlIIIlIIII.sourcePos);
            AL10.alSource((int)lIlIIIlIIII.sources.get(lIlIIIlIIIl), (int)4102, (FloatBuffer)lIlIIIlIIII.sourceVel);
            AL10.alSourcePlay((int)lIlIIIlIIII.sources.get(lIlIIIlIIIl));
            return lIlIIIlIIIl;
        }
        return -1;
    }

    public boolean isDeferredLoading() {
        SoundStore lIllIIlIIIl;
        return lIllIIlIIIl.deferred;
    }

    public Audio getOggStream(String lIIIlIIIIIl) throws IOException {
        SoundStore lIIIlIIIIII;
        if (!lIIIlIIIIII.soundWorks) {
            return new NullAudio();
        }
        lIIIlIIIIII.setMOD(null);
        lIIIlIIIIII.setStream(null);
        if (lIIIlIIIIII.currentMusic != -1) {
            AL10.alSourceStop((int)lIIIlIIIIII.sources.get(0));
        }
        lIIIlIIIIII.getMusicSource();
        lIIIlIIIIII.currentMusic = lIIIlIIIIII.sources.get(0);
        return new StreamSound(new OpenALStreamPlayer(lIIIlIIIIII.currentMusic, lIIIlIIIIIl));
    }

    public void setDeferredLoading(boolean lIllIIlIllI) {
        lIllIIlIlll.deferred = lIllIIlIllI;
    }

    public void restartLoop() {
        SoundStore lIIlIlIIIll;
        if (lIIlIlIIIll.music && lIIlIlIIIll.soundWorks && lIIlIlIIIll.currentMusic != -1) {
            lIIlIlIIIll.paused = false;
            AL10.alSourcePlay((int)lIIlIlIIIll.currentMusic);
        }
    }

    public boolean soundsOn() {
        SoundStore lIlIlIllIII;
        return lIlIlIllIII.sounds;
    }

    public int getSourceCount() {
        SoundStore llllllIllI;
        return llllllIllI.sourceCount;
    }

    public int getSource(int lIlIllIIIIl) {
        SoundStore lIlIllIIIlI;
        if (!lIlIllIIIlI.soundWorks) {
            return -1;
        }
        if (lIlIllIIIIl < 0) {
            return -1;
        }
        return lIlIllIIIlI.sources.get(lIlIllIIIIl);
    }

    public Audio getWAV(InputStream lIIIlIlllII) throws IOException {
        SoundStore lIIIlIlllll;
        return lIIIlIlllll.getWAV(lIIIlIlllII.toString(), lIIIlIlllII);
    }

    public void setMusicPitch(float lIIlIlIlIIl) {
        SoundStore lIIlIlIllII;
        if (lIIlIlIllII.soundWorks) {
            AL10.alSourcef((int)lIIlIlIllII.sources.get(0), (int)4099, (float)lIIlIlIlIIl);
        }
    }

    public void clear() {
        store = new SoundStore();
    }

    public Audio getOgg(String lIIIIllIlIl) throws IOException {
        SoundStore lIIIIllIllI;
        return lIIIIllIllI.getOgg(lIIIIllIlIl, ResourceLoader.getResourceAsStream(lIIIIllIlIl));
    }

    void stopSource(int lIlIIlIllII) {
        SoundStore lIlIIlIllIl;
        AL10.alSourceStop((int)lIlIIlIllIl.sources.get(lIlIIlIllII));
    }

    public void setSoundVolume(float lIlIlllIlIl) {
        if (lIlIlllIlIl < 0.0f) {
            lIlIlllIlIl = 0.0f;
        }
        lIlIlllIlII.soundVolume = lIlIlllIlIl;
    }

    public Audio getMOD(String lIIlIIllIIl) throws IOException {
        SoundStore lIIlIIllIII;
        return lIIlIIllIII.getMOD(lIIlIIllIIl, ResourceLoader.getResourceAsStream(lIIlIIllIIl));
    }

    public void setMusicOn(boolean lIllIIIllIl) {
        SoundStore lIllIIIllII;
        if (lIllIIIllII.soundWorks) {
            lIllIIIllII.music = lIllIIIllIl;
            if (lIllIIIllIl) {
                lIllIIIllII.restartLoop();
                lIllIIIllII.setMusicVolume(lIllIIIllII.musicVolume);
            } else {
                lIllIIIllII.pauseLoop();
            }
        }
    }

    public float getCurrentMusicVolume() {
        SoundStore lIlIlllllll;
        return lIlIlllllll.lastCurrentMusicVolume;
    }

    public Audio getAIF(String lIIIllIllII, InputStream lIIIllIllll) throws IOException {
        SoundStore lIIIllIllIl;
        lIIIllIllll = new BufferedInputStream(lIIIllIllll);
        if (!lIIIllIllIl.soundWorks) {
            return new NullAudio();
        }
        if (!lIIIllIllIl.inited) {
            throw new RuntimeException("Can't load sounds until SoundStore is init(). Use the container init() method.");
        }
        if (lIIIllIllIl.deferred) {
            return new DeferredSound(lIIIllIllII, lIIIllIllll, 4);
        }
        int lIIIllIlllI = -1;
        if (lIIIllIllIl.loaded.get(lIIIllIllII) != null) {
            lIIIllIlllI = (Integer)lIIIllIllIl.loaded.get(lIIIllIllII);
        } else {
            try {
                IntBuffer lIIIlllIlIl = BufferUtils.createIntBuffer((int)1);
                AiffData lIIIlllIlII = AiffData.create(lIIIllIllll);
                AL10.alGenBuffers((IntBuffer)lIIIlllIlIl);
                AL10.alBufferData((int)lIIIlllIlIl.get(0), (int)lIIIlllIlII.format, (ByteBuffer)lIIIlllIlII.data, (int)lIIIlllIlII.samplerate);
                lIIIllIllIl.loaded.put(lIIIllIllII, new Integer(lIIIlllIlIl.get(0)));
                lIIIllIlllI = lIIIlllIlIl.get(0);
            }
            catch (Exception lIIIlllIIlI) {
                Log.error(lIIIlllIIlI);
                IOException lIIIlllIIll = new IOException(String.valueOf(new StringBuilder().append("Failed to load: ").append(lIIIllIllII)));
                lIIIlllIIll.initCause(lIIIlllIIlI);
                throw lIIIlllIIll;
            }
        }
        if (lIIIllIlllI == -1) {
            throw new IOException(String.valueOf(new StringBuilder().append("Unable to load: ").append(lIIIllIllII)));
        }
        return new AudioImpl(lIIIllIllIl, lIIIllIlllI);
    }

    public void stopSoundEffect(int lllllllIIl) {
        AL10.alSourceStop((int)lllllllIIl);
    }

    int playAsSound(int lIlIIIllllI, float lIlIIlIIIlI, float lIlIIlIIIIl, boolean lIlIIlIIIII) {
        SoundStore lIlIIlIIlII;
        return lIlIIlIIlII.playAsSoundAt(lIlIIIllllI, lIlIIlIIIlI, lIlIIlIIIIl, lIlIIlIIIII, 0.0f, 0.0f, 0.0f);
    }

    public void setSoundsOn(boolean lIlIlIlllIl) {
        SoundStore lIlIlIllllI;
        if (lIlIlIllllI.soundWorks) {
            lIlIlIllllI.sounds = lIlIlIlllIl;
        }
    }

    public float getMusicVolume() {
        SoundStore lIlIllIIlll;
        return lIlIllIIlll.musicVolume;
    }

    public boolean musicOn() {
        SoundStore lIlIllIllIl;
        return lIlIllIllIl.music;
    }

    boolean isPlaying(int lIIlllllIll) {
        SoundStore lIIlllllIIl;
        int lIIlllllIlI = AL10.alGetSourcei((int)lIIlllllIIl.sources.get(lIIlllllIll), (int)4112);
        return lIIlllllIlI == 4114;
    }

    public void disable() {
        lIllIIllIlI.inited = true;
    }

    private SoundStore() {
        SoundStore lIllIIlllll;
        lIllIIlllll.loaded = new HashMap();
        lIllIIlllll.currentMusic = -1;
        lIllIIlllll.inited = false;
        lIllIIlllll.musicVolume = 1.0f;
        lIllIIlllll.soundVolume = 1.0f;
        lIllIIlllll.lastCurrentMusicVolume = 1.0f;
        lIllIIlllll.sourceVel = BufferUtils.createFloatBuffer((int)3).put(new float[]{0.0f, 0.0f, 0.0f});
        lIllIIlllll.sourcePos = BufferUtils.createFloatBuffer((int)3);
        lIllIIlllll.maxSources = 64;
    }

    public static SoundStore get() {
        return store;
    }

    void setMOD(MODSound lIIIIIlIIll) {
        SoundStore lIIIIIlIIlI;
        if (!lIIIIIlIIlI.soundWorks) {
            return;
        }
        lIIIIIlIIlI.currentMusic = lIIIIIlIIlI.sources.get(0);
        lIIIIIlIIlI.stopSource(0);
        lIIIIIlIIlI.mod = lIIIIIlIIll;
        if (lIIIIIlIIll != null) {
            lIIIIIlIIlI.stream = null;
        }
        lIIIIIlIIlI.paused = false;
    }
}

