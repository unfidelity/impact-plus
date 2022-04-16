/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer;

import java.io.OutputStream;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.struct.SourceMap;
import org.spongepowered.asm.mixin.transformer.ClassContext;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.MixinApplicatorInterface;
import org.spongepowered.asm.mixin.transformer.MixinApplicatorStandard;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;
import org.spongepowered.asm.mixin.transformer.ext.ITargetClassContext;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.ClassSignature;

class TargetClassContext
extends ClassContext
implements ITargetClassContext {
    private final /* synthetic */ String sessionId;
    private final /* synthetic */ SortedSet<MixinInfo> mixins;
    private final /* synthetic */ ClassInfo classInfo;
    private /* synthetic */ int nextUniqueFieldIndex;
    private final /* synthetic */ MixinEnvironment env;
    private final /* synthetic */ ClassSignature signature;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ Extensions extensions;
    private final /* synthetic */ SourceMap sourceMap;
    private final /* synthetic */ String className;
    private final /* synthetic */ ClassNode classNode;
    private final /* synthetic */ Set<MethodNode> mixinMethods;
    private /* synthetic */ boolean applied;
    private /* synthetic */ int nextUniqueMethodIndex;
    private /* synthetic */ boolean forceExport;
    private final /* synthetic */ Map<String, Target> targetMethods;

    @Override
    String getClassRef() {
        TargetClassContext llIlIIlllIIIIIl;
        return llIlIIlllIIIIIl.classNode.name;
    }

    boolean isApplied() {
        TargetClassContext llIlIIlllIIlllI;
        return llIlIIlllIIlllI.applied;
    }

    @Override
    public ClassNode getClassNode() {
        TargetClassContext llIlIIllIllllII;
        return llIlIIllIllllII.classNode;
    }

    void applyMixins() {
        TargetClassContext llIlIIlIIlllIIl;
        if (llIlIIlIIlllIIl.applied) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Mixins already applied to target class ").append(llIlIIlIIlllIIl.className)));
        }
        llIlIIlIIlllIIl.applied = true;
        MixinApplicatorStandard llIlIIlIIlllIlI = llIlIIlIIlllIIl.createApplicator();
        llIlIIlIIlllIlI.apply(llIlIIlIIlllIIl.mixins);
        llIlIIlIIlllIIl.applySignature();
        llIlIIlIIlllIIl.upgradeMethods();
        llIlIIlIIlllIIl.checkMerges();
    }

    private void checkMerges() {
        TargetClassContext llIlIIlIIlIllII;
        for (MethodNode llIlIIlIIlIlllI : llIlIIlIIlIllII.mixinMethods) {
            if (llIlIIlIIlIlllI.name.startsWith("<")) continue;
            logger.debug("Unexpected: Registered method {}{} in {} was not merged", new Object[]{llIlIIlIIlIlllI.name, llIlIIlIIlIlllI.desc, llIlIIlIIlIllII});
        }
    }

    String getUniqueName(FieldNode llIlIIlIIllllll) {
        TargetClassContext llIlIIlIlIIIIll;
        String llIlIIlIlIIIIIl = Integer.toHexString(llIlIIlIlIIIIll.nextUniqueFieldIndex++);
        return String.format("fd%s$%s$%s", llIlIIlIlIIIIll.sessionId.substring(30), llIlIIlIIllllll.name, llIlIIlIlIIIIIl);
    }

    SourceMap getSourceMap() {
        TargetClassContext llIlIIllIlIllII;
        return llIlIIllIlIllII.sourceMap;
    }

    List<FieldNode> getFields() {
        TargetClassContext llIlIIllIllIllI;
        return llIlIIllIllIllI.classNode.fields;
    }

    MethodNode findAliasedMethod(Deque<String> llIlIIllIIIllII, String llIlIIllIIIlIll) {
        TargetClassContext llIlIIllIIIlIlI;
        return llIlIIllIIIlIlI.findAliasedMethod(llIlIIllIIIllII, llIlIIllIIIlIll, false);
    }

    private void applySignature() {
        TargetClassContext llIlIIlIIllIIll;
        llIlIIlIIllIIll.getClassNode().signature = llIlIIlIIllIIll.signature.toString();
    }

    void addMixinMethod(MethodNode llIlIIllIlIIIII) {
        TargetClassContext llIlIIllIlIIIll;
        llIlIIllIlIIIll.mixinMethods.add(llIlIIllIlIIIII);
    }

    FieldNode findAliasedField(Deque<String> llIlIIlIllIIllI, String llIlIIlIllIlIIl) {
        TargetClassContext llIlIIlIllIIlll;
        String llIlIIlIllIlIII = llIlIIlIllIIllI.poll();
        if (llIlIIlIllIlIII == null) {
            return null;
        }
        for (FieldNode llIlIIlIllIllII : llIlIIlIllIIlll.classNode.fields) {
            if (!llIlIIlIllIllII.name.equals(llIlIIlIllIlIII) || !llIlIIlIllIllII.desc.equals(llIlIIlIllIlIIl)) continue;
            return llIlIIlIllIllII;
        }
        return llIlIIlIllIIlll.findAliasedField(llIlIIlIllIIllI, llIlIIlIllIlIIl);
    }

    String getSessionId() {
        TargetClassContext llIlIIlllIIIlII;
        return llIlIIlllIIIlII.sessionId;
    }

    String getClassName() {
        TargetClassContext llIlIIllIlllllI;
        return llIlIIllIlllllI.className;
    }

    public String toString() {
        TargetClassContext llIlIIlllIlIIII;
        return llIlIIlllIlIIII.className;
    }

    @Override
    public ClassInfo getClassInfo() {
        TargetClassContext llIlIIllIllIIll;
        return llIlIIllIllIIll.classInfo;
    }

    void processDebugTasks() {
        TargetClassContext llIlIIlIIlIIIlI;
        if (!llIlIIlIIlIIIlI.env.getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
            return;
        }
        AnnotationNode llIlIIlIIlIIIIl = Annotations.getVisible(llIlIIlIIlIIIlI.classNode, Debug.class);
        if (llIlIIlIIlIIIIl != null) {
            llIlIIlIIlIIIlI.forceExport = Boolean.TRUE.equals(Annotations.getValue(llIlIIlIIlIIIIl, "export"));
            if (Boolean.TRUE.equals(Annotations.getValue(llIlIIlIIlIIIIl, "print"))) {
                Bytecode.textify(llIlIIlIIlIIIlI.classNode, (OutputStream)System.err);
            }
        }
        for (MethodNode llIlIIlIIlIIIll : llIlIIlIIlIIIlI.classNode.methods) {
            AnnotationNode llIlIIlIIlIIlII = Annotations.getVisible(llIlIIlIIlIIIll, Debug.class);
            if (llIlIIlIIlIIlII == null || !Boolean.TRUE.equals(Annotations.getValue(llIlIIlIIlIIlII, "print"))) continue;
            Bytecode.textify(llIlIIlIIlIIIll, (OutputStream)System.err);
        }
    }

    void methodMerged(MethodNode llIlIIllIIlllII) {
        TargetClassContext llIlIIllIIlllIl;
        if (!llIlIIllIIlllIl.mixinMethods.remove(llIlIIllIIlllII)) {
            logger.debug("Unexpected: Merged unregistered method {}{} in {}", new Object[]{llIlIIllIIlllII.name, llIlIIllIIlllII.desc, llIlIIllIIlllIl});
        }
    }

    static {
        logger = LogManager.getLogger((String)"mixin");
    }

    void mergeSignature(ClassSignature llIlIIllIlIIllI) {
        TargetClassContext llIlIIllIlIlIIl;
        llIlIIllIlIlIIl.signature.merge(llIlIIllIlIIllI);
    }

    private MethodNode findAliasedMethod(Deque<String> llIlIIlIllllIII, String llIlIIlIlllllII, boolean llIlIIlIllllIll) {
        TargetClassContext llIlIIlIllllIIl;
        String llIlIIlIllllIlI = llIlIIlIllllIII.poll();
        if (llIlIIlIllllIlI == null) {
            return null;
        }
        for (MethodNode llIlIIllIIIIIII : llIlIIlIllllIIl.classNode.methods) {
            if (!llIlIIllIIIIIII.name.equals(llIlIIlIllllIlI) || !llIlIIllIIIIIII.desc.equals(llIlIIlIlllllII)) continue;
            return llIlIIllIIIIIII;
        }
        if (llIlIIlIllllIll) {
            for (MethodNode llIlIIlIlllllll : llIlIIlIllllIIl.mixinMethods) {
                if (!llIlIIlIlllllll.name.equals(llIlIIlIllllIlI) || !llIlIIlIlllllll.desc.equals(llIlIIlIlllllII)) continue;
                return llIlIIlIlllllll;
            }
        }
        return llIlIIlIllllIIl.findAliasedMethod(llIlIIlIllllIII, llIlIIlIlllllII);
    }

    Extensions getExtensions() {
        TargetClassContext llIlIIlllIIlIII;
        return llIlIIlllIIlIII.extensions;
    }

    TargetClassContext(MixinEnvironment llIlIIlllIllIII, Extensions llIlIIlllIllllI, String llIlIIlllIlIllI, String llIlIIlllIlllII, ClassNode llIlIIlllIlIlII, SortedSet<MixinInfo> llIlIIlllIlIIll) {
        TargetClassContext llIlIIlllIllIIl;
        llIlIIlllIllIIl.targetMethods = new HashMap<String, Target>();
        llIlIIlllIllIIl.mixinMethods = new HashSet<MethodNode>();
        llIlIIlllIllIIl.env = llIlIIlllIllIII;
        llIlIIlllIllIIl.extensions = llIlIIlllIllllI;
        llIlIIlllIllIIl.sessionId = llIlIIlllIlIllI;
        llIlIIlllIllIIl.className = llIlIIlllIlllII;
        llIlIIlllIllIIl.classNode = llIlIIlllIlIlII;
        llIlIIlllIllIIl.classInfo = ClassInfo.fromClassNode(llIlIIlllIlIlII);
        llIlIIlllIllIIl.signature = llIlIIlllIllIIl.classInfo.getSignature();
        llIlIIlllIllIIl.mixins = llIlIIlllIlIIll;
        llIlIIlllIllIIl.sourceMap = new SourceMap(llIlIIlllIlIlII.sourceFile);
        llIlIIlllIllIIl.sourceMap.addFile(llIlIIlllIllIIl.classNode);
    }

    List<MethodNode> getMethods() {
        TargetClassContext llIlIIllIlllIIl;
        return llIlIIllIlllIIl.classNode.methods;
    }

    private MixinApplicatorStandard createApplicator() {
        TargetClassContext llIlIIlIIllIlIl;
        if (llIlIIlIIllIlIl.classInfo.isInterface()) {
            return new MixinApplicatorInterface(llIlIIlIIllIlIl);
        }
        return new MixinApplicatorStandard(llIlIIlIIllIlIl);
    }

    Target getTargetMethod(MethodNode llIlIIlIlIllIII) {
        TargetClassContext llIlIIlIlIlllIl;
        if (!llIlIIlIlIlllIl.classNode.methods.contains(llIlIIlIlIllIII)) {
            throw new IllegalArgumentException("Invalid target method supplied to getTargetMethod()");
        }
        String llIlIIlIlIllIll = String.valueOf(new StringBuilder().append(llIlIIlIlIllIII.name).append(llIlIIlIlIllIII.desc));
        Target llIlIIlIlIllIlI = llIlIIlIlIlllIl.targetMethods.get(llIlIIlIlIllIll);
        if (llIlIIlIlIllIlI == null) {
            llIlIIlIlIllIlI = new Target(llIlIIlIlIlllIl.classNode, llIlIIlIlIllIII);
            llIlIIlIlIlllIl.targetMethods.put(llIlIIlIlIllIll, llIlIIlIlIllIlI);
        }
        return llIlIIlIlIllIlI;
    }

    MethodNode findMethod(Deque<String> llIlIIllIIlIlIl, String llIlIIllIIlIlII) {
        TargetClassContext llIlIIllIIlIIll;
        return llIlIIllIIlIIll.findAliasedMethod(llIlIIllIIlIlIl, llIlIIllIIlIlII, true);
    }

    String getUniqueName(MethodNode llIlIIlIlIIlIlI, boolean llIlIIlIlIIlllI) {
        TargetClassContext llIlIIlIlIlIIII;
        String llIlIIlIlIIllIl = Integer.toHexString(llIlIIlIlIlIIII.nextUniqueMethodIndex++);
        String llIlIIlIlIIllII = llIlIIlIlIIlllI ? "%2$s_$md$%1$s$%3$s" : "md%s$%s$%s";
        return String.format(llIlIIlIlIIllII, llIlIIlIlIlIIII.sessionId.substring(30), llIlIIlIlIIlIlI.name, llIlIIlIlIIllIl);
    }

    SortedSet<MixinInfo> getMixins() {
        TargetClassContext llIlIIllIlIllll;
        return llIlIIllIlIllll.mixins;
    }

    boolean isExportForced() {
        TargetClassContext llIlIIlllIIlIll;
        return llIlIIlllIIlIll.forceExport;
    }
}

