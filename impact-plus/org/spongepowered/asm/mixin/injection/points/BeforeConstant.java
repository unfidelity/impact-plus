/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.primitives.Doubles
 *  com.google.common.primitives.Floats
 *  com.google.common.primitives.Ints
 *  com.google.common.primitives.Longs
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.injection.points;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.FrameNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;

@InjectionPoint.AtCode(value="CONSTANT")
public class BeforeConstant
extends InjectionPoint {
    private final /* synthetic */ boolean expand;
    private final /* synthetic */ Long longValue;
    private final /* synthetic */ String matchByType;
    private final /* synthetic */ boolean log;
    private final /* synthetic */ Double doubleValue;
    private final /* synthetic */ boolean nullValue;
    private final /* synthetic */ int ordinal;
    private final /* synthetic */ Float floatValue;
    private final /* synthetic */ Type typeValue;
    private final /* synthetic */ String stringValue;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ int[] expandOpcodes;
    private final /* synthetic */ Integer intValue;

    @Override
    public boolean find(String llIIlIlllllIlll, InsnList llIIlIlllllllII, Collection<AbstractInsnNode> llIIlIllllllIll) {
        BeforeConstant llIIlIllllllIII;
        boolean llIIlIllllllIlI = false;
        llIIlIllllllIII.log("BeforeConstant is searching for constants in method with descriptor {}", llIIlIlllllIlll);
        ListIterator<AbstractInsnNode> llIIlIllllllIIl = llIIlIlllllllII.iterator();
        int llIIllIIIIIIIII = 0;
        int llIIlIlllllllll = 0;
        while (llIIlIllllllIIl.hasNext()) {
            boolean llIIllIIIIIIIIl;
            AbstractInsnNode llIIllIIIIIIIlI = llIIlIllllllIIl.next();
            boolean bl = llIIllIIIIIIIIl = llIIlIllllllIII.expand ? llIIlIllllllIII.matchesConditionalInsn(llIIlIlllllllll, llIIllIIIIIIIlI) : llIIlIllllllIII.matchesConstantInsn(llIIllIIIIIIIlI);
            if (llIIllIIIIIIIIl) {
                llIIlIllllllIII.log("    BeforeConstant found a matching constant{} at ordinal {}", llIIlIllllllIII.matchByType != null ? " TYPE" : " value", llIIllIIIIIIIII);
                if (llIIlIllllllIII.ordinal == -1 || llIIlIllllllIII.ordinal == llIIllIIIIIIIII) {
                    llIIlIllllllIII.log("      BeforeConstant found {}", Bytecode.describeNode(llIIllIIIIIIIlI).trim());
                    llIIlIllllllIll.add(llIIllIIIIIIIlI);
                    llIIlIllllllIlI = true;
                }
                ++llIIllIIIIIIIII;
            }
            if (llIIllIIIIIIIlI instanceof LabelNode || llIIllIIIIIIIlI instanceof FrameNode) continue;
            llIIlIlllllllll = llIIllIIIIIIIlI.getOpcode();
        }
        return llIIlIllllllIlI;
    }

    static {
        logger = LogManager.getLogger((String)"mixin");
    }

    public BeforeConstant(IMixinContext llIIllIIlIlllIl, AnnotationNode llIIllIIlIlllII, String llIIllIIlIlIllI) {
        super(Annotations.getValue(llIIllIIlIlllII, "slice", ""), InjectionPoint.Selector.DEFAULT, null);
        BeforeConstant llIIllIIlIllllI;
        Boolean llIIllIIlIllIlI = Annotations.getValue(llIIllIIlIlllII, "nullValue", (Boolean)null);
        llIIllIIlIllllI.ordinal = Annotations.getValue(llIIllIIlIlllII, "ordinal", -1);
        llIIllIIlIllllI.nullValue = llIIllIIlIllIlI != null && llIIllIIlIllIlI != false;
        llIIllIIlIllllI.intValue = Annotations.getValue(llIIllIIlIlllII, "intValue", (Integer)null);
        llIIllIIlIllllI.floatValue = Annotations.getValue(llIIllIIlIlllII, "floatValue", (Float)null);
        llIIllIIlIllllI.longValue = Annotations.getValue(llIIllIIlIlllII, "longValue", (Long)null);
        llIIllIIlIllllI.doubleValue = Annotations.getValue(llIIllIIlIlllII, "doubleValue", (Double)null);
        llIIllIIlIllllI.stringValue = Annotations.getValue(llIIllIIlIlllII, "stringValue", (String)null);
        llIIllIIlIllllI.typeValue = Annotations.getValue(llIIllIIlIlllII, "classValue", (Type)null);
        llIIllIIlIllllI.matchByType = llIIllIIlIllllI.validateDiscriminator(llIIllIIlIlllIl, llIIllIIlIlIllI, llIIllIIlIllIlI, "on @Constant annotation");
        llIIllIIlIllllI.expandOpcodes = llIIllIIlIllllI.parseExpandOpcodes(Annotations.getValue(llIIllIIlIlllII, "expandZeroConditions", true, Constant.Condition.class));
        llIIllIIlIllllI.expand = llIIllIIlIllllI.expandOpcodes.length > 0;
        llIIllIIlIllllI.log = Annotations.getValue(llIIllIIlIlllII, "log", Boolean.FALSE);
    }

    private int[] parseExpandOpcodes(List<Constant.Condition> llIIllIIIIlIlll) {
        HashSet<Integer> llIIllIIIIlIllI = new HashSet<Integer>();
        for (Constant.Condition llIIllIIIIllIIl : llIIllIIIIlIlll) {
            Constant.Condition llIIllIIIIllIlI = llIIllIIIIllIIl.getEquivalentCondition();
            for (int llIIllIIIIllIll : llIIllIIIIllIlI.getOpcodes()) {
                llIIllIIIIlIllI.add(llIIllIIIIllIll);
            }
        }
        return Ints.toArray(llIIllIIIIlIllI);
    }

    private boolean matchesConditionalInsn(int llIIlIlllIlllll, AbstractInsnNode llIIlIllllIIIIl) {
        BeforeConstant llIIlIllllIIIII;
        for (int llIIlIllllIIlIl : llIIlIllllIIIII.expandOpcodes) {
            int llIIlIllllIIllI = llIIlIllllIIIIl.getOpcode();
            if (llIIlIllllIIllI != llIIlIllllIIlIl) continue;
            if (llIIlIlllIlllll == 148 || llIIlIlllIlllll == 149 || llIIlIlllIlllll == 150 || llIIlIlllIlllll == 151 || llIIlIlllIlllll == 152) {
                llIIlIllllIIIII.log("  BeforeConstant is ignoring {} following {}", Bytecode.getOpcodeName(llIIlIllllIIllI), Bytecode.getOpcodeName(llIIlIlllIlllll));
                return false;
            }
            llIIlIllllIIIII.log("  BeforeConstant found {} instruction", Bytecode.getOpcodeName(llIIlIllllIIllI));
            return true;
        }
        if (llIIlIllllIIIII.intValue != null && llIIlIllllIIIII.intValue == 0 && Bytecode.isConstant(llIIlIllllIIIIl)) {
            Object llIIlIllllIIlII = Bytecode.getConstant(llIIlIllllIIIIl);
            llIIlIllllIIIII.log("  BeforeConstant found INTEGER constant: value = {}", llIIlIllllIIlII);
            return llIIlIllllIIlII instanceof Integer && (Integer)llIIlIllllIIlII == 0;
        }
        return false;
    }

    public BeforeConstant(InjectionPointData llIIllIIlIIIIII) {
        super(llIIllIIlIIIIII);
        BeforeConstant llIIllIIlIIIIIl;
        String llIIllIIlIIIllI = llIIllIIlIIIIII.get("nullValue", null);
        Boolean llIIllIIlIIIlIl = llIIllIIlIIIllI != null ? Boolean.valueOf(Boolean.parseBoolean(llIIllIIlIIIllI)) : null;
        llIIllIIlIIIIIl.ordinal = llIIllIIlIIIIII.getOrdinal();
        llIIllIIlIIIIIl.nullValue = llIIllIIlIIIlIl != null && llIIllIIlIIIlIl != false;
        llIIllIIlIIIIIl.intValue = Ints.tryParse((String)llIIllIIlIIIIII.get("intValue", ""));
        llIIllIIlIIIIIl.floatValue = Floats.tryParse((String)llIIllIIlIIIIII.get("floatValue", ""));
        llIIllIIlIIIIIl.longValue = Longs.tryParse((String)llIIllIIlIIIIII.get("longValue", ""));
        llIIllIIlIIIIIl.doubleValue = Doubles.tryParse((String)llIIllIIlIIIIII.get("doubleValue", ""));
        llIIllIIlIIIIIl.stringValue = llIIllIIlIIIIII.get("stringValue", null);
        String llIIllIIlIIIlII = llIIllIIlIIIIII.get("classValue", null);
        llIIllIIlIIIIIl.typeValue = llIIllIIlIIIlII != null ? Type.getObjectType(llIIllIIlIIIlII.replace('.', '/')) : null;
        llIIllIIlIIIIIl.matchByType = llIIllIIlIIIIIl.validateDiscriminator(llIIllIIlIIIIII.getContext(), "V", llIIllIIlIIIlIl, "in @At(\"CONSTANT\") args");
        if ("V".equals(llIIllIIlIIIIIl.matchByType)) {
            throw new InvalidInjectionException(llIIllIIlIIIIII.getContext(), "No constant discriminator could be parsed in @At(\"CONSTANT\") args");
        }
        ArrayList<Constant.Condition> llIIllIIlIIIIll = new ArrayList<Constant.Condition>();
        String llIIllIIlIIIIlI = llIIllIIlIIIIII.get("expandZeroConditions", "").toLowerCase();
        for (Constant.Condition llIIllIIlIIlIIl : Constant.Condition.values()) {
            if (!llIIllIIlIIIIlI.contains(llIIllIIlIIlIIl.name().toLowerCase())) continue;
            llIIllIIlIIIIll.add(llIIllIIlIIlIIl);
        }
        llIIllIIlIIIIIl.expandOpcodes = llIIllIIlIIIIIl.parseExpandOpcodes(llIIllIIlIIIIll);
        llIIllIIlIIIIIl.expand = llIIllIIlIIIIIl.expandOpcodes.length > 0;
        llIIllIIlIIIIIl.log = llIIllIIlIIIIII.get("log", false);
    }

    private boolean matchesConstantInsn(AbstractInsnNode llIIlIlllIlIIIl) {
        BeforeConstant llIIlIlllIlIIlI;
        if (!Bytecode.isConstant(llIIlIlllIlIIIl)) {
            return false;
        }
        Object llIIlIlllIlIIll = Bytecode.getConstant(llIIlIlllIlIIIl);
        if (llIIlIlllIlIIll == null) {
            llIIlIlllIlIIlI.log("  BeforeConstant found NULL constant: nullValue = {}", llIIlIlllIlIIlI.nullValue);
            return llIIlIlllIlIIlI.nullValue || "Ljava/lang/Object;".equals(llIIlIlllIlIIlI.matchByType);
        }
        if (llIIlIlllIlIIll instanceof Integer) {
            llIIlIlllIlIIlI.log("  BeforeConstant found INTEGER constant: value = {}, intValue = {}", llIIlIlllIlIIll, llIIlIlllIlIIlI.intValue);
            return llIIlIlllIlIIll.equals(llIIlIlllIlIIlI.intValue) || "I".equals(llIIlIlllIlIIlI.matchByType);
        }
        if (llIIlIlllIlIIll instanceof Float) {
            llIIlIlllIlIIlI.log("  BeforeConstant found FLOAT constant: value = {}, floatValue = {}", llIIlIlllIlIIll, llIIlIlllIlIIlI.floatValue);
            return llIIlIlllIlIIll.equals(llIIlIlllIlIIlI.floatValue) || "F".equals(llIIlIlllIlIIlI.matchByType);
        }
        if (llIIlIlllIlIIll instanceof Long) {
            llIIlIlllIlIIlI.log("  BeforeConstant found LONG constant: value = {}, longValue = {}", llIIlIlllIlIIll, llIIlIlllIlIIlI.longValue);
            return llIIlIlllIlIIll.equals(llIIlIlllIlIIlI.longValue) || "J".equals(llIIlIlllIlIIlI.matchByType);
        }
        if (llIIlIlllIlIIll instanceof Double) {
            llIIlIlllIlIIlI.log("  BeforeConstant found DOUBLE constant: value = {}, doubleValue = {}", llIIlIlllIlIIll, llIIlIlllIlIIlI.doubleValue);
            return llIIlIlllIlIIll.equals(llIIlIlllIlIIlI.doubleValue) || "D".equals(llIIlIlllIlIIlI.matchByType);
        }
        if (llIIlIlllIlIIll instanceof String) {
            llIIlIlllIlIIlI.log("  BeforeConstant found STRING constant: value = {}, stringValue = {}", llIIlIlllIlIIll, llIIlIlllIlIIlI.stringValue);
            return llIIlIlllIlIIll.equals(llIIlIlllIlIIlI.stringValue) || "Ljava/lang/String;".equals(llIIlIlllIlIIlI.matchByType);
        }
        if (llIIlIlllIlIIll instanceof Type) {
            llIIlIlllIlIIlI.log("  BeforeConstant found CLASS constant: value = {}, typeValue = {}", llIIlIlllIlIIll, llIIlIlllIlIIlI.typeValue);
            return llIIlIlllIlIIll.equals(llIIlIlllIlIIlI.typeValue) || "Ljava/lang/Class;".equals(llIIlIlllIlIIlI.matchByType);
        }
        return false;
    }

    protected void log(String llIIlIlllIIlIII, Object ... llIIlIlllIIIlll) {
        BeforeConstant llIIlIlllIIlIIl;
        if (llIIlIlllIIlIIl.log) {
            logger.info(llIIlIlllIIlIII, llIIlIlllIIIlll);
        }
    }

    private String validateDiscriminator(IMixinContext llIIllIIIlIlIIl, String llIIllIIIlIlIII, Boolean llIIllIIIlIIlll, String llIIllIIIlIIllI) {
        BeforeConstant llIIllIIIllIIII;
        int llIIllIIIlIlIll = BeforeConstant.count(llIIllIIIlIIlll, llIIllIIIllIIII.intValue, llIIllIIIllIIII.floatValue, llIIllIIIllIIII.longValue, llIIllIIIllIIII.doubleValue, llIIllIIIllIIII.stringValue, llIIllIIIllIIII.typeValue);
        if (llIIllIIIlIlIll == 1) {
            llIIllIIIlIlIII = null;
        } else if (llIIllIIIlIlIll > 1) {
            throw new InvalidInjectionException(llIIllIIIlIlIIl, String.valueOf(new StringBuilder().append("Conflicting constant discriminators specified ").append(llIIllIIIlIIllI).append(" for ").append(llIIllIIIlIlIIl)));
        }
        return llIIllIIIlIlIII;
    }

    private static int count(Object ... llIIlIllIllllll) {
        int llIIlIllIlllllI = 0;
        for (Object llIIlIlllIIIIII : llIIlIllIllllll) {
            if (llIIlIlllIIIIII == null) continue;
            ++llIIlIllIlllllI;
        }
        return llIIlIllIlllllI;
    }
}

