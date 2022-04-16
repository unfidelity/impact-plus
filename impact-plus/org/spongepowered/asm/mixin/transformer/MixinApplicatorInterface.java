/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer;

import java.util.Map;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.MixinApplicatorStandard;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.mixin.transformer.TargetClassContext;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidInterfaceMixinException;

class MixinApplicatorInterface
extends MixinApplicatorStandard {
    @Override
    protected void applyFields(MixinTargetContext llllIIllIlIIIIl) {
        MixinApplicatorInterface llllIIllIlIIlII;
        for (Map.Entry<FieldNode, ClassInfo.Field> llllIIllIlIIlIl : llllIIllIlIIIIl.getShadowFields()) {
            FieldNode llllIIllIlIIllI = llllIIllIlIIlIl.getKey();
            llllIIllIlIIlII.logger.error("Ignoring redundant @Shadow field {}:{} in {}", new Object[]{llllIIllIlIIllI.name, llllIIllIlIIllI.desc, llllIIllIlIIIIl});
        }
        llllIIllIlIIlII.mergeNewFields(llllIIllIlIIIIl);
    }

    @Override
    protected void applyInjections(MixinTargetContext llllIIllIIIlIII) {
    }

    @Override
    protected void prepareInjections(MixinTargetContext llllIIllIIIlllI) {
        MixinApplicatorInterface llllIIllIIlIIIl;
        for (MethodNode llllIIllIIlIIlI : llllIIllIIlIIIl.targetClass.methods) {
            try {
                InjectionInfo llllIIllIIlIlIl = InjectionInfo.parse(llllIIllIIIlllI, llllIIllIIlIIlI);
                if (llllIIllIIlIlIl == null) continue;
                throw new InvalidInterfaceMixinException((IMixinContext)llllIIllIIIlllI, String.valueOf(new StringBuilder().append(llllIIllIIlIlIl).append(" is not supported on interface mixin method ").append(llllIIllIIlIIlI.name)));
            }
            catch (InvalidInjectionException llllIIllIIlIIll) {
                String llllIIllIIlIlII = llllIIllIIlIIll.getInjectionInfo() != null ? llllIIllIIlIIll.getInjectionInfo().toString() : "Injection";
                throw new InvalidInterfaceMixinException((IMixinContext)llllIIllIIIlllI, String.valueOf(new StringBuilder().append(llllIIllIIlIlII).append(" is not supported in interface mixin")));
            }
        }
    }

    MixinApplicatorInterface(TargetClassContext llllIIllIllIlll) {
        super(llllIIllIllIlll);
        MixinApplicatorInterface llllIIllIlllIII;
    }

    @Override
    protected void applyInterfaces(MixinTargetContext llllIIllIllIIII) {
        for (String llllIIllIllIIlI : llllIIllIllIIII.getInterfaces()) {
            MixinApplicatorInterface llllIIllIllIIIl;
            if (llllIIllIllIIIl.targetClass.name.equals(llllIIllIllIIlI) || llllIIllIllIIIl.targetClass.interfaces.contains(llllIIllIllIIlI)) continue;
            llllIIllIllIIIl.targetClass.interfaces.add(llllIIllIllIIlI);
            llllIIllIllIIII.getTargetClassInfo().addInterface(llllIIllIllIIlI);
        }
    }

    @Override
    protected void applyInitialisers(MixinTargetContext llllIIllIIlllII) {
    }
}

