/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Joiner
 */
package org.spongepowered.asm.util.perf;

import com.google.common.base.Joiner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import org.spongepowered.asm.util.PrettyPrinter;

public final class Profiler {
    private final /* synthetic */ Deque<Section> stack;
    private final /* synthetic */ List<String> phases;
    private /* synthetic */ boolean active;
    private final /* synthetic */ Map<String, Section> sections;
    public static final /* synthetic */ int ROOT;
    public static final /* synthetic */ int FINE;

    public Section get(String llllllllllllllllIIIIlIIIlllllIII) {
        Profiler llllllllllllllllIIIIlIIlIIIIIIII;
        Section llllllllllllllllIIIIlIIIllllllIl = llllllllllllllllIIIIlIIlIIIIIIII.sections.get(llllllllllllllllIIIIlIIIlllllIII);
        if (llllllllllllllllIIIIlIIIllllllIl == null) {
            llllllllllllllllIIIIlIIIllllllIl = llllllllllllllllIIIIlIIlIIIIIIII.active ? llllllllllllllllIIIIlIIlIIIIIIII.new LiveSection(llllllllllllllllIIIIlIIIlllllIII, llllllllllllllllIIIIlIIlIIIIIIII.phases.size() - 1) : llllllllllllllllIIIIlIIlIIIIIIII.new Section(llllllllllllllllIIIIlIIIlllllIII);
            llllllllllllllllIIIIlIIlIIIIIIII.sections.put(llllllllllllllllIIIIlIIIlllllIII, llllllllllllllllIIIIlIIIllllllIl);
        }
        return llllllllllllllllIIIIlIIIllllllIl;
    }

    void end(Section llllllllllllllllIIIIlIIIIlIIllll) {
        block5: {
            Profiler llllllllllllllllIIIIlIIIIlIIllII;
            try {
                Section llllllllllllllllIIIIlIIIIlIllIII;
                Section llllllllllllllllIIIIlIIIIlIlIllI = llllllllllllllllIIIIlIIIIlIllIII = llllllllllllllllIIIIlIIIIlIIllII.stack.pop();
                while (llllllllllllllllIIIIlIIIIlIlIllI != llllllllllllllllIIIIlIIIIlIIllll) {
                    if (llllllllllllllllIIIIlIIIIlIlIllI == null && llllllllllllllllIIIIlIIIIlIIllII.active) {
                        if (llllllllllllllllIIIIlIIIIlIllIII == null) {
                            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Attempted to pop ").append(llllllllllllllllIIIIlIIIIlIIllll).append(" but the stack is empty")));
                        }
                        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Attempted to pop ").append(llllllllllllllllIIIIlIIIIlIIllll).append(" which was not in the stack, head was ").append(llllllllllllllllIIIIlIIIIlIllIII)));
                    }
                    llllllllllllllllIIIIlIIIIlIlIllI = llllllllllllllllIIIIlIIIIlIIllII.stack.pop();
                }
            }
            catch (NoSuchElementException llllllllllllllllIIIIlIIIIlIlIlII) {
                if (!llllllllllllllllIIIIlIIIIlIIllII.active) break block5;
                throw new IllegalStateException(String.valueOf(new StringBuilder().append("Attempted to pop ").append(llllllllllllllllIIIIlIIIIlIIllll).append(" but the stack is empty")));
            }
        }
    }

    public Section begin(int llllllllllllllllIIIIlIIIlIlIIIlI, String ... llllllllllllllllIIIIlIIIlIlIIlII) {
        Profiler llllllllllllllllIIIIlIIIlIlIIlll;
        return llllllllllllllllIIIIlIIIlIlIIlll.begin(llllllllllllllllIIIIlIIIlIlIIIlI, Joiner.on((char)'.').join((Object[])llllllllllllllllIIIIlIIIlIlIIlII));
    }

    public Section begin(String llllllllllllllllIIIIlIIIlIIllIll) {
        Profiler llllllllllllllllIIIIlIIIlIIlllII;
        return llllllllllllllllIIIIlIIIlIIlllII.begin(0, llllllllllllllllIIIIlIIIlIIllIll);
    }

