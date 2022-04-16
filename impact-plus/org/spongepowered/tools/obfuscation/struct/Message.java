/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.struct;

import javax.annotation.processing.Messager;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;

public class Message {
    private final /* synthetic */ Element element;
    private final /* synthetic */ AnnotationValue value;
    private final /* synthetic */ AnnotationMirror annotation;
    private /* synthetic */ CharSequence msg;
    private /* synthetic */ Diagnostic.Kind kind;

    public CharSequence getMsg() {
        Message llllllllllllllllIlllIIllIIIIllIl;
        return llllllllllllllllIlllIIllIIIIllIl.msg;
    }

    public Message(Diagnostic.Kind llllllllllllllllIlllIIllIlllIlIl, CharSequence llllllllllllllllIlllIIllIlllIIIl) {
        llllllllllllllllIlllIIllIlllIIll(llllllllllllllllIlllIIllIlllIlIl, llllllllllllllllIlllIIllIlllIIIl, null, (AnnotationMirror)null, null);
        Message llllllllllllllllIlllIIllIlllIIll;
    }

    public Message(Diagnostic.Kind llllllllllllllllIlllIIllIllIIlll, CharSequence llllllllllllllllIlllIIllIllIlIlI, Element llllllllllllllllIlllIIllIllIIlIl) {
        llllllllllllllllIlllIIllIllIlIII(llllllllllllllllIlllIIllIllIIlll, llllllllllllllllIlllIIllIllIlIlI, llllllllllllllllIlllIIllIllIIlIl, (AnnotationMirror)null, null);
        Message llllllllllllllllIlllIIllIllIlIII;
    }

    public Message(Diagnostic.Kind llllllllllllllllIlllIIllIlIllllI, CharSequence llllllllllllllllIlllIIllIlIllIII, Element llllllllllllllllIlllIIllIlIlllII, AnnotationHandle llllllllllllllllIlllIIllIlIllIll) {
        llllllllllllllllIlllIIllIlIlllll(llllllllllllllllIlllIIllIlIllllI, llllllllllllllllIlllIIllIlIllIII, llllllllllllllllIlllIIllIlIlllII, llllllllllllllllIlllIIllIlIllIll.asMirror(), null);
        Message llllllllllllllllIlllIIllIlIlllll;
    }

    public Message sendTo(Messager llllllllllllllllIlllIIllIIIlllIl) {
        Message llllllllllllllllIlllIIllIIIllllI;
        if (llllllllllllllllIlllIIllIIIllllI.value != null) {
            llllllllllllllllIlllIIllIIIlllIl.printMessage(llllllllllllllllIlllIIllIIIllllI.kind, llllllllllllllllIlllIIllIIIllllI.msg, llllllllllllllllIlllIIllIIIllllI.element, llllllllllllllllIlllIIllIIIllllI.annotation, llllllllllllllllIlllIIllIIIllllI.value);
        } else if (llllllllllllllllIlllIIllIIIllllI.annotation != null) {
            llllllllllllllllIlllIIllIIIlllIl.printMessage(llllllllllllllllIlllIIllIIIllllI.kind, llllllllllllllllIlllIIllIIIllllI.msg, llllllllllllllllIlllIIllIIIllllI.element, llllllllllllllllIlllIIllIIIllllI.annotation);
        } else if (llllllllllllllllIlllIIllIIIllllI.element != null) {
            llllllllllllllllIlllIIllIIIlllIl.printMessage(llllllllllllllllIlllIIllIIIllllI.kind, llllllllllllllllIlllIIllIIIllllI.msg, llllllllllllllllIlllIIllIIIllllI.element);
        } else {
            llllllllllllllllIlllIIllIIIlllIl.printMessage(llllllllllllllllIlllIIllIIIllllI.kind, llllllllllllllllIlllIIllIIIllllI.msg);
        }
        return llllllllllllllllIlllIIllIIIllllI;
    }

