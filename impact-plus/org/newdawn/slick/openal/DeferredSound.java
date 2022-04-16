/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.openal;

import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.loading.LoadingList;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioImpl;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.util.Log;

public class DeferredSound
extends AudioImpl
implements DeferredResource {
    public static final /* synthetic */ int OGG;
    private /* synthetic */ String ref;
    public static final /* synthetic */ int MOD;
    private /* synthetic */ int type;
    public static final /* synthetic */ int AIF;
    private /* synthetic */ InputStream in;
    private /* synthetic */ Audio target;
    public static final /* synthetic */ int WAV;

    @Override
    public int playAsSoundEffect(float lllllllllllllllllIIIlIllIIlIIlIl, float lllllllllllllllllIIIlIllIIlIlIII, boolean lllllllllllllllllIIIlIllIIlIIIll) {
        DeferredSound lllllllllllllllllIIIlIllIIlIlIlI;
        lllllllllllllllllIIIlIllIIlIlIlI.checkTarget();
        return lllllllllllllllllIIIlIllIIlIlIlI.target.playAsSoundEffect(lllllllllllllllllIIIlIllIIlIIlIl, lllllllllllllllllIIIlIllIIlIlIII, lllllllllllllllllIIIlIllIIlIIIll);
    }

    private void checkTarget() {
        DeferredSound lllllllllllllllllIIIlIllIllIIllI;
        if (lllllllllllllllllIIIlIllIllIIllI.target == null) {
            throw new RuntimeException("Attempt to use deferred sound before loading");
        }
    }

    public DeferredSound(String lllllllllllllllllIIIlIllIllIllll, InputStream lllllllllllllllllIIIlIllIlllIlIl, int lllllllllllllllllIIIlIllIllIllIl) {
        DeferredSound lllllllllllllllllIIIlIllIlllIlll;
        lllllllllllllllllIIIlIllIlllIlll.ref = lllllllllllllllllIIIlIllIllIllll;
        lllllllllllllllllIIIlIllIlllIlll.type = lllllllllllllllllIIIlIllIllIllIl;
        if (lllllllllllllllllIIIlIllIllIllll.equals(lllllllllllllllllIIIlIllIlllIlIl.toString())) {
            lllllllllllllllllIIIlIllIlllIlll.in = lllllllllllllllllIIIlIllIlllIlIl;
        }
        LoadingList.get().add(lllllllllllllllllIIIlIllIlllIlll);
    }

    @Override
    public boolean isPlaying() {
        DeferredSound lllllllllllllllllIIIlIllIlIIIlIl;
        lllllllllllllllllIIIlIllIlIIIlIl.checkTarget();
        return lllllllllllllllllIIIlIllIlIIIlIl.target.isPlaying();
    }

    @Override
    public void load() throws IOException {
        DeferredSound lllllllllllllllllIIIlIllIlIIllll;
        boolean lllllllllllllllllIIIlIllIlIIllIl = SoundStore.get().isDeferredLoading();
        SoundStore.get().setDeferredLoading(false);
        if (lllllllllllllllllIIIlIllIlIIllll.in != null) {
            switch (lllllllllllllllllIIIlIllIlIIllll.type) {
                case 1: {
                    lllllllllllllllllIIIlIllIlIIllll.target = SoundStore.get().getOgg(lllllllllllllllllIIIlIllIlIIllll.in);
                    break;
                }
                case 2: {
                    lllllllllllllllllIIIlIllIlIIllll.target = SoundStore.get().getWAV(lllllllllllllllllIIIlIllIlIIllll.in);
                    break;
                }
                case 3: {
                    lllllllllllllllllIIIlIllIlIIllll.target = SoundStore.get().getMOD(lllllllllllllllllIIIlIllIlIIllll.in);
                    break;
                }
                case 4: {
                    lllllllllllllllllIIIlIllIlIIllll.target = SoundStore.get().getAIF(lllllllllllllllllIIIlIllIlIIllll.in);
                    break;
                }
                default: {
                    Log.error(String.valueOf(new StringBuilder().append("Unrecognised sound type: ").append(lllllllllllllllllIIIlIllIlIIllll.type)));
                    break;
                }
            }
        } else {
            switch (lllllllllllllllllIIIlIllIlIIllll.type) {
                case 1: {
                    lllllllllllllllllIIIlIllIlIIllll.target = SoundStore.get().getOgg(lllllllllllllllllIIIlIllIlIIllll.ref);
                    break;
                }
                case 2: {
                    lllllllllllllllllIIIlIllIlIIllll.target = SoundStore.get().getWAV(lllllllllllllllllIIIlIllIlIIllll.ref);
                    break;
                }
                case 3: {
                    lllllllllllllllllIIIlIllIlIIllll.target = SoundStore.get().getMOD(lllllllllllllllllIIIlIllIlIIllll.ref);
                    break;
                }
                case 4: {
                    lllllllllllllllllIIIlIllIlIIllll.target = SoundStore.get().getAIF(lllllllllllllllllIIIlIllIlIIllll.ref);
                    break;
                }
                default: {
                    Log.error(String.valueOf(new StringBuilder().append("Unrecognised sound type: ").append(lllllllllllllllllIIIlIllIlIIllll.type)));
                }
            }
        }
        SoundStore.get().setDeferredLoading(lllllllllllllllllIIIlIllIlIIllIl);
    }

    @Override
    public int playAsMusic(float lllllllllllllllllIIIlIllIIllIIIl, float lllllllllllllllllIIIlIllIIllIIII, boolean lllllllllllllllllIIIlIllIIlIllll) {
        DeferredSound lllllllllllllllllIIIlIllIIlllIII;
        lllllllllllllllllIIIlIllIIlllIII.checkTarget();
        return lllllllllllllllllIIIlIllIIlllIII.target.playAsMusic(lllllllllllllllllIIIlIllIIllIIIl, lllllllllllllllllIIIlIllIIllIIII, lllllllllllllllllIIIlIllIIlIllll);
    }

    static {
        AIF = 4;
        OGG = 1;
        WAV = 2;
        MOD = 3;
    }

    @Override
    public int playAsSoundEffect(float lllllllllllllllllIIIlIllIIIIllll, float lllllllllllllllllIIIlIllIIIIlllI, boolean lllllllllllllllllIIIlIllIIIlIlIl, float lllllllllllllllllIIIlIllIIIIlIll, float lllllllllllllllllIIIlIllIIIIlIlI, float lllllllllllllllllIIIlIllIIIIlIIl) {
        DeferredSound lllllllllllllllllIIIlIllIIIllIII;
        lllllllllllllllllIIIlIllIIIllIII.checkTarget();
        return lllllllllllllllllIIIlIllIIIllIII.target.playAsSoundEffect(lllllllllllllllllIIIlIllIIIIllll, lllllllllllllllllIIIlIllIIIIlllI, lllllllllllllllllIIIlIllIIIlIlIl, lllllllllllllllllIIIlIllIIIIlIll, lllllllllllllllllIIIlIllIIIIlIlI, lllllllllllllllllIIIlIllIIIIlIIl);
    }

    @Override
    public void stop() {
        DeferredSound lllllllllllllllllIIIlIllIIIIIIll;
        lllllllllllllllllIIIlIllIIIIIIll.checkTarget();
        lllllllllllllllllIIIlIllIIIIIIll.target.stop();
    }

    @Override
    public String getDescription() {
        DeferredSound lllllllllllllllllIIIlIlIllllllIl;
        return lllllllllllllllllIIIlIlIllllllIl.ref;
    }
}

