/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tiled;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.Layer;
import org.newdawn.slick.tiled.TileSet;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TiledMap {
    protected /* synthetic */ int width;
    private static /* synthetic */ boolean headless;
    protected /* synthetic */ int tileWidth;
    protected /* synthetic */ int orientation;
    protected /* synthetic */ Properties props;
    private /* synthetic */ boolean loadTileSets;
    protected /* synthetic */ ArrayList objectGroups;
    protected static final /* synthetic */ int ISOMETRIC;
    protected /* synthetic */ ArrayList layers;
    protected static final /* synthetic */ int ORTHOGONAL;
    protected /* synthetic */ String tilesLocation;
    protected /* synthetic */ int height;
    protected /* synthetic */ int tileHeight;
    protected /* synthetic */ ArrayList tileSets;

    public TiledMap(InputStream llllllllllllllllIIIIIlIlIIIIIlII) throws SlickException {
        TiledMap llllllllllllllllIIIIIlIlIIIIIIll;
        llllllllllllllllIIIIIlIlIIIIIIll.tileSets = new ArrayList();
        llllllllllllllllIIIIIlIlIIIIIIll.layers = new ArrayList();
        llllllllllllllllIIIIIlIlIIIIIIll.objectGroups = new ArrayList();
        llllllllllllllllIIIIIlIlIIIIIIll.loadTileSets = true;
        llllllllllllllllIIIIIlIlIIIIIIll.load(llllllllllllllllIIIIIlIlIIIIIlII, "");
    }

    public void render(int llllllllllllllllIIIIIlIIIlllIIII, int llllllllllllllllIIIIIlIIIllIllII) {
        TiledMap llllllllllllllllIIIIIlIIIlllIIIl;
        llllllllllllllllIIIIIlIIIlllIIIl.render(llllllllllllllllIIIIIlIIIlllIIII, llllllllllllllllIIIIIlIIIllIllII, 0, 0, llllllllllllllllIIIIIlIIIlllIIIl.width, llllllllllllllllIIIIIlIIIlllIIIl.height, false);
    }

    public String getTileProperty(int llllllllllllllllIIIIIlIIIlllllll, String llllllllllllllllIIIIIlIIIllllllI, String llllllllllllllllIIIIIlIIIlllIlll) {
        TiledMap llllllllllllllllIIIIIlIIlIIIIIII;
        if (llllllllllllllllIIIIIlIIIlllllll == 0) {
            return llllllllllllllllIIIIIlIIIlllIlll;
        }
        TileSet llllllllllllllllIIIIIlIIIlllllII = llllllllllllllllIIIIIlIIlIIIIIII.findTileSet(llllllllllllllllIIIIIlIIIlllllll);
        Properties llllllllllllllllIIIIIlIIIllllIll = llllllllllllllllIIIIIlIIIlllllII.getProperties(llllllllllllllllIIIIIlIIIlllllll);
        if (llllllllllllllllIIIIIlIIIllllIll == null) {
            return llllllllllllllllIIIIIlIIIlllIlll;
        }
        return llllllllllllllllIIIIIlIIIllllIll.getProperty(llllllllllllllllIIIIIlIIIllllllI, llllllllllllllllIIIIIlIIIlllIlll);
    }

    public TileSet findTileSet(int llllllllllllllllIIIIIIllIllIIIIl) {
        TiledMap llllllllllllllllIIIIIIllIllIIlII;
        for (int llllllllllllllllIIIIIIllIllIIlIl = 0; llllllllllllllllIIIIIIllIllIIlIl < llllllllllllllllIIIIIIllIllIIlII.tileSets.size(); ++llllllllllllllllIIIIIIllIllIIlIl) {
            TileSet llllllllllllllllIIIIIIllIllIIllI = (TileSet)llllllllllllllllIIIIIIllIllIIlII.tileSets.get(llllllllllllllllIIIIIIllIllIIlIl);
            if (!llllllllllllllllIIIIIIllIllIIllI.contains(llllllllllllllllIIIIIIllIllIIIIl)) continue;
            return llllllllllllllllIIIIIIllIllIIllI;
        }
        return null;
    }

    public String getMapProperty(String llllllllllllllllIIIIIlIIlIIlIlll, String llllllllllllllllIIIIIlIIlIIlIllI) {
        TiledMap llllllllllllllllIIIIIlIIlIIllIII;
        if (llllllllllllllllIIIIIlIIlIIllIII.props == null) {
            return llllllllllllllllIIIIIlIIlIIlIllI;
        }
        return llllllllllllllllIIIIIlIIlIIllIII.props.getProperty(llllllllllllllllIIIIIlIIlIIlIlll, llllllllllllllllIIIIIlIIlIIlIllI);
    }

    public String getTilesLocation() {
        TiledMap llllllllllllllllIIIIIlIIllllIlll;
        return llllllllllllllllIIIIIlIIllllIlll.tilesLocation;
    }

    public TileSet getTileSetByGID(int llllllllllllllllIIIIIIllIllIllIl) {
        TiledMap llllllllllllllllIIIIIIllIllIlllI;
        for (int llllllllllllllllIIIIIIllIlllIIIl = 0; llllllllllllllllIIIIIIllIlllIIIl < llllllllllllllllIIIIIIllIllIlllI.tileSets.size(); ++llllllllllllllllIIIIIIllIlllIIIl) {
            TileSet llllllllllllllllIIIIIIllIlllIIlI = (TileSet)llllllllllllllllIIIIIIllIllIlllI.tileSets.get(llllllllllllllllIIIIIIllIlllIIIl);
            if (!llllllllllllllllIIIIIIllIlllIIlI.contains(llllllllllllllllIIIIIIllIllIllIl)) continue;
            return llllllllllllllllIIIIIIllIlllIIlI;
        }
        return null;
    }

    public int getTileWidth() {
        TiledMap llllllllllllllllIIIIIlIIllIIIIII;
        return llllllllllllllllIIIIIlIIllIIIIII.tileWidth;
    }

    public int getWidth() {
        TiledMap llllllllllllllllIIIIIlIIllIIlIIl;
        return llllllllllllllllIIIIIlIIllIIlIIl.width;
    }

    public String getObjectImage(int llllllllllllllllIIIIIIlIlllIlIIl, int llllllllllllllllIIIIIIlIlllIlIII) {
        TiledMap llllllllllllllllIIIIIIlIlllIlIlI;
        if (llllllllllllllllIIIIIIlIlllIlIIl >= 0 && llllllllllllllllIIIIIIlIlllIlIIl < llllllllllllllllIIIIIIlIlllIlIlI.objectGroups.size()) {
            ObjectGroup llllllllllllllllIIIIIIlIlllIlllI = (ObjectGroup)llllllllllllllllIIIIIIlIlllIlIlI.objectGroups.get(llllllllllllllllIIIIIIlIlllIlIIl);
            if (llllllllllllllllIIIIIIlIlllIlIII >= 0 && llllllllllllllllIIIIIIlIlllIlIII < llllllllllllllllIIIIIIlIlllIlllI.objects.size()) {
                GroupObject llllllllllllllllIIIIIIlIlllIllll = (GroupObject)llllllllllllllllIIIIIIlIlllIlllI.objects.get(llllllllllllllllIIIIIIlIlllIlIII);
                if (llllllllllllllllIIIIIIlIlllIllll == null) {
                    return null;
                }
                return llllllllllllllllIIIIIIlIlllIllll.image;
            }
        }
        return null;
    }

    protected void renderedLine(int llllllllllllllllIIIIIIllIlIlllIl, int llllllllllllllllIIIIIIllIlIlllII, int llllllllllllllllIIIIIIllIlIllIll) {
    }

    private int parseInt(String llllllllllllllllIIIIIIlllIllIlll) {
        try {
            return Integer.parseInt(llllllllllllllllIIIIIIlllIllIlll);
        }
        catch (NumberFormatException llllllllllllllllIIIIIIlllIlllIIl) {
            return 0;
        }
    }

    static {
        ISOMETRIC = 2;
        ORTHOGONAL = 1;
    }

    public TiledMap(String llllllllllllllllIIIIIlIlIIIllIlI) throws SlickException {
        llllllllllllllllIIIIIlIlIIIllIll(llllllllllllllllIIIIIlIlIIIllIlI, true);
        TiledMap llllllllllllllllIIIIIlIlIIIllIll;
    }

    public int getObjectX(int llllllllllllllllIIIIIIllIIlIIlIl, int llllllllllllllllIIIIIIllIIlIIlII) {
        TiledMap llllllllllllllllIIIIIIllIIlIlIIl;
        if (llllllllllllllllIIIIIIllIIlIIlIl >= 0 && llllllllllllllllIIIIIIllIIlIIlIl < llllllllllllllllIIIIIIllIIlIlIIl.objectGroups.size()) {
            ObjectGroup llllllllllllllllIIIIIIllIIlIlIlI = (ObjectGroup)llllllllllllllllIIIIIIllIIlIlIIl.objectGroups.get(llllllllllllllllIIIIIIllIIlIIlIl);
            if (llllllllllllllllIIIIIIllIIlIIlII >= 0 && llllllllllllllllIIIIIIllIIlIIlII < llllllllllllllllIIIIIIllIIlIlIlI.objects.size()) {
                GroupObject llllllllllllllllIIIIIIllIIlIlIll = (GroupObject)llllllllllllllllIIIIIIllIIlIlIlI.objects.get(llllllllllllllllIIIIIIllIIlIIlII);
                return llllllllllllllllIIIIIIllIIlIlIll.x;
            }
        }
        return -1;
    }

    public int getObjectHeight(int llllllllllllllllIIIIIIlIlllllIII, int llllllllllllllllIIIIIIlIllllIlll) {
        TiledMap llllllllllllllllIIIIIIlIllllllII;
        if (llllllllllllllllIIIIIIlIlllllIII >= 0 && llllllllllllllllIIIIIIlIlllllIII < llllllllllllllllIIIIIIlIllllllII.objectGroups.size()) {
            ObjectGroup llllllllllllllllIIIIIIlIllllllIl = (ObjectGroup)llllllllllllllllIIIIIIlIllllllII.objectGroups.get(llllllllllllllllIIIIIIlIlllllIII);
            if (llllllllllllllllIIIIIIlIllllIlll >= 0 && llllllllllllllllIIIIIIlIllllIlll < llllllllllllllllIIIIIIlIllllllIl.objects.size()) {
                GroupObject llllllllllllllllIIIIIIlIlllllllI = (GroupObject)llllllllllllllllIIIIIIlIllllllIl.objects.get(llllllllllllllllIIIIIIlIllllIlll);
                return llllllllllllllllIIIIIIlIlllllllI.height;
            }
        }
        return -1;
    }

    private void load(InputStream llllllllllllllllIIIIIIlllIIIlllI, String llllllllllllllllIIIIIIlllIIIllIl) throws SlickException {
        llllllllllllllllIIIIIIlllIIIllII.tilesLocation = llllllllllllllllIIIIIIlllIIIllIl;
        try {
            NodeList llllllllllllllllIIIIIIlllIlIIIll;
            TiledMap llllllllllllllllIIIIIIlllIIIllII;
            DocumentBuilderFactory llllllllllllllllIIIIIIlllIIlIlll = DocumentBuilderFactory.newInstance();
            llllllllllllllllIIIIIIlllIIlIlll.setValidating(false);
            DocumentBuilder llllllllllllllllIIIIIIlllIIlIllI = llllllllllllllllIIIIIIlllIIlIlll.newDocumentBuilder();
            llllllllllllllllIIIIIIlllIIlIllI.setEntityResolver(new EntityResolver(){
                {
                    1 llIlIlIIIlIIlI;
                }

                @Override
                public InputSource resolveEntity(String llIlIlIIIIlllI, String llIlIlIIIIllII) throws IOException, SAXException {
                    return new InputSource(new ByteArrayInputStream(new byte[0]));
                }
            });
            Document llllllllllllllllIIIIIIlllIIlIlIl = llllllllllllllllIIIIIIlllIIlIllI.parse(llllllllllllllllIIIIIIlllIIIlllI);
            Element llllllllllllllllIIIIIIlllIIlIlII = llllllllllllllllIIIIIIlllIIlIlIl.getDocumentElement();
            llllllllllllllllIIIIIIlllIIIllII.orientation = llllllllllllllllIIIIIIlllIIlIlII.getAttribute("orientation").equals("orthogonal") ? 1 : 2;
            llllllllllllllllIIIIIIlllIIIllII.width = llllllllllllllllIIIIIIlllIIIllII.parseInt(llllllllllllllllIIIIIIlllIIlIlII.getAttribute("width"));
            llllllllllllllllIIIIIIlllIIIllII.height = llllllllllllllllIIIIIIlllIIIllII.parseInt(llllllllllllllllIIIIIIlllIIlIlII.getAttribute("height"));
            llllllllllllllllIIIIIIlllIIIllII.tileWidth = llllllllllllllllIIIIIIlllIIIllII.parseInt(llllllllllllllllIIIIIIlllIIlIlII.getAttribute("tilewidth"));
            llllllllllllllllIIIIIIlllIIIllII.tileHeight = llllllllllllllllIIIIIIlllIIIllII.parseInt(llllllllllllllllIIIIIIlllIIlIlII.getAttribute("tileheight"));
            Element llllllllllllllllIIIIIIlllIIlIIll = (Element)llllllllllllllllIIIIIIlllIIlIlII.getElementsByTagName("properties").item(0);
            if (llllllllllllllllIIIIIIlllIIlIIll != null && (llllllllllllllllIIIIIIlllIlIIIll = llllllllllllllllIIIIIIlllIIlIIll.getElementsByTagName("property")) != null) {
                llllllllllllllllIIIIIIlllIIIllII.props = new Properties();
                for (int llllllllllllllllIIIIIIlllIlIIlII = 0; llllllllllllllllIIIIIIlllIlIIlII < llllllllllllllllIIIIIIlllIlIIIll.getLength(); ++llllllllllllllllIIIIIIlllIlIIlII) {
                    Element llllllllllllllllIIIIIIlllIlIIlll = (Element)llllllllllllllllIIIIIIlllIlIIIll.item(llllllllllllllllIIIIIIlllIlIIlII);
                    String llllllllllllllllIIIIIIlllIlIIllI = llllllllllllllllIIIIIIlllIlIIlll.getAttribute("name");
                    String llllllllllllllllIIIIIIlllIlIIlIl = llllllllllllllllIIIIIIlllIlIIlll.getAttribute("value");
                    llllllllllllllllIIIIIIlllIIIllII.props.setProperty(llllllllllllllllIIIIIIlllIlIIllI, llllllllllllllllIIIIIIlllIlIIlIl);
                }
            }
            if (llllllllllllllllIIIIIIlllIIIllII.loadTileSets) {
                TileSet llllllllllllllllIIIIIIlllIlIIIII = null;
                TileSet llllllllllllllllIIIIIIlllIIlllll = null;
                NodeList llllllllllllllllIIIIIIlllIIllllI = llllllllllllllllIIIIIIlllIIlIlII.getElementsByTagName("tileset");
                for (int llllllllllllllllIIIIIIlllIlIIIIl = 0; llllllllllllllllIIIIIIlllIlIIIIl < llllllllllllllllIIIIIIlllIIllllI.getLength(); ++llllllllllllllllIIIIIIlllIlIIIIl) {
                    Element llllllllllllllllIIIIIIlllIlIIIlI = (Element)llllllllllllllllIIIIIIlllIIllllI.item(llllllllllllllllIIIIIIlllIlIIIIl);
                    llllllllllllllllIIIIIIlllIlIIIII = new TileSet(llllllllllllllllIIIIIIlllIIIllII, llllllllllllllllIIIIIIlllIlIIIlI, !headless);
                    llllllllllllllllIIIIIIlllIlIIIII.index = llllllllllllllllIIIIIIlllIlIIIIl;
                    if (llllllllllllllllIIIIIIlllIIlllll != null) {
                        llllllllllllllllIIIIIIlllIIlllll.setLimit(llllllllllllllllIIIIIIlllIlIIIII.firstGID - 1);
                    }
                    llllllllllllllllIIIIIIlllIIlllll = llllllllllllllllIIIIIIlllIlIIIII;
                    llllllllllllllllIIIIIIlllIIIllII.tileSets.add(llllllllllllllllIIIIIIlllIlIIIII);
                }
            }
            NodeList llllllllllllllllIIIIIIlllIIlIIlI = llllllllllllllllIIIIIIlllIIlIlII.getElementsByTagName("layer");
            int llllllllllllllllIIIIIIlllIIllIll = 0;
            while (llllllllllllllllIIIIIIlllIIllIll < llllllllllllllllIIIIIIlllIIlIIlI.getLength()) {
                Element llllllllllllllllIIIIIIlllIIlllIl = (Element)llllllllllllllllIIIIIIlllIIlIIlI.item(llllllllllllllllIIIIIIlllIIllIll);
                Layer llllllllllllllllIIIIIIlllIIlllII = new Layer(llllllllllllllllIIIIIIlllIIIllII, llllllllllllllllIIIIIIlllIIlllIl);
                llllllllllllllllIIIIIIlllIIlllII.index = llllllllllllllllIIIIIIlllIIllIll++;
                llllllllllllllllIIIIIIlllIIIllII.layers.add(llllllllllllllllIIIIIIlllIIlllII);
            }
            NodeList llllllllllllllllIIIIIIlllIIlIIIl = llllllllllllllllIIIIIIlllIIlIlII.getElementsByTagName("objectgroup");
            int llllllllllllllllIIIIIIlllIIllIII = 0;
            while (llllllllllllllllIIIIIIlllIIllIII < llllllllllllllllIIIIIIlllIIlIIIl.getLength()) {
                Element llllllllllllllllIIIIIIlllIIllIlI = (Element)llllllllllllllllIIIIIIlllIIlIIIl.item(llllllllllllllllIIIIIIlllIIllIII);
                ObjectGroup llllllllllllllllIIIIIIlllIIllIIl = llllllllllllllllIIIIIIlllIIIllII.new ObjectGroup(llllllllllllllllIIIIIIlllIIllIlI);
                llllllllllllllllIIIIIIlllIIllIIl.index = llllllllllllllllIIIIIIlllIIllIII++;
                llllllllllllllllIIIIIIlllIIIllII.objectGroups.add(llllllllllllllllIIIIIIlllIIllIIl);
            }
        }
        catch (Exception llllllllllllllllIIIIIIlllIIlIIII) {
            Log.error(llllllllllllllllIIIIIIlllIIlIIII);
            throw new SlickException("Failed to parse tilemap", llllllllllllllllIIIIIIlllIIlIIII);
        }
    }

    public void render(int llllllllllllllllIIIIIlIIIIIIllII, int llllllllllllllllIIIIIlIIIIIIlIll, int llllllllllllllllIIIIIlIIIIIIlIlI, int llllllllllllllllIIIIIlIIIIIIlIIl, int llllllllllllllllIIIIIlIIIIIIlIII, int llllllllllllllllIIIIIlIIIIIIllll, boolean llllllllllllllllIIIIIlIIIIIIIllI) {
        TiledMap llllllllllllllllIIIIIlIIIIIIllIl;
        switch (llllllllllllllllIIIIIlIIIIIIllIl.orientation) {
            case 1: {
                for (int llllllllllllllllIIIIIlIIIIIlIllI = 0; llllllllllllllllIIIIIlIIIIIlIllI < llllllllllllllllIIIIIlIIIIIIllll; ++llllllllllllllllIIIIIlIIIIIlIllI) {
                    for (int llllllllllllllllIIIIIlIIIIIlIlll = 0; llllllllllllllllIIIIIlIIIIIlIlll < llllllllllllllllIIIIIlIIIIIIllIl.layers.size(); ++llllllllllllllllIIIIIlIIIIIlIlll) {
                        Layer llllllllllllllllIIIIIlIIIIIllIII = (Layer)llllllllllllllllIIIIIlIIIIIIllIl.layers.get(llllllllllllllllIIIIIlIIIIIlIlll);
                        llllllllllllllllIIIIIlIIIIIllIII.render(llllllllllllllllIIIIIlIIIIIIllII, llllllllllllllllIIIIIlIIIIIIlIll, llllllllllllllllIIIIIlIIIIIIlIlI, llllllllllllllllIIIIIlIIIIIIlIIl, llllllllllllllllIIIIIlIIIIIIlIII, llllllllllllllllIIIIIlIIIIIlIllI, llllllllllllllllIIIIIlIIIIIIIllI, llllllllllllllllIIIIIlIIIIIIllIl.tileWidth, llllllllllllllllIIIIIlIIIIIIllIl.tileHeight);
                    }
                }
                break;
            }
            case 2: {
                llllllllllllllllIIIIIlIIIIIIllIl.renderIsometricMap(llllllllllllllllIIIIIlIIIIIIllII, llllllllllllllllIIIIIlIIIIIIlIll, llllllllllllllllIIIIIlIIIIIIlIlI, llllllllllllllllIIIIIlIIIIIIlIIl, llllllllllllllllIIIIIlIIIIIIlIII, llllllllllllllllIIIIIlIIIIIIllll, null, llllllllllllllllIIIIIlIIIIIIIllI);
                break;
            }
        }
    }

    public int getHeight() {
        TiledMap llllllllllllllllIIIIIlIIllIIIlll;
        return llllllllllllllllIIIIIlIIllIIIlll.height;
    }

    public String getObjectProperty(int llllllllllllllllIIIIIIlIllIlIllI, int llllllllllllllllIIIIIIlIllIlIlIl, String llllllllllllllllIIIIIIlIllIlIlII, String llllllllllllllllIIIIIIlIllIlIIll) {
        TiledMap llllllllllllllllIIIIIIlIllIlIlll;
        if (llllllllllllllllIIIIIIlIllIlIllI >= 0 && llllllllllllllllIIIIIIlIllIlIllI < llllllllllllllllIIIIIIlIllIlIlll.objectGroups.size()) {
            ObjectGroup llllllllllllllllIIIIIIlIllIlllIl = (ObjectGroup)llllllllllllllllIIIIIIlIllIlIlll.objectGroups.get(llllllllllllllllIIIIIIlIllIlIllI);
            if (llllllllllllllllIIIIIIlIllIlIlIl >= 0 && llllllllllllllllIIIIIIlIllIlIlIl < llllllllllllllllIIIIIIlIllIlllIl.objects.size()) {
                GroupObject llllllllllllllllIIIIIIlIllIllllI = (GroupObject)llllllllllllllllIIIIIIlIllIlllIl.objects.get(llllllllllllllllIIIIIIlIllIlIlIl);
                if (llllllllllllllllIIIIIIlIllIllllI == null) {
                    return llllllllllllllllIIIIIIlIllIlIIll;
                }
                if (llllllllllllllllIIIIIIlIllIllllI.props == null) {
                    return llllllllllllllllIIIIIIlIllIlIIll;
                }
                return llllllllllllllllIIIIIIlIllIllllI.props.getProperty(llllllllllllllllIIIIIIlIllIlIlII, llllllllllllllllIIIIIIlIllIlIIll);
            }
        }
        return llllllllllllllllIIIIIIlIllIlIIll;
    }

    public int getTileSetCount() {
        TiledMap llllllllllllllllIIIIIIllIlllllIl;
        return llllllllllllllllIIIIIIllIlllllIl.tileSets.size();
    }

    public void render(int llllllllllllllllIIIIIlIIIllIIIlI, int llllllllllllllllIIIIIlIIIllIIIIl, int llllllllllllllllIIIIIlIIIllIIlII) {
        TiledMap llllllllllllllllIIIIIlIIIllIIIll;
        llllllllllllllllIIIIIlIIIllIIIll.render(llllllllllllllllIIIIIlIIIllIIIlI, llllllllllllllllIIIIIlIIIllIIIIl, 0, 0, llllllllllllllllIIIIIlIIIllIIIll.getWidth(), llllllllllllllllIIIIIlIIIllIIIll.getHeight(), llllllllllllllllIIIIIlIIIllIIlII, false);
    }

    public int getLayerCount() {
        TiledMap llllllllllllllllIIIIIIlllIllllIl;
        return llllllllllllllllIIIIIIlllIllllIl.layers.size();
    }

    public String getObjectType(int llllllllllllllllIIIIIIllIIllIlII, int llllllllllllllllIIIIIIllIIllIllI) {
        TiledMap llllllllllllllllIIIIIIllIIlllIII;
        if (llllllllllllllllIIIIIIllIIllIlII >= 0 && llllllllllllllllIIIIIIllIIllIlII < llllllllllllllllIIIIIIllIIlllIII.objectGroups.size()) {
            ObjectGroup llllllllllllllllIIIIIIllIIlllIIl = (ObjectGroup)llllllllllllllllIIIIIIllIIlllIII.objectGroups.get(llllllllllllllllIIIIIIllIIllIlII);
            if (llllllllllllllllIIIIIIllIIllIllI >= 0 && llllllllllllllllIIIIIIllIIllIllI < llllllllllllllllIIIIIIllIIlllIIl.objects.size()) {
                GroupObject llllllllllllllllIIIIIIllIIlllIlI = (GroupObject)llllllllllllllllIIIIIIllIIlllIIl.objects.get(llllllllllllllllIIIIIIllIIllIllI);
                return llllllllllllllllIIIIIIllIIlllIlI.type;
            }
        }
        return null;
    }

    public TiledMap(String llllllllllllllllIIIIIlIlIIIlIlIl, boolean llllllllllllllllIIIIIlIlIIIlIIIl) throws SlickException {
        TiledMap llllllllllllllllIIIIIlIlIIIlIllI;
        llllllllllllllllIIIIIlIlIIIlIllI.tileSets = new ArrayList();
        llllllllllllllllIIIIIlIlIIIlIllI.layers = new ArrayList();
        llllllllllllllllIIIIIlIlIIIlIllI.objectGroups = new ArrayList();
        llllllllllllllllIIIIIlIlIIIlIllI.loadTileSets = true;
        llllllllllllllllIIIIIlIlIIIlIllI.loadTileSets = llllllllllllllllIIIIIlIlIIIlIIIl;
        llllllllllllllllIIIIIlIlIIIlIlIl = llllllllllllllllIIIIIlIlIIIlIlIl.replace('\\', '/');
        llllllllllllllllIIIIIlIlIIIlIllI.load(ResourceLoader.getResourceAsStream(llllllllllllllllIIIIIlIlIIIlIlIl), llllllllllllllllIIIIIlIlIIIlIlIl.substring(0, llllllllllllllllIIIIIlIlIIIlIlIl.lastIndexOf("/")));
    }

    public TiledMap(InputStream llllllllllllllllIIIIIlIIlllllIlI, String llllllllllllllllIIIIIlIIlllllIIl) throws SlickException {
        TiledMap llllllllllllllllIIIIIlIIlllllIll;
        llllllllllllllllIIIIIlIIlllllIll.tileSets = new ArrayList();
        llllllllllllllllIIIIIlIIlllllIll.layers = new ArrayList();
        llllllllllllllllIIIIIlIIlllllIll.objectGroups = new ArrayList();
        llllllllllllllllIIIIIlIIlllllIll.loadTileSets = true;
        llllllllllllllllIIIIIlIIlllllIll.load(llllllllllllllllIIIIIlIIlllllIlI, llllllllllllllllIIIIIlIIlllllIIl);
    }

    public TiledMap(String llllllllllllllllIIIIIlIlIIIIlIIl, String llllllllllllllllIIIIIlIlIIIIlIII) throws SlickException {
        TiledMap llllllllllllllllIIIIIlIlIIIIllIl;
        llllllllllllllllIIIIIlIlIIIIllIl.tileSets = new ArrayList();
        llllllllllllllllIIIIIlIlIIIIllIl.layers = new ArrayList();
        llllllllllllllllIIIIIlIlIIIIllIl.objectGroups = new ArrayList();
        llllllllllllllllIIIIIlIlIIIIllIl.loadTileSets = true;
        llllllllllllllllIIIIIlIlIIIIllIl.load(ResourceLoader.getResourceAsStream(llllllllllllllllIIIIIlIlIIIIlIIl), llllllllllllllllIIIIIlIlIIIIlIII);
    }

    public int getLayerIndex(String llllllllllllllllIIIIIlIIlllIlIlI) {
        TiledMap llllllllllllllllIIIIIlIIlllIlllI;
        boolean llllllllllllllllIIIIIlIIlllIllII = false;
        for (int llllllllllllllllIIIIIlIIlllIllll = 0; llllllllllllllllIIIIIlIIlllIllll < llllllllllllllllIIIIIlIIlllIlllI.layers.size(); ++llllllllllllllllIIIIIlIIlllIllll) {
            Layer llllllllllllllllIIIIIlIIllllIIII = (Layer)llllllllllllllllIIIIIlIIlllIlllI.layers.get(llllllllllllllllIIIIIlIIlllIllll);
            if (!llllllllllllllllIIIIIlIIllllIIII.name.equals(llllllllllllllllIIIIIlIIlllIlIlI)) continue;
            return llllllllllllllllIIIIIlIIlllIllll;
        }
        return -1;
    }

    private static void setHeadless(boolean llllllllllllllllIIIIIlIlIIlIIIIl) {
        headless = llllllllllllllllIIIIIlIlIIlIIIIl;
    }

    public void setTileId(int llllllllllllllllIIIIIlIIlIlIIIll, int llllllllllllllllIIIIIlIIlIlIIIlI, int llllllllllllllllIIIIIlIIlIlIIIIl, int llllllllllllllllIIIIIlIIlIlIIIII) {
        TiledMap llllllllllllllllIIIIIlIIlIlIlIlI;
        Layer llllllllllllllllIIIIIlIIlIlIIlIl = (Layer)llllllllllllllllIIIIIlIIlIlIlIlI.layers.get(llllllllllllllllIIIIIlIIlIlIIIIl);
        llllllllllllllllIIIIIlIIlIlIIlIl.setTileID(llllllllllllllllIIIIIlIIlIlIIIll, llllllllllllllllIIIIIlIIlIlIIIlI, llllllllllllllllIIIIIlIIlIlIIIII);
    }

    public int getObjectY(int llllllllllllllllIIIIIIllIIIlIllI, int llllllllllllllllIIIIIIllIIIlIlIl) {
        TiledMap llllllllllllllllIIIIIIllIIIlIlll;
        if (llllllllllllllllIIIIIIllIIIlIllI >= 0 && llllllllllllllllIIIIIIllIIIlIllI < llllllllllllllllIIIIIIllIIIlIlll.objectGroups.size()) {
            ObjectGroup llllllllllllllllIIIIIIllIIIllIll = (ObjectGroup)llllllllllllllllIIIIIIllIIIlIlll.objectGroups.get(llllllllllllllllIIIIIIllIIIlIllI);
            if (llllllllllllllllIIIIIIllIIIlIlIl >= 0 && llllllllllllllllIIIIIIllIIIlIlIl < llllllllllllllllIIIIIIllIIIllIll.objects.size()) {
                GroupObject llllllllllllllllIIIIIIllIIIlllII = (GroupObject)llllllllllllllllIIIIIIllIIIllIll.objects.get(llllllllllllllllIIIIIIllIIIlIlIl);
                return llllllllllllllllIIIIIIllIIIlllII.y;
            }
        }
        return -1;
    }

    public int getObjectCount(int llllllllllllllllIIIIIIllIlIlIIII) {
        TiledMap llllllllllllllllIIIIIIllIlIlIIll;
        if (llllllllllllllllIIIIIIllIlIlIIII >= 0 && llllllllllllllllIIIIIIllIlIlIIII < llllllllllllllllIIIIIIllIlIlIIll.objectGroups.size()) {
            ObjectGroup llllllllllllllllIIIIIIllIlIlIlII = (ObjectGroup)llllllllllllllllIIIIIIllIlIlIIll.objectGroups.get(llllllllllllllllIIIIIIllIlIlIIII);
            return llllllllllllllllIIIIIIllIlIlIlII.objects.size();
        }
        return -1;
    }

    public int getObjectGroupCount() {
        TiledMap llllllllllllllllIIIIIIllIlIllIIl;
        return llllllllllllllllIIIIIIllIlIllIIl.objectGroups.size();
    }

    public Image getTileImage(int llllllllllllllllIIIIIlIIllIllIIl, int llllllllllllllllIIIIIlIIllIllIII, int llllllllllllllllIIIIIlIIllIlIlll) {
        TiledMap llllllllllllllllIIIIIlIIllIllIlI;
        Layer llllllllllllllllIIIIIlIIllIlIllI = (Layer)llllllllllllllllIIIIIlIIllIllIlI.layers.get(llllllllllllllllIIIIIlIIllIlIlll);
        int llllllllllllllllIIIIIlIIllIlIlIl = llllllllllllllllIIIIIlIIllIlIllI.data[llllllllllllllllIIIIIlIIllIllIIl][llllllllllllllllIIIIIlIIllIllIII][0];
        if (llllllllllllllllIIIIIlIIllIlIlIl >= 0 && llllllllllllllllIIIIIlIIllIlIlIl < llllllllllllllllIIIIIlIIllIllIlI.tileSets.size()) {
            TileSet llllllllllllllllIIIIIlIIllIlllIl = (TileSet)llllllllllllllllIIIIIlIIllIllIlI.tileSets.get(llllllllllllllllIIIIIlIIllIlIlIl);
            int llllllllllllllllIIIIIlIIllIlllII = llllllllllllllllIIIIIlIIllIlllIl.getTileX(llllllllllllllllIIIIIlIIllIlIllI.data[llllllllllllllllIIIIIlIIllIllIIl][llllllllllllllllIIIIIlIIllIllIII][1]);
            int llllllllllllllllIIIIIlIIllIllIll = llllllllllllllllIIIIIlIIllIlllIl.getTileY(llllllllllllllllIIIIIlIIllIlIllI.data[llllllllllllllllIIIIIlIIllIllIIl][llllllllllllllllIIIIIlIIllIllIII][1]);
            return llllllllllllllllIIIIIlIIllIlllIl.tiles.getSprite(llllllllllllllllIIIIIlIIllIlllII, llllllllllllllllIIIIIlIIllIllIll);
        }
        return null;
    }

    protected void renderIsometricMap(int llllllllllllllllIIIIIIlllllIIlII, int llllllllllllllllIIIIIIllllIlIIlI, int llllllllllllllllIIIIIIlllllIIIlI, int llllllllllllllllIIIIIIlllllIIIIl, int llllllllllllllllIIIIIIlllllIIIII, int llllllllllllllllIIIIIIllllIlllll, Layer llllllllllllllllIIIIIIllllIIllll, boolean llllllllllllllllIIIIIIllllIIlllI) {
        TiledMap llllllllllllllllIIIIIIllllIlIlII;
        ArrayList<Layer> llllllllllllllllIIIIIIllllIlllII = llllllllllllllllIIIIIIllllIlIlII.layers;
        if (llllllllllllllllIIIIIIllllIIllll != null) {
            llllllllllllllllIIIIIIllllIlllII = new ArrayList<Layer>();
            llllllllllllllllIIIIIIllllIlllII.add(llllllllllllllllIIIIIIllllIIllll);
        }
        int llllllllllllllllIIIIIIllllIllIll = llllllllllllllllIIIIIIlllllIIIII * llllllllllllllllIIIIIIllllIlllll;
        int llllllllllllllllIIIIIIllllIllIlI = 0;
        boolean llllllllllllllllIIIIIIllllIllIIl = false;
        int llllllllllllllllIIIIIIllllIllIII = llllllllllllllllIIIIIIlllllIIlII;
        int llllllllllllllllIIIIIIllllIlIlll = llllllllllllllllIIIIIIllllIlIIlI;
        int llllllllllllllllIIIIIIllllIlIllI = 0;
        int llllllllllllllllIIIIIIllllIlIlIl = 0;
        while (!llllllllllllllllIIIIIIllllIllIIl) {
            int llllllllllllllllIIIIIIlllllIlIIl = llllllllllllllllIIIIIIllllIlIllI;
            int llllllllllllllllIIIIIIlllllIlIII = llllllllllllllllIIIIIIllllIlIlIl;
            int llllllllllllllllIIIIIIlllllIIlll = llllllllllllllllIIIIIIllllIllIII;
            int llllllllllllllllIIIIIIlllllIIllI = 0;
            llllllllllllllllIIIIIIlllllIIllI = llllllllllllllllIIIIIIllllIlllll > llllllllllllllllIIIIIIlllllIIIII ? (llllllllllllllllIIIIIIllllIlIlIl < llllllllllllllllIIIIIIlllllIIIII - 1 ? llllllllllllllllIIIIIIllllIlIlIl : (llllllllllllllllIIIIIIlllllIIIII - llllllllllllllllIIIIIIlllllIlIIl < llllllllllllllllIIIIIIllllIlllll ? llllllllllllllllIIIIIIlllllIIIII - llllllllllllllllIIIIIIlllllIlIIl - 1 : llllllllllllllllIIIIIIlllllIIIII - 1)) : (llllllllllllllllIIIIIIllllIlIlIl < llllllllllllllllIIIIIIllllIlllll - 1 ? llllllllllllllllIIIIIIllllIlIlIl : (llllllllllllllllIIIIIIlllllIIIII - llllllllllllllllIIIIIIlllllIlIIl < llllllllllllllllIIIIIIllllIlllll ? llllllllllllllllIIIIIIlllllIIIII - llllllllllllllllIIIIIIlllllIlIIl - 1 : llllllllllllllllIIIIIIllllIlllll - 1));
            for (int llllllllllllllllIIIIIIlllllIlIlI = 0; llllllllllllllllIIIIIIlllllIlIlI <= llllllllllllllllIIIIIIlllllIIllI; ++llllllllllllllllIIIIIIlllllIlIlI) {
                for (int llllllllllllllllIIIIIIlllllIlIll = 0; llllllllllllllllIIIIIIlllllIlIll < llllllllllllllllIIIIIIllllIlllII.size(); ++llllllllllllllllIIIIIIlllllIlIll) {
                    Layer llllllllllllllllIIIIIIlllllIllII = (Layer)llllllllllllllllIIIIIIllllIlllII.get(llllllllllllllllIIIIIIlllllIlIll);
                    llllllllllllllllIIIIIIlllllIllII.render(llllllllllllllllIIIIIIlllllIIlll, llllllllllllllllIIIIIIllllIlIlll, llllllllllllllllIIIIIIlllllIlIIl, llllllllllllllllIIIIIIlllllIlIII, 1, 0, llllllllllllllllIIIIIIllllIIlllI, llllllllllllllllIIIIIIllllIlIlII.tileWidth, llllllllllllllllIIIIIIllllIlIlII.tileHeight);
                }
                llllllllllllllllIIIIIIlllllIIlll += llllllllllllllllIIIIIIllllIlIlII.tileWidth;
                ++llllllllllllllllIIIIIIllllIllIlI;
                ++llllllllllllllllIIIIIIlllllIlIIl;
                --llllllllllllllllIIIIIIlllllIlIII;
            }
            if (llllllllllllllllIIIIIIllllIlIlIl < llllllllllllllllIIIIIIllllIlllll - 1) {
                ++llllllllllllllllIIIIIIllllIlIlIl;
                llllllllllllllllIIIIIIllllIllIII -= llllllllllllllllIIIIIIllllIlIlII.tileWidth / 2;
                llllllllllllllllIIIIIIllllIlIlll += llllllllllllllllIIIIIIllllIlIlII.tileHeight / 2;
            } else {
                ++llllllllllllllllIIIIIIllllIlIllI;
                llllllllllllllllIIIIIIllllIllIII += llllllllllllllllIIIIIIllllIlIlII.tileWidth / 2;
                llllllllllllllllIIIIIIllllIlIlll += llllllllllllllllIIIIIIllllIlIlII.tileHeight / 2;
            }
            if (llllllllllllllllIIIIIIllllIllIlI < llllllllllllllllIIIIIIllllIllIll) continue;
            llllllllllllllllIIIIIIllllIllIIl = true;
        }
    }

    public String getObjectName(int llllllllllllllllIIIIIIllIlIIIIll, int llllllllllllllllIIIIIIllIlIIIIlI) {
        TiledMap llllllllllllllllIIIIIIllIlIIIlll;
        if (llllllllllllllllIIIIIIllIlIIIIll >= 0 && llllllllllllllllIIIIIIllIlIIIIll < llllllllllllllllIIIIIIllIlIIIlll.objectGroups.size()) {
            ObjectGroup llllllllllllllllIIIIIIllIlIIlIII = (ObjectGroup)llllllllllllllllIIIIIIllIlIIIlll.objectGroups.get(llllllllllllllllIIIIIIllIlIIIIll);
            if (llllllllllllllllIIIIIIllIlIIIIlI >= 0 && llllllllllllllllIIIIIIllIlIIIIlI < llllllllllllllllIIIIIIllIlIIlIII.objects.size()) {
                GroupObject llllllllllllllllIIIIIIllIlIIlIIl = (GroupObject)llllllllllllllllIIIIIIllIlIIlIII.objects.get(llllllllllllllllIIIIIIllIlIIIIlI);
                return llllllllllllllllIIIIIIllIlIIlIIl.name;
            }
        }
        return null;
    }

    public String getLayerProperty(int llllllllllllllllIIIIIlIIlIIIlIlI, String llllllllllllllllIIIIIlIIlIIIlIIl, String llllllllllllllllIIIIIlIIlIIIllIl) {
        TiledMap llllllllllllllllIIIIIlIIlIIlIIII;
        Layer llllllllllllllllIIIIIlIIlIIIllII = (Layer)llllllllllllllllIIIIIlIIlIIlIIII.layers.get(llllllllllllllllIIIIIlIIlIIIlIlI);
        if (llllllllllllllllIIIIIlIIlIIIllII == null || llllllllllllllllIIIIIlIIlIIIllII.props == null) {
            return llllllllllllllllIIIIIlIIlIIIllIl;
        }
        return llllllllllllllllIIIIIlIIlIIIllII.props.getProperty(llllllllllllllllIIIIIlIIlIIIlIIl, llllllllllllllllIIIIIlIIlIIIllIl);
    }

    public int getTileHeight() {
        TiledMap llllllllllllllllIIIIIlIIllIIIlII;
        return llllllllllllllllIIIIIlIIllIIIlII.tileHeight;
    }

    public int getObjectWidth(int llllllllllllllllIIIIIIllIIIIIlll, int llllllllllllllllIIIIIIllIIIIIllI) {
        TiledMap llllllllllllllllIIIIIIllIIIIlIII;
        if (llllllllllllllllIIIIIIllIIIIIlll >= 0 && llllllllllllllllIIIIIIllIIIIIlll < llllllllllllllllIIIIIIllIIIIlIII.objectGroups.size()) {
            ObjectGroup llllllllllllllllIIIIIIllIIIIllII = (ObjectGroup)llllllllllllllllIIIIIIllIIIIlIII.objectGroups.get(llllllllllllllllIIIIIIllIIIIIlll);
            if (llllllllllllllllIIIIIIllIIIIIllI >= 0 && llllllllllllllllIIIIIIllIIIIIllI < llllllllllllllllIIIIIIllIIIIllII.objects.size()) {
                GroupObject llllllllllllllllIIIIIIllIIIIllIl = (GroupObject)llllllllllllllllIIIIIIllIIIIllII.objects.get(llllllllllllllllIIIIIIllIIIIIllI);
                return llllllllllllllllIIIIIIllIIIIllIl.width;
            }
        }
        return -1;
    }

    public void render(int llllllllllllllllIIIIIlIIIIllllII, int llllllllllllllllIIIIIlIIIIlllIll, int llllllllllllllllIIIIIlIIIIlllIlI, int llllllllllllllllIIIIIlIIIIlIlIlI, int llllllllllllllllIIIIIlIIIIllIlll, int llllllllllllllllIIIIIlIIIIllIlIl, int llllllllllllllllIIIIIlIIIIlIIlll, boolean llllllllllllllllIIIIIlIIIIllIIll) {
        TiledMap llllllllllllllllIIIIIlIIIIlIllll;
        Layer llllllllllllllllIIIIIlIIIIllIIIl = (Layer)llllllllllllllllIIIIIlIIIIlIllll.layers.get(llllllllllllllllIIIIIlIIIIlIIlll);
        switch (llllllllllllllllIIIIIlIIIIlIllll.orientation) {
            case 1: {
                for (int llllllllllllllllIIIIIlIIIIllllll = 0; llllllllllllllllIIIIIlIIIIllllll < llllllllllllllllIIIIIlIIIIllIlIl; ++llllllllllllllllIIIIIlIIIIllllll) {
                    llllllllllllllllIIIIIlIIIIllIIIl.render(llllllllllllllllIIIIIlIIIIllllII, llllllllllllllllIIIIIlIIIIlllIll, llllllllllllllllIIIIIlIIIIlllIlI, llllllllllllllllIIIIIlIIIIlIlIlI, llllllllllllllllIIIIIlIIIIllIlll, llllllllllllllllIIIIIlIIIIllllll, llllllllllllllllIIIIIlIIIIllIIll, llllllllllllllllIIIIIlIIIIlIllll.tileWidth, llllllllllllllllIIIIIlIIIIlIllll.tileHeight);
                }
                break;
            }
            case 2: {
                llllllllllllllllIIIIIlIIIIlIllll.renderIsometricMap(llllllllllllllllIIIIIlIIIIllllII, llllllllllllllllIIIIIlIIIIlllIll, llllllllllllllllIIIIIlIIIIlllIlI, llllllllllllllllIIIIIlIIIIlIlIlI, llllllllllllllllIIIIIlIIIIllIlll, llllllllllllllllIIIIIlIIIIllIlIl, llllllllllllllllIIIIIlIIIIllIIIl, llllllllllllllllIIIIIlIIIIllIIll);
                break;
            }
        }
    }

    public void render(int llllllllllllllllIIIIIlIIIlIlIlll, int llllllllllllllllIIIIIlIIIlIIllll, int llllllllllllllllIIIIIlIIIlIIlllI, int llllllllllllllllIIIIIlIIIlIlIlII, int llllllllllllllllIIIIIlIIIlIIllII, int llllllllllllllllIIIIIlIIIlIIlIll) {
        TiledMap llllllllllllllllIIIIIlIIIlIlIIIl;
        llllllllllllllllIIIIIlIIIlIlIIIl.render(llllllllllllllllIIIIIlIIIlIlIlll, llllllllllllllllIIIIIlIIIlIIllll, llllllllllllllllIIIIIlIIIlIIlllI, llllllllllllllllIIIIIlIIIlIlIlII, llllllllllllllllIIIIIlIIIlIIllII, llllllllllllllllIIIIIlIIIlIIlIll, false);
    }

    public TileSet getTileSet(int llllllllllllllllIIIIIIllIllllIIl) {
        TiledMap llllllllllllllllIIIIIIllIllllIlI;
        return (TileSet)llllllllllllllllIIIIIIllIllllIlI.tileSets.get(llllllllllllllllIIIIIIllIllllIIl);
    }

    public int getTileId(int llllllllllllllllIIIIIlIIlIllIlII, int llllllllllllllllIIIIIlIIlIlllIII, int llllllllllllllllIIIIIlIIlIllIIlI) {
        TiledMap llllllllllllllllIIIIIlIIlIlllIlI;
        Layer llllllllllllllllIIIIIlIIlIllIllI = (Layer)llllllllllllllllIIIIIlIIlIlllIlI.layers.get(llllllllllllllllIIIIIlIIlIllIIlI);
        return llllllllllllllllIIIIIlIIlIllIllI.getTileID(llllllllllllllllIIIIIlIIlIllIlII, llllllllllllllllIIIIIlIIlIlllIII);
    }

    protected class GroupObject {
        public /* synthetic */ int x;
        public /* synthetic */ String type;
        public /* synthetic */ int y;
        public /* synthetic */ int height;
        public /* synthetic */ int width;
        public /* synthetic */ String name;
        public /* synthetic */ int index;
        public /* synthetic */ Properties props;
        private /* synthetic */ String image;

        public GroupObject(Element llllllllllllllllIlIIlIIIlIIlIIll) throws SlickException {
            NodeList llllllllllllllllIlIIlIIIlIIllIlI;
            Element llllllllllllllllIlIIlIIIlIIlIllI;
            GroupObject llllllllllllllllIlIIlIIIlIIllIIl;
            llllllllllllllllIlIIlIIIlIIllIIl.name = llllllllllllllllIlIIlIIIlIIlIIll.getAttribute("name");
            llllllllllllllllIlIIlIIIlIIllIIl.type = llllllllllllllllIlIIlIIIlIIlIIll.getAttribute("type");
            llllllllllllllllIlIIlIIIlIIllIIl.x = Integer.parseInt(llllllllllllllllIlIIlIIIlIIlIIll.getAttribute("x"));
            llllllllllllllllIlIIlIIIlIIllIIl.y = Integer.parseInt(llllllllllllllllIlIIlIIIlIIlIIll.getAttribute("y"));
            llllllllllllllllIlIIlIIIlIIllIIl.width = Integer.parseInt(llllllllllllllllIlIIlIIIlIIlIIll.getAttribute("width"));
            llllllllllllllllIlIIlIIIlIIllIIl.height = Integer.parseInt(llllllllllllllllIlIIlIIIlIIlIIll.getAttribute("height"));
            Element llllllllllllllllIlIIlIIIlIIlIlll = (Element)llllllllllllllllIlIIlIIIlIIlIIll.getElementsByTagName("image").item(0);
            if (llllllllllllllllIlIIlIIIlIIlIlll != null) {
                llllllllllllllllIlIIlIIIlIIllIIl.image = llllllllllllllllIlIIlIIIlIIlIlll.getAttribute("source");
            }
            if ((llllllllllllllllIlIIlIIIlIIlIllI = (Element)llllllllllllllllIlIIlIIIlIIlIIll.getElementsByTagName("properties").item(0)) != null && (llllllllllllllllIlIIlIIIlIIllIlI = llllllllllllllllIlIIlIIIlIIlIllI.getElementsByTagName("property")) != null) {
                llllllllllllllllIlIIlIIIlIIllIIl.props = new Properties();
                for (int llllllllllllllllIlIIlIIIlIIllIll = 0; llllllllllllllllIlIIlIIIlIIllIll < llllllllllllllllIlIIlIIIlIIllIlI.getLength(); ++llllllllllllllllIlIIlIIIlIIllIll) {
                    Element llllllllllllllllIlIIlIIIlIIllllI = (Element)llllllllllllllllIlIIlIIIlIIllIlI.item(llllllllllllllllIlIIlIIIlIIllIll);
                    String llllllllllllllllIlIIlIIIlIIlllIl = llllllllllllllllIlIIlIIIlIIllllI.getAttribute("name");
                    String llllllllllllllllIlIIlIIIlIIlllII = llllllllllllllllIlIIlIIIlIIllllI.getAttribute("value");
                    llllllllllllllllIlIIlIIIlIIllIIl.props.setProperty(llllllllllllllllIlIIlIIIlIIlllIl, llllllllllllllllIlIIlIIIlIIlllII);
                }
            }
        }
    }

    protected class ObjectGroup {
        public /* synthetic */ int width;
        public /* synthetic */ int height;
        public /* synthetic */ int index;
        public /* synthetic */ ArrayList objects;
        public /* synthetic */ Properties props;
        public /* synthetic */ String name;

        public ObjectGroup(Element llIllIIlIllIlII) throws SlickException {
            NodeList llIllIIlIlllllI;
            ObjectGroup llIllIIlIllIllI;
            llIllIIlIllIllI.name = llIllIIlIllIlII.getAttribute("name");
            llIllIIlIllIllI.width = Integer.parseInt(llIllIIlIllIlII.getAttribute("width"));
            llIllIIlIllIllI.height = Integer.parseInt(llIllIIlIllIlII.getAttribute("height"));
            llIllIIlIllIllI.objects = new ArrayList();
            Element llIllIIlIlllIII = (Element)llIllIIlIllIlII.getElementsByTagName("properties").item(0);
            if (llIllIIlIlllIII != null && (llIllIIlIlllllI = llIllIIlIlllIII.getElementsByTagName("property")) != null) {
                llIllIIlIllIllI.props = new Properties();
                for (int llIllIIlIllllll = 0; llIllIIlIllllll < llIllIIlIlllllI.getLength(); ++llIllIIlIllllll) {
                    Element llIllIIllIIIIlI = (Element)llIllIIlIlllllI.item(llIllIIlIllllll);
                    String llIllIIllIIIIIl = llIllIIllIIIIlI.getAttribute("name");
                    String llIllIIllIIIIII = llIllIIllIIIIlI.getAttribute("value");
                    llIllIIlIllIllI.props.setProperty(llIllIIllIIIIIl, llIllIIllIIIIII);
                }
            }
            NodeList llIllIIlIllIlll = llIllIIlIllIlII.getElementsByTagName("object");
            int llIllIIlIlllIll = 0;
            while (llIllIIlIlllIll < llIllIIlIllIlll.getLength()) {
                Element llIllIIlIllllIl = (Element)llIllIIlIllIlll.item(llIllIIlIlllIll);
                GroupObject llIllIIlIllllII = new GroupObject(llIllIIlIllllIl);
                llIllIIlIllllII.index = llIllIIlIlllIll++;
                llIllIIlIllIllI.objects.add(llIllIIlIllllII);
            }
        }
    }
}

