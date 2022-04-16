/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Charsets
 *  com.google.common.collect.ImmutableMap
 *  com.google.common.io.Files
 *  org.apache.commons.io.FileUtils
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.jetbrains.java.decompiler.main.Fernflower
 *  org.jetbrains.java.decompiler.main.extern.IBytecodeProvider
 *  org.jetbrains.java.decompiler.main.extern.IFernflowerLogger
 *  org.jetbrains.java.decompiler.main.extern.IFernflowerLogger$Severity
 *  org.jetbrains.java.decompiler.main.extern.IResultSaver
 *  org.jetbrains.java.decompiler.util.InterpreterUtil
 */
package org.spongepowered.asm.mixin.transformer.debug;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.jar.Manifest;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.java.decompiler.main.Fernflower;
import org.jetbrains.java.decompiler.main.extern.IBytecodeProvider;
import org.jetbrains.java.decompiler.main.extern.IFernflowerLogger;
import org.jetbrains.java.decompiler.main.extern.IResultSaver;
import org.jetbrains.java.decompiler.util.InterpreterUtil;
import org.spongepowered.asm.mixin.transformer.ext.IDecompiler;

public class RuntimeDecompiler
extends IFernflowerLogger
implements IResultSaver,
IDecompiler {
    private final /* synthetic */ File outputPath;
    private static final /* synthetic */ Level[] SEVERITY_LEVELS;
    protected final /* synthetic */ Logger logger;
    private final /* synthetic */ Map<String, Object> options;

    public void writeMessage(String llllllllllllllllIIllllllIIlIIIIl, Throwable llllllllllllllllIIllllllIIIlllIl) {
        RuntimeDecompiler llllllllllllllllIIllllllIIlIIIlI;
        llllllllllllllllIIllllllIIlIIIlI.logger.warn("{} {}: {}", new Object[]{llllllllllllllllIIllllllIIlIIIIl, llllllllllllllllIIllllllIIIlllIl.getClass().getSimpleName(), llllllllllllllllIIllllllIIIlllIl.getMessage()});
    }

    public void saveClassEntry(String llllllllllllllllIIlllllIlllllllI, String llllllllllllllllIIlllllIllllllIl, String llllllllllllllllIIlllllIllllllII, String llllllllllllllllIIlllllIlllllIll, String llllllllllllllllIIlllllIlllllIlI) {
    }

    public void saveDirEntry(String llllllllllllllllIIllllllIIIIIlll, String llllllllllllllllIIllllllIIIIIllI, String llllllllllllllllIIllllllIIIIIlIl) {
    }

    public RuntimeDecompiler(File llllllllllllllllIIllllllIlIlIlII) {
        RuntimeDecompiler llllllllllllllllIIllllllIlIlIlll;
        llllllllllllllllIIllllllIlIlIlll.options = ImmutableMap.builder().put((Object)"din", (Object)"0").put((Object)"rbr", (Object)"0").put((Object)"dgs", (Object)"1").put((Object)"asc", (Object)"1").put((Object)"den", (Object)"1").put((Object)"hdc", (Object)"1").put((Object)"ind", (Object)"    ").build();
        llllllllllllllllIIllllllIlIlIlll.logger = LogManager.getLogger((String)"fernflower");
        llllllllllllllllIIllllllIlIlIlll.outputPath = llllllllllllllllIIllllllIlIlIlII;
        if (llllllllllllllllIIllllllIlIlIlll.outputPath.exists()) {
            try {
                FileUtils.deleteDirectory((File)llllllllllllllllIIllllllIlIlIlll.outputPath);
            }
            catch (IOException llllllllllllllllIIllllllIlIllIII) {
                llllllllllllllllIIllllllIlIlIlll.logger.warn("Error cleaning output directory: {}", new Object[]{llllllllllllllllIIllllllIlIllIII.getMessage()});
            }
        }
    }

    public void saveClassFile(String llllllllllllllllIIllllllIIllllll, String llllllllllllllllIIllllllIIlllllI, String llllllllllllllllIIllllllIIllllIl, String llllllllllllllllIIllllllIIllllII, int[] llllllllllllllllIIllllllIIlllIll) {
        RuntimeDecompiler llllllllllllllllIIllllllIlIIIIII;
        File llllllllllllllllIIllllllIIlllIlI = new File(llllllllllllllllIIllllllIlIIIIII.outputPath, String.valueOf(new StringBuilder().append(llllllllllllllllIIllllllIIlllllI).append(".java")));
        llllllllllllllllIIllllllIIlllIlI.getParentFile().mkdirs();
        try {
            llllllllllllllllIIllllllIlIIIIII.logger.info("Writing {}", new Object[]{llllllllllllllllIIllllllIIlllIlI.getAbsolutePath()});
            Files.write((CharSequence)llllllllllllllllIIllllllIIllllII, (File)llllllllllllllllIIllllllIIlllIlI, (Charset)Charsets.UTF_8);
        }
        catch (IOException llllllllllllllllIIllllllIlIIIIIl) {
            llllllllllllllllIIllllllIlIIIIII.writeMessage(String.valueOf(new StringBuilder().append("Cannot write source file ").append(llllllllllllllllIIllllllIIlllIlI)), llllllllllllllllIIllllllIlIIIIIl);
        }
    }

    public void copyFile(String llllllllllllllllIIllllllIIIIllll, String llllllllllllllllIIllllllIIIIlllI, String llllllllllllllllIIllllllIIIIllIl) {
    }

    public void writeMessage(String llllllllllllllllIIllllllIIIlIIll, IFernflowerLogger.Severity llllllllllllllllIIllllllIIIlIIlI, Throwable llllllllllllllllIIllllllIIIlIlIl) {
        RuntimeDecompiler llllllllllllllllIIllllllIIIlIlII;
        llllllllllllllllIIllllllIIIlIlII.logger.log(SEVERITY_LEVELS[llllllllllllllllIIllllllIIIlIIlI.ordinal()], llllllllllllllllIIllllllIIIlIIll, llllllllllllllllIIllllllIIIlIlIl);
    }

    public void saveFolder(String llllllllllllllllIIllllllIlIIIlll) {
    }

    @Override
    public void decompile(File llllllllllllllllIIllllllIlIIlIlI) {
        RuntimeDecompiler llllllllllllllllIIllllllIlIIlIll;
        try {
            Fernflower llllllllllllllllIIllllllIlIIllll = new Fernflower(new IBytecodeProvider(){
                private /* synthetic */ byte[] byteCode;

                public byte[] getBytecode(String llIllllIlllllII, String llIllllIllllIll) throws IOException {
                    1 llIllllIllllIlI;
                    if (llIllllIllllIlI.byteCode == null) {
                        llIllllIllllIlI.byteCode = InterpreterUtil.getBytes((File)new File(llIllllIlllllII));
                    }
                    return llIllllIllllIlI.byteCode;
                }
                {
                    1 llIlllllIIIIIIl;
                }
            }, (IResultSaver)llllllllllllllllIIllllllIlIIlIll, llllllllllllllllIIllllllIlIIlIll.options, (IFernflowerLogger)llllllllllllllllIIllllllIlIIlIll);
            llllllllllllllllIIllllllIlIIllll.getStructContext().addSpace(llllllllllllllllIIllllllIlIIlIlI, true);
            llllllllllllllllIIllllllIlIIllll.decompileContext();
        }
        catch (Throwable llllllllllllllllIIllllllIlIIlllI) {
            llllllllllllllllIIllllllIlIIlIll.logger.warn("Decompilation error while processing {}", new Object[]{llllllllllllllllIIllllllIlIIlIlI.getName()});
        }
    }

    public void copyEntry(String llllllllllllllllIIllllllIIIIIIll, String llllllllllllllllIIllllllIIIIIIlI, String llllllllllllllllIIllllllIIIIIIIl, String llllllllllllllllIIllllllIIIIIIII) {
    }

    public void writeMessage(String llllllllllllllllIIllllllIIlIIlll, IFernflowerLogger.Severity llllllllllllllllIIllllllIIlIlIIl) {
        RuntimeDecompiler llllllllllllllllIIllllllIIlIlIll;
        llllllllllllllllIIllllllIIlIlIll.logger.log(SEVERITY_LEVELS[llllllllllllllllIIllllllIIlIlIIl.ordinal()], llllllllllllllllIIllllllIIlIIlll);
    }

    public void closeArchive(String llllllllllllllllIIlllllIlllllIII, String llllllllllllllllIIlllllIllllIlll) {
    }

    public void createArchive(String llllllllllllllllIIllllllIIIIlIll, String llllllllllllllllIIllllllIIIIlIlI, Manifest llllllllllllllllIIllllllIIIIlIIl) {
    }

    static {
        SEVERITY_LEVELS = new Level[]{Level.TRACE, Level.INFO, Level.WARN, Level.ERROR};
    }

    public void startReadingClass(String llllllllllllllllIIllllllIIlIllll) {
        RuntimeDecompiler llllllllllllllllIIllllllIIllIIlI;
        llllllllllllllllIIllllllIIllIIlI.logger.info("Decompiling {}", new Object[]{llllllllllllllllIIllllllIIlIllll});
    }
}

