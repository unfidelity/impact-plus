/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.List;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;

public class TryCatchBlockNode {
    public /* synthetic */ List<TypeAnnotationNode> visibleTypeAnnotations;
    public /* synthetic */ String type;
    public /* synthetic */ LabelNode handler;
    public /* synthetic */ List<TypeAnnotationNode> invisibleTypeAnnotations;
    public /* synthetic */ LabelNode end;
    public /* synthetic */ LabelNode start;

    public TryCatchBlockNode(LabelNode llllllllllllllllIllllllIlllllIIl, LabelNode llllllllllllllllIllllllIllllIlll, LabelNode llllllllllllllllIllllllIlllIlIIl, String llllllllllllllllIllllllIlllIIlll) {
        TryCatchBlockNode llllllllllllllllIllllllIlllIlllI;
        llllllllllllllllIllllllIlllIlllI.start = llllllllllllllllIllllllIlllllIIl;
        llllllllllllllllIllllllIlllIlllI.end = llllllllllllllllIllllllIllllIlll;
        llllllllllllllllIllllllIlllIlllI.handler = llllllllllllllllIllllllIlllIlIIl;
        llllllllllllllllIllllllIlllIlllI.type = llllllllllllllllIllllllIlllIIlll;
    }

    public void updateIndex(int llllllllllllllllIllllllIlIllllIl) {
        TryCatchBlockNode llllllllllllllllIllllllIllIIIIIl;
        int llllllllllllllllIllllllIlIlllIlI = 0x42000000 | llllllllllllllllIllllllIlIllllIl << 8;
        if (llllllllllllllllIllllllIllIIIIIl.visibleTypeAnnotations != null) {
            for (TypeAnnotationNode llllllllllllllllIllllllIllIIIllI : llllllllllllllllIllllllIllIIIIIl.visibleTypeAnnotations) {
                llllllllllllllllIllllllIllIIIllI.typeRef = llllllllllllllllIllllllIlIlllIlI;
            }
        }
        if (llllllllllllllllIllllllIllIIIIIl.invisibleTypeAnnotations != null) {
            for (TypeAnnotationNode llllllllllllllllIllllllIllIIIlII : llllllllllllllllIllllllIllIIIIIl.invisibleTypeAnnotations) {
                llllllllllllllllIllllllIllIIIlII.typeRef = llllllllllllllllIllllllIlIlllIlI;
            }
        }
    }

    public void accept(MethodVisitor llllllllllllllllIllllllIIllIlIlI) {
        TryCatchBlockNode llllllllllllllllIllllllIIllIIIlI;
        llllllllllllllllIllllllIIllIlIlI.visitTryCatchBlock(llllllllllllllllIllllllIIllIIIlI.start.getLabel(), llllllllllllllllIllllllIIllIIIlI.end.getLabel(), llllllllllllllllIllllllIIllIIIlI.handler == null ? null : llllllllllllllllIllllllIIllIIIlI.handler.getLabel(), llllllllllllllllIllllllIIllIIIlI.type);
        int llllllllllllllllIllllllIIllIlIII = llllllllllllllllIllllllIIllIIIlI.visibleTypeAnnotations == null ? 0 : llllllllllllllllIllllllIIllIIIlI.visibleTypeAnnotations.size();
        for (int llllllllllllllllIllllllIIlllIIIl = 0; llllllllllllllllIllllllIIlllIIIl < llllllllllllllllIllllllIIllIlIII; ++llllllllllllllllIllllllIIlllIIIl) {
            TypeAnnotationNode llllllllllllllllIllllllIIlllIlII = llllllllllllllllIllllllIIllIIIlI.visibleTypeAnnotations.get(llllllllllllllllIllllllIIlllIIIl);
            llllllllllllllllIllllllIIlllIlII.accept(llllllllllllllllIllllllIIllIlIlI.visitTryCatchAnnotation(llllllllllllllllIllllllIIlllIlII.typeRef, llllllllllllllllIllllllIIlllIlII.typePath, llllllllllllllllIllllllIIlllIlII.desc, true));
        }
        llllllllllllllllIllllllIIllIlIII = llllllllllllllllIllllllIIllIIIlI.invisibleTypeAnnotations == null ? 0 : llllllllllllllllIllllllIIllIIIlI.invisibleTypeAnnotations.size();
        for (int llllllllllllllllIllllllIIllIllIl = 0; llllllllllllllllIllllllIIllIllIl < llllllllllllllllIllllllIIllIlIII; ++llllllllllllllllIllllllIIllIllIl) {
            TypeAnnotationNode llllllllllllllllIllllllIIllIllll = llllllllllllllllIllllllIIllIIIlI.invisibleTypeAnnotations.get(llllllllllllllllIllllllIIllIllIl);
            llllllllllllllllIllllllIIllIllll.accept(llllllllllllllllIllllllIIllIlIlI.visitTryCatchAnnotation(llllllllllllllllIllllllIIllIllll.typeRef, llllllllllllllllIllllllIIllIllll.typePath, llllllllllllllllIllllllIIllIllll.desc, false));
        }
    }
}

