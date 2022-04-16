/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.openal.AL
 *  org.lwjgl.openal.AL10
 */
package ibxm;

import ibxm.FastTracker2;
import ibxm.IBXM;
import ibxm.Module;
import ibxm.ProTracker;
import ibxm.ScreamTracker3;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;

public class OpenALMODPlayer {
    private /* synthetic */ boolean done;
    private /* synthetic */ int songDuration;
    private /* synthetic */ IBXM ibxm;
    private static final /* synthetic */ int sectionSize;
    private /* synthetic */ boolean soundWorks;
    private /* synthetic */ int source;
    private /* synthetic */ IntBuffer bufferNames;
    private /* synthetic */ Module module;
    private /* synthetic */ IntBuffer unqueued;
    private /* synthetic */ ByteBuffer bufferData;
    private /* synthetic */ boolean loop;
    private /* synthetic */ byte[] data;
    private /* synthetic */ int remainingBufferCount;

    public static Module loadModule(InputStream lllllllllllllllIlllIIIllIIIlIIlI) throws IOException {
        DataInputStream lllllllllllllllIlllIIIllIIIlIlII = new DataInputStream(lllllllllllllllIlllIIIllIIIlIIlI);
        Module lllllllllllllllIlllIIIllIIIlIlIl = null;
        byte[] lllllllllllllllIlllIIIllIIIlIIll = new byte[60];
        lllllllllllllllIlllIIIllIIIlIlII.readFully(lllllllllllllllIlllIIIllIIIlIIll);
        if (FastTracker2.is_xm(lllllllllllllllIlllIIIllIIIlIIll)) {
            lllllllllllllllIlllIIIllIIIlIlIl = FastTracker2.load_xm(lllllllllllllllIlllIIIllIIIlIIll, lllllllllllllllIlllIIIllIIIlIlII);
        } else {
            byte[] lllllllllllllllIlllIIIllIIIllIII = new byte[96];
            System.arraycopy(lllllllllllllllIlllIIIllIIIlIIll, 0, lllllllllllllllIlllIIIllIIIllIII, 0, 60);
            lllllllllllllllIlllIIIllIIIlIlII.readFully(lllllllllllllllIlllIIIllIIIllIII, 60, 36);
            if (ScreamTracker3.is_s3m(lllllllllllllllIlllIIIllIIIllIII)) {
                lllllllllllllllIlllIIIllIIIlIlIl = ScreamTracker3.load_s3m(lllllllllllllllIlllIIIllIIIllIII, lllllllllllllllIlllIIIllIIIlIlII);
            } else {
                byte[] lllllllllllllllIlllIIIllIIIlIlll = new byte[1084];
                System.arraycopy(lllllllllllllllIlllIIIllIIIllIII, 0, lllllllllllllllIlllIIIllIIIlIlll, 0, 96);
                lllllllllllllllIlllIIIllIIIlIlII.readFully(lllllllllllllllIlllIIIllIIIlIlll, 96, 988);
                lllllllllllllllIlllIIIllIIIlIlIl = ProTracker.load_mod(lllllllllllllllIlllIIIllIIIlIlll, lllllllllllllllIlllIIIllIIIlIlII);
            }
        }
        lllllllllllllllIlllIIIllIIIlIlII.close();
        return lllllllllllllllIlllIIIllIIIlIlIl;
    }

    public OpenALMODPlayer() {
        OpenALMODPlayer lllllllllllllllIlllIIIllIllIIIII;
        lllllllllllllllIlllIIIllIllIIIII.data = new byte[163840];
        lllllllllllllllIlllIIIllIllIIIII.bufferData = BufferUtils.createByteBuffer((int)163840);
        lllllllllllllllIlllIIIllIllIIIII.unqueued = BufferUtils.createIntBuffer((int)1);
        lllllllllllllllIlllIIIllIllIIIII.soundWorks = true;
        lllllllllllllllIlllIIIllIllIIIII.done = true;
    }

    public boolean done() {
        OpenALMODPlayer lllllllllllllllIlllIIIllIIIlllll;
        return lllllllllllllllIlllIIIllIIIlllll.done;
    }

    public void setup(float lllllllllllllllIlllIIIllIIlIIllI, float lllllllllllllllIlllIIIllIIlIIIlI) {
        OpenALMODPlayer lllllllllllllllIlllIIIllIIlIIlII;
        AL10.alSourcef((int)lllllllllllllllIlllIIIllIIlIIlII.source, (int)4099, (float)lllllllllllllllIlllIIIllIIlIIllI);
        AL10.alSourcef((int)lllllllllllllllIlllIIIllIIlIIlII.source, (int)4106, (float)lllllllllllllllIlllIIIllIIlIIIlI);
    }

