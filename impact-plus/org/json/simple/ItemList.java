/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ItemList {
    private /* synthetic */ String sp;
    /* synthetic */ List items;

    public ItemList(String llllllllllllllllIlIIIlllllllIllI, String llllllllllllllllIlIIIllllllllIII) {
        ItemList llllllllllllllllIlIIIllllllllIlI;
        llllllllllllllllIlIIIllllllllIlI.sp = ",";
        llllllllllllllllIlIIIllllllllIlI.items = new ArrayList();
        llllllllllllllllIlIIIllllllllIlI.sp = llllllllllllllllIlIIIlllllllIllI;
        llllllllllllllllIlIIIllllllllIlI.split(llllllllllllllllIlIIIlllllllIllI, llllllllllllllllIlIIIllllllllIII, llllllllllllllllIlIIIllllllllIlI.items);
    }

    public ItemList(String llllllllllllllllIlIIIllllllllllI) {
        ItemList llllllllllllllllIlIIIlllllllllll;
        llllllllllllllllIlIIIlllllllllll.sp = ",";
        llllllllllllllllIlIIIlllllllllll.items = new ArrayList();
        llllllllllllllllIlIIIlllllllllll.split(llllllllllllllllIlIIIllllllllllI, llllllllllllllllIlIIIlllllllllll.sp, llllllllllllllllIlIIIlllllllllll.items);
    }

    public void split(String llllllllllllllllIlIIIlllllIlIlIl, String llllllllllllllllIlIIIlllllIlIlII, List llllllllllllllllIlIIIlllllIlIIll, boolean llllllllllllllllIlIIIlllllIlIIlI) {
        if (llllllllllllllllIlIIIlllllIlIlIl == null || llllllllllllllllIlIIIlllllIlIlII == null) {
            return;
        }
        if (llllllllllllllllIlIIIlllllIlIIlI) {
            StringTokenizer llllllllllllllllIlIIIlllllIlllII = new StringTokenizer(llllllllllllllllIlIIIlllllIlIlIl, llllllllllllllllIlIIIlllllIlIlII);
            while (llllllllllllllllIlIIIlllllIlllII.hasMoreTokens()) {
                llllllllllllllllIlIIIlllllIlIIll.add(llllllllllllllllIlIIIlllllIlllII.nextToken().trim());
            }
        } else {
            ItemList llllllllllllllllIlIIIlllllIllIll;
            llllllllllllllllIlIIIlllllIllIll.split(llllllllllllllllIlIIIlllllIlIlIl, llllllllllllllllIlIIIlllllIlIlII, llllllllllllllllIlIIIlllllIlIIll);
        }
    }

    public void add(String llllllllllllllllIlIIIllllIlIllII) {
        ItemList llllllllllllllllIlIIIllllIlIllll;
        if (llllllllllllllllIlIIIllllIlIllII == null) {
            return;
        }
        llllllllllllllllIlIIIllllIlIllll.items.add(llllllllllllllllIlIIIllllIlIllII.trim());
    }

    public void addAll(String llllllllllllllllIlIIIllllIlIIIlI) {
        ItemList llllllllllllllllIlIIIllllIlIIIll;
        llllllllllllllllIlIIIllllIlIIIll.split(llllllllllllllllIlIIIllllIlIIIlI, llllllllllllllllIlIIIllllIlIIIll.sp, llllllllllllllllIlIIIllllIlIIIll.items);
    }

    public void addAll(ItemList llllllllllllllllIlIIIllllIlIlIII) {
        ItemList llllllllllllllllIlIIIllllIlIlIIl;
        llllllllllllllllIlIIIllllIlIlIIl.items.addAll(llllllllllllllllIlIIIllllIlIlIII.items);
    }

    public String get(int llllllllllllllllIlIIIllllIIIIlIl) {
        ItemList llllllllllllllllIlIIIllllIIIIllI;
        return (String)llllllllllllllllIlIIIllllIIIIllI.items.get(llllllllllllllllIlIIIllllIIIIlIl);
    }

    public String[] getArray() {
        ItemList llllllllllllllllIlIIIllllllIIIll;
        return (String[])llllllllllllllllIlIIIllllllIIIll.items.toArray();
    }

    public String toString() {
        ItemList llllllllllllllllIlIIIllllIIIIIII;
        return llllllllllllllllIlIIIllllIIIIIII.toString(llllllllllllllllIlIIIllllIIIIIII.sp);
    }

    public String toString(String llllllllllllllllIlIIIlllIllllIII) {
        ItemList llllllllllllllllIlIIIlllIlllIllI;
        StringBuffer llllllllllllllllIlIIIlllIlllIlll = new StringBuffer();
        for (int llllllllllllllllIlIIIlllIllllIlI = 0; llllllllllllllllIlIIIlllIllllIlI < llllllllllllllllIlIIIlllIlllIllI.items.size(); ++llllllllllllllllIlIIIlllIllllIlI) {
            if (llllllllllllllllIlIIIlllIllllIlI == 0) {
                llllllllllllllllIlIIIlllIlllIlll.append(llllllllllllllllIlIIIlllIlllIllI.items.get(llllllllllllllllIlIIIlllIllllIlI));
                continue;
            }
            llllllllllllllllIlIIIlllIlllIlll.append(llllllllllllllllIlIIIlllIllllIII);
            llllllllllllllllIlIIIlllIlllIlll.append(llllllllllllllllIlIIIlllIlllIllI.items.get(llllllllllllllllIlIIIlllIllllIlI));
        }
        return llllllllllllllllIlIIIlllIlllIlll.toString();
    }

    public int size() {
        ItemList llllllllllllllllIlIIIllllIIIIIll;
        return llllllllllllllllIlIIIllllIIIIIll.items.size();
    }

    public void clear() {
        ItemList llllllllllllllllIlIIIlllIlllIIIl;
        llllllllllllllllIlIIIlllIlllIIIl.items.clear();
    }

    public void addAll(String llllllllllllllllIlIIIllllIIllIII, String llllllllllllllllIlIIIllllIIlIlll) {
        ItemList llllllllllllllllIlIIIllllIIllIIl;
        llllllllllllllllIlIIIllllIIllIIl.split(llllllllllllllllIlIIIllllIIllIII, llllllllllllllllIlIIIllllIIlIlll, llllllllllllllllIlIIIllllIIllIIl.items);
    }

    public void addAll(String llllllllllllllllIlIIIllllIIlIIIl, String llllllllllllllllIlIIIllllIIIllII, boolean llllllllllllllllIlIIIllllIIIlIll) {
        ItemList llllllllllllllllIlIIIllllIIlIIlI;
        llllllllllllllllIlIIIllllIIlIIlI.split(llllllllllllllllIlIIIllllIIlIIIl, llllllllllllllllIlIIIllllIIIllII, llllllllllllllllIlIIIllllIIlIIlI.items, llllllllllllllllIlIIIllllIIIlIll);
    }

    public void split(String llllllllllllllllIlIIIlllllIIlIlI, String llllllllllllllllIlIIIlllllIIlIIl, List llllllllllllllllIlIIIlllllIIlIII) {
        if (llllllllllllllllIlIIIlllllIIlIlI == null || llllllllllllllllIlIIIlllllIIlIIl == null) {
            return;
        }
        int llllllllllllllllIlIIIlllllIIIlll = 0;
        int llllllllllllllllIlIIIlllllIIIllI = 0;
        do {
            llllllllllllllllIlIIIlllllIIIllI = llllllllllllllllIlIIIlllllIIIlll;
            if ((llllllllllllllllIlIIIlllllIIIlll = llllllllllllllllIlIIIlllllIIlIlI.indexOf(llllllllllllllllIlIIIlllllIIlIIl, llllllllllllllllIlIIIlllllIIIlll)) == -1) break;
            llllllllllllllllIlIIIlllllIIlIII.add(llllllllllllllllIlIIIlllllIIlIlI.substring(llllllllllllllllIlIIIlllllIIIllI, llllllllllllllllIlIIIlllllIIIlll).trim());
        } while ((llllllllllllllllIlIIIlllllIIIlll += llllllllllllllllIlIIIlllllIIlIIl.length()) != -1);
        llllllllllllllllIlIIIlllllIIlIII.add(llllllllllllllllIlIIIlllllIIlIlI.substring(llllllllllllllllIlIIIlllllIIIllI).trim());
    }

    public ItemList(String llllllllllllllllIlIIIllllllIlIll, String llllllllllllllllIlIIIllllllIlIlI, boolean llllllllllllllllIlIIIllllllIlIIl) {
        ItemList llllllllllllllllIlIIIllllllIllII;
        llllllllllllllllIlIIIllllllIllII.sp = ",";
        llllllllllllllllIlIIIllllllIllII.items = new ArrayList();
        llllllllllllllllIlIIIllllllIllII.split(llllllllllllllllIlIIIllllllIlIll, llllllllllllllllIlIIIllllllIlIlI, llllllllllllllllIlIIIllllllIllII.items, llllllllllllllllIlIIIllllllIlIIl);
    }

    public List getItems() {
        ItemList llllllllllllllllIlIIIllllllIIllI;
        return llllllllllllllllIlIIIllllllIIllI.items;
    }

    public void setSP(String llllllllllllllllIlIIIllllIllllIl) {
        llllllllllllllllIlIIIllllIlllllI.sp = llllllllllllllllIlIIIllllIllllIl;
    }

    public void add(int llllllllllllllllIlIIIllllIllIIll, String llllllllllllllllIlIIIllllIllIlIl) {
        ItemList llllllllllllllllIlIIIllllIllIlll;
        if (llllllllllllllllIlIIIllllIllIlIl == null) {
            return;
        }
        llllllllllllllllIlIIIllllIllIlll.items.add(llllllllllllllllIlIIIllllIllIIll, llllllllllllllllIlIIIllllIllIlIl.trim());
    }

    public ItemList() {
        ItemList llllllllllllllllIlIIlIIIIIIIIlII;
        llllllllllllllllIlIIlIIIIIIIIlII.sp = ",";
        llllllllllllllllIlIIlIIIIIIIIlII.items = new ArrayList();
    }

    public void reset() {
        ItemList llllllllllllllllIlIIIlllIllIlllI;
        llllllllllllllllIlIIIlllIllIlllI.sp = ",";
        llllllllllllllllIlIIIlllIllIlllI.items.clear();
    }
}

