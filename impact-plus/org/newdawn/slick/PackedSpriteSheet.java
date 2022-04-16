/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

public class PackedSpriteSheet {
    private /* synthetic */ String basePath;
    private /* synthetic */ HashMap sections;
    private /* synthetic */ int filter;
    private /* synthetic */ Image image;

    public Image getFullImage() {
        PackedSpriteSheet lIlIIIIIIIIIlIl;
        return lIlIIIIIIIIIlIl.image;
    }

    public PackedSpriteSheet(String lIlIIIIIIIlllIl, Color lIlIIIIIIIlllll) throws SlickException {
        PackedSpriteSheet lIlIIIIIIIllllI;
        lIlIIIIIIIllllI.sections = new HashMap();
        lIlIIIIIIIllllI.filter = 2;
        lIlIIIIIIIlllIl = lIlIIIIIIIlllIl.replace('\\', '/');
        lIlIIIIIIIllllI.basePath = lIlIIIIIIIlllIl.substring(0, lIlIIIIIIIlllIl.lastIndexOf("/") + 1);
        lIlIIIIIIIllllI.loadDefinition(lIlIIIIIIIlllIl, lIlIIIIIIIlllll);
    }

    public PackedSpriteSheet(String lIlIIIIIIIlIlll, int lIlIIIIIIIlIllI) throws SlickException {
        lIlIIIIIIIllIII(lIlIIIIIIIlIlll, lIlIIIIIIIlIllI, null);
        PackedSpriteSheet lIlIIIIIIIllIII;
    }

    private void loadDefinition(String lIIlllllllIIllI, Color lIIlllllllIIIIl) throws SlickException {
        BufferedReader lIIlllllllIIlII = new BufferedReader(new InputStreamReader(ResourceLoader.getResourceAsStream(lIIlllllllIIllI)));
        try {
            PackedSpriteSheet lIIlllllllIIIll;
            lIIlllllllIIIll.image = new Image(String.valueOf(new StringBuilder().append(lIIlllllllIIIll.basePath).append(lIIlllllllIIlII.readLine())), false, lIIlllllllIIIll.filter, lIIlllllllIIIIl);
            while (lIIlllllllIIlII.ready() && lIIlllllllIIlII.readLine() != null) {
                Section lIIlllllllIlIIl = lIIlllllllIIIll.new Section(lIIlllllllIIlII);
                lIIlllllllIIIll.sections.put(lIIlllllllIlIIl.name, lIIlllllllIlIIl);
                if (lIIlllllllIIlII.readLine() != null) continue;
                break;
            }
        }
        catch (Exception lIIlllllllIlIII) {
            Log.error(lIIlllllllIlIII);
            throw new SlickException("Failed to process definitions file - invalid format?", lIIlllllllIlIII);
        }
    }

    public SpriteSheet getSpriteSheet(String lIIllllllllIlIl) {
        PackedSpriteSheet lIIllllllllIllI;
        Image lIIllllllllIlII = lIIllllllllIllI.getSprite(lIIllllllllIlIl);
        Section lIIllllllllIIll = (Section)lIIllllllllIllI.sections.get(lIIllllllllIlIl);
        return new SpriteSheet(lIIllllllllIlII, lIIllllllllIIll.width / lIIllllllllIIll.tilesx, lIIllllllllIIll.height / lIIllllllllIIll.tilesy);
    }

    public PackedSpriteSheet(String lIlIIIIIIIIllIl, int lIlIIIIIIIIlIII, Color lIlIIIIIIIIlIll) throws SlickException {
        PackedSpriteSheet lIlIIIIIIIIlIlI;
        lIlIIIIIIIIlIlI.sections = new HashMap();
        lIlIIIIIIIIlIlI.filter = 2;
        lIlIIIIIIIIlIlI.filter = lIlIIIIIIIIlIII;
        lIlIIIIIIIIllIl = lIlIIIIIIIIllIl.replace('\\', '/');
        lIlIIIIIIIIlIlI.basePath = lIlIIIIIIIIllIl.substring(0, lIlIIIIIIIIllIl.lastIndexOf("/") + 1);
        lIlIIIIIIIIlIlI.loadDefinition(lIlIIIIIIIIllIl, lIlIIIIIIIIlIll);
    }

    public PackedSpriteSheet(String lIlIIIIIIlIIlIl) throws SlickException {
        lIlIIIIIIlIlIII(lIlIIIIIIlIIlIl, null);
        PackedSpriteSheet lIlIIIIIIlIlIII;
    }

    public Image getSprite(String lIIllllllllllll) {
        PackedSpriteSheet lIIllllllllllIl;
        Section lIIlllllllllllI = (Section)lIIllllllllllIl.sections.get(lIIllllllllllll);
        if (lIIlllllllllllI == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("Unknown sprite from packed sheet: ").append(lIIllllllllllll)));
        }
        return lIIllllllllllIl.image.getSubImage(lIIlllllllllllI.x, lIIlllllllllllI.y, lIIlllllllllllI.width, lIIlllllllllllI.height);
    }

    private class Section {
        public /* synthetic */ String name;
        public /* synthetic */ int y;
        public /* synthetic */ int tilesy;
        public /* synthetic */ int x;
        public /* synthetic */ int tilesx;
        public /* synthetic */ int width;
        public /* synthetic */ int height;

        public Section(BufferedReader llllllllllllllllllIIlIIIIllIIIll) throws IOException {
            Section llllllllllllllllllIIlIIIIllIIIlI;
            llllllllllllllllllIIlIIIIllIIIlI.name = llllllllllllllllllIIlIIIIllIIIll.readLine().trim();
            llllllllllllllllllIIlIIIIllIIIlI.x = Integer.parseInt(llllllllllllllllllIIlIIIIllIIIll.readLine().trim());
            llllllllllllllllllIIlIIIIllIIIlI.y = Integer.parseInt(llllllllllllllllllIIlIIIIllIIIll.readLine().trim());
            llllllllllllllllllIIlIIIIllIIIlI.width = Integer.parseInt(llllllllllllllllllIIlIIIIllIIIll.readLine().trim());
            llllllllllllllllllIIlIIIIllIIIlI.height = Integer.parseInt(llllllllllllllllllIIlIIIIllIIIll.readLine().trim());
            llllllllllllllllllIIlIIIIllIIIlI.tilesx = Integer.parseInt(llllllllllllllllllIIlIIIIllIIIll.readLine().trim());
            llllllllllllllllllIIlIIIIllIIIlI.tilesy = Integer.parseInt(llllllllllllllllllIIlIIIIllIIIll.readLine().trim());
            llllllllllllllllllIIlIIIIllIIIll.readLine().trim();
            llllllllllllllllllIIlIIIIllIIIll.readLine().trim();
            llllllllllllllllllIIlIIIIllIIIlI.tilesx = Math.max(1, llllllllllllllllllIIlIIIIllIIIlI.tilesx);
            llllllllllllllllllIIlIIIIllIIIlI.tilesy = Math.max(1, llllllllllllllllllIIlIIIIllIIIlI.tilesy);
        }
    }
}

