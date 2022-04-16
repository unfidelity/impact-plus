/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Instrument;
import ibxm.Pattern;

public class Module {
    public /* synthetic */ boolean fast_volume_slides;
    private /* synthetic */ int[] sequence;
    public /* synthetic */ boolean linear_periods;
    private /* synthetic */ Pattern default_pattern;
    private /* synthetic */ Instrument[] instruments;
    public /* synthetic */ int restart_sequence_index;
    public /* synthetic */ int default_tempo;
    private /* synthetic */ Instrument default_instrument;
    public /* synthetic */ int global_volume;
    private /* synthetic */ int[] initial_panning;
    private /* synthetic */ Pattern[] patterns;
    public /* synthetic */ int default_speed;
    public /* synthetic */ String song_title;
    public /* synthetic */ int channel_gain;

    public Pattern get_pattern(int lllllllllllllllIlllllIllIIIllIlI) {
        Module lllllllllllllllIlllllIllIIIllIll;
        Pattern lllllllllllllllIlllllIllIIIlllII = null;
        if (lllllllllllllllIlllllIllIIIllIlI >= 0 && lllllllllllllllIlllllIllIIIllIlI < lllllllllllllllIlllllIllIIIllIll.patterns.length) {
            lllllllllllllllIlllllIllIIIlllII = lllllllllllllllIlllllIllIIIllIll.patterns[lllllllllllllllIlllllIllIIIllIlI];
        }
        if (lllllllllllllllIlllllIllIIIlllII == null) {
            lllllllllllllllIlllllIllIIIlllII = lllllllllllllllIlllllIllIIIllIll.default_pattern;
        }
        return lllllllllllllllIlllllIllIIIlllII;
    }

    public void set_instrument(int lllllllllllllllIlllllIlIllllIllI, Instrument lllllllllllllllIlllllIlIlllllIII) {
        Module lllllllllllllllIlllllIlIllllIlll;
        if (lllllllllllllllIlllllIlIllllIllI > 0 && lllllllllllllllIlllllIlIllllIllI <= lllllllllllllllIlllllIlIllllIlll.instruments.length) {
            lllllllllllllllIlllllIlIllllIlll.instruments[lllllllllllllllIlllllIlIllllIllI - 1] = lllllllllllllllIlllllIlIlllllIII;
        }
    }

    public Instrument get_instrument(int lllllllllllllllIlllllIlIllllllll) {
        Module lllllllllllllllIlllllIllIIIIIIll;
        Instrument lllllllllllllllIlllllIllIIIIIIIl = null;
        if (lllllllllllllllIlllllIlIllllllll > 0 && lllllllllllllllIlllllIlIllllllll <= lllllllllllllllIlllllIllIIIIIIll.instruments.length) {
            lllllllllllllllIlllllIllIIIIIIIl = lllllllllllllllIlllllIllIIIIIIll.instruments[lllllllllllllllIlllllIlIllllllll - 1];
        }
        if (lllllllllllllllIlllllIllIIIIIIIl == null) {
            lllllllllllllllIlllllIllIIIIIIIl = lllllllllllllllIlllllIllIIIIIIll.default_instrument;
        }
        return lllllllllllllllIlllllIllIIIIIIIl;
    }

    public int get_num_patterns() {
        Module lllllllllllllllIlllllIllIIllIIIl;
        return lllllllllllllllIlllllIllIIllIIIl.patterns.length;
    }

    public Pattern get_pattern_from_sequence(int lllllllllllllllIlllllIllIIlIIllI) {
        Module lllllllllllllllIlllllIllIIlIIlll;
        Pattern lllllllllllllllIlllllIllIIlIIlIl = lllllllllllllllIlllllIllIIlIIlll.default_pattern;
        if (lllllllllllllllIlllllIllIIlIIllI >= 0 && lllllllllllllllIlllllIllIIlIIllI < lllllllllllllllIlllllIllIIlIIlll.sequence.length) {
            lllllllllllllllIlllllIllIIlIIlIl = lllllllllllllllIlllllIllIIlIIlll.get_pattern(lllllllllllllllIlllllIllIIlIIlll.sequence[lllllllllllllllIlllllIllIIlIIllI]);
        }
        return lllllllllllllllIlllllIllIIlIIlIl;
    }

    public void set_initial_panning(int lllllllllllllllIlllllIllIlIIlIlI, int lllllllllllllllIlllllIllIlIIIllI) {
        Module lllllllllllllllIlllllIllIlIIlIll;
        if (lllllllllllllllIlllllIllIlIIlIlI >= 0 && lllllllllllllllIlllllIllIlIIlIlI < lllllllllllllllIlllllIllIlIIlIll.initial_panning.length) {
            lllllllllllllllIlllllIllIlIIlIll.initial_panning[lllllllllllllllIlllllIllIlIIlIlI] = lllllllllllllllIlllllIllIlIIIllI;
        }
    }

