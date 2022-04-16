/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  com.google.common.collect.ImmutableSet
 *  org.apache.logging.log4j.LogManager
 */
package org.spongepowered.asm.mixin.gen;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.AccessorGenerator;
import org.spongepowered.asm.mixin.gen.AccessorGeneratorFieldGetter;
import org.spongepowered.asm.mixin.gen.AccessorGeneratorFieldSetter;
import org.spongepowered.asm.mixin.gen.AccessorGeneratorMethodProxy;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.gen.InvokerInfo;
import org.spongepowered.asm.mixin.gen.throwables.InvalidAccessorException;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.struct.SpecialMethodInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;

public class AccessorInfo
extends SpecialMethodInfo {
    protected final /* synthetic */ MemberInfo target;
    protected final /* synthetic */ AccessorType type;
    private final /* synthetic */ Type targetFieldType;
    protected final /* synthetic */ Type returnType;
    protected /* synthetic */ MethodNode targetMethod;
    protected /* synthetic */ FieldNode targetField;
    protected static final /* synthetic */ Pattern PATTERN_ACCESSOR;
    protected final /* synthetic */ Type[] argTypes;

    private static <TNode> String getNodeName(TNode llllllllllllllllIIIlIlIllIIllIIl) {
        return llllllllllllllllIIIlIlIllIIllIIl instanceof MethodNode ? ((MethodNode)llllllllllllllllIIIlIlIllIIllIIl).name : (llllllllllllllllIIIlIlIllIIllIIl instanceof FieldNode ? ((FieldNode)llllllllllllllllIIIlIlIllIIllIIl).name : null);
    }

    private static <TNode> String getNodeDesc(TNode llllllllllllllllIIIlIlIllIIlllII) {
        return llllllllllllllllIIIlIlIllIIlllII instanceof MethodNode ? ((MethodNode)llllllllllllllllIIIlIlIllIIlllII).desc : (llllllllllllllllIIIlIlIllIIlllII instanceof FieldNode ? ((FieldNode)llllllllllllllllIIIlIlIllIIlllII).desc : null);
    }

    protected MemberInfo initTarget() {
        AccessorInfo llllllllllllllllIIIlIllIIIIIIIll;
        MemberInfo llllllllllllllllIIIlIllIIIIIIlII = new MemberInfo(llllllllllllllllIIIlIllIIIIIIIll.getTargetName(), null, llllllllllllllllIIIlIllIIIIIIIll.targetFieldType.getDescriptor());
        llllllllllllllllIIIlIllIIIIIIIll.annotation.visit("target", llllllllllllllllIIIlIllIIIIIIlII.toString());
        return llllllllllllllllIIIlIllIIIIIIlII;
    }

    protected AccessorInfo(MixinTargetContext llllllllllllllllIIIlIllIIIIlIlII, MethodNode llllllllllllllllIIIlIllIIIIIllll, Class<? extends Annotation> llllllllllllllllIIIlIllIIIIlIIlI) {
        super(llllllllllllllllIIIlIllIIIIlIlII, llllllllllllllllIIIlIllIIIIIllll, Annotations.getVisible(llllllllllllllllIIIlIllIIIIIllll, llllllllllllllllIIIlIllIIIIlIIlI));
        AccessorInfo llllllllllllllllIIIlIllIIIIlIlIl;
        llllllllllllllllIIIlIllIIIIlIlIl.argTypes = Type.getArgumentTypes(llllllllllllllllIIIlIllIIIIIllll.desc);
        llllllllllllllllIIIlIllIIIIlIlIl.returnType = Type.getReturnType(llllllllllllllllIIIlIllIIIIIllll.desc);
        llllllllllllllllIIIlIllIIIIlIlIl.type = llllllllllllllllIIIlIllIIIIlIlIl.initType();
        llllllllllllllllIIIlIllIIIIlIlIl.targetFieldType = llllllllllllllllIIIlIllIIIIlIlIl.initTargetFieldType();
        llllllllllllllllIIIlIllIIIIlIlIl.target = llllllllllllllllIIIlIllIIIIlIlIl.initTarget();
    }

    protected String inflectTarget() {
        AccessorInfo llllllllllllllllIIIlIlIlllllIllI;
        return AccessorInfo.inflectTarget(llllllllllllllllIIIlIlIlllllIllI.method.name, llllllllllllllllIIIlIlIlllllIllI.type, llllllllllllllllIIIlIlIlllllIllI.toString(), llllllllllllllllIIIlIlIlllllIllI.mixin, llllllllllllllllIIIlIlIlllllIllI.mixin.getEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERBOSE));
    }

    public final MethodNode getTargetMethod() {
        AccessorInfo llllllllllllllllIIIlIlIlllIIllII;
        return llllllllllllllllIIIlIlIlllIIllII.targetMethod;
    }

    public static AccessorInfo of(MixinTargetContext llllllllllllllllIIIlIlIllIIlIlIl, MethodNode llllllllllllllllIIIlIlIllIIlIlII, Class<? extends Annotation> llllllllllllllllIIIlIlIllIIlIIll) {
        if (llllllllllllllllIIIlIlIllIIlIIll == Accessor.class) {
            return new AccessorInfo(llllllllllllllllIIIlIlIllIIlIlIl, llllllllllllllllIIIlIlIllIIlIlII);
        }
        if (llllllllllllllllIIIlIlIllIIlIIll == Invoker.class) {
            return new InvokerInfo(llllllllllllllllIIIlIlIllIIlIlIl, llllllllllllllllIIIlIlIllIIlIlII);
        }
        throw new InvalidAccessorException((IMixinContext)llllllllllllllllIIIlIlIllIIlIlIl, String.valueOf(new StringBuilder().append("Could not parse accessor for unknown type ").append(llllllllllllllllIIIlIlIllIIlIIll.getName())));
    }

    private FieldNode findTargetField() {
        AccessorInfo llllllllllllllllIIIlIlIllIlllIII;
        return llllllllllllllllIIIlIlIllIlllIII.findTarget(llllllllllllllllIIIlIlIllIlllIII.classNode.fields);
    }

    public final Type[] getArgTypes() {
        AccessorInfo llllllllllllllllIIIlIlIlllIIIllI;
        return llllllllllllllllIIIlIlIlllIIIllI.argTypes;
    }

    public final Type getReturnType() {
        AccessorInfo llllllllllllllllIIIlIlIlllIIlIlI;
        return llllllllllllllllIIIlIlIlllIIlIlI.returnType;
    }

    private static boolean isUpperCase(String llllllllllllllllIIIlIlIllIIIIlll) {
        return llllllllllllllllIIIlIlIllIIIIlll.toUpperCase().equals(llllllllllllllllIIIlIlIllIIIIlll);
    }

    protected <TNode> TNode findTarget(List<TNode> llllllllllllllllIIIlIlIllIlIIlIl) {
        AccessorInfo llllllllllllllllIIIlIlIllIlIlIll;
        TNode llllllllllllllllIIIlIlIllIlIlIIl = null;
        ArrayList<TNode> llllllllllllllllIIIlIlIllIlIlIII = new ArrayList<TNode>();
        for (TNode llllllllllllllllIIIlIlIllIlIllII : llllllllllllllllIIIlIlIllIlIIlIl) {
            String llllllllllllllllIIIlIlIllIlIllIl;
            String llllllllllllllllIIIlIlIllIlIlllI = AccessorInfo.getNodeDesc(llllllllllllllllIIIlIlIllIlIllII);
            if (llllllllllllllllIIIlIlIllIlIlllI == null || !llllllllllllllllIIIlIlIllIlIlllI.equals(llllllllllllllllIIIlIlIllIlIlIll.target.desc) || (llllllllllllllllIIIlIlIllIlIllIl = AccessorInfo.getNodeName(llllllllllllllllIIIlIlIllIlIllII)) == null) continue;
            if (llllllllllllllllIIIlIlIllIlIllIl.equals(llllllllllllllllIIIlIlIllIlIlIll.target.name)) {
                llllllllllllllllIIIlIlIllIlIlIIl = llllllllllllllllIIIlIlIllIlIllII;
            }
            if (!llllllllllllllllIIIlIlIllIlIllIl.equalsIgnoreCase(llllllllllllllllIIIlIlIllIlIlIll.target.name)) continue;
            llllllllllllllllIIIlIlIllIlIlIII.add(llllllllllllllllIIIlIlIllIlIllII);
        }
        if (llllllllllllllllIIIlIlIllIlIlIIl != null) {
            if (llllllllllllllllIIIlIlIllIlIlIII.size() > 1) {
                LogManager.getLogger((String)"mixin").debug("{} found an exact match for {} but other candidates were found!", new Object[]{llllllllllllllllIIIlIlIllIlIlIll, llllllllllllllllIIIlIlIllIlIlIll.target});
            }
            return llllllllllllllllIIIlIlIllIlIlIIl;
        }
        if (llllllllllllllllIIIlIlIllIlIlIII.size() == 1) {
            return (TNode)llllllllllllllllIIIlIlIllIlIlIII.get(0);
        }
        String llllllllllllllllIIIlIlIllIlIIlll = llllllllllllllllIIIlIlIllIlIlIII.size() == 0 ? "No" : "Multiple";
        throw new InvalidAccessorException(llllllllllllllllIIIlIlIllIlIlIll, String.valueOf(new StringBuilder().append(llllllllllllllllIIIlIlIllIlIIlll).append(" candidates were found matching ").append(llllllllllllllllIIIlIlIllIlIlIll.target).append(" in ").append(llllllllllllllllIIIlIlIllIlIlIll.classNode.name).append(" for ").append(llllllllllllllllIIIlIlIllIlIlIll)));
    }

    protected String getTargetName() {
        AccessorInfo llllllllllllllllIIIlIlIlllllllIl;
        String llllllllllllllllIIIlIlIlllllllII = (String)Annotations.getValue(llllllllllllllllIIIlIlIlllllllIl.annotation);
        if (Strings.isNullOrEmpty((String)llllllllllllllllIIIlIlIlllllllII)) {
            String llllllllllllllllIIIlIlIllllllllI = llllllllllllllllIIIlIlIlllllllIl.inflectTarget();
            if (llllllllllllllllIIIlIlIllllllllI == null) {
                throw new InvalidAccessorException((IMixinContext)llllllllllllllllIIIlIlIlllllllIl.mixin, String.valueOf(new StringBuilder().append("Failed to inflect target name for ").append(llllllllllllllllIIIlIlIlllllllIl).append(", supported prefixes: [get, set, is]")));
            }
            return llllllllllllllllIIIlIlIllllllllI;
        }
        return MemberInfo.parse((String)llllllllllllllllIIIlIlIlllllllII, (IMixinContext)llllllllllllllllIIIlIlIlllllllIl.mixin).name;
    }

    public void locate() {
        AccessorInfo llllllllllllllllIIIlIlIlllIIIIII;
        llllllllllllllllIIIlIlIlllIIIIII.targetField = llllllllllllllllIIIlIlIlllIIIIII.findTargetField();
    }

    protected AccessorType initType() {
        AccessorInfo llllllllllllllllIIIlIllIIIIIlIll;
        if (llllllllllllllllIIIlIllIIIIIlIll.returnType.equals(Type.VOID_TYPE)) {
            return AccessorType.FIELD_SETTER;
        }
        return AccessorType.FIELD_GETTER;
    }

    public final FieldNode getTargetField() {
        AccessorInfo llllllllllllllllIIIlIlIlllIIllll;
        return llllllllllllllllIIIlIlIlllIIllll.targetField;
    }

    public MethodNode generate() {
        AccessorInfo llllllllllllllllIIIlIlIllIlllIll;
        MethodNode llllllllllllllllIIIlIlIllIllllII = llllllllllllllllIIIlIlIllIlllIll.type.getGenerator(llllllllllllllllIIIlIlIllIlllIll).generate();
        Bytecode.mergeAnnotations(llllllllllllllllIIIlIlIllIlllIll.method, llllllllllllllllIIIlIlIllIllllII);
        return llllllllllllllllIIIlIlIllIllllII;
    }

    private static String toLowerCase(String llllllllllllllllIIIlIlIllIIIllIl, boolean llllllllllllllllIIIlIlIllIIIllII) {
        return llllllllllllllllIIIlIlIllIIIllII ? llllllllllllllllIIIlIlIllIIIllIl.toLowerCase() : llllllllllllllllIIIlIlIllIIIllIl;
    }

    public String toString() {
        AccessorInfo llllllllllllllllIIIlIlIlllIIIlII;
        return String.format("%s->@%s[%s]::%s%s", llllllllllllllllIIIlIlIlllIIIlII.mixin.toString(), Bytecode.getSimpleName(llllllllllllllllIIIlIlIlllIIIlII.annotation), llllllllllllllllIIIlIlIlllIIIlII.type.toString(), llllllllllllllllIIIlIlIlllIIIlII.method.name, llllllllllllllllIIIlIlIlllIIIlII.method.desc);
    }

    public AccessorInfo(MixinTargetContext llllllllllllllllIIIlIllIIIIllllI, MethodNode llllllllllllllllIIIlIllIIIIllIlI) {
        llllllllllllllllIIIlIllIIIIlllll(llllllllllllllllIIIlIllIIIIllllI, llllllllllllllllIIIlIllIIIIllIlI, Accessor.class);
        AccessorInfo llllllllllllllllIIIlIllIIIIlllll;
    }

    public final MemberInfo getTarget() {
        AccessorInfo llllllllllllllllIIIlIlIlllIlIllI;
        return llllllllllllllllIIIlIlIlllIlIllI.target;
    }

    public static String inflectTarget(String llllllllllllllllIIIlIlIllllIIIIl, AccessorType llllllllllllllllIIIlIlIllllIIllI, String llllllllllllllllIIIlIlIlllIlllll, IMixinContext llllllllllllllllIIIlIlIlllIllllI, boolean llllllllllllllllIIIlIlIlllIlllIl) {
        Matcher llllllllllllllllIIIlIlIllllIIIlI = PATTERN_ACCESSOR.matcher(llllllllllllllllIIIlIlIllllIIIIl);
        if (llllllllllllllllIIIlIlIllllIIIlI.matches()) {
            String llllllllllllllllIIIlIlIllllIlIll = llllllllllllllllIIIlIlIllllIIIlI.group(1);
            String llllllllllllllllIIIlIlIllllIlIlI = llllllllllllllllIIIlIlIllllIIIlI.group(3);
            String llllllllllllllllIIIlIlIllllIlIIl = llllllllllllllllIIIlIlIllllIIIlI.group(4);
            String llllllllllllllllIIIlIlIllllIlIII = String.format("%s%s", AccessorInfo.toLowerCase(llllllllllllllllIIIlIlIllllIlIlI, !AccessorInfo.isUpperCase(llllllllllllllllIIIlIlIllllIlIIl)), llllllllllllllllIIIlIlIllllIlIIl);
            if (!llllllllllllllllIIIlIlIllllIIllI.isExpectedPrefix(llllllllllllllllIIIlIlIllllIlIll) && llllllllllllllllIIIlIlIlllIlllIl) {
                LogManager.getLogger((String)"mixin").warn("Unexpected prefix for {}, found [{}] expecting {}", new Object[]{llllllllllllllllIIIlIlIlllIlllll, llllllllllllllllIIIlIlIllllIlIll, llllllllllllllllIIIlIlIllllIIllI.getExpectedPrefixes()});
            }
            return MemberInfo.parse((String)llllllllllllllllIIIlIlIllllIlIII, (IMixinContext)llllllllllllllllIIIlIlIlllIllllI).name;
        }
        return null;
    }

    static {
        PATTERN_ACCESSOR = Pattern.compile("^(get|set|is|invoke|call)(([A-Z])(.*?))(_\\$md.*)?$");
    }

    protected Type initTargetFieldType() {
        AccessorInfo llllllllllllllllIIIlIllIIIIIlIII;
        switch (llllllllllllllllIIIlIllIIIIIlIII.type) {
            case FIELD_GETTER: {
                if (llllllllllllllllIIIlIllIIIIIlIII.argTypes.length > 0) {
                    throw new InvalidAccessorException((IMixinContext)llllllllllllllllIIIlIllIIIIIlIII.mixin, String.valueOf(new StringBuilder().append(llllllllllllllllIIIlIllIIIIIlIII).append(" must take exactly 0 arguments, found ").append(llllllllllllllllIIIlIllIIIIIlIII.argTypes.length)));
                }
                return llllllllllllllllIIIlIllIIIIIlIII.returnType;
            }
            case FIELD_SETTER: {
                if (llllllllllllllllIIIlIllIIIIIlIII.argTypes.length != 1) {
                    throw new InvalidAccessorException((IMixinContext)llllllllllllllllIIIlIllIIIIIlIII.mixin, String.valueOf(new StringBuilder().append(llllllllllllllllIIIlIllIIIIIlIII).append(" must take exactly 1 argument, found ").append(llllllllllllllllIIIlIllIIIIIlIII.argTypes.length)));
                }
                return llllllllllllllllIIIlIllIIIIIlIII.argTypes[0];
            }
        }
        throw new InvalidAccessorException((IMixinContext)llllllllllllllllIIIlIllIIIIIlIII.mixin, String.valueOf(new StringBuilder().append("Computed unsupported accessor type ").append((Object)llllllllllllllllIIIlIllIIIIIlIII.type).append(" for ").append(llllllllllllllllIIIlIllIIIIIlIII)));
    }

    public final Type getTargetFieldType() {
        AccessorInfo llllllllllllllllIIIlIlIlllIlIIll;
        return llllllllllllllllIIIlIlIlllIlIIll.targetFieldType;
    }

    public static enum AccessorType {
        FIELD_GETTER((Set)ImmutableSet.of((Object)"get", (Object)"is")){
            {
                1 lllIIllIlIlIlIl;
            }

            @Override
            AccessorGenerator getGenerator(AccessorInfo lllIIllIlIIllll) {
                return new AccessorGeneratorFieldGetter(lllIIllIlIIllll);
            }
        }
        ,
        FIELD_SETTER((Set)ImmutableSet.of((Object)"set")){
            {
                2 llllllllllllllllllIIlIIIIIlIIllI;
            }

            @Override
            AccessorGenerator getGenerator(AccessorInfo llllllllllllllllllIIlIIIIIlIIIII) {
                return new AccessorGeneratorFieldSetter(llllllllllllllllllIIlIIIIIlIIIII);
            }
        }
        ,
        METHOD_PROXY((Set)ImmutableSet.of((Object)"call", (Object)"invoke")){
            {
                3 llllllllllllllllllIlllIIIlIIllIl;
            }

            @Override
            AccessorGenerator getGenerator(AccessorInfo llllllllllllllllllIlllIIIlIIIIII) {
                return new AccessorGeneratorMethodProxy(llllllllllllllllllIlllIIIlIIIIII);
            }
        };

        private final /* synthetic */ Set<String> expectedPrefixes;

        abstract AccessorGenerator getGenerator(AccessorInfo var1);

        public String getExpectedPrefixes() {
            AccessorType llIIIlllllIIIl;
            return llIIIlllllIIIl.expectedPrefixes.toString();
        }

        private AccessorType(Set<String> llIIlIIIIIllIl) {
            AccessorType llIIlIIIIIllll;
            llIIlIIIIIllll.expectedPrefixes = llIIlIIIIIllIl;
        }

        public boolean isExpectedPrefix(String llIIIllllllIll) {
            AccessorType llIIlIIIIIIIIl;
            return llIIlIIIIIIIIl.expectedPrefixes.contains(llIIIllllllIll);
        }
    }
}

