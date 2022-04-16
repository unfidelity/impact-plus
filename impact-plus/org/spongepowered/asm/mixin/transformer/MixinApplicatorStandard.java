/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer;

import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.signature.SignatureReader;
import org.spongepowered.asm.lib.signature.SignatureVisitor;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.LineNumberNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.mixin.transformer.TargetClassContext;
import org.spongepowered.asm.mixin.transformer.meta.MixinMerged;
import org.spongepowered.asm.mixin.transformer.meta.MixinRenamed;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.ConstraintParser;
import org.spongepowered.asm.util.perf.Profiler;
import org.spongepowered.asm.util.throwables.ConstraintViolationException;
import org.spongepowered.asm.util.throwables.InvalidConstraintException;

class MixinApplicatorStandard {
    protected static final /* synthetic */ List<Class<? extends Annotation>> CONSTRAINED_ANNOTATIONS;
    protected final /* synthetic */ String targetName;
    protected static final /* synthetic */ int[] INITIALISER_OPCODE_BLACKLIST;
    protected final /* synthetic */ TargetClassContext context;
    protected final /* synthetic */ Logger logger;
    protected final /* synthetic */ Profiler profiler;
    protected final /* synthetic */ ClassNode targetClass;

    protected boolean isAlreadyMerged(MixinTargetContext lIIllllllllllI, MethodNode lIIlllllllllIl, boolean lIlIIIIIIIIlIl, MethodNode lIIlllllllllII) {
        MixinApplicatorStandard lIlIIIIIIIlIII;
        AnnotationNode lIlIIIIIIIIIll = Annotations.getVisible(lIIlllllllllII, MixinMerged.class);
        if (lIlIIIIIIIIIll == null) {
            if (Annotations.getVisible(lIIlllllllllII, Final.class) != null) {
                lIlIIIIIIIlIII.logger.warn("Overwrite prohibited for @Final method {} in {}. Skipping method.", new Object[]{lIIlllllllllIl.name, lIIllllllllllI});
                return true;
            }
            return false;
        }
        String lIlIIIIIIIIIlI = (String)Annotations.getValue(lIlIIIIIIIIIll, "sessionId");
        if (!lIlIIIIIIIlIII.context.getSessionId().equals(lIlIIIIIIIIIlI)) {
            throw new ClassFormatError(String.valueOf(new StringBuilder().append("Invalid @MixinMerged annotation found in").append(lIIllllllllllI).append(" at ").append(lIIlllllllllIl.name).append(" in ").append(lIlIIIIIIIlIII.targetClass.name)));
        }
        if (Bytecode.hasFlag(lIIlllllllllII, 4160) && Bytecode.hasFlag(lIIlllllllllIl, 4160)) {
            if (lIIllllllllllI.getEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
                lIlIIIIIIIlIII.logger.warn("Synthetic bridge method clash for {} in {}", new Object[]{lIIlllllllllIl.name, lIIllllllllllI});
            }
            return true;
        }
        String lIlIIIIIIIIIIl = (String)Annotations.getValue(lIlIIIIIIIIIll, "mixin");
        int lIlIIIIIIIIIII = (Integer)Annotations.getValue(lIlIIIIIIIIIll, "priority");
        if (lIlIIIIIIIIIII >= lIIllllllllllI.getPriority() && !lIlIIIIIIIIIIl.equals(lIIllllllllllI.getClassName())) {
            lIlIIIIIIIlIII.logger.warn("Method overwrite conflict for {} in {}, previously written by {}. Skipping method.", new Object[]{lIIlllllllllIl.name, lIIllllllllllI, lIlIIIIIIIIIIl});
            return true;
        }
        if (Annotations.getVisible(lIIlllllllllII, Final.class) != null) {
            lIlIIIIIIIlIII.logger.warn("Method overwrite conflict for @Final method {} in {} declared by {}. Skipping method.", new Object[]{lIIlllllllllIl.name, lIIllllllllllI, lIlIIIIIIIIIIl});
            return true;
        }
        return false;
    }

    protected void applyAccessors(MixinTargetContext lIIllIlIIIIIlI) {
        List<MethodNode> lIIllIlIIIIIIl = lIIllIlIIIIIlI.generateAccessors();
        for (MethodNode lIIllIlIIIIlIl : lIIllIlIIIIIIl) {
            MixinApplicatorStandard lIIllIlIIIIlII;
            if (lIIllIlIIIIlIl.name.startsWith("<")) continue;
            lIIllIlIIIIlII.mergeMethod(lIIllIlIIIIIlI, lIIllIlIIIIlIl);
        }
    }

    protected void checkMethodConstraints(MixinTargetContext lIIllIIlIIlIll, MethodNode lIIllIIlIIlIlI) {
        for (Class<? extends Annotation> lIIllIIlIIllIl : CONSTRAINED_ANNOTATIONS) {
            MixinApplicatorStandard lIIllIIlIIllII;
            AnnotationNode lIIllIIlIIlllI = Annotations.getVisible(lIIllIIlIIlIlI, lIIllIIlIIllIl);
            if (lIIllIIlIIlllI == null) continue;
            lIIllIIlIIllII.checkConstraints(lIIllIIlIIlIll, lIIllIIlIIlIlI, lIIllIIlIIlllI);
        }
    }

