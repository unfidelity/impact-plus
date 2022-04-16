/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

public class Sample {
    private static final /* synthetic */ int OVERLAP;
    private /* synthetic */ int loop_length;
    private static final /* synthetic */ int INTERP_SHIFT;
    private /* synthetic */ short[] sample_data;
    public /* synthetic */ boolean set_panning;
    public /* synthetic */ int c2_rate;
    private static final /* synthetic */ int POINT_SHIFT;
    private static final /* synthetic */ short[] sinc_table;
    private static final /* synthetic */ int POINTS;
    private static final /* synthetic */ int INTERP_BITMASK;
    public /* synthetic */ int fine_tune;
    public /* synthetic */ int panning;
    public /* synthetic */ int volume;
    public /* synthetic */ String name;
    public /* synthetic */ int relative_note;
    private /* synthetic */ int loop_start;

    public void resample_linear(int llllllllllllllllllIllllllIIllIII, int llllllllllllllllllIllllllIIlIlll, int llllllllllllllllllIllllllIIlIllI, int llllllllllllllllllIllllllIIIIIll, int llllllllllllllllllIllllllIIIIIlI, int[] llllllllllllllllllIllllllIIlIIll, int llllllllllllllllllIllllllIIIIIII, int llllllllllllllllllIlllllIlllllll) {
        Sample llllllllllllllllllIllllllIIllIIl;
        llllllllllllllllllIllllllIIllIII += 8;
        int llllllllllllllllllIllllllIIIlIlI = llllllllllllllllllIllllllIIllIIl.loop_start + llllllllllllllllllIllllllIIllIIl.loop_length - 1;
        int llllllllllllllllllIllllllIIIlllI = llllllllllllllllllIllllllIIIIIII << 1;
        int llllllllllllllllllIllllllIIIllII = llllllllllllllllllIllllllIIIIIII + llllllllllllllllllIlllllIlllllll - 1 << 1;
        while (llllllllllllllllllIllllllIIIlllI <= llllllllllllllllllIllllllIIIllII) {
            if (llllllllllllllllllIllllllIIllIII > llllllllllllllllllIllllllIIIlIlI) {
                if (llllllllllllllllllIllllllIIllIIl.loop_length <= 1) break;
                llllllllllllllllllIllllllIIllIII = llllllllllllllllllIllllllIIllIIl.loop_start + (llllllllllllllllllIllllllIIllIII - llllllllllllllllllIllllllIIllIIl.loop_start) % llllllllllllllllllIllllllIIllIIl.loop_length;
            }
            int llllllllllllllllllIllllllIIllIlI = llllllllllllllllllIllllllIIllIIl.sample_data[llllllllllllllllllIllllllIIllIII];
            llllllllllllllllllIllllllIIllIlI += (llllllllllllllllllIllllllIIllIIl.sample_data[llllllllllllllllllIllllllIIllIII + 1] - llllllllllllllllllIllllllIIllIlI) * llllllllllllllllllIllllllIIlIlll >> 15;
            int n = llllllllllllllllllIllllllIIIlllI;
            llllllllllllllllllIllllllIIlIIll[n] = llllllllllllllllllIllllllIIlIIll[n] + (llllllllllllllllllIllllllIIllIlI * llllllllllllllllllIllllllIIIIIll >> 15);
            int n2 = llllllllllllllllllIllllllIIIlllI + 1;
            llllllllllllllllllIllllllIIlIIll[n2] = llllllllllllllllllIllllllIIlIIll[n2] + (llllllllllllllllllIllllllIIllIlI * llllllllllllllllllIllllllIIIIIlI >> 15);
            llllllllllllllllllIllllllIIIlllI += 2;
            llllllllllllllllllIllllllIIllIII += (llllllllllllllllllIllllllIIlIlll += llllllllllllllllllIllllllIIlIllI) >> 15;
            llllllllllllllllllIllllllIIlIlll &= Short.MAX_VALUE;
        }
    }

