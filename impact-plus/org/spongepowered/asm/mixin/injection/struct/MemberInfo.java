/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Objects
 *  com.google.common.base.Strings
 */
package org.spongepowered.asm.mixin.injection.struct;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.mixin.injection.struct.InvalidMemberDescriptorException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.refmap.IReferenceMapper;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.asm.util.SignaturePrinter;

public final class MemberInfo {
    public final /* synthetic */ String desc;
    public final /* synthetic */ String owner;
    public final /* synthetic */ String name;
    private final /* synthetic */ boolean forceField;
    private final /* synthetic */ String unparsed;
    public final /* synthetic */ boolean matchAll;

    public boolean matches(String lIlIIllllIIlIlI, String lIlIIllllIIlIIl, String lIlIIllllIIIlII) {
        MemberInfo lIlIIllllIIIlll;
        return lIlIIllllIIIlll.matches(lIlIIllllIIlIlI, lIlIIllllIIlIIl, lIlIIllllIIIlII, 0);
    }

    public int hashCode() {
        MemberInfo lIlIIllIIIlllll;
        return Objects.hashCode((Object[])new Object[]{lIlIIllIIIlllll.matchAll, lIlIIllIIIlllll.owner, lIlIIllIIIlllll.name, lIlIIllIIIlllll.desc});
    }

    public MemberInfo(IMapping<?> lIlIlIlIlIIIIlI) {
        MemberInfo lIlIlIlIlIIIlIl;
        lIlIlIlIlIIIlIl.owner = lIlIlIlIlIIIIlI.getOwner();
        lIlIlIlIlIIIlIl.name = lIlIlIlIlIIIIlI.getSimpleName();
        lIlIlIlIlIIIlIl.desc = lIlIlIlIlIIIIlI.getDesc();
        lIlIlIlIlIIIlIl.matchAll = false;
        lIlIlIlIlIIIlIl.forceField = lIlIlIlIlIIIIlI.getType() == IMapping.Type.FIELD;
        lIlIlIlIlIIIlIl.unparsed = null;
    }

    public String toCtorDesc() {
        MemberInfo lIlIlIIlIIlIllI;
        if (lIlIlIIlIIlIllI.desc != null && lIlIlIIlIIlIllI.desc.startsWith("(") && lIlIlIIlIIlIllI.desc.indexOf(41) > -1) {
            return String.valueOf(new StringBuilder().append(lIlIlIIlIIlIllI.desc.substring(0, lIlIlIIlIIlIllI.desc.indexOf(41) + 1)).append("V"));
        }
        return null;
    }

    public MappingMethod asMethodMapping() {
        MemberInfo lIlIlIIIlIllIIl;
        if (!lIlIlIIIlIllIIl.isFullyQualified()) {
            throw new MixinException(String.valueOf(new StringBuilder().append("Cannot convert unqualified reference ").append(lIlIlIIIlIllIIl).append(" to MethodMapping")));
        }
        if (lIlIlIIIlIllIIl.isField()) {
            throw new MixinException(String.valueOf(new StringBuilder().append("Cannot convert a non-method reference ").append(lIlIlIIIlIllIIl).append(" to MethodMapping")));
        }
        return new MappingMethod(lIlIlIIIlIllIIl.owner, lIlIlIIIlIllIIl.name, lIlIlIIIlIllIIl.desc);
    }

    public MemberInfo(String lIlIlIllIIlIllI, String lIlIlIllIIlIlIl, String lIlIlIllIIIllll, boolean lIlIlIllIIIlllI) {
        lIlIlIllIIlIIlI(lIlIlIllIIlIllI, lIlIlIllIIlIlIl, lIlIlIllIIIllll, lIlIlIllIIIlllI, null);
        MemberInfo lIlIlIllIIlIIlI;
    }

    public String toCtorType() {
        MemberInfo lIlIlIIlIllIIlI;
        if (lIlIlIIlIllIIlI.unparsed == null) {
            return null;
        }
        String lIlIlIIlIllIIIl = lIlIlIIlIllIIlI.getReturnType();
        if (lIlIlIIlIllIIIl != null) {
            return lIlIlIIlIllIIIl;
        }
        if (lIlIlIIlIllIIlI.owner != null) {
            return lIlIlIIlIllIIlI.owner;
        }
        if (lIlIlIIlIllIIlI.name != null && lIlIlIIlIllIIlI.desc == null) {
            return lIlIlIIlIllIIlI.name;
        }
        return lIlIlIIlIllIIlI.desc != null ? lIlIlIIlIllIIlI.desc : lIlIlIIlIllIIlI.unparsed;
    }

