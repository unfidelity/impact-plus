/*
 * Decompiled with CFR 0.152.
 */
package ibxm;

import ibxm.Envelope;
import ibxm.Instrument;
import ibxm.LogTable;
import ibxm.Module;
import ibxm.Sample;

public class Channel {
    private /* synthetic */ int tremolo_speed;
    private /* synthetic */ int vibrato_wave;
    private /* synthetic */ int fine_tune;
    private /* synthetic */ int fade_out_volume;
    private /* synthetic */ int panning_envelope_tick;
    private /* synthetic */ int log_2_c2_rate;
    private /* synthetic */ int retrig_param;
    private /* synthetic */ Sample sample;
    public /* synthetic */ int pattern_loop_row;
    private /* synthetic */ int sample_frac;
    private /* synthetic */ int sample_idx;
    private /* synthetic */ int vibrato_add;
    private /* synthetic */ int effect_tick;
    private /* synthetic */ int volume_slide_param;
    private /* synthetic */ int volume_envelope_tick;
    private /* synthetic */ int panning;
    private /* synthetic */ Module module;
    private static final /* synthetic */ int[] sine_table;
    private /* synthetic */ int vibrato_tick;
    private /* synthetic */ int porta_period;
    private /* synthetic */ int period;
    private /* synthetic */ Instrument instrument;
    private /* synthetic */ boolean key_on;
    private static final /* synthetic */ int LOG_2_1712;
    private /* synthetic */ int volume;
    private static final /* synthetic */ int LOG_2_29024;
    private /* synthetic */ int tremolo_tick;
    private /* synthetic */ int[] global_volume;
    private /* synthetic */ int tremolo_wave;
    private /* synthetic */ int random_seed;
    private /* synthetic */ int right_gain;
    private /* synthetic */ int left_gain;
    private /* synthetic */ int step;
    private /* synthetic */ int portamento_param;
    private /* synthetic */ int vibrato_depth;
    private /* synthetic */ int[] current_note;
    private /* synthetic */ int log_2_sampling_rate;
    private /* synthetic */ int key_add;
    private /* synthetic */ boolean linear_periods;
    private /* synthetic */ int tremolo_depth;
    private /* synthetic */ int vibrato_speed;
    private /* synthetic */ boolean silent;
    private /* synthetic */ int tremolo_add;
    private /* synthetic */ boolean fast_volume_slides;
    private /* synthetic */ int trigger_tick;

    private void update_envelopes() {
        Channel llllllllllllllllIIIllIllllllIIII;
        if (llllllllllllllllIIIllIllllllIIII.instrument.volume_envelope_active) {
            if (!llllllllllllllllIIIllIllllllIIII.key_on) {
                llllllllllllllllIIIllIllllllIIII.fade_out_volume -= llllllllllllllllIIIllIllllllIIII.instrument.volume_fade_out & 0xFFFF;
                if (llllllllllllllllIIIllIllllllIIII.fade_out_volume < 0) {
                    llllllllllllllllIIIllIllllllIIII.fade_out_volume = 0;
                }
            }
            Envelope llllllllllllllllIIIllIllllllIIll = llllllllllllllllIIIllIllllllIIII.instrument.get_volume_envelope();
            llllllllllllllllIIIllIllllllIIII.volume_envelope_tick = llllllllllllllllIIIllIllllllIIll.next_tick(llllllllllllllllIIIllIllllllIIII.volume_envelope_tick, llllllllllllllllIIIllIllllllIIII.key_on);
        }
        if (llllllllllllllllIIIllIllllllIIII.instrument.panning_envelope_active) {
            Envelope llllllllllllllllIIIllIllllllIIlI = llllllllllllllllIIIllIllllllIIII.instrument.get_panning_envelope();
            llllllllllllllllIIIllIllllllIIII.panning_envelope_tick = llllllllllllllllIIIllIllllllIIlI.next_tick(llllllllllllllllIIIllIllllllIIII.panning_envelope_tick, llllllllllllllllIIIllIllllllIIII.key_on);
        }
    }

    private void set_retrig_param(int llllllllllllllllIIIlllIIIllIlllI) {
        if (llllllllllllllllIIIlllIIIllIlllI != 0) {
            llllllllllllllllIIIlllIIIlllIIIl.retrig_param = llllllllllllllllIIIlllIIIllIlllI;
        }
    }

