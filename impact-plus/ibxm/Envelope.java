/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

public class Envelope {
    private /* synthetic */ int loop_start_tick;
    private /* synthetic */ int loop_end_tick;
    public /* synthetic */ boolean looped;
    public /* synthetic */ boolean sustain;
    private /* synthetic */ int[] ticks;
    private /* synthetic */ int sustain_tick;
    private /* synthetic */ int[] ampls;

    public Envelope() {
        Envelope lIIlllIlllIl;
        lIIlllIlllIl.set_num_points(1);
    }

    public void set_num_points(int lIIlllIIlIll) {
        Envelope lIIlllIIlIII;
        if (lIIlllIIlIll <= 0) {
            lIIlllIIlIll = 1;
        }
        lIIlllIIlIII.ticks = new int[lIIlllIIlIll];
        lIIlllIIlIII.ampls = new int[lIIlllIIlIll];
        lIIlllIIlIII.set_point(0, 0, 0);
    }

    public void set_loop_points(int lIIllIIIIIIl, int lIIlIlllllll) {
        Envelope lIIllIIIIIll;
        if (lIIllIIIIIIl < 0) {
            lIIllIIIIIIl = 0;
        }
        if (lIIllIIIIIIl >= lIIllIIIIIll.ticks.length) {
            lIIllIIIIIIl = lIIllIIIIIll.ticks.length - 1;
        }
        if (lIIlIlllllll < lIIllIIIIIIl || lIIlIlllllll >= lIIllIIIIIll.ticks.length) {
            lIIlIlllllll = lIIllIIIIIIl;
        }
        lIIllIIIIIll.loop_start_tick = lIIllIIIIIll.ticks[lIIllIIIIIIl];
        lIIllIIIIIll.loop_end_tick = lIIllIIIIIll.ticks[lIIlIlllllll];
    }

    public int next_tick(int lIIlIlllIIIl, boolean lIIlIlllIIII) {
        Envelope lIIlIlllIIlI;
        if (lIIlIlllIIlI.looped && ++lIIlIlllIIIl >= lIIlIlllIIlI.loop_end_tick) {
            lIIlIlllIIIl = lIIlIlllIIlI.loop_start_tick;
        }
        if (lIIlIlllIIlI.sustain && lIIlIlllIIII && lIIlIlllIIIl >= lIIlIlllIIlI.sustain_tick) {
            lIIlIlllIIIl = lIIlIlllIIlI.sustain_tick;
        }
        return lIIlIlllIIIl;
    }

    public void set_point(int lIIllIIlllIl, int lIIllIIllIll, int lIIllIlIIIIl) {
        Envelope lIIllIIlllll;
        if (lIIllIIlllIl >= 0 && lIIllIIlllIl < lIIllIIlllll.ticks.length) {
            if (lIIllIIlllIl == 0) {
                lIIllIIllIll = 0;
            }
            if (lIIllIIlllIl > 0) {
                if (lIIllIIllIll < lIIllIIlllll.ticks[lIIllIIlllIl - 1]) {
                    lIIllIIllIll += 256;
                }
                if (lIIllIIllIll <= lIIllIIlllll.ticks[lIIllIIlllIl - 1]) {
                    System.out.println(String.valueOf(new StringBuilder().append("Envelope: Point not valid (").append(lIIllIIllIll).append(" <= ").append(lIIllIIlllll.ticks[lIIllIIlllIl - 1]).append(")")));
                    lIIllIIllIll = lIIllIIlllll.ticks[lIIllIIlllIl - 1] + 1;
                }
            }
            lIIllIIlllll.ticks[lIIllIIlllIl] = lIIllIIllIll;
            lIIllIIlllll.ampls[lIIllIIlllIl] = lIIllIlIIIIl;
            ++lIIllIIlllIl;
            while (lIIllIIlllIl < lIIllIIlllll.ticks.length) {
                lIIllIIlllll.ticks[lIIllIIlllIl] = lIIllIIlllll.ticks[lIIllIIlllIl - 1] + 1;
                lIIllIIlllll.ampls[lIIllIIlllIl] = 0;
                ++lIIllIIlllIl;
            }
        }
    }

    public int calculate_ampl(int lIIlIlIIlIll) {
        Envelope lIIlIlIIllIl;
        int lIIlIlIIlIlI = lIIlIlIIllIl.ampls[lIIlIlIIllIl.ticks.length - 1];
        if (lIIlIlIIlIll < lIIlIlIIllIl.ticks[lIIlIlIIllIl.ticks.length - 1]) {
            int lIIlIlIlIIIl = 0;
            for (int lIIlIlIlIIlI = 1; lIIlIlIlIIlI < lIIlIlIIllIl.ticks.length; ++lIIlIlIlIIlI) {
                if (lIIlIlIIllIl.ticks[lIIlIlIlIIlI] > lIIlIlIIlIll) continue;
                lIIlIlIlIIIl = lIIlIlIlIIlI;
            }
            int lIIlIlIlIIII = lIIlIlIIllIl.ticks[lIIlIlIlIIIl + 1] - lIIlIlIIllIl.ticks[lIIlIlIlIIIl];
            int lIIlIlIIllll = lIIlIlIIllIl.ampls[lIIlIlIlIIIl + 1] - lIIlIlIIllIl.ampls[lIIlIlIlIIIl];
            lIIlIlIIlIlI = (lIIlIlIIllll << 15) / lIIlIlIlIIII;
            lIIlIlIIlIlI = lIIlIlIIlIlI * (lIIlIlIIlIll - lIIlIlIIllIl.ticks[lIIlIlIlIIIl]) >> 15;
            lIIlIlIIlIlI += lIIlIlIIllIl.ampls[lIIlIlIlIIIl];
        }
        return lIIlIlIIlIlI;
    }

    public void set_sustain_point(int lIIllIIlIllI) {
        Envelope lIIllIIlIlIl;
        if (lIIllIIlIllI < 0) {
            lIIllIIlIllI = 0;
        }
        if (lIIllIIlIllI >= lIIllIIlIlIl.ticks.length) {
            lIIllIIlIllI = lIIllIIlIlIl.ticks.length - 1;
        }
        lIIllIIlIlIl.sustain_tick = lIIllIIlIlIl.ticks[lIIllIIlIllI];
    }

    public void dump() {
        Envelope lIIlIIlllIII;
        for (int lIIlIIlllIlI = 0; lIIlIIlllIlI < lIIlIIlllIII.ticks.length; ++lIIlIIlllIlI) {
            System.out.println(String.valueOf(new StringBuilder().append(lIIlIIlllIII.ticks[lIIlIIlllIlI]).append(", ").append(lIIlIIlllIII.ampls[lIIlIIlllIlI])));
        }
        for (int lIIlIIlllIIl = 0; lIIlIIlllIIl < 222; ++lIIlIIlllIIl) {
            System.out.print(String.valueOf(new StringBuilder().append(lIIlIIlllIII.calculate_ampl(lIIlIIlllIIl)).append(", ")));
        }
    }
}

