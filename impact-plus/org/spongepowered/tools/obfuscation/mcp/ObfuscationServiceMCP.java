/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableSet
 */
package org.spongepowered.tools.obfuscation.mcp;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Set;
import org.spongepowered.tools.obfuscation.mcp.ObfuscationEnvironmentMCP;
import org.spongepowered.tools.obfuscation.service.IObfuscationService;
import org.spongepowered.tools.obfuscation.service.ObfuscationTypeDescriptor;

public class ObfuscationServiceMCP
implements IObfuscationService {
    public static final /* synthetic */ String OUT_REFMAP_FILE;
    public static final /* synthetic */ String REOBF_SRG_FILE;
    public static final /* synthetic */ String OUT_NOTCH_SRG_FILE;
    public static final /* synthetic */ String REOBF_NOTCH_FILE;
    public static final /* synthetic */ String SEARGE;
    public static final /* synthetic */ String REOBF_EXTRA_SRG_FILES;
    public static final /* synthetic */ String NOTCH;
    public static final /* synthetic */ String REOBF_EXTRA_NOTCH_FILES;
    public static final /* synthetic */ String OUT_SRG_SRG_FILE;

    @Override
    public Set<String> getSupportedOptions() {
        return ImmutableSet.of((Object)"reobfSrgFile", (Object)"reobfSrgFiles", (Object)"reobfNotchSrgFile", (Object)"reobfNotchSrgFiles", (Object)"outSrgFile", (Object)"outNotchSrgFile", (Object[])new String[]{"outRefMapFile"});
    }

    @Override
    public Collection<ObfuscationTypeDescriptor> getObfuscationTypes() {
        return ImmutableList.of((Object)new ObfuscationTypeDescriptor("searge", "reobfSrgFile", "reobfSrgFiles", "outSrgFile", ObfuscationEnvironmentMCP.class), (Object)new ObfuscationTypeDescriptor("notch", "reobfNotchSrgFile", "reobfNotchSrgFiles", "outNotchSrgFile", ObfuscationEnvironmentMCP.class));
    }

    public ObfuscationServiceMCP() {
        ObfuscationServiceMCP llllllllllllllllIlllIlllllIllIII;
    }

    static {
        OUT_NOTCH_SRG_FILE = "outNotchSrgFile";
        NOTCH = "notch";
        OUT_SRG_SRG_FILE = "outSrgFile";
        REOBF_SRG_FILE = "reobfSrgFile";
        OUT_REFMAP_FILE = "outRefMapFile";
        REOBF_EXTRA_SRG_FILES = "reobfSrgFiles";
        REOBF_EXTRA_NOTCH_FILES = "reobfNotchSrgFiles";
        SEARGE = "searge";
        REOBF_NOTCH_FILE = "reobfNotchSrgFile";
    }
}

