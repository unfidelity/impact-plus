/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.Yytoken;

class Yylex {
    private static final /* synthetic */ String ZZ_ATTRIBUTE_PACKED_0;
    private static final /* synthetic */ int[] ZZ_ATTRIBUTE;
    private static final /* synthetic */ String ZZ_ROWMAP_PACKED_0;
    private static final /* synthetic */ int[] ZZ_ROWMAP;
    private static final /* synthetic */ int[] ZZ_ACTION;
    private /* synthetic */ int yycolumn;
    public static final /* synthetic */ int YYINITIAL;
    private /* synthetic */ StringBuffer sb;
    private /* synthetic */ int zzMarkedPos;
    private static final /* synthetic */ int ZZ_UNKNOWN_ERROR;
    private /* synthetic */ int zzStartRead;
    private static final /* synthetic */ char[] ZZ_CMAP;
    private static final /* synthetic */ String ZZ_ACTION_PACKED_0;
    private /* synthetic */ char[] zzBuffer;
    private /* synthetic */ int yychar;
    private static final /* synthetic */ String ZZ_CMAP_PACKED;
    private /* synthetic */ int zzCurrentPos;
    private /* synthetic */ int zzState;
    private /* synthetic */ boolean zzAtBOL;
    private static final /* synthetic */ String[] ZZ_ERROR_MSG;
    private /* synthetic */ int zzEndRead;
    public static final /* synthetic */ int YYEOF;
    private static final /* synthetic */ int[] ZZ_LEXSTATE;
    private /* synthetic */ Reader zzReader;
    private static final /* synthetic */ int[] ZZ_TRANS;
    private /* synthetic */ int zzLexicalState;
    private /* synthetic */ int yyline;
    public static final /* synthetic */ int STRING_BEGIN;
    private /* synthetic */ boolean zzAtEOF;
    private static final /* synthetic */ int ZZ_NO_MATCH;
    private static final /* synthetic */ int ZZ_PUSHBACK_2BIG;
    private static final /* synthetic */ int ZZ_BUFFERSIZE;

    private static int[] zzUnpackAttribute() {
        int[] lllllllllllllllllIlllllIIIlIlIlI = new int[45];
        int lllllllllllllllllIlllllIIIlIlIIl = 0;
        lllllllllllllllllIlllllIIIlIlIIl = Yylex.zzUnpackAttribute("\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t", lllllllllllllllllIlllllIIIlIlIIl, lllllllllllllllllIlllllIIIlIlIlI);
        return lllllllllllllllllIlllllIIIlIlIlI;
    }

    private static int[] zzUnpackRowMap() {
        int[] lllllllllllllllllIlllllIIlIIIlIl = new int[45];
        int lllllllllllllllllIlllllIIlIIIlII = 0;
        lllllllllllllllllIlllllIIlIIIlII = Yylex.zzUnpackRowMap("\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u0087\u00006\u0000\u00a2\u0000\u00bd\u0000\u00d8\u00006\u00006\u00006\u00006\u00006\u00006\u0000\u00f3\u0000\u010e\u00006\u0000\u0129\u0000\u0144\u0000\u015f\u0000\u017a\u0000\u0195\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000\u01b0\u0000\u01cb\u0000\u01e6\u0000\u01e6\u0000\u0201\u0000\u021c\u0000\u0237\u0000\u0252\u00006\u00006\u0000\u026d\u0000\u0288\u00006", lllllllllllllllllIlllllIIlIIIlII, lllllllllllllllllIlllllIIlIIIlIl);
        return lllllllllllllllllIlllllIIlIIIlIl;
    }

    public final char yycharat(int lllllllllllllllllIllllIlllIIlIll) {
        Yylex lllllllllllllllllIllllIlllIIllII;
        return lllllllllllllllllIllllIlllIIllII.zzBuffer[lllllllllllllllllIllllIlllIIllII.zzStartRead + lllllllllllllllllIllllIlllIIlIll];
    }

