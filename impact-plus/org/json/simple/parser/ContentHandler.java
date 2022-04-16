/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple.parser;

import java.io.IOException;
import org.json.simple.parser.ParseException;

public interface ContentHandler {
    public boolean startObject() throws ParseException, IOException;

    public boolean endArray() throws IOException, ParseException;

    public void endJSON() throws ParseException, IOException;

    public boolean endObject() throws ParseException, IOException;

    public boolean primitive(Object var1) throws IOException, ParseException;

    public boolean startObjectEntry(String var1) throws ParseException, IOException;

    public boolean startArray() throws IOException, ParseException;

    public void startJSON() throws ParseException, IOException;

    public boolean endObjectEntry() throws ParseException, IOException;
}

