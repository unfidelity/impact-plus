/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer;

import com.google.common.base.Strings;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.ListIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.gen.throwables.InvalidAccessorException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.InterfaceInfo;
import org.spongepowered.asm.mixin.transformer.MethodMapper;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.mixin.transformer.TargetClassContext;
import org.spongepowered.asm.mixin.transformer.meta.MixinRenamed;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.perf.Profiler;
import org.spongepowered.asm.util.throwables.SyntheticBridgeException;

class MixinPreProcessorStandard {
    private static final /* synthetic */ Logger logger;
    private /* synthetic */ boolean prepared;
    private final /* synthetic */ boolean verboseLogging;
    protected final /* synthetic */ Profiler profiler;
    protected final /* synthetic */ MixinEnvironment env;
    protected final /* synthetic */ MixinInfo.MixinClassNode classNode;
    private /* synthetic */ boolean attached;
    private final /* synthetic */ boolean strictUnique;
    protected final /* synthetic */ MixinInfo mixin;

    MixinPreProcessorStandard(MixinInfo lIIIIIllIlIIl, MixinInfo.MixinClassNode lIIIIIllIlIII) {
        MixinPreProcessorStandard lIIIIIllIIlll;
        lIIIIIllIIlll.profiler = MixinEnvironment.getProfiler();
        lIIIIIllIIlll.mixin = lIIIIIllIlIIl;
        lIIIIIllIIlll.classNode = lIIIIIllIlIII;
        lIIIIIllIIlll.env = lIIIIIllIlIIl.getParent().getEnvironment();
        lIIIIIllIIlll.verboseLogging = lIIIIIllIIlll.env.getOption(MixinEnvironment.Option.DEBUG_VERBOSE);
        lIIIIIllIIlll.strictUnique = lIIIIIllIIlll.env.getOption(MixinEnvironment.Option.DEBUG_UNIQUE);
    }

    protected void prepareMethod(MixinInfo.MixinMethodNode lIIIIIIllIIlI, ClassInfo.Method lIIIIIIllIIIl) {
        MixinPreProcessorStandard lIIIIIIllIIll;
        lIIIIIIllIIll.prepareShadow(lIIIIIIllIIlI, lIIIIIIllIIIl);
        lIIIIIIllIIll.prepareSoftImplements(lIIIIIIllIIlI, lIIIIIIllIIIl);
    }

    protected static String getDynamicInfo(MethodNode llIllIIllIll) {
        return MixinPreProcessorStandard.getDynamicInfo("Method", Annotations.getInvisible(llIllIIllIll, Dynamic.class));
    }

    private static String getDynamicInfo(String llIllIIlIIlI, AnnotationNode llIllIIIllIl) {
        String llIllIIlIIII = Strings.nullToEmpty((String)((String)Annotations.getValue(llIllIIIllIl)));
        Type llIllIIIllll = (Type)Annotations.getValue(llIllIIIllIl, "mixin");
        if (llIllIIIllll != null) {
            llIllIIlIIII = String.format("{%s} %s", llIllIIIllll.getClassName(), llIllIIlIIII).trim();
        }
        return llIllIIlIIII.length() > 0 ? String.format(" %s is @Dynamic(%s)", llIllIIlIIlI, llIllIIlIIII) : "";
    }

    protected void prepareShadow(MixinInfo.MixinMethodNode lIIIIIIIIllll, ClassInfo.Method lIIIIIIIlIlll) {
        AnnotationNode lIIIIIIIlIlII = Annotations.getVisible(lIIIIIIIIllll, Shadow.class);
        if (lIIIIIIIlIlII == null) {
            return;
        }
        String lIIIIIIIlIIlI = (String)Annotations.getValue(lIIIIIIIlIlII, "prefix", Shadow.class);
        if (lIIIIIIIIllll.name.startsWith(lIIIIIIIlIIlI)) {
            Annotations.setVisible(lIIIIIIIIllll, MixinRenamed.class, "originalName", lIIIIIIIIllll.name);
            String lIIIIIIIlllll = lIIIIIIIIllll.name.substring(lIIIIIIIlIIlI.length());
            lIIIIIIIIllll.name = lIIIIIIIlIlll.renameTo(lIIIIIIIlllll);
        }
    }