    protected final Deque<AbstractInsnNode> getInitialiser(MixinTargetContext lIIlllIlIlllII, MethodNode lIIlllIlIlIIIl) {
        MixinApplicatorStandard lIIlllIlIlIIll;
        Range lIIlllIlIllIlI = lIIlllIlIlIIll.getConstructorRange(lIIlllIlIlIIIl);
        if (!lIIlllIlIllIlI.isValid()) {
            return null;
        }
        int lIIlllIlIllIIl = 0;
        ArrayDeque<AbstractInsnNode> lIIlllIlIllIII = new ArrayDeque<AbstractInsnNode>();
        boolean lIIlllIlIlIlll = false;
        int lIIlllIlIlIllI = -1;
        LabelNode lIIlllIlIlIlIl = null;
        ListIterator<AbstractInsnNode> lIIlllIlIllllI = lIIlllIlIlIIIl.instructions.iterator(lIIlllIlIllIlI.marker);
        while (lIIlllIlIllllI.hasNext()) {
            AbstractInsnNode lIIlllIlIlllll = (AbstractInsnNode)lIIlllIlIllllI.next();
            if (lIIlllIlIlllll instanceof LineNumberNode) {
                lIIlllIlIllIIl = ((LineNumberNode)lIIlllIlIlllll).line;
                AbstractInsnNode lIIlllIllIIIlI = lIIlllIlIlIIIl.instructions.get(lIIlllIlIlIIIl.instructions.indexOf(lIIlllIlIlllll) + 1);
                if (lIIlllIlIllIIl == lIIlllIlIllIlI.end && lIIlllIllIIIlI.getOpcode() != 177) {
                    lIIlllIlIlIlll = true;
                    lIIlllIlIlIllI = 177;
                    continue;
                }
                lIIlllIlIlIlll = lIIlllIlIllIlI.excludes(lIIlllIlIllIIl);
                lIIlllIlIlIllI = -1;
                continue;
            }
            if (!lIIlllIlIlIlll) continue;
            if (lIIlllIlIlIlIl != null) {
                lIIlllIlIllIII.add(lIIlllIlIlIlIl);
                lIIlllIlIlIlIl = null;
            }
            if (lIIlllIlIlllll instanceof LabelNode) {
                lIIlllIlIlIlIl = (LabelNode)lIIlllIlIlllll;
                continue;
            }
            int lIIlllIllIIIII = lIIlllIlIlllll.getOpcode();
            if (lIIlllIllIIIII == lIIlllIlIlIllI) {
                lIIlllIlIlIllI = -1;
                continue;
            }
            for (int lIIlllIllIIIIl : INITIALISER_OPCODE_BLACKLIST) {
                if (lIIlllIllIIIII != lIIlllIllIIIIl) continue;
                throw new InvalidMixinException((IMixinContext)lIIlllIlIlllII, String.valueOf(new StringBuilder().append("Cannot handle ").append(Bytecode.getOpcodeName(lIIlllIllIIIII)).append(" opcode (0x").append(Integer.toHexString(lIIlllIllIIIII).toUpperCase()).append(") in class initialiser")));
            }
            lIIlllIlIllIII.add(lIIlllIlIlllll);
        }
        AbstractInsnNode lIIlllIlIlIlII = (AbstractInsnNode)lIIlllIlIllIII.peekLast();
        if (lIIlllIlIlIlII != null && lIIlllIlIlIlII.getOpcode() != 181) {
            throw new InvalidMixinException((IMixinContext)lIIlllIlIlllII, String.valueOf(new StringBuilder().append("Could not parse initialiser, expected 0xB5, found 0x").append(Integer.toHexString(lIIlllIlIlIlII.getOpcode())).append(" in ").append(lIIlllIlIlllII)));
        }
        return lIIlllIlIllIII;
    }

    protected void applyAttributes(MixinTargetContext lIlIIIIlllIIll) {
        MixinApplicatorStandard lIlIIIIlllIlII;
        if (lIlIIIIlllIIll.shouldSetSourceFile()) {
            lIlIIIIlllIlII.targetClass.sourceFile = lIlIIIIlllIIll.getSourceFile();
        }
        lIlIIIIlllIlII.targetClass.version = Math.max(lIlIIIIlllIlII.targetClass.version, lIlIIIIlllIIll.getMinRequiredClassVersion());
    }

    protected void applyInitialisers(MixinTargetContext lIIllllIlIlIlI) {
        MixinApplicatorStandard lIIllllIlIllll;
        MethodNode lIIllllIlIllIl = lIIllllIlIllll.getConstructor(lIIllllIlIlIlI);
        if (lIIllllIlIllIl == null) {
            return;
        }
        Deque<AbstractInsnNode> lIIllllIlIllII = lIIllllIlIllll.getInitialiser(lIIllllIlIlIlI, lIIllllIlIllIl);
        if (lIIllllIlIllII == null || lIIllllIlIllII.size() == 0) {
            return;
        }
        for (MethodNode lIIllllIllIIII : lIIllllIlIllll.targetClass.methods) {
            if (!"<init>".equals(lIIllllIllIIII.name)) continue;
            lIIllllIllIIII.maxStack = Math.max(lIIllllIllIIII.maxStack, lIIllllIlIllIl.maxStack);
            lIIllllIlIllll.injectInitialiser(lIIllllIlIlIlI, lIIllllIllIIII, lIIllllIlIllII);
        }
    }

    MixinApplicatorStandard(TargetClassContext lIlIIIlIllIlIl) {
        MixinApplicatorStandard lIlIIIlIllIllI;
        lIlIIIlIllIllI.logger = LogManager.getLogger((String)"mixin");
        lIlIIIlIllIllI.profiler = MixinEnvironment.getProfiler();
        lIlIIIlIllIllI.context = lIlIIIlIllIlIl;
        lIlIIIlIllIllI.targetName = lIlIIIlIllIlIl.getClassName();
        lIlIIIlIllIllI.targetClass = lIlIIIlIllIlIl.getClassNode();
    }

