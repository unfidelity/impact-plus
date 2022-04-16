/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

public class Pattern {
    private /* synthetic */ byte[] pattern_data;
    public /* synthetic */ int num_rows;
    private /* synthetic */ int data_offset;
    private /* synthetic */ int note_index;

    public void get_note(int[] lIlIllIlIllIIII, int lIlIllIlIllIIlI) {
        Pattern lIlIllIlIllIIIl;
        if (lIlIllIlIllIIlI < lIlIllIlIllIIIl.note_index) {
            lIlIllIlIllIIIl.note_index = 0;
            lIlIllIlIllIIIl.data_offset = 0;
        }
        while (lIlIllIlIllIIIl.note_index <= lIlIllIlIllIIlI) {
            lIlIllIlIllIIIl.data_offset = lIlIllIlIllIIIl.next_note(lIlIllIlIllIIIl.data_offset, lIlIllIlIllIIII);
            ++lIlIllIlIllIIIl.note_index;
        }
    }

    public Pattern() {
        Pattern lIlIllIllIIlIll;
        lIlIllIllIIlIll.num_rows = 1;
        lIlIllIllIIlIll.set_pattern_data(new byte[0]);
    }

    public int next_note(int lIlIllIlIIlIIlI, int[] lIlIllIlIIlIIIl) {
        Pattern lIlIllIlIIlIIll;
        if (lIlIllIlIIlIIlI < 0) {
            lIlIllIlIIlIIlI = lIlIllIlIIlIIll.pattern_data.length;
        }
        int lIlIllIlIIlIIII = 128;
        if (lIlIllIlIIlIIlI < lIlIllIlIIlIIll.pattern_data.length) {
            lIlIllIlIIlIIII = lIlIllIlIIlIIll.pattern_data[lIlIllIlIIlIIlI] & 0xFF;
        }
        if ((lIlIllIlIIlIIII & 0x80) == 128) {
            ++lIlIllIlIIlIIlI;
        } else {
            lIlIllIlIIlIIII = 31;
        }
        for (int lIlIllIlIIIllll = 0; lIlIllIlIIIllll < 5; ++lIlIllIlIIIllll) {
            lIlIllIlIIlIIIl[lIlIllIlIIIllll] = 0;
            if ((lIlIllIlIIlIIII & 1) == 1 && lIlIllIlIIlIIlI < lIlIllIlIIlIIll.pattern_data.length) {
                lIlIllIlIIlIIIl[lIlIllIlIIIllll] = lIlIllIlIIlIIll.pattern_data[lIlIllIlIIlIIlI] & 0xFF;
                ++lIlIllIlIIlIIlI;
            }
            lIlIllIlIIlIIII >>= 1;
        }
        return lIlIllIlIIlIIlI;
    }

    public void set_pattern_data(byte[] lIlIllIllIIIIII) {
        if (lIlIllIllIIIIII != null) {
            lIlIllIllIIIlIl.pattern_data = lIlIllIllIIIIII;
        }
        lIlIllIllIIIlIl.data_offset = 0;
        lIlIllIllIIIlIl.note_index = 0;
    }
}