    protected void attachFields(MixinTargetContext lllIIIIlIlII) {
        MixinPreProcessorStandard lllIIIIlIlll;
        Iterator lllIIIIllIII = lllIIIIlIlll.classNode.fields.iterator();
        while (lllIIIIllIII.hasNext()) {
            boolean lllIIIIllIll;
            FieldNode lllIIIIlllIl = (FieldNode)lllIIIIllIII.next();
            AnnotationNode lllIIIIlllII = Annotations.getVisible(lllIIIIlllIl, Shadow.class);
            boolean bl = lllIIIIllIll = lllIIIIlllII != null;
            if (!lllIIIIlIlll.validateField(lllIIIIlIlII, lllIIIIlllIl, lllIIIIlllII)) {
                lllIIIIllIII.remove();
                continue;
            }
            ClassInfo.Field lllIIIIllIlI = lllIIIIlIlll.mixin.getClassInfo().findField(lllIIIIlllIl);
            lllIIIIlIlII.transformDescriptor(lllIIIIlllIl);
            lllIIIIllIlI.remapTo(lllIIIIlllIl.desc);
            if (lllIIIIllIlI.isUnique() && lllIIIIllIll) {
                throw new InvalidMixinException((IMixinInfo)lllIIIIlIlll.mixin, String.format("@Shadow field %s cannot be @Unique", lllIIIIlllIl.name));
            }
            FieldNode lllIIIIllIIl = lllIIIIlIlII.findField(lllIIIIlllIl, lllIIIIlllII);
            if (lllIIIIllIIl == null) {
                if (lllIIIIlllII == null) continue;
                lllIIIIllIIl = lllIIIIlIlII.findRemappedField(lllIIIIlllIl);
                if (lllIIIIllIIl == null) {
                    throw new InvalidMixinException((IMixinInfo)lllIIIIlIlll.mixin, String.format("Shadow field %s was not located in the target class %s. %s%s", lllIIIIlllIl.name, lllIIIIlIlII.getTarget(), lllIIIIlIlII.getReferenceMapper().getStatus(), MixinPreProcessorStandard.getDynamicInfo(lllIIIIlllIl)));
                }
                lllIIIIlllIl.name = lllIIIIllIlI.renameTo(lllIIIIllIIl.name);
            }
            if (!Bytecode.compareFlags(lllIIIIlllIl, lllIIIIllIIl, 8)) {
                throw new InvalidMixinException((IMixinInfo)lllIIIIlIlll.mixin, String.format("STATIC modifier of @Shadow field %s in %s does not match the target", lllIIIIlllIl.name, lllIIIIlIlll.mixin));
            }
            if (lllIIIIllIlI.isUnique()) {
                if ((lllIIIIlllIl.access & 6) != 0) {
                    String lllIIIlIIIII = lllIIIIlIlII.getUniqueName(lllIIIIlllIl);
                    logger.log(lllIIIIlIlll.mixin.getLoggingLevel(), "Renaming @Unique field {}{} to {} in {}", new Object[]{lllIIIIlllIl.name, lllIIIIlllIl.desc, lllIIIlIIIII, lllIIIIlIlll.mixin});
                    lllIIIIlllIl.name = lllIIIIllIlI.renameTo(lllIIIlIIIII);
                    continue;
                }
                if (lllIIIIlIlll.strictUnique) {
                    throw new InvalidMixinException((IMixinInfo)lllIIIIlIlll.mixin, String.format("Field conflict, @Unique field %s in %s cannot overwrite %s%s in %s", lllIIIIlllIl.name, lllIIIIlIlll.mixin, lllIIIIllIIl.name, lllIIIIllIIl.desc, lllIIIIlIlII.getTarget()));
                }
                logger.warn("Discarding @Unique public field {} in {} because it already exists in {}. Note that declared FIELD INITIALISERS will NOT be removed!", new Object[]{lllIIIIlllIl.name, lllIIIIlIlll.mixin, lllIIIIlIlII.getTarget()});
                lllIIIIllIII.remove();
                continue;
            }
            if (!lllIIIIllIIl.desc.equals(lllIIIIlllIl.desc)) {
                throw new InvalidMixinException((IMixinInfo)lllIIIIlIlll.mixin, String.format("The field %s in the target class has a conflicting signature", lllIIIIlllIl.name));
            }
            if (!lllIIIIllIIl.name.equals(lllIIIIlllIl.name)) {
                if ((lllIIIIllIIl.access & 2) == 0 && (lllIIIIllIIl.access & 0x1000) == 0) {
                    throw new InvalidMixinException((IMixinInfo)lllIIIIlIlll.mixin, String.valueOf(new StringBuilder().append("Non-private field cannot be aliased. Found ").append(lllIIIIllIIl.name)));
                }
                lllIIIIlllIl.name = lllIIIIllIlI.renameTo(lllIIIIllIIl.name);
            }
            lllIIIIllIII.remove();
            if (!lllIIIIllIll) continue;
            boolean lllIIIIllllI = lllIIIIllIlI.isDecoratedFinal();
            if (lllIIIIlIlll.verboseLogging && Bytecode.hasFlag(lllIIIIllIIl, 16) != lllIIIIllllI) {
                String lllIIIIlllll = lllIIIIllllI ? "@Shadow field {}::{} is decorated with @Final but target is not final" : "@Shadow target {}::{} is final but shadow is not decorated with @Final";
                logger.warn(lllIIIIlllll, new Object[]{lllIIIIlIlll.mixin, lllIIIIlllIl.name});
            }
            lllIIIIlIlII.addShadowField(lllIIIIlllIl, lllIIIIllIlI);
        }
    }