    public void yypushback(int lllllllllllllllllIllllIllIlllIII) {
        Yylex lllllllllllllllllIllllIllIllIlll;
        if (lllllllllllllllllIllllIllIlllIII > lllllllllllllllllIllllIllIllIlll.yylength()) {
            lllllllllllllllllIllllIllIllIlll.zzScanError(2);
        }
        lllllllllllllllllIllllIllIllIlll.zzMarkedPos -= lllllllllllllllllIllllIllIlllIII;
    }

    Yylex(InputStream lllllllllllllllllIlllllIIIIIIIlI) {
        lllllllllllllllllIlllllIIIIIIIIl(new InputStreamReader(lllllllllllllllllIlllllIIIIIIIlI));
        Yylex lllllllllllllllllIlllllIIIIIIIIl;
    }

    private static char[] zzUnpackCMap(String lllllllllllllllllIllllIlllllIlll) {
        char[] lllllllllllllllllIllllIlllllIllI = new char[65536];
        int lllllllllllllllllIllllIlllllIlIl = 0;
        int lllllllllllllllllIllllIlllllIlII = 0;
        while (lllllllllllllllllIllllIlllllIlIl < 90) {
            int lllllllllllllllllIllllIllllllIIl = lllllllllllllllllIllllIlllllIlll.charAt(lllllllllllllllllIllllIlllllIlIl++);
            char lllllllllllllllllIllllIllllllIII = lllllllllllllllllIllllIlllllIlll.charAt(lllllllllllllllllIllllIlllllIlIl++);
            do {
                lllllllllllllllllIllllIlllllIllI[lllllllllllllllllIllllIlllllIlII++] = lllllllllllllllllIllllIllllllIII;
            } while (--lllllllllllllllllIllllIllllllIIl > 0);
        }
        return lllllllllllllllllIllllIlllllIllI;
    }

    public final int yylength() {
        Yylex lllllllllllllllllIllllIlllIIIllI;
        return lllllllllllllllllIllllIlllIIIllI.zzMarkedPos - lllllllllllllllllIllllIlllIIIllI.zzStartRead;
    }

    private boolean zzRefill() throws IOException {
        int lllllllllllllllllIllllIllllIIlll;
        Yylex lllllllllllllllllIllllIllllIlIII;
        if (lllllllllllllllllIllllIllllIlIII.zzStartRead > 0) {
            System.arraycopy(lllllllllllllllllIllllIllllIlIII.zzBuffer, lllllllllllllllllIllllIllllIlIII.zzStartRead, lllllllllllllllllIllllIllllIlIII.zzBuffer, 0, lllllllllllllllllIllllIllllIlIII.zzEndRead - lllllllllllllllllIllllIllllIlIII.zzStartRead);
            lllllllllllllllllIllllIllllIlIII.zzEndRead -= lllllllllllllllllIllllIllllIlIII.zzStartRead;
            lllllllllllllllllIllllIllllIlIII.zzCurrentPos -= lllllllllllllllllIllllIllllIlIII.zzStartRead;
            lllllllllllllllllIllllIllllIlIII.zzMarkedPos -= lllllllllllllllllIllllIllllIlIII.zzStartRead;
            lllllllllllllllllIllllIllllIlIII.zzStartRead = 0;
        }
        if (lllllllllllllllllIllllIllllIlIII.zzCurrentPos >= lllllllllllllllllIllllIllllIlIII.zzBuffer.length) {
            char[] lllllllllllllllllIllllIllllIlIlI = new char[lllllllllllllllllIllllIllllIlIII.zzCurrentPos * 2];
            System.arraycopy(lllllllllllllllllIllllIllllIlIII.zzBuffer, 0, lllllllllllllllllIllllIllllIlIlI, 0, lllllllllllllllllIllllIllllIlIII.zzBuffer.length);
            lllllllllllllllllIllllIllllIlIII.zzBuffer = lllllllllllllllllIllllIllllIlIlI;
        }
        if ((lllllllllllllllllIllllIllllIIlll = lllllllllllllllllIllllIllllIlIII.zzReader.read(lllllllllllllllllIllllIllllIlIII.zzBuffer, lllllllllllllllllIllllIllllIlIII.zzEndRead, lllllllllllllllllIllllIllllIlIII.zzBuffer.length - lllllllllllllllllIllllIllllIlIII.zzEndRead)) > 0) {
            lllllllllllllllllIllllIllllIlIII.zzEndRead += lllllllllllllllllIllllIllllIIlll;
            return false;
        }
        if (lllllllllllllllllIllllIllllIIlll == 0) {
            int lllllllllllllllllIllllIllllIlIIl = lllllllllllllllllIllllIllllIlIII.zzReader.read();
            if (lllllllllllllllllIllllIllllIlIIl == -1) {
                return true;
            }
            lllllllllllllllllIllllIllllIlIII.zzBuffer[lllllllllllllllllIllllIllllIlIII.zzEndRead++] = (char)lllllllllllllllllIllllIllllIlIIl;
            return false;
        }
        return true;
    }