    public PrettyPrinter printer(boolean llllllllllllllllIIIIlIIIIIIIllII, boolean llllllllllllllllIIIIlIIIIIIIIlII) {
        Profiler llllllllllllllllIIIIlIIIIIIIllIl;
        PrettyPrinter llllllllllllllllIIIIlIIIIIIIlIlI = new PrettyPrinter();
        int llllllllllllllllIIIIlIIIIIIIlIIl = llllllllllllllllIIIIlIIIIIIIllIl.phases.size() + 4;
        int[] llllllllllllllllIIIIlIIIIIIIlIII = new int[]{0, 1, 2, llllllllllllllllIIIIlIIIIIIIlIIl - 2, llllllllllllllllIIIIlIIIIIIIlIIl - 1};
        Object[] llllllllllllllllIIIIlIIIIIIIIlll = new Object[llllllllllllllllIIIIlIIIIIIIlIIl * 2];
        int llllllllllllllllIIIIlIIIIIIlIIlI = 0;
        int llllllllllllllllIIIIlIIIIIIlIIIl = 0;
        while (llllllllllllllllIIIIlIIIIIIlIIlI < llllllllllllllllIIIIlIIIIIIIlIIl) {
            llllllllllllllllIIIIlIIIIIIIIlll[llllllllllllllllIIIIlIIIIIIlIIIl + 1] = PrettyPrinter.Alignment.RIGHT;
            if (llllllllllllllllIIIIlIIIIIIlIIlI == llllllllllllllllIIIIlIIIIIIIlIII[0]) {
                llllllllllllllllIIIIlIIIIIIIIlll[llllllllllllllllIIIIlIIIIIIlIIIl] = String.valueOf(new StringBuilder().append(llllllllllllllllIIIIlIIIIIIIIlII ? "" : "  ").append("Section"));
                llllllllllllllllIIIIlIIIIIIIIlll[llllllllllllllllIIIIlIIIIIIlIIIl + 1] = PrettyPrinter.Alignment.LEFT;
            } else {
                llllllllllllllllIIIIlIIIIIIIIlll[llllllllllllllllIIIIlIIIIIIlIIIl] = llllllllllllllllIIIIlIIIIIIlIIlI == llllllllllllllllIIIIlIIIIIIIlIII[1] ? "    TOTAL" : (llllllllllllllllIIIIlIIIIIIlIIlI == llllllllllllllllIIIIlIIIIIIIlIII[3] ? "    Count" : (llllllllllllllllIIIIlIIIIIIlIIlI == llllllllllllllllIIIIlIIIIIIIlIII[4] ? "Avg. " : (llllllllllllllllIIIIlIIIIIIlIIlI - llllllllllllllllIIIIlIIIIIIIlIII[2] < llllllllllllllllIIIIlIIIIIIIllIl.phases.size() ? llllllllllllllllIIIIlIIIIIIIllIl.phases.get(llllllllllllllllIIIIlIIIIIIlIIlI - llllllllllllllllIIIIlIIIIIIIlIII[2]) : "")));
            }
            llllllllllllllllIIIIlIIIIIIlIIIl = ++llllllllllllllllIIIIlIIIIIIlIIlI * 2;
        }
        llllllllllllllllIIIIlIIIIIIIlIlI.table(llllllllllllllllIIIIlIIIIIIIIlll).th().hr().add();
        for (Section llllllllllllllllIIIIlIIIIIIIlllI : llllllllllllllllIIIIlIIIIIIIllIl.sections.values()) {
            if (llllllllllllllllIIIIlIIIIIIIlllI.isFine() && !llllllllllllllllIIIIlIIIIIIIllII || llllllllllllllllIIIIlIIIIIIIIlII && llllllllllllllllIIIIlIIIIIIIlllI.getDelegate() != llllllllllllllllIIIIlIIIIIIIlllI) continue;
            llllllllllllllllIIIIlIIIIIIIllIl.printSectionRow(llllllllllllllllIIIIlIIIIIIIlIlI, llllllllllllllllIIIIlIIIIIIIlIIl, llllllllllllllllIIIIlIIIIIIIlIII, llllllllllllllllIIIIlIIIIIIIlllI, llllllllllllllllIIIIlIIIIIIIIlII);
            if (!llllllllllllllllIIIIlIIIIIIIIlII) continue;
            for (Section llllllllllllllllIIIIlIIIIIIIllll : llllllllllllllllIIIIlIIIIIIIllIl.sections.values()) {
                Section llllllllllllllllIIIIlIIIIIIlIIII = llllllllllllllllIIIIlIIIIIIIllll.getDelegate();
                if (llllllllllllllllIIIIlIIIIIIIllll.isFine() && !llllllllllllllllIIIIlIIIIIIIllII || llllllllllllllllIIIIlIIIIIIlIIII != llllllllllllllllIIIIlIIIIIIIlllI || llllllllllllllllIIIIlIIIIIIlIIII == llllllllllllllllIIIIlIIIIIIIllll) continue;
                llllllllllllllllIIIIlIIIIIIIllIl.printSectionRow(llllllllllllllllIIIIlIIIIIIIlIlI, llllllllllllllllIIIIlIIIIIIIlIIl, llllllllllllllllIIIIlIIIIIIIlIII, llllllllllllllllIIIIlIIIIIIIllll, llllllllllllllllIIIIlIIIIIIIIlII);
            }
        }
        return llllllllllllllllIIIIlIIIIIIIlIlI.add();
    }

