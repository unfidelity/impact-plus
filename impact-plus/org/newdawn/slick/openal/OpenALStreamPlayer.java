/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.openal.AL10
 *  org.lwjgl.openal.OpenALException
 */
package org.newdawn.slick.openal;

import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.OpenALException;
import org.newdawn.slick.openal.AudioInputStream;
import org.newdawn.slick.openal.OggInputStream;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

public class OpenALStreamPlayer {
    private /* synthetic */ boolean done;
    private /* synthetic */ ByteBuffer bufferData;
    private /* synthetic */ float pitch;
    private /* synthetic */ AudioInputStream audio;
    private /* synthetic */ byte[] buffer;
    private /* synthetic */ int source;
    private /* synthetic */ boolean loop;
    private /* synthetic */ int remainingBufferCount;
    private /* synthetic */ IntBuffer unqueued;
    public static final /* synthetic */ int BUFFER_COUNT;
    private /* synthetic */ IntBuffer bufferNames;
    private /* synthetic */ String ref;
    private /* synthetic */ URL url;
    private static final /* synthetic */ int sectionSize;
    private /* synthetic */ float positionOffset;

    public float getPosition() {
        OpenALStreamPlayer lIlIIIIlIl;
        return lIlIIIIlIl.positionOffset + AL10.alGetSourcef((int)lIlIIIIlIl.source, (int)4132);
    }

    private void startPlayback() {
        OpenALStreamPlayer lIlIIIlIIl;
        AL10.alSourcei((int)lIlIIIlIIl.source, (int)4103, (int)0);
        AL10.alSourcef((int)lIlIIIlIIl.source, (int)4099, (float)lIlIIIlIIl.pitch);
        lIlIIIlIIl.remainingBufferCount = 3;
        for (int lIlIIIlIll = 0; lIlIIIlIll < 3; ++lIlIIIlIll) {
            lIlIIIlIIl.stream(lIlIIIlIIl.bufferNames.get(lIlIIIlIll));
        }
        AL10.alSourceQueueBuffers((int)lIlIIIlIIl.source, (IntBuffer)lIlIIIlIIl.bufferNames);
        AL10.alSourcePlay((int)lIlIIIlIIl.source);
    }

    public boolean setPosition(float lIlIIlIlII) {
        try {
            float lIlIIlIlll;
            OpenALStreamPlayer lIlIIlIIll;
            if (lIlIIlIIll.getPosition() > lIlIIlIlII) {
                lIlIIlIIll.initStreams();
            }
            float lIlIIllIII = lIlIIlIIll.audio.getRate();
            if (lIlIIlIIll.audio.getChannels() > 1) {
                float lIlIIllIll = 4.0f;
            } else {
                lIlIIlIlll = 2.0f;
            }
            while (lIlIIlIIll.positionOffset < lIlIIlIlII) {
                int lIlIIllIIl = lIlIIlIIll.audio.read(lIlIIlIIll.buffer);
                if (lIlIIllIIl != -1) {
                    float lIlIIllIlI = (float)lIlIIllIIl / lIlIIlIlll / lIlIIllIII;
                    lIlIIlIIll.positionOffset += lIlIIllIlI;
                    continue;
                }
                if (lIlIIlIIll.loop) {
                    lIlIIlIIll.initStreams();
                } else {
                    lIlIIlIIll.done = true;
                }
                return false;
            }
            lIlIIlIIll.startPlayback();
            return true;
        }
        catch (IOException lIlIIlIllI) {
            Log.error(lIlIIlIllI);
            return false;
        }
    }

    static {
        BUFFER_COUNT = 3;
        sectionSize = 81920;
    }

    private void removeBuffers() {
        IntBuffer lIlllIlIll = BufferUtils.createIntBuffer((int)1);
        for (int lIlllIlIlI = AL10.alGetSourcei((int)lIlllIlIIl.source, (int)4117); lIlllIlIlI > 0; --lIlllIlIlI) {
            OpenALStreamPlayer lIlllIlIIl;
            AL10.alSourceUnqueueBuffers((int)lIlllIlIIl.source, (IntBuffer)lIlllIlIll);
        }
    }

    private void initStreams() throws IOException {
        OggInputStream llIIIIlIII;
        OpenALStreamPlayer llIIIIlIIl;
        if (llIIIIlIIl.audio != null) {
            llIIIIlIIl.audio.close();
        }
        if (llIIIIlIIl.url != null) {
            OggInputStream llIIIIlIlI = new OggInputStream(llIIIIlIIl.url.openStream());
        } else {
            llIIIIlIII = new OggInputStream(ResourceLoader.getResourceAsStream(llIIIIlIIl.ref));
        }
        llIIIIlIIl.audio = llIIIIlIII;
        llIIIIlIIl.positionOffset = 0.0f;
    }

    public String getSource() {
        OpenALStreamPlayer lIllllllll;
        return lIllllllll.url == null ? lIllllllll.ref : lIllllllll.url.toString();
    }