    public final int yystate() {
        Yylex lllllllllllllllllIllllIlllIllIIl;
        return lllllllllllllllllIllllIlllIllIIl.zzLexicalState;
    }

    int getPosition() {
        Yylex lllllllllllllllllIlllllIIIIIllIl;
        return lllllllllllllllllIlllllIIIIIllIl.yychar;
    }

    public Yytoken yylex() throws IOException, ParseException {
        Yylex lllllllllllllllllIllllIllIIllIlI;
        int lllllllllllllllllIllllIllIIlIlIl = lllllllllllllllllIllllIllIIllIlI.zzEndRead;
        char[] lllllllllllllllllIllllIllIIlIIll = lllllllllllllllllIllllIllIIllIlI.zzBuffer;
        char[] lllllllllllllllllIllllIllIIlIIlI = ZZ_CMAP;
        int[] lllllllllllllllllIllllIllIIlIIII = ZZ_TRANS;
        int[] lllllllllllllllllIllllIllIIIllll = ZZ_ROWMAP;
        int[] lllllllllllllllllIllllIllIIIllII = ZZ_ATTRIBUTE;
        block51: while (true) {
            char lllllllllllllllllIllllIllIIllIIl;
            int lllllllllllllllllIllllIllIIlIllI = lllllllllllllllllIllllIllIIllIlI.zzMarkedPos;
            lllllllllllllllllIllllIllIIllIlI.yychar += lllllllllllllllllIllllIllIIlIllI - lllllllllllllllllIllllIllIIllIlI.zzStartRead;
            int lllllllllllllllllIllllIllIIllIII = -1;
            lllllllllllllllllIllllIllIIllIlI.zzCurrentPos = lllllllllllllllllIllllIllIIllIlI.zzStartRead = lllllllllllllllllIllllIllIIlIllI;
            int lllllllllllllllllIllllIllIIlIlll = lllllllllllllllllIllllIllIIllIlI.zzStartRead;
            lllllllllllllllllIllllIllIIllIlI.zzState = ZZ_LEXSTATE[lllllllllllllllllIllllIllIIllIlI.zzLexicalState];
            while (true) {
                if (lllllllllllllllllIllllIllIIlIlll < lllllllllllllllllIllllIllIIlIlIl) {
                    char lllllllllllllllllIllllIllIlIIlIl = lllllllllllllllllIllllIllIIlIIll[lllllllllllllllllIllllIllIIlIlll++];
                } else {
                    if (lllllllllllllllllIllllIllIIllIlI.zzAtEOF) {
                        int lllllllllllllllllIllllIllIlIIlII = -1;
                        break;
                    }
                    lllllllllllllllllIllllIllIIllIlI.zzCurrentPos = lllllllllllllllllIllllIllIIlIlll;
                    lllllllllllllllllIllllIllIIllIlI.zzMarkedPos = lllllllllllllllllIllllIllIIlIllI;
                    boolean lllllllllllllllllIllllIllIlIIIlI = lllllllllllllllllIllllIllIIllIlI.zzRefill();
                    lllllllllllllllllIllllIllIIlIlll = lllllllllllllllllIllllIllIIllIlI.zzCurrentPos;
                    lllllllllllllllllIllllIllIIlIllI = lllllllllllllllllIllllIllIIllIlI.zzMarkedPos;
                    lllllllllllllllllIllllIllIIlIIll = lllllllllllllllllIllllIllIIllIlI.zzBuffer;
                    lllllllllllllllllIllllIllIIlIlIl = lllllllllllllllllIllllIllIIllIlI.zzEndRead;
                    if (lllllllllllllllllIllllIllIlIIIlI) {
                        int lllllllllllllllllIllllIllIlIIIll = -1;
                        break;
                    }
                    lllllllllllllllllIllllIllIIllIIl = lllllllllllllllllIllllIllIIlIIll[lllllllllllllllllIllllIllIIlIlll++];
                }
                int lllllllllllllllllIllllIllIlIIIIl = lllllllllllllllllIllllIllIIlIIII[lllllllllllllllllIllllIllIIIllll[lllllllllllllllllIllllIllIIllIlI.zzState] + lllllllllllllllllIllllIllIIlIIlI[lllllllllllllllllIllllIllIIllIIl]];
                if (lllllllllllllllllIllllIllIlIIIIl == -1) break;
                lllllllllllllllllIllllIllIIllIlI.zzState = lllllllllllllllllIllllIllIlIIIIl;
                int lllllllllllllllllIllllIllIlIIIII = lllllllllllllllllIllllIllIIIllII[lllllllllllllllllIllllIllIIllIlI.zzState];
                if ((lllllllllllllllllIllllIllIlIIIII & 1) != 1) continue;
                lllllllllllllllllIllllIllIIllIII = lllllllllllllllllIllllIllIIllIlI.zzState;
                lllllllllllllllllIllllIllIIlIllI = lllllllllllllllllIllllIllIIlIlll;
                if ((lllllllllllllllllIllllIllIlIIIII & 8) == 8) break;
            }
            lllllllllllllllllIllllIllIIllIlI.zzMarkedPos = lllllllllllllllllIllllIllIIlIllI;
            switch (lllllllllllllllllIllllIllIIllIII < 0 ? lllllllllllllllllIllllIllIIllIII : ZZ_ACTION[lllllllllllllllllIllllIllIIllIII]) {
                case 11: {
                    lllllllllllllllllIllllIllIIllIlI.sb.append(lllllllllllllllllIllllIllIIllIlI.yytext());
                }
                case 25: {
                    continue block51;
                }
                case 4: {
                    lllllllllllllllllIllllIllIIllIlI.sb.delete(0, lllllllllllllllllIllllIllIIllIlI.sb.length());
                    lllllllllllllllllIllllIllIIllIlI.yybegin(2);
                }
                case 26: {
                    continue block51;
                }
                case 16: {
                    lllllllllllllllllIllllIllIIllIlI.sb.append('\b');
                }
                case 27: {
                    continue block51;
                }
                case 6: {
                    return new Yytoken(2, null);
                }
                case 28: {
                    continue block51;
                }
                case 23: {
                    Boolean lllllllllllllllllIllllIllIIlllll = Boolean.valueOf(lllllllllllllllllIllllIllIIllIlI.yytext());
                    return new Yytoken(0, lllllllllllllllllIllllIllIIlllll);
                }
                case 29: {
                    continue block51;
                }
                case 22: {
                    return new Yytoken(0, null);
                }
                case 30: {
                    continue block51;
                }
                case 13: {
                    lllllllllllllllllIllllIllIIllIlI.yybegin(0);
                    return new Yytoken(0, lllllllllllllllllIllllIllIIllIlI.sb.toString());
                }
                case 31: {
                    continue block51;
                }
                case 12: {
                    lllllllllllllllllIllllIllIIllIlI.sb.append('\\');
                }
                case 32: {
                    continue block51;
                }
                case 21: {
                    Double lllllllllllllllllIllllIllIIllllI = Double.valueOf(lllllllllllllllllIllllIllIIllIlI.yytext());
                    return new Yytoken(0, lllllllllllllllllIllllIllIIllllI);
                }
                case 33: {
                    continue block51;
                }
                case 1: {
                    throw new ParseException(lllllllllllllllllIllllIllIIllIlI.yychar, 0, new Character(lllllllllllllllllIllllIllIIllIlI.yycharat(0)));
                }
                case 34: {
                    continue block51;
                }
                case 8: {
                    return new Yytoken(4, null);
                }
                case 35: {
                    continue block51;
                }
                case 19: {
                    lllllllllllllllllIllllIllIIllIlI.sb.append('\r');
                }
                case 36: {
                    continue block51;
                }
                case 15: {
                    lllllllllllllllllIllllIllIIllIlI.sb.append('/');
                }
                case 37: {
                    continue block51;
                }
                case 10: {
                    return new Yytoken(6, null);
                }
                case 38: {
                    continue block51;
                }
                case 14: {
                    lllllllllllllllllIllllIllIIllIlI.sb.append('\"');
                }
                case 39: {
                    continue block51;
                }
                case 5: {
                    return new Yytoken(1, null);
                }
                case 40: {
                    continue block51;
                }
                case 17: {
                    lllllllllllllllllIllllIllIIllIlI.sb.append('\f');
                }
                case 41: {
                    continue block51;
                }
                case 24: {
                    try {
                        int lllllllllllllllllIllllIllIIlllIl = Integer.parseInt(lllllllllllllllllIllllIllIIllIlI.yytext().substring(2), 16);
                        lllllllllllllllllIllllIllIIllIlI.sb.append((char)lllllllllllllllllIllllIllIIlllIl);
                    }
                    catch (Exception lllllllllllllllllIllllIllIIlllII) {
                        throw new ParseException(lllllllllllllllllIllllIllIIllIlI.yychar, 2, lllllllllllllllllIllllIllIIlllII);
                    }
                }
                case 42: {
                    continue block51;
                }
                case 20: {
                    lllllllllllllllllIllllIllIIllIlI.sb.append('\t');
                }
                case 43: {
                    continue block51;
                }
                case 7: {
                    return new Yytoken(3, null);
                }
                case 44: {
                    continue block51;
                }
                case 2: {
                    Long lllllllllllllllllIllllIllIIllIll = Long.valueOf(lllllllllllllllllIllllIllIIllIlI.yytext());
                    return new Yytoken(0, lllllllllllllllllIllllIllIIllIll);
                }
                case 45: {
                    continue block51;
                }
                case 18: {
                    lllllllllllllllllIllllIllIIllIlI.sb.append('\n');
                }
                case 46: {
                    continue block51;
                }
                case 9: {
                    return new Yytoken(5, null);
                }
                case 47: {
                    continue block51;
                }
                case 3: 
                case 48: {
                    continue block51;
                }
            }
            if (lllllllllllllllllIllllIllIIllIIl == '\uffffffff' && lllllllllllllllllIllllIllIIllIlI.zzStartRead == lllllllllllllllllIllllIllIIllIlI.zzCurrentPos) {
                lllllllllllllllllIllllIllIIllIlI.zzAtEOF = true;
                return null;
            }
            lllllllllllllllllIllllIllIIllIlI.zzScanError(1);
        }
    }

