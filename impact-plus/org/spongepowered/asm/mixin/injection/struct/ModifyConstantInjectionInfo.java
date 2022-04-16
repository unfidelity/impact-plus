/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  com.google.common.collect.ImmutableList
 */
package org.spongepowered.asm.mixin.injection.struct;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.invoke.ModifyConstantInjector;
import org.spongepowered.asm.mixin.injection.points.BeforeConstant;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;

public class ModifyConstantInjectionInfo
extends InjectionInfo {
    private static final /* synthetic */ String CONSTANT_ANNOTATION_CLASS;

    static {
        CONSTANT_ANNOTATION_CLASS = Constant.class.getName().replace('.', '/');
    }

    @Override
    public String getSliceId(String lIlIIllIIlIIII) {
        return Strings.nullToEmpty((String)lIlIIllIIlIIII);
    }

    @Override
    protected Injector parseInjector(AnnotationNode lIlIIllIIlIllI) {
        ModifyConstantInjectionInfo lIlIIllIIlIlll;
        return new ModifyConstantInjector(lIlIIllIIlIlll);
    }

    @Override
    protected String getDescription() {
        return "Constant modifier method";
    }

    public ModifyConstantInjectionInfo(MixinTargetContext lIlIIllIllIlIl, MethodNode lIlIIllIlllIII, AnnotationNode lIlIIllIllIIll) {
        super(lIlIIllIllIlIl, lIlIIllIlllIII, lIlIIllIllIIll, "constant");
        ModifyConstantInjectionInfo lIlIIllIllIllI;
    }

    @Override
    protected List<AnnotationNode> readInjectionPoints(String lIlIIllIlIlIIl) {
        ModifyConstantInjectionInfo lIlIIllIlIlIlI;
        ImmutableList lIlIIllIlIlIll = super.readInjectionPoints(lIlIIllIlIlIIl);
        if (lIlIIllIlIlIll.isEmpty()) {
            AnnotationNode lIlIIllIlIlllI = new AnnotationNode(CONSTANT_ANNOTATION_CLASS);
            lIlIIllIlIlllI.visit("log", Boolean.TRUE);
            lIlIIllIlIlIll = ImmutableList.of((Object)lIlIIllIlIlllI);
        }
        return lIlIIllIlIlIll;
    }

    @Override
    protected void parseInjectionPoints(List<AnnotationNode> lIlIIllIIlllll) {
        ModifyConstantInjectionInfo lIlIIllIlIIIII;
        Type lIlIIllIIllllI = Type.getReturnType(lIlIIllIlIIIII.method.desc);
        for (AnnotationNode lIlIIllIlIIIIl : lIlIIllIIlllll) {
            lIlIIllIlIIIII.injectionPoints.add(new BeforeConstant(lIlIIllIlIIIII.getContext(), lIlIIllIlIIIIl, lIlIIllIIllllI.getDescriptor()));
        }
    }
}

