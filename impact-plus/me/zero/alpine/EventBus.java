/*
 * Decompiled with CFR 0.152.
 */
package me.zero.alpine;

public interface EventBus {
    public void subscribe(Object var1);

    public void post(Object var1);

    public void detach(EventBus var1);

    public void attach(EventBus var1);

    public void unsubscribe(Object var1);

    public void subscribe(Object ... var1);

    public void unsubscribe(Iterable<Object> var1);

    public void subscribe(Iterable<Object> var1);

    public void unsubscribe(Object ... var1);
}