    private static int zzUnpackAttribute(String lllllllllllllllllIlllllIIIIlIllI, int lllllllllllllllllIlllllIIIIlIlIl, int[] lllllllllllllllllIlllllIIIIlIlII) {
        int lllllllllllllllllIlllllIIIIllIIl = 0;
        int lllllllllllllllllIlllllIIIIllIII = lllllllllllllllllIlllllIIIIlIlIl;
        int lllllllllllllllllIlllllIIIIlIlll = lllllllllllllllllIlllllIIIIlIllI.length();
        while (lllllllllllllllllIlllllIIIIllIIl < lllllllllllllllllIlllllIIIIlIlll) {
            int lllllllllllllllllIlllllIIIIllllI = lllllllllllllllllIlllllIIIIlIllI.charAt(lllllllllllllllllIlllllIIIIllIIl++);
            char lllllllllllllllllIlllllIIIIlllIl = lllllllllllllllllIlllllIIIIlIllI.charAt(lllllllllllllllllIlllllIIIIllIIl++);
            do {
                lllllllllllllllllIlllllIIIIlIlII[lllllllllllllllllIlllllIIIIllIII++] = lllllllllllllllllIlllllIIIIlllIl;
            } while (--lllllllllllllllllIlllllIIIIllllI > 0);
        }
        return lllllllllllllllllIlllllIIIIllIII;
    }