    public void reset() {
        Profiler llllllllllllllllIIIIlIIlIIIlIlII;
        for (Section llllllllllllllllIIIIlIIlIIIlIlll : llllllllllllllllIIIIlIIlIIIlIlII.sections.values()) {
            llllllllllllllllIIIIlIIlIIIlIlll.invalidate();
        }
        llllllllllllllllIIIIlIIlIIIlIlII.sections.clear();
        llllllllllllllllIIIIlIIlIIIlIlII.phases.clear();
        llllllllllllllllIIIIlIIlIIIlIlII.phases.add("Initial");
        llllllllllllllllIIIIlIIlIIIlIlII.stack.clear();
    }

    public Profiler() {
        Profiler llllllllllllllllIIIIlIIlIIllllII;
        llllllllllllllllIIIIlIIlIIllllII.sections = new TreeMap<String, Section>();
        llllllllllllllllIIIIlIIlIIllllII.phases = new ArrayList<String>();
        llllllllllllllllIIIIlIIlIIllllII.stack = new LinkedList<Section>();
        llllllllllllllllIIIIlIIlIIllllII.phases.add("Initial");
    }

    private Section getSubSection(String llllllllllllllllIIIIlIIIllIlIlll, String llllllllllllllllIIIIlIIIllIlIlII, Section llllllllllllllllIIIIlIIIllIIllII) {
        Profiler llllllllllllllllIIIIlIIIllIIllll;
        Section llllllllllllllllIIIIlIIIllIlIIIl = llllllllllllllllIIIIlIIIllIIllll.sections.get(llllllllllllllllIIIIlIIIllIlIlll);
        if (llllllllllllllllIIIIlIIIllIlIIIl == null) {
            llllllllllllllllIIIIlIIIllIlIIIl = llllllllllllllllIIIIlIIIllIIllll.new SubSection(llllllllllllllllIIIIlIIIllIlIlll, llllllllllllllllIIIIlIIIllIIllll.phases.size() - 1, llllllllllllllllIIIIlIIIllIlIlII, llllllllllllllllIIIIlIIIllIIllII);
            llllllllllllllllIIIIlIIIllIIllll.sections.put(llllllllllllllllIIIIlIIIllIlIlll, llllllllllllllllIIIIlIIIllIlIIIl);
        }
        return llllllllllllllllIIIIlIIIllIlIIIl;
    }

