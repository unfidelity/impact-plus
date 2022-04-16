/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 */
package org.spongepowered.asm.mixin.injection.callback;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.injection.Coerce;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.Surrogate;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.points.BeforeReturn;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InjectionError;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.Locals;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.SignaturePrinter;

public class CallbackInjector
extends Injector {
    private final /* synthetic */ Map<Integer, String> ids;
    private /* synthetic */ String lastId;
    private /* synthetic */ Target lastTarget;
    private /* synthetic */ String lastDesc;
    private final /* synthetic */ boolean cancellable;
    private /* synthetic */ int callbackInfoVar;
    private final /* synthetic */ String identifier;
    private /* synthetic */ String callbackInfoClass;
    private /* synthetic */ int totalInjections;
    private final /* synthetic */ LocalCapture localCapture;

    private MethodNode generateErrorMethod(Callback lllIIllIllIIIII, String lllIIllIllIIlIl, String lllIIllIlIllllI) {
        CallbackInjector lllIIllIllIIIIl;
        MethodNode lllIIllIllIIIll = lllIIllIllIIIIl.info.addMethod(lllIIllIllIIIIl.methodNode.access, String.valueOf(new StringBuilder().append(lllIIllIllIIIIl.methodNode.name).append("$missing")), lllIIllIllIIIII.getDescriptor());
        lllIIllIllIIIll.maxLocals = Bytecode.getFirstNonArgLocalIndex(Type.getArgumentTypes(lllIIllIllIIIII.getDescriptor()), !lllIIllIllIIIIl.isStatic);
        lllIIllIllIIIll.maxStack = 3;
        InsnList lllIIllIllIIIlI = lllIIllIllIIIll.instructions;
        lllIIllIllIIIlI.add(new TypeInsnNode(187, lllIIllIllIIlIl));
        lllIIllIllIIIlI.add(new InsnNode(89));
        lllIIllIllIIIlI.add(new LdcInsnNode(lllIIllIlIllllI));
        lllIIllIllIIIlI.add(new MethodInsnNode(183, lllIIllIllIIlIl, "<init>", "(Ljava/lang/String;)V", false));
        lllIIllIllIIIlI.add(new InsnNode(191));
        return lllIIllIllIIIll;
    }

    protected void injectCancellationCode(Callback lllIIlIlllIlllI) {
        CallbackInjector lllIIlIlllIllll;
        if (!lllIIlIlllIllll.cancellable) {
            return;
        }
        lllIIlIlllIlllI.add(new VarInsnNode(25, lllIIlIlllIllll.callbackInfoVar));
        lllIIlIlllIlllI.add(new MethodInsnNode(182, lllIIlIlllIllll.callbackInfoClass, CallbackInfo.getIsCancelledMethodName(), CallbackInfo.getIsCancelledMethodSig(), false));
        LabelNode lllIIlIlllIllIl = new LabelNode();
        lllIIlIlllIlllI.add(new JumpInsnNode(153, lllIIlIlllIllIl));
        lllIIlIlllIllll.injectReturnCode(lllIIlIlllIlllI);
        lllIIlIlllIlllI.add(lllIIlIlllIllIl);
    }

    private void inject(Callback lllIIlllIIIIIll) {
        CallbackInjector lllIIlllIIIIIIl;
        if (lllIIlllIIIIIIl.localCapture.isPrintLocals()) {
            lllIIlllIIIIIIl.printLocals(lllIIlllIIIIIll);
            lllIIlllIIIIIIl.info.addCallbackInvocation(lllIIlllIIIIIIl.methodNode);
            return;
        }
        MethodNode lllIIlllIIIIIlI = lllIIlllIIIIIIl.methodNode;
        if (!lllIIlllIIIIIll.checkDescriptor(lllIIlllIIIIIIl.methodNode.desc)) {
            if (lllIIlllIIIIIIl.info.getTargets().size() > 1) {
                return;
            }
            if (lllIIlllIIIIIll.canCaptureLocals) {
                MethodNode lllIIlllIIIIlll = Bytecode.findMethod(lllIIlllIIIIIIl.classNode, lllIIlllIIIIIIl.methodNode.name, lllIIlllIIIIIll.getDescriptor());
                if (lllIIlllIIIIlll != null && Annotations.getVisible(lllIIlllIIIIlll, Surrogate.class) != null) {
                    lllIIlllIIIIIlI = lllIIlllIIIIlll;
                } else {
                    String lllIIlllIIIlIII = lllIIlllIIIIIIl.generateBadLVTMessage(lllIIlllIIIIIll);
                    switch (lllIIlllIIIIIIl.localCapture) {
                        case CAPTURE_FAILEXCEPTION: {
                            Injector.logger.error("Injection error: {}", new Object[]{lllIIlllIIIlIII});
                            lllIIlllIIIIIlI = lllIIlllIIIIIIl.generateErrorMethod(lllIIlllIIIIIll, "org/spongepowered/asm/mixin/injection/throwables/InjectionError", lllIIlllIIIlIII);
                            break;
                        }
                        case CAPTURE_FAILSOFT: {
                            Injector.logger.warn("Injection warning: {}", new Object[]{lllIIlllIIIlIII});
                            return;
                        }
                        default: {
                            Injector.logger.error("Critical injection failure: {}", new Object[]{lllIIlllIIIlIII});
                            throw new InjectionError(lllIIlllIIIlIII);
                        }
                    }
                }
            } else {
                String lllIIlllIIIIllI = lllIIlllIIIIIIl.methodNode.desc.replace("Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;", "Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfoReturnable;");
                if (lllIIlllIIIIIll.checkDescriptor(lllIIlllIIIIllI)) {
                    throw new InvalidInjectionException(lllIIlllIIIIIIl.info, String.valueOf(new StringBuilder().append("Invalid descriptor on ").append(lllIIlllIIIIIIl.info).append("! CallbackInfoReturnable is required!")));
                }
                MethodNode lllIIlllIIIIlIl = Bytecode.findMethod(lllIIlllIIIIIIl.classNode, lllIIlllIIIIIIl.methodNode.name, lllIIlllIIIIIll.getDescriptor());
                if (lllIIlllIIIIlIl != null && Annotations.getVisible(lllIIlllIIIIlIl, Surrogate.class) != null) {
                    lllIIlllIIIIIlI = lllIIlllIIIIlIl;
                } else {
                    throw new InvalidInjectionException(lllIIlllIIIIIIl.info, String.valueOf(new StringBuilder().append("Invalid descriptor on ").append(lllIIlllIIIIIIl.info).append("! Expected ").append(lllIIlllIIIIIll.getDescriptor()).append(" but found ").append(lllIIlllIIIIIIl.methodNode.desc)));
                }
            }
        }
        lllIIlllIIIIIIl.dupReturnValue(lllIIlllIIIIIll);
        if (lllIIlllIIIIIIl.cancellable || lllIIlllIIIIIIl.totalInjections > 1) {
            lllIIlllIIIIIIl.createCallbackInfo(lllIIlllIIIIIll, true);
        }
        lllIIlllIIIIIIl.invokeCallback(lllIIlllIIIIIll, lllIIlllIIIIIlI);
        lllIIlllIIIIIIl.injectCancellationCode(lllIIlllIIIIIll);
        lllIIlllIIIIIll.inject();
        lllIIlllIIIIIIl.info.notifyInjected(lllIIlllIIIIIll.target);
    }

    private String generateBadLVTMessage(Callback lllIIllIlllIllI) {
        CallbackInjector lllIIllIlllIlll;
        int lllIIllIlllIlIl = lllIIllIlllIllI.target.indexOf(lllIIllIlllIllI.node);
        List<String> lllIIllIlllIlII = CallbackInjector.summariseLocals(lllIIllIlllIlll.methodNode.desc, lllIIllIlllIllI.target.arguments.length + 1);
        List<String> lllIIllIlllIIll = CallbackInjector.summariseLocals(lllIIllIlllIllI.getDescriptorWithAllLocals(), lllIIllIlllIllI.frameSize);
        return String.format("LVT in %s has incompatible changes at opcode %d in callback %s.\nExpected: %s\n   Found: %s", lllIIllIlllIllI.target, lllIIllIlllIlIl, lllIIllIlllIlll, lllIIllIlllIlII, lllIIllIlllIIll);
    }

    @Override
    protected void inject(Target lllIIlllIIlllll, InjectionNodes.InjectionNode lllIIlllIlIIIlI) {
        CallbackInjector lllIIlllIlIIlII;
        LocalVariableNode[] lllIIlllIlIIIIl = null;
        if (lllIIlllIlIIlII.localCapture.isCaptureLocals() || lllIIlllIlIIlII.localCapture.isPrintLocals()) {
            lllIIlllIlIIIIl = Locals.getLocalsAt(lllIIlllIlIIlII.classNode, lllIIlllIIlllll.method, lllIIlllIlIIIlI.getCurrentTarget());
        }
        lllIIlllIlIIlII.inject(lllIIlllIlIIlII.new Callback(lllIIlllIlIIlII.methodNode, lllIIlllIIlllll, lllIIlllIlIIIlI, lllIIlllIlIIIIl, lllIIlllIlIIlII.localCapture.isCaptureLocals()));
    }

    private void invokeCallback(Callback lllIIllIIIIIIII, MethodNode lllIIlIllllllll) {
        CallbackInjector lllIIllIIIIIIIl;
        if (!lllIIllIIIIIIIl.isStatic) {
            lllIIllIIIIIIII.add(new VarInsnNode(25, 0), false, true);
        }
        if (lllIIllIIIIIIII.captureArgs()) {
            Bytecode.loadArgs(lllIIllIIIIIIII.target.arguments, lllIIllIIIIIIII, lllIIllIIIIIIIl.isStatic ? 0 : 1, -1);
        }
        lllIIllIIIIIIIl.loadOrCreateCallbackInfo(lllIIllIIIIIIII);
        if (lllIIllIIIIIIII.canCaptureLocals) {
            Locals.loadLocals(lllIIllIIIIIIII.localTypes, lllIIllIIIIIIII, lllIIllIIIIIIII.frameSize, lllIIllIIIIIIII.extraArgs);
        }
        lllIIllIIIIIIIl.invokeHandler(lllIIllIIIIIIII, lllIIlIllllllll);
    }

    private static List<String> summariseLocals(String lllIIlIllIllIII, int lllIIlIllIlIlll) {
        return CallbackInjector.summariseLocals(Type.getArgumentTypes(lllIIlIllIllIII), lllIIlIllIlIlll);
    }

    protected boolean isStatic() {
        CallbackInjector lllIIlIllIlllII;
        return lllIIlIllIlllII.isStatic;
    }

    private void loadOrCreateCallbackInfo(Callback lllIIllIIIllllI) {
        CallbackInjector lllIIllIIlIIIIl;
        if (lllIIllIIlIIIIl.cancellable || lllIIllIIlIIIIl.totalInjections > 1) {
            lllIIllIIIllllI.add(new VarInsnNode(25, lllIIllIIlIIIIl.callbackInfoVar), false, true);
        } else {
            lllIIllIIlIIIIl.createCallbackInfo(lllIIllIIIllllI, false);
        }
    }

    public CallbackInjector(InjectionInfo lllIIlllllIIlII, boolean lllIIlllllIIIll, LocalCapture lllIIlllllIIlll, String lllIIlllllIIIIl) {
        super(lllIIlllllIIlII);
        CallbackInjector lllIIlllllIllIl;
        lllIIlllllIllIl.ids = new HashMap<Integer, String>();
        lllIIlllllIllIl.totalInjections = 0;
        lllIIlllllIllIl.callbackInfoVar = -1;
        lllIIlllllIllIl.cancellable = lllIIlllllIIIll;
        lllIIlllllIllIl.localCapture = lllIIlllllIIlll;
        lllIIlllllIllIl.identifier = lllIIlllllIIIIl;
    }

    @Override
    protected void addTargetNode(Target lllIIllllIIIIll, List<InjectionNodes.InjectionNode> lllIIlllIlllIlI, AbstractInsnNode lllIIlllIlllIIl, Set<InjectionPoint> lllIIllllIIIIII) {
        CallbackInjector lllIIlllIllllIl;
        InjectionNodes.InjectionNode lllIIlllIlllllI = lllIIllllIIIIll.addInjectionNode(lllIIlllIlllIIl);
        for (InjectionPoint lllIIllllIIIllI : lllIIllllIIIIII) {
            String lllIIllllIIlIII = lllIIllllIIIllI.getId();
            if (Strings.isNullOrEmpty((String)lllIIllllIIlIII)) continue;
            String lllIIllllIIIlll = lllIIlllIllllIl.ids.get(lllIIlllIlllllI.getId());
            if (lllIIllllIIIlll != null && !lllIIllllIIIlll.equals(lllIIllllIIlIII)) {
                Injector.logger.warn("Conflicting id for {} insn in {}, found id {} on {}, previously defined as {}", new Object[]{Bytecode.getOpcodeName(lllIIlllIlllIIl), lllIIllllIIIIll.toString(), lllIIllllIIlIII, lllIIlllIllllIl.info, lllIIllllIIIlll});
                break;
            }
            lllIIlllIllllIl.ids.put(lllIIlllIlllllI.getId(), lllIIllllIIlIII);
        }
        lllIIlllIlllIlI.add(lllIIlllIlllllI);
        ++lllIIlllIllllIl.totalInjections;
    }

    protected void instanceCallbackInfo(Callback lllIIllIIIlIIlI, String lllIIllIIIlIIIl, String lllIIllIIIlIIII, boolean lllIIllIIIIllll) {
        CallbackInjector lllIIllIIIIllIl;
        lllIIllIIIIllIl.lastId = lllIIllIIIlIIIl;
        lllIIllIIIIllIl.lastDesc = lllIIllIIIlIIII;
        lllIIllIIIIllIl.callbackInfoVar = lllIIllIIIlIIlI.marshalVar();
        lllIIllIIIIllIl.callbackInfoClass = lllIIllIIIlIIlI.target.getCallbackInfoClass();
        boolean lllIIllIIIIlllI = lllIIllIIIIllll && lllIIllIIIIllIl.totalInjections > 1 && !lllIIllIIIlIIlI.isAtReturn && !lllIIllIIIIllIl.cancellable;
        lllIIllIIIlIIlI.add(new TypeInsnNode(187, lllIIllIIIIllIl.callbackInfoClass), true, !lllIIllIIIIllll, lllIIllIIIIlllI);
        lllIIllIIIlIIlI.add(new InsnNode(89), true, true, lllIIllIIIIlllI);
        lllIIllIIIlIIlI.add(new LdcInsnNode(lllIIllIIIlIIIl), true, !lllIIllIIIIllll, lllIIllIIIIlllI);
        lllIIllIIIlIIlI.add(new InsnNode(lllIIllIIIIllIl.cancellable ? 4 : 3), true, !lllIIllIIIIllll, lllIIllIIIIlllI);
        if (lllIIllIIIlIIlI.isAtReturn) {
            lllIIllIIIlIIlI.add(new VarInsnNode(lllIIllIIIlIIlI.target.returnType.getOpcode(21), lllIIllIIIlIIlI.marshalVar()), true, !lllIIllIIIIllll);
            lllIIllIIIlIIlI.add(new MethodInsnNode(183, lllIIllIIIIllIl.callbackInfoClass, "<init>", lllIIllIIIlIIII, false));
        } else {
            lllIIllIIIlIIlI.add(new MethodInsnNode(183, lllIIllIIIIllIl.callbackInfoClass, "<init>", lllIIllIIIlIIII, false), false, false, lllIIllIIIIlllI);
        }
        if (lllIIllIIIIllll) {
            lllIIllIIIlIIlI.target.addLocalVariable(lllIIllIIIIllIl.callbackInfoVar, String.valueOf(new StringBuilder().append("callbackInfo").append(lllIIllIIIIllIl.callbackInfoVar)), String.valueOf(new StringBuilder().append("L").append(lllIIllIIIIllIl.callbackInfoClass).append(";")));
            lllIIllIIIlIIlI.add(new VarInsnNode(58, lllIIllIIIIllIl.callbackInfoVar), false, false, lllIIllIIIIlllI);
        }
    }

    protected void injectReturnCode(Callback lllIIlIlllIIIlI) {
        if (lllIIlIlllIIIlI.target.returnType.equals(Type.VOID_TYPE)) {
            lllIIlIlllIIIlI.add(new InsnNode(177));
        } else {
            CallbackInjector lllIIlIlllIIIIl;
            lllIIlIlllIIIlI.add(new VarInsnNode(25, lllIIlIlllIIIlI.marshalVar()));
            String lllIIlIlllIIlIl = CallbackInfoReturnable.getReturnAccessor(lllIIlIlllIIIlI.target.returnType);
            String lllIIlIlllIIlII = CallbackInfoReturnable.getReturnDescriptor(lllIIlIlllIIIlI.target.returnType);
            lllIIlIlllIIIlI.add(new MethodInsnNode(182, lllIIlIlllIIIIl.callbackInfoClass, lllIIlIlllIIlIl, lllIIlIlllIIlII, false));
            if (lllIIlIlllIIIlI.target.returnType.getSort() == 10) {
                lllIIlIlllIIIlI.add(new TypeInsnNode(192, lllIIlIlllIIIlI.target.returnType.getInternalName()));
            }
            lllIIlIlllIIIlI.add(new InsnNode(lllIIlIlllIIIlI.target.returnType.getOpcode(172)));
        }
    }

    @Override
    protected void sanityCheck(Target lllIIllllIllIIl, List<InjectionPoint> lllIIllllIlIlIl) {
        CallbackInjector lllIIllllIllIlI;
        super.sanityCheck(lllIIllllIllIIl, lllIIllllIlIlIl);
        if (lllIIllllIllIIl.isStatic != lllIIllllIllIlI.isStatic) {
            throw new InvalidInjectionException(lllIIllllIllIlI.info, String.valueOf(new StringBuilder().append("'static' modifier of callback method does not match target in ").append(lllIIllllIllIlI)));
        }
        if ("<init>".equals(lllIIllllIllIIl.method.name)) {
            for (InjectionPoint lllIIllllIllIll : lllIIllllIlIlIl) {
                if (lllIIllllIllIll.getClass().equals(BeforeReturn.class)) continue;
                throw new InvalidInjectionException(lllIIllllIllIlI.info, String.valueOf(new StringBuilder().append("Found injection point type ").append(lllIIllllIllIll.getClass().getSimpleName()).append(" targetting a ctor in ").append(lllIIllllIllIlI).append(". Only RETURN allowed for a ctor target")));
            }
        }
    }

    private void createCallbackInfo(Callback lllIIllIIlIllII, boolean lllIIllIIlIlIll) {
        CallbackInjector lllIIllIIlIllIl;
        if (lllIIllIIlIllII.target != lllIIllIIlIllIl.lastTarget) {
            lllIIllIIlIllIl.lastId = null;
            lllIIllIIlIllIl.lastDesc = null;
        }
        lllIIllIIlIllIl.lastTarget = lllIIllIIlIllII.target;
        String lllIIllIIlIlIlI = lllIIllIIlIllIl.getIdentifier(lllIIllIIlIllII);
        String lllIIllIIlIlIIl = lllIIllIIlIllII.getCallbackInfoConstructorDescriptor();
        if (lllIIllIIlIlIlI.equals(lllIIllIIlIllIl.lastId) && lllIIllIIlIlIIl.equals(lllIIllIIlIllIl.lastDesc) && !lllIIllIIlIllII.isAtReturn && !lllIIllIIlIllIl.cancellable) {
            return;
        }
        lllIIllIIlIllIl.instanceCallbackInfo(lllIIllIIlIllII, lllIIllIIlIlIlI, lllIIllIIlIlIIl, lllIIllIIlIlIll);
    }

    static String meltSnowman(int lllIIlIllIIlIIl, String lllIIlIllIIIllI) {
        return lllIIlIllIIIllI != null && '\u2603' == lllIIlIllIIIllI.charAt(0) ? String.valueOf(new StringBuilder().append("var").append(lllIIlIllIIlIIl)) : lllIIlIllIIIllI;
    }

    private void printLocals(Callback lllIIllIlIIIIII) {
        CallbackInjector lllIIllIlIIIIIl;
        Type[] lllIIllIIllllll = Type.getArgumentTypes(lllIIllIlIIIIII.getDescriptorWithAllLocals());
        SignaturePrinter lllIIllIIlllllI = new SignaturePrinter(lllIIllIlIIIIII.target.method, lllIIllIlIIIIII.argNames);
        SignaturePrinter lllIIllIIllllIl = new SignaturePrinter(lllIIllIlIIIIIl.methodNode.name, lllIIllIlIIIIII.target.returnType, lllIIllIIllllll, lllIIllIlIIIIII.argNames);
        lllIIllIIllllIl.setModifiers(lllIIllIlIIIIIl.methodNode);
        PrettyPrinter lllIIllIIllllII = new PrettyPrinter();
        lllIIllIIllllII.kv("Target Class", lllIIllIlIIIIIl.classNode.name.replace('/', '.'));
        lllIIllIIllllII.kv("Target Method", lllIIllIIlllllI);
        lllIIllIIllllII.kv("Target Max LOCALS", lllIIllIlIIIIII.target.getMaxLocals());
        lllIIllIIllllII.kv("Initial Frame Size", lllIIllIlIIIIII.frameSize);
        lllIIllIIllllII.kv("Callback Name", lllIIllIlIIIIIl.methodNode.name);
        lllIIllIIllllII.kv("Instruction", "%s %s", lllIIllIlIIIIII.node.getClass().getSimpleName(), Bytecode.getOpcodeName(lllIIllIlIIIIII.node.getCurrentTarget().getOpcode()));
        lllIIllIIllllII.hr();
        if (lllIIllIlIIIIII.locals.length > lllIIllIlIIIIII.frameSize) {
            lllIIllIIllllII.add("  %s  %20s  %s", "LOCAL", "TYPE", "NAME");
            for (int lllIIllIlIIIIlI = 0; lllIIllIlIIIIlI < lllIIllIlIIIIII.locals.length; ++lllIIllIlIIIIlI) {
                String lllIIllIlIIIIll;
                String string = lllIIllIlIIIIll = lllIIllIlIIIIlI == lllIIllIlIIIIII.frameSize ? ">" : " ";
                if (lllIIllIlIIIIII.locals[lllIIllIlIIIIlI] != null) {
                    lllIIllIIllllII.add("%s [%3d]  %20s  %-50s %s", lllIIllIlIIIIll, lllIIllIlIIIIlI, SignaturePrinter.getTypeName(lllIIllIlIIIIII.localTypes[lllIIllIlIIIIlI], false), CallbackInjector.meltSnowman(lllIIllIlIIIIlI, lllIIllIlIIIIII.locals[lllIIllIlIIIIlI].name), lllIIllIlIIIIlI >= lllIIllIlIIIIII.frameSize ? "<capture>" : "");
                    continue;
                }
                boolean lllIIllIlIIIlII = lllIIllIlIIIIlI > 0 && lllIIllIlIIIIII.localTypes[lllIIllIlIIIIlI - 1] != null && lllIIllIlIIIIII.localTypes[lllIIllIlIIIIlI - 1].getSize() > 1;
                lllIIllIIllllII.add("%s [%3d]  %20s", lllIIllIlIIIIll, lllIIllIlIIIIlI, lllIIllIlIIIlII ? "<top>" : "-");
            }
            lllIIllIIllllII.hr();
        }
        lllIIllIIllllII.add().add("/**").add(" * Expected callback signature").add(" * /");
        lllIIllIIllllII.add("%s {", lllIIllIIllllIl);
        lllIIllIIllllII.add("    // Method body").add("}").add().print(System.err);
    }

    private static List<String> summariseLocals(Type[] lllIIlIllIlIIIl, int lllIIlIllIIllIl) {
        ArrayList<String> lllIIlIllIIllll = new ArrayList<String>();
        if (lllIIlIllIlIIIl != null) {
            while (lllIIlIllIIllIl < lllIIlIllIlIIIl.length) {
                if (lllIIlIllIlIIIl[lllIIlIllIIllIl] != null) {
                    lllIIlIllIIllll.add(lllIIlIllIlIIIl[lllIIlIllIIllIl].toString());
                }
                ++lllIIlIllIIllIl;
            }
        }
        return lllIIlIllIIllll;
    }

    private String getIdentifier(Callback lllIIlIlllllIIl) {
        CallbackInjector lllIIlIllllIllI;
        String lllIIlIlllllIII = Strings.isNullOrEmpty((String)lllIIlIllllIllI.identifier) ? lllIIlIlllllIIl.target.method.name : lllIIlIllllIllI.identifier;
        String lllIIlIllllIlll = lllIIlIllllIllI.ids.get(lllIIlIlllllIIl.node.getId());
        return String.valueOf(new StringBuilder().append(lllIIlIlllllIII).append(Strings.isNullOrEmpty((String)lllIIlIllllIlll) ? "" : String.valueOf(new StringBuilder().append(":").append(lllIIlIllllIlll))));
    }

    private void dupReturnValue(Callback lllIIllIIIllIlI) {
        if (!lllIIllIIIllIlI.isAtReturn) {
            return;
        }
        lllIIllIIIllIlI.add(new InsnNode(89));
        lllIIllIIIllIlI.add(new VarInsnNode(lllIIllIIIllIlI.target.returnType.getOpcode(54), lllIIllIIIllIlI.marshalVar()));
    }

    private class Callback
    extends InsnList {
        private /* synthetic */ int marshalVar;
        final /* synthetic */ LocalVariableNode[] locals;
        private /* synthetic */ boolean captureArgs;
        final /* synthetic */ Type[] localTypes;
        final /* synthetic */ boolean isAtReturn;
        final /* synthetic */ boolean canCaptureLocals;
        private final /* synthetic */ MethodNode handler;
        final /* synthetic */ String descl;
        /* synthetic */ int invoke;
        final /* synthetic */ String desc;
        final /* synthetic */ int extraArgs;
        final /* synthetic */ InjectionNodes.InjectionNode node;
        /* synthetic */ int ctor;
        final /* synthetic */ Target target;
        private final /* synthetic */ AbstractInsnNode head;
        final /* synthetic */ int frameSize;
        final /* synthetic */ String[] argNames;

        private boolean isValueReturnOpcode(int lllIIIllIIlll) {
            return lllIIIllIIlll >= 172 && lllIIIllIIlll < 177;
        }

        Callback(MethodNode lllIIIlllIIIl, Target lllIIIlllIIII, InjectionNodes.InjectionNode lllIIIllIllll, LocalVariableNode[] lllIIIlllIllI, boolean lllIIIllIllIl) {
            Callback lllIIIllllIlI;
            lllIIIllllIlI.marshalVar = -1;
            lllIIIllllIlI.captureArgs = true;
            lllIIIllllIlI.handler = lllIIIlllIIIl;
            lllIIIllllIlI.target = lllIIIlllIIII;
            lllIIIllllIlI.head = lllIIIlllIIII.insns.getFirst();
            lllIIIllllIlI.node = lllIIIllIllll;
            lllIIIllllIlI.locals = lllIIIlllIllI;
            lllIIIllllIlI.localTypes = lllIIIlllIllI != null ? new Type[lllIIIlllIllI.length] : null;
            lllIIIllllIlI.frameSize = Bytecode.getFirstNonArgLocalIndex(lllIIIlllIIII.arguments, !lllIIIllllIlI.CallbackInjector.this.isStatic());
            ArrayList<String> lllIIIlllIlII = null;
            if (lllIIIlllIllI != null) {
                int lllIIIllllIll = lllIIIllllIlI.CallbackInjector.this.isStatic() ? 0 : 1;
                lllIIIlllIlII = new ArrayList<String>();
                for (int lllIIIlllllII = 0; lllIIIlllllII <= lllIIIlllIllI.length; ++lllIIIlllllII) {
                    if (lllIIIlllllII == lllIIIllllIlI.frameSize) {
                        lllIIIlllIlII.add(lllIIIlllIIII.returnType == Type.VOID_TYPE ? "ci" : "cir");
                    }
                    if (lllIIIlllllII >= lllIIIlllIllI.length || lllIIIlllIllI[lllIIIlllllII] == null) continue;
                    lllIIIllllIlI.localTypes[lllIIIlllllII] = Type.getType(lllIIIlllIllI[lllIIIlllllII].desc);
                    if (lllIIIlllllII < lllIIIllllIll) continue;
                    lllIIIlllIlII.add(CallbackInjector.meltSnowman(lllIIIlllllII, lllIIIlllIllI[lllIIIlllllII].name));
                }
            }
            lllIIIllllIlI.extraArgs = Math.max(0, Bytecode.getFirstNonArgLocalIndex(lllIIIllllIlI.handler) - (lllIIIllllIlI.frameSize + 1));
            lllIIIllllIlI.argNames = lllIIIlllIlII != null ? lllIIIlllIlII.toArray(new String[lllIIIlllIlII.size()]) : null;
            lllIIIllllIlI.canCaptureLocals = lllIIIllIllIl && lllIIIlllIllI != null && lllIIIlllIllI.length > lllIIIllllIlI.frameSize;
            lllIIIllllIlI.isAtReturn = lllIIIllllIlI.node.getCurrentTarget() instanceof InsnNode && lllIIIllllIlI.isValueReturnOpcode(lllIIIllllIlI.node.getCurrentTarget().getOpcode());
            lllIIIllllIlI.desc = lllIIIlllIIII.getCallbackDescriptor(lllIIIllllIlI.localTypes, lllIIIlllIIII.arguments);
            lllIIIllllIlI.descl = lllIIIlllIIII.getCallbackDescriptor(true, lllIIIllllIlI.localTypes, lllIIIlllIIII.arguments, lllIIIllllIlI.frameSize, lllIIIllllIlI.extraArgs);
            lllIIIllllIlI.invoke = lllIIIlllIIII.arguments.length + (lllIIIllllIlI.canCaptureLocals ? lllIIIllllIlI.localTypes.length - lllIIIllllIlI.frameSize : 0);
        }

        void inject() {
            Callback lllIIIlIIIIII;
            lllIIIlIIIIII.target.insertBefore(lllIIIlIIIIII.node, (InsnList)lllIIIlIIIIII);
            lllIIIlIIIIII.target.addToStack(Math.max(lllIIIlIIIIII.invoke, lllIIIlIIIIII.ctor));
        }

        int marshalVar() {
            Callback lllIIIIlIIlll;
            if (lllIIIIlIIlll.marshalVar < 0) {
                lllIIIIlIIlll.marshalVar = lllIIIIlIIlll.target.allocateLocal();
            }
            return lllIIIIlIIlll.marshalVar;
        }

        String getDescriptorWithAllLocals() {
            Callback lllIIIllIIIII;
            return lllIIIllIIIII.target.getCallbackDescriptor(true, lllIIIllIIIII.localTypes, lllIIIllIIIII.target.arguments, lllIIIllIIIII.frameSize, Short.MAX_VALUE);
        }

        void add(AbstractInsnNode lllIIIlIIIlIl, boolean lllIIIlIIlIIl, boolean lllIIIlIIlIII, boolean lllIIIlIIIlll) {
            Callback lllIIIlIIIllI;
            if (lllIIIlIIIlll) {
                lllIIIlIIIllI.target.insns.insertBefore(lllIIIlIIIllI.head, lllIIIlIIIlIl);
            } else {
                lllIIIlIIIllI.add(lllIIIlIIIlIl);
            }
            lllIIIlIIIllI.ctor = lllIIIlIIIllI.ctor + (lllIIIlIIlIIl ? 1 : 0);
            lllIIIlIIIllI.invoke = lllIIIlIIIllI.invoke + (lllIIIlIIlIII ? 1 : 0);
        }

        boolean checkDescriptor(String lllIIIIllIIIl) {
            Type[] lllIIIIllIIll;
            Callback lllIIIIllIIlI;
            if (lllIIIIllIIlI.getDescriptor().equals(lllIIIIllIIIl)) {
                return true;
            }
            if (lllIIIIllIIlI.target.getSimpleCallbackDescriptor().equals(lllIIIIllIIIl) && !lllIIIIllIIlI.canCaptureLocals) {
                lllIIIIllIIlI.captureArgs = false;
                return true;
            }
            Type[] lllIIIIllIlII = Type.getArgumentTypes(lllIIIIllIIIl);
            if (lllIIIIllIlII.length != (lllIIIIllIIll = Type.getArgumentTypes(lllIIIIllIIlI.descl)).length) {
                return false;
            }
            for (int lllIIIIllIlll = 0; lllIIIIllIlll < lllIIIIllIIll.length; ++lllIIIIllIlll) {
                Type lllIIIIlllIII = lllIIIIllIlII[lllIIIIllIlll];
                if (lllIIIIlllIII.equals(lllIIIIllIIll[lllIIIIllIlll])) continue;
                if (lllIIIIlllIII.getSort() == 9) {
                    return false;
                }
                if (Annotations.getInvisibleParameter(lllIIIIllIIlI.handler, Coerce.class, lllIIIIllIlll) == null) {
                    return false;
                }
                if (Injector.canCoerce(lllIIIIllIlII[lllIIIIllIlll], lllIIIIllIIll[lllIIIIllIlll])) continue;
                return false;
            }
            return true;
        }

        String getCallbackInfoConstructorDescriptor() {
            Callback lllIIIlIllllI;
            return lllIIIlIllllI.isAtReturn ? CallbackInfo.getConstructorDescriptor(lllIIIlIllllI.target.returnType) : CallbackInfo.getConstructorDescriptor();
        }

        void add(AbstractInsnNode lllIIIlIlIlll, boolean lllIIIlIlIIlI, boolean lllIIIlIlIlIl) {
            Callback lllIIIlIlIlII;
            lllIIIlIlIlII.add(lllIIIlIlIlll, lllIIIlIlIIlI, lllIIIlIlIlIl, false);
        }

        boolean captureArgs() {
            Callback lllIIIIlIlIll;
            return lllIIIIlIlIll.captureArgs;
        }

        String getDescriptor() {
            Callback lllIIIllIIIll;
            return lllIIIllIIIll.canCaptureLocals ? lllIIIllIIIll.descl : lllIIIllIIIll.desc;
        }
    }
}