    protected void applyNormalMethod(MixinTargetContext lIlIIIIIlIIlIl, MethodNode lIlIIIIIlIIlll) {
        MixinApplicatorStandard lIlIIIIIlIlIIl;
        lIlIIIIIlIIlIl.transformMethod(lIlIIIIIlIIlll);
        if (!lIlIIIIIlIIlll.name.startsWith("<")) {
            lIlIIIIIlIlIIl.checkMethodVisibility(lIlIIIIIlIIlIl, lIlIIIIIlIIlll);
            lIlIIIIIlIlIIl.checkMethodConstraints(lIlIIIIIlIIlIl, lIlIIIIIlIIlll);
            lIlIIIIIlIlIIl.mergeMethod(lIlIIIIIlIIlIl, lIlIIIIIlIIlll);
        } else if ("<clinit>".equals(lIlIIIIIlIIlll.name)) {
            lIlIIIIIlIlIIl.appendInsns(lIlIIIIIlIIlIl, lIlIIIIIlIIlll);
        }
    }

    protected void displaceIntrinsic(MixinTargetContext lIIlllllIlIlII, MethodNode lIIlllllIlIIll, MethodNode lIIlllllIIlllI) {
        String lIIlllllIlIIIl = String.valueOf(new StringBuilder().append("proxy+").append(lIIlllllIIlllI.name));
        ListIterator<AbstractInsnNode> lIIlllllIlIllI = lIIlllllIlIIll.instructions.iterator();
        while (lIIlllllIlIllI.hasNext()) {
            MixinApplicatorStandard lIIlllllIlIIII;
            AbstractInsnNode lIIlllllIlIlll = (AbstractInsnNode)lIIlllllIlIllI.next();
            if (!(lIIlllllIlIlll instanceof MethodInsnNode) || lIIlllllIlIlll.getOpcode() == 184) continue;
            MethodInsnNode lIIlllllIllIII = (MethodInsnNode)lIIlllllIlIlll;
            if (!lIIlllllIllIII.owner.equals(lIIlllllIlIIII.targetClass.name) || !lIIlllllIllIII.name.equals(lIIlllllIIlllI.name) || !lIIlllllIllIII.desc.equals(lIIlllllIIlllI.desc)) continue;
            lIIlllllIllIII.name = lIIlllllIlIIIl;
        }
        lIIlllllIIlllI.name = lIIlllllIlIIIl;
    }

    protected final void appendInsns(MixinTargetContext lIIllllIllllll, MethodNode lIIllllIlllIll) {
        MixinApplicatorStandard lIIllllIllllII;
        if (Type.getReturnType(lIIllllIlllIll.desc) != Type.VOID_TYPE) {
            throw new IllegalArgumentException("Attempted to merge insns from a method which does not return void");
        }
        MethodNode lIIllllIllllIl = lIIllllIllllII.findTargetMethod(lIIllllIlllIll);
        if (lIIllllIllllIl != null) {
            AbstractInsnNode lIIlllllIIIIIl = Bytecode.findInsn(lIIllllIllllIl, 177);
            if (lIIlllllIIIIIl != null) {
                ListIterator<AbstractInsnNode> lIIlllllIIIIlI = lIIllllIlllIll.instructions.iterator();
                while (lIIlllllIIIIlI.hasNext()) {
                    AbstractInsnNode lIIlllllIIIIll = (AbstractInsnNode)lIIlllllIIIIlI.next();
                    if (lIIlllllIIIIll instanceof LineNumberNode || lIIlllllIIIIll.getOpcode() == 177) continue;
                    lIIllllIllllIl.instructions.insertBefore(lIIlllllIIIIIl, lIIlllllIIIIll);
                }
                lIIllllIllllIl.maxLocals = Math.max(lIIllllIllllIl.maxLocals, lIIllllIlllIll.maxLocals);
                lIIllllIllllIl.maxStack = Math.max(lIIllllIllllIl.maxStack, lIIllllIlllIll.maxStack);
            }
            return;
        }
        lIIllllIllllII.targetClass.methods.add(lIIllllIlllIll);
    }

    protected void applyShadowMethod(MixinTargetContext lIlIIIIIllIIlI, MethodNode lIlIIIIIlIlllI) {
        MixinApplicatorStandard lIlIIIIIllIIll;
        MethodNode lIlIIIIIllIIII = lIlIIIIIllIIll.findTargetMethod(lIlIIIIIlIlllI);
        if (lIlIIIIIllIIII != null) {
            Bytecode.mergeAnnotations(lIlIIIIIlIlllI, lIlIIIIIllIIII);
        }
    }

    protected void prepareInjections(MixinTargetContext lIIllIlIIlIIll) {
        lIIllIlIIlIIll.prepareInjections();
    }

    protected void mergeNewFields(MixinTargetContext lIlIIIIlIIIllI) {
        for (FieldNode lIlIIIIlIIlIlI : lIlIIIIlIIIllI.getFields()) {
            MixinApplicatorStandard lIlIIIIlIIlIIl;
            FieldNode lIlIIIIlIIlIll = lIlIIIIlIIlIIl.findTargetField(lIlIIIIlIIlIlI);
            if (lIlIIIIlIIlIll != null) continue;
            lIlIIIIlIIlIIl.targetClass.fields.add(lIlIIIIlIIlIlI);
        }
    }

