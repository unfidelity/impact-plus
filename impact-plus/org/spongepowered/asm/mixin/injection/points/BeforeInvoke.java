/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.injection.points;

import java.util.Collection;
import java.util.ListIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;

@InjectionPoint.AtCode(value="INVOKE")
public class BeforeInvoke
extends InjectionPoint {
    protected final /* synthetic */ String className;
    protected final /* synthetic */ MemberInfo target;
    protected final /* synthetic */ int ordinal;
    private final /* synthetic */ Logger logger;
    protected final /* synthetic */ MemberInfo permissiveTarget;
    private /* synthetic */ boolean log;

    @Override
    public boolean find(String llllllllllllllllllIIIllllllllllI, InsnList llllllllllllllllllIIIlllllllllIl, Collection<AbstractInsnNode> llllllllllllllllllIIIllllllllIII) {
        BeforeInvoke llllllllllllllllllIIIlllllllllll;
        llllllllllllllllllIIIlllllllllll.log("{} is searching for an injection point in method with descriptor {}", llllllllllllllllllIIIlllllllllll.className, llllllllllllllllllIIIllllllllllI);
        if (!llllllllllllllllllIIIlllllllllll.find(llllllllllllllllllIIIllllllllllI, llllllllllllllllllIIIlllllllllIl, llllllllllllllllllIIIllllllllIII, llllllllllllllllllIIIlllllllllll.target)) {
            return llllllllllllllllllIIIlllllllllll.find(llllllllllllllllllIIIllllllllllI, llllllllllllllllllIIIlllllllllIl, llllllllllllllllllIIIllllllllIII, llllllllllllllllllIIIlllllllllll.permissiveTarget);
        }
        return true;
    }

    protected boolean matchesInsn(AbstractInsnNode llllllllllllllllllIIIlllllIIlllI) {
        return llllllllllllllllllIIIlllllIIlllI instanceof MethodInsnNode;
    }

    protected void log(String llllllllllllllllllIIIllllIlllIll, Object ... llllllllllllllllllIIIllllIlllIlI) {
        BeforeInvoke llllllllllllllllllIIIllllIllllll;
        if (llllllllllllllllllIIIllllIllllll.log) {
            llllllllllllllllllIIIllllIllllll.logger.info(llllllllllllllllllIIIllllIlllIll, llllllllllllllllllIIIllllIlllIlI);
        }
    }

    public BeforeInvoke setLogging(boolean llllllllllllllllllIIlIIIIIIIIlII) {
        BeforeInvoke llllllllllllllllllIIlIIIIIIIIlIl;
        llllllllllllllllllIIlIIIIIIIIlIl.log = llllllllllllllllllIIlIIIIIIIIlII;
        return llllllllllllllllllIIlIIIIIIIIlIl;
    }

    public BeforeInvoke(InjectionPointData llllllllllllllllllIIlIIIIIIlIIlI) {
        super(llllllllllllllllllIIlIIIIIIlIIlI);
        BeforeInvoke llllllllllllllllllIIlIIIIIIlIIIl;
        llllllllllllllllllIIlIIIIIIlIIIl.log = false;
        llllllllllllllllllIIlIIIIIIlIIIl.logger = LogManager.getLogger((String)"mixin");
        llllllllllllllllllIIlIIIIIIlIIIl.target = llllllllllllllllllIIlIIIIIIlIIlI.getTarget();
        llllllllllllllllllIIlIIIIIIlIIIl.ordinal = llllllllllllllllllIIlIIIIIIlIIlI.getOrdinal();
        llllllllllllllllllIIlIIIIIIlIIIl.log = llllllllllllllllllIIlIIIIIIlIIlI.get("log", false);
        llllllllllllllllllIIlIIIIIIlIIIl.className = llllllllllllllllllIIlIIIIIIlIIIl.getClassName();
        llllllllllllllllllIIlIIIIIIlIIIl.permissiveTarget = llllllllllllllllllIIlIIIIIIlIIlI.getContext().getOption(MixinEnvironment.Option.REFMAP_REMAP) ? llllllllllllllllllIIlIIIIIIlIIIl.target.transform(null) : null;
    }

    protected boolean find(String llllllllllllllllllIIIllllllIIIlI, InsnList llllllllllllllllllIIIllllllIlIIl, Collection<AbstractInsnNode> llllllllllllllllllIIIllllllIIIII, MemberInfo llllllllllllllllllIIIllllllIIlll) {
        if (llllllllllllllllllIIIllllllIIlll == null) {
            return false;
        }
        int llllllllllllllllllIIIllllllIIllI = 0;
        boolean llllllllllllllllllIIIllllllIIlIl = false;
        ListIterator<AbstractInsnNode> llllllllllllllllllIIIllllllIIlII = llllllllllllllllllIIIllllllIlIIl.iterator();
        while (llllllllllllllllllIIIllllllIIlII.hasNext()) {
            BeforeInvoke llllllllllllllllllIIIllllllIlIll;
            AbstractInsnNode llllllllllllllllllIIIllllllIllII = llllllllllllllllllIIIllllllIIlII.next();
            if (llllllllllllllllllIIIllllllIlIll.matchesInsn(llllllllllllllllllIIIllllllIllII)) {
                MemberInfo llllllllllllllllllIIIllllllIllIl = new MemberInfo(llllllllllllllllllIIIllllllIllII);
                llllllllllllllllllIIIllllllIlIll.log("{} is considering insn {}", llllllllllllllllllIIIllllllIlIll.className, llllllllllllllllllIIIllllllIllIl);
                if (llllllllllllllllllIIIllllllIIlll.matches(llllllllllllllllllIIIllllllIllIl.owner, llllllllllllllllllIIIllllllIllIl.name, llllllllllllllllllIIIllllllIllIl.desc)) {
                    llllllllllllllllllIIIllllllIlIll.log("{} > found a matching insn, checking preconditions...", llllllllllllllllllIIIllllllIlIll.className);
                    if (llllllllllllllllllIIIllllllIlIll.matchesInsn(llllllllllllllllllIIIllllllIllIl, llllllllllllllllllIIIllllllIIllI)) {
                        llllllllllllllllllIIIllllllIlIll.log("{} > > > found a matching insn at ordinal {}", llllllllllllllllllIIIllllllIlIll.className, llllllllllllllllllIIIllllllIIllI);
                        llllllllllllllllllIIIllllllIIlIl |= llllllllllllllllllIIIllllllIlIll.addInsn(llllllllllllllllllIIIllllllIlIIl, llllllllllllllllllIIIllllllIIIII, llllllllllllllllllIIIllllllIllII);
                        if (llllllllllllllllllIIIllllllIlIll.ordinal == llllllllllllllllllIIIllllllIIllI) break;
                    }
                    ++llllllllllllllllllIIIllllllIIllI;
                }
            }
            llllllllllllllllllIIIllllllIlIll.inspectInsn(llllllllllllllllllIIIllllllIIIlI, llllllllllllllllllIIIllllllIlIIl, llllllllllllllllllIIIllllllIllII);
        }
        return llllllllllllllllllIIIllllllIIlIl;
    }

    protected boolean addInsn(InsnList llllllllllllllllllIIIlllllIlIllI, Collection<AbstractInsnNode> llllllllllllllllllIIIlllllIlIlIl, AbstractInsnNode llllllllllllllllllIIIlllllIlIlII) {
        llllllllllllllllllIIIlllllIlIlIl.add(llllllllllllllllllIIIlllllIlIlII);
        return true;
    }

    protected boolean matchesInsn(MemberInfo llllllllllllllllllIIIlllllIIIllI, int llllllllllllllllllIIIlllllIIIlIl) {
        BeforeInvoke llllllllllllllllllIIIlllllIIIlll;
        llllllllllllllllllIIIlllllIIIlll.log("{} > > comparing target ordinal {} with current ordinal {}", llllllllllllllllllIIIlllllIIIlll.className, llllllllllllllllllIIIlllllIIIlll.ordinal, llllllllllllllllllIIIlllllIIIlIl);
        return llllllllllllllllllIIIlllllIIIlll.ordinal == -1 || llllllllllllllllllIIIlllllIIIlll.ordinal == llllllllllllllllllIIIlllllIIIlIl;
    }

    protected void inspectInsn(String llllllllllllllllllIIIlllllIIllII, InsnList llllllllllllllllllIIIlllllIIlIll, AbstractInsnNode llllllllllllllllllIIIlllllIIlIlI) {
    }

    private String getClassName() {
        BeforeInvoke llllllllllllllllllIIlIIIIIIIlIll;
        InjectionPoint.AtCode llllllllllllllllllIIlIIIIIIIllII = llllllllllllllllllIIlIIIIIIIlIll.getClass().getAnnotation(InjectionPoint.AtCode.class);
        return String.format("@At(%s)", llllllllllllllllllIIlIIIIIIIllII != null ? llllllllllllllllllIIlIIIIIIIllII.value() : llllllllllllllllllIIlIIIIIIIlIll.getClass().getSimpleName().toUpperCase());
    }
}