    final MixinPreProcessorStandard prepare() {
        MixinPreProcessorStandard lIIIIIlIlIIII;
        if (lIIIIIlIlIIII.prepared) {
            return lIIIIIlIlIIII;
        }
        lIIIIIlIlIIII.prepared = true;
        Profiler.Section lIIIIIlIIllll = lIIIIIlIlIIII.profiler.begin("prepare");
        for (MixinInfo.MixinMethodNode lIIIIIlIlIIll : lIIIIIlIlIIII.classNode.mixinMethods) {
            ClassInfo.Method lIIIIIlIlIlIl = lIIIIIlIlIIII.mixin.getClassInfo().findMethod(lIIIIIlIlIIll);
            lIIIIIlIlIIII.prepareMethod(lIIIIIlIlIIll, lIIIIIlIlIlIl);
        }
        for (FieldNode lIIIIIlIlIIlI : lIIIIIlIlIIII.classNode.fields) {
            lIIIIIlIlIIII.prepareField(lIIIIIlIlIIlI);
        }
        lIIIIIlIIllll.end();
        return lIIIIIlIlIIII;
    }

    protected static String getDynamicInfo(FieldNode llIllIIllIII) {
        return MixinPreProcessorStandard.getDynamicInfo("Field", Annotations.getInvisible(llIllIIllIII, Dynamic.class));
    }

    final MixinPreProcessorStandard conform(ClassInfo lllllIllllIl) {
        MixinPreProcessorStandard lllllIlllllI;
        Profiler.Section lllllIllllII = lllllIlllllI.profiler.begin("conform");
        for (MixinInfo.MixinMethodNode lllllIllllll : lllllIlllllI.classNode.mixinMethods) {
            if (!lllllIllllll.isInjector()) continue;
            ClassInfo.Method llllllIIIIII = lllllIlllllI.mixin.getClassInfo().findMethod(lllllIllllll, 10);
            lllllIlllllI.conformInjector(lllllIllllIl, lllllIllllll, llllllIIIIII);
        }
        lllllIllllII.end();
        return lllllIlllllI;
    }

    protected boolean attachOverwriteMethod(MixinTargetContext llllIIIlllII, MixinInfo.MixinMethodNode llllIIIlllll) {
        MixinPreProcessorStandard llllIIIllllI;
        return llllIIIllllI.attachSpecialMethod(llllIIIlllII, llllIIIlllll, SpecialMethod.OVERWRITE);
    }

    final MixinPreProcessorStandard conform(TargetClassContext llllllIIllll) {
        MixinPreProcessorStandard llllllIlIIII;
        return llllllIlIIII.conform(llllllIIllll.getClassInfo());
    }

    protected void attachMethod(MixinTargetContext lllIIlllIIII, MixinInfo.MixinMethodNode lllIIllIllll) {
        MethodNode lllIIlllIIlI;
        MixinPreProcessorStandard lllIIlllIIIl;
        ClassInfo.Method lllIIlllIlII = lllIIlllIIIl.mixin.getClassInfo().findMethod(lllIIllIllll);
        if (lllIIlllIlII == null) {
            return;
        }
        ClassInfo.Method lllIIlllIIll = lllIIlllIIIl.mixin.getClassInfo().findMethodInHierarchy(lllIIllIllll, ClassInfo.SearchType.SUPER_CLASSES_ONLY);
        if (lllIIlllIIll != null && lllIIlllIIll.isRenamed()) {
            lllIIllIllll.name = lllIIlllIlII.renameTo(lllIIlllIIll.getName());
        }
        if ((lllIIlllIIlI = lllIIlllIIII.findMethod(lllIIllIllll, null)) != null) {
            lllIIlllIIIl.conformVisibility(lllIIlllIIII, lllIIllIllll, SpecialMethod.MERGE, lllIIlllIIlI);
        }
    }

    protected boolean validateMethod(MixinTargetContext lllllIIIIIIl, MixinInfo.MixinMethodNode lllllIIIIIII) {
        return true;
    }

    final MixinPreProcessorStandard attach(MixinTargetContext lllllIIlIlII) {
        MixinPreProcessorStandard lllllIIllIIl;
        if (lllllIIllIIl.attached) {
            throw new IllegalStateException("Preprocessor was already attached");
        }
        lllllIIllIIl.attached = true;
        Profiler.Section lllllIIlIlll = lllllIIllIIl.profiler.begin("attach");
        Profiler.Section lllllIIlIllI = lllllIIllIIl.profiler.begin("methods");
        lllllIIllIIl.attachMethods(lllllIIlIlII);
        lllllIIlIllI = lllllIIlIllI.next("fields");
        lllllIIllIIl.attachFields(lllllIIlIlII);
        lllllIIlIllI = lllllIIlIllI.next("transform");
        lllllIIllIIl.transform(lllllIIlIlII);
        lllllIIlIllI.end();
        lllllIIlIlll.end();
        return lllllIIllIIl;
    }