    protected void checkMethodVisibility(MixinTargetContext lIIllIIlIlllII, MethodNode lIIllIIlIllIll) {
        if (Bytecode.hasFlag(lIIllIIlIllIll, 8) && !Bytecode.hasFlag(lIIllIIlIllIll, 2) && !Bytecode.hasFlag(lIIllIIlIllIll, 4096) && Annotations.getVisible(lIIllIIlIllIll, Overwrite.class) == null) {
            throw new InvalidMixinException((IMixinContext)lIIllIIlIlllII, String.format("Mixin %s contains non-private static method %s", lIIllIIlIlllII, lIIllIIlIllIll));
        }
    }

    private Range getConstructorRange(MethodNode lIIllllIIIlIIl) {
        MixinApplicatorStandard lIIllllIIIlIlI;
        boolean lIIllllIIIlIII = false;
        AbstractInsnNode lIIllllIIIIlll = null;
        int lIIllllIIIIllI = 0;
        int lIIllllIIIIlIl = 0;
        int lIIllllIIIIlII = 0;
        int lIIllllIIIIIll = -1;
        ListIterator<AbstractInsnNode> lIIllllIIIllII = lIIllllIIIlIIl.instructions.iterator();
        while (lIIllllIIIllII.hasNext()) {
            AbstractInsnNode lIIllllIIIllIl = (AbstractInsnNode)lIIllllIIIllII.next();
            if (lIIllllIIIllIl instanceof LineNumberNode) {
                lIIllllIIIIllI = ((LineNumberNode)lIIllllIIIllIl).line;
                lIIllllIIIlIII = true;
                continue;
            }
            if (lIIllllIIIllIl instanceof MethodInsnNode) {
                if (lIIllllIIIllIl.getOpcode() != 183 || !"<init>".equals(((MethodInsnNode)lIIllllIIIllIl).name) || lIIllllIIIIIll != -1) continue;
                lIIllllIIIIIll = lIIllllIIIlIIl.instructions.indexOf(lIIllllIIIllIl);
                lIIllllIIIIlIl = lIIllllIIIIllI;
                continue;
            }
            if (lIIllllIIIllIl.getOpcode() == 181) {
                lIIllllIIIlIII = false;
                continue;
            }
            if (lIIllllIIIllIl.getOpcode() != 177) continue;
            if (lIIllllIIIlIII) {
                lIIllllIIIIlII = lIIllllIIIIllI;
                continue;
            }
            lIIllllIIIIlII = lIIllllIIIIlIl;
            lIIllllIIIIlll = lIIllllIIIllIl;
        }
        if (lIIllllIIIIlll != null) {
            LabelNode lIIllllIIIlIll = new LabelNode(new Label());
            lIIllllIIIlIIl.instructions.insertBefore(lIIllllIIIIlll, lIIllllIIIlIll);
            lIIllllIIIlIIl.instructions.insertBefore(lIIllllIIIIlll, new LineNumberNode(lIIllllIIIIlIl, lIIllllIIIlIll));
        }
        return lIIllllIIIlIlI.new Range(lIIllllIIIIlIl, lIIllllIIIIlII, lIIllllIIIIIll);
    }

    protected final void applyMixin(MixinTargetContext lIlIIIlIIIlIIl, ApplicatorPass lIlIIIlIIIlIII) {
        switch (lIlIIIlIIIlIII) {
            case MAIN: {
                MixinApplicatorStandard lIlIIIlIIIlIlI;
                lIlIIIlIIIlIlI.applySignature(lIlIIIlIIIlIIl);
                lIlIIIlIIIlIlI.applyInterfaces(lIlIIIlIIIlIIl);
                lIlIIIlIIIlIlI.applyAttributes(lIlIIIlIIIlIIl);
                lIlIIIlIIIlIlI.applyAnnotations(lIlIIIlIIIlIIl);
                lIlIIIlIIIlIlI.applyFields(lIlIIIlIIIlIIl);
                lIlIIIlIIIlIlI.applyMethods(lIlIIIlIIIlIIl);
                lIlIIIlIIIlIlI.applyInitialisers(lIlIIIlIIIlIIl);
                break;
            }
            case PREINJECT: {
                MixinApplicatorStandard lIlIIIlIIIlIlI;
                lIlIIIlIIIlIlI.prepareInjections(lIlIIIlIIIlIIl);
                break;
            }
            case INJECT: {
                MixinApplicatorStandard lIlIIIlIIIlIlI;
                lIlIIIlIIIlIlI.applyAccessors(lIlIIIlIIIlIIl);
                lIlIIIlIIIlIlI.applyInjections(lIlIIIlIIIlIIl);
                break;
            }
            default: {
                throw new IllegalStateException(String.valueOf(new StringBuilder().append("Invalid pass specified ").append((Object)lIlIIIlIIIlIII)));
            }
        }
    }

    private InitialiserInjectionMode getInitialiserInjectionMode(MixinEnvironment lIIllIlIlIIllI) {
        String lIIllIlIlIlIlI = lIIllIlIlIIllI.getOptionValue(MixinEnvironment.Option.INITIALISER_INJECTION_MODE);
        if (lIIllIlIlIlIlI == null) {
            return InitialiserInjectionMode.DEFAULT;
        }
        try {
            return InitialiserInjectionMode.valueOf(lIIllIlIlIlIlI.toUpperCase());
        }
        catch (Exception lIIllIlIllIIII) {
            MixinApplicatorStandard lIIllIlIlIlIII;
            lIIllIlIlIlIII.logger.warn("Could not parse unexpected value \"{}\" for mixin.initialiserInjectionMode, reverting to DEFAULT", new Object[]{lIIllIlIlIlIlI});
            return InitialiserInjectionMode.DEFAULT;
        }
    }

    protected void applySourceMap(TargetClassContext lIIllIIlIlIlll) {
        lIIllIIlIlIllI.targetClass.sourceDebug = lIIllIIlIlIlll.getSourceMap().toString();
    }