    public void mark(String llllllllllllllllIIIIlIIIIIlllIlI) {
        Profiler llllllllllllllllIIIIlIIIIIllIllI;
        long llllllllllllllllIIIIlIIIIIlllIII = 0L;
        for (Section llllllllllllllllIIIIlIIIIIlllllI : llllllllllllllllIIIIlIIIIIllIllI.sections.values()) {
            llllllllllllllllIIIIlIIIIIlllIII += llllllllllllllllIIIIlIIIIIlllllI.getTime();
        }
        if (llllllllllllllllIIIIlIIIIIlllIII == 0L) {
            int llllllllllllllllIIIIlIIIIIllllIl = llllllllllllllllIIIIlIIIIIllIllI.phases.size();
            llllllllllllllllIIIIlIIIIIllIllI.phases.set(llllllllllllllllIIIIlIIIIIllllIl - 1, llllllllllllllllIIIIlIIIIIlllIlI);
            return;
        }
        llllllllllllllllIIIIlIIIIIllIllI.phases.add(llllllllllllllllIIIIlIIIIIlllIlI);
        for (Section llllllllllllllllIIIIlIIIIIllllII : llllllllllllllllIIIIlIIIIIllIllI.sections.values()) {
            llllllllllllllllIIIIlIIIIIllllII.mark();
        }
    }

    static {
        ROOT = 1;
        FINE = 2;
    }

    public void setActive(boolean llllllllllllllllIIIIlIIlIIlllIII) {
        Profiler llllllllllllllllIIIIlIIlIIllIlll;
        if (!llllllllllllllllIIIIlIIlIIllIlll.active && llllllllllllllllIIIIlIIlIIlllIII || !llllllllllllllllIIIIlIIlIIlllIII) {
            llllllllllllllllIIIIlIIlIIllIlll.reset();
        }
        llllllllllllllllIIIIlIIlIIllIlll.active = llllllllllllllllIIIIlIIlIIlllIII;
    }

    private void printSectionRow(PrettyPrinter llllllllllllllllIIIIIllllllIlIlI, int llllllllllllllllIIIIIllllllIIIII, int[] llllllllllllllllIIIIIlllllIlllll, Section llllllllllllllllIIIIIlllllIllllI, boolean llllllllllllllllIIIIIlllllIlllIl) {
        long[] llllllllllllllllIIIIIllllllIIIlI;
        boolean llllllllllllllllIIIIIllllllIIlIl = llllllllllllllllIIIIIlllllIllllI.getDelegate() != llllllllllllllllIIIIIlllllIllllI;
        Object[] llllllllllllllllIIIIIllllllIIlII = new Object[llllllllllllllllIIIIIllllllIIIII];
        int llllllllllllllllIIIIIllllllIIIll = 1;
        llllllllllllllllIIIIIllllllIIlII[0] = llllllllllllllllIIIIIlllllIlllIl ? (llllllllllllllllIIIIIllllllIIlIl ? String.valueOf(new StringBuilder().append("  > ").append(llllllllllllllllIIIIIlllllIllllI.getBaseName())) : llllllllllllllllIIIIIlllllIllllI.getName()) : String.valueOf(new StringBuilder().append(llllllllllllllllIIIIIllllllIIlIl ? "+ " : "  ").append(llllllllllllllllIIIIIlllllIllllI.getName()));
        for (long llllllllllllllllIIIIIllllllIllIl : llllllllllllllllIIIIIllllllIIIlI = llllllllllllllllIIIIIlllllIllllI.getTimes()) {
            if (llllllllllllllllIIIIIllllllIIIll == llllllllllllllllIIIIIlllllIlllll[1]) {
                llllllllllllllllIIIIIllllllIIlII[llllllllllllllllIIIIIllllllIIIll++] = String.valueOf(new StringBuilder().append(llllllllllllllllIIIIIlllllIllllI.getTotalTime()).append(" ms"));
            }
            if (llllllllllllllllIIIIIllllllIIIll < llllllllllllllllIIIIIlllllIlllll[2] || llllllllllllllllIIIIIllllllIIIll >= llllllllllllllllIIIIIllllllIIlII.length) continue;
            llllllllllllllllIIIIIllllllIIlII[llllllllllllllllIIIIIllllllIIIll++] = String.valueOf(new StringBuilder().append(llllllllllllllllIIIIIllllllIllIl).append(" ms"));
        }
        llllllllllllllllIIIIIllllllIIlII[llllllllllllllllIIIIIlllllIlllll[3]] = llllllllllllllllIIIIIlllllIllllI.getTotalCount();
        llllllllllllllllIIIIIllllllIIlII[llllllllllllllllIIIIIlllllIlllll[4]] = new DecimalFormat("   ###0.000 ms").format(llllllllllllllllIIIIIlllllIllllI.getTotalAverageTime());
        for (int llllllllllllllllIIIIIllllllIllII = 0; llllllllllllllllIIIIIllllllIllII < llllllllllllllllIIIIIllllllIIlII.length; ++llllllllllllllllIIIIIllllllIllII) {
            if (llllllllllllllllIIIIIllllllIIlII[llllllllllllllllIIIIIllllllIllII] != null) continue;
            llllllllllllllllIIIIIllllllIIlII[llllllllllllllllIIIIIllllllIllII] = "-";
        }
        llllllllllllllllIIIIIllllllIlIlI.tr(llllllllllllllllIIIIIllllllIIlII);
    }

