/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer;

import java.util.HashSet;
import java.util.Set;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.meta.MixinRenamed;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.util.Annotations;

public final class InterfaceInfo {
    private final /* synthetic */ String prefix;
    private final /* synthetic */ Type iface;
    private final /* synthetic */ boolean unique;
    private /* synthetic */ Set<String> methods;
    private final /* synthetic */ MixinInfo mixin;

    public int hashCode() {
        InterfaceInfo lllllllllllllllIlllIIlIIlIIIIIll;
        int lllllllllllllllIlllIIlIIlIIIIlII = lllllllllllllllIlllIIlIIlIIIIIll.mixin.hashCode();
        lllllllllllllllIlllIIlIIlIIIIlII = 31 * lllllllllllllllIlllIIlIIlIIIIlII + lllllllllllllllIlllIIlIIlIIIIIll.prefix.hashCode();
        lllllllllllllllIlllIIlIIlIIIIlII = 31 * lllllllllllllllIlllIIlIIlIIIIlII + lllllllllllllllIlllIIlIIlIIIIIll.iface.hashCode();
        return lllllllllllllllIlllIIlIIlIIIIlII;
    }

    public Type getIface() {
        InterfaceInfo lllllllllllllllIlllIIlIIlIlllIll;
        return lllllllllllllllIlllIIlIIlIlllIll.iface;
    }

    private void readInterface(String lllllllllllllllIlllIIlIIllIIIlII) {
        InterfaceInfo lllllllllllllllIlllIIlIIllIIIlIl;
        ClassInfo lllllllllllllllIlllIIlIIllIIIllI = ClassInfo.forName(lllllllllllllllIlllIIlIIllIIIlII);
        for (ClassInfo.Method lllllllllllllllIlllIIlIIllIIlIlI : lllllllllllllllIlllIIlIIllIIIllI.getMethods()) {
            lllllllllllllllIlllIIlIIllIIIlIl.methods.add(lllllllllllllllIlllIIlIIllIIlIlI.toString());
        }
        for (String lllllllllllllllIlllIIlIIllIIlIIl : lllllllllllllllIlllIIlIIllIIIllI.getInterfaces()) {
            lllllllllllllllIlllIIlIIllIIIlIl.readInterface(lllllllllllllllIlllIIlIIllIIlIIl);
        }
    }

    public boolean equals(Object lllllllllllllllIlllIIlIIlIIIlIIl) {
        InterfaceInfo lllllllllllllllIlllIIlIIlIIIlIlI;
        if (lllllllllllllllIlllIIlIIlIIIlIlI == lllllllllllllllIlllIIlIIlIIIlIIl) {
            return true;
        }
        if (lllllllllllllllIlllIIlIIlIIIlIIl == null || lllllllllllllllIlllIIlIIlIIIlIlI.getClass() != lllllllllllllllIlllIIlIIlIIIlIIl.getClass()) {
            return false;
        }
        InterfaceInfo lllllllllllllllIlllIIlIIlIIIlIll = (InterfaceInfo)lllllllllllllllIlllIIlIIlIIIlIIl;
        return lllllllllllllllIlllIIlIIlIIIlIlI.mixin.equals(lllllllllllllllIlllIIlIIlIIIlIll.mixin) && lllllllllllllllIlllIIlIIlIIIlIlI.prefix.equals(lllllllllllllllIlllIIlIIlIIIlIll.prefix) && lllllllllllllllIlllIIlIIlIIIlIlI.iface.equals(lllllllllllllllIlllIIlIIlIIIlIll.iface);
    }

    public String getInternalName() {
        InterfaceInfo lllllllllllllllIlllIIlIIlIllIllI;
        return lllllllllllllllIlllIIlIIlIllIllI.iface.getInternalName();
    }

    public String getPrefix() {
        InterfaceInfo lllllllllllllllIlllIIlIIlIllllll;
        return lllllllllllllllIlllIIlIIlIllllll.prefix;
    }

    static InterfaceInfo fromAnnotation(MixinInfo lllllllllllllllIlllIIlIIlIIllIlI, AnnotationNode lllllllllllllllIlllIIlIIlIIlIlII) {
        String lllllllllllllllIlllIIlIIlIIllIII = (String)Annotations.getValue(lllllllllllllllIlllIIlIIlIIlIlII, "prefix");
        Type lllllllllllllllIlllIIlIIlIIlIlll = (Type)Annotations.getValue(lllllllllllllllIlllIIlIIlIIlIlII, "iface");
        Boolean lllllllllllllllIlllIIlIIlIIlIllI = (Boolean)Annotations.getValue(lllllllllllllllIlllIIlIIlIIlIlII, "unique");
        if (lllllllllllllllIlllIIlIIlIIllIII == null || lllllllllllllllIlllIIlIIlIIlIlll == null) {
            throw new InvalidMixinException((IMixinInfo)lllllllllllllllIlllIIlIIlIIllIlI, String.format("@Interface annotation on %s is missing a required parameter", lllllllllllllllIlllIIlIIlIIllIlI));
        }
        return new InterfaceInfo(lllllllllllllllIlllIIlIIlIIllIlI, lllllllllllllllIlllIIlIIlIIllIII, lllllllllllllllIlllIIlIIlIIlIlll, lllllllllllllllIlllIIlIIlIIlIllI != null && lllllllllllllllIlllIIlIIlIIlIllI != false);
    }

