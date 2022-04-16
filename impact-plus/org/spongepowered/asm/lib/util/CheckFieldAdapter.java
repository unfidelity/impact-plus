/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.util.CheckAnnotationAdapter;
import org.spongepowered.asm.lib.util.CheckClassAdapter;
import org.spongepowered.asm.lib.util.CheckMethodAdapter;

public class CheckFieldAdapter
extends FieldVisitor {
    private /* synthetic */ boolean end;

    public AnnotationVisitor visitAnnotation(String llllllllllllllllIIIIlllIlIlllllI, boolean llllllllllllllllIIIIlllIlIlllIlI) {
        CheckFieldAdapter llllllllllllllllIIIIlllIlIllllll;
        llllllllllllllllIIIIlllIlIllllll.checkEnd();
        CheckMethodAdapter.checkDesc(llllllllllllllllIIIIlllIlIlllllI, false);
        return new CheckAnnotationAdapter(super.visitAnnotation(llllllllllllllllIIIIlllIlIlllllI, llllllllllllllllIIIIlllIlIlllIlI));
    }

    public void visitAttribute(Attribute llllllllllllllllIIIIlllIlIlIIIlI) {
        CheckFieldAdapter llllllllllllllllIIIIlllIlIlIIlIl;
        llllllllllllllllIIIIlllIlIlIIlIl.checkEnd();
        if (llllllllllllllllIIIIlllIlIlIIIlI == null) {
            throw new IllegalArgumentException("Invalid attribute (must not be null)");
        }
        super.visitAttribute(llllllllllllllllIIIIlllIlIlIIIlI);
    }

    protected CheckFieldAdapter(int llllllllllllllllIIIIlllIllIIIlII, FieldVisitor llllllllllllllllIIIIlllIllIIIllI) {
        super(llllllllllllllllIIIIlllIllIIIlII, llllllllllllllllIIIIlllIllIIIllI);
        CheckFieldAdapter llllllllllllllllIIIIlllIllIIIlIl;
    }

    private void checkEnd() {
        CheckFieldAdapter llllllllllllllllIIIIlllIlIIlllII;
        if (llllllllllllllllIIIIlllIlIIlllII.end) {
            throw new IllegalStateException("Cannot call a visit method after visitEnd has been called");
        }
    }

    public void visitEnd() {
        CheckFieldAdapter llllllllllllllllIIIIlllIlIIlllll;
        llllllllllllllllIIIIlllIlIIlllll.checkEnd();
        llllllllllllllllIIIIlllIlIIlllll.end = true;
        super.visitEnd();
    }

    public CheckFieldAdapter(FieldVisitor llllllllllllllllIIIIlllIllIIlllI) {
        llllllllllllllllIIIIlllIllIIllll(327680, llllllllllllllllIIIIlllIllIIlllI);
        CheckFieldAdapter llllllllllllllllIIIIlllIllIIllll;
        if (llllllllllllllllIIIIlllIllIIllll.getClass() != CheckFieldAdapter.class) {
            throw new IllegalStateException();
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int llllllllllllllllIIIIlllIlIllIIlI, TypePath llllllllllllllllIIIIlllIlIllIIIl, String llllllllllllllllIIIIlllIlIllIIII, boolean llllllllllllllllIIIIlllIlIlIlIIl) {
        CheckFieldAdapter llllllllllllllllIIIIlllIlIllIIll;
        llllllllllllllllIIIIlllIlIllIIll.checkEnd();
        int llllllllllllllllIIIIlllIlIlIlllI = llllllllllllllllIIIIlllIlIllIIlI >>> 24;
        if (llllllllllllllllIIIIlllIlIlIlllI != 19) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type reference sort 0x").append(Integer.toHexString(llllllllllllllllIIIIlllIlIlIlllI))));
        }
        CheckClassAdapter.checkTypeRefAndPath(llllllllllllllllIIIIlllIlIllIIlI, llllllllllllllllIIIIlllIlIllIIIl);
        CheckMethodAdapter.checkDesc(llllllllllllllllIIIIlllIlIllIIII, false);
        return new CheckAnnotationAdapter(super.visitTypeAnnotation(llllllllllllllllIIIIlllIlIllIIlI, llllllllllllllllIIIIlllIlIllIIIl, llllllllllllllllIIIIlllIlIllIIII, llllllllllllllllIIIIlllIlIlIlIIl));
    }
}

