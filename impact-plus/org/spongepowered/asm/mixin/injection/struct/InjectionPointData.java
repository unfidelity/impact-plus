/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Joiner
 *  com.google.common.base.Strings
 */
package org.spongepowered.asm.mixin.injection.struct;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.modify.LocalVariableDiscriminator;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InvalidMemberDescriptorException;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionPointException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;

public class InjectionPointData {
    private final /* synthetic */ IMixinContext context;
    private final /* synthetic */ String id;
    private final /* synthetic */ AnnotationNode parent;
    private final /* synthetic */ InjectionPoint.Selector selector;
    private final /* synthetic */ String at;
    private final /* synthetic */ int ordinal;
    private final /* synthetic */ MethodNode method;
    private final /* synthetic */ String slice;
    private final /* synthetic */ String type;
    private final /* synthetic */ int opcode;
    private final /* synthetic */ String target;
    private final /* synthetic */ Map<String, String> args;
    private static final /* synthetic */ Pattern AT_PATTERN;

    public int getOpcode(int llllllllllllllllIIlIIIlllIIlllIl, int ... llllllllllllllllIIlIIIlllIIlllll) {
        for (int llllllllllllllllIIlIIIlllIlIIIlI : llllllllllllllllIIlIIIlllIIlllll) {
            InjectionPointData llllllllllllllllIIlIIIlllIIllllI;
            if (llllllllllllllllIIlIIIlllIIllllI.opcode != llllllllllllllllIIlIIIlllIlIIIlI) continue;
            return llllllllllllllllIIlIIIlllIIllllI.opcode;
        }
        return llllllllllllllllIIlIIIlllIIlllIl;
    }

    private void parseArgs(List<String> llllllllllllllllIIlIIlIIIIlIIlll) {
        if (llllllllllllllllIIlIIlIIIIlIIlll == null) {
            return;
        }
        for (String llllllllllllllllIIlIIlIIIIlIlIll : llllllllllllllllIIlIIlIIIIlIIlll) {
            InjectionPointData llllllllllllllllIIlIIlIIIIlIlIII;
            if (llllllllllllllllIIlIIlIIIIlIlIll == null) continue;
            int llllllllllllllllIIlIIlIIIIlIllII = llllllllllllllllIIlIIlIIIIlIlIll.indexOf(61);
            if (llllllllllllllllIIlIIlIIIIlIllII > -1) {
                llllllllllllllllIIlIIlIIIIlIlIII.args.put(llllllllllllllllIIlIIlIIIIlIlIll.substring(0, llllllllllllllllIIlIIlIIIIlIllII), llllllllllllllllIIlIIlIIIIlIlIll.substring(llllllllllllllllIIlIIlIIIIlIllII + 1));
                continue;
            }
            llllllllllllllllIIlIIlIIIIlIlIII.args.put(llllllllllllllllIIlIIlIIIIlIlIll, "");
        }
    }

    private static String parseType(Matcher llllllllllllllllIIlIIIlllIIIlIIl, String llllllllllllllllIIlIIIlllIIIIllI) {
        return llllllllllllllllIIlIIIlllIIIlIIl.matches() ? llllllllllllllllIIlIIIlllIIIlIIl.group(1) : llllllllllllllllIIlIIIlllIIIIllI;
    }

    public static String parseType(String llllllllllllllllIIlIIIlllIIIllIl) {
        Matcher llllllllllllllllIIlIIIlllIIIlllI = AT_PATTERN.matcher(llllllllllllllllIIlIIIlllIIIllIl);
        return InjectionPointData.parseType(llllllllllllllllIIlIIIlllIIIlllI, llllllllllllllllIIlIIIlllIIIllIl);
    }

    public boolean get(String llllllllllllllllIIlIIIllllIlIIlI, boolean llllllllllllllllIIlIIIllllIlIlIl) {
        InjectionPointData llllllllllllllllIIlIIIllllIlIIll;
        return InjectionPointData.parseBoolean(llllllllllllllllIIlIIIllllIlIIll.get(llllllllllllllllIIlIIIllllIlIIlI, String.valueOf(llllllllllllllllIIlIIIllllIlIlIl)), llllllllllllllllIIlIIIllllIlIlIl);
    }

    public String getSlice() {
        InjectionPointData llllllllllllllllIIlIIlIIIIIIllIl;
        return llllllllllllllllIIlIIlIIIIIIllIl.slice;
    }

    private static int parseInt(String llllllllllllllllIIlIIIllIlllllII, int llllllllllllllllIIlIIIllIllllIll) {
        try {
            return Integer.parseInt(llllllllllllllllIIlIIIllIlllllII);
        }
        catch (Exception llllllllllllllllIIlIIIllIlllllll) {
            return llllllllllllllllIIlIIIllIllllIll;
        }
    }

    private static InjectionPoint.Selector parseSelector(Matcher llllllllllllllllIIlIIIlllIIIIlII) {
        return llllllllllllllllIIlIIIlllIIIIlII.matches() && llllllllllllllllIIlIIIlllIIIIlII.group(2) != null ? InjectionPoint.Selector.valueOf(llllllllllllllllIIlIIIlllIIIIlII.group(2)) : InjectionPoint.Selector.DEFAULT;
    }

