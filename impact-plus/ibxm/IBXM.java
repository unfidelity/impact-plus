/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Channel;
import ibxm.Module;
import ibxm.Pattern;
import java.nio.ByteOrder;

public class IBXM {
    public static final /* synthetic */ int FP_ONE;
    private /* synthetic */ int tick_counter;
    private /* synthetic */ int[] volume_ramp_buffer;
    private /* synthetic */ Channel[] channels;
    private /* synthetic */ int tick_length_samples;
    private /* synthetic */ int current_sequence_index;
    public static final /* synthetic */ String VERSION;
    private /* synthetic */ int next_sequence_index;
    private /* synthetic */ int ticks_per_row;
    public static final /* synthetic */ int FP_MASK;
    public static final /* synthetic */ int FP_SHIFT;
    private /* synthetic */ int next_row;
    private /* synthetic */ Module module;
    private /* synthetic */ int pattern_loop_channel;
    private /* synthetic */ int[] note;
    private /* synthetic */ int volume_ramp_length;
    private /* synthetic */ int sampling_rate;
    private /* synthetic */ int[] global_volume;
    private /* synthetic */ int pattern_loop_count;
    private /* synthetic */ int resampling_quality;
    private /* synthetic */ int current_row;
    private /* synthetic */ int[] mixing_buffer;
    private /* synthetic */ int current_tick_samples;

    private void set_tempo(int llllIlIllIIIll) {
        if (llllIlIllIIIll > 31 && llllIlIllIIIll < 256) {
            IBXM llllIlIllIIlII;
            llllIlIllIIlII.tick_length_samples = llllIlIllIIlII.sampling_rate * 5 / (llllIlIllIIIll * 2);
        }
    }

    public void set_sequence_index(int llllIlllIllIII, int llllIlllIlIlll) {
        IBXM llllIlllIlllIl;
        llllIlllIlllIl.global_volume[0] = 64;
        for (int llllIlllIllIlI = 0; llllIlllIllIlI < llllIlllIlllIl.channels.length; ++llllIlllIllIlI) {
            llllIlllIlllIl.channels[llllIlllIllIlI].reset();
            llllIlllIlllIl.channels[llllIlllIllIlI].set_panning(llllIlllIlllIl.module.get_initial_panning(llllIlllIllIlI));
        }
        llllIlllIlllIl.set_global_volume(llllIlllIlllIl.module.global_volume);
        llllIlllIlllIl.set_speed(6);
        llllIlllIlllIl.set_speed(llllIlllIlllIl.module.default_speed);
        llllIlllIlllIl.set_tempo(125);
        llllIlllIlllIl.set_tempo(llllIlllIlllIl.module.default_tempo);
        llllIlllIlllIl.pattern_loop_count = -1;
        llllIlllIlllIl.next_sequence_index = llllIlllIllIII;
        llllIlllIlllIl.next_row = llllIlllIlIlll;
        llllIlllIlllIl.tick_counter = 0;
        llllIlllIlllIl.current_tick_samples = llllIlllIlllIl.tick_length_samples;
    }

    private void volume_ramp() {
        IBXM llllIlIlIlIlII;
        int llllIlIlIlIlIl = 0;
        int llllIlIlIlIlll = 32768 / llllIlIlIlIlII.volume_ramp_length;
        int llllIlIlIlIllI = 0;
        int llllIlIlIllIIl = 2 * llllIlIlIlIlII.tick_length_samples;
        int llllIlIlIllIII = llllIlIlIlIlII.volume_ramp_length * 2 - 1;
        for (int llllIlIlIllIlI = 0; llllIlIlIllIlI <= llllIlIlIllIII; llllIlIlIllIlI += 2) {
            llllIlIlIlIlIl = llllIlIlIlIlII.volume_ramp_buffer[llllIlIlIllIlI] * (32768 - llllIlIlIlIllI) >> 15;
            llllIlIlIlIlII.mixing_buffer[llllIlIlIllIlI] = llllIlIlIlIlIl + (llllIlIlIlIlII.mixing_buffer[llllIlIlIllIlI] * llllIlIlIlIllI >> 15);
            llllIlIlIlIlII.volume_ramp_buffer[llllIlIlIllIlI] = llllIlIlIlIlII.mixing_buffer[llllIlIlIllIIl + llllIlIlIllIlI];
            llllIlIlIlIlIl = llllIlIlIlIlII.volume_ramp_buffer[llllIlIlIllIlI + 1] * (32768 - llllIlIlIlIllI) >> 15;
            llllIlIlIlIlII.mixing_buffer[llllIlIlIllIlI + 1] = llllIlIlIlIlIl + (llllIlIlIlIlII.mixing_buffer[llllIlIlIllIlI + 1] * llllIlIlIlIllI >> 15);
            llllIlIlIlIlII.volume_ramp_buffer[llllIlIlIllIlI + 1] = llllIlIlIlIlII.mixing_buffer[llllIlIlIllIIl + llllIlIlIllIlI + 1];
            llllIlIlIlIllI += llllIlIlIlIlll;
        }
    }

