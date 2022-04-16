/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class AnnotationNode
extends AnnotationVisitor {
    public /* synthetic */ String desc;
    public /* synthetic */ List<Object> values;

    @Override
    public AnnotationVisitor visitArray(String llllllllllllllllIlIlIIIllllIIIIl) {
        AnnotationNode llllllllllllllllIlIlIIIlllIlllll;
        if (llllllllllllllllIlIlIIIlllIlllll.values == null) {
            llllllllllllllllIlIlIIIlllIlllll.values = new ArrayList<Object>(llllllllllllllllIlIlIIIlllIlllll.desc != null ? 2 : 1);
        }
        if (llllllllllllllllIlIlIIIlllIlllll.desc != null) {
            llllllllllllllllIlIlIIIlllIlllll.values.add(llllllllllllllllIlIlIIIllllIIIIl);
        }
        ArrayList<Object> llllllllllllllllIlIlIIIllllIIIII = new ArrayList<Object>();
        llllllllllllllllIlIlIIIlllIlllll.values.add(llllllllllllllllIlIlIIIllllIIIII);
        return new AnnotationNode(llllllllllllllllIlIlIIIllllIIIII);
    }

    static void accept(AnnotationVisitor llllllllllllllllIlIlIIIllIlIIIIl, String llllllllllllllllIlIlIIIllIlIIIII, Object llllllllllllllllIlIlIIIllIIlllll) {
        if (llllllllllllllllIlIlIIIllIlIIIIl != null) {
            if (llllllllllllllllIlIlIIIllIIlllll instanceof String[]) {
                String[] llllllllllllllllIlIlIIIllIlIllIl = (String[])llllllllllllllllIlIlIIIllIIlllll;
                llllllllllllllllIlIlIIIllIlIIIIl.visitEnum(llllllllllllllllIlIlIIIllIlIIIII, llllllllllllllllIlIlIIIllIlIllIl[0], llllllllllllllllIlIlIIIllIlIllIl[1]);
            } else if (llllllllllllllllIlIlIIIllIIlllll instanceof AnnotationNode) {
                AnnotationNode llllllllllllllllIlIlIIIllIlIllII = (AnnotationNode)llllllllllllllllIlIlIIIllIIlllll;
                llllllllllllllllIlIlIIIllIlIllII.accept(llllllllllllllllIlIlIIIllIlIIIIl.visitAnnotation(llllllllllllllllIlIlIIIllIlIIIII, llllllllllllllllIlIlIIIllIlIllII.desc));
            } else if (llllllllllllllllIlIlIIIllIIlllll instanceof List) {
                AnnotationVisitor llllllllllllllllIlIlIIIllIlIlIII = llllllllllllllllIlIlIIIllIlIIIIl.visitArray(llllllllllllllllIlIlIIIllIlIIIII);
                if (llllllllllllllllIlIlIIIllIlIlIII != null) {
                    List llllllllllllllllIlIlIIIllIlIlIIl = (List)llllllllllllllllIlIlIIIllIIlllll;
                    for (int llllllllllllllllIlIlIIIllIlIlIll = 0; llllllllllllllllIlIlIIIllIlIlIll < llllllllllllllllIlIlIIIllIlIlIIl.size(); ++llllllllllllllllIlIlIIIllIlIlIll) {
                        AnnotationNode.accept(llllllllllllllllIlIlIIIllIlIlIII, null, llllllllllllllllIlIlIIIllIlIlIIl.get(llllllllllllllllIlIlIIIllIlIlIll));
                    }
                    llllllllllllllllIlIlIIIllIlIlIII.visitEnd();
                }
            } else {
                llllllllllllllllIlIlIIIllIlIIIIl.visit(llllllllllllllllIlIlIIIllIlIIIII, llllllllllllllllIlIlIIIllIIlllll);
            }
        }
    }

    @Override
    public void visitEnum(String llllllllllllllllIlIlIIIlllllIlII, String llllllllllllllllIlIlIIIlllllIIll, String llllllllllllllllIlIlIIIlllllIllI) {
        AnnotationNode llllllllllllllllIlIlIIIlllllIlIl;
        if (llllllllllllllllIlIlIIIlllllIlIl.values == null) {
            llllllllllllllllIlIlIIIlllllIlIl.values = new ArrayList<Object>(llllllllllllllllIlIlIIIlllllIlIl.desc != null ? 2 : 1);
        }
        if (llllllllllllllllIlIlIIIlllllIlIl.desc != null) {
            llllllllllllllllIlIlIIIlllllIlIl.values.add(llllllllllllllllIlIlIIIlllllIlII);
        }
        llllllllllllllllIlIlIIIlllllIlIl.values.add(new String[]{llllllllllllllllIlIlIIIlllllIIll, llllllllllllllllIlIlIIIlllllIllI});
    }

    @Override
    public AnnotationVisitor visitAnnotation(String llllllllllllllllIlIlIIIllllIlIII, String llllllllllllllllIlIlIIIllllIlIll) {
        AnnotationNode llllllllllllllllIlIlIIIllllIlIIl;
        if (llllllllllllllllIlIlIIIllllIlIIl.values == null) {
            llllllllllllllllIlIlIIIllllIlIIl.values = new ArrayList<Object>(llllllllllllllllIlIlIIIllllIlIIl.desc != null ? 2 : 1);
        }
        if (llllllllllllllllIlIlIIIllllIlIIl.desc != null) {
            llllllllllllllllIlIlIIIllllIlIIl.values.add(llllllllllllllllIlIlIIIllllIlIII);
        }
        AnnotationNode llllllllllllllllIlIlIIIllllIlIlI = new AnnotationNode(llllllllllllllllIlIlIIIllllIlIll);
        llllllllllllllllIlIlIIIllllIlIIl.values.add(llllllllllllllllIlIlIIIllllIlIlI);
        return llllllllllllllllIlIlIIIllllIlIlI;
    }

    public AnnotationNode(int llllllllllllllllIlIlIIlIIlllIIII, String llllllllllllllllIlIlIIlIIllIlllI) {
        super(llllllllllllllllIlIlIIlIIlllIIII);
        AnnotationNode llllllllllllllllIlIlIIlIIlllIlll;
        llllllllllllllllIlIlIIlIIlllIlll.desc = llllllllllllllllIlIlIIlIIllIlllI;
    }

    @Override
    public void visitEnd() {
    }

    public AnnotationNode(String llllllllllllllllIlIlIIlIlIIIIIII) {
        llllllllllllllllIlIlIIlIIllllllI(327680, llllllllllllllllIlIlIIlIlIIIIIII);
        AnnotationNode llllllllllllllllIlIlIIlIIllllllI;
        if (llllllllllllllllIlIlIIlIIllllllI.getClass() != AnnotationNode.class) {
            throw new IllegalStateException();
        }
    }

    public void check(int llllllllllllllllIlIlIIIlllIllIlI) {
    }

    public void accept(AnnotationVisitor llllllllllllllllIlIlIIIlllIIlIll) {
        if (llllllllllllllllIlIlIIIlllIIlIll != null) {
            AnnotationNode llllllllllllllllIlIlIIIlllIIlIIl;
            if (llllllllllllllllIlIlIIIlllIIlIIl.values != null) {
                for (int llllllllllllllllIlIlIIIlllIIllll = 0; llllllllllllllllIlIlIIIlllIIllll < llllllllllllllllIlIlIIIlllIIlIIl.values.size(); llllllllllllllllIlIlIIIlllIIllll += 2) {
                    String llllllllllllllllIlIlIIIlllIlIIIl = (String)llllllllllllllllIlIlIIIlllIIlIIl.values.get(llllllllllllllllIlIlIIIlllIIllll);
                    Object llllllllllllllllIlIlIIIlllIlIIII = llllllllllllllllIlIlIIIlllIIlIIl.values.get(llllllllllllllllIlIlIIIlllIIllll + 1);
                    AnnotationNode.accept(llllllllllllllllIlIlIIIlllIIlIll, llllllllllllllllIlIlIIIlllIlIIIl, llllllllllllllllIlIlIIIlllIlIIII);
                }
            }
            llllllllllllllllIlIlIIIlllIIlIll.visitEnd();
        }
    }

    @Override
    public void visit(String llllllllllllllllIlIlIIlIIIIIlIIl, Object llllllllllllllllIlIlIIlIIIIIlIII) {
        AnnotationNode llllllllllllllllIlIlIIlIIIIIlIlI;
        if (llllllllllllllllIlIlIIlIIIIIlIlI.values == null) {
            llllllllllllllllIlIlIIlIIIIIlIlI.values = new ArrayList<Object>(llllllllllllllllIlIlIIlIIIIIlIlI.desc != null ? 2 : 1);
        }
        if (llllllllllllllllIlIlIIlIIIIIlIlI.desc != null) {
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIIIlIIl);
        }
        if (llllllllllllllllIlIlIIlIIIIIlIII instanceof byte[]) {
            byte[] llllllllllllllllIlIlIIlIIIlIIlIl = (byte[])llllllllllllllllIlIlIIlIIIIIlIII;
            ArrayList<Byte> llllllllllllllllIlIlIIlIIIlIIIlI = new ArrayList<Byte>(llllllllllllllllIlIlIIlIIIlIIlIl.length);
            for (byte llllllllllllllllIlIlIIlIIIlIIllI : llllllllllllllllIlIlIIlIIIlIIlIl) {
                llllllllllllllllIlIlIIlIIIlIIIlI.add(llllllllllllllllIlIlIIlIIIlIIllI);
            }
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIlIIIlI);
        } else if (llllllllllllllllIlIlIIlIIIIIlIII instanceof boolean[]) {
            boolean[] llllllllllllllllIlIlIIlIIIlIIIII = (boolean[])llllllllllllllllIlIlIIlIIIIIlIII;
            ArrayList<Boolean> llllllllllllllllIlIlIIlIIIIlllll = new ArrayList<Boolean>(llllllllllllllllIlIlIIlIIIlIIIII.length);
            for (boolean llllllllllllllllIlIlIIlIIIlIIIIl : llllllllllllllllIlIlIIlIIIlIIIII) {
                llllllllllllllllIlIlIIlIIIIlllll.add(llllllllllllllllIlIlIIlIIIlIIIIl);
            }
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIIlllll);
        } else if (llllllllllllllllIlIlIIlIIIIIlIII instanceof short[]) {
            short[] llllllllllllllllIlIlIIlIIIIllIll = (short[])llllllllllllllllIlIlIIlIIIIIlIII;
            ArrayList<Short> llllllllllllllllIlIlIIlIIIIllIlI = new ArrayList<Short>(llllllllllllllllIlIlIIlIIIIllIll.length);
            for (short llllllllllllllllIlIlIIlIIIIlllIl : llllllllllllllllIlIlIIlIIIIllIll) {
                llllllllllllllllIlIlIIlIIIIllIlI.add(llllllllllllllllIlIlIIlIIIIlllIl);
            }
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIIllIlI);
        } else if (llllllllllllllllIlIlIIlIIIIIlIII instanceof char[]) {
            char[] llllllllllllllllIlIlIIlIIIIllIII = (char[])llllllllllllllllIlIlIIlIIIIIlIII;
            ArrayList<Character> llllllllllllllllIlIlIIlIIIIlIlll = new ArrayList<Character>(llllllllllllllllIlIlIIlIIIIllIII.length);
            for (char llllllllllllllllIlIlIIlIIIIllIIl : llllllllllllllllIlIlIIlIIIIllIII) {
                llllllllllllllllIlIlIIlIIIIlIlll.add(Character.valueOf(llllllllllllllllIlIlIIlIIIIllIIl));
            }
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIIlIlll);
        } else if (llllllllllllllllIlIlIIlIIIIIlIII instanceof int[]) {
            int[] llllllllllllllllIlIlIIlIIIIlIlIl = (int[])llllllllllllllllIlIlIIlIIIIIlIII;
            ArrayList<Integer> llllllllllllllllIlIlIIlIIIIlIlII = new ArrayList<Integer>(llllllllllllllllIlIlIIlIIIIlIlIl.length);
            for (int llllllllllllllllIlIlIIlIIIIlIllI : llllllllllllllllIlIlIIlIIIIlIlIl) {
                llllllllllllllllIlIlIIlIIIIlIlII.add(llllllllllllllllIlIlIIlIIIIlIllI);
            }
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIIlIlII);
        } else if (llllllllllllllllIlIlIIlIIIIIlIII instanceof long[]) {
            long[] llllllllllllllllIlIlIIlIIIIlIIlI = (long[])llllllllllllllllIlIlIIlIIIIIlIII;
            ArrayList<Long> llllllllllllllllIlIlIIlIIIIlIIIl = new ArrayList<Long>(llllllllllllllllIlIlIIlIIIIlIIlI.length);
            for (long llllllllllllllllIlIlIIlIIIIlIIll : llllllllllllllllIlIlIIlIIIIlIIlI) {
                llllllllllllllllIlIlIIlIIIIlIIIl.add(llllllllllllllllIlIlIIlIIIIlIIll);
            }
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIIlIIIl);
        } else if (llllllllllllllllIlIlIIlIIIIIlIII instanceof float[]) {
            float[] llllllllllllllllIlIlIIlIIIIIllll = (float[])llllllllllllllllIlIlIIlIIIIIlIII;
            ArrayList<Float> llllllllllllllllIlIlIIlIIIIIlllI = new ArrayList<Float>(llllllllllllllllIlIlIIlIIIIIllll.length);
            for (float llllllllllllllllIlIlIIlIIIIlIIII : llllllllllllllllIlIlIIlIIIIIllll) {
                llllllllllllllllIlIlIIlIIIIIlllI.add(Float.valueOf(llllllllllllllllIlIlIIlIIIIlIIII));
            }
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIIIlllI);
        } else if (llllllllllllllllIlIlIIlIIIIIlIII instanceof double[]) {
            double[] llllllllllllllllIlIlIIlIIIIIllII = (double[])llllllllllllllllIlIlIIlIIIIIlIII;
            ArrayList<Double> llllllllllllllllIlIlIIlIIIIIlIll = new ArrayList<Double>(llllllllllllllllIlIlIIlIIIIIllII.length);
            for (double llllllllllllllllIlIlIIlIIIIIllIl : llllllllllllllllIlIlIIlIIIIIllII) {
                llllllllllllllllIlIlIIlIIIIIlIll.add(llllllllllllllllIlIlIIlIIIIIllIl);
            }
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIIIlIll);
        } else {
            llllllllllllllllIlIlIIlIIIIIlIlI.values.add(llllllllllllllllIlIlIIlIIIIIlIII);
        }
    }

    AnnotationNode(List<Object> llllllllllllllllIlIlIIlIIllIlIIl) {
        super(327680);
        AnnotationNode llllllllllllllllIlIlIIlIIllIlIII;
        llllllllllllllllIlIlIIlIIllIlIII.values = llllllllllllllllIlIlIIlIIllIlIIl;
    }
}

