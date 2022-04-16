/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.points;

import java.util.Collection;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.points.BeforeInvoke;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;

@InjectionPoint.AtCode(value="INVOKE_STRING")
public class BeforeStringInvoke
extends BeforeInvoke {
    private static final /* synthetic */ String STRING_VOID_SIG;
    private /* synthetic */ boolean foundLdc;
    private final /* synthetic */ String ldcValue;

    @Override
    protected boolean matchesInsn(MemberInfo lllllllllllllllllIIIlIlIlIllllII, int lllllllllllllllllIIIlIlIllIIIIlI) {
        BeforeStringInvoke lllllllllllllllllIIIlIlIllIIlIII;
        lllllllllllllllllIIIlIlIllIIlIII.log("{} > > found LDC \"{}\" = {}", lllllllllllllllllIIIlIlIllIIlIII.className, lllllllllllllllllIIIlIlIllIIlIII.ldcValue, lllllllllllllllllIIIlIlIllIIlIII.foundLdc);
        return lllllllllllllllllIIIlIlIllIIlIII.foundLdc && super.matchesInsn(lllllllllllllllllIIIlIlIlIllllII, lllllllllllllllllIIIlIlIllIIIIlI);
    }

    public BeforeStringInvoke(InjectionPointData lllllllllllllllllIIIlIllIIIIIlll) {
        super(lllllllllllllllllIIIlIllIIIIIlll);
        BeforeStringInvoke lllllllllllllllllIIIlIllIIIIIllI;
        lllllllllllllllllIIIlIllIIIIIllI.ldcValue = lllllllllllllllllIIIlIllIIIIIlll.get("ldc", null);
        if (lllllllllllllllllIIIlIllIIIIIllI.ldcValue == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(lllllllllllllllllIIIlIllIIIIIllI.getClass().getSimpleName()).append(" requires named argument \"ldc\" to specify the desired target")));
        }
        if (!"(Ljava/lang/String;)V".equals(lllllllllllllllllIIIlIllIIIIIllI.target.desc)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(lllllllllllllllllIIIlIllIIIIIllI.getClass().getSimpleName()).append(" requires target method with with signature ").append("(Ljava/lang/String;)V")));
        }
    }

    @Override
    public boolean find(String lllllllllllllllllIIIlIlIllllIlIl, InsnList lllllllllllllllllIIIlIlIllllIlII, Collection<AbstractInsnNode> lllllllllllllllllIIIlIlIllllIlll) {
        BeforeStringInvoke lllllllllllllllllIIIlIlIllllIllI;
        lllllllllllllllllIIIlIlIllllIllI.foundLdc = false;
        return super.find(lllllllllllllllllIIIlIlIllllIlIl, lllllllllllllllllIIIlIlIllllIlII, lllllllllllllllllIIIlIlIllllIlll);
    }

    @Override
    protected void inspectInsn(String lllllllllllllllllIIIlIlIlllIllIl, InsnList lllllllllllllllllIIIlIlIlllIllII, AbstractInsnNode lllllllllllllllllIIIlIlIlllIlIll) {
        if (lllllllllllllllllIIIlIlIlllIlIll instanceof LdcInsnNode) {
            BeforeStringInvoke lllllllllllllllllIIIlIlIlllIlllI;
            LdcInsnNode lllllllllllllllllIIIlIlIlllIllll = (LdcInsnNode)lllllllllllllllllIIIlIlIlllIlIll;
            if (lllllllllllllllllIIIlIlIlllIllll.cst instanceof String && lllllllllllllllllIIIlIlIlllIlllI.ldcValue.equals(lllllllllllllllllIIIlIlIlllIllll.cst)) {
                lllllllllllllllllIIIlIlIlllIlllI.log("{} > found a matching LDC with value {}", lllllllllllllllllIIIlIlIlllIlllI.className, lllllllllllllllllIIIlIlIlllIllll.cst);
                lllllllllllllllllIIIlIlIlllIlllI.foundLdc = true;
                return;
            }
        }
        lllllllllllllllllIIIlIlIlllIlllI.foundLdc = false;
    }

    static {
        STRING_VOID_SIG = "(Ljava/lang/String;)V";
    }
}

