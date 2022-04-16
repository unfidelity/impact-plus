/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util.throwables;

import org.spongepowered.asm.util.ConstraintParser;

public class ConstraintViolationException
extends Exception {
    private static final /* synthetic */ String MISSING_VALUE;
    private static final /* synthetic */ long serialVersionUID = 1L;
    private final /* synthetic */ String badValue;
    private final /* synthetic */ ConstraintParser.Constraint constraint;

    public ConstraintViolationException(String llIllIllIlIIlll, ConstraintParser.Constraint llIllIllIlIIIlI, int llIllIllIlIIlIl) {
        super(llIllIllIlIIlll);
        ConstraintViolationException llIllIllIlIlIII;
        llIllIllIlIlIII.constraint = llIllIllIlIIIlI;
        llIllIllIlIlIII.badValue = String.valueOf(llIllIllIlIIlIl);
    }

    static {
        MISSING_VALUE = "UNRESOLVED";
    }

    public ConstraintViolationException(String llIllIllIIIIIlI, Throwable llIllIllIIIIlIl, ConstraintParser.Constraint llIllIllIIIIlII) {
        super(llIllIllIIIIIlI, llIllIllIIIIlIl);
        ConstraintViolationException llIllIllIIIIlll;
        llIllIllIIIIlll.constraint = llIllIllIIIIlII;
        llIllIllIIIIlll.badValue = "UNRESOLVED";
    }

    public ConstraintViolationException(Throwable llIllIllIIlllII, ConstraintParser.Constraint llIllIllIIllIll) {
        super(llIllIllIIlllII);
        ConstraintViolationException llIllIllIIllIlI;
        llIllIllIIllIlI.constraint = llIllIllIIllIll;
        llIllIllIIllIlI.badValue = "UNRESOLVED";
    }

    public ConstraintViolationException(String llIllIllIlIlllI, ConstraintParser.Constraint llIllIllIlIllIl) {
        super(llIllIllIlIlllI);
        ConstraintViolationException llIllIllIlIllll;
        llIllIllIlIllll.constraint = llIllIllIlIllIl;
        llIllIllIlIllll.badValue = "UNRESOLVED";
    }

    public String getBadValue() {
        ConstraintViolationException llIllIlIllIllII;
        return llIllIlIllIllII.badValue;
    }

    public ConstraintParser.Constraint getConstraint() {
        ConstraintViolationException llIllIlIllIllll;
        return llIllIlIllIllll.constraint;
    }

    public ConstraintViolationException(Throwable llIllIllIIIlllI, ConstraintParser.Constraint llIllIllIIIllIl, int llIllIllIIlIIII) {
        super(llIllIllIIIlllI);
        ConstraintViolationException llIllIllIIlIIll;
        llIllIllIIlIIll.constraint = llIllIllIIIllIl;
        llIllIllIIlIIll.badValue = String.valueOf(llIllIllIIlIIII);
    }

    public ConstraintViolationException(ConstraintParser.Constraint llIllIlllIIIIIl) {
        ConstraintViolationException llIllIlllIIIIlI;
        llIllIlllIIIIlI.constraint = llIllIlllIIIIIl;
        llIllIlllIIIIlI.badValue = "UNRESOLVED";
    }

    public ConstraintViolationException(ConstraintParser.Constraint llIllIllIllIlll, int llIllIllIlllIIl) {
        ConstraintViolationException llIllIllIlllIll;
        llIllIllIlllIll.constraint = llIllIllIllIlll;
        llIllIllIlllIll.badValue = String.valueOf(llIllIllIlllIIl);
    }

    public ConstraintViolationException(String llIllIlIlllIlII, Throwable llIllIlIlllIIll, ConstraintParser.Constraint llIllIlIlllIIlI, int llIllIlIlllIIIl) {
        super(llIllIlIlllIlII, llIllIlIlllIIll);
        ConstraintViolationException llIllIlIllllIlI;
        llIllIlIllllIlI.constraint = llIllIlIlllIIlI;
        llIllIlIllllIlI.badValue = String.valueOf(llIllIlIlllIIIl);
    }
}

