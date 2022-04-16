/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple.parser;

public class Yytoken {
    public static final /* synthetic */ int TYPE_EOF;
    public /* synthetic */ Object value;
    public static final /* synthetic */ int TYPE_VALUE;
    public static final /* synthetic */ int TYPE_COLON;
    public static final /* synthetic */ int TYPE_LEFT_BRACE;
    public /* synthetic */ int type;
    public static final /* synthetic */ int TYPE_RIGHT_BRACE;
    public static final /* synthetic */ int TYPE_LEFT_SQUARE;
    public static final /* synthetic */ int TYPE_COMMA;
    public static final /* synthetic */ int TYPE_RIGHT_SQUARE;

    public Yytoken(int lIlllllllIIlIl, Object lIlllllllIIlII) {
        Yytoken lIlllllllIIllI;
        lIlllllllIIllI.type = 0;
        lIlllllllIIllI.value = null;
        lIlllllllIIllI.type = lIlllllllIIlIl;
        lIlllllllIIllI.value = lIlllllllIIlII;
    }

    public String toString() {
        Yytoken lIllllllIlllII;
        StringBuffer lIllllllIlllIl = new StringBuffer();
        switch (lIllllllIlllII.type) {
            case 0: {
                lIllllllIlllIl.append("VALUE(").append(lIllllllIlllII.value).append(")");
                break;
            }
            case 1: {
                lIllllllIlllIl.append("LEFT BRACE({)");
                break;
            }
            case 2: {
                lIllllllIlllIl.append("RIGHT BRACE(})");
                break;
            }
            case 3: {
                lIllllllIlllIl.append("LEFT SQUARE([)");
                break;
            }
            case 4: {
                lIllllllIlllIl.append("RIGHT SQUARE(])");
                break;
            }
            case 5: {
                lIllllllIlllIl.append("COMMA(,)");
                break;
            }
            case 6: {
                lIllllllIlllIl.append("COLON(:)");
                break;
            }
            case -1: {
                lIllllllIlllIl.append("END OF FILE");
            }
        }
        return lIllllllIlllIl.toString();
    }

    static {
        TYPE_COMMA = 5;
        TYPE_RIGHT_BRACE = 2;
        TYPE_LEFT_BRACE = 1;
        TYPE_COLON = 6;
        TYPE_RIGHT_SQUARE = 4;
        TYPE_LEFT_SQUARE = 3;
        TYPE_EOF = -1;
        TYPE_VALUE = 0;
    }
}

