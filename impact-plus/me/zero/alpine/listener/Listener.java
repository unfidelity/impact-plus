/*
 * Decompiled with CFR 0.152.
 */
package me.zero.alpine.listener;

import java.util.function.Predicate;
import me.zero.alpine.listener.EventHook;
import net.jodah.typetools.TypeResolver;

public final class Listener<T>
implements EventHook<T> {
    private final /* synthetic */ Class<T> target;
    private final /* synthetic */ byte priority;
    private final /* synthetic */ EventHook<T> hook;
    private final /* synthetic */ Predicate<T>[] filters;

    public final byte getPriority() {
        Listener llllllllllllllllIlIIlIIlIIllIlII;
        return llllllllllllllllIlIIlIIlIIllIlII.priority;
    }

    @SafeVarargs
    public Listener(EventHook<T> llllllllllllllllIlIIlIIlIIllllII, byte llllllllllllllllIlIIlIIlIIllllll, Predicate<T> ... llllllllllllllllIlIIlIIlIIlllIlI) {
        Listener llllllllllllllllIlIIlIIlIlIIIIIl;
        llllllllllllllllIlIIlIIlIlIIIIIl.hook = llllllllllllllllIlIIlIIlIIllllII;
        llllllllllllllllIlIIlIIlIlIIIIIl.priority = llllllllllllllllIlIIlIIlIIllllll;
        llllllllllllllllIlIIlIIlIlIIIIIl.target = TypeResolver.resolveRawArgument(EventHook.class, llllllllllllllllIlIIlIIlIIllllII.getClass());
        llllllllllllllllIlIIlIIlIlIIIIIl.filters = llllllllllllllllIlIIlIIlIIlllIlI;
    }

    @SafeVarargs
    public Listener(EventHook<T> llllllllllllllllIlIIlIIlIlIIIlll, Predicate<T> ... llllllllllllllllIlIIlIIlIlIIlIIl) {
        llllllllllllllllIlIIlIIlIlIIlIII(llllllllllllllllIlIIlIIlIlIIIlll, 3, llllllllllllllllIlIIlIIlIlIIlIIl);
        Listener<T> llllllllllllllllIlIIlIIlIlIIlIII;
    }

    @Override
    public final void invoke(T llllllllllllllllIlIIlIIlIIlIlIIl) {
        Listener llllllllllllllllIlIIlIIlIIlIllII;
        if (llllllllllllllllIlIIlIIlIIlIllII.filters.length > 0) {
            for (Predicate<T> llllllllllllllllIlIIlIIlIIlIllIl : llllllllllllllllIlIIlIIlIIlIllII.filters) {
                if (llllllllllllllllIlIIlIIlIIlIllIl.test(llllllllllllllllIlIIlIIlIIlIlIIl)) continue;
                return;
            }
        }
        llllllllllllllllIlIIlIIlIIlIllII.hook.invoke(llllllllllllllllIlIIlIIlIIlIlIIl);
    }

    public final Class<T> getTarget() {
        Listener llllllllllllllllIlIIlIIlIIllIlll;
        return llllllllllllllllIlIIlIIlIIllIlll.target;
    }
}

