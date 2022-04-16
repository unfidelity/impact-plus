/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.BiMap
 *  com.google.common.collect.HashBiMap
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.InvokeDynamicInsnNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.SoftOverride;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.gen.AccessorInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectorGroupInfo;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InjectionError;
import org.spongepowered.asm.mixin.injection.throwables.InjectionValidationException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.refmap.IReferenceMapper;
import org.spongepowered.asm.mixin.struct.MemberRef;
import org.spongepowered.asm.mixin.struct.SourceMap;
import org.spongepowered.asm.mixin.transformer.ClassContext;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.InnerClassGenerator;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.TargetClassContext;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;
import org.spongepowered.asm.mixin.transformer.meta.MixinMerged;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.mixin.transformer.throwables.MixinTransformerError;
import org.spongepowered.asm.obfuscation.RemapperChain;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.ClassSignature;

public class MixinTargetContext
extends ClassContext
implements IMixinContext {
    private final /* synthetic */ String sessionId;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ Map<FieldNode, ClassInfo.Field> shadowFields;
    private final /* synthetic */ List<AccessorInfo> accessors;
    private final /* synthetic */ SourceMap.File stratum;
    private final /* synthetic */ TargetClassContext targetClass;
    private final /* synthetic */ ClassNode classNode;
    private final /* synthetic */ boolean inheritsFromMixin;
    private final /* synthetic */ List<MethodNode> mergedMethods;
    private final /* synthetic */ List<InjectionInfo> injectors;
    private final /* synthetic */ ClassInfo targetClassInfo;
    private final /* synthetic */ boolean detachedSuper;
    private /* synthetic */ int minRequiredClassVersion;
    private final /* synthetic */ MixinInfo mixin;
    private final /* synthetic */ InjectorGroupInfo.Map injectorGroups;
    private final /* synthetic */ BiMap<String, String> innerClasses;
    private final /* synthetic */ List<MethodNode> shadowMethods;

    public int getDefaultRequiredInjections() {
        MixinTargetContext lllllllllllllllIllllIIlIllIlIlIl;
        return lllllllllllllllIllllIIlIllIlIlIl.mixin.getParent().getDefaultRequiredInjections();
    }

    @Override
    protected ClassInfo getClassInfo() {
        MixinTargetContext lllllllllllllllIllllIIlIlllIIIIl;
        return lllllllllllllllIllllIIlIlllIIIIl.mixin.getClassInfo();
    }

    private void transformMethodRef(MethodNode lllllllllllllllIllllIIlIlIIlIlIl, Iterator<AbstractInsnNode> lllllllllllllllIllllIIlIlIIlIlII, MemberRef lllllllllllllllIllllIIlIlIIlIIll) {
        MixinTargetContext lllllllllllllllIllllIIlIlIIlIllI;
        lllllllllllllllIllllIIlIlIIlIllI.transformDescriptor(lllllllllllllllIllllIIlIlIIlIIll);
        if (lllllllllllllllIllllIIlIlIIlIIll.getOwner().equals(lllllllllllllllIllllIIlIlIIlIllI.getClassRef())) {
            lllllllllllllllIllllIIlIlIIlIIll.setOwner(lllllllllllllllIllllIIlIlIIlIllI.getTarget().getClassRef());
            ClassInfo.Method lllllllllllllllIllllIIlIlIIlIlll = lllllllllllllllIllllIIlIlIIlIllI.getClassInfo().findMethod(lllllllllllllllIllllIIlIlIIlIIll.getName(), lllllllllllllllIllllIIlIlIIlIIll.getDesc(), 10);
            if (lllllllllllllllIllllIIlIlIIlIlll != null && lllllllllllllllIllllIIlIlIIlIlll.isRenamed() && lllllllllllllllIllllIIlIlIIlIlll.getOriginalName().equals(lllllllllllllllIllllIIlIlIIlIIll.getName()) && lllllllllllllllIllllIIlIlIIlIlll.isSynthetic()) {
                lllllllllllllllIllllIIlIlIIlIIll.setName(lllllllllllllllIllllIIlIlIIlIlll.getName());
            }
            lllllllllllllllIllllIIlIlIIlIllI.upgradeMethodRef(lllllllllllllllIllllIIlIlIIlIlIl, lllllllllllllllIllllIIlIlIIlIIll, lllllllllllllllIllllIIlIlIIlIlll);
        } else if (lllllllllllllllIllllIIlIlIIlIllI.innerClasses.containsKey((Object)lllllllllllllllIllllIIlIlIIlIIll.getOwner())) {
            lllllllllllllllIllllIIlIlIIlIIll.setOwner((String)lllllllllllllllIllllIIlIlIIlIllI.innerClasses.get((Object)lllllllllllllllIllllIIlIlIIlIIll.getOwner()));
            lllllllllllllllIllllIIlIlIIlIIll.setDesc(lllllllllllllllIllllIIlIlIIlIllI.transformMethodDescriptor(lllllllllllllllIllllIIlIlIIlIIll.getDesc()));
        } else if (lllllllllllllllIllllIIlIlIIlIllI.detachedSuper || lllllllllllllllIllllIIlIlIIlIllI.inheritsFromMixin) {
            if (lllllllllllllllIllllIIlIlIIlIIll.getOpcode() == 183) {
                lllllllllllllllIllllIIlIlIIlIllI.updateStaticBinding(lllllllllllllllIllllIIlIlIIlIlIl, lllllllllllllllIllllIIlIlIIlIIll);
            } else if (lllllllllllllllIllllIIlIlIIlIIll.getOpcode() == 182 && ClassInfo.forName(lllllllllllllllIllllIIlIlIIlIIll.getOwner()).isMixin()) {
                lllllllllllllllIllllIIlIlIIlIllI.updateDynamicBinding(lllllllllllllllIllllIIlIlIIlIlIl, lllllllllllllllIllllIIlIlIIlIIll);
            }
        }
    }

    void addShadowField(FieldNode lllllllllllllllIllllIIllIIllIIlI, ClassInfo.Field lllllllllllllllIllllIIllIIllIIII) {
        MixinTargetContext lllllllllllllllIllllIIllIIllIlII;
        lllllllllllllllIllllIIllIIllIlII.shadowFields.put(lllllllllllllllIllllIIllIIllIIlI, lllllllllllllllIllllIIllIIllIIII);
    }

    public void transformDescriptor(MethodNode lllllllllllllllIllllIIIllIllllll) {
        MixinTargetContext lllllllllllllllIllllIIIlllIIIIlI;
        if (!lllllllllllllllIllllIIIlllIIIIlI.inheritsFromMixin && lllllllllllllllIllllIIIlllIIIIlI.innerClasses.size() == 0) {
            return;
        }
        lllllllllllllllIllllIIIllIllllll.desc = lllllllllllllllIllllIIIlllIIIIlI.transformMethodDescriptor(lllllllllllllllIllllIIIllIllllll.desc);
    }

    @Override
    public Extensions getExtensions() {
        MixinTargetContext lllllllllllllllIllllIIIlIIIIlIII;
        return lllllllllllllllIllllIIIlIIIIlIII.targetClass.getExtensions();
    }

    public ClassNode getTargetClassNode() {
        MixinTargetContext lllllllllllllllIllllIIlIlllIIlll;
        return lllllllllllllllIllllIIlIlllIIlll.getTarget().getClassNode();
    }

    @Override
    public IReferenceMapper getReferenceMapper() {
        MixinTargetContext lllllllllllllllIllllIIIIllIIlIII;
        return lllllllllllllllIllllIIIIllIIlIII.mixin.getParent().getReferenceMapper();
    }

    public boolean requireOverwriteAnnotations() {
        MixinTargetContext lllllllllllllllIllllIIlIllIIlIII;
        return lllllllllllllllIllllIIlIllIIlIII.mixin.getParent().requireOverwriteAnnotations();
    }

    FieldNode findField(FieldNode lllllllllllllllIllllIIIlIIllllII, AnnotationNode lllllllllllllllIllllIIIlIIlllIll) {
        MixinTargetContext lllllllllllllllIllllIIIlIIlllllI;
        List lllllllllllllllIllllIIIlIlIIIIII;
        LinkedList<String> lllllllllllllllIllllIIIlIIlllIlI = new LinkedList<String>();
        lllllllllllllllIllllIIIlIIlllIlI.add(lllllllllllllllIllllIIIlIIllllII.name);
        if (lllllllllllllllIllllIIIlIIlllIll != null && (lllllllllllllllIllllIIIlIlIIIIII = (List)Annotations.getValue(lllllllllllllllIllllIIIlIIlllIll, "aliases")) != null) {
            lllllllllllllllIllllIIIlIIlllIlI.addAll(lllllllllllllllIllllIIIlIlIIIIII);
        }
        return lllllllllllllllIllllIIIlIIlllllI.getTarget().findAliasedField(lllllllllllllllIllllIIIlIIlllIlI, lllllllllllllllIllllIIIlIIllllII.desc);
    }

    public MixinEnvironment getEnvironment() {
        MixinTargetContext lllllllllllllllIllllIIllIIIIIIll;
        return lllllllllllllllIllllIIllIIIIIIll.mixin.getParent().getEnvironment();
    }

    private void processImaginarySuper(MethodNode lllllllllllllllIllllIIlIIIIIIIIl, FieldInsnNode lllllllllllllllIllllIIlIIIIIIIll) {
        MixinTargetContext lllllllllllllllIllllIIlIIIIIIllI;
        if (lllllllllllllllIllllIIlIIIIIIIll.getOpcode() != 180) {
            if ("<init>".equals(lllllllllllllllIllllIIlIIIIIIIIl.name)) {
                throw new InvalidMixinException((IMixinContext)lllllllllllllllIllllIIlIIIIIIllI, String.valueOf(new StringBuilder().append("Illegal imaginary super declaration: field ").append(lllllllllllllllIllllIIlIIIIIIIll.name).append(" must not specify an initialiser")));
            }
            throw new InvalidMixinException((IMixinContext)lllllllllllllllIllllIIlIIIIIIllI, String.valueOf(new StringBuilder().append("Illegal imaginary super access: found ").append(Bytecode.getOpcodeName(lllllllllllllllIllllIIlIIIIIIIll.getOpcode())).append(" opcode in ").append(lllllllllllllllIllllIIlIIIIIIIIl.name).append(lllllllllllllllIllllIIlIIIIIIIIl.desc)));
        }
        if ((lllllllllllllllIllllIIlIIIIIIIIl.access & 2) != 0 || (lllllllllllllllIllllIIlIIIIIIIIl.access & 8) != 0) {
            throw new InvalidMixinException((IMixinContext)lllllllllllllllIllllIIlIIIIIIllI, String.valueOf(new StringBuilder().append("Illegal imaginary super access: method ").append(lllllllllllllllIllllIIlIIIIIIIIl.name).append(lllllllllllllllIllllIIlIIIIIIIIl.desc).append(" is private or static")));
        }
        if (Annotations.getInvisible(lllllllllllllllIllllIIlIIIIIIIIl, SoftOverride.class) == null) {
            throw new InvalidMixinException((IMixinContext)lllllllllllllllIllllIIlIIIIIIllI, String.valueOf(new StringBuilder().append("Illegal imaginary super access: method ").append(lllllllllllllllIllllIIlIIIIIIIIl.name).append(lllllllllllllllIllllIIlIIIIIIIIl.desc).append(" is not decorated with @SoftOverride")));
        }
        ListIterator<AbstractInsnNode> lllllllllllllllIllllIIlIIIIIIlll = lllllllllllllllIllllIIlIIIIIIIIl.instructions.iterator(lllllllllllllllIllllIIlIIIIIIIIl.instructions.indexOf(lllllllllllllllIllllIIlIIIIIIIll));
        while (lllllllllllllllIllllIIlIIIIIIlll.hasNext()) {
            AbstractInsnNode lllllllllllllllIllllIIlIIIIIlIII = (AbstractInsnNode)lllllllllllllllIllllIIlIIIIIIlll.next();
            if (!(lllllllllllllllIllllIIlIIIIIlIII instanceof MethodInsnNode)) continue;
            MethodInsnNode lllllllllllllllIllllIIlIIIIIlIlI = (MethodInsnNode)lllllllllllllllIllllIIlIIIIIlIII;
            if (!lllllllllllllllIllllIIlIIIIIlIlI.owner.equals(lllllllllllllllIllllIIlIIIIIIllI.getClassRef()) || !lllllllllllllllIllllIIlIIIIIlIlI.name.equals(lllllllllllllllIllllIIlIIIIIIIIl.name) || !lllllllllllllllIllllIIlIIIIIlIlI.desc.equals(lllllllllllllllIllllIIlIIIIIIIIl.desc)) continue;
            lllllllllllllllIllllIIlIIIIIlIlI.setOpcode(183);
            lllllllllllllllIllllIIlIIIIIIllI.updateStaticBinding(lllllllllllllllIllllIIlIIIIIIIIl, new MemberRef.Method(lllllllllllllllIllllIIlIIIIIlIlI));
            return;
        }
        throw new InvalidMixinException((IMixinContext)lllllllllllllllIllllIIlIIIIIIllI, String.valueOf(new StringBuilder().append("Illegal imaginary super access: could not find INVOKE for ").append(lllllllllllllllIllllIIlIIIIIIIIl.name).append(lllllllllllllllIllllIIlIIIIIIIIl.desc)));
    }

    public String getUniqueName(MethodNode lllllllllllllllIllllIIIIlIIIlIIl, boolean lllllllllllllllIllllIIIIlIIIlIII) {
        MixinTargetContext lllllllllllllllIllllIIIIlIIIlIll;
        return lllllllllllllllIllllIIIIlIIIlIll.getTarget().getUniqueName(lllllllllllllllIllllIIIIlIIIlIIl, lllllllllllllllIllllIIIIlIIIlIII);
    }

    MethodNode findMethod(MethodNode lllllllllllllllIllllIIIlIllIlIlI, AnnotationNode lllllllllllllllIllllIIIlIllIllIl) {
        MixinTargetContext lllllllllllllllIllllIIIlIllIllll;
        List lllllllllllllllIllllIIIlIlllIIII;
        LinkedList<String> lllllllllllllllIllllIIIlIllIllII = new LinkedList<String>();
        lllllllllllllllIllllIIIlIllIllII.add(lllllllllllllllIllllIIIlIllIlIlI.name);
        if (lllllllllllllllIllllIIIlIllIllIl != null && (lllllllllllllllIllllIIIlIlllIIII = (List)Annotations.getValue(lllllllllllllllIllllIIIlIllIllIl, "aliases")) != null) {
            lllllllllllllllIllllIIIlIllIllII.addAll(lllllllllllllllIllllIIIlIlllIIII);
        }
        return lllllllllllllllIllllIIIlIllIllll.getTarget().findMethod(lllllllllllllllIllllIIIlIllIllII, lllllllllllllllIllllIIIlIllIlIlI.desc);
    }

    public void transformDescriptor(TypeInsnNode lllllllllllllllIllllIIIllIllIlIl) {
        MixinTargetContext lllllllllllllllIllllIIIllIllIllI;
        if (!lllllllllllllllIllllIIIllIllIllI.inheritsFromMixin && lllllllllllllllIllllIIIllIllIllI.innerClasses.size() == 0) {
            return;
        }
        lllllllllllllllIllllIIIllIllIlIl.desc = lllllllllllllllIllllIIIllIllIllI.transformSingleDescriptor(lllllllllllllllIllllIIIllIllIlIl.desc, true);
    }

    private void checkFinal(MethodNode lllllllllllllllIllllIIlIIllIlIlI, Iterator<AbstractInsnNode> lllllllllllllllIllllIIlIIllIlllI, FieldInsnNode lllllllllllllllIllllIIlIIllIlIIl) {
        MixinTargetContext lllllllllllllllIllllIIlIIllIlIll;
        if (!lllllllllllllllIllllIIlIIllIlIIl.owner.equals(lllllllllllllllIllllIIlIIllIlIll.getTarget().getClassRef())) {
            return;
        }
        int lllllllllllllllIllllIIlIIllIllII = lllllllllllllllIllllIIlIIllIlIIl.getOpcode();
        if (lllllllllllllllIllllIIlIIllIllII == 180 || lllllllllllllllIllllIIlIIllIllII == 178) {
            return;
        }
        for (Map.Entry<FieldNode, ClassInfo.Field> lllllllllllllllIllllIIlIIlllIIIl : lllllllllllllllIllllIIlIIllIlIll.shadowFields.entrySet()) {
            FieldNode lllllllllllllllIllllIIlIIlllIIll = lllllllllllllllIllllIIlIIlllIIIl.getKey();
            if (!lllllllllllllllIllllIIlIIlllIIll.desc.equals(lllllllllllllllIllllIIlIIllIlIIl.desc) || !lllllllllllllllIllllIIlIIlllIIll.name.equals(lllllllllllllllIllllIIlIIllIlIIl.name)) continue;
            ClassInfo.Field lllllllllllllllIllllIIlIIlllIIlI = lllllllllllllllIllllIIlIIlllIIIl.getValue();
            if (lllllllllllllllIllllIIlIIlllIIlI.isDecoratedFinal()) {
                if (lllllllllllllllIllllIIlIIlllIIlI.isDecoratedMutable()) {
                    if (lllllllllllllllIllllIIlIIllIlIll.mixin.getParent().getEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
                        logger.warn("Write access to @Mutable @Final field {} in {}::{}", new Object[]{lllllllllllllllIllllIIlIIlllIIlI, lllllllllllllllIllllIIlIIllIlIll.mixin, lllllllllllllllIllllIIlIIllIlIlI.name});
                    }
                } else if ("<init>".equals(lllllllllllllllIllllIIlIIllIlIlI.name) || "<clinit>".equals(lllllllllllllllIllllIIlIIllIlIlI.name)) {
                    logger.warn("@Final field {} in {} should be final", new Object[]{lllllllllllllllIllllIIlIIlllIIlI, lllllllllllllllIllllIIlIIllIlIll.mixin});
                } else {
                    logger.error("Write access detected to @Final field {} in {}::{}", new Object[]{lllllllllllllllIllllIIlIIlllIIlI, lllllllllllllllIllllIIlIIllIlIll.mixin, lllllllllllllllIllllIIlIIllIlIlI.name});
                    if (lllllllllllllllIllllIIlIIllIlIll.mixin.getParent().getEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERIFY)) {
                        throw new InvalidMixinException((IMixinInfo)lllllllllllllllIllllIIlIIllIlIll.mixin, String.valueOf(new StringBuilder().append("Write access detected to @Final field ").append(lllllllllllllllIllllIIlIIlllIIlI).append(" in ").append(lllllllllllllllIllllIIlIIllIlIll.mixin).append("::").append(lllllllllllllllIllllIIlIIllIlIlI.name)));
                    }
                }
            }
            return;
        }
    }

    private void updateStaticBinding(MethodNode lllllllllllllllIllllIIIlllllIlII, MemberRef lllllllllllllllIllllIIIlllllIlll) {
        MixinTargetContext lllllllllllllllIllllIIIlllllIllI;
        lllllllllllllllIllllIIIlllllIllI.updateBinding(lllllllllllllllIllllIIIlllllIlII, lllllllllllllllIllllIIIlllllIlll, ClassInfo.Traversal.SUPER);
    }

    @Override
    public ClassNode getClassNode() {
        MixinTargetContext lllllllllllllllIllllIIlIllllIlIl;
        return lllllllllllllllIllllIIlIllllIlIl.classNode;
    }

    public String getClassName() {
        MixinTargetContext lllllllllllllllIllllIIlIllllIIlI;
        return lllllllllllllllIllllIIlIllllIIlI.mixin.getClassName();
    }

    private String transformMethodDescriptor(String lllllllllllllllIllllIIIllIIIIlII) {
        MixinTargetContext lllllllllllllllIllllIIIllIIIIIlI;
        StringBuilder lllllllllllllllIllllIIIllIIIIIll = new StringBuilder();
        lllllllllllllllIllllIIIllIIIIIll.append('(');
        for (Type lllllllllllllllIllllIIIllIIIIllI : Type.getArgumentTypes(lllllllllllllllIllllIIIllIIIIlII)) {
            lllllllllllllllIllllIIIllIIIIIll.append(lllllllllllllllIllllIIIllIIIIIlI.transformSingleDescriptor(lllllllllllllllIllllIIIllIIIIllI));
        }
        return String.valueOf(lllllllllllllllIllllIIIllIIIIIll.append(')').append(lllllllllllllllIllllIIIllIIIIIlI.transformSingleDescriptor(Type.getReturnType(lllllllllllllllIllllIIIllIIIIlII))));
    }

    public String getUniqueName(FieldNode lllllllllllllllIllllIIIIIlllllII) {
        MixinTargetContext lllllllllllllllIllllIIIIIllllllI;
        return lllllllllllllllIllllIIIIIllllllI.getTarget().getUniqueName(lllllllllllllllIllllIIIIIlllllII);
    }

    private void updateDynamicBinding(MethodNode lllllllllllllllIllllIIIllllIlIII, MemberRef lllllllllllllllIllllIIIllllIlIlI) {
        MixinTargetContext lllllllllllllllIllllIIIllllIllII;
        lllllllllllllllIllllIIIllllIllII.updateBinding(lllllllllllllllIllllIIIllllIlIII, lllllllllllllllIllllIIIllllIlIlI, ClassInfo.Traversal.ALL);
    }

    public List<FieldNode> getFields() {
        MixinTargetContext lllllllllllllllIllllIIIIlllIIIIl;
        return lllllllllllllllIllllIIIIlllIIIIl.classNode.fields;
    }

    public void postApply(String lllllllllllllllIllllIIIIlIlIIIIl, ClassNode lllllllllllllllIllllIIIIlIlIIIII) {
        MixinTargetContext lllllllllllllllIllllIIIIlIlIIIlI;
        try {
            lllllllllllllllIllllIIIIlIlIIIlI.injectorGroups.validateAll();
        }
        catch (InjectionValidationException lllllllllllllllIllllIIIIlIlIIIll) {
            InjectorGroupInfo lllllllllllllllIllllIIIIlIlIIlII = lllllllllllllllIllllIIIIlIlIIIll.getGroup();
            throw new InjectionError(String.format("Critical injection failure: Callback group %s in %s failed injection check: %s", lllllllllllllllIllllIIIIlIlIIlII, lllllllllllllllIllllIIIIlIlIIIlI.mixin, lllllllllllllllIllllIIIIlIlIIIll.getMessage()));
        }
        lllllllllllllllIllllIIIIlIlIIIlI.mixin.postApply(lllllllllllllllIllllIIIIlIlIIIIl, lllllllllllllllIllllIIIIlIlIIIII);
    }

    private void transformInvokeDynamicNode(MethodNode lllllllllllllllIllllIIlIIlIIIIII, Iterator<AbstractInsnNode> lllllllllllllllIllllIIlIIIlllIll, InvokeDynamicInsnNode lllllllllllllllIllllIIlIIIlllIlI) {
        MixinTargetContext lllllllllllllllIllllIIlIIIllllIl;
        lllllllllllllllIllllIIlIIIllllIl.requireVersion(51);
        lllllllllllllllIllllIIlIIIlllIlI.desc = lllllllllllllllIllllIIlIIIllllIl.transformMethodDescriptor(lllllllllllllllIllllIIlIIIlllIlI.desc);
        lllllllllllllllIllllIIlIIIlllIlI.bsm = lllllllllllllllIllllIIlIIIllllIl.transformHandle(lllllllllllllllIllllIIlIIlIIIIII, lllllllllllllllIllllIIlIIIlllIll, lllllllllllllllIllllIIlIIIlllIlI.bsm);
        for (int lllllllllllllllIllllIIlIIlIIIIlI = 0; lllllllllllllllIllllIIlIIlIIIIlI < lllllllllllllllIllllIIlIIIlllIlI.bsmArgs.length; ++lllllllllllllllIllllIIlIIlIIIIlI) {
            lllllllllllllllIllllIIlIIIlllIlI.bsmArgs[lllllllllllllllIllllIIlIIlIIIIlI] = lllllllllllllllIllllIIlIIIllllIl.transformConstant(lllllllllllllllIllllIIlIIlIIIIII, lllllllllllllllIllllIIlIIIlllIll, lllllllllllllllIllllIIlIIIlllIlI.bsmArgs[lllllllllllllllIllllIIlIIlIIIIlI]);
        }
    }

    public List<MethodNode> getMethods() {
        MixinTargetContext lllllllllllllllIllllIIIIlllIllll;
        return lllllllllllllllIllllIIIIlllIllll.classNode.methods;
    }

    static {
        logger = LogManager.getLogger((String)"mixin");
    }

    private void validateMethod(MethodNode lllllllllllllllIllllIIlIlIlIlIlI) {
        MixinTargetContext lllllllllllllllIllllIIlIlIlIlIll;
        ClassInfo.Method lllllllllllllllIllllIIlIlIlIllII;
        if (!(Annotations.getInvisible(lllllllllllllllIllllIIlIlIlIlIlI, SoftOverride.class) == null || (lllllllllllllllIllllIIlIlIlIllII = lllllllllllllllIllllIIlIlIlIlIll.targetClassInfo.findMethodInHierarchy(lllllllllllllllIllllIIlIlIlIlIlI.name, lllllllllllllllIllllIIlIlIlIlIlI.desc, ClassInfo.SearchType.SUPER_CLASSES_ONLY, ClassInfo.Traversal.SUPER)) != null && lllllllllllllllIllllIIlIlIlIllII.isInjected())) {
            throw new InvalidMixinException((IMixinContext)lllllllllllllllIllllIIlIlIlIlIll, String.valueOf(new StringBuilder().append("Mixin method ").append(lllllllllllllllIllllIIlIlIlIlIlI.name).append(lllllllllllllllIllllIIlIlIlIlIlI.desc).append(" is tagged with @SoftOverride but no valid method was found in superclasses of ").append(lllllllllllllllIllllIIlIlIlIlIll.getTarget().getClassName())));
        }
    }

    public List<MethodNode> generateAccessors() {
        MixinTargetContext lllllllllllllllIllllIIIIIlIIIIII;
        for (AccessorInfo lllllllllllllllIllllIIIIIlIIIlIl : lllllllllllllllIllllIIIIIlIIIIII.accessors) {
            lllllllllllllllIllllIIIIIlIIIlIl.locate();
        }
        ArrayList<MethodNode> lllllllllllllllIllllIIIIIlIIIIIl = new ArrayList<MethodNode>();
        for (AccessorInfo lllllllllllllllIllllIIIIIlIIIIll : lllllllllllllllIllllIIIIIlIIIIII.accessors) {
            MethodNode lllllllllllllllIllllIIIIIlIIIlII = lllllllllllllllIllllIIIIIlIIIIll.generate();
            lllllllllllllllIllllIIIIIlIIIIII.getTarget().addMixinMethod(lllllllllllllllIllllIIIIIlIIIlII);
            lllllllllllllllIllllIIIIIlIIIIIl.add(lllllllllllllllIllllIIIIIlIIIlII);
        }
        return lllllllllllllllIllllIIIIIlIIIIIl;
    }

    public int getMinRequiredClassVersion() {
        MixinTargetContext lllllllllllllllIllllIIlIllIllIII;
        return lllllllllllllllIllllIIlIllIllIII.minRequiredClassVersion;
    }

    public void transformMethod(MethodNode lllllllllllllllIllllIIlIlIllIllI) {
        MixinTargetContext lllllllllllllllIllllIIlIlIllIlll;
        lllllllllllllllIllllIIlIlIllIlll.validateMethod(lllllllllllllllIllllIIlIlIllIllI);
        lllllllllllllllIllllIIlIlIllIlll.transformDescriptor(lllllllllllllllIllllIIlIlIllIllI);
        lllllllllllllllIllllIIlIlIllIlll.transformLVT(lllllllllllllllIllllIIlIlIllIllI);
        lllllllllllllllIllllIIlIlIllIlll.stratum.applyOffset(lllllllllllllllIllllIIlIlIllIllI);
        AbstractInsnNode lllllllllllllllIllllIIlIlIllIlIl = null;
        ListIterator<AbstractInsnNode> lllllllllllllllIllllIIlIlIlllIII = lllllllllllllllIllllIIlIlIllIllI.instructions.iterator();
        while (lllllllllllllllIllllIIlIlIlllIII.hasNext()) {
            AbstractInsnNode lllllllllllllllIllllIIlIlIlllIIl = (AbstractInsnNode)lllllllllllllllIllllIIlIlIlllIII.next();
            if (lllllllllllllllIllllIIlIlIlllIIl instanceof MethodInsnNode) {
                lllllllllllllllIllllIIlIlIllIlll.transformMethodRef(lllllllllllllllIllllIIlIlIllIllI, lllllllllllllllIllllIIlIlIlllIII, new MemberRef.Method((MethodInsnNode)lllllllllllllllIllllIIlIlIlllIIl));
            } else if (lllllllllllllllIllllIIlIlIlllIIl instanceof FieldInsnNode) {
                lllllllllllllllIllllIIlIlIllIlll.transformFieldRef(lllllllllllllllIllllIIlIlIllIllI, lllllllllllllllIllllIIlIlIlllIII, new MemberRef.Field((FieldInsnNode)lllllllllllllllIllllIIlIlIlllIIl));
                lllllllllllllllIllllIIlIlIllIlll.checkFinal(lllllllllllllllIllllIIlIlIllIllI, lllllllllllllllIllllIIlIlIlllIII, (FieldInsnNode)lllllllllllllllIllllIIlIlIlllIIl);
            } else if (lllllllllllllllIllllIIlIlIlllIIl instanceof TypeInsnNode) {
                lllllllllllllllIllllIIlIlIllIlll.transformTypeNode(lllllllllllllllIllllIIlIlIllIllI, lllllllllllllllIllllIIlIlIlllIII, (TypeInsnNode)lllllllllllllllIllllIIlIlIlllIIl, lllllllllllllllIllllIIlIlIllIlIl);
            } else if (lllllllllllllllIllllIIlIlIlllIIl instanceof LdcInsnNode) {
                lllllllllllllllIllllIIlIlIllIlll.transformConstantNode(lllllllllllllllIllllIIlIlIllIllI, lllllllllllllllIllllIIlIlIlllIII, (LdcInsnNode)lllllllllllllllIllllIIlIlIlllIIl);
            } else if (lllllllllllllllIllllIIlIlIlllIIl instanceof InvokeDynamicInsnNode) {
                lllllllllllllllIllllIIlIlIllIlll.transformInvokeDynamicNode(lllllllllllllllIllllIIlIlIllIllI, lllllllllllllllIllllIIlIlIlllIII, (InvokeDynamicInsnNode)lllllllllllllllIllllIIlIlIlllIIl);
            }
            lllllllllllllllIllllIIlIlIllIlIl = lllllllllllllllIllllIIlIlIlllIIl;
        }
    }

    public ClassInfo findRealType(ClassInfo lllllllllllllllIllllIIlIllIIIIII) {
        MixinTargetContext lllllllllllllllIllllIIlIllIIIlII;
        if (lllllllllllllllIllllIIlIllIIIIII == lllllllllllllllIllllIIlIllIIIlII.getClassInfo()) {
            return lllllllllllllllIllllIIlIllIIIlII.targetClassInfo;
        }
        ClassInfo lllllllllllllllIllllIIlIllIIIIlI = lllllllllllllllIllllIIlIllIIIlII.targetClassInfo.findCorrespondingType(lllllllllllllllIllllIIlIllIIIIII);
        if (lllllllllllllllIllllIIlIllIIIIlI == null) {
            throw new InvalidMixinException((IMixinContext)lllllllllllllllIllllIIlIllIIIlII, String.valueOf(new StringBuilder().append("Resolution error: unable to find corresponding type for ").append(lllllllllllllllIllllIIlIllIIIIII).append(" in hierarchy of ").append(lllllllllllllllIllllIIlIllIIIlII.targetClassInfo)));
        }
        return lllllllllllllllIllllIIlIllIIIIlI;
    }

    @Override
    public boolean getOption(MixinEnvironment.Option lllllllllllllllIllllIIlIlllllIll) {
        MixinTargetContext lllllllllllllllIllllIIlIllllllIl;
        return lllllllllllllllIllllIIlIllllllIl.getEnvironment().getOption(lllllllllllllllIllllIIlIlllllIll);
    }

    public boolean shouldSetSourceFile() {
        MixinTargetContext lllllllllllllllIllllIIIIllIlIlIl;
        return lllllllllllllllIllllIIIIllIlIlIl.mixin.getParent().shouldSetSourceFile();
    }

    private Object transformConstant(MethodNode lllllllllllllllIllllIIlIIIlIlIll, Iterator<AbstractInsnNode> lllllllllllllllIllllIIlIIIlIlIlI, Object lllllllllllllllIllllIIlIIIlIlIIl) {
        MixinTargetContext lllllllllllllllIllllIIlIIIllIIII;
        if (lllllllllllllllIllllIIlIIIlIlIIl instanceof Type) {
            Type lllllllllllllllIllllIIlIIIllIIlI = (Type)lllllllllllllllIllllIIlIIIlIlIIl;
            String lllllllllllllllIllllIIlIIIllIIIl = lllllllllllllllIllllIIlIIIllIIII.transformDescriptor(lllllllllllllllIllllIIlIIIllIIlI);
            if (!lllllllllllllllIllllIIlIIIllIIlI.toString().equals(lllllllllllllllIllllIIlIIIllIIIl)) {
                return Type.getType(lllllllllllllllIllllIIlIIIllIIIl);
            }
            return lllllllllllllllIllllIIlIIIlIlIIl;
        }
        if (lllllllllllllllIllllIIlIIIlIlIIl instanceof Handle) {
            return lllllllllllllllIllllIIlIIIllIIII.transformHandle(lllllllllllllllIllllIIlIIIlIlIll, lllllllllllllllIllllIIlIIIlIlIlI, (Handle)lllllllllllllllIllllIIlIIIlIlIIl);
        }
        return lllllllllllllllIllllIIlIIIlIlIIl;
    }

    @Override
    public String getClassRef() {
        MixinTargetContext lllllllllllllllIllllIIlIlllIllll;
        return lllllllllllllllIllllIIlIlllIllll.mixin.getClassRef();
    }

    void methodMerged(MethodNode lllllllllllllllIllllIIllIIIIllIl) {
        MixinTargetContext lllllllllllllllIllllIIllIIIIllll;
        lllllllllllllllIllllIIllIIIIllll.mergedMethods.add(lllllllllllllllIllllIIllIIIIllIl);
        lllllllllllllllIllllIIllIIIIllll.targetClassInfo.addMethod(lllllllllllllllIllllIIllIIIIllIl);
        lllllllllllllllIllllIIllIIIIllll.getTarget().methodMerged(lllllllllllllllIllllIIllIIIIllIl);
        Annotations.setVisible(lllllllllllllllIllllIIllIIIIllIl, MixinMerged.class, "mixin", lllllllllllllllIllllIIllIIIIllll.getClassName(), "priority", lllllllllllllllIllllIIllIIIIllll.getPriority(), "sessionId", lllllllllllllllIllllIIllIIIIllll.sessionId);
    }

    void addAccessorMethod(MethodNode lllllllllllllllIllllIIllIIIllllI, Class<? extends Annotation> lllllllllllllllIllllIIllIIlIIIIl) {
        MixinTargetContext lllllllllllllllIllllIIllIIIlllll;
        lllllllllllllllIllllIIllIIIlllll.accessors.add(AccessorInfo.of(lllllllllllllllIllllIIllIIIlllll, lllllllllllllllIllllIIllIIIllllI, lllllllllllllllIllllIIllIIlIIIIl));
    }

    private String transformSingleDescriptor(String lllllllllllllllIllllIIIllIIlIIlI, boolean lllllllllllllllIllllIIIllIIlIlll) {
        MixinTargetContext lllllllllllllllIllllIIIllIIlIIll;
        String lllllllllllllllIllllIIIllIIlIllI = lllllllllllllllIllllIIIllIIlIIlI;
        while (lllllllllllllllIllllIIIllIIlIllI.startsWith("[") || lllllllllllllllIllllIIIllIIlIllI.startsWith("L")) {
            if (lllllllllllllllIllllIIIllIIlIllI.startsWith("[")) {
                lllllllllllllllIllllIIIllIIlIllI = lllllllllllllllIllllIIIllIIlIllI.substring(1);
                continue;
            }
            lllllllllllllllIllllIIIllIIlIllI = lllllllllllllllIllllIIIllIIlIllI.substring(1, lllllllllllllllIllllIIIllIIlIllI.indexOf(";"));
            lllllllllllllllIllllIIIllIIlIlll = true;
        }
        if (!lllllllllllllllIllllIIIllIIlIlll) {
            return lllllllllllllllIllllIIIllIIlIIlI;
        }
        String lllllllllllllllIllllIIIllIIlIlIl = (String)lllllllllllllllIllllIIIllIIlIIll.innerClasses.get((Object)lllllllllllllllIllllIIIllIIlIllI);
        if (lllllllllllllllIllllIIIllIIlIlIl != null) {
            return lllllllllllllllIllllIIIllIIlIIlI.replace(lllllllllllllllIllllIIIllIIlIllI, lllllllllllllllIllllIIIllIIlIlIl);
        }
        if (lllllllllllllllIllllIIIllIIlIIll.innerClasses.inverse().containsKey((Object)lllllllllllllllIllllIIIllIIlIllI)) {
            return lllllllllllllllIllllIIIllIIlIIlI;
        }
        ClassInfo lllllllllllllllIllllIIIllIIlIlII = ClassInfo.forName(lllllllllllllllIllllIIIllIIlIllI);
        if (!lllllllllllllllIllllIIIllIIlIlII.isMixin()) {
            return lllllllllllllllIllllIIIllIIlIIlI;
        }
        return lllllllllllllllIllllIIIllIIlIIlI.replace(lllllllllllllllIllllIIIllIIlIllI, lllllllllllllllIllllIIIllIIlIIll.findRealType(lllllllllllllllIllllIIIllIIlIlII).toString());
    }

    private void updateBinding(MethodNode lllllllllllllllIllllIIIlllIIlllI, MemberRef lllllllllllllllIllllIIIlllIlIIlI, ClassInfo.Traversal lllllllllllllllIllllIIIlllIIllII) {
        MixinTargetContext lllllllllllllllIllllIIIlllIlIlII;
        if ("<init>".equals(lllllllllllllllIllllIIIlllIIlllI.name) || lllllllllllllllIllllIIIlllIlIIlI.getOwner().equals(lllllllllllllllIllllIIIlllIlIlII.getTarget().getClassRef()) || lllllllllllllllIllllIIIlllIlIlII.getTarget().getClassRef().startsWith("<")) {
            return;
        }
        ClassInfo.Method lllllllllllllllIllllIIIlllIlIIII = lllllllllllllllIllllIIIlllIlIlII.targetClassInfo.findMethodInHierarchy(lllllllllllllllIllllIIIlllIlIIlI.getName(), lllllllllllllllIllllIIIlllIlIIlI.getDesc(), lllllllllllllllIllllIIIlllIIllII.getSearchType(), lllllllllllllllIllllIIIlllIIllII);
        if (lllllllllllllllIllllIIIlllIlIIII != null) {
            if (lllllllllllllllIllllIIIlllIlIIII.getOwner().isMixin()) {
                throw new InvalidMixinException((IMixinContext)lllllllllllllllIllllIIIlllIlIlII, String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllllIIIlllIlIIlI).append(" in ").append(lllllllllllllllIllllIIIlllIlIlII).append(" resolved ").append(lllllllllllllllIllllIIIlllIlIIII.getOwner()).append(" but is mixin.")));
            }
            lllllllllllllllIllllIIIlllIlIIlI.setOwner(lllllllllllllllIllllIIIlllIlIIII.getImplementor().getName());
        } else if (ClassInfo.forName(lllllllllllllllIllllIIIlllIlIIlI.getOwner()).isMixin()) {
            throw new MixinTransformerError(String.valueOf(new StringBuilder().append("Error resolving ").append(lllllllllllllllIllllIIIlllIlIIlI).append(" in ").append(lllllllllllllllIllllIIIlllIlIlII)));
        }
    }

    @Override
    public Target getTargetMethod(MethodNode lllllllllllllllIllllIIIlIllllIII) {
        MixinTargetContext lllllllllllllllIllllIIIlIllllIIl;
        return lllllllllllllllIllllIIIlIllllIIl.getTarget().getTargetMethod(lllllllllllllllIllllIIIlIllllIII);
    }

    public InjectorGroupInfo.Map getInjectorGroups() {
        MixinTargetContext lllllllllllllllIllllIIlIllIIllII;
        return lllllllllllllllIllllIIlIllIIllII.injectorGroups;
    }

    public Set<Map.Entry<FieldNode, ClassInfo.Field>> getShadowFields() {
        MixinTargetContext lllllllllllllllIllllIIIIlllIIllI;
        return lllllllllllllllIllllIIIIlllIIllI.shadowFields.entrySet();
    }

    MethodNode findRemappedMethod(MethodNode lllllllllllllllIllllIIIlIlIlIIIl) {
        MixinTargetContext lllllllllllllllIllllIIIlIlIlIIlI;
        RemapperChain lllllllllllllllIllllIIIlIlIlIllI = lllllllllllllllIllllIIIlIlIlIIlI.getEnvironment().getRemappers();
        String lllllllllllllllIllllIIIlIlIlIlII = lllllllllllllllIllllIIIlIlIlIllI.mapMethodName(lllllllllllllllIllllIIIlIlIlIIlI.getTarget().getClassRef(), lllllllllllllllIllllIIIlIlIlIIIl.name, lllllllllllllllIllllIIIlIlIlIIIl.desc);
        if (lllllllllllllllIllllIIIlIlIlIlII.equals(lllllllllllllllIllllIIIlIlIlIIIl.name)) {
            return null;
        }
        LinkedList<String> lllllllllllllllIllllIIIlIlIlIIll = new LinkedList<String>();
        lllllllllllllllIllllIIIlIlIlIIll.add(lllllllllllllllIllllIIIlIlIlIlII);
        return lllllllllllllllIllllIIIlIlIlIIlI.getTarget().findAliasedMethod(lllllllllllllllIllllIIIlIlIlIIll, lllllllllllllllIllllIIIlIlIlIIIl.desc);
    }

    public void preApply(String lllllllllllllllIllllIIIIlIlllllI, ClassNode lllllllllllllllIllllIIIIlIllllII) {
        MixinTargetContext lllllllllllllllIllllIIIIllIIIIII;
        lllllllllllllllIllllIIIIllIIIIII.mixin.preApply(lllllllllllllllIllllIIIIlIlllllI, lllllllllllllllIllllIIIIlIllllII);
    }

    private void transformConstantNode(MethodNode lllllllllllllllIllllIIlIIlIIlllI, Iterator<AbstractInsnNode> lllllllllllllllIllllIIlIIlIIlIIl, LdcInsnNode lllllllllllllllIllllIIlIIlIIllII) {
        MixinTargetContext lllllllllllllllIllllIIlIIlIIlIll;
        lllllllllllllllIllllIIlIIlIIllII.cst = lllllllllllllllIllllIIlIIlIIlIll.transformConstant(lllllllllllllllIllllIIlIIlIIlllI, lllllllllllllllIllllIIlIIlIIlIIl, lllllllllllllllIllllIIlIIlIIllII.cst);
    }

    void addMixinMethod(MethodNode lllllllllllllllIllllIIllIIIllIIl) {
        MixinTargetContext lllllllllllllllIllllIIllIIIllIlI;
        Annotations.setVisible(lllllllllllllllIllllIIllIIIllIIl, MixinMerged.class, "mixin", lllllllllllllllIllllIIllIIIllIlI.getClassName());
        lllllllllllllllIllllIIllIIIllIlI.getTarget().addMixinMethod(lllllllllllllllIllllIIllIIIllIIl);
    }

    @Override
    public String getTargetClassRef() {
        MixinTargetContext lllllllllllllllIllllIIlIlllIlIIl;
        return lllllllllllllllIllllIIlIlllIlIIl.getTarget().getClassRef();
    }

    public SourceMap.File getStratum() {
        MixinTargetContext lllllllllllllllIllllIIlIllIllIlI;
        return lllllllllllllllIllllIIlIllIllIlI.stratum;
    }

    public Set<String> getInterfaces() {
        MixinTargetContext lllllllllllllllIllllIIIIlllllIII;
        return lllllllllllllllIllllIIIIlllllIII.mixin.getInterfaces();
    }

    private String transformDescriptor(Type lllllllllllllllIllllIIIllIlIllll) {
        MixinTargetContext lllllllllllllllIllllIIIllIllIIII;
        if (lllllllllllllllIllllIIIllIlIllll.getSort() == 11) {
            return lllllllllllllllIllllIIIllIllIIII.transformMethodDescriptor(lllllllllllllllIllllIIIllIlIllll.getDescriptor());
        }
        return lllllllllllllllIllllIIIllIllIIII.transformSingleDescriptor(lllllllllllllllIllllIIIllIlIllll);
    }

    public String getSourceFile() {
        MixinTargetContext lllllllllllllllIllllIIIIllIlIIII;
        return lllllllllllllllIllllIIIIllIlIIII.classNode.sourceFile;
    }

    public String toString() {
        MixinTargetContext lllllllllllllllIllllIIllIIIIIlll;
        return lllllllllllllllIllllIIllIIIIIlll.mixin.toString();
    }

    public Level getLoggingLevel() {
        MixinTargetContext lllllllllllllllIllllIIIIllIllIlI;
        return lllllllllllllllIllllIIIIllIllIlI.mixin.getLoggingLevel();
    }

    void addShadowMethod(MethodNode lllllllllllllllIllllIIllIllIIIll) {
        MixinTargetContext lllllllllllllllIllllIIllIllIIlII;
        lllllllllllllllIllllIIllIllIIlII.shadowMethods.add(lllllllllllllllIllllIIllIllIIIll);
    }

    public int getMaxShiftByValue() {
        MixinTargetContext lllllllllllllllIllllIIlIllIIllll;
        return lllllllllllllllIllllIIlIllIIllll.mixin.getParent().getMaxShiftByValue();
    }

    public ClassInfo getTargetClassInfo() {
        MixinTargetContext lllllllllllllllIllllIIlIlllIIIll;
        return lllllllllllllllIllllIIlIlllIIIll.targetClassInfo;
    }

    public TargetClassContext getTarget() {
        MixinTargetContext lllllllllllllllIllllIIlIlllIllII;
        return lllllllllllllllIllllIIlIlllIllII.targetClass;
    }

    public Collection<MethodNode> getShadowMethods() {
        MixinTargetContext lllllllllllllllIllllIIIIllllIlIl;
        return lllllllllllllllIllllIIIIllllIlIl.shadowMethods;
    }

    private Handle transformHandle(MethodNode lllllllllllllllIllllIIlIIIlIIIII, Iterator<AbstractInsnNode> lllllllllllllllIllllIIlIIIIlllll, Handle lllllllllllllllIllllIIlIIIIllllI) {
        MixinTargetContext lllllllllllllllIllllIIlIIIIlllII;
        MemberRef.Handle lllllllllllllllIllllIIlIIIIlllIl = new MemberRef.Handle(lllllllllllllllIllllIIlIIIIllllI);
        if (lllllllllllllllIllllIIlIIIIlllIl.isField()) {
            lllllllllllllllIllllIIlIIIIlllII.transformFieldRef(lllllllllllllllIllllIIlIIIlIIIII, lllllllllllllllIllllIIlIIIIlllll, lllllllllllllllIllllIIlIIIIlllIl);
        } else {
            lllllllllllllllIllllIIlIIIIlllII.transformMethodRef(lllllllllllllllIllllIIlIIIlIIIII, lllllllllllllllIllllIIlIIIIlllll, lllllllllllllllIllllIIlIIIIlllIl);
        }
        return lllllllllllllllIllllIIlIIIIlllIl.getMethodHandle();
    }

    MixinInfo getInfo() {
        MixinTargetContext lllllllllllllllIllllIIIIllllllIl;
        return lllllllllllllllIllllIIIIllllllIl.mixin;
    }

    protected void requireVersion(int lllllllllllllllIllllIIIlIIIlIIII) {
        MixinTargetContext lllllllllllllllIllllIIIlIIIIlllI;
        lllllllllllllllIllllIIIlIIIIlllI.minRequiredClassVersion = Math.max(lllllllllllllllIllllIIIlIIIIlllI.minRequiredClassVersion, lllllllllllllllIllllIIIlIIIlIIII);
        if (lllllllllllllllIllllIIIlIIIlIIII > MixinEnvironment.getCompatibilityLevel().classVersion()) {
            throw new InvalidMixinException((IMixinContext)lllllllllllllllIllllIIIlIIIIlllI, String.valueOf(new StringBuilder().append("Unsupported mixin class version ").append(lllllllllllllllIllllIIIlIIIlIIII)));
        }
    }

    FieldNode findRemappedField(FieldNode lllllllllllllllIllllIIIlIIlIIlll) {
        MixinTargetContext lllllllllllllllIllllIIIlIIlIlIII;
        RemapperChain lllllllllllllllIllllIIIlIIlIIllI = lllllllllllllllIllllIIIlIIlIlIII.getEnvironment().getRemappers();
        String lllllllllllllllIllllIIIlIIlIIlIl = lllllllllllllllIllllIIIlIIlIIllI.mapFieldName(lllllllllllllllIllllIIIlIIlIlIII.getTarget().getClassRef(), lllllllllllllllIllllIIIlIIlIIlll.name, lllllllllllllllIllllIIIlIIlIIlll.desc);
        if (lllllllllllllllIllllIIIlIIlIIlIl.equals(lllllllllllllllIllllIIIlIIlIIlll.name)) {
            return null;
        }
        LinkedList<String> lllllllllllllllIllllIIIlIIlIIlII = new LinkedList<String>();
        lllllllllllllllIllllIIIlIIlIIlII.add(lllllllllllllllIllllIIIlIIlIIlIl);
        return lllllllllllllllIllllIIIlIIlIlIII.getTarget().findAliasedField(lllllllllllllllIllllIIIlIIlIIlII, lllllllllllllllIllllIIIlIIlIIlll.desc);
    }

    @Override
    public IMixinInfo getMixin() {
        MixinTargetContext lllllllllllllllIllllIIIlIIIIIIll;
        return lllllllllllllllIllllIIIlIIIIIIll.mixin;
    }

    private String transformSingleDescriptor(Type lllllllllllllllIllllIIIllIlIIIlI) {
        MixinTargetContext lllllllllllllllIllllIIIllIlIIlll;
        if (lllllllllllllllIllllIIIllIlIIIlI.getSort() < 9) {
            return lllllllllllllllIllllIIIllIlIIIlI.toString();
        }
        return lllllllllllllllIllllIIIllIlIIlll.transformSingleDescriptor(lllllllllllllllIllllIIIllIlIIIlI.toString(), false);
    }

    public void prepareInjections() {
        MixinTargetContext lllllllllllllllIllllIIIIIllIIlIl;
        lllllllllllllllIllllIIIIIllIIlIl.injectors.clear();
        for (MethodNode lllllllllllllllIllllIIIIIllIlIIl : lllllllllllllllIllllIIIIIllIIlIl.mergedMethods) {
            InjectionInfo lllllllllllllllIllllIIIIIllIlIll = InjectionInfo.parse(lllllllllllllllIllllIIIIIllIIlIl, lllllllllllllllIllllIIIIIllIlIIl);
            if (lllllllllllllllIllllIIIIIllIlIll == null) continue;
            if (lllllllllllllllIllllIIIIIllIlIll.isValid()) {
                lllllllllllllllIllllIIIIIllIlIll.prepare();
                lllllllllllllllIllllIIIIIllIIlIl.injectors.add(lllllllllllllllIllllIIIIIllIlIll);
            }
            lllllllllllllllIllllIIIIIllIlIIl.visibleAnnotations.remove(lllllllllllllllIllllIIIIIllIlIll.getAnnotation());
        }
    }

    public void transformDescriptor(FieldNode lllllllllllllllIllllIIIlllIIIlIl) {
        MixinTargetContext lllllllllllllllIllllIIIlllIIIllI;
        if (!lllllllllllllllIllllIIIlllIIIllI.inheritsFromMixin && lllllllllllllllIllllIIIlllIIIllI.innerClasses.size() == 0) {
            return;
        }
        lllllllllllllllIllllIIIlllIIIlIl.desc = lllllllllllllllIllllIIIlllIIIllI.transformSingleDescriptor(lllllllllllllllIllllIIIlllIIIlIl.desc, false);
    }

    public ClassSignature getSignature() {
        MixinTargetContext lllllllllllllllIllllIIlIllIllllI;
        return lllllllllllllllIllllIIlIllIllllI.getClassInfo().getSignature();
    }

    public void transformDescriptor(MemberRef lllllllllllllllIllllIIIllIlllIIl) {
        MixinTargetContext lllllllllllllllIllllIIIllIlllIlI;
        if (!lllllllllllllllIllllIIIllIlllIlI.inheritsFromMixin && lllllllllllllllIllllIIIllIlllIlI.innerClasses.size() == 0) {
            return;
        }
        if (lllllllllllllllIllllIIIllIlllIIl.isField()) {
            lllllllllllllllIllllIIIllIlllIIl.setDesc(lllllllllllllllIllllIIIllIlllIlI.transformSingleDescriptor(lllllllllllllllIllllIIIllIlllIIl.getDesc(), false));
        } else {
            lllllllllllllllIllllIIIllIlllIIl.setDesc(lllllllllllllllIllllIIIllIlllIlI.transformMethodDescriptor(lllllllllllllllIllllIIIllIlllIIl.getDesc()));
        }
    }

    @Override
    public int getPriority() {
        MixinTargetContext lllllllllllllllIllllIIIIlllllIll;
        return lllllllllllllllIllllIIIIlllllIll.mixin.getPriority();
    }

    public void applyInjections() {
        MixinTargetContext lllllllllllllllIllllIIIIIlIlIlIl;
        for (InjectionInfo lllllllllllllllIllllIIIIIlIllIIl : lllllllllllllllIllllIIIIIlIlIlIl.injectors) {
            lllllllllllllllIllllIIIIIlIllIIl.inject();
        }
        for (InjectionInfo lllllllllllllllIllllIIIIIlIlIlll : lllllllllllllllIllllIIIIIlIlIlIl.injectors) {
            lllllllllllllllIllllIIIIIlIlIlll.postInject();
        }
        lllllllllllllllIllllIIIIIlIlIlIl.injectors.clear();
    }

    MixinTargetContext(MixinInfo lllllllllllllllIllllIIllIlllIIIl, ClassNode lllllllllllllllIllllIIllIlllIIII, TargetClassContext lllllllllllllllIllllIIllIllIllll) {
        MixinTargetContext lllllllllllllllIllllIIllIllIllIl;
        lllllllllllllllIllllIIllIllIllIl.innerClasses = HashBiMap.create();
        lllllllllllllllIllllIIllIllIllIl.shadowMethods = new ArrayList<MethodNode>();
        lllllllllllllllIllllIIllIllIllIl.shadowFields = new LinkedHashMap<FieldNode, ClassInfo.Field>();
        lllllllllllllllIllllIIllIllIllIl.mergedMethods = new ArrayList<MethodNode>();
        lllllllllllllllIllllIIllIllIllIl.injectorGroups = new InjectorGroupInfo.Map();
        lllllllllllllllIllllIIllIllIllIl.injectors = new ArrayList<InjectionInfo>();
        lllllllllllllllIllllIIllIllIllIl.accessors = new ArrayList<AccessorInfo>();
        lllllllllllllllIllllIIllIllIllIl.minRequiredClassVersion = MixinEnvironment.CompatibilityLevel.JAVA_6.classVersion();
        lllllllllllllllIllllIIllIllIllIl.mixin = lllllllllllllllIllllIIllIlllIIIl;
        lllllllllllllllIllllIIllIllIllIl.classNode = lllllllllllllllIllllIIllIlllIIII;
        lllllllllllllllIllllIIllIllIllIl.targetClass = lllllllllllllllIllllIIllIllIllll;
        lllllllllllllllIllllIIllIllIllIl.targetClassInfo = ClassInfo.forName(lllllllllllllllIllllIIllIllIllIl.getTarget().getClassRef());
        lllllllllllllllIllllIIllIllIllIl.stratum = lllllllllllllllIllllIIllIllIllll.getSourceMap().addFile(lllllllllllllllIllllIIllIllIllIl.classNode);
        lllllllllllllllIllllIIllIllIllIl.inheritsFromMixin = lllllllllllllllIllllIIllIlllIIIl.getClassInfo().hasMixinInHierarchy() || lllllllllllllllIllllIIllIllIllIl.targetClassInfo.hasMixinTargetInHierarchy();
        lllllllllllllllIllllIIllIllIllIl.detachedSuper = !lllllllllllllllIllllIIllIllIllIl.classNode.superName.equals(lllllllllllllllIllllIIllIllIllIl.getTarget().getClassNode().superName);
        lllllllllllllllIllllIIllIllIllIl.sessionId = lllllllllllllllIllllIIllIllIllll.getSessionId();
        lllllllllllllllIllllIIllIllIllIl.requireVersion(lllllllllllllllIllllIIllIlllIIII.version);
        InnerClassGenerator lllllllllllllllIllllIIllIllIlllI = (InnerClassGenerator)lllllllllllllllIllllIIllIllIllll.getExtensions().getGenerator(InnerClassGenerator.class);
        for (String lllllllllllllllIllllIIllIlllIIll : lllllllllllllllIllllIIllIllIllIl.mixin.getInnerClasses()) {
            lllllllllllllllIllllIIllIllIllIl.innerClasses.put((Object)lllllllllllllllIllllIIllIlllIIll, (Object)lllllllllllllllIllllIIllIllIlllI.registerInnerClass(lllllllllllllllIllllIIllIllIllIl.mixin, lllllllllllllllIllllIIllIlllIIll, lllllllllllllllIllllIIllIllIllIl));
        }
    }

    private void transformTypeNode(MethodNode lllllllllllllllIllllIIlIIlIlllII, Iterator<AbstractInsnNode> lllllllllllllllIllllIIlIIlIlIlll, TypeInsnNode lllllllllllllllIllllIIlIIlIlIllI, AbstractInsnNode lllllllllllllllIllllIIlIIlIlIlIl) {
        MixinTargetContext lllllllllllllllIllllIIlIIlIllIII;
        if (lllllllllllllllIllllIIlIIlIlIllI.getOpcode() == 192 && lllllllllllllllIllllIIlIIlIlIllI.desc.equals(lllllllllllllllIllllIIlIIlIllIII.getTarget().getClassRef()) && lllllllllllllllIllllIIlIIlIlIlIl.getOpcode() == 25 && ((VarInsnNode)lllllllllllllllIllllIIlIIlIlIlIl).var == 0) {
            lllllllllllllllIllllIIlIIlIlIlll.remove();
            return;
        }
        if (lllllllllllllllIllllIIlIIlIlIllI.desc.equals(lllllllllllllllIllllIIlIIlIllIII.getClassRef())) {
            lllllllllllllllIllllIIlIIlIlIllI.desc = lllllllllllllllIllllIIlIIlIllIII.getTarget().getClassRef();
        } else {
            String lllllllllllllllIllllIIlIIlIllllI = (String)lllllllllllllllIllllIIlIIlIllIII.innerClasses.get((Object)lllllllllllllllIllllIIlIIlIlIllI.desc);
            if (lllllllllllllllIllllIIlIIlIllllI != null) {
                lllllllllllllllIllllIIlIIlIlIllI.desc = lllllllllllllllIllllIIlIIlIllllI;
            }
        }
        lllllllllllllllIllllIIlIIlIllIII.transformDescriptor(lllllllllllllllIllllIIlIIlIlIllI);
    }

    public String getDefaultInjectorGroup() {
        MixinTargetContext lllllllllllllllIllllIIlIllIlIIIl;
        return lllllllllllllllIllllIIlIllIlIIIl.mixin.getParent().getDefaultInjectorGroup();
    }

    private void transformLVT(MethodNode lllllllllllllllIllllIIlIlIlIIIII) {
        if (lllllllllllllllIllllIIlIlIlIIIII.localVariables == null) {
            return;
        }
        for (LocalVariableNode lllllllllllllllIllllIIlIlIlIIIlI : lllllllllllllllIllllIIlIlIlIIIII.localVariables) {
            MixinTargetContext lllllllllllllllIllllIIlIlIIlllll;
            if (lllllllllllllllIllllIIlIlIlIIIlI == null || lllllllllllllllIllllIIlIlIlIIIlI.desc == null) continue;
            lllllllllllllllIllllIIlIlIlIIIlI.desc = lllllllllllllllIllllIIlIlIIlllll.transformSingleDescriptor(Type.getType(lllllllllllllllIllllIIlIlIlIIIlI.desc));
        }
    }

    private void transformFieldRef(MethodNode lllllllllllllllIllllIIlIlIIIIIII, Iterator<AbstractInsnNode> lllllllllllllllIllllIIlIIlllllll, MemberRef lllllllllllllllIllllIIlIIllllllI) {
        MixinTargetContext lllllllllllllllIllllIIlIlIIIIIIl;
        if ("super$".equals(lllllllllllllllIllllIIlIIllllllI.getName())) {
            if (lllllllllllllllIllllIIlIIllllllI instanceof MemberRef.Field) {
                lllllllllllllllIllllIIlIlIIIIIIl.processImaginarySuper(lllllllllllllllIllllIIlIlIIIIIII, ((MemberRef.Field)lllllllllllllllIllllIIlIIllllllI).insn);
                lllllllllllllllIllllIIlIIlllllll.remove();
            } else {
                throw new InvalidMixinException((IMixinInfo)lllllllllllllllIllllIIlIlIIIIIIl.mixin, "Cannot call imaginary super from method handle.");
            }
        }
        lllllllllllllllIllllIIlIlIIIIIIl.transformDescriptor(lllllllllllllllIllllIIlIIllllllI);
        if (lllllllllllllllIllllIIlIIllllllI.getOwner().equals(lllllllllllllllIllllIIlIlIIIIIIl.getClassRef())) {
            lllllllllllllllIllllIIlIIllllllI.setOwner(lllllllllllllllIllllIIlIlIIIIIIl.getTarget().getClassRef());
            ClassInfo.Field lllllllllllllllIllllIIlIlIIIlIII = lllllllllllllllIllllIIlIlIIIIIIl.getClassInfo().findField(lllllllllllllllIllllIIlIIllllllI.getName(), lllllllllllllllIllllIIlIIllllllI.getDesc(), 10);
            if (lllllllllllllllIllllIIlIlIIIlIII != null && lllllllllllllllIllllIIlIlIIIlIII.isRenamed() && lllllllllllllllIllllIIlIlIIIlIII.getOriginalName().equals(lllllllllllllllIllllIIlIIllllllI.getName()) && lllllllllllllllIllllIIlIlIIIlIII.isStatic()) {
                lllllllllllllllIllllIIlIIllllllI.setName(lllllllllllllllIllllIIlIlIIIlIII.getName());
            }
        } else {
            ClassInfo lllllllllllllllIllllIIlIlIIIIllI = ClassInfo.forName(lllllllllllllllIllllIIlIIllllllI.getOwner());
            if (lllllllllllllllIllllIIlIlIIIIllI.isMixin()) {
                ClassInfo lllllllllllllllIllllIIlIlIIIIlll = lllllllllllllllIllllIIlIlIIIIIIl.targetClassInfo.findCorrespondingType(lllllllllllllllIllllIIlIlIIIIllI);
                lllllllllllllllIllllIIlIIllllllI.setOwner(lllllllllllllllIllllIIlIlIIIIlll != null ? lllllllllllllllIllllIIlIlIIIIlll.getName() : lllllllllllllllIllllIIlIlIIIIIIl.getTarget().getClassRef());
            }
        }
    }
}