    protected final void checkConstraints(MixinTargetContext lIIllIIIllIlll, MethodNode lIIllIIIllIllI, AnnotationNode lIIllIIIllIIIl) {
        try {
            ConstraintParser.Constraint lIIllIIIlllIlI = ConstraintParser.parse(lIIllIIIllIIIl);
            try {
                lIIllIIIlllIlI.check(lIIllIIIllIlll.getEnvironment());
            }
            catch (ConstraintViolationException lIIllIIIlllIll) {
                MixinApplicatorStandard lIIllIIIllIlII;
                String lIIllIIIllllII = String.format("Constraint violation: %s on %s in %s", lIIllIIIlllIll.getMessage(), lIIllIIIllIllI, lIIllIIIllIlll);
                lIIllIIIllIlII.logger.warn(lIIllIIIllllII);
                if (!lIIllIIIllIlll.getEnvironment().getOption(MixinEnvironment.Option.IGNORE_CONSTRAINTS)) {
                    throw new InvalidMixinException(lIIllIIIllIlll, lIIllIIIllllII, (Throwable)lIIllIIIlllIll);
                }
            }
        }
        catch (InvalidConstraintException lIIllIIIlllIIl) {
            throw new InvalidMixinException((IMixinContext)lIIllIIIllIlll, lIIllIIIlllIIl.getMessage());
        }
    }

    static {
        CONSTRAINED_ANNOTATIONS = ImmutableList.of(Overwrite.class, Inject.class, ModifyArg.class, ModifyArgs.class, Redirect.class, ModifyVariable.class, ModifyConstant.class);
        INITIALISER_OPCODE_BLACKLIST = new int[]{177, 21, 22, 23, 24, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 79, 80, 81, 82, 83, 84, 85, 86};
    }

    protected void mergeShadowFields(MixinTargetContext lIlIIIIlIlIlIl) {
        for (Map.Entry<FieldNode, ClassInfo.Field> lIlIIIIlIllIIl : lIlIIIIlIlIlIl.getShadowFields()) {
            MixinApplicatorStandard lIlIIIIlIlIllI;
            FieldNode lIlIIIIlIllIll = lIlIIIIlIllIIl.getKey();
            FieldNode lIlIIIIlIllIlI = lIlIIIIlIlIllI.findTargetField(lIlIIIIlIllIll);
            if (lIlIIIIlIllIlI == null) continue;
            Bytecode.mergeAnnotations(lIlIIIIlIllIll, lIlIIIIlIllIlI);
            if (!lIlIIIIlIllIIl.getValue().isDecoratedMutable() || Bytecode.hasFlag(lIlIIIIlIllIlI, 2)) continue;
            lIlIIIIlIllIlI.access &= 0xFFFFFFEF;
        }
    }

    private static String fieldKey(FieldInsnNode lIIllIlIIlllII) {
        return String.format("%s:%s", lIIllIlIIlllII.desc, lIIllIlIIlllII.name);
    }

    void apply(SortedSet<MixinInfo> lIlIIIlIIllllI) {
        MixinApplicatorStandard lIlIIIlIIlllll;
        ArrayList<MixinTargetContext> lIlIIIlIIlllIl = new ArrayList<MixinTargetContext>();
        for (MixinInfo mixinInfo : lIlIIIlIIllllI) {
            lIlIIIlIIlllll.logger.log(mixinInfo.getLoggingLevel(), "Mixing {} from {} into {}", new Object[]{mixinInfo.getName(), mixinInfo.getParent(), lIlIIIlIIlllll.targetName});
            lIlIIIlIIlllIl.add(mixinInfo.createContextFor(lIlIIIlIIlllll.context));
        }
        MixinTargetContext lIlIIIlIIlllII = null;
        try {
            Iterator iterator = lIlIIIlIIlllIl.iterator();
            while (iterator.hasNext()) {
                MixinTargetContext lIlIIIlIlIIllI;
                lIlIIIlIIlllII = lIlIIIlIlIIllI = (MixinTargetContext)iterator.next();
                lIlIIIlIIlllII.preApply(lIlIIIlIIlllll.targetName, lIlIIIlIIlllll.targetClass);
            }
            for (ApplicatorPass lIlIIIlIlIIIll : ApplicatorPass.values()) {
                Profiler.Section lIlIIIlIlIIlII = lIlIIIlIIlllll.profiler.begin("pass", lIlIIIlIlIIIll.name().toLowerCase());
                Iterator lIlIIIlIIlIIlI = lIlIIIlIIlllIl.iterator();
                while (lIlIIIlIIlIIlI.hasNext()) {
                    MixinTargetContext lIlIIIlIlIIlIl;
                    lIlIIIlIIlllII = lIlIIIlIlIIlIl = (MixinTargetContext)lIlIIIlIIlIIlI.next();
                    lIlIIIlIIlllll.applyMixin(lIlIIIlIIlllII, lIlIIIlIlIIIll);
                }
                lIlIIIlIlIIlII.end();
            }
            Iterator iterator2 = lIlIIIlIIlllIl.iterator();
            while (iterator2.hasNext()) {
                MixinTargetContext lIlIIIlIlIIIlI;
                lIlIIIlIIlllII = lIlIIIlIlIIIlI = (MixinTargetContext)iterator2.next();
                lIlIIIlIIlllII.postApply(lIlIIIlIIlllll.targetName, lIlIIIlIIlllll.targetClass);
            }
        }
        catch (InvalidMixinException invalidMixinException) {
            throw invalidMixinException;
        }
        catch (Exception exception) {
            throw new InvalidMixinException(lIlIIIlIIlllII, String.valueOf(new StringBuilder().append("Unexpecteded ").append(exception.getClass().getSimpleName()).append(" whilst applying the mixin class: ").append(exception.getMessage())), (Throwable)exception);
        }
        lIlIIIlIIlllll.applySourceMap(lIlIIIlIIlllll.context);
        lIlIIIlIIlllll.context.processDebugTasks();
    }

