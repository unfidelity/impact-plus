/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.TypeReference;
import org.spongepowered.asm.lib.signature.SignatureReader;
import org.spongepowered.asm.lib.util.Printer;
import org.spongepowered.asm.lib.util.Textifiable;
import org.spongepowered.asm.lib.util.TraceClassVisitor;
import org.spongepowered.asm.lib.util.TraceSignatureVisitor;

public class Textifier
extends Printer {
    protected /* synthetic */ String tab2;
    protected /* synthetic */ Map<Label, String> labelNames;
    protected /* synthetic */ String tab;
    public static final /* synthetic */ int FIELD_SIGNATURE;
    protected /* synthetic */ String tab3;
    public static final /* synthetic */ int TYPE_DECLARATION;
    public static final /* synthetic */ int CLASS_SIGNATURE;
    public static final /* synthetic */ int INTERNAL_NAME;
    private /* synthetic */ int access;
    public static final /* synthetic */ int FIELD_DESCRIPTOR;
    public static final /* synthetic */ int HANDLE_DESCRIPTOR;
    public static final /* synthetic */ int METHOD_DESCRIPTOR;
    private /* synthetic */ int valueNumber;
    protected /* synthetic */ String ltab;
    public static final /* synthetic */ int PARAMETERS_DECLARATION;
    public static final /* synthetic */ int METHOD_SIGNATURE;
    public static final /* synthetic */ int CLASS_DECLARATION;

    protected Textifier createTextifier() {
        return new Textifier();
    }

    private void appendFrameTypes(int lllllllllllllllIllIIllIllIIIIIlI, Object[] lllllllllllllllIllIIllIllIIIIIIl) {
        for (int lllllllllllllllIllIIllIllIIIIlll = 0; lllllllllllllllIllIIllIllIIIIlll < lllllllllllllllIllIIllIllIIIIIlI; ++lllllllllllllllIllIIllIllIIIIlll) {
            Textifier lllllllllllllllIllIIllIllIIIIIll;
            if (lllllllllllllllIllIIllIllIIIIlll > 0) {
                lllllllllllllllIllIIllIllIIIIIll.buf.append(' ');
            }
            if (lllllllllllllllIllIIllIllIIIIIIl[lllllllllllllllIllIIllIllIIIIlll] instanceof String) {
                String lllllllllllllllIllIIllIllIIIlIII = (String)lllllllllllllllIllIIllIllIIIIIIl[lllllllllllllllIllIIllIllIIIIlll];
                if (lllllllllllllllIllIIllIllIIIlIII.startsWith("[")) {
                    lllllllllllllllIllIIllIllIIIIIll.appendDescriptor(1, lllllllllllllllIllIIllIllIIIlIII);
                    continue;
                }
                lllllllllllllllIllIIllIllIIIIIll.appendDescriptor(0, lllllllllllllllIllIIllIllIIIlIII);
                continue;
            }
            if (lllllllllllllllIllIIllIllIIIIIIl[lllllllllllllllIllIIllIllIIIIlll] instanceof Integer) {
                switch ((Integer)lllllllllllllllIllIIllIllIIIIIIl[lllllllllllllllIllIIllIllIIIIlll]) {
                    case 0: {
                        lllllllllllllllIllIIllIllIIIIIll.appendDescriptor(1, "T");
                        break;
                    }
                    case 1: {
                        lllllllllllllllIllIIllIllIIIIIll.appendDescriptor(1, "I");
                        break;
                    }
                    case 2: {
                        lllllllllllllllIllIIllIllIIIIIll.appendDescriptor(1, "F");
                        break;
                    }
                    case 3: {
                        lllllllllllllllIllIIllIllIIIIIll.appendDescriptor(1, "D");
                        break;
                    }
                    case 4: {
                        lllllllllllllllIllIIllIllIIIIIll.appendDescriptor(1, "J");
                        break;
                    }
                    case 5: {
                        lllllllllllllllIllIIllIllIIIIIll.appendDescriptor(1, "N");
                        break;
                    }
                    case 6: {
                        lllllllllllllllIllIIllIllIIIIIll.appendDescriptor(1, "U");
                    }
                }
                continue;
            }
            lllllllllllllllIllIIllIllIIIIIll.appendLabel((Label)lllllllllllllllIllIIllIllIIIIIIl[lllllllllllllllIllIIllIllIIIIlll]);
        }
    }

    public Printer visitInsnAnnotation(int lllllllllllllllIllIIlllIIlIlIllI, TypePath lllllllllllllllIllIIlllIIlIllIlI, String lllllllllllllllIllIIlllIIlIlIlII, boolean lllllllllllllllIllIIlllIIlIlIIll) {
        Textifier lllllllllllllllIllIIlllIIlIlllII;
        return lllllllllllllllIllIIlllIIlIlllII.visitTypeAnnotation(lllllllllllllllIllIIlllIIlIlIllI, lllllllllllllllIllIIlllIIlIllIlI, lllllllllllllllIllIIlllIIlIlIlII, lllllllllllllllIllIIlllIIlIlIIll);
    }

    public void visitFieldInsn(int lllllllllllllllIllIIlllIlllllIIl, String lllllllllllllllIllIIlllIlllllIII, String lllllllllllllllIllIIlllIllllIIlI, String lllllllllllllllIllIIlllIllllIllI) {
        Textifier lllllllllllllllIllIIlllIlllllIlI;
        lllllllllllllllIllIIlllIlllllIlI.buf.setLength(0);
        lllllllllllllllIllIIlllIlllllIlI.buf.append(lllllllllllllllIllIIlllIlllllIlI.tab2).append(OPCODES[lllllllllllllllIllIIlllIlllllIIl]).append(' ');
        lllllllllllllllIllIIlllIlllllIlI.appendDescriptor(0, lllllllllllllllIllIIlllIlllllIII);
        lllllllllllllllIllIIlllIlllllIlI.buf.append('.').append(lllllllllllllllIllIIlllIllllIIlI).append(" : ");
        lllllllllllllllIllIIlllIlllllIlI.appendDescriptor(1, lllllllllllllllIllIIlllIllllIllI);
        lllllllllllllllIllIIlllIlllllIlI.buf.append('\n');
        lllllllllllllllIllIIlllIlllllIlI.text.add(lllllllllllllllIllIIlllIlllllIlI.buf.toString());
    }

    public void visitInvokeDynamicInsn(String lllllllllllllllIllIIlllIlIllIIll, String lllllllllllllllIllIIlllIlIllIIlI, Handle lllllllllllllllIllIIlllIlIlIllII, Object ... lllllllllllllllIllIIlllIlIllIIII) {
        Textifier lllllllllllllllIllIIlllIlIllIlII;
        lllllllllllllllIllIIlllIlIllIlII.buf.setLength(0);
        lllllllllllllllIllIIlllIlIllIlII.buf.append(lllllllllllllllIllIIlllIlIllIlII.tab2).append("INVOKEDYNAMIC").append(' ');
        lllllllllllllllIllIIlllIlIllIlII.buf.append(lllllllllllllllIllIIlllIlIllIIll);
        lllllllllllllllIllIIlllIlIllIlII.appendDescriptor(3, lllllllllllllllIllIIlllIlIllIIlI);
        lllllllllllllllIllIIlllIlIllIlII.buf.append(" [");
        lllllllllllllllIllIIlllIlIllIlII.buf.append('\n');
        lllllllllllllllIllIIlllIlIllIlII.buf.append(lllllllllllllllIllIIlllIlIllIlII.tab3);
        lllllllllllllllIllIIlllIlIllIlII.appendHandle(lllllllllllllllIllIIlllIlIlIllII);
        lllllllllllllllIllIIlllIlIllIlII.buf.append('\n');
        lllllllllllllllIllIIlllIlIllIlII.buf.append(lllllllllllllllIllIIlllIlIllIlII.tab3).append("// arguments:");
        if (lllllllllllllllIllIIlllIlIllIIII.length == 0) {
            lllllllllllllllIllIIlllIlIllIlII.buf.append(" none");
        } else {
            lllllllllllllllIllIIlllIlIllIlII.buf.append('\n');
            for (int lllllllllllllllIllIIlllIlIllIlIl = 0; lllllllllllllllIllIIlllIlIllIlIl < lllllllllllllllIllIIlllIlIllIIII.length; ++lllllllllllllllIllIIlllIlIllIlIl) {
                lllllllllllllllIllIIlllIlIllIlII.buf.append(lllllllllllllllIllIIlllIlIllIlII.tab3);
                Object lllllllllllllllIllIIlllIlIllIllI = lllllllllllllllIllIIlllIlIllIIII[lllllllllllllllIllIIlllIlIllIlIl];
                if (lllllllllllllllIllIIlllIlIllIllI instanceof String) {
                    Printer.appendString(lllllllllllllllIllIIlllIlIllIlII.buf, (String)lllllllllllllllIllIIlllIlIllIllI);
                } else if (lllllllllllllllIllIIlllIlIllIllI instanceof Type) {
                    Type lllllllllllllllIllIIlllIlIllIlll = (Type)lllllllllllllllIllIIlllIlIllIllI;
                    if (lllllllllllllllIllIIlllIlIllIlll.getSort() == 11) {
                        lllllllllllllllIllIIlllIlIllIlII.appendDescriptor(3, lllllllllllllllIllIIlllIlIllIlll.getDescriptor());
                    } else {
                        lllllllllllllllIllIIlllIlIllIlII.buf.append(lllllllllllllllIllIIlllIlIllIlll.getDescriptor()).append(".class");
                    }
                } else if (lllllllllllllllIllIIlllIlIllIllI instanceof Handle) {
                    lllllllllllllllIllIIlllIlIllIlII.appendHandle((Handle)lllllllllllllllIllIIlllIlIllIllI);
                } else {
                    lllllllllllllllIllIIlllIlIllIlII.buf.append(lllllllllllllllIllIIlllIlIllIllI);
                }
                lllllllllllllllIllIIlllIlIllIlII.buf.append(", \n");
            }
            lllllllllllllllIllIIlllIlIllIlII.buf.setLength(lllllllllllllllIllIIlllIlIllIlII.buf.length() - 3);
        }
        lllllllllllllllIllIIlllIlIllIlII.buf.append('\n');
        lllllllllllllllIllIIlllIlIllIlII.buf.append(lllllllllllllllIllIIlllIlIllIlII.tab2).append("]\n");
        lllllllllllllllIllIIlllIlIllIlII.text.add(lllllllllllllllIllIIlllIlIllIlII.buf.toString());
    }

    public void visitJumpInsn(int lllllllllllllllIllIIlllIlIlIIIII, Label lllllllllllllllIllIIlllIlIlIIIlI) {
        Textifier lllllllllllllllIllIIlllIlIlIIIIl;
        lllllllllllllllIllIIlllIlIlIIIIl.buf.setLength(0);
        lllllllllllllllIllIIlllIlIlIIIIl.buf.append(lllllllllllllllIllIIlllIlIlIIIIl.tab2).append(OPCODES[lllllllllllllllIllIIlllIlIlIIIII]).append(' ');
        lllllllllllllllIllIIlllIlIlIIIIl.appendLabel(lllllllllllllllIllIIlllIlIlIIIlI);
        lllllllllllllllIllIIlllIlIlIIIIl.buf.append('\n');
        lllllllllllllllIllIIlllIlIlIIIIl.text.add(lllllllllllllllIllIIlllIlIlIIIIl.buf.toString());
    }

    public Textifier visitAnnotationDefault() {
        Textifier lllllllllllllllIllIIllllIllIIIlI;
        lllllllllllllllIllIIllllIllIIIlI.text.add(String.valueOf(new StringBuilder().append(lllllllllllllllIllIIllllIllIIIlI.tab2).append("default=")));
        Textifier lllllllllllllllIllIIllllIllIIIll = lllllllllllllllIllIIllllIllIIIlI.createTextifier();
        lllllllllllllllIllIIllllIllIIIlI.text.add(lllllllllllllllIllIIllllIllIIIll.getText());
        lllllllllllllllIllIIllllIllIIIlI.text.add("\n");
        return lllllllllllllllIllIIllllIllIIIll;
    }

    public void visitOuterClass(String lllllllllllllllIllIlIIIIIlllllII, String lllllllllllllllIllIlIIIIIlllIlll, String lllllllllllllllIllIlIIIIIllllIlI) {
        Textifier lllllllllllllllIllIlIIIIIlllllIl;
        lllllllllllllllIllIlIIIIIlllllIl.buf.setLength(0);
        lllllllllllllllIllIlIIIIIlllllIl.buf.append(lllllllllllllllIllIlIIIIIlllllIl.tab).append("OUTERCLASS ");
        lllllllllllllllIllIlIIIIIlllllIl.appendDescriptor(0, lllllllllllllllIllIlIIIIIlllllII);
        lllllllllllllllIllIlIIIIIlllllIl.buf.append(' ');
        if (lllllllllllllllIllIlIIIIIlllIlll != null) {
            lllllllllllllllIllIlIIIIIlllllIl.buf.append(lllllllllllllllIllIlIIIIIlllIlll).append(' ');
        }
        lllllllllllllllIllIlIIIIIlllllIl.appendDescriptor(3, lllllllllllllllIllIlIIIIIllllIlI);
        lllllllllllllllIllIlIIIIIlllllIl.buf.append('\n');
        lllllllllllllllIllIlIIIIIlllllIl.text.add(lllllllllllllllIllIlIIIIIlllllIl.buf.toString());
    }

    public void visitFieldEnd() {
    }

    protected void appendLabel(Label lllllllllllllllIllIIllIllIllIIll) {
        String lllllllllllllllIllIIllIllIllIIlI;
        Textifier lllllllllllllllIllIIllIllIllIlII;
        if (lllllllllllllllIllIIllIllIllIlII.labelNames == null) {
            lllllllllllllllIllIIllIllIllIlII.labelNames = new HashMap<Label, String>();
        }
        if ((lllllllllllllllIllIIllIllIllIIlI = lllllllllllllllIllIIllIllIllIlII.labelNames.get(lllllllllllllllIllIIllIllIllIIll)) == null) {
            lllllllllllllllIllIIllIllIllIIlI = String.valueOf(new StringBuilder().append("L").append(lllllllllllllllIllIIllIllIllIlII.labelNames.size()));
            lllllllllllllllIllIIllIllIllIlII.labelNames.put(lllllllllllllllIllIIllIllIllIIll, lllllllllllllllIllIIllIllIllIIlI);
        }
        lllllllllllllllIllIIllIllIllIlII.buf.append(lllllllllllllllIllIIllIllIllIIlI);
    }

    public Textifier visitAnnotation(String lllllllllllllllIllIIlllllIIllIll, String lllllllllllllllIllIIlllllIIllllI) {
        Textifier lllllllllllllllIllIIlllllIlIIIII;
        lllllllllllllllIllIIlllllIlIIIII.buf.setLength(0);
        lllllllllllllllIllIIlllllIlIIIII.appendComa(lllllllllllllllIllIIlllllIlIIIII.valueNumber++);
        if (lllllllllllllllIllIIlllllIIllIll != null) {
            lllllllllllllllIllIIlllllIlIIIII.buf.append(lllllllllllllllIllIIlllllIIllIll).append('=');
        }
        lllllllllllllllIllIIlllllIlIIIII.buf.append('@');
        lllllllllllllllIllIIlllllIlIIIII.appendDescriptor(1, lllllllllllllllIllIIlllllIIllllI);
        lllllllllllllllIllIIlllllIlIIIII.buf.append('(');
        lllllllllllllllIllIIlllllIlIIIII.text.add(lllllllllllllllIllIIlllllIlIIIII.buf.toString());
        Textifier lllllllllllllllIllIIlllllIIlllIl = lllllllllllllllIllIIlllllIlIIIII.createTextifier();
        lllllllllllllllIllIIlllllIlIIIII.text.add(lllllllllllllllIllIIlllllIIlllIl.getText());
        lllllllllllllllIllIIlllllIlIIIII.text.add(")");
        return lllllllllllllllIllIIlllllIIlllIl;
    }

    public Printer visitFieldTypeAnnotation(int lllllllllllllllIllIIllllIllllIlI, TypePath lllllllllllllllIllIIllllIllllIIl, String lllllllllllllllIllIIllllIlllllIl, boolean lllllllllllllllIllIIllllIlllIlll) {
        Textifier lllllllllllllllIllIIllllIllllIll;
        return lllllllllllllllIllIIllllIllllIll.visitTypeAnnotation(lllllllllllllllIllIIllllIllllIlI, lllllllllllllllIllIIllllIllllIIl, lllllllllllllllIllIIllllIlllllIl, lllllllllllllllIllIIllllIlllIlll);
    }

    protected void appendHandle(Handle lllllllllllllllIllIIllIllIlIlIIl) {
        Textifier lllllllllllllllIllIIllIllIlIIllI;
        int lllllllllllllllIllIIllIllIlIlIII = lllllllllllllllIllIIllIllIlIlIIl.getTag();
        lllllllllllllllIllIIllIllIlIIllI.buf.append("// handle kind 0x").append(Integer.toHexString(lllllllllllllllIllIIllIllIlIlIII)).append(" : ");
        boolean lllllllllllllllIllIIllIllIlIIlll = false;
        switch (lllllllllllllllIllIIllIllIlIlIII) {
            case 1: {
                lllllllllllllllIllIIllIllIlIIllI.buf.append("GETFIELD");
                break;
            }
            case 2: {
                lllllllllllllllIllIIllIllIlIIllI.buf.append("GETSTATIC");
                break;
            }
            case 3: {
                lllllllllllllllIllIIllIllIlIIllI.buf.append("PUTFIELD");
                break;
            }
            case 4: {
                lllllllllllllllIllIIllIllIlIIllI.buf.append("PUTSTATIC");
                break;
            }
            case 9: {
                lllllllllllllllIllIIllIllIlIIllI.buf.append("INVOKEINTERFACE");
                lllllllllllllllIllIIllIllIlIIlll = true;
                break;
            }
            case 7: {
                lllllllllllllllIllIIllIllIlIIllI.buf.append("INVOKESPECIAL");
                lllllllllllllllIllIIllIllIlIIlll = true;
                break;
            }
            case 6: {
                lllllllllllllllIllIIllIllIlIIllI.buf.append("INVOKESTATIC");
                lllllllllllllllIllIIllIllIlIIlll = true;
                break;
            }
            case 5: {
                lllllllllllllllIllIIllIllIlIIllI.buf.append("INVOKEVIRTUAL");
                lllllllllllllllIllIIllIllIlIIlll = true;
                break;
            }
            case 8: {
                lllllllllllllllIllIIllIllIlIIllI.buf.append("NEWINVOKESPECIAL");
                lllllllllllllllIllIIllIllIlIIlll = true;
            }
        }
        lllllllllllllllIllIIllIllIlIIllI.buf.append('\n');
        lllllllllllllllIllIIllIllIlIIllI.buf.append(lllllllllllllllIllIIllIllIlIIllI.tab3);
        lllllllllllllllIllIIllIllIlIIllI.appendDescriptor(0, lllllllllllllllIllIIllIllIlIlIIl.getOwner());
        lllllllllllllllIllIIllIllIlIIllI.buf.append('.');
        lllllllllllllllIllIIllIllIlIIllI.buf.append(lllllllllllllllIllIIllIllIlIlIIl.getName());
        if (!lllllllllllllllIllIIllIllIlIIlll) {
            lllllllllllllllIllIIllIllIlIIllI.buf.append('(');
        }
        lllllllllllllllIllIIllIllIlIIllI.appendDescriptor(9, lllllllllllllllIllIIllIllIlIlIIl.getDesc());
        if (!lllllllllllllllIllIIllIllIlIIlll) {
            lllllllllllllllIllIIllIllIlIIllI.buf.append(')');
        }
    }

    public void visitTryCatchBlock(Label lllllllllllllllIllIIlllIIlIIllII, Label lllllllllllllllIllIIlllIIlIIlIll, Label lllllllllllllllIllIIlllIIlIIIlIl, String lllllllllllllllIllIIlllIIlIIlIIl) {
        Textifier lllllllllllllllIllIIlllIIlIIllIl;
        lllllllllllllllIllIIlllIIlIIllIl.buf.setLength(0);
        lllllllllllllllIllIIlllIIlIIllIl.buf.append(lllllllllllllllIllIIlllIIlIIllIl.tab2).append("TRYCATCHBLOCK ");
        lllllllllllllllIllIIlllIIlIIllIl.appendLabel(lllllllllllllllIllIIlllIIlIIllII);
        lllllllllllllllIllIIlllIIlIIllIl.buf.append(' ');
        lllllllllllllllIllIIlllIIlIIllIl.appendLabel(lllllllllllllllIllIIlllIIlIIlIll);
        lllllllllllllllIllIIlllIIlIIllIl.buf.append(' ');
        lllllllllllllllIllIIlllIIlIIllIl.appendLabel(lllllllllllllllIllIIlllIIlIIIlIl);
        lllllllllllllllIllIIlllIIlIIllIl.buf.append(' ');
        lllllllllllllllIllIIlllIIlIIllIl.appendDescriptor(0, lllllllllllllllIllIIlllIIlIIlIIl);
        lllllllllllllllIllIIlllIIlIIllIl.buf.append('\n');
        lllllllllllllllIllIIlllIIlIIllIl.text.add(lllllllllllllllIllIIlllIIlIIllIl.buf.toString());
    }

    public void visitLineNumber(int lllllllllllllllIllIIllIlllllIIIl, Label lllllllllllllllIllIIllIlllllIIll) {
        Textifier lllllllllllllllIllIIllIlllllIlIl;
        lllllllllllllllIllIIllIlllllIlIl.buf.setLength(0);
        lllllllllllllllIllIIllIlllllIlIl.buf.append(lllllllllllllllIllIIllIlllllIlIl.tab2).append("LINENUMBER ").append(lllllllllllllllIllIIllIlllllIIIl).append(' ');
        lllllllllllllllIllIIllIlllllIlIl.appendLabel(lllllllllllllllIllIIllIlllllIIll);
        lllllllllllllllIllIIllIlllllIlIl.buf.append('\n');
        lllllllllllllllIllIIllIlllllIlIl.text.add(lllllllllllllllIllIIllIlllllIlIl.buf.toString());
    }

    public void visitIincInsn(int lllllllllllllllIllIIlllIlIIIlIll, int lllllllllllllllIllIIlllIlIIIllIl) {
        Textifier lllllllllllllllIllIIlllIlIIIllll;
        lllllllllllllllIllIIlllIlIIIllll.buf.setLength(0);
        lllllllllllllllIllIIlllIlIIIllll.buf.append(lllllllllllllllIllIIlllIlIIIllll.tab2).append("IINC ").append(lllllllllllllllIllIIlllIlIIIlIll).append(' ').append(lllllllllllllllIllIIlllIlIIIllIl).append('\n');
        lllllllllllllllIllIIlllIlIIIllll.text.add(lllllllllllllllIllIIlllIlIIIllll.buf.toString());
    }

    private void visitLong(long lllllllllllllllIllIIlllllllIIIIl) {
        Textifier lllllllllllllllIllIIlllllllIIlII;
        lllllllllllllllIllIIlllllllIIlII.buf.append(lllllllllllllllIllIIlllllllIIIIl).append('L');
    }

    public void visitEnum(String lllllllllllllllIllIIlllllIlIIlll, String lllllllllllllllIllIIlllllIlIlIlI, String lllllllllllllllIllIIlllllIlIIlIl) {
        Textifier lllllllllllllllIllIIlllllIlIllII;
        lllllllllllllllIllIIlllllIlIllII.buf.setLength(0);
        lllllllllllllllIllIIlllllIlIllII.appendComa(lllllllllllllllIllIIlllllIlIllII.valueNumber++);
        if (lllllllllllllllIllIIlllllIlIIlll != null) {
            lllllllllllllllIllIIlllllIlIllII.buf.append(lllllllllllllllIllIIlllllIlIIlll).append('=');
        }
        lllllllllllllllIllIIlllllIlIllII.appendDescriptor(1, lllllllllllllllIllIIlllllIlIlIlI);
        lllllllllllllllIllIIlllllIlIllII.buf.append('.').append(lllllllllllllllIllIIlllllIlIIlIl);
        lllllllllllllllIllIIlllllIlIllII.text.add(lllllllllllllllIllIIlllllIlIllII.buf.toString());
    }

    private void appendAccess(int lllllllllllllllIllIIllIllIIlllll) {
        Textifier lllllllllllllllIllIIllIllIlIIIII;
        if ((lllllllllllllllIllIIllIllIIlllll & 1) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("public ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 2) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("private ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 4) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("protected ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 0x10) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("final ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 8) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("static ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 0x20) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("synchronized ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 0x40) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("volatile ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 0x80) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("transient ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 0x400) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("abstract ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 0x800) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("strictfp ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 0x1000) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("synthetic ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 0x8000) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("mandated ");
        }
        if ((lllllllllllllllIllIIllIllIIlllll & 0x4000) != 0) {
            lllllllllllllllIllIIllIllIlIIIII.buf.append("enum ");
        }
    }

    public void visitTypeInsn(int lllllllllllllllIllIIllllIIIIIIIl, String lllllllllllllllIllIIllllIIIIIIII) {
        Textifier lllllllllllllllIllIIllllIIIIIlIl;
        lllllllllllllllIllIIllllIIIIIlIl.buf.setLength(0);
        lllllllllllllllIllIIllllIIIIIlIl.buf.append(lllllllllllllllIllIIllllIIIIIlIl.tab2).append(OPCODES[lllllllllllllllIllIIllllIIIIIIIl]).append(' ');
        lllllllllllllllIllIIllllIIIIIlIl.appendDescriptor(0, lllllllllllllllIllIIllllIIIIIIII);
        lllllllllllllllIllIIllllIIIIIlIl.buf.append('\n');
        lllllllllllllllIllIIllllIIIIIlIl.text.add(lllllllllllllllIllIIllllIIIIIlIl.buf.toString());
    }

    public void visitInsn(int lllllllllllllllIllIIllllIIIllIll) {
        Textifier lllllllllllllllIllIIllllIIIlllII;
        lllllllllllllllIllIIllllIIIlllII.buf.setLength(0);
        lllllllllllllllIllIIllllIIIlllII.buf.append(lllllllllllllllIllIIllllIIIlllII.tab2).append(OPCODES[lllllllllllllllIllIIllllIIIllIll]).append('\n');
        lllllllllllllllIllIIllllIIIlllII.text.add(lllllllllllllllIllIIllllIIIlllII.buf.toString());
    }

    public void visitCode() {
    }

    public void visitTableSwitchInsn(int lllllllllllllllIllIIlllIlIIIIIlI, int lllllllllllllllIllIIlllIlIIIIIIl, Label lllllllllllllllIllIIlllIlIIIIIII, Label ... lllllllllllllllIllIIlllIIlllllll) {
        Textifier lllllllllllllllIllIIlllIIllllllI;
        lllllllllllllllIllIIlllIIllllllI.buf.setLength(0);
        lllllllllllllllIllIIlllIIllllllI.buf.append(lllllllllllllllIllIIlllIIllllllI.tab2).append("TABLESWITCH\n");
        for (int lllllllllllllllIllIIlllIlIIIIlII = 0; lllllllllllllllIllIIlllIlIIIIlII < lllllllllllllllIllIIlllIIlllllll.length; ++lllllllllllllllIllIIlllIlIIIIlII) {
            lllllllllllllllIllIIlllIIllllllI.buf.append(lllllllllllllllIllIIlllIIllllllI.tab3).append(lllllllllllllllIllIIlllIlIIIIIlI + lllllllllllllllIllIIlllIlIIIIlII).append(": ");
            lllllllllllllllIllIIlllIIllllllI.appendLabel(lllllllllllllllIllIIlllIIlllllll[lllllllllllllllIllIIlllIlIIIIlII]);
            lllllllllllllllIllIIlllIIllllllI.buf.append('\n');
        }
        lllllllllllllllIllIIlllIIllllllI.buf.append(lllllllllllllllIllIIlllIIllllllI.tab3).append("default: ");
        lllllllllllllllIllIIlllIIllllllI.appendLabel(lllllllllllllllIllIIlllIlIIIIIII);
        lllllllllllllllIllIIlllIIllllllI.buf.append('\n');
        lllllllllllllllIllIIlllIIllllllI.text.add(lllllllllllllllIllIIlllIIllllllI.buf.toString());
    }

    public void visitLocalVariable(String lllllllllllllllIllIIlllIIIlIIlIl, String lllllllllllllllIllIIlllIIIlIIlII, String lllllllllllllllIllIIlllIIIlIIIll, Label lllllllllllllllIllIIlllIIIIllIll, Label lllllllllllllllIllIIlllIIIIllIlI, int lllllllllllllllIllIIlllIIIIllIIl) {
        Textifier lllllllllllllllIllIIlllIIIIlllll;
        lllllllllllllllIllIIlllIIIIlllll.buf.setLength(0);
        lllllllllllllllIllIIlllIIIIlllll.buf.append(lllllllllllllllIllIIlllIIIIlllll.tab2).append("LOCALVARIABLE ").append(lllllllllllllllIllIIlllIIIlIIlIl).append(' ');
        lllllllllllllllIllIIlllIIIIlllll.appendDescriptor(1, lllllllllllllllIllIIlllIIIlIIlII);
        lllllllllllllllIllIIlllIIIIlllll.buf.append(' ');
        lllllllllllllllIllIIlllIIIIlllll.appendLabel(lllllllllllllllIllIIlllIIIIllIll);
        lllllllllllllllIllIIlllIIIIlllll.buf.append(' ');
        lllllllllllllllIllIIlllIIIIlllll.appendLabel(lllllllllllllllIllIIlllIIIIllIlI);
        lllllllllllllllIllIIlllIIIIlllll.buf.append(' ').append(lllllllllllllllIllIIlllIIIIllIIl).append('\n');
        if (lllllllllllllllIllIIlllIIIlIIIll != null) {
            lllllllllllllllIllIIlllIIIIlllll.buf.append(lllllllllllllllIllIIlllIIIIlllll.tab2);
            lllllllllllllllIllIIlllIIIIlllll.appendDescriptor(2, lllllllllllllllIllIIlllIIIlIIIll);
            TraceSignatureVisitor lllllllllllllllIllIIlllIIIlIlIII = new TraceSignatureVisitor(0);
            SignatureReader lllllllllllllllIllIIlllIIIlIIlll = new SignatureReader(lllllllllllllllIllIIlllIIIlIIIll);
            lllllllllllllllIllIIlllIIIlIIlll.acceptType(lllllllllllllllIllIIlllIIIlIlIII);
            lllllllllllllllIllIIlllIIIIlllll.buf.append(lllllllllllllllIllIIlllIIIIlllll.tab2).append("// declaration: ").append(lllllllllllllllIllIIlllIIIlIlIII.getDeclaration()).append('\n');
        }
        lllllllllllllllIllIIlllIIIIlllll.text.add(lllllllllllllllIllIIlllIIIIlllll.buf.toString());
    }

    private void visitType(Type lllllllllllllllIllIIlllllIllIIll) {
        Textifier lllllllllllllllIllIIlllllIllIIlI;
        lllllllllllllllIllIIlllllIllIIlI.buf.append(lllllllllllllllIllIIlllllIllIIll.getClassName()).append(".class");
    }

    public void visitSource(String lllllllllllllllIllIlIIIIlIIIIIll, String lllllllllllllllIllIlIIIIlIIIIIlI) {
        Textifier lllllllllllllllIllIlIIIIlIIIIlII;
        lllllllllllllllIllIlIIIIlIIIIlII.buf.setLength(0);
        if (lllllllllllllllIllIlIIIIlIIIIIll != null) {
            lllllllllllllllIllIlIIIIlIIIIlII.buf.append(lllllllllllllllIllIlIIIIlIIIIlII.tab).append("// compiled from: ").append(lllllllllllllllIllIlIIIIlIIIIIll).append('\n');
        }
        if (lllllllllllllllIllIlIIIIlIIIIIlI != null) {
            lllllllllllllllIllIlIIIIlIIIIlII.buf.append(lllllllllllllllIllIlIIIIlIIIIlII.tab).append("// debug info: ").append(lllllllllllllllIllIlIIIIlIIIIIlI).append('\n');
        }
        if (lllllllllllllllIllIlIIIIlIIIIlII.buf.length() > 0) {
            lllllllllllllllIllIlIIIIlIIIIlII.text.add(lllllllllllllllIllIlIIIIlIIIIlII.buf.toString());
        }
    }

    public static void main(String[] lllllllllllllllIllIlIIIIlIllIIIl) throws Exception {
        ClassReader lllllllllllllllIllIlIIIIlIllIIlI;
        int lllllllllllllllIllIlIIIIlIllIlIl = 0;
        int lllllllllllllllIllIlIIIIlIllIlII = 2;
        boolean lllllllllllllllIllIlIIIIlIllIIll = true;
        if (lllllllllllllllIllIlIIIIlIllIIIl.length < 1 || lllllllllllllllIllIlIIIIlIllIIIl.length > 2) {
            lllllllllllllllIllIlIIIIlIllIIll = false;
        }
        if (lllllllllllllllIllIlIIIIlIllIIll && "-debug".equals(lllllllllllllllIllIlIIIIlIllIIIl[0])) {
            lllllllllllllllIllIlIIIIlIllIlIl = 1;
            lllllllllllllllIllIlIIIIlIllIlII = 0;
            if (lllllllllllllllIllIlIIIIlIllIIIl.length != 2) {
                lllllllllllllllIllIlIIIIlIllIIll = false;
            }
        }
        if (!lllllllllllllllIllIlIIIIlIllIIll) {
            System.err.println("Prints a disassembled view of the given class.");
            System.err.println("Usage: Textifier [-debug] <fully qualified class name or class file name>");
            return;
        }
        if (lllllllllllllllIllIlIIIIlIllIIIl[lllllllllllllllIllIlIIIIlIllIlIl].endsWith(".class") || lllllllllllllllIllIlIIIIlIllIIIl[lllllllllllllllIllIlIIIIlIllIlIl].indexOf(92) > -1 || lllllllllllllllIllIlIIIIlIllIIIl[lllllllllllllllIllIlIIIIlIllIlIl].indexOf(47) > -1) {
            ClassReader lllllllllllllllIllIlIIIIlIllIlll = new ClassReader(new FileInputStream(lllllllllllllllIllIlIIIIlIllIIIl[lllllllllllllllIllIlIIIIlIllIlIl]));
        } else {
            lllllllllllllllIllIlIIIIlIllIIlI = new ClassReader(lllllllllllllllIllIlIIIIlIllIIIl[lllllllllllllllIllIlIIIIlIllIlIl]);
        }
        lllllllllllllllIllIlIIIIlIllIIlI.accept(new TraceClassVisitor(new PrintWriter(System.out)), lllllllllllllllIllIlIIIIlIllIlII);
    }

    public void visit(String lllllllllllllllIllIIllllllllIIII, Object lllllllllllllllIllIIlllllllIllll) {
        Textifier lllllllllllllllIllIIllllllllIlII;
        lllllllllllllllIllIIllllllllIlII.buf.setLength(0);
        lllllllllllllllIllIIllllllllIlII.appendComa(lllllllllllllllIllIIllllllllIlII.valueNumber++);
        if (lllllllllllllllIllIIllllllllIIII != null) {
            lllllllllllllllIllIIllllllllIlII.buf.append(lllllllllllllllIllIIllllllllIIII).append('=');
        }
        if (lllllllllllllllIllIIlllllllIllll instanceof String) {
            lllllllllllllllIllIIllllllllIlII.visitString((String)lllllllllllllllIllIIlllllllIllll);
        } else if (lllllllllllllllIllIIlllllllIllll instanceof Type) {
            lllllllllllllllIllIIllllllllIlII.visitType((Type)lllllllllllllllIllIIlllllllIllll);
        } else if (lllllllllllllllIllIIlllllllIllll instanceof Byte) {
            lllllllllllllllIllIIllllllllIlII.visitByte((Byte)lllllllllllllllIllIIlllllllIllll);
        } else if (lllllllllllllllIllIIlllllllIllll instanceof Boolean) {
            lllllllllllllllIllIIllllllllIlII.visitBoolean((Boolean)lllllllllllllllIllIIlllllllIllll);
        } else if (lllllllllllllllIllIIlllllllIllll instanceof Short) {
            lllllllllllllllIllIIllllllllIlII.visitShort((Short)lllllllllllllllIllIIlllllllIllll);
        } else if (lllllllllllllllIllIIlllllllIllll instanceof Character) {
            lllllllllllllllIllIIllllllllIlII.visitChar(((Character)lllllllllllllllIllIIlllllllIllll).charValue());
        } else if (lllllllllllllllIllIIlllllllIllll instanceof Integer) {
            lllllllllllllllIllIIllllllllIlII.visitInt((Integer)lllllllllllllllIllIIlllllllIllll);
        } else if (lllllllllllllllIllIIlllllllIllll instanceof Float) {
            lllllllllllllllIllIIllllllllIlII.visitFloat(((Float)lllllllllllllllIllIIlllllllIllll).floatValue());
        } else if (lllllllllllllllIllIIlllllllIllll instanceof Long) {
            lllllllllllllllIllIIllllllllIlII.visitLong((Long)lllllllllllllllIllIIlllllllIllll);
        } else if (lllllllllllllllIllIIlllllllIllll instanceof Double) {
            lllllllllllllllIllIIllllllllIlII.visitDouble((Double)lllllllllllllllIllIIlllllllIllll);
        } else if (lllllllllllllllIllIIlllllllIllll.getClass().isArray()) {
            lllllllllllllllIllIIllllllllIlII.buf.append('{');
            if (lllllllllllllllIllIIlllllllIllll instanceof byte[]) {
                byte[] lllllllllllllllIllIlIIIIIIIIIIll = (byte[])lllllllllllllllIllIIlllllllIllll;
                for (int lllllllllllllllIllIlIIIIIIIIIlII = 0; lllllllllllllllIllIlIIIIIIIIIlII < lllllllllllllllIllIlIIIIIIIIIIll.length; ++lllllllllllllllIllIlIIIIIIIIIlII) {
                    lllllllllllllllIllIIllllllllIlII.appendComa(lllllllllllllllIllIlIIIIIIIIIlII);
                    lllllllllllllllIllIIllllllllIlII.visitByte(lllllllllllllllIllIlIIIIIIIIIIll[lllllllllllllllIllIlIIIIIIIIIlII]);
                }
            } else if (lllllllllllllllIllIIlllllllIllll instanceof boolean[]) {
                boolean[] lllllllllllllllIllIlIIIIIIIIIIIl = (boolean[])lllllllllllllllIllIIlllllllIllll;
                for (int lllllllllllllllIllIlIIIIIIIIIIlI = 0; lllllllllllllllIllIlIIIIIIIIIIlI < lllllllllllllllIllIlIIIIIIIIIIIl.length; ++lllllllllllllllIllIlIIIIIIIIIIlI) {
                    lllllllllllllllIllIIllllllllIlII.appendComa(lllllllllllllllIllIlIIIIIIIIIIlI);
                    lllllllllllllllIllIIllllllllIlII.visitBoolean(lllllllllllllllIllIlIIIIIIIIIIIl[lllllllllllllllIllIlIIIIIIIIIIlI]);
                }
            } else if (lllllllllllllllIllIIlllllllIllll instanceof short[]) {
                short[] lllllllllllllllIllIIllllllllllll = (short[])lllllllllllllllIllIIlllllllIllll;
                for (int lllllllllllllllIllIlIIIIIIIIIIII = 0; lllllllllllllllIllIlIIIIIIIIIIII < lllllllllllllllIllIIllllllllllll.length; ++lllllllllllllllIllIlIIIIIIIIIIII) {
                    lllllllllllllllIllIIllllllllIlII.appendComa(lllllllllllllllIllIlIIIIIIIIIIII);
                    lllllllllllllllIllIIllllllllIlII.visitShort(lllllllllllllllIllIIllllllllllll[lllllllllllllllIllIlIIIIIIIIIIII]);
                }
            } else if (lllllllllllllllIllIIlllllllIllll instanceof char[]) {
                char[] lllllllllllllllIllIIllllllllllIl = (char[])lllllllllllllllIllIIlllllllIllll;
                for (int lllllllllllllllIllIIlllllllllllI = 0; lllllllllllllllIllIIlllllllllllI < lllllllllllllllIllIIllllllllllIl.length; ++lllllllllllllllIllIIlllllllllllI) {
                    lllllllllllllllIllIIllllllllIlII.appendComa(lllllllllllllllIllIIlllllllllllI);
                    lllllllllllllllIllIIllllllllIlII.visitChar(lllllllllllllllIllIIllllllllllIl[lllllllllllllllIllIIlllllllllllI]);
                }
            } else if (lllllllllllllllIllIIlllllllIllll instanceof int[]) {
                int[] lllllllllllllllIllIIlllllllllIll = (int[])lllllllllllllllIllIIlllllllIllll;
                for (int lllllllllllllllIllIIllllllllllII = 0; lllllllllllllllIllIIllllllllllII < lllllllllllllllIllIIlllllllllIll.length; ++lllllllllllllllIllIIllllllllllII) {
                    lllllllllllllllIllIIllllllllIlII.appendComa(lllllllllllllllIllIIllllllllllII);
                    lllllllllllllllIllIIllllllllIlII.visitInt(lllllllllllllllIllIIlllllllllIll[lllllllllllllllIllIIllllllllllII]);
                }
            } else if (lllllllllllllllIllIIlllllllIllll instanceof long[]) {
                long[] lllllllllllllllIllIIlllllllllIIl = (long[])lllllllllllllllIllIIlllllllIllll;
                for (int lllllllllllllllIllIIlllllllllIlI = 0; lllllllllllllllIllIIlllllllllIlI < lllllllllllllllIllIIlllllllllIIl.length; ++lllllllllllllllIllIIlllllllllIlI) {
                    lllllllllllllllIllIIllllllllIlII.appendComa(lllllllllllllllIllIIlllllllllIlI);
                    lllllllllllllllIllIIllllllllIlII.visitLong(lllllllllllllllIllIIlllllllllIIl[lllllllllllllllIllIIlllllllllIlI]);
                }
            } else if (lllllllllllllllIllIIlllllllIllll instanceof float[]) {
                float[] lllllllllllllllIllIIllllllllIlll = (float[])lllllllllllllllIllIIlllllllIllll;
                for (int lllllllllllllllIllIIlllllllllIII = 0; lllllllllllllllIllIIlllllllllIII < lllllllllllllllIllIIllllllllIlll.length; ++lllllllllllllllIllIIlllllllllIII) {
                    lllllllllllllllIllIIllllllllIlII.appendComa(lllllllllllllllIllIIlllllllllIII);
                    lllllllllllllllIllIIllllllllIlII.visitFloat(lllllllllllllllIllIIllllllllIlll[lllllllllllllllIllIIlllllllllIII]);
                }
            } else if (lllllllllllllllIllIIlllllllIllll instanceof double[]) {
                double[] lllllllllllllllIllIIllllllllIlIl = (double[])lllllllllllllllIllIIlllllllIllll;
                for (int lllllllllllllllIllIIllllllllIllI = 0; lllllllllllllllIllIIllllllllIllI < lllllllllllllllIllIIllllllllIlIl.length; ++lllllllllllllllIllIIllllllllIllI) {
                    lllllllllllllllIllIIllllllllIlII.appendComa(lllllllllllllllIllIIllllllllIllI);
                    lllllllllllllllIllIIllllllllIlII.visitDouble(lllllllllllllllIllIIllllllllIlIl[lllllllllllllllIllIIllllllllIllI]);
                }
            }
            lllllllllllllllIllIIllllllllIlII.buf.append('}');
        }
        lllllllllllllllIllIIllllllllIlII.text.add(lllllllllllllllIllIIllllllllIlII.buf.toString());
    }

    public void visitMaxs(int lllllllllllllllIllIIllIllllIlIII, int lllllllllllllllIllIIllIllllIlIlI) {
        Textifier lllllllllllllllIllIIllIllllIllII;
        lllllllllllllllIllIIllIllllIllII.buf.setLength(0);
        lllllllllllllllIllIIllIllllIllII.buf.append(lllllllllllllllIllIIllIllllIllII.tab2).append("MAXSTACK = ").append(lllllllllllllllIllIIllIllllIlIII).append('\n');
        lllllllllllllllIllIIllIllllIllII.text.add(lllllllllllllllIllIIllIllllIllII.buf.toString());
        lllllllllllllllIllIIllIllllIllII.buf.setLength(0);
        lllllllllllllllIllIIllIllllIllII.buf.append(lllllllllllllllIllIIllIllllIllII.tab2).append("MAXLOCALS = ").append(lllllllllllllllIllIIllIllllIlIlI).append('\n');
        lllllllllllllllIllIIllIllllIllII.text.add(lllllllllllllllIllIIllIllllIllII.buf.toString());
    }

    public Textifier visitMethod(int lllllllllllllllIllIlIIIIIIIlllIl, String lllllllllllllllIllIlIIIIIIIlllII, String lllllllllllllllIllIlIIIIIIIllIll, String lllllllllllllllIllIlIIIIIIIllIlI, String[] lllllllllllllllIllIlIIIIIIIllIIl) {
        Textifier lllllllllllllllIllIlIIIIIIIlIlll;
        lllllllllllllllIllIlIIIIIIIlIlll.buf.setLength(0);
        lllllllllllllllIllIlIIIIIIIlIlll.buf.append('\n');
        if ((lllllllllllllllIllIlIIIIIIIlllIl & 0x20000) != 0) {
            lllllllllllllllIllIlIIIIIIIlIlll.buf.append(lllllllllllllllIllIlIIIIIIIlIlll.tab).append("// DEPRECATED\n");
        }
        lllllllllllllllIllIlIIIIIIIlIlll.buf.append(lllllllllllllllIllIlIIIIIIIlIlll.tab).append("// access flags 0x").append(Integer.toHexString(lllllllllllllllIllIlIIIIIIIlllIl).toUpperCase()).append('\n');
        if (lllllllllllllllIllIlIIIIIIIllIlI != null) {
            lllllllllllllllIllIlIIIIIIIlIlll.buf.append(lllllllllllllllIllIlIIIIIIIlIlll.tab);
            lllllllllllllllIllIlIIIIIIIlIlll.appendDescriptor(4, lllllllllllllllIllIlIIIIIIIllIlI);
            TraceSignatureVisitor lllllllllllllllIllIlIIIIIIlIIlII = new TraceSignatureVisitor(0);
            SignatureReader lllllllllllllllIllIlIIIIIIlIIIll = new SignatureReader(lllllllllllllllIllIlIIIIIIIllIlI);
            lllllllllllllllIllIlIIIIIIlIIIll.accept(lllllllllllllllIllIlIIIIIIlIIlII);
            String lllllllllllllllIllIlIIIIIIlIIIlI = lllllllllllllllIllIlIIIIIIlIIlII.getDeclaration();
            String lllllllllllllllIllIlIIIIIIlIIIIl = lllllllllllllllIllIlIIIIIIlIIlII.getReturnType();
            String lllllllllllllllIllIlIIIIIIlIIIII = lllllllllllllllIllIlIIIIIIlIIlII.getExceptions();
            lllllllllllllllIllIlIIIIIIIlIlll.buf.append(lllllllllllllllIllIlIIIIIIIlIlll.tab).append("// declaration: ").append(lllllllllllllllIllIlIIIIIIlIIIIl).append(' ').append(lllllllllllllllIllIlIIIIIIIlllII).append(lllllllllllllllIllIlIIIIIIlIIIlI);
            if (lllllllllllllllIllIlIIIIIIlIIIII != null) {
                lllllllllllllllIllIlIIIIIIIlIlll.buf.append(" throws ").append(lllllllllllllllIllIlIIIIIIlIIIII);
            }
            lllllllllllllllIllIlIIIIIIIlIlll.buf.append('\n');
        }
        lllllllllllllllIllIlIIIIIIIlIlll.buf.append(lllllllllllllllIllIlIIIIIIIlIlll.tab);
        lllllllllllllllIllIlIIIIIIIlIlll.appendAccess(lllllllllllllllIllIlIIIIIIIlllIl & 0xFFFFFFBF);
        if ((lllllllllllllllIllIlIIIIIIIlllIl & 0x100) != 0) {
            lllllllllllllllIllIlIIIIIIIlIlll.buf.append("native ");
        }
        if ((lllllllllllllllIllIlIIIIIIIlllIl & 0x80) != 0) {
            lllllllllllllllIllIlIIIIIIIlIlll.buf.append("varargs ");
        }
        if ((lllllllllllllllIllIlIIIIIIIlllIl & 0x40) != 0) {
            lllllllllllllllIllIlIIIIIIIlIlll.buf.append("bridge ");
        }
        if ((lllllllllllllllIllIlIIIIIIIlIlll.access & 0x200) != 0 && (lllllllllllllllIllIlIIIIIIIlllIl & 0x400) == 0 && (lllllllllllllllIllIlIIIIIIIlllIl & 8) == 0) {
            lllllllllllllllIllIlIIIIIIIlIlll.buf.append("default ");
        }
        lllllllllllllllIllIlIIIIIIIlIlll.buf.append(lllllllllllllllIllIlIIIIIIIlllII);
        lllllllllllllllIllIlIIIIIIIlIlll.appendDescriptor(3, lllllllllllllllIllIlIIIIIIIllIll);
        if (lllllllllllllllIllIlIIIIIIIllIIl != null && lllllllllllllllIllIlIIIIIIIllIIl.length > 0) {
            lllllllllllllllIllIlIIIIIIIlIlll.buf.append(" throws ");
            for (int lllllllllllllllIllIlIIIIIIIlllll = 0; lllllllllllllllIllIlIIIIIIIlllll < lllllllllllllllIllIlIIIIIIIllIIl.length; ++lllllllllllllllIllIlIIIIIIIlllll) {
                lllllllllllllllIllIlIIIIIIIlIlll.appendDescriptor(0, lllllllllllllllIllIlIIIIIIIllIIl[lllllllllllllllIllIlIIIIIIIlllll]);
                lllllllllllllllIllIlIIIIIIIlIlll.buf.append(' ');
            }
        }
        lllllllllllllllIllIlIIIIIIIlIlll.buf.append('\n');
        lllllllllllllllIllIlIIIIIIIlIlll.text.add(lllllllllllllllIllIlIIIIIIIlIlll.buf.toString());
        Textifier lllllllllllllllIllIlIIIIIIIllIII = lllllllllllllllIllIlIIIIIIIlIlll.createTextifier();
        lllllllllllllllIllIlIIIIIIIlIlll.text.add(lllllllllllllllIllIlIIIIIIIllIII.getText());
        return lllllllllllllllIllIlIIIIIIIllIII;
    }

    public void visitClassAttribute(Attribute lllllllllllllllIllIlIIIIIlIllIII) {
        Textifier lllllllllllllllIllIlIIIIIlIllIIl;
        lllllllllllllllIllIlIIIIIlIllIIl.text.add("\n");
        lllllllllllllllIllIlIIIIIlIllIIl.visitAttribute(lllllllllllllllIllIlIIIIIlIllIII);
    }

    private void visitFloat(float lllllllllllllllIllIIllllllIllIll) {
        Textifier lllllllllllllllIllIIllllllIlllII;
        lllllllllllllllIllIIllllllIlllII.buf.append(lllllllllllllllIllIIllllllIllIll).append('F');
    }

    public Textifier visitParameterAnnotation(int lllllllllllllllIllIIllllIIllllIl, String lllllllllllllllIllIIllllIIllllII, boolean lllllllllllllllIllIIllllIIlllIll) {
        Textifier lllllllllllllllIllIIllllIlIIIIll;
        lllllllllllllllIllIIllllIlIIIIll.buf.setLength(0);
        lllllllllllllllIllIIllllIlIIIIll.buf.append(lllllllllllllllIllIIllllIlIIIIll.tab2).append('@');
        lllllllllllllllIllIIllllIlIIIIll.appendDescriptor(1, lllllllllllllllIllIIllllIIllllII);
        lllllllllllllllIllIIllllIlIIIIll.buf.append('(');
        lllllllllllllllIllIIllllIlIIIIll.text.add(lllllllllllllllIllIIllllIlIIIIll.buf.toString());
        Textifier lllllllllllllllIllIIllllIIllllll = lllllllllllllllIllIIllllIlIIIIll.createTextifier();
        lllllllllllllllIllIIllllIlIIIIll.text.add(lllllllllllllllIllIIllllIIllllll.getText());
        lllllllllllllllIllIIllllIlIIIIll.text.add(lllllllllllllllIllIIllllIIlllIll ? ") // parameter " : ") // invisible, parameter ");
        lllllllllllllllIllIIllllIlIIIIll.text.add(lllllllllllllllIllIIllllIIllllIl);
        lllllllllllllllIllIIllllIlIIIIll.text.add("\n");
        return lllllllllllllllIllIIllllIIllllll;
    }

    public Printer visitTryCatchAnnotation(int lllllllllllllllIllIIlllIIIllIllI, TypePath lllllllllllllllIllIIlllIIIlllIll, String lllllllllllllllIllIIlllIIIllIlII, boolean lllllllllllllllIllIIlllIIIlllIIl) {
        Textifier lllllllllllllllIllIIlllIIIllllIl;
        lllllllllllllllIllIIlllIIIllllIl.buf.setLength(0);
        lllllllllllllllIllIIlllIIIllllIl.buf.append(lllllllllllllllIllIIlllIIIllllIl.tab2).append("TRYCATCHBLOCK @");
        lllllllllllllllIllIIlllIIIllllIl.appendDescriptor(1, lllllllllllllllIllIIlllIIIllIlII);
        lllllllllllllllIllIIlllIIIllllIl.buf.append('(');
        lllllllllllllllIllIIlllIIIllllIl.text.add(lllllllllllllllIllIIlllIIIllllIl.buf.toString());
        Textifier lllllllllllllllIllIIlllIIIlllIII = lllllllllllllllIllIIlllIIIllllIl.createTextifier();
        lllllllllllllllIllIIlllIIIllllIl.text.add(lllllllllllllllIllIIlllIIIlllIII.getText());
        lllllllllllllllIllIIlllIIIllllIl.buf.setLength(0);
        lllllllllllllllIllIIlllIIIllllIl.buf.append(") : ");
        lllllllllllllllIllIIlllIIIllllIl.appendTypeReference(lllllllllllllllIllIIlllIIIllIllI);
        lllllllllllllllIllIIlllIIIllllIl.buf.append(", ").append(lllllllllllllllIllIIlllIIIlllIll);
        lllllllllllllllIllIIlllIIIllllIl.buf.append(lllllllllllllllIllIIlllIIIlllIIl ? "\n" : " // invisible\n");
        lllllllllllllllIllIIlllIIIllllIl.text.add(lllllllllllllllIllIIlllIIIllllIl.buf.toString());
        return lllllllllllllllIllIIlllIIIlllIII;
    }

    public void visitAttribute(Attribute lllllllllllllllIllIIllIlllIIIlII) {
        Textifier lllllllllllllllIllIIllIlllIIIlIl;
        lllllllllllllllIllIIllIlllIIIlIl.buf.setLength(0);
        lllllllllllllllIllIIllIlllIIIlIl.buf.append(lllllllllllllllIllIIllIlllIIIlIl.tab).append("ATTRIBUTE ");
        lllllllllllllllIllIIllIlllIIIlIl.appendDescriptor(-1, lllllllllllllllIllIIllIlllIIIlII.type);
        if (lllllllllllllllIllIIllIlllIIIlII instanceof Textifiable) {
            ((Textifiable)((Object)lllllllllllllllIllIIllIlllIIIlII)).textify(lllllllllllllllIllIIllIlllIIIlIl.buf, null);
        } else {
            lllllllllllllllIllIIllIlllIIIlIl.buf.append(" : unknown\n");
        }
        lllllllllllllllIllIIllIlllIIIlIl.text.add(lllllllllllllllIllIIllIlllIIIlIl.buf.toString());
    }

    public Textifier() {
        lllllllllllllllIllIlIIIIllIIIlII(327680);
        Textifier lllllllllllllllIllIlIIIIllIIIlII;
        if (lllllllllllllllIllIlIIIIllIIIlII.getClass() != Textifier.class) {
            throw new IllegalStateException();
        }
    }

    public void visitFieldAttribute(Attribute lllllllllllllllIllIIllllIlllIIll) {
        Textifier lllllllllllllllIllIIllllIlllIIlI;
        lllllllllllllllIllIIllllIlllIIlI.visitAttribute(lllllllllllllllIllIIllllIlllIIll);
    }

    private void visitBoolean(boolean lllllllllllllllIllIIlllllIllllll) {
        Textifier lllllllllllllllIllIIlllllIlllllI;
        lllllllllllllllIllIIlllllIlllllI.buf.append(lllllllllllllllIllIIlllllIllllll);
    }

    static {
        INTERNAL_NAME = 0;
        FIELD_SIGNATURE = 2;
        CLASS_SIGNATURE = 5;
        PARAMETERS_DECLARATION = 8;
        HANDLE_DESCRIPTOR = 9;
        TYPE_DECLARATION = 6;
        METHOD_DESCRIPTOR = 3;
        METHOD_SIGNATURE = 4;
        FIELD_DESCRIPTOR = 1;
        CLASS_DECLARATION = 7;
    }

    public void visitVarInsn(int lllllllllllllllIllIIllllIIIIllIl, int lllllllllllllllIllIIllllIIIIlIIl) {
        Textifier lllllllllllllllIllIIllllIIIIlllI;
        lllllllllllllllIllIIllllIIIIlllI.buf.setLength(0);
        lllllllllllllllIllIIllllIIIIlllI.buf.append(lllllllllllllllIllIIllllIIIIlllI.tab2).append(OPCODES[lllllllllllllllIllIIllllIIIIllIl]).append(' ').append(lllllllllllllllIllIIllllIIIIlIIl).append('\n');
        lllllllllllllllIllIIllllIIIIlllI.text.add(lllllllllllllllIllIIllllIIIIlllI.buf.toString());
    }

    protected Textifier(int lllllllllllllllIllIlIIIIlIllllll) {
        super(lllllllllllllllIllIlIIIIlIllllll);
        Textifier lllllllllllllllIllIlIIIIllIIIIII;
        lllllllllllllllIllIlIIIIllIIIIII.tab = "  ";
        lllllllllllllllIllIlIIIIllIIIIII.tab2 = "    ";
        lllllllllllllllIllIlIIIIllIIIIII.tab3 = "      ";
        lllllllllllllllIllIlIIIIllIIIIII.ltab = "   ";
        lllllllllllllllIllIlIIIIllIIIIII.valueNumber = 0;
    }

    public void visitLdcInsn(Object lllllllllllllllIllIIlllIlIIlIlIl) {
        Textifier lllllllllllllllIllIIlllIlIIlIlII;
        lllllllllllllllIllIIlllIlIIlIlII.buf.setLength(0);
        lllllllllllllllIllIIlllIlIIlIlII.buf.append(lllllllllllllllIllIIlllIlIIlIlII.tab2).append("LDC ");
        if (lllllllllllllllIllIIlllIlIIlIlIl instanceof String) {
            Printer.appendString(lllllllllllllllIllIIlllIlIIlIlII.buf, (String)lllllllllllllllIllIIlllIlIIlIlIl);
        } else if (lllllllllllllllIllIIlllIlIIlIlIl instanceof Type) {
            lllllllllllllllIllIIlllIlIIlIlII.buf.append(((Type)lllllllllllllllIllIIlllIlIIlIlIl).getDescriptor()).append(".class");
        } else {
            lllllllllllllllIllIIlllIlIIlIlII.buf.append(lllllllllllllllIllIIlllIlIIlIlIl);
        }
        lllllllllllllllIllIIlllIlIIlIlII.buf.append('\n');
        lllllllllllllllIllIIlllIlIIlIlII.text.add(lllllllllllllllIllIIlllIlIIlIlII.buf.toString());
    }

    public Textifier visitMethodAnnotation(String lllllllllllllllIllIIllllIlIllIIl, boolean lllllllllllllllIllIIllllIlIllIII) {
        Textifier lllllllllllllllIllIIllllIlIlllIl;
        return lllllllllllllllIllIIllllIlIlllIl.visitAnnotation(lllllllllllllllIllIIllllIlIllIIl, lllllllllllllllIllIIllllIlIllIII);
    }

    public void visitFrame(int lllllllllllllllIllIIllllIIlIIlIl, int lllllllllllllllIllIIllllIIlIIlII, Object[] lllllllllllllllIllIIllllIIlIlIIl, int lllllllllllllllIllIIllllIIlIlIII, Object[] lllllllllllllllIllIIllllIIlIIIIl) {
        Textifier lllllllllllllllIllIIllllIIlIllII;
        lllllllllllllllIllIIllllIIlIllII.buf.setLength(0);
        lllllllllllllllIllIIllllIIlIllII.buf.append(lllllllllllllllIllIIllllIIlIllII.ltab);
        lllllllllllllllIllIIllllIIlIllII.buf.append("FRAME ");
        switch (lllllllllllllllIllIIllllIIlIIlIl) {
            case -1: 
            case 0: {
                lllllllllllllllIllIIllllIIlIllII.buf.append("FULL [");
                lllllllllllllllIllIIllllIIlIllII.appendFrameTypes(lllllllllllllllIllIIllllIIlIIlII, lllllllllllllllIllIIllllIIlIlIIl);
                lllllllllllllllIllIIllllIIlIllII.buf.append("] [");
                lllllllllllllllIllIIllllIIlIllII.appendFrameTypes(lllllllllllllllIllIIllllIIlIlIII, lllllllllllllllIllIIllllIIlIIIIl);
                lllllllllllllllIllIIllllIIlIllII.buf.append(']');
                break;
            }
            case 1: {
                lllllllllllllllIllIIllllIIlIllII.buf.append("APPEND [");
                lllllllllllllllIllIIllllIIlIllII.appendFrameTypes(lllllllllllllllIllIIllllIIlIIlII, lllllllllllllllIllIIllllIIlIlIIl);
                lllllllllllllllIllIIllllIIlIllII.buf.append(']');
                break;
            }
            case 2: {
                lllllllllllllllIllIIllllIIlIllII.buf.append("CHOP ").append(lllllllllllllllIllIIllllIIlIIlII);
                break;
            }
            case 3: {
                lllllllllllllllIllIIllllIIlIllII.buf.append("SAME");
                break;
            }
            case 4: {
                lllllllllllllllIllIIllllIIlIllII.buf.append("SAME1 ");
                lllllllllllllllIllIIllllIIlIllII.appendFrameTypes(1, lllllllllllllllIllIIllllIIlIIIIl);
            }
        }
        lllllllllllllllIllIIllllIIlIllII.buf.append('\n');
        lllllllllllllllIllIIllllIIlIllII.text.add(lllllllllllllllIllIIllllIIlIllII.buf.toString());
    }

    public void visitInnerClass(String lllllllllllllllIllIlIIIIIlIlIIIl, String lllllllllllllllIllIlIIIIIlIlIIII, String lllllllllllllllIllIlIIIIIlIIllll, int lllllllllllllllIllIlIIIIIlIIlllI) {
        Textifier lllllllllllllllIllIlIIIIIlIlIIlI;
        lllllllllllllllIllIlIIIIIlIlIIlI.buf.setLength(0);
        lllllllllllllllIllIlIIIIIlIlIIlI.buf.append(lllllllllllllllIllIlIIIIIlIlIIlI.tab).append("// access flags 0x");
        lllllllllllllllIllIlIIIIIlIlIIlI.buf.append(Integer.toHexString(lllllllllllllllIllIlIIIIIlIIlllI & 0xFFFFFFDF).toUpperCase()).append('\n');
        lllllllllllllllIllIlIIIIIlIlIIlI.buf.append(lllllllllllllllIllIlIIIIIlIlIIlI.tab);
        lllllllllllllllIllIlIIIIIlIlIIlI.appendAccess(lllllllllllllllIllIlIIIIIlIIlllI);
        lllllllllllllllIllIlIIIIIlIlIIlI.buf.append("INNERCLASS ");
        lllllllllllllllIllIlIIIIIlIlIIlI.appendDescriptor(0, lllllllllllllllIllIlIIIIIlIlIIIl);
        lllllllllllllllIllIlIIIIIlIlIIlI.buf.append(' ');
        lllllllllllllllIllIlIIIIIlIlIIlI.appendDescriptor(0, lllllllllllllllIllIlIIIIIlIlIIII);
        lllllllllllllllIllIlIIIIIlIlIIlI.buf.append(' ');
        lllllllllllllllIllIlIIIIIlIlIIlI.appendDescriptor(0, lllllllllllllllIllIlIIIIIlIIllll);
        lllllllllllllllIllIlIIIIIlIlIIlI.buf.append('\n');
        lllllllllllllllIllIlIIIIIlIlIIlI.text.add(lllllllllllllllIllIlIIIIIlIlIIlI.buf.toString());
    }

    private void appendTypeReference(int lllllllllllllllIllIIllIllIIlIIlI) {
        TypeReference lllllllllllllllIllIIllIllIIlIIIl = new TypeReference(lllllllllllllllIllIIllIllIIlIIlI);
        switch (lllllllllllllllIllIIllIllIIlIIIl.getSort()) {
            case 0: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("CLASS_TYPE_PARAMETER ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeParameterIndex());
                break;
            }
            case 1: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("METHOD_TYPE_PARAMETER ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeParameterIndex());
                break;
            }
            case 16: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("CLASS_EXTENDS ").append(lllllllllllllllIllIIllIllIIlIIIl.getSuperTypeIndex());
                break;
            }
            case 17: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("CLASS_TYPE_PARAMETER_BOUND ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeParameterIndex()).append(", ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeParameterBoundIndex());
                break;
            }
            case 18: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("METHOD_TYPE_PARAMETER_BOUND ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeParameterIndex()).append(", ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeParameterBoundIndex());
                break;
            }
            case 19: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("FIELD");
                break;
            }
            case 20: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("METHOD_RETURN");
                break;
            }
            case 21: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("METHOD_RECEIVER");
                break;
            }
            case 22: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("METHOD_FORMAL_PARAMETER ").append(lllllllllllllllIllIIllIllIIlIIIl.getFormalParameterIndex());
                break;
            }
            case 23: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("THROWS ").append(lllllllllllllllIllIIllIllIIlIIIl.getExceptionIndex());
                break;
            }
            case 64: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("LOCAL_VARIABLE");
                break;
            }
            case 65: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("RESOURCE_VARIABLE");
                break;
            }
            case 66: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("EXCEPTION_PARAMETER ").append(lllllllllllllllIllIIllIllIIlIIIl.getTryCatchBlockIndex());
                break;
            }
            case 67: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("INSTANCEOF");
                break;
            }
            case 68: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("NEW");
                break;
            }
            case 69: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("CONSTRUCTOR_REFERENCE");
                break;
            }
            case 70: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("METHOD_REFERENCE");
                break;
            }
            case 71: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("CAST ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeArgumentIndex());
                break;
            }
            case 72: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("CONSTRUCTOR_INVOCATION_TYPE_ARGUMENT ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeArgumentIndex());
                break;
            }
            case 73: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("METHOD_INVOCATION_TYPE_ARGUMENT ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeArgumentIndex());
                break;
            }
            case 74: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("CONSTRUCTOR_REFERENCE_TYPE_ARGUMENT ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeArgumentIndex());
                break;
            }
            case 75: {
                Textifier lllllllllllllllIllIIllIllIIlIIll;
                lllllllllllllllIllIIllIllIIlIIll.buf.append("METHOD_REFERENCE_TYPE_ARGUMENT ").append(lllllllllllllllIllIIllIllIIlIIIl.getTypeArgumentIndex());
            }
        }
    }

    public void visitClassEnd() {
        Textifier lllllllllllllllIllIlIIIIIIIIlIlI;
        lllllllllllllllIllIlIIIIIIIIlIlI.text.add("}\n");
    }

    private void visitByte(byte lllllllllllllllIllIIllllllIIIIll) {
        Textifier lllllllllllllllIllIIllllllIIIllI;
        lllllllllllllllIllIIllllllIIIllI.buf.append("(byte)").append(lllllllllllllllIllIIllllllIIIIll);
    }

    public Printer visitLocalVariableAnnotation(int lllllllllllllllIllIIlllIIIIIIIIl, TypePath lllllllllllllllIllIIlllIIIIIIIII, Label[] lllllllllllllllIllIIllIlllllllll, Label[] lllllllllllllllIllIIllIllllllllI, int[] lllllllllllllllIllIIlllIIIIIIllI, String lllllllllllllllIllIIllIlllllllII, boolean lllllllllllllllIllIIlllIIIIIIlII) {
        Textifier lllllllllllllllIllIIlllIIIIIlIll;
        lllllllllllllllIllIIlllIIIIIlIll.buf.setLength(0);
        lllllllllllllllIllIIlllIIIIIlIll.buf.append(lllllllllllllllIllIIlllIIIIIlIll.tab2).append("LOCALVARIABLE @");
        lllllllllllllllIllIIlllIIIIIlIll.appendDescriptor(1, lllllllllllllllIllIIllIlllllllII);
        lllllllllllllllIllIIlllIIIIIlIll.buf.append('(');
        lllllllllllllllIllIIlllIIIIIlIll.text.add(lllllllllllllllIllIIlllIIIIIlIll.buf.toString());
        Textifier lllllllllllllllIllIIlllIIIIIIIll = lllllllllllllllIllIIlllIIIIIlIll.createTextifier();
        lllllllllllllllIllIIlllIIIIIlIll.text.add(lllllllllllllllIllIIlllIIIIIIIll.getText());
        lllllllllllllllIllIIlllIIIIIlIll.buf.setLength(0);
        lllllllllllllllIllIIlllIIIIIlIll.buf.append(") : ");
        lllllllllllllllIllIIlllIIIIIlIll.appendTypeReference(lllllllllllllllIllIIlllIIIIIIIIl);
        lllllllllllllllIllIIlllIIIIIlIll.buf.append(", ").append(lllllllllllllllIllIIlllIIIIIIIII);
        for (int lllllllllllllllIllIIlllIIIIIllII = 0; lllllllllllllllIllIIlllIIIIIllII < lllllllllllllllIllIIllIlllllllll.length; ++lllllllllllllllIllIIlllIIIIIllII) {
            lllllllllllllllIllIIlllIIIIIlIll.buf.append(" [ ");
            lllllllllllllllIllIIlllIIIIIlIll.appendLabel(lllllllllllllllIllIIllIlllllllll[lllllllllllllllIllIIlllIIIIIllII]);
            lllllllllllllllIllIIlllIIIIIlIll.buf.append(" - ");
            lllllllllllllllIllIIlllIIIIIlIll.appendLabel(lllllllllllllllIllIIllIllllllllI[lllllllllllllllIllIIlllIIIIIllII]);
            lllllllllllllllIllIIlllIIIIIlIll.buf.append(" - ").append(lllllllllllllllIllIIlllIIIIIIllI[lllllllllllllllIllIIlllIIIIIllII]).append(" ]");
        }
        lllllllllllllllIllIIlllIIIIIlIll.buf.append(lllllllllllllllIllIIlllIIIIIIlII ? "\n" : " // invisible\n");
        lllllllllllllllIllIIlllIIIIIlIll.text.add(lllllllllllllllIllIIlllIIIIIlIll.buf.toString());
        return lllllllllllllllIllIIlllIIIIIIIll;
    }

    public Printer visitClassTypeAnnotation(int lllllllllllllllIllIlIIIIIllIIIIl, TypePath lllllllllllllllIllIlIIIIIllIIlIl, String lllllllllllllllIllIlIIIIIllIIlII, boolean lllllllllllllllIllIlIIIIIlIllllI) {
        Textifier lllllllllllllllIllIlIIIIIllIIlll;
        lllllllllllllllIllIlIIIIIllIIlll.text.add("\n");
        return lllllllllllllllIllIlIIIIIllIIlll.visitTypeAnnotation(lllllllllllllllIllIlIIIIIllIIIIl, lllllllllllllllIllIlIIIIIllIIlIl, lllllllllllllllIllIlIIIIIllIIlII, lllllllllllllllIllIlIIIIIlIllllI);
    }

    public void visitMultiANewArrayInsn(String lllllllllllllllIllIIlllIIllIIllI, int lllllllllllllllIllIIlllIIllIIlIl) {
        Textifier lllllllllllllllIllIIlllIIllIIlII;
        lllllllllllllllIllIIlllIIllIIlII.buf.setLength(0);
        lllllllllllllllIllIIlllIIllIIlII.buf.append(lllllllllllllllIllIIlllIIllIIlII.tab2).append("MULTIANEWARRAY ");
        lllllllllllllllIllIIlllIIllIIlII.appendDescriptor(1, lllllllllllllllIllIIlllIIllIIllI);
        lllllllllllllllIllIIlllIIllIIlII.buf.append(' ').append(lllllllllllllllIllIIlllIIllIIlIl).append('\n');
        lllllllllllllllIllIIlllIIllIIlII.text.add(lllllllllllllllIllIIlllIIllIIlII.buf.toString());
    }

    public void visitAnnotationEnd() {
    }

    public void visitMethodAttribute(Attribute lllllllllllllllIllIIllllIIllIllI) {
        Textifier lllllllllllllllIllIIllllIIllIlIl;
        lllllllllllllllIllIIllllIIllIlIl.buf.setLength(0);
        lllllllllllllllIllIIllllIIllIlIl.buf.append(lllllllllllllllIllIIllllIIllIlIl.tab).append("ATTRIBUTE ");
        lllllllllllllllIllIIllllIIllIlIl.appendDescriptor(-1, lllllllllllllllIllIIllllIIllIllI.type);
        if (lllllllllllllllIllIIllllIIllIllI instanceof Textifiable) {
            ((Textifiable)((Object)lllllllllllllllIllIIllllIIllIllI)).textify(lllllllllllllllIllIIllllIIllIlIl.buf, lllllllllllllllIllIIllllIIllIlIl.labelNames);
        } else {
            lllllllllllllllIllIIllllIIllIlIl.buf.append(" : unknown\n");
        }
        lllllllllllllllIllIIllllIIllIlIl.text.add(lllllllllllllllIllIIllllIIllIlIl.buf.toString());
    }

    public Textifier visitAnnotation(String lllllllllllllllIllIIllIlllIlllII, boolean lllllllllllllllIllIIllIlllIlllll) {
        Textifier lllllllllllllllIllIIllIllllIIIIl;
        lllllllllllllllIllIIllIllllIIIIl.buf.setLength(0);
        lllllllllllllllIllIIllIllllIIIIl.buf.append(lllllllllllllllIllIIllIllllIIIIl.tab).append('@');
        lllllllllllllllIllIIllIllllIIIIl.appendDescriptor(1, lllllllllllllllIllIIllIlllIlllII);
        lllllllllllllllIllIIllIllllIIIIl.buf.append('(');
        lllllllllllllllIllIIllIllllIIIIl.text.add(lllllllllllllllIllIIllIllllIIIIl.buf.toString());
        Textifier lllllllllllllllIllIIllIlllIllllI = lllllllllllllllIllIIllIllllIIIIl.createTextifier();
        lllllllllllllllIllIIllIllllIIIIl.text.add(lllllllllllllllIllIIllIlllIllllI.getText());
        lllllllllllllllIllIIllIllllIIIIl.text.add(lllllllllllllllIllIIllIlllIlllll ? ")\n" : ") // invisible\n");
        return lllllllllllllllIllIIllIlllIllllI;
    }

    private void visitInt(int lllllllllllllllIllIIlllllllIIlll) {
        Textifier lllllllllllllllIllIIlllllllIlIlI;
        lllllllllllllllIllIIlllllllIlIlI.buf.append(lllllllllllllllIllIIlllllllIIlll);
    }

    public Textifier visitClassAnnotation(String lllllllllllllllIllIlIIIIIllIlllI, boolean lllllllllllllllIllIlIIIIIllIllIl) {
        Textifier lllllllllllllllIllIlIIIIIlllIIlI;
        lllllllllllllllIllIlIIIIIlllIIlI.text.add("\n");
        return lllllllllllllllIllIlIIIIIlllIIlI.visitAnnotation(lllllllllllllllIllIlIIIIIllIlllI, lllllllllllllllIllIlIIIIIllIllIl);
    }

    public Textifier visitArray(String lllllllllllllllIllIIlllllIIlIIIl) {
        Textifier lllllllllllllllIllIIlllllIIlIIlI;
        lllllllllllllllIllIIlllllIIlIIlI.buf.setLength(0);
        lllllllllllllllIllIIlllllIIlIIlI.appendComa(lllllllllllllllIllIIlllllIIlIIlI.valueNumber++);
        if (lllllllllllllllIllIIlllllIIlIIIl != null) {
            lllllllllllllllIllIIlllllIIlIIlI.buf.append(lllllllllllllllIllIIlllllIIlIIIl).append('=');
        }
        lllllllllllllllIllIIlllllIIlIIlI.buf.append('{');
        lllllllllllllllIllIIlllllIIlIIlI.text.add(lllllllllllllllIllIIlllllIIlIIlI.buf.toString());
        Textifier lllllllllllllllIllIIlllllIIlIIll = lllllllllllllllIllIIlllllIIlIIlI.createTextifier();
        lllllllllllllllIllIIlllllIIlIIlI.text.add(lllllllllllllllIllIIlllllIIlIIll.getText());
        lllllllllllllllIllIIlllllIIlIIlI.text.add("}");
        return lllllllllllllllIllIIlllllIIlIIll;
    }

    public void visitParameter(String lllllllllllllllIllIIllllIllIlIII, int lllllllllllllllIllIIllllIllIIlll) {
        Textifier lllllllllllllllIllIIllllIllIllII;
        lllllllllllllllIllIIllllIllIllII.buf.setLength(0);
        lllllllllllllllIllIIllllIllIllII.buf.append(lllllllllllllllIllIIllllIllIllII.tab2).append("// parameter ");
        lllllllllllllllIllIIllllIllIllII.appendAccess(lllllllllllllllIllIIllllIllIIlll);
        lllllllllllllllIllIIllllIllIllII.buf.append(' ').append(lllllllllllllllIllIIllllIllIlIII == null ? "<no name>" : lllllllllllllllIllIIllllIllIlIII).append('\n');
        lllllllllllllllIllIIllllIllIllII.text.add(lllllllllllllllIllIIllllIllIllII.buf.toString());
    }

    private void visitString(String lllllllllllllllIllIIlllllIllIlll) {
        Textifier lllllllllllllllIllIIlllllIlllIlI;
        Textifier.appendString(lllllllllllllllIllIIlllllIlllIlI.buf, lllllllllllllllIllIIlllllIllIlll);
    }

    public Textifier visitFieldAnnotation(String lllllllllllllllIllIIlllllIIIIlll, boolean lllllllllllllllIllIIlllllIIIlIIl) {
        Textifier lllllllllllllllIllIIlllllIIIlIll;
        return lllllllllllllllIllIIlllllIIIlIll.visitAnnotation(lllllllllllllllIllIIlllllIIIIlll, lllllllllllllllIllIIlllllIIIlIIl);
    }

    public Printer visitMethodTypeAnnotation(int lllllllllllllllIllIIllllIlIlIIIl, TypePath lllllllllllllllIllIIllllIlIlIIII, String lllllllllllllllIllIIllllIlIIllll, boolean lllllllllllllllIllIIllllIlIIlllI) {
        Textifier lllllllllllllllIllIIllllIlIIllIl;
        return lllllllllllllllIllIIllllIlIIllIl.visitTypeAnnotation(lllllllllllllllIllIIllllIlIlIIIl, lllllllllllllllIllIIllllIlIlIIII, lllllllllllllllIllIIllllIlIIllll, lllllllllllllllIllIIllllIlIIlllI);
    }

    public void visitIntInsn(int lllllllllllllllIllIIllllIIIlIllI, int lllllllllllllllIllIIllllIIIlIIlI) {
        Textifier lllllllllllllllIllIIllllIIIlIlII;
        lllllllllllllllIllIIllllIIIlIlII.buf.setLength(0);
        lllllllllllllllIllIIllllIIIlIlII.buf.append(lllllllllllllllIllIIllllIIIlIlII.tab2).append(OPCODES[lllllllllllllllIllIIllllIIIlIllI]).append(' ').append(lllllllllllllllIllIIllllIIIlIllI == 188 ? TYPES[lllllllllllllllIllIIllllIIIlIIlI] : Integer.toString(lllllllllllllllIllIIllllIIIlIIlI)).append('\n');
        lllllllllllllllIllIIllllIIIlIlII.text.add(lllllllllllllllIllIIllllIIIlIlII.buf.toString());
    }

    private void doVisitMethodInsn(int lllllllllllllllIllIIlllIllIIlIIl, String lllllllllllllllIllIIlllIllIIIIlI, String lllllllllllllllIllIIlllIllIIIlll, String lllllllllllllllIllIIlllIllIIIllI, boolean lllllllllllllllIllIIlllIllIIIlIl) {
        Textifier lllllllllllllllIllIIlllIllIIIlII;
        lllllllllllllllIllIIlllIllIIIlII.buf.setLength(0);
        lllllllllllllllIllIIlllIllIIIlII.buf.append(lllllllllllllllIllIIlllIllIIIlII.tab2).append(OPCODES[lllllllllllllllIllIIlllIllIIlIIl]).append(' ');
        lllllllllllllllIllIIlllIllIIIlII.appendDescriptor(0, lllllllllllllllIllIIlllIllIIIIlI);
        lllllllllllllllIllIIlllIllIIIlII.buf.append('.').append(lllllllllllllllIllIIlllIllIIIlll).append(' ');
        lllllllllllllllIllIIlllIllIIIlII.appendDescriptor(3, lllllllllllllllIllIIlllIllIIIllI);
        lllllllllllllllIllIIlllIllIIIlII.buf.append('\n');
        lllllllllllllllIllIIlllIllIIIlII.text.add(lllllllllllllllIllIIlllIllIIIlII.buf.toString());
    }

    public void visitLookupSwitchInsn(Label lllllllllllllllIllIIlllIIlllIIlI, int[] lllllllllllllllIllIIlllIIllIllIl, Label[] lllllllllllllllIllIIlllIIlllIIII) {
        Textifier lllllllllllllllIllIIlllIIllIllll;
        lllllllllllllllIllIIlllIIllIllll.buf.setLength(0);
        lllllllllllllllIllIIlllIIllIllll.buf.append(lllllllllllllllIllIIlllIIllIllll.tab2).append("LOOKUPSWITCH\n");
        for (int lllllllllllllllIllIIlllIIlllIlII = 0; lllllllllllllllIllIIlllIIlllIlII < lllllllllllllllIllIIlllIIlllIIII.length; ++lllllllllllllllIllIIlllIIlllIlII) {
            lllllllllllllllIllIIlllIIllIllll.buf.append(lllllllllllllllIllIIlllIIllIllll.tab3).append(lllllllllllllllIllIIlllIIllIllIl[lllllllllllllllIllIIlllIIlllIlII]).append(": ");
            lllllllllllllllIllIIlllIIllIllll.appendLabel(lllllllllllllllIllIIlllIIlllIIII[lllllllllllllllIllIIlllIIlllIlII]);
            lllllllllllllllIllIIlllIIllIllll.buf.append('\n');
        }
        lllllllllllllllIllIIlllIIllIllll.buf.append(lllllllllllllllIllIIlllIIllIllll.tab3).append("default: ");
        lllllllllllllllIllIIlllIIllIllll.appendLabel(lllllllllllllllIllIIlllIIlllIIlI);
        lllllllllllllllIllIIlllIIllIllll.buf.append('\n');
        lllllllllllllllIllIIlllIIllIllll.text.add(lllllllllllllllIllIIlllIIllIllll.buf.toString());
    }

    public void visitMethodEnd() {
    }

    public Textifier visitTypeAnnotation(int lllllllllllllllIllIIllIlllIIllII, TypePath lllllllllllllllIllIIllIlllIIlIll, String lllllllllllllllIllIIllIlllIIlIlI, boolean lllllllllllllllIllIIllIlllIIlIIl) {
        Textifier lllllllllllllllIllIIllIlllIIllIl;
        lllllllllllllllIllIIllIlllIIllIl.buf.setLength(0);
        lllllllllllllllIllIIllIlllIIllIl.buf.append(lllllllllllllllIllIIllIlllIIllIl.tab).append('@');
        lllllllllllllllIllIIllIlllIIllIl.appendDescriptor(1, lllllllllllllllIllIIllIlllIIlIlI);
        lllllllllllllllIllIIllIlllIIllIl.buf.append('(');
        lllllllllllllllIllIIllIlllIIllIl.text.add(lllllllllllllllIllIIllIlllIIllIl.buf.toString());
        Textifier lllllllllllllllIllIIllIlllIIlllI = lllllllllllllllIllIIllIlllIIllIl.createTextifier();
        lllllllllllllllIllIIllIlllIIllIl.text.add(lllllllllllllllIllIIllIlllIIlllI.getText());
        lllllllllllllllIllIIllIlllIIllIl.buf.setLength(0);
        lllllllllllllllIllIIllIlllIIllIl.buf.append(") : ");
        lllllllllllllllIllIIllIlllIIllIl.appendTypeReference(lllllllllllllllIllIIllIlllIIllII);
        lllllllllllllllIllIIllIlllIIllIl.buf.append(", ").append(lllllllllllllllIllIIllIlllIIlIll);
        lllllllllllllllIllIIllIlllIIllIl.buf.append(lllllllllllllllIllIIllIlllIIlIIl ? "\n" : " // invisible\n");
        lllllllllllllllIllIIllIlllIIllIl.text.add(lllllllllllllllIllIIllIlllIIllIl.buf.toString());
        return lllllllllllllllIllIIllIlllIIlllI;
    }

    public void visit(int lllllllllllllllIllIlIIIIlIIlIlII, int lllllllllllllllIllIlIIIIlIIlIIll, String lllllllllllllllIllIlIIIIlIIlIIlI, String lllllllllllllllIllIlIIIIlIIlIIIl, String lllllllllllllllIllIlIIIIlIIllIIl, String[] lllllllllllllllIllIlIIIIlIIIllll) {
        Textifier lllllllllllllllIllIlIIIIlIIllllI;
        lllllllllllllllIllIlIIIIlIIllllI.access = lllllllllllllllIllIlIIIIlIIlIIll;
        int lllllllllllllllIllIlIIIIlIIlIlll = lllllllllllllllIllIlIIIIlIIlIlII & 0xFFFF;
        int lllllllllllllllIllIlIIIIlIIlIllI = lllllllllllllllIllIlIIIIlIIlIlII >>> 16;
        lllllllllllllllIllIlIIIIlIIllllI.buf.setLength(0);
        lllllllllllllllIllIlIIIIlIIllllI.buf.append("// class version ").append(lllllllllllllllIllIlIIIIlIIlIlll).append('.').append(lllllllllllllllIllIlIIIIlIIlIllI).append(" (").append(lllllllllllllllIllIlIIIIlIIlIlII).append(")\n");
        if ((lllllllllllllllIllIlIIIIlIIlIIll & 0x20000) != 0) {
            lllllllllllllllIllIlIIIIlIIllllI.buf.append("// DEPRECATED\n");
        }
        lllllllllllllllIllIlIIIIlIIllllI.buf.append("// access flags 0x").append(Integer.toHexString(lllllllllllllllIllIlIIIIlIIlIIll).toUpperCase()).append('\n');
        lllllllllllllllIllIlIIIIlIIllllI.appendDescriptor(5, lllllllllllllllIllIlIIIIlIIlIIIl);
        if (lllllllllllllllIllIlIIIIlIIlIIIl != null) {
            TraceSignatureVisitor lllllllllllllllIllIlIIIIlIlIIIIl = new TraceSignatureVisitor(lllllllllllllllIllIlIIIIlIIlIIll);
            SignatureReader lllllllllllllllIllIlIIIIlIlIIIII = new SignatureReader(lllllllllllllllIllIlIIIIlIIlIIIl);
            lllllllllllllllIllIlIIIIlIlIIIII.accept(lllllllllllllllIllIlIIIIlIlIIIIl);
            lllllllllllllllIllIlIIIIlIIllllI.buf.append("// declaration: ").append(lllllllllllllllIllIlIIIIlIIlIIlI).append(lllllllllllllllIllIlIIIIlIlIIIIl.getDeclaration()).append('\n');
        }
        lllllllllllllllIllIlIIIIlIIllllI.appendAccess(lllllllllllllllIllIlIIIIlIIlIIll & 0xFFFFFFDF);
        if ((lllllllllllllllIllIlIIIIlIIlIIll & 0x2000) != 0) {
            lllllllllllllllIllIlIIIIlIIllllI.buf.append("@interface ");
        } else if ((lllllllllllllllIllIlIIIIlIIlIIll & 0x200) != 0) {
            lllllllllllllllIllIlIIIIlIIllllI.buf.append("interface ");
        } else if ((lllllllllllllllIllIlIIIIlIIlIIll & 0x4000) == 0) {
            lllllllllllllllIllIlIIIIlIIllllI.buf.append("class ");
        }
        lllllllllllllllIllIlIIIIlIIllllI.appendDescriptor(0, lllllllllllllllIllIlIIIIlIIlIIlI);
        if (lllllllllllllllIllIlIIIIlIIllIIl != null && !"java/lang/Object".equals(lllllllllllllllIllIlIIIIlIIllIIl)) {
            lllllllllllllllIllIlIIIIlIIllllI.buf.append(" extends ");
            lllllllllllllllIllIlIIIIlIIllllI.appendDescriptor(0, lllllllllllllllIllIlIIIIlIIllIIl);
            lllllllllllllllIllIlIIIIlIIllllI.buf.append(' ');
        }
        if (lllllllllllllllIllIlIIIIlIIIllll != null && lllllllllllllllIllIlIIIIlIIIllll.length > 0) {
            lllllllllllllllIllIlIIIIlIIllllI.buf.append(" implements ");
            for (int lllllllllllllllIllIlIIIIlIIlllll = 0; lllllllllllllllIllIlIIIIlIIlllll < lllllllllllllllIllIlIIIIlIIIllll.length; ++lllllllllllllllIllIlIIIIlIIlllll) {
                lllllllllllllllIllIlIIIIlIIllllI.appendDescriptor(0, lllllllllllllllIllIlIIIIlIIIllll[lllllllllllllllIllIlIIIIlIIlllll]);
                lllllllllllllllIllIlIIIIlIIllllI.buf.append(' ');
            }
        }
        lllllllllllllllIllIlIIIIlIIllllI.buf.append(" {\n\n");
        lllllllllllllllIllIlIIIIlIIllllI.text.add(lllllllllllllllIllIlIIIIlIIllllI.buf.toString());
    }

    private void visitChar(char lllllllllllllllIllIIllllllIlIIIl) {
        Textifier lllllllllllllllIllIIllllllIlIIII;
        lllllllllllllllIllIIllllllIlIIII.buf.append("(char)").append((int)lllllllllllllllIllIIllllllIlIIIl);
    }

    public Textifier visitField(int lllllllllllllllIllIlIIIIIIllIllI, String lllllllllllllllIllIlIIIIIIllllII, String lllllllllllllllIllIlIIIIIIlllIll, String lllllllllllllllIllIlIIIIIIlllIlI, Object lllllllllllllllIllIlIIIIIIlllIIl) {
        Textifier lllllllllllllllIllIlIIIIIIllIlll;
        lllllllllllllllIllIlIIIIIIllIlll.buf.setLength(0);
        lllllllllllllllIllIlIIIIIIllIlll.buf.append('\n');
        if ((lllllllllllllllIllIlIIIIIIllIllI & 0x20000) != 0) {
            lllllllllllllllIllIlIIIIIIllIlll.buf.append(lllllllllllllllIllIlIIIIIIllIlll.tab).append("// DEPRECATED\n");
        }
        lllllllllllllllIllIlIIIIIIllIlll.buf.append(lllllllllllllllIllIlIIIIIIllIlll.tab).append("// access flags 0x").append(Integer.toHexString(lllllllllllllllIllIlIIIIIIllIllI).toUpperCase()).append('\n');
        if (lllllllllllllllIllIlIIIIIIlllIlI != null) {
            lllllllllllllllIllIlIIIIIIllIlll.buf.append(lllllllllllllllIllIlIIIIIIllIlll.tab);
            lllllllllllllllIllIlIIIIIIllIlll.appendDescriptor(2, lllllllllllllllIllIlIIIIIIlllIlI);
            TraceSignatureVisitor lllllllllllllllIllIlIIIIIlIIIIII = new TraceSignatureVisitor(0);
            SignatureReader lllllllllllllllIllIlIIIIIIllllll = new SignatureReader(lllllllllllllllIllIlIIIIIIlllIlI);
            lllllllllllllllIllIlIIIIIIllllll.acceptType(lllllllllllllllIllIlIIIIIlIIIIII);
            lllllllllllllllIllIlIIIIIIllIlll.buf.append(lllllllllllllllIllIlIIIIIIllIlll.tab).append("// declaration: ").append(lllllllllllllllIllIlIIIIIlIIIIII.getDeclaration()).append('\n');
        }
        lllllllllllllllIllIlIIIIIIllIlll.buf.append(lllllllllllllllIllIlIIIIIIllIlll.tab);
        lllllllllllllllIllIlIIIIIIllIlll.appendAccess(lllllllllllllllIllIlIIIIIIllIllI);
        lllllllllllllllIllIlIIIIIIllIlll.appendDescriptor(1, lllllllllllllllIllIlIIIIIIlllIll);
        lllllllllllllllIllIlIIIIIIllIlll.buf.append(' ').append(lllllllllllllllIllIlIIIIIIllllII);
        if (lllllllllllllllIllIlIIIIIIlllIIl != null) {
            lllllllllllllllIllIlIIIIIIllIlll.buf.append(" = ");
            if (lllllllllllllllIllIlIIIIIIlllIIl instanceof String) {
                lllllllllllllllIllIlIIIIIIllIlll.buf.append('\"').append(lllllllllllllllIllIlIIIIIIlllIIl).append('\"');
            } else {
                lllllllllllllllIllIlIIIIIIllIlll.buf.append(lllllllllllllllIllIlIIIIIIlllIIl);
            }
        }
        lllllllllllllllIllIlIIIIIIllIlll.buf.append('\n');
        lllllllllllllllIllIlIIIIIIllIlll.text.add(lllllllllllllllIllIlIIIIIIllIlll.buf.toString());
        Textifier lllllllllllllllIllIlIIIIIIlllIII = lllllllllllllllIllIlIIIIIIllIlll.createTextifier();
        lllllllllllllllIllIlIIIIIIllIlll.text.add(lllllllllllllllIllIlIIIIIIlllIII.getText());
        return lllllllllllllllIllIlIIIIIIlllIII;
    }

    protected void appendDescriptor(int lllllllllllllllIllIIllIllIllllII, String lllllllllllllllIllIIllIllIlllIII) {
        Textifier lllllllllllllllIllIIllIllIlllIlI;
        if (lllllllllllllllIllIIllIllIllllII == 5 || lllllllllllllllIllIIllIllIllllII == 2 || lllllllllllllllIllIIllIllIllllII == 4) {
            if (lllllllllllllllIllIIllIllIlllIII != null) {
                lllllllllllllllIllIIllIllIlllIlI.buf.append("// signature ").append(lllllllllllllllIllIIllIllIlllIII).append('\n');
            }
        } else {
            lllllllllllllllIllIIllIllIlllIlI.buf.append(lllllllllllllllIllIIllIllIlllIII);
        }
    }

    public void visitMethodInsn(int lllllllllllllllIllIIlllIllIlIlII, String lllllllllllllllIllIIlllIllIllIIl, String lllllllllllllllIllIIlllIllIllIII, String lllllllllllllllIllIIlllIllIlIIIl, boolean lllllllllllllllIllIIlllIllIlIIII) {
        Textifier lllllllllllllllIllIIlllIllIlIlIl;
        if (lllllllllllllllIllIIlllIllIlIlIl.api < 327680) {
            super.visitMethodInsn(lllllllllllllllIllIIlllIllIlIlII, lllllllllllllllIllIIlllIllIllIIl, lllllllllllllllIllIIlllIllIllIII, lllllllllllllllIllIIlllIllIlIIIl, lllllllllllllllIllIIlllIllIlIIII);
            return;
        }
        lllllllllllllllIllIIlllIllIlIlIl.doVisitMethodInsn(lllllllllllllllIllIIlllIllIlIlII, lllllllllllllllIllIIlllIllIllIIl, lllllllllllllllIllIIlllIllIllIII, lllllllllllllllIllIIlllIllIlIIIl, lllllllllllllllIllIIlllIllIlIIII);
    }

    private void visitShort(short lllllllllllllllIllIIllllllIIlIIl) {
        Textifier lllllllllllllllIllIIllllllIIlIlI;
        lllllllllllllllIllIIllllllIIlIlI.buf.append("(short)").append(lllllllllllllllIllIIllllllIIlIIl);
    }

    @Deprecated
    public void visitMethodInsn(int lllllllllllllllIllIIlllIlllIIlIl, String lllllllllllllllIllIIlllIlllIIlII, String lllllllllllllllIllIIlllIlllIlIII, String lllllllllllllllIllIIlllIlllIIlll) {
        Textifier lllllllllllllllIllIIlllIlllIlIll;
        if (lllllllllllllllIllIIlllIlllIlIll.api >= 327680) {
            super.visitMethodInsn(lllllllllllllllIllIIlllIlllIIlIl, lllllllllllllllIllIIlllIlllIIlII, lllllllllllllllIllIIlllIlllIlIII, lllllllllllllllIllIIlllIlllIIlll);
            return;
        }
        lllllllllllllllIllIIlllIlllIlIll.doVisitMethodInsn(lllllllllllllllIllIIlllIlllIIlIl, lllllllllllllllIllIIlllIlllIIlII, lllllllllllllllIllIIlllIlllIlIII, lllllllllllllllIllIIlllIlllIIlll, lllllllllllllllIllIIlllIlllIIlIl == 185);
    }

    public void visitLabel(Label lllllllllllllllIllIIlllIlIIllIll) {
        Textifier lllllllllllllllIllIIlllIlIIlllII;
        lllllllllllllllIllIIlllIlIIlllII.buf.setLength(0);
        lllllllllllllllIllIIlllIlIIlllII.buf.append(lllllllllllllllIllIIlllIlIIlllII.ltab);
        lllllllllllllllIllIIlllIlIIlllII.appendLabel(lllllllllllllllIllIIlllIlIIllIll);
        lllllllllllllllIllIIlllIlIIlllII.buf.append('\n');
        lllllllllllllllIllIIlllIlIIlllII.text.add(lllllllllllllllIllIIlllIlIIlllII.buf.toString());
    }

    private void visitDouble(double lllllllllllllllIllIIllllllIlIlll) {
        Textifier lllllllllllllllIllIIllllllIllIII;
        lllllllllllllllIllIIllllllIllIII.buf.append(lllllllllllllllIllIIllllllIlIlll).append('D');
    }

    private void appendComa(int lllllllllllllllIllIIllIllIIllIIl) {
        if (lllllllllllllllIllIIllIllIIllIIl != 0) {
            Textifier lllllllllllllllIllIIllIllIIllIII;
            lllllllllllllllIllIIllIllIIllIII.buf.append(", ");
        }
    }
}

