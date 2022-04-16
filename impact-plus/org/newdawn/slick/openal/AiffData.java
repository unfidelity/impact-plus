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

public class AiffData {
    public final /* synthetic */ int samplerate;
    public final /* synthetic */ ByteBuffer data;
    public final /* synthetic */ int format;

    private AiffData(ByteBuffer lllllllllllllllIlllIIIIIlIlIlIlI, int lllllllllllllllIlllIIIIIlIlIlIIl, int lllllllllllllllIlllIIIIIlIlIlIII) {
        AiffData lllllllllllllllIlllIIIIIlIlIIlll;
        lllllllllllllllIlllIIIIIlIlIIlll.data = lllllllllllllllIlllIIIIIlIlIlIlI;
        lllllllllllllllIlllIIIIIlIlIIlll.format = lllllllllllllllIlllIIIIIlIlIlIIl;
        lllllllllllllllIlllIIIIIlIlIIlll.samplerate = lllllllllllllllIlllIIIIIlIlIlIII;
    }

    public static AiffData create(byte[] lllllllllllllllIlllIIIIIlIIIllIl) {
        try {
            return AiffData.create(AudioSystem.getAudioInputStream(new BufferedInputStream(new ByteArrayInputStream(lllllllllllllllIlllIIIIIlIIIllIl))));
        }
        catch (Exception lllllllllllllllIlllIIIIIlIIIllll) {
            lllllllllllllllIlllIIIIIlIIIllll.printStackTrace();
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static AiffData create(AudioInputStream lllllllllllllllIlllIIIIIIlllIIIl) {
        AudioFormat lllllllllllllllIlllIIIIIIllllIII = lllllllllllllllIlllIIIIIIlllIIIl.getFormat();
        int lllllllllllllllIlllIIIIIIlllIlll = 0;
        if (lllllllllllllllIlllIIIIIIllllIII.getChannels() == 1) {
            if (lllllllllllllllIlllIIIIIIllllIII.getSampleSizeInBits() == 8) {
                lllllllllllllllIlllIIIIIIlllIlll = 4352;
            } else {
                if (lllllllllllllllIlllIIIIIIllllIII.getSampleSizeInBits() != 16) throw new RuntimeException("Illegal sample size");
                lllllllllllllllIlllIIIIIIlllIlll = 4353;
            }
        } else {
            if (lllllllllllllllIlllIIIIIIllllIII.getChannels() != 2) throw new RuntimeException("Only mono or stereo is supported");
            if (lllllllllllllllIlllIIIIIIllllIII.getSampleSizeInBits() == 8) {
                lllllllllllllllIlllIIIIIIlllIlll = 4354;
            } else {
                if (lllllllllllllllIlllIIIIIIllllIII.getSampleSizeInBits() != 16) throw new RuntimeException("Illegal sample size");
                lllllllllllllllIlllIIIIIIlllIlll = 4355;
            }
        }
        byte[] lllllllllllllllIlllIIIIIIlllIllI = new byte[lllllllllllllllIlllIIIIIIllllIII.getChannels() * (int)lllllllllllllllIlllIIIIIIlllIIIl.getFrameLength() * lllllllllllllllIlllIIIIIIllllIII.getSampleSizeInBits() / 8];
        int lllllllllllllllIlllIIIIIIlllIlIl = 0;
        try {
            for (int lllllllllllllllIlllIIIIIIlllIlII = 0; (lllllllllllllllIlllIIIIIIlllIlIl = lllllllllllllllIlllIIIIIIlllIIIl.read(lllllllllllllllIlllIIIIIIlllIllI, lllllllllllllllIlllIIIIIIlllIlII, lllllllllllllllIlllIIIIIIlllIllI.length - lllllllllllllllIlllIIIIIIlllIlII)) != -1 && lllllllllllllllIlllIIIIIIlllIlII < lllllllllllllllIlllIIIIIIlllIllI.length; lllllllllllllllIlllIIIIIIlllIlII += lllllllllllllllIlllIIIIIIlllIlIl) {
            }
        }
        catch (IOException lllllllllllllllIlllIIIIIIllllIll) {
            return null;
        }
        ByteBuffer lllllllllllllllIlllIIIIIIlllIIll = AiffData.convertAudioBytes(lllllllllllllllIlllIIIIIIllllIII, lllllllllllllllIlllIIIIIIlllIllI, lllllllllllllllIlllIIIIIIllllIII.getSampleSizeInBits() == 16);
        AiffData lllllllllllllllIlllIIIIIIlllIIlI = new AiffData(lllllllllllllllIlllIIIIIIlllIIll, lllllllllllllllIlllIIIIIIlllIlll, (int)lllllllllllllllIlllIIIIIIllllIII.getSampleRate());
        try {
            lllllllllllllllIlllIIIIIIlllIIIl.close();
            return lllllllllllllllIlllIIIIIIlllIIlI;
        }
        catch (IOException lllllllllllllllIlllIIIIIIllllIlI) {
            // empty catch block
        }
        return lllllllllllllllIlllIIIIIIlllIIlI;
    }

    public void dispose() {
        AiffData lllllllllllllllIlllIIIIIlIlIIIlI;
        lllllllllllllllIlllIIIIIlIlIIIlI.data.clear();
    }

    public static AiffData create(ByteBuffer lllllllllllllllIlllIIIIIlIIIIllI) {
        try {
            byte[] lllllllllllllllIlllIIIIIlIIIlIIl = null;
            if (lllllllllllllllIlllIIIIIlIIIIllI.hasArray()) {
                lllllllllllllllIlllIIIIIlIIIlIIl = lllllllllllllllIlllIIIIIlIIIIllI.array();
            } else {
                lllllllllllllllIlllIIIIIlIIIlIIl = new byte[lllllllllllllllIlllIIIIIlIIIIllI.capacity()];
                lllllllllllllllIlllIIIIIlIIIIllI.get(lllllllllllllllIlllIIIIIlIIIlIIl);
            }
            return AiffData.create(lllllllllllllllIlllIIIIIlIIIlIIl);
        }
        catch (Exception lllllllllllllllIlllIIIIIlIIIlIII) {
            lllllllllllllllIlllIIIIIlIIIlIII.printStackTrace();
            return null;
        }
    }

    private static ByteBuffer convertAudioBytes(AudioFormat lllllllllllllllIlllIIIIIIlIllllI, byte[] lllllllllllllllIlllIIIIIIlIllIII, boolean lllllllllllllllIlllIIIIIIlIlIlll) {
        ByteBuffer lllllllllllllllIlllIIIIIIlIllIll = ByteBuffer.allocateDirect(lllllllllllllllIlllIIIIIIlIllIII.length);
        lllllllllllllllIlllIIIIIIlIllIll.order(ByteOrder.nativeOrder());
        ByteBuffer lllllllllllllllIlllIIIIIIlIllIlI = ByteBuffer.wrap(lllllllllllllllIlllIIIIIIlIllIII);
        lllllllllllllllIlllIIIIIIlIllIlI.order(ByteOrder.BIG_ENDIAN);
        if (lllllllllllllllIlllIIIIIIlIlIlll) {
            ShortBuffer lllllllllllllllIlllIIIIIIllIIIIl = lllllllllllllllIlllIIIIIIlIllIll.asShortBuffer();
            ShortBuffer lllllllllllllllIlllIIIIIIllIIIII = lllllllllllllllIlllIIIIIIlIllIlI.asShortBuffer();
            while (lllllllllllllllIlllIIIIIIllIIIII.hasRemaining()) {
                lllllllllllllllIlllIIIIIIllIIIIl.put(lllllllllllllllIlllIIIIIIllIIIII.get());
            }
        } else {
            while (lllllllllllllllIlllIIIIIIlIllIlI.hasRemaining()) {
                byte lllllllllllllllIlllIIIIIIlIlllll = lllllllllllllllIlllIIIIIIlIllIlI.get();
                if (lllllllllllllllIlllIIIIIIlIllllI.getEncoding() == AudioFormat.Encoding.PCM_SIGNED) {
                    lllllllllllllllIlllIIIIIIlIlllll = (byte)(lllllllllllllllIlllIIIIIIlIlllll + 127);
                }
                lllllllllllllllIlllIIIIIIlIllIll.put(lllllllllllllllIlllIIIIIIlIlllll);
            }
        }
        lllllllllllllllIlllIIIIIIlIllIll.rewind();
        return lllllllllllllllIlllIIIIIIlIllIll;
    }

    public static AiffData create(URL lllllllllllllllIlllIIIIIlIIlllII) {
        try {
            return AiffData.create(AudioSystem.getAudioInputStream(new BufferedInputStream(lllllllllllllllIlllIIIIIlIIlllII.openStream())));
        }
        catch (Exception lllllllllllllllIlllIIIIIlIIllllI) {
            LWJGLUtil.log((CharSequence)String.valueOf(new StringBuilder().append("Unable to create from: ").append(lllllllllllllllIlllIIIIIlIIlllII)));
            lllllllllllllllIlllIIIIIlIIllllI.printStackTrace();
            return null;
        }
    }

    public static AiffData create(String lllllllllllllllIlllIIIIIlIIllIII) {
        return AiffData.create(AiffData.class.getClassLoader().getResource(lllllllllllllllIlllIIIIIlIIllIII));
    }

    public static AiffData create(InputStream lllllllllllllllIlllIIIIIlIIlIIll) {
        try {
            return AiffData.create(AudioSystem.getAudioInputStream(lllllllllllllllIlllIIIIIlIIlIIll));
        }
        catch (Exception lllllllllllllllIlllIIIIIlIIlIlIl) {
            LWJGLUtil.log((CharSequence)"Unable to create from inputstream");
            lllllllllllllllIlllIIIIIlIIlIlIl.printStackTrace();
            return null;
        }
    }
}