    protected boolean validateField(MixinTargetContext llIllllIIllI, FieldNode llIllllIIlII, AnnotationNode llIllllIIIlI) {
        if (Bytecode.hasFlag(llIllllIIlII, 8) && !Bytecode.hasFlag(llIllllIIlII, 2) && !Bytecode.hasFlag(llIllllIIlII, 4096) && llIllllIIIlI == null) {
            throw new InvalidMixinException((IMixinContext)llIllllIIllI, String.format("Mixin %s contains non-private static field %s:%s", llIllllIIllI, llIllllIIlII.name, llIllllIIlII.desc));
        }
        String llIllllIlIlI = (String)Annotations.getValue(llIllllIIIlI, "prefix", Shadow.class);
        if (llIllllIIlII.name.startsWith(llIllllIlIlI)) {
            throw new InvalidMixinException((IMixinContext)llIllllIIllI, String.format("@Shadow field %s.%s has a shadow prefix. This is not allowed.", llIllllIIllI, llIllllIIlII.name));
        }
        if ("super$".equals(llIllllIIlII.name)) {
            MixinPreProcessorStandard llIllllIlIII;
            if (llIllllIIlII.access != 2) {
                throw new InvalidMixinException((IMixinInfo)llIllllIlIII.mixin, String.format("Imaginary super field %s.%s must be private and non-final", llIllllIIllI, llIllllIIlII.name));
            }
            if (!llIllllIIlII.desc.equals(String.valueOf(new StringBuilder().append("L").append(llIllllIlIII.mixin.getClassRef()).append(";")))) {
                throw new InvalidMixinException((IMixinInfo)llIllllIlIII.mixin, String.format("Imaginary super field %s.%s must have the same type as the parent mixin (%s)", llIllllIIllI, llIllllIIlII.name, llIllllIlIII.mixin.getClassName()));
            }
            return false;
        }
        return true;
    }

    protected void attachMethods(MixinTargetContext lllllIIIIlll) {
        MixinPreProcessorStandard lllllIIIIllI;
        Iterator<MixinInfo.MixinMethodNode> lllllIIIlIIl = lllllIIIIllI.classNode.mixinMethods.iterator();
        while (lllllIIIlIIl.hasNext()) {
            MixinInfo.MixinMethodNode lllllIIIlIlI = lllllIIIlIIl.next();
            if (!lllllIIIIllI.validateMethod(lllllIIIIlll, lllllIIIlIlI)) {
                lllllIIIlIIl.remove();
                continue;
            }
            if (lllllIIIIllI.attachInjectorMethod(lllllIIIIlll, lllllIIIlIlI)) {
                lllllIIIIlll.addMixinMethod(lllllIIIlIlI);
                continue;
            }
            if (lllllIIIIllI.attachAccessorMethod(lllllIIIIlll, lllllIIIlIlI)) {
                lllllIIIlIIl.remove();
                continue;
            }
            if (lllllIIIIllI.attachShadowMethod(lllllIIIIlll, lllllIIIlIlI)) {
                lllllIIIIlll.addShadowMethod(lllllIIIlIlI);
                lllllIIIlIIl.remove();
                continue;
            }
            if (lllllIIIIllI.attachOverwriteMethod(lllllIIIIlll, lllllIIIlIlI)) {
                lllllIIIIlll.addMixinMethod(lllllIIIlIlI);
                continue;
            }
            if (lllllIIIIllI.attachUniqueMethod(lllllIIIIlll, lllllIIIlIlI)) {
                lllllIIIlIIl.remove();
                continue;
            }
            lllllIIIIllI.attachMethod(lllllIIIIlll, lllllIIIlIlI);
            lllllIIIIlll.addMixinMethod(lllllIIIlIlI);
        }
    }

    protected ClassInfo.Method getSpecialMethod(MixinInfo.MixinMethodNode lllIlIllllII, SpecialMethod lllIlIlllIll) {
        MixinPreProcessorStandard lllIlIllllIl;
        ClassInfo.Method lllIlIlllllI = lllIlIllllIl.mixin.getClassInfo().findMethod(lllIlIllllII, 10);
        lllIlIllllIl.checkMethodNotUnique(lllIlIlllllI, lllIlIlllIll);
        return lllIlIlllllI;
    }

