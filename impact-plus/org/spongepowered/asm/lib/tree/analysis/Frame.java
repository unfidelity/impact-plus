/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.ArrayList;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.IincInsnNode;
import org.spongepowered.asm.lib.tree.InvokeDynamicInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MultiANewArrayInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.lib.tree.analysis.Interpreter;
import org.spongepowered.asm.lib.tree.analysis.Value;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class Frame<V extends Value> {
    private /* synthetic */ int top;
    private /* synthetic */ int locals;
    private /* synthetic */ V[] values;
    private /* synthetic */ V returnValue;

    public void setReturn(V llllllllllllllllllIlIIIllIIllIlI) {
        llllllllllllllllllIlIIIllIIllIll.returnValue = llllllllllllllllllIlIIIllIIllIlI;
    }

    public void clearStack() {
        llllllllllllllllllIlIIIlIlIlIlll.top = 0;
    }

    public int getStackSize() {
        Frame llllllllllllllllllIlIIIlIllllllI;
        return llllllllllllllllllIlIIIlIllllllI.top;
    }

    public Frame(int llllllllllllllllllIlIIIllIlIlllI, int llllllllllllllllllIlIIIllIlIllIl) {
        Frame llllllllllllllllllIlIIIllIlIllll;
        llllllllllllllllllIlIIIllIlIllll.values = new Value[llllllllllllllllllIlIIIllIlIlllI + llllllllllllllllllIlIIIllIlIllIl];
        llllllllllllllllllIlIIIllIlIllll.locals = llllllllllllllllllIlIIIllIlIlllI;
    }

    public void push(V llllllllllllllllllIlIIIlIIlIlIlI) throws IndexOutOfBoundsException {
        Frame llllllllllllllllllIlIIIlIIlIlIIl;
        if (llllllllllllllllllIlIIIlIIlIlIIl.top + llllllllllllllllllIlIIIlIIlIlIIl.locals >= llllllllllllllllllIlIIIlIIlIlIIl.values.length) {
            throw new IndexOutOfBoundsException("Insufficient maximum stack size.");
        }
        llllllllllllllllllIlIIIlIIlIlIIl.values[llllllllllllllllllIlIIIlIIlIlIIl.top++ + llllllllllllllllllIlIIIlIIlIlIIl.locals] = llllllllllllllllllIlIIIlIIlIlIlI;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void execute(AbstractInsnNode llllllllllllllllllIlIIIIlIIlIIIl, Interpreter<V> llllllllllllllllllIlIIIIlIIlIIII) throws AnalyzerException {
        switch (llllllllllllllllllIlIIIIlIIlIIIl.getOpcode()) {
            case 0: {
                return;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
            case 18: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.newOperation(llllllllllllllllllIlIIIIlIIlIIIl));
                return;
            }
            case 21: 
            case 22: 
            case 23: 
            case 24: 
            case 25: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.getLocal(((VarInsnNode)llllllllllllllllllIlIIIIlIIlIIIl).var)));
                return;
            }
            case 46: 
            case 47: 
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIllIIIlIl = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIllIIIllI = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.binaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIllIIIllI, llllllllllllllllllIlIIIIllIIIlIl));
                return;
            }
            case 54: 
            case 55: 
            case 56: 
            case 57: 
            case 58: {
                V llllllllllllllllllIlIIIIllIIIlII;
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                Object llllllllllllllllllIlIIIIllIIIIll = llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                int llllllllllllllllllIlIIIIllIIIIlI = ((VarInsnNode)llllllllllllllllllIlIIIIlIIlIIIl).var;
                llllllllllllllllllIlIIIIlIIlIlIl.setLocal(llllllllllllllllllIlIIIIllIIIIlI, llllllllllllllllllIlIIIIllIIIIll);
                if (llllllllllllllllllIlIIIIllIIIIll.getSize() == 2) {
                    llllllllllllllllllIlIIIIlIIlIlIl.setLocal(llllllllllllllllllIlIIIIllIIIIlI + 1, llllllllllllllllllIlIIIIlIIlIIII.newValue(null));
                }
                if (llllllllllllllllllIlIIIIllIIIIlI <= 0 || (llllllllllllllllllIlIIIIllIIIlII = llllllllllllllllllIlIIIIlIIlIlIl.getLocal(llllllllllllllllllIlIIIIllIIIIlI - 1)) == null || llllllllllllllllllIlIIIIllIIIlII.getSize() != 2) return;
                llllllllllllllllllIlIIIIlIIlIlIl.setLocal(llllllllllllllllllIlIIIIllIIIIlI - 1, llllllllllllllllllIlIIIIlIIlIIII.newValue(null));
                return;
            }
            case 79: 
            case 80: 
            case 81: 
            case 82: 
            case 83: 
            case 84: 
            case 85: 
            case 86: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIllllll = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIllIIIIII = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIllIIIIIl = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                llllllllllllllllllIlIIIIlIIlIIII.ternaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIllIIIIIl, llllllllllllllllllIlIIIIllIIIIII, llllllllllllllllllIlIIIIlIllllll);
                return;
            }
            case 87: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                if (llllllllllllllllllIlIIIIlIIlIlIl.pop().getSize() != 2) return;
                throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of POP");
            }
            case 88: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                if (llllllllllllllllllIlIIIIlIIlIlIl.pop().getSize() != 1 || llllllllllllllllllIlIIIIlIIlIlIl.pop().getSize() == 1) return;
                throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of POP2");
            }
            case 89: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIlllllI = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIlllllI.getSize() != 1) {
                    throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP");
                }
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlllllI);
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlllllI));
                return;
            }
            case 90: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIllllIl = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIlIllllII = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIllllIl.getSize() != 1 || llllllllllllllllllIlIIIIlIllllII.getSize() != 1) {
                    throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP_X1");
                }
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIllllIl));
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllllII);
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllllIl);
                return;
            }
            case 91: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIlllIIl = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIlllIIl.getSize() != 1) throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP_X2");
                V llllllllllllllllllIlIIIIlIlllIlI = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIlllIlI.getSize() == 1) {
                    V llllllllllllllllllIlIIIIlIlllIll = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                    if (llllllllllllllllllIlIIIIlIlllIll.getSize() != 1) throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP_X2");
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlllIIl));
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlllIll);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlllIlI);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlllIIl);
                    return;
                }
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlllIIl));
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlllIlI);
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlllIIl);
                return;
            }
            case 92: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIllIlll = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIllIlll.getSize() == 1) {
                    V llllllllllllllllllIlIIIIlIlllIII = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                    if (llllllllllllllllllIlIIIIlIlllIII.getSize() != 1) throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP2");
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlllIII);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIlll);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlllIII));
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIllIlll));
                    return;
                }
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIlll);
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIllIlll));
                return;
            }
            case 93: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIllIIll = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIllIIll.getSize() == 1) {
                    V llllllllllllllllllIlIIIIlIllIlII;
                    V llllllllllllllllllIlIIIIlIllIlIl = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                    if (llllllllllllllllllIlIIIIlIllIlIl.getSize() != 1 || (llllllllllllllllllIlIIIIlIllIlII = llllllllllllllllllIlIIIIlIIlIlIl.pop()).getSize() != 1) throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP2_X1");
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIllIlIl));
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIllIIll));
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIlII);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIlIl);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIIll);
                    return;
                }
                V llllllllllllllllllIlIIIIlIllIIlI = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIllIIlI.getSize() != 1) throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP2_X1");
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIllIIll));
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIIlI);
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIIll);
                return;
            }
            case 94: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIlIllIl = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIlIllIl.getSize() == 1) {
                    V llllllllllllllllllIlIIIIlIllIIII = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                    if (llllllllllllllllllIlIIIIlIllIIII.getSize() != 1) throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP2_X2");
                    V llllllllllllllllllIlIIIIlIlIllll = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                    if (llllllllllllllllllIlIIIIlIlIllll.getSize() == 1) {
                        V llllllllllllllllllIlIIIIlIllIIIl = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                        if (llllllllllllllllllIlIIIIlIllIIIl.getSize() != 1) throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP2_X2");
                        llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIllIIII));
                        llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIllIl));
                        llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIIIl);
                        llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlIllll);
                        llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIIII);
                        llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlIllIl);
                        return;
                    }
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIllIIII));
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIllIl));
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlIllll);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIllIIII);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlIllIl);
                    return;
                }
                V llllllllllllllllllIlIIIIlIlIllII = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIlIllII.getSize() == 1) {
                    V llllllllllllllllllIlIIIIlIlIlllI = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                    if (llllllllllllllllllIlIIIIlIlIlllI.getSize() != 1) throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of DUP2_X2");
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIllIl));
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlIlllI);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlIllII);
                    llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlIllIl);
                    return;
                }
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIllIl));
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlIllII);
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIlIllIl);
                return;
            }
            case 95: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIlIlIlI = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIlIlIlIll = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                if (llllllllllllllllllIlIIIIlIlIlIll.getSize() != 1 || llllllllllllllllllIlIIIIlIlIlIlI.getSize() != 1) {
                    throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Illegal use of SWAP");
                }
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIlIlI));
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.copyOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIlIll));
                return;
            }
            case 96: 
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 101: 
            case 102: 
            case 103: 
            case 104: 
            case 105: 
            case 106: 
            case 107: 
            case 108: 
            case 109: 
            case 110: 
            case 111: 
            case 112: 
            case 113: 
            case 114: 
            case 115: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIlIlIII = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIlIlIlIIl = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.binaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIlIIl, llllllllllllllllllIlIIIIlIlIlIII));
                return;
            }
            case 116: 
            case 117: 
            case 118: 
            case 119: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop()));
                return;
            }
            case 120: 
            case 121: 
            case 122: 
            case 123: 
            case 124: 
            case 125: 
            case 126: 
            case 127: 
            case 128: 
            case 129: 
            case 130: 
            case 131: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIlIIllI = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIlIlIIlll = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.binaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIIlll, llllllllllllllllllIlIIIIlIlIIllI));
                return;
            }
            case 132: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                int llllllllllllllllllIlIIIIlIlIIlIl = ((IincInsnNode)llllllllllllllllllIlIIIIlIIlIIIl).var;
                llllllllllllllllllIlIIIIlIIlIlIl.setLocal(llllllllllllllllllIlIIIIlIlIIlIl, llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.getLocal(llllllllllllllllllIlIIIIlIlIIlIl)));
                return;
            }
            case 133: 
            case 134: 
            case 135: 
            case 136: 
            case 137: 
            case 138: 
            case 139: 
            case 140: 
            case 141: 
            case 142: 
            case 143: 
            case 144: 
            case 145: 
            case 146: 
            case 147: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop()));
                return;
            }
            case 148: 
            case 149: 
            case 150: 
            case 151: 
            case 152: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIlIIIll = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIlIlIIlII = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.binaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIIlII, llllllllllllllllllIlIIIIlIlIIIll));
                return;
            }
            case 153: 
            case 154: 
            case 155: 
            case 156: 
            case 157: 
            case 158: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                return;
            }
            case 159: 
            case 160: 
            case 161: 
            case 162: 
            case 163: 
            case 164: 
            case 165: 
            case 166: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIlIIIIl = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIlIlIIIlI = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                llllllllllllllllllIlIIIIlIIlIIII.binaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIIIlI, llllllllllllllllllIlIIIIlIlIIIIl);
                return;
            }
            case 167: {
                return;
            }
            case 168: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.newOperation(llllllllllllllllllIlIIIIlIIlIIIl));
                return;
            }
            case 169: {
                return;
            }
            case 170: 
            case 171: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                return;
            }
            case 172: 
            case 173: 
            case 174: 
            case 175: 
            case 176: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIlIIIII = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIIIII);
                llllllllllllllllllIlIIIIlIIlIIII.returnOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIlIIIII, llllllllllllllllllIlIIIIlIIlIlIl.returnValue);
                return;
            }
            case 177: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                if (llllllllllllllllllIlIIIIlIIlIlIl.returnValue == null) return;
                throw new AnalyzerException(llllllllllllllllllIlIIIIlIIlIIIl, "Incompatible return type");
            }
            case 178: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.newOperation(llllllllllllllllllIlIIIIlIIlIIIl));
                return;
            }
            case 179: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                return;
            }
            case 180: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop()));
                return;
            }
            case 181: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                V llllllllllllllllllIlIIIIlIIllllI = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                V llllllllllllllllllIlIIIIlIIlllll = llllllllllllllllllIlIIIIlIIlIlIl.pop();
                llllllllllllllllllIlIIIIlIIlIIII.binaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlllll, llllllllllllllllllIlIIIIlIIllllI);
                return;
            }
            case 182: 
            case 183: 
            case 184: 
            case 185: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                ArrayList<V> llllllllllllllllllIlIIIIlIIllIll = new ArrayList<V>();
                String llllllllllllllllllIlIIIIlIIlllII = ((MethodInsnNode)llllllllllllllllllIlIIIIlIIlIIIl).desc;
                for (int llllllllllllllllllIlIIIIlIIlllIl = Type.getArgumentTypes(llllllllllllllllllIlIIIIlIIlllII).length; llllllllllllllllllIlIIIIlIIlllIl > 0; --llllllllllllllllllIlIIIIlIIlllIl) {
                    llllllllllllllllllIlIIIIlIIllIll.add(0, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                }
                if (llllllllllllllllllIlIIIIlIIlIIIl.getOpcode() != 184) {
                    llllllllllllllllllIlIIIIlIIllIll.add(0, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                }
                if (Type.getReturnType(llllllllllllllllllIlIIIIlIIlllII) == Type.VOID_TYPE) {
                    llllllllllllllllllIlIIIIlIIlIIII.naryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIllIll);
                    return;
                }
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.naryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIllIll));
                return;
            }
            case 186: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                ArrayList<V> llllllllllllllllllIlIIIIlIIllIII = new ArrayList<V>();
                String llllllllllllllllllIlIIIIlIIllIIl = ((InvokeDynamicInsnNode)llllllllllllllllllIlIIIIlIIlIIIl).desc;
                for (int llllllllllllllllllIlIIIIlIIllIlI = Type.getArgumentTypes(llllllllllllllllllIlIIIIlIIllIIl).length; llllllllllllllllllIlIIIIlIIllIlI > 0; --llllllllllllllllllIlIIIIlIIllIlI) {
                    llllllllllllllllllIlIIIIlIIllIII.add(0, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                }
                if (Type.getReturnType(llllllllllllllllllIlIIIIlIIllIIl) == Type.VOID_TYPE) {
                    llllllllllllllllllIlIIIIlIIlIIII.naryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIllIII);
                    return;
                }
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.naryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIllIII));
                return;
            }
            case 187: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.newOperation(llllllllllllllllllIlIIIIlIIlIIIl));
                return;
            }
            case 188: 
            case 189: 
            case 190: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop()));
                return;
            }
            case 191: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                return;
            }
            case 192: 
            case 193: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop()));
                return;
            }
            case 194: 
            case 195: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                return;
            }
            case 197: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                ArrayList<V> llllllllllllllllllIlIIIIlIIlIllI = new ArrayList<V>();
                for (int llllllllllllllllllIlIIIIlIIlIlll = ((MultiANewArrayInsnNode)llllllllllllllllllIlIIIIlIIlIIIl).dims; llllllllllllllllllIlIIIIlIIlIlll > 0; --llllllllllllllllllIlIIIIlIIlIlll) {
                    llllllllllllllllllIlIIIIlIIlIllI.add(0, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                }
                llllllllllllllllllIlIIIIlIIlIlIl.push(llllllllllllllllllIlIIIIlIIlIIII.naryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIllI));
                return;
            }
            case 198: 
            case 199: {
                Frame llllllllllllllllllIlIIIIlIIlIlIl;
                llllllllllllllllllIlIIIIlIIlIIII.unaryOperation(llllllllllllllllllIlIIIIlIIlIIIl, llllllllllllllllllIlIIIIlIIlIlIl.pop());
                return;
            }
            default: {
                throw new RuntimeException(String.valueOf(new StringBuilder().append("Illegal opcode ").append(llllllllllllllllllIlIIIIlIIlIIIl.getOpcode())));
            }
        }
    }

    public int getLocals() {
        Frame llllllllllllllllllIlIIIllIIlIlIl;
        return llllllllllllllllllIlIIIllIIlIlIl.locals;
    }

    public Frame<V> init(Frame<? extends V> llllllllllllllllllIlIIIllIIllllI) {
        Frame llllllllllllllllllIlIIIllIlIIIIl;
        llllllllllllllllllIlIIIllIlIIIIl.returnValue = llllllllllllllllllIlIIIllIIllllI.returnValue;
        System.arraycopy(llllllllllllllllllIlIIIllIIllllI.values, 0, llllllllllllllllllIlIIIllIlIIIIl.values, 0, llllllllllllllllllIlIIIllIlIIIIl.values.length);
        llllllllllllllllllIlIIIllIlIIIIl.top = llllllllllllllllllIlIIIllIIllllI.top;
        return llllllllllllllllllIlIIIllIlIIIIl;
    }

    public void setLocal(int llllllllllllllllllIlIIIllIIIIlll, V llllllllllllllllllIlIIIllIIIIllI) throws IndexOutOfBoundsException {
        Frame llllllllllllllllllIlIIIllIIIIlIl;
        if (llllllllllllllllllIlIIIllIIIIlll >= llllllllllllllllllIlIIIllIIIIlIl.locals) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Trying to access an inexistant local variable ").append(llllllllllllllllllIlIIIllIIIIlll)));
        }
        llllllllllllllllllIlIIIllIIIIlIl.values[llllllllllllllllllIlIIIllIIIIlll] = llllllllllllllllllIlIIIllIIIIllI;
    }

    public V getLocal(int llllllllllllllllllIlIIIllIIIlllI) throws IndexOutOfBoundsException {
        Frame llllllllllllllllllIlIIIllIIIllll;
        if (llllllllllllllllllIlIIIllIIIlllI >= llllllllllllllllllIlIIIllIIIllll.locals) {
            throw new IndexOutOfBoundsException("Trying to access an inexistant local variable");
        }
        return llllllllllllllllllIlIIIllIIIllll.values[llllllllllllllllllIlIIIllIIIlllI];
    }

    public String toString() {
        Frame llllllllllllllllllIlIIIIIlIlllll;
        StringBuilder llllllllllllllllllIlIIIIIllIIIII = new StringBuilder();
        for (int llllllllllllllllllIlIIIIIllIIIll = 0; llllllllllllllllllIlIIIIIllIIIll < llllllllllllllllllIlIIIIIlIlllll.getLocals(); ++llllllllllllllllllIlIIIIIllIIIll) {
            llllllllllllllllllIlIIIIIllIIIII.append(llllllllllllllllllIlIIIIIlIlllll.getLocal(llllllllllllllllllIlIIIIIllIIIll));
        }
        llllllllllllllllllIlIIIIIllIIIII.append(' ');
        for (int llllllllllllllllllIlIIIIIllIIIlI = 0; llllllllllllllllllIlIIIIIllIIIlI < llllllllllllllllllIlIIIIIlIlllll.getStackSize(); ++llllllllllllllllllIlIIIIIllIIIlI) {
            llllllllllllllllllIlIIIIIllIIIII.append(llllllllllllllllllIlIIIIIlIlllll.getStack(llllllllllllllllllIlIIIIIllIIIlI).toString());
        }
        return String.valueOf(llllllllllllllllllIlIIIIIllIIIII);
    }

    public Frame(Frame<? extends V> llllllllllllllllllIlIIIllIlIIlII) {
        llllllllllllllllllIlIIIllIlIIlll(llllllllllllllllllIlIIIllIlIIlII.locals, llllllllllllllllllIlIIIllIlIIlII.values.length - llllllllllllllllllIlIIIllIlIIlII.locals);
        Frame<? extends V> llllllllllllllllllIlIIIllIlIIlll;
        llllllllllllllllllIlIIIllIlIIlll.init(llllllllllllllllllIlIIIllIlIIlII);
    }

    public V pop() throws IndexOutOfBoundsException {
        Frame llllllllllllllllllIlIIIlIlIIIIIl;
        if (llllllllllllllllllIlIIIlIlIIIIIl.top == 0) {
            throw new IndexOutOfBoundsException("Cannot pop operand off an empty stack.");
        }
        return llllllllllllllllllIlIIIlIlIIIIIl.values[--llllllllllllllllllIlIIIlIlIIIIIl.top + llllllllllllllllllIlIIIlIlIIIIIl.locals];
    }

    public boolean merge(Frame<? extends V> llllllllllllllllllIlIIIIIllllllI, Interpreter<V> llllllllllllllllllIlIIIIIllllIIl) throws AnalyzerException {
        Frame llllllllllllllllllIlIIIIIllllIll;
        if (llllllllllllllllllIlIIIIIllllIll.top != llllllllllllllllllIlIIIIIllllllI.top) {
            throw new AnalyzerException(null, "Incompatible stack heights");
        }
        boolean llllllllllllllllllIlIIIIIlllllII = false;
        for (int llllllllllllllllllIlIIIIlIIIIIII = 0; llllllllllllllllllIlIIIIlIIIIIII < llllllllllllllllllIlIIIIIllllIll.locals + llllllllllllllllllIlIIIIIllllIll.top; ++llllllllllllllllllIlIIIIlIIIIIII) {
            V llllllllllllllllllIlIIIIlIIIIIIl = llllllllllllllllllIlIIIIIllllIIl.merge(llllllllllllllllllIlIIIIIllllIll.values[llllllllllllllllllIlIIIIlIIIIIII], llllllllllllllllllIlIIIIIllllllI.values[llllllllllllllllllIlIIIIlIIIIIII]);
            if (llllllllllllllllllIlIIIIlIIIIIIl.equals(llllllllllllllllllIlIIIIIllllIll.values[llllllllllllllllllIlIIIIlIIIIIII])) continue;
            llllllllllllllllllIlIIIIIllllIll.values[llllllllllllllllllIlIIIIlIIIIIII] = llllllllllllllllllIlIIIIlIIIIIIl;
            llllllllllllllllllIlIIIIIlllllII = true;
        }
        return llllllllllllllllllIlIIIIIlllllII;
    }

    public boolean merge(Frame<? extends V> llllllllllllllllllIlIIIIIllIlllI, boolean[] llllllllllllllllllIlIIIIIllIllIl) {
        Frame llllllllllllllllllIlIIIIIllIllll;
        boolean llllllllllllllllllIlIIIIIllIllII = false;
        for (int llllllllllllllllllIlIIIIIlllIIII = 0; llllllllllllllllllIlIIIIIlllIIII < llllllllllllllllllIlIIIIIllIllll.locals; ++llllllllllllllllllIlIIIIIlllIIII) {
            if (llllllllllllllllllIlIIIIIllIllIl[llllllllllllllllllIlIIIIIlllIIII] || llllllllllllllllllIlIIIIIllIllll.values[llllllllllllllllllIlIIIIIlllIIII].equals(llllllllllllllllllIlIIIIIllIlllI.values[llllllllllllllllllIlIIIIIlllIIII])) continue;
            llllllllllllllllllIlIIIIIllIllll.values[llllllllllllllllllIlIIIIIlllIIII] = llllllllllllllllllIlIIIIIllIlllI.values[llllllllllllllllllIlIIIIIlllIIII];
            llllllllllllllllllIlIIIIIllIllII = true;
        }
        return llllllllllllllllllIlIIIIIllIllII;
    }

    public int getMaxStackSize() {
        Frame llllllllllllllllllIlIIIllIIlIIll;
        return llllllllllllllllllIlIIIllIIlIIll.values.length - llllllllllllllllllIlIIIllIIlIIll.locals;
    }

    public V getStack(int llllllllllllllllllIlIIIlIllIlIlI) throws IndexOutOfBoundsException {
        Frame llllllllllllllllllIlIIIlIllIllII;
        return llllllllllllllllllIlIIIlIllIllII.values[llllllllllllllllllIlIIIlIllIlIlI + llllllllllllllllllIlIIIlIllIllII.locals];
    }
}