    public String getType() {
        InjectionPointData llllllllllllllllIIlIIlIIIIIllllI;
        return llllllllllllllllIIlIIlIIIIIllllI.type;
    }

    public MemberInfo get(String llllllllllllllllIIlIIIllllIIIIIl) {
        InjectionPointData llllllllllllllllIIlIIIllllIIIllI;
        try {
            return MemberInfo.parseAndValidate(llllllllllllllllIIlIIIllllIIIllI.get(llllllllllllllllIIlIIIllllIIIIIl, ""), llllllllllllllllIIlIIIllllIIIllI.context);
        }
        catch (InvalidMemberDescriptorException llllllllllllllllIIlIIIllllIIIlll) {
            throw new InvalidInjectionPointException(llllllllllllllllIIlIIIllllIIIllI.context, "Failed parsing @At(\"%s\").%s descriptor \"%s\" on %s", llllllllllllllllIIlIIIllllIIIllI.at, llllllllllllllllIIlIIIllllIIIIIl, llllllllllllllllIIlIIIllllIIIllI.target, InjectionInfo.describeInjector(llllllllllllllllIIlIIIllllIIIllI.context, llllllllllllllllIIlIIIllllIIIllI.parent, llllllllllllllllIIlIIIllllIIIllI.method));
        }
    }

    public String getAt() {
        InjectionPointData llllllllllllllllIIlIIlIIIIlIIIIl;
        return llllllllllllllllIIlIIlIIIIlIIIIl.at;
    }

    public MemberInfo getTarget() {
        InjectionPointData llllllllllllllllIIlIIIlllIlllIII;
        try {
            return MemberInfo.parseAndValidate(llllllllllllllllIIlIIIlllIlllIII.target, llllllllllllllllIIlIIIlllIlllIII.context);
        }
        catch (InvalidMemberDescriptorException llllllllllllllllIIlIIIlllIlllIIl) {
            throw new InvalidInjectionPointException(llllllllllllllllIIlIIIlllIlllIII.context, "Failed parsing @At(\"%s\") descriptor \"%s\" on %s", llllllllllllllllIIlIIIlllIlllIII.at, llllllllllllllllIIlIIIlllIlllIII.target, InjectionInfo.describeInjector(llllllllllllllllIIlIIIlllIlllIII.context, llllllllllllllllIIlIIIlllIlllIII.parent, llllllllllllllllIIlIIIlllIlllIII.method));
        }
    }

    public LocalVariableDiscriminator getLocalVariableDiscriminator() {
        InjectionPointData llllllllllllllllIIlIIlIIIIIIlIIl;
        return LocalVariableDiscriminator.parse(llllllllllllllllIIlIIlIIIIIIlIIl.parent);
    }

    private static boolean parseBoolean(String llllllllllllllllIIlIIIllIlllIIll, boolean llllllllllllllllIIlIIIllIlllIlII) {
        try {
            return Boolean.parseBoolean(llllllllllllllllIIlIIIllIlllIIll);
        }
        catch (Exception llllllllllllllllIIlIIIllIlllIllI) {
            return llllllllllllllllIIlIIIllIlllIlII;
        }
    }

    public int get(String llllllllllllllllIIlIIIlllllIIIIl, int llllllllllllllllIIlIIIlllllIIlIl) {
        InjectionPointData llllllllllllllllIIlIIIlllllIIIll;
        return InjectionPointData.parseInt(llllllllllllllllIIlIIIlllllIIIll.get(llllllllllllllllIIlIIIlllllIIIIl, String.valueOf(llllllllllllllllIIlIIIlllllIIlIl)), llllllllllllllllIIlIIIlllllIIlIl);
    }

    public AnnotationNode getParent() {
        InjectionPointData llllllllllllllllIIlIIlIIIIIlIIII;
        return llllllllllllllllIIlIIlIIIIIlIIII.parent;
    }

    public int getOpcode() {
        InjectionPointData llllllllllllllllIIlIIIlllIllIIII;
        return llllllllllllllllIIlIIIlllIllIIII.opcode;
    }

    private static Pattern createPattern() {
        return Pattern.compile(String.format("^([^:]+):?(%s)?$", Joiner.on((char)'|').join((Object[])InjectionPoint.Selector.values())));
    }

    public int getOpcode(int llllllllllllllllIIlIIIlllIlIllII) {
        InjectionPointData llllllllllllllllIIlIIIlllIlIllIl;
        return llllllllllllllllIIlIIIlllIlIllIl.opcode > 0 ? llllllllllllllllIIlIIIlllIlIllIl.opcode : llllllllllllllllIIlIIIlllIlIllII;
    }

    public IMixinContext getContext() {
        InjectionPointData llllllllllllllllIIlIIlIIIIIllIII;
        return llllllllllllllllIIlIIlIIIIIllIII.context;
    }