    private static int zzUnpackAction(String lllllllllllllllllIlllllIIlIIllll, int lllllllllllllllllIlllllIIlIIlllI, int[] lllllllllllllllllIlllllIIlIIllIl) {
        int lllllllllllllllllIlllllIIlIlIIlI = 0;
        int lllllllllllllllllIlllllIIlIlIIIl = lllllllllllllllllIlllllIIlIIlllI;
        int lllllllllllllllllIlllllIIlIlIIII = lllllllllllllllllIlllllIIlIIllll.length();
        while (lllllllllllllllllIlllllIIlIlIIlI < lllllllllllllllllIlllllIIlIlIIII) {
            int lllllllllllllllllIlllllIIlIlIlll = lllllllllllllllllIlllllIIlIIllll.charAt(lllllllllllllllllIlllllIIlIlIIlI++);
            char lllllllllllllllllIlllllIIlIlIllI = lllllllllllllllllIlllllIIlIIllll.charAt(lllllllllllllllllIlllllIIlIlIIlI++);
            do {
                lllllllllllllllllIlllllIIlIIllIl[lllllllllllllllllIlllllIIlIlIIIl++] = lllllllllllllllllIlllllIIlIlIllI;
            } while (--lllllllllllllllllIlllllIIlIlIlll > 0);
        }
        return lllllllllllllllllIlllllIIlIlIIIl;
    }

