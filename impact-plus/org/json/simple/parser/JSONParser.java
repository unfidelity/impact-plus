/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple.parser;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.ContentHandler;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.Yylex;
import org.json.simple.parser.Yytoken;

public class JSONParser {
    public static final /* synthetic */ int S_IN_OBJECT;
    public static final /* synthetic */ int S_PASSED_PAIR_KEY;
    private /* synthetic */ Yytoken token;
    private /* synthetic */ LinkedList handlerStatusStack;
    public static final /* synthetic */ int S_IN_ARRAY;
    public static final /* synthetic */ int S_IN_FINISHED_VALUE;
    private /* synthetic */ Yylex lexer;
    public static final /* synthetic */ int S_INIT;
    private /* synthetic */ int status;
    public static final /* synthetic */ int S_IN_PAIR_VALUE;
    public static final /* synthetic */ int S_IN_ERROR;
    public static final /* synthetic */ int S_END;

    public void parse(String lllIIIIIIIIIlll, ContentHandler lllIIIIIIIIlIIl) throws ParseException {
        JSONParser lllIIIIIIIIlIll;
        lllIIIIIIIIlIll.parse(lllIIIIIIIIIlll, lllIIIIIIIIlIIl, false);
    }

    public void parse(Reader llIlllllIIIllll, ContentHandler llIlllllIIllIIl, boolean llIlllllIIIlIIl) throws IOException, ParseException {
        JSONParser llIlllllIIlllII;
        if (!llIlllllIIIlIIl) {
            llIlllllIIlllII.reset(llIlllllIIIllll);
            llIlllllIIlllII.handlerStatusStack = new LinkedList();
        } else if (llIlllllIIlllII.handlerStatusStack == null) {
            llIlllllIIIlIIl = false;
            llIlllllIIlllII.reset(llIlllllIIIllll);
            llIlllllIIlllII.handlerStatusStack = new LinkedList();
        }
        LinkedList llIlllllIIlIlIl = llIlllllIIlllII.handlerStatusStack;
        try {
            do {
                block1 : switch (llIlllllIIlllII.status) {
                    case 0: {
                        llIlllllIIllIIl.startJSON();
                        llIlllllIIlllII.nextToken();
                        switch (llIlllllIIlllII.token.type) {
                            case 0: {
                                llIlllllIIlllII.status = 1;
                                llIlllllIIlIlIl.addFirst(new Integer(llIlllllIIlllII.status));
                                if (llIlllllIIllIIl.primitive(llIlllllIIlllII.token.value)) break block1;
                                return;
                            }
                            case 1: {
                                llIlllllIIlllII.status = 2;
                                llIlllllIIlIlIl.addFirst(new Integer(llIlllllIIlllII.status));
                                if (llIlllllIIllIIl.startObject()) break block1;
                                return;
                            }
                            case 3: {
                                llIlllllIIlllII.status = 3;
                                llIlllllIIlIlIl.addFirst(new Integer(llIlllllIIlllII.status));
                                if (llIlllllIIllIIl.startArray()) break block1;
                                return;
                            }
                        }
                        llIlllllIIlllII.status = -1;
                        break;
                    }
                    case 1: {
                        llIlllllIIlllII.nextToken();
                        if (llIlllllIIlllII.token.type == -1) {
                            llIlllllIIllIIl.endJSON();
                            llIlllllIIlllII.status = 6;
                            return;
                        }
                        llIlllllIIlllII.status = -1;
                        throw new ParseException(llIlllllIIlllII.getPosition(), 1, llIlllllIIlllII.token);
                    }
                    case 2: {
                        llIlllllIIlllII.nextToken();
                        switch (llIlllllIIlllII.token.type) {
                            case 5: {
                                break;
                            }
                            case 0: {
                                if (llIlllllIIlllII.token.value instanceof String) {
                                    String llIlllllIlIIlIl = (String)llIlllllIIlllII.token.value;
                                    llIlllllIIlllII.status = 4;
                                    llIlllllIIlIlIl.addFirst(new Integer(llIlllllIIlllII.status));
                                    if (llIlllllIIllIIl.startObjectEntry(llIlllllIlIIlIl)) break block1;
                                    return;
                                }
                                llIlllllIIlllII.status = -1;
                                break;
                            }
                            case 2: {
                                if (llIlllllIIlIlIl.size() > 1) {
                                    llIlllllIIlIlIl.removeFirst();
                                    llIlllllIIlllII.status = llIlllllIIlllII.peekStatus(llIlllllIIlIlIl);
                                } else {
                                    llIlllllIIlllII.status = 1;
                                }
                                if (llIlllllIIllIIl.endObject()) break;
                                return;
                            }
                            default: {
                                llIlllllIIlllII.status = -1;
                                break;
                            }
                        }
                        break;
                    }
                    case 4: {
                        llIlllllIIlllII.nextToken();
                        switch (llIlllllIIlllII.token.type) {
                            case 6: {
                                break block1;
                            }
                            case 0: {
                                llIlllllIIlIlIl.removeFirst();
                                llIlllllIIlllII.status = llIlllllIIlllII.peekStatus(llIlllllIIlIlIl);
                                if (!llIlllllIIllIIl.primitive(llIlllllIIlllII.token.value)) {
                                    return;
                                }
                                if (llIlllllIIllIIl.endObjectEntry()) break block1;
                                return;
                            }
                            case 3: {
                                llIlllllIIlIlIl.removeFirst();
                                llIlllllIIlIlIl.addFirst(new Integer(5));
                                llIlllllIIlllII.status = 3;
                                llIlllllIIlIlIl.addFirst(new Integer(llIlllllIIlllII.status));
                                if (llIlllllIIllIIl.startArray()) break block1;
                                return;
                            }
                            case 1: {
                                llIlllllIIlIlIl.removeFirst();
                                llIlllllIIlIlIl.addFirst(new Integer(5));
                                llIlllllIIlllII.status = 2;
                                llIlllllIIlIlIl.addFirst(new Integer(llIlllllIIlllII.status));
                                if (llIlllllIIllIIl.startObject()) break block1;
                                return;
                            }
                        }
                        llIlllllIIlllII.status = -1;
                        break;
                    }
                    case 5: {
                        llIlllllIIlIlIl.removeFirst();
                        llIlllllIIlllII.status = llIlllllIIlllII.peekStatus(llIlllllIIlIlIl);
                        if (llIlllllIIllIIl.endObjectEntry()) break;
                        return;
                    }
                    case 3: {
                        llIlllllIIlllII.nextToken();
                        switch (llIlllllIIlllII.token.type) {
                            case 5: {
                                break block1;
                            }
                            case 0: {
                                if (llIlllllIIllIIl.primitive(llIlllllIIlllII.token.value)) break block1;
                                return;
                            }
                            case 4: {
                                if (llIlllllIIlIlIl.size() > 1) {
                                    llIlllllIIlIlIl.removeFirst();
                                    llIlllllIIlllII.status = llIlllllIIlllII.peekStatus(llIlllllIIlIlIl);
                                } else {
                                    llIlllllIIlllII.status = 1;
                                }
                                if (llIlllllIIllIIl.endArray()) break block1;
                                return;
                            }
                            case 1: {
                                llIlllllIIlllII.status = 2;
                                llIlllllIIlIlIl.addFirst(new Integer(llIlllllIIlllII.status));
                                if (llIlllllIIllIIl.startObject()) break block1;
                                return;
                            }
                            case 3: {
                                llIlllllIIlllII.status = 3;
                                llIlllllIIlIlIl.addFirst(new Integer(llIlllllIIlllII.status));
                                if (llIlllllIIllIIl.startArray()) break block1;
                                return;
                            }
                        }
                        llIlllllIIlllII.status = -1;
                        break;
                    }
                    case 6: {
                        return;
                    }
                    case -1: {
                        throw new ParseException(llIlllllIIlllII.getPosition(), 1, llIlllllIIlllII.token);
                    }
                }
                if (llIlllllIIlllII.status != -1) continue;
                throw new ParseException(llIlllllIIlllII.getPosition(), 1, llIlllllIIlllII.token);
            } while (llIlllllIIlllII.token.type != -1);
        }
        catch (IOException llIlllllIlIIlII) {
            llIlllllIIlllII.status = -1;
            throw llIlllllIlIIlII;
        }
        catch (ParseException llIlllllIlIIIlI) {
            llIlllllIIlllII.status = -1;
            throw llIlllllIlIIIlI;
        }
        catch (RuntimeException llIlllllIlIIIII) {
            llIlllllIIlllII.status = -1;
            throw llIlllllIlIIIII;
        }
        catch (Error llIlllllIIllllI) {
            llIlllllIIlllII.status = -1;
            throw llIlllllIIllllI;
        }
        llIlllllIIlllII.status = -1;
        throw new ParseException(llIlllllIIlllII.getPosition(), 1, llIlllllIIlllII.token);
    }