    MixinTargetContext createContextFor(TargetClassContext lllllIlIIIlI) {
        MixinPreProcessorStandard lllllIlIIIII;
        MixinTargetContext lllllIlIIIIl = new MixinTargetContext(lllllIlIIIII.mixin, lllllIlIIIII.classNode, lllllIlIIIlI);
        lllllIlIIIII.conform(lllllIlIIIlI);
        lllllIlIIIII.attach(lllllIlIIIIl);
        return lllllIlIIIIl;
    }

    protected void transformField(FieldInsnNode llIllIlIIIII) {
        MixinPreProcessorStandard llIllIlIIllI;
        Profiler.Section llIllIlIIlII = llIllIlIIllI.profiler.begin("meta");
        ClassInfo llIllIlIIIll = ClassInfo.forName(llIllIlIIIII.owner);
        if (llIllIlIIIll == null) {
            throw new RuntimeException(new ClassNotFoundException(llIllIlIIIII.owner.replace('/', '.')));
        }
        ClassInfo.Field llIllIlIIIlI = llIllIlIIIll.findField(llIllIlIIIII, 2);
        llIllIlIIlII.end();
        if (llIllIlIIIlI != null && llIllIlIIIlI.isRenamed()) {
            llIllIlIIIII.name = llIllIlIIIlI.getName();
        }
    }

    protected void prepareField(FieldNode llllllIlIIll) {
    }

    protected boolean attachAccessorMethod(MixinTargetContext llllIlllIIII, MixinInfo.MixinMethodNode llllIlllIIlI) {
        MixinPreProcessorStandard llllIlllIlII;
        return llllIlllIlII.attachAccessorMethod(llllIlllIIII, llllIlllIIlI, SpecialMethod.ACCESSOR) || llllIlllIlII.attachAccessorMethod(llllIlllIIII, llllIlllIIlI, SpecialMethod.INVOKER);
    }

    private void conformVisibility(MixinTargetContext lllIllIIllII, MixinInfo.MixinMethodNode lllIllIIlIll, SpecialMethod lllIllIlIIlI, MethodNode lllIllIlIIIl) {
        MixinPreProcessorStandard lllIllIIllIl;
        Bytecode.Visibility lllIllIlIIII = Bytecode.getVisibility(lllIllIlIIIl);
        Bytecode.Visibility lllIllIIllll = Bytecode.getVisibility(lllIllIIlIll);
        if (lllIllIIllll.ordinal() >= lllIllIlIIII.ordinal()) {
            if (lllIllIlIIII == Bytecode.Visibility.PRIVATE && lllIllIIllll.ordinal() > Bytecode.Visibility.PRIVATE.ordinal()) {
                lllIllIIllII.getTarget().addUpgradedMethod(lllIllIlIIIl);
            }
            return;
        }
        String lllIllIIlllI = String.format("%s %s method %s in %s cannot reduce visibiliy of %s target method", new Object[]{lllIllIIllll, lllIllIlIIlI, lllIllIIlIll.name, lllIllIIllIl.mixin, lllIllIlIIII});
        if (lllIllIlIIlI.isOverwrite && !lllIllIIllIl.mixin.getParent().conformOverwriteVisibility()) {
            throw new InvalidMixinException((IMixinInfo)lllIllIIllIl.mixin, lllIllIIlllI);
        }
        if (lllIllIIllll == Bytecode.Visibility.PRIVATE) {
            if (lllIllIlIIlI.isOverwrite) {
                logger.warn("Static binding violation: {}, visibility will be upgraded.", new Object[]{lllIllIIlllI});
            }
            lllIllIIllII.addUpgradedMethod(lllIllIIlIll);
            Bytecode.setVisibility((MethodNode)lllIllIIlIll, lllIllIlIIII);
        }
    }