    public final void yyclose() throws IOException {
        Yylex lllllllllllllllllIllllIllllIIIlI;
        lllllllllllllllllIllllIllllIIIlI.zzAtEOF = true;
        lllllllllllllllllIllllIllllIIIlI.zzEndRead = lllllllllllllllllIllllIllllIIIlI.zzStartRead;
        if (lllllllllllllllllIllllIllllIIIlI.zzReader != null) {
            lllllllllllllllllIllllIllllIIIlI.zzReader.close();
        }
    }

    Yylex(Reader lllllllllllllllllIlllllIIIIIlIII) {
        Yylex lllllllllllllllllIlllllIIIIIlIIl;
        lllllllllllllllllIlllllIIIIIlIIl.zzLexicalState = 0;
        lllllllllllllllllIlllllIIIIIlIIl.zzBuffer = new char[16384];
        lllllllllllllllllIlllllIIIIIlIIl.zzAtBOL = true;
        lllllllllllllllllIlllllIIIIIlIIl.sb = new StringBuffer();
        lllllllllllllllllIlllllIIIIIlIIl.zzReader = lllllllllllllllllIlllllIIIIIlIII;
    }

    public final String yytext() {
        Yylex lllllllllllllllllIllllIlllIlIIII;
        return new String(lllllllllllllllllIllllIlllIlIIII.zzBuffer, lllllllllllllllllIllllIlllIlIIII.zzStartRead, lllllllllllllllllIllllIlllIlIIII.zzMarkedPos - lllllllllllllllllIllllIlllIlIIII.zzStartRead);
    }

    private void zzScanError(int lllllllllllllllllIllllIllIlllllI) {
        String lllllllllllllllllIllllIllIllllll;
        try {
            lllllllllllllllllIllllIllIllllll = ZZ_ERROR_MSG[lllllllllllllllllIllllIllIlllllI];
        }
        catch (ArrayIndexOutOfBoundsException lllllllllllllllllIllllIlllIIIIlI) {
            lllllllllllllllllIllllIllIllllll = ZZ_ERROR_MSG[0];
        }
        throw new Error(lllllllllllllllllIllllIllIllllll);
    }