    protected void applySignature(MixinTargetContext lIlIIIlIIIIlII) {
        MixinApplicatorStandard lIlIIIlIIIIIll;
        lIlIIIlIIIIIll.context.mergeSignature(lIlIIIlIIIIlII.getSignature());
    }

    protected MethodNode getConstructor(MixinTargetContext lIIllllIIllllI) {
        MethodNode lIIllllIIlllIl = null;
        for (MethodNode lIIllllIlIIIII : lIIllllIIllllI.getMethods()) {
            MixinApplicatorStandard lIIllllIIlllII;
            if (!"<init>".equals(lIIllllIlIIIII.name) || !Bytecode.methodHasLineNumbers(lIIllllIlIIIII)) continue;
            if (lIIllllIIlllIl == null) {
                lIIllllIIlllIl = lIIllllIlIIIII;
                continue;
            }
            lIIllllIIlllII.logger.warn(String.format("Mixin %s has multiple constructors, %s was selected\n", lIIllllIIllllI, lIIllllIIlllIl.desc));
        }
        return lIIllllIIlllIl;
    }

    protected boolean mergeIntrinsic(MixinTargetContext lIIllllllIllIl, MethodNode lIIllllllIIlIl, boolean lIIllllllIlIll, MethodNode lIIllllllIIIll, AnnotationNode lIIllllllIIIlI) {
        MixinApplicatorStandard lIIllllllIlllI;
        AnnotationNode lIIllllllIllll;
        if (lIIllllllIlIll) {
            throw new InvalidMixinException((IMixinContext)lIIllllllIllIl, String.valueOf(new StringBuilder().append("@Intrinsic is not compatible with @Overwrite, remove one of these annotations on ").append(lIIllllllIIlIl.name).append(" in ").append(lIIllllllIllIl)));
        }
        String lIIllllllIlIII = String.valueOf(new StringBuilder().append(lIIllllllIIlIl.name).append(lIIllllllIIlIl.desc));
        if (Bytecode.hasFlag(lIIllllllIIlIl, 8)) {
            throw new InvalidMixinException((IMixinContext)lIIllllllIllIl, String.valueOf(new StringBuilder().append("@Intrinsic method cannot be static, found ").append(lIIllllllIlIII).append(" in ").append(lIIllllllIllIl)));
        }
        if (!(Bytecode.hasFlag(lIIllllllIIlIl, 4096) || (lIIllllllIllll = Annotations.getVisible(lIIllllllIIlIl, MixinRenamed.class)) != null && Annotations.getValue(lIIllllllIllll, "isInterfaceMember", Boolean.FALSE).booleanValue())) {
            throw new InvalidMixinException((IMixinContext)lIIllllllIllIl, String.valueOf(new StringBuilder().append("@Intrinsic method must be prefixed interface method, no rename encountered on ").append(lIIllllllIlIII).append(" in ").append(lIIllllllIllIl)));
        }
        if (!Annotations.getValue(lIIllllllIIIlI, "displace", Boolean.FALSE).booleanValue()) {
            lIIllllllIlllI.logger.log(lIIllllllIllIl.getLoggingLevel(), "Skipping Intrinsic mixin method {} for {}", new Object[]{lIIllllllIlIII, lIIllllllIllIl.getTargetClassRef()});
            return true;
        }
        lIIllllllIlllI.displaceIntrinsic(lIIllllllIllIl, lIIllllllIIlIl, lIIllllllIIIll);
        return false;
    }

    protected final FieldNode findTargetField(FieldNode lIIlIllllIllll) {
        MixinApplicatorStandard lIIlIllllIllIl;
        for (FieldNode lIIlIlllllIIIl : lIIlIllllIllIl.targetClass.fields) {
            if (!lIIlIlllllIIIl.name.equals(lIIlIllllIllll.name)) continue;
            return lIIlIlllllIIIl;
        }
        return null;
    }

    protected void applyFields(MixinTargetContext lIlIIIIllIIIlI) {
        MixinApplicatorStandard lIlIIIIllIIlIl;
        lIlIIIIllIIlIl.mergeShadowFields(lIlIIIIllIIIlI);
        lIlIIIIllIIlIl.mergeNewFields(lIlIIIIllIIIlI);
    }