    public OpenALStreamPlayer(int llIIlIIIII, String llIIIlllll) {
        OpenALStreamPlayer llIIlIIlII;
        llIIlIIlII.buffer = new byte[81920];
        llIIlIIlII.bufferData = BufferUtils.createByteBuffer((int)81920);
        llIIlIIlII.unqueued = BufferUtils.createIntBuffer((int)1);
        llIIlIIlII.done = true;
        llIIlIIlII.source = llIIlIIIII;
        llIIlIIlII.ref = llIIIlllll;
        llIIlIIlII.bufferNames = BufferUtils.createIntBuffer((int)3);
        AL10.alGenBuffers((IntBuffer)llIIlIIlII.bufferNames);
    }

    public boolean done() {
        OpenALStreamPlayer lIllIlIIll;
        return lIllIlIIll.done;
    }

    public void setup(float lIllIllIlI) {
        lIllIllllI.pitch = lIllIllIlI;
    }

    public void play(boolean lIlllIIIIl) throws IOException {
        OpenALStreamPlayer lIlllIIlII;
        lIlllIIlII.loop = lIlllIIIIl;
        lIlllIIlII.initStreams();
        lIlllIIlII.done = false;
        AL10.alSourceStop((int)lIlllIIlII.source);
        lIlllIIlII.removeBuffers();
        lIlllIIlII.startPlayback();
    }

    public void update() {
        float lIlIlllIlI;
        OpenALStreamPlayer lIlIllllII;
        if (lIlIllllII.done) {
            return;
        }
        float lIlIlllIll = lIlIllllII.audio.getRate();
        if (lIlIllllII.audio.getChannels() > 1) {
            float lIlIllllll = 4.0f;
        } else {
            lIlIlllIlI = 2.0f;
        }
        for (int lIlIlllIIl = AL10.alGetSourcei((int)lIlIllllII.source, (int)4118); lIlIlllIIl > 0; --lIlIlllIIl) {
            lIlIllllII.unqueued.clear();
            AL10.alSourceUnqueueBuffers((int)lIlIllllII.source, (IntBuffer)lIlIllllII.unqueued);
            int lIlIlllllI = lIlIllllII.unqueued.get(0);
            float lIlIllllIl = (float)AL10.alGetBufferi((int)lIlIlllllI, (int)8196) / lIlIlllIlI / lIlIlllIll;
            lIlIllllII.positionOffset += lIlIllllIl;
            if (lIlIllllII.stream(lIlIlllllI)) {
                AL10.alSourceQueueBuffers((int)lIlIllllII.source, (IntBuffer)lIlIllllII.unqueued);
                continue;
            }
            --lIlIllllII.remainingBufferCount;
            if (lIlIllllII.remainingBufferCount != 0) continue;
            lIlIllllII.done = true;
        }
        int lIlIlllIII = AL10.alGetSourcei((int)lIlIllllII.source, (int)4112);
        if (lIlIlllIII != 4114) {
            AL10.alSourcePlay((int)lIlIllllII.source);
        }
    }

    public OpenALStreamPlayer(int llIIIlIlII, URL llIIIlIIll) {
        OpenALStreamPlayer llIIIllIII;
        llIIIllIII.buffer = new byte[81920];
        llIIIllIII.bufferData = BufferUtils.createByteBuffer((int)81920);
        llIIIllIII.unqueued = BufferUtils.createIntBuffer((int)1);
        llIIIllIII.done = true;
        llIIIllIII.source = llIIIlIlII;
        llIIIllIII.url = llIIIlIIll;
        llIIIllIII.bufferNames = BufferUtils.createIntBuffer((int)3);
        AL10.alGenBuffers((IntBuffer)llIIIllIII.bufferNames);
    }

    public boolean stream(int lIlIlIIlIl) {
        try {
            OpenALStreamPlayer lIlIlIIllI;
            int lIlIlIlIlI = lIlIlIIllI.audio.read(lIlIlIIllI.buffer);
            if (lIlIlIlIlI != -1) {
                lIlIlIIllI.bufferData.clear();
                lIlIlIIllI.bufferData.put(lIlIlIIllI.buffer, 0, lIlIlIlIlI);
                lIlIlIIllI.bufferData.flip();
                int lIlIlIlIll = lIlIlIIllI.audio.getChannels() > 1 ? 4355 : 4353;
                try {
                    AL10.alBufferData((int)lIlIlIIlIl, (int)lIlIlIlIll, (ByteBuffer)lIlIlIIllI.bufferData, (int)lIlIlIIllI.audio.getRate());
                }
                catch (OpenALException lIlIlIllII) {
                    Log.error(String.valueOf(new StringBuilder().append("Failed to loop buffer: ").append(lIlIlIIlIl).append(" ").append(lIlIlIlIll).append(" ").append(lIlIlIlIlI).append(" ").append(lIlIlIIllI.audio.getRate())), lIlIlIllII);
                    return false;
                }
            } else if (lIlIlIIllI.loop) {
                lIlIlIIllI.initStreams();
                lIlIlIIllI.stream(lIlIlIIlIl);
            } else {
                lIlIlIIllI.done = true;
                return false;
            }
            return true;
        }
        catch (IOException lIlIlIlIIl) {
            Log.error(lIlIlIlIIl);
            return false;
        }
    }
}

