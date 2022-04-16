/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util;

import java.io.File;
import org.spongepowered.asm.mixin.Mixin;

public abstract class Constants {
    public static final /* synthetic */ String SYNTHETIC_PACKAGE;
    public static final /* synthetic */ String CLASS;
    public static final /* synthetic */ String OBJECT;
    public static final /* synthetic */ String STRING;
    public static final /* synthetic */ String CTOR;
    public static final /* synthetic */ String IMAGINARY_SUPER;
    public static final /* synthetic */ String DEBUG_OUTPUT_PATH;
    public static final /* synthetic */ char UNICODE_SNOWMAN;
    public static final /* synthetic */ String MIXIN_PACKAGE;
    public static final /* synthetic */ String CLINIT;
    public static final /* synthetic */ File DEBUG_OUTPUT_DIR;
    public static final /* synthetic */ String MIXIN_PACKAGE_REF;

    private Constants() {
        Constants llllllllllllllllIIIIIIIllIllIIll;
    }

    static {
        OBJECT = "Ljava/lang/Object;";
        CLASS = "Ljava/lang/Class;";
        CLINIT = "<clinit>";
        DEBUG_OUTPUT_PATH = ".mixin.out";
        CTOR = "<init>";
        STRING = "Ljava/lang/String;";
        UNICODE_SNOWMAN = (char)9731;
        IMAGINARY_SUPER = "super$";
        SYNTHETIC_PACKAGE = "org.spongepowered.asm.synthetic";
        MIXIN_PACKAGE = Mixin.class.getPackage().getName();
        MIXIN_PACKAGE_REF = MIXIN_PACKAGE.replace('.', '/');
        DEBUG_OUTPUT_DIR = new File(".mixin.out");
    }

    public static abstract class ManifestAttributes {
        public static final /* synthetic */ String MAINCLASS;
        @Deprecated
        public static final /* synthetic */ String COMPATIBILITY;
        public static final /* synthetic */ String TOKENPROVIDERS;
        public static final /* synthetic */ String MIXINCONFIGS;
        public static final /* synthetic */ String TWEAKER;

        private ManifestAttributes() {
            ManifestAttributes llllllllllllllllIlIIlIlIllllllIl;
        }

        static {
            COMPATIBILITY = "MixinCompatibilityLevel";
            MAINCLASS = "Main-Class";
            TWEAKER = "TweakClass";
            MIXINCONFIGS = "MixinConfigs";
            TOKENPROVIDERS = "MixinTokenProviders";
        }
    }
}