    protected AbstractInsnNode findInitialiserInjectionPoint(MixinTargetContext lIIllIllIlIIII, MethodNode lIIllIllIllIII, Deque<AbstractInsnNode> lIIllIllIIlllI) {
        MixinApplicatorStandard lIIllIllIllIlI;
        HashSet<String> lIIllIllIlIllI = new HashSet<String>();
        for (AbstractInsnNode lIIllIlllIIlII : lIIllIllIIlllI) {
            if (lIIllIlllIIlII.getOpcode() != 181) continue;
            lIIllIllIlIllI.add(MixinApplicatorStandard.fieldKey((FieldInsnNode)lIIllIlllIIlII));
        }
        InitialiserInjectionMode lIIllIllIlIlIl = lIIllIllIllIlI.getInitialiserInjectionMode(lIIllIllIlIIII.getEnvironment());
        String lIIllIllIlIlII = lIIllIllIlIIII.getTargetClassInfo().getName();
        String lIIllIllIlIIll = lIIllIllIlIIII.getTargetClassInfo().getSuperName();
        AbstractInsnNode lIIllIllIlIIlI = null;
        ListIterator<AbstractInsnNode> lIIllIllIlllII = lIIllIllIllIII.instructions.iterator();
        while (lIIllIllIlllII.hasNext()) {
            String lIIllIlllIIIII;
            AbstractInsnNode lIIllIllIllllI = (AbstractInsnNode)lIIllIllIlllII.next();
            if (lIIllIllIllllI.getOpcode() == 183 && "<init>".equals(((MethodInsnNode)lIIllIllIllllI).name)) {
                String lIIllIlllIIIlI = ((MethodInsnNode)lIIllIllIllllI).owner;
                if (!lIIllIlllIIIlI.equals(lIIllIllIlIlII) && !lIIllIlllIIIlI.equals(lIIllIllIlIIll)) continue;
                lIIllIllIlIIlI = lIIllIllIllllI;
                if (lIIllIllIlIlIl != InitialiserInjectionMode.SAFE) continue;
                break;
            }
            if (lIIllIllIllllI.getOpcode() != 181 || lIIllIllIlIlIl != InitialiserInjectionMode.DEFAULT || !lIIllIllIlIllI.contains(lIIllIlllIIIII = MixinApplicatorStandard.fieldKey((FieldInsnNode)lIIllIllIllllI))) continue;
            lIIllIllIlIIlI = lIIllIllIllllI;
        }
        return lIIllIllIlIIlI;
    }

    protected void applyInterfaces(MixinTargetContext lIlIIIIllllIIl) {
        for (String lIlIIIIlllllIl : lIlIIIIllllIIl.getInterfaces()) {
            MixinApplicatorStandard lIlIIIIllllIlI;
            if (lIlIIIIllllIlI.targetClass.interfaces.contains(lIlIIIIlllllIl)) continue;
            lIlIIIIllllIlI.targetClass.interfaces.add(lIlIIIIlllllIl);
            lIlIIIIllllIIl.getTargetClassInfo().addInterface(lIlIIIIlllllIl);
        }
    }

    protected final void injectInitialiser(MixinTargetContext lIIlllIIlIlIII, MethodNode lIIlllIIlIIlll, Deque<AbstractInsnNode> lIIlllIIlIllII) {
        MixinApplicatorStandard lIIlllIIlIlIIl;
        Map<LabelNode, LabelNode> lIIlllIIlIlIll = Bytecode.cloneLabels(lIIlllIIlIIlll.instructions);
        AbstractInsnNode lIIlllIIlIlIlI = lIIlllIIlIlIIl.findInitialiserInjectionPoint(lIIlllIIlIlIII, lIIlllIIlIIlll, lIIlllIIlIllII);
        if (lIIlllIIlIlIlI == null) {
            lIIlllIIlIlIIl.logger.warn("Failed to locate initialiser injection point in <init>{}, initialiser was not mixed in.", new Object[]{lIIlllIIlIIlll.desc});
            return;
        }
        for (AbstractInsnNode lIIlllIIllIIII : lIIlllIIlIllII) {
            if (lIIlllIIllIIII instanceof LabelNode) continue;
            if (lIIlllIIllIIII instanceof JumpInsnNode) {
                throw new InvalidMixinException((IMixinContext)lIIlllIIlIlIII, String.valueOf(new StringBuilder().append("Unsupported JUMP opcode in initialiser in ").append(lIIlllIIlIlIII)));
            }
            AbstractInsnNode lIIlllIIllIIIl = lIIlllIIllIIII.clone(lIIlllIIlIlIll);
            lIIlllIIlIIlll.instructions.insert(lIIlllIIlIlIlI, lIIlllIIllIIIl);
            lIIlllIIlIlIlI = lIIlllIIllIIIl;
        }
    }

    protected void mergeMethod(MixinTargetContext lIlIIIIIIllIlI, MethodNode lIlIIIIIIlIlII) {
        MixinApplicatorStandard lIlIIIIIIlIllI;
        boolean lIlIIIIIIllIII = Annotations.getVisible(lIlIIIIIIlIlII, Overwrite.class) != null;
        MethodNode lIlIIIIIIlIlll = lIlIIIIIIlIllI.findTargetMethod(lIlIIIIIIlIlII);
        if (lIlIIIIIIlIlll != null) {
            if (lIlIIIIIIlIllI.isAlreadyMerged(lIlIIIIIIllIlI, lIlIIIIIIlIlII, lIlIIIIIIllIII, lIlIIIIIIlIlll)) {
                return;
            }
            AnnotationNode lIlIIIIIIlllIl = Annotations.getInvisible(lIlIIIIIIlIlII, Intrinsic.class);
            if (lIlIIIIIIlllIl != null) {
                if (lIlIIIIIIlIllI.mergeIntrinsic(lIlIIIIIIllIlI, lIlIIIIIIlIlII, lIlIIIIIIllIII, lIlIIIIIIlIlll, lIlIIIIIIlllIl)) {
                    lIlIIIIIIllIlI.getTarget().methodMerged(lIlIIIIIIlIlII);
                    return;
                }
            } else {
                if (lIlIIIIIIllIlI.requireOverwriteAnnotations() && !lIlIIIIIIllIII) {
                    throw new InvalidMixinException((IMixinContext)lIlIIIIIIllIlI, String.format("%s%s in %s cannot overwrite method in %s because @Overwrite is required by the parent configuration", lIlIIIIIIlIlII.name, lIlIIIIIIlIlII.desc, lIlIIIIIIllIlI, lIlIIIIIIllIlI.getTarget().getClassName()));
                }
                lIlIIIIIIlIllI.targetClass.methods.remove(lIlIIIIIIlIlll);
            }
        } else if (lIlIIIIIIllIII) {
            throw new InvalidMixinException((IMixinContext)lIlIIIIIIllIlI, String.format("Overwrite target \"%s\" was not located in target class %s", lIlIIIIIIlIlII.name, lIlIIIIIIllIlI.getTargetClassRef()));
        }
        lIlIIIIIIlIllI.targetClass.methods.add(lIlIIIIIIlIlII);
        lIlIIIIIIllIlI.methodMerged(lIlIIIIIIlIlII);
        if (lIlIIIIIIlIlII.signature != null) {
            SignatureVisitor lIlIIIIIIlllII = lIlIIIIIIllIlI.getSignature().getRemapper();
            new SignatureReader(lIlIIIIIIlIlII.signature).accept(lIlIIIIIIlllII);
            lIlIIIIIIlIlII.signature = lIlIIIIIIlllII.toString();
        }
    }