    public void resample_nearest(int llllllllllllllllllIllllllIllIllI, int llllllllllllllllllIlllllllIIIIIl, int llllllllllllllllllIllllllIllIlII, int llllllllllllllllllIllllllIllllll, int llllllllllllllllllIllllllIllIIlI, int[] llllllllllllllllllIllllllIllIIIl, int llllllllllllllllllIllllllIllIIII, int llllllllllllllllllIllllllIlllIll) {
        Sample llllllllllllllllllIllllllIllIlll;
        llllllllllllllllllIllllllIllIllI += 8;
        int llllllllllllllllllIllllllIlllIII = llllllllllllllllllIllllllIllIlll.loop_start + llllllllllllllllllIllllllIllIlll.loop_length - 1;
        int llllllllllllllllllIllllllIlllIlI = llllllllllllllllllIllllllIllIIII << 1;
        int llllllllllllllllllIllllllIlllIIl = llllllllllllllllllIllllllIllIIII + llllllllllllllllllIllllllIlllIll - 1 << 1;
        while (llllllllllllllllllIllllllIlllIlI <= llllllllllllllllllIllllllIlllIIl) {
            if (llllllllllllllllllIllllllIllIllI > llllllllllllllllllIllllllIlllIII) {
                if (llllllllllllllllllIllllllIllIlll.loop_length <= 1) break;
                llllllllllllllllllIllllllIllIllI = llllllllllllllllllIllllllIllIlll.loop_start + (llllllllllllllllllIllllllIllIllI - llllllllllllllllllIllllllIllIlll.loop_start) % llllllllllllllllllIllllllIllIlll.loop_length;
            }
            int n = llllllllllllllllllIllllllIlllIlI;
            llllllllllllllllllIllllllIllIIIl[n] = llllllllllllllllllIllllllIllIIIl[n] + (llllllllllllllllllIllllllIllIlll.sample_data[llllllllllllllllllIllllllIllIllI] * llllllllllllllllllIllllllIllllll >> 15);
            int n2 = llllllllllllllllllIllllllIlllIlI + 1;
            llllllllllllllllllIllllllIllIIIl[n2] = llllllllllllllllllIllllllIllIIIl[n2] + (llllllllllllllllllIllllllIllIlll.sample_data[llllllllllllllllllIllllllIllIllI] * llllllllllllllllllIllllllIllIIlI >> 15);
            llllllllllllllllllIllllllIlllIlI += 2;
            llllllllllllllllllIllllllIllIllI += (llllllllllllllllllIlllllllIIIIIl += llllllllllllllllllIllllllIllIlII) >> 15;
            llllllllllllllllllIlllllllIIIIIl &= Short.MAX_VALUE;
        }
    }