    public IMapping<?> asMapping() {
        MemberInfo lIlIlIIIllIlIII;
        return lIlIlIIIllIlIII.isField() ? lIlIlIIIllIlIII.asFieldMapping() : lIlIlIIIllIlIII.asMethodMapping();
    }

    public static MemberInfo parse(String lIlIIlIlIlIIIll, IMixinContext lIlIIlIlIlIIIIl) {
        return MemberInfo.parse(lIlIIlIlIlIIIll, lIlIIlIlIlIIIIl.getReferenceMapper(), lIlIIlIlIlIIIIl.getClassRef());
    }

    public static MemberInfo parseAndValidate(String lIlIIlIllIlIlII) throws InvalidMemberDescriptorException {
        return MemberInfo.parse(lIlIIlIllIlIlII, null, null).validate();
    }

    public static MemberInfo parseAndValidate(String lIlIIlIllIIIllI, IMixinContext lIlIIlIllIIIlII) throws InvalidMemberDescriptorException {
        return MemberInfo.parse(lIlIIlIllIIIllI, lIlIIlIllIIIlII.getReferenceMapper(), lIlIIlIllIIIlII.getClassRef()).validate();
    }

    @Deprecated
    public String toSrg() {
        MemberInfo lIlIlIIllIIIIll;
        if (!lIlIlIIllIIIIll.isFullyQualified()) {
            throw new MixinException("Cannot convert unqualified reference to SRG mapping");
        }
        if (lIlIlIIllIIIIll.desc.startsWith("(")) {
            return String.valueOf(new StringBuilder().append(lIlIlIIllIIIIll.owner).append("/").append(lIlIlIIllIIIIll.name).append(" ").append(lIlIlIIllIIIIll.desc));
        }
        return String.valueOf(new StringBuilder().append(lIlIlIIllIIIIll.owner).append("/").append(lIlIlIIllIIIIll.name));
    }

    public MemberInfo(String lIlIlIlllIIlllI, boolean lIlIlIlllIIllIl) {
        lIlIlIlllIIllll(lIlIlIlllIIlllI, null, null, lIlIlIlllIIllIl);
        MemberInfo lIlIlIlllIIllll;
    }

    public MemberInfo(String lIlIlIllIlIlIll, String lIlIlIllIlIIlII, String lIlIlIllIlIIIll) {
        lIlIlIllIlIIllI(lIlIlIllIlIlIll, lIlIlIllIlIIlII, lIlIlIllIlIIIll, false);
        MemberInfo lIlIlIllIlIIllI;
    }

    public boolean equals(Object lIlIIllIIlIlIlI) {
        MemberInfo lIlIIllIIlIlllI;
        if (lIlIIllIIlIlIlI == null || lIlIIllIIlIlIlI.getClass() != MemberInfo.class) {
            return false;
        }
        MemberInfo lIlIIllIIlIllII = (MemberInfo)lIlIIllIIlIlIlI;
        return lIlIIllIIlIlllI.matchAll == lIlIIllIIlIllII.matchAll && lIlIIllIIlIlllI.forceField == lIlIIllIIlIllII.forceField && Objects.equal((Object)lIlIIllIIlIlllI.owner, (Object)lIlIIllIIlIllII.owner) && Objects.equal((Object)lIlIIllIIlIlllI.name, (Object)lIlIIllIIlIllII.name) && Objects.equal((Object)lIlIIllIIlIlllI.desc, (Object)lIlIIllIIlIllII.desc);
    }

    public boolean isConstructor() {
        MemberInfo lIlIlIIIIlIlIIl;
        return "<init>".equals(lIlIlIIIIlIlIIl.name);
    }