    protected boolean attachUniqueMethod(MixinTargetContext lllIlIIIIlII, MixinInfo.MixinMethodNode lllIlIIIIIll) {
        String lllIlIIIIlll;
        MethodNode lllIlIIIlIII;
        MixinPreProcessorStandard lllIlIIIllII;
        ClassInfo.Method lllIlIIIlIIl = lllIlIIIllII.mixin.getClassInfo().findMethod(lllIlIIIIIll, 10);
        if (lllIlIIIlIIl == null || !lllIlIIIlIIl.isUnique() && !lllIlIIIllII.mixin.isUnique() && !lllIlIIIlIIl.isSynthetic()) {
            return false;
        }
        if (lllIlIIIlIIl.isSynthetic()) {
            lllIlIIIIlII.transformDescriptor(lllIlIIIIIll);
            lllIlIIIlIIl.remapTo(lllIlIIIIIll.desc);
        }
        if ((lllIlIIIlIII = lllIlIIIIlII.findMethod(lllIlIIIIIll, null)) == null) {
            return false;
        }
        String string = lllIlIIIIlll = lllIlIIIlIIl.isSynthetic() ? "synthetic" : "@Unique";
        if (Bytecode.getVisibility(lllIlIIIIIll).ordinal() < Bytecode.Visibility.PUBLIC.ordinal()) {
            String lllIlIIIlllI = lllIlIIIIlII.getUniqueName(lllIlIIIIIll, false);
            logger.log(lllIlIIIllII.mixin.getLoggingLevel(), "Renaming {} method {}{} to {} in {}", new Object[]{lllIlIIIIlll, lllIlIIIIIll.name, lllIlIIIIIll.desc, lllIlIIIlllI, lllIlIIIllII.mixin});
            lllIlIIIIIll.name = lllIlIIIlIIl.renameTo(lllIlIIIlllI);
            return false;
        }
        if (lllIlIIIllII.strictUnique) {
            throw new InvalidMixinException((IMixinInfo)lllIlIIIllII.mixin, String.format("Method conflict, %s method %s in %s cannot overwrite %s%s in %s", lllIlIIIIlll, lllIlIIIIIll.name, lllIlIIIllII.mixin, lllIlIIIlIII.name, lllIlIIIlIII.desc, lllIlIIIIlII.getTarget()));
        }
        AnnotationNode lllIlIIIIllI = Annotations.getVisible(lllIlIIIIIll, Unique.class);
        if (lllIlIIIIllI == null || !Annotations.getValue(lllIlIIIIllI, "silent", Boolean.FALSE).booleanValue()) {
            if (Bytecode.hasFlag(lllIlIIIIIll, 64)) {
                try {
                    Bytecode.compareBridgeMethods(lllIlIIIlIII, lllIlIIIIIll);
                    logger.debug("Discarding sythetic bridge method {} in {} because existing method in {} is compatible", new Object[]{lllIlIIIIlll, lllIlIIIIIll.name, lllIlIIIllII.mixin, lllIlIIIIlII.getTarget()});
                    return true;
                }
                catch (SyntheticBridgeException lllIlIIIllIl) {
                    if (lllIlIIIllII.verboseLogging || lllIlIIIllII.env.getOption(MixinEnvironment.Option.DEBUG_VERIFY)) {
                        lllIlIIIllIl.printAnalysis(lllIlIIIIlII, lllIlIIIlIII, lllIlIIIIIll);
                    }
                    throw new InvalidMixinException((IMixinInfo)lllIlIIIllII.mixin, lllIlIIIllIl.getMessage());
                }
            }
            logger.warn("Discarding {} public method {} in {} because it already exists in {}", new Object[]{lllIlIIIIlll, lllIlIIIIIll.name, lllIlIIIllII.mixin, lllIlIIIIlII.getTarget()});
            return true;
        }
        lllIlIIIIlII.addMixinMethod(lllIlIIIIIll);
        return true;
    }

    private void conformInjector(ClassInfo lllllIlIlIlI, MixinInfo.MixinMethodNode lllllIlIlllI, ClassInfo.Method lllllIlIlIII) {
        MixinPreProcessorStandard lllllIlIlIll;
        MethodMapper lllllIlIllII = lllllIlIlIlI.getMethodMapper();
        lllllIlIllII.remapHandlerMethod(lllllIlIlIll.mixin, lllllIlIlllI, lllllIlIlIII);
    }

    protected boolean attachInjectorMethod(MixinTargetContext llllIlllllIl, MixinInfo.MixinMethodNode llllIlllllII) {
        return llllIlllllII.isInjector();
    }

    protected void checkMethodNotUnique(ClassInfo.Method lllIlIllIIlI, SpecialMethod lllIlIllIlII) {
        if (lllIlIllIIlI.isUnique()) {
            MixinPreProcessorStandard lllIlIllIllI;
            throw new InvalidMixinException((IMixinInfo)lllIlIllIllI.mixin, String.format("%s method %s in %s cannot be @Unique", new Object[]{lllIlIllIlII, lllIlIllIIlI.getName(), lllIlIllIllI.mixin}));
        }
    }

