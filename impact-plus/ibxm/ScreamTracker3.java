/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Instrument;
import ibxm.Module;
import ibxm.Pattern;
import ibxm.Sample;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class ScreamTracker3 {
    private static final /* synthetic */ int[] effect_s_map;
    private static final /* synthetic */ int[] effect_map;

    private static byte[] read_more(byte[] llllllllllllllllIIIlIlIIIIIIIlII, int llllllllllllllllIIIlIlIIIIIIIIll, DataInput llllllllllllllllIIIlIIlllllllllI) throws IOException {
        byte[] llllllllllllllllIIIlIlIIIIIIIIIl = llllllllllllllllIIIlIlIIIIIIIlII;
        if (llllllllllllllllIIIlIlIIIIIIIIll > llllllllllllllllIIIlIlIIIIIIIlII.length) {
            llllllllllllllllIIIlIlIIIIIIIIIl = new byte[llllllllllllllllIIIlIlIIIIIIIIll];
            System.arraycopy(llllllllllllllllIIIlIlIIIIIIIlII, 0, llllllllllllllllIIIlIlIIIIIIIIIl, 0, llllllllllllllllIIIlIlIIIIIIIlII.length);
            try {
                llllllllllllllllIIIlIIlllllllllI.readFully(llllllllllllllllIIIlIlIIIIIIIIIl, llllllllllllllllIIIlIlIIIIIIIlII.length, llllllllllllllllIIIlIlIIIIIIIIIl.length - llllllllllllllllIIIlIlIIIIIIIlII.length);
            }
            catch (EOFException llllllllllllllllIIIlIlIIIIIIIlIl) {
                System.out.println("ScreamTracker3: Module has been truncated!");
            }
        }
        return llllllllllllllllIIIlIlIIIIIIIIIl;
    }

    private static int get_sample_data_length(byte[] llllllllllllllllIIIlIlIIIIlIIlIl, int llllllllllllllllIIIlIlIIIIlIIIIl) {
        int llllllllllllllllIIIlIlIIIIlIIIll = 0;
        if (llllllllllllllllIIIlIlIIIIlIIlIl[llllllllllllllllIIIlIlIIIIlIIIIl] == 1) {
            llllllllllllllllIIIlIlIIIIlIIIll = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIIIlIIlIl, llllllllllllllllIIIlIlIIIIlIIIIl + 16);
        }
        return llllllllllllllllIIIlIlIIIIlIIIll;
    }

    public static boolean is_s3m(byte[] llllllllllllllllIIIlIlIlIIllIIIl) {
        String llllllllllllllllIIIlIlIlIIllIIII = ScreamTracker3.ascii_text(llllllllllllllllIIIlIlIlIIllIIIl, 44, 4);
        return llllllllllllllllIIIlIlIlIIllIIII.equals("SCRM");
    }

    private static int get_num_pattern_orders(byte[] llllllllllllllllIIIlIlIIIlIIllIl) {
        int llllllllllllllllIIIlIlIIIlIIllII = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIIlIIllIl, 32);
        return llllllllllllllllIIIlIlIIIlIIllII;
    }

    public ScreamTracker3() {
        ScreamTracker3 llllllllllllllllIIIlIlIlIIllIlIl;
    }

    private static int get_num_instruments(byte[] llllllllllllllllIIIlIlIIIlIIIlll) {
        int llllllllllllllllIIIlIlIIIlIIIllI = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIIlIIIlll, 34);
        return llllllllllllllllIIIlIlIIIlIIIllI;
    }

    private static Pattern read_s3m_pattern(byte[] llllllllllllllllIIIlIlIIlIIIIlIl, int llllllllllllllllIIIlIlIIlIIIIlII, int[] llllllllllllllllIIIlIlIIlIIIIIll) {
        int llllllllllllllllIIIlIlIIlIIIlIII;
        int llllllllllllllllIIIlIlIIlIIIlIll = 0;
        for (llllllllllllllllIIIlIlIIlIIIlIII = 0; llllllllllllllllIIIlIlIIlIIIlIII < 32; ++llllllllllllllllIIIlIlIIlIIIlIII) {
            if (llllllllllllllllIIIlIlIIlIIIIIll[llllllllllllllllIIIlIlIIlIIIlIII] < llllllllllllllllIIIlIlIIlIIIlIll) continue;
            llllllllllllllllIIIlIlIIlIIIlIll = llllllllllllllllIIIlIlIIlIIIlIII + 1;
        }
        int llllllllllllllllIIIlIlIIlIIIlIlI = llllllllllllllllIIIlIlIIlIIIlIll * 64;
        byte[] llllllllllllllllIIIlIlIIlIIIIlll = new byte[llllllllllllllllIIIlIlIIlIIIlIlI * 5];
        int llllllllllllllllIIIlIlIIlIIIlIIl = 0;
        int llllllllllllllllIIIlIlIIlIIIllII = ScreamTracker3.get_pattern_offset(llllllllllllllllIIIlIlIIlIIIIlIl, llllllllllllllllIIIlIlIIlIIIIlII) + 2;
        while (llllllllllllllllIIIlIlIIlIIIlIIl < 64) {
            int llllllllllllllllIIIlIlIIlIIlIIII = llllllllllllllllIIIlIlIIlIIIIlIl[llllllllllllllllIIIlIlIIlIIIllII] & 0xFF;
            ++llllllllllllllllIIIlIlIIlIIIllII;
            if (llllllllllllllllIIIlIlIIlIIlIIII > 0) {
                llllllllllllllllIIIlIlIIlIIIlIII = llllllllllllllllIIIlIlIIlIIIIIll[llllllllllllllllIIIlIlIIlIIlIIII & 0x1F];
                int llllllllllllllllIIIlIlIIlIIlIIIl = (llllllllllllllllIIIlIlIIlIIIlIll * llllllllllllllllIIIlIlIIlIIIlIIl + llllllllllllllllIIIlIlIIlIIIlIII) * 5;
                if ((llllllllllllllllIIIlIlIIlIIlIIII & 0x20) == 32) {
                    if (llllllllllllllllIIIlIlIIlIIIlIII >= 0) {
                        int llllllllllllllllIIIlIlIIlIIlIlIl = llllllllllllllllIIIlIlIIlIIIIlIl[llllllllllllllllIIIlIlIIlIIIllII] & 0xFF;
                        if (llllllllllllllllIIIlIlIIlIIlIlIl == 255) {
                            llllllllllllllllIIIlIlIIlIIlIlIl = 0;
                        } else if (llllllllllllllllIIIlIlIIlIIlIlIl == 254) {
                            llllllllllllllllIIIlIlIIlIIlIlIl = 97;
                        } else {
                            for (llllllllllllllllIIIlIlIIlIIlIlIl = ((llllllllllllllllIIIlIlIIlIIlIlIl & 0xF0) >> 4) * 12 + (llllllllllllllllIIIlIlIIlIIlIlIl & 0xF) + 1; llllllllllllllllIIIlIlIIlIIlIlIl > 96; llllllllllllllllIIIlIlIIlIIlIlIl -= 12) {
                            }
                        }
                        llllllllllllllllIIIlIlIIlIIIIlll[llllllllllllllllIIIlIlIIlIIlIIIl] = (byte)llllllllllllllllIIIlIlIIlIIlIlIl;
                        llllllllllllllllIIIlIlIIlIIIIlll[llllllllllllllllIIIlIlIIlIIlIIIl + 1] = llllllllllllllllIIIlIlIIlIIIIlIl[llllllllllllllllIIIlIlIIlIIIllII + 1];
                    }
                    llllllllllllllllIIIlIlIIlIIIllII += 2;
                }
                if ((llllllllllllllllIIIlIlIIlIIlIIII & 0x40) == 64) {
                    if (llllllllllllllllIIIlIlIIlIIIlIII >= 0) {
                        int llllllllllllllllIIIlIlIIlIIlIlII = (llllllllllllllllIIIlIlIIlIIIIlIl[llllllllllllllllIIIlIlIIlIIIllII] & 0xFF) + 16;
                        llllllllllllllllIIIlIlIIlIIIIlll[llllllllllllllllIIIlIlIIlIIlIIIl + 2] = (byte)llllllllllllllllIIIlIlIIlIIlIlII;
                    }
                    ++llllllllllllllllIIIlIlIIlIIIllII;
                }
                if ((llllllllllllllllIIIlIlIIlIIlIIII & 0x80) != 128) continue;
                if (llllllllllllllllIIIlIlIIlIIIlIII >= 0) {
                    int llllllllllllllllIIIlIlIIlIIlIIll = llllllllllllllllIIIlIlIIlIIIIlIl[llllllllllllllllIIIlIlIIlIIIllII] & 0xFF;
                    int llllllllllllllllIIIlIlIIlIIlIIlI = llllllllllllllllIIIlIlIIlIIIIlIl[llllllllllllllllIIIlIlIIlIIIllII + 1] & 0xFF;
                    if ((llllllllllllllllIIIlIlIIlIIlIIll = effect_map[llllllllllllllllIIIlIlIIlIIlIIll & 0x1F]) == 255) {
                        llllllllllllllllIIIlIlIIlIIlIIll = 0;
                        llllllllllllllllIIIlIlIIlIIlIIlI = 0;
                    }
                    if (llllllllllllllllIIIlIlIIlIIlIIll == 14) {
                        llllllllllllllllIIIlIlIIlIIlIIll = effect_s_map[(llllllllllllllllIIIlIlIIlIIlIIlI & 0xF0) >> 4];
                        llllllllllllllllIIIlIlIIlIIlIIlI &= 0xF;
                        switch (llllllllllllllllIIIlIlIIlIIlIIll) {
                            case 8: {
                                llllllllllllllllIIIlIlIIlIIlIIll = 8;
                                llllllllllllllllIIIlIlIIlIIlIIlI <<= 4;
                                break;
                            }
                            case 9: {
                                llllllllllllllllIIIlIlIIlIIlIIll = 8;
                                if (llllllllllllllllIIIlIlIIlIIlIIlI > 7) {
                                    llllllllllllllllIIIlIlIIlIIlIIlI -= 8;
                                    break;
                                }
                                llllllllllllllllIIIlIlIIlIIlIIlI += 8;
                                break;
                            }
                            case 255: {
                                llllllllllllllllIIIlIlIIlIIlIIll = 0;
                                llllllllllllllllIIIlIlIIlIIlIIlI = 0;
                                break;
                            }
                            default: {
                                llllllllllllllllIIIlIlIIlIIlIIlI = (llllllllllllllllIIIlIlIIlIIlIIll & 0xF) << 4 | llllllllllllllllIIIlIlIIlIIlIIlI & 0xF;
                                llllllllllllllllIIIlIlIIlIIlIIll = 14;
                            }
                        }
                    }
                    llllllllllllllllIIIlIlIIlIIIIlll[llllllllllllllllIIIlIlIIlIIlIIIl + 3] = (byte)llllllllllllllllIIIlIlIIlIIlIIll;
                    llllllllllllllllIIIlIlIIlIIIIlll[llllllllllllllllIIIlIlIIlIIlIIIl + 4] = (byte)llllllllllllllllIIIlIlIIlIIlIIlI;
                }
                llllllllllllllllIIIlIlIIlIIIllII += 2;
                continue;
            }
            ++llllllllllllllllIIIlIlIIlIIIlIIl;
        }
        Pattern llllllllllllllllIIIlIlIIlIIIIllI = new Pattern();
        llllllllllllllllIIIlIlIIlIIIIllI.num_rows = 64;
        llllllllllllllllIIIlIlIIlIIIIllI.set_pattern_data(llllllllllllllllIIIlIlIIlIIIIlll);
        return llllllllllllllllIIIlIlIIlIIIIllI;
    }

    private static int get_sample_data_offset(byte[] llllllllllllllllIIIlIlIIIIlIlllI, int llllllllllllllllIIIlIlIIIIlIlIlI) {
        int llllllllllllllllIIIlIlIIIIlIllII = 0;
        if (llllllllllllllllIIIlIlIIIIlIlllI[llllllllllllllllIIIlIlIIIIlIlIlI] == 1) {
            llllllllllllllllIIIlIlIIIIlIllII = (llllllllllllllllIIIlIlIIIIlIlllI[llllllllllllllllIIIlIlIIIIlIlIlI + 13] & 0xFF) << 20;
            llllllllllllllllIIIlIlIIIIlIllII |= ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIIIlIlllI, llllllllllllllllIIIlIlIIIIlIlIlI + 14) << 4;
        }
        return llllllllllllllllIIIlIlIIIIlIllII;
    }

    static {
        effect_map = new int[]{255, 37, 11, 13, 10, 2, 1, 3, 4, 29, 0, 6, 5, 255, 255, 9, 255, 27, 7, 14, 15, 36, 16, 255, 255, 255, 255, 255, 255, 255, 255, 255};
        effect_s_map = new int[]{0, 3, 5, 4, 7, 255, 255, 255, 8, 255, 9, 6, 12, 13, 14, 15};
    }

    private static int get_pattern_length(byte[] llllllllllllllllIIIlIlIIIIIIllIl, int llllllllllllllllIIIlIlIIIIIIllll) {
        int llllllllllllllllIIIlIlIIIIIIlllI = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIIIIIllIl, llllllllllllllllIIIlIlIIIIIIllll);
        return llllllllllllllllIIIlIlIIIIIIlllI;
    }

    private static int unsigned_short_le(byte[] llllllllllllllllIIIlIIlllllllIII, int llllllllllllllllIIIlIIllllllIlll) {
        int llllllllllllllllIIIlIIllllllIllI = llllllllllllllllIIIlIIlllllllIII[llllllllllllllllIIIlIIllllllIlll] & 0xFF;
        return llllllllllllllllIIIlIIllllllIllI |= (llllllllllllllllIIIlIIlllllllIII[llllllllllllllllIIIlIIllllllIlll + 1] & 0xFF) << 8;
    }

    private static Instrument read_s3m_instrument(byte[] llllllllllllllllIIIlIlIIlIllIIlI, int llllllllllllllllIIIlIlIIlIllIlll, boolean llllllllllllllllIIIlIlIIlIllIIII) {
        int llllllllllllllllIIIlIlIIlIllIlIl = ScreamTracker3.get_instrument_offset(llllllllllllllllIIIlIlIIlIllIIlI, llllllllllllllllIIIlIlIIlIllIlll);
        Instrument llllllllllllllllIIIlIlIIlIllIlII = new Instrument();
        llllllllllllllllIIIlIlIIlIllIlII.name = ScreamTracker3.ascii_text(llllllllllllllllIIIlIlIIlIllIIlI, llllllllllllllllIIIlIlIIlIllIlIl + 48, 28);
        Sample llllllllllllllllIIIlIlIIlIllIIll = new Sample();
        if (llllllllllllllllIIIlIlIIlIllIIlI[llllllllllllllllIIIlIlIIlIllIlIl] == 1) {
            int llllllllllllllllIIIlIlIIlIllllIl = ScreamTracker3.get_sample_data_length(llllllllllllllllIIIlIlIIlIllIIlI, llllllllllllllllIIIlIlIIlIllIlIl);
            int llllllllllllllllIIIlIlIIlIllllII = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIlIllIIlI, llllllllllllllllIIIlIlIIlIllIlIl + 20);
            int llllllllllllllllIIIlIlIIlIlllIll = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIlIllIIlI, llllllllllllllllIIIlIlIIlIllIlIl + 24) - llllllllllllllllIIIlIlIIlIllllII;
            llllllllllllllllIIIlIlIIlIllIIll.volume = llllllllllllllllIIIlIlIIlIllIIlI[llllllllllllllllIIIlIlIIlIllIlIl + 28] & 0xFF;
            if (llllllllllllllllIIIlIlIIlIllIIlI[llllllllllllllllIIIlIlIIlIllIlIl + 30] != 0) {
                throw new IllegalArgumentException("ScreamTracker3: Packed samples not supported!");
            }
            if ((llllllllllllllllIIIlIlIIlIllIIlI[llllllllllllllllIIIlIlIIlIllIlIl + 31] & 1) == 0) {
                llllllllllllllllIIIlIlIIlIlllIll = 0;
            }
            llllllllllllllllIIIlIlIIlIllIIll.c2_rate = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIlIllIIlI, llllllllllllllllIIIlIlIIlIllIlIl + 32);
            short[] llllllllllllllllIIIlIlIIlIlllIIl = new short[llllllllllllllllIIIlIlIIlIllllIl];
            int llllllllllllllllIIIlIlIIlIlllllI = ScreamTracker3.get_sample_data_offset(llllllllllllllllIIIlIlIIlIllIIlI, llllllllllllllllIIIlIlIIlIllIlIl);
            if (llllllllllllllllIIIlIlIIlIllIIII) {
                for (int llllllllllllllllIIIlIlIIllIIIIIl = 0; llllllllllllllllIIIlIlIIllIIIIIl < llllllllllllllllIIIlIlIIlIllllIl; ++llllllllllllllllIIIlIlIIllIIIIIl) {
                    int llllllllllllllllIIIlIlIIllIIIIII = llllllllllllllllIIIlIlIIlIllIIlI[llllllllllllllllIIIlIlIIlIlllllI + llllllllllllllllIIIlIlIIllIIIIIl] << 8;
                    llllllllllllllllIIIlIlIIlIlllIIl[llllllllllllllllIIIlIlIIllIIIIIl] = (short)(llllllllllllllllIIIlIlIIllIIIIII << 8);
                }
            } else {
                for (int llllllllllllllllIIIlIlIIlIlllIlI = 0; llllllllllllllllIIIlIlIIlIlllIlI < llllllllllllllllIIIlIlIIlIllllIl; ++llllllllllllllllIIIlIlIIlIlllIlI) {
                    int llllllllllllllllIIIlIlIIlIllllll = (llllllllllllllllIIIlIlIIlIllIIlI[llllllllllllllllIIIlIlIIlIlllllI + llllllllllllllllIIIlIlIIlIlllIlI] & 0xFF) - 128;
                    llllllllllllllllIIIlIlIIlIlllIIl[llllllllllllllllIIIlIlIIlIlllIlI] = (short)(llllllllllllllllIIIlIlIIlIllllll << 8);
                }
            }
            llllllllllllllllIIIlIlIIlIllIIll.set_sample_data(llllllllllllllllIIIlIlIIlIlllIIl, llllllllllllllllIIIlIlIIlIllllII, llllllllllllllllIIIlIlIIlIlllIll, false);
        }
        llllllllllllllllIIIlIlIIlIllIlII.set_num_samples(1);
        llllllllllllllllIIIlIlIIlIllIlII.set_sample(0, llllllllllllllllIIIlIlIIlIllIIll);
        return llllllllllllllllIIIlIlIIlIllIlII;
    }

    private static int get_pattern_offset(byte[] llllllllllllllllIIIlIlIIIIIlIlll, int llllllllllllllllIIIlIlIIIIIlIllI) {
        int llllllllllllllllIIIlIlIIIIIllIII = 96 + ScreamTracker3.get_num_pattern_orders(llllllllllllllllIIIlIlIIIIIlIlll);
        int llllllllllllllllIIIlIlIIIIIllIIl = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIIIIlIlll, (llllllllllllllllIIIlIlIIIIIllIII += ScreamTracker3.get_num_instruments(llllllllllllllllIIIlIlIIIIIlIlll) * 2) + llllllllllllllllIIIlIlIIIIIlIllI * 2) << 4;
        return llllllllllllllllIIIlIlIIIIIllIIl;
    }

    private static String ascii_text(byte[] llllllllllllllllIIIlIIlllllIlIII, int llllllllllllllllIIIlIIlllllIIIIl, int llllllllllllllllIIIlIIlllllIIllI) {
        String llllllllllllllllIIIlIIlllllIIIll;
        byte[] llllllllllllllllIIIlIIlllllIIlII = new byte[llllllllllllllllIIIlIIlllllIIllI];
        for (int llllllllllllllllIIIlIIlllllIIlIl = 0; llllllllllllllllIIIlIIlllllIIlIl < llllllllllllllllIIIlIIlllllIIllI; ++llllllllllllllllIIIlIIlllllIIlIl) {
            int llllllllllllllllIIIlIIlllllIlIlI = llllllllllllllllIIIlIIlllllIlIII[llllllllllllllllIIIlIIlllllIIIIl + llllllllllllllllIIIlIIlllllIIlIl];
            if (llllllllllllllllIIIlIIlllllIlIlI < 32) {
                llllllllllllllllIIIlIIlllllIlIlI = 32;
            }
            llllllllllllllllIIIlIIlllllIIlII[llllllllllllllllIIIlIIlllllIIlIl] = (byte)llllllllllllllllIIIlIIlllllIlIlI;
        }
        try {
            llllllllllllllllIIIlIIlllllIIIll = new String(llllllllllllllllIIIlIIlllllIIlII, 0, llllllllllllllllIIIlIIlllllIIllI, "ISO-8859-1");
        }
        catch (UnsupportedEncodingException llllllllllllllllIIIlIIlllllIlIIl) {
            llllllllllllllllIIIlIIlllllIIIll = "";
        }
        return llllllllllllllllIIIlIIlllllIIIll;
    }

    private static int get_num_patterns(byte[] llllllllllllllllIIIlIlIIIIllllll) {
        int llllllllllllllllIIIlIlIIIlIIIIII = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIIIllllll, 36);
        return llllllllllllllllIIIlIlIIIlIIIIII;
    }

    public static Module load_s3m(byte[] llllllllllllllllIIIlIlIlIIIlIIIl, DataInput llllllllllllllllIIIlIlIIlllllIll) throws IOException {
        int llllllllllllllllIIIlIlIlIIIIIllI;
        byte[] llllllllllllllllIIIlIlIIlllllllI = ScreamTracker3.read_s3m_file(llllllllllllllllIIIlIlIlIIIlIIIl, llllllllllllllllIIIlIlIIlllllIll);
        Module llllllllllllllllIIIlIlIIllllllIl = new Module();
        llllllllllllllllIIIlIlIIllllllIl.song_title = ScreamTracker3.ascii_text(llllllllllllllllIIIlIlIIlllllllI, 0, 28);
        int llllllllllllllllIIIlIlIlIIIIllll = ScreamTracker3.get_num_pattern_orders(llllllllllllllllIIIlIlIIlllllllI);
        int llllllllllllllllIIIlIlIlIIIIlllI = ScreamTracker3.get_num_instruments(llllllllllllllllIIIlIlIIlllllllI);
        int llllllllllllllllIIIlIlIlIIIIllIl = ScreamTracker3.get_num_patterns(llllllllllllllllIIIlIlIIlllllllI);
        int llllllllllllllllIIIlIlIlIIIIlIll = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIlllllllI, 38);
        int llllllllllllllllIIIlIlIlIIIIlIlI = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIlllllllI, 40);
        if ((llllllllllllllllIIIlIlIlIIIIlIll & 0x40) == 64 || llllllllllllllllIIIlIlIlIIIIlIlI == 4864) {
            llllllllllllllllIIIlIlIIllllllIl.fast_volume_slides = true;
        }
        boolean llllllllllllllllIIIlIlIlIIIIIIll = false;
        if (ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIlllllllI, 42) == 1) {
            llllllllllllllllIIIlIlIlIIIIIIll = true;
        }
        llllllllllllllllIIIlIlIIllllllIl.global_volume = llllllllllllllllIIIlIlIIlllllllI[48] & 0xFF;
        llllllllllllllllIIIlIlIIllllllIl.default_speed = llllllllllllllllIIIlIlIIlllllllI[49] & 0xFF;
        llllllllllllllllIIIlIlIIllllllIl.default_tempo = llllllllllllllllIIIlIlIIlllllllI[50] & 0xFF;
        int llllllllllllllllIIIlIlIlIIIIlIIl = llllllllllllllllIIIlIlIIlllllllI[51] & 0x7F;
        llllllllllllllllIIIlIlIIllllllIl.channel_gain = llllllllllllllllIIIlIlIlIIIIlIIl << 15 >> 7;
        boolean llllllllllllllllIIIlIlIlIIIIIIlI = (llllllllllllllllIIIlIlIIlllllllI[51] & 0x80) == 128;
        boolean llllllllllllllllIIIlIlIlIIIIIIIl = (llllllllllllllllIIIlIlIIlllllllI[53] & 0xFF) == 252;
        int[] llllllllllllllllIIIlIlIlIIIIIIII = new int[32];
        int llllllllllllllllIIIlIlIlIIIIllII = 0;
        for (llllllllllllllllIIIlIlIlIIIIIllI = 0; llllllllllllllllIIIlIlIlIIIIIllI < 32; ++llllllllllllllllIIIlIlIlIIIIIllI) {
            int llllllllllllllllIIIlIlIlIIIlIlIl = llllllllllllllllIIIlIlIIlllllllI[64 + llllllllllllllllIIIlIlIlIIIIIllI] & 0xFF;
            llllllllllllllllIIIlIlIlIIIIIIII[llllllllllllllllIIIlIlIlIIIIIllI] = -1;
            if (llllllllllllllllIIIlIlIlIIIlIlIl >= 16) continue;
            llllllllllllllllIIIlIlIlIIIIIIII[llllllllllllllllIIIlIlIlIIIIIllI] = llllllllllllllllIIIlIlIlIIIIllII++;
        }
        llllllllllllllllIIIlIlIIllllllIl.set_num_channels(llllllllllllllllIIIlIlIlIIIIllII);
        int llllllllllllllllIIIlIlIlIIIIIlII = 96 + llllllllllllllllIIIlIlIlIIIIllll + llllllllllllllllIIIlIlIlIIIIlllI * 2 + llllllllllllllllIIIlIlIlIIIIllIl * 2;
        for (llllllllllllllllIIIlIlIlIIIIIllI = 0; llllllllllllllllIIIlIlIlIIIIIllI < 32; ++llllllllllllllllIIIlIlIlIIIIIllI) {
            int llllllllllllllllIIIlIlIlIIIlIIll = llllllllllllllllIIIlIlIIlllllllI[64 + llllllllllllllllIIIlIlIlIIIIIllI] & 0xFF;
            if (llllllllllllllllIIIlIlIlIIIIIIII[llllllllllllllllIIIlIlIlIIIIIllI] < 0) continue;
            int llllllllllllllllIIIlIlIlIIIlIlII = 128;
            if (llllllllllllllllIIIlIlIlIIIIIIlI) {
                llllllllllllllllIIIlIlIlIIIlIlII = llllllllllllllllIIIlIlIlIIIlIIll < 8 ? 64 : 192;
            }
            if (llllllllllllllllIIIlIlIlIIIIIIIl && ((llllllllllllllllIIIlIlIlIIIIlIll = llllllllllllllllIIIlIlIIlllllllI[llllllllllllllllIIIlIlIlIIIIIlII + llllllllllllllllIIIlIlIlIIIIIllI] & 0xFF) & 0x20) == 32) {
                llllllllllllllllIIIlIlIlIIIlIlII = (llllllllllllllllIIIlIlIlIIIIlIll & 0xF) << 4;
            }
            llllllllllllllllIIIlIlIIllllllIl.set_initial_panning(llllllllllllllllIIIlIlIlIIIIIIII[llllllllllllllllIIIlIlIlIIIIIllI], llllllllllllllllIIIlIlIlIIIlIlII);
        }
        int[] llllllllllllllllIIIlIlIIllllllll = ScreamTracker3.read_s3m_sequence(llllllllllllllllIIIlIlIIlllllllI);
        llllllllllllllllIIIlIlIIllllllIl.set_sequence_length(llllllllllllllllIIIlIlIIllllllll.length);
        for (int llllllllllllllllIIIlIlIlIIIIIlIl = 0; llllllllllllllllIIIlIlIlIIIIIlIl < llllllllllllllllIIIlIlIIllllllll.length; ++llllllllllllllllIIIlIlIlIIIIIlIl) {
            llllllllllllllllIIIlIlIIllllllIl.set_sequence(llllllllllllllllIIIlIlIlIIIIIlIl, llllllllllllllllIIIlIlIIllllllll[llllllllllllllllIIIlIlIlIIIIIlIl]);
        }
        llllllllllllllllIIIlIlIIllllllIl.set_num_instruments(llllllllllllllllIIIlIlIlIIIIlllI);
        for (int llllllllllllllllIIIlIlIlIIIIlIII = 0; llllllllllllllllIIIlIlIlIIIIlIII < llllllllllllllllIIIlIlIlIIIIlllI; ++llllllllllllllllIIIlIlIlIIIIlIII) {
            Instrument llllllllllllllllIIIlIlIlIIIlIIlI = ScreamTracker3.read_s3m_instrument(llllllllllllllllIIIlIlIIlllllllI, llllllllllllllllIIIlIlIlIIIIlIII, llllllllllllllllIIIlIlIlIIIIIIll);
            llllllllllllllllIIIlIlIIllllllIl.set_instrument(llllllllllllllllIIIlIlIlIIIIlIII + 1, llllllllllllllllIIIlIlIlIIIlIIlI);
        }
        llllllllllllllllIIIlIlIIllllllIl.set_num_patterns(llllllllllllllllIIIlIlIlIIIIllIl);
        for (int llllllllllllllllIIIlIlIlIIIIIlll = 0; llllllllllllllllIIIlIlIlIIIIIlll < llllllllllllllllIIIlIlIlIIIIllIl; ++llllllllllllllllIIIlIlIlIIIIIlll) {
            llllllllllllllllIIIlIlIIllllllIl.set_pattern(llllllllllllllllIIIlIlIlIIIIIlll, ScreamTracker3.read_s3m_pattern(llllllllllllllllIIIlIlIIlllllllI, llllllllllllllllIIIlIlIlIIIIIlll, llllllllllllllllIIIlIlIlIIIIIIII));
        }
        return llllllllllllllllIIIlIlIIllllllIl;
    }

    private static int get_instrument_offset(byte[] llllllllllllllllIIIlIlIIIIllIlIl, int llllllllllllllllIIIlIlIIIIllIlII) {
        int llllllllllllllllIIIlIlIIIIllIllI = 96 + ScreamTracker3.get_num_pattern_orders(llllllllllllllllIIIlIlIIIIllIlIl);
        int llllllllllllllllIIIlIlIIIIllIlll = ScreamTracker3.unsigned_short_le(llllllllllllllllIIIlIlIIIIllIlIl, llllllllllllllllIIIlIlIIIIllIllI + llllllllllllllllIIIlIlIIIIllIlII * 2) << 4;
        return llllllllllllllllIIIlIlIIIIllIlll;
    }

    private static int[] read_s3m_sequence(byte[] llllllllllllllllIIIlIlIIllIllIll) {
        int llllllllllllllllIIIlIlIIllIlllII;
        int llllllllllllllllIIIlIlIIllIlllIl;
        int llllllllllllllllIIIlIlIIllIlIlll;
        int llllllllllllllllIIIlIlIIllIllIlI = ScreamTracker3.get_num_pattern_orders(llllllllllllllllIIIlIlIIllIllIll);
        int llllllllllllllllIIIlIlIIllIllIIl = 0;
        for (llllllllllllllllIIIlIlIIllIlIlll = 0; llllllllllllllllIIIlIlIIllIlIlll < llllllllllllllllIIIlIlIIllIllIlI && (llllllllllllllllIIIlIlIIllIlllIl = llllllllllllllllIIIlIlIIllIllIll[96 + llllllllllllllllIIIlIlIIllIlIlll] & 0xFF) != 255; ++llllllllllllllllIIIlIlIIllIlIlll) {
            if (llllllllllllllllIIIlIlIIllIlllIl >= 254) continue;
            ++llllllllllllllllIIIlIlIIllIllIIl;
        }
        int[] llllllllllllllllIIIlIlIIllIlIllI = new int[llllllllllllllllIIIlIlIIllIllIIl];
        int llllllllllllllllIIIlIlIIllIllIII = 0;
        for (llllllllllllllllIIIlIlIIllIlIlll = 0; llllllllllllllllIIIlIlIIllIlIlll < llllllllllllllllIIIlIlIIllIllIlI && (llllllllllllllllIIIlIlIIllIlllII = llllllllllllllllIIIlIlIIllIllIll[96 + llllllllllllllllIIIlIlIIllIlIlll] & 0xFF) != 255; ++llllllllllllllllIIIlIlIIllIlIlll) {
            if (llllllllllllllllIIIlIlIIllIlllII >= 254) continue;
            llllllllllllllllIIIlIlIIllIlIllI[llllllllllllllllIIIlIlIIllIllIII] = llllllllllllllllIIIlIlIIllIlllII;
            ++llllllllllllllllIIIlIlIIllIllIII;
        }
        return llllllllllllllllIIIlIlIIllIlIllI;
    }

    private static byte[] read_s3m_file(byte[] llllllllllllllllIIIlIlIIIlIllIll, DataInput llllllllllllllllIIIlIlIIIllIIIll) throws IOException {
        int llllllllllllllllIIIlIlIIIlIlllIl;
        int llllllllllllllllIIIlIlIIIlIllllI;
        if (!ScreamTracker3.is_s3m(llllllllllllllllIIIlIlIIIlIllIll)) {
            throw new IllegalArgumentException("ScreamTracker3: Not an S3M file!");
        }
        byte[] llllllllllllllllIIIlIlIIIlIlllII = llllllllllllllllIIIlIlIIIlIllIll;
        int llllllllllllllllIIIlIlIIIllIIIlI = llllllllllllllllIIIlIlIIIlIllIll.length;
        int llllllllllllllllIIIlIlIIIllIIIIl = ScreamTracker3.get_num_pattern_orders(llllllllllllllllIIIlIlIIIlIlllII);
        int llllllllllllllllIIIlIlIIIllIIIII = ScreamTracker3.get_num_instruments(llllllllllllllllIIIlIlIIIlIlllII);
        int llllllllllllllllIIIlIlIIIlIlllll = ScreamTracker3.get_num_patterns(llllllllllllllllIIIlIlIIIlIlllII);
        llllllllllllllllIIIlIlIIIllIIIlI += llllllllllllllllIIIlIlIIIllIIIIl;
        llllllllllllllllIIIlIlIIIllIIIlI += llllllllllllllllIIIlIlIIIllIIIII * 2;
        llllllllllllllllIIIlIlIIIlIlllII = ScreamTracker3.read_more(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIllIIIlI += llllllllllllllllIIIlIlIIIlIlllll * 2, llllllllllllllllIIIlIlIIIllIIIll);
        for (llllllllllllllllIIIlIlIIIlIllllI = 0; llllllllllllllllIIIlIlIIIlIllllI < llllllllllllllllIIIlIlIIIllIIIII; ++llllllllllllllllIIIlIlIIIlIllllI) {
            int llllllllllllllllIIIlIlIIIllIlIIl = ScreamTracker3.get_instrument_offset(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIlIllllI);
            if ((llllllllllllllllIIIlIlIIIllIlIIl += 80) <= llllllllllllllllIIIlIlIIIllIIIlI) continue;
            llllllllllllllllIIIlIlIIIllIIIlI = llllllllllllllllIIIlIlIIIllIlIIl;
        }
        for (llllllllllllllllIIIlIlIIIlIlllIl = 0; llllllllllllllllIIIlIlIIIlIlllIl < llllllllllllllllIIIlIlIIIlIlllll; ++llllllllllllllllIIIlIlIIIlIlllIl) {
            int llllllllllllllllIIIlIlIIIllIlIII = ScreamTracker3.get_pattern_offset(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIlIlllIl);
            if ((llllllllllllllllIIIlIlIIIllIlIII += 2) <= llllllllllllllllIIIlIlIIIllIIIlI) continue;
            llllllllllllllllIIIlIlIIIllIIIlI = llllllllllllllllIIIlIlIIIllIlIII;
        }
        llllllllllllllllIIIlIlIIIlIlllII = ScreamTracker3.read_more(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIllIIIlI, llllllllllllllllIIIlIlIIIllIIIll);
        for (llllllllllllllllIIIlIlIIIlIllllI = 0; llllllllllllllllIIIlIlIIIlIllllI < llllllllllllllllIIIlIlIIIllIIIII; ++llllllllllllllllIIIlIlIIIlIllllI) {
            int llllllllllllllllIIIlIlIIIllIIlll = ScreamTracker3.get_instrument_offset(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIlIllllI);
            int llllllllllllllllIIIlIlIIIllIIllI = ScreamTracker3.get_sample_data_offset(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIllIIlll);
            if ((llllllllllllllllIIIlIlIIIllIIllI += ScreamTracker3.get_sample_data_length(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIllIIlll)) <= llllllllllllllllIIIlIlIIIllIIIlI) continue;
            llllllllllllllllIIIlIlIIIllIIIlI = llllllllllllllllIIIlIlIIIllIIllI;
        }
        for (llllllllllllllllIIIlIlIIIlIlllIl = 0; llllllllllllllllIIIlIlIIIlIlllIl < llllllllllllllllIIIlIlIIIlIlllll; ++llllllllllllllllIIIlIlIIIlIlllIl) {
            int llllllllllllllllIIIlIlIIIllIIlIl = ScreamTracker3.get_pattern_offset(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIlIlllIl);
            llllllllllllllllIIIlIlIIIllIIlIl += ScreamTracker3.get_pattern_length(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIllIIlIl);
            if ((llllllllllllllllIIIlIlIIIllIIlIl += 2) <= llllllllllllllllIIIlIlIIIllIIIlI) continue;
            llllllllllllllllIIIlIlIIIllIIIlI = llllllllllllllllIIIlIlIIIllIIlIl;
        }
        llllllllllllllllIIIlIlIIIlIlllII = ScreamTracker3.read_more(llllllllllllllllIIIlIlIIIlIlllII, llllllllllllllllIIIlIlIIIllIIIlI, llllllllllllllllIIIlIlIIIllIIIll);
        return llllllllllllllllIIIlIlIIIlIlllII;
    }
}

