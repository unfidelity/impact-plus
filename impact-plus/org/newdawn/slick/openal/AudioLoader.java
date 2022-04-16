/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.openal;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.SoundStore;

public class AudioLoader {
    private static final /* synthetic */ String MOD;
    private static final /* synthetic */ String WAV;
    private static /* synthetic */ boolean inited;
    private static final /* synthetic */ String OGG;
    private static final /* synthetic */ String AIF;
    private static final /* synthetic */ String XM;

    public static Audio getAudio(String lIlIlIlIIIlIlI, InputStream lIlIlIlIIIlIIl) throws IOException {
        AudioLoader.init();
        if (lIlIlIlIIIlIlI.equals("AIF")) {
            return SoundStore.get().getAIF(lIlIlIlIIIlIIl);
        }
        if (lIlIlIlIIIlIlI.equals("WAV")) {
            return SoundStore.get().getWAV(lIlIlIlIIIlIIl);
        }
        if (lIlIlIlIIIlIlI.equals("OGG")) {
            return SoundStore.get().getOgg(lIlIlIlIIIlIIl);
        }
        throw new IOException(String.valueOf(new StringBuilder().append("Unsupported format for non-streaming Audio: ").append(lIlIlIlIIIlIlI)));
    }

    public AudioLoader() {
        AudioLoader lIlIlIlIIIlllI;
    }

    static {
        AIF = "AIF";
        WAV = "WAV";
        OGG = "OGG";
        XM = "XM";
        MOD = "MOD";
        inited = false;
    }

    public static void update() {
        AudioLoader.init();
        SoundStore.get().poll(0);
    }

    private static void init() {
        if (!inited) {
            SoundStore.get().init();
            inited = true;
        }
    }

    public static Audio getStreamingAudio(String lIlIlIlIIIIIlI, URL lIlIlIlIIIIIIl) throws IOException {
        AudioLoader.init();
        if (lIlIlIlIIIIIlI.equals("OGG")) {
            return SoundStore.get().getOggStream(lIlIlIlIIIIIIl);
        }
        if (lIlIlIlIIIIIlI.equals("MOD")) {
            return SoundStore.get().getMOD(lIlIlIlIIIIIIl.openStream());
        }
        if (lIlIlIlIIIIIlI.equals("XM")) {
            return SoundStore.get().getMOD(lIlIlIlIIIIIIl.openStream());
        }
        throw new IOException(String.valueOf(new StringBuilder().append("Unsupported format for streaming Audio: ").append(lIlIlIlIIIIIlI)));
    }
}

