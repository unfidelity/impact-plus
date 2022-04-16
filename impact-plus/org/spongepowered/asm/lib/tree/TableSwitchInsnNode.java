/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class TableSwitchInsnNode
extends AbstractInsnNode {
    public /* synthetic */ int min;
    public /* synthetic */ int max;
    public /* synthetic */ List<LabelNode> labels;
    public /* synthetic */ LabelNode dflt;

    @Override
    public int getType() {
        return 11;
    }

    @Override
    public void accept(MethodVisitor lllllllllllllllllIllIIIlIIIIIIlI) {
        TableSwitchInsnNode lllllllllllllllllIllIIIlIIIIIIII;
        Label[] lllllllllllllllllIllIIIlIIIIIIIl = new Label[lllllllllllllllllIllIIIlIIIIIIII.labels.size()];
        for (int lllllllllllllllllIllIIIlIIIIIlII = 0; lllllllllllllllllIllIIIlIIIIIlII < lllllllllllllllllIllIIIlIIIIIIIl.length; ++lllllllllllllllllIllIIIlIIIIIlII) {
            lllllllllllllllllIllIIIlIIIIIIIl[lllllllllllllllllIllIIIlIIIIIlII] = lllllllllllllllllIllIIIlIIIIIIII.labels.get(lllllllllllllllllIllIIIlIIIIIlII).getLabel();
        }
        lllllllllllllllllIllIIIlIIIIIIlI.visitTableSwitchInsn(lllllllllllllllllIllIIIlIIIIIIII.min, lllllllllllllllllIllIIIlIIIIIIII.max, lllllllllllllllllIllIIIlIIIIIIII.dflt.getLabel(), lllllllllllllllllIllIIIlIIIIIIIl);
        lllllllllllllllllIllIIIlIIIIIIII.acceptAnnotations(lllllllllllllllllIllIIIlIIIIIIlI);
    }

    public TableSwitchInsnNode(int lllllllllllllllllIllIIIlIIIIllIl, int lllllllllllllllllIllIIIlIIIIllII, LabelNode lllllllllllllllllIllIIIlIIIlIIII, LabelNode ... lllllllllllllllllIllIIIlIIIIlIlI) {
        super(170);
        TableSwitchInsnNode lllllllllllllllllIllIIIlIIIlIlIl;
        lllllllllllllllllIllIIIlIIIlIlIl.min = lllllllllllllllllIllIIIlIIIIllIl;
        lllllllllllllllllIllIIIlIIIlIlIl.max = lllllllllllllllllIllIIIlIIIIllII;
        lllllllllllllllllIllIIIlIIIlIlIl.dflt = lllllllllllllllllIllIIIlIIIlIIII;
        lllllllllllllllllIllIIIlIIIlIlIl.labels = new ArrayList<LabelNode>();
        if (lllllllllllllllllIllIIIlIIIIlIlI != null) {
            lllllllllllllllllIllIIIlIIIlIlIl.labels.addAll(Arrays.asList(lllllllllllllllllIllIIIlIIIIlIlI));
        }
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> lllllllllllllllllIllIIIIllllIlll) {
        TableSwitchInsnNode lllllllllllllllllIllIIIIlllllIII;
        return new TableSwitchInsnNode(lllllllllllllllllIllIIIIlllllIII.min, lllllllllllllllllIllIIIIlllllIII.max, TableSwitchInsnNode.clone(lllllllllllllllllIllIIIIlllllIII.dflt, lllllllllllllllllIllIIIIllllIlll), TableSwitchInsnNode.clone(lllllllllllllllllIllIIIIlllllIII.labels, lllllllllllllllllIllIIIIllllIlll)).cloneAnnotations(lllllllllllllllllIllIIIIlllllIII);
    }
}

