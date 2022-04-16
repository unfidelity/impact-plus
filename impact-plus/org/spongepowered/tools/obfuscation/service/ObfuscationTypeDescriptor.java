/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.service;

import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;

public class ObfuscationTypeDescriptor {
    private final /* synthetic */ String extraInputFilesArgName;
    private final /* synthetic */ Class<? extends ObfuscationEnvironment> environmentType;
    private final /* synthetic */ String outFileArgName;
    private final /* synthetic */ String key;
    private final /* synthetic */ String inputFileArgName;

    public ObfuscationTypeDescriptor(String llllllllllllllllIIIlIllIllIlIIlI, String llllllllllllllllIIIlIllIllIlIIIl, String llllllllllllllllIIIlIllIllIlIllI, String llllllllllllllllIIIlIllIllIIllll, Class<? extends ObfuscationEnvironment> llllllllllllllllIIIlIllIllIIlllI) {
        ObfuscationTypeDescriptor llllllllllllllllIIIlIllIllIlIIll;
        llllllllllllllllIIIlIllIllIlIIll.key = llllllllllllllllIIIlIllIllIlIIlI;
        llllllllllllllllIIIlIllIllIlIIll.inputFileArgName = llllllllllllllllIIIlIllIllIlIIIl;
        llllllllllllllllIIIlIllIllIlIIll.extraInputFilesArgName = llllllllllllllllIIIlIllIllIlIllI;
        llllllllllllllllIIIlIllIllIlIIll.outFileArgName = llllllllllllllllIIIlIllIllIIllll;
        llllllllllllllllIIIlIllIllIlIIll.environmentType = llllllllllllllllIIIlIllIllIIlllI;
    }

    public final String getKey() {
        ObfuscationTypeDescriptor llllllllllllllllIIIlIllIllIIlIll;
        return llllllllllllllllIIIlIllIllIIlIll.key;
    }

    public Class<? extends ObfuscationEnvironment> getEnvironmentType() {
        ObfuscationTypeDescriptor llllllllllllllllIIIlIllIllIIIIII;
        return llllllllllllllllIIIlIllIllIIIIII.environmentType;
    }

    public String getOutputFileOption() {
        ObfuscationTypeDescriptor llllllllllllllllIIIlIllIllIIIIll;
        return llllllllllllllllIIIlIllIllIIIIll.outFileArgName;
    }

    public ObfuscationTypeDescriptor(String llllllllllllllllIIIlIllIlllIlIII, String llllllllllllllllIIIlIllIlllIIlll, String llllllllllllllllIIIlIllIlllIIllI, Class<? extends ObfuscationEnvironment> llllllllllllllllIIIlIllIlllIIlIl) {
        llllllllllllllllIIIlIllIlllIIlII(llllllllllllllllIIIlIllIlllIlIII, llllllllllllllllIIIlIllIlllIIlll, null, llllllllllllllllIIIlIllIlllIIllI, llllllllllllllllIIIlIllIlllIIlIl);
        ObfuscationTypeDescriptor llllllllllllllllIIIlIllIlllIIlII;
    }

    public String getInputFileOption() {
        ObfuscationTypeDescriptor llllllllllllllllIIIlIllIllIIlIII;
        return llllllllllllllllIIIlIllIllIIlIII.inputFileArgName;
    }

    public String getExtraInputFilesOption() {
        ObfuscationTypeDescriptor llllllllllllllllIIIlIllIllIIIllI;
        return llllllllllllllllIIIlIllIllIIIllI.extraInputFilesArgName;
    }
}

