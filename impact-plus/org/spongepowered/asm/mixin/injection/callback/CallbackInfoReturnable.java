/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.callback;

import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CancellationException;

public class CallbackInfoReturnable<R>
extends CallbackInfo {
    private /* synthetic */ R returnValue;

    public CallbackInfoReturnable(String llIIlllIllI, boolean llIIllllIIl, short llIIllllIII) {
        super(llIIlllIllI, llIIllllIIl);
        CallbackInfoReturnable llIIllllIll;
        llIIllllIll.returnValue = llIIllllIII;
    }

    public int getReturnValueI() {
        CallbackInfoReturnable llIIIlllllI;
        if (llIIIlllllI.returnValue == null) {
            return 0;
        }
        return (Integer)llIIIlllllI.returnValue;
    }

    public boolean getReturnValueZ() {
        CallbackInfoReturnable llIIIlIllIl;
        if (llIIIlIllIl.returnValue == null) {
            return false;
        }
        return (Boolean)llIIIlIllIl.returnValue;
    }

    public R getReturnValue() {
        CallbackInfoReturnable llIIllIIIII;
        return llIIllIIIII.returnValue;
    }

    public void setReturnValue(R llIIllIIIlI) throws CancellationException {
        CallbackInfoReturnable llIIllIIIll;
        super.cancel();
        llIIllIIIll.returnValue = llIIllIIIlI;
    }

    public CallbackInfoReturnable(String llIIllIlllI, boolean llIIllIlIIl, boolean llIIllIlIII) {
        super(llIIllIlllI, llIIllIlIIl);
        CallbackInfoReturnable llIIllIlIll;
        llIIllIlIll.returnValue = llIIllIlIII;
    }

    public char getReturnValueC() {
        CallbackInfoReturnable llIIlIllIlI;
        if (llIIlIllIlI.returnValue == null) {
            return '\u0000';
        }
        return ((Character)llIIlIllIlI.returnValue).charValue();
    }

    public short getReturnValueS() {
        CallbackInfoReturnable llIIIllIlII;
        if (llIIIllIlII.returnValue == null) {
            return 0;
        }
        return (Short)llIIIllIlII.returnValue;
    }

    public double getReturnValueD() {
        CallbackInfoReturnable llIIlIlIlll;
        if (llIIlIlIlll.returnValue == null) {
            return 0.0;
        }
        return (Double)llIIlIlIlll.returnValue;
    }

    public CallbackInfoReturnable(String llIlIIllIlI, boolean llIlIIllIIl, float llIlIIlllII) {
        super(llIlIIllIlI, llIlIIllIIl);
        CallbackInfoReturnable llIlIIlllll;
        llIlIIlllll.returnValue = Float.valueOf(llIlIIlllII);
    }

    static String getReturnDescriptor(Type llIIIIllIlI) {
        if (llIIIIllIlI.getSort() == 10 || llIIIIllIlI.getSort() == 9) {
            return String.format("()%s", "Ljava/lang/Object;");
        }
        return String.format("()%s", llIIIIllIlI.getDescriptor());
    }

    public long getReturnValueJ() {
        CallbackInfoReturnable llIIIlllIll;
        if (llIIIlllIll.returnValue == null) {
            return 0L;
        }
        return (Long)llIIIlllIll.returnValue;
    }

    public CallbackInfoReturnable(String llIllIlIlIl, boolean llIllIlIlll) {
        super(llIllIlIlIl, llIllIlIlll);
        CallbackInfoReturnable llIllIlIllI;
        llIllIlIllI.returnValue = null;
    }

    public CallbackInfoReturnable(String llIllIIlIlI, boolean llIllIIllIl, R llIllIIllII) {
        super(llIllIIlIlI, llIllIIllIl);
        CallbackInfoReturnable llIllIIlIll;
        llIllIIlIll.returnValue = llIllIIllII;
    }

    public CallbackInfoReturnable(String llIlIIlIIlI, boolean llIlIIlIIIl, int llIlIIlIIII) {
        super(llIlIIlIIlI, llIlIIlIIIl);
        CallbackInfoReturnable llIlIIIllll;
        llIlIIIllll.returnValue = llIlIIlIIII;
    }

    public CallbackInfoReturnable(String llIlIllIIlI, boolean llIlIllIlIl, char llIlIllIIII) {
        super(llIlIllIIlI, llIlIllIlIl);
        CallbackInfoReturnable llIlIllIlll;
        llIlIllIlll.returnValue = Character.valueOf(llIlIllIIII);
    }

    static String getReturnAccessor(Type llIIIlIIIll) {
        if (llIIIlIIIll.getSort() == 10 || llIIIlIIIll.getSort() == 9) {
            return "getReturnValue";
        }
        return String.format("getReturnValue%s", llIIIlIIIll.getDescriptor());
    }

    public CallbackInfoReturnable(String llIlIIIIllI, boolean llIlIIIIIIl, long llIlIIIIIII) {
        super(llIlIIIIllI, llIlIIIIIIl);
        CallbackInfoReturnable llIlIIIIIll;
        llIlIIIIIll.returnValue = llIlIIIIIII;
    }

    public CallbackInfoReturnable(String llIlIlIIllI, boolean llIlIlIIlIl, double llIlIlIIlII) {
        super(llIlIlIIllI, llIlIlIIlIl);
        CallbackInfoReturnable llIlIlIIlll;
        llIlIlIIlll.returnValue = llIlIlIIlII;
    }

    public CallbackInfoReturnable(String llIlIlllllI, boolean llIlIllllIl, byte llIllIIIIII) {
        super(llIlIlllllI, llIlIllllIl);
        CallbackInfoReturnable llIllIIIIll;
        llIllIIIIll.returnValue = llIllIIIIII;
    }

    public byte getReturnValueB() {
        CallbackInfoReturnable llIIlIlllII;
        if (llIIlIlllII.returnValue == null) {
            return 0;
        }
        return (Byte)llIIlIlllII.returnValue;
    }

    public float getReturnValueF() {
        CallbackInfoReturnable llIIlIIllll;
        if (llIIlIIllll.returnValue == null) {
            return 0.0f;
        }
        return ((Float)llIIlIIllll.returnValue).floatValue();
    }
}