    public boolean matches(String lIlIIlllIIlIlII, String lIlIIlllIIlIIll, String lIlIIlllIIIlIII, int lIlIIlllIIlIIII) {
        MemberInfo lIlIIlllIIlIllI;
        if (lIlIIlllIIlIllI.desc != null && lIlIIlllIIIlIII != null && !lIlIIlllIIlIllI.desc.equals(lIlIIlllIIIlIII)) {
            return false;
        }
        if (lIlIIlllIIlIllI.name != null && lIlIIlllIIlIIll != null && !lIlIIlllIIlIllI.name.equals(lIlIIlllIIlIIll)) {
            return false;
        }
        if (lIlIIlllIIlIllI.owner != null && lIlIIlllIIlIlII != null && !lIlIIlllIIlIllI.owner.equals(lIlIIlllIIlIlII)) {
            return false;
        }
        return lIlIIlllIIlIIII == 0 || lIlIIlllIIlIllI.matchAll;
    }

    public String toDescriptor() {
        MemberInfo lIlIlIIlIllIllI;
        if (lIlIlIIlIllIllI.desc == null) {
            return "";
        }
        return new SignaturePrinter(lIlIlIIlIllIllI).setFullyQualified(true).toDescriptor();
    }

    public MappingField asFieldMapping() {
        MemberInfo lIlIlIIIlIIIlll;
        if (!lIlIlIIIlIIIlll.isField()) {
            throw new MixinException(String.valueOf(new StringBuilder().append("Cannot convert non-field reference ").append(lIlIlIIIlIIIlll).append(" to FieldMapping")));
        }
        return new MappingField(lIlIlIIIlIIIlll.owner, lIlIlIIIlIIIlll.name, lIlIlIIIlIIIlll.desc);
    }

    public MemberInfo(String lIlIlIlllIIIlll, String lIlIlIlllIIIIlI, boolean lIlIlIlllIIIIIl) {
        lIlIlIlllIIlIII(lIlIlIlllIIIlll, lIlIlIlllIIIIlI, null, lIlIlIlllIIIIIl);
        MemberInfo lIlIlIlllIIlIII;
    }

    public static MemberInfo fromMapping(IMapping<?> lIlIIlIIIlIlIIl) {
        return new MemberInfo(lIlIIlIIIlIlIIl);
    }

    public boolean isField() {
        MemberInfo lIlIlIIIIllIlII;
        return lIlIlIIIIllIlII.forceField || lIlIlIIIIllIlII.desc != null && !lIlIlIIIIllIlII.desc.startsWith("(");
    }

    public boolean isInitialiser() {
        MemberInfo lIlIlIIIIIIIllI;
        return lIlIlIIIIIIIllI.isConstructor() || lIlIlIIIIIIIllI.isClassInitialiser();
    }