    public void tick() {
        Channel llllllllllllllllIIIlllIlIIlIIIIl;
        int llllllllllllllllIIIlllIlIIlIIlII = llllllllllllllllIIIlllIlIIlIIIIl.current_note[2];
        int llllllllllllllllIIIlllIlIIlIIIll = llllllllllllllllIIIlllIlIIlIIIIl.current_note[3];
        int llllllllllllllllIIIlllIlIIlIIIlI = llllllllllllllllIIIlllIlIIlIIIIl.current_note[4];
        ++llllllllllllllllIIIlllIlIIlIIIIl.effect_tick;
        if (llllllllllllllllIIIlllIlIIlIIIll == 61 && llllllllllllllllIIIlllIlIIlIIIlI == llllllllllllllllIIIlllIlIIlIIIIl.effect_tick) {
            llllllllllllllllIIIlllIlIIlIIIIl.row(llllllllllllllllIIIlllIlIIlIIIIl.current_note[0], llllllllllllllllIIIlllIlIIlIIIIl.current_note[1], llllllllllllllllIIIlllIlIIlIIlII, 0, 0);
        } else {
            ++llllllllllllllllIIIlllIlIIlIIIIl.trigger_tick;
            ++llllllllllllllllIIIlllIlIIlIIIIl.vibrato_tick;
            ++llllllllllllllllIIIlllIlIIlIIIIl.tremolo_tick;
            llllllllllllllllIIIlllIlIIlIIIIl.update_envelopes();
            llllllllllllllllIIIlllIlIIlIIIIl.key_add = 0;
            llllllllllllllllIIIlllIlIIlIIIIl.vibrato_add = 0;
            llllllllllllllllIIIlllIlIIlIIIIl.tremolo_add = 0;
            if (llllllllllllllllIIIlllIlIIlIIIIl.instrument.vibrato_depth > 0) {
                llllllllllllllllIIIlllIlIIlIIIIl.auto_vibrato();
            }
            switch (llllllllllllllllIIIlllIlIIlIIlII & 0xF0) {
                case 96: {
                    llllllllllllllllIIIlllIlIIlIIIIl.set_volume(llllllllllllllllIIIlllIlIIlIIIIl.volume - (llllllllllllllllIIIlllIlIIlIIlII & 0xF));
                    break;
                }
                case 112: {
                    llllllllllllllllIIIlllIlIIlIIIIl.set_volume(llllllllllllllllIIIlllIlIIlIIIIl.volume + (llllllllllllllllIIIlllIlIIlIIlII & 0xF));
                    break;
                }
                case 176: {
                    llllllllllllllllIIIlllIlIIlIIIIl.vibrato();
                    break;
                }
                case 208: {
                    llllllllllllllllIIIlllIlIIlIIIIl.set_panning(llllllllllllllllIIIlllIlIIlIIIIl.panning - (llllllllllllllllIIIlllIlIIlIIlII & 0xF));
                    break;
                }
                case 224: {
                    llllllllllllllllIIIlllIlIIlIIIIl.set_panning(llllllllllllllllIIIlllIlIIlIIIIl.panning + (llllllllllllllllIIIlllIlIIlIIlII & 0xF));
                    break;
                }
                case 240: {
                    llllllllllllllllIIIlllIlIIlIIIIl.tone_portamento();
                }
            }
            block8 : switch (llllllllllllllllIIIlllIlIIlIIIll) {
                case 1: {
                    llllllllllllllllIIIlllIlIIlIIIIl.portamento_up();
                    break;
                }
                case 2: {
                    llllllllllllllllIIIlllIlIIlIIIIl.portamento_down();
                    break;
                }
                case 3: {
                    llllllllllllllllIIIlllIlIIlIIIIl.tone_portamento();
                    break;
                }
                case 4: {
                    llllllllllllllllIIIlllIlIIlIIIIl.vibrato();
                    break;
                }
                case 5: {
                    llllllllllllllllIIIlllIlIIlIIIIl.tone_portamento();
                    llllllllllllllllIIIlllIlIIlIIIIl.volume_slide();
                    break;
                }
                case 6: {
                    llllllllllllllllIIIlllIlIIlIIIIl.vibrato();
                    llllllllllllllllIIIlllIlIIlIIIIl.volume_slide();
                    break;
                }
                case 7: {
                    llllllllllllllllIIIlllIlIIlIIIIl.tremolo();
                    break;
                }
                case 10: {
                    llllllllllllllllIIIlllIlIIlIIIIl.volume_slide();
                    break;
                }
                case 17: {
                    llllllllllllllllIIIlllIlIIlIIIIl.global_volume_slide();
                    break;
                }
                case 20: {
                    if (llllllllllllllllIIIlllIlIIlIIIIl.effect_tick != llllllllllllllllIIIlllIlIIlIIIlI) break;
                    llllllllllllllllIIIlllIlIIlIIIIl.key_on = false;
                    break;
                }
                case 25: {
                    llllllllllllllllIIIlllIlIIlIIIIl.panning_slide();
                    break;
                }
                case 27: {
                    llllllllllllllllIIIlllIlIIlIIIIl.retrig_volume_slide();
                    break;
                }
                case 29: {
                    llllllllllllllllIIIlllIlIIlIIIIl.tremor();
                    break;
                }
                case 36: {
                    llllllllllllllllIIIlllIlIIlIIIIl.fine_vibrato();
                    break;
                }
                case 57: {
                    llllllllllllllllIIIlllIlIIlIIIIl.retrig_volume_slide();
                    break;
                }
                case 60: {
                    if (llllllllllllllllIIIlllIlIIlIIIIl.effect_tick != llllllllllllllllIIIlllIlIIlIIIlI) break;
                    llllllllllllllllIIIlllIlIIlIIIIl.set_volume(0);
                    break;
                }
                case 64: {
                    switch (llllllllllllllllIIIlllIlIIlIIIIl.effect_tick % 3) {
                        case 1: {
                            llllllllllllllllIIIlllIlIIlIIIIl.key_add = (llllllllllllllllIIIlllIlIIlIIIlI & 0xF0) >> 4;
                            break block8;
                        }
                        case 2: {
                            llllllllllllllllIIIlllIlIIlIIIIl.key_add = llllllllllllllllIIIlllIlIIlIIIlI & 0xF;
                        }
                    }
                }
            }
        }
        llllllllllllllllIIIlllIlIIlIIIIl.calculate_amplitude();
        llllllllllllllllIIIlllIlIIlIIIIl.calculate_frequency();
    }

    private void tremolo() {
        Channel llllllllllllllllIIIlllIIlIllIlIl;
        int llllllllllllllllIIIlllIIlIllIllI = llllllllllllllllIIIlllIIlIllIlIl.tremolo_tick * llllllllllllllllIIIlllIIlIllIlIl.tremolo_speed;
        llllllllllllllllIIIlllIIlIllIlIl.tremolo_add += llllllllllllllllIIIlllIIlIllIlIl.waveform(llllllllllllllllIIIlllIIlIllIllI, llllllllllllllllIIIlllIIlIllIlIl.tremolo_wave) * llllllllllllllllIIIlllIIlIllIlIl.tremolo_depth >> 6;
    }

    private void fine_vibrato() {
        Channel llllllllllllllllIIIlllIIllIIIlll;
        int llllllllllllllllIIIlllIIllIIIlIl = llllllllllllllllIIIlllIIllIIIlll.vibrato_tick * llllllllllllllllIIIlllIIllIIIlll.vibrato_speed;
        llllllllllllllllIIIlllIIllIIIlll.vibrato_add += llllllllllllllllIIIlllIIllIIIlll.waveform(llllllllllllllllIIIlllIIllIIIlIl, llllllllllllllllIIIlllIIllIIIlll.vibrato_wave) * llllllllllllllllIIIlllIIllIIIlll.vibrato_depth >> 7;
    }

    public void resample(int[] llllllllllllllllIIIlllIlllIIlIIl, int llllllllllllllllIIIlllIlllIIllIl, int llllllllllllllllIIIlllIlllIIIlll, int llllllllllllllllIIIlllIlllIIIllI) {
        Channel llllllllllllllllIIIlllIlllIIlIlI;
        if (!llllllllllllllllIIIlllIlllIIlIlI.silent) {
            switch (llllllllllllllllIIIlllIlllIIIllI) {
                default: {
                    llllllllllllllllIIIlllIlllIIlIlI.sample.resample_nearest(llllllllllllllllIIIlllIlllIIlIlI.sample_idx, llllllllllllllllIIIlllIlllIIlIlI.sample_frac, llllllllllllllllIIIlllIlllIIlIlI.step, llllllllllllllllIIIlllIlllIIlIlI.left_gain, llllllllllllllllIIIlllIlllIIlIlI.right_gain, llllllllllllllllIIIlllIlllIIlIIl, llllllllllllllllIIIlllIlllIIllIl, llllllllllllllllIIIlllIlllIIIlll);
                    break;
                }
                case 1: {
                    llllllllllllllllIIIlllIlllIIlIlI.sample.resample_linear(llllllllllllllllIIIlllIlllIIlIlI.sample_idx, llllllllllllllllIIIlllIlllIIlIlI.sample_frac, llllllllllllllllIIIlllIlllIIlIlI.step, llllllllllllllllIIIlllIlllIIlIlI.left_gain, llllllllllllllllIIIlllIlllIIlIlI.right_gain, llllllllllllllllIIIlllIlllIIlIIl, llllllllllllllllIIIlllIlllIIllIl, llllllllllllllllIIIlllIlllIIIlll);
                    break;
                }
                case 2: {
                    llllllllllllllllIIIlllIlllIIlIlI.sample.resample_sinc(llllllllllllllllIIIlllIlllIIlIlI.sample_idx, llllllllllllllllIIIlllIlllIIlIlI.sample_frac, llllllllllllllllIIIlllIlllIIlIlI.step, llllllllllllllllIIIlllIlllIIlIlI.left_gain, llllllllllllllllIIIlllIlllIIlIlI.right_gain, llllllllllllllllIIIlllIlllIIlIIl, llllllllllllllllIIIlllIlllIIllIl, llllllllllllllllIIIlllIlllIIIlll);
                }
            }
        }
    }

