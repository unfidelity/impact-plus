/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.util;

import com.google.common.base.Strings;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrettyPrinter {
    private final /* synthetic */ List<Object> lines;
    protected /* synthetic */ String kvFormat;
    protected /* synthetic */ int width;
    private final /* synthetic */ HorizontalRule horizontalRule;
    protected /* synthetic */ int kvKeyWidth;
    protected /* synthetic */ int wrapWidth;
    private /* synthetic */ Table table;
    private /* synthetic */ boolean recalcWidth;

    public PrettyPrinter kv(String lllllllllllllllllIIIlllIlIllllII, String lllllllllllllllllIIIlllIlIlllIll, Object ... lllllllllllllllllIIIlllIlIlllIlI) {
        PrettyPrinter lllllllllllllllllIIIlllIlIlllIIl;
        return lllllllllllllllllIIIlllIlIlllIIl.kv(lllllllllllllllllIIIlllIlIllllII, String.format(lllllllllllllllllIIIlllIlIlllIll, lllllllllllllllllIIIlllIlIlllIlI));
    }

    public PrettyPrinter trace(PrintStream lllllllllllllllllIIIlllIIIllIIIl, Logger lllllllllllllllllIIIlllIIIllIIII) {
        PrettyPrinter lllllllllllllllllIIIlllIIIllIIlI;
        return lllllllllllllllllIIIlllIIIllIIlI.trace(lllllllllllllllllIIIlllIIIllIIIl, lllllllllllllllllIIIlllIIIllIIII, Level.DEBUG);
    }

    private void printSpecial(PrintStream lllllllllllllllllIIIlllIIIIIllll, ISpecialEntry lllllllllllllllllIIIlllIIIIIlllI) {
        lllllllllllllllllIIIlllIIIIIllll.printf("/*%s*/\n", lllllllllllllllllIIIlllIIIIIlllI.toString());
    }

    public PrettyPrinter log(Logger lllllllllllllllllIIIllIlllllllII) {
        PrettyPrinter lllllllllllllllllIIIllIllllllIll;
        return lllllllllllllllllIIIllIllllllIll.log(lllllllllllllllllIIIllIlllllllII, Level.INFO);
    }

    public PrettyPrinter spacing(int lllllllllllllllllIIIlllllIIllIIl) {
        PrettyPrinter lllllllllllllllllIIIlllllIIllIII;
        if (lllllllllllllllllIIIlllllIIllIII.table == null) {
            lllllllllllllllllIIIlllllIIllIII.table = new Table();
        }
        lllllllllllllllllIIIlllllIIllIII.table.setColSpacing(lllllllllllllllllIIIlllllIIllIIl);
        return lllllllllllllllllIIIlllllIIllIII;
    }

    public PrettyPrinter trace(Logger lllllllllllllllllIIIlllIIllIlIII) {
        PrettyPrinter lllllllllllllllllIIIlllIIllIlIIl;
        return lllllllllllllllllIIIlllIIllIlIIl.trace(System.err, lllllllllllllllllIIIlllIIllIlIII);
    }

    public PrettyPrinter log(Logger lllllllllllllllllIIIllIlllIlIlll, Level lllllllllllllllllIIIllIlllIlIlIl) {
        PrettyPrinter lllllllllllllllllIIIllIlllIllIII;
        lllllllllllllllllIIIllIlllIllIII.updateWidth();
        lllllllllllllllllIIIllIlllIllIII.logSpecial(lllllllllllllllllIIIllIlllIlIlll, lllllllllllllllllIIIllIlllIlIlIl, lllllllllllllllllIIIllIlllIllIII.horizontalRule);
        for (Object lllllllllllllllllIIIllIlllIllIlI : lllllllllllllllllIIIllIlllIllIII.lines) {
            if (lllllllllllllllllIIIllIlllIllIlI instanceof ISpecialEntry) {
                lllllllllllllllllIIIllIlllIllIII.logSpecial(lllllllllllllllllIIIllIlllIlIlll, lllllllllllllllllIIIllIlllIlIlIl, (ISpecialEntry)lllllllllllllllllIIIllIlllIllIlI);
                continue;
            }
            lllllllllllllllllIIIllIlllIllIII.logString(lllllllllllllllllIIIllIlllIlIlll, lllllllllllllllllIIIllIlllIlIlIl, lllllllllllllllllIIIllIlllIllIlI.toString());
        }
        lllllllllllllllllIIIllIlllIllIII.logSpecial(lllllllllllllllllIIIllIlllIlIlll, lllllllllllllllllIIIllIlllIlIlIl, lllllllllllllllllIIIllIlllIllIII.horizontalRule);
        return lllllllllllllllllIIIllIlllIllIII;
    }

    public PrettyPrinter table(Object ... lllllllllllllllllIIIlllllIlIIllI) {
        PrettyPrinter lllllllllllllllllIIIlllllIlIIlII;
        lllllllllllllllllIIIlllllIlIIlII.table = new Table();
        Column lllllllllllllllllIIIlllllIlIIlIl = null;
        for (Object lllllllllllllllllIIIlllllIlIlIII : lllllllllllllllllIIIlllllIlIIllI) {
            if (lllllllllllllllllIIIlllllIlIlIII instanceof String) {
                lllllllllllllllllIIIlllllIlIIlIl = lllllllllllllllllIIIlllllIlIIlII.table.addColumn((String)lllllllllllllllllIIIlllllIlIlIII);
                continue;
            }
            if (lllllllllllllllllIIIlllllIlIlIII instanceof Integer && lllllllllllllllllIIIlllllIlIIlIl != null) {
                int lllllllllllllllllIIIlllllIlIlIIl = (Integer)lllllllllllllllllIIIlllllIlIlIII;
                if (lllllllllllllllllIIIlllllIlIlIIl > 0) {
                    lllllllllllllllllIIIlllllIlIIlIl.setWidth(lllllllllllllllllIIIlllllIlIlIIl);
                    continue;
                }
                if (lllllllllllllllllIIIlllllIlIlIIl >= 0) continue;
                lllllllllllllllllIIIlllllIlIIlIl.setMaxWidth(-lllllllllllllllllIIIlllllIlIlIIl);
                continue;
            }
            if (lllllllllllllllllIIIlllllIlIlIII instanceof Alignment && lllllllllllllllllIIIlllllIlIIlIl != null) {
                lllllllllllllllllIIIlllllIlIIlIl.setAlignment((Alignment)((Object)lllllllllllllllllIIIlllllIlIlIII));
                continue;
            }
            if (lllllllllllllllllIIIlllllIlIlIII == null) continue;
            lllllllllllllllllIIIlllllIlIIlIl = lllllllllllllllllIIIlllllIlIIlII.table.addColumn(lllllllllllllllllIIIlllllIlIlIII.toString());
        }
        return lllllllllllllllllIIIlllllIlIIlII;
    }

    public PrettyPrinter trace(PrintStream lllllllllllllllllIIIlllIIlIllIIl) {
        PrettyPrinter lllllllllllllllllIIIlllIIlIllIlI;
        return lllllllllllllllllIIIlllIIlIllIlI.trace(lllllllllllllllllIIIlllIIlIllIIl, PrettyPrinter.getDefaultLoggerName());
    }

    public PrettyPrinter kvWidth(int lllllllllllllllllIIIlllIlIlIIlll) {
        PrettyPrinter lllllllllllllllllIIIlllIlIlIlIII;
        if (lllllllllllllllllIIIlllIlIlIIlll > lllllllllllllllllIIIlllIlIlIlIII.kvKeyWidth) {
            lllllllllllllllllIIIlllIlIlIlIII.kvKeyWidth = lllllllllllllllllIIIlllIlIlIIlll;
            lllllllllllllllllIIIlllIlIlIlIII.kvFormat = PrettyPrinter.makeKvFormat(lllllllllllllllllIIIlllIlIlIIlll);
        }
        lllllllllllllllllIIIlllIlIlIlIII.recalcWidth = true;
        return lllllllllllllllllIIIlllIlIlIlIII;
    }

    public PrettyPrinter add(String lllllllllllllllllIIIllllIlllIlIl, Object ... lllllllllllllllllIIIllllIllllIII) {
        PrettyPrinter lllllllllllllllllIIIllllIlllIllI;
        String lllllllllllllllllIIIllllIlllIlll = String.format(lllllllllllllllllIIIllllIlllIlIl, lllllllllllllllllIIIllllIllllIII);
        lllllllllllllllllIIIllllIlllIllI.addLine(lllllllllllllllllIIIllllIlllIlll);
        lllllllllllllllllIIIllllIlllIllI.width = Math.max(lllllllllllllllllIIIllllIlllIllI.width, lllllllllllllllllIIIllllIlllIlll.length());
        return lllllllllllllllllIIIllllIlllIllI;
    }

    public PrettyPrinter add(Object[] lllllllllllllllllIIIllllIllIIIII, String lllllllllllllllllIIIllllIlIlllll) {
        PrettyPrinter lllllllllllllllllIIIllllIllIIlII;
        for (Object lllllllllllllllllIIIllllIllIIlIl : lllllllllllllllllIIIllllIllIIIII) {
            lllllllllllllllllIIIllllIllIIlII.add(lllllllllllllllllIIIllllIlIlllll, lllllllllllllllllIIIllllIllIIlIl);
        }
        return lllllllllllllllllIIIllllIllIIlII;
    }

    public PrettyPrinter add(Object lllllllllllllllllIIIllllIIIlIllI) {
        PrettyPrinter lllllllllllllllllIIIllllIIIllIIl;
        return lllllllllllllllllIIIllllIIIllIIl.add(lllllllllllllllllIIIllllIIIlIllI, 0);
    }

    public PrettyPrinter tr(Object ... lllllllllllllllllIIIlllllIIIlIII) {
        PrettyPrinter lllllllllllllllllIIIlllllIIIlIll;
        lllllllllllllllllIIIlllllIIIlIll.th(true);
        lllllllllllllllllIIIlllllIIIlIll.addLine(lllllllllllllllllIIIlllllIIIlIll.table.addRow(lllllllllllllllllIIIlllllIIIlIII));
        lllllllllllllllllIIIlllllIIIlIll.recalcWidth = true;
        return lllllllllllllllllIIIlllllIIIlIll;
    }

    public PrettyPrinter th() {
        PrettyPrinter lllllllllllllllllIIIlllllIIlIlII;
        return lllllllllllllllllIIIlllllIIlIlII.th(false);
    }

    public static void dumpStack() {
        new PrettyPrinter().add(new Exception("Stack trace")).print(System.err);
    }

    public PrettyPrinter addWrapped(int lllllllllllllllllIIIlllIllIlllII, String lllllllllllllllllIIIlllIllIllIll, Object ... lllllllllllllllllIIIlllIllIllIlI) {
        PrettyPrinter lllllllllllllllllIIIlllIlllIIlII;
        String lllllllllllllllllIIIlllIlllIIIII = "";
        String lllllllllllllllllIIIlllIllIlllll = String.format(lllllllllllllllllIIIlllIllIllIll, lllllllllllllllllIIIlllIllIllIlI).replace("\t", "    ");
        Matcher lllllllllllllllllIIIlllIllIllllI = Pattern.compile("^(\\s+)(.*)$").matcher(lllllllllllllllllIIIlllIllIlllll);
        if (lllllllllllllllllIIIlllIllIllllI.matches()) {
            lllllllllllllllllIIIlllIlllIIIII = lllllllllllllllllIIIlllIllIllllI.group(1);
        }
        try {
            for (String lllllllllllllllllIIIlllIlllIIllI : lllllllllllllllllIIIlllIlllIIlII.getWrapped(lllllllllllllllllIIIlllIllIlllII, lllllllllllllllllIIIlllIllIlllll, lllllllllllllllllIIIlllIlllIIIII)) {
                lllllllllllllllllIIIlllIlllIIlII.addLine(lllllllllllllllllIIIlllIlllIIllI);
            }
        }
        catch (Exception lllllllllllllllllIIIlllIlllIIlIl) {
            lllllllllllllllllIIIlllIlllIIlII.add(lllllllllllllllllIIIlllIllIlllll);
        }
        return lllllllllllllllllIIIlllIlllIIlII;
    }

    private void updateWidth() {
        PrettyPrinter lllllllllllllllllIIIllIllIIlllll;
        if (lllllllllllllllllIIIllIllIIlllll.recalcWidth) {
            lllllllllllllllllIIIllIllIIlllll.recalcWidth = false;
            for (Object lllllllllllllllllIIIllIllIlIIIll : lllllllllllllllllIIIllIllIIlllll.lines) {
                if (!(lllllllllllllllllIIIllIllIlIIIll instanceof IVariableWidthEntry)) continue;
                lllllllllllllllllIIIllIllIIlllll.width = Math.min(4096, Math.max(lllllllllllllllllIIIllIllIIlllll.width, ((IVariableWidthEntry)lllllllllllllllllIIIllIllIlIIIll).getWidth()));
            }
        }
    }

    public static void print(Throwable lllllllllllllllllIIIllIlIllllIll) {
        new PrettyPrinter().add(lllllllllllllllllIIIllIlIllllIll).print(System.err);
    }

    private PrettyPrinter append(Object lllllllllllllllllIIIllllIIIIIIIl, int lllllllllllllllllIIIlllIllllllII, String lllllllllllllllllIIIlllIlllllIll) {
        PrettyPrinter lllllllllllllllllIIIlllIlllllllI;
        if (lllllllllllllllllIIIllllIIIIIIIl instanceof String) {
            return lllllllllllllllllIIIlllIlllllllI.add("%s%s", lllllllllllllllllIIIlllIlllllIll, lllllllllllllllllIIIllllIIIIIIIl);
        }
        if (lllllllllllllllllIIIllllIIIIIIIl instanceof Iterable) {
            for (Object lllllllllllllllllIIIllllIIIIIIll : (Iterable)lllllllllllllllllIIIllllIIIIIIIl) {
                lllllllllllllllllIIIlllIlllllllI.append(lllllllllllllllllIIIllllIIIIIIll, lllllllllllllllllIIIlllIllllllII, lllllllllllllllllIIIlllIlllllIll);
            }
            return lllllllllllllllllIIIlllIlllllllI;
        }
        if (lllllllllllllllllIIIllllIIIIIIIl instanceof Map) {
            lllllllllllllllllIIIlllIlllllllI.kvWidth(lllllllllllllllllIIIlllIllllllII);
            return lllllllllllllllllIIIlllIlllllllI.add((Map)lllllllllllllllllIIIllllIIIIIIIl);
        }
        if (lllllllllllllllllIIIllllIIIIIIIl instanceof IPrettyPrintable) {
            return lllllllllllllllllIIIlllIlllllllI.add((IPrettyPrintable)lllllllllllllllllIIIllllIIIIIIIl);
        }
        if (lllllllllllllllllIIIllllIIIIIIIl instanceof Throwable) {
            return lllllllllllllllllIIIlllIlllllllI.add((Throwable)lllllllllllllllllIIIllllIIIIIIIl, lllllllllllllllllIIIlllIllllllII);
        }
        if (lllllllllllllllllIIIllllIIIIIIIl.getClass().isArray()) {
            return lllllllllllllllllIIIlllIlllllllI.add((Object[])lllllllllllllllllIIIllllIIIIIIIl, String.valueOf(new StringBuilder().append(lllllllllllllllllIIIlllIllllllII).append("%s")));
        }
        return lllllllllllllllllIIIlllIlllllllI.add("%s%s", lllllllllllllllllIIIlllIlllllIll, lllllllllllllllllIIIllllIIIIIIIl);
    }

    public PrettyPrinter add(IPrettyPrintable lllllllllllllllllIIIllllIlIIIIlI) {
        PrettyPrinter lllllllllllllllllIIIllllIlIIIIIl;
        if (lllllllllllllllllIIIllllIlIIIIlI != null) {
            lllllllllllllllllIIIllllIlIIIIlI.print(lllllllllllllllllIIIllllIlIIIIIl);
        }
        return lllllllllllllllllIIIllllIlIIIIIl;
    }

    public PrettyPrinter table(String ... lllllllllllllllllIIIlllllIlllIII) {
        PrettyPrinter lllllllllllllllllIIIlllllIllIlll;
        lllllllllllllllllIIIlllllIllIlll.table = new Table();
        for (String lllllllllllllllllIIIlllllIlllIlI : lllllllllllllllllIIIlllllIlllIII) {
            lllllllllllllllllIIIlllllIllIlll.table.addColumn(lllllllllllllllllIIIlllllIlllIlI);
        }
        return lllllllllllllllllIIIlllllIllIlll;
    }

    public PrettyPrinter add(Object lllllllllllllllllIIIllllIIIlIIII, int lllllllllllllllllIIIllllIIIIllll) {
        PrettyPrinter lllllllllllllllllIIIllllIIIIllIl;
        String lllllllllllllllllIIIllllIIIIlllI = Strings.repeat((String)" ", (int)lllllllllllllllllIIIllllIIIIllll);
        return lllllllllllllllllIIIllllIIIIllIl.append(lllllllllllllllllIIIllllIIIlIIII, lllllllllllllllllIIIllllIIIIllll, lllllllllllllllllIIIllllIIIIlllI);
    }

    private void printString(PrintStream lllllllllllllllllIIIlllIIIIIIlll, String lllllllllllllllllIIIlllIIIIIIIll) {
        if (lllllllllllllllllIIIlllIIIIIIIll != null) {
            PrettyPrinter lllllllllllllllllIIIlllIIIIIIlIl;
            lllllllllllllllllIIIlllIIIIIIlll.printf(String.valueOf(new StringBuilder().append("/* %-").append(lllllllllllllllllIIIlllIIIIIIlIl.width).append("s */\n")), lllllllllllllllllIIIlllIIIIIIIll);
        }
    }

    private void addLine(Object lllllllllllllllllIIIlllIlIIIIlII) {
        PrettyPrinter lllllllllllllllllIIIlllIlIIIIlIl;
        if (lllllllllllllllllIIIlllIlIIIIlII == null) {
            return;
        }
        lllllllllllllllllIIIlllIlIIIIlIl.lines.add(lllllllllllllllllIIIlllIlIIIIlII);
        lllllllllllllllllIIIlllIlIIIIlIl.recalcWidth |= lllllllllllllllllIIIlllIlIIIIlII instanceof IVariableWidthEntry;
    }

    public PrettyPrinter hr(char lllllllllllllllllIIIlllIlIIlIIII) {
        PrettyPrinter lllllllllllllllllIIIlllIlIIlIIll;
        lllllllllllllllllIIIlllIlIIlIIll.addLine(lllllllllllllllllIIIlllIlIIlIIll.new HorizontalRule(lllllllllllllllllIIIlllIlIIlIIII));
        return lllllllllllllllllIIIlllIlIIlIIll;
    }

    public PrettyPrinter add(String lllllllllllllllllIIIlllllIIIIIIl) {
        PrettyPrinter lllllllllllllllllIIIlllllIIIIIlI;
        lllllllllllllllllIIIlllllIIIIIlI.addLine(lllllllllllllllllIIIlllllIIIIIIl);
        lllllllllllllllllIIIlllllIIIIIlI.width = Math.max(lllllllllllllllllIIIlllllIIIIIlI.width, lllllllllllllllllIIIlllllIIIIIIl.length());
        return lllllllllllllllllIIIlllllIIIIIlI;
    }

    public PrettyPrinter trace(String lllllllllllllllllIIIlllIIlllIlll) {
        PrettyPrinter lllllllllllllllllIIIlllIIlllIllI;
        return lllllllllllllllllIIIlllIIlllIllI.trace(System.err, LogManager.getLogger((String)lllllllllllllllllIIIlllIIlllIlll));
    }

    public PrettyPrinter trace(PrintStream lllllllllllllllllIIIlllIIIlIIllI, Logger lllllllllllllllllIIIlllIIIlIIlIl, Level lllllllllllllllllIIIlllIIIlIIlII) {
        PrettyPrinter lllllllllllllllllIIIlllIIIlIlIll;
        lllllllllllllllllIIIlllIIIlIlIll.log(lllllllllllllllllIIIlllIIIlIIlIl, lllllllllllllllllIIIlllIIIlIIlII);
        lllllllllllllllllIIIlllIIIlIlIll.print(lllllllllllllllllIIIlllIIIlIIllI);
        return lllllllllllllllllIIIlllIIIlIlIll;
    }

    public PrettyPrinter add(Object[] lllllllllllllllllIIIllllIllIllIl) {
        PrettyPrinter lllllllllllllllllIIIllllIllIlllI;
        return lllllllllllllllllIIIllllIllIlllI.add(lllllllllllllllllIIIllllIllIllIl, "%s");
    }

    private void logString(Logger lllllllllllllllllIIIllIllIllIlIl, Level lllllllllllllllllIIIllIllIlllIII, String lllllllllllllllllIIIllIllIllIIll) {
        if (lllllllllllllllllIIIllIllIllIIll != null) {
            PrettyPrinter lllllllllllllllllIIIllIllIlllIlI;
            lllllllllllllllllIIIllIllIllIlIl.log(lllllllllllllllllIIIllIllIlllIII, String.format(String.valueOf(new StringBuilder().append("/* %-").append(lllllllllllllllllIIIllIllIlllIlI.width).append("s */")), lllllllllllllllllIIIllIllIllIIll));
        }
    }

    public PrettyPrinter addWithIndices(Collection<?> lllllllllllllllllIIIllllIlIIIllI) {
        PrettyPrinter lllllllllllllllllIIIllllIlIIIlll;
        return lllllllllllllllllIIIllllIlIIIlll.addIndexed(lllllllllllllllllIIIllllIlIIIllI.toArray());
    }

    public PrettyPrinter centre() {
        Object lllllllllllllllllIIIlllIlIIIllIl;
        PrettyPrinter lllllllllllllllllIIIlllIlIIIlIll;
        if (!lllllllllllllllllIIIlllIlIIIlIll.lines.isEmpty() && (lllllllllllllllllIIIlllIlIIIllIl = lllllllllllllllllIIIlllIlIIIlIll.lines.get(lllllllllllllllllIIIlllIlIIIlIll.lines.size() - 1)) instanceof String) {
            lllllllllllllllllIIIlllIlIIIlIll.addLine(lllllllllllllllllIIIlllIlIIIlIll.new CentredText(lllllllllllllllllIIIlllIlIIIlIll.lines.remove(lllllllllllllllllIIIlllIlIIIlIll.lines.size() - 1)));
        }
        return lllllllllllllllllIIIlllIlIIIlIll;
    }

    public PrettyPrinter trace(PrintStream lllllllllllllllllIIIlllIIlIlIIlI, Level lllllllllllllllllIIIlllIIlIIlllI) {
        PrettyPrinter lllllllllllllllllIIIlllIIlIlIIII;
        return lllllllllllllllllIIIlllIIlIlIIII.trace(lllllllllllllllllIIIlllIIlIlIIlI, PrettyPrinter.getDefaultLoggerName(), lllllllllllllllllIIIlllIIlIIlllI);
    }

    public PrettyPrinter add(Throwable lllllllllllllllllIIIllllIIllIlIl, int lllllllllllllllllIIIllllIIllIlII) {
        PrettyPrinter lllllllllllllllllIIIllllIIllIIll;
        while (lllllllllllllllllIIIllllIIllIlIl != null) {
            lllllllllllllllllIIIllllIIllIIll.add("%s: %s", lllllllllllllllllIIIllllIIllIlIl.getClass().getName(), lllllllllllllllllIIIllllIIllIlIl.getMessage());
            lllllllllllllllllIIIllllIIllIIll.add(lllllllllllllllllIIIllllIIllIlIl.getStackTrace(), lllllllllllllllllIIIllllIIllIlII);
            lllllllllllllllllIIIllllIIllIlIl = lllllllllllllllllIIIllllIIllIlIl.getCause();
        }
        return lllllllllllllllllIIIllllIIllIIll;
    }

    public PrettyPrinter add(Map<?, ?> lllllllllllllllllIIIlllIlIIlllII) {
        PrettyPrinter lllllllllllllllllIIIlllIlIIlllll;
        for (Map.Entry<?, ?> lllllllllllllllllIIIlllIlIlIIIII : lllllllllllllllllIIIlllIlIIlllII.entrySet()) {
            String lllllllllllllllllIIIlllIlIlIIIIl = lllllllllllllllllIIIlllIlIlIIIII.getKey() == null ? "null" : lllllllllllllllllIIIlllIlIlIIIII.getKey().toString();
            lllllllllllllllllIIIlllIlIIlllll.kv(lllllllllllllllllIIIlllIlIlIIIIl, lllllllllllllllllIIIlllIlIlIIIII.getValue());
        }
        return lllllllllllllllllIIIlllIlIIlllll;
    }

    public PrettyPrinter add() {
        PrettyPrinter lllllllllllllllllIIIlllllIIIIlIl;
        lllllllllllllllllIIIlllllIIIIlIl.addLine("");
        return lllllllllllllllllIIIlllllIIIIlIl;
    }

    public PrettyPrinter trace(PrintStream lllllllllllllllllIIIlllIIIllllll, String lllllllllllllllllIIIlllIIIlllIlI, Level lllllllllllllllllIIIlllIIIlllIIl) {
        PrettyPrinter lllllllllllllllllIIIlllIIIllllII;
        return lllllllllllllllllIIIlllIIIllllII.trace(lllllllllllllllllIIIlllIIIllllll, LogManager.getLogger((String)lllllllllllllllllIIIlllIIIlllIlI), lllllllllllllllllIIIlllIIIlllIIl);
    }

    public PrettyPrinter() {
        lllllllllllllllllIIIllllllIlIIll(100);
        PrettyPrinter lllllllllllllllllIIIllllllIlIIll;
    }

    public PrettyPrinter kv(String lllllllllllllllllIIIlllIlIllIIIl, Object lllllllllllllllllIIIlllIlIllIIII) {
        PrettyPrinter lllllllllllllllllIIIlllIlIllIIlI;
        lllllllllllllllllIIIlllIlIllIIlI.addLine(lllllllllllllllllIIIlllIlIllIIlI.new KeyValue(lllllllllllllllllIIIlllIlIllIIIl, lllllllllllllllllIIIlllIlIllIIII));
        return lllllllllllllllllIIIlllIlIllIIlI.kvWidth(lllllllllllllllllIIIlllIlIllIIIl.length());
    }

    private void logSpecial(Logger lllllllllllllllllIIIllIlllIIIlII, Level lllllllllllllllllIIIllIlllIIIIll, ISpecialEntry lllllllllllllllllIIIllIllIllllll) {
        lllllllllllllllllIIIllIlllIIIlII.log(lllllllllllllllllIIIllIlllIIIIll, "/*{}*/", new Object[]{lllllllllllllllllIIIllIllIllllll.toString()});
    }

    private PrettyPrinter th(boolean lllllllllllllllllIIIlllllIIlIIII) {
        PrettyPrinter lllllllllllllllllIIIlllllIIlIIIl;
        if (lllllllllllllllllIIIlllllIIlIIIl.table == null) {
            lllllllllllllllllIIIlllllIIlIIIl.table = new Table();
        }
        if (!lllllllllllllllllIIIlllllIIlIIII || lllllllllllllllllIIIlllllIIlIIIl.table.addHeader) {
            lllllllllllllllllIIIlllllIIlIIIl.table.headerAdded();
            lllllllllllllllllIIIlllllIIlIIIl.addLine(lllllllllllllllllIIIlllllIIlIIIl.table);
        }
        return lllllllllllllllllIIIlllllIIlIIIl;
    }

    public PrettyPrinter hr() {
        PrettyPrinter lllllllllllllllllIIIlllIlIIlIlll;
        return lllllllllllllllllIIIlllIlIIlIlll.hr('*');
    }

    public PrettyPrinter addIndexed(Object[] lllllllllllllllllIIIllllIlIIllll) {
        PrettyPrinter lllllllllllllllllIIIllllIlIlIIII;
        int lllllllllllllllllIIIllllIlIlIIlI = String.valueOf(lllllllllllllllllIIIllllIlIIllll.length - 1).length();
        String lllllllllllllllllIIIllllIlIlIIIl = String.valueOf(new StringBuilder().append("[%").append(lllllllllllllllllIIIllllIlIlIIlI).append("d] %s"));
        for (int lllllllllllllllllIIIllllIlIlIlIl = 0; lllllllllllllllllIIIllllIlIlIlIl < lllllllllllllllllIIIllllIlIIllll.length; ++lllllllllllllllllIIIllllIlIlIlIl) {
            lllllllllllllllllIIIllllIlIlIIII.add(lllllllllllllllllIIIllllIlIlIIIl, lllllllllllllllllIIIllllIlIlIlIl, lllllllllllllllllIIIllllIlIIllll[lllllllllllllllllIIIllllIlIlIlIl]);
        }
        return lllllllllllllllllIIIllllIlIlIIII;
    }

    public PrettyPrinter trace(String lllllllllllllllllIIIlllIIlllIIII, Level lllllllllllllllllIIIlllIIllIllII) {
        PrettyPrinter lllllllllllllllllIIIlllIIlllIIIl;
        return lllllllllllllllllIIIlllIIlllIIIl.trace(System.err, LogManager.getLogger((String)lllllllllllllllllIIIlllIIlllIIII), lllllllllllllllllIIIlllIIllIllII);
    }

    public PrettyPrinter print(PrintStream lllllllllllllllllIIIlllIIIIlIlIl) {
        PrettyPrinter lllllllllllllllllIIIlllIIIIlIllI;
        lllllllllllllllllIIIlllIIIIlIllI.updateWidth();
        lllllllllllllllllIIIlllIIIIlIllI.printSpecial(lllllllllllllllllIIIlllIIIIlIlIl, lllllllllllllllllIIIlllIIIIlIllI.horizontalRule);
        for (Object lllllllllllllllllIIIlllIIIIllIIl : lllllllllllllllllIIIlllIIIIlIllI.lines) {
            if (lllllllllllllllllIIIlllIIIIllIIl instanceof ISpecialEntry) {
                lllllllllllllllllIIIlllIIIIlIllI.printSpecial(lllllllllllllllllIIIlllIIIIlIlIl, (ISpecialEntry)lllllllllllllllllIIIlllIIIIllIIl);
                continue;
            }
            lllllllllllllllllIIIlllIIIIlIllI.printString(lllllllllllllllllIIIlllIIIIlIlIl, lllllllllllllllllIIIlllIIIIllIIl.toString());
        }
        lllllllllllllllllIIIlllIIIIlIllI.printSpecial(lllllllllllllllllIIIlllIIIIlIlIl, lllllllllllllllllIIIlllIIIIlIllI.horizontalRule);
        return lllllllllllllllllIIIlllIIIIlIllI;
    }

    public PrettyPrinter(int lllllllllllllllllIIIllllllIIllll) {
        PrettyPrinter lllllllllllllllllIIIllllllIIlllI;
        lllllllllllllllllIIIllllllIIlllI.horizontalRule = lllllllllllllllllIIIllllllIIlllI.new HorizontalRule('*');
        lllllllllllllllllIIIllllllIIlllI.lines = new ArrayList<Object>();
        lllllllllllllllllIIIllllllIIlllI.recalcWidth = false;
        lllllllllllllllllIIIllllllIIlllI.width = 100;
        lllllllllllllllllIIIllllllIIlllI.wrapWidth = 80;
        lllllllllllllllllIIIllllllIIlllI.kvKeyWidth = 10;
        lllllllllllllllllIIIllllllIIlllI.kvFormat = PrettyPrinter.makeKvFormat(lllllllllllllllllIIIllllllIIlllI.kvKeyWidth);
        lllllllllllllllllIIIllllllIIlllI.width = lllllllllllllllllIIIllllllIIllll;
    }

    private List<String> getWrapped(int lllllllllllllllllIIIlllIllIIlIll, String lllllllllllllllllIIIlllIllIIIllI, String lllllllllllllllllIIIlllIllIIlIIl) {
        ArrayList<String> lllllllllllllllllIIIlllIllIIlIII = new ArrayList<String>();
        while (lllllllllllllllllIIIlllIllIIIllI.length() > lllllllllllllllllIIIlllIllIIlIll) {
            int lllllllllllllllllIIIlllIllIIlllI = lllllllllllllllllIIIlllIllIIIllI.lastIndexOf(32, lllllllllllllllllIIIlllIllIIlIll);
            if (lllllllllllllllllIIIlllIllIIlllI < 10) {
                lllllllllllllllllIIIlllIllIIlllI = lllllllllllllllllIIIlllIllIIlIll;
            }
            String lllllllllllllllllIIIlllIllIIllIl = lllllllllllllllllIIIlllIllIIIllI.substring(0, lllllllllllllllllIIIlllIllIIlllI);
            lllllllllllllllllIIIlllIllIIlIII.add(lllllllllllllllllIIIlllIllIIllIl);
            lllllllllllllllllIIIlllIllIIIllI = String.valueOf(new StringBuilder().append(lllllllllllllllllIIIlllIllIIlIIl).append(lllllllllllllllllIIIlllIllIIIllI.substring(lllllllllllllllllIIIlllIllIIlllI + 1)));
        }
        if (lllllllllllllllllIIIlllIllIIIllI.length() > 0) {
            lllllllllllllllllIIIlllIllIIlIII.add(lllllllllllllllllIIIlllIllIIIllI);
        }
        return lllllllllllllllllIIIlllIllIIlIII;
    }

    private static String getDefaultLoggerName() {
        String lllllllllllllllllIIIllIllIIIIlIl = new Throwable().getStackTrace()[2].getClassName();
        int lllllllllllllllllIIIllIllIIIIIll = lllllllllllllllllIIIllIllIIIIlIl.lastIndexOf(46);
        return lllllllllllllllllIIIllIllIIIIIll == -1 ? lllllllllllllllllIIIllIllIIIIlIl : lllllllllllllllllIIIllIllIIIIlIl.substring(lllllllllllllllllIIIllIllIIIIIll + 1);
    }

    public PrettyPrinter addWrapped(String lllllllllllllllllIIIlllIllllIlII, Object ... lllllllllllllllllIIIlllIllllIIll) {
        PrettyPrinter lllllllllllllllllIIIlllIllllIIlI;
        return lllllllllllllllllIIIlllIllllIIlI.addWrapped(lllllllllllllllllIIIlllIllllIIlI.wrapWidth, lllllllllllllllllIIIlllIllllIlII, lllllllllllllllllIIIlllIllllIIll);
    }

    public PrettyPrinter trace(Logger lllllllllllllllllIIIlllIIlIllllI, Level lllllllllllllllllIIIlllIIlIlllIl) {
        PrettyPrinter lllllllllllllllllIIIlllIIlIlllll;
        return lllllllllllllllllIIIlllIIlIlllll.trace(System.err, lllllllllllllllllIIIlllIIlIllllI, lllllllllllllllllIIIlllIIlIlllIl);
    }

    public int wrapTo() {
        PrettyPrinter lllllllllllllllllIIIllllllIIIlII;
        return lllllllllllllllllIIIllllllIIIlII.wrapWidth;
    }

    public PrettyPrinter add(StackTraceElement[] lllllllllllllllllIIIllllIIlIIIlI, int lllllllllllllllllIIIllllIIlIIIIl) {
        PrettyPrinter lllllllllllllllllIIIllllIIlIIIll;
        String lllllllllllllllllIIIllllIIlIIlII = Strings.repeat((String)" ", (int)lllllllllllllllllIIIllllIIlIIIIl);
        for (StackTraceElement lllllllllllllllllIIIllllIIlIlIII : lllllllllllllllllIIIllllIIlIIIlI) {
            lllllllllllllllllIIIllllIIlIIIll.add("%s%s", lllllllllllllllllIIIllllIIlIIlII, lllllllllllllllllIIIllllIIlIlIII);
        }
        return lllllllllllllllllIIIllllIIlIIIll;
    }

    public PrettyPrinter add(Throwable lllllllllllllllllIIIllllIIllllII) {
        PrettyPrinter lllllllllllllllllIIIllllIIlllIll;
        return lllllllllllllllllIIIllllIIlllIll.add(lllllllllllllllllIIIllllIIllllII, 4);
    }

    public PrettyPrinter print() {
        PrettyPrinter lllllllllllllllllIIIlllIIIlIIIIl;
        return lllllllllllllllllIIIlllIIIlIIIIl.print(System.err);
    }

    public PrettyPrinter table() {
        PrettyPrinter lllllllllllllllllIIIllllllIIIIlI;
        lllllllllllllllllIIIllllllIIIIlI.table = new Table();
        return lllllllllllllllllIIIllllllIIIIlI;
    }

    public PrettyPrinter trace(PrintStream lllllllllllllllllIIIlllIIlIIlIIl, String lllllllllllllllllIIIlllIIlIIIlIl) {
        PrettyPrinter lllllllllllllllllIIIlllIIlIIIlll;
        return lllllllllllllllllIIIlllIIlIIIlll.trace(lllllllllllllllllIIIlllIIlIIlIIl, LogManager.getLogger((String)lllllllllllllllllIIIlllIIlIIIlIl));
    }

    public PrettyPrinter trace() {
        PrettyPrinter lllllllllllllllllIIIlllIlIIIIIIl;
        return lllllllllllllllllIIIlllIlIIIIIIl.trace(PrettyPrinter.getDefaultLoggerName());
    }

    public PrettyPrinter trace(Level lllllllllllllllllIIIlllIIlllllIl) {
        PrettyPrinter lllllllllllllllllIIIlllIIllllllI;
        return lllllllllllllllllIIIlllIIllllllI.trace(PrettyPrinter.getDefaultLoggerName(), lllllllllllllllllIIIlllIIlllllIl);
    }

    private static String makeKvFormat(int lllllllllllllllllIIIllIllIIlIlIl) {
        return String.format("%%%ds : %%s", lllllllllllllllllIIIllIllIIlIlIl);
    }

    public PrettyPrinter wrapTo(int lllllllllllllllllIIIllllllIIIlll) {
        PrettyPrinter lllllllllllllllllIIIllllllIIlIlI;
        lllllllllllllllllIIIllllllIIlIlI.wrapWidth = lllllllllllllllllIIIllllllIIIlll;
        return lllllllllllllllllIIIllllllIIlIlI;
    }

    static class Row
    implements IVariableWidthEntry {
        final /* synthetic */ Table table;
        final /* synthetic */ String[] args;

        public Row(Table lllllllllllllllIlllIlIIlIIlIIIlI, Object ... lllllllllllllllIlllIlIIlIIlIIIII) {
            Row lllllllllllllllIlllIlIIlIIlIIllI;
            lllllllllllllllIlllIlIIlIIlIIllI.table = lllllllllllllllIlllIlIIlIIlIIIlI.grow(lllllllllllllllIlllIlIIlIIlIIIII.length);
            lllllllllllllllIlllIlIIlIIlIIllI.args = new String[lllllllllllllllIlllIlIIlIIlIIIII.length];
            for (int lllllllllllllllIlllIlIIlIIlIlIII = 0; lllllllllllllllIlllIlIIlIIlIlIII < lllllllllllllllIlllIlIIlIIlIIIII.length; ++lllllllllllllllIlllIlIIlIIlIlIII) {
                lllllllllllllllIlllIlIIlIIlIIllI.args[lllllllllllllllIlllIlIIlIIlIlIII] = lllllllllllllllIlllIlIIlIIlIIIII[lllllllllllllllIlllIlIIlIIlIlIII].toString();
                lllllllllllllllIlllIlIIlIIlIIllI.table.columns.get(lllllllllllllllIlllIlIIlIIlIlIII).setMinWidth(lllllllllllllllIlllIlIIlIIlIIllI.args[lllllllllllllllIlllIlIIlIIlIlIII].length());
            }
        }

        @Override
        public int getWidth() {
            Row lllllllllllllllIlllIlIIlIIIIIIII;
            return lllllllllllllllIlllIlIIlIIIIIIII.toString().length();
        }

        public String toString() {
            Row lllllllllllllllIlllIlIIlIIIIlIII;
            Object[] lllllllllllllllIlllIlIIlIIIIlIIl = new Object[lllllllllllllllIlllIlIIlIIIIlIII.table.columns.size()];
            for (int lllllllllllllllIlllIlIIlIIIIllIl = 0; lllllllllllllllIlllIlIIlIIIIllIl < lllllllllllllllIlllIlIIlIIIIlIIl.length; ++lllllllllllllllIlllIlIIlIIIIllIl) {
                Column lllllllllllllllIlllIlIIlIIIIllll = lllllllllllllllIlllIlIIlIIIIlIII.table.columns.get(lllllllllllllllIlllIlIIlIIIIllIl);
                lllllllllllllllIlllIlIIlIIIIlIIl[lllllllllllllllIlllIlIIlIIIIllIl] = lllllllllllllllIlllIlIIlIIIIllIl >= lllllllllllllllIlllIlIIlIIIIlIII.args.length ? "" : (lllllllllllllllIlllIlIIlIIIIlIII.args[lllllllllllllllIlllIlIIlIIIIllIl].length() > lllllllllllllllIlllIlIIlIIIIllll.getMaxWidth() ? lllllllllllllllIlllIlIIlIIIIlIII.args[lllllllllllllllIlllIlIIlIIIIllIl].substring(0, lllllllllllllllIlllIlIIlIIIIllll.getMaxWidth()) : lllllllllllllllIlllIlIIlIIIIlIII.args[lllllllllllllllIlllIlIIlIIIIllIl]);
            }
            return String.format(lllllllllllllllIlllIlIIlIIIIlIII.table.format, lllllllllllllllIlllIlIIlIIIIlIIl);
        }
    }

    static class Table
    implements IVariableWidthEntry {
        /* synthetic */ String format;
        /* synthetic */ int colSpacing;
        final /* synthetic */ List<Column> columns;
        /* synthetic */ boolean addHeader;
        final /* synthetic */ List<Row> rows;

        Object[] getTitles() {
            Table lIIIlIIlIlIIlll;
            ArrayList<String> lIIIlIIlIlIIllI = new ArrayList<String>();
            for (Column lIIIlIIlIlIlIII : lIIIlIIlIlIIlll.columns) {
                lIIIlIIlIlIIllI.add(lIIIlIIlIlIlIII.getTitle());
            }
            return lIIIlIIlIlIIllI.toArray();
        }

        Column add(Column lIIIlIIllIlllll) {
            Table lIIIlIIlllIIIII;
            lIIIlIIlllIIIII.columns.add(lIIIlIIllIlllll);
            return lIIIlIIllIlllll;
        }

        public String toString() {
            Table lIIIlIIlIIllIIl;
            boolean lIIIlIIlIIllIll = false;
            String[] lIIIlIIlIIllIlI = new String[lIIIlIIlIIllIIl.columns.size()];
            for (int lIIIlIIlIIlllIl = 0; lIIIlIIlIIlllIl < lIIIlIIlIIllIIl.columns.size(); ++lIIIlIIlIIlllIl) {
                lIIIlIIlIIllIlI[lIIIlIIlIIlllIl] = lIIIlIIlIIllIIl.columns.get(lIIIlIIlIIlllIl).toString();
                lIIIlIIlIIllIll |= !lIIIlIIlIIllIlI[lIIIlIIlIIlllIl].isEmpty();
            }
            return lIIIlIIlIIllIll ? String.format(lIIIlIIlIIllIIl.format, lIIIlIIlIIllIlI) : null;
        }

        Table grow(int lIIIlIIlllIIlll) {
            Table lIIIlIIlllIIllI;
            while (lIIIlIIlllIIllI.columns.size() < lIIIlIIlllIIlll) {
                lIIIlIIlllIIllI.columns.add(new Column(lIIIlIIlllIIllI));
            }
            lIIIlIIlllIIllI.updateFormat();
            return lIIIlIIlllIIllI;
        }

        void headerAdded() {
            lIIIlIIllllIIIl.addHeader = false;
        }

        void setColSpacing(int lIIIlIIlllIllIl) {
            Table lIIIlIIlllIlllI;
            lIIIlIIlllIlllI.colSpacing = Math.max(0, lIIIlIIlllIllIl);
            lIIIlIIlllIlllI.updateFormat();
        }

        @Override
        public int getWidth() {
            Table lIIIlIIlIIlIIll;
            String lIIIlIIlIIlIIlI = lIIIlIIlIIlIIll.toString();
            return lIIIlIIlIIlIIlI != null ? lIIIlIIlIIlIIlI.length() : 0;
        }

        Row addRow(Object ... lIIIlIIllIIIIIl) {
            Table lIIIlIIllIIIlII;
            return lIIIlIIllIIIlII.add(new Row(lIIIlIIllIIIlII, lIIIlIIllIIIIIl));
        }

        Column addColumn(Alignment lIIIlIIllIIlIIl, int lIIIlIIllIIllII, String lIIIlIIllIIIlll) {
            Table lIIIlIIllIIlIlI;
            return lIIIlIIllIIlIlI.add(new Column(lIIIlIIllIIlIlI, lIIIlIIllIIlIIl, lIIIlIIllIIllII, lIIIlIIllIIIlll));
        }

        Column addColumn(String lIIIlIIllIlIlIl) {
            Table lIIIlIIllIlIllI;
            return lIIIlIIllIlIllI.add(new Column(lIIIlIIllIlIllI, lIIIlIIllIlIlIl));
        }

        String getFormat() {
            Table lIIIlIIlIlIllIl;
            return lIIIlIIlIlIllIl.format;
        }

        void updateFormat() {
            Table lIIIlIIlIlllIIl;
            String lIIIlIIlIlllIII = Strings.repeat((String)" ", (int)lIIIlIIlIlllIIl.colSpacing);
            StringBuilder lIIIlIIlIllIlll = new StringBuilder();
            boolean lIIIlIIlIllIllI = false;
            for (Column lIIIlIIlIlllIlI : lIIIlIIlIlllIIl.columns) {
                if (lIIIlIIlIllIllI) {
                    lIIIlIIlIllIlll.append(lIIIlIIlIlllIII);
                }
                lIIIlIIlIllIllI = true;
                lIIIlIIlIllIlll.append(lIIIlIIlIlllIlI.getFormat());
            }
            lIIIlIIlIlllIIl.format = String.valueOf(lIIIlIIlIllIlll);
        }

        Row add(Row lIIIlIIllIllIll) {
            Table lIIIlIIllIllIlI;
            lIIIlIIllIllIlI.rows.add(lIIIlIIllIllIll);
            return lIIIlIIllIllIll;
        }

        Table() {
            Table lIIIlIIllllIlII;
            lIIIlIIllllIlII.columns = new ArrayList<Column>();
            lIIIlIIllllIlII.rows = new ArrayList<Row>();
            lIIIlIIllllIlII.format = "%s";
            lIIIlIIllllIlII.colSpacing = 2;
            lIIIlIIllllIlII.addHeader = true;
        }
    }

    static interface IVariableWidthEntry {
        public int getWidth();
    }

    public static enum Alignment {
        LEFT,
        RIGHT;


        private Alignment() {
            Alignment lIlllIIllIl;
        }
    }

    static interface ISpecialEntry {
    }

    class CentredText {
        private final /* synthetic */ Object centred;

        public String toString() {
            CentredText lllllllllllllllllIIllIlIlIlIlIlI;
            String lllllllllllllllllIIllIlIlIlIlIll = lllllllllllllllllIIllIlIlIlIlIlI.centred.toString();
            return String.format(String.valueOf(new StringBuilder().append("%").append((lllllllllllllllllIIllIlIlIlIlIlI.PrettyPrinter.this.width - lllllllllllllllllIIllIlIlIlIlIll.length()) / 2 + lllllllllllllllllIIllIlIlIlIlIll.length()).append("s")), lllllllllllllllllIIllIlIlIlIlIll);
        }

        public CentredText(Object lllllllllllllllllIIllIlIlIllIIlI) {
            CentredText lllllllllllllllllIIllIlIlIllIIIl;
            lllllllllllllllllIIllIlIlIllIIIl.centred = lllllllllllllllllIIllIlIlIllIIlI;
        }
    }

    public static interface IPrettyPrintable {
        public void print(PrettyPrinter var1);
    }

    class HorizontalRule
    implements ISpecialEntry {
        private final /* synthetic */ char[] hrChars;

        public String toString() {
            HorizontalRule llllIlIlIIIIlIl;
            return Strings.repeat((String)new String(llllIlIlIIIIlIl.hrChars), (int)(llllIlIlIIIIlIl.PrettyPrinter.this.width + 2));
        }

        public HorizontalRule(char ... llllIlIlIIIlIlI) {
            HorizontalRule llllIlIlIIIlIIl;
            llllIlIlIIIlIIl.hrChars = llllIlIlIIIlIlI;
        }
    }

    static class Column {
        private /* synthetic */ String title;
        private /* synthetic */ int minWidth;
        private /* synthetic */ Alignment align;
        private /* synthetic */ int size;
        private /* synthetic */ String format;
        private final /* synthetic */ Table table;
        private /* synthetic */ int maxWidth;

        private void updateFormat() {
            Column lIIIllIlIIllIIl;
            int lIIIllIlIIllIII = Math.min(lIIIllIlIIllIIl.maxWidth, lIIIllIlIIllIIl.size == 0 ? lIIIllIlIIllIIl.minWidth : lIIIllIlIIllIIl.size);
            lIIIllIlIIllIIl.format = String.valueOf(new StringBuilder().append("%").append(lIIIllIlIIllIIl.align == Alignment.RIGHT ? "" : "-").append(lIIIllIlIIllIII).append("s"));
            lIIIllIlIIllIIl.table.updateFormat();
        }

        void setMinWidth(int lIIIllIlIlIlllI) {
            Column lIIIllIlIlIllIl;
            if (lIIIllIlIlIlllI > lIIIllIlIlIllIl.minWidth) {
                lIIIllIlIlIllIl.minWidth = lIIIllIlIlIlllI;
                lIIIllIlIlIllIl.updateFormat();
            }
        }

        Column(Table lIIIllIllllllIl) {
            Column lIIIllIlllllllI;
            lIIIllIlllllllI.align = Alignment.LEFT;
            lIIIllIlllllllI.minWidth = 1;
            lIIIllIlllllllI.maxWidth = Integer.MAX_VALUE;
            lIIIllIlllllllI.size = 0;
            lIIIllIlllllllI.title = "";
            lIIIllIlllllllI.format = "%s";
            lIIIllIlllllllI.table = lIIIllIllllllIl;
        }

        Column(Table lIIIllIllIlIlII, Alignment lIIIllIllIlllII, int lIIIllIllIlIIII, String lIIIllIllIIlllI) {
            lIIIllIllIlIllI(lIIIllIllIlIlII, lIIIllIllIIlllI);
            Column lIIIllIllIlIllI;
            lIIIllIllIlIllI.align = lIIIllIllIlllII;
            lIIIllIllIlIllI.size = lIIIllIllIlIIII;
        }

        String getFormat() {
            Column lIIIllIlIIIlllI;
            return lIIIllIlIIIlllI.format;
        }

        public String toString() {
            Column lIIIllIlIIIlIlI;
            if (lIIIllIlIIIlIlI.title.length() > lIIIllIlIIIlIlI.maxWidth) {
                return lIIIllIlIIIlIlI.title.substring(0, lIIIllIlIIIlIlI.maxWidth);
            }
            return lIIIllIlIIIlIlI.title;
        }

        String getTitle() {
            Column lIIIllIlIIlIIII;
            return lIIIllIlIIlIIII.title;
        }

        void setTitle(String lIIIllIlIIllllI) {
            Column lIIIllIlIIlllll;
            lIIIllIlIIlllll.title = lIIIllIlIIllllI;
            lIIIllIlIIlllll.setWidth(lIIIllIlIIllllI.length());
        }

        void setAlignment(Alignment lIIIllIllIIIlIl) {
            Column lIIIllIllIIlIII;
            lIIIllIllIIlIII.align = lIIIllIllIIIlIl;
            lIIIllIllIIlIII.updateFormat();
        }

        void setWidth(int lIIIllIlIlllIll) {
            Column lIIIllIllIIIIII;
            if (lIIIllIlIlllIll > lIIIllIllIIIIII.size) {
                lIIIllIllIIIIII.size = lIIIllIlIlllIll;
                lIIIllIllIIIIII.updateFormat();
            }
        }

        int getMaxWidth() {
            Column lIIIllIlIIlIlII;
            return lIIIllIlIIlIlII.maxWidth;
        }

        Column(Table lIIIllIllllIllI, String lIIIllIllllIlIl) {
            lIIIllIllllIlll(lIIIllIllllIllI);
            Column lIIIllIllllIlll;
            lIIIllIllllIlll.title = lIIIllIllllIlIl;
            lIIIllIllllIlll.minWidth = lIIIllIllllIlIl.length();
            lIIIllIllllIlll.updateFormat();
        }

        void setMaxWidth(int lIIIllIlIlIIIll) {
            Column lIIIllIlIlIIlIl;
            lIIIllIlIlIIlIl.size = Math.min(lIIIllIlIlIIlIl.size, lIIIllIlIlIIlIl.maxWidth);
            lIIIllIlIlIIlIl.maxWidth = Math.max(1, lIIIllIlIlIIIll);
            lIIIllIlIlIIlIl.updateFormat();
        }
    }

    class KeyValue
    implements IVariableWidthEntry {
        private final /* synthetic */ String key;
        private final /* synthetic */ Object value;

        public KeyValue(String llllllllllllllllIIlIlIllllIlllIl, Object llllllllllllllllIIlIlIllllIlllII) {
            KeyValue llllllllllllllllIIlIlIllllIllIll;
            llllllllllllllllIIlIlIllllIllIll.key = llllllllllllllllIIlIlIllllIlllIl;
            llllllllllllllllIIlIlIllllIllIll.value = llllllllllllllllIIlIlIllllIlllII;
        }

        public String toString() {
            KeyValue llllllllllllllllIIlIlIllllIlIlIl;
            return String.format(llllllllllllllllIIlIlIllllIlIlIl.PrettyPrinter.this.kvFormat, llllllllllllllllIIlIlIllllIlIlIl.key, llllllllllllllllIIlIlIllllIlIlIl.value);
        }

        @Override
        public int getWidth() {
            KeyValue llllllllllllllllIIlIlIllllIlIIlI;
            return llllllllllllllllIIlIlIllllIlIIlI.toString().length();
        }
    }
}

