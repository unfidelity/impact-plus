/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;

public class LocalVariableAnnotationNode
extends TypeAnnotationNode {
    public /* synthetic */ List<Integer> index;
    public /* synthetic */ List<LabelNode> start;
    public /* synthetic */ List<LabelNode> end;

    public LocalVariableAnnotationNode(int lIllIIlIIlllIIl, TypePath lIllIIlIIlllIII, LabelNode[] lIllIIlIIllIlll, LabelNode[] lIllIIlIIllllIl, int[] lIllIIlIIllIlIl, String lIllIIlIIllIlII) {
        lIllIIlIIlllIlI(327680, lIllIIlIIlllIIl, lIllIIlIIlllIII, lIllIIlIIllIlll, lIllIIlIIllllIl, lIllIIlIIllIlIl, lIllIIlIIllIlII);
        LocalVariableAnnotationNode lIllIIlIIlllIlI;
    }

    public void accept(MethodVisitor lIllIIlIIIIlIlI, boolean lIllIIlIIIIlIIl) {
        LocalVariableAnnotationNode lIllIIlIIIIIlIl;
        Label[] lIllIIlIIIIlIII = new Label[lIllIIlIIIIIlIl.start.size()];
        Label[] lIllIIlIIIIIlll = new Label[lIllIIlIIIIIlIl.end.size()];
        int[] lIllIIlIIIIIllI = new int[lIllIIlIIIIIlIl.index.size()];
        for (int lIllIIlIIIIllII = 0; lIllIIlIIIIllII < lIllIIlIIIIlIII.length; ++lIllIIlIIIIllII) {
            lIllIIlIIIIlIII[lIllIIlIIIIllII] = lIllIIlIIIIIlIl.start.get(lIllIIlIIIIllII).getLabel();
            lIllIIlIIIIIlll[lIllIIlIIIIllII] = lIllIIlIIIIIlIl.end.get(lIllIIlIIIIllII).getLabel();
            lIllIIlIIIIIllI[lIllIIlIIIIllII] = lIllIIlIIIIIlIl.index.get(lIllIIlIIIIllII);
        }
        lIllIIlIIIIIlIl.accept(lIllIIlIIIIlIlI.visitLocalVariableAnnotation(lIllIIlIIIIIlIl.typeRef, lIllIIlIIIIIlIl.typePath, lIllIIlIIIIlIII, lIllIIlIIIIIlll, lIllIIlIIIIIllI, lIllIIlIIIIIlIl.desc, true));
    }

    public LocalVariableAnnotationNode(int lIllIIlIIIlllIl, int lIllIIlIIIlllII, TypePath lIllIIlIIIllIll, LabelNode[] lIllIIlIIIllIlI, LabelNode[] lIllIIlIIlIIIIl, int[] lIllIIlIIIllIII, String lIllIIlIIIlllll) {
        super(lIllIIlIIIlllIl, lIllIIlIIIlllII, lIllIIlIIIllIll, lIllIIlIIIlllll);
        LocalVariableAnnotationNode lIllIIlIIIllllI;
        lIllIIlIIIllllI.start = new ArrayList<LabelNode>(lIllIIlIIIllIlI.length);
        lIllIIlIIIllllI.start.addAll(Arrays.asList(lIllIIlIIIllIlI));
        lIllIIlIIIllllI.end = new ArrayList<LabelNode>(lIllIIlIIlIIIIl.length);
        lIllIIlIIIllllI.end.addAll(Arrays.asList(lIllIIlIIlIIIIl));
        lIllIIlIIIllllI.index = new ArrayList<Integer>(lIllIIlIIIllIII.length);
        for (int lIllIIlIIlIIlll : lIllIIlIIIllIII) {
            lIllIIlIIIllllI.index.add(lIllIIlIIlIIlll);
        }
    }
}