    public Section begin(String ... llllllllllllllllIIIIlIIIlIllIIll) {
        Profiler llllllllllllllllIIIIlIIIlIllIlIl;
        return llllllllllllllllIIIIlIIIlIllIlIl.begin(0, llllllllllllllllIIIIlIIIlIllIIll);
    }

    public Section begin(int llllllllllllllllIIIIlIIIIlllllII, String llllllllllllllllIIIIlIIIIllllIlI) {
        Profiler llllllllllllllllIIIIlIIIIlllIIlI;
        boolean llllllllllllllllIIIIlIIIIllllIII = (llllllllllllllllIIIIlIIIIlllllII & 1) != 0;
        boolean llllllllllllllllIIIIlIIIIlllIllI = (llllllllllllllllIIIIlIIIIlllllII & 2) != 0;
        String llllllllllllllllIIIIlIIIIlllIlIl = llllllllllllllllIIIIlIIIIllllIlI;
        Section llllllllllllllllIIIIlIIIIlllIlII = llllllllllllllllIIIIlIIIIlllIIlI.stack.peek();
        if (llllllllllllllllIIIIlIIIIlllIlII != null) {
            llllllllllllllllIIIIlIIIIlllIlIl = String.valueOf(new StringBuilder().append(llllllllllllllllIIIIlIIIIlllIlII.getName()).append(llllllllllllllllIIIIlIIIIllllIII ? " -> " : ".").append(llllllllllllllllIIIIlIIIIlllIlIl));
            if (llllllllllllllllIIIIlIIIIlllIlII.isRoot() && !llllllllllllllllIIIIlIIIIllllIII) {
                int llllllllllllllllIIIIlIIIlIIIIIII = llllllllllllllllIIIIlIIIIlllIlII.getName().lastIndexOf(" -> ");
                llllllllllllllllIIIIlIIIIllllIlI = String.valueOf(new StringBuilder().append(llllllllllllllllIIIIlIIIlIIIIIII > -1 ? llllllllllllllllIIIIlIIIIlllIlII.getName().substring(llllllllllllllllIIIIlIIIlIIIIIII + 4) : llllllllllllllllIIIIlIIIIlllIlII.getName()).append(".").append(llllllllllllllllIIIIlIIIIllllIlI));
                llllllllllllllllIIIIlIIIIllllIII = true;
            }
        }
        Section llllllllllllllllIIIIlIIIIlllIIll = llllllllllllllllIIIIlIIIIlllIIlI.get(llllllllllllllllIIIIlIIIIllllIII ? llllllllllllllllIIIIlIIIIllllIlI : llllllllllllllllIIIIlIIIIlllIlIl);
        if (llllllllllllllllIIIIlIIIIllllIII && llllllllllllllllIIIIlIIIIlllIlII != null && llllllllllllllllIIIIlIIIIlllIIlI.active) {
            llllllllllllllllIIIIlIIIIlllIIll = llllllllllllllllIIIIlIIIIlllIIlI.getSubSection(llllllllllllllllIIIIlIIIIlllIlIl, llllllllllllllllIIIIlIIIIlllIlII.getName(), llllllllllllllllIIIIlIIIIlllIIll);
        }
        llllllllllllllllIIIIlIIIIlllIIll.setFine(llllllllllllllllIIIIlIIIIlllIllI).setRoot(llllllllllllllllIIIIlIIIIllllIII);
        llllllllllllllllIIIIlIIIIlllIIlI.stack.push(llllllllllllllllIIIIlIIIIlllIIll);
        return llllllllllllllllIIIIlIIIIlllIIll.start();
    }