    public int getPosition() {
        JSONParser lllIIIIllIIIIlI;
        return lllIIIIllIIIIlI.lexer.getPosition();
    }

    private int peekStatus(LinkedList lllIIIIllIlIIIl) {
        if (lllIIIIllIlIIIl.size() == 0) {
            return -1;
        }
        Integer lllIIIIllIlIIII = (Integer)lllIIIIllIlIIIl.getFirst();
        return lllIIIIllIlIIII;
    }

    public Object parse(Reader lllIIIIlIlIIlll) throws IOException, ParseException {
        JSONParser lllIIIIlIlIlIII;
        return lllIIIIlIlIlIII.parse(lllIIIIlIlIIlll, (ContainerFactory)null);
    }

    public Object parse(String lllIIIIlIllIlII, ContainerFactory lllIIIIlIllIIll) throws ParseException {
        StringReader lllIIIIlIllIIlI = new StringReader(lllIIIIlIllIlII);
        try {
            JSONParser lllIIIIlIllIlIl;
            return lllIIIIlIllIlIl.parse((Reader)lllIIIIlIllIIlI, lllIIIIlIllIIll);
        }
        catch (IOException lllIIIIlIllIllI) {
            throw new ParseException(-1, 2, lllIIIIlIllIllI);
        }
    }

