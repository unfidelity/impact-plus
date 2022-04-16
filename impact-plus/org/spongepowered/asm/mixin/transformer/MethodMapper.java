/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.util.Counter;

public class MethodMapper {
    private final /* synthetic */ ClassInfo info;
    private static final /* synthetic */ List<String> classes;
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ Map<String, Counter> methods;

    private static String finagle(int lIIIIllIIlllIll) {
        String lIIIIllIIllllll = Integer.toHexString(lIIIIllIIlllIll);
        StringBuilder lIIIIllIIllllIl = new StringBuilder();
        for (int lIIIIllIlIIIlIl = 0; lIIIIllIlIIIlIl < lIIIIllIIllllll.length(); ++lIIIIllIlIIIlIl) {
            char lIIIIllIlIIIllI;
            lIIIIllIlIIIllI = (char)(lIIIIllIlIIIllI + ((lIIIIllIlIIIllI = lIIIIllIIllllll.charAt(lIIIIllIlIIIlIl)) < ':' ? 49 : 10));
            lIIIIllIIllllIl.append(lIIIIllIlIIIllI);
        }
        return Strings.padStart((String)String.valueOf(lIIIIllIIllllIl), (int)3, (char)'z');
    }

    public void remapHandlerMethod(MixinInfo lIIIIllllllIlII, MethodNode lIIIIllllllIIll, ClassInfo.Method lIIIIllllllIIIl) {
        MethodMapper lIIIIlllllIlllI;
        if (!(lIIIIllllllIIll instanceof MixinInfo.MixinMethodNode) || !((MixinInfo.MixinMethodNode)lIIIIllllllIIll).isInjector()) {
            return;
        }
        if (lIIIIllllllIIIl.isUnique()) {
            logger.warn("Redundant @Unique on injector method {} in {}. Injectors are implicitly unique", new Object[]{lIIIIllllllIIIl, lIIIIllllllIlII});
        }
        if (lIIIIllllllIIIl.isRenamed()) {
            lIIIIllllllIIll.name = lIIIIllllllIIIl.getName();
            return;
        }
        String lIIIIllllllIIII = lIIIIlllllIlllI.getHandlerName((MixinInfo.MixinMethodNode)lIIIIllllllIIll);
        lIIIIllllllIIll.name = lIIIIllllllIIIl.renameTo(lIIIIllllllIIII);
    }

    private static String getMethodUID(String lIIIIllIlIllIlI, String lIIIIllIlIlIlII, boolean lIIIIllIlIlIIll) {
        String lIIIIllIlIlIlll = String.format("%s%s", lIIIIllIlIllIlI, lIIIIllIlIlIlII);
        Counter lIIIIllIlIlIllI = methods.get(lIIIIllIlIlIlll);
        if (lIIIIllIlIlIllI == null) {
            lIIIIllIlIlIllI = new Counter();
            methods.put(lIIIIllIlIlIlll, lIIIIllIlIlIllI);
        } else if (lIIIIllIlIlIIll) {
            ++lIIIIllIlIlIllI.value;
        }
        return String.format("%03x", lIIIIllIlIlIllI.value);
    }

    public MethodMapper(MixinEnvironment lIIIlIIIIIIIIlI, ClassInfo lIIIIllllllllll) {
        MethodMapper lIIIlIIIIIIIIII;
        lIIIlIIIIIIIIII.info = lIIIIllllllllll;
    }

    private static String getClassUID(String lIIIIlllIIIllll) {
        int lIIIIlllIIIllIl = classes.indexOf(lIIIIlllIIIllll);
        if (lIIIIlllIIIllIl < 0) {
            lIIIIlllIIIllIl = classes.size();
            classes.add(lIIIIlllIIIllll);
        }
        return MethodMapper.finagle(lIIIIlllIIIllIl);
    }

    public ClassInfo getClassInfo() {
        MethodMapper lIIIIllllllllII;
        return lIIIIllllllllII.info;
    }

    public String getHandlerName(MixinInfo.MixinMethodNode lIIIIlllIlIIIlI) {
        String lIIIIlllIlIlIll = InjectionInfo.getInjectorPrefix(lIIIIlllIlIIIlI.getInjectorAnnotation());
        String lIIIIlllIlIlIII = MethodMapper.getClassUID(lIIIIlllIlIIIlI.getOwner().getClassRef());
        String lIIIIlllIlIIlIl = MethodMapper.getMethodUID(lIIIIlllIlIIIlI.name, lIIIIlllIlIIIlI.desc, !lIIIIlllIlIIIlI.isSurrogate());
        return String.format("%s$%s$%s%s", lIIIIlllIlIlIll, lIIIIlllIlIIIlI.name, lIIIIlllIlIlIII, lIIIIlllIlIIlIl);
    }

    static {
        logger = LogManager.getLogger((String)"mixin");
        classes = new ArrayList<String>();
        methods = new HashMap<String, Counter>();
    }
}