    static {
        FP_ONE = 32768;
        FP_SHIFT = 15;
        VERSION = "ibxm alpha 45 (c)2006 mumart@gmail.com";
        FP_MASK = Short.MAX_VALUE;
    }

    public int calculate_song_duration() {
        IBXM llllIllllIIlIl;
        llllIllllIIlIl.set_sequence_index(0, 0);
        llllIllllIIlIl.next_tick();
        int llllIllllIIllI = llllIllllIIlIl.tick_length_samples;
        while (!llllIllllIIlIl.next_tick()) {
            llllIllllIIllI += llllIllllIIlIl.tick_length_samples;
        }
        llllIllllIIlIl.set_sequence_index(0, 0);
        return llllIllllIIllI;
    }

    private boolean next_tick() {
        boolean llllIllIlIIIlI;
        IBXM llllIllIlIIIIl;
        int llllIllIlIIIll;
        for (llllIllIlIIIll = 0; llllIllIlIIIll < llllIllIlIIIIl.channels.length; ++llllIllIlIIIll) {
            llllIllIlIIIIl.channels[llllIllIlIIIll].update_sample_idx(llllIllIlIIIIl.tick_length_samples);
        }
        --llllIllIlIIIIl.tick_counter;
        if (llllIllIlIIIIl.tick_counter <= 0) {
            llllIllIlIIIIl.tick_counter = llllIllIlIIIIl.ticks_per_row;
            boolean llllIllIlIIlIl = llllIllIlIIIIl.next_row();
        } else {
            for (llllIllIlIIIll = 0; llllIllIlIIIll < llllIllIlIIIIl.channels.length; ++llllIllIlIIIll) {
                llllIllIlIIIIl.channels[llllIllIlIIIll].tick();
            }
            llllIllIlIIIlI = false;
        }
        return llllIllIlIIIlI;
    }

    public IBXM(int lllllIIIIlIlII) {
        IBXM lllllIIIIlIlll;
        System.out.println("ibxm alpha 45 (c)2006 mumart@gmail.com");
        if (lllllIIIIlIlII < 8000) {
            lllllIIIIlIlII = 8000;
        }
        lllllIIIIlIlll.sampling_rate = lllllIIIIlIlII;
        lllllIIIIlIlll.volume_ramp_length = lllllIIIIlIlll.sampling_rate >> 10;
        lllllIIIIlIlll.volume_ramp_buffer = new int[lllllIIIIlIlll.volume_ramp_length * 2];
        lllllIIIIlIlll.mixing_buffer = new int[lllllIIIIlIlll.sampling_rate / 6];
        lllllIIIIlIlll.global_volume = new int[1];
        lllllIIIIlIlll.note = new int[5];
        lllllIIIIlIlll.set_module(new Module());
        lllllIIIIlIlll.set_resampling_quality(1);
    }

    private void mix_tick() {
        IBXM llllIllIlIllII;
        int llllIllIlIllIl = llllIllIlIllII.tick_length_samples + llllIllIlIllII.volume_ramp_length << 1;
        for (int llllIllIlIlllI = 0; llllIllIlIlllI < llllIllIlIllIl; ++llllIllIlIlllI) {
            llllIllIlIllII.mixing_buffer[llllIllIlIlllI] = 0;
        }
        for (int llllIllIlIllll = 0; llllIllIlIllll < llllIllIlIllII.channels.length; ++llllIllIlIllll) {
            llllIllIlIllIl = llllIllIlIllII.tick_length_samples + llllIllIlIllII.volume_ramp_length;
            llllIllIlIllII.channels[llllIllIlIllll].resample(llllIllIlIllII.mixing_buffer, 0, llllIllIlIllIl, llllIllIlIllII.resampling_quality);
        }
        llllIllIlIllII.volume_ramp();
    }

    private void set_speed(int llllIlIllIlIIl) {
        if (llllIlIllIlIIl > 0 && llllIlIllIlIIl < 256) {
            llllIlIllIllII.ticks_per_row = llllIlIllIlIIl;
        }
    }

