/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.Item;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.Type;

class Frame {
    static final /* synthetic */ int FLOAT;
    static final /* synthetic */ int BYTE;
    /* synthetic */ int[] inputLocals;
    static final /* synthetic */ int ELEMENT_OF;
    static final /* synthetic */ int BASE;
    private /* synthetic */ int initializationCount;
    static final /* synthetic */ int BASE_VALUE;
    static final /* synthetic */ int INTEGER;
    /* synthetic */ int outputStackTop;
    static final /* synthetic */ int OBJECT;
    static final /* synthetic */ int DIM;
    static final /* synthetic */ int LONG;
    static final /* synthetic */ int UNINITIALIZED_THIS;
    static final /* synthetic */ int DOUBLE;
    private /* synthetic */ int[] initializations;
    static final /* synthetic */ int UNINITIALIZED;
    static final /* synthetic */ int ARRAY_OF;
    static final /* synthetic */ int[] SIZE;
    private /* synthetic */ int[] outputStack;
    /* synthetic */ Label owner;
    static final /* synthetic */ int BOOLEAN;
    private /* synthetic */ int[] outputLocals;
    static final /* synthetic */ int SHORT;
    static final /* synthetic */ int CHAR;
    static final /* synthetic */ int VALUE;
    static final /* synthetic */ int NULL;
    /* synthetic */ int[] inputStack;
    static final /* synthetic */ int TOP;
    static final /* synthetic */ int KIND;
    static final /* synthetic */ int BASE_KIND;
    private static final /* synthetic */ int STACK;
    static final /* synthetic */ int TOP_IF_LONG_OR_DOUBLE;
    private static final /* synthetic */ int LOCAL;

    private void init(int llllllllllllllllllllIIIlIlIllIlI) {
        int llllllllllllllllllllIIIlIlIllIIl;
        Frame llllllllllllllllllllIIIlIlIllIll;
        if (llllllllllllllllllllIIIlIlIllIll.initializations == null) {
            llllllllllllllllllllIIIlIlIllIll.initializations = new int[2];
        }
        if (llllllllllllllllllllIIIlIlIllIll.initializationCount >= (llllllllllllllllllllIIIlIlIllIIl = llllllllllllllllllllIIIlIlIllIll.initializations.length)) {
            int[] llllllllllllllllllllIIIlIlIlllII = new int[Math.max(llllllllllllllllllllIIIlIlIllIll.initializationCount + 1, 2 * llllllllllllllllllllIIIlIlIllIIl)];
            System.arraycopy(llllllllllllllllllllIIIlIlIllIll.initializations, 0, llllllllllllllllllllIIIlIlIlllII, 0, llllllllllllllllllllIIIlIlIllIIl);
            llllllllllllllllllllIIIlIlIllIll.initializations = llllllllllllllllllllIIIlIlIlllII;
        }
        llllllllllllllllllllIIIlIlIllIll.initializations[llllllllllllllllllllIIIlIlIllIll.initializationCount++] = llllllllllllllllllllIIIlIlIllIlI;
    }

