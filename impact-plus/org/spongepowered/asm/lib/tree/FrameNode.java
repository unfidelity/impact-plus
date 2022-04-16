/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class FrameNode
extends AbstractInsnNode {
    public /* synthetic */ List<Object> stack;
    public /* synthetic */ List<Object> local;
    public /* synthetic */ int type;

    @Override
    public int getType() {
        return 14;
    }

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllllIIlllIIllIllIl) {
        FrameNode llllllllllllllllllIIlllIIllIlllI;
        FrameNode llllllllllllllllllIIlllIIllIllll = new FrameNode();
        llllllllllllllllllIIlllIIllIllll.type = llllllllllllllllllIIlllIIllIlllI.type;
        if (llllllllllllllllllIIlllIIllIlllI.local != null) {
            llllllllllllllllllIIlllIIllIllll.local = new ArrayList<Object>();
            for (int llllllllllllllllllIIlllIIlllIlII = 0; llllllllllllllllllIIlllIIlllIlII < llllllllllllllllllIIlllIIllIlllI.local.size(); ++llllllllllllllllllIIlllIIlllIlII) {
                Object llllllllllllllllllIIlllIIlllIlIl = llllllllllllllllllIIlllIIllIlllI.local.get(llllllllllllllllllIIlllIIlllIlII);
                if (llllllllllllllllllIIlllIIlllIlIl instanceof LabelNode) {
                    llllllllllllllllllIIlllIIlllIlIl = llllllllllllllllllIIlllIIllIllIl.get(llllllllllllllllllIIlllIIlllIlIl);
                }
                llllllllllllllllllIIlllIIllIllll.local.add(llllllllllllllllllIIlllIIlllIlIl);
            }
        }
        if (llllllllllllllllllIIlllIIllIlllI.stack != null) {
            llllllllllllllllllIIlllIIllIllll.stack = new ArrayList<Object>();
            for (int llllllllllllllllllIIlllIIlllIIlI = 0; llllllllllllllllllIIlllIIlllIIlI < llllllllllllllllllIIlllIIllIlllI.stack.size(); ++llllllllllllllllllIIlllIIlllIIlI) {
                Object llllllllllllllllllIIlllIIlllIIll = llllllllllllllllllIIlllIIllIlllI.stack.get(llllllllllllllllllIIlllIIlllIIlI);
                if (llllllllllllllllllIIlllIIlllIIll instanceof LabelNode) {
                    llllllllllllllllllIIlllIIlllIIll = llllllllllllllllllIIlllIIllIllIl.get(llllllllllllllllllIIlllIIlllIIll);
                }
                llllllllllllllllllIIlllIIllIllll.stack.add(llllllllllllllllllIIlllIIlllIIll);
            }
        }
        return llllllllllllllllllIIlllIIllIllll;
    }

    private static List<Object> asList(int llllllllllllllllllIIlllIIllIIlIl, Object[] llllllllllllllllllIIlllIIllIIllI) {
        return Arrays.asList(llllllllllllllllllIIlllIIllIIllI).subList(0, llllllllllllllllllIIlllIIllIIlIl);
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllllIIlllIIllllIll) {
        FrameNode llllllllllllllllllIIlllIIlllllII;
        switch (llllllllllllllllllIIlllIIlllllII.type) {
            case -1: 
            case 0: {
                llllllllllllllllllIIlllIIllllIll.visitFrame(llllllllllllllllllIIlllIIlllllII.type, llllllllllllllllllIIlllIIlllllII.local.size(), FrameNode.asArray(llllllllllllllllllIIlllIIlllllII.local), llllllllllllllllllIIlllIIlllllII.stack.size(), FrameNode.asArray(llllllllllllllllllIIlllIIlllllII.stack));
                break;
            }
            case 1: {
                llllllllllllllllllIIlllIIllllIll.visitFrame(llllllllllllllllllIIlllIIlllllII.type, llllllllllllllllllIIlllIIlllllII.local.size(), FrameNode.asArray(llllllllllllllllllIIlllIIlllllII.local), 0, null);
                break;
            }
            case 2: {
                llllllllllllllllllIIlllIIllllIll.visitFrame(llllllllllllllllllIIlllIIlllllII.type, llllllllllllllllllIIlllIIlllllII.local.size(), null, 0, null);
                break;
            }
            case 3: {
                llllllllllllllllllIIlllIIllllIll.visitFrame(llllllllllllllllllIIlllIIlllllII.type, 0, null, 0, null);
                break;
            }
            case 4: {
                llllllllllllllllllIIlllIIllllIll.visitFrame(llllllllllllllllllIIlllIIlllllII.type, 0, null, 1, FrameNode.asArray(llllllllllllllllllIIlllIIlllllII.stack));
            }
        }
    }

    private FrameNode() {
        super(-1);
        FrameNode llllllllllllllllllIIlllIlIIlIlII;
    }

    private static Object[] asArray(List<Object> llllllllllllllllllIIlllIIlIllIll) {
        Object[] llllllllllllllllllIIlllIIlIlllII = new Object[llllllllllllllllllIIlllIIlIllIll.size()];
        for (int llllllllllllllllllIIlllIIlIllllI = 0; llllllllllllllllllIIlllIIlIllllI < llllllllllllllllllIIlllIIlIlllII.length; ++llllllllllllllllllIIlllIIlIllllI) {
            Object llllllllllllllllllIIlllIIlIlllll = llllllllllllllllllIIlllIIlIllIll.get(llllllllllllllllllIIlllIIlIllllI);
            if (llllllllllllllllllIIlllIIlIlllll instanceof LabelNode) {
                llllllllllllllllllIIlllIIlIlllll = ((LabelNode)llllllllllllllllllIIlllIIlIlllll).getLabel();
            }
            llllllllllllllllllIIlllIIlIlllII[llllllllllllllllllIIlllIIlIllllI] = llllllllllllllllllIIlllIIlIlllll;
        }
        return llllllllllllllllllIIlllIIlIlllII;
    }

    public FrameNode(int llllllllllllllllllIIlllIlIIIIllI, int llllllllllllllllllIIlllIlIIIlIll, Object[] llllllllllllllllllIIlllIlIIIIlII, int llllllllllllllllllIIlllIlIIIIIll, Object[] llllllllllllllllllIIlllIlIIIlIII) {
        super(-1);
        FrameNode llllllllllllllllllIIlllIlIIIllIl;
        llllllllllllllllllIIlllIlIIIllIl.type = llllllllllllllllllIIlllIlIIIIllI;
        switch (llllllllllllllllllIIlllIlIIIIllI) {
            case -1: 
            case 0: {
                llllllllllllllllllIIlllIlIIIllIl.local = FrameNode.asList(llllllllllllllllllIIlllIlIIIlIll, llllllllllllllllllIIlllIlIIIIlII);
                llllllllllllllllllIIlllIlIIIllIl.stack = FrameNode.asList(llllllllllllllllllIIlllIlIIIIIll, llllllllllllllllllIIlllIlIIIlIII);
                break;
            }
            case 1: {
                llllllllllllllllllIIlllIlIIIllIl.local = FrameNode.asList(llllllllllllllllllIIlllIlIIIlIll, llllllllllllllllllIIlllIlIIIIlII);
                break;
            }
            case 2: {
                llllllllllllllllllIIlllIlIIIllIl.local = Arrays.asList(new Object[llllllllllllllllllIIlllIlIIIlIll]);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                llllllllllllllllllIIlllIlIIIllIl.stack = FrameNode.asList(1, llllllllllllllllllIIlllIlIIIlIII);
            }
        }
    }
}

