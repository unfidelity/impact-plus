/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONValue {
    public JSONValue() {
        JSONValue lllIIIIIlllIII;
    }

    public static String toJSONString(Object lllIIIIIIlIlll) {
        if (lllIIIIIIlIlll == null) {
            return "null";
        }
        if (lllIIIIIIlIlll instanceof String) {
            return "\"" + JSONValue.escape((String)lllIIIIIIlIlll) + "\"";
        }
        if (lllIIIIIIlIlll instanceof Double) {
            if (((Double)lllIIIIIIlIlll).isInfinite() || ((Double)lllIIIIIIlIlll).isNaN()) {
                return "null";
            }
            return lllIIIIIIlIlll.toString();
        }
        if (lllIIIIIIlIlll instanceof Float) {
            if (((Float)lllIIIIIIlIlll).isInfinite() || ((Float)lllIIIIIIlIlll).isNaN()) {
                return "null";
            }
            return lllIIIIIIlIlll.toString();
        }
        if (lllIIIIIIlIlll instanceof Number) {
            return lllIIIIIIlIlll.toString();
        }
        if (lllIIIIIIlIlll instanceof Boolean) {
            return lllIIIIIIlIlll.toString();
        }
        if (lllIIIIIIlIlll instanceof JSONAware) {
            return ((JSONAware)lllIIIIIIlIlll).toJSONString();
        }
        if (lllIIIIIIlIlll instanceof Map) {
            return JSONObject.toJSONString((Map)lllIIIIIIlIlll);
        }
        if (lllIIIIIIlIlll instanceof List) {
            return JSONArray.toJSONString((List)lllIIIIIIlIlll);
        }
        return lllIIIIIIlIlll.toString();
    }

    public static Object parse(String lllIIIIIlIlllI) {
        StringReader lllIIIIIlIllIl = new StringReader(lllIIIIIlIlllI);
        return JSONValue.parse(lllIIIIIlIllIl);
    }

    public static String escape(String lllIIIIIIlIIIl) {
        if (lllIIIIIIlIIIl == null) {
            return null;
        }
        StringBuffer lllIIIIIIlIIlI = new StringBuffer();
        JSONValue.escape(lllIIIIIIlIIIl, lllIIIIIIlIIlI);
        return lllIIIIIIlIIlI.toString();
    }

    public static Object parseWithException(Reader lllIIIIIlIlIII) throws IOException, ParseException {
        JSONParser lllIIIIIlIIlll = new JSONParser();
        return lllIIIIIlIIlll.parse(lllIIIIIlIlIII);
    }

    public static void writeJSONString(Object lllIIIIIIllIlI, Writer lllIIIIIIllIll) throws IOException {
        if (lllIIIIIIllIlI == null) {
            lllIIIIIIllIll.write("null");
            return;
        }
        if (lllIIIIIIllIlI instanceof String) {
            lllIIIIIIllIll.write(34);
            lllIIIIIIllIll.write(JSONValue.escape((String)lllIIIIIIllIlI));
            lllIIIIIIllIll.write(34);
            return;
        }
        if (lllIIIIIIllIlI instanceof Double) {
            if (((Double)lllIIIIIIllIlI).isInfinite() || ((Double)lllIIIIIIllIlI).isNaN()) {
                lllIIIIIIllIll.write("null");
            } else {
                lllIIIIIIllIll.write(lllIIIIIIllIlI.toString());
            }
            return;
        }
        if (lllIIIIIIllIlI instanceof Float) {
            if (((Float)lllIIIIIIllIlI).isInfinite() || ((Float)lllIIIIIIllIlI).isNaN()) {
                lllIIIIIIllIll.write("null");
            } else {
                lllIIIIIIllIll.write(lllIIIIIIllIlI.toString());
            }
            return;
        }
        if (lllIIIIIIllIlI instanceof Number) {
            lllIIIIIIllIll.write(lllIIIIIIllIlI.toString());
            return;
        }
        if (lllIIIIIIllIlI instanceof Boolean) {
            lllIIIIIIllIll.write(lllIIIIIIllIlI.toString());
            return;
        }
        if (lllIIIIIIllIlI instanceof JSONStreamAware) {
            ((JSONStreamAware)lllIIIIIIllIlI).writeJSONString(lllIIIIIIllIll);
            return;
        }
        if (lllIIIIIIllIlI instanceof JSONAware) {
            lllIIIIIIllIll.write(((JSONAware)lllIIIIIIllIlI).toJSONString());
            return;
        }
        if (lllIIIIIIllIlI instanceof Map) {
            JSONObject.writeJSONString((Map)lllIIIIIIllIlI, lllIIIIIIllIll);
            return;
        }
        if (lllIIIIIIllIlI instanceof List) {
            JSONArray.writeJSONString((List)lllIIIIIIllIlI, lllIIIIIIllIll);
            return;
        }
        lllIIIIIIllIll.write(lllIIIIIIllIlI.toString());
    }

    static void escape(String lllIIIIIIIIlIl, StringBuffer lllIIIIIIIIlII) {
        block10: for (int lllIIIIIIIIllI = 0; lllIIIIIIIIllI < lllIIIIIIIIlIl.length(); ++lllIIIIIIIIllI) {
            char lllIIIIIIIIlll = lllIIIIIIIIlIl.charAt(lllIIIIIIIIllI);
            switch (lllIIIIIIIIlll) {
                case '\"': {
                    lllIIIIIIIIlII.append("\\\"");
                    continue block10;
                }
                case '\\': {
                    lllIIIIIIIIlII.append("\\\\");
                    continue block10;
                }
                case '\b': {
                    lllIIIIIIIIlII.append("\\b");
                    continue block10;
                }
                case '\f': {
                    lllIIIIIIIIlII.append("\\f");
                    continue block10;
                }
                case '\n': {
                    lllIIIIIIIIlII.append("\\n");
                    continue block10;
                }
                case '\r': {
                    lllIIIIIIIIlII.append("\\r");
                    continue block10;
                }
                case '\t': {
                    lllIIIIIIIIlII.append("\\t");
                    continue block10;
                }
                case '/': {
                    lllIIIIIIIIlII.append("\\/");
                    continue block10;
                }
                default: {
                    if (lllIIIIIIIIlll >= '\u0000' && lllIIIIIIIIlll <= '\u001f' || lllIIIIIIIIlll >= '\u007f' && lllIIIIIIIIlll <= '\u009f' || lllIIIIIIIIlll >= '\u2000' && lllIIIIIIIIlll <= '\u20ff') {
                        String lllIIIIIIIlIII = Integer.toHexString(lllIIIIIIIIlll);
                        lllIIIIIIIIlII.append("\\u");
                        for (int lllIIIIIIIlIIl = 0; lllIIIIIIIlIIl < 4 - lllIIIIIIIlIII.length(); ++lllIIIIIIIlIIl) {
                            lllIIIIIIIIlII.append('0');
                        }
                        lllIIIIIIIIlII.append(lllIIIIIIIlIII.toUpperCase());
                        continue block10;
                    }
                    lllIIIIIIIIlII.append(lllIIIIIIIIlll);
                }
            }
        }
    }

    public static Object parseWithException(String lllIIIIIlIIIII) throws ParseException {
        JSONParser lllIIIIIlIIIIl = new JSONParser();
        return lllIIIIIlIIIIl.parse(lllIIIIIlIIIII);
    }

    public static Object parse(Reader lllIIIIIllIIlI) {
        try {
            JSONParser lllIIIIIllIlIl = new JSONParser();
            return lllIIIIIllIlIl.parse(lllIIIIIllIIlI);
        }
        catch (Exception lllIIIIIllIlII) {
            return null;
        }
    }
}

