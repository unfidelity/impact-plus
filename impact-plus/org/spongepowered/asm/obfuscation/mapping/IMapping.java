/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.obfuscation.mapping;

public interface IMapping<TMapping> {
    public TMapping move(String var1);

    public String getDesc();

    public String serialise();

    public TMapping getSuper();

    public Type getType();

    public String getSimpleName();

    public TMapping remap(String var1);

    public String getName();

    public TMapping transform(String var1);

    public TMapping copy();

    public String getOwner();

    public static enum Type {
        FIELD,
        METHOD,
        CLASS,
        PACKAGE;


        private Type() {
            Type lllIlIlIlI;
        }
    }
}