    protected boolean attachSpecialMethod(MixinTargetContext lllIlllIlIlI, MixinInfo.MixinMethodNode lllIlllIlIIl, SpecialMethod lllIlllIIIIl) {
        MixinPreProcessorStandard lllIlllIIlII;
        AnnotationNode lllIlllIIlll = lllIlllIlIIl.getVisibleAnnotation(lllIlllIIIIl.annotation);
        if (lllIlllIIlll == null) {
            return false;
        }
        if (lllIlllIIIIl.isOverwrite) {
            lllIlllIIlII.checkMixinNotUnique(lllIlllIlIIl, lllIlllIIIIl);
        }
        ClassInfo.Method lllIlllIIllI = lllIlllIIlII.getSpecialMethod(lllIlllIlIIl, lllIlllIIIIl);
        MethodNode lllIlllIIlIl = lllIlllIlIlI.findMethod(lllIlllIlIIl, lllIlllIIlll);
        if (lllIlllIIlIl == null) {
            if (lllIlllIIIIl.isOverwrite) {
                return false;
            }
            lllIlllIIlIl = lllIlllIlIlI.findRemappedMethod(lllIlllIlIIl);
            if (lllIlllIIlIl == null) {
                throw new InvalidMixinException((IMixinInfo)lllIlllIIlII.mixin, String.format("%s method %s in %s was not located in the target class %s. %s%s", new Object[]{lllIlllIIIIl, lllIlllIlIIl.name, lllIlllIIlII.mixin, lllIlllIlIlI.getTarget(), lllIlllIlIlI.getReferenceMapper().getStatus(), MixinPreProcessorStandard.getDynamicInfo(lllIlllIlIIl)}));
            }
            lllIlllIlIIl.name = lllIlllIIllI.renameTo(lllIlllIIlIl.name);
        }
        if ("<init>".equals(lllIlllIIlIl.name)) {
            throw new InvalidMixinException((IMixinInfo)lllIlllIIlII.mixin, String.format("Nice try! %s in %s cannot alias a constructor", lllIlllIlIIl.name, lllIlllIIlII.mixin));
        }
        if (!Bytecode.compareFlags(lllIlllIlIIl, lllIlllIIlIl, 8)) {
            throw new InvalidMixinException((IMixinInfo)lllIlllIIlII.mixin, String.format("STATIC modifier of %s method %s in %s does not match the target", new Object[]{lllIlllIIIIl, lllIlllIlIIl.name, lllIlllIIlII.mixin}));
        }
        lllIlllIIlII.conformVisibility(lllIlllIlIlI, lllIlllIlIIl, lllIlllIIIIl, lllIlllIIlIl);
        if (!lllIlllIIlIl.name.equals(lllIlllIlIIl.name)) {
            if (lllIlllIIIIl.isOverwrite && (lllIlllIIlIl.access & 2) == 0) {
                throw new InvalidMixinException((IMixinInfo)lllIlllIIlII.mixin, String.valueOf(new StringBuilder().append("Non-private method cannot be aliased. Found ").append(lllIlllIIlIl.name)));
            }
            lllIlllIlIIl.name = lllIlllIIllI.renameTo(lllIlllIIlIl.name);
        }
        return true;
    }

    protected boolean attachAccessorMethod(MixinTargetContext llllIlIIIIII, MixinInfo.MixinMethodNode llllIIlllllI, SpecialMethod llllIlIIIlll) {
        MixinPreProcessorStandard llllIlIIlIlI;
        AnnotationNode llllIlIIIllI = llllIIlllllI.getVisibleAnnotation(llllIlIIIlll.annotation);
        if (llllIlIIIllI == null) {
            return false;
        }
        String llllIlIIIlIl = String.valueOf(new StringBuilder().append((Object)llllIlIIIlll).append(" method ").append(llllIIlllllI.name));
        ClassInfo.Method llllIlIIIIll = llllIlIIlIlI.getSpecialMethod(llllIIlllllI, llllIlIIIlll);
        if (MixinEnvironment.getCompatibilityLevel().isAtLeast(MixinEnvironment.CompatibilityLevel.JAVA_8) && llllIlIIIIll.isStatic()) {
            if (llllIlIIlIlI.mixin.getTargets().size() > 1) {
                throw new InvalidAccessorException((IMixinContext)llllIlIIIIII, String.valueOf(new StringBuilder().append(llllIlIIIlIl).append(" in multi-target mixin is invalid. Mixin must have exactly 1 target.")));
            }
            String llllIlIIlIll = llllIlIIIIII.getUniqueName(llllIIlllllI, true);
            logger.log(llllIlIIlIlI.mixin.getLoggingLevel(), "Renaming @Unique method {}{} to {} in {}", new Object[]{llllIIlllllI.name, llllIIlllllI.desc, llllIlIIlIll, llllIlIIlIlI.mixin});
            llllIIlllllI.name = llllIlIIIIll.renameTo(llllIlIIlIll);
        } else {
            if (!llllIlIIIIll.isAbstract()) {
                throw new InvalidAccessorException((IMixinContext)llllIlIIIIII, String.valueOf(new StringBuilder().append(llllIlIIIlIl).append(" is not abstract")));
            }
            if (llllIlIIIIll.isStatic()) {
                throw new InvalidAccessorException((IMixinContext)llllIlIIIIII, String.valueOf(new StringBuilder().append(llllIlIIIlIl).append(" cannot be static")));
            }
        }
        llllIlIIIIII.addAccessorMethod(llllIIlllllI, llllIlIIIlll.annotation);
        return true;
    }

    static {
        logger = LogManager.getLogger((String)"mixin");
    }

