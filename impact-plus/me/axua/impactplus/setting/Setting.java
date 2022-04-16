/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.setting;

import java.util.List;
import me.axua.impactplus.module.Module;

public class Setting {
    private final /* synthetic */ Module parent;
    private final /* synthetic */ String name;
    private final /* synthetic */ Type type;

    public String getName() {
        Setting lllllllllllllllllllIIlIlIlIIllIl;
        return lllllllllllllllllllIIlIlIlIIllIl.name;
    }

    public Setting(String lllllllllllllllllllIIlIlIlIllIII, Module lllllllllllllllllllIIlIlIlIlIlll, Type lllllllllllllllllllIIlIlIlIlIlIl) {
        Setting lllllllllllllllllllIIlIlIlIllllI;
        lllllllllllllllllllIIlIlIlIllllI.name = lllllllllllllllllllIIlIlIlIllIII;
        lllllllllllllllllllIIlIlIlIllllI.parent = lllllllllllllllllllIIlIlIlIlIlll;
        lllllllllllllllllllIIlIlIlIllllI.type = lllllllllllllllllllIIlIlIlIlIlIl;
    }

    public Type getType() {
        Setting lllllllllllllllllllIIlIlIIllIlIl;
        return lllllllllllllllllllIIlIlIIllIlIl.type;
    }

    public Module getParent() {
        Setting lllllllllllllllllllIIlIlIlIIIIlI;
        return lllllllllllllllllllIIlIlIlIIIIlI.parent;
    }

    public static class s
    extends Setting {
        private /* synthetic */ String value;

        public void setValue(String lIIIIIlIlIlIIIl) {
            lIIIIIlIlIlIIlI.value = lIIIIIlIlIlIIIl;
        }

        public String getValue() {
            s lIIIIIlIlIllIll;
            return lIIIIIlIlIllIll.value;
        }

        public s(String lIIIIIlIllIIlII, Module lIIIIIlIllIIlll, String lIIIIIlIllIIIlI) {
            super(lIIIIIlIllIIlII, lIIIIIlIllIIlll, Type.STRING);
            s lIIIIIlIllIIlIl;
            lIIIIIlIllIIlIl.value = lIIIIIlIllIIIlI;
        }
    }

    public static enum Type {
        INT,
        DOUBLE,
        BOOLEAN,
        STRING,
        MODE;


        private Type() {
            Type lllllllllllllllllIlllIIlIIlIIIlI;
        }
    }

    public static class mode
    extends Setting {
        private final /* synthetic */ List<String> modes;
        private /* synthetic */ String value;

        public void setValue(String lllllllllllllllllIIIlIllllllllIl) {
            lllllllllllllllllIIIlIlllllllllI.value = lllllllllllllllllIIIlIllllllllIl;
        }

        public List<String> getModes() {
            mode lllllllllllllllllIIIlIlllllllIIl;
            return lllllllllllllllllIIIlIlllllllIIl.modes;
        }

        public mode(String lllllllllllllllllIIIllIIIIIlIIIl, Module lllllllllllllllllIIIllIIIIIIIllI, List<String> lllllllllllllllllIIIllIIIIIIllIl, String lllllllllllllllllIIIllIIIIIIIlII) {
            super(lllllllllllllllllIIIllIIIIIlIIIl, lllllllllllllllllIIIllIIIIIIIllI, Type.MODE);
            mode lllllllllllllllllIIIllIIIIIlIIll;
            lllllllllllllllllIIIllIIIIIlIIll.value = lllllllllllllllllIIIllIIIIIIIlII;
            lllllllllllllllllIIIllIIIIIlIIll.modes = lllllllllllllllllIIIllIIIIIIllIl;
        }

        public String getValue() {
            mode lllllllllllllllllIIIllIIIIIIIIIl;
            return lllllllllllllllllIIIllIIIIIIIIIl.value;
        }
    }