    public void get_audio(byte[] llllIllIllllII, int llllIlllIIIIII) {
        boolean llllIllIllllll = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
        int llllIllIlllllI = 0;
        while (llllIlllIIIIII > 0) {
            int llllIlllIIIlIl;
            IBXM llllIllIllllIl;
            int llllIlllIIIIll = llllIllIllllIl.tick_length_samples - llllIllIllllIl.current_tick_samples;
            if (llllIlllIIIIll > llllIlllIIIIII) {
                llllIlllIIIIll = llllIlllIIIIII;
            }
            int llllIlllIIIlII = llllIlllIIIlIl + (llllIlllIIIIll << 1) - 1;
            for (llllIlllIIIlIl = llllIllIllllIl.current_tick_samples << 1; llllIlllIIIlIl <= llllIlllIIIlII; ++llllIlllIIIlIl) {
                int llllIlllIIIllI = llllIllIllllIl.mixing_buffer[llllIlllIIIlIl];
                if (llllIlllIIIllI > Short.MAX_VALUE) {
                    llllIlllIIIllI = Short.MAX_VALUE;
                }
                if (llllIlllIIIllI < Short.MIN_VALUE) {
                    llllIlllIIIllI = Short.MIN_VALUE;
                }
                if (llllIllIllllll) {
                    llllIllIllllII[llllIllIlllllI] = (byte)(llllIlllIIIllI >> 8);
                    llllIllIllllII[llllIllIlllllI + 1] = (byte)(llllIlllIIIllI & 0xFF);
                } else {
                    llllIllIllllII[llllIllIlllllI] = (byte)(llllIlllIIIllI & 0xFF);
                    llllIllIllllII[llllIllIlllllI + 1] = (byte)(llllIlllIIIllI >> 8);
                }
                llllIllIlllllI += 2;
            }
            llllIllIllllIl.current_tick_samples = llllIlllIIIlIl >> 1;
            if ((llllIlllIIIIII -= llllIlllIIIIll) <= 0) continue;
            llllIllIllllIl.next_tick();
            llllIllIllllIl.mix_tick();
            llllIllIllllIl.current_tick_samples = 0;
        }
    }

    public void set_module(Module lllllIIIIIIIIl) {
        IBXM lllllIIIIIIIlI;
        lllllIIIIIIIlI.module = lllllIIIIIIIIl;
        lllllIIIIIIIlI.channels = new Channel[lllllIIIIIIIlI.module.get_num_channels()];
        for (int lllllIIIIIIIII = 0; lllllIIIIIIIII < lllllIIIIIIIlI.channels.length; ++lllllIIIIIIIII) {
            lllllIIIIIIIlI.channels[lllllIIIIIIIII] = new Channel(lllllIIIIIIIlI.module, lllllIIIIIIIlI.sampling_rate, lllllIIIIIIIlI.global_volume);
        }
        lllllIIIIIIIlI.set_sequence_index(0, 0);
    }

    public void seek(int llllIlllIlIIlI) {
        IBXM llllIlllIlIIIl;
        llllIlllIlIIIl.set_sequence_index(0, 0);
        llllIlllIlIIIl.next_tick();
        while (llllIlllIlIIlI > llllIlllIlIIIl.tick_length_samples) {
            llllIlllIlIIlI -= llllIlllIlIIIl.tick_length_samples;
            llllIlllIlIIIl.next_tick();
        }
        llllIlllIlIIIl.next_tick();
        llllIlllIlIIIl.current_tick_samples = llllIlllIlIIlI;
    }

    public void set_resampling_quality(int llllIllllllIIl) {
        llllIllllllIII.resampling_quality = llllIllllllIIl;
    }

