/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.signature.SignatureVisitor;
import org.spongepowered.asm.lib.util.CheckMethodAdapter;

public class CheckSignatureAdapter
extends SignatureVisitor {
    private /* synthetic */ boolean canBeVoid;
    private static final /* synthetic */ int SIMPLE_TYPE;
    public static final /* synthetic */ int METHOD_SIGNATURE;
    private final /* synthetic */ SignatureVisitor sv;
    private static final /* synthetic */ int END;
    private final /* synthetic */ int type;
    public static final /* synthetic */ int TYPE_SIGNATURE;
    public static final /* synthetic */ int CLASS_SIGNATURE;
    private /* synthetic */ int state;
    private static final /* synthetic */ int RETURN;
    private static final /* synthetic */ int BOUND;
    private static final /* synthetic */ int PARAM;
    private static final /* synthetic */ int FORMAL;
    private static final /* synthetic */ int EMPTY;
    private static final /* synthetic */ int CLASS_TYPE;
    private static final /* synthetic */ int SUPER;

    public SignatureVisitor visitExceptionType() {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIIllIlII;
        if (llllllllllllllllIllIlIlIIIllIlII.state != 32) {
            throw new IllegalStateException();
        }
        SignatureVisitor llllllllllllllllIllIlIlIIIllIllI = llllllllllllllllIllIlIlIIIllIlII.sv == null ? null : llllllllllllllllIllIlIlIIIllIlII.sv.visitExceptionType();
        return new CheckSignatureAdapter(2, llllllllllllllllIllIlIlIIIllIllI);
    }

    public SignatureVisitor visitInterfaceBound() {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIlIllIlI;
        if (llllllllllllllllIllIlIlIIlIllIlI.state != 2 && llllllllllllllllIllIlIlIIlIllIlI.state != 4) {
            throw new IllegalArgumentException();
        }
        SignatureVisitor llllllllllllllllIllIlIlIIlIllIll = llllllllllllllllIllIlIlIIlIllIlI.sv == null ? null : llllllllllllllllIllIlIlIIlIllIlI.sv.visitInterfaceBound();
        return new CheckSignatureAdapter(2, llllllllllllllllIllIlIlIIlIllIll);
    }

    public void visitFormalTypeParameter(String llllllllllllllllIllIlIlIIllIIlIl) {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIllIlIII;
        if (llllllllllllllllIllIlIlIIllIlIII.type == 2 || llllllllllllllllIllIlIlIIllIlIII.state != 1 && llllllllllllllllIllIlIlIIllIlIII.state != 2 && llllllllllllllllIllIlIlIIllIlIII.state != 4) {
            throw new IllegalStateException();
        }
        CheckMethodAdapter.checkIdentifier(llllllllllllllllIllIlIlIIllIIlIl, "formal type parameter");
        llllllllllllllllIllIlIlIIllIlIII.state = 2;
        if (llllllllllllllllIllIlIlIIllIlIII.sv != null) {
            llllllllllllllllIllIlIlIIllIlIII.sv.visitFormalTypeParameter(llllllllllllllllIllIlIlIIllIIlIl);
        }
    }

    static {
        METHOD_SIGNATURE = 1;
        TYPE_SIGNATURE = 2;
        CLASS_SIGNATURE = 0;
        END = 256;
        SUPER = 8;
        RETURN = 32;
        BOUND = 4;
        PARAM = 16;
        SIMPLE_TYPE = 64;
        CLASS_TYPE = 128;
        EMPTY = 1;
        FORMAL = 2;
    }

    public SignatureVisitor visitReturnType() {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIlIIIIII;
        if (llllllllllllllllIllIlIlIIlIIIIII.type != 1 || (llllllllllllllllIllIlIlIIlIIIIII.state & 0x17) == 0) {
            throw new IllegalArgumentException();
        }
        llllllllllllllllIllIlIlIIlIIIIII.state = 32;
        SignatureVisitor llllllllllllllllIllIlIlIIlIIIIlI = llllllllllllllllIllIlIlIIlIIIIII.sv == null ? null : llllllllllllllllIllIlIlIIlIIIIII.sv.visitReturnType();
        CheckSignatureAdapter llllllllllllllllIllIlIlIIlIIIIIl = new CheckSignatureAdapter(2, llllllllllllllllIllIlIlIIlIIIIlI);
        llllllllllllllllIllIlIlIIlIIIIIl.canBeVoid = true;
        return llllllllllllllllIllIlIlIIlIIIIIl;
    }

    public void visitInnerClassType(String llllllllllllllllIllIlIIllllllIIl) {
        CheckSignatureAdapter llllllllllllllllIllIlIIllllllIll;
        if (llllllllllllllllIllIlIIllllllIll.state != 128) {
            throw new IllegalStateException();
        }
        CheckMethodAdapter.checkIdentifier(llllllllllllllllIllIlIIllllllIIl, "inner class name");
        if (llllllllllllllllIllIlIIllllllIll.sv != null) {
            llllllllllllllllIllIlIIllllllIll.sv.visitInnerClassType(llllllllllllllllIllIlIIllllllIIl);
        }
    }

    public void visitClassType(String llllllllllllllllIllIlIlIIIIIIIIl) {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIIIIIlII;
        if (llllllllllllllllIllIlIlIIIIIIlII.type != 2 || llllllllllllllllIllIlIlIIIIIIlII.state != 1) {
            throw new IllegalStateException();
        }
        CheckMethodAdapter.checkInternalName(llllllllllllllllIllIlIlIIIIIIIIl, "class name");
        llllllllllllllllIllIlIlIIIIIIlII.state = 128;
        if (llllllllllllllllIllIlIlIIIIIIlII.sv != null) {
            llllllllllllllllIllIlIlIIIIIIlII.sv.visitClassType(llllllllllllllllIllIlIlIIIIIIIIl);
        }
    }

    public void visitBaseType(char llllllllllllllllIllIlIlIIIlIIIll) {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIIlIIIlI;
        if (llllllllllllllllIllIlIlIIIlIIIlI.type != 2 || llllllllllllllllIllIlIlIIIlIIIlI.state != 1) {
            throw new IllegalStateException();
        }
        if (llllllllllllllllIllIlIlIIIlIIIll == 'V' ? !llllllllllllllllIllIlIlIIIlIIIlI.canBeVoid : "ZCBSIFJD".indexOf(llllllllllllllllIllIlIlIIIlIIIll) == -1) {
            throw new IllegalArgumentException();
        }
        llllllllllllllllIllIlIlIIIlIIIlI.state = 64;
        if (llllllllllllllllIllIlIlIIIlIIIlI.sv != null) {
            llllllllllllllllIllIlIlIIIlIIIlI.sv.visitBaseType(llllllllllllllllIllIlIlIIIlIIIll);
        }
    }

    public SignatureVisitor visitInterface() {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIlIlIIII;
        if (llllllllllllllllIllIlIlIIlIlIIII.state != 8) {
            throw new IllegalStateException();
        }
        SignatureVisitor llllllllllllllllIllIlIlIIlIIllll = llllllllllllllllIllIlIlIIlIlIIII.sv == null ? null : llllllllllllllllIllIlIlIIlIlIIII.sv.visitInterface();
        return new CheckSignatureAdapter(2, llllllllllllllllIllIlIlIIlIIllll);
    }

    public void visitTypeVariable(String llllllllllllllllIllIlIlIIIIlIIll) {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIIIlIlII;
        if (llllllllllllllllIllIlIlIIIIlIlII.type != 2 || llllllllllllllllIllIlIlIIIIlIlII.state != 1) {
            throw new IllegalStateException();
        }
        CheckMethodAdapter.checkIdentifier(llllllllllllllllIllIlIlIIIIlIIll, "type variable");
        llllllllllllllllIllIlIlIIIIlIlII.state = 64;
        if (llllllllllllllllIllIlIlIIIIlIlII.sv != null) {
            llllllllllllllllIllIlIlIIIIlIlII.sv.visitTypeVariable(llllllllllllllllIllIlIlIIIIlIIll);
        }
    }

    protected CheckSignatureAdapter(int llllllllllllllllIllIlIlIIlllIIIl, int llllllllllllllllIllIlIlIIllIllII, SignatureVisitor llllllllllllllllIllIlIlIIllIlIll) {
        super(llllllllllllllllIllIlIlIIlllIIIl);
        CheckSignatureAdapter llllllllllllllllIllIlIlIIlllIIlI;
        llllllllllllllllIllIlIlIIlllIIlI.type = llllllllllllllllIllIlIlIIllIllII;
        llllllllllllllllIllIlIlIIlllIIlI.state = 1;
        llllllllllllllllIllIlIlIIlllIIlI.sv = llllllllllllllllIllIlIlIIllIlIll;
    }

    public SignatureVisitor visitTypeArgument(char llllllllllllllllIllIlIIlllIllIll) {
        CheckSignatureAdapter llllllllllllllllIllIlIIlllIllIIl;
        if (llllllllllllllllIllIlIIlllIllIIl.state != 128) {
            throw new IllegalStateException();
        }
        if ("+-=".indexOf(llllllllllllllllIllIlIIlllIllIll) == -1) {
            throw new IllegalArgumentException();
        }
        SignatureVisitor llllllllllllllllIllIlIIlllIllIlI = llllllllllllllllIllIlIIlllIllIIl.sv == null ? null : llllllllllllllllIllIlIIlllIllIIl.sv.visitTypeArgument(llllllllllllllllIllIlIIlllIllIll);
        return new CheckSignatureAdapter(2, llllllllllllllllIllIlIIlllIllIlI);
    }

    public SignatureVisitor visitSuperclass() {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIlIlIlII;
        if (llllllllllllllllIllIlIlIIlIlIlII.type != 0 || (llllllllllllllllIllIlIlIIlIlIlII.state & 7) == 0) {
            throw new IllegalArgumentException();
        }
        llllllllllllllllIllIlIlIIlIlIlII.state = 8;
        SignatureVisitor llllllllllllllllIllIlIlIIlIlIlIl = llllllllllllllllIllIlIlIIlIlIlII.sv == null ? null : llllllllllllllllIllIlIlIIlIlIlII.sv.visitSuperclass();
        return new CheckSignatureAdapter(2, llllllllllllllllIllIlIlIIlIlIlIl);
    }

    public SignatureVisitor visitClassBound() {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIllIIIII;
        if (llllllllllllllllIllIlIlIIllIIIII.state != 2) {
            throw new IllegalStateException();
        }
        llllllllllllllllIllIlIlIIllIIIII.state = 4;
        SignatureVisitor llllllllllllllllIllIlIlIIllIIIIl = llllllllllllllllIllIlIlIIllIIIII.sv == null ? null : llllllllllllllllIllIlIlIIllIIIII.sv.visitClassBound();
        return new CheckSignatureAdapter(2, llllllllllllllllIllIlIlIIllIIIIl);
    }

    public CheckSignatureAdapter(int llllllllllllllllIllIlIlIIllllIII, SignatureVisitor llllllllllllllllIllIlIlIIlllIlll) {
        llllllllllllllllIllIlIlIIlllllII(327680, llllllllllllllllIllIlIlIIllllIII, llllllllllllllllIllIlIlIIlllIlll);
        CheckSignatureAdapter llllllllllllllllIllIlIlIIlllllII;
    }

    public SignatureVisitor visitParameterType() {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIlIIlIlI;
        if (llllllllllllllllIllIlIlIIlIIlIlI.type != 1 || (llllllllllllllllIllIlIlIIlIIlIlI.state & 0x17) == 0) {
            throw new IllegalArgumentException();
        }
        llllllllllllllllIllIlIlIIlIIlIlI.state = 16;
        SignatureVisitor llllllllllllllllIllIlIlIIlIIlIIl = llllllllllllllllIllIlIlIIlIIlIlI.sv == null ? null : llllllllllllllllIllIlIlIIlIIlIlI.sv.visitParameterType();
        return new CheckSignatureAdapter(2, llllllllllllllllIllIlIlIIlIIlIIl);
    }

    public SignatureVisitor visitArrayType() {
        CheckSignatureAdapter llllllllllllllllIllIlIlIIIIIlIll;
        if (llllllllllllllllIllIlIlIIIIIlIll.type != 2 || llllllllllllllllIllIlIlIIIIIlIll.state != 1) {
            throw new IllegalStateException();
        }
        llllllllllllllllIllIlIlIIIIIlIll.state = 64;
        SignatureVisitor llllllllllllllllIllIlIlIIIIIllIl = llllllllllllllllIllIlIlIIIIIlIll.sv == null ? null : llllllllllllllllIllIlIlIIIIIlIll.sv.visitArrayType();
        return new CheckSignatureAdapter(2, llllllllllllllllIllIlIlIIIIIllIl);
    }

    public void visitTypeArgument() {
        CheckSignatureAdapter llllllllllllllllIllIlIIllllIlIll;
        if (llllllllllllllllIllIlIIllllIlIll.state != 128) {
            throw new IllegalStateException();
        }
        if (llllllllllllllllIllIlIIllllIlIll.sv != null) {
            llllllllllllllllIllIlIIllllIlIll.sv.visitTypeArgument();
        }
    }

    public void visitEnd() {
        CheckSignatureAdapter llllllllllllllllIllIlIIlllIlIlII;
        if (llllllllllllllllIllIlIIlllIlIlII.state != 128) {
            throw new IllegalStateException();
        }
        llllllllllllllllIllIlIIlllIlIlII.state = 256;
        if (llllllllllllllllIllIlIIlllIlIlII.sv != null) {
            llllllllllllllllIllIlIIlllIlIlII.sv.visitEnd();
        }
    }
}

