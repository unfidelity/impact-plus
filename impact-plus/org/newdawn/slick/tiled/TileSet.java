/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tiled;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TileSet {
    public /* synthetic */ int firstGID;
    public /* synthetic */ int tilesDown;
    private /* synthetic */ HashMap props;
    public /* synthetic */ SpriteSheet tiles;
    public /* synthetic */ String name;
    protected /* synthetic */ int tileSpacing;
    private final /* synthetic */ TiledMap map;
    public /* synthetic */ int tileWidth;
    public /* synthetic */ int index;
    public /* synthetic */ int tilesAcross;
    public /* synthetic */ int tileHeight;
    public /* synthetic */ int lastGID;
    protected /* synthetic */ int tileMargin;

    public int getTileMargin() {
        TileSet llllllllllllllllIllIllIllIIIIlll;
        return llllllllllllllllIllIllIllIIIIlll.tileMargin;
    }

    public int getTileSpacing() {
        TileSet llllllllllllllllIllIllIllIIIlIlI;
        return llllllllllllllllIllIllIllIIIlIlI.tileSpacing;
    }

    public int getTileHeight() {
        TileSet llllllllllllllllIllIllIllIIIlllI;
        return llllllllllllllllIllIllIllIIIlllI.tileHeight;
    }

    public int getTileX(int llllllllllllllllIllIllIlIlllIlll) {
        TileSet llllllllllllllllIllIllIlIllllIII;
        return llllllllllllllllIllIllIlIlllIlll % llllllllllllllllIllIllIlIllllIII.tilesAcross;
    }

    public TileSet(TiledMap llllllllllllllllIllIllIllIlIlIlI, Element llllllllllllllllIllIllIllIlIlIIl, boolean llllllllllllllllIllIllIllIlIlIII) throws SlickException {
        String llllllllllllllllIllIllIllIllIIlI;
        TileSet llllllllllllllllIllIllIllIlIlIll;
        llllllllllllllllIllIllIllIlIlIll.lastGID = Integer.MAX_VALUE;
        llllllllllllllllIllIllIllIlIlIll.props = new HashMap();
        llllllllllllllllIllIllIllIlIlIll.tileSpacing = 0;
        llllllllllllllllIllIllIllIlIlIll.tileMargin = 0;
        llllllllllllllllIllIllIllIlIlIll.map = llllllllllllllllIllIllIllIlIlIlI;
        llllllllllllllllIllIllIllIlIlIll.name = llllllllllllllllIllIllIllIlIlIIl.getAttribute("name");
        llllllllllllllllIllIllIllIlIlIll.firstGID = Integer.parseInt(llllllllllllllllIllIllIllIlIlIIl.getAttribute("firstgid"));
        String llllllllllllllllIllIllIllIllIllI = llllllllllllllllIllIllIllIlIlIIl.getAttribute("source");
        if (llllllllllllllllIllIllIllIllIllI != null && !llllllllllllllllIllIllIllIllIllI.equals("")) {
            try {
                Element llllllllllllllllIllIllIlllIlIIlI;
                InputStream llllllllllllllllIllIllIlllIlIlIl = ResourceLoader.getResourceAsStream(String.valueOf(new StringBuilder().append(llllllllllllllllIllIllIllIlIlIlI.getTilesLocation()).append("/").append(llllllllllllllllIllIllIllIllIllI)));
                DocumentBuilder llllllllllllllllIllIllIlllIlIlII = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document llllllllllllllllIllIllIlllIlIIll = llllllllllllllllIllIllIlllIlIlII.parse(llllllllllllllllIllIllIlllIlIlIl);
                llllllllllllllllIllIllIllIlIlIIl = llllllllllllllllIllIllIlllIlIIlI = llllllllllllllllIllIllIlllIlIIll.getDocumentElement();
            }
            catch (Exception llllllllllllllllIllIllIlllIlIIIl) {
                Log.error(llllllllllllllllIllIllIlllIlIIIl);
                throw new SlickException(String.valueOf(new StringBuilder().append("Unable to load or parse sourced tileset: ").append(llllllllllllllllIllIllIllIlIlIll.map.tilesLocation).append("/").append(llllllllllllllllIllIllIllIllIllI)));
            }
        }
        String llllllllllllllllIllIllIllIllIlIl = llllllllllllllllIllIllIllIlIlIIl.getAttribute("tilewidth");
        String llllllllllllllllIllIllIllIllIlII = llllllllllllllllIllIllIllIlIlIIl.getAttribute("tileheight");
        if (llllllllllllllllIllIllIllIllIlIl.length() == 0 || llllllllllllllllIllIllIllIllIlII.length() == 0) {
            throw new SlickException("TiledMap requires that the map be created with tilesets that use a single image.  Check the WiKi for more complete information.");
        }
        llllllllllllllllIllIllIllIlIlIll.tileWidth = Integer.parseInt(llllllllllllllllIllIllIllIllIlIl);
        llllllllllllllllIllIllIllIlIlIll.tileHeight = Integer.parseInt(llllllllllllllllIllIllIllIllIlII);
        String llllllllllllllllIllIllIllIllIIll = llllllllllllllllIllIllIllIlIlIIl.getAttribute("spacing");
        if (llllllllllllllllIllIllIllIllIIll != null && !llllllllllllllllIllIllIllIllIIll.equals("")) {
            llllllllllllllllIllIllIllIlIlIll.tileSpacing = Integer.parseInt(llllllllllllllllIllIllIllIllIIll);
        }
        if ((llllllllllllllllIllIllIllIllIIlI = llllllllllllllllIllIllIllIlIlIIl.getAttribute("margin")) != null && !llllllllllllllllIllIllIllIllIIlI.equals("")) {
            llllllllllllllllIllIllIllIlIlIll.tileMargin = Integer.parseInt(llllllllllllllllIllIllIllIllIIlI);
        }
        NodeList llllllllllllllllIllIllIllIllIIIl = llllllllllllllllIllIllIllIlIlIIl.getElementsByTagName("image");
        Element llllllllllllllllIllIllIllIllIIII = (Element)llllllllllllllllIllIllIllIllIIIl.item(0);
        String llllllllllllllllIllIllIllIlIllll = llllllllllllllllIllIllIllIllIIII.getAttribute("source");
        Color llllllllllllllllIllIllIllIlIlllI = null;
        String llllllllllllllllIllIllIllIlIllIl = llllllllllllllllIllIllIllIllIIII.getAttribute("trans");
        if (llllllllllllllllIllIllIllIlIllIl != null && llllllllllllllllIllIllIllIlIllIl.length() > 0) {
            int llllllllllllllllIllIllIlllIlIIII = Integer.parseInt(llllllllllllllllIllIllIllIlIllIl, 16);
            llllllllllllllllIllIllIllIlIlllI = new Color(llllllllllllllllIllIllIlllIlIIII);
        }
        if (llllllllllllllllIllIllIllIlIlIII) {
            Image llllllllllllllllIllIllIlllIIllll = new Image(String.valueOf(new StringBuilder().append(llllllllllllllllIllIllIllIlIlIlI.getTilesLocation()).append("/").append(llllllllllllllllIllIllIllIlIllll)), false, 2, llllllllllllllllIllIllIllIlIlllI);
            llllllllllllllllIllIllIllIlIlIll.setTileSetImage(llllllllllllllllIllIllIlllIIllll);
        }
        NodeList llllllllllllllllIllIllIllIlIllII = llllllllllllllllIllIllIllIlIlIIl.getElementsByTagName("tile");
        for (int llllllllllllllllIllIllIllIllllII = 0; llllllllllllllllIllIllIllIllllII < llllllllllllllllIllIllIllIlIllII.getLength(); ++llllllllllllllllIllIllIllIllllII) {
            Element llllllllllllllllIllIllIlllIIIIll = (Element)llllllllllllllllIllIllIllIlIllII.item(llllllllllllllllIllIllIllIllllII);
            int llllllllllllllllIllIllIlllIIIIlI = Integer.parseInt(llllllllllllllllIllIllIlllIIIIll.getAttribute("id"));
            llllllllllllllllIllIllIlllIIIIlI += llllllllllllllllIllIllIllIlIlIll.firstGID;
            Properties llllllllllllllllIllIllIlllIIIIIl = new Properties();
            Element llllllllllllllllIllIllIllIllllll = (Element)llllllllllllllllIllIllIlllIIIIll.getElementsByTagName("properties").item(0);
            if (llllllllllllllllIllIllIllIllllll == null) continue;
            NodeList llllllllllllllllIllIllIlllIIIlII = llllllllllllllllIllIllIllIllllll.getElementsByTagName("property");
            for (int llllllllllllllllIllIllIlllIIIlIl = 0; llllllllllllllllIllIllIlllIIIlIl < llllllllllllllllIllIllIlllIIIlII.getLength(); ++llllllllllllllllIllIllIlllIIIlIl) {
                Element llllllllllllllllIllIllIlllIIlllI = (Element)llllllllllllllllIllIllIlllIIIlII.item(llllllllllllllllIllIllIlllIIIlIl);
                String llllllllllllllllIllIllIlllIIlIIl = llllllllllllllllIllIllIlllIIlllI.getAttribute("name");
                String llllllllllllllllIllIllIlllIIIlll = llllllllllllllllIllIllIlllIIlllI.getAttribute("value");
                llllllllllllllllIllIllIlllIIIIIl.setProperty(llllllllllllllllIllIllIlllIIlIIl, llllllllllllllllIllIllIlllIIIlll);
            }
            llllllllllllllllIllIllIllIlIlIll.props.put(new Integer(llllllllllllllllIllIllIlllIIIIlI), llllllllllllllllIllIllIlllIIIIIl);
        }
    }

    public int getTileWidth() {
        TileSet llllllllllllllllIllIllIllIIlIIIl;
        return llllllllllllllllIllIllIllIIlIIIl.tileWidth;
    }

    public void setLimit(int llllllllllllllllIllIllIlIllIlIIl) {
        llllllllllllllllIllIllIlIllIllII.lastGID = llllllllllllllllIllIllIlIllIlIIl;
    }

    public int getTileY(int llllllllllllllllIllIllIlIlllIIIl) {
        TileSet llllllllllllllllIllIllIlIlllIIII;
        return llllllllllllllllIllIllIlIlllIIIl / llllllllllllllllIllIllIlIlllIIII.tilesAcross;
    }

    public void setTileSetImage(Image llllllllllllllllIllIllIllIIIIIIl) {
        TileSet llllllllllllllllIllIllIllIIIIlII;
        llllllllllllllllIllIllIllIIIIlII.tiles = new SpriteSheet(llllllllllllllllIllIllIllIIIIIIl, llllllllllllllllIllIllIllIIIIlII.tileWidth, llllllllllllllllIllIllIllIIIIlII.tileHeight, llllllllllllllllIllIllIllIIIIlII.tileSpacing, llllllllllllllllIllIllIllIIIIlII.tileMargin);
        llllllllllllllllIllIllIllIIIIlII.tilesAcross = llllllllllllllllIllIllIllIIIIlII.tiles.getHorizontalCount();
        llllllllllllllllIllIllIllIIIIlII.tilesDown = llllllllllllllllIllIllIllIIIIlII.tiles.getVerticalCount();
        if (llllllllllllllllIllIllIllIIIIlII.tilesAcross <= 0) {
            llllllllllllllllIllIllIllIIIIlII.tilesAcross = 1;
        }
        if (llllllllllllllllIllIllIllIIIIlII.tilesDown <= 0) {
            llllllllllllllllIllIllIllIIIIlII.tilesDown = 1;
        }
        llllllllllllllllIllIllIllIIIIlII.lastGID = llllllllllllllllIllIllIllIIIIlII.tilesAcross * llllllllllllllllIllIllIllIIIIlII.tilesDown + llllllllllllllllIllIllIllIIIIlII.firstGID - 1;
    }

    public Properties getProperties(int llllllllllllllllIllIllIlIllllIll) {
        TileSet llllllllllllllllIllIllIlIllllllI;
        return (Properties)llllllllllllllllIllIllIlIllllllI.props.get(new Integer(llllllllllllllllIllIllIlIllllIll));
    }

    public boolean contains(int llllllllllllllllIllIllIlIllIIIll) {
        TileSet llllllllllllllllIllIllIlIllIIllI;
        return llllllllllllllllIllIllIlIllIIIll >= llllllllllllllllIllIllIlIllIIllI.firstGID && llllllllllllllllIllIllIlIllIIIll <= llllllllllllllllIllIllIlIllIIllI.lastGID;
    }
}

