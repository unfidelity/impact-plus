/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.tools.agent;

import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.transformer.MixinTransformer;
import org.spongepowered.asm.mixin.transformer.ext.IHotSwap;
import org.spongepowered.asm.mixin.transformer.throwables.MixinReloadException;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.tools.agent.MixinAgentClassLoader;

public class MixinAgent
implements IHotSwap {
    static /* synthetic */ Instrumentation instrumentation;
    private static /* synthetic */ List<MixinAgent> agents;
    static final /* synthetic */ MixinAgentClassLoader classLoader;
    final /* synthetic */ MixinTransformer classTransformer;
    static final /* synthetic */ Logger logger;
    public static final /* synthetic */ byte[] ERROR_BYTECODE;

    public static void init(Instrumentation llllIlllIlIIIlI) {
        instrumentation = llllIlllIlIIIlI;
        if (!instrumentation.isRedefineClassesSupported()) {
            logger.error("The instrumentation doesn't support re-definition of classes");
        }
        for (MixinAgent llllIlllIlIIlII : agents) {
            llllIlllIlIIlII.initTransformer();
        }
    }

    static {
        ERROR_BYTECODE = new byte[]{1};
        classLoader = new MixinAgentClassLoader();
        logger = LogManager.getLogger((String)"mixin.agent");
        instrumentation = null;
        agents = new ArrayList<MixinAgent>();
    }

    public static void premain(String llllIlllIIllllI, Instrumentation llllIlllIIlllII) {
        System.setProperty("mixin.hotSwap", "true");
        MixinAgent.init(llllIlllIIlllII);
    }

    @Override
    public void registerMixinClass(String llllIlllIllIIII) {
        classLoader.addMixinClass(llllIlllIllIIII);
    }

    @Override
    public void registerTargetClass(String llllIlllIlIlIll, byte[] llllIlllIlIlIlI) {
        classLoader.addTargetClass(llllIlllIlIlIll, llllIlllIlIlIlI);
    }

    public static void agentmain(String llllIlllIIllIlI, Instrumentation llllIlllIIllIII) {
        MixinAgent.init(llllIlllIIllIII);
    }

    public MixinAgent(MixinTransformer llllIlllIllIllI) {
        MixinAgent llllIlllIlllIIl;
        llllIlllIlllIIl.classTransformer = llllIlllIllIllI;
        agents.add(llllIlllIlllIIl);
        if (instrumentation != null) {
            llllIlllIlllIIl.initTransformer();
        }
    }

    private void initTransformer() {
        MixinAgent llllIlllIllIIll;
        instrumentation.addTransformer(llllIlllIllIIll.new Transformer(), true);
    }

    class Transformer
    implements ClassFileTransformer {
        private boolean reApplyMixins(List<String> lllllllllllllllllIllIlIIIlIlIllI) {
            IMixinService lllllllllllllllllIllIlIIIlIllIlI = MixinService.getService();
            for (String lllllllllllllllllIllIlIIIllIIIIl : lllllllllllllllllIllIlIIIlIlIllI) {
                String lllllllllllllllllIllIlIIIllIIlII = lllllllllllllllllIllIlIIIllIIIIl.replace('/', '.');
                logger.debug("Re-transforming target class {}", new Object[]{lllllllllllllllllIllIlIIIllIIIIl});
                try {
                    Transformer lllllllllllllllllIllIlIIIlIllIII;
                    Class<?> lllllllllllllllllIllIlIIIllIlIIl = lllllllllllllllllIllIlIIIlIllIlI.getClassProvider().findClass(lllllllllllllllllIllIlIIIllIIlII);
                    byte[] lllllllllllllllllIllIlIIIllIIlll = classLoader.getOriginalTargetBytecode(lllllllllllllllllIllIlIIIllIIlII);
                    if (lllllllllllllllllIllIlIIIllIIlll == null) {
                        logger.error("Target class {} bytecode is not registered", new Object[]{lllllllllllllllllIllIlIIIllIIlII});
                        return false;
                    }
                    lllllllllllllllllIllIlIIIllIIlll = lllllllllllllllllIllIlIIIlIllIII.MixinAgent.this.classTransformer.transformClassBytes(null, lllllllllllllllllIllIlIIIllIIlII, lllllllllllllllllIllIlIIIllIIlll);
                    instrumentation.redefineClasses(new ClassDefinition(lllllllllllllllllIllIlIIIllIlIIl, lllllllllllllllllIllIlIIIllIIlll));
                }
                catch (Throwable lllllllllllllllllIllIlIIIllIIllI) {
                    logger.error(String.valueOf(new StringBuilder().append("Error while re-transforming target class ").append(lllllllllllllllllIllIlIIIllIIIIl)), lllllllllllllllllIllIlIIIllIIllI);
                    return false;
                }
            }
            return true;
        }

        Transformer() {
            Transformer lllllllllllllllllIllIlIIlllIllII;
        }

        private List<String> reloadMixin(String lllllllllllllllllIllIlIIlIIlIllI, byte[] lllllllllllllllllIllIlIIlIIllIlI) {
            logger.info("Redefining mixin {}", new Object[]{lllllllllllllllllIllIlIIlIIlIllI});
            try {
                Transformer lllllllllllllllllIllIlIIlIIlllIl;
                return lllllllllllllllllIllIlIIlIIlllIl.MixinAgent.this.classTransformer.reload(lllllllllllllllllIllIlIIlIIlIllI.replace('/', '.'), lllllllllllllllllIllIlIIlIIllIlI);
            }
            catch (MixinReloadException lllllllllllllllllIllIlIIlIlIIIlI) {
                logger.error("Mixin {} cannot be reloaded, needs a restart to be applied: {} ", new Object[]{lllllllllllllllllIllIlIIlIlIIIlI.getMixinInfo(), lllllllllllllllllIllIlIIlIlIIIlI.getMessage()});
            }
            catch (Throwable lllllllllllllllllIllIlIIlIIlllll) {
                logger.error(String.valueOf(new StringBuilder().append("Error while finding targets for mixin ").append(lllllllllllllllllIllIlIIlIIlIllI)), lllllllllllllllllIllIlIIlIIlllll);
            }
            return null;
        }

        @Override
        public byte[] transform(ClassLoader lllllllllllllllllIllIlIIllIlIIII, String lllllllllllllllllIllIlIIllIIIIll, Class<?> lllllllllllllllllIllIlIIllIIllIl, ProtectionDomain lllllllllllllllllIllIlIIllIIlIll, byte[] lllllllllllllllllIllIlIIllIIIIII) throws IllegalClassFormatException {
            Transformer lllllllllllllllllIllIlIIllIIIlIl;
            if (lllllllllllllllllIllIlIIllIIllIl == null) {
                return null;
            }
            byte[] lllllllllllllllllIllIlIIllIIIlll = classLoader.getFakeMixinBytecode(lllllllllllllllllIllIlIIllIIllIl);
            if (lllllllllllllllllIllIlIIllIIIlll != null) {
                List<String> lllllllllllllllllIllIlIIllIlIlIl = lllllllllllllllllIllIlIIllIIIlIl.reloadMixin(lllllllllllllllllIllIlIIllIIIIll, lllllllllllllllllIllIlIIllIIIIII);
                if (lllllllllllllllllIllIlIIllIlIlIl == null || !lllllllllllllllllIllIlIIllIIIlIl.reApplyMixins(lllllllllllllllllIllIlIIllIlIlIl)) {
                    return ERROR_BYTECODE;
                }
                return lllllllllllllllllIllIlIIllIIIlll;
            }
            try {
                logger.info(String.valueOf(new StringBuilder().append("Redefining class ").append(lllllllllllllllllIllIlIIllIIIIll)));
                return lllllllllllllllllIllIlIIllIIIlIl.MixinAgent.this.classTransformer.transformClassBytes(null, lllllllllllllllllIllIlIIllIIIIll, lllllllllllllllllIllIlIIllIIIIII);
            }
            catch (Throwable lllllllllllllllllIllIlIIllIlIIll) {
                logger.error(String.valueOf(new StringBuilder().append("Error while re-transforming class ").append(lllllllllllllllllIllIlIIllIIIIll)), lllllllllllllllllIllIlIIllIlIIll);
                return ERROR_BYTECODE;
            }
        }
    }
}