    private boolean next_row() {
        IBXM llllIlIllllllI;
        boolean llllIlIlllllII = false;
        if (llllIlIllllllI.next_sequence_index < 0) {
            llllIlIllllllI.next_sequence_index = 0;
            llllIlIllllllI.next_row = 0;
        }
        if (llllIlIllllllI.next_sequence_index >= llllIlIllllllI.module.get_sequence_length()) {
            llllIlIlllllII = true;
            llllIlIllllllI.next_sequence_index = llllIlIllllllI.module.restart_sequence_index;
            if (llllIlIllllllI.next_sequence_index < 0) {
                llllIlIllllllI.next_sequence_index = 0;
            }
            if (llllIlIllllllI.next_sequence_index >= llllIlIllllllI.module.get_sequence_length()) {
                llllIlIllllllI.next_sequence_index = 0;
            }
            llllIlIllllllI.next_row = 0;
        }
        if (llllIlIllllllI.next_sequence_index < llllIlIllllllI.current_sequence_index) {
            llllIlIlllllII = true;
        }
        if (llllIlIllllllI.next_sequence_index == llllIlIllllllI.current_sequence_index && llllIlIllllllI.next_row <= llllIlIllllllI.current_row && llllIlIllllllI.pattern_loop_count < 0) {
            llllIlIlllllII = true;
        }
        llllIlIllllllI.current_sequence_index = llllIlIllllllI.next_sequence_index;
        Pattern llllIlIllllIll = llllIlIllllllI.module.get_pattern_from_sequence(llllIlIllllllI.current_sequence_index);
        if (llllIlIllllllI.next_row < 0 || llllIlIllllllI.next_row >= llllIlIllllIll.num_rows) {
            llllIlIllllllI.next_row = 0;
        }
        llllIlIllllllI.current_row = llllIlIllllllI.next_row;
        llllIlIllllllI.next_row = llllIlIllllllI.current_row + 1;
        if (llllIlIllllllI.next_row >= llllIlIllllIll.num_rows) {
            llllIlIllllllI.next_sequence_index = llllIlIllllllI.current_sequence_index + 1;
            llllIlIllllllI.next_row = 0;
        }
        block11: for (int llllIlIlllllIl = 0; llllIlIlllllIl < llllIlIllllllI.channels.length; ++llllIlIlllllIl) {
            llllIlIllllIll.get_note(llllIlIllllllI.note, llllIlIllllllI.current_row * llllIlIllllllI.channels.length + llllIlIlllllIl);
            int llllIllIIIIIII = llllIlIllllllI.note[3];
            int llllIlIlllllll = llllIlIllllllI.note[4];
            llllIlIllllllI.channels[llllIlIlllllIl].row(llllIlIllllllI.note[0], llllIlIllllllI.note[1], llllIlIllllllI.note[2], llllIllIIIIIII, llllIlIlllllll);
            switch (llllIllIIIIIII) {
                case 11: {
                    if (llllIlIllllllI.pattern_loop_count >= 0) continue block11;
                    llllIlIllllllI.next_sequence_index = llllIlIlllllll;
                    llllIlIllllllI.next_row = 0;
                    continue block11;
                }
                case 13: {
                    if (llllIlIllllllI.pattern_loop_count >= 0) continue block11;
                    llllIlIllllllI.next_sequence_index = llllIlIllllllI.current_sequence_index + 1;
                    llllIlIllllllI.next_row = (llllIlIlllllll >> 4) * 10 + (llllIlIlllllll & 0xF);
                    continue block11;
                }
                case 14: {
                    switch (llllIlIlllllll & 0xF0) {
                        case 96: {
                            if ((llllIlIlllllll & 0xF) == 0) {
                                llllIlIllllllI.channels[llllIlIlllllIl].pattern_loop_row = llllIlIllllllI.current_row;
                            }
                            if (llllIlIllllllI.channels[llllIlIlllllIl].pattern_loop_row >= llllIlIllllllI.current_row) break;
                            if (llllIlIllllllI.pattern_loop_count < 0) {
                                llllIlIllllllI.pattern_loop_count = llllIlIlllllll & 0xF;
                                llllIlIllllllI.pattern_loop_channel = llllIlIlllllIl;
                            }
                            if (llllIlIllllllI.pattern_loop_channel != llllIlIlllllIl) break;
                            if (llllIlIllllllI.pattern_loop_count == 0) {
                                llllIlIllllllI.channels[llllIlIlllllIl].pattern_loop_row = llllIlIllllllI.current_row + 1;
                            } else {
                                llllIlIllllllI.next_row = llllIlIllllllI.channels[llllIlIlllllIl].pattern_loop_row;
                                llllIlIllllllI.next_sequence_index = llllIlIllllllI.current_sequence_index;
                            }
                            --llllIlIllllllI.pattern_loop_count;
                            break;
                        }
                        case 224: {
                            llllIlIllllllI.tick_counter += llllIlIllllllI.ticks_per_row * (llllIlIlllllll & 0xF);
                        }
                    }
                    continue block11;
                }
                case 15: {
                    if (llllIlIlllllll < 32) {
                        llllIlIllllllI.set_speed(llllIlIlllllll);
                        llllIlIllllllI.tick_counter = llllIlIllllllI.ticks_per_row;
                        continue block11;
                    }
                    llllIlIllllllI.set_tempo(llllIlIlllllll);
                    continue block11;
                }
                case 37: {
                    llllIlIllllllI.set_speed(llllIlIlllllll);
                    llllIlIllllllI.tick_counter = llllIlIllllllI.ticks_per_row;
                }
            }
        }
        return llllIlIlllllII;
    }

    private void set_global_volume(int llllIlIllIllll) {
        if (llllIlIllIllll < 0) {
            llllIlIllIllll = 0;
        }
        if (llllIlIllIllll > 64) {
            llllIlIllIllll = 64;
        }
        llllIlIlllIIlI.global_volume[0] = llllIlIllIllll;
    }
}