    boolean isHead(Section llllllllllllllllIIIIlIIIllIIIIIl) {
        Profiler llllllllllllllllIIIIlIIIllIIIIll;
        return llllllllllllllllIIIIlIIIllIIIIll.stack.peek() == llllllllllllllllIIIIlIIIllIIIIIl;
    }

    public Collection<Section> getSections() {
        Profiler llllllllllllllllIIIIlIIIIIlIlIll;
        return Collections.unmodifiableCollection(llllllllllllllllIIIIlIIIIIlIlIll.sections.values());
    }

    class SubSection
    extends LiveSection {
        private final /* synthetic */ Section root;
        private final /* synthetic */ String baseName;

        @Override
        public Section next(String llIIIIlIllI) {
            SubSection llIIIIlIlll;
            super.stop();
            return llIIIIlIlll.root.next(llIIIIlIllI);
        }

        @Override
        Section invalidate() {
            SubSection llIIIlllIIl;
            llIIIlllIIl.root.invalidate();
            return super.invalidate();
        }

        SubSection(String llIIlIIlIlI, int llIIlIIIIlI, String llIIlIIIIII, Section llIIlIIIlll) {
            SubSection llIIlIIIllI;
            super(llIIlIIlIlI, llIIlIIIIlI);
            llIIlIIIllI.baseName = llIIlIIIIII;
            llIIlIIIllI.root = llIIlIIIlll;
        }

        @Override
        Section getDelegate() {
            SubSection llIIIlIIlll;
            return llIIIlIIlll.root;
        }

        @Override
        public void setInfo(String llIIIlIlIIl) {
            SubSection llIIIlIlIlI;
            llIIIlIlIlI.root.setInfo(llIIIlIlIIl);
            super.setInfo(llIIIlIlIIl);
        }

        @Override
        Section start() {
            SubSection llIIIlIIIIl;
            llIIIlIIIIl.root.start();
            return super.start();
        }

        @Override
        public String getBaseName() {
            SubSection llIIIllIlIl;
            return llIIIllIlIl.baseName;
        }

        @Override
        public Section end() {
            SubSection llIIIIlllII;
            llIIIIlllII.root.stop();
            return super.end();
        }
    }

    public class Section {
        private /* synthetic */ boolean fine;
        private /* synthetic */ boolean root;
        static final /* synthetic */ String SEPARATOR_CHILD;
        static final /* synthetic */ String SEPARATOR_ROOT;
        private final /* synthetic */ String name;
        private /* synthetic */ String info;
        protected /* synthetic */ boolean invalidated;

        void mark() {
        }

        public String getInfo() {
            Section lllllllllllllllllIlIIIIIIIlIlllI;
            return lllllllllllllllllIlIIIIIIIlIlllI.info;
        }

        protected Section stop() {
            Section lllllllllllllllllIlIIIIIIIlIlIIl;
            return lllllllllllllllllIlIIIIIIIlIlIIl;
        }

        public long getTime() {
            return 0L;
        }

        Section start() {
            Section lllllllllllllllllIlIIIIIIIlIllII;
            return lllllllllllllllllIlIIIIIIIlIllII;
        }

        public boolean isFine() {
            Section lllllllllllllllllIlIIIIIIlIIIIIl;
            return lllllllllllllllllIlIIIIIIlIIIIIl.fine;
        }

        public Section next(String lllllllllllllllllIlIIIIIIIlIIIIl) {
            Section lllllllllllllllllIlIIIIIIIlIIIlI;
            lllllllllllllllllIlIIIIIIIlIIIlI.end();
            return lllllllllllllllllIlIIIIIIIlIIIlI.Profiler.this.begin(lllllllllllllllllIlIIIIIIIlIIIIl);
        }

