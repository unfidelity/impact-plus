/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.loading;

import java.util.ArrayList;
import org.newdawn.slick.loading.DeferredResource;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.util.Log;

public class LoadingList {
    private static /* synthetic */ LoadingList single;
    private /* synthetic */ ArrayList deferred;
    private /* synthetic */ int total;

    public static LoadingList get() {
        return single;
    }

    public void add(DeferredResource llllllllllllllllIlllIIIllllIlIll) {
        LoadingList llllllllllllllllIlllIIIllllIlllI;
        ++llllllllllllllllIlllIIIllllIlllI.total;
        llllllllllllllllIlllIIIllllIlllI.deferred.add(llllllllllllllllIlllIIIllllIlIll);
    }

    public static boolean isDeferredLoading() {
        return InternalTextureLoader.get().isDeferredLoading();
    }

    public static void setDeferredLoading(boolean llllllllllllllllIlllIIIlllllIlIl) {
        single = new LoadingList();
        InternalTextureLoader.get().setDeferredLoading(llllllllllllllllIlllIIIlllllIlIl);
        SoundStore.get().setDeferredLoading(llllllllllllllllIlllIIIlllllIlIl);
    }

    public DeferredResource getNext() {
        LoadingList llllllllllllllllIlllIIIlllIlllIl;
        if (llllllllllllllllIlllIIIlllIlllIl.deferred.size() == 0) {
            return null;
        }
        return (DeferredResource)llllllllllllllllIlllIIIlllIlllIl.deferred.remove(0);
    }

    public void remove(DeferredResource llllllllllllllllIlllIIIllllIIlll) {
        LoadingList llllllllllllllllIlllIIIllllIIllI;
        Log.info(String.valueOf(new StringBuilder().append("Early loading of deferred resource due to req: ").append(llllllllllllllllIlllIIIllllIIlll.getDescription())));
        --llllllllllllllllIlllIIIllllIIllI.total;
        llllllllllllllllIlllIIIllllIIllI.deferred.remove(llllllllllllllllIlllIIIllllIIlll);
    }

    static {
        single = new LoadingList();
    }

    public int getRemainingResources() {
        LoadingList llllllllllllllllIlllIIIlllIlllll;
        return llllllllllllllllIlllIIIlllIlllll.deferred.size();
    }

    public int getTotalResources() {
        LoadingList llllllllllllllllIlllIIIllllIIIll;
        return llllllllllllllllIlllIIIllllIIIll.total;
    }

    private LoadingList() {
        LoadingList llllllllllllllllIlllIIIlllllIIIl;
        llllllllllllllllIlllIIIlllllIIIl.deferred = new ArrayList();
    }
}