    public Type getMethodReturnType() {
        InjectionPointData llllllllllllllllIIlIIlIIIIIlIIll;
        return Type.getReturnType(llllllllllllllllIIlIIlIIIIIlIIll.method.desc);
    }

    static {
        AT_PATTERN = InjectionPointData.createPattern();
    }

    public InjectionPointData(IMixinContext llllllllllllllllIIlIIlIIIlIIlIIl, MethodNode llllllllllllllllIIlIIlIIIlIllIIl, AnnotationNode llllllllllllllllIIlIIlIIIlIIIlll, String llllllllllllllllIIlIIlIIIlIIIllI, List<String> llllllllllllllllIIlIIlIIIlIlIIll, String llllllllllllllllIIlIIlIIIlIIIlII, String llllllllllllllllIIlIIlIIIlIIIIll, int llllllllllllllllIIlIIlIIIlIIlllI, int llllllllllllllllIIlIIlIIIlIIIIIl, String llllllllllllllllIIlIIlIIIlIIllII) {
        InjectionPointData llllllllllllllllIIlIIlIIIlIlllIl;
        llllllllllllllllIIlIIlIIIlIlllIl.args = new HashMap<String, String>();
        llllllllllllllllIIlIIlIIIlIlllIl.context = llllllllllllllllIIlIIlIIIlIIlIIl;
        llllllllllllllllIIlIIlIIIlIlllIl.method = llllllllllllllllIIlIIlIIIlIllIIl;
        llllllllllllllllIIlIIlIIIlIlllIl.parent = llllllllllllllllIIlIIlIIIlIIIlll;
        llllllllllllllllIIlIIlIIIlIlllIl.at = llllllllllllllllIIlIIlIIIlIIIllI;
        llllllllllllllllIIlIIlIIIlIlllIl.target = llllllllllllllllIIlIIlIIIlIIIlII;
        llllllllllllllllIIlIIlIIIlIlllIl.slice = Strings.nullToEmpty((String)llllllllllllllllIIlIIlIIIlIIIIll);
        llllllllllllllllIIlIIlIIIlIlllIl.ordinal = Math.max(-1, llllllllllllllllIIlIIlIIIlIIlllI);
        llllllllllllllllIIlIIlIIIlIlllIl.opcode = llllllllllllllllIIlIIlIIIlIIIIIl;
        llllllllllllllllIIlIIlIIIlIlllIl.id = llllllllllllllllIIlIIlIIIlIIllII;
        llllllllllllllllIIlIIlIIIlIlllIl.parseArgs(llllllllllllllllIIlIIlIIIlIlIIll);
        llllllllllllllllIIlIIlIIIlIlllIl.args.put("target", llllllllllllllllIIlIIlIIIlIIIlII);
        llllllllllllllllIIlIIlIIIlIlllIl.args.put("ordinal", String.valueOf(llllllllllllllllIIlIIlIIIlIIlllI));
        llllllllllllllllIIlIIlIIIlIlllIl.args.put("opcode", String.valueOf(llllllllllllllllIIlIIlIIIlIIIIIl));
        Matcher llllllllllllllllIIlIIlIIIlIIlIll = AT_PATTERN.matcher(llllllllllllllllIIlIIlIIIlIIIllI);
        llllllllllllllllIIlIIlIIIlIlllIl.type = InjectionPointData.parseType(llllllllllllllllIIlIIlIIIlIIlIll, llllllllllllllllIIlIIlIIIlIIIllI);
        llllllllllllllllIIlIIlIIIlIlllIl.selector = InjectionPointData.parseSelector(llllllllllllllllIIlIIlIIIlIIlIll);
    }

    public String get(String llllllllllllllllIIlIIIllllllIlll, String llllllllllllllllIIlIIIllllllIIlI) {
        InjectionPointData llllllllllllllllIIlIIIlllllllIIl;
        String llllllllllllllllIIlIIIlllllllIll = llllllllllllllllIIlIIIlllllllIIl.args.get(llllllllllllllllIIlIIIllllllIlll);
        return llllllllllllllllIIlIIIlllllllIll != null ? llllllllllllllllIIlIIIlllllllIll : llllllllllllllllIIlIIIllllllIIlI;
    }

    public InjectionPoint.Selector getSelector() {
        InjectionPointData llllllllllllllllIIlIIlIIIIIlllII;
        return llllllllllllllllIIlIIlIIIIIlllII.selector;
    }

    public String toString() {
        InjectionPointData llllllllllllllllIIlIIIlllIIlIIlI;
        return llllllllllllllllIIlIIIlllIIlIIlI.type;
    }

    public MethodNode getMethod() {
        InjectionPointData llllllllllllllllIIlIIlIIIIIlIllI;
        return llllllllllllllllIIlIIlIIIIIlIllI.method;
    }

    public String getId() {
        InjectionPointData llllllllllllllllIIlIIIlllIIlIlIl;
        return llllllllllllllllIIlIIIlllIIlIlIl.id;
    }

    public int getOrdinal() {
        InjectionPointData llllllllllllllllIIlIIIlllIllIlII;
        return llllllllllllllllIIlIIIlllIllIlII.ordinal;
    }
}