    private void portamento_down() {
        Channel llllllllllllllllIIIlllIIlIlIIIlI;
        if ((llllllllllllllllIIIlllIIlIlIIIlI.portamento_param & 0xF0) == 224) {
            if (llllllllllllllllIIIlllIIlIlIIIlI.effect_tick == 0) {
                llllllllllllllllIIIlllIIlIlIIIlI.set_period(llllllllllllllllIIIlllIIlIlIIIlI.period + (llllllllllllllllIIIlllIIlIlIIIlI.portamento_param & 0xF));
            }
        } else if ((llllllllllllllllIIIlllIIlIlIIIlI.portamento_param & 0xF0) == 240) {
            if (llllllllllllllllIIIlllIIlIlIIIlI.effect_tick == 0) {
                llllllllllllllllIIIlllIIlIlIIIlI.set_period(llllllllllllllllIIIlllIIlIlIIIlI.period + ((llllllllllllllllIIIlllIIlIlIIIlI.portamento_param & 0xF) << 2));
            }
        } else if (llllllllllllllllIIIlllIIlIlIIIlI.effect_tick > 0) {
            llllllllllllllllIIIlllIIlIlIIIlI.set_period(llllllllllllllllIIIlllIIlIlIIIlI.period + (llllllllllllllllIIIlllIIlIlIIIlI.portamento_param << 2));
        }
    }

    private void volume_slide() {
        Channel llllllllllllllllIIIlllIIIlllllll;
        int llllllllllllllllIIIlllIIlIIIIIIl = (llllllllllllllllIIIlllIIIlllllll.volume_slide_param & 0xF0) >> 4;
        int llllllllllllllllIIIlllIIlIIIIIII = llllllllllllllllIIIlllIIIlllllll.volume_slide_param & 0xF;
        if (llllllllllllllllIIIlllIIlIIIIIII == 15 && llllllllllllllllIIIlllIIlIIIIIIl > 0) {
            if (llllllllllllllllIIIlllIIIlllllll.effect_tick == 0) {
                llllllllllllllllIIIlllIIIlllllll.set_volume(llllllllllllllllIIIlllIIIlllllll.volume + llllllllllllllllIIIlllIIlIIIIIIl);
            }
        } else if (llllllllllllllllIIIlllIIlIIIIIIl == 15 && llllllllllllllllIIIlllIIlIIIIIII > 0) {
            if (llllllllllllllllIIIlllIIIlllllll.effect_tick == 0) {
                llllllllllllllllIIIlllIIIlllllll.set_volume(llllllllllllllllIIIlllIIIlllllll.volume - llllllllllllllllIIIlllIIlIIIIIII);
            }
        } else if (llllllllllllllllIIIlllIIIlllllll.effect_tick > 0 || llllllllllllllllIIIlllIIIlllllll.fast_volume_slides) {
            llllllllllllllllIIIlllIIIlllllll.set_volume(llllllllllllllllIIIlllIIIlllllll.volume + llllllllllllllllIIIlllIIlIIIIIIl - llllllllllllllllIIIlllIIlIIIIIII);
        }
    }

    public void set_volume(int llllllllllllllllIIIlllIllIlllIIl) {
        if (llllllllllllllllIIIlllIllIlllIIl < 0) {
            llllllllllllllllIIIlllIllIlllIIl = 0;
        }
        if (llllllllllllllllIIIlllIllIlllIIl > 64) {
            llllllllllllllllIIIlllIllIlllIIl = 64;
        }
        llllllllllllllllIIIlllIllIlllIlI.volume = llllllllllllllllIIIlllIllIlllIIl;
    }

    private int waveform(int llllllllllllllllIIIllIllllIlllIl, int llllllllllllllllIIIllIllllIllIII) {
        int llllllllllllllllIIIllIllllIllIll = 0;
        switch (llllllllllllllllIIIllIllllIllIII & 3) {
            case 0: {
                if ((llllllllllllllllIIIllIllllIlllIl & 0x20) == 0) {
                    llllllllllllllllIIIllIllllIllIll = sine_table[llllllllllllllllIIIllIllllIlllIl & 0x1F];
                    break;
                }
                llllllllllllllllIIIllIllllIllIll = -sine_table[llllllllllllllllIIIllIllllIlllIl & 0x1F];
                break;
            }
            case 1: {
                if ((llllllllllllllllIIIllIllllIlllIl & 0x20) == 0) {
                    llllllllllllllllIIIllIllllIllIll = (llllllllllllllllIIIllIllllIlllIl & 0x1F) << 3;
                    break;
                }
                llllllllllllllllIIIllIllllIllIll = ((llllllllllllllllIIIllIllllIlllIl & 0x1F) << 3) - 255;
                break;
            }
            case 2: {
                if ((llllllllllllllllIIIllIllllIlllIl & 0x20) == 0) {
                    llllllllllllllllIIIllIllllIllIll = 255;
                    break;
                }
                llllllllllllllllIIIllIllllIllIll = -255;
                break;
            }
            case 3: {
                Channel llllllllllllllllIIIllIllllIllIlI;
                llllllllllllllllIIIllIllllIllIll = (llllllllllllllllIIIllIllllIllIlI.random_seed >> 15) - 255;
                llllllllllllllllIIIllIllllIllIlI.random_seed = llllllllllllllllIIIllIllllIllIlI.random_seed * 65 + 17 & 0xFFFFFF;
            }
        }
        return llllllllllllllllIIIllIllllIllIll;
    }

    private void vibrato() {
        Channel llllllllllllllllIIIlllIIllIlIlIl;
        int llllllllllllllllIIIlllIIllIlIlII = llllllllllllllllIIIlllIIllIlIlIl.vibrato_tick * llllllllllllllllIIIlllIIllIlIlIl.vibrato_speed;
        llllllllllllllllIIIlllIIllIlIlIl.vibrato_add += llllllllllllllllIIIlllIIllIlIlIl.waveform(llllllllllllllllIIIlllIIllIlIlII, llllllllllllllllIIIlllIIllIlIlIl.vibrato_wave) * llllllllllllllllIIIlllIIllIlIlIl.vibrato_depth >> 5;
    }