    private static int zzUnpackRowMap(String lllllllllllllllllIlllllIIIlllIIl, int lllllllllllllllllIlllllIIIllIIlI, int[] lllllllllllllllllIlllllIIIllIIIl) {
        int lllllllllllllllllIlllllIIIllIllI = 0;
        int lllllllllllllllllIlllllIIIllIlIl = lllllllllllllllllIlllllIIIllIIlI;
        int lllllllllllllllllIlllllIIIllIlII = lllllllllllllllllIlllllIIIlllIIl.length();
        while (lllllllllllllllllIlllllIIIllIllI < lllllllllllllllllIlllllIIIllIlII) {
            int lllllllllllllllllIlllllIIIlllIlI = lllllllllllllllllIlllllIIIlllIIl.charAt(lllllllllllllllllIlllllIIIllIllI++) << 16;
            lllllllllllllllllIlllllIIIllIIIl[lllllllllllllllllIlllllIIIllIlIl++] = lllllllllllllllllIlllllIIIlllIlI | lllllllllllllllllIlllllIIIlllIIl.charAt(lllllllllllllllllIlllllIIIllIllI++);
        }
        return lllllllllllllllllIlllllIIIllIlIl;
    }

    public final void yybegin(int lllllllllllllllllIllllIlllIlIlII) {
        lllllllllllllllllIllllIlllIlIlIl.zzLexicalState = lllllllllllllllllIllllIlllIlIlII;
    }

    public final void yyreset(Reader lllllllllllllllllIllllIlllIlllIl) {
        lllllllllllllllllIllllIlllIlllII.zzReader = lllllllllllllllllIllllIlllIlllIl;
        lllllllllllllllllIllllIlllIlllII.zzAtBOL = true;
        lllllllllllllllllIllllIlllIlllII.zzAtEOF = false;
        lllllllllllllllllIllllIlllIlllII.zzStartRead = 0;
        lllllllllllllllllIllllIlllIlllII.zzEndRead = 0;
        lllllllllllllllllIllllIlllIlllII.zzMarkedPos = 0;
        lllllllllllllllllIllllIlllIlllII.zzCurrentPos = 0;
        lllllllllllllllllIllllIlllIlllII.yycolumn = 0;
        lllllllllllllllllIllllIlllIlllII.yychar = 0;
        lllllllllllllllllIllllIlllIlllII.yyline = 0;
        lllllllllllllllllIllllIlllIlllII.zzLexicalState = 0;
    }

    private static int[] zzUnpackAction() {
        int[] lllllllllllllllllIlllllIIllIIIll = new int[45];
        int lllllllllllllllllIlllllIIllIIIlI = 0;
        lllllllllllllllllIlllllIIllIIIlI = Yylex.zzUnpackAction("\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018", lllllllllllllllllIlllllIIllIIIlI, lllllllllllllllllIlllllIIllIIIll);
        return lllllllllllllllllIlllllIIllIIIll;
    }

    static {
        ZZ_CMAP_PACKED = "\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016\uff82\u0000";
        ZZ_UNKNOWN_ERROR = 0;
        ZZ_PUSHBACK_2BIG = 2;
        ZZ_ATTRIBUTE_PACKED_0 = "\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t";
        ZZ_NO_MATCH = 1;
        ZZ_ACTION_PACKED_0 = "\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018";
        STRING_BEGIN = 2;
        ZZ_ROWMAP_PACKED_0 = "\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u0087\u00006\u0000\u00a2\u0000\u00bd\u0000\u00d8\u00006\u00006\u00006\u00006\u00006\u00006\u0000\u00f3\u0000\u010e\u00006\u0000\u0129\u0000\u0144\u0000\u015f\u0000\u017a\u0000\u0195\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000\u01b0\u0000\u01cb\u0000\u01e6\u0000\u01e6\u0000\u0201\u0000\u021c\u0000\u0237\u0000\u0252\u00006\u00006\u0000\u026d\u0000\u0288\u00006";
        ZZ_BUFFERSIZE = 16384;
        YYEOF = -1;
        YYINITIAL = 0;
        ZZ_LEXSTATE = new int[]{0, 0, 1, 1};
        ZZ_CMAP = Yylex.zzUnpackCMap("\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016\uff82\u0000");
        ZZ_ACTION = Yylex.zzUnpackAction();
        ZZ_ROWMAP = Yylex.zzUnpackRowMap();
        ZZ_TRANS = new int[]{2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
        ZZ_ERROR_MSG = new String[]{"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
        ZZ_ATTRIBUTE = Yylex.zzUnpackAttribute();
    }
}