    public Object parse(String lllIIIIlIlllllI) throws ParseException {
        JSONParser lllIIIIlIllllll;
        return lllIIIIlIllllll.parse(lllIIIIlIlllllI, (ContainerFactory)null);
    }

    private void nextToken() throws ParseException, IOException {
        JSONParser lllIIIIIIllllIl;
        lllIIIIIIllllIl.token = lllIIIIIIllllIl.lexer.yylex();
        if (lllIIIIIIllllIl.token == null) {
            lllIIIIIIllllIl.token = new Yytoken(-1, null);
        }
    }

    public JSONParser() {
        JSONParser lllIIIIllIlIllI;
        lllIIIIllIlIllI.lexer = new Yylex((Reader)null);
        lllIIIIllIlIllI.token = null;
        lllIIIIllIlIllI.status = 0;
    }

    private Map createObjectContainer(ContainerFactory lllIIIIIIlIIlII) {
        if (lllIIIIIIlIIlII == null) {
            return new JSONObject();
        }
        Map lllIIIIIIlIIIll = lllIIIIIIlIIlII.createObjectContainer();
        if (lllIIIIIIlIIIll == null) {
            return new JSONObject();
        }
        return lllIIIIIIlIIIll;
    }

    public void parse(String llIllllllllIlIl, ContentHandler llIlllllllIllll, boolean llIllllllllIIll) throws ParseException {
        StringReader llIllllllllIIlI = new StringReader(llIllllllllIlIl);
        try {
            JSONParser llIllllllllIllI;
            llIllllllllIllI.parse(llIllllllllIIlI, llIlllllllIllll, llIllllllllIIll);
        }
        catch (IOException llIllllllllIlll) {
            throw new ParseException(-1, 2, llIllllllllIlll);
        }
    }

    public void parse(Reader llIlllllllIIIlI, ContentHandler llIlllllllIIIIl) throws IOException, ParseException {
        JSONParser llIlllllllIlIII;
        llIlllllllIlIII.parse(llIlllllllIIIlI, llIlllllllIIIIl, false);
    }

    public void reset(Reader lllIIIIllIIIlll) {
        JSONParser lllIIIIllIIIllI;
        lllIIIIllIIIllI.lexer.yyreset(lllIIIIllIIIlll);
        lllIIIIllIIIllI.reset();
    }

    static {
        S_IN_OBJECT = 2;
        S_IN_ERROR = -1;
        S_INIT = 0;
        S_IN_PAIR_VALUE = 5;
        S_IN_ARRAY = 3;
        S_PASSED_PAIR_KEY = 4;
        S_IN_FINISHED_VALUE = 1;
        S_END = 6;
    }

