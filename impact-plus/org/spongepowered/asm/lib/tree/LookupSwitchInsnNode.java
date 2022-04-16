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
public class LookupSwitchInsnNode
extends AbstractInsnNode {
    public /* synthetic */ List<LabelNode> labels;
    public /* synthetic */ LabelNode dflt;
    public /* synthetic */ List<Integer> keys;

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllIIlIllllIlIlIIII) {
        LookupSwitchInsnNode llllllllllllllllIIlIllllIlIIlllI;
        LookupSwitchInsnNode llllllllllllllllIIlIllllIlIIllll = new LookupSwitchInsnNode(LookupSwitchInsnNode.clone(llllllllllllllllIIlIllllIlIIlllI.dflt, llllllllllllllllIIlIllllIlIlIIII), null, LookupSwitchInsnNode.clone(llllllllllllllllIIlIllllIlIIlllI.labels, llllllllllllllllIIlIllllIlIlIIII));
        llllllllllllllllIIlIllllIlIIllll.keys.addAll(llllllllllllllllIIlIllllIlIIlllI.keys);
        return llllllllllllllllIIlIllllIlIIllll.cloneAnnotations(llllllllllllllllIIlIllllIlIIlllI);
    }

    public LookupSwitchInsnNode(LabelNode llllllllllllllllIIlIllllIllIllIl, int[] llllllllllllllllIIlIllllIllIllII, LabelNode[] llllllllllllllllIIlIllllIllIIlll) {
        super(171);
        LookupSwitchInsnNode llllllllllllllllIIlIllllIllIlIlI;
        llllllllllllllllIIlIllllIllIlIlI.dflt = llllllllllllllllIIlIllllIllIllIl;
        llllllllllllllllIIlIllllIllIlIlI.keys = new ArrayList<Integer>(llllllllllllllllIIlIllllIllIllII == null ? 0 : llllllllllllllllIIlIllllIllIllII.length);
        llllllllllllllllIIlIllllIllIlIlI.labels = new ArrayList<LabelNode>(llllllllllllllllIIlIllllIllIIlll == null ? 0 : llllllllllllllllIIlIllllIllIIlll.length);
        if (llllllllllllllllIIlIllllIllIllII != null) {
            for (int llllllllllllllllIIlIllllIllIllll = 0; llllllllllllllllIIlIllllIllIllll < llllllllllllllllIIlIllllIllIllII.length; ++llllllllllllllllIIlIllllIllIllll) {
                llllllllllllllllIIlIllllIllIlIlI.keys.add(llllllllllllllllIIlIllllIllIllII[llllllllllllllllIIlIllllIllIllll]);
            }
        }
        if (llllllllllllllllIIlIllllIllIIlll != null) {
            llllllllllllllllIIlIllllIllIlIlI.labels.addAll(Arrays.asList(llllllllllllllllIIlIllllIllIIlll));
        }
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllIIlIllllIlIlllII) {
        LookupSwitchInsnNode llllllllllllllllIIlIllllIlIlllIl;
        int[] llllllllllllllllIIlIllllIlIllIll = new int[llllllllllllllllIIlIllllIlIlllIl.keys.size()];
        for (int llllllllllllllllIIlIllllIlIlllll = 0; llllllllllllllllIIlIllllIlIlllll < llllllllllllllllIIlIllllIlIllIll.length; ++llllllllllllllllIIlIllllIlIlllll) {
            llllllllllllllllIIlIllllIlIllIll[llllllllllllllllIIlIllllIlIlllll] = llllllllllllllllIIlIllllIlIlllIl.keys.get(llllllllllllllllIIlIllllIlIlllll);
        }
        Label[] llllllllllllllllIIlIllllIlIllIlI = new Label[llllllllllllllllIIlIllllIlIlllIl.labels.size()];
        for (int llllllllllllllllIIlIllllIlIllllI = 0; llllllllllllllllIIlIllllIlIllllI < llllllllllllllllIIlIllllIlIllIlI.length; ++llllllllllllllllIIlIllllIlIllllI) {
            llllllllllllllllIIlIllllIlIllIlI[llllllllllllllllIIlIllllIlIllllI] = llllllllllllllllIIlIllllIlIlllIl.labels.get(llllllllllllllllIIlIllllIlIllllI).getLabel();
        }
        llllllllllllllllIIlIllllIlIlllII.visitLookupSwitchInsn(llllllllllllllllIIlIllllIlIlllIl.dflt.getLabel(), llllllllllllllllIIlIllllIlIllIll, llllllllllllllllIIlIllllIlIllIlI);
        llllllllllllllllIIlIllllIlIlllIl.acceptAnnotations(llllllllllllllllIIlIllllIlIlllII);
    }

    @Override
    public int getType() {
        return 12;
    }
}

