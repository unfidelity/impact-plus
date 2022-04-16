/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.LWJGLUtil
 */
package org.newdawn.slick.openal;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import org.lwjgl.LWJGLUtil;

public class WaveData {
    public final /* synthetic */ int format;
    public final /* synthetic */ ByteBuffer data;
    public final /* synthetic */ int samplerate;

    private WaveData(ByteBuffer llllIlIIIIIIll, int llllIIlllllllI, int llllIIllllllIl) {
        WaveData llllIlIIIIIIII;
        llllIlIIIIIIII.data = llllIlIIIIIIll;
        llllIlIIIIIIII.format = llllIIlllllllI;
        llllIlIIIIIIII.samplerate = llllIIllllllIl;
    }

    public static WaveData create(ByteBuffer llllIIllIlllll) {
        try {
            byte[] llllIIlllIIIlI = null;
            if (llllIIllIlllll.hasArray()) {
                llllIIlllIIIlI = llllIIllIlllll.array();
            } else {
                llllIIlllIIIlI = new byte[llllIIllIlllll.capacity()];
                llllIIllIlllll.get(llllIIlllIIIlI);
            }
            return WaveData.create(llllIIlllIIIlI);
        }
        catch (Exception llllIIlllIIIIl) {
            llllIIlllIIIIl.printStackTrace();
            return null;
        }
    }

    private static ByteBuffer convertAudioBytes(byte[] llllIIlIllIlIl, boolean llllIIlIlllIII) {
        ByteBuffer llllIIlIllIlll = ByteBuffer.allocateDirect(llllIIlIllIlIl.length);
        llllIIlIllIlll.order(ByteOrder.nativeOrder());
        ByteBuffer llllIIlIllIllI = ByteBuffer.wrap(llllIIlIllIlIl);
        llllIIlIllIllI.order(ByteOrder.LITTLE_ENDIAN);
        if (llllIIlIlllIII) {
            ShortBuffer llllIIlIlllIll = llllIIlIllIlll.asShortBuffer();
            ShortBuffer llllIIlIlllIlI = llllIIlIllIllI.asShortBuffer();
            while (llllIIlIlllIlI.hasRemaining()) {
                llllIIlIlllIll.put(llllIIlIlllIlI.get());
            }
        } else {
            while (llllIIlIllIllI.hasRemaining()) {
                llllIIlIllIlll.put(llllIIlIllIllI.get());
            }
        }
        llllIIlIllIlll.rewind();
        return llllIIlIllIlll;
    }

    public static WaveData create(URL llllIIllllIlIl) {
        try {
            return WaveData.create(AudioSystem.getAudioInputStream(new BufferedInputStream(llllIIllllIlIl.openStream())));
        }
        catch (Exception llllIIllllIlll) {
            LWJGLUtil.log((CharSequence)String.valueOf(new StringBuilder().append("Unable to create from: ").append(llllIIllllIlIl)));
            llllIIllllIlll.printStackTrace();
            return null;
        }
    }

    public static WaveData create(byte[] llllIIlllIIllI) {
        try {
            return WaveData.create(AudioSystem.getAudioInputStream(new BufferedInputStream(new ByteArrayInputStream(llllIIlllIIllI))));
        }
        catch (Exception llllIIlllIlIII) {
            llllIIlllIlIII.printStackTrace();
            return null;
        }
    }

    public static WaveData create(String llllIIllllIIlI) {
        return WaveData.create(WaveData.class.getClassLoader().getResource(llllIIllllIIlI));
    }

    public static WaveData create(InputStream llllIIlllIllII) {
        try {
            return WaveData.create(AudioSystem.getAudioInputStream(llllIIlllIllII));
        }
        catch (Exception llllIIlllIlllI) {
            LWJGLUtil.log((CharSequence)"Unable to create from inputstream");
            llllIIlllIlllI.printStackTrace();
            return null;
        }
    }

    public void dispose() {
        WaveData llllIIlllllIlI;
        llllIIlllllIlI.data.clear();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static WaveData create(AudioInputStream llllIIllIlIIlI) {
        AudioFormat llllIIllIlIIIl = llllIIllIlIIlI.getFormat();
        int llllIIllIlIIII = 0;
        if (llllIIllIlIIIl.getChannels() == 1) {
            if (llllIIllIlIIIl.getSampleSizeInBits() == 8) {
                llllIIllIlIIII = 4352;
            } else {
                if (llllIIllIlIIIl.getSampleSizeInBits() != 16) throw new RuntimeException("Illegal sample size");
                llllIIllIlIIII = 4353;
            }
        } else {
            if (llllIIllIlIIIl.getChannels() != 2) throw new RuntimeException("Only mono or stereo is supported");
            if (llllIIllIlIIIl.getSampleSizeInBits() == 8) {
                llllIIllIlIIII = 4354;
            } else {
                if (llllIIllIlIIIl.getSampleSizeInBits() != 16) throw new RuntimeException("Illegal sample size");
                llllIIllIlIIII = 4355;
            }
        }
        byte[] llllIIllIIllll = new byte[llllIIllIlIIIl.getChannels() * (int)llllIIllIlIIlI.getFrameLength() * llllIIllIlIIIl.getSampleSizeInBits() / 8];
        int llllIIllIIlllI = 0;
        try {
            for (int llllIIllIIllIl = 0; (llllIIllIIlllI = llllIIllIlIIlI.read(llllIIllIIllll, llllIIllIIllIl, llllIIllIIllll.length - llllIIllIIllIl)) != -1 && llllIIllIIllIl < llllIIllIIllll.length; llllIIllIIllIl += llllIIllIIlllI) {
            }
        }
        catch (IOException llllIIllIlIlII) {
            return null;
        }
        ByteBuffer llllIIllIIllII = WaveData.convertAudioBytes(llllIIllIIllll, llllIIllIlIIIl.getSampleSizeInBits() == 16);
        WaveData llllIIllIIlIll = new WaveData(llllIIllIIllII, llllIIllIlIIII, (int)llllIIllIlIIIl.getSampleRate());
        try {
            llllIIllIlIIlI.close();
            return llllIIllIIlIll;
        }
        catch (IOException llllIIllIlIIll) {
            // empty catch block
        }
        return llllIIllIIlIll;
    }
}