    public MemberInfo validate() throws InvalidMemberDescriptorException {
        MemberInfo lIlIIllllIllIII;
        if (lIlIIllllIllIII.owner != null) {
            if (!lIlIIllllIllIII.owner.matches("(?i)^[\\w\\p{Sc}/]+$")) {
                throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append("Invalid owner: ").append(lIlIIllllIllIII.owner)));
            }
            try {
                if (!lIlIIllllIllIII.owner.equals(Type.getType(lIlIIllllIllIII.owner).getDescriptor())) {
                    throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append("Invalid owner type specified: ").append(lIlIIllllIllIII.owner)));
                }
            }
            catch (Exception lIlIIllllIllllI) {
                throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append("Invalid owner type specified: ").append(lIlIIllllIllIII.owner)));
            }
        }
        if (lIlIIllllIllIII.name != null && !lIlIIllllIllIII.name.matches("(?i)^<?[\\w\\p{Sc}]+>?$")) {
            throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append("Invalid name: ").append(lIlIIllllIllIII.name)));
        }
        if (lIlIIllllIllIII.desc != null) {
            if (!lIlIIllllIllIII.desc.matches("^(\\([\\w\\p{Sc}\\[/;]*\\))?\\[*[\\w\\p{Sc}/;]+$")) {
                throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lIlIIllllIllIII.desc)));
            }
            if (lIlIIllllIllIII.isField()) {
                if (!lIlIIllllIllIII.desc.equals(Type.getType(lIlIIllllIllIII.desc).getDescriptor())) {
                    throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append("Invalid field type in descriptor: ").append(lIlIIllllIllIII.desc)));
                }
            } else {
                try {
                    Type.getArgumentTypes(lIlIIllllIllIII.desc);
                }
                catch (Exception lIlIIllllIlllIl) {
                    throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lIlIIllllIllIII.desc)));
                }
                String lIlIIllllIllIlI = lIlIIllllIllIII.desc.substring(lIlIIllllIllIII.desc.indexOf(41) + 1);
                try {
                    Type lIlIIllllIlllII = Type.getType(lIlIIllllIllIlI);
                    if (!lIlIIllllIllIlI.equals(lIlIIllllIlllII.getDescriptor())) {
                        throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append("Invalid return type \"").append(lIlIIllllIllIlI).append("\" in descriptor: ").append(lIlIIllllIllIII.desc)));
                    }
                }
                catch (Exception lIlIIllllIllIll) {
                    throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append("Invalid return type \"").append(lIlIIllllIllIlI).append("\" in descriptor: ").append(lIlIIllllIllIII.desc)));
                }
            }
        }
        return lIlIIllllIllIII;
    }

    public MemberInfo remapUsing(MappingMethod lIlIIlIllIllIlI, boolean lIlIIlIllIlIllI) {
        MemberInfo lIlIIlIllIllIII;
        return new MemberInfo(lIlIIlIllIllIII, lIlIIlIllIllIlI, lIlIIlIllIlIllI);
    }

    private static MemberInfo parse(String lIlIIlIIlIIlIII, IReferenceMapper lIlIIlIIIllIlIl, String lIlIIlIIlIIIlII) {
        boolean lIlIIlIIIllIlll;
        String lIlIIlIIlIIIIlI = null;
        String lIlIIlIIlIIIIII = null;
        String lIlIIlIIIlllllI = Strings.nullToEmpty((String)lIlIIlIIlIIlIII).replaceAll("\\s", "");
        if (lIlIIlIIIllIlIl != null) {
            lIlIIlIIIlllllI = lIlIIlIIIllIlIl.remap(lIlIIlIIlIIIlII, lIlIIlIIIlllllI);
        }
        int lIlIIlIIIllllII = lIlIIlIIIlllllI.lastIndexOf(46);
        int lIlIIlIIIlllIlI = lIlIIlIIIlllllI.indexOf(59);
        if (lIlIIlIIIllllII > -1) {
            lIlIIlIIlIIIIII = lIlIIlIIIlllllI.substring(0, lIlIIlIIIllllII).replace('.', '/');
            lIlIIlIIIlllllI = lIlIIlIIIlllllI.substring(lIlIIlIIIllllII + 1);
        } else if (lIlIIlIIIlllIlI > -1 && lIlIIlIIIlllllI.startsWith("L")) {
            lIlIIlIIlIIIIII = lIlIIlIIIlllllI.substring(1, lIlIIlIIIlllIlI).replace('.', '/');
            lIlIIlIIIlllllI = lIlIIlIIIlllllI.substring(lIlIIlIIIlllIlI + 1);
        }
        int lIlIIlIIIlllIIl = lIlIIlIIIlllllI.indexOf(40);
        int lIlIIlIIIlllIII = lIlIIlIIIlllllI.indexOf(58);
        if (lIlIIlIIIlllIIl > -1) {
            lIlIIlIIlIIIIlI = lIlIIlIIIlllllI.substring(lIlIIlIIIlllIIl);
            lIlIIlIIIlllllI = lIlIIlIIIlllllI.substring(0, lIlIIlIIIlllIIl);
        } else if (lIlIIlIIIlllIII > -1) {
            lIlIIlIIlIIIIlI = lIlIIlIIIlllllI.substring(lIlIIlIIIlllIII + 1);
            lIlIIlIIIlllllI = lIlIIlIIIlllllI.substring(0, lIlIIlIIIlllIII);
        }
        if ((lIlIIlIIIlllllI.indexOf(47) > -1 || lIlIIlIIIlllllI.indexOf(46) > -1) && lIlIIlIIlIIIIII == null) {
            lIlIIlIIlIIIIII = lIlIIlIIIlllllI;
            lIlIIlIIIlllllI = "";
        }
        if (lIlIIlIIIllIlll = lIlIIlIIIlllllI.endsWith("*")) {
            lIlIIlIIIlllllI = lIlIIlIIIlllllI.substring(0, lIlIIlIIIlllllI.length() - 1);
        }
        if (lIlIIlIIIlllllI.isEmpty()) {
            lIlIIlIIIlllllI = null;
        }
        return new MemberInfo(lIlIIlIIIlllllI, lIlIIlIIlIIIIII, lIlIIlIIlIIIIlI, lIlIIlIIIllIlll, lIlIIlIIlIIlIII);
    }

    private MemberInfo(MemberInfo lIlIlIlIIlllIII, MappingMethod lIlIlIlIIllIlll, boolean lIlIlIlIIlllIlI) {
        MemberInfo lIlIlIlIIlllIIl;
        lIlIlIlIIlllIIl.owner = lIlIlIlIIlllIlI ? lIlIlIlIIllIlll.getOwner() : lIlIlIlIIlllIII.owner;
        lIlIlIlIIlllIIl.name = lIlIlIlIIllIlll.getSimpleName();
        lIlIlIlIIlllIIl.desc = lIlIlIlIIllIlll.getDesc();
        lIlIlIlIIlllIIl.matchAll = lIlIlIlIIlllIII.matchAll;
        lIlIlIlIIlllIIl.forceField = false;
        lIlIlIlIIlllIIl.unparsed = null;
    }

    public MemberInfo(AbstractInsnNode lIlIlIlIlIlIlII) {
        MemberInfo lIlIlIlIlIlIlIl;
        lIlIlIlIlIlIlIl.matchAll = false;
        lIlIlIlIlIlIlIl.forceField = false;
        lIlIlIlIlIlIlIl.unparsed = null;
        if (lIlIlIlIlIlIlII instanceof MethodInsnNode) {
            MethodInsnNode lIlIlIlIlIlIlll = (MethodInsnNode)lIlIlIlIlIlIlII;
            lIlIlIlIlIlIlIl.owner = lIlIlIlIlIlIlll.owner;
            lIlIlIlIlIlIlIl.name = lIlIlIlIlIlIlll.name;
            lIlIlIlIlIlIlIl.desc = lIlIlIlIlIlIlll.desc;
        } else if (lIlIlIlIlIlIlII instanceof FieldInsnNode) {
            FieldInsnNode lIlIlIlIlIlIllI = (FieldInsnNode)lIlIlIlIlIlIlII;
            lIlIlIlIlIlIlIl.owner = lIlIlIlIlIlIllI.owner;
            lIlIlIlIlIlIlIl.name = lIlIlIlIlIlIllI.name;
            lIlIlIlIlIlIlIl.desc = lIlIlIlIlIlIllI.desc;
        } else {
            throw new IllegalArgumentException("insn must be an instance of MethodInsnNode or FieldInsnNode");
        }
    }

    private MemberInfo(MemberInfo lIlIlIlIIllIIIl, String lIlIlIlIIllIIII) {
        MemberInfo lIlIlIlIIllIIlI;
        lIlIlIlIIllIIlI.owner = lIlIlIlIIllIIII;
        lIlIlIlIIllIIlI.name = lIlIlIlIIllIIIl.name;
        lIlIlIlIIllIIlI.desc = lIlIlIlIIllIIIl.desc;
        lIlIlIlIIllIIlI.matchAll = lIlIlIlIIllIIIl.matchAll;
        lIlIlIlIIllIIlI.forceField = lIlIlIlIIllIIIl.forceField;
        lIlIlIlIIllIIlI.unparsed = null;
    }

    public MemberInfo move(String lIlIIlIllllllIl) {
        MemberInfo lIlIIllIIIIIlII;
        if (lIlIIlIllllllIl == null && lIlIIllIIIIIlII.owner == null || lIlIIlIllllllIl != null && lIlIIlIllllllIl.equals(lIlIIllIIIIIlII.owner)) {
            return lIlIIllIIIIIlII;
        }
        return new MemberInfo(lIlIIllIIIIIlII, lIlIIlIllllllIl);
    }

    public boolean isClassInitialiser() {
        MemberInfo lIlIlIIIIIlllII;
        return "<clinit>".equals(lIlIlIIIIIlllII.name);
    }

    public MemberInfo(String lIlIlIlIlllIlII, String lIlIlIlIllIllIl, String lIlIlIlIllIlIll, boolean lIlIlIlIllIlIIl, String lIlIlIlIlllIIII) {
        MemberInfo lIlIlIlIlllIlIl;
        if (lIlIlIlIllIllIl != null && lIlIlIlIllIllIl.contains(".")) {
            throw new IllegalArgumentException("Attempt to instance a MemberInfo with an invalid owner format");
        }
        lIlIlIlIlllIlIl.owner = lIlIlIlIllIllIl;
        lIlIlIlIlllIlIl.name = lIlIlIlIlllIlII;
        lIlIlIlIlllIlIl.desc = lIlIlIlIllIlIll;
        lIlIlIlIlllIlIl.matchAll = lIlIlIlIllIlIIl;
        lIlIlIlIlllIlIl.forceField = false;
        lIlIlIlIlllIlIl.unparsed = lIlIlIlIlllIIII;
    }

    public boolean isFullyQualified() {
        MemberInfo lIlIlIIIIllllIl;
        return lIlIlIIIIllllIl.owner != null && lIlIlIIIIllllIl.name != null && lIlIlIIIIllllIl.desc != null;
    }

    public boolean matches(String lIlIIllIlllIlIl, String lIlIIllIllllIII) {
        MemberInfo lIlIIllIlllIllI;
        return lIlIIllIlllIllI.matches(lIlIIllIlllIlIl, lIlIIllIllllIII, 0);
    }

    public MemberInfo transform(String lIlIIlIlllIIlIl) {
        MemberInfo lIlIIlIlllIIIll;
        if (lIlIIlIlllIIlIl == null && lIlIIlIlllIIIll.desc == null || lIlIIlIlllIIlIl != null && lIlIIlIlllIIlIl.equals(lIlIIlIlllIIIll.desc)) {
            return lIlIIlIlllIIIll;
        }
        return new MemberInfo(lIlIIlIlllIIIll.name, lIlIIlIlllIIIll.owner, lIlIIlIlllIIlIl, lIlIIlIlllIIIll.matchAll);
    }

    public String toString() {
        String lIlIlIlIIIlIlII;
        MemberInfo lIlIlIlIIIllIlI;
        String lIlIlIlIIIllIII = lIlIlIlIIIllIlI.owner != null ? String.valueOf(new StringBuilder().append("L").append(lIlIlIlIIIllIlI.owner).append(";")) : "";
        String lIlIlIlIIIlIllI = lIlIlIlIIIllIlI.name != null ? lIlIlIlIIIllIlI.name : "";
        String lIlIlIlIIIlIlIl = lIlIlIlIIIllIlI.matchAll ? "*" : "";
        String string = lIlIlIlIIIlIlII = lIlIlIlIIIllIlI.desc != null ? lIlIlIlIIIllIlI.desc : "";
        String lIlIlIlIIIlIIll = lIlIlIlIIIlIlII.startsWith("(") ? "" : (lIlIlIlIIIllIlI.desc != null ? ":" : "");
        return String.valueOf(new StringBuilder().append(lIlIlIlIIIllIII).append(lIlIlIlIIIlIllI).append(lIlIlIlIIIlIlIl).append(lIlIlIlIIIlIIll).append(lIlIlIlIIIlIlII));
    }

    public String getReturnType() {
        MemberInfo lIlIlIIIlllIlIl;
        if (lIlIlIIIlllIlIl.desc == null || lIlIlIIIlllIlIl.desc.indexOf(41) == -1 || lIlIlIIIlllIlIl.desc.indexOf(40) != 0) {
            return null;
        }
        String lIlIlIIIlllIIlI = lIlIlIIIlllIlIl.desc.substring(lIlIlIIIlllIlIl.desc.indexOf(41) + 1);
        if (lIlIlIIIlllIIlI.startsWith("L") && lIlIlIIIlllIIlI.endsWith(";")) {
            return lIlIlIIIlllIIlI.substring(1, lIlIlIIIlllIIlI.length() - 1);
        }
        return lIlIlIIIlllIIlI;
    }

    public static MemberInfo parse(String lIlIIlIlIllIIIl) {
        return MemberInfo.parse(lIlIIlIlIllIIIl, null, null);
    }

    public boolean matches(String lIlIIllIlIIllIl, String lIlIIllIlIIlIll, int lIlIIllIlIlIIIl) {
        MemberInfo lIlIIllIlIlIlII;
        return !(lIlIIllIlIlIlII.name != null && !lIlIIllIlIlIlII.name.equals(lIlIIllIlIIllIl) || lIlIIllIlIlIlII.desc != null && (lIlIIllIlIIlIll == null || !lIlIIllIlIIlIll.equals(lIlIIllIlIlIlII.desc)) || lIlIIllIlIlIIIl != 0 && !lIlIIllIlIlIlII.matchAll);
    }
}

