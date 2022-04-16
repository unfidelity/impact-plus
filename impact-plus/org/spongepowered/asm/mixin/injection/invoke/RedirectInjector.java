/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Joiner
 *  com.google.common.collect.ObjectArrays
 *  com.google.common.primitives.Ints
 */
package org.spongepowered.asm.mixin.injection.invoke;

import com.google.common.base.Joiner;
import com.google.common.collect.ObjectArrays;
import com.google.common.primitives.Ints;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.invoke.InvokeInjector;
import org.spongepowered.asm.mixin.injection.points.BeforeFieldAccess;
import org.spongepowered.asm.mixin.injection.points.BeforeNew;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;

public class RedirectInjector
extends InvokeInjector {
    private static final /* synthetic */ String KEY_WILD;
    protected /* synthetic */ Meta meta;
    private static final /* synthetic */ String KEY_OPCODE;
    private static final /* synthetic */ String KEY_FUZZ;
    private static final /* synthetic */ String KEY_NOMINATORS;
    private /* synthetic */ Map<BeforeNew, ConstructorRedirectData> ctorRedirectors;

    public RedirectInjector(InjectionInfo lllllllllllllllllllIIlIIllllIIlI) {
        lllllllllllllllllllIIlIIllllIIIl(lllllllllllllllllllIIlIIllllIIlI, "@Redirect");
        RedirectInjector lllllllllllllllllllIIlIIllllIIIl;
    }

    protected boolean checkDescriptor(String lllllllllllllllllllIIIllIIlIllII, Target lllllllllllllllllllIIIllIIlIIIII, String lllllllllllllllllllIIIllIIIlllll) {
        RedirectInjector lllllllllllllllllllIIIllIIlIIIll;
        if (lllllllllllllllllllIIIllIIlIIIll.methodNode.desc.equals(lllllllllllllllllllIIIllIIlIllII)) {
            return false;
        }
        int lllllllllllllllllllIIIllIIlIIlll = lllllllllllllllllllIIIllIIlIllII.indexOf(41);
        String lllllllllllllllllllIIIllIIlIIlIl = String.format("%s%s%s", lllllllllllllllllllIIIllIIlIllII.substring(0, lllllllllllllllllllIIIllIIlIIlll), Joiner.on((String)"").join((Object[])lllllllllllllllllllIIIllIIlIIIII.arguments), lllllllllllllllllllIIIllIIlIllII.substring(lllllllllllllllllllIIIllIIlIIlll));
        if (lllllllllllllllllllIIIllIIlIIIll.methodNode.desc.equals(lllllllllllllllllllIIIllIIlIIlIl)) {
            return true;
        }
        throw new InvalidInjectionException(lllllllllllllllllllIIIllIIlIIIll.info, String.valueOf(new StringBuilder().append(lllllllllllllllllllIIIllIIlIIIll.annotationType).append(" method ").append(lllllllllllllllllllIIIllIIIlllll).append(" ").append(lllllllllllllllllllIIIllIIlIIIll).append(" has an invalid signature. Expected ").append(lllllllllllllllllllIIIllIIlIllII).append(" but found ").append(lllllllllllllllllllIIIllIIlIIIll.methodNode.desc)));
    }

    private void injectAtSetArray(Target lllllllllllllllllllIIIllllllllll, FieldInsnNode lllllllllllllllllllIIIllllllIllI, AbstractInsnNode lllllllllllllllllllIIIllllllIlIl, Type lllllllllllllllllllIIIllllllllII, Type lllllllllllllllllllIIIllllllIlII) {
        RedirectInjector lllllllllllllllllllIIlIIIIIIIIII;
        String lllllllllllllllllllIIIlllllllIlI = Bytecode.generateDescriptor(null, RedirectInjector.getArrayArgs(lllllllllllllllllllIIIllllllIlII, 1, lllllllllllllllllllIIIllllllIlII.getElementType()));
        boolean lllllllllllllllllllIIIlllllllIIl = lllllllllllllllllllIIlIIIIIIIIII.checkDescriptor(lllllllllllllllllllIIIlllllllIlI, lllllllllllllllllllIIIllllllllll, "array setter");
        lllllllllllllllllllIIlIIIIIIIIII.injectArrayRedirect(lllllllllllllllllllIIIllllllllll, lllllllllllllllllllIIIllllllIllI, lllllllllllllllllllIIIllllllIlIl, lllllllllllllllllllIIIlllllllIIl, "array setter");
    }

    private AbstractInsnNode injectAtPutField(InsnList lllllllllllllllllllIIIllIlIlIlII, Target lllllllllllllllllllIIIllIlIIlIlI, FieldInsnNode lllllllllllllllllllIIIllIlIlIIlI, boolean lllllllllllllllllllIIIllIlIIlIIl, Type lllllllllllllllllllIIIllIlIIlIII, Type lllllllllllllllllllIIIllIlIIllll) {
        RedirectInjector lllllllllllllllllllIIIllIlIlIlIl;
        String lllllllllllllllllllIIIllIlIIlllI = lllllllllllllllllllIIIllIlIIlIIl ? Bytecode.generateDescriptor(null, lllllllllllllllllllIIIllIlIIllll) : Bytecode.generateDescriptor(null, lllllllllllllllllllIIIllIlIIlIII, lllllllllllllllllllIIIllIlIIllll);
        boolean lllllllllllllllllllIIIllIlIIllIl = lllllllllllllllllllIIIllIlIlIlIl.checkDescriptor(lllllllllllllllllllIIIllIlIIlllI, lllllllllllllllllllIIIllIlIIlIlI, "setter");
        if (!lllllllllllllllllllIIIllIlIlIlIl.isStatic) {
            if (lllllllllllllllllllIIIllIlIIlIIl) {
                lllllllllllllllllllIIIllIlIlIlII.add(new VarInsnNode(25, 0));
                lllllllllllllllllllIIIllIlIlIlII.add(new InsnNode(95));
            } else {
                int lllllllllllllllllllIIIllIlIlIllI = lllllllllllllllllllIIIllIlIIlIlI.allocateLocals(lllllllllllllllllllIIIllIlIIllll.getSize());
                lllllllllllllllllllIIIllIlIlIlII.add(new VarInsnNode(lllllllllllllllllllIIIllIlIIllll.getOpcode(54), lllllllllllllllllllIIIllIlIlIllI));
                lllllllllllllllllllIIIllIlIlIlII.add(new VarInsnNode(25, 0));
                lllllllllllllllllllIIIllIlIlIlII.add(new InsnNode(95));
                lllllllllllllllllllIIIllIlIlIlII.add(new VarInsnNode(lllllllllllllllllllIIIllIlIIllll.getOpcode(21), lllllllllllllllllllIIIllIlIlIllI));
            }
        }
        if (lllllllllllllllllllIIIllIlIIllIl) {
            lllllllllllllllllllIIIllIlIlIlIl.pushArgs(lllllllllllllllllllIIIllIlIIlIlI.arguments, lllllllllllllllllllIIIllIlIlIlII, lllllllllllllllllllIIIllIlIIlIlI.getArgIndices(), 0, lllllllllllllllllllIIIllIlIIlIlI.arguments.length);
            lllllllllllllllllllIIIllIlIIlIlI.addToStack(Bytecode.getArgsSize(lllllllllllllllllllIIIllIlIIlIlI.arguments));
        }
        lllllllllllllllllllIIIllIlIIlIlI.addToStack(!lllllllllllllllllllIIIllIlIlIlIl.isStatic && !lllllllllllllllllllIIIllIlIIlIIl ? 1 : 0);
        return lllllllllllllllllllIIIllIlIlIlIl.invokeHandler(lllllllllllllllllllIIIllIlIlIlII);
    }

    private ConstructorRedirectData getCtorRedirect(BeforeNew lllllllllllllllllllIIlIIlIllIIlI) {
        RedirectInjector lllllllllllllllllllIIlIIlIllIllI;
        ConstructorRedirectData lllllllllllllllllllIIlIIlIllIlII = lllllllllllllllllllIIlIIlIllIllI.ctorRedirectors.get(lllllllllllllllllllIIlIIlIllIIlI);
        if (lllllllllllllllllllIIlIIlIllIlII == null) {
            lllllllllllllllllllIIlIIlIllIlII = lllllllllllllllllllIIlIIlIllIllI.new ConstructorRedirectData();
            lllllllllllllllllllIIlIIlIllIllI.ctorRedirectors.put(lllllllllllllllllllIIlIIlIllIIlI, lllllllllllllllllllIIlIIlIllIlII);
        }
        return lllllllllllllllllllIIlIIlIllIlII;
    }

    @Override
    protected void checkTarget(Target lllllllllllllllllllIIlIIllIlllll) {
    }

    public void injectAtScalarField(Target lllllllllllllllllllIIIlllIlIllll, FieldInsnNode lllllllllllllllllllIIIlllIllllIl, int lllllllllllllllllllIIIlllIlllIll, Type lllllllllllllllllllIIIlllIlIlIll, Type lllllllllllllllllllIIIlllIllIlll) {
        RedirectInjector lllllllllllllllllllIIIlllIllIIIl;
        AbstractInsnNode lllllllllllllllllllIIIlllIllIlIl = null;
        InsnList lllllllllllllllllllIIIlllIllIIll = new InsnList();
        if (lllllllllllllllllllIIIlllIlllIll == 178 || lllllllllllllllllllIIIlllIlllIll == 180) {
            lllllllllllllllllllIIIlllIllIlIl = lllllllllllllllllllIIIlllIllIIIl.injectAtGetField(lllllllllllllllllllIIIlllIllIIll, lllllllllllllllllllIIIlllIlIllll, lllllllllllllllllllIIIlllIllllIl, lllllllllllllllllllIIIlllIlllIll == 178, lllllllllllllllllllIIIlllIlIlIll, lllllllllllllllllllIIIlllIllIlll);
        } else if (lllllllllllllllllllIIIlllIlllIll == 179 || lllllllllllllllllllIIIlllIlllIll == 181) {
            lllllllllllllllllllIIIlllIllIlIl = lllllllllllllllllllIIIlllIllIIIl.injectAtPutField(lllllllllllllllllllIIIlllIllIIll, lllllllllllllllllllIIIlllIlIllll, lllllllllllllllllllIIIlllIllllIl, lllllllllllllllllllIIIlllIlllIll == 179, lllllllllllllllllllIIIlllIlIlIll, lllllllllllllllllllIIIlllIllIlll);
        } else {
            throw new InvalidInjectionException(lllllllllllllllllllIIIlllIllIIIl.info, String.valueOf(new StringBuilder().append("Unspported opcode ").append(Bytecode.getOpcodeName(lllllllllllllllllllIIIlllIlllIll)).append(" for ").append(lllllllllllllllllllIIIlllIllIIIl.info)));
        }
        lllllllllllllllllllIIIlllIlIllll.replaceNode(lllllllllllllllllllIIIlllIllllIl, lllllllllllllllllllIIIlllIllIlIl, lllllllllllllllllllIIIlllIllIIll);
    }

    public void injectArrayRedirect(Target lllllllllllllllllllIIIllllIlllIl, FieldInsnNode lllllllllllllllllllIIIllllIlllII, AbstractInsnNode lllllllllllllllllllIIIlllllIIIll, boolean lllllllllllllllllllIIIlllllIIIlI, String lllllllllllllllllllIIIlllllIIIIl) {
        RedirectInjector lllllllllllllllllllIIIllllIlllll;
        if (lllllllllllllllllllIIIlllllIIIll == null) {
            String lllllllllllllllllllIIIlllllIlIIl = "";
            throw new InvalidInjectionException(lllllllllllllllllllIIIllllIlllll.info, String.valueOf(new StringBuilder().append("Array element ").append(lllllllllllllllllllIIIllllIlllll.annotationType).append(" on ").append(lllllllllllllllllllIIIllllIlllll).append(" could not locate a matching ").append(lllllllllllllllllllIIIlllllIIIIl).append(" instruction in ").append(lllllllllllllllllllIIIllllIlllIl).append(". ").append(lllllllllllllllllllIIIlllllIlIIl)));
        }
        if (!lllllllllllllllllllIIIllllIlllll.isStatic) {
            lllllllllllllllllllIIIllllIlllIl.insns.insertBefore((AbstractInsnNode)lllllllllllllllllllIIIllllIlllII, new VarInsnNode(25, 0));
            lllllllllllllllllllIIIllllIlllIl.addToStack(1);
        }
        InsnList lllllllllllllllllllIIIlllllIIIII = new InsnList();
        if (lllllllllllllllllllIIIlllllIIIlI) {
            lllllllllllllllllllIIIllllIlllll.pushArgs(lllllllllllllllllllIIIllllIlllIl.arguments, lllllllllllllllllllIIIlllllIIIII, lllllllllllllllllllIIIllllIlllIl.getArgIndices(), 0, lllllllllllllllllllIIIllllIlllIl.arguments.length);
            lllllllllllllllllllIIIllllIlllIl.addToStack(Bytecode.getArgsSize(lllllllllllllllllllIIIllllIlllIl.arguments));
        }
        lllllllllllllllllllIIIllllIlllIl.replaceNode(lllllllllllllllllllIIIlllllIIIll, lllllllllllllllllllIIIllllIlllll.invokeHandler(lllllllllllllllllllIIIlllllIIIII), lllllllllllllllllllIIIlllllIIIII);
    }

    private void injectAtGetArray(Target lllllllllllllllllllIIlIIIIIlIlIl, FieldInsnNode lllllllllllllllllllIIlIIIIIlIlII, AbstractInsnNode lllllllllllllllllllIIlIIIIIlIIll, Type lllllllllllllllllllIIlIIIIIlIIlI, Type lllllllllllllllllllIIlIIIIIIlIlI) {
        RedirectInjector lllllllllllllllllllIIlIIIIIIlllI;
        String lllllllllllllllllllIIlIIIIIlIIII = RedirectInjector.getGetArrayHandlerDescriptor(lllllllllllllllllllIIlIIIIIlIIll, lllllllllllllllllllIIlIIIIIIlllI.returnType, lllllllllllllllllllIIlIIIIIIlIlI);
        boolean lllllllllllllllllllIIlIIIIIIllll = lllllllllllllllllllIIlIIIIIIlllI.checkDescriptor(lllllllllllllllllllIIlIIIIIlIIII, lllllllllllllllllllIIlIIIIIlIlIl, "array getter");
        lllllllllllllllllllIIlIIIIIIlllI.injectArrayRedirect(lllllllllllllllllllIIlIIIIIlIlIl, lllllllllllllllllllIIlIIIIIlIlII, lllllllllllllllllllIIlIIIIIlIIll, lllllllllllllllllllIIlIIIIIIllll, "array getter");
    }

    @Override
    protected void addTargetNode(Target lllllllllllllllllllIIlIIllIIlllI, List<InjectionNodes.InjectionNode> lllllllllllllllllllIIlIIllIIllIl, AbstractInsnNode lllllllllllllllllllIIlIIllIIllII, Set<InjectionPoint> lllllllllllllllllllIIlIIllIIIIIl) {
        RedirectInjector lllllllllllllllllllIIlIIllIIIlIl;
        Object lllllllllllllllllllIIlIIllIlIIlI;
        InjectionNodes.InjectionNode lllllllllllllllllllIIlIIllIIlIlI = lllllllllllllllllllIIlIIllIIlllI.getInjectionNode(lllllllllllllllllllIIlIIllIIllII);
        ConstructorRedirectData lllllllllllllllllllIIlIIllIIlIIl = null;
        int lllllllllllllllllllIIlIIllIIlIII = 8;
        int lllllllllllllllllllIIlIIllIIIlll = 0;
        if (lllllllllllllllllllIIlIIllIIlIlI != null && (lllllllllllllllllllIIlIIllIlIIlI = (Meta)lllllllllllllllllllIIlIIllIIlIlI.getDecoration("redirector")) != null && ((Meta)lllllllllllllllllllIIlIIllIlIIlI).getOwner() != lllllllllllllllllllIIlIIllIIIlIl) {
            if (((Meta)lllllllllllllllllllIIlIIllIlIIlI).priority >= lllllllllllllllllllIIlIIllIIIlIl.meta.priority) {
                Injector.logger.warn("{} conflict. Skipping {} with priority {}, already redirected by {} with priority {}", new Object[]{lllllllllllllllllllIIlIIllIIIlIl.annotationType, lllllllllllllllllllIIlIIllIIIlIl.info, lllllllllllllllllllIIlIIllIIIlIl.meta.priority, ((Meta)lllllllllllllllllllIIlIIllIlIIlI).name, ((Meta)lllllllllllllllllllIIlIIllIlIIlI).priority});
                return;
            }
            if (((Meta)lllllllllllllllllllIIlIIllIlIIlI).isFinal) {
                throw new InvalidInjectionException(lllllllllllllllllllIIlIIllIIIlIl.info, String.valueOf(new StringBuilder().append(lllllllllllllllllllIIlIIllIIIlIl.annotationType).append(" conflict: ").append(lllllllllllllllllllIIlIIllIIIlIl).append(" failed because target was already remapped by ").append(((Meta)lllllllllllllllllllIIlIIllIlIIlI).name)));
            }
        }
        for (InjectionPoint lllllllllllllllllllIIlIIllIlIIII : lllllllllllllllllllIIlIIllIIIIIl) {
            if (lllllllllllllllllllIIlIIllIlIIII instanceof BeforeNew && !((BeforeNew)lllllllllllllllllllIIlIIllIlIIII).hasDescriptor()) {
                lllllllllllllllllllIIlIIllIIlIIl = lllllllllllllllllllIIlIIllIIIlIl.getCtorRedirect((BeforeNew)lllllllllllllllllllIIlIIllIlIIII);
                continue;
            }
            if (!(lllllllllllllllllllIIlIIllIlIIII instanceof BeforeFieldAccess)) continue;
            BeforeFieldAccess lllllllllllllllllllIIlIIllIlIIIl = (BeforeFieldAccess)lllllllllllllllllllIIlIIllIlIIII;
            lllllllllllllllllllIIlIIllIIlIII = lllllllllllllllllllIIlIIllIlIIIl.getFuzzFactor();
            lllllllllllllllllllIIlIIllIIIlll = lllllllllllllllllllIIlIIllIlIIIl.getArrayOpcode();
        }
        InjectionNodes.InjectionNode lllllllllllllllllllIIlIIllIIIllI = lllllllllllllllllllIIlIIllIIlllI.addInjectionNode(lllllllllllllllllllIIlIIllIIllII);
        lllllllllllllllllllIIlIIllIIIllI.decorate("redirector", lllllllllllllllllllIIlIIllIIIlIl.meta);
        lllllllllllllllllllIIlIIllIIIllI.decorate("nominators", lllllllllllllllllllIIlIIllIIIIIl);
        if (lllllllllllllllllllIIlIIllIIllII instanceof TypeInsnNode && lllllllllllllllllllIIlIIllIIllII.getOpcode() == 187) {
            lllllllllllllllllllIIlIIllIIIllI.decorate("wildcard", lllllllllllllllllllIIlIIllIIlIIl != null);
            lllllllllllllllllllIIlIIllIIIllI.decorate("ctor", lllllllllllllllllllIIlIIllIIlIIl);
        } else {
            lllllllllllllllllllIIlIIllIIIllI.decorate("fuzz", lllllllllllllllllllIIlIIllIIlIII);
            lllllllllllllllllllIIlIIllIIIllI.decorate("opcode", lllllllllllllllllllIIlIIllIIIlll);
        }
        lllllllllllllllllllIIlIIllIIllIl.add(lllllllllllllllllllIIlIIllIIIllI);
    }

    protected void injectAtConstructor(Target lllllllllllllllllllIIIlIllIlIIIl, InjectionNodes.InjectionNode lllllllllllllllllllIIIlIllIllllI) {
        RedirectInjector lllllllllllllllllllIIIlIlllIIIlI;
        ConstructorRedirectData lllllllllllllllllllIIIlIllIlllII = (ConstructorRedirectData)lllllllllllllllllllIIIlIllIllllI.getDecoration("ctor");
        boolean lllllllllllllllllllIIIlIllIllIlI = (Boolean)lllllllllllllllllllIIIlIllIllllI.getDecoration("wildcard");
        TypeInsnNode lllllllllllllllllllIIIlIllIllIIl = (TypeInsnNode)lllllllllllllllllllIIIlIllIllllI.getCurrentTarget();
        AbstractInsnNode lllllllllllllllllllIIIlIllIllIII = lllllllllllllllllllIIIlIllIlIIIl.get(lllllllllllllllllllIIIlIllIlIIIl.indexOf(lllllllllllllllllllIIIlIllIllIIl) + 1);
        MethodInsnNode lllllllllllllllllllIIIlIllIlIlll = lllllllllllllllllllIIIlIllIlIIIl.findInitNodeFor(lllllllllllllllllllIIIlIllIllIIl);
        if (lllllllllllllllllllIIIlIllIlIlll == null) {
            if (!lllllllllllllllllllIIIlIllIllIlI) {
                throw new InvalidInjectionException(lllllllllllllllllllIIIlIlllIIIlI.info, String.valueOf(new StringBuilder().append(lllllllllllllllllllIIIlIlllIIIlI.annotationType).append(" ctor invocation was not found in ").append(lllllllllllllllllllIIIlIllIlIIIl)));
            }
            return;
        }
        boolean lllllllllllllllllllIIIlIllIlIllI = lllllllllllllllllllIIIlIllIllIII.getOpcode() == 89;
        String lllllllllllllllllllIIIlIllIlIlIl = lllllllllllllllllllIIIlIllIlIlll.desc.replace(")V", String.valueOf(new StringBuilder().append(")L").append(lllllllllllllllllllIIIlIllIllIIl.desc).append(";")));
        boolean lllllllllllllllllllIIIlIllIlIlII = false;
        try {
            lllllllllllllllllllIIIlIllIlIlII = lllllllllllllllllllIIIlIlllIIIlI.checkDescriptor(lllllllllllllllllllIIIlIllIlIlIl, lllllllllllllllllllIIIlIllIlIIIl, "constructor");
        }
        catch (InvalidInjectionException lllllllllllllllllllIIIlIlllIIllI) {
            if (!lllllllllllllllllllIIIlIllIllIlI) {
                throw lllllllllllllllllllIIIlIlllIIllI;
            }
            return;
        }
        if (lllllllllllllllllllIIIlIllIlIllI) {
            lllllllllllllllllllIIIlIllIlIIIl.removeNode(lllllllllllllllllllIIIlIllIllIII);
        }
        if (lllllllllllllllllllIIIlIlllIIIlI.isStatic) {
            lllllllllllllllllllIIIlIllIlIIIl.removeNode(lllllllllllllllllllIIIlIllIllIIl);
        } else {
            lllllllllllllllllllIIIlIllIlIIIl.replaceNode((AbstractInsnNode)lllllllllllllllllllIIIlIllIllIIl, new VarInsnNode(25, 0));
        }
        InsnList lllllllllllllllllllIIIlIllIlIIll = new InsnList();
        if (lllllllllllllllllllIIIlIllIlIlII) {
            lllllllllllllllllllIIIlIlllIIIlI.pushArgs(lllllllllllllllllllIIIlIllIlIIIl.arguments, lllllllllllllllllllIIIlIllIlIIll, lllllllllllllllllllIIIlIllIlIIIl.getArgIndices(), 0, lllllllllllllllllllIIIlIllIlIIIl.arguments.length);
            lllllllllllllllllllIIIlIllIlIIIl.addToStack(Bytecode.getArgsSize(lllllllllllllllllllIIIlIllIlIIIl.arguments));
        }
        lllllllllllllllllllIIIlIlllIIIlI.invokeHandler(lllllllllllllllllllIIIlIllIlIIll);
        if (lllllllllllllllllllIIIlIllIlIllI) {
            LabelNode lllllllllllllllllllIIIlIlllIIlII = new LabelNode();
            lllllllllllllllllllIIIlIllIlIIll.add(new InsnNode(89));
            lllllllllllllllllllIIIlIllIlIIll.add(new JumpInsnNode(199, lllllllllllllllllllIIIlIlllIIlII));
            lllllllllllllllllllIIIlIlllIIIlI.throwException(lllllllllllllllllllIIIlIllIlIIll, "java/lang/NullPointerException", String.valueOf(new StringBuilder().append(lllllllllllllllllllIIIlIlllIIIlI.annotationType).append(" constructor handler ").append(lllllllllllllllllllIIIlIlllIIIlI).append(" returned null for ").append(lllllllllllllllllllIIIlIllIllIIl.desc.replace('/', '.'))));
            lllllllllllllllllllIIIlIllIlIIll.add(lllllllllllllllllllIIIlIlllIIlII);
            lllllllllllllllllllIIIlIllIlIIIl.addToStack(1);
        } else {
            lllllllllllllllllllIIIlIllIlIIll.add(new InsnNode(87));
        }
        lllllllllllllllllllIIIlIllIlIIIl.replaceNode((AbstractInsnNode)lllllllllllllllllllIIIlIllIlIlll, lllllllllllllllllllIIIlIllIlIIll);
        ++lllllllllllllllllllIIIlIllIlllII.injected;
    }

    static {
        KEY_WILD = "wildcard";
        KEY_FUZZ = "fuzz";
        KEY_OPCODE = "opcode";
        KEY_NOMINATORS = "nominators";
    }

    protected boolean preInject(InjectionNodes.InjectionNode lllllllllllllllllllIIlIIlIlIIIII) {
        RedirectInjector lllllllllllllllllllIIlIIlIlIIlII;
        Meta lllllllllllllllllllIIlIIlIlIIIlI = (Meta)lllllllllllllllllllIIlIIlIlIIIII.getDecoration("redirector");
        if (lllllllllllllllllllIIlIIlIlIIIlI.getOwner() != lllllllllllllllllllIIlIIlIlIIlII) {
            Injector.logger.warn("{} conflict. Skipping {} with priority {}, already redirected by {} with priority {}", new Object[]{lllllllllllllllllllIIlIIlIlIIlII.annotationType, lllllllllllllllllllIIlIIlIlIIlII.info, lllllllllllllllllllIIlIIlIlIIlII.meta.priority, lllllllllllllllllllIIlIIlIlIIIlI.name, lllllllllllllllllllIIlIIlIlIIIlI.priority});
            return false;
        }
        return true;
    }

    @Override
    protected void inject(Target lllllllllllllllllllIIlIIlIlIlIIl, InjectionNodes.InjectionNode lllllllllllllllllllIIlIIlIlIlIII) {
        RedirectInjector lllllllllllllllllllIIlIIlIlIlIlI;
        if (!lllllllllllllllllllIIlIIlIlIlIlI.preInject(lllllllllllllllllllIIlIIlIlIlIII)) {
            return;
        }
        if (lllllllllllllllllllIIlIIlIlIlIII.isReplaced()) {
            throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append("Redirector target failure for ").append(lllllllllllllllllllIIlIIlIlIlIlI.info)));
        }
        if (lllllllllllllllllllIIlIIlIlIlIII.getCurrentTarget() instanceof MethodInsnNode) {
            lllllllllllllllllllIIlIIlIlIlIlI.checkTargetForNode(lllllllllllllllllllIIlIIlIlIlIIl, lllllllllllllllllllIIlIIlIlIlIII);
            lllllllllllllllllllIIlIIlIlIlIlI.injectAtInvoke(lllllllllllllllllllIIlIIlIlIlIIl, lllllllllllllllllllIIlIIlIlIlIII);
            return;
        }
        if (lllllllllllllllllllIIlIIlIlIlIII.getCurrentTarget() instanceof FieldInsnNode) {
            lllllllllllllllllllIIlIIlIlIlIlI.checkTargetForNode(lllllllllllllllllllIIlIIlIlIlIIl, lllllllllllllllllllIIlIIlIlIlIII);
            lllllllllllllllllllIIlIIlIlIlIlI.injectAtFieldAccess(lllllllllllllllllllIIlIIlIlIlIIl, lllllllllllllllllllIIlIIlIlIlIII);
            return;
        }
        if (lllllllllllllllllllIIlIIlIlIlIII.getCurrentTarget() instanceof TypeInsnNode && lllllllllllllllllllIIlIIlIlIlIII.getCurrentTarget().getOpcode() == 187) {
            if (!lllllllllllllllllllIIlIIlIlIlIlI.isStatic && lllllllllllllllllllIIlIIlIlIlIIl.isStatic) {
                throw new InvalidInjectionException(lllllllllllllllllllIIlIIlIlIlIlI.info, String.valueOf(new StringBuilder().append("non-static callback method ").append(lllllllllllllllllllIIlIIlIlIlIlI).append(" has a static target which is not supported")));
            }
            lllllllllllllllllllIIlIIlIlIlIlI.injectAtConstructor(lllllllllllllllllllIIlIIlIlIlIIl, lllllllllllllllllllIIlIIlIlIlIII);
            return;
        }
        throw new InvalidInjectionException(lllllllllllllllllllIIlIIlIlIlIlI.info, String.valueOf(new StringBuilder().append(lllllllllllllllllllIIlIIlIlIlIlI.annotationType).append(" annotation on is targetting an invalid insn in ").append(lllllllllllllllllllIIlIIlIlIlIIl).append(" in ").append(lllllllllllllllllllIIlIIlIlIlIlI)));
    }

    private AbstractInsnNode injectAtGetField(InsnList lllllllllllllllllllIIIlllIIIIllI, Target lllllllllllllllllllIIIllIlllllII, FieldInsnNode lllllllllllllllllllIIIlllIIIIlII, boolean lllllllllllllllllllIIIlllIIIIIll, Type lllllllllllllllllllIIIlllIIIIIlI, Type lllllllllllllllllllIIIlllIIIIIIl) {
        RedirectInjector lllllllllllllllllllIIIllIllllllI;
        String lllllllllllllllllllIIIlllIIIIIII = lllllllllllllllllllIIIlllIIIIIll ? Bytecode.generateDescriptor(lllllllllllllllllllIIIlllIIIIIIl, new Object[0]) : Bytecode.generateDescriptor(lllllllllllllllllllIIIlllIIIIIIl, lllllllllllllllllllIIIlllIIIIIlI);
        boolean lllllllllllllllllllIIIllIlllllll = lllllllllllllllllllIIIllIllllllI.checkDescriptor(lllllllllllllllllllIIIlllIIIIIII, lllllllllllllllllllIIIllIlllllII, "getter");
        if (!lllllllllllllllllllIIIllIllllllI.isStatic) {
            lllllllllllllllllllIIIlllIIIIllI.add(new VarInsnNode(25, 0));
            if (!lllllllllllllllllllIIIlllIIIIIll) {
                lllllllllllllllllllIIIlllIIIIllI.add(new InsnNode(95));
            }
        }
        if (lllllllllllllllllllIIIllIlllllll) {
            lllllllllllllllllllIIIllIllllllI.pushArgs(lllllllllllllllllllIIIllIlllllII.arguments, lllllllllllllllllllIIIlllIIIIllI, lllllllllllllllllllIIIllIlllllII.getArgIndices(), 0, lllllllllllllllllllIIIllIlllllII.arguments.length);
            lllllllllllllllllllIIIllIlllllII.addToStack(Bytecode.getArgsSize(lllllllllllllllllllIIIllIlllllII.arguments));
        }
        lllllllllllllllllllIIIllIlllllII.addToStack(lllllllllllllllllllIIIllIllllllI.isStatic ? 0 : 1);
        return lllllllllllllllllllIIIllIllllllI.invokeHandler(lllllllllllllllllllIIIlllIIIIllI);
    }

    @Override
    protected void injectAtInvoke(Target lllllllllllllllllllIIlIIIlllllII, InjectionNodes.InjectionNode lllllllllllllllllllIIlIIIllllIll) {
        RedirectInjector lllllllllllllllllllIIlIIIlllllIl;
        MethodInsnNode lllllllllllllllllllIIlIIIllllIlI = (MethodInsnNode)lllllllllllllllllllIIlIIIllllIll.getCurrentTarget();
        boolean lllllllllllllllllllIIlIIIllllIIl = lllllllllllllllllllIIlIIIllllIlI.getOpcode() == 184;
        Type lllllllllllllllllllIIlIIIllllIII = Type.getType(String.valueOf(new StringBuilder().append("L").append(lllllllllllllllllllIIlIIIllllIlI.owner).append(";")));
        Type lllllllllllllllllllIIlIIIlllIlll = Type.getReturnType(lllllllllllllllllllIIlIIIllllIlI.desc);
        Object[] lllllllllllllllllllIIlIIIlllIllI = Type.getArgumentTypes(lllllllllllllllllllIIlIIIllllIlI.desc);
        Object[] lllllllllllllllllllIIlIIIlllIlIl = lllllllllllllllllllIIlIIIllllIIl ? lllllllllllllllllllIIlIIIlllIllI : (Type[])ObjectArrays.concat((Object)lllllllllllllllllllIIlIIIllllIII, (Object[])lllllllllllllllllllIIlIIIlllIllI);
        boolean lllllllllllllllllllIIlIIIlllIlII = false;
        String lllllllllllllllllllIIlIIIlllIIll = Bytecode.getDescriptor((Type[])lllllllllllllllllllIIlIIIlllIlIl, lllllllllllllllllllIIlIIIlllIlll);
        if (!lllllllllllllllllllIIlIIIlllIIll.equals(lllllllllllllllllllIIlIIIlllllIl.methodNode.desc)) {
            String lllllllllllllllllllIIlIIIlllllll = Bytecode.getDescriptor((Type[])ObjectArrays.concat((Object[])lllllllllllllllllllIIlIIIlllIlIl, (Object[])lllllllllllllllllllIIlIIIlllllII.arguments, Type.class), lllllllllllllllllllIIlIIIlllIlll);
            if (lllllllllllllllllllIIlIIIlllllll.equals(lllllllllllllllllllIIlIIIlllllIl.methodNode.desc)) {
                lllllllllllllllllllIIlIIIlllIlII = true;
            } else {
                throw new InvalidInjectionException(lllllllllllllllllllIIlIIIlllllIl.info, String.valueOf(new StringBuilder().append(lllllllllllllllllllIIlIIIlllllIl.annotationType).append(" handler method ").append(lllllllllllllllllllIIlIIIlllllIl).append(" has an invalid signature, expected ").append(lllllllllllllllllllIIlIIIlllIIll).append(" found ").append(lllllllllllllllllllIIlIIIlllllIl.methodNode.desc)));
            }
        }
        InsnList lllllllllllllllllllIIlIIIlllIIlI = new InsnList();
        int lllllllllllllllllllIIlIIIlllIIIl = Bytecode.getArgsSize((Type[])lllllllllllllllllllIIlIIIlllIlIl) + 1;
        int lllllllllllllllllllIIlIIIlllIIII = 1;
        int[] lllllllllllllllllllIIlIIIllIllll = lllllllllllllllllllIIlIIIlllllIl.storeArgs(lllllllllllllllllllIIlIIIlllllII, (Type[])lllllllllllllllllllIIlIIIlllIlIl, lllllllllllllllllllIIlIIIlllIIlI, 0);
        if (lllllllllllllllllllIIlIIIlllIlII) {
            int lllllllllllllllllllIIlIIIllllllI = Bytecode.getArgsSize(lllllllllllllllllllIIlIIIlllllII.arguments);
            lllllllllllllllllllIIlIIIlllIIIl += lllllllllllllllllllIIlIIIllllllI;
            lllllllllllllllllllIIlIIIlllIIII += lllllllllllllllllllIIlIIIllllllI;
            lllllllllllllllllllIIlIIIllIllll = Ints.concat((int[][])new int[][]{lllllllllllllllllllIIlIIIllIllll, lllllllllllllllllllIIlIIIlllllII.getArgIndices()});
        }
        AbstractInsnNode lllllllllllllllllllIIlIIIllIlllI = lllllllllllllllllllIIlIIIlllllIl.invokeHandlerWithArgs(lllllllllllllllllllIIlIIIlllllIl.methodArgs, lllllllllllllllllllIIlIIIlllIIlI, lllllllllllllllllllIIlIIIllIllll);
        lllllllllllllllllllIIlIIIlllllII.replaceNode(lllllllllllllllllllIIlIIIllllIlI, lllllllllllllllllllIIlIIIllIlllI, lllllllllllllllllllIIlIIIlllIIlI);
        lllllllllllllllllllIIlIIIlllllII.addToLocals(lllllllllllllllllllIIlIIIlllIIIl);
        lllllllllllllllllllIIlIIIlllllII.addToStack(lllllllllllllllllllIIlIIIlllIIII);
    }

    @Override
    protected void postInject(Target lllllllllllllllllllIIlIIlIIlIllI, InjectionNodes.InjectionNode lllllllllllllllllllIIlIIlIIlIlIl) {
        RedirectInjector lllllllllllllllllllIIlIIlIIlIlll;
        super.postInject(lllllllllllllllllllIIlIIlIIlIllI, lllllllllllllllllllIIlIIlIIlIlIl);
        if (lllllllllllllllllllIIlIIlIIlIlIl.getOriginalTarget() instanceof TypeInsnNode && lllllllllllllllllllIIlIIlIIlIlIl.getOriginalTarget().getOpcode() == 187) {
            ConstructorRedirectData lllllllllllllllllllIIlIIlIIllIIl = (ConstructorRedirectData)lllllllllllllllllllIIlIIlIIlIlIl.getDecoration("ctor");
            boolean lllllllllllllllllllIIlIIlIIllIII = (Boolean)lllllllllllllllllllIIlIIlIIlIlIl.getDecoration("wildcard");
            if (lllllllllllllllllllIIlIIlIIllIII && lllllllllllllllllllIIlIIlIIllIIl.injected == 0) {
                throw new InvalidInjectionException(lllllllllllllllllllIIlIIlIIlIlll.info, String.valueOf(new StringBuilder().append(lllllllllllllllllllIIlIIlIIlIlll.annotationType).append(" ctor invocation was not found in ").append(lllllllllllllllllllIIlIIlIIlIllI)));
            }
        }
    }

    private void injectAtFieldAccess(Target lllllllllllllllllllIIlIIIlIIIllI, InjectionNodes.InjectionNode lllllllllllllllllllIIlIIIlIIlllI) {
        RedirectInjector lllllllllllllllllllIIlIIIlIlIIII;
        int lllllllllllllllllllIIlIIIlIIlIII;
        FieldInsnNode lllllllllllllllllllIIlIIIlIIllIl = (FieldInsnNode)lllllllllllllllllllIIlIIIlIIlllI.getCurrentTarget();
        int lllllllllllllllllllIIlIIIlIIllII = lllllllllllllllllllIIlIIIlIIllIl.getOpcode();
        Type lllllllllllllllllllIIlIIIlIIlIll = Type.getType(String.valueOf(new StringBuilder().append("L").append(lllllllllllllllllllIIlIIIlIIllIl.owner).append(";")));
        Type lllllllllllllllllllIIlIIIlIIlIlI = Type.getType(lllllllllllllllllllIIlIIIlIIllIl.desc);
        int lllllllllllllllllllIIlIIIlIIlIIl = lllllllllllllllllllIIlIIIlIIlIlI.getSort() == 9 ? lllllllllllllllllllIIlIIIlIIlIlI.getDimensions() : 0;
        int n = lllllllllllllllllllIIlIIIlIIlIII = lllllllllllllllllllIIlIIIlIlIIII.returnType.getSort() == 9 ? lllllllllllllllllllIIlIIIlIlIIII.returnType.getDimensions() : 0;
        if (lllllllllllllllllllIIlIIIlIIlIII > lllllllllllllllllllIIlIIIlIIlIIl) {
            throw new InvalidInjectionException(lllllllllllllllllllIIlIIIlIlIIII.info, String.valueOf(new StringBuilder().append("Dimensionality of handler method is greater than target array on ").append(lllllllllllllllllllIIlIIIlIlIIII)));
        }
        if (lllllllllllllllllllIIlIIIlIIlIII == 0 && lllllllllllllllllllIIlIIIlIIlIIl > 0) {
            int lllllllllllllllllllIIlIIIlIlIIlI = (Integer)lllllllllllllllllllIIlIIIlIIlllI.getDecoration("fuzz");
            int lllllllllllllllllllIIlIIIlIlIIIl = (Integer)lllllllllllllllllllIIlIIIlIIlllI.getDecoration("opcode");
            lllllllllllllllllllIIlIIIlIlIIII.injectAtArrayField(lllllllllllllllllllIIlIIIlIIIllI, lllllllllllllllllllIIlIIIlIIllIl, lllllllllllllllllllIIlIIIlIIllII, lllllllllllllllllllIIlIIIlIIlIll, lllllllllllllllllllIIlIIIlIIlIlI, lllllllllllllllllllIIlIIIlIlIIlI, lllllllllllllllllllIIlIIIlIlIIIl);
        } else {
            lllllllllllllllllllIIlIIIlIlIIII.injectAtScalarField(lllllllllllllllllllIIlIIIlIIIllI, lllllllllllllllllllIIlIIIlIIllIl, lllllllllllllllllllIIlIIIlIIllII, lllllllllllllllllllIIlIIIlIIlIll, lllllllllllllllllllIIlIIIlIIlIlI);
        }
    }

    private void injectAtArrayField(Target lllllllllllllllllllIIlIIIIlIllll, FieldInsnNode lllllllllllllllllllIIlIIIIlIlllI, int lllllllllllllllllllIIlIIIIlIIlII, Type lllllllllllllllllllIIlIIIIlIIIll, Type lllllllllllllllllllIIlIIIIlIIIlI, int lllllllllllllllllllIIlIIIIlIlIlI, int lllllllllllllllllllIIlIIIIlIlIIl) {
        RedirectInjector lllllllllllllllllllIIlIIIIllIIII;
        Type lllllllllllllllllllIIlIIIIlIlIII = lllllllllllllllllllIIlIIIIlIIIlI.getElementType();
        if (lllllllllllllllllllIIlIIIIlIIlII != 178 && lllllllllllllllllllIIlIIIIlIIlII != 180) {
            throw new InvalidInjectionException(lllllllllllllllllllIIlIIIIllIIII.info, String.valueOf(new StringBuilder().append("Unspported opcode ").append(Bytecode.getOpcodeName(lllllllllllllllllllIIlIIIIlIIlII)).append(" for array access ").append(lllllllllllllllllllIIlIIIIllIIII.info)));
        }
        if (lllllllllllllllllllIIlIIIIllIIII.returnType.getSort() != 0) {
            if (lllllllllllllllllllIIlIIIIlIlIIl != 190) {
                lllllllllllllllllllIIlIIIIlIlIIl = lllllllllllllllllllIIlIIIIlIlIII.getOpcode(46);
            }
            AbstractInsnNode lllllllllllllllllllIIlIIIIllIIlI = BeforeFieldAccess.findArrayNode(lllllllllllllllllllIIlIIIIlIllll.insns, lllllllllllllllllllIIlIIIIlIlllI, lllllllllllllllllllIIlIIIIlIlIIl, lllllllllllllllllllIIlIIIIlIlIlI);
            lllllllllllllllllllIIlIIIIllIIII.injectAtGetArray(lllllllllllllllllllIIlIIIIlIllll, lllllllllllllllllllIIlIIIIlIlllI, lllllllllllllllllllIIlIIIIllIIlI, lllllllllllllllllllIIlIIIIlIIIll, lllllllllllllllllllIIlIIIIlIIIlI);
        } else {
            AbstractInsnNode lllllllllllllllllllIIlIIIIllIIIl = BeforeFieldAccess.findArrayNode(lllllllllllllllllllIIlIIIIlIllll.insns, lllllllllllllllllllIIlIIIIlIlllI, lllllllllllllllllllIIlIIIIlIlIII.getOpcode(79), lllllllllllllllllllIIlIIIIlIlIlI);
            lllllllllllllllllllIIlIIIIllIIII.injectAtSetArray(lllllllllllllllllllIIlIIIIlIllll, lllllllllllllllllllIIlIIIIlIlllI, lllllllllllllllllllIIlIIIIllIIIl, lllllllllllllllllllIIlIIIIlIIIll, lllllllllllllllllllIIlIIIIlIIIlI);
        }
    }

    private static Type[] getArrayArgs(Type lllllllllllllllllllIIIlIlIIIIIIl, int lllllllllllllllllllIIIlIlIIIlIII, Type ... lllllllllllllllllllIIIlIIllllllI) {
        int lllllllllllllllllllIIIlIlIIIIlIl = lllllllllllllllllllIIIlIlIIIIIIl.getDimensions() + lllllllllllllllllllIIIlIlIIIlIII;
        Type[] lllllllllllllllllllIIIlIlIIIIIll = new Type[lllllllllllllllllllIIIlIlIIIIlIl + lllllllllllllllllllIIIlIIllllllI.length];
        for (int lllllllllllllllllllIIIlIlIIIllII = 0; lllllllllllllllllllIIIlIlIIIllII < lllllllllllllllllllIIIlIlIIIIIll.length; ++lllllllllllllllllllIIIlIlIIIllII) {
            lllllllllllllllllllIIIlIlIIIIIll[lllllllllllllllllllIIIlIlIIIllII] = lllllllllllllllllllIIIlIlIIIllII == 0 ? lllllllllllllllllllIIIlIlIIIIIIl : (lllllllllllllllllllIIIlIlIIIllII < lllllllllllllllllllIIIlIlIIIIlIl ? Type.INT_TYPE : lllllllllllllllllllIIIlIIllllllI[lllllllllllllllllllIIIlIlIIIIlIl - lllllllllllllllllllIIIlIlIIIllII]);
        }
        return lllllllllllllllllllIIIlIlIIIIIll;
    }

    private static String getGetArrayHandlerDescriptor(AbstractInsnNode lllllllllllllllllllIIIlIlIllIlIl, Type lllllllllllllllllllIIIlIlIllIlII, Type lllllllllllllllllllIIIlIlIllIIlI) {
        if (lllllllllllllllllllIIIlIlIllIlIl != null && lllllllllllllllllllIIIlIlIllIlIl.getOpcode() == 190) {
            return Bytecode.generateDescriptor(Type.INT_TYPE, RedirectInjector.getArrayArgs(lllllllllllllllllllIIIlIlIllIIlI, 0, new Type[0]));
        }
        return Bytecode.generateDescriptor(lllllllllllllllllllIIIlIlIllIlII, RedirectInjector.getArrayArgs(lllllllllllllllllllIIIlIlIllIIlI, 1, new Type[0]));
    }

    protected RedirectInjector(InjectionInfo lllllllllllllllllllIIlIIlllIIlII, String lllllllllllllllllllIIlIIlllIlIII) {
        super(lllllllllllllllllllIIlIIlllIIlII, lllllllllllllllllllIIlIIlllIlIII);
        RedirectInjector lllllllllllllllllllIIlIIlllIlIlI;
        lllllllllllllllllllIIlIIlllIlIlI.ctorRedirectors = new HashMap<BeforeNew, ConstructorRedirectData>();
        int lllllllllllllllllllIIlIIlllIIlll = lllllllllllllllllllIIlIIlllIIlII.getContext().getPriority();
        boolean lllllllllllllllllllIIlIIlllIIllI = Annotations.getVisible(lllllllllllllllllllIIlIIlllIlIlI.methodNode, Final.class) != null;
        lllllllllllllllllllIIlIIlllIlIlI.meta = lllllllllllllllllllIIlIIlllIlIlI.new Meta(lllllllllllllllllllIIlIIlllIIlll, lllllllllllllllllllIIlIIlllIIllI, lllllllllllllllllllIIlIIlllIlIlI.info.toString(), lllllllllllllllllllIIlIIlllIlIlI.methodNode.desc);
    }

    class Meta {
        final /* synthetic */ String desc;
        final /* synthetic */ String name;
        final /* synthetic */ int priority;
        public static final /* synthetic */ String KEY;
        final /* synthetic */ boolean isFinal;

        RedirectInjector getOwner() {
            Meta llllllllllllllllIIIIIIIlIlllIlIl;
            return llllllllllllllllIIIIIIIlIlllIlIl.RedirectInjector.this;
        }

        static {
            KEY = "redirector";
        }

        public Meta(int llllllllllllllllIIIIIIIllIIIIIII, boolean llllllllllllllllIIIIIIIlIlllllll, String llllllllllllllllIIIIIIIlIllllIII, String llllllllllllllllIIIIIIIlIlllIlll) {
            Meta llllllllllllllllIIIIIIIlIlllllII;
            llllllllllllllllIIIIIIIlIlllllII.priority = llllllllllllllllIIIIIIIllIIIIIII;
            llllllllllllllllIIIIIIIlIlllllII.isFinal = llllllllllllllllIIIIIIIlIlllllll;
            llllllllllllllllIIIIIIIlIlllllII.name = llllllllllllllllIIIIIIIlIllllIII;
            llllllllllllllllIIIIIIIlIlllllII.desc = llllllllllllllllIIIIIIIlIlllIlll;
        }
    }

    class ConstructorRedirectData {
        public static final /* synthetic */ String KEY;
        public /* synthetic */ int injected;

        static {
            KEY = "ctor";
        }

        ConstructorRedirectData() {
            ConstructorRedirectData llllllllllllllllIllIllIIlIlllIIl;
            llllllllllllllllIllIllIIlIlllIIl.injected = 0;
        }
    }
}

