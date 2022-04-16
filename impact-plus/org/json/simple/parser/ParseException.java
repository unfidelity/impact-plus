/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple.parser;

public class ParseException
extends Exception {
    private /* synthetic */ int errorType;
    private /* synthetic */ int position;
    private static final /* synthetic */ long serialVersionUID = -7880698968187728548L;
    public static final /* synthetic */ int ERROR_UNEXPECTED_EXCEPTION;
    public static final /* synthetic */ int ERROR_UNEXPECTED_TOKEN;
    private /* synthetic */ Object unexpectedObject;
    public static final /* synthetic */ int ERROR_UNEXPECTED_CHAR;

    public int getErrorType() {
        ParseException lllllIlllIlll;
        return lllllIlllIlll.errorType;
    }

    public ParseException(int llllllIIllIlI) {
        llllllIIllllI(-1, llllllIIllIlI, null);
        ParseException llllllIIllllI;
    }

    public ParseException(int llllllIIIllll, Object llllllIIIlIlI) {
        llllllIIlIIIl(-1, llllllIIIllll, llllllIIIlIlI);
        ParseException llllllIIlIIIl;
    }

    public void setPosition(int lllllIllIlIlI) {
        lllllIllIlIll.position = lllllIllIlIlI;
    }

    public void setUnexpectedObject(Object lllllIlIlllll) {
        lllllIllIIIlI.unexpectedObject = lllllIlIlllll;
    }

    public void setErrorType(int lllllIlllIIll) {
        lllllIlllIlII.errorType = lllllIlllIIll;
    }

    static {
        ERROR_UNEXPECTED_CHAR = 0;
        ERROR_UNEXPECTED_EXCEPTION = 2;
        ERROR_UNEXPECTED_TOKEN = 1;
    }

    public int getPosition() {
        ParseException lllllIllIlllI;
        return lllllIllIlllI.position;
    }

    public Object getUnexpectedObject() {
        ParseException lllllIllIIllI;
        return lllllIllIIllI.unexpectedObject;
    }

    public ParseException(int llllllIIIIIII, int lllllIllllIll, Object lllllIllllllI) {
        ParseException llllllIIIIIIl;
        llllllIIIIIIl.position = llllllIIIIIII;
        llllllIIIIIIl.errorType = lllllIllllIll;
        llllllIIIIIIl.unexpectedObject = lllllIllllllI;
    }

    public String toString() {
        ParseException lllllIlIlllII;
        StringBuffer lllllIlIllIll = new StringBuffer();
        switch (lllllIlIlllII.errorType) {
            case 0: {
                lllllIlIllIll.append("Unexpected character (").append(lllllIlIlllII.unexpectedObject).append(") at position ").append(lllllIlIlllII.position).append(".");
                break;
            }
            case 1: {
                lllllIlIllIll.append("Unexpected token ").append(lllllIlIlllII.unexpectedObject).append(" at position ").append(lllllIlIlllII.position).append(".");
                break;
            }
            case 2: {
                lllllIlIllIll.append("Unexpected exception at position ").append(lllllIlIlllII.position).append(": ").append(lllllIlIlllII.unexpectedObject);
                break;
            }
            default: {
                lllllIlIllIll.append("Unkown error at position ").append(lllllIlIlllII.position).append(".");
            }
        }
        return lllllIlIllIll.toString();
    }
}

