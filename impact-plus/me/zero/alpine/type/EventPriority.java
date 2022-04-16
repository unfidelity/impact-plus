/*
 * Decompiled with CFR 0.152.
 */
package me.zero.alpine.type;

public interface EventPriority {
    public static final /* synthetic */ byte DEFAULT;
    public static final /* synthetic */ byte LOW;
    public static final /* synthetic */ byte HIGHEST;
    public static final /* synthetic */ byte MEDIUM;
    public static final /* synthetic */ byte LOWEST;
    public static final /* synthetic */ byte HIGH;

    static {
        LOWEST = (byte)5;
        HIGHEST = 1;
        MEDIUM = (byte)3;
        HIGH = (byte)2;
        DEFAULT = (byte)3;
        LOW = (byte)4;
    }
}

