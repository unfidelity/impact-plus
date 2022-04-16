/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Envelope;
import ibxm.Sample;

public class Instrument {
    private /* synthetic */ int[] key_to_sample;
    public /* synthetic */ boolean panning_envelope_active;
    public /* synthetic */ String name;
    public /* synthetic */ int volume_fade_out;
    private /* synthetic */ Sample[] samples;
    public /* synthetic */ int vibrato_sweep;
    public /* synthetic */ boolean volume_envelope_active;
    private /* synthetic */ Envelope volume_envelope;
    private /* synthetic */ Envelope panning_envelope;
    public /* synthetic */ int vibrato_type;
    public /* synthetic */ int vibrato_depth;
    public /* synthetic */ int vibrato_rate;

    public Instrument() {
        Instrument lIIllllIlIIlIll;
        lIIllllIlIIlIll.name = "";
        lIIllllIlIIlIll.set_volume_envelope(new Envelope());
        lIIllllIlIIlIll.set_panning_envelope(new Envelope());
        lIIllllIlIIlIll.key_to_sample = new int[96];
        lIIllllIlIIlIll.set_num_samples(1);
    }

    public void set_num_samples(int lIIllllIIIlllll) {
        Instrument lIIllllIIIllllI;
        if (lIIllllIIIlllll < 1) {
            lIIllllIIIlllll = 1;
        }
        lIIllllIIIllllI.samples = new Sample[lIIllllIIIlllll];
        lIIllllIIIllllI.set_sample(0, null);
    }

    public void set_volume_envelope(Envelope lIIllllIlIIIIll) {
        if (lIIllllIlIIIIll != null) {
            lIIllllIlIIIlII.volume_envelope = lIIllllIlIIIIll;
        }
    }

    public Envelope get_panning_envelope() {
        Instrument lIIllllIIlllllI;
        return lIIllllIIlllllI.panning_envelope;
    }

    public void set_panning_envelope(Envelope lIIllllIIlllIlI) {
        if (lIIllllIIlllIlI != null) {
            lIIllllIIlllIIl.panning_envelope = lIIllllIIlllIlI;
        }
    }

    public Sample get_sample(int lIIllllIIIlIlIl) {
        Instrument lIIllllIIIlIllI;
        Sample lIIllllIIIlIlll = null;
        if (lIIllllIIIlIlIl >= 0 && lIIllllIIIlIlIl < lIIllllIIIlIllI.samples.length) {
            lIIllllIIIlIlll = lIIllllIIIlIllI.samples[lIIllllIIIlIlIl];
        }
        if (lIIllllIIIlIlll == null) {
            lIIllllIIIlIlll = lIIllllIIIlIllI.samples[0];
        }
        return lIIllllIIIlIlll;
    }

    public Sample get_sample_from_key(int lIIllllIIllIIII) {
        Instrument lIIllllIIllIIIl;
        int lIIllllIIllIIlI = 0;
        if (lIIllllIIllIIII > 0 && lIIllllIIllIIII <= lIIllllIIllIIIl.key_to_sample.length) {
            lIIllllIIllIIlI = lIIllllIIllIIIl.key_to_sample[lIIllllIIllIIII - 1];
        }
        return lIIllllIIllIIIl.get_sample(lIIllllIIllIIlI);
    }

    public void set_key_to_sample(int lIIllllIIlIlIlI, int lIIllllIIlIlIIl) {
        Instrument lIIllllIIlIlIII;
        if (lIIllllIIlIlIlI > 0 && lIIllllIIlIlIlI <= lIIllllIIlIlIII.key_to_sample.length) {
            lIIllllIIlIlIII.key_to_sample[lIIllllIIlIlIlI - 1] = lIIllllIIlIlIIl;
        }
    }

    public int get_num_samples() {
        Instrument lIIllllIIlIIIll;
        return lIIllllIIlIIIll.samples.length;
    }

    public void set_sample(int lIIllllIIIIllII, Sample lIIllllIIIIlIll) {
        Instrument lIIllllIIIIllIl;
        if (lIIllllIIIIllII >= 0 && lIIllllIIIIllII < lIIllllIIIIllIl.samples.length) {
            lIIllllIIIIllIl.samples[lIIllllIIIIllII] = lIIllllIIIIlIll;
        }
        if (lIIllllIIIIllIl.samples[0] == null) {
            lIIllllIIIIllIl.samples[0] = new Sample();
        }
    }

    public Envelope get_volume_envelope() {
        Instrument lIIllllIlIIIlll;
        return lIIllllIlIIIlll.volume_envelope;
    }
}