    private InterfaceInfo(MixinInfo lllllllllllllllIlllIIlIIllIllIll, String lllllllllllllllIlllIIlIIllIlIlIl, Type lllllllllllllllIlllIIlIIllIlIlII, boolean lllllllllllllllIlllIIlIIllIllIII) {
        InterfaceInfo lllllllllllllllIlllIIlIIllIlllII;
        if (lllllllllllllllIlllIIlIIllIlIlIl == null || lllllllllllllllIlllIIlIIllIlIlIl.length() < 2 || !lllllllllllllllIlllIIlIIllIlIlIl.endsWith("$")) {
            throw new InvalidMixinException((IMixinInfo)lllllllllllllllIlllIIlIIllIllIll, String.format("Prefix %s for iface %s is not valid", lllllllllllllllIlllIIlIIllIlIlIl, lllllllllllllllIlllIIlIIllIlIlII.toString()));
        }
        lllllllllllllllIlllIIlIIllIlllII.mixin = lllllllllllllllIlllIIlIIllIllIll;
        lllllllllllllllIlllIIlIIllIlllII.prefix = lllllllllllllllIlllIIlIIllIlIlIl;
        lllllllllllllllIlllIIlIIllIlllII.iface = lllllllllllllllIlllIIlIIllIlIlII;
        lllllllllllllllIlllIIlIIllIlllII.unique = lllllllllllllllIlllIIlIIllIllIII;
    }

    public boolean isUnique() {
        InterfaceInfo lllllllllllllllIlllIIlIIlIllIIlI;
        return lllllllllllllllIlllIIlIIlIllIIlI.unique;
    }

    private void initMethods() {
        InterfaceInfo lllllllllllllllIlllIIlIIllIlIIIl;
        lllllllllllllllIlllIIlIIllIlIIIl.methods = new HashSet<String>();
        lllllllllllllllIlllIIlIIllIlIIIl.readInterface(lllllllllllllllIlllIIlIIllIlIIIl.iface.getInternalName());
    }

    public String getName() {
        InterfaceInfo lllllllllllllllIlllIIlIIlIlllIIl;
        return lllllllllllllllIlllIIlIIlIlllIIl.iface.getClassName();
    }

    private void decorateUniqueMethod(MethodNode lllllllllllllllIlllIIlIIlIlIIIII) {
        InterfaceInfo lllllllllllllllIlllIIlIIlIlIIIll;
        if (!lllllllllllllllIlllIIlIIlIlIIIll.unique) {
            return;
        }
        if (Annotations.getVisible(lllllllllllllllIlllIIlIIlIlIIIII, Unique.class) == null) {
            Annotations.setVisible(lllllllllllllllIlllIIlIIlIlIIIII, Unique.class, new Object[0]);
            lllllllllllllllIlllIIlIIlIlIIIll.mixin.getClassInfo().findMethod(lllllllllllllllIlllIIlIIlIlIIIII).setUnique(true);
        }
    }

    public boolean renameMethod(MethodNode lllllllllllllllIlllIIlIIlIlIllII) {
        InterfaceInfo lllllllllllllllIlllIIlIIlIlIllIl;
        if (lllllllllllllllIlllIIlIIlIlIllIl.methods == null) {
            lllllllllllllllIlllIIlIIlIlIllIl.initMethods();
        }
        if (!lllllllllllllllIlllIIlIIlIlIllII.name.startsWith(lllllllllllllllIlllIIlIIlIlIllIl.prefix)) {
            if (lllllllllllllllIlllIIlIIlIlIllIl.methods.contains(String.valueOf(new StringBuilder().append(lllllllllllllllIlllIIlIIlIlIllII.name).append(lllllllllllllllIlllIIlIIlIlIllII.desc)))) {
                lllllllllllllllIlllIIlIIlIlIllIl.decorateUniqueMethod(lllllllllllllllIlllIIlIIlIlIllII);
            }
            return false;
        }
        String lllllllllllllllIlllIIlIIlIlIlIll = lllllllllllllllIlllIIlIIlIlIllII.name.substring(lllllllllllllllIlllIIlIIlIlIllIl.prefix.length());
        String lllllllllllllllIlllIIlIIlIlIlIlI = String.valueOf(new StringBuilder().append(lllllllllllllllIlllIIlIIlIlIlIll).append(lllllllllllllllIlllIIlIIlIlIllII.desc));
        if (!lllllllllllllllIlllIIlIIlIlIllIl.methods.contains(lllllllllllllllIlllIIlIIlIlIlIlI)) {
            throw new InvalidMixinException((IMixinInfo)lllllllllllllllIlllIIlIIlIlIllIl.mixin, String.format("%s does not exist in target interface %s", lllllllllllllllIlllIIlIIlIlIlIll, lllllllllllllllIlllIIlIIlIlIllIl.getName()));
        }
        if ((lllllllllllllllIlllIIlIIlIlIllII.access & 1) == 0) {
            throw new InvalidMixinException((IMixinInfo)lllllllllllllllIlllIIlIIlIlIllIl.mixin, String.format("%s cannot implement %s because it is not visible", lllllllllllllllIlllIIlIIlIlIlIll, lllllllllllllllIlllIIlIIlIlIllIl.getName()));
        }
        Annotations.setVisible(lllllllllllllllIlllIIlIIlIlIllII, MixinRenamed.class, "originalName", lllllllllllllllIlllIIlIIlIlIllII.name, "isInterfaceMember", true);
        lllllllllllllllIlllIIlIIlIlIllIl.decorateUniqueMethod(lllllllllllllllIlllIIlIIlIlIllII);
        lllllllllllllllIlllIIlIIlIlIllII.name = lllllllllllllllIlllIIlIIlIlIlIll;
        return true;
    }
}