    public void play(int lllllllllllllllIlllIIIllIlIIIlIl, InputStream lllllllllllllllIlllIIIllIIllllll, boolean lllllllllllllllIlllIIIllIIlllllI, boolean lllllllllllllllIlllIIIllIIllllIl) throws IOException {
        OpenALMODPlayer lllllllllllllllIlllIIIllIlIIIIIl;
        if (!lllllllllllllllIlllIIIllIlIIIIIl.soundWorks) {
            return;
        }
        lllllllllllllllIlllIIIllIlIIIIIl.done = false;
        lllllllllllllllIlllIIIllIlIIIIIl.loop = lllllllllllllllIlllIIIllIIlllllI;
        lllllllllllllllIlllIIIllIlIIIIIl.source = lllllllllllllllIlllIIIllIlIIIlIl;
        lllllllllllllllIlllIIIllIlIIIIIl.module = OpenALMODPlayer.loadModule(lllllllllllllllIlllIIIllIIllllll);
        lllllllllllllllIlllIIIllIlIIIIIl.play(lllllllllllllllIlllIIIllIlIIIIIl.module, lllllllllllllllIlllIIIllIlIIIlIl, lllllllllllllllIlllIIIllIIlllllI, lllllllllllllllIlllIIIllIIllllIl);
    }

    public void play(InputStream lllllllllllllllIlllIIIllIlIIlllI, boolean lllllllllllllllIlllIIIllIlIIllIl, boolean lllllllllllllllIlllIIIllIlIIllII) throws IOException {
        OpenALMODPlayer lllllllllllllllIlllIIIllIlIIllll;
        lllllllllllllllIlllIIIllIlIIllll.play(lllllllllllllllIlllIIIllIlIIllll.source, lllllllllllllllIlllIIIllIlIIlllI, lllllllllllllllIlllIIIllIlIIllIl, lllllllllllllllIlllIIIllIlIIllII);
    }

    static {
        sectionSize = 40960;
    }

    public boolean stream(int lllllllllllllllIlllIIIlIllllllIl) {
        OpenALMODPlayer lllllllllllllllIlllIIIlIlllllIIl;
        int lllllllllllllllIlllIIIlIllllllII = 40960;
        boolean lllllllllllllllIlllIIIlIlllllIll = false;
        boolean lllllllllllllllIlllIIIlIlllllIlI = true;
        if (lllllllllllllllIlllIIIlIllllllII > lllllllllllllllIlllIIIlIlllllIIl.songDuration) {
            lllllllllllllllIlllIIIlIllllllII = lllllllllllllllIlllIIIlIlllllIIl.songDuration;
            lllllllllllllllIlllIIIlIlllllIll = true;
        }
        lllllllllllllllIlllIIIlIlllllIIl.ibxm.get_audio(lllllllllllllllIlllIIIlIlllllIIl.data, lllllllllllllllIlllIIIlIllllllII);
        lllllllllllllllIlllIIIlIlllllIIl.bufferData.clear();
        lllllllllllllllIlllIIIlIlllllIIl.bufferData.put(lllllllllllllllIlllIIIlIlllllIIl.data);
        lllllllllllllllIlllIIIlIlllllIIl.bufferData.limit(lllllllllllllllIlllIIIlIllllllII * 4);
        if (lllllllllllllllIlllIIIlIlllllIll) {
            if (lllllllllllllllIlllIIIlIlllllIIl.loop) {
                lllllllllllllllIlllIIIlIlllllIIl.ibxm.seek(0);
                lllllllllllllllIlllIIIlIlllllIIl.ibxm.set_module(lllllllllllllllIlllIIIlIlllllIIl.module);
                lllllllllllllllIlllIIIlIlllllIIl.songDuration = lllllllllllllllIlllIIIlIlllllIIl.ibxm.calculate_song_duration();
            } else {
                lllllllllllllllIlllIIIlIlllllIlI = false;
                lllllllllllllllIlllIIIlIlllllIIl.songDuration -= lllllllllllllllIlllIIIlIllllllII;
            }
        } else {
            lllllllllllllllIlllIIIlIlllllIIl.songDuration -= lllllllllllllllIlllIIIlIllllllII;
        }
        lllllllllllllllIlllIIIlIlllllIIl.bufferData.flip();
        AL10.alBufferData((int)lllllllllllllllIlllIIIlIllllllIl, (int)4355, (ByteBuffer)lllllllllllllllIlllIIIlIlllllIIl.bufferData, (int)48000);
        return lllllllllllllllIlllIIIlIlllllIlI;
    }

    public void init() {
        OpenALMODPlayer lllllllllllllllIlllIIIllIlIllIlI;
        try {
            AL.create();
            lllllllllllllllIlllIIIllIlIllIlI.soundWorks = true;
        }
        catch (LWJGLException lllllllllllllllIlllIIIllIlIlllII) {
            System.err.println("Failed to initialise LWJGL OpenAL");
            lllllllllllllllIlllIIIllIlIllIlI.soundWorks = false;
            return;
        }
        if (lllllllllllllllIlllIIIllIlIllIlI.soundWorks) {
            IntBuffer lllllllllllllllIlllIIIllIlIllIll = BufferUtils.createIntBuffer((int)1);
            AL10.alGenSources((IntBuffer)lllllllllllllllIlllIIIllIlIllIll);
            if (AL10.alGetError() != 0) {
                System.err.println("Failed to create sources");
                lllllllllllllllIlllIIIllIlIllIlI.soundWorks = false;
            } else {
                lllllllllllllllIlllIIIllIlIllIlI.source = lllllllllllllllIlllIIIllIlIllIll.get(0);
            }
        }
    }

