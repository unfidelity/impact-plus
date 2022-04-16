/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Instrument;
import ibxm.LogTable;
import ibxm.Module;
import ibxm.Pattern;
import ibxm.Sample;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ProTracker {
    private static int calculate_num_patterns(byte[] lIIIlllllIlIlII) {
        int lIIIlllllIlIllI = 0;
        for (int lIIIlllllIlIlIl = 0; lIIIlllllIlIlIl < 128; ++lIIIlllllIlIlIl) {
            int lIIIlllllIllIII = lIIIlllllIlIlII[952 + lIIIlllllIlIlIl] & 0x7F;
            if (lIIIlllllIllIII < lIIIlllllIlIllI) continue;
            lIIIlllllIlIllI = lIIIlllllIllIII + 1;
        }
        return lIIIlllllIlIllI;
    }

    public static Module load_mod(byte[] lIIIllllllIlIII, DataInput lIIIlllllllIIlI) throws IOException {
        int lIIIlllllllIIIl = ProTracker.calculate_num_channels(lIIIllllllIlIII);
        if (lIIIlllllllIIIl < 1) {
            throw new IllegalArgumentException("ProTracker: Unrecognised module format!");
        }
        Module lIIIllllllIlIIl = new Module();
        lIIIllllllIlIIl.song_title = ProTracker.ascii_text(lIIIllllllIlIII, 0, 20);
        lIIIllllllIlIIl.global_volume = 64;
        lIIIllllllIlIIl.channel_gain = 12288;
        lIIIllllllIlIIl.default_speed = 6;
        lIIIllllllIlIIl.default_tempo = 125;
        lIIIllllllIlIIl.set_num_channels(lIIIlllllllIIIl);
        for (int lIIIlllllllIIII = 0; lIIIlllllllIIII < lIIIlllllllIIIl; ++lIIIlllllllIIII) {
            int lIIIlllllllIlII = 64;
            if ((lIIIlllllllIIII & 3) == 1 || (lIIIlllllllIIII & 3) == 2) {
                lIIIlllllllIlII = 192;
            }
            lIIIllllllIlIIl.set_initial_panning(lIIIlllllllIIII, lIIIlllllllIlII);
        }
        int lIIIllllllIlllI = lIIIllllllIlIII[951] & 0x7F;
        int lIIIllllllIllll = lIIIllllllIlIII[950] & 0x7F;
        if (lIIIllllllIlllI >= lIIIllllllIllll) {
            lIIIllllllIlllI = 0;
        }
        lIIIllllllIlIIl.restart_sequence_index = lIIIllllllIlllI;
        lIIIllllllIlIIl.set_sequence_length(lIIIllllllIllll);
        for (int lIIIllllllIllIl = 0; lIIIllllllIllIl < lIIIllllllIllll; ++lIIIllllllIllIl) {
            lIIIllllllIlIIl.set_sequence(lIIIllllllIllIl, lIIIllllllIlIII[952 + lIIIllllllIllIl] & 0x7F);
        }
        int lIIIllllllIllII = ProTracker.calculate_num_patterns(lIIIllllllIlIII);
        lIIIllllllIlIIl.set_num_patterns(lIIIllllllIllII);
        for (int lIIIllllllIlIll = 0; lIIIllllllIlIll < lIIIllllllIllII; ++lIIIllllllIlIll) {
            lIIIllllllIlIIl.set_pattern(lIIIllllllIlIll, ProTracker.read_mod_pattern(lIIIlllllllIIlI, lIIIlllllllIIIl));
        }
        lIIIllllllIlIIl.set_num_instruments(31);
        for (int lIIIllllllIlIlI = 1; lIIIllllllIlIlI <= 31; ++lIIIllllllIlIlI) {
            lIIIllllllIlIIl.set_instrument(lIIIllllllIlIlI, ProTracker.read_mod_instrument(lIIIllllllIlIII, lIIIllllllIlIlI, lIIIlllllllIIlI));
        }
        return lIIIllllllIlIIl;
    }

    public ProTracker() {
        ProTracker lIIlIIIIIIIIlll;
    }

    private static String ascii_text(byte[] lIIIlllIlIllllI, int lIIIlllIlIlllIl, int lIIIlllIllIIIlI) {
        String lIIIlllIlIlllll;
        byte[] lIIIlllIllIIIII = new byte[lIIIlllIllIIIlI];
        for (int lIIIlllIllIIIIl = 0; lIIIlllIllIIIIl < lIIIlllIllIIIlI; ++lIIIlllIllIIIIl) {
            int lIIIlllIllIIllI = lIIIlllIlIllllI[lIIIlllIlIlllIl + lIIIlllIllIIIIl];
            if (lIIIlllIllIIllI < 32) {
                lIIIlllIllIIllI = 32;
            }
            lIIIlllIllIIIII[lIIIlllIllIIIIl] = (byte)lIIIlllIllIIllI;
        }
        try {
            lIIIlllIlIlllll = new String(lIIIlllIllIIIII, 0, lIIIlllIllIIIlI, "ISO-8859-1");
        }
        catch (UnsupportedEncodingException lIIIlllIllIIlIl) {
            lIIIlllIlIlllll = "";
        }
        return lIIIlllIlIlllll;
    }

    public static boolean is_mod(byte[] lIIlIIIIIIIIlII) {
        boolean lIIlIIIIIIIIIll = false;
        if (ProTracker.calculate_num_channels(lIIlIIIIIIIIlII) > 0) {
            lIIlIIIIIIIIIll = true;
        }
        return lIIlIIIIIIIIIll;
    }

    private static byte to_key(int lIIIlllIllllIlI) {
        int lIIIlllIllllIll;
        if (lIIIlllIllllIlI < 32) {
            boolean lIIIlllIlllllll = false;
        } else {
            int lIIIlllIlllllIl = LogTable.log_2(7256) - LogTable.log_2(lIIIlllIllllIlI);
            if (lIIIlllIlllllIl < 0) {
                boolean lIIIlllIllllllI = false;
            } else {
                lIIIlllIllllIll = lIIIlllIlllllIl * 12;
                lIIIlllIllllIll >>= 14;
                lIIIlllIllllIll = (lIIIlllIllllIll >> 1) + (lIIIlllIllllIll & 1);
            }
        }
        return (byte)lIIIlllIllllIll;
    }

    private static Pattern read_mod_pattern(DataInput lIIIllllIlllIll, int lIIIllllIllIIll) throws IOException {
        Pattern lIIIllllIllIlll = new Pattern();
        lIIIllllIllIlll.num_rows = 64;
        byte[] lIIIllllIllIllI = new byte[64 * lIIIllllIllIIll * 4];
        byte[] lIIIllllIllIlIl = new byte[64 * lIIIllllIllIIll * 5];
        lIIIllllIlllIll.readFully(lIIIllllIllIllI);
        int lIIIllllIlllIIl = 0;
        int lIIIllllIlllIII = 0;
        while (lIIIllllIlllIIl < lIIIllllIllIllI.length) {
            int lIIIllllIllllll = (lIIIllllIllIllI[lIIIllllIlllIIl] & 0xF) << 8;
            lIIIllllIllIlIl[lIIIllllIlllIII] = ProTracker.to_key(lIIIllllIllllll |= lIIIllllIllIllI[lIIIllllIlllIIl + 1] & 0xFF);
            int lIIIllllIlllllI = lIIIllllIllIllI[lIIIllllIlllIIl] & 0x10;
            lIIIllllIllIlIl[lIIIllllIlllIII + 1] = (byte)(lIIIllllIlllllI |= (lIIIllllIllIllI[lIIIllllIlllIIl + 2] & 0xF0) >> 4);
            int lIIIllllIllllIl = lIIIllllIllIllI[lIIIllllIlllIIl + 2] & 0xF;
            int lIIIllllIllllII = lIIIllllIllIllI[lIIIllllIlllIIl + 3] & 0xFF;
            if (lIIIllllIllllIl == 8 && lIIIllllIllIIll == 4) {
                lIIIllllIllllIl = 0;
                lIIIllllIllllII = 0;
            }
            if (lIIIllllIllllIl == 10 && lIIIllllIllllII == 0) {
                lIIIllllIllllIl = 0;
            }
            if (lIIIllllIllllIl == 5 && lIIIllllIllllII == 0) {
                lIIIllllIllllIl = 3;
            }
            if (lIIIllllIllllIl == 6 && lIIIllllIllllII == 0) {
                lIIIllllIllllIl = 4;
            }
            lIIIllllIllIlIl[lIIIllllIlllIII + 3] = (byte)lIIIllllIllllIl;
            lIIIllllIllIlIl[lIIIllllIlllIII + 4] = (byte)lIIIllllIllllII;
            lIIIllllIlllIIl += 4;
            lIIIllllIlllIII += 5;
        }
        lIIIllllIllIlll.set_pattern_data(lIIIllllIllIlIl);
        return lIIIllllIllIlll;
    }

    private static int calculate_num_channels(byte[] lIIIlllllIIllII) {
        int lIIIlllllIIllIl;
        switch (lIIIlllllIIllII[1082] << 8 | lIIIlllllIIllII[1083]) {
            case 19233: 
            case 19246: 
            case 21550: 
            case 21556: {
                lIIIlllllIIllIl = 4;
                break;
            }
            case 18510: {
                lIIIlllllIIllIl = lIIIlllllIIllII[1080] - 48;
                break;
            }
            case 17224: {
                lIIIlllllIIllIl = (lIIIlllllIIllII[1080] - 48) * 10 + (lIIIlllllIIllII[1081] - 48);
                break;
            }
            default: {
                lIIIlllllIIllIl = 0;
            }
        }
        return lIIIlllllIIllIl;
    }

    private static Instrument read_mod_instrument(byte[] lIIIllllIIIllll, int lIIIllllIIllIlI, DataInput lIIIllllIIllIIl) throws IOException {
        int lIIIllllIIllIII = (lIIIllllIIllIlI - 1) * 30 + 20;
        Instrument lIIIllllIIlIIll = new Instrument();
        lIIIllllIIlIIll.name = ProTracker.ascii_text(lIIIllllIIIllll, lIIIllllIIllIII, 22);
        Sample lIIIllllIIlIIlI = new Sample();
        lIIIllllIIlIIlI.c2_rate = 8287;
        int lIIIllllIIlIlll = ProTracker.unsigned_short_be(lIIIllllIIIllll, lIIIllllIIllIII + 22) << 1;
        lIIIllllIIlIIlI.fine_tune = (lIIIllllIIIllll[lIIIllllIIllIII + 24] & 0xF) << 4;
        if (lIIIllllIIlIIlI.fine_tune > 127) {
            lIIIllllIIlIIlI.fine_tune -= 256;
        }
        lIIIllllIIlIIlI.volume = lIIIllllIIIllll[lIIIllllIIllIII + 25] & 0x7F;
        int lIIIllllIIlIllI = ProTracker.unsigned_short_be(lIIIllllIIIllll, lIIIllllIIllIII + 26) << 1;
        int lIIIllllIIlIlIl = ProTracker.unsigned_short_be(lIIIllllIIIllll, lIIIllllIIllIII + 28) << 1;
        if (lIIIllllIIlIlIl < 4) {
            lIIIllllIIlIlIl = 0;
        }
        byte[] lIIIllllIIlIIIl = new byte[lIIIllllIIlIlll];
        short[] lIIIllllIIlIIII = new short[lIIIllllIIlIlll];
        try {
            lIIIllllIIllIIl.readFully(lIIIllllIIlIIIl);
        }
        catch (EOFException lIIIllllIIlllII) {
            System.out.println(String.valueOf(new StringBuilder().append("ProTracker: Instrument ").append(lIIIllllIIllIlI).append(" has samples missing.")));
        }
        for (int lIIIllllIIlIlII = 0; lIIIllllIIlIlII < lIIIllllIIlIIIl.length; ++lIIIllllIIlIlII) {
            lIIIllllIIlIIII[lIIIllllIIlIlII] = (short)(lIIIllllIIlIIIl[lIIIllllIIlIlII] << 8);
        }
        lIIIllllIIlIIlI.set_sample_data(lIIIllllIIlIIII, lIIIllllIIlIllI, lIIIllllIIlIlIl, false);
        lIIIllllIIlIIll.set_num_samples(1);
        lIIIllllIIlIIll.set_sample(0, lIIIllllIIlIIlI);
        return lIIIllllIIlIIll;
    }

    private static int unsigned_short_be(byte[] lIIIlllIlllIlII, int lIIIlllIlllIIll) {
        int lIIIlllIlllIIlI = (lIIIlllIlllIlII[lIIIlllIlllIIll] & 0xFF) << 8;
        return lIIIlllIlllIIlI |= lIIIlllIlllIlII[lIIIlllIlllIIll + 1] & 0xFF;
    }
}