    public static class d
    extends Setting {
        private /* synthetic */ double value;
        private final /* synthetic */ double min;
        private final /* synthetic */ double max;

        public double getMin() {
            d lllllllllllllllIlllIIIlIIIIIlllI;
            return lllllllllllllllIlllIIIlIIIIIlllI.min;
        }

        public double getValue() {
            d lllllllllllllllIlllIIIlIIIIlIlll;
            return lllllllllllllllIlllIIIlIIIIlIlll.value;
        }

        public void setValue(double lllllllllllllllIlllIIIlIIIIlIIlI) {
            lllllllllllllllIlllIIIlIIIIlIIll.value = lllllllllllllllIlllIIIlIIIIlIIlI;
        }

        public d(String lllllllllllllllIlllIIIlIIIlIIllI, Module lllllllllllllllIlllIIIlIIIlIIlII, double lllllllllllllllIlllIIIlIIIlIIIlI, double lllllllllllllllIlllIIIlIIIlIIIII, double lllllllllllllllIlllIIIlIIIIlllll) {
            super(lllllllllllllllIlllIIIlIIIlIIllI, lllllllllllllllIlllIIIlIIIlIIlII, Type.DOUBLE);
            d lllllllllllllllIlllIIIlIIIlIlIII;
            lllllllllllllllIlllIIIlIIIlIlIII.value = lllllllllllllllIlllIIIlIIIlIIIlI;
            lllllllllllllllIlllIIIlIIIlIlIII.min = lllllllllllllllIlllIIIlIIIlIIIII;
            lllllllllllllllIlllIIIlIIIlIlIII.max = lllllllllllllllIlllIIIlIIIIlllll;
        }

        public double getMax() {
            d lllllllllllllllIlllIIIlIIIIIlIlI;
            return lllllllllllllllIlllIIIlIIIIIlIlI.max;
        }
    }

    public static class i
    extends Setting {
        private final /* synthetic */ int min;
        private final /* synthetic */ int max;
        private /* synthetic */ int value;

        public i(String llllllllllllllllIlIIIllIIllllIIl, Module llllllllllllllllIlIIIllIIlllIlll, int llllllllllllllllIlIIIllIlIIIIIII, int llllllllllllllllIlIIIllIIlllllll, int llllllllllllllllIlIIIllIIlllIIIl) {
            super(llllllllllllllllIlIIIllIIllllIIl, llllllllllllllllIlIIIllIIlllIlll, Type.INT);
            i llllllllllllllllIlIIIllIlIIIIlII;
            llllllllllllllllIlIIIllIlIIIIlII.value = llllllllllllllllIlIIIllIlIIIIIII;
            llllllllllllllllIlIIIllIlIIIIlII.min = llllllllllllllllIlIIIllIIlllllll;
            llllllllllllllllIlIIIllIlIIIIlII.max = llllllllllllllllIlIIIllIIlllIIIl;
        }

        public void setValue(int llllllllllllllllIlIIIllIIllIIlIl) {
            llllllllllllllllIlIIIllIIllIIllI.value = llllllllllllllllIlIIIllIIllIIlIl;
        }

        public int getValue() {
            i llllllllllllllllIlIIIllIIllIlIlI;
            return llllllllllllllllIlIIIllIIllIlIlI.value;
        }

        public int getMin() {
            i llllllllllllllllIlIIIllIIllIIIII;
            return llllllllllllllllIlIIIllIIllIIIII.min;
        }

        public int getMax() {
            i llllllllllllllllIlIIIllIIlIllIll;
            return llllllllllllllllIlIIIllIIlIllIll.max;
        }
    }

    public static class b
    extends Setting {
        private /* synthetic */ boolean value;

        public b(String lllllllllllllllIlllIIlllIIlIIIII, Module lllllllllllllllIlllIIlllIIIlllll, boolean lllllllllllllllIlllIIlllIIIllllI) {
            super(lllllllllllllllIlllIIlllIIlIIIII, lllllllllllllllIlllIIlllIIIlllll, Type.BOOLEAN);
            b lllllllllllllllIlllIIlllIIIlllIl;
            lllllllllllllllIlllIIlllIIIlllIl.value = lllllllllllllllIlllIIlllIIIllllI;
        }

        public boolean getValue() {
            b lllllllllllllllIlllIIlllIIIlIIlI;
            return lllllllllllllllIlllIIlllIIIlIIlI.value;
        }

        public void setValue(boolean lllllllllllllllIlllIIlllIIIIlIll) {
            lllllllllllllllIlllIIlllIIIIlllI.value = lllllllllllllllIlllIIlllIIIIlIll;
        }
    }
}

