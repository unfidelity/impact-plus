/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.tiled;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.GZIPInputStream;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TileSet;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.Log;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Layer {
    public /* synthetic */ Properties props;
    private final /* synthetic */ TiledMap map;
    public /* synthetic */ int height;
    public /* synthetic */ int[][][] data;
    private static /* synthetic */ byte[] baseCodes;
    public /* synthetic */ int width;
    public /* synthetic */ int index;
    public /* synthetic */ String name;

    public void setTileID(int lIIIlIIIllllII, int lIIIlIIIlllIll, int lIIIlIIIllIllI) {
        if (lIIIlIIIllIllI == 0) {
            lIIIlIIIlllIIl.data[lIIIlIIIllllII][lIIIlIIIlllIll][0] = -1;
            lIIIlIIIlllIIl.data[lIIIlIIIllllII][lIIIlIIIlllIll][1] = 0;
            lIIIlIIIlllIIl.data[lIIIlIIIllllII][lIIIlIIIlllIll][2] = 0;
        } else {
            Layer lIIIlIIIlllIIl;
            TileSet lIIIlIIIlllllI = lIIIlIIIlllIIl.map.findTileSet(lIIIlIIIllIllI);
            lIIIlIIIlllIIl.data[lIIIlIIIllllII][lIIIlIIIlllIll][0] = lIIIlIIIlllllI.index;
            lIIIlIIIlllIIl.data[lIIIlIIIllllII][lIIIlIIIlllIll][1] = lIIIlIIIllIllI - lIIIlIIIlllllI.firstGID;
            lIIIlIIIlllIIl.data[lIIIlIIIllllII][lIIIlIIIlllIll][2] = lIIIlIIIllIllI;
        }
    }

    public void render(int lIIIlIIIIlllIl, int lIIIlIIIIlllII, int lIIIlIIIIllIll, int lIIIlIIIIlIIII, int lIIIlIIIIllIIl, int lIIIlIIIIIlllI, boolean lIIIlIIIIlIlll, int lIIIlIIIIlIllI, int lIIIlIIIIIlIll) {
        Layer lIIIlIIIIlIlII;
        for (int lIIIlIIIIlllll = 0; lIIIlIIIIlllll < lIIIlIIIIlIlII.map.getTileSetCount(); ++lIIIlIIIIlllll) {
            TileSet lIIIlIIIlIIIII = null;
            for (int lIIIlIIIlIIIIl = 0; lIIIlIIIlIIIIl < lIIIlIIIIllIIl; ++lIIIlIIIlIIIIl) {
                if (lIIIlIIIIllIll + lIIIlIIIlIIIIl < 0 || lIIIlIIIIlIIII + lIIIlIIIIIlllI < 0 || lIIIlIIIIllIll + lIIIlIIIlIIIIl >= lIIIlIIIIlIlII.width || lIIIlIIIIlIIII + lIIIlIIIIIlllI >= lIIIlIIIIlIlII.height || lIIIlIIIIlIlII.data[lIIIlIIIIllIll + lIIIlIIIlIIIIl][lIIIlIIIIlIIII + lIIIlIIIIIlllI][0] != lIIIlIIIIlllll) continue;
                if (lIIIlIIIlIIIII == null) {
                    lIIIlIIIlIIIII = lIIIlIIIIlIlII.map.getTileSet(lIIIlIIIIlllll);
                    lIIIlIIIlIIIII.tiles.startUse();
                }
                int lIIIlIIIlIIlII = lIIIlIIIlIIIII.getTileX(lIIIlIIIIlIlII.data[lIIIlIIIIllIll + lIIIlIIIlIIIIl][lIIIlIIIIlIIII + lIIIlIIIIIlllI][1]);
                int lIIIlIIIlIIIll = lIIIlIIIlIIIII.getTileY(lIIIlIIIIlIlII.data[lIIIlIIIIllIll + lIIIlIIIlIIIIl][lIIIlIIIIlIIII + lIIIlIIIIIlllI][1]);
                int lIIIlIIIlIIIlI = lIIIlIIIlIIIII.tileHeight - lIIIlIIIIIlIll;
                lIIIlIIIlIIIII.tiles.renderInUse(lIIIlIIIIlllIl + lIIIlIIIlIIIIl * lIIIlIIIIlIllI, lIIIlIIIIlllII + lIIIlIIIIIlllI * lIIIlIIIIIlIll - lIIIlIIIlIIIlI, lIIIlIIIlIIlII, lIIIlIIIlIIIll);
            }
            if (lIIIlIIIIlIlll) {
                if (lIIIlIIIlIIIII != null) {
                    lIIIlIIIlIIIII.tiles.endUse();
                    lIIIlIIIlIIIII = null;
                }
                lIIIlIIIIlIlII.map.renderedLine(lIIIlIIIIIlllI, lIIIlIIIIIlllI + lIIIlIIIIlIIII, lIIIlIIIIlIlII.index);
            }
            if (lIIIlIIIlIIIII == null) continue;
            lIIIlIIIlIIIII.tiles.endUse();
        }
    }

    private byte[] decodeBase64(char[] lIIIIlllllIIII) {
        int lIIIIlllllIllI = lIIIIlllllIIII.length;
        for (int lIIIIllllllIll = 0; lIIIIllllllIll < lIIIIlllllIIII.length; ++lIIIIllllllIll) {
            if (lIIIIlllllIIII[lIIIIllllllIll] <= '\u00ff' && baseCodes[lIIIIlllllIIII[lIIIIllllllIll]] >= 0) continue;
            --lIIIIlllllIllI;
        }
        int lIIIIlllllIlIl = lIIIIlllllIllI / 4 * 3;
        if (lIIIIlllllIllI % 4 == 3) {
            lIIIIlllllIlIl += 2;
        }
        if (lIIIIlllllIllI % 4 == 2) {
            ++lIIIIlllllIlIl;
        }
        byte[] lIIIIlllllIlII = new byte[lIIIIlllllIlIl];
        int lIIIIlllllIIll = 0;
        int lIIIIlllllIIlI = 0;
        int lIIIIlllllIIIl = 0;
        for (int lIIIIllllllIIl = 0; lIIIIllllllIIl < lIIIIlllllIIII.length; ++lIIIIllllllIIl) {
            int lIIIIllllllIlI;
            int n = lIIIIllllllIlI = lIIIIlllllIIII[lIIIIllllllIIl] > '\u00ff' ? -1 : baseCodes[lIIIIlllllIIII[lIIIIllllllIIl]];
            if (lIIIIllllllIlI < 0) continue;
            lIIIIlllllIIlI <<= 6;
            lIIIIlllllIIlI |= lIIIIllllllIlI;
            if ((lIIIIlllllIIll += 6) < 8) continue;
            lIIIIlllllIlII[lIIIIlllllIIIl++] = (byte)(lIIIIlllllIIlI >> (lIIIIlllllIIll -= 8) & 0xFF);
        }
        if (lIIIIlllllIIIl != lIIIIlllllIlII.length) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("Data length appears to be wrong (wrote ").append(lIIIIlllllIIIl).append(" should be ").append(lIIIIlllllIlII.length).append(")")));
        }
        return lIIIIlllllIlII;
    }

    public int getTileID(int lIIIlIIlIIlIII, int lIIIlIIlIIIlII) {
        Layer lIIIlIIlIIIllI;
        return lIIIlIIlIIIllI.data[lIIIlIIlIIlIII][lIIIlIIlIIIlII][2];
    }

    static {
        baseCodes = new byte[256];
        for (int lIIIIllllIIllI = 0; lIIIIllllIIllI < 256; ++lIIIIllllIIllI) {
            Layer.baseCodes[lIIIIllllIIllI] = -1;
        }
        for (int lIIIIllllIIlIl = 65; lIIIIllllIIlIl <= 90; ++lIIIIllllIIlIl) {
            Layer.baseCodes[lIIIIllllIIlIl] = (byte)(lIIIIllllIIlIl - 65);
        }
        for (int lIIIIllllIIlII = 97; lIIIIllllIIlII <= 122; ++lIIIIllllIIlII) {
            Layer.baseCodes[lIIIIllllIIlII] = (byte)(26 + lIIIIllllIIlII - 97);
        }
        for (int lIIIIllllIIIll = 48; lIIIIllllIIIll <= 57; ++lIIIIllllIIIll) {
            Layer.baseCodes[lIIIIllllIIIll] = (byte)(52 + lIIIIllllIIIll - 48);
        }
        Layer.baseCodes[43] = 62;
        Layer.baseCodes[47] = 63;
    }

    public Layer(TiledMap lIIIlIIllIIIIl, Element lIIIlIIlIllIIl) throws SlickException {
        NodeList lIIIlIIllIllII;
        Layer lIIIlIIllIIIlI;
        lIIIlIIllIIIlI.map = lIIIlIIllIIIIl;
        lIIIlIIllIIIlI.name = lIIIlIIlIllIIl.getAttribute("name");
        lIIIlIIllIIIlI.width = Integer.parseInt(lIIIlIIlIllIIl.getAttribute("width"));
        lIIIlIIllIIIlI.height = Integer.parseInt(lIIIlIIlIllIIl.getAttribute("height"));
        lIIIlIIllIIIlI.data = new int[lIIIlIIllIIIlI.width][lIIIlIIllIIIlI.height][3];
        Element lIIIlIIlIlllll = (Element)lIIIlIIlIllIIl.getElementsByTagName("properties").item(0);
        if (lIIIlIIlIlllll != null && (lIIIlIIllIllII = lIIIlIIlIlllll.getElementsByTagName("property")) != null) {
            lIIIlIIllIIIlI.props = new Properties();
            for (int lIIIlIIllIllIl = 0; lIIIlIIllIllIl < lIIIlIIllIllII.getLength(); ++lIIIlIIllIllIl) {
                Element lIIIlIIlllIIII = (Element)lIIIlIIllIllII.item(lIIIlIIllIllIl);
                String lIIIlIIllIllll = lIIIlIIlllIIII.getAttribute("name");
                String lIIIlIIllIlllI = lIIIlIIlllIIII.getAttribute("value");
                lIIIlIIllIIIlI.props.setProperty(lIIIlIIllIllll, lIIIlIIllIlllI);
            }
        }
        Element lIIIlIIlIllllI = (Element)lIIIlIIlIllIIl.getElementsByTagName("data").item(0);
        String lIIIlIIlIlllIl = lIIIlIIlIllllI.getAttribute("encoding");
        String lIIIlIIlIlllII = lIIIlIIlIllllI.getAttribute("compression");
        if (lIIIlIIlIlllIl.equals("base64") && lIIIlIIlIlllII.equals("gzip")) {
            try {
                Node lIIIlIIllIIlll = lIIIlIIlIllllI.getFirstChild();
                char[] lIIIlIIllIIllI = lIIIlIIllIIlll.getNodeValue().trim().toCharArray();
                byte[] lIIIlIIllIIlIl = lIIIlIIllIIIlI.decodeBase64(lIIIlIIllIIllI);
                GZIPInputStream lIIIlIIllIIlII = new GZIPInputStream(new ByteArrayInputStream(lIIIlIIllIIlIl));
                for (int lIIIlIIllIlIII = 0; lIIIlIIllIlIII < lIIIlIIllIIIlI.height; ++lIIIlIIllIlIII) {
                    for (int lIIIlIIllIlIIl = 0; lIIIlIIllIlIIl < lIIIlIIllIIIlI.width; ++lIIIlIIllIlIIl) {
                        int lIIIlIIllIlIlI = 0;
                        lIIIlIIllIlIlI |= lIIIlIIllIIlII.read();
                        lIIIlIIllIlIlI |= lIIIlIIllIIlII.read() << 8;
                        lIIIlIIllIlIlI |= lIIIlIIllIIlII.read() << 16;
                        if ((lIIIlIIllIlIlI |= lIIIlIIllIIlII.read() << 24) == 0) {
                            lIIIlIIllIIIlI.data[lIIIlIIllIlIIl][lIIIlIIllIlIII][0] = -1;
                            lIIIlIIllIIIlI.data[lIIIlIIllIlIIl][lIIIlIIllIlIII][1] = 0;
                            lIIIlIIllIIIlI.data[lIIIlIIllIlIIl][lIIIlIIllIlIII][2] = 0;
                            continue;
                        }
                        TileSet lIIIlIIllIlIll = lIIIlIIllIIIIl.findTileSet(lIIIlIIllIlIlI);
                        if (lIIIlIIllIlIll != null) {
                            lIIIlIIllIIIlI.data[lIIIlIIllIlIIl][lIIIlIIllIlIII][0] = lIIIlIIllIlIll.index;
                            lIIIlIIllIIIlI.data[lIIIlIIllIlIIl][lIIIlIIllIlIII][1] = lIIIlIIllIlIlI - lIIIlIIllIlIll.firstGID;
                        }
                        lIIIlIIllIIIlI.data[lIIIlIIllIlIIl][lIIIlIIllIlIII][2] = lIIIlIIllIlIlI;
                    }
                }
            }
            catch (IOException lIIIlIIllIIIll) {
                Log.error(lIIIlIIllIIIll);
                throw new SlickException("Unable to decode base 64 block");
            }
        } else {
            throw new SlickException(String.valueOf(new StringBuilder().append("Unsupport tiled map type: ").append(lIIIlIIlIlllIl).append(",").append(lIIIlIIlIlllII).append(" (only gzip base64 supported)")));
        }
    }
}

