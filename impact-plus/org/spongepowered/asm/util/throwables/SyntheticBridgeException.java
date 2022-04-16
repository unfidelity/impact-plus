/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util.throwables;

import java.util.ListIterator;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.meta.MixinMerged;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.PrettyPrinter;

public class SyntheticBridgeException
extends MixinException {
    private final /* synthetic */ String name;
    private final /* synthetic */ int index;
    private final /* synthetic */ AbstractInsnNode a;
    private static final /* synthetic */ long serialVersionUID = 1L;
    private final /* synthetic */ Problem problem;
    private final /* synthetic */ String desc;
    private final /* synthetic */ AbstractInsnNode b;

    private PrettyPrinter printMethod(PrettyPrinter lllllllllllllllIlllIllIlIllIIlll, MethodNode lllllllllllllllIlllIllIlIlIlllIl) {
        int lllllllllllllllIlllIllIlIllIIIll = 0;
        ListIterator<AbstractInsnNode> lllllllllllllllIlllIllIlIllIlIll = lllllllllllllllIlllIllIlIlIlllIl.instructions.iterator();
        while (lllllllllllllllIlllIllIlIllIlIll.hasNext()) {
            SyntheticBridgeException lllllllllllllllIlllIllIlIllIIIIl;
            lllllllllllllllIlllIllIlIllIIlll.kv(lllllllllllllllIlllIllIlIllIIIll == lllllllllllllllIlllIllIlIllIIIIl.index ? ">>>>" : "", Bytecode.describeNode((AbstractInsnNode)lllllllllllllllIlllIllIlIllIlIll.next()));
            ++lllllllllllllllIlllIllIlIllIIIll;
        }
        return lllllllllllllllIlllIllIlIllIIlll.add();
    }

    public void printAnalysis(IMixinContext lllllllllllllllIlllIllIllIIIIlIl, MethodNode lllllllllllllllIlllIllIllIIIllll, MethodNode lllllllllllllllIlllIllIllIIIIIIl) {
        SyntheticBridgeException lllllllllllllllIlllIllIllIIlIIIl;
        PrettyPrinter lllllllllllllllIlllIllIllIIIllII = new PrettyPrinter();
        lllllllllllllllIlllIllIllIIIllII.addWrapped(100, lllllllllllllllIlllIllIllIIlIIIl.getMessage(), new Object[0]).hr();
        lllllllllllllllIlllIllIllIIIllII.add().kv("Method", String.valueOf(new StringBuilder().append(lllllllllllllllIlllIllIllIIlIIIl.name).append(lllllllllllllllIlllIllIllIIlIIIl.desc))).kv("Problem Type", (Object)lllllllllllllllIlllIllIllIIlIIIl.problem).add().hr();
        String lllllllllllllllIlllIllIllIIIlIlI = (String)Annotations.getValue(Annotations.getVisible(lllllllllllllllIlllIllIllIIIllll, MixinMerged.class), "mixin");
        String lllllllllllllllIlllIllIllIIIlIII = lllllllllllllllIlllIllIllIIIlIlI != null ? lllllllllllllllIlllIllIllIIIlIlI : lllllllllllllllIlllIllIllIIIIlIl.getTargetClassRef().replace('/', '.');
        lllllllllllllllIlllIllIllIIlIIIl.printMethod(lllllllllllllllIlllIllIllIIIllII.add("Existing method").add().kv("Owner", lllllllllllllllIlllIllIllIIIlIII).add(), lllllllllllllllIlllIllIllIIIllll).hr();
        lllllllllllllllIlllIllIllIIlIIIl.printMethod(lllllllllllllllIlllIllIllIIIllII.add("Incoming method").add().kv("Owner", lllllllllllllllIlllIllIllIIIIlIl.getClassRef().replace('/', '.')).add(), lllllllllllllllIlllIllIllIIIIIIl).hr();
        lllllllllllllllIlllIllIllIIlIIIl.printProblem(lllllllllllllllIlllIllIllIIIllII, lllllllllllllllIlllIllIllIIIIlIl, lllllllllllllllIlllIllIllIIIllll, lllllllllllllllIlllIllIllIIIIIIl).print(System.err);
    }

    private PrettyPrinter printTypeComparison(PrettyPrinter lllllllllllllllIlllIllIlIIIIlIlI, String lllllllllllllllIlllIllIlIIIIIlIl, Type lllllllllllllllIlllIllIlIIIIlIII, Type lllllllllllllllIlllIllIlIIIIIIll) {
        lllllllllllllllIlllIllIlIIIIlIlI.kv(String.valueOf(new StringBuilder().append("Target ").append(lllllllllllllllIlllIllIlIIIIIlIl)), "%s", lllllllllllllllIlllIllIlIIIIlIII);
        lllllllllllllllIlllIllIlIIIIlIlI.kv(String.valueOf(new StringBuilder().append("Incoming ").append(lllllllllllllllIlllIllIlIIIIIlIl)), "%s", lllllllllllllllIlllIllIlIIIIIIll);
        if (lllllllllllllllIlllIllIlIIIIlIII.equals(lllllllllllllllIlllIllIlIIIIIIll)) {
            lllllllllllllllIlllIllIlIIIIlIlI.kv("Analysis", "Types match: %s", lllllllllllllllIlllIllIlIIIIlIII);
        } else if (lllllllllllllllIlllIllIlIIIIlIII.getSort() != lllllllllllllllIlllIllIlIIIIIIll.getSort()) {
            lllllllllllllllIlllIllIlIIIIlIlI.kv("Analysis", "Types are incompatible");
        } else if (lllllllllllllllIlllIllIlIIIIlIII.getSort() == 10) {
            ClassInfo lllllllllllllllIlllIllIlIIIIllII = ClassInfo.getCommonSuperClassOrInterface(lllllllllllllllIlllIllIlIIIIlIII, lllllllllllllllIlllIllIlIIIIIIll);
            lllllllllllllllIlllIllIlIIIIlIlI.kv("Analysis", "Common supertype: L%s;", lllllllllllllllIlllIllIlIIIIllII);
        }
        return lllllllllllllllIlllIllIlIIIIlIlI.add();
    }

    public SyntheticBridgeException(Problem lllllllllllllllIlllIllIllIlIllIl, String lllllllllllllllIlllIllIllIllIlll, String lllllllllllllllIlllIllIllIlIlIIl, int lllllllllllllllIlllIllIllIllIIll, AbstractInsnNode lllllllllllllllIlllIllIllIllIIIl, AbstractInsnNode lllllllllllllllIlllIllIllIlIIIll) {
        super(lllllllllllllllIlllIllIllIlIllIl.getMessage(lllllllllllllllIlllIllIllIllIlll, lllllllllllllllIlllIllIllIlIlIIl, lllllllllllllllIlllIllIllIllIIll, lllllllllllllllIlllIllIllIllIIIl, lllllllllllllllIlllIllIllIlIIIll));
        SyntheticBridgeException lllllllllllllllIlllIllIllIlllIIl;
        lllllllllllllllIlllIllIllIlllIIl.problem = lllllllllllllllIlllIllIllIlIllIl;
        lllllllllllllllIlllIllIllIlllIIl.name = lllllllllllllllIlllIllIllIllIlll;
        lllllllllllllllIlllIllIllIlllIIl.desc = lllllllllllllllIlllIllIllIlIlIIl;
        lllllllllllllllIlllIllIllIlllIIl.index = lllllllllllllllIlllIllIllIllIIll;
        lllllllllllllllIlllIllIllIlllIIl.a = lllllllllllllllIlllIllIllIllIIIl;
        lllllllllllllllIlllIllIllIlllIIl.b = lllllllllllllllIlllIllIllIlIIIll;
    }

    private PrettyPrinter printProblem(PrettyPrinter lllllllllllllllIlllIllIlIIlIIIll, IMixinContext lllllllllllllllIlllIllIlIIlIlIII, MethodNode lllllllllllllllIlllIllIlIIlIIlll, MethodNode lllllllllllllllIlllIllIlIIlIIllI) {
        SyntheticBridgeException lllllllllllllllIlllIllIlIIlIlIlI;
        Type lllllllllllllllIlllIllIlIIlIIlIl = Type.getObjectType(lllllllllllllllIlllIllIlIIlIlIII.getTargetClassRef());
        lllllllllllllllIlllIllIlIIlIIIll.add("Analysis").add();
        switch (lllllllllllllllIlllIllIlIIlIlIlI.problem) {
            case BAD_INSN: {
                lllllllllllllllIlllIllIlIIlIIIll.add("The bridge methods are not compatible because they contain incompatible opcodes");
                lllllllllllllllIlllIllIlIIlIIIll.add(String.valueOf(new StringBuilder().append("at index ").append(lllllllllllllllIlllIllIlIIlIlIlI.index).append(":"))).add();
                lllllllllllllllIlllIllIlIIlIIIll.kv("Existing opcode: %s", Bytecode.getOpcodeName(lllllllllllllllIlllIllIlIIlIlIlI.a));
                lllllllllllllllIlllIllIlIIlIIIll.kv("Incoming opcode: %s", Bytecode.getOpcodeName(lllllllllllllllIlllIllIlIIlIlIlI.b)).add();
                lllllllllllllllIlllIllIlIIlIIIll.add("This implies that the bridge methods are from different interfaces. This problem");
                lllllllllllllllIlllIllIlIIlIIIll.add("may not be resolvable without changing the base interfaces.").add();
                break;
            }
            case BAD_LOAD: {
                lllllllllllllllIlllIllIlIIlIIIll.add("The bridge methods are not compatible because they contain different variables at");
                lllllllllllllllIlllIllIlIIlIIIll.add(String.valueOf(new StringBuilder().append("opcode index ").append(lllllllllllllllIlllIllIlIIlIlIlI.index).append("."))).add();
                ListIterator<AbstractInsnNode> lllllllllllllllIlllIllIlIIlllIIl = lllllllllllllllIlllIllIlIIlIIlll.instructions.iterator();
                ListIterator<AbstractInsnNode> lllllllllllllllIlllIllIlIIlllIII = lllllllllllllllIlllIllIlIIlIIllI.instructions.iterator();
                Type[] lllllllllllllllIlllIllIlIIllIlll = Type.getArgumentTypes(lllllllllllllllIlllIllIlIIlIIlll.desc);
                Type[] lllllllllllllllIlllIllIlIIllIllI = Type.getArgumentTypes(lllllllllllllllIlllIllIlIIlIIllI.desc);
                int lllllllllllllllIlllIllIlIIlllIlI = 0;
                while (lllllllllllllllIlllIllIlIIlllIIl.hasNext() && lllllllllllllllIlllIllIlIIlllIII.hasNext()) {
                    AbstractInsnNode lllllllllllllllIlllIllIlIIllllII = lllllllllllllllIlllIllIlIIlllIIl.next();
                    AbstractInsnNode lllllllllllllllIlllIllIlIIlllIll = lllllllllllllllIlllIllIlIIlllIII.next();
                    if (lllllllllllllllIlllIllIlIIllllII instanceof VarInsnNode && lllllllllllllllIlllIllIlIIlllIll instanceof VarInsnNode) {
                        VarInsnNode lllllllllllllllIlllIllIlIlIIIIII = (VarInsnNode)lllllllllllllllIlllIllIlIIllllII;
                        VarInsnNode lllllllllllllllIlllIllIlIIllllll = (VarInsnNode)lllllllllllllllIlllIllIlIIlllIll;
                        Type lllllllllllllllIlllIllIlIIlllllI = lllllllllllllllIlllIllIlIlIIIIII.var > 0 ? lllllllllllllllIlllIllIlIIllIlll[lllllllllllllllIlllIllIlIlIIIIII.var - 1] : lllllllllllllllIlllIllIlIIlIIlIl;
                        Type lllllllllllllllIlllIllIlIIllllIl = lllllllllllllllIlllIllIlIIllllll.var > 0 ? lllllllllllllllIlllIllIlIIllIllI[lllllllllllllllIlllIllIlIIllllll.var - 1] : lllllllllllllllIlllIllIlIIlIIlIl;
                        lllllllllllllllIlllIllIlIIlIIIll.kv(String.valueOf(new StringBuilder().append("Target ").append(lllllllllllllllIlllIllIlIIlllIlI)), "%8s %-2d %s", Bytecode.getOpcodeName(lllllllllllllllIlllIllIlIlIIIIII), lllllllllllllllIlllIllIlIlIIIIII.var, lllllllllllllllIlllIllIlIIlllllI);
                        lllllllllllllllIlllIllIlIIlIIIll.kv(String.valueOf(new StringBuilder().append("Incoming ").append(lllllllllllllllIlllIllIlIIlllIlI)), "%8s %-2d %s", Bytecode.getOpcodeName(lllllllllllllllIlllIllIlIIllllll), lllllllllllllllIlllIllIlIIllllll.var, lllllllllllllllIlllIllIlIIllllIl);
                        if (lllllllllllllllIlllIllIlIIlllllI.equals(lllllllllllllllIlllIllIlIIllllIl)) {
                            lllllllllllllllIlllIllIlIIlIIIll.kv("", "Types match: %s", lllllllllllllllIlllIllIlIIlllllI);
                        } else if (lllllllllllllllIlllIllIlIIlllllI.getSort() != lllllllllllllllIlllIllIlIIllllIl.getSort()) {
                            lllllllllllllllIlllIllIlIIlIIIll.kv("", "Types are incompatible");
                        } else if (lllllllllllllllIlllIllIlIIlllllI.getSort() == 10) {
                            ClassInfo lllllllllllllllIlllIllIlIlIIIIIl = ClassInfo.getCommonSuperClassOrInterface(lllllllllllllllIlllIllIlIIlllllI, lllllllllllllllIlllIllIlIIllllIl);
                            lllllllllllllllIlllIllIlIIlIIIll.kv("", "Common supertype: %s", lllllllllllllllIlllIllIlIlIIIIIl);
                        }
                        lllllllllllllllIlllIllIlIIlIIIll.add();
                    }
                    ++lllllllllllllllIlllIllIlIIlllIlI;
                }
                lllllllllllllllIlllIllIlIIlIIIll.add("Since this probably means that the methods come from different interfaces, you");
                lllllllllllllllIlllIllIlIIlIIIll.add("may have a \"multiple inheritance\" problem, it may not be possible to implement");
                lllllllllllllllIlllIllIlIIlIIIll.add("both root interfaces");
                break;
            }
            case BAD_CAST: {
                lllllllllllllllIlllIllIlIIlIIIll.add(String.valueOf(new StringBuilder().append("Incompatible CHECKCAST encountered at opcode ").append(lllllllllllllllIlllIllIlIIlIlIlI.index).append(", this could indicate that the bridge")));
                lllllllllllllllIlllIllIlIIlIIIll.add("is casting down for contravariant generic types. It may be possible to coalesce the");
                lllllllllllllllIlllIllIlIIlIIIll.add("bridges by adjusting the types in the target method.").add();
                Type lllllllllllllllIlllIllIlIIllIlIl = Type.getObjectType(((TypeInsnNode)lllllllllllllllIlllIllIlIIlIlIlI.a).desc);
                Type lllllllllllllllIlllIllIlIIllIlII = Type.getObjectType(((TypeInsnNode)lllllllllllllllIlllIllIlIIlIlIlI.b).desc);
                lllllllllllllllIlllIllIlIIlIIIll.kv("Target type", lllllllllllllllIlllIllIlIIllIlIl);
                lllllllllllllllIlllIllIlIIlIIIll.kv("Incoming type", lllllllllllllllIlllIllIlIIllIlII);
                lllllllllllllllIlllIllIlIIlIIIll.kv("Common supertype", ClassInfo.getCommonSuperClassOrInterface(lllllllllllllllIlllIllIlIIllIlIl, lllllllllllllllIlllIllIlIIllIlII)).add();
                break;
            }
            case BAD_INVOKE_NAME: {
                lllllllllllllllIlllIllIlIIlIIIll.add("Incompatible invocation targets in synthetic bridge. This is extremely unusual");
                lllllllllllllllIlllIllIlIIlIIIll.add("and implies that a remapping transformer has incorrectly remapped a method. This");
                lllllllllllllllIlllIllIlIIlIIIll.add("is an unrecoverable error.");
                break;
            }
            case BAD_INVOKE_DESC: {
                MethodInsnNode lllllllllllllllIlllIllIlIIllIIII = (MethodInsnNode)lllllllllllllllIlllIllIlIIlIlIlI.a;
                MethodInsnNode lllllllllllllllIlllIllIlIIlIllll = (MethodInsnNode)lllllllllllllllIlllIllIlIIlIlIlI.b;
                Type[] lllllllllllllllIlllIllIlIIlIlllI = Type.getArgumentTypes(lllllllllllllllIlllIllIlIIllIIII.desc);
                Type[] lllllllllllllllIlllIllIlIIlIllIl = Type.getArgumentTypes(lllllllllllllllIlllIllIlIIlIllll.desc);
                if (lllllllllllllllIlllIllIlIIlIlllI.length != lllllllllllllllIlllIllIlIIlIllIl.length) {
                    int lllllllllllllllIlllIllIlIIllIIll = Type.getArgumentTypes(lllllllllllllllIlllIllIlIIlIIlll.desc).length;
                    String lllllllllllllllIlllIllIlIIllIIlI = lllllllllllllllIlllIllIlIIlIlllI.length == lllllllllllllllIlllIllIlIIllIIll ? "The TARGET" : (lllllllllllllllIlllIllIlIIlIllIl.length == lllllllllllllllIlllIllIlIIllIIll ? " The INCOMING" : "NEITHER");
                    lllllllllllllllIlllIllIlIIlIIIll.add("Mismatched invocation descriptors in synthetic bridge implies that a remapping");
                    lllllllllllllllIlllIllIlIIlIIIll.add("transformer has incorrectly coalesced a bridge method with a conflicting name.");
                    lllllllllllllllIlllIllIlIIlIIIll.add("Overlapping bridge methods should always have the same number of arguments, yet");
                    lllllllllllllllIlllIllIlIIlIIIll.add("the target method has %d arguments, the incoming method has %d. This is an", lllllllllllllllIlllIllIlIIlIlllI.length, lllllllllllllllIlllIllIlIIlIllIl.length);
                    lllllllllllllllIlllIllIlIIlIIIll.add("unrecoverable error. %s method has the expected arg count of %d", lllllllllllllllIlllIllIlIIllIIlI, lllllllllllllllIlllIllIlIIllIIll);
                    break;
                }
                Type lllllllllllllllIlllIllIlIIlIllII = Type.getReturnType(lllllllllllllllIlllIllIlIIllIIII.desc);
                Type lllllllllllllllIlllIllIlIIlIlIll = Type.getReturnType(lllllllllllllllIlllIllIlIIlIllll.desc);
                lllllllllllllllIlllIllIlIIlIIIll.add("Incompatible invocation descriptors in synthetic bridge implies that generified");
                lllllllllllllllIlllIllIlIIlIIIll.add("types are incompatible over one or more generic superclasses or interfaces. It may");
                lllllllllllllllIlllIllIlIIlIIIll.add("be possible to adjust the generic types on implemented members to rectify this");
                lllllllllllllllIlllIllIlIIlIIIll.add("problem by coalescing the appropriate generic types.").add();
                lllllllllllllllIlllIllIlIIlIlIlI.printTypeComparison(lllllllllllllllIlllIllIlIIlIIIll, "return type", lllllllllllllllIlllIllIlIIlIllII, lllllllllllllllIlllIllIlIIlIlIll);
                for (int lllllllllllllllIlllIllIlIIllIIIl = 0; lllllllllllllllIlllIllIlIIllIIIl < lllllllllllllllIlllIllIlIIlIlllI.length; ++lllllllllllllllIlllIllIlIIllIIIl) {
                    lllllllllllllllIlllIllIlIIlIlIlI.printTypeComparison(lllllllllllllllIlllIllIlIIlIIIll, String.valueOf(new StringBuilder().append("arg ").append(lllllllllllllllIlllIllIlIIllIIIl)), lllllllllllllllIlllIllIlIIlIlllI[lllllllllllllllIlllIllIlIIllIIIl], lllllllllllllllIlllIllIlIIlIllIl[lllllllllllllllIlllIllIlIIllIIIl]);
                }
                break;
            }
            case BAD_LENGTH: {
                lllllllllllllllIlllIllIlIIlIIIll.add("Mismatched bridge method length implies the bridge methods are incompatible");
                lllllllllllllllIlllIllIlIIlIIIll.add("and may originate from different superinterfaces. This is an unrecoverable");
                lllllllllllllllIlllIllIlIIlIIIll.add("error.").add();
                break;
            }
        }
        return lllllllllllllllIlllIllIlIIlIIIll;
    }

    public static enum Problem {
        BAD_INSN("Conflicting opcodes %4$s and %5$s at offset %3$d in synthetic bridge method %1$s%2$s"),
        BAD_LOAD("Conflicting variable access at offset %3$d in synthetic bridge method %1$s%2$s"),
        BAD_CAST("Conflicting type cast at offset %3$d in synthetic bridge method %1$s%2$s"),
        BAD_INVOKE_NAME("Conflicting synthetic bridge target method name in synthetic bridge method %1$s%2$s Existing:%6$s Incoming:%7$s"),
        BAD_INVOKE_DESC("Conflicting synthetic bridge target method descriptor in synthetic bridge method %1$s%2$s Existing:%8$s Incoming:%9$s"),
        BAD_LENGTH("Mismatched bridge method length for synthetic bridge method %1$s%2$s unexpected extra opcode at offset %3$d");

        private final /* synthetic */ String message;

        private static String getInsnName(AbstractInsnNode lIlIlIllIIllII) {
            return lIlIlIllIIllII instanceof MethodInsnNode ? ((MethodInsnNode)lIlIlIllIIllII).name : "";
        }

        private static String getInsnDesc(AbstractInsnNode lIlIlIllIIlIIl) {
            return lIlIlIllIIlIIl instanceof MethodInsnNode ? ((MethodInsnNode)lIlIlIllIIlIIl).desc : "";
        }

        String getMessage(String lIlIlIllIlIIlI, String lIlIlIllIlIlll, int lIlIlIllIlIllI, AbstractInsnNode lIlIlIllIIllll, AbstractInsnNode lIlIlIllIIlllI) {
            Problem lIlIlIllIlIIll;
            return String.format(lIlIlIllIlIIll.message, lIlIlIllIlIIlI, lIlIlIllIlIlll, lIlIlIllIlIllI, Bytecode.getOpcodeName(lIlIlIllIIllll), Bytecode.getOpcodeName(lIlIlIllIIllll), Problem.getInsnName(lIlIlIllIIllll), Problem.getInsnName(lIlIlIllIIlllI), Problem.getInsnDesc(lIlIlIllIIllll), Problem.getInsnDesc(lIlIlIllIIlllI));
        }

        private Problem(String lIlIlIlllIIIII) {
            Problem lIlIlIlllIIIll;
            lIlIlIlllIIIll.message = lIlIlIlllIIIII;
        }
    }
}