    private List createArrayContainer(ContainerFactory lllIIIIIIIlllII) {
        if (lllIIIIIIIlllII == null) {
            return new JSONArray();
        }
        List lllIIIIIIIllIll = lllIIIIIIIlllII.creatArrayContainer();
        if (lllIIIIIIIllIll == null) {
            return new JSONArray();
        }
        return lllIIIIIIIllIll;
    }

    public void reset() {
        lllIIIIllIIllII.token = null;
        lllIIIIllIIllII.status = 0;
        lllIIIIllIIllII.handlerStatusStack = null;
    }

    public Object parse(Reader lllIIIIIlIIlIll, ContainerFactory lllIIIIIlIIllll) throws ParseException, IOException {
        JSONParser lllIIIIIlIIllII;
        lllIIIIIlIIllII.reset(lllIIIIIlIIlIll);
        LinkedList<Integer> lllIIIIIlIIlllI = new LinkedList<Integer>();
        LinkedList<Object> lllIIIIIlIIllIl = new LinkedList<Object>();
        do {
            lllIIIIIlIIllII.nextToken();
            block1 : switch (lllIIIIIlIIllII.status) {
                case 0: {
                    switch (lllIIIIIlIIllII.token.type) {
                        case 0: {
                            lllIIIIIlIIllII.status = 1;
                            lllIIIIIlIIlllI.addFirst(new Integer(lllIIIIIlIIllII.status));
                            lllIIIIIlIIllIl.addFirst(lllIIIIIlIIllII.token.value);
                            break block1;
                        }
                        case 1: {
                            lllIIIIIlIIllII.status = 2;
                            lllIIIIIlIIlllI.addFirst(new Integer(lllIIIIIlIIllII.status));
                            lllIIIIIlIIllIl.addFirst(lllIIIIIlIIllII.createObjectContainer(lllIIIIIlIIllll));
                            break block1;
                        }
                        case 3: {
                            lllIIIIIlIIllII.status = 3;
                            lllIIIIIlIIlllI.addFirst(new Integer(lllIIIIIlIIllII.status));
                            lllIIIIIlIIllIl.addFirst(lllIIIIIlIIllII.createArrayContainer(lllIIIIIlIIllll));
                            break block1;
                        }
                    }
                    lllIIIIIlIIllII.status = -1;
                    break;
                }
                case 1: {
                    if (lllIIIIIlIIllII.token.type == -1) {
                        return lllIIIIIlIIllIl.removeFirst();
                    }
                    throw new ParseException(lllIIIIIlIIllII.getPosition(), 1, lllIIIIIlIIllII.token);
                }
                case 2: {
                    switch (lllIIIIIlIIllII.token.type) {
                        case 5: {
                            break block1;
                        }
                        case 0: {
                            if (lllIIIIIlIIllII.token.value instanceof String) {
                                String lllIIIIIlIllIlI = (String)lllIIIIIlIIllII.token.value;
                                lllIIIIIlIIllIl.addFirst(lllIIIIIlIllIlI);
                                lllIIIIIlIIllII.status = 4;
                                lllIIIIIlIIlllI.addFirst(new Integer(lllIIIIIlIIllII.status));
                                break block1;
                            }
                            lllIIIIIlIIllII.status = -1;
                            break block1;
                        }
                        case 2: {
                            if (lllIIIIIlIIllIl.size() > 1) {
                                lllIIIIIlIIlllI.removeFirst();
                                lllIIIIIlIIllIl.removeFirst();
                                lllIIIIIlIIllII.status = lllIIIIIlIIllII.peekStatus(lllIIIIIlIIlllI);
                                break block1;
                            }
                            lllIIIIIlIIllII.status = 1;
                            break block1;
                        }
                    }
                    lllIIIIIlIIllII.status = -1;
                    break;
                }
                case 4: {
                    switch (lllIIIIIlIIllII.token.type) {
                        case 6: {
                            break block1;
                        }
                        case 0: {
                            lllIIIIIlIIlllI.removeFirst();
                            String lllIIIIIlIllIIl = (String)lllIIIIIlIIllIl.removeFirst();
                            Map lllIIIIIlIllIII = (Map)lllIIIIIlIIllIl.getFirst();
                            lllIIIIIlIllIII.put(lllIIIIIlIllIIl, lllIIIIIlIIllII.token.value);
                            lllIIIIIlIIllII.status = lllIIIIIlIIllII.peekStatus(lllIIIIIlIIlllI);
                            break block1;
                        }
                        case 3: {
                            lllIIIIIlIIlllI.removeFirst();
                            String lllIIIIIlIllIIl = (String)lllIIIIIlIIllIl.removeFirst();
                            Map lllIIIIIlIllIII = (Map)lllIIIIIlIIllIl.getFirst();
                            List lllIIIIIlIlIlll = lllIIIIIlIIllII.createArrayContainer(lllIIIIIlIIllll);
                            lllIIIIIlIllIII.put(lllIIIIIlIllIIl, lllIIIIIlIlIlll);
                            lllIIIIIlIIllII.status = 3;
                            lllIIIIIlIIlllI.addFirst(new Integer(lllIIIIIlIIllII.status));
                            lllIIIIIlIIllIl.addFirst(lllIIIIIlIlIlll);
                            break block1;
                        }
                        case 1: {
                            lllIIIIIlIIlllI.removeFirst();
                            String lllIIIIIlIllIIl = (String)lllIIIIIlIIllIl.removeFirst();
                            Map lllIIIIIlIllIII = (Map)lllIIIIIlIIllIl.getFirst();
                            Map lllIIIIIlIlIllI = lllIIIIIlIIllII.createObjectContainer(lllIIIIIlIIllll);
                            lllIIIIIlIllIII.put(lllIIIIIlIllIIl, lllIIIIIlIlIllI);
                            lllIIIIIlIIllII.status = 2;
                            lllIIIIIlIIlllI.addFirst(new Integer(lllIIIIIlIIllII.status));
                            lllIIIIIlIIllIl.addFirst(lllIIIIIlIlIllI);
                            break block1;
                        }
                    }
                    lllIIIIIlIIllII.status = -1;
                    break;
                }
                case 3: {
                    switch (lllIIIIIlIIllII.token.type) {
                        case 5: {
                            break block1;
                        }
                        case 0: {
                            List lllIIIIIlIlIlIl = (List)lllIIIIIlIIllIl.getFirst();
                            lllIIIIIlIlIlIl.add(lllIIIIIlIIllII.token.value);
                            break block1;
                        }
                        case 4: {
                            if (lllIIIIIlIIllIl.size() > 1) {
                                lllIIIIIlIIlllI.removeFirst();
                                lllIIIIIlIIllIl.removeFirst();
                                lllIIIIIlIIllII.status = lllIIIIIlIIllII.peekStatus(lllIIIIIlIIlllI);
                                break block1;
                            }
                            lllIIIIIlIIllII.status = 1;
                            break block1;
                        }
                        case 1: {
                            List lllIIIIIlIlIlIl = (List)lllIIIIIlIIllIl.getFirst();
                            Map lllIIIIIlIlIlII = lllIIIIIlIIllII.createObjectContainer(lllIIIIIlIIllll);
                            lllIIIIIlIlIlIl.add(lllIIIIIlIlIlII);
                            lllIIIIIlIIllII.status = 2;
                            lllIIIIIlIIlllI.addFirst(new Integer(lllIIIIIlIIllII.status));
                            lllIIIIIlIIllIl.addFirst(lllIIIIIlIlIlII);
                            break block1;
                        }
                        case 3: {
                            List lllIIIIIlIlIlIl = (List)lllIIIIIlIIllIl.getFirst();
                            List lllIIIIIlIlIIll = lllIIIIIlIIllII.createArrayContainer(lllIIIIIlIIllll);
                            lllIIIIIlIlIlIl.add(lllIIIIIlIlIIll);
                            lllIIIIIlIIllII.status = 3;
                            lllIIIIIlIIlllI.addFirst(new Integer(lllIIIIIlIIllII.status));
                            lllIIIIIlIIllIl.addFirst(lllIIIIIlIlIIll);
                            break block1;
                        }
                    }
                    lllIIIIIlIIllII.status = -1;
                    break;
                }
                case -1: {
                    throw new ParseException(lllIIIIIlIIllII.getPosition(), 1, lllIIIIIlIIllII.token);
                }
            }
            if (lllIIIIIlIIllII.status != -1) continue;
            throw new ParseException(lllIIIIIlIIllII.getPosition(), 1, lllIIIIIlIIllII.token);
        } while (lllIIIIIlIIllII.token.type != -1);
        throw new ParseException(lllIIIIIlIIllII.getPosition(), 1, lllIIIIIlIIllII.token);
    }
}

