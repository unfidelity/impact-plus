/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.spongepowered.asm.lib.commons.Remapper
 */
package org.spongepowered.asm.mixin.transformer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.commons.ClassRemapper;
import org.spongepowered.asm.lib.commons.Remapper;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.mixin.transformer.ext.IClassGenerator;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.transformers.MixinClassWriter;

final class InnerClassGenerator
implements IClassGenerator {
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ Map<String, InnerClassInfo> innerClasses;
    private final /* synthetic */ Map<String, String> innerClassNames;

    @Override
    public byte[] generate(String lIlIlIIIIlIllI) {
        InnerClassGenerator lIlIlIIIIlIIll;
        String lIlIlIIIIlIlIl = lIlIlIIIIlIllI.replace('.', '/');
        InnerClassInfo lIlIlIIIIlIlII = lIlIlIIIIlIIll.innerClasses.get(lIlIlIIIIlIlIl);
        if (lIlIlIIIIlIlII != null) {
            return lIlIlIIIIlIIll.generate(lIlIlIIIIlIlII);
        }
        return null;
    }

    private byte[] generate(InnerClassInfo lIlIlIIIIIIlll) {
        try {
            logger.debug("Generating mapped inner class {} (originally {})", new Object[]{lIlIlIIIIIIlll.getName(), lIlIlIIIIIIlll.getOriginalName()});
            ClassReader lIlIlIIIIIllII = new ClassReader(lIlIlIIIIIIlll.getClassBytes());
            MixinClassWriter lIlIlIIIIIlIll = new MixinClassWriter(lIlIlIIIIIllII, 0);
            lIlIlIIIIIllII.accept(new InnerClassAdapter((ClassVisitor)lIlIlIIIIIlIll, lIlIlIIIIIIlll), 8);
            return lIlIlIIIIIlIll.toByteArray();
        }
        catch (InvalidMixinException lIlIlIIIIIlIlI) {
            throw lIlIlIIIIIlIlI;
        }
        catch (Exception lIlIlIIIIIlIIl) {
            logger.catching((Throwable)lIlIlIIIIIlIIl);
            return null;
        }
    }

    public String registerInnerClass(MixinInfo lIlIlIIIlIIIII, String lIlIlIIIIlllll, MixinTargetContext lIlIlIIIlIIlII) {
        InnerClassGenerator lIlIlIIIlIIlll;
        String lIlIlIIIlIIIll = String.format("%s%s", lIlIlIIIIlllll, lIlIlIIIlIIlII);
        String lIlIlIIIlIIIlI = lIlIlIIIlIIlll.innerClassNames.get(lIlIlIIIlIIIll);
        if (lIlIlIIIlIIIlI == null) {
            lIlIlIIIlIIIlI = InnerClassGenerator.getUniqueReference(lIlIlIIIIlllll, lIlIlIIIlIIlII);
            lIlIlIIIlIIlll.innerClassNames.put(lIlIlIIIlIIIll, lIlIlIIIlIIIlI);
            lIlIlIIIlIIlll.innerClasses.put(lIlIlIIIlIIIlI, new InnerClassInfo(lIlIlIIIlIIIlI, lIlIlIIIIlllll, lIlIlIIIlIIIII, lIlIlIIIlIIlII));
            logger.debug("Inner class {} in {} on {} gets unique name {}", new Object[]{lIlIlIIIIlllll, lIlIlIIIlIIIII.getClassRef(), lIlIlIIIlIIlII.getTargetClassRef(), lIlIlIIIlIIIlI});
        }
        return lIlIlIIIlIIIlI;
    }

    private static String getUniqueReference(String lIlIIlllllllIl, MixinTargetContext lIlIIlllllllII) {
        String lIlIIllllllllI = lIlIIlllllllIl.substring(lIlIIlllllllIl.lastIndexOf(36) + 1);
        if (lIlIIllllllllI.matches("^[0-9]+$")) {
            lIlIIllllllllI = "Anonymous";
        }
        return String.format("%s$%s$%s", lIlIIlllllllII.getTargetClassRef(), lIlIIllllllllI, UUID.randomUUID().toString().replace("-", ""));
    }

    InnerClassGenerator() {
        InnerClassGenerator lIlIlIIIlIlllI;
        lIlIlIIIlIlllI.innerClassNames = new HashMap<String, String>();
        lIlIlIIIlIlllI.innerClasses = new HashMap<String, InnerClassInfo>();
    }

    static {
        logger = LogManager.getLogger((String)"mixin");
    }

    static class InnerClassInfo
    extends Remapper {
        private final /* synthetic */ MixinInfo owner;
        private final /* synthetic */ MixinTargetContext target;
        private final /* synthetic */ String targetName;
        private final /* synthetic */ String name;
        private final /* synthetic */ String ownerName;
        private final /* synthetic */ String originalName;

        public String map(String lllllllllllllllllllIIIIIIIllIIII) {
            InnerClassInfo lllllllllllllllllllIIIIIIIlIllll;
            if (lllllllllllllllllllIIIIIIIlIllll.originalName.equals(lllllllllllllllllllIIIIIIIllIIII)) {
                return lllllllllllllllllllIIIIIIIlIllll.name;
            }
            if (lllllllllllllllllllIIIIIIIlIllll.ownerName.equals(lllllllllllllllllllIIIIIIIllIIII)) {
                return lllllllllllllllllllIIIIIIIlIllll.targetName;
            }
            return lllllllllllllllllllIIIIIIIllIIII;
        }

        MixinInfo getOwner() {
            InnerClassInfo lllllllllllllllllllIIIIIIlIIllll;
            return lllllllllllllllllllIIIIIIlIIllll.owner;
        }

        InnerClassInfo(String lllllllllllllllllllIIIIIIlIllIll, String lllllllllllllllllllIIIIIIlIlllll, MixinInfo lllllllllllllllllllIIIIIIlIllIIl, MixinTargetContext lllllllllllllllllllIIIIIIlIlllIl) {
            InnerClassInfo lllllllllllllllllllIIIIIIlIlllII;
            lllllllllllllllllllIIIIIIlIlllII.name = lllllllllllllllllllIIIIIIlIllIll;
            lllllllllllllllllllIIIIIIlIlllII.originalName = lllllllllllllllllllIIIIIIlIlllll;
            lllllllllllllllllllIIIIIIlIlllII.owner = lllllllllllllllllllIIIIIIlIllIIl;
            lllllllllllllllllllIIIIIIlIlllII.ownerName = lllllllllllllllllllIIIIIIlIllIIl.getClassRef();
            lllllllllllllllllllIIIIIIlIlllII.target = lllllllllllllllllllIIIIIIlIlllIl;
            lllllllllllllllllllIIIIIIlIlllII.targetName = lllllllllllllllllllIIIIIIlIlllIl.getTargetClassRef();
        }

        String getOriginalName() {
            InnerClassInfo lllllllllllllllllllIIIIIIlIlIIll;
            return lllllllllllllllllllIIIIIIlIlIIll.originalName;
        }

        public String toString() {
            InnerClassInfo lllllllllllllllllllIIIIIIIlIllII;
            return lllllllllllllllllllIIIIIIIlIllII.name;
        }

        public String mapMethodName(String lllllllllllllllllllIIIIIIIllIlll, String lllllllllllllllllllIIIIIIIlllIlI, String lllllllllllllllllllIIIIIIIllIlIl) {
            ClassInfo.Method lllllllllllllllllllIIIIIIIllllIl;
            InnerClassInfo lllllllllllllllllllIIIIIIIllllII;
            if (lllllllllllllllllllIIIIIIIllllII.ownerName.equalsIgnoreCase(lllllllllllllllllllIIIIIIIllIlll) && (lllllllllllllllllllIIIIIIIllllIl = lllllllllllllllllllIIIIIIIllllII.owner.getClassInfo().findMethod(lllllllllllllllllllIIIIIIIlllIlI, lllllllllllllllllllIIIIIIIllIlIl, 10)) != null) {
                return lllllllllllllllllllIIIIIIIllllIl.getName();
            }
            return super.mapMethodName(lllllllllllllllllllIIIIIIIllIlll, lllllllllllllllllllIIIIIIIlllIlI, lllllllllllllllllllIIIIIIIllIlIl);
        }

        MixinTargetContext getTarget() {
            InnerClassInfo lllllllllllllllllllIIIIIIlIIllII;
            return lllllllllllllllllllIIIIIIlIIllII.target;
        }

        byte[] getClassBytes() throws IOException, ClassNotFoundException {
            InnerClassInfo lllllllllllllllllllIIIIIIlIIIIll;
            return MixinService.getService().getBytecodeProvider().getClassBytes(lllllllllllllllllllIIIIIIlIIIIll.originalName, true);
        }

        String getName() {
            InnerClassInfo lllllllllllllllllllIIIIIIlIlIllI;
            return lllllllllllllllllllIIIIIIlIlIllI.name;
        }

        String getTargetName() {
            InnerClassInfo lllllllllllllllllllIIIIIIlIIIllI;
            return lllllllllllllllllllIIIIIIlIIIllI.targetName;
        }

        String getOwnerName() {
            InnerClassInfo lllllllllllllllllllIIIIIIlIIlIlI;
            return lllllllllllllllllllIIIIIIlIIlIlI.ownerName;
        }
    }

    static class InnerClassAdapter
    extends ClassRemapper {
        private final /* synthetic */ InnerClassInfo info;

        public InnerClassAdapter(ClassVisitor lIlllIlllIllIll, InnerClassInfo lIlllIlllIlIlll) {
            super(327680, lIlllIlllIllIll, lIlllIlllIlIlll);
            InnerClassAdapter lIlllIlllIlllII;
            lIlllIlllIlllII.info = lIlllIlllIlIlll;
        }

        @Override
        public void visitSource(String lIlllIlllIlIIIl, String lIlllIlllIIllII) {
            InnerClassAdapter lIlllIlllIlIIlI;
            super.visitSource(lIlllIlllIlIIIl, lIlllIlllIIllII);
            AnnotationVisitor lIlllIlllIIllll = lIlllIlllIlIIlI.cv.visitAnnotation("Lorg/spongepowered/asm/mixin/transformer/meta/MixinInner;", false);
            lIlllIlllIIllll.visit("mixin", lIlllIlllIlIIlI.info.getOwner().toString());
            lIlllIlllIIllll.visit("name", lIlllIlllIlIIlI.info.getOriginalName().substring(lIlllIlllIlIIlI.info.getOriginalName().lastIndexOf(47) + 1));
            lIlllIlllIIllll.visitEnd();
        }

        @Override
        public void visitInnerClass(String lIlllIllIllllll, String lIlllIlllIIIIll, String lIlllIllIllllIl, int lIlllIllIllllII) {
            InnerClassAdapter lIlllIlllIIIIII;
            if (lIlllIllIllllll.startsWith(String.valueOf(new StringBuilder().append(lIlllIlllIIIIII.info.getOriginalName()).append("$")))) {
                throw new InvalidMixinException((IMixinInfo)lIlllIlllIIIIII.info.getOwner(), String.valueOf(new StringBuilder().append("Found unsupported nested inner class ").append(lIlllIllIllllll).append(" in ").append(lIlllIlllIIIIII.info.getOriginalName())));
            }
            super.visitInnerClass(lIlllIllIllllll, lIlllIlllIIIIll, lIlllIllIllllIl, lIlllIllIllllII);
        }
    }
}