    void execute(int llllllllllllllllllllIIIIlllIIllI, int llllllllllllllllllllIIIIlllIIlIl, ClassWriter llllllllllllllllllllIIIIlllIIlII, Item llllllllllllllllllllIIIIlllIIIll) {
        block0 : switch (llllllllllllllllllllIIIIlllIIllI) {
            case 0: 
            case 116: 
            case 117: 
            case 118: 
            case 119: 
            case 145: 
            case 146: 
            case 147: 
            case 167: 
            case 177: {
                break;
            }
            case 1: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000005);
                break;
            }
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 16: 
            case 17: 
            case 21: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000001);
                break;
            }
            case 9: 
            case 10: 
            case 22: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000004);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                break;
            }
            case 11: 
            case 12: 
            case 13: 
            case 23: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000002);
                break;
            }
            case 14: 
            case 15: 
            case 24: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000003);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                break;
            }
            case 18: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                switch (llllllllllllllllllllIIIIlllIIIll.type) {
                    case 3: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1000001);
                        break block0;
                    }
                    case 5: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1000004);
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                        break block0;
                    }
                    case 4: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1000002);
                        break block0;
                    }
                    case 6: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1000003);
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                        break block0;
                    }
                    case 7: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1700000 | llllllllllllllllllllIIIIlllIIlII.addType("java/lang/Class"));
                        break block0;
                    }
                    case 8: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1700000 | llllllllllllllllllllIIIIlllIIlII.addType("java/lang/String"));
                        break block0;
                    }
                    case 16: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1700000 | llllllllllllllllllllIIIIlllIIlII.addType("java/lang/invoke/MethodType"));
                        break block0;
                    }
                }
                llllllllllllllllllllIIIIlllIIIlI.push(0x1700000 | llllllllllllllllllllIIIIlllIIlII.addType("java/lang/invoke/MethodHandle"));
                break;
            }
            case 25: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIIIlI.get(llllllllllllllllllllIIIIlllIIlIl));
                break;
            }
            case 46: 
            case 51: 
            case 52: 
            case 53: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(2);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000001);
                break;
            }
            case 47: 
            case 143: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(2);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000004);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                break;
            }
            case 48: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(2);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000002);
                break;
            }
            case 49: 
            case 138: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(2);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000003);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                break;
            }
            case 50: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(1);
                int llllllllllllllllllllIIIlIIIIIIII = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.push(-268435456 + llllllllllllllllllllIIIlIIIIIIII);
                break;
            }
            case 54: 
            case 56: 
            case 58: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                int llllllllllllllllllllIIIIllllllll = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.set(llllllllllllllllllllIIIIlllIIlIl, llllllllllllllllllllIIIIllllllll);
                if (llllllllllllllllllllIIIIlllIIlIl <= 0) break;
                int llllllllllllllllllllIIIIlllllllI = llllllllllllllllllllIIIIlllIIIlI.get(llllllllllllllllllllIIIIlllIIlIl - 1);
                if (llllllllllllllllllllIIIIlllllllI == 0x1000004 || llllllllllllllllllllIIIIlllllllI == 0x1000003) {
                    llllllllllllllllllllIIIIlllIIIlI.set(llllllllllllllllllllIIIIlllIIlIl - 1, 0x1000000);
                    break;
                }
                if ((llllllllllllllllllllIIIIlllllllI & 0xF000000) == 0x1000000) break;
                llllllllllllllllllllIIIIlllIIIlI.set(llllllllllllllllllllIIIIlllIIlIl - 1, llllllllllllllllllllIIIIlllllllI | 0x800000);
                break;
            }
            case 55: 
            case 57: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(1);
                int llllllllllllllllllllIIIIllllllIl = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.set(llllllllllllllllllllIIIIlllIIlIl, llllllllllllllllllllIIIIllllllIl);
                llllllllllllllllllllIIIIlllIIIlI.set(llllllllllllllllllllIIIIlllIIlIl + 1, 0x1000000);
                if (llllllllllllllllllllIIIIlllIIlIl <= 0) break;
                int llllllllllllllllllllIIIIllllllII = llllllllllllllllllllIIIIlllIIIlI.get(llllllllllllllllllllIIIIlllIIlIl - 1);
                if (llllllllllllllllllllIIIIllllllII == 0x1000004 || llllllllllllllllllllIIIIllllllII == 0x1000003) {
                    llllllllllllllllllllIIIIlllIIIlI.set(llllllllllllllllllllIIIIlllIIlIl - 1, 0x1000000);
                    break;
                }
                if ((llllllllllllllllllllIIIIllllllII & 0xF000000) == 0x1000000) break;
                llllllllllllllllllllIIIIlllIIIlI.set(llllllllllllllllllllIIIIlllIIlIl - 1, llllllllllllllllllllIIIIllllllII | 0x800000);
                break;
            }
            case 79: 
            case 81: 
            case 83: 
            case 84: 
            case 85: 
            case 86: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(3);
                break;
            }
            case 80: 
            case 82: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(4);
                break;
            }
            case 87: 
            case 153: 
            case 154: 
            case 155: 
            case 156: 
            case 157: 
            case 158: 
            case 170: 
            case 171: 
            case 172: 
            case 174: 
            case 176: 
            case 191: 
            case 194: 
            case 195: 
            case 198: 
            case 199: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(1);
                break;
            }
            case 88: 
            case 159: 
            case 160: 
            case 161: 
            case 162: 
            case 163: 
            case 164: 
            case 165: 
            case 166: 
            case 173: 
            case 175: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(2);
                break;
            }
            case 89: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                int llllllllllllllllllllIIIIlllllIll = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllllIll);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllllIll);
                break;
            }
            case 90: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                int llllllllllllllllllllIIIIlllllIlI = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIlllllIIl = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllllIlI);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllllIIl);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllllIlI);
                break;
            }
            case 91: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                int llllllllllllllllllllIIIIlllllIII = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIllllIlll = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIllllIllI = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllllIII);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIllI);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIlll);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllllIII);
                break;
            }
            case 92: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                int llllllllllllllllllllIIIIllllIlIl = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIllllIlII = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIlII);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIlIl);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIlII);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIlIl);
                break;
            }
            case 93: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                int llllllllllllllllllllIIIIllllIIll = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIllllIIlI = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIllllIIIl = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIIlI);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIIll);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIIIl);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIIlI);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIIll);
                break;
            }
            case 94: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                int llllllllllllllllllllIIIIllllIIII = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIlllIllll = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIlllIlllI = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIlllIllIl = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIllll);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIIII);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIllIl);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIlllI);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIllll);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIllllIIII);
                break;
            }
            case 95: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                int llllllllllllllllllllIIIIlllIllII = llllllllllllllllllllIIIIlllIIIlI.pop();
                int llllllllllllllllllllIIIIlllIlIll = llllllllllllllllllllIIIIlllIIIlI.pop();
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIllII);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIlIll);
                break;
            }
            case 96: 
            case 100: 
            case 104: 
            case 108: 
            case 112: 
            case 120: 
            case 122: 
            case 124: 
            case 126: 
            case 128: 
            case 130: 
            case 136: 
            case 142: 
            case 149: 
            case 150: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(2);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000001);
                break;
            }
            case 97: 
            case 101: 
            case 105: 
            case 109: 
            case 113: 
            case 127: 
            case 129: 
            case 131: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(4);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000004);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                break;
            }
            case 98: 
            case 102: 
            case 106: 
            case 110: 
            case 114: 
            case 137: 
            case 144: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(2);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000002);
                break;
            }
            case 99: 
            case 103: 
            case 107: 
            case 111: 
            case 115: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(4);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000003);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                break;
            }
            case 121: 
            case 123: 
            case 125: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(3);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000004);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                break;
            }
            case 132: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.set(llllllllllllllllllllIIIIlllIIlIl, 0x1000001);
                break;
            }
            case 133: 
            case 140: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(1);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000004);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                break;
            }
            case 134: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(1);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000002);
                break;
            }
            case 135: 
            case 141: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(1);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000003);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000000);
                break;
            }
            case 139: 
            case 190: 
            case 193: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(1);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000001);
                break;
            }
            case 148: 
            case 151: 
            case 152: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(4);
                llllllllllllllllllllIIIIlllIIIlI.push(0x1000001);
                break;
            }
            case 168: 
            case 169: {
                throw new RuntimeException("JSR/RET are not supported with computeFrames option");
            }
            case 178: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIIlII, llllllllllllllllllllIIIIlllIIIll.strVal3);
                break;
            }
            case 179: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(llllllllllllllllllllIIIIlllIIIll.strVal3);
                break;
            }
            case 180: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(1);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIIlII, llllllllllllllllllllIIIIlllIIIll.strVal3);
                break;
            }
            case 181: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(llllllllllllllllllllIIIIlllIIIll.strVal3);
                llllllllllllllllllllIIIIlllIIIlI.pop();
                break;
            }
            case 182: 
            case 183: 
            case 184: 
            case 185: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(llllllllllllllllllllIIIIlllIIIll.strVal3);
                if (llllllllllllllllllllIIIIlllIIllI != 184) {
                    int llllllllllllllllllllIIIIlllIlIlI = llllllllllllllllllllIIIIlllIIIlI.pop();
                    if (llllllllllllllllllllIIIIlllIIllI == 183 && llllllllllllllllllllIIIIlllIIIll.strVal2.charAt(0) == '<') {
                        llllllllllllllllllllIIIIlllIIIlI.init(llllllllllllllllllllIIIIlllIlIlI);
                    }
                }
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIIlII, llllllllllllllllllllIIIIlllIIIll.strVal3);
                break;
            }
            case 186: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(llllllllllllllllllllIIIIlllIIIll.strVal2);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIIlII, llllllllllllllllllllIIIIlllIIIll.strVal2);
                break;
            }
            case 187: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.push(0x1800000 | llllllllllllllllllllIIIIlllIIlII.addUninitializedType(llllllllllllllllllllIIIIlllIIIll.strVal1, llllllllllllllllllllIIIIlllIIlIl));
                break;
            }
            case 188: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop();
                switch (llllllllllllllllllllIIIIlllIIlIl) {
                    case 4: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x11000009);
                        break block0;
                    }
                    case 5: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1100000B);
                        break block0;
                    }
                    case 8: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1100000A);
                        break block0;
                    }
                    case 9: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x1100000C);
                        break block0;
                    }
                    case 10: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x11000001);
                        break block0;
                    }
                    case 6: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x11000002);
                        break block0;
                    }
                    case 7: {
                        llllllllllllllllllllIIIIlllIIIlI.push(0x11000003);
                        break block0;
                    }
                }
                llllllllllllllllllllIIIIlllIIIlI.push(0x11000004);
                break;
            }
            case 189: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                String llllllllllllllllllllIIIIlllIlIIl = llllllllllllllllllllIIIIlllIIIll.strVal1;
                llllllllllllllllllllIIIIlllIIIlI.pop();
                if (llllllllllllllllllllIIIIlllIlIIl.charAt(0) == '[') {
                    llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIIlII, String.valueOf(new StringBuilder().append('[').append(llllllllllllllllllllIIIIlllIlIIl)));
                    break;
                }
                llllllllllllllllllllIIIIlllIIIlI.push(0x11700000 | llllllllllllllllllllIIIIlllIIlII.addType(llllllllllllllllllllIIIIlllIlIIl));
                break;
            }
            case 192: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                String llllllllllllllllllllIIIIlllIlIII = llllllllllllllllllllIIIIlllIIIll.strVal1;
                llllllllllllllllllllIIIIlllIIIlI.pop();
                if (llllllllllllllllllllIIIIlllIlIII.charAt(0) == '[') {
                    llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIIlII, llllllllllllllllllllIIIIlllIlIII);
                    break;
                }
                llllllllllllllllllllIIIIlllIIIlI.push(0x1700000 | llllllllllllllllllllIIIIlllIIlII.addType(llllllllllllllllllllIIIIlllIlIII));
                break;
            }
            default: {
                Frame llllllllllllllllllllIIIIlllIIIlI;
                llllllllllllllllllllIIIIlllIIIlI.pop(llllllllllllllllllllIIIIlllIIlIl);
                llllllllllllllllllllIIIIlllIIIlI.push(llllllllllllllllllllIIIIlllIIlII, llllllllllllllllllllIIIIlllIIIll.strVal1);
            }
        }
    }

    private static int type(ClassWriter llllllllllllllllllllIIIlIllllIll, String llllllllllllllllllllIIIlIlllIlll) {
        int llllllllllllllllllllIIIlIlllllIl;
        int llllllllllllllllllllIIIlIllllIIl = llllllllllllllllllllIIIlIlllIlll.charAt(0) == '(' ? llllllllllllllllllllIIIlIlllIlll.indexOf(41) + 1 : 0;
        switch (llllllllllllllllllllIIIlIlllIlll.charAt(llllllllllllllllllllIIIlIllllIIl)) {
            case 'V': {
                return 0;
            }
            case 'B': 
            case 'C': 
            case 'I': 
            case 'S': 
            case 'Z': {
                return 0x1000001;
            }
            case 'F': {
                return 0x1000002;
            }
            case 'J': {
                return 0x1000004;
            }
            case 'D': {
                return 0x1000003;
            }
            case 'L': {
                String llllllllllllllllllllIIIllIIIIlll = llllllllllllllllllllIIIlIlllIlll.substring(llllllllllllllllllllIIIlIllllIIl + 1, llllllllllllllllllllIIIlIlllIlll.length() - 1);
                return 0x1700000 | llllllllllllllllllllIIIlIllllIll.addType(llllllllllllllllllllIIIllIIIIlll);
            }
        }
        int llllllllllllllllllllIIIlIlllllII = llllllllllllllllllllIIIlIllllIIl + 1;
        while (llllllllllllllllllllIIIlIlllIlll.charAt(llllllllllllllllllllIIIlIlllllII) == '[') {
            ++llllllllllllllllllllIIIlIlllllII;
        }
        switch (llllllllllllllllllllIIIlIlllIlll.charAt(llllllllllllllllllllIIIlIlllllII)) {
            case 'Z': {
                int llllllllllllllllllllIIIllIIIIllI = 0x1000009;
                break;
            }
            case 'C': {
                int llllllllllllllllllllIIIllIIIIlIl = 0x100000B;
                break;
            }
            case 'B': {
                int llllllllllllllllllllIIIllIIIIlII = 0x100000A;
                break;
            }
            case 'S': {
                int llllllllllllllllllllIIIllIIIIIll = 0x100000C;
                break;
            }
            case 'I': {
                int llllllllllllllllllllIIIllIIIIIlI = 0x1000001;
                break;
            }
            case 'F': {
                int llllllllllllllllllllIIIllIIIIIIl = 0x1000002;
                break;
            }
            case 'J': {
                int llllllllllllllllllllIIIllIIIIIII = 0x1000004;
                break;
            }
            case 'D': {
                int llllllllllllllllllllIIIlIlllllll = 0x1000003;
                break;
            }
            default: {
                String llllllllllllllllllllIIIlIllllllI = llllllllllllllllllllIIIlIlllIlll.substring(llllllllllllllllllllIIIlIlllllII + 1, llllllllllllllllllllIIIlIlllIlll.length() - 1);
                llllllllllllllllllllIIIlIlllllIl = 0x1700000 | llllllllllllllllllllIIIlIllllIll.addType(llllllllllllllllllllIIIlIllllllI);
            }
        }
        return llllllllllllllllllllIIIlIlllllII - llllllllllllllllllllIIIlIllllIIl << 28 | llllllllllllllllllllIIIlIlllllIl;
    }

    private int get(int llllllllllllllllllllIIIllllIlIIl) {
        Frame llllllllllllllllllllIIIllllIllII;
        if (llllllllllllllllllllIIIllllIllII.outputLocals == null || llllllllllllllllllllIIIllllIlIIl >= llllllllllllllllllllIIIllllIllII.outputLocals.length) {
            return 0x2000000 | llllllllllllllllllllIIIllllIlIIl;
        }
        int llllllllllllllllllllIIIllllIllIl = llllllllllllllllllllIIIllllIllII.outputLocals[llllllllllllllllllllIIIllllIlIIl];
        if (llllllllllllllllllllIIIllllIllIl == 0) {
            llllllllllllllllllllIIIllllIllIl = llllllllllllllllllllIIIllllIllII.outputLocals[llllllllllllllllllllIIIllllIlIIl] = 0x2000000 | llllllllllllllllllllIIIllllIlIIl;
        }
        return llllllllllllllllllllIIIllllIllIl;
    }

    final boolean merge(ClassWriter llllllllllllllllllllIIIIIlllIIIl, Frame llllllllllllllllllllIIIIIllllIIl, int llllllllllllllllllllIIIIIllllIII) {
        int llllllllllllllllllllIIIIIlllIllI;
        Frame llllllllllllllllllllIIIIIlllIIlI;
        boolean llllllllllllllllllllIIIIIlllIlll = false;
        int llllllllllllllllllllIIIIIlllIlIl = llllllllllllllllllllIIIIIlllIIlI.inputLocals.length;
        int llllllllllllllllllllIIIIIlllIlII = llllllllllllllllllllIIIIIlllIIlI.inputStack.length;
        if (llllllllllllllllllllIIIIIllllIIl.inputLocals == null) {
            llllllllllllllllllllIIIIIllllIIl.inputLocals = new int[llllllllllllllllllllIIIIIlllIlIl];
            llllllllllllllllllllIIIIIlllIlll = true;
        }
        for (llllllllllllllllllllIIIIIlllIllI = 0; llllllllllllllllllllIIIIIlllIllI < llllllllllllllllllllIIIIIlllIlIl; ++llllllllllllllllllllIIIIIlllIllI) {
            int llllllllllllllllllllIIIIlIIIIlII;
            if (llllllllllllllllllllIIIIIlllIIlI.outputLocals != null && llllllllllllllllllllIIIIIlllIllI < llllllllllllllllllllIIIIIlllIIlI.outputLocals.length) {
                int llllllllllllllllllllIIIIlIIIlIII = llllllllllllllllllllIIIIIlllIIlI.outputLocals[llllllllllllllllllllIIIIIlllIllI];
                if (llllllllllllllllllllIIIIlIIIlIII == 0) {
                    int llllllllllllllllllllIIIIlIIIlIll = llllllllllllllllllllIIIIIlllIIlI.inputLocals[llllllllllllllllllllIIIIIlllIllI];
                } else {
                    int llllllllllllllllllllIIIIlIIIIlll = llllllllllllllllllllIIIIlIIIlIII & 0xF0000000;
                    int llllllllllllllllllllIIIIlIIIIllI = llllllllllllllllllllIIIIlIIIlIII & 0xF000000;
                    if (llllllllllllllllllllIIIIlIIIIllI == 0x1000000) {
                        int llllllllllllllllllllIIIIlIIIlIlI = llllllllllllllllllllIIIIlIIIlIII;
                    } else {
                        int llllllllllllllllllllIIIIlIIIIlIl;
                        if (llllllllllllllllllllIIIIlIIIIllI == 0x2000000) {
                            int llllllllllllllllllllIIIIlIIIlIIl = llllllllllllllllllllIIIIlIIIIlll + llllllllllllllllllllIIIIIlllIIlI.inputLocals[llllllllllllllllllllIIIIlIIIlIII & 0x7FFFFF];
                        } else {
                            llllllllllllllllllllIIIIlIIIIlIl = llllllllllllllllllllIIIIlIIIIlll + llllllllllllllllllllIIIIIlllIIlI.inputStack[llllllllllllllllllllIIIIIlllIlII - (llllllllllllllllllllIIIIlIIIlIII & 0x7FFFFF)];
                        }
                        if ((llllllllllllllllllllIIIIlIIIlIII & 0x800000) != 0 && (llllllllllllllllllllIIIIlIIIIlIl == 0x1000004 || llllllllllllllllllllIIIIlIIIIlIl == 0x1000003)) {
                            llllllllllllllllllllIIIIlIIIIlIl = 0x1000000;
                        }
                    }
                }
            } else {
                llllllllllllllllllllIIIIlIIIIlII = llllllllllllllllllllIIIIIlllIIlI.inputLocals[llllllllllllllllllllIIIIIlllIllI];
            }
            if (llllllllllllllllllllIIIIIlllIIlI.initializations != null) {
                llllllllllllllllllllIIIIlIIIIlII = llllllllllllllllllllIIIIIlllIIlI.init(llllllllllllllllllllIIIIIlllIIIl, llllllllllllllllllllIIIIlIIIIlII);
            }
            llllllllllllllllllllIIIIIlllIlll |= Frame.merge(llllllllllllllllllllIIIIIlllIIIl, llllllllllllllllllllIIIIlIIIIlII, llllllllllllllllllllIIIIIllllIIl.inputLocals, llllllllllllllllllllIIIIIlllIllI);
        }
        if (llllllllllllllllllllIIIIIllllIII > 0) {
            for (llllllllllllllllllllIIIIIlllIllI = 0; llllllllllllllllllllIIIIIlllIllI < llllllllllllllllllllIIIIIlllIlIl; ++llllllllllllllllllllIIIIIlllIllI) {
                int llllllllllllllllllllIIIIlIIIIIll = llllllllllllllllllllIIIIIlllIIlI.inputLocals[llllllllllllllllllllIIIIIlllIllI];
                llllllllllllllllllllIIIIIlllIlll |= Frame.merge(llllllllllllllllllllIIIIIlllIIIl, llllllllllllllllllllIIIIlIIIIIll, llllllllllllllllllllIIIIIllllIIl.inputLocals, llllllllllllllllllllIIIIIlllIllI);
            }
            if (llllllllllllllllllllIIIIIllllIIl.inputStack == null) {
                llllllllllllllllllllIIIIIllllIIl.inputStack = new int[1];
                llllllllllllllllllllIIIIIlllIlll = true;
            }
            return llllllllllllllllllllIIIIIlllIlll |= Frame.merge(llllllllllllllllllllIIIIIlllIIIl, llllllllllllllllllllIIIIIllllIII, llllllllllllllllllllIIIIIllllIIl.inputStack, 0);
        }
        int llllllllllllllllllllIIIIIlllIIll = llllllllllllllllllllIIIIIlllIIlI.inputStack.length + llllllllllllllllllllIIIIIlllIIlI.owner.inputStackTop;
        if (llllllllllllllllllllIIIIIllllIIl.inputStack == null) {
            llllllllllllllllllllIIIIIllllIIl.inputStack = new int[llllllllllllllllllllIIIIIlllIIll + llllllllllllllllllllIIIIIlllIIlI.outputStackTop];
            llllllllllllllllllllIIIIIlllIlll = true;
        }
        for (llllllllllllllllllllIIIIIlllIllI = 0; llllllllllllllllllllIIIIIlllIllI < llllllllllllllllllllIIIIIlllIIll; ++llllllllllllllllllllIIIIIlllIllI) {
            int llllllllllllllllllllIIIIlIIIIIlI = llllllllllllllllllllIIIIIlllIIlI.inputStack[llllllllllllllllllllIIIIIlllIllI];
            if (llllllllllllllllllllIIIIIlllIIlI.initializations != null) {
                llllllllllllllllllllIIIIlIIIIIlI = llllllllllllllllllllIIIIIlllIIlI.init(llllllllllllllllllllIIIIIlllIIIl, llllllllllllllllllllIIIIlIIIIIlI);
            }
            llllllllllllllllllllIIIIIlllIlll |= Frame.merge(llllllllllllllllllllIIIIIlllIIIl, llllllllllllllllllllIIIIlIIIIIlI, llllllllllllllllllllIIIIIllllIIl.inputStack, llllllllllllllllllllIIIIIlllIllI);
        }
        for (llllllllllllllllllllIIIIIlllIllI = 0; llllllllllllllllllllIIIIIlllIllI < llllllllllllllllllllIIIIIlllIIlI.outputStackTop; ++llllllllllllllllllllIIIIIlllIllI) {
            int llllllllllllllllllllIIIIIlllllII;
            int llllllllllllllllllllIIIIIlllllll = llllllllllllllllllllIIIIIlllIIlI.outputStack[llllllllllllllllllllIIIIIlllIllI];
            int llllllllllllllllllllIIIIIllllllI = llllllllllllllllllllIIIIIlllllll & 0xF0000000;
            int llllllllllllllllllllIIIIIlllllIl = llllllllllllllllllllIIIIIlllllll & 0xF000000;
            if (llllllllllllllllllllIIIIIlllllIl == 0x1000000) {
                int llllllllllllllllllllIIIIlIIIIIIl = llllllllllllllllllllIIIIIlllllll;
            } else {
                if (llllllllllllllllllllIIIIIlllllIl == 0x2000000) {
                    int llllllllllllllllllllIIIIlIIIIIII = llllllllllllllllllllIIIIIllllllI + llllllllllllllllllllIIIIIlllIIlI.inputLocals[llllllllllllllllllllIIIIIlllllll & 0x7FFFFF];
                } else {
                    llllllllllllllllllllIIIIIlllllII = llllllllllllllllllllIIIIIllllllI + llllllllllllllllllllIIIIIlllIIlI.inputStack[llllllllllllllllllllIIIIIlllIlII - (llllllllllllllllllllIIIIIlllllll & 0x7FFFFF)];
                }
                if ((llllllllllllllllllllIIIIIlllllll & 0x800000) != 0 && (llllllllllllllllllllIIIIIlllllII == 0x1000004 || llllllllllllllllllllIIIIIlllllII == 0x1000003)) {
                    llllllllllllllllllllIIIIIlllllII = 0x1000000;
                }
            }
            if (llllllllllllllllllllIIIIIlllIIlI.initializations != null) {
                llllllllllllllllllllIIIIIlllllII = llllllllllllllllllllIIIIIlllIIlI.init(llllllllllllllllllllIIIIIlllIIIl, llllllllllllllllllllIIIIIlllllII);
            }
            llllllllllllllllllllIIIIIlllIlll |= Frame.merge(llllllllllllllllllllIIIIIlllIIIl, llllllllllllllllllllIIIIIlllllII, llllllllllllllllllllIIIIIllllIIl.inputStack, llllllllllllllllllllIIIIIlllIIll + llllllllllllllllllllIIIIIlllIllI);
        }
        return llllllllllllllllllllIIIIIlllIlll;
    }

    static {
        ARRAY_OF = 0x10000000;
        NULL = 0x1000005;
        ELEMENT_OF = -268435456;
        BASE_VALUE = 1048575;
        BASE_KIND = 0xFF00000;
        CHAR = 0x100000B;
        KIND = 0xF000000;
        BASE = 0x1000000;
        TOP_IF_LONG_OR_DOUBLE = 0x800000;
        SHORT = 0x100000C;
        OBJECT = 0x1700000;
        STACK = 0x3000000;
        UNINITIALIZED = 0x1800000;
        DOUBLE = 0x1000003;
        FLOAT = 0x1000002;
        UNINITIALIZED_THIS = 0x1000006;
        BYTE = 0x100000A;
        DIM = -268435456;
        LOCAL = 0x2000000;
        BOOLEAN = 0x1000009;
        TOP = 0x1000000;
        LONG = 0x1000004;
        VALUE = 0x7FFFFF;
        INTEGER = 0x1000001;
        int[] llllllllllllllllllllIIIIIlIIIIll = new int[202];
        String llllllllllllllllllllIIIIIlIIIIlI = "EFFFFFFFFGGFFFGGFFFEEFGFGFEEEEEEEEEEEEEEEEEEEEDEDEDDDDDCDCDEEEEEEEEEEEEEEEEEEEEBABABBBBDCFFFGGGEDCDCDCDCDCDCDCDCDCDCEEEEDDDDDDDCDCDCEFEFDDEEFFDEDEEEBDDBBDDDDDDCCCCCCCCEFEDDDCDCDEEEEEEEEEEFEEEEEEDDEEDDEE";
        for (int llllllllllllllllllllIIIIIlIIIlII = 0; llllllllllllllllllllIIIIIlIIIlII < llllllllllllllllllllIIIIIlIIIIll.length; ++llllllllllllllllllllIIIIIlIIIlII) {
            llllllllllllllllllllIIIIIlIIIIll[llllllllllllllllllllIIIIIlIIIlII] = llllllllllllllllllllIIIIIlIIIIlI.charAt(llllllllllllllllllllIIIIIlIIIlII) - 69;
        }
        SIZE = llllllllllllllllllllIIIIIlIIIIll;
    }

    private void push(int llllllllllllllllllllIIIllIllllII) {
        int llllllllllllllllllllIIIllIlllIll;
        Frame llllllllllllllllllllIIIllIllllIl;
        if (llllllllllllllllllllIIIllIllllIl.outputStack == null) {
            llllllllllllllllllllIIIllIllllIl.outputStack = new int[10];
        }
        if (llllllllllllllllllllIIIllIllllIl.outputStackTop >= (llllllllllllllllllllIIIllIlllIll = llllllllllllllllllllIIIllIllllIl.outputStack.length)) {
            int[] llllllllllllllllllllIIIllIlllllI = new int[Math.max(llllllllllllllllllllIIIllIllllIl.outputStackTop + 1, 2 * llllllllllllllllllllIIIllIlllIll)];
            System.arraycopy(llllllllllllllllllllIIIllIllllIl.outputStack, 0, llllllllllllllllllllIIIllIlllllI, 0, llllllllllllllllllllIIIllIlllIll);
            llllllllllllllllllllIIIllIllllIl.outputStack = llllllllllllllllllllIIIllIlllllI;
        }
        llllllllllllllllllllIIIllIllllIl.outputStack[llllllllllllllllllllIIIllIllllIl.outputStackTop++] = llllllllllllllllllllIIIllIllllII;
        int llllllllllllllllllllIIIllIlllIlI = llllllllllllllllllllIIIllIllllIl.owner.inputStackTop + llllllllllllllllllllIIIllIllllIl.outputStackTop;
        if (llllllllllllllllllllIIIllIlllIlI > llllllllllllllllllllIIIllIllllIl.owner.outputStackMax) {
            llllllllllllllllllllIIIllIllllIl.owner.outputStackMax = llllllllllllllllllllIIIllIlllIlI;
        }
    }

    Frame() {
        Frame llllllllllllllllllllIIlIIIllllll;
    }

    private void pop(String llllllllllllllllllllIIIlIllIIIlI) {
        Frame llllllllllllllllllllIIIlIllIIIll;
        char llllllllllllllllllllIIIlIllIIlII = llllllllllllllllllllIIIlIllIIIlI.charAt(0);
        if (llllllllllllllllllllIIIlIllIIlII == '(') {
            llllllllllllllllllllIIIlIllIIIll.pop((Type.getArgumentsAndReturnSizes(llllllllllllllllllllIIIlIllIIIlI) >> 2) - 1);
        } else if (llllllllllllllllllllIIIlIllIIlII == 'J' || llllllllllllllllllllIIIlIllIIlII == 'D') {
            llllllllllllllllllllIIIlIllIIIll.pop(2);
        } else {
            llllllllllllllllllllIIIlIllIIIll.pop(1);
        }
    }

    final void set(Frame llllllllllllllllllllIIIlllllIIll) {
        llllllllllllllllllllIIIlllllIlII.inputLocals = llllllllllllllllllllIIIlllllIIll.inputLocals;
        llllllllllllllllllllIIIlllllIlII.inputStack = llllllllllllllllllllIIIlllllIIll.inputStack;
        llllllllllllllllllllIIIlllllIlII.outputLocals = llllllllllllllllllllIIIlllllIIll.outputLocals;
        llllllllllllllllllllIIIlllllIlII.outputStack = llllllllllllllllllllIIIlllllIIll.outputStack;
        llllllllllllllllllllIIIlllllIlII.outputStackTop = llllllllllllllllllllIIIlllllIIll.outputStackTop;
        llllllllllllllllllllIIIlllllIlII.initializationCount = llllllllllllllllllllIIIlllllIIll.initializationCount;
        llllllllllllllllllllIIIlllllIlII.initializations = llllllllllllllllllllIIIlllllIIll.initializations;
    }

    final void initInputFrame(ClassWriter llllllllllllllllllllIIIlIIIllIlI, int llllllllllllllllllllIIIlIIIllIIl, Type[] llllllllllllllllllllIIIlIIIllIII, int llllllllllllllllllllIIIlIIIlIIIl) {
        llllllllllllllllllllIIIlIIIlIlIl.inputLocals = new int[llllllllllllllllllllIIIlIIIlIIIl];
        llllllllllllllllllllIIIlIIIlIlIl.inputStack = new int[0];
        int llllllllllllllllllllIIIlIIIlIllI = 0;
        if ((llllllllllllllllllllIIIlIIIllIIl & 8) == 0) {
            llllllllllllllllllllIIIlIIIlIlIl.inputLocals[llllllllllllllllllllIIIlIIIlIllI++] = (llllllllllllllllllllIIIlIIIllIIl & 0x80000) == 0 ? 0x1700000 | llllllllllllllllllllIIIlIIIllIlI.addType(llllllllllllllllllllIIIlIIIllIlI.thisName) : 0x1000006;
        }
        for (int llllllllllllllllllllIIIlIIIlllII = 0; llllllllllllllllllllIIIlIIIlllII < llllllllllllllllllllIIIlIIIllIII.length; ++llllllllllllllllllllIIIlIIIlllII) {
            int llllllllllllllllllllIIIlIIIlllIl = Frame.type(llllllllllllllllllllIIIlIIIllIlI, llllllllllllllllllllIIIlIIIllIII[llllllllllllllllllllIIIlIIIlllII].getDescriptor());
            llllllllllllllllllllIIIlIIIlIlIl.inputLocals[llllllllllllllllllllIIIlIIIlIllI++] = llllllllllllllllllllIIIlIIIlllIl;
            if (llllllllllllllllllllIIIlIIIlllIl != 0x1000004 && llllllllllllllllllllIIIlIIIlllIl != 0x1000003) continue;
            llllllllllllllllllllIIIlIIIlIlIl.inputLocals[llllllllllllllllllllIIIlIIIlIllI++] = 0x1000000;
        }
        while (llllllllllllllllllllIIIlIIIlIllI < llllllllllllllllllllIIIlIIIlIIIl) {
            llllllllllllllllllllIIIlIIIlIlIl.inputLocals[llllllllllllllllllllIIIlIIIlIllI++] = 0x1000000;
        }
    }

    private void pop(int llllllllllllllllllllIIIlIllIlIlI) {
        Frame llllllllllllllllllllIIIlIllIllIl;
        if (llllllllllllllllllllIIIlIllIllIl.outputStackTop >= llllllllllllllllllllIIIlIllIlIlI) {
            llllllllllllllllllllIIIlIllIllIl.outputStackTop -= llllllllllllllllllllIIIlIllIlIlI;
        } else {
            llllllllllllllllllllIIIlIllIllIl.owner.inputStackTop -= llllllllllllllllllllIIIlIllIlIlI - llllllllllllllllllllIIIlIllIllIl.outputStackTop;
            llllllllllllllllllllIIIlIllIllIl.outputStackTop = 0;
        }
    }

    /*
     * WARNING - void declaration
     */
    private int init(ClassWriter llllllllllllllllllllIIIlIIllIllI, int llllllllllllllllllllIIIlIIllIlIl) {
        Frame llllllllllllllllllllIIIlIIlllIII;
        if (llllllllllllllllllllIIIlIIllIlIl == 0x1000006) {
            int llllllllllllllllllllIIIlIlIIlIIl = 0x1700000 | llllllllllllllllllllIIIlIIllIllI.addType(llllllllllllllllllllIIIlIIllIllI.thisName);
        } else if ((llllllllllllllllllllIIIlIIllIlIl & 0xFFF00000) == 0x1800000) {
            String llllllllllllllllllllIIIlIlIIlIII = llllllllllllllllllllIIIlIIllIllI.typeTable[llllllllllllllllllllIIIlIIllIlIl & 0xFFFFF].strVal1;
            int llllllllllllllllllllIIIlIlIIIllI = 0x1700000 | llllllllllllllllllllIIIlIIllIllI.addType(llllllllllllllllllllIIIlIlIIlIII);
        } else {
            return llllllllllllllllllllIIIlIIllIlIl;
        }
        for (int llllllllllllllllllllIIIlIIlllllI = 0; llllllllllllllllllllIIIlIIlllllI < llllllllllllllllllllIIIlIIlllIII.initializationCount; ++llllllllllllllllllllIIIlIIlllllI) {
            void llllllllllllllllllllIIIlIIlllIIl;
            int llllllllllllllllllllIIIlIlIIIlII = llllllllllllllllllllIIIlIIlllIII.initializations[llllllllllllllllllllIIIlIIlllllI];
            int llllllllllllllllllllIIIlIlIIIIlI = llllllllllllllllllllIIIlIlIIIlII & 0xF0000000;
            int llllllllllllllllllllIIIlIlIIIIII = llllllllllllllllllllIIIlIlIIIlII & 0xF000000;
            if (llllllllllllllllllllIIIlIlIIIIII == 0x2000000) {
                llllllllllllllllllllIIIlIlIIIlII = llllllllllllllllllllIIIlIlIIIIlI + llllllllllllllllllllIIIlIIlllIII.inputLocals[llllllllllllllllllllIIIlIlIIIlII & 0x7FFFFF];
            } else if (llllllllllllllllllllIIIlIlIIIIII == 0x3000000) {
                llllllllllllllllllllIIIlIlIIIlII = llllllllllllllllllllIIIlIlIIIIlI + llllllllllllllllllllIIIlIIlllIII.inputStack[llllllllllllllllllllIIIlIIlllIII.inputStack.length - (llllllllllllllllllllIIIlIlIIIlII & 0x7FFFFF)];
            }
            if (llllllllllllllllllllIIIlIIllIlIl != llllllllllllllllllllIIIlIlIIIlII) continue;
            return (int)llllllllllllllllllllIIIlIIlllIIl;
        }
        return llllllllllllllllllllIIIlIIllIlIl;
    }

    final void set(ClassWriter llllllllllllllllllllIIlIIIlIIIll, int llllllllllllllllllllIIlIIIlIIIlI, Object[] llllllllllllllllllllIIlIIIIlIlll, int llllllllllllllllllllIIlIIIlIIIII, Object[] llllllllllllllllllllIIlIIIIlllll) {
        Frame llllllllllllllllllllIIlIIIIllIll;
        int llllllllllllllllllllIIlIIIIllllI = Frame.convert(llllllllllllllllllllIIlIIIlIIIll, llllllllllllllllllllIIlIIIlIIIlI, llllllllllllllllllllIIlIIIIlIlll, llllllllllllllllllllIIlIIIIllIll.inputLocals);
        while (llllllllllllllllllllIIlIIIIllllI < llllllllllllllllllllIIlIIIIlIlll.length) {
            llllllllllllllllllllIIlIIIIllIll.inputLocals[llllllllllllllllllllIIlIIIIllllI++] = 0x1000000;
        }
        int llllllllllllllllllllIIlIIIIlllIl = 0;
        for (int llllllllllllllllllllIIlIIIlIIllI = 0; llllllllllllllllllllIIlIIIlIIllI < llllllllllllllllllllIIlIIIlIIIII; ++llllllllllllllllllllIIlIIIlIIllI) {
            if (llllllllllllllllllllIIlIIIIlllll[llllllllllllllllllllIIlIIIlIIllI] != Opcodes.LONG && llllllllllllllllllllIIlIIIIlllll[llllllllllllllllllllIIlIIIlIIllI] != Opcodes.DOUBLE) continue;
            ++llllllllllllllllllllIIlIIIIlllIl;
        }
        llllllllllllllllllllIIlIIIIllIll.inputStack = new int[llllllllllllllllllllIIlIIIlIIIII + llllllllllllllllllllIIlIIIIlllIl];
        Frame.convert(llllllllllllllllllllIIlIIIlIIIll, llllllllllllllllllllIIlIIIlIIIII, llllllllllllllllllllIIlIIIIlllll, llllllllllllllllllllIIlIIIIllIll.inputStack);
        llllllllllllllllllllIIlIIIIllIll.outputStackTop = 0;
        llllllllllllllllllllIIlIIIIllIll.initializationCount = 0;
    }

    private int pop() {
        Frame llllllllllllllllllllIIIlIlllIIIl;
        if (llllllllllllllllllllIIIlIlllIIIl.outputStackTop > 0) {
            return llllllllllllllllllllIIIlIlllIIIl.outputStack[--llllllllllllllllllllIIIlIlllIIIl.outputStackTop];
        }
        return 0x3000000 | -(--llllllllllllllllllllIIIlIlllIIIl.owner.inputStackTop);
    }

    private void set(int llllllllllllllllllllIIIlllIlIlll, int llllllllllllllllllllIIIlllIlIllI) {
        int llllllllllllllllllllIIIlllIlIlIl;
        Frame llllllllllllllllllllIIIlllIlIlII;
        if (llllllllllllllllllllIIIlllIlIlII.outputLocals == null) {
            llllllllllllllllllllIIIlllIlIlII.outputLocals = new int[10];
        }
        if (llllllllllllllllllllIIIlllIlIlll >= (llllllllllllllllllllIIIlllIlIlIl = llllllllllllllllllllIIIlllIlIlII.outputLocals.length)) {
            int[] llllllllllllllllllllIIIlllIllIIl = new int[Math.max(llllllllllllllllllllIIIlllIlIlll + 1, 2 * llllllllllllllllllllIIIlllIlIlIl)];
            System.arraycopy(llllllllllllllllllllIIIlllIlIlII.outputLocals, 0, llllllllllllllllllllIIIlllIllIIl, 0, llllllllllllllllllllIIIlllIlIlIl);
            llllllllllllllllllllIIIlllIlIlII.outputLocals = llllllllllllllllllllIIIlllIllIIl;
        }
        llllllllllllllllllllIIIlllIlIlII.outputLocals[llllllllllllllllllllIIIlllIlIlll] = llllllllllllllllllllIIIlllIlIllI;
    }

    private void push(ClassWriter llllllllllllllllllllIIIllIlIllII, String llllllllllllllllllllIIIllIlIlIlI) {
        int llllllllllllllllllllIIIllIlIIlll = Frame.type(llllllllllllllllllllIIIllIlIllII, llllllllllllllllllllIIIllIlIlIlI);
        if (llllllllllllllllllllIIIllIlIIlll != 0) {
            Frame llllllllllllllllllllIIIllIlIlllI;
            llllllllllllllllllllIIIllIlIlllI.push(llllllllllllllllllllIIIllIlIIlll);
            if (llllllllllllllllllllIIIllIlIIlll == 0x1000004 || llllllllllllllllllllIIIllIlIIlll == 0x1000003) {
                llllllllllllllllllllIIIllIlIlllI.push(0x1000000);
            }
        }
    }

    private static int convert(ClassWriter llllllllllllllllllllIIIlllllllII, int llllllllllllllllllllIIlIIIIIIIII, Object[] llllllllllllllllllllIIIllllllIlI, int[] llllllllllllllllllllIIIllllllllI) {
        int llllllllllllllllllllIIIlllllllIl = 0;
        for (int llllllllllllllllllllIIlIIIIIIIlI = 0; llllllllllllllllllllIIlIIIIIIIlI < llllllllllllllllllllIIlIIIIIIIII; ++llllllllllllllllllllIIlIIIIIIIlI) {
            if (llllllllllllllllllllIIIllllllIlI[llllllllllllllllllllIIlIIIIIIIlI] instanceof Integer) {
                llllllllllllllllllllIIIllllllllI[llllllllllllllllllllIIIlllllllIl++] = 0x1000000 | (Integer)llllllllllllllllllllIIIllllllIlI[llllllllllllllllllllIIlIIIIIIIlI];
                if (llllllllllllllllllllIIIllllllIlI[llllllllllllllllllllIIlIIIIIIIlI] != Opcodes.LONG && llllllllllllllllllllIIIllllllIlI[llllllllllllllllllllIIlIIIIIIIlI] != Opcodes.DOUBLE) continue;
                llllllllllllllllllllIIIllllllllI[llllllllllllllllllllIIIlllllllIl++] = 0x1000000;
                continue;
            }
            llllllllllllllllllllIIIllllllllI[llllllllllllllllllllIIIlllllllIl++] = llllllllllllllllllllIIIllllllIlI[llllllllllllllllllllIIlIIIIIIIlI] instanceof String ? Frame.type(llllllllllllllllllllIIIlllllllII, Type.getObjectType((String)llllllllllllllllllllIIIllllllIlI[llllllllllllllllllllIIlIIIIIIIlI]).getDescriptor()) : 0x1800000 | llllllllllllllllllllIIIlllllllII.addUninitializedType("", ((Label)llllllllllllllllllllIIIllllllIlI[llllllllllllllllllllIIlIIIIIIIlI]).position);
        }
        return llllllllllllllllllllIIIlllllllIl;
    }

    private static boolean merge(ClassWriter llllllllllllllllllllIIIIIlIlIlIl, int llllllllllllllllllllIIIIIlIIlllI, int[] llllllllllllllllllllIIIIIlIIllIl, int llllllllllllllllllllIIIIIlIIllII) {
        int llllllllllllllllllllIIIIIlIlIIII;
        int llllllllllllllllllllIIIIIlIlIIIl = llllllllllllllllllllIIIIIlIIllIl[llllllllllllllllllllIIIIIlIIllII];
        if (llllllllllllllllllllIIIIIlIlIIIl == llllllllllllllllllllIIIIIlIIlllI) {
            return false;
        }
        if ((llllllllllllllllllllIIIIIlIIlllI & 0xFFFFFFF) == 0x1000005) {
            if (llllllllllllllllllllIIIIIlIlIIIl == 0x1000005) {
                return false;
            }
            llllllllllllllllllllIIIIIlIIlllI = 0x1000005;
        }
        if (llllllllllllllllllllIIIIIlIlIIIl == 0) {
            llllllllllllllllllllIIIIIlIIllIl[llllllllllllllllllllIIIIIlIIllII] = llllllllllllllllllllIIIIIlIIlllI;
            return true;
        }
        if ((llllllllllllllllllllIIIIIlIlIIIl & 0xFF00000) == 0x1700000 || (llllllllllllllllllllIIIIIlIlIIIl & 0xF0000000) != 0) {
            if (llllllllllllllllllllIIIIIlIIlllI == 0x1000005) {
                return false;
            }
            if ((llllllllllllllllllllIIIIIlIIlllI & 0xFFF00000) == (llllllllllllllllllllIIIIIlIlIIIl & 0xFFF00000)) {
                if ((llllllllllllllllllllIIIIIlIlIIIl & 0xFF00000) == 0x1700000) {
                    int llllllllllllllllllllIIIIIlIlllIl = llllllllllllllllllllIIIIIlIIlllI & 0xF0000000 | 0x1700000 | llllllllllllllllllllIIIIIlIlIlIl.getMergedType(llllllllllllllllllllIIIIIlIIlllI & 0xFFFFF, llllllllllllllllllllIIIIIlIlIIIl & 0xFFFFF);
                } else {
                    int llllllllllllllllllllIIIIIlIlllII = -268435456 + (llllllllllllllllllllIIIIIlIlIIIl & 0xF0000000);
                    int llllllllllllllllllllIIIIIlIllIll = llllllllllllllllllllIIIIIlIlllII | 0x1700000 | llllllllllllllllllllIIIIIlIlIlIl.addType("java/lang/Object");
                }
            } else if ((llllllllllllllllllllIIIIIlIIlllI & 0xFF00000) == 0x1700000 || (llllllllllllllllllllIIIIIlIIlllI & 0xF0000000) != 0) {
                int llllllllllllllllllllIIIIIlIllIlI = ((llllllllllllllllllllIIIIIlIIlllI & 0xF0000000) == 0 || (llllllllllllllllllllIIIIIlIIlllI & 0xFF00000) == 0x1700000 ? 0 : -268435456) + (llllllllllllllllllllIIIIIlIIlllI & 0xF0000000);
                int llllllllllllllllllllIIIIIlIllIIl = ((llllllllllllllllllllIIIIIlIlIIIl & 0xF0000000) == 0 || (llllllllllllllllllllIIIIIlIlIIIl & 0xFF00000) == 0x1700000 ? 0 : -268435456) + (llllllllllllllllllllIIIIIlIlIIIl & 0xF0000000);
                int llllllllllllllllllllIIIIIlIllIII = Math.min(llllllllllllllllllllIIIIIlIllIlI, llllllllllllllllllllIIIIIlIllIIl) | 0x1700000 | llllllllllllllllllllIIIIIlIlIlIl.addType("java/lang/Object");
            } else {
                int llllllllllllllllllllIIIIIlIlIlll = 0x1000000;
            }
        } else if (llllllllllllllllllllIIIIIlIlIIIl == 0x1000005) {
            int llllllllllllllllllllIIIIIlIlIllI = (llllllllllllllllllllIIIIIlIIlllI & 0xFF00000) == 0x1700000 || (llllllllllllllllllllIIIIIlIIlllI & 0xF0000000) != 0 ? llllllllllllllllllllIIIIIlIIlllI : 0x1000000;
        } else {
            llllllllllllllllllllIIIIIlIlIIII = 0x1000000;
        }
        if (llllllllllllllllllllIIIIIlIlIIIl != llllllllllllllllllllIIIIIlIlIIII) {
            llllllllllllllllllllIIIIIlIIllIl[llllllllllllllllllllIIIIIlIIllII] = llllllllllllllllllllIIIIIlIlIIII;
            return true;
        }
        return false;
    }
}