    protected void applyInjections(MixinTargetContext lIIllIlIIIlllI) {
        lIIllIlIIIlllI.applyInjections();
    }

    protected void applyMethods(MixinTargetContext lIlIIIIIlllIll) {
        MixinApplicatorStandard lIlIIIIIllllII;
        for (MethodNode lIlIIIIIlllllI : lIlIIIIIlllIll.getShadowMethods()) {
            lIlIIIIIllllII.applyShadowMethod(lIlIIIIIlllIll, lIlIIIIIlllllI);
        }
        for (MethodNode lIlIIIIIllllIl : lIlIIIIIlllIll.getMethods()) {
            lIlIIIIIllllII.applyNormalMethod(lIlIIIIIlllIll, lIlIIIIIllllIl);
        }
    }

    protected void applyAnnotations(MixinTargetContext lIlIIIIllIllII) {
        MixinApplicatorStandard lIlIIIIllIllIl;
        ClassNode lIlIIIIllIlIll = lIlIIIIllIllII.getClassNode();
        Bytecode.mergeAnnotations(lIlIIIIllIlIll, lIlIIIIllIllIl.targetClass);
    }

    protected final MethodNode findTargetMethod(MethodNode lIIllIIIIIlIlI) {
        MixinApplicatorStandard lIIllIIIIlIIII;
        for (MethodNode lIIllIIIIlIIlI : lIIllIIIIlIIII.targetClass.methods) {
            if (!lIIllIIIIlIIlI.name.equals(lIIllIIIIIlIlI.name) || !lIIllIIIIlIIlI.desc.equals(lIIllIIIIIlIlI.desc)) continue;
            return lIIllIIIIlIIlI;
        }
        return null;
    }

    static enum ApplicatorPass {
        MAIN,
        PREINJECT,
        INJECT;


        private ApplicatorPass() {
            ApplicatorPass llllllllllllllllIllIlIlIlllIlllI;
        }
    }

    class Range {
        final /* synthetic */ int end;
        final /* synthetic */ int marker;
        final /* synthetic */ int start;

        boolean contains(int lllllllllllllllllIlIlIIIIlllIlII) {
            Range lllllllllllllllllIlIlIIIIlllIllI;
            return lllllllllllllllllIlIlIIIIlllIlII >= lllllllllllllllllIlIlIIIIlllIllI.start && lllllllllllllllllIlIlIIIIlllIlII <= lllllllllllllllllIlIlIIIIlllIllI.end;
        }

        public String toString() {
            Range lllllllllllllllllIlIlIIIIllIIIlI;
            return String.format("Range[%d-%d,%d,valid=%s)", lllllllllllllllllIlIlIIIIllIIIlI.start, lllllllllllllllllIlIlIIIIllIIIlI.end, lllllllllllllllllIlIlIIIIllIIIlI.marker, lllllllllllllllllIlIlIIIIllIIIlI.isValid());
        }

        boolean isValid() {
            Range lllllllllllllllllIlIlIIIlIIIlIII;
            return lllllllllllllllllIlIlIIIlIIIlIII.start != 0 && lllllllllllllllllIlIlIIIlIIIlIII.end != 0 && lllllllllllllllllIlIlIIIlIIIlIII.end >= lllllllllllllllllIlIlIIIlIIIlIII.start;
        }

        boolean excludes(int lllllllllllllllllIlIlIIIIllIlIll) {
            Range lllllllllllllllllIlIlIIIIllIlIlI;
            return lllllllllllllllllIlIlIIIIllIlIll < lllllllllllllllllIlIlIIIIllIlIlI.start || lllllllllllllllllIlIlIIIIllIlIll > lllllllllllllllllIlIlIIIIllIlIlI.end;
        }

        Range(int lllllllllllllllllIlIlIIIlIIllIII, int lllllllllllllllllIlIlIIIlIIlIIlI, int lllllllllllllllllIlIlIIIlIIlIllI) {
            Range lllllllllllllllllIlIlIIIlIIlIlIl;
            lllllllllllllllllIlIlIIIlIIlIlIl.start = lllllllllllllllllIlIlIIIlIIllIII;
            lllllllllllllllllIlIlIIIlIIlIlIl.end = lllllllllllllllllIlIlIIIlIIlIIlI;
            lllllllllllllllllIlIlIIIlIIlIlIl.marker = lllllllllllllllllIlIlIIIlIIlIllI;
        }
    }

    static enum InitialiserInjectionMode {
        DEFAULT,
        SAFE;


        private InitialiserInjectionMode() {
            InitialiserInjectionMode llllllllllllllllllIIlIIIIlIllIII;
        }
    }
}

