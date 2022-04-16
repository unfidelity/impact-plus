/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

public class AngelCodeFont
implements Font {
    private static /* synthetic */ SGL GL;
    private /* synthetic */ Image fontImage;
    private /* synthetic */ boolean displayListCaching;
    private /* synthetic */ int lineHeight;
    private /* synthetic */ DisplayList eldestDisplayList;
    private static final /* synthetic */ int DISPLAY_LIST_CACHE_SIZE;
    private /* synthetic */ int baseDisplayListID;
    private final /* synthetic */ LinkedHashMap displayLists;
    private static final /* synthetic */ int MAX_CHAR;
    private /* synthetic */ CharDef[] chars;
    private /* synthetic */ int eldestDisplayListID;

    @Override
    public void drawString(float llllllllllllllllllllllIIIIIIlIlI, float llllllllllllllllllllllIIIIIIlIIl, String llllllllllllllllllllllIIIIIIlIII) {
        AngelCodeFont llllllllllllllllllllllIIIIIIIlll;
        llllllllllllllllllllllIIIIIIIlll.drawString(llllllllllllllllllllllIIIIIIlIlI, llllllllllllllllllllllIIIIIIlIIl, llllllllllllllllllllllIIIIIIlIII, Color.white);
    }

    public AngelCodeFont(String llllllllllllllllllllllIlIIlIIlll, Image llllllllllllllllllllllIlIIlIIIII) throws SlickException {
        AngelCodeFont llllllllllllllllllllllIlIIlIlIII;
        llllllllllllllllllllllIlIIlIlIII.displayListCaching = true;
        llllllllllllllllllllllIlIIlIlIII.baseDisplayListID = -1;
        llllllllllllllllllllllIlIIlIlIII.displayLists = new LinkedHashMap(200, 1.0f, true){
            {
                1 lllllllllllllllllIlIIlIIIllIIlII;
                super(lllllllllllllllllIlIIlIIIllIIIlI, lllllllllllllllllIlIIlIIIlIllIll, lllllllllllllllllIlIIlIIIlIlllll);
            }

            protected boolean removeEldestEntry(Map.Entry lllllllllllllllllIlIIlIIIlIIllll) {
                1 lllllllllllllllllIlIIlIIIlIlIlIl;
                lllllllllllllllllIlIIlIIIlIlIlIl.AngelCodeFont.this.eldestDisplayList = (DisplayList)lllllllllllllllllIlIIlIIIlIIllll.getValue();
                lllllllllllllllllIlIIlIIIlIlIlIl.AngelCodeFont.this.eldestDisplayListID = ((AngelCodeFont)lllllllllllllllllIlIIlIIIlIlIlIl.AngelCodeFont.this).eldestDisplayList.id;
                return false;
            }
        };
        llllllllllllllllllllllIlIIlIlIII.fontImage = llllllllllllllllllllllIlIIlIIIII;
        llllllllllllllllllllllIlIIlIlIII.parseFnt(ResourceLoader.getResourceAsStream(llllllllllllllllllllllIlIIlIIlll));
    }

    @Override
    public int getHeight(String lllllllllllllllllllllIllIlllIIll) {
        AngelCodeFont lllllllllllllllllllllIllIllIllll;
        DisplayList lllllllllllllllllllllIllIlllIIlI = null;
        if (lllllllllllllllllllllIllIllIllll.displayListCaching && (lllllllllllllllllllllIllIlllIIlI = (DisplayList)lllllllllllllllllllllIllIllIllll.displayLists.get(lllllllllllllllllllllIllIlllIIll)) != null && lllllllllllllllllllllIllIlllIIlI.height != null) {
            return lllllllllllllllllllllIllIlllIIlI.height.intValue();
        }
        int lllllllllllllllllllllIllIlllIIIl = 0;
        int lllllllllllllllllllllIllIlllIIII = 0;
        for (int lllllllllllllllllllllIllIlllIlIl = 0; lllllllllllllllllllllIllIlllIlIl < lllllllllllllllllllllIllIlllIIll.length(); ++lllllllllllllllllllllIllIlllIlIl) {
            CharDef lllllllllllllllllllllIllIlllIllI;
            char lllllllllllllllllllllIllIlllIlll = lllllllllllllllllllllIllIlllIIll.charAt(lllllllllllllllllllllIllIlllIlIl);
            if (lllllllllllllllllllllIllIlllIlll == '\n') {
                ++lllllllllllllllllllllIllIlllIIIl;
                lllllllllllllllllllllIllIlllIIII = 0;
                continue;
            }
            if (lllllllllllllllllllllIllIlllIlll == ' ' || (lllllllllllllllllllllIllIlllIllI = lllllllllllllllllllllIllIllIllll.chars[lllllllllllllllllllllIllIlllIlll]) == null) continue;
            lllllllllllllllllllllIllIlllIIII = Math.max(lllllllllllllllllllllIllIlllIllI.height + lllllllllllllllllllllIllIlllIllI.yoffset, lllllllllllllllllllllIllIlllIIII);
        }
        lllllllllllllllllllllIllIlllIIII += lllllllllllllllllllllIllIlllIIIl * lllllllllllllllllllllIllIllIllll.getLineHeight();
        if (lllllllllllllllllllllIllIlllIIlI != null) {
            lllllllllllllllllllllIllIlllIIlI.height = new Short((short)lllllllllllllllllllllIllIlllIIII);
        }
        return lllllllllllllllllllllIllIlllIIII;
    }

    public AngelCodeFont(String llllllllllllllllllllllIIllIIlIlI, InputStream llllllllllllllllllllllIIllIIlIIl, InputStream llllllllllllllllllllllIIllIIllII) throws SlickException {
        AngelCodeFont llllllllllllllllllllllIIllIlIIIl;
        llllllllllllllllllllllIIllIlIIIl.displayListCaching = true;
        llllllllllllllllllllllIIllIlIIIl.baseDisplayListID = -1;
        llllllllllllllllllllllIIllIlIIIl.displayLists = new /* invalid duplicate definition of identical inner class */;
        llllllllllllllllllllllIIllIlIIIl.fontImage = new Image(llllllllllllllllllllllIIllIIllII, llllllllllllllllllllllIIllIIlIlI, false);
        llllllllllllllllllllllIIllIlIIIl.parseFnt(llllllllllllllllllllllIIllIIlIIl);
    }

    public int getYOffset(String lllllllllllllllllllllIlllIIIIllI) {
        AngelCodeFont lllllllllllllllllllllIlllIIIIlll;
        DisplayList lllllllllllllllllllllIlllIIIlIlI = null;
        if (lllllllllllllllllllllIlllIIIIlll.displayListCaching && (lllllllllllllllllllllIlllIIIlIlI = (DisplayList)lllllllllllllllllllllIlllIIIIlll.displayLists.get(lllllllllllllllllllllIlllIIIIllI)) != null && lllllllllllllllllllllIlllIIIlIlI.yOffset != null) {
            return lllllllllllllllllllllIlllIIIlIlI.yOffset.intValue();
        }
        int lllllllllllllllllllllIlllIIIlIIl = lllllllllllllllllllllIlllIIIIllI.indexOf(10);
        if (lllllllllllllllllllllIlllIIIlIIl == -1) {
            lllllllllllllllllllllIlllIIIlIIl = lllllllllllllllllllllIlllIIIIllI.length();
        }
        int lllllllllllllllllllllIlllIIIlIII = 10000;
        for (int lllllllllllllllllllllIlllIIIllIl = 0; lllllllllllllllllllllIlllIIIllIl < lllllllllllllllllllllIlllIIIlIIl; ++lllllllllllllllllllllIlllIIIllIl) {
            char lllllllllllllllllllllIlllIIIllll = lllllllllllllllllllllIlllIIIIllI.charAt(lllllllllllllllllllllIlllIIIllIl);
            CharDef lllllllllllllllllllllIlllIIIlllI = lllllllllllllllllllllIlllIIIIlll.chars[lllllllllllllllllllllIlllIIIllll];
            if (lllllllllllllllllllllIlllIIIlllI == null) continue;
            lllllllllllllllllllllIlllIIIlIII = Math.min(lllllllllllllllllllllIlllIIIlllI.yoffset, lllllllllllllllllllllIlllIIIlIII);
        }
        if (lllllllllllllllllllllIlllIIIlIlI != null) {
            lllllllllllllllllllllIlllIIIlIlI.yOffset = new Short((short)lllllllllllllllllllllIlllIIIlIII);
        }
        return lllllllllllllllllllllIlllIIIlIII;
    }

    @Override
    public int getLineHeight() {
        AngelCodeFont lllllllllllllllllllllIllIlIIIlll;
        return lllllllllllllllllllllIllIlIIIlll.lineHeight;
    }

    public AngelCodeFont(String llllllllllllllllllllllIlIIIlIIIl, String llllllllllllllllllllllIlIIIIllII) throws SlickException {
        AngelCodeFont llllllllllllllllllllllIlIIIIllll;
        llllllllllllllllllllllIlIIIIllll.displayListCaching = true;
        llllllllllllllllllllllIlIIIIllll.baseDisplayListID = -1;
        llllllllllllllllllllllIlIIIIllll.displayLists = new /* invalid duplicate definition of identical inner class */;
        llllllllllllllllllllllIlIIIIllll.fontImage = new Image(llllllllllllllllllllllIlIIIIllII);
        llllllllllllllllllllllIlIIIIllll.parseFnt(ResourceLoader.getResourceAsStream(llllllllllllllllllllllIlIIIlIIIl));
    }

    public AngelCodeFont(String llllllllllllllllllllllIIlllIllIl, String llllllllllllllllllllllIIlllIIIll, boolean llllllllllllllllllllllIIlllIIIIl) throws SlickException {
        AngelCodeFont llllllllllllllllllllllIIlllIllll;
        llllllllllllllllllllllIIlllIllll.displayListCaching = true;
        llllllllllllllllllllllIIlllIllll.baseDisplayListID = -1;
        llllllllllllllllllllllIIlllIllll.displayLists = new /* invalid duplicate definition of identical inner class */;
        llllllllllllllllllllllIIlllIllll.fontImage = new Image(llllllllllllllllllllllIIlllIIIll);
        llllllllllllllllllllllIIlllIllll.displayListCaching = llllllllllllllllllllllIIlllIIIIl;
        llllllllllllllllllllllIIlllIllll.parseFnt(ResourceLoader.getResourceAsStream(llllllllllllllllllllllIIlllIllIl));
    }

    @Override
    public void drawString(float lllllllllllllllllllllIllllIIIIIl, float lllllllllllllllllllllIllllIIlIIl, String lllllllllllllllllllllIllllIIlIII, Color lllllllllllllllllllllIllllIIIlll, int lllllllllllllllllllllIlllIllllII, int lllllllllllllllllllllIllllIIIlII) {
        AngelCodeFont lllllllllllllllllllllIllllIIlIll;
        lllllllllllllllllllllIllllIIlIll.fontImage.bind();
        lllllllllllllllllllllIllllIIIlll.bind();
        GL.glTranslatef(lllllllllllllllllllllIllllIIIIIl, lllllllllllllllllllllIllllIIlIIl, 0.0f);
        if (lllllllllllllllllllllIllllIIlIll.displayListCaching && lllllllllllllllllllllIlllIllllII == 0 && lllllllllllllllllllllIllllIIIlII == lllllllllllllllllllllIllllIIlIII.length() - 1) {
            DisplayList lllllllllllllllllllllIllllIIllII = (DisplayList)lllllllllllllllllllllIllllIIlIll.displayLists.get(lllllllllllllllllllllIllllIIlIII);
            if (lllllllllllllllllllllIllllIIllII != null) {
                GL.glCallList(lllllllllllllllllllllIllllIIllII.id);
            } else {
                lllllllllllllllllllllIllllIIllII = new DisplayList();
                lllllllllllllllllllllIllllIIllII.text = lllllllllllllllllllllIllllIIlIII;
                int lllllllllllllllllllllIllllIIlllI = lllllllllllllllllllllIllllIIlIll.displayLists.size();
                if (lllllllllllllllllllllIllllIIlllI < 200) {
                    lllllllllllllllllllllIllllIIllII.id = lllllllllllllllllllllIllllIIlIll.baseDisplayListID + lllllllllllllllllllllIllllIIlllI;
                } else {
                    lllllllllllllllllllllIllllIIllII.id = lllllllllllllllllllllIllllIIlIll.eldestDisplayListID;
                    lllllllllllllllllllllIllllIIlIll.displayLists.remove(lllllllllllllllllllllIllllIIlIll.eldestDisplayList.text);
                }
                lllllllllllllllllllllIllllIIlIll.displayLists.put(lllllllllllllllllllllIllllIIlIII, lllllllllllllllllllllIllllIIllII);
                GL.glNewList(lllllllllllllllllllllIllllIIllII.id, 4865);
                lllllllllllllllllllllIllllIIlIll.render(lllllllllllllllllllllIllllIIlIII, lllllllllllllllllllllIlllIllllII, lllllllllllllllllllllIllllIIIlII);
                GL.glEndList();
            }
        } else {
            lllllllllllllllllllllIllllIIlIll.render(lllllllllllllllllllllIllllIIlIII, lllllllllllllllllllllIlllIllllII, lllllllllllllllllllllIllllIIIlII);
        }
        GL.glTranslatef(-lllllllllllllllllllllIllllIIIIIl, -lllllllllllllllllllllIllllIIlIIl, 0.0f);
    }

    public AngelCodeFont(String llllllllllllllllllllllIIlIllIIlI, InputStream llllllllllllllllllllllIIlIllIIII, InputStream llllllllllllllllllllllIIlIllIlll, boolean llllllllllllllllllllllIIlIlIllII) throws SlickException {
        AngelCodeFont llllllllllllllllllllllIIlIllllII;
        llllllllllllllllllllllIIlIllllII.displayListCaching = true;
        llllllllllllllllllllllIIlIllllII.baseDisplayListID = -1;
        llllllllllllllllllllllIIlIllllII.displayLists = new /* invalid duplicate definition of identical inner class */;
        llllllllllllllllllllllIIlIllllII.fontImage = new Image(llllllllllllllllllllllIIlIllIlll, llllllllllllllllllllllIIlIllIIlI, false);
        llllllllllllllllllllllIIlIllllII.displayListCaching = llllllllllllllllllllllIIlIlIllII;
        llllllllllllllllllllllIIlIllllII.parseFnt(llllllllllllllllllllllIIlIllIIII);
    }

    private void parseFnt(InputStream llllllllllllllllllllllIIIlIlIIlI) throws SlickException {
        AngelCodeFont llllllllllllllllllllllIIIlIlIIll;
        if (llllllllllllllllllllllIIIlIlIIll.displayListCaching) {
            llllllllllllllllllllllIIIlIlIIll.baseDisplayListID = GL.glGenLists(200);
            if (llllllllllllllllllllllIIIlIlIIll.baseDisplayListID == 0) {
                llllllllllllllllllllllIIIlIlIIll.displayListCaching = false;
            }
        }
        try {
            BufferedReader llllllllllllllllllllllIIIlIllllI = new BufferedReader(new InputStreamReader(llllllllllllllllllllllIIIlIlIIlI));
            String llllllllllllllllllllllIIIlIlllIl = llllllllllllllllllllllIIIlIllllI.readLine();
            String llllllllllllllllllllllIIIlIlllII = llllllllllllllllllllllIIIlIllllI.readLine();
            String llllllllllllllllllllllIIIlIllIll = llllllllllllllllllllllIIIlIllllI.readLine();
            HashMap<Short, ArrayList<Short>> llllllllllllllllllllllIIIlIllIlI = new HashMap<Short, ArrayList<Short>>(64);
            ArrayList<CharDef> llllllllllllllllllllllIIIlIllIIl = new ArrayList<CharDef>(255);
            int llllllllllllllllllllllIIIlIllIII = 0;
            boolean llllllllllllllllllllllIIIlIlIlll = false;
            while (!llllllllllllllllllllllIIIlIlIlll) {
                CharDef llllllllllllllllllllllIIIllIlllI;
                String llllllllllllllllllllllIIIllIlIII = llllllllllllllllllllllIIIlIllllI.readLine();
                if (llllllllllllllllllllllIIIllIlIII == null) {
                    llllllllllllllllllllllIIIlIlIlll = true;
                    continue;
                }
                if (!llllllllllllllllllllllIIIllIlIII.startsWith("chars c") && llllllllllllllllllllllIIIllIlIII.startsWith("char") && (llllllllllllllllllllllIIIllIlllI = llllllllllllllllllllllIIIlIlIIll.parseChar(llllllllllllllllllllllIIIllIlIII)) != null) {
                    llllllllllllllllllllllIIIlIllIII = Math.max(llllllllllllllllllllllIIIlIllIII, llllllllllllllllllllllIIIllIlllI.id);
                    llllllllllllllllllllllIIIlIllIIl.add(llllllllllllllllllllllIIIllIlllI);
                }
                if (llllllllllllllllllllllIIIllIlIII.startsWith("kernings c") || !llllllllllllllllllllllIIIllIlIII.startsWith("kerning")) continue;
                StringTokenizer llllllllllllllllllllllIIIllIllIl = new StringTokenizer(llllllllllllllllllllllIIIllIlIII, " =");
                llllllllllllllllllllllIIIllIllIl.nextToken();
                llllllllllllllllllllllIIIllIllIl.nextToken();
                short llllllllllllllllllllllIIIllIllII = Short.parseShort(llllllllllllllllllllllIIIllIllIl.nextToken());
                llllllllllllllllllllllIIIllIllIl.nextToken();
                int llllllllllllllllllllllIIIllIlIll = Integer.parseInt(llllllllllllllllllllllIIIllIllIl.nextToken());
                llllllllllllllllllllllIIIllIllIl.nextToken();
                int llllllllllllllllllllllIIIllIlIlI = Integer.parseInt(llllllllllllllllllllllIIIllIllIl.nextToken());
                ArrayList<Short> llllllllllllllllllllllIIIllIlIIl = (ArrayList<Short>)llllllllllllllllllllllIIIlIllIlI.get(new Short(llllllllllllllllllllllIIIllIllII));
                if (llllllllllllllllllllllIIIllIlIIl == null) {
                    llllllllllllllllllllllIIIllIlIIl = new ArrayList<Short>();
                    llllllllllllllllllllllIIIlIllIlI.put(new Short(llllllllllllllllllllllIIIllIllII), llllllllllllllllllllllIIIllIlIIl);
                }
                llllllllllllllllllllllIIIllIlIIl.add(new Short((short)(llllllllllllllllllllllIIIllIlIlI << 8 | llllllllllllllllllllllIIIllIlIll)));
            }
            llllllllllllllllllllllIIIlIlIIll.chars = new CharDef[llllllllllllllllllllllIIIlIllIII + 1];
            Iterator llllllllllllllllllllllIIIllIIllI = llllllllllllllllllllllIIIlIllIIl.iterator();
            while (llllllllllllllllllllllIIIllIIllI.hasNext()) {
                CharDef llllllllllllllllllllllIIIllIIlll;
                llllllllllllllllllllllIIIlIlIIll.chars[llllllllllllllllllllllIIIllIIlll.id] = llllllllllllllllllllllIIIllIIlll = (CharDef)llllllllllllllllllllllIIIllIIllI.next();
            }
            for (Map.Entry llllllllllllllllllllllIIIllIIlII : llllllllllllllllllllllIIIlIllIlI.entrySet()) {
                short llllllllllllllllllllllIIIllIIIll = (Short)llllllllllllllllllllllIIIllIIlII.getKey();
                List llllllllllllllllllllllIIIllIIIlI = (List)llllllllllllllllllllllIIIllIIlII.getValue();
                short[] llllllllllllllllllllllIIIllIIIIl = new short[llllllllllllllllllllllIIIllIIIlI.size()];
                int llllllllllllllllllllllIIIllIIIII = 0;
                Iterator llllllllllllllllllllllIIIllIIlIl = llllllllllllllllllllllIIIllIIIlI.iterator();
                while (llllllllllllllllllllllIIIllIIlIl.hasNext()) {
                    llllllllllllllllllllllIIIllIIIIl[llllllllllllllllllllllIIIllIIIII] = (Short)llllllllllllllllllllllIIIllIIlIl.next();
                    ++llllllllllllllllllllllIIIllIIIII;
                }
                llllllllllllllllllllllIIIlIlIIll.chars[llllllllllllllllllllllIIIllIIIll].kerning = llllllllllllllllllllllIIIllIIIIl;
            }
        }
        catch (IOException llllllllllllllllllllllIIIlIlIllI) {
            Log.error(llllllllllllllllllllllIIIlIlIllI);
            throw new SlickException(String.valueOf(new StringBuilder().append("Failed to parse font file: ").append(llllllllllllllllllllllIIIlIlIIlI)));
        }
    }

    @Override
    public int getWidth(String lllllllllllllllllllllIllIlIlIIlI) {
        AngelCodeFont lllllllllllllllllllllIllIlIllIIl;
        DisplayList lllllllllllllllllllllIllIlIlIlll = null;
        if (lllllllllllllllllllllIllIlIllIIl.displayListCaching && (lllllllllllllllllllllIllIlIlIlll = (DisplayList)lllllllllllllllllllllIllIlIllIIl.displayLists.get(lllllllllllllllllllllIllIlIlIIlI)) != null && lllllllllllllllllllllIllIlIlIlll.width != null) {
            return lllllllllllllllllllllIllIlIlIlll.width.intValue();
        }
        int lllllllllllllllllllllIllIlIlIllI = 0;
        int lllllllllllllllllllllIllIlIlIlIl = 0;
        CharDef lllllllllllllllllllllIllIlIlIlII = null;
        int lllllllllllllllllllllIllIlIllIlI = lllllllllllllllllllllIllIlIlIIlI.length();
        for (int lllllllllllllllllllllIllIlIllIll = 0; lllllllllllllllllllllIllIlIllIll < lllllllllllllllllllllIllIlIllIlI; ++lllllllllllllllllllllIllIlIllIll) {
            CharDef lllllllllllllllllllllIllIlIlllII;
            char lllllllllllllllllllllIllIlIlllIl = lllllllllllllllllllllIllIlIlIIlI.charAt(lllllllllllllllllllllIllIlIllIll);
            if (lllllllllllllllllllllIllIlIlllIl == '\n') {
                lllllllllllllllllllllIllIlIlIlIl = 0;
                continue;
            }
            if (lllllllllllllllllllllIllIlIlllIl >= lllllllllllllllllllllIllIlIllIIl.chars.length || (lllllllllllllllllllllIllIlIlllII = lllllllllllllllllllllIllIlIllIIl.chars[lllllllllllllllllllllIllIlIlllIl]) == null) continue;
            if (lllllllllllllllllllllIllIlIlIlII != null) {
                lllllllllllllllllllllIllIlIlIlIl += lllllllllllllllllllllIllIlIlIlII.getKerning(lllllllllllllllllllllIllIlIlllIl);
            }
            lllllllllllllllllllllIllIlIlIlII = lllllllllllllllllllllIllIlIlllII;
            lllllllllllllllllllllIllIlIlIlIl = lllllllllllllllllllllIllIlIllIll < lllllllllllllllllllllIllIlIllIlI - 1 ? (lllllllllllllllllllllIllIlIlIlIl += lllllllllllllllllllllIllIlIlllII.xadvance) : (lllllllllllllllllllllIllIlIlIlIl += lllllllllllllllllllllIllIlIlllII.width);
            lllllllllllllllllllllIllIlIlIllI = Math.max(lllllllllllllllllllllIllIlIlIllI, lllllllllllllllllllllIllIlIlIlIl);
        }
        if (lllllllllllllllllllllIllIlIlIlll != null) {
            lllllllllllllllllllllIllIlIlIlll.width = new Short((short)lllllllllllllllllllllIllIlIlIllI);
        }
        return lllllllllllllllllllllIllIlIlIllI;
    }

    private void render(String lllllllllllllllllllllIlllIlIIIIl, int lllllllllllllllllllllIlllIlIlIII, int lllllllllllllllllllllIlllIlIIlll) {
        GL.glBegin(7);
        int lllllllllllllllllllllIlllIlIIllI = 0;
        int lllllllllllllllllllllIlllIlIIlIl = 0;
        CharDef lllllllllllllllllllllIlllIlIIlII = null;
        char[] lllllllllllllllllllllIlllIlIIIll = lllllllllllllllllllllIlllIlIIIIl.toCharArray();
        for (int lllllllllllllllllllllIlllIlIlIll = 0; lllllllllllllllllllllIlllIlIlIll < lllllllllllllllllllllIlllIlIIIll.length; ++lllllllllllllllllllllIlllIlIlIll) {
            CharDef lllllllllllllllllllllIlllIlIllII;
            AngelCodeFont lllllllllllllllllllllIlllIlIIIlI;
            char lllllllllllllllllllllIlllIlIllIl = lllllllllllllllllllllIlllIlIIIll[lllllllllllllllllllllIlllIlIlIll];
            if (lllllllllllllllllllllIlllIlIllIl == '\n') {
                lllllllllllllllllllllIlllIlIIllI = 0;
                lllllllllllllllllllllIlllIlIIlIl += lllllllllllllllllllllIlllIlIIIlI.getLineHeight();
                continue;
            }
            if (lllllllllllllllllllllIlllIlIllIl >= lllllllllllllllllllllIlllIlIIIlI.chars.length || (lllllllllllllllllllllIlllIlIllII = lllllllllllllllllllllIlllIlIIIlI.chars[lllllllllllllllllllllIlllIlIllIl]) == null) continue;
            if (lllllllllllllllllllllIlllIlIIlII != null) {
                lllllllllllllllllllllIlllIlIIllI += lllllllllllllllllllllIlllIlIIlII.getKerning(lllllllllllllllllllllIlllIlIllIl);
            }
            lllllllllllllllllllllIlllIlIIlII = lllllllllllllllllllllIlllIlIllII;
            if (lllllllllllllllllllllIlllIlIlIll >= lllllllllllllllllllllIlllIlIlIII && lllllllllllllllllllllIlllIlIlIll <= lllllllllllllllllllllIlllIlIIlll) {
                lllllllllllllllllllllIlllIlIllII.draw(lllllllllllllllllllllIlllIlIIllI, lllllllllllllllllllllIlllIlIIlIl);
            }
            lllllllllllllllllllllIlllIlIIllI += lllllllllllllllllllllIlllIlIllII.xadvance;
        }
        GL.glEnd();
    }

    private CharDef parseChar(String llllllllllllllllllllllIIIIIlllII) throws SlickException {
        AngelCodeFont llllllllllllllllllllllIIIIIlllIl;
        CharDef llllllllllllllllllllllIIIIIllIll = llllllllllllllllllllllIIIIIlllIl.new CharDef();
        StringTokenizer llllllllllllllllllllllIIIIIllIlI = new StringTokenizer(llllllllllllllllllllllIIIIIlllII, " =");
        llllllllllllllllllllllIIIIIllIlI.nextToken();
        llllllllllllllllllllllIIIIIllIlI.nextToken();
        llllllllllllllllllllllIIIIIllIll.id = Short.parseShort(llllllllllllllllllllllIIIIIllIlI.nextToken());
        if (llllllllllllllllllllllIIIIIllIll.id < 0) {
            return null;
        }
        if (llllllllllllllllllllllIIIIIllIll.id > 255) {
            throw new SlickException(String.valueOf(new StringBuilder().append("Invalid character '").append(llllllllllllllllllllllIIIIIllIll.id).append("': AngelCodeFont does not support characters above ").append(255)));
        }
        llllllllllllllllllllllIIIIIllIlI.nextToken();
        llllllllllllllllllllllIIIIIllIll.x = Short.parseShort(llllllllllllllllllllllIIIIIllIlI.nextToken());
        llllllllllllllllllllllIIIIIllIlI.nextToken();
        llllllllllllllllllllllIIIIIllIll.y = Short.parseShort(llllllllllllllllllllllIIIIIllIlI.nextToken());
        llllllllllllllllllllllIIIIIllIlI.nextToken();
        llllllllllllllllllllllIIIIIllIll.width = Short.parseShort(llllllllllllllllllllllIIIIIllIlI.nextToken());
        llllllllllllllllllllllIIIIIllIlI.nextToken();
        llllllllllllllllllllllIIIIIllIll.height = Short.parseShort(llllllllllllllllllllllIIIIIllIlI.nextToken());
        llllllllllllllllllllllIIIIIllIlI.nextToken();
        llllllllllllllllllllllIIIIIllIll.xoffset = Short.parseShort(llllllllllllllllllllllIIIIIllIlI.nextToken());
        llllllllllllllllllllllIIIIIllIlI.nextToken();
        llllllllllllllllllllllIIIIIllIll.yoffset = Short.parseShort(llllllllllllllllllllllIIIIIllIlI.nextToken());
        llllllllllllllllllllllIIIIIllIlI.nextToken();
        llllllllllllllllllllllIIIIIllIll.xadvance = Short.parseShort(llllllllllllllllllllllIIIIIllIlI.nextToken());
        llllllllllllllllllllllIIIIIllIll.init();
        if (llllllllllllllllllllllIIIIIllIll.id != 32) {
            llllllllllllllllllllllIIIIIlllIl.lineHeight = Math.max(llllllllllllllllllllllIIIIIllIll.height + llllllllllllllllllllllIIIIIllIll.yoffset, llllllllllllllllllllllIIIIIlllIl.lineHeight);
        }
        return llllllllllllllllllllllIIIIIllIll;
    }

    static {
        MAX_CHAR = 255;
        DISPLAY_LIST_CACHE_SIZE = 200;
        GL = Renderer.get();
    }

    public AngelCodeFont(String llllllllllllllllllllllIIlllllIlI, Image llllllllllllllllllllllIIlllllIIl, boolean llllllllllllllllllllllIIlllllIII) throws SlickException {
        AngelCodeFont llllllllllllllllllllllIIlllllIll;
        llllllllllllllllllllllIIlllllIll.displayListCaching = true;
        llllllllllllllllllllllIIlllllIll.baseDisplayListID = -1;
        llllllllllllllllllllllIIlllllIll.displayLists = new /* invalid duplicate definition of identical inner class */;
        llllllllllllllllllllllIIlllllIll.fontImage = llllllllllllllllllllllIIlllllIIl;
        llllllllllllllllllllllIIlllllIll.displayListCaching = llllllllllllllllllllllIIlllllIII;
        llllllllllllllllllllllIIlllllIll.parseFnt(ResourceLoader.getResourceAsStream(llllllllllllllllllllllIIlllllIlI));
    }

    @Override
    public void drawString(float lllllllllllllllllllllIlllllllIII, float lllllllllllllllllllllIllllllIlll, String lllllllllllllllllllllIlllllllIll, Color lllllllllllllllllllllIllllllIlIl) {
        AngelCodeFont lllllllllllllllllllllIlllllllIIl;
        lllllllllllllllllllllIlllllllIIl.drawString(lllllllllllllllllllllIlllllllIII, lllllllllllllllllllllIllllllIlll, lllllllllllllllllllllIlllllllIll, lllllllllllllllllllllIllllllIlIl, 0, lllllllllllllllllllllIlllllllIll.length() - 1);
    }

    private static class DisplayList {
        /* synthetic */ String text;
        /* synthetic */ Short yOffset;
        /* synthetic */ int id;
        /* synthetic */ Short width;
        /* synthetic */ Short height;

        private DisplayList() {
            DisplayList llIlllIIIIl;
        }
    }

    private class CharDef {
        public /* synthetic */ short[] kerning;
        public /* synthetic */ short id;
        public /* synthetic */ short xadvance;
        public /* synthetic */ short yoffset;
        public /* synthetic */ short width;
        public /* synthetic */ short x;
        public /* synthetic */ short y;
        public /* synthetic */ short height;
        public /* synthetic */ short xoffset;
        public /* synthetic */ short dlIndex;
        public /* synthetic */ Image image;

        public void draw(float llllllllllllllllIlIllIlllllIlIII, float llllllllllllllllIlIllIlllllIIlII) {
            CharDef llllllllllllllllIlIllIlllllIIllI;
            llllllllllllllllIlIllIlllllIIllI.image.drawEmbedded(llllllllllllllllIlIllIlllllIlIII + (float)llllllllllllllllIlIllIlllllIIllI.xoffset, llllllllllllllllIlIllIlllllIIlII + (float)llllllllllllllllIlIllIlllllIIllI.yoffset, llllllllllllllllIlIllIlllllIIllI.width, llllllllllllllllIlIllIlllllIIllI.height);
        }

        private CharDef() {
            CharDef llllllllllllllllIlIllIllllllIlII;
        }

        public void init() {
            CharDef llllllllllllllllIlIllIllllllIIII;
            llllllllllllllllIlIllIllllllIIII.image = llllllllllllllllIlIllIllllllIIII.AngelCodeFont.this.fontImage.getSubImage(llllllllllllllllIlIllIllllllIIII.x, llllllllllllllllIlIllIllllllIIII.y, llllllllllllllllIlIllIllllllIIII.width, llllllllllllllllIlIllIllllllIIII.height);
        }

        public int getKerning(int llllllllllllllllIlIllIllllIllIII) {
            CharDef llllllllllllllllIlIllIllllIlIlIl;
            if (llllllllllllllllIlIllIllllIlIlIl.kerning == null) {
                return 0;
            }
            int llllllllllllllllIlIllIllllIlIlll = 0;
            int llllllllllllllllIlIllIllllIlIllI = llllllllllllllllIlIllIllllIlIlIl.kerning.length - 1;
            while (llllllllllllllllIlIllIllllIlIlll <= llllllllllllllllIlIllIllllIlIllI) {
                int llllllllllllllllIlIllIllllIlllII = llllllllllllllllIlIllIllllIlIlll + llllllllllllllllIlIllIllllIlIllI >>> 1;
                short llllllllllllllllIlIllIllllIllIll = llllllllllllllllIlIllIllllIlIlIl.kerning[llllllllllllllllIlIllIllllIlllII];
                int llllllllllllllllIlIllIllllIllIlI = llllllllllllllllIlIllIllllIllIll & 0xFF;
                if (llllllllllllllllIlIllIllllIllIlI < llllllllllllllllIlIllIllllIllIII) {
                    llllllllllllllllIlIllIllllIlIlll = llllllllllllllllIlIllIllllIlllII + 1;
                    continue;
                }
                if (llllllllllllllllIlIllIllllIllIlI > llllllllllllllllIlIllIllllIllIII) {
                    llllllllllllllllIlIllIllllIlIllI = llllllllllllllllIlIllIllllIlllII - 1;
                    continue;
                }
                return llllllllllllllllIlIllIllllIllIll >> 8;
            }
            return 0;
        }

        public String toString() {
            CharDef llllllllllllllllIlIllIlllllIlllI;
            return String.valueOf(new StringBuilder().append("[CharDef id=").append(llllllllllllllllIlIllIlllllIlllI.id).append(" x=").append(llllllllllllllllIlIllIlllllIlllI.x).append(" y=").append(llllllllllllllllIlIllIlllllIlllI.y).append("]"));
        }
    }
}

