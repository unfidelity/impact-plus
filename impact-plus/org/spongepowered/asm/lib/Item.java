/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

final class Item {
    /* synthetic */ String strVal1;
    /* synthetic */ String strVal3;
    /* synthetic */ String strVal2;
    /* synthetic */ int hashCode;
    /* synthetic */ int type;
    /* synthetic */ long longVal;
    /* synthetic */ int intVal;
    /* synthetic */ int index;
    /* synthetic */ Item next;

    Item(int lllIllIlIIIIIl, Item lllIllIlIIIIll) {
        Item lllIllIlIIIlIl;
        lllIllIlIIIlIl.index = lllIllIlIIIIIl;
        lllIllIlIIIlIl.type = lllIllIlIIIIll.type;
        lllIllIlIIIlIl.intVal = lllIllIlIIIIll.intVal;
        lllIllIlIIIlIl.longVal = lllIllIlIIIIll.longVal;
        lllIllIlIIIlIl.strVal1 = lllIllIlIIIIll.strVal1;
        lllIllIlIIIlIl.strVal2 = lllIllIlIIIIll.strVal2;
        lllIllIlIIIlIl.strVal3 = lllIllIlIIIIll.strVal3;
        lllIllIlIIIlIl.hashCode = lllIllIlIIIIll.hashCode;
    }

    void set(double lllIllIIIlllII) {
        Item lllIllIIIlllIl;
        lllIllIIIlllIl.type = 6;
        lllIllIIIlllIl.longVal = Double.doubleToRawLongBits(lllIllIIIlllII);
        lllIllIIIlllIl.hashCode = Integer.MAX_VALUE & lllIllIIIlllIl.type + (int)lllIllIIIlllII;
    }

    void set(int lllIlIllIllllI, int lllIlIllIlIlll) {
        lllIlIllIllIlI.type = 33;
        lllIlIllIllIlI.intVal = lllIlIllIllllI;
        lllIlIllIllIlI.hashCode = lllIlIllIlIlll;
    }

    void set(int lllIllIIlllIlI) {
        Item lllIllIIllllIl;
        lllIllIIllllIl.type = 3;
        lllIllIIllllIl.intVal = lllIllIIlllIlI;
        lllIllIIllllIl.hashCode = Integer.MAX_VALUE & lllIllIIllllIl.type + lllIllIIlllIlI;
    }

    void set(String lllIlIlllIlIIl, String lllIlIlllIllII, int lllIlIlllIlIll) {
        Item lllIlIlllIlIlI;
        lllIlIlllIlIlI.type = 18;
        lllIlIlllIlIlI.longVal = lllIlIlllIlIll;
        lllIlIlllIlIlI.strVal1 = lllIlIlllIlIIl;
        lllIlIlllIlIlI.strVal2 = lllIlIlllIllII;
        lllIlIlllIlIlI.hashCode = Integer.MAX_VALUE & 18 + lllIlIlllIlIll * lllIlIlllIlIlI.strVal1.hashCode() * lllIlIlllIlIlI.strVal2.hashCode();
    }

    void set(float lllIllIIlIllIl) {
        Item lllIllIIlIlllI;
        lllIllIIlIlllI.type = 4;
        lllIllIIlIlllI.intVal = Float.floatToRawIntBits(lllIllIIlIllIl);
        lllIllIIlIlllI.hashCode = Integer.MAX_VALUE & lllIllIIlIlllI.type + (int)lllIllIIlIllIl;
    }

    Item(int lllIllIlIIlIll) {
        Item lllIllIlIIlIlI;
        lllIllIlIIlIlI.index = lllIllIlIIlIll;
    }

    void set(int lllIllIIIIllIl, String lllIllIIIIIlll, String lllIllIIIIlIll, String lllIllIIIIIlIl) {
        lllIllIIIIlIIl.type = lllIllIIIIllIl;
        lllIllIIIIlIIl.strVal1 = lllIllIIIIIlll;
        lllIllIIIIlIIl.strVal2 = lllIllIIIIlIll;
        lllIllIIIIlIIl.strVal3 = lllIllIIIIIlIl;
        switch (lllIllIIIIllIl) {
            case 7: {
                lllIllIIIIlIIl.intVal = 0;
            }
            case 1: 
            case 8: 
            case 16: 
            case 30: {
                lllIllIIIIlIIl.hashCode = Integer.MAX_VALUE & lllIllIIIIllIl + lllIllIIIIIlll.hashCode();
                return;
            }
            case 12: {
                lllIllIIIIlIIl.hashCode = Integer.MAX_VALUE & lllIllIIIIllIl + lllIllIIIIIlll.hashCode() * lllIllIIIIlIll.hashCode();
                return;
            }
        }
        lllIllIIIIlIIl.hashCode = Integer.MAX_VALUE & lllIllIIIIllIl + lllIllIIIIIlll.hashCode() * lllIllIIIIlIll.hashCode() * lllIllIIIIIlIl.hashCode();
    }

    boolean isEqualTo(Item lllIlIlIIllIll) {
        Item lllIlIlIIlllII;
        switch (lllIlIlIIlllII.type) {
            case 1: 
            case 7: 
            case 8: 
            case 16: 
            case 30: {
                return lllIlIlIIllIll.strVal1.equals(lllIlIlIIlllII.strVal1);
            }
            case 5: 
            case 6: 
            case 32: {
                return lllIlIlIIllIll.longVal == lllIlIlIIlllII.longVal;
            }
            case 3: 
            case 4: {
                return lllIlIlIIllIll.intVal == lllIlIlIIlllII.intVal;
            }
            case 31: {
                return lllIlIlIIllIll.intVal == lllIlIlIIlllII.intVal && lllIlIlIIllIll.strVal1.equals(lllIlIlIIlllII.strVal1);
            }
            case 12: {
                return lllIlIlIIllIll.strVal1.equals(lllIlIlIIlllII.strVal1) && lllIlIlIIllIll.strVal2.equals(lllIlIlIIlllII.strVal2);
            }
            case 18: {
                return lllIlIlIIllIll.longVal == lllIlIlIIlllII.longVal && lllIlIlIIllIll.strVal1.equals(lllIlIlIIlllII.strVal1) && lllIlIlIIllIll.strVal2.equals(lllIlIlIIlllII.strVal2);
            }
        }
        return lllIlIlIIllIll.strVal1.equals(lllIlIlIIlllII.strVal1) && lllIlIlIIllIll.strVal2.equals(lllIlIlIIlllII.strVal2) && lllIlIlIIllIll.strVal3.equals(lllIlIlIIlllII.strVal3);
    }

    void set(long lllIllIIllIlIl) {
        Item lllIllIIllIlII;
        lllIllIIllIlII.type = 5;
        lllIllIIllIlII.longVal = lllIllIIllIlIl;
        lllIllIIllIlII.hashCode = Integer.MAX_VALUE & lllIllIIllIlII.type + (int)lllIllIIllIlIl;
    }

    Item() {
        Item lllIllIlIlIIII;
    }
}