        public final String toString() {
            Section lllllllllllllllllIlIIIIIIIIlIIll;
            return lllllllllllllllllIlIIIIIIIIlIIll.name;
        }

        public long[] getTimes() {
            return new long[1];
        }

        static {
            SEPARATOR_CHILD = ".";
            SEPARATOR_ROOT = " -> ";
        }

        Section setFine(boolean lllllllllllllllllIlIIIIIIlIIlIII) {
            Section lllllllllllllllllIlIIIIIIlIIlIll;
            lllllllllllllllllIlIIIIIIlIIlIll.fine = lllllllllllllllllIlIIIIIIlIIlIII;
            return lllllllllllllllllIlIIIIIIlIIlIll;
        }

        public String getBaseName() {
            Section lllllllllllllllllIlIIIIIIIllIlll;
            return lllllllllllllllllIlIIIIIIIllIlll.name;
        }

        Section invalidate() {
            Section lllllllllllllllllIlIIIIIIllIIlII;
            lllllllllllllllllIlIIIIIIllIIlII.invalidated = true;
            return lllllllllllllllllIlIIIIIIllIIlII;
        }

        public int getCount() {
            return 0;
        }

        Section getDelegate() {
            Section lllllllllllllllllIlIIIIIIllIlIlI;
            return lllllllllllllllllIlIIIIIIllIlIlI;
        }

        public double getSeconds() {
            return 0.0;
        }

        public double getAverageTime() {
            return 0.0;
        }

        Section setRoot(boolean lllllllllllllllllIlIIIIIIlIlIlll) {
            Section lllllllllllllllllIlIIIIIIlIllIlI;
            lllllllllllllllllIlIIIIIIlIllIlI.root = lllllllllllllllllIlIIIIIIlIlIlll;
            return lllllllllllllllllIlIIIIIIlIllIlI;
        }

        Section(String lllllllllllllllllIlIIIIIIlllIIIl) {
            Section lllllllllllllllllIlIIIIIIlllIlII;
            lllllllllllllllllIlIIIIIIlllIlII.name = lllllllllllllllllIlIIIIIIlllIIIl;
            lllllllllllllllllIlIIIIIIlllIlII.info = lllllllllllllllllIlIIIIIIlllIIIl;
        }

        public int getTotalCount() {
            return 0;
        }

        public double getTotalAverageTime() {
            return 0.0;
        }

        public String getName() {
            Section lllllllllllllllllIlIIIIIIIllllIl;
            return lllllllllllllllllIlIIIIIIIllllIl.name;
        }

        public boolean isRoot() {
            Section lllllllllllllllllIlIIIIIIlIlIIll;
            return lllllllllllllllllIlIIIIIIlIlIIll.root;
        }

        public double getTotalSeconds() {
            return 0.0;
        }

        public long getTotalTime() {
            return 0L;
        }

        public Section end() {
            Section lllllllllllllllllIlIIIIIIIlIIllI;
            if (!lllllllllllllllllIlIIIIIIIlIIllI.invalidated) {
                lllllllllllllllllIlIIIIIIIlIIllI.Profiler.this.end(lllllllllllllllllIlIIIIIIIlIIllI);
            }
            return lllllllllllllllllIlIIIIIIIlIIllI;
        }

        public void setInfo(String lllllllllllllllllIlIIIIIIIllIIll) {
            lllllllllllllllllIlIIIIIIIllIIlI.info = lllllllllllllllllIlIIIIIIIllIIll;
        }
    }

