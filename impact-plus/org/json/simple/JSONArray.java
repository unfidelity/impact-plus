/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONAware;
import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

public class JSONArray
extends ArrayList
implements JSONStreamAware,
JSONAware,
List {
    private static final /* synthetic */ long serialVersionUID = 3957988303675231981L;

    public void writeJSONString(Writer llllllllllllllllIIIllIIlllllIlll) throws IOException {
        JSONArray llllllllllllllllIIIllIIllllllIII;
        JSONArray.writeJSONString(llllllllllllllllIIIllIIllllllIII, llllllllllllllllIIIllIIlllllIlll);
    }

    public static void writeJSONString(List llllllllllllllllIIIllIlIIIIIllII, Writer llllllllllllllllIIIllIlIIIIIlIlI) throws IOException {
        if (llllllllllllllllIIIllIlIIIIIllII == null) {
            llllllllllllllllIIIllIlIIIIIlIlI.write("null");
            return;
        }
        boolean llllllllllllllllIIIllIlIIIIlIIII = true;
        Iterator llllllllllllllllIIIllIlIIIIIlllI = llllllllllllllllIIIllIlIIIIIllII.iterator();
        llllllllllllllllIIIllIlIIIIIlIlI.write(91);
        while (llllllllllllllllIIIllIlIIIIIlllI.hasNext()) {
            if (llllllllllllllllIIIllIlIIIIlIIII) {
                llllllllllllllllIIIllIlIIIIlIIII = false;
            } else {
                llllllllllllllllIIIllIlIIIIIlIlI.write(44);
            }
            Object llllllllllllllllIIIllIlIIIIlIllI = llllllllllllllllIIIllIlIIIIIlllI.next();
            if (llllllllllllllllIIIllIlIIIIlIllI == null) {
                llllllllllllllllIIIllIlIIIIIlIlI.write("null");
                continue;
            }
            JSONValue.writeJSONString(llllllllllllllllIIIllIlIIIIlIllI, llllllllllllllllIIIllIlIIIIIlIlI);
        }
        llllllllllllllllIIIllIlIIIIIlIlI.write(93);
    }

    public static String toJSONString(List llllllllllllllllIIIllIIlllIlIlII) {
        if (llllllllllllllllIIIllIIlllIlIlII == null) {
            return "null";
        }
        boolean llllllllllllllllIIIllIIlllIllIlI = true;
        StringBuffer llllllllllllllllIIIllIIlllIllIII = new StringBuffer();
        Iterator llllllllllllllllIIIllIIlllIlIllI = llllllllllllllllIIIllIIlllIlIlII.iterator();
        llllllllllllllllIIIllIIlllIllIII.append('[');
        while (llllllllllllllllIIIllIIlllIlIllI.hasNext()) {
            if (llllllllllllllllIIIllIIlllIllIlI) {
                llllllllllllllllIIIllIIlllIllIlI = false;
            } else {
                llllllllllllllllIIIllIIlllIllIII.append(',');
            }
            Object llllllllllllllllIIIllIIlllIlllIl = llllllllllllllllIIIllIIlllIlIllI.next();
            if (llllllllllllllllIIIllIIlllIlllIl == null) {
                llllllllllllllllIIIllIIlllIllIII.append("null");
                continue;
            }
            llllllllllllllllIIIllIIlllIllIII.append(JSONValue.toJSONString(llllllllllllllllIIIllIIlllIlllIl));
        }
        llllllllllllllllIIIllIIlllIllIII.append(']');
        return llllllllllllllllIIIllIIlllIllIII.toString();
    }

    public String toJSONString() {
        JSONArray llllllllllllllllIIIllIIlllIIllIl;
        return JSONArray.toJSONString(llllllllllllllllIIIllIIlllIIllIl);
    }

    public JSONArray() {
        JSONArray llllllllllllllllIIIllIlIIIlIIIlI;
    }

    public String toString() {
        JSONArray llllllllllllllllIIIllIIlllIIlIIl;
        return llllllllllllllllIIIllIIlllIIlIIl.toJSONString();
    }
}

