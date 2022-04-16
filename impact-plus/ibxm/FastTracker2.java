/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Envelope;
import ibxm.Instrument;
import ibxm.Module;
import ibxm.Pattern;
import ibxm.Sample;
import java.io.DataInput;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FastTracker2 {
    private static int int_le(byte[] llllllllllllllllIIlIIllllIlllIIl, int llllllllllllllllIIlIIllllIlllIII) {
        int llllllllllllllllIIlIIllllIllIlll = llllllllllllllllIIlIIllllIlllIIl[llllllllllllllllIIlIIllllIlllIII] & 0xFF;
        llllllllllllllllIIlIIllllIllIlll |= (llllllllllllllllIIlIIllllIlllIIl[llllllllllllllllIIlIIllllIlllIII + 1] & 0xFF) << 8;
        llllllllllllllllIIlIIllllIllIlll |= (llllllllllllllllIIlIIllllIlllIIl[llllllllllllllllIIlIIllllIlllIII + 2] & 0xFF) << 16;
        return llllllllllllllllIIlIIllllIllIlll |= (llllllllllllllllIIlIIllllIlllIIl[llllllllllllllllIIlIIllllIlllIII + 3] & 0x7F) << 24;
    }

    private static Instrument read_xm_instrument(DataInput llllllllllllllllIIlIlIIIIIIIIllI) throws IOException {
        byte[] llllllllllllllllIIlIlIIIIIIIlIIl = new byte[4];
        llllllllllllllllIIlIlIIIIIIIIllI.readFully(llllllllllllllllIIlIlIIIIIIIlIIl);
        int llllllllllllllllIIlIlIIIIIIIlIll = FastTracker2.int_le(llllllllllllllllIIlIlIIIIIIIlIIl, 0);
        byte[] llllllllllllllllIIlIlIIIIIIIlIII = new byte[llllllllllllllllIIlIlIIIIIIIlIll];
        llllllllllllllllIIlIlIIIIIIIIllI.readFully(llllllllllllllllIIlIlIIIIIIIlIII, 4, llllllllllllllllIIlIlIIIIIIIlIll - 4);
        Instrument llllllllllllllllIIlIlIIIIIIIIlll = new Instrument();
        llllllllllllllllIIlIlIIIIIIIIlll.name = FastTracker2.ascii_text(llllllllllllllllIIlIlIIIIIIIlIII, 4, 22);
        int llllllllllllllllIIlIlIIIIIIIlIlI = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIIIIlIII, 27);
        if (llllllllllllllllIIlIlIIIIIIIlIlI > 0) {
            int llllllllllllllllIIlIlIIIIIIlIIIl;
            llllllllllllllllIIlIlIIIIIIIIlll.set_num_samples(llllllllllllllllIIlIlIIIIIIIlIlI);
            for (llllllllllllllllIIlIlIIIIIIlIIIl = 0; llllllllllllllllIIlIlIIIIIIlIIIl < 96; ++llllllllllllllllIIlIlIIIIIIlIIIl) {
                llllllllllllllllIIlIlIIIIIIIIlll.set_key_to_sample(llllllllllllllllIIlIlIIIIIIlIIIl + 1, llllllllllllllllIIlIlIIIIIIIlIII[33 + llllllllllllllllIIlIlIIIIIIlIIIl] & 0xFF);
            }
            Envelope llllllllllllllllIIlIlIIIIIIIllIl = new Envelope();
            int llllllllllllllllIIlIlIIIIIIlIIII = llllllllllllllllIIlIlIIIIIIIlIII[225] & 0xFF;
            llllllllllllllllIIlIlIIIIIIIllIl.set_num_points(llllllllllllllllIIlIlIIIIIIlIIII);
            for (llllllllllllllllIIlIlIIIIIIlIIIl = 0; llllllllllllllllIIlIlIIIIIIlIIIl < llllllllllllllllIIlIlIIIIIIlIIII; ++llllllllllllllllIIlIlIIIIIIlIIIl) {
                int llllllllllllllllIIlIlIIIIIIlIlIl = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIIIIlIII, 129 + llllllllllllllllIIlIlIIIIIIlIIIl * 4);
                int llllllllllllllllIIlIlIIIIIIlIlII = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIIIIlIII, 131 + llllllllllllllllIIlIlIIIIIIlIIIl * 4);
                llllllllllllllllIIlIlIIIIIIIllIl.set_point(llllllllllllllllIIlIlIIIIIIlIIIl, llllllllllllllllIIlIlIIIIIIlIlIl, llllllllllllllllIIlIlIIIIIIlIlII);
            }
            llllllllllllllllIIlIlIIIIIIIllIl.set_sustain_point(llllllllllllllllIIlIlIIIIIIIlIII[227] & 0xFF);
            llllllllllllllllIIlIlIIIIIIIllIl.set_loop_points(llllllllllllllllIIlIlIIIIIIIlIII[228] & 0xFF, llllllllllllllllIIlIlIIIIIIIlIII[229] & 0xFF);
            int llllllllllllllllIIlIlIIIIIIIllll = llllllllllllllllIIlIlIIIIIIIlIII[233] & 0xFF;
            llllllllllllllllIIlIlIIIIIIIIlll.volume_envelope_active = (llllllllllllllllIIlIlIIIIIIIllll & 1) == 1;
            llllllllllllllllIIlIlIIIIIIIllIl.sustain = (llllllllllllllllIIlIlIIIIIIIllll & 2) == 2;
            llllllllllllllllIIlIlIIIIIIIllIl.looped = (llllllllllllllllIIlIlIIIIIIIllll & 4) == 4;
            llllllllllllllllIIlIlIIIIIIIIlll.set_volume_envelope(llllllllllllllllIIlIlIIIIIIIllIl);
            llllllllllllllllIIlIlIIIIIIIllIl = new Envelope();
            llllllllllllllllIIlIlIIIIIIlIIII = llllllllllllllllIIlIlIIIIIIIlIII[226] & 0xFF;
            llllllllllllllllIIlIlIIIIIIIllIl.set_num_points(llllllllllllllllIIlIlIIIIIIlIIII);
            for (llllllllllllllllIIlIlIIIIIIlIIIl = 0; llllllllllllllllIIlIlIIIIIIlIIIl < llllllllllllllllIIlIlIIIIIIlIIII; ++llllllllllllllllIIlIlIIIIIIlIIIl) {
                int llllllllllllllllIIlIlIIIIIIlIIll = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIIIIlIII, 177 + llllllllllllllllIIlIlIIIIIIlIIIl * 4);
                int llllllllllllllllIIlIlIIIIIIlIIlI = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIIIIlIII, 179 + llllllllllllllllIIlIlIIIIIIlIIIl * 4);
                llllllllllllllllIIlIlIIIIIIIllIl.set_point(llllllllllllllllIIlIlIIIIIIlIIIl, llllllllllllllllIIlIlIIIIIIlIIll, llllllllllllllllIIlIlIIIIIIlIIlI);
            }
            llllllllllllllllIIlIlIIIIIIIllIl.set_sustain_point(llllllllllllllllIIlIlIIIIIIIlIII[230] & 0xFF);
            llllllllllllllllIIlIlIIIIIIIllIl.set_loop_points(llllllllllllllllIIlIlIIIIIIIlIII[231] & 0xFF, llllllllllllllllIIlIlIIIIIIIlIII[232] & 0xFF);
            llllllllllllllllIIlIlIIIIIIIllll = llllllllllllllllIIlIlIIIIIIIlIII[234] & 0xFF;
            llllllllllllllllIIlIlIIIIIIIIlll.panning_envelope_active = (llllllllllllllllIIlIlIIIIIIIllll & 1) == 1;
            llllllllllllllllIIlIlIIIIIIIllIl.sustain = (llllllllllllllllIIlIlIIIIIIIllll & 2) == 2;
            llllllllllllllllIIlIlIIIIIIIllIl.looped = (llllllllllllllllIIlIlIIIIIIIllll & 4) == 4;
            llllllllllllllllIIlIlIIIIIIIIlll.set_panning_envelope(llllllllllllllllIIlIlIIIIIIIllIl);
            llllllllllllllllIIlIlIIIIIIIIlll.vibrato_type = llllllllllllllllIIlIlIIIIIIIlIII[235] & 0xFF;
            llllllllllllllllIIlIlIIIIIIIIlll.vibrato_sweep = llllllllllllllllIIlIlIIIIIIIlIII[236] & 0xFF;
            llllllllllllllllIIlIlIIIIIIIIlll.vibrato_depth = llllllllllllllllIIlIlIIIIIIIlIII[237] & 0xFF;
            llllllllllllllllIIlIlIIIIIIIIlll.vibrato_rate = llllllllllllllllIIlIlIIIIIIIlIII[238] & 0xFF;
            llllllllllllllllIIlIlIIIIIIIIlll.volume_fade_out = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIIIIlIII, 239);
            byte[] llllllllllllllllIIlIlIIIIIIIlllI = new byte[llllllllllllllllIIlIlIIIIIIIlIlI * 40];
            llllllllllllllllIIlIlIIIIIIIIllI.readFully(llllllllllllllllIIlIlIIIIIIIlllI);
            for (llllllllllllllllIIlIlIIIIIIlIIIl = 0; llllllllllllllllIIlIlIIIIIIlIIIl < llllllllllllllllIIlIlIIIIIIIlIlI; ++llllllllllllllllIIlIlIIIIIIlIIIl) {
                llllllllllllllllIIlIlIIIIIIIIlll.set_sample(llllllllllllllllIIlIlIIIIIIlIIIl, FastTracker2.read_xm_sample(llllllllllllllllIIlIlIIIIIIIlllI, llllllllllllllllIIlIlIIIIIIlIIIl, llllllllllllllllIIlIlIIIIIIIIllI));
            }
        }
        return llllllllllllllllIIlIlIIIIIIIIlll;
    }

    public static Module load_xm(byte[] llllllllllllllllIIlIlIIIIlIlIlIl, DataInput llllllllllllllllIIlIlIIIIlIlIlII) throws IOException {
        int llllllllllllllllIIlIlIIIIlIIllII;
        if (!FastTracker2.is_xm(llllllllllllllllIIlIlIIIIlIlIlIl)) {
            throw new IllegalArgumentException("Not an XM file!");
        }
        int llllllllllllllllIIlIlIIIIlIlIIll = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIlIlIlIl, 58);
        if (llllllllllllllllIIlIlIIIIlIlIIll != 260) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Sorry, XM version ").append(llllllllllllllllIIlIlIIIIlIlIIll).append(" is not supported!")));
        }
        Module llllllllllllllllIIlIlIIIIlIIlIIl = new Module();
        llllllllllllllllIIlIlIIIIlIIlIIl.song_title = FastTracker2.ascii_text(llllllllllllllllIIlIlIIIIlIlIlIl, 17, 20);
        byte[] llllllllllllllllIIlIlIIIIlIIlIll = new byte[4];
        llllllllllllllllIIlIlIIIIlIlIlII.readFully(llllllllllllllllIIlIlIIIIlIIlIll);
        int llllllllllllllllIIlIlIIIIlIlIIlI = FastTracker2.int_le(llllllllllllllllIIlIlIIIIlIIlIll, 0);
        byte[] llllllllllllllllIIlIlIIIIlIIlIlI = new byte[llllllllllllllllIIlIlIIIIlIlIIlI];
        llllllllllllllllIIlIlIIIIlIlIlII.readFully(llllllllllllllllIIlIlIIIIlIIlIlI, 4, llllllllllllllllIIlIlIIIIlIlIIlI - 4);
        int llllllllllllllllIIlIlIIIIlIlIIIl = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIlIIlIlI, 4);
        llllllllllllllllIIlIlIIIIlIIlIIl.restart_sequence_index = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIlIIlIlI, 6);
        int llllllllllllllllIIlIlIIIIlIlIIII = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIlIIlIlI, 8);
        int llllllllllllllllIIlIlIIIIlIIllll = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIlIIlIlI, 10);
        int llllllllllllllllIIlIlIIIIlIIlllI = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIlIIlIlI, 12);
        int llllllllllllllllIIlIlIIIIlIIllIl = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIlIIlIlI, 14);
        llllllllllllllllIIlIlIIIIlIIlIIl.linear_periods = (llllllllllllllllIIlIlIIIIlIIllIl & 1) == 1;
        llllllllllllllllIIlIlIIIIlIIlIIl.global_volume = 64;
        llllllllllllllllIIlIlIIIIlIIlIIl.channel_gain = 12288;
        llllllllllllllllIIlIlIIIIlIIlIIl.default_speed = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIlIIlIlI, 16);
        llllllllllllllllIIlIlIIIIlIIlIIl.default_tempo = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIlIIlIlI, 18);
        llllllllllllllllIIlIlIIIIlIIlIIl.set_num_channels(llllllllllllllllIIlIlIIIIlIlIIII);
        for (llllllllllllllllIIlIlIIIIlIIllII = 0; llllllllllllllllIIlIlIIIIlIIllII < llllllllllllllllIIlIlIIIIlIlIIII; ++llllllllllllllllIIlIlIIIIlIIllII) {
            llllllllllllllllIIlIlIIIIlIIlIIl.set_initial_panning(llllllllllllllllIIlIlIIIIlIIllII, 128);
        }
        llllllllllllllllIIlIlIIIIlIIlIIl.set_sequence_length(llllllllllllllllIIlIlIIIIlIlIIIl);
        for (llllllllllllllllIIlIlIIIIlIIllII = 0; llllllllllllllllIIlIlIIIIlIIllII < llllllllllllllllIIlIlIIIIlIlIIIl; ++llllllllllllllllIIlIlIIIIlIIllII) {
            llllllllllllllllIIlIlIIIIlIIlIIl.set_sequence(llllllllllllllllIIlIlIIIIlIIllII, llllllllllllllllIIlIlIIIIlIIlIlI[20 + llllllllllllllllIIlIlIIIIlIIllII] & 0xFF);
        }
        llllllllllllllllIIlIlIIIIlIIlIIl.set_num_patterns(llllllllllllllllIIlIlIIIIlIIllll);
        for (llllllllllllllllIIlIlIIIIlIIllII = 0; llllllllllllllllIIlIlIIIIlIIllII < llllllllllllllllIIlIlIIIIlIIllll; ++llllllllllllllllIIlIlIIIIlIIllII) {
            llllllllllllllllIIlIlIIIIlIIlIIl.set_pattern(llllllllllllllllIIlIlIIIIlIIllII, FastTracker2.read_xm_pattern(llllllllllllllllIIlIlIIIIlIlIlII, llllllllllllllllIIlIlIIIIlIlIIII));
        }
        llllllllllllllllIIlIlIIIIlIIlIIl.set_num_instruments(llllllllllllllllIIlIlIIIIlIIlllI);
        for (llllllllllllllllIIlIlIIIIlIIllII = 1; llllllllllllllllIIlIlIIIIlIIllII <= llllllllllllllllIIlIlIIIIlIIlllI; ++llllllllllllllllIIlIlIIIIlIIllII) {
            llllllllllllllllIIlIlIIIIlIIlIIl.set_instrument(llllllllllllllllIIlIlIIIIlIIllII, FastTracker2.read_xm_instrument(llllllllllllllllIIlIlIIIIlIlIlII));
        }
        return llllllllllllllllIIlIlIIIIlIIlIIl;
    }

    public static boolean is_xm(byte[] llllllllllllllllIIlIlIIIIllIIlII) {
        String llllllllllllllllIIlIlIIIIllIIlIl = FastTracker2.ascii_text(llllllllllllllllIIlIlIIIIllIIlII, 0, 17);
        return llllllllllllllllIIlIlIIIIllIIlIl.equals("Extended Module: ");
    }

    private static Pattern read_xm_pattern(DataInput llllllllllllllllIIlIlIIIIIlIlIlI, int llllllllllllllllIIlIlIIIIIllIIlI) throws IOException {
        byte[] llllllllllllllllIIlIlIIIIIlIlllI = new byte[4];
        llllllllllllllllIIlIlIIIIIlIlIlI.readFully(llllllllllllllllIIlIlIIIIIlIlllI);
        int llllllllllllllllIIlIlIIIIIllIIIl = FastTracker2.int_le(llllllllllllllllIIlIlIIIIIlIlllI, 0);
        byte[] llllllllllllllllIIlIlIIIIIlIllIl = new byte[llllllllllllllllIIlIlIIIIIllIIIl];
        llllllllllllllllIIlIlIIIIIlIlIlI.readFully(llllllllllllllllIIlIlIIIIIlIllIl, 4, llllllllllllllllIIlIlIIIIIllIIIl - 4);
        byte llllllllllllllllIIlIlIIIIIllIIII = llllllllllllllllIIlIlIIIIIlIllIl[4];
        if (llllllllllllllllIIlIlIIIIIllIIII != 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Pattern packing type ").append(llllllllllllllllIIlIlIIIIIllIIII).append(" is not supported!")));
        }
        Pattern llllllllllllllllIIlIlIIIIIlIlIll = new Pattern();
        llllllllllllllllIIlIlIIIIIlIlIll.num_rows = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIIlIllIl, 5);
        int llllllllllllllllIIlIlIIIIIlIllll = FastTracker2.unsigned_short_le(llllllllllllllllIIlIlIIIIIlIllIl, 7);
        byte[] llllllllllllllllIIlIlIIIIIlIllII = new byte[llllllllllllllllIIlIlIIIIIlIllll];
        llllllllllllllllIIlIlIIIIIlIlIlI.readFully(llllllllllllllllIIlIlIIIIIlIllII);
        llllllllllllllllIIlIlIIIIIlIlIll.set_pattern_data(llllllllllllllllIIlIlIIIIIlIllII);
        return llllllllllllllllIIlIlIIIIIlIlIll;
    }

    public FastTracker2() {
        FastTracker2 llllllllllllllllIIlIlIIIIllIlIlI;
    }

    private static String ascii_text(byte[] llllllllllllllllIIlIIllllIlIlIIl, int llllllllllllllllIIlIIllllIlIIIlI, int llllllllllllllllIIlIIllllIlIIlll) {
        String llllllllllllllllIIlIIllllIlIIlII;
        byte[] llllllllllllllllIIlIIllllIlIIlIl = new byte[llllllllllllllllIIlIIllllIlIIlll];
        for (int llllllllllllllllIIlIIllllIlIIllI = 0; llllllllllllllllIIlIIllllIlIIllI < llllllllllllllllIIlIIllllIlIIlll; ++llllllllllllllllIIlIIllllIlIIllI) {
            int llllllllllllllllIIlIIllllIlIlIll = llllllllllllllllIIlIIllllIlIlIIl[llllllllllllllllIIlIIllllIlIIIlI + llllllllllllllllIIlIIllllIlIIllI];
            if (llllllllllllllllIIlIIllllIlIlIll < 32) {
                llllllllllllllllIIlIIllllIlIlIll = 32;
            }
            llllllllllllllllIIlIIllllIlIIlIl[llllllllllllllllIIlIIllllIlIIllI] = (byte)llllllllllllllllIIlIIllllIlIlIll;
        }
        try {
            llllllllllllllllIIlIIllllIlIIlII = new String(llllllllllllllllIIlIIllllIlIIlIl, 0, llllllllllllllllIIlIIllllIlIIlll, "ISO-8859-1");
        }
        catch (UnsupportedEncodingException llllllllllllllllIIlIIllllIlIlIlI) {
            llllllllllllllllIIlIIllllIlIIlII = "";
        }
        return llllllllllllllllIIlIIllllIlIIlII;
    }

    private static Sample read_xm_sample(byte[] llllllllllllllllIIlIIllllllIIlll, int llllllllllllllllIIlIIlllllIlIlIl, DataInput llllllllllllllllIIlIIllllllIIlIl) throws IOException {
        int llllllllllllllllIIlIIllllllIIlII = llllllllllllllllIIlIIlllllIlIlIl * 40;
        Sample llllllllllllllllIIlIIlllllIlIlll = new Sample();
        int llllllllllllllllIIlIIllllllIIIll = FastTracker2.int_le(llllllllllllllllIIlIIllllllIIlll, llllllllllllllllIIlIIllllllIIlII);
        int llllllllllllllllIIlIIllllllIIIlI = FastTracker2.int_le(llllllllllllllllIIlIIllllllIIlll, llllllllllllllllIIlIIllllllIIlII + 4);
        int llllllllllllllllIIlIIllllllIIIIl = FastTracker2.int_le(llllllllllllllllIIlIIllllllIIlll, llllllllllllllllIIlIIllllllIIlII + 8);
        llllllllllllllllIIlIIlllllIlIlll.volume = llllllllllllllllIIlIIllllllIIlll[llllllllllllllllIIlIIllllllIIlII + 12] & 0xFF;
        llllllllllllllllIIlIIlllllIlIlll.fine_tune = llllllllllllllllIIlIIllllllIIlll[llllllllllllllllIIlIIllllllIIlII + 13];
        llllllllllllllllIIlIIlllllIlIlll.set_panning = true;
        int llllllllllllllllIIlIIllllllIIIII = llllllllllllllllIIlIIllllllIIlll[llllllllllllllllIIlIIllllllIIlII + 14] & 0xFF;
        if ((llllllllllllllllIIlIIllllllIIIII & 3) == 0) {
            llllllllllllllllIIlIIllllllIIIIl = 0;
        }
        boolean llllllllllllllllIIlIIlllllIllIlI = (llllllllllllllllIIlIIllllllIIIII & 2) == 2;
        boolean llllllllllllllllIIlIIlllllIllIll = (llllllllllllllllIIlIIllllllIIIII & 0x10) == 16;
        llllllllllllllllIIlIIlllllIlIlll.panning = llllllllllllllllIIlIIllllllIIlll[llllllllllllllllIIlIIllllllIIlII + 15] & 0xFF;
        llllllllllllllllIIlIIlllllIlIlll.relative_note = llllllllllllllllIIlIIllllllIIlll[llllllllllllllllIIlIIllllllIIlII + 16];
        llllllllllllllllIIlIIlllllIlIlll.name = FastTracker2.ascii_text(llllllllllllllllIIlIIllllllIIlll, llllllllllllllllIIlIIllllllIIlII + 18, 22);
        byte[] llllllllllllllllIIlIIlllllIllIIl = new byte[llllllllllllllllIIlIIllllllIIIll];
        llllllllllllllllIIlIIllllllIIlIl.readFully(llllllllllllllllIIlIIlllllIllIIl);
        int llllllllllllllllIIlIIlllllIlllll = 0;
        int llllllllllllllllIIlIIlllllIllllI = 0;
        int llllllllllllllllIIlIIlllllIlllIl = 0;
        int llllllllllllllllIIlIIlllllIlllII = 0;
        if (llllllllllllllllIIlIIlllllIllIll) {
            short[] llllllllllllllllIIlIIllllllIlIII = new short[llllllllllllllllIIlIIllllllIIIll >> 1];
            while (llllllllllllllllIIlIIlllllIlllll < llllllllllllllllIIlIIlllllIllIIl.length) {
                llllllllllllllllIIlIIlllllIlllIl = llllllllllllllllIIlIIlllllIllIIl[llllllllllllllllIIlIIlllllIlllll] & 0xFF;
                llllllllllllllllIIlIIllllllIlIII[llllllllllllllllIIlIIlllllIllllI] = (short)(llllllllllllllllIIlIIlllllIlllII += (llllllllllllllllIIlIIlllllIlllIl |= (llllllllllllllllIIlIIlllllIllIIl[llllllllllllllllIIlIIlllllIlllll + 1] & 0xFF) << 8));
                llllllllllllllllIIlIIlllllIlllll += 2;
                ++llllllllllllllllIIlIIlllllIllllI;
            }
            llllllllllllllllIIlIIlllllIlIlll.set_sample_data(llllllllllllllllIIlIIllllllIlIII, llllllllllllllllIIlIIllllllIIIlI >> 1, llllllllllllllllIIlIIllllllIIIIl >> 1, llllllllllllllllIIlIIlllllIllIlI);
        } else {
            short[] llllllllllllllllIIlIIlllllIllIII = new short[llllllllllllllllIIlIIllllllIIIll];
            while (llllllllllllllllIIlIIlllllIlllll < llllllllllllllllIIlIIlllllIllIIl.length) {
                llllllllllllllllIIlIIlllllIlllIl = llllllllllllllllIIlIIlllllIllIIl[llllllllllllllllIIlIIlllllIlllll] & 0xFF;
                llllllllllllllllIIlIIlllllIllIII[llllllllllllllllIIlIIlllllIllllI] = (short)((llllllllllllllllIIlIIlllllIlllII += llllllllllllllllIIlIIlllllIlllIl) << 8);
                ++llllllllllllllllIIlIIlllllIlllll;
                ++llllllllllllllllIIlIIlllllIllllI;
            }
            llllllllllllllllIIlIIlllllIlIlll.set_sample_data(llllllllllllllllIIlIIlllllIllIII, llllllllllllllllIIlIIllllllIIIlI, llllllllllllllllIIlIIllllllIIIIl, llllllllllllllllIIlIIlllllIllIlI);
        }
        return llllllllllllllllIIlIIlllllIlIlll;
    }

    private static int unsigned_short_le(byte[] llllllllllllllllIIlIIlllllIIIIlI, int llllllllllllllllIIlIIlllllIIIIIl) {
        int llllllllllllllllIIlIIlllllIIIIII = llllllllllllllllIIlIIlllllIIIIlI[llllllllllllllllIIlIIlllllIIIIIl] & 0xFF;
        return llllllllllllllllIIlIIlllllIIIIII |= (llllllllllllllllIIlIIlllllIIIIlI[llllllllllllllllIIlIIlllllIIIIIl + 1] & 0xFF) << 8;
    }
}

