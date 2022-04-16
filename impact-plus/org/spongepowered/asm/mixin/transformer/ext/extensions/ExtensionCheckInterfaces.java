/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Charsets
 *  com.google.common.collect.HashMultimap
 *  com.google.common.collect.Multimap
 *  com.google.common.io.Files
 *  org.apache.commons.io.IOUtils
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer.ext.extensions;

import com.google.common.base.Charsets;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.io.Files;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.ext.IExtension;
import org.spongepowered.asm.mixin.transformer.ext.ITargetClassContext;
import org.spongepowered.asm.util.Constants;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.SignaturePrinter;

public class ExtensionCheckInterfaces
implements IExtension {
    private /* synthetic */ boolean strict;
    private final /* synthetic */ Multimap<ClassInfo, ClassInfo.Method> interfaceMethods;
    private static final /* synthetic */ String IMPL_REPORT_FILENAME;
    private static final /* synthetic */ String AUDIT_DIR;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ File csv;
    private final /* synthetic */ File report;
    private static final /* synthetic */ String IMPL_REPORT_TXT_FILENAME;
    private static final /* synthetic */ String IMPL_REPORT_CSV_FILENAME;

    public ExtensionCheckInterfaces() {
        ExtensionCheckInterfaces llllllllllllllllIlIIIIllIllIIIIl;
        llllllllllllllllIlIIIIllIllIIIIl.interfaceMethods = HashMultimap.create();
        File llllllllllllllllIlIIIIllIllIIIlI = new File(Constants.DEBUG_OUTPUT_DIR, "audit");
        llllllllllllllllIlIIIIllIllIIIlI.mkdirs();
        llllllllllllllllIlIIIIllIllIIIIl.csv = new File(llllllllllllllllIlIIIIllIllIIIlI, "mixin_implementation_report.csv");
        llllllllllllllllIlIIIIllIllIIIIl.report = new File(llllllllllllllllIlIIIIllIllIIIlI, "mixin_implementation_report.txt");
        try {
            Files.write((CharSequence)"Class,Method,Signature,Interface\n", (File)llllllllllllllllIlIIIIllIllIIIIl.csv, (Charset)Charsets.ISO_8859_1);
        }
        catch (IOException llllllllllllllllIlIIIIllIlIlllll) {
            // empty catch block
        }
        try {
            String llllllllllllllllIlIIIIllIllIIlII = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            Files.write((CharSequence)String.valueOf(new StringBuilder().append("Mixin Implementation Report generated on ").append(llllllllllllllllIlIIIIllIllIIlII).append("\n")), (File)llllllllllllllllIlIIIIllIllIIIIl.report, (Charset)Charsets.ISO_8859_1);
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void appendToTextReport(PrettyPrinter llllllllllllllllIlIIIIllIIIIlIlI) {
        FileOutputStream llllllllllllllllIlIIIIllIIIIlIIl = null;
        try {
            ExtensionCheckInterfaces llllllllllllllllIlIIIIllIIIIlIll;
            llllllllllllllllIlIIIIllIIIIlIIl = new FileOutputStream(llllllllllllllllIlIIIIllIIIIlIll.report, true);
            PrintStream llllllllllllllllIlIIIIllIIIIllII = new PrintStream(llllllllllllllllIlIIIIllIIIIlIIl);
            llllllllllllllllIlIIIIllIIIIllII.print("\n");
            llllllllllllllllIlIIIIllIIIIlIlI.print(llllllllllllllllIlIIIIllIIIIllII);
        }
        catch (Exception exception) {
            IOUtils.closeQuietly(llllllllllllllllIlIIIIllIIIIlIIl);
        }
        catch (Throwable llllllllllllllllIlIIIIllIIIIIlII) {
            IOUtils.closeQuietly(llllllllllllllllIlIIIIllIIIIlIIl);
            throw llllllllllllllllIlIIIIllIIIIIlII;
        }
        IOUtils.closeQuietly((OutputStream)llllllllllllllllIlIIIIllIIIIlIIl);
    }

    @Override
    public boolean checkActive(MixinEnvironment llllllllllllllllIlIIIIllIlIllIIl) {
        llllllllllllllllIlIIIIllIlIllIlI.strict = llllllllllllllllIlIIIIllIlIllIIl.getOption(MixinEnvironment.Option.CHECK_IMPLEMENTS_STRICT);
        return llllllllllllllllIlIIIIllIlIllIIl.getOption(MixinEnvironment.Option.CHECK_IMPLEMENTS);
    }

    static {
        IMPL_REPORT_TXT_FILENAME = "mixin_implementation_report.txt";
        IMPL_REPORT_CSV_FILENAME = "mixin_implementation_report.csv";
        IMPL_REPORT_FILENAME = "mixin_implementation_report";
        AUDIT_DIR = "audit";
        logger = LogManager.getLogger((String)"mixin");
    }

    private void appendToCSVReport(String llllllllllllllllIlIIIIllIIIlIlIl, ClassInfo.Method llllllllllllllllIlIIIIllIIIllIII, String llllllllllllllllIlIIIIllIIIlIlll) {
        try {
            ExtensionCheckInterfaces llllllllllllllllIlIIIIllIIIllIlI;
            Files.append((CharSequence)String.format("%s,%s,%s,%s\n", llllllllllllllllIlIIIIllIIIlIlIl, llllllllllllllllIlIIIIllIIIllIII.getName(), llllllllllllllllIlIIIIllIIIllIII.getDesc(), llllllllllllllllIlIIIIllIIIlIlll), (File)llllllllllllllllIlIIIIllIIIllIlI.csv, (Charset)Charsets.ISO_8859_1);
        }
        catch (IOException llllllllllllllllIlIIIIllIIIlIIlI) {
            // empty catch block
        }
    }

    @Override
    public void postApply(ITargetClassContext llllllllllllllllIlIIIIllIIlllIII) {
        ExtensionCheckInterfaces llllllllllllllllIlIIIIllIIlllIIl;
        ClassInfo llllllllllllllllIlIIIIllIIllIlll = llllllllllllllllIlIIIIllIIlllIII.getClassInfo();
        if (llllllllllllllllIlIIIIllIIllIlll.isAbstract() && !llllllllllllllllIlIIIIllIIlllIIl.strict) {
            logger.info("{} is skipping abstract target {}", new Object[]{llllllllllllllllIlIIIIllIIlllIIl.getClass().getSimpleName(), llllllllllllllllIlIIIIllIIlllIII});
            return;
        }
        String llllllllllllllllIlIIIIllIIllIllI = llllllllllllllllIlIIIIllIIllIlll.getName().replace('/', '.');
        int llllllllllllllllIlIIIIllIIllIlIl = 0;
        PrettyPrinter llllllllllllllllIlIIIIllIIllIlII = new PrettyPrinter();
        llllllllllllllllIlIIIIllIIllIlII.add("Class: %s", llllllllllllllllIlIIIIllIIllIllI).hr();
        llllllllllllllllIlIIIIllIIllIlII.add("%-32s %-47s  %s", "Return Type", "Missing Method", "From Interface").hr();
        Set<ClassInfo.Method> llllllllllllllllIlIIIIllIIllIIll = llllllllllllllllIlIIIIllIIllIlll.getInterfaceMethods(true);
        HashSet<ClassInfo.Method> llllllllllllllllIlIIIIllIIllIIlI = new HashSet<ClassInfo.Method>(llllllllllllllllIlIIIIllIIllIlll.getSuperClass().getInterfaceMethods(true));
        llllllllllllllllIlIIIIllIIllIIlI.addAll(llllllllllllllllIlIIIIllIIlllIIl.interfaceMethods.removeAll((Object)llllllllllllllllIlIIIIllIIllIlll));
        for (ClassInfo.Method llllllllllllllllIlIIIIllIIlllIlI : llllllllllllllllIlIIIIllIIllIIll) {
            ClassInfo.Method llllllllllllllllIlIIIIllIIllllIl = llllllllllllllllIlIIIIllIIllIlll.findMethodInHierarchy(llllllllllllllllIlIIIIllIIlllIlI.getName(), llllllllllllllllIlIIIIllIIlllIlI.getDesc(), ClassInfo.SearchType.ALL_CLASSES, ClassInfo.Traversal.ALL);
            if (llllllllllllllllIlIIIIllIIllllIl != null && !llllllllllllllllIlIIIIllIIllllIl.isAbstract() || llllllllllllllllIlIIIIllIIllIIlI.contains(llllllllllllllllIlIIIIllIIlllIlI)) continue;
            if (llllllllllllllllIlIIIIllIIllIlIl > 0) {
                llllllllllllllllIlIIIIllIIllIlII.add();
            }
            SignaturePrinter llllllllllllllllIlIIIIllIIllllII = new SignaturePrinter(llllllllllllllllIlIIIIllIIlllIlI.getName(), llllllllllllllllIlIIIIllIIlllIlI.getDesc()).setModifiers("");
            String llllllllllllllllIlIIIIllIIlllIll = llllllllllllllllIlIIIIllIIlllIlI.getOwner().getName().replace('/', '.');
            ++llllllllllllllllIlIIIIllIIllIlIl;
            llllllllllllllllIlIIIIllIIllIlII.add("%-32s%s", llllllllllllllllIlIIIIllIIllllII.getReturnType(), llllllllllllllllIlIIIIllIIllllII);
            llllllllllllllllIlIIIIllIIllIlII.add("%-80s  %s", "", llllllllllllllllIlIIIIllIIlllIll);
            llllllllllllllllIlIIIIllIIlllIIl.appendToCSVReport(llllllllllllllllIlIIIIllIIllIllI, llllllllllllllllIlIIIIllIIlllIlI, llllllllllllllllIlIIIIllIIlllIll);
        }
        if (llllllllllllllllIlIIIIllIIllIlIl > 0) {
            llllllllllllllllIlIIIIllIIllIlII.hr().add("%82s%s: %d", "", "Total unimplemented", llllllllllllllllIlIIIIllIIllIlIl);
            llllllllllllllllIlIIIIllIIllIlII.print(System.err);
            llllllllllllllllIlIIIIllIIlllIIl.appendToTextReport(llllllllllllllllIlIIIIllIIllIlII);
        }
    }

    @Override
    public void export(MixinEnvironment llllllllllllllllIlIIIIllIIlIIIll, String llllllllllllllllIlIIIIllIIlIIIlI, boolean llllllllllllllllIlIIIIllIIlIIIIl, byte[] llllllllllllllllIlIIIIllIIlIIIII) {
    }

    @Override
    public void preApply(ITargetClassContext llllllllllllllllIlIIIIllIlIIlllI) {
        ClassInfo llllllllllllllllIlIIIIllIlIlIIII = llllllllllllllllIlIIIIllIlIIlllI.getClassInfo();
        for (ClassInfo.Method llllllllllllllllIlIIIIllIlIlIIll : llllllllllllllllIlIIIIllIlIlIIII.getInterfaceMethods(false)) {
            ExtensionCheckInterfaces llllllllllllllllIlIIIIllIlIlIIlI;
            llllllllllllllllIlIIIIllIlIlIIlI.interfaceMethods.put((Object)llllllllllllllllIlIIIIllIlIlIIII, (Object)llllllllllllllllIlIIIIllIlIlIIll);
        }
    }
}