    public void set_num_patterns(int lllllllllllllllIlllllIllIIlIllIl) {
        if (lllllllllllllllIlllllIllIIlIllIl < 0) {
            lllllllllllllllIlllllIllIIlIllIl = 0;
        }
        lllllllllllllllIlllllIllIIlIllII.patterns = new Pattern[lllllllllllllllIlllllIllIIlIllIl];
    }

    public int get_initial_panning(int lllllllllllllllIlllllIllIlIlIIII) {
        Module lllllllllllllllIlllllIllIlIlIlII;
        int lllllllllllllllIlllllIllIlIlIIlI = 128;
        if (lllllllllllllllIlllllIllIlIlIIII >= 0 && lllllllllllllllIlllllIllIlIlIIII < lllllllllllllllIlllllIllIlIlIlII.initial_panning.length) {
            lllllllllllllllIlllllIllIlIlIIlI = lllllllllllllllIlllllIllIlIlIlII.initial_panning[lllllllllllllllIlllllIllIlIlIIII];
        }
        return lllllllllllllllIlllllIllIlIlIIlI;
    }

    public Module() {
        Module lllllllllllllllIlllllIllIllIlIIl;
        lllllllllllllllIlllllIllIllIlIIl.song_title = "ibxm alpha 45 (c)2006 mumart@gmail.com";
        lllllllllllllllIlllllIllIllIlIIl.set_num_channels(1);
        lllllllllllllllIlllllIllIllIlIIl.set_sequence_length(1);
        lllllllllllllllIlllllIllIllIlIIl.set_num_patterns(0);
        lllllllllllllllIlllllIllIllIlIIl.set_num_instruments(0);
        lllllllllllllllIlllllIllIllIlIIl.default_pattern = new Pattern();
        lllllllllllllllIlllllIllIllIlIIl.default_instrument = new Instrument();
    }

    public void set_pattern(int lllllllllllllllIlllllIllIIIlIIIl, Pattern lllllllllllllllIlllllIllIIIlIIll) {
        Module lllllllllllllllIlllllIllIIIlIlIl;
        if (lllllllllllllllIlllllIllIIIlIIIl >= 0 && lllllllllllllllIlllllIllIIIlIIIl < lllllllllllllllIlllllIllIIIlIlIl.patterns.length) {
            lllllllllllllllIlllllIllIIIlIlIl.patterns[lllllllllllllllIlllllIllIIIlIIIl] = lllllllllllllllIlllllIllIIIlIIll;
        }
    }

    public int get_num_channels() {
        Module lllllllllllllllIlllllIllIllIIlIl;
        return lllllllllllllllIlllllIllIllIIlIl.initial_panning.length;
    }

    public void set_num_channels(int lllllllllllllllIlllllIllIlIlllII) {
        if (lllllllllllllllIlllllIllIlIlllII < 1) {
            lllllllllllllllIlllllIllIlIlllII = 1;
        }
        lllllllllllllllIlllllIllIlIlllIl.initial_panning = new int[lllllllllllllllIlllllIllIlIlllII];
    }

    public void set_sequence_length(int lllllllllllllllIlllllIllIIllllIl) {
        if (lllllllllllllllIlllllIllIIllllIl < 0) {
            lllllllllllllllIlllllIllIIllllIl = 0;
        }
        lllllllllllllllIlllllIllIIlllllI.sequence = new int[lllllllllllllllIlllllIllIIllllIl];
    }

    public void set_sequence(int lllllllllllllllIlllllIllIIllIlIl, int lllllllllllllllIlllllIllIIllIlll) {
        Module lllllllllllllllIlllllIllIIllIllI;
        if (lllllllllllllllIlllllIllIIllIlIl >= 0 && lllllllllllllllIlllllIllIIllIlIl < lllllllllllllllIlllllIllIIllIllI.sequence.length) {
            lllllllllllllllIlllllIllIIllIllI.sequence[lllllllllllllllIlllllIllIIllIlIl] = lllllllllllllllIlllllIllIIllIlll;
        }
    }

    public int get_sequence_length() {
        Module lllllllllllllllIlllllIllIlIIIlII;
        return lllllllllllllllIlllllIllIlIIIlII.sequence.length;
    }

    public void set_num_instruments(int lllllllllllllllIlllllIllIIIIlIIl) {
        if (lllllllllllllllIlllllIllIIIIlIIl < 0) {
            lllllllllllllllIlllllIllIIIIlIIl = 0;
        }
        lllllllllllllllIlllllIllIIIIlIlI.instruments = new Instrument[lllllllllllllllIlllllIllIIIIlIIl];
    }

    public int get_num_instruments() {
        Module lllllllllllllllIlllllIllIIIIllIl;
        return lllllllllllllllIlllllIllIIIIllIl.instruments.length;
    }
}