    protected void transform(MixinTargetContext llIlllIIlllI) {
        MixinPreProcessorStandard llIlllIIllII;
        for (MethodNode llIlllIlIIIl : llIlllIIllII.classNode.methods) {
            ListIterator<AbstractInsnNode> llIlllIlIIll = llIlllIlIIIl.instructions.iterator();
            while (llIlllIlIIll.hasNext()) {
                AbstractInsnNode llIlllIlIlIl = (AbstractInsnNode)llIlllIlIIll.next();
                if (llIlllIlIlIl instanceof MethodInsnNode) {
                    llIlllIIllII.transformMethod((MethodInsnNode)llIlllIlIlIl);
                    continue;
                }
                if (!(llIlllIlIlIl instanceof FieldInsnNode)) continue;
                llIlllIIllII.transformField((FieldInsnNode)llIlllIlIlIl);
            }
        }
    }

    protected boolean attachShadowMethod(MixinTargetContext llllIIlIllII, MixinInfo.MixinMethodNode llllIIlIlIlI) {
        MixinPreProcessorStandard llllIIlIlllI;
        return llllIIlIlllI.attachSpecialMethod(llllIIlIllII, llllIIlIlIlI, SpecialMethod.SHADOW);
    }

    protected void prepareSoftImplements(MixinInfo.MixinMethodNode lllllllIIIll, ClassInfo.Method lllllllIlIIl) {
        MixinPreProcessorStandard lllllllIIlll;
        for (InterfaceInfo llllllllIIII : lllllllIIlll.mixin.getSoftImplements()) {
            if (!llllllllIIII.renameMethod(lllllllIIIll)) continue;
            lllllllIlIIl.renameTo(lllllllIIIll.name);
        }
    }

    protected void checkMixinNotUnique(MixinInfo.MixinMethodNode lllIlIlIllII, SpecialMethod lllIlIlIlIll) {
        MixinPreProcessorStandard lllIlIlIlIlI;
        if (lllIlIlIlIlI.mixin.isUnique()) {
            throw new InvalidMixinException((IMixinInfo)lllIlIlIlIlI.mixin, String.format("%s method %s found in a @Unique mixin %s", new Object[]{lllIlIlIlIll, lllIlIlIllII.name, lllIlIlIlIlI.mixin}));
        }
    }

    protected void transformMethod(MethodInsnNode llIllIllIlII) {
        MixinPreProcessorStandard llIllIllIlIl;
        Profiler.Section llIllIllIIll = llIllIllIlIl.profiler.begin("meta");
        ClassInfo llIllIllIIlI = ClassInfo.forName(llIllIllIlII.owner);
        if (llIllIllIIlI == null) {
            throw new RuntimeException(new ClassNotFoundException(llIllIllIlII.owner.replace('/', '.')));
        }
        ClassInfo.Method llIllIllIIIl = llIllIllIIlI.findMethodInHierarchy(llIllIllIlII, ClassInfo.SearchType.ALL_CLASSES, 2);
        llIllIllIIll.end();
        if (llIllIllIIIl != null && llIllIllIIIl.isRenamed()) {
            llIllIllIlII.name = llIllIllIIIl.getName();
        }
    }

    static enum SpecialMethod {
        MERGE(true),
        OVERWRITE(true, Overwrite.class),
        SHADOW(false, Shadow.class),
        ACCESSOR(false, Accessor.class),
        INVOKER(false, Invoker.class);

        final /* synthetic */ boolean isOverwrite;
        final /* synthetic */ Class<? extends Annotation> annotation;
        final /* synthetic */ String description;

        private SpecialMethod(boolean llllllllllllllllllIllIllIlllIllI, Class<? extends Annotation> llllllllllllllllllIllIllIlllIIII) {
            SpecialMethod llllllllllllllllllIllIllIlllIlII;
            llllllllllllllllllIllIllIlllIlII.isOverwrite = llllllllllllllllllIllIllIlllIllI;
            llllllllllllllllllIllIllIlllIlII.annotation = llllllllllllllllllIllIllIlllIIII;
            llllllllllllllllllIllIllIlllIlII.description = String.valueOf(new StringBuilder().append("@").append(Bytecode.getSimpleName(llllllllllllllllllIllIllIlllIIII)));
        }

        private SpecialMethod(boolean llllllllllllllllllIllIllIlIllIIl) {
            SpecialMethod llllllllllllllllllIllIllIlIlIlll;
            llllllllllllllllllIllIllIlIlIlll.isOverwrite = llllllllllllllllllIllIllIlIllIIl;
            llllllllllllllllllIllIllIlIlIlll.annotation = null;
            llllllllllllllllllIllIllIlIlIlll.description = "overwrite";
        }

        public String toString() {
            SpecialMethod llllllllllllllllllIllIllIlIIlIll;
            return llllllllllllllllllIllIllIlIIlIll.description;
        }
    }
}

