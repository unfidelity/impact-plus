/*
 * Decompiled with CFR 0.152.
 */
package me.zero.alpine.listener;

@FunctionalInterface
public interface EventHook<T> {
    public void invoke(T var1);
}