    public void resample_sinc(int llllllllllllllllllIlllllIIIllllI, int llllllllllllllllllIlllllIIIlIIII, int llllllllllllllllllIlllllIIIIllll, int llllllllllllllllllIlllllIIIllIlI, int llllllllllllllllllIlllllIIIIllIl, int[] llllllllllllllllllIlllllIIIllIII, int llllllllllllllllllIlllllIIIlIlll, int llllllllllllllllllIlllllIIIIlIlI) {
        Sample llllllllllllllllllIlllllIIIlIIlI;
        int llllllllllllllllllIlllllIIIlIIll = llllllllllllllllllIlllllIIIlIIlI.loop_start + llllllllllllllllllIlllllIIIlIIlI.loop_length - 1;
        int llllllllllllllllllIlllllIIIlIlIl = llllllllllllllllllIlllllIIIlIlll << 1;
        int llllllllllllllllllIlllllIIIlIlII = llllllllllllllllllIlllllIIIlIlll + llllllllllllllllllIlllllIIIIlIlI - 1 << 1;
        while (llllllllllllllllllIlllllIIIlIlIl <= llllllllllllllllllIlllllIIIlIlII) {
            if (llllllllllllllllllIlllllIIIllllI > llllllllllllllllllIlllllIIIlIIll) {
                if (llllllllllllllllllIlllllIIIlIIlI.loop_length <= 1) break;
                llllllllllllllllllIlllllIIIllllI = llllllllllllllllllIlllllIIIlIIlI.loop_start + (llllllllllllllllllIlllllIIIllllI - llllllllllllllllllIlllllIIIlIIlI.loop_start) % llllllllllllllllllIlllllIIIlIIlI.loop_length;
            }
            int llllllllllllllllllIlllllIIlIIlIl = llllllllllllllllllIlllllIIIlIIII >> 11 << 4;
            int llllllllllllllllllIlllllIIlIIlII = sinc_table[llllllllllllllllllIlllllIIlIIlIl + 0] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 0] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 1] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 1] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 2] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 2] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 3] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 3] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 4] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 4] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 5] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 5] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 6] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 6] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 7] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 7] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 8] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 8] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 9] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 9] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 10] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 10] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 11] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 11] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 12] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 12] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 13] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 13] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 14] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 14] >> 15;
            llllllllllllllllllIlllllIIlIIlII += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 15] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 15] >> 15;
            int llllllllllllllllllIlllllIIlIIIll = sinc_table[llllllllllllllllllIlllllIIlIIlIl + 16] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 0] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 17] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 1] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 18] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 2] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 19] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 3] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 20] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 4] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 21] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 5] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 22] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 6] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 23] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 7] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 24] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 8] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 25] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 9] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 26] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 10] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 27] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 11] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 28] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 12] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 29] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 13] >> 15;
            llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 30] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 14] >> 15;
            int llllllllllllllllllIlllllIIlIIIlI = llllllllllllllllllIlllllIIlIIlII + (((llllllllllllllllllIlllllIIlIIIll += sinc_table[llllllllllllllllllIlllllIIlIIlIl + 31] * llllllllllllllllllIlllllIIIlIIlI.sample_data[llllllllllllllllllIlllllIIIllllI + 15] >> 15) - llllllllllllllllllIlllllIIlIIlII) * (llllllllllllllllllIlllllIIIlIIII & 0x7FF) >> 11);
            int n = llllllllllllllllllIlllllIIIlIlIl;
            llllllllllllllllllIlllllIIIllIII[n] = llllllllllllllllllIlllllIIIllIII[n] + (llllllllllllllllllIlllllIIlIIIlI * llllllllllllllllllIlllllIIIllIlI >> 15);
            int n2 = llllllllllllllllllIlllllIIIlIlIl + 1;
            llllllllllllllllllIlllllIIIllIII[n2] = llllllllllllllllllIlllllIIIllIII[n2] + (llllllllllllllllllIlllllIIlIIIlI * llllllllllllllllllIlllllIIIIllIl >> 15);
            llllllllllllllllllIlllllIIIlIlIl += 2;
            llllllllllllllllllIlllllIIIllllI += (llllllllllllllllllIlllllIIIlIIII += llllllllllllllllllIlllllIIIIllll) >> 15;
            llllllllllllllllllIlllllIIIlIIII &= Short.MAX_VALUE;
        }
    }

    public boolean has_finished(int llllllllllllllllllIllllIlllIllIl) {
        Sample llllllllllllllllllIllllIlllIllll;
        boolean llllllllllllllllllIllllIllllIIIl = false;
        if (llllllllllllllllllIllllIlllIllll.loop_length <= 1 && llllllllllllllllllIllllIlllIllIl > llllllllllllllllllIllllIlllIllll.loop_start) {
            llllllllllllllllllIllllIllllIIIl = true;
        }
        return llllllllllllllllllIllllIllllIIIl;
    }

    public void set_sample_data(short[] llllllllllllllllllIlllllllIlIllI, int llllllllllllllllllIlllllllIllIll, int llllllllllllllllllIlllllllIllIlI, boolean llllllllllllllllllIlllllllIlIIll) {
        Sample llllllllllllllllllIlllllllIlIlll;
        if (llllllllllllllllllIlllllllIllIll < 0) {
            llllllllllllllllllIlllllllIllIll = 0;
        }
        if (llllllllllllllllllIlllllllIllIll >= llllllllllllllllllIlllllllIlIllI.length) {
            llllllllllllllllllIlllllllIllIll = llllllllllllllllllIlllllllIlIllI.length - 1;
        }
        if (llllllllllllllllllIlllllllIllIll + llllllllllllllllllIlllllllIllIlI > llllllllllllllllllIlllllllIlIllI.length) {
            llllllllllllllllllIlllllllIllIlI = llllllllllllllllllIlllllllIlIllI.length - llllllllllllllllllIlllllllIllIll;
        }
        if (llllllllllllllllllIlllllllIllIlI <= 1) {
            llllllllllllllllllIlllllllIlIlll.sample_data = new short[8 + llllllllllllllllllIlllllllIlIllI.length + 24];
            System.arraycopy(llllllllllllllllllIlllllllIlIllI, 0, llllllllllllllllllIlllllllIlIlll.sample_data, 8, llllllllllllllllllIlllllllIlIllI.length);
            for (int llllllllllllllllllIllllllllIIIIl = 0; llllllllllllllllllIllllllllIIIIl < 8; ++llllllllllllllllllIllllllllIIIIl) {
                short llllllllllllllllllIllllllllIIIlI = llllllllllllllllllIlllllllIlIlll.sample_data[8 + llllllllllllllllllIlllllllIlIllI.length - 1];
                llllllllllllllllllIlllllllIlIlll.sample_data[8 + llllllllllllllllllIlllllllIlIllI.length + llllllllllllllllllIllllllllIIIIl] = llllllllllllllllllIllllllllIIIlI = (short)(llllllllllllllllllIllllllllIIIlI * (8 - llllllllllllllllllIllllllllIIIIl) / 8);
            }
            llllllllllllllllllIlllllllIllIll = 8 + llllllllllllllllllIlllllllIlIllI.length + 8;
            llllllllllllllllllIlllllllIllIlI = 1;
        } else {
            if (llllllllllllllllllIlllllllIlIIll) {
                llllllllllllllllllIlllllllIlIlll.sample_data = new short[8 + llllllllllllllllllIlllllllIllIll + llllllllllllllllllIlllllllIllIlI * 2 + 16];
                System.arraycopy(llllllllllllllllllIlllllllIlIllI, 0, llllllllllllllllllIlllllllIlIlll.sample_data, 8, llllllllllllllllllIlllllllIllIll + llllllllllllllllllIlllllllIllIlI);
                for (int llllllllllllllllllIlllllllIlllll = 0; llllllllllllllllllIlllllllIlllll < llllllllllllllllllIlllllllIllIlI; ++llllllllllllllllllIlllllllIlllll) {
                    short llllllllllllllllllIllllllllIIIII;
                    llllllllllllllllllIlllllllIlIlll.sample_data[8 + llllllllllllllllllIlllllllIllIll + llllllllllllllllllIlllllllIllIlI + llllllllllllllllllIlllllllIlllll] = llllllllllllllllllIllllllllIIIII = llllllllllllllllllIlllllllIlIllI[llllllllllllllllllIlllllllIllIll + llllllllllllllllllIlllllllIllIlI - llllllllllllllllllIlllllllIlllll - 1];
                }
                llllllllllllllllllIlllllllIllIll += 8;
                llllllllllllllllllIlllllllIllIlI *= 2;
            } else {
                llllllllllllllllllIlllllllIlIlll.sample_data = new short[8 + llllllllllllllllllIlllllllIllIll + llllllllllllllllllIlllllllIllIlI + 16];
                System.arraycopy(llllllllllllllllllIlllllllIlIllI, 0, llllllllllllllllllIlllllllIlIlll.sample_data, 8, llllllllllllllllllIlllllllIllIll + llllllllllllllllllIlllllllIllIlI);
                llllllllllllllllllIlllllllIllIll += 8;
            }
            for (int llllllllllllllllllIlllllllIllIII = 0; llllllllllllllllllIlllllllIllIII < 16; ++llllllllllllllllllIlllllllIllIII) {
                short llllllllllllllllllIlllllllIllllI;
                llllllllllllllllllIlllllllIlIlll.sample_data[llllllllllllllllllIlllllllIllIll + llllllllllllllllllIlllllllIllIlI + llllllllllllllllllIlllllllIllIII] = llllllllllllllllllIlllllllIllllI = llllllllllllllllllIlllllllIlIlll.sample_data[llllllllllllllllllIlllllllIllIll + llllllllllllllllllIlllllllIllIII];
            }
        }
        llllllllllllllllllIlllllllIlIlll.loop_start = llllllllllllllllllIlllllllIllIll;
        llllllllllllllllllIlllllllIlIlll.loop_length = llllllllllllllllllIlllllllIllIlI;
    }

    public Sample() {
        Sample llllllllllllllllllIllllllllIlllI;
        llllllllllllllllllIllllllllIlllI.name = "";
        llllllllllllllllllIllllllllIlllI.c2_rate = 8363;
        llllllllllllllllllIllllllllIlllI.set_sample_data(new short[0], 0, 0, false);
    }

    static {
        INTERP_BITMASK = 2047;
        OVERLAP = 8;
        INTERP_SHIFT = 11;
        POINT_SHIFT = 4;
        POINTS = 16;
        sinc_table = new short[]{0, -7, 27, -71, 142, -227, 299, 32439, 299, -227, 142, -71, 27, -7, 0, 0, 0, 0, -5, 36, -142, 450, -1439, 32224, 2302, -974, 455, -190, 64, -15, 2, 0, 0, 6, -33, 128, -391, 1042, -2894, 31584, 4540, -1765, 786, -318, 105, -25, 3, 0, 0, 10, -55, 204, -597, 1533, -4056, 30535, 6977, -2573, 1121, -449, 148, -36, 5, 0, -1, 13, -71, 261, -757, 1916, -4922, 29105, 9568, -3366, 1448, -578, 191, -47, 7, 0, -1, 15, -81, 300, -870, 2185, -5498, 27328, 12263, -4109, 1749, -698, 232, -58, 9, 0, -1, 15, -86, 322, -936, 2343, -5800, 25249, 15006, -4765, 2011, -802, 269, -68, 10, 0, -1, 15, -87, 328, -957, 2394, -5849, 22920, 17738, -5298, 2215, -885, 299, -77, 12, 0, 0, 14, -83, 319, -938, 2347, -5671, 20396, 20396, -5671, 2347, -938, 319, -83, 14, 0, 0, 12, -77, 299, -885, 2215, -5298, 17738, 22920, -5849, 2394, -957, 328, -87, 15, -1, 0, 10, -68, 269, -802, 2011, -4765, 15006, 25249, -5800, 2343, -936, 322, -86, 15, -1, 0, 9, -58, 232, -698, 1749, -4109, 12263, 27328, -5498, 2185, -870, 300, -81, 15, -1, 0, 7, -47, 191, -578, 1448, -3366, 9568, 29105, -4922, 1916, -757, 261, -71, 13, -1, 0, 5, -36, 148, -449, 1121, -2573, 6977, 30535, -4056, 1533, -597, 204, -55, 10, 0, 0, 3, -25, 105, -318, 786, -1765, 4540, 31584, -2894, 1042, -391, 128, -33, 6, 0, 0, 2, -15, 64, -190, 455, -974, 2302, 32224, -1439, 450, -142, 36, -5, 0, 0, 0, 0, -7, 27, -71, 142, -227, 299, 32439, 299, -227, 142, -71, 27, -7, 0};
    }
}

