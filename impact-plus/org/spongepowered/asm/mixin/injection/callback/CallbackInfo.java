/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.callback;

import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.Cancellable;
import org.spongepowered.asm.mixin.injection.callback.CancellationException;

public class CallbackInfo
implements Cancellable {
    private final /* synthetic */ String name;
    private /* synthetic */ boolean cancelled;
    private final /* synthetic */ boolean cancellable;

    static String getIsCancelledMethodSig() {
        return "()Z";
    }

    static String getCallInfoClassName() {
        return CallbackInfo.class.getName();
    }

    static String getConstructorDescriptor(Type llllllllllllllllIllIIllIllllllIl) {
        if (llllllllllllllllIllIIllIllllllIl.equals(Type.VOID_TYPE)) {
            return CallbackInfo.getConstructorDescriptor();
        }
        if (llllllllllllllllIllIIllIllllllIl.getSort() == 10 || llllllllllllllllIllIIllIllllllIl.getSort() == 9) {
            return String.format("(%sZ%s)V", "Ljava/lang/String;", "Ljava/lang/Object;");
        }
        return String.format("(%sZ%s)V", "Ljava/lang/String;", llllllllllllllllIllIIllIllllllIl.getDescriptor());
    }

    @Override
    public final boolean isCancellable() {
        CallbackInfo llllllllllllllllIllIIlllIIIIlIIl;
        return llllllllllllllllIllIIlllIIIIlIIl.cancellable;
    }

    public CallbackInfo(String llllllllllllllllIllIIlllIIIlIllI, boolean llllllllllllllllIllIIlllIIIlIIlI) {
        CallbackInfo llllllllllllllllIllIIlllIIIlIlll;
        llllllllllllllllIllIIlllIIIlIlll.name = llllllllllllllllIllIIlllIIIlIllI;
        llllllllllllllllIllIIlllIIIlIlll.cancellable = llllllllllllllllIllIIlllIIIlIIlI;
    }

    public String toString() {
        CallbackInfo llllllllllllllllIllIIlllIIIIllII;
        return String.format("CallbackInfo[TYPE=%s,NAME=%s,CANCELLABLE=%s]", llllllllllllllllIllIIlllIIIIllII.getClass().getSimpleName(), llllllllllllllllIllIIlllIIIIllII.name, llllllllllllllllIllIIlllIIIIllII.cancellable);
    }

    public static String getCallInfoClassName(Type llllllllllllllllIllIIlllIIIIIIIl) {
        return (llllllllllllllllIllIIlllIIIIIIIl.equals(Type.VOID_TYPE) ? CallbackInfo.class.getName() : CallbackInfoReturnable.class.getName()).replace('.', '/');
    }

    public String getId() {
        CallbackInfo llllllllllllllllIllIIlllIIIlIIII;
        return llllllllllllllllIllIIlllIIIlIIII.name;
    }

    @Override
    public void cancel() throws CancellationException {
        CallbackInfo llllllllllllllllIllIIlllIIIIIlII;
        if (!llllllllllllllllIllIIlllIIIIIlII.cancellable) {
            throw new CancellationException(String.format("The call %s is not cancellable.", llllllllllllllllIllIIlllIIIIIlII.name));
        }
        llllllllllllllllIllIIlllIIIIIlII.cancelled = true;
    }

    static String getConstructorDescriptor() {
        return String.format("(%sZ)V", "Ljava/lang/String;");
    }

    static String getIsCancelledMethodName() {
        return "isCancelled";
    }

    @Override
    public final boolean isCancelled() {
        CallbackInfo llllllllllllllllIllIIlllIIIIIllI;
        return llllllllllllllllIllIIlllIIIIIllI.cancelled;
    }
}

