/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONAware;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class JSONObject
extends HashMap
implements JSONAware,
JSONStreamAware,
Map {
    private static final /* synthetic */ long serialVersionUID = -503443796854799292L;

    public void writeJSONString(Writer lllIlIIlllllIIl) throws IOException {
        JSONObject lllIlIIlllllIlI;
        JSONObject.writeJSONString(lllIlIIlllllIlI, lllIlIIlllllIIl);
    }

    public JSONObject(Map lllIlIlIIIlIIII) {
        super(lllIlIlIIIlIIII);
        JSONObject lllIlIlIIIIllll;
    }

    public static String escape(String lllIlIIllIlIIII) {
        return JSONValue.escape(lllIlIIllIlIIII);
    }

    public String toString() {
        JSONObject lllIlIIllIlllII;
        return lllIlIIllIlllII.toJSONString();
    }

    public static void writeJSONString(Map lllIlIlIIIIIlll, Writer lllIlIlIIIIIIlI) throws IOException {
        if (lllIlIlIIIIIlll == null) {
            lllIlIlIIIIIIlI.write("null");
            return;
        }
        boolean lllIlIlIIIIIlIl = true;
        Iterator lllIlIlIIIIIlII = lllIlIlIIIIIlll.entrySet().iterator();
        lllIlIlIIIIIIlI.write(123);
        while (lllIlIlIIIIIlII.hasNext()) {
            if (lllIlIlIIIIIlIl) {
                lllIlIlIIIIIlIl = false;
            } else {
                lllIlIlIIIIIIlI.write(44);
            }
            Map.Entry lllIlIlIIIIlIII = lllIlIlIIIIIlII.next();
            lllIlIlIIIIIIlI.write(34);
            lllIlIlIIIIIIlI.write(JSONObject.escape(String.valueOf(lllIlIlIIIIlIII.getKey())));
            lllIlIlIIIIIIlI.write(34);
            lllIlIlIIIIIIlI.write(58);
            JSONValue.writeJSONString(lllIlIlIIIIlIII.getValue(), lllIlIlIIIIIIlI);
        }
        lllIlIlIIIIIIlI.write(125);
    }

    public static String toString(String lllIlIIllIlIlll, Object lllIlIIllIlIllI) {
        StringBuffer lllIlIIllIlIlIl = new StringBuffer();
        JSONObject.toJSONString(lllIlIIllIlIlll, lllIlIIllIlIllI, lllIlIIllIlIlIl);
        return lllIlIIllIlIlIl.toString();
    }

    private static String toJSONString(String lllIlIIlllIIIII, Object lllIlIIllIlllll, StringBuffer lllIlIIlllIIIIl) {
        lllIlIIlllIIIIl.append('\"');
        if (lllIlIIlllIIIII == null) {
            lllIlIIlllIIIIl.append("null");
        } else {
            JSONValue.escape(lllIlIIlllIIIII, lllIlIIlllIIIIl);
        }
        lllIlIIlllIIIIl.append('\"').append(':');
        lllIlIIlllIIIIl.append(JSONValue.toJSONString(lllIlIIllIlllll));
        return lllIlIIlllIIIIl.toString();
    }

    public JSONObject() {
        JSONObject lllIlIlIIIlIlII;
    }

    public String toJSONString() {
        JSONObject lllIlIIlllIlIII;
        return JSONObject.toJSONString(lllIlIIlllIlIII);
    }

    public static String toJSONString(Map lllIlIIlllIlllI) {
        if (lllIlIIlllIlllI == null) {
            return "null";
        }
        StringBuffer lllIlIIllllIIIl = new StringBuffer();
        boolean lllIlIIllllIIII = true;
        Iterator lllIlIIlllIllll = lllIlIIlllIlllI.entrySet().iterator();
        lllIlIIllllIIIl.append('{');
        while (lllIlIIlllIllll.hasNext()) {
            if (lllIlIIllllIIII) {
                lllIlIIllllIIII = false;
            } else {
                lllIlIIllllIIIl.append(',');
            }
            Map.Entry lllIlIIllllIIll = lllIlIIlllIllll.next();
            JSONObject.toJSONString(String.valueOf(lllIlIIllllIIll.getKey()), lllIlIIllllIIll.getValue(), lllIlIIllllIIIl);
        }
        lllIlIIllllIIIl.append('}');
        return lllIlIIllllIIIl.toString();
    }
}

