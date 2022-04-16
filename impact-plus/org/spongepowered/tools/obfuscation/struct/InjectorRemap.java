/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.struct;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.struct.Message;

public class InjectorRemap {
    private /* synthetic */ int remappedCount;
    private final /* synthetic */ boolean remap;
    private /* synthetic */ Message message;

    public void clearMessage() {
        llllllllllllllllIIlllIIlIIIllIll.message = null;
    }

    public void dispatchPendingMessages(Messager llllllllllllllllIIlllIIlIIIlIlII) {
        InjectorRemap llllllllllllllllIIlllIIlIIIlIlll;
        if (llllllllllllllllIIlllIIlIIIlIlll.remappedCount == 0 && llllllllllllllllIIlllIIlIIIlIlll.message != null) {
            llllllllllllllllIIlllIIlIIIlIlll.message.sendTo(llllllllllllllllIIlllIIlIIIlIlII);
        }
    }

    public boolean shouldRemap() {
        InjectorRemap llllllllllllllllIIlllIIlIIlIllll;
        return llllllllllllllllIIlllIIlIIlIllll.remap;
    }

    public InjectorRemap(boolean llllllllllllllllIIlllIIlIIllIlII) {
        InjectorRemap llllllllllllllllIIlllIIlIIllIIll;
        llllllllllllllllIIlllIIlIIllIIll.remap = llllllllllllllllIIlllIIlIIllIlII;
    }

    public void notifyRemapped() {
        InjectorRemap llllllllllllllllIIlllIIlIIlIllIl;
        ++llllllllllllllllIIlllIIlIIlIllIl.remappedCount;
        llllllllllllllllIIlllIIlIIlIllIl.clearMessage();
    }

    public void addMessage(Diagnostic.Kind llllllllllllllllIIlllIIlIIlIIlIl, CharSequence llllllllllllllllIIlllIIlIIlIIlII, Element llllllllllllllllIIlllIIlIIlIIIll, AnnotationHandle llllllllllllllllIIlllIIlIIIlllIl) {
        llllllllllllllllIIlllIIlIIlIIllI.message = new Message(llllllllllllllllIIlllIIlIIlIIlIl, llllllllllllllllIIlllIIlIIlIIlII, llllllllllllllllIIlllIIlIIlIIIll, llllllllllllllllIIlllIIlIIIlllIl);
    }
}