    private void retrig_volume_slide() {
        Channel llllllllllllllllIIIlllIIIIlIlIII;
        int llllllllllllllllIIIlllIIIIlIlIlI = (llllllllllllllllIIIlllIIIIlIlIII.retrig_param & 0xF0) >> 4;
        int llllllllllllllllIIIlllIIIIlIlIIl = llllllllllllllllIIIlllIIIIlIlIII.retrig_param & 0xF;
        if (llllllllllllllllIIIlllIIIIlIlIIl > 0 && llllllllllllllllIIIlllIIIIlIlIII.trigger_tick % llllllllllllllllIIIlllIIIIlIlIIl == 0) {
            llllllllllllllllIIIlllIIIIlIlIII.set_sample_index(0);
            switch (llllllllllllllllIIIlllIIIIlIlIlI) {
                case 1: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume - 1);
                    break;
                }
                case 2: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume - 2);
                    break;
                }
                case 3: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume - 4);
                    break;
                }
                case 4: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume - 8);
                    break;
                }
                case 5: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume - 16);
                    break;
                }
                case 6: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume - llllllllllllllllIIIlllIIIIlIlIII.volume / 3);
                    break;
                }
                case 7: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume / 2);
                    break;
                }
                case 9: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume + 1);
                    break;
                }
                case 10: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume + 2);
                    break;
                }
                case 11: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume + 4);
                    break;
                }
                case 12: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume + 8);
                    break;
                }
                case 13: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume + 16);
                    break;
                }
                case 14: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume + llllllllllllllllIIIlllIIIIlIlIII.volume / 2);
                    break;
                }
                case 15: {
                    llllllllllllllllIIIlllIIIIlIlIII.set_volume(llllllllllllllllIIIlllIIIIlIlIII.volume * 2);
                }
            }
        }
    }

    public Channel(Module llllllllllllllllIIIlllIlllIllllI, int llllllllllllllllIIIlllIlllIlllIl, int[] llllllllllllllllIIIlllIlllIlllII) {
        Channel llllllllllllllllIIIlllIlllIllIll;
        llllllllllllllllIIIlllIlllIllIll.module = llllllllllllllllIIIlllIlllIllllI;
        llllllllllllllllIIIlllIlllIllIll.global_volume = llllllllllllllllIIIlllIlllIlllII;
        llllllllllllllllIIIlllIlllIllIll.linear_periods = llllllllllllllllIIIlllIlllIllIll.module.linear_periods;
        llllllllllllllllIIIlllIlllIllIll.fast_volume_slides = llllllllllllllllIIIlllIlllIllIll.module.fast_volume_slides;
        llllllllllllllllIIIlllIlllIllIll.current_note = new int[5];
        llllllllllllllllIIIlllIlllIllIll.log_2_sampling_rate = LogTable.log_2(llllllllllllllllIIIlllIlllIlllIl);
    }

    private void trigger(int llllllllllllllllIIIllIlllllllllI, int llllllllllllllllIIIllIllllllllIl, int llllllllllllllllIIIllIllllllllII, int llllllllllllllllIIIllIllllllIllI) {
        Channel llllllllllllllllIIIllIllllllllll;
        if (llllllllllllllllIIIllIllllllllIl > 0) {
            llllllllllllllllIIIllIllllllllll.instrument = llllllllllllllllIIIllIllllllllll.module.get_instrument(llllllllllllllllIIIllIllllllllIl);
            llllllllllllllllIIIllIllllllllll.sample = llllllllllllllllIIIllIllllllllll.instrument.get_sample_from_key(llllllllllllllllIIIllIlllllllllI);
            llllllllllllllllIIIllIllllllllll.set_volume(llllllllllllllllIIIllIllllllllll.sample.volume);
            if (llllllllllllllllIIIllIllllllllll.sample.set_panning) {
                llllllllllllllllIIIllIllllllllll.set_panning(llllllllllllllllIIIllIllllllllll.sample.panning);
            }
            llllllllllllllllIIIllIllllllllll.log_2_c2_rate = LogTable.log_2(llllllllllllllllIIIllIllllllllll.sample.c2_rate);
            llllllllllllllllIIIllIllllllllll.set_envelope_tick(0);
            llllllllllllllllIIIllIllllllllll.fade_out_volume = 32768;
            llllllllllllllllIIIllIllllllllll.key_on = true;
        }
        if (llllllllllllllllIIIllIlllllllllI > 0) {
            if (llllllllllllllllIIIllIlllllllllI < 97) {
                llllllllllllllllIIIllIllllllllll.porta_period = llllllllllllllllIIIllIllllllllll.key_to_period(llllllllllllllllIIIllIlllllllllI);
                if (llllllllllllllllIIIllIllllllIllI != 3 && llllllllllllllllIIIllIllllllIllI != 5 && (llllllllllllllllIIIllIllllllllII & 0xF0) != 240) {
                    llllllllllllllllIIIllIllllllllll.trigger_tick = 0;
                    if (llllllllllllllllIIIllIllllllllll.vibrato_wave < 4) {
                        llllllllllllllllIIIllIllllllllll.vibrato_tick = 0;
                    }
                    if (llllllllllllllllIIIllIllllllllll.tremolo_wave < 4) {
                        llllllllllllllllIIIllIllllllllll.tremolo_tick = 0;
                    }
                    llllllllllllllllIIIllIllllllllll.set_period(llllllllllllllllIIIllIllllllllll.porta_period);
                    llllllllllllllllIIIllIllllllllll.set_sample_index(0);
                }
            } else {
                llllllllllllllllIIIllIllllllllll.key_on = false;
            }
        }
    }

    private void portamento_up() {
        Channel llllllllllllllllIIIlllIIlIlIIlII;
        if ((llllllllllllllllIIIlllIIlIlIIlII.portamento_param & 0xF0) == 224) {
            if (llllllllllllllllIIIlllIIlIlIIlII.effect_tick == 0) {
                llllllllllllllllIIIlllIIlIlIIlII.set_period(llllllllllllllllIIIlllIIlIlIIlII.period - (llllllllllllllllIIIlllIIlIlIIlII.portamento_param & 0xF));
            }
        } else if ((llllllllllllllllIIIlllIIlIlIIlII.portamento_param & 0xF0) == 240) {
            if (llllllllllllllllIIIlllIIlIlIIlII.effect_tick == 0) {
                llllllllllllllllIIIlllIIlIlIIlII.set_period(llllllllllllllllIIIlllIIlIlIIlII.period - ((llllllllllllllllIIIlllIIlIlIIlII.portamento_param & 0xF) << 2));
            }
        } else if (llllllllllllllllIIIlllIIlIlIIlII.effect_tick > 0) {
            llllllllllllllllIIIlllIIlIlIIlII.set_period(llllllllllllllllIIIlllIIlIlIIlII.period - (llllllllllllllllIIIlllIIlIlIIlII.portamento_param << 2));
        }
    }

    private void set_vibrato_wave(int llllllllllllllllIIIlllIlIIIIIIll) {
        if (llllllllllllllllIIIlllIlIIIIIIll < 0 || llllllllllllllllIIIlllIlIIIIIIll > 7) {
            llllllllllllllllIIIlllIlIIIIIIll = 0;
        }
        llllllllllllllllIIIlllIlIIIIIlIl.vibrato_wave = llllllllllllllllIIIlllIlIIIIIIll;
    }

    private void calculate_amplitude() {
        Channel llllllllllllllllIIIllIlllIIlIlIl;
        int llllllllllllllllIIIllIlllIIlIlII = 0;
        if (llllllllllllllllIIIllIlllIIlIlIl.instrument.volume_envelope_active) {
            Envelope llllllllllllllllIIIllIlllIIllIlI = llllllllllllllllIIIllIlllIIlIlIl.instrument.get_volume_envelope();
            llllllllllllllllIIIllIlllIIlIlII = llllllllllllllllIIIllIlllIIllIlI.calculate_ampl(llllllllllllllllIIIllIlllIIlIlIl.volume_envelope_tick);
        } else if (llllllllllllllllIIIllIlllIIlIlIl.key_on) {
            llllllllllllllllIIIllIlllIIlIlII = 64;
        }
        int llllllllllllllllIIIllIlllIIlIIll = llllllllllllllllIIIllIlllIIlIlIl.volume + llllllllllllllllIIIllIlllIIlIlIl.tremolo_add;
        if (llllllllllllllllIIIllIlllIIlIIll < 0) {
            llllllllllllllllIIIllIlllIIlIIll = 0;
        }
        if (llllllllllllllllIIIllIlllIIlIIll > 64) {
            llllllllllllllllIIIllIlllIIlIIll = 64;
        }
        int llllllllllllllllIIIllIlllIIlIIlI = llllllllllllllllIIIllIlllIIlIIll << 9;
        llllllllllllllllIIIllIlllIIlIIlI = llllllllllllllllIIIllIlllIIlIIlI * llllllllllllllllIIIllIlllIIlIlII >> 6;
        llllllllllllllllIIIllIlllIIlIIlI = llllllllllllllllIIIllIlllIIlIIlI * llllllllllllllllIIIllIlllIIlIlIl.fade_out_volume >> 15;
        llllllllllllllllIIIllIlllIIlIIlI = llllllllllllllllIIIllIlllIIlIIlI * llllllllllllllllIIIllIlllIIlIlIl.global_volume[0] >> 6;
        llllllllllllllllIIIllIlllIIlIIlI = llllllllllllllllIIIllIlllIIlIIlI * llllllllllllllllIIIllIlllIIlIlIl.module.channel_gain >> 15;
        llllllllllllllllIIIllIlllIIlIlIl.silent = llllllllllllllllIIIllIlllIIlIlIl.sample.has_finished(llllllllllllllllIIIllIlllIIlIlIl.sample_idx);
        if (llllllllllllllllIIIllIlllIIlIIlI <= 0) {
            llllllllllllllllIIIllIlllIIlIlIl.silent = true;
        } else {
            int llllllllllllllllIIIllIlllIIlIlll;
            int llllllllllllllllIIIllIlllIIlIllI;
            int llllllllllllllllIIIllIlllIIllIII = 32;
            if (llllllllllllllllIIIllIlllIIlIlIl.instrument.panning_envelope_active) {
                Envelope llllllllllllllllIIIllIlllIIllIIl = llllllllllllllllIIIllIlllIIlIlIl.instrument.get_panning_envelope();
                llllllllllllllllIIIllIlllIIllIII = llllllllllllllllIIIllIlllIIllIIl.calculate_ampl(llllllllllllllllIIIllIlllIIlIlIl.panning_envelope_tick);
            }
            if ((llllllllllllllllIIIllIlllIIlIllI = 32768 - (llllllllllllllllIIIllIlllIIlIlll = (llllllllllllllllIIIllIlllIIlIlIl.panning & 0xFF) << 7)) > llllllllllllllllIIIllIlllIIlIlll) {
                llllllllllllllllIIIllIlllIIlIllI = llllllllllllllllIIIllIlllIIlIlll;
            }
            llllllllllllllllIIIllIlllIIlIlIl.left_gain = llllllllllllllllIIIllIlllIIlIIlI * (32768 - (llllllllllllllllIIIllIlllIIlIlll += llllllllllllllllIIIllIlllIIlIllI * (llllllllllllllllIIIllIlllIIllIII - 32) >> 5)) >> 15;
            llllllllllllllllIIIllIlllIIlIlIl.right_gain = llllllllllllllllIIIllIlllIIlIIlI * llllllllllllllllIIIllIlllIIlIlll >> 15;
        }
    }

    private void set_envelope_tick(int llllllllllllllllIIIlllIIIIIlllII) {
        llllllllllllllllIIIlllIIIIIlllIl.volume_envelope_tick = llllllllllllllllIIIlllIIIIIlllII;
        llllllllllllllllIIIlllIIIIIlllIl.panning_envelope_tick = llllllllllllllllIIIlllIIIIIlllII;
    }

    public void row(int llllllllllllllllIIIlllIlIllIIIIl, int llllllllllllllllIIIlllIlIlIlIIll, int llllllllllllllllIIIlllIlIlIlllIl, int llllllllllllllllIIIlllIlIlIllIll, int llllllllllllllllIIIlllIlIlIllIIl) {
        Channel llllllllllllllllIIIlllIlIllIIIll;
        if ((llllllllllllllllIIIlllIlIlIllIll &= 0xFF) >= 48) {
            llllllllllllllllIIIlllIlIlIllIll = 0;
        }
        if (llllllllllllllllIIIlllIlIlIllIll == 0 && llllllllllllllllIIIlllIlIlIllIIl != 0) {
            llllllllllllllllIIIlllIlIlIllIll = 64;
        }
        if (llllllllllllllllIIIlllIlIlIllIll == 14) {
            llllllllllllllllIIIlllIlIlIllIll = 48 + ((llllllllllllllllIIIlllIlIlIllIIl & 0xF0) >> 4);
            llllllllllllllllIIIlllIlIlIllIIl &= 0xF;
        }
        if (llllllllllllllllIIIlllIlIlIllIll == 33) {
            llllllllllllllllIIIlllIlIlIllIll = 64 + ((llllllllllllllllIIIlllIlIlIllIIl & 0xF0) >> 4);
            llllllllllllllllIIIlllIlIlIllIIl &= 0xF;
        }
        llllllllllllllllIIIlllIlIllIIIll.current_note[0] = llllllllllllllllIIIlllIlIllIIIIl;
        llllllllllllllllIIIlllIlIllIIIll.current_note[1] = llllllllllllllllIIIlllIlIlIlIIll;
        llllllllllllllllIIIlllIlIllIIIll.current_note[2] = llllllllllllllllIIIlllIlIlIlllIl;
        llllllllllllllllIIIlllIlIllIIIll.current_note[3] = llllllllllllllllIIIlllIlIlIllIll;
        llllllllllllllllIIIlllIlIllIIIll.current_note[4] = llllllllllllllllIIIlllIlIlIllIIl;
        llllllllllllllllIIIlllIlIllIIIll.effect_tick = 0;
        ++llllllllllllllllIIIlllIlIllIIIll.trigger_tick;
        llllllllllllllllIIIlllIlIllIIIll.update_envelopes();
        llllllllllllllllIIIlllIlIllIIIll.key_add = 0;
        llllllllllllllllIIIlllIlIllIIIll.vibrato_add = 0;
        llllllllllllllllIIIlllIlIllIIIll.tremolo_add = 0;
        if (llllllllllllllllIIIlllIlIlIllIll != 61 || llllllllllllllllIIIlllIlIlIllIIl <= 0) {
            llllllllllllllllIIIlllIlIllIIIll.trigger(llllllllllllllllIIIlllIlIllIIIIl, llllllllllllllllIIIlllIlIlIlIIll, llllllllllllllllIIIlllIlIlIlllIl, llllllllllllllllIIIlllIlIlIllIll);
            switch (llllllllllllllllIIIlllIlIlIlllIl & 0xF0) {
                case 0: {
                    break;
                }
                case 96: {
                    break;
                }
                case 112: {
                    break;
                }
                case 128: {
                    llllllllllllllllIIIlllIlIllIIIll.set_volume(llllllllllllllllIIIlllIlIllIIIll.volume - (llllllllllllllllIIIlllIlIlIlllIl & 0xF));
                    break;
                }
                case 144: {
                    llllllllllllllllIIIlllIlIllIIIll.set_volume(llllllllllllllllIIIlllIlIllIIIll.volume + (llllllllllllllllIIIlllIlIlIlllIl & 0xF));
                    break;
                }
                case 160: {
                    llllllllllllllllIIIlllIlIllIIIll.set_vibrato_speed(llllllllllllllllIIIlllIlIlIlllIl & 0xF);
                    break;
                }
                case 176: {
                    llllllllllllllllIIIlllIlIllIIIll.set_vibrato_depth(llllllllllllllllIIIlllIlIlIlllIl & 0xF);
                    llllllllllllllllIIIlllIlIllIIIll.vibrato();
                    break;
                }
                case 192: {
                    llllllllllllllllIIIlllIlIllIIIll.set_panning((llllllllllllllllIIIlllIlIlIlllIl & 0xF) << 4);
                    break;
                }
                case 208: {
                    break;
                }
                case 224: {
                    break;
                }
                case 240: {
                    llllllllllllllllIIIlllIlIllIIIll.set_portamento_param(llllllllllllllllIIIlllIlIlIlllIl & 0xF);
                    break;
                }
                default: {
                    llllllllllllllllIIIlllIlIllIIIll.set_volume(llllllllllllllllIIIlllIlIlIlllIl - 16);
                }
            }
        }
        if (llllllllllllllllIIIlllIlIllIIIll.instrument.vibrato_depth > 0) {
            llllllllllllllllIIIlllIlIllIIIll.auto_vibrato();
        }
        switch (llllllllllllllllIIIlllIlIlIllIll) {
            case 1: {
                llllllllllllllllIIIlllIlIllIIIll.set_portamento_param(llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.portamento_up();
                break;
            }
            case 2: {
                llllllllllllllllIIIlllIlIllIIIll.set_portamento_param(llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.portamento_down();
                break;
            }
            case 3: {
                llllllllllllllllIIIlllIlIllIIIll.set_portamento_param(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 4: {
                llllllllllllllllIIIlllIlIllIIIll.set_vibrato_speed((llllllllllllllllIIIlllIlIlIllIIl & 0xF0) >> 4);
                llllllllllllllllIIIlllIlIllIIIll.set_vibrato_depth(llllllllllllllllIIIlllIlIlIllIIl & 0xF);
                llllllllllllllllIIIlllIlIllIIIll.vibrato();
                break;
            }
            case 5: {
                llllllllllllllllIIIlllIlIllIIIll.set_volume_slide_param(llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.volume_slide();
                break;
            }
            case 6: {
                llllllllllllllllIIIlllIlIllIIIll.set_volume_slide_param(llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.vibrato();
                llllllllllllllllIIIlllIlIllIIIll.volume_slide();
                break;
            }
            case 7: {
                llllllllllllllllIIIlllIlIllIIIll.set_tremolo_speed((llllllllllllllllIIIlllIlIlIllIIl & 0xF0) >> 4);
                llllllllllllllllIIIlllIlIllIIIll.set_tremolo_depth(llllllllllllllllIIIlllIlIlIllIIl & 0xF);
                llllllllllllllllIIIlllIlIllIIIll.tremolo();
                break;
            }
            case 8: {
                llllllllllllllllIIIlllIlIllIIIll.set_panning(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 9: {
                llllllllllllllllIIIlllIlIllIIIll.set_sample_index(llllllllllllllllIIIlllIlIlIllIIl << 8);
                break;
            }
            case 10: {
                llllllllllllllllIIIlllIlIllIIIll.set_volume_slide_param(llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.volume_slide();
                break;
            }
            case 11: {
                break;
            }
            case 12: {
                llllllllllllllllIIIlllIlIllIIIll.set_volume(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 13: {
                break;
            }
            case 14: {
                break;
            }
            case 15: {
                break;
            }
            case 16: {
                llllllllllllllllIIIlllIlIllIIIll.set_global_volume(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 17: {
                llllllllllllllllIIIlllIlIllIIIll.set_volume_slide_param(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 20: {
                if (llllllllllllllllIIIlllIlIlIllIIl != 0) break;
                llllllllllllllllIIIlllIlIllIIIll.key_on = false;
                break;
            }
            case 21: {
                llllllllllllllllIIIlllIlIllIIIll.set_envelope_tick(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 25: {
                llllllllllllllllIIIlllIlIllIIIll.set_volume_slide_param(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 27: {
                llllllllllllllllIIIlllIlIllIIIll.set_retrig_param(llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.retrig_volume_slide();
                break;
            }
            case 29: {
                llllllllllllllllIIIlllIlIllIIIll.set_retrig_param(llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.tremor();
                break;
            }
            case 36: {
                llllllllllllllllIIIlllIlIllIIIll.set_vibrato_speed((llllllllllllllllIIIlllIlIlIllIIl & 0xF0) >> 4);
                llllllllllllllllIIIlllIlIllIIIll.set_vibrato_depth(llllllllllllllllIIIlllIlIlIllIIl & 0xF);
                llllllllllllllllIIIlllIlIllIIIll.fine_vibrato();
                break;
            }
            case 37: {
                break;
            }
            case 48: {
                break;
            }
            case 49: {
                llllllllllllllllIIIlllIlIllIIIll.set_portamento_param(0xF0 | llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.portamento_up();
                break;
            }
            case 50: {
                llllllllllllllllIIIlllIlIllIIIll.set_portamento_param(0xF0 | llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.portamento_down();
                break;
            }
            case 51: {
                break;
            }
            case 52: {
                llllllllllllllllIIIlllIlIllIIIll.set_vibrato_wave(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 53: {
                break;
            }
            case 54: {
                break;
            }
            case 55: {
                llllllllllllllllIIIlllIlIllIIIll.set_tremolo_wave(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 56: {
                break;
            }
            case 57: {
                llllllllllllllllIIIlllIlIllIIIll.set_retrig_param(llllllllllllllllIIIlllIlIlIllIIl);
                break;
            }
            case 58: {
                llllllllllllllllIIIlllIlIllIIIll.set_volume_slide_param(llllllllllllllllIIIlllIlIlIllIIl << 4 | 0xF);
                llllllllllllllllIIIlllIlIllIIIll.volume_slide();
                break;
            }
            case 59: {
                llllllllllllllllIIIlllIlIllIIIll.set_volume_slide_param(0xF0 | llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.volume_slide();
                break;
            }
            case 60: {
                if (llllllllllllllllIIIlllIlIlIllIIl != 0) break;
                llllllllllllllllIIIlllIlIllIIIll.set_volume(0);
                break;
            }
            case 61: {
                break;
            }
            case 62: {
                break;
            }
            case 63: {
                break;
            }
            case 64: {
                break;
            }
            case 65: {
                llllllllllllllllIIIlllIlIllIIIll.set_portamento_param(0xE0 | llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.portamento_up();
                break;
            }
            case 66: {
                llllllllllllllllIIIlllIlIllIIIll.set_portamento_param(0xE0 | llllllllllllllllIIIlllIlIlIllIIl);
                llllllllllllllllIIIlllIlIllIIIll.portamento_down();
            }
        }
        llllllllllllllllIIIlllIlIllIIIll.calculate_amplitude();
        llllllllllllllllIIIlllIlIllIIIll.calculate_frequency();
    }

    public void reset() {
        Channel llllllllllllllllIIIlllIlllIlIllI;
        llllllllllllllllIIIlllIlllIlIllI.tremolo_speed = 0;
        llllllllllllllllIIIlllIlllIlIllI.tremolo_depth = 0;
        llllllllllllllllIIIlllIlllIlIllI.tremolo_wave = 0;
        llllllllllllllllIIIlllIlllIlIllI.vibrato_speed = 0;
        llllllllllllllllIIIlllIlllIlIllI.vibrato_depth = 0;
        llllllllllllllllIIIlllIlllIlIllI.vibrato_wave = 0;
        llllllllllllllllIIIlllIlllIlIllI.volume_slide_param = 0;
        llllllllllllllllIIIlllIlllIlIllI.portamento_param = 0;
        llllllllllllllllIIIlllIlllIlIllI.retrig_param = 0;
        llllllllllllllllIIIlllIlllIlIllI.random_seed = 11256099;
        llllllllllllllllIIIlllIlllIlIllI.instrument = llllllllllllllllIIIlllIlllIlIllI.module.get_instrument(0);
        llllllllllllllllIIIlllIlllIlIllI.row(48, 256, 0, 0, 0);
    }

    public void update_sample_idx(int llllllllllllllllIIIlllIlllIIIIIl) {
        Channel llllllllllllllllIIIlllIlllIIIIll;
        llllllllllllllllIIIlllIlllIIIIll.sample_frac += llllllllllllllllIIIlllIlllIIIIll.step * llllllllllllllllIIIlllIlllIIIIIl;
        llllllllllllllllIIIlllIlllIIIIll.sample_idx += llllllllllllllllIIIlllIlllIIIIll.sample_frac >> 15;
        llllllllllllllllIIIlllIlllIIIIll.sample_frac &= Short.MAX_VALUE;
    }

    static {
        LOG_2_29024 = LogTable.log_2(29024);
        LOG_2_1712 = LogTable.log_2(1712);
        sine_table = new int[]{0, 24, 49, 74, 97, 120, 141, 161, 180, 197, 212, 224, 235, 244, 250, 253, 255, 253, 250, 244, 235, 224, 212, 197, 180, 161, 141, 120, 97, 74, 49, 24};
    }

    private void tremor() {
        Channel llllllllllllllllIIIlllIIIlIlllII;
        int llllllllllllllllIIIlllIIIllIIIlI = ((llllllllllllllllIIIlllIIIlIlllII.retrig_param & 0xF0) >> 4) + 1;
        int llllllllllllllllIIIlllIIIllIIIII = llllllllllllllllIIIlllIIIllIIIlI + (llllllllllllllllIIIlllIIIlIlllII.retrig_param & 0xF) + 1;
        int llllllllllllllllIIIlllIIIlIllllI = llllllllllllllllIIIlllIIIlIlllII.trigger_tick % llllllllllllllllIIIlllIIIllIIIII;
        if (llllllllllllllllIIIlllIIIlIllllI >= llllllllllllllllIIIlllIIIllIIIlI) {
            llllllllllllllllIIIlllIIIlIlllII.tremolo_add = -64;
        }
    }

    private void set_vibrato_speed(int llllllllllllllllIIIlllIlIIIllIII) {
        if (llllllllllllllllIIIlllIlIIIllIII > 0) {
            llllllllllllllllIIIlllIlIIIllIll.vibrato_speed = llllllllllllllllIIIlllIlIIIllIII;
        }
    }

    private void set_portamento_param(int llllllllllllllllIIIlllIIlIlIlllI) {
        if (llllllllllllllllIIIlllIIlIlIlllI != 0) {
            llllllllllllllllIIIlllIIlIllIIIl.portamento_param = llllllllllllllllIIIlllIIlIlIlllI;
        }
    }

    private int key_to_period(int llllllllllllllllIIIllIllllIIIlII) {
        int llllllllllllllllIIIllIllllIIIlll;
        Channel llllllllllllllllIIIllIllllIIlIll;
        llllllllllllllllIIIllIllllIIIlII += llllllllllllllllIIIllIllllIIlIll.sample.relative_note;
        if (llllllllllllllllIIIllIllllIIlIll.linear_periods) {
            int llllllllllllllllIIIllIllllIIllll = 7744 - llllllllllllllllIIIllIllllIIIlII * 64;
        } else {
            int llllllllllllllllIIIllIllllIIllIl = LOG_2_29024 - (llllllllllllllllIIIllIllllIIIlII << 15) / 12;
            llllllllllllllllIIIllIllllIIIlll = LogTable.raise_2(llllllllllllllllIIIllIllllIIllIl) >> 15;
        }
        return llllllllllllllllIIIllIllllIIIlll;
    }

    private void set_vibrato_depth(int llllllllllllllllIIIlllIlIIIlIlII) {
        if (llllllllllllllllIIIlllIlIIIlIlII > 0) {
            llllllllllllllllIIIlllIlIIIlIIlI.vibrato_depth = llllllllllllllllIIIlllIlIIIlIlII;
        }
    }

    private void set_tremolo_depth(int llllllllllllllllIIIlllIIlllIIlIl) {
        if (llllllllllllllllIIIlllIIlllIIlIl > 0) {
            llllllllllllllllIIIlllIIlllIIIll.tremolo_depth = llllllllllllllllIIIlllIIlllIIlIl;
        }
    }

    private void set_tremolo_wave(int llllllllllllllllIIIlllIIllIllIlI) {
        if (llllllllllllllllIIIlllIIllIllIlI < 0 || llllllllllllllllIIIlllIIllIllIlI > 7) {
            llllllllllllllllIIIlllIIllIllIlI = 0;
        }
        llllllllllllllllIIIlllIIllIllIll.tremolo_wave = llllllllllllllllIIIlllIIllIllIlI;
    }

    private void set_global_volume(int llllllllllllllllIIIlllIIlIIlIlll) {
        if (llllllllllllllllIIIlllIIlIIlIlll < 0) {
            llllllllllllllllIIIlllIIlIIlIlll = 0;
        }
        if (llllllllllllllllIIIlllIIlIIlIlll > 64) {
            llllllllllllllllIIIlllIIlIIlIlll = 64;
        }
        llllllllllllllllIIIlllIIlIIlIllI.global_volume[0] = llllllllllllllllIIIlllIIlIIlIlll;
    }

    private void set_tremolo_speed(int llllllllllllllllIIIlllIIllllIlII) {
        if (llllllllllllllllIIIlllIIllllIlII > 0) {
            llllllllllllllllIIIlllIIllllIllI.tremolo_speed = llllllllllllllllIIIlllIIllllIlII;
        }
    }

    private void calculate_frequency() {
        Channel llllllllllllllllIIIllIllIllllIIl;
        int llllllllllllllllIIIllIllIlllIlll = llllllllllllllllIIIllIllIllllIIl.period + llllllllllllllllIIIllIllIllllIIl.vibrato_add;
        if (llllllllllllllllIIIllIllIlllIlll < 32) {
            llllllllllllllllIIIllIllIlllIlll = 32;
        }
        if (llllllllllllllllIIIllIllIlllIlll > 32768) {
            llllllllllllllllIIIllIllIlllIlll = 32768;
        }
        if (llllllllllllllllIIIllIllIllllIIl.linear_periods) {
            int llllllllllllllllIIIllIllIllllIll = llllllllllllllllIIIllIllIllllIIl.log_2_c2_rate + (4608 - llllllllllllllllIIIllIllIlllIlll << 15) / 768;
        } else {
            int llllllllllllllllIIIllIllIlllIlIl = llllllllllllllllIIIllIllIllllIIl.log_2_c2_rate + LOG_2_1712 - LogTable.log_2(llllllllllllllllIIIllIllIlllIlll);
        }
        llllllllllllllllIIIllIllIllllIIl.step = LogTable.raise_2((llllllllllllllllIIIllIllIlllIlIl += ((llllllllllllllllIIIllIllIllllIIl.key_add << 7) + llllllllllllllllIIIllIllIllllIIl.sample.fine_tune << 15) / 1536) - llllllllllllllllIIIllIllIllllIIl.log_2_sampling_rate);
    }

    private void auto_vibrato() {
        Channel llllllllllllllllIIIllIlllllIIllI;
        int llllllllllllllllIIIllIlllllIlIIl = llllllllllllllllIIIllIlllllIIllI.instrument.vibrato_sweep & 0xFF;
        int llllllllllllllllIIIllIlllllIlIII = llllllllllllllllIIIllIlllllIIllI.instrument.vibrato_depth & 0xF;
        int llllllllllllllllIIIllIlllllIIlll = llllllllllllllllIIIllIlllllIIllI.instrument.vibrato_rate & 0x3F;
        if (llllllllllllllllIIIllIlllllIIllI.trigger_tick < llllllllllllllllIIIllIlllllIlIIl) {
            llllllllllllllllIIIllIlllllIlIII = llllllllllllllllIIIllIlllllIlIII * llllllllllllllllIIIllIlllllIIllI.trigger_tick / llllllllllllllllIIIllIlllllIlIIl;
        }
        llllllllllllllllIIIllIlllllIIllI.vibrato_add += llllllllllllllllIIIllIlllllIIllI.waveform(llllllllllllllllIIIllIlllllIIllI.trigger_tick * llllllllllllllllIIIllIlllllIIlll, 0) * llllllllllllllllIIIllIlllllIlIII >> 9;
    }

    private void set_period(int llllllllllllllllIIIlllIIlIIlllIl) {
        if (llllllllllllllllIIIlllIIlIIlllIl < 32) {
            llllllllllllllllIIIlllIIlIIlllIl = 32;
        }
        if (llllllllllllllllIIIlllIIlIIlllIl > 32768) {
            llllllllllllllllIIIlllIIlIIlllIl = 32768;
        }
        llllllllllllllllIIIlllIIlIIllllI.period = llllllllllllllllIIIlllIIlIIlllIl;
    }

    private void panning_slide() {
        Channel llllllllllllllllIIIlllIIIlllIllI;
        int llllllllllllllllIIIlllIIIllllIII = (llllllllllllllllIIIlllIIIlllIllI.volume_slide_param & 0xF0) >> 4;
        int llllllllllllllllIIIlllIIIlllIlll = llllllllllllllllIIIlllIIIlllIllI.volume_slide_param & 0xF;
        llllllllllllllllIIIlllIIIlllIllI.set_panning(llllllllllllllllIIIlllIIIlllIllI.panning - llllllllllllllllIIIlllIIIllllIII + llllllllllllllllIIIlllIIIlllIlll);
    }

    private void tone_portamento() {
        Channel llllllllllllllllIIIlllIIlIlIlIII;
        if (llllllllllllllllIIIlllIIlIlIlIII.porta_period < llllllllllllllllIIIlllIIlIlIlIII.period) {
            int llllllllllllllllIIIlllIIlIlIlIll = llllllllllllllllIIIlllIIlIlIlIII.period - (llllllllllllllllIIIlllIIlIlIlIII.portamento_param << 2);
            if (llllllllllllllllIIIlllIIlIlIlIll < llllllllllllllllIIIlllIIlIlIlIII.porta_period) {
                llllllllllllllllIIIlllIIlIlIlIll = llllllllllllllllIIIlllIIlIlIlIII.porta_period;
            }
            llllllllllllllllIIIlllIIlIlIlIII.set_period(llllllllllllllllIIIlllIIlIlIlIll);
        }
        if (llllllllllllllllIIIlllIIlIlIlIII.porta_period > llllllllllllllllIIIlllIIlIlIlIII.period) {
            int llllllllllllllllIIIlllIIlIlIlIlI = llllllllllllllllIIIlllIIlIlIlIII.period + (llllllllllllllllIIIlllIIlIlIlIII.portamento_param << 2);
            if (llllllllllllllllIIIlllIIlIlIlIlI > llllllllllllllllIIIlllIIlIlIlIII.porta_period) {
                llllllllllllllllIIIlllIIlIlIlIlI = llllllllllllllllIIIlllIIlIlIlIII.porta_period;
            }
            llllllllllllllllIIIlllIIlIlIlIII.set_period(llllllllllllllllIIIlllIIlIlIlIlI);
        }
    }

    private void set_sample_index(int llllllllllllllllIIIlllIIIIlIIIlI) {
        if (llllllllllllllllIIIlllIIIIlIIIlI < 0) {
            llllllllllllllllIIIlllIIIIlIIIlI = 0;
        }
        llllllllllllllllIIIlllIIIIlIIIll.sample_idx = llllllllllllllllIIIlllIIIIlIIIlI;
        llllllllllllllllIIIlllIIIIlIIIll.sample_frac = 0;
    }

    private void global_volume_slide() {
        Channel llllllllllllllllIIIlllIIlIIIlIll;
        int llllllllllllllllIIIlllIIlIIIlIlI = (llllllllllllllllIIIlllIIlIIIlIll.volume_slide_param & 0xF0) >> 4;
        int llllllllllllllllIIIlllIIlIIIlIIl = llllllllllllllllIIIlllIIlIIIlIll.volume_slide_param & 0xF;
        llllllllllllllllIIIlllIIlIIIlIll.set_global_volume(llllllllllllllllIIIlllIIlIIIlIll.global_volume[0] + llllllllllllllllIIIlllIIlIIIlIlI - llllllllllllllllIIIlllIIlIIIlIIl);
    }

    public void set_panning(int llllllllllllllllIIIlllIllIllIIlI) {
        if (llllllllllllllllIIIlllIllIllIIlI < 0) {
            llllllllllllllllIIIlllIllIllIIlI = 0;
        }
        if (llllllllllllllllIIIlllIllIllIIlI > 255) {
            llllllllllllllllIIIlllIllIllIIlI = 255;
        }
        llllllllllllllllIIIlllIllIllIIll.panning = llllllllllllllllIIIlllIllIllIIlI;
    }

    private void set_volume_slide_param(int llllllllllllllllIIIlllIIlIIIllll) {
        if (llllllllllllllllIIIlllIIlIIIllll != 0) {
            llllllllllllllllIIIlllIIlIIlIIII.volume_slide_param = llllllllllllllllIIIlllIIlIIIllll;
        }
    }
}