    public void play(Module lllllllllllllllIlllIIIllIIlIllll, int lllllllllllllllIlllIIIllIIlIlllI, boolean lllllllllllllllIlllIIIllIIlIllIl, boolean lllllllllllllllIlllIIIllIIllIIIl) {
        OpenALMODPlayer lllllllllllllllIlllIIIllIIllIlIl;
        lllllllllllllllIlllIIIllIIllIlIl.source = lllllllllllllllIlllIIIllIIlIlllI;
        lllllllllllllllIlllIIIllIIllIlIl.loop = lllllllllllllllIlllIIIllIIlIllIl;
        lllllllllllllllIlllIIIllIIllIlIl.module = lllllllllllllllIlllIIIllIIlIllll;
        lllllllllllllllIlllIIIllIIllIlIl.done = false;
        lllllllllllllllIlllIIIllIIllIlIl.ibxm = new IBXM(48000);
        lllllllllllllllIlllIIIllIIllIlIl.ibxm.set_module(lllllllllllllllIlllIIIllIIlIllll);
        lllllllllllllllIlllIIIllIIllIlIl.songDuration = lllllllllllllllIlllIIIllIIllIlIl.ibxm.calculate_song_duration();
        if (lllllllllllllllIlllIIIllIIllIlIl.bufferNames != null) {
            AL10.alSourceStop((int)lllllllllllllllIlllIIIllIIlIlllI);
            lllllllllllllllIlllIIIllIIllIlIl.bufferNames.flip();
            AL10.alDeleteBuffers((IntBuffer)lllllllllllllllIlllIIIllIIllIlIl.bufferNames);
        }
        lllllllllllllllIlllIIIllIIllIlIl.bufferNames = BufferUtils.createIntBuffer((int)2);
        AL10.alGenBuffers((IntBuffer)lllllllllllllllIlllIIIllIIllIlIl.bufferNames);
        lllllllllllllllIlllIIIllIIllIlIl.remainingBufferCount = 2;
        for (int lllllllllllllllIlllIIIllIIllIllI = 0; lllllllllllllllIlllIIIllIIllIllI < 2; ++lllllllllllllllIlllIIIllIIllIllI) {
            lllllllllllllllIlllIIIllIIllIlIl.stream(lllllllllllllllIlllIIIllIIllIlIl.bufferNames.get(lllllllllllllllIlllIIIllIIllIllI));
        }
        AL10.alSourceQueueBuffers((int)lllllllllllllllIlllIIIllIIlIlllI, (IntBuffer)lllllllllllllllIlllIIIllIIllIlIl.bufferNames);
        AL10.alSourcef((int)lllllllllllllllIlllIIIllIIlIlllI, (int)4099, (float)1.0f);
        AL10.alSourcef((int)lllllllllllllllIlllIIIllIIlIlllI, (int)4106, (float)1.0f);
        if (lllllllllllllllIlllIIIllIIllIIIl) {
            AL10.alSourcePlay((int)lllllllllllllllIlllIIIllIIlIlllI);
        }
    }

    public void update() {
        OpenALMODPlayer lllllllllllllllIlllIIIllIIIIIllI;
        if (lllllllllllllllIlllIIIllIIIIIllI.done) {
            return;
        }
        for (int lllllllllllllllIlllIIIllIIIIlIII = AL10.alGetSourcei((int)lllllllllllllllIlllIIIllIIIIIllI.source, (int)4118); lllllllllllllllIlllIIIllIIIIlIII > 0; --lllllllllllllllIlllIIIllIIIIlIII) {
            lllllllllllllllIlllIIIllIIIIIllI.unqueued.clear();
            AL10.alSourceUnqueueBuffers((int)lllllllllllllllIlllIIIllIIIIIllI.source, (IntBuffer)lllllllllllllllIlllIIIllIIIIIllI.unqueued);
            if (lllllllllllllllIlllIIIllIIIIIllI.stream(lllllllllllllllIlllIIIllIIIIIllI.unqueued.get(0))) {
                AL10.alSourceQueueBuffers((int)lllllllllllllllIlllIIIllIIIIIllI.source, (IntBuffer)lllllllllllllllIlllIIIllIIIIIllI.unqueued);
                continue;
            }
            --lllllllllllllllIlllIIIllIIIIIllI.remainingBufferCount;
            if (lllllllllllllllIlllIIIllIIIIIllI.remainingBufferCount != 0) continue;
            lllllllllllllllIlllIIIllIIIIIllI.done = true;
        }
        int lllllllllllllllIlllIIIllIIIIIlll = AL10.alGetSourcei((int)lllllllllllllllIlllIIIllIIIIIllI.source, (int)4112);
        if (lllllllllllllllIlllIIIllIIIIIlll != 4114) {
            AL10.alSourcePlay((int)lllllllllllllllIlllIIIllIIIIIllI.source);
        }
    }
}