    class LiveSection
    extends Section {
        private /* synthetic */ long start;
        private /* synthetic */ long time;
        private /* synthetic */ int count;
        private /* synthetic */ long[] times;
        private /* synthetic */ int cursor;
        private /* synthetic */ long markedTime;
        private /* synthetic */ int markedCount;

        @Override
        public int getCount() {
            LiveSection lllIIIlllIIIIl;
            return lllIIIlllIIIIl.count;
        }

        @Override
        public double getTotalAverageTime() {
            LiveSection lllIIIllIlIlll;
            return lllIIIllIlIlll.count > 0 ? (double)(lllIIIllIlIlll.time + lllIIIllIlIlll.markedTime) / (double)(lllIIIllIlIlll.count + lllIIIllIlIlll.markedCount) : 0.0;
        }

        @Override
        public int getTotalCount() {
            LiveSection lllIIIllIllllI;
            return lllIIIllIllllI.count + lllIIIllIllllI.markedCount;
        }

        @Override
        public long getTotalTime() {
            LiveSection lllIIIllllIIII;
            return lllIIIllllIIII.time + lllIIIllllIIII.markedTime;
        }

        @Override
        public Section end() {
            LiveSection lllIIIlllllIIl;
            lllIIIlllllIIl.stop();
            if (!lllIIIlllllIIl.invalidated) {
                lllIIIlllllIIl.Profiler.this.end(lllIIIlllllIIl);
            }
            return lllIIIlllllIIl;
        }

        @Override
        public double getSeconds() {
            LiveSection lllIIIlllIllII;
            return (double)lllIIIlllIllII.time * 0.001;
        }

        LiveSection(String lllIIlIIIIIIlI, int lllIIlIIIIIIIl) {
            LiveSection lllIIlIIIIIlII;
            super(lllIIlIIIIIIlI);
            lllIIlIIIIIlII.cursor = 0;
            lllIIlIIIIIlII.times = new long[0];
            lllIIlIIIIIlII.start = 0L;
            lllIIlIIIIIlII.cursor = lllIIlIIIIIIIl;
        }

        @Override
        public double getAverageTime() {
            LiveSection lllIIIllIllIlI;
            return lllIIIllIllIlI.count > 0 ? (double)lllIIIllIllIlI.time / (double)lllIIIllIllIlI.count : 0.0;
        }

        @Override
        public long[] getTimes() {
            LiveSection lllIIIlllIIllI;
            long[] lllIIIlllIIlIl = new long[lllIIIlllIIllI.cursor + 1];
            System.arraycopy(lllIIIlllIIllI.times, 0, lllIIIlllIIlIl, 0, Math.min(lllIIIlllIIllI.times.length, lllIIIlllIIllI.cursor));
            lllIIIlllIIlIl[lllIIIlllIIllI.cursor] = lllIIIlllIIllI.time;
            return lllIIIlllIIlIl;
        }

        @Override
        protected Section stop() {
            LiveSection lllIIIlllllIll;
            if (lllIIIlllllIll.start > 0L) {
                lllIIIlllllIll.time += System.currentTimeMillis() - lllIIIlllllIll.start;
            }
            lllIIIlllllIll.start = 0L;
            ++lllIIIlllllIll.count;
            return lllIIIlllllIll;
        }

        @Override
        Section start() {
            LiveSection lllIIIlllllllI;
            lllIIIlllllllI.start = System.currentTimeMillis();
            return lllIIIlllllllI;
        }

        @Override
        public long getTime() {
            LiveSection lllIIIllllIIll;
            return lllIIIllllIIll.time;
        }

        @Override
        void mark() {
            LiveSection lllIIIllllIlIl;
            if (lllIIIllllIlIl.cursor >= lllIIIllllIlIl.times.length) {
                lllIIIllllIlIl.times = Arrays.copyOf(lllIIIllllIlIl.times, lllIIIllllIlIl.cursor + 4);
            }
            lllIIIllllIlIl.times[lllIIIllllIlIl.cursor] = lllIIIllllIlIl.time;
            lllIIIllllIlIl.markedTime += lllIIIllllIlIl.time;
            lllIIIllllIlIl.markedCount += lllIIIllllIlIl.count;
            lllIIIllllIlIl.time = 0L;
            lllIIIllllIlIl.count = 0;
            ++lllIIIllllIlIl.cursor;
        }

        @Override
        public double getTotalSeconds() {
            LiveSection lllIIIlllIlIlI;
            return (double)(lllIIIlllIlIlI.time + lllIIIlllIlIlI.markedTime) * 0.001;
        }
    }
}