    public Message(Diagnostic.Kind llllllllllllllllIlllIIllIIlllIIl, CharSequence llllllllllllllllIlllIIllIIlllIII, Element llllllllllllllllIlllIIllIIllllIl, AnnotationHandle llllllllllllllllIlllIIllIIllllII, AnnotationValue llllllllllllllllIlllIIllIIllIlIl) {
        llllllllllllllllIlllIIllIlIIIIII(llllllllllllllllIlllIIllIIlllIIl, llllllllllllllllIlllIIllIIlllIII, llllllllllllllllIlllIIllIIllllIl, llllllllllllllllIlllIIllIIllllII.asMirror(), llllllllllllllllIlllIIllIIllIlIl);
        Message llllllllllllllllIlllIIllIlIIIIII;
    }

    public Message setKind(Diagnostic.Kind llllllllllllllllIlllIIllIIIlIllI) {
        Message llllllllllllllllIlllIIllIIIlIlIl;
        llllllllllllllllIlllIIllIIIlIlIl.kind = llllllllllllllllIlllIIllIIIlIllI;
        return llllllllllllllllIlllIIllIIIlIlIl;
    }

    public Element getElement() {
        Message llllllllllllllllIlllIIlIllllllll;
        return llllllllllllllllIlllIIlIllllllll.element;
    }

    public Message(Diagnostic.Kind llllllllllllllllIlllIIllIIlIIlll, CharSequence llllllllllllllllIlllIIllIIlIIllI, Element llllllllllllllllIlllIIllIIlIIlIl, AnnotationMirror llllllllllllllllIlllIIllIIlIIlII, AnnotationValue llllllllllllllllIlllIIllIIlIlIIl) {
        Message llllllllllllllllIlllIIllIIlIlllI;
        llllllllllllllllIlllIIllIIlIlllI.kind = llllllllllllllllIlllIIllIIlIIlll;
        llllllllllllllllIlllIIllIIlIlllI.msg = llllllllllllllllIlllIIllIIlIIllI;
        llllllllllllllllIlllIIllIIlIlllI.element = llllllllllllllllIlllIIllIIlIIlIl;
        llllllllllllllllIlllIIllIIlIlllI.annotation = llllllllllllllllIlllIIllIIlIIlII;
        llllllllllllllllIlllIIllIIlIlllI.value = llllllllllllllllIlllIIllIIlIlIIl;
    }

    public Message setMsg(CharSequence llllllllllllllllIlllIIllIIIIIlIl) {
        Message llllllllllllllllIlllIIllIIIIIlII;
        llllllllllllllllIlllIIllIIIIIlII.msg = llllllllllllllllIlllIIllIIIIIlIl;
        return llllllllllllllllIlllIIllIIIIIlII;
    }

    public AnnotationMirror getAnnotation() {
        Message llllllllllllllllIlllIIlIllllIlll;
        return llllllllllllllllIlllIIlIllllIlll.annotation;
    }

    public AnnotationValue getValue() {
        Message llllllllllllllllIlllIIlIlllIlllI;
        return llllllllllllllllIlllIIlIlllIlllI.value;
    }

    public Diagnostic.Kind getKind() {
        Message llllllllllllllllIlllIIllIIIllIlI;
        return llllllllllllllllIlllIIllIIIllIlI.kind;
    }

    public Message(Diagnostic.Kind llllllllllllllllIlllIIllIlIIlIlI, CharSequence llllllllllllllllIlllIIllIlIIlllI, Element llllllllllllllllIlllIIllIlIIllIl, AnnotationMirror llllllllllllllllIlllIIllIlIIIlll) {
        llllllllllllllllIlllIIllIlIlIIII(llllllllllllllllIlllIIllIlIIlIlI, llllllllllllllllIlllIIllIlIIlllI, llllllllllllllllIlllIIllIlIIllIl, llllllllllllllllIlllIIllIlIIIlll, null);
        Message llllllllllllllllIlllIIllIlIlIIII;
    }
}

