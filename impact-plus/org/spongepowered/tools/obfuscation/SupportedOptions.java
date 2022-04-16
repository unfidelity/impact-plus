/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableSet
 *  com.google.common.collect.ImmutableSet$Builder
 */
package org.spongepowered.tools.obfuscation;

import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.spongepowered.tools.obfuscation.service.ObfuscationServices;

public final class SupportedOptions {
    public static final /* synthetic */ String DISABLE_TARGET_VALIDATOR;
    public static final /* synthetic */ String DEPENDENCY_TARGETS_FILE;
    public static final /* synthetic */ String DISABLE_OVERWRITE_CHECKER;
    public static final /* synthetic */ String TOKENS;
    public static final /* synthetic */ String OVERWRITE_ERROR_LEVEL;
    public static final /* synthetic */ String DEFAULT_OBFUSCATION_ENV;
    public static final /* synthetic */ String OUT_REFMAP_FILE;
    public static final /* synthetic */ String DISABLE_TARGET_EXPORT;

    private SupportedOptions() {
        SupportedOptions llllllllllllllllllIlIlIlIllIlIII;
    }

    static {
        OUT_REFMAP_FILE = "outRefMapFile";
        DISABLE_TARGET_VALIDATOR = "disableTargetValidator";
        DEPENDENCY_TARGETS_FILE = "dependencyTargetsFile";
        OVERWRITE_ERROR_LEVEL = "overwriteErrorLevel";
        DEFAULT_OBFUSCATION_ENV = "defaultObfuscationEnv";
        DISABLE_TARGET_EXPORT = "disableTargetExport";
        DISABLE_OVERWRITE_CHECKER = "disableOverwriteChecker";
        TOKENS = "tokens";
    }

    public static Set<String> getAllOptions() {
        ImmutableSet.Builder llllllllllllllllllIlIlIlIlIllIII = ImmutableSet.builder();
        llllllllllllllllllIlIlIlIlIllIII.add((Object[])new String[]{"tokens", "outRefMapFile", "disableTargetValidator", "disableTargetExport", "disableOverwriteChecker", "overwriteErrorLevel", "defaultObfuscationEnv", "dependencyTargetsFile"});
        llllllllllllllllllIlIlIlIlIllIII.addAll(ObfuscationServices.getInstance().getSupportedOptions());
        return llllllllllllllllllIlIlIlIlIllIII.build();
    }
}

