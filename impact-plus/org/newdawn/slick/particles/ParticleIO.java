/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.particles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ConfigurableEmitterFactory;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ParticleIO {
    public static ConfigurableEmitter loadEmitter(String lllllllllllllllllIIIIlIIlIIIlIlI) throws IOException {
        return ParticleIO.loadEmitter(ResourceLoader.getResourceAsStream(lllllllllllllllllIIIIlIIlIIIlIlI), null);
    }

    public static ParticleSystem loadConfiguredSystem(InputStream lllllllllllllllllIIIIlIIllIIIIlI, ConfigurableEmitterFactory lllllllllllllllllIIIIlIIllIIIIIl, ParticleSystem lllllllllllllllllIIIIlIIllIIIIII, Color lllllllllllllllllIIIIlIIlIlllIll) throws IOException {
        if (lllllllllllllllllIIIIlIIllIIIIIl == null) {
            lllllllllllllllllIIIIlIIllIIIIIl = new ConfigurableEmitterFactory(){
                {
                    1 lllllllllllIIll;
                }

                @Override
                public ConfigurableEmitter createEmitter(String llllllllllIllll) {
                    return new ConfigurableEmitter(llllllllllIllll);
                }
            };
        }
        try {
            boolean lllllllllllllllllIIIIlIIllIIIlll;
            DocumentBuilder lllllllllllllllllIIIIlIIllIIlIlI = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document lllllllllllllllllIIIIlIIllIIlIIl = lllllllllllllllllIIIIlIIllIIlIlI.parse(lllllllllllllllllIIIIlIIllIIIIlI);
            Element lllllllllllllllllIIIIlIIllIIlIII = lllllllllllllllllIIIIlIIllIIlIIl.getDocumentElement();
            if (!lllllllllllllllllIIIIlIIllIIlIII.getNodeName().equals("system")) {
                throw new IOException("Not a particle system file");
            }
            if (lllllllllllllllllIIIIlIIllIIIIII == null) {
                lllllllllllllllllIIIIlIIllIIIIII = new ParticleSystem("org/newdawn/slick/data/particle.tga", 2000, lllllllllllllllllIIIIlIIlIlllIll);
            }
            if (lllllllllllllllllIIIIlIIllIIIlll = "true".equals(lllllllllllllllllIIIIlIIllIIlIII.getAttribute("additive"))) {
                lllllllllllllllllIIIIlIIllIIIIII.setBlendingMode(1);
            } else {
                lllllllllllllllllIIIIlIIllIIIIII.setBlendingMode(2);
            }
            boolean lllllllllllllllllIIIIlIIllIIIllI = "true".equals(lllllllllllllllllIIIIlIIllIIlIII.getAttribute("points"));
            lllllllllllllllllIIIIlIIllIIIIII.setUsePoints(lllllllllllllllllIIIIlIIllIIIllI);
            NodeList lllllllllllllllllIIIIlIIllIIIlIl = lllllllllllllllllIIIIlIIllIIlIII.getElementsByTagName("emitter");
            for (int lllllllllllllllllIIIIlIIllIIlIll = 0; lllllllllllllllllIIIIlIIllIIlIll < lllllllllllllllllIIIIlIIllIIIlIl.getLength(); ++lllllllllllllllllIIIIlIIllIIlIll) {
                Element lllllllllllllllllIIIIlIIllIIllIl = (Element)lllllllllllllllllIIIIlIIllIIIlIl.item(lllllllllllllllllIIIIlIIllIIlIll);
                ConfigurableEmitter lllllllllllllllllIIIIlIIllIIllII = lllllllllllllllllIIIIlIIllIIIIIl.createEmitter("new");
                ParticleIO.elementToEmitter(lllllllllllllllllIIIIlIIllIIllIl, lllllllllllllllllIIIIlIIllIIllII);
                lllllllllllllllllIIIIlIIllIIIIII.addEmitter(lllllllllllllllllIIIIlIIllIIllII);
            }
            lllllllllllllllllIIIIlIIllIIIIII.setRemoveCompletedEmitters(false);
            return lllllllllllllllllIIIIlIIllIIIIII;
        }
        catch (IOException lllllllllllllllllIIIIlIIllIIIlII) {
            Log.error(lllllllllllllllllIIIIlIIllIIIlII);
            throw lllllllllllllllllIIIIlIIllIIIlII;
        }
        catch (Exception lllllllllllllllllIIIIlIIllIIIIll) {
            Log.error(lllllllllllllllllIIIIlIIllIIIIll);
            throw new IOException("Unable to load particle system config");
        }
    }

    private static Element getFirstNamedElement(Element lllllllllllllllllIIIIlIIIIlIIIII, String lllllllllllllllllIIIIlIIIIlIlIIl) {
        NodeList lllllllllllllllllIIIIlIIIIlIIIll = lllllllllllllllllIIIIlIIIIlIIIII.getElementsByTagName(lllllllllllllllllIIIIlIIIIlIlIIl);
        if (lllllllllllllllllIIIIlIIIIlIIIll.getLength() == 0) {
            return null;
        }
        return (Element)lllllllllllllllllIIIIlIIIIlIIIll.item(0);
    }

    public static void saveEmitter(File lllllllllllllllllIIIIlIIIllIIIIl, ConfigurableEmitter lllllllllllllllllIIIIlIIIllIIIII) throws IOException {
        ParticleIO.saveEmitter(new FileOutputStream(lllllllllllllllllIIIIlIIIllIIIIl), lllllllllllllllllIIIIlIIIllIIIII);
    }

    public static ParticleSystem loadConfiguredSystem(String lllllllllllllllllIIIIlIIllllllIl, Color lllllllllllllllllIIIIlIIllllllII) throws IOException {
        return ParticleIO.loadConfiguredSystem(ResourceLoader.getResourceAsStream(lllllllllllllllllIIIIlIIllllllIl), null, null, lllllllllllllllllIIIIlIIllllllII);
    }

    public static ParticleSystem loadConfiguredSystem(InputStream lllllllllllllllllIIIIlIIllIlllII, ConfigurableEmitterFactory lllllllllllllllllIIIIlIIllIllIll) throws IOException {
        return ParticleIO.loadConfiguredSystem(lllllllllllllllllIIIIlIIllIlllII, lllllllllllllllllIIIIlIIllIllIll, null, null);
    }

    private static void parseRangeElement(Element lllllllllllllllllIIIIIlIllIllIlI, ConfigurableEmitter.Range lllllllllllllllllIIIIIlIllIlIlll) {
        if (lllllllllllllllllIIIIIlIllIllIlI == null) {
            return;
        }
        lllllllllllllllllIIIIIlIllIlIlll.setMin(Float.parseFloat(lllllllllllllllllIIIIIlIllIllIlI.getAttribute("min")));
        lllllllllllllllllIIIIIlIllIlIlll.setMax(Float.parseFloat(lllllllllllllllllIIIIIlIllIllIlI.getAttribute("max")));
        lllllllllllllllllIIIIIlIllIlIlll.setEnabled("true".equals(lllllllllllllllllIIIIIlIllIllIlI.getAttribute("enabled")));
    }

    public static ConfigurableEmitter loadEmitter(InputStream lllllllllllllllllIIIIlIIIllIlIlI, ConfigurableEmitterFactory lllllllllllllllllIIIIlIIIllIIlll) throws IOException {
        if (lllllllllllllllllIIIIlIIIllIIlll == null) {
            lllllllllllllllllIIIIlIIIllIIlll = new ConfigurableEmitterFactory(){
                {
                    2 lIIlIIllI;
                }

                @Override
                public ConfigurableEmitter createEmitter(String lIIlIIIII) {
                    return new ConfigurableEmitter(lIIlIIIII);
                }
            };
        }
        try {
            DocumentBuilder lllllllllllllllllIIIIlIIIllIllll = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document lllllllllllllllllIIIIlIIIllIlllI = lllllllllllllllllIIIIlIIIllIllll.parse(lllllllllllllllllIIIIlIIIllIlIlI);
            if (!lllllllllllllllllIIIIlIIIllIlllI.getDocumentElement().getNodeName().equals("emitter")) {
                throw new IOException("Not a particle emitter file");
            }
            ConfigurableEmitter lllllllllllllllllIIIIlIIIllIllIl = lllllllllllllllllIIIIlIIIllIIlll.createEmitter("new");
            ParticleIO.elementToEmitter(lllllllllllllllllIIIIlIIIllIlllI.getDocumentElement(), lllllllllllllllllIIIIlIIIllIllIl);
            return lllllllllllllllllIIIIlIIIllIllIl;
        }
        catch (IOException lllllllllllllllllIIIIlIIIllIllII) {
            Log.error(lllllllllllllllllIIIIlIIIllIllII);
            throw lllllllllllllllllIIIIlIIIllIllII;
        }
        catch (Exception lllllllllllllllllIIIIlIIIllIlIll) {
            Log.error(lllllllllllllllllIIIIlIIIllIlIll);
            throw new IOException("Unable to load emitter");
        }
    }

    public static ParticleSystem loadConfiguredSystem(InputStream lllllllllllllllllIIIIlIIllllIIIl, Color lllllllllllllllllIIIIlIIllllIIII) throws IOException {
        return ParticleIO.loadConfiguredSystem(lllllllllllllllllIIIIlIIllllIIIl, null, null, lllllllllllllllllIIIIlIIllllIIII);
    }

    public static ConfigurableEmitter loadEmitter(String lllllllllllllllllIIIIlIIlIIIIIIl, ConfigurableEmitterFactory lllllllllllllllllIIIIlIIlIIIIIII) throws IOException {
        return ParticleIO.loadEmitter(ResourceLoader.getResourceAsStream(lllllllllllllllllIIIIlIIlIIIIIIl), lllllllllllllllllIIIIlIIlIIIIIII);
    }

    public static void saveConfiguredSystem(OutputStream lllllllllllllllllIIIIlIIlIIlIlll, ParticleSystem lllllllllllllllllIIIIlIIlIIlIlII) throws IOException {
        try {
            DocumentBuilder lllllllllllllllllIIIIlIIlIIlllll = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document lllllllllllllllllIIIIlIIlIIllllI = lllllllllllllllllIIIIlIIlIIlllll.newDocument();
            Element lllllllllllllllllIIIIlIIlIIlllIl = lllllllllllllllllIIIIlIIlIIllllI.createElement("system");
            lllllllllllllllllIIIIlIIlIIlllIl.setAttribute("additive", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIlIIlIIlIlII.getBlendingMode() == 1)));
            lllllllllllllllllIIIIlIIlIIlllIl.setAttribute("points", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIlIIlIIlIlII.usePoints())));
            lllllllllllllllllIIIIlIIlIIllllI.appendChild(lllllllllllllllllIIIIlIIlIIlllIl);
            for (int lllllllllllllllllIIIIlIIlIlIIIII = 0; lllllllllllllllllIIIIlIIlIlIIIII < lllllllllllllllllIIIIlIIlIIlIlII.getEmitterCount(); ++lllllllllllllllllIIIIlIIlIlIIIII) {
                ParticleEmitter lllllllllllllllllIIIIlIIlIlIIIIl = lllllllllllllllllIIIIlIIlIIlIlII.getEmitter(lllllllllllllllllIIIIlIIlIlIIIII);
                if (!(lllllllllllllllllIIIIlIIlIlIIIIl instanceof ConfigurableEmitter)) {
                    throw new RuntimeException("Only ConfigurableEmitter instances can be stored");
                }
                Element lllllllllllllllllIIIIlIIlIlIIIlI = ParticleIO.emitterToElement(lllllllllllllllllIIIIlIIlIIllllI, (ConfigurableEmitter)lllllllllllllllllIIIIlIIlIlIIIIl);
                lllllllllllllllllIIIIlIIlIIlllIl.appendChild(lllllllllllllllllIIIIlIIlIlIIIlI);
            }
            StreamResult lllllllllllllllllIIIIlIIlIIlllII = new StreamResult(new OutputStreamWriter(lllllllllllllllllIIIIlIIlIIlIlll, "utf-8"));
            DOMSource lllllllllllllllllIIIIlIIlIIllIll = new DOMSource(lllllllllllllllllIIIIlIIlIIllllI);
            TransformerFactory lllllllllllllllllIIIIlIIlIIllIlI = TransformerFactory.newInstance();
            Transformer lllllllllllllllllIIIIlIIlIIllIIl = lllllllllllllllllIIIIlIIlIIllIlI.newTransformer();
            lllllllllllllllllIIIIlIIlIIllIIl.setOutputProperty("indent", "yes");
            lllllllllllllllllIIIIlIIlIIllIIl.transform(lllllllllllllllllIIIIlIIlIIllIll, lllllllllllllllllIIIIlIIlIIlllII);
        }
        catch (Exception lllllllllllllllllIIIIlIIlIIllIII) {
            Log.error(lllllllllllllllllIIIIlIIlIIllIII);
            throw new IOException("Unable to save configured particle system");
        }
    }

    public static ParticleSystem loadConfiguredSystem(File lllllllllllllllllIIIIlIIllllIlll) throws IOException {
        return ParticleIO.loadConfiguredSystem(new FileInputStream(lllllllllllllllllIIIIlIIllllIlll), null, null, null);
    }

    public static ParticleSystem loadConfiguredSystem(String lllllllllllllllllIIIIlIIlllllIIl) throws IOException {
        return ParticleIO.loadConfiguredSystem(ResourceLoader.getResourceAsStream(lllllllllllllllllIIIIlIIlllllIIl), null, null, null);
    }

    private static Element createRangeElement(Document lllllllllllllllllIIIIIlIllllllII, String lllllllllllllllllIIIIIlIllllIlll, ConfigurableEmitter.Range lllllllllllllllllIIIIIlIllllIllI) {
        Element lllllllllllllllllIIIIIlIlllllIIl = lllllllllllllllllIIIIIlIllllllII.createElement(lllllllllllllllllIIIIIlIllllIlll);
        lllllllllllllllllIIIIIlIlllllIIl.setAttribute("min", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIlIllllIllI.getMin())));
        lllllllllllllllllIIIIIlIlllllIIl.setAttribute("max", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIlIllllIllI.getMax())));
        lllllllllllllllllIIIIIlIlllllIIl.setAttribute("enabled", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIlIllllIllI.isEnabled())));
        return lllllllllllllllllIIIIIlIlllllIIl;
    }

    public ParticleIO() {
        ParticleIO lllllllllllllllllIIIIlIlIIIIIIll;
    }

    public static void saveConfiguredSystem(File lllllllllllllllllIIIIlIIlIlIllIl, ParticleSystem lllllllllllllllllIIIIlIIlIlIlllI) throws IOException {
        ParticleIO.saveConfiguredSystem(new FileOutputStream(lllllllllllllllllIIIIlIIlIlIllIl), lllllllllllllllllIIIIlIIlIlIlllI);
    }

    public static ConfigurableEmitter loadEmitter(File lllllllllllllllllIIIIlIIlIIIIlll) throws IOException {
        return ParticleIO.loadEmitter(new FileInputStream(lllllllllllllllllIIIIlIIlIIIIlll), null);
    }

    public static ConfigurableEmitter loadEmitter(File lllllllllllllllllIIIIlIIIllllIIl, ConfigurableEmitterFactory lllllllllllllllllIIIIlIIIllllIlI) throws IOException {
        return ParticleIO.loadEmitter(new FileInputStream(lllllllllllllllllIIIIlIIIllllIIl), lllllllllllllllllIIIIlIIIllllIlI);
    }

    private static void elementToEmitter(Element lllllllllllllllllIIIIIlllIlIIIIl, ConfigurableEmitter lllllllllllllllllIIIIIlllIllIIII) {
        String lllllllllllllllllIIIIIlllIlIlIll;
        String lllllllllllllllllIIIIIlllIlIllII;
        lllllllllllllllllIIIIIlllIllIIII.name = lllllllllllllllllIIIIIlllIlIIIIl.getAttribute("name");
        lllllllllllllllllIIIIIlllIllIIII.setImageName(lllllllllllllllllIIIIIlllIlIIIIl.getAttribute("imageName"));
        String lllllllllllllllllIIIIIlllIlIlllI = lllllllllllllllllIIIIIlllIlIIIIl.getAttribute("renderType");
        lllllllllllllllllIIIIIlllIllIIII.usePoints = 1;
        if (lllllllllllllllllIIIIIlllIlIlllI.equals("quads")) {
            lllllllllllllllllIIIIIlllIllIIII.usePoints = 3;
        }
        if (lllllllllllllllllIIIIIlllIlIlllI.equals("points")) {
            lllllllllllllllllIIIIIlllIllIIII.usePoints = 2;
        }
        if ((lllllllllllllllllIIIIIlllIlIllII = lllllllllllllllllIIIIIlllIlIIIIl.getAttribute("useOriented")) != null) {
            lllllllllllllllllIIIIIlllIllIIII.useOriented = "true".equals(lllllllllllllllllIIIIIlllIlIllII);
        }
        if ((lllllllllllllllllIIIIIlllIlIlIll = lllllllllllllllllIIIIIlllIlIIIIl.getAttribute("useAdditive")) != null) {
            lllllllllllllllllIIIIIlllIllIIII.useAdditive = "true".equals(lllllllllllllllllIIIIIlllIlIlIll);
        }
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "spawnInterval"), lllllllllllllllllIIIIIlllIllIIII.spawnInterval);
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "spawnCount"), lllllllllllllllllIIIIIlllIllIIII.spawnCount);
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "initialLife"), lllllllllllllllllIIIIIlllIllIIII.initialLife);
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "initialSize"), lllllllllllllllllIIIIIlllIllIIII.initialSize);
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "xOffset"), lllllllllllllllllIIIIIlllIllIIII.xOffset);
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "yOffset"), lllllllllllllllllIIIIIlllIllIIII.yOffset);
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "initialDistance"), lllllllllllllllllIIIIIlllIllIIII.initialDistance);
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "speed"), lllllllllllllllllIIIIIlllIllIIII.speed);
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "length"), lllllllllllllllllIIIIIlllIllIIII.length);
        ParticleIO.parseRangeElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "emitCount"), lllllllllllllllllIIIIIlllIllIIII.emitCount);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "spread"), lllllllllllllllllIIIIIlllIllIIII.spread);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "angularOffset"), lllllllllllllllllIIIIIlllIllIIII.angularOffset);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "growthFactor"), lllllllllllllllllIIIIIlllIllIIII.growthFactor);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "gravityFactor"), lllllllllllllllllIIIIIlllIllIIII.gravityFactor);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "windFactor"), lllllllllllllllllIIIIIlllIllIIII.windFactor);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "startAlpha"), lllllllllllllllllIIIIIlllIllIIII.startAlpha);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "endAlpha"), lllllllllllllllllIIIIIlllIllIIII.endAlpha);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "alpha"), lllllllllllllllllIIIIIlllIllIIII.alpha);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "size"), lllllllllllllllllIIIIIlllIllIIII.size);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "velocity"), lllllllllllllllllIIIIIlllIllIIII.velocity);
        ParticleIO.parseValueElement(ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "scaleY"), lllllllllllllllllIIIIIlllIllIIII.scaleY);
        Element lllllllllllllllllIIIIIlllIlIIllI = ParticleIO.getFirstNamedElement(lllllllllllllllllIIIIIlllIlIIIIl, "color");
        NodeList lllllllllllllllllIIIIIlllIlIIlII = lllllllllllllllllIIIIIlllIlIIllI.getElementsByTagName("step");
        lllllllllllllllllIIIIIlllIllIIII.colors.clear();
        for (int lllllllllllllllllIIIIIlllIllIlIl = 0; lllllllllllllllllIIIIIlllIllIlIl < lllllllllllllllllIIIIIlllIlIIlII.getLength(); ++lllllllllllllllllIIIIIlllIllIlIl) {
            Element lllllllllllllllllIIIIIllllIIIIlI = (Element)lllllllllllllllllIIIIIlllIlIIlII.item(lllllllllllllllllIIIIIlllIllIlIl);
            float lllllllllllllllllIIIIIllllIIIIII = Float.parseFloat(lllllllllllllllllIIIIIllllIIIIlI.getAttribute("offset"));
            float lllllllllllllllllIIIIIlllIlllllI = Float.parseFloat(lllllllllllllllllIIIIIllllIIIIlI.getAttribute("r"));
            float lllllllllllllllllIIIIIlllIlllIll = Float.parseFloat(lllllllllllllllllIIIIIllllIIIIlI.getAttribute("g"));
            float lllllllllllllllllIIIIIlllIlllIII = Float.parseFloat(lllllllllllllllllIIIIIllllIIIIlI.getAttribute("b"));
            lllllllllllllllllIIIIIlllIllIIII.addColorPoint(lllllllllllllllllIIIIIllllIIIIII, new Color(lllllllllllllllllIIIIIlllIlllllI, lllllllllllllllllIIIIIlllIlllIll, lllllllllllllllllIIIIIlllIlllIII, 1.0f));
        }
        lllllllllllllllllIIIIIlllIllIIII.replay();
    }

    public static ParticleSystem loadConfiguredSystem(File lllllllllllllllllIIIIlIIlllIIlII, ConfigurableEmitterFactory lllllllllllllllllIIIIlIIlllIIIIl) throws IOException {
        return ParticleIO.loadConfiguredSystem(new FileInputStream(lllllllllllllllllIIIIlIIlllIIlII), lllllllllllllllllIIIIlIIlllIIIIl, null, null);
    }

    public static ConfigurableEmitter loadEmitter(InputStream lllllllllllllllllIIIIlIIlIIIIlII) throws IOException {
        return ParticleIO.loadEmitter(lllllllllllllllllIIIIlIIlIIIIlII, null);
    }

    private static void parseValueElement(Element lllllllllllllllllIIIIIlIllIIIIII, ConfigurableEmitter.Value lllllllllllllllllIIIIIlIlIllllll) {
        if (lllllllllllllllllIIIIIlIllIIIIII == null) {
            return;
        }
        String lllllllllllllllllIIIIIlIlIlllllI = lllllllllllllllllIIIIIlIllIIIIII.getAttribute("type");
        String lllllllllllllllllIIIIIlIlIllllIl = lllllllllllllllllIIIIIlIllIIIIII.getAttribute("value");
        if (lllllllllllllllllIIIIIlIlIlllllI == null || lllllllllllllllllIIIIIlIlIlllllI.length() == 0) {
            if (lllllllllllllllllIIIIIlIlIllllll instanceof ConfigurableEmitter.SimpleValue) {
                ((ConfigurableEmitter.SimpleValue)lllllllllllllllllIIIIIlIlIllllll).setValue(Float.parseFloat(lllllllllllllllllIIIIIlIlIllllIl));
            } else if (lllllllllllllllllIIIIIlIlIllllll instanceof ConfigurableEmitter.RandomValue) {
                ((ConfigurableEmitter.RandomValue)lllllllllllllllllIIIIIlIlIllllll).setValue(Float.parseFloat(lllllllllllllllllIIIIIlIlIllllIl));
            } else {
                Log.warn(String.valueOf(new StringBuilder().append("problems reading element, skipping: ").append(lllllllllllllllllIIIIIlIllIIIIII)));
            }
        } else if (lllllllllllllllllIIIIIlIlIlllllI.equals("simple")) {
            ((ConfigurableEmitter.SimpleValue)lllllllllllllllllIIIIIlIlIllllll).setValue(Float.parseFloat(lllllllllllllllllIIIIIlIlIllllIl));
        } else if (lllllllllllllllllIIIIIlIlIlllllI.equals("random")) {
            ((ConfigurableEmitter.RandomValue)lllllllllllllllllIIIIIlIlIllllll).setValue(Float.parseFloat(lllllllllllllllllIIIIIlIlIllllIl));
        } else if (lllllllllllllllllIIIIIlIlIlllllI.equals("linear")) {
            String lllllllllllllllllIIIIIlIllIIIlIl = lllllllllllllllllIIIIIlIllIIIIII.getAttribute("min");
            String lllllllllllllllllIIIIIlIllIIIlII = lllllllllllllllllIIIIIlIllIIIIII.getAttribute("max");
            String lllllllllllllllllIIIIIlIllIIIIll = lllllllllllllllllIIIIIlIllIIIIII.getAttribute("active");
            NodeList lllllllllllllllllIIIIIlIllIIIIlI = lllllllllllllllllIIIIIlIllIIIIII.getElementsByTagName("point");
            ArrayList<Vector2f> lllllllllllllllllIIIIIlIllIIIIIl = new ArrayList<Vector2f>();
            for (int lllllllllllllllllIIIIIlIllIIIllI = 0; lllllllllllllllllIIIIIlIllIIIllI < lllllllllllllllllIIIIIlIllIIIIlI.getLength(); ++lllllllllllllllllIIIIIlIllIIIllI) {
                Element lllllllllllllllllIIIIIlIllIIlIIl = (Element)lllllllllllllllllIIIIIlIllIIIIlI.item(lllllllllllllllllIIIIIlIllIIIllI);
                float lllllllllllllllllIIIIIlIllIIlIII = Float.parseFloat(lllllllllllllllllIIIIIlIllIIlIIl.getAttribute("x"));
                float lllllllllllllllllIIIIIlIllIIIlll = Float.parseFloat(lllllllllllllllllIIIIIlIllIIlIIl.getAttribute("y"));
                lllllllllllllllllIIIIIlIllIIIIIl.add(new Vector2f(lllllllllllllllllIIIIIlIllIIlIII, lllllllllllllllllIIIIIlIllIIIlll));
            }
            ((ConfigurableEmitter.LinearInterpolator)lllllllllllllllllIIIIIlIlIllllll).setCurve(lllllllllllllllllIIIIIlIllIIIIIl);
            ((ConfigurableEmitter.LinearInterpolator)lllllllllllllllllIIIIIlIlIllllll).setMin(Integer.parseInt(lllllllllllllllllIIIIIlIllIIIlIl));
            ((ConfigurableEmitter.LinearInterpolator)lllllllllllllllllIIIIIlIlIllllll).setMax(Integer.parseInt(lllllllllllllllllIIIIIlIllIIIlII));
            ((ConfigurableEmitter.LinearInterpolator)lllllllllllllllllIIIIIlIlIllllll).setActive("true".equals(lllllllllllllllllIIIIIlIllIIIIll));
        } else {
            Log.warn(String.valueOf(new StringBuilder().append("unkown type detected: ").append(lllllllllllllllllIIIIIlIlIlllllI)));
        }
    }

    private static Element createValueElement(Document lllllllllllllllllIIIIIlIlllIIlII, String lllllllllllllllllIIIIIlIlllIIIll, ConfigurableEmitter.Value lllllllllllllllllIIIIIlIlllIIIlI) {
        Element lllllllllllllllllIIIIIlIlllIIlIl = lllllllllllllllllIIIIIlIlllIIlII.createElement(lllllllllllllllllIIIIIlIlllIIIll);
        if (lllllllllllllllllIIIIIlIlllIIIlI instanceof ConfigurableEmitter.SimpleValue) {
            lllllllllllllllllIIIIIlIlllIIlIl.setAttribute("type", "simple");
            lllllllllllllllllIIIIIlIlllIIlIl.setAttribute("value", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIlIlllIIIlI.getValue(0.0f))));
        } else if (lllllllllllllllllIIIIIlIlllIIIlI instanceof ConfigurableEmitter.RandomValue) {
            lllllllllllllllllIIIIIlIlllIIlIl.setAttribute("type", "random");
            lllllllllllllllllIIIIIlIlllIIlIl.setAttribute("value", String.valueOf(new StringBuilder().append("").append(((ConfigurableEmitter.RandomValue)lllllllllllllllllIIIIIlIlllIIIlI).getValue())));
        } else if (lllllllllllllllllIIIIIlIlllIIIlI instanceof ConfigurableEmitter.LinearInterpolator) {
            lllllllllllllllllIIIIIlIlllIIlIl.setAttribute("type", "linear");
            lllllllllllllllllIIIIIlIlllIIlIl.setAttribute("min", String.valueOf(new StringBuilder().append("").append(((ConfigurableEmitter.LinearInterpolator)lllllllllllllllllIIIIIlIlllIIIlI).getMin())));
            lllllllllllllllllIIIIIlIlllIIlIl.setAttribute("max", String.valueOf(new StringBuilder().append("").append(((ConfigurableEmitter.LinearInterpolator)lllllllllllllllllIIIIIlIlllIIIlI).getMax())));
            lllllllllllllllllIIIIIlIlllIIlIl.setAttribute("active", String.valueOf(new StringBuilder().append("").append(((ConfigurableEmitter.LinearInterpolator)lllllllllllllllllIIIIIlIlllIIIlI).isActive())));
            ArrayList lllllllllllllllllIIIIIlIlllIlIIl = ((ConfigurableEmitter.LinearInterpolator)lllllllllllllllllIIIIIlIlllIIIlI).getCurve();
            for (int lllllllllllllllllIIIIIlIlllIlIlI = 0; lllllllllllllllllIIIIIlIlllIlIlI < lllllllllllllllllIIIIIlIlllIlIIl.size(); ++lllllllllllllllllIIIIIlIlllIlIlI) {
                Vector2f lllllllllllllllllIIIIIlIlllIllII = (Vector2f)lllllllllllllllllIIIIIlIlllIlIIl.get(lllllllllllllllllIIIIIlIlllIlIlI);
                Element lllllllllllllllllIIIIIlIlllIlIll = lllllllllllllllllIIIIIlIlllIIlII.createElement("point");
                lllllllllllllllllIIIIIlIlllIlIll.setAttribute("x", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIlIlllIllII.x)));
                lllllllllllllllllIIIIIlIlllIlIll.setAttribute("y", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIlIlllIllII.y)));
                lllllllllllllllllIIIIIlIlllIIlIl.appendChild(lllllllllllllllllIIIIIlIlllIlIll);
            }
        } else {
            Log.warn(String.valueOf(new StringBuilder().append("unkown value type ignored: ").append(lllllllllllllllllIIIIIlIlllIIIlI.getClass())));
        }
        return lllllllllllllllllIIIIIlIlllIIlIl;
    }

    public static void saveEmitter(OutputStream lllllllllllllllllIIIIlIIIlIIlIlI, ConfigurableEmitter lllllllllllllllllIIIIlIIIlIIlIll) throws IOException {
        try {
            DocumentBuilder lllllllllllllllllIIIIlIIIlIlIlIl = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document lllllllllllllllllIIIIlIIIlIlIlII = lllllllllllllllllIIIIlIIIlIlIlIl.newDocument();
            lllllllllllllllllIIIIlIIIlIlIlII.appendChild(ParticleIO.emitterToElement(lllllllllllllllllIIIIlIIIlIlIlII, lllllllllllllllllIIIIlIIIlIIlIll));
            StreamResult lllllllllllllllllIIIIlIIIlIlIIll = new StreamResult(new OutputStreamWriter(lllllllllllllllllIIIIlIIIlIIlIlI, "utf-8"));
            DOMSource lllllllllllllllllIIIIlIIIlIlIIlI = new DOMSource(lllllllllllllllllIIIIlIIIlIlIlII);
            TransformerFactory lllllllllllllllllIIIIlIIIlIlIIIl = TransformerFactory.newInstance();
            Transformer lllllllllllllllllIIIIlIIIlIlIIII = lllllllllllllllllIIIIlIIIlIlIIIl.newTransformer();
            lllllllllllllllllIIIIlIIIlIlIIII.setOutputProperty("indent", "yes");
            lllllllllllllllllIIIIlIIIlIlIIII.transform(lllllllllllllllllIIIIlIIIlIlIIlI, lllllllllllllllllIIIIlIIIlIlIIll);
        }
        catch (Exception lllllllllllllllllIIIIlIIIlIIllll) {
            Log.error(lllllllllllllllllIIIIlIIIlIIllll);
            throw new IOException("Failed to save emitter");
        }
    }

    public static ParticleSystem loadConfiguredSystem(String lllllllllllllllllIIIIlIIlllIlIII, ConfigurableEmitterFactory lllllllllllllllllIIIIlIIlllIIlll) throws IOException {
        return ParticleIO.loadConfiguredSystem(ResourceLoader.getResourceAsStream(lllllllllllllllllIIIIlIIlllIlIII), lllllllllllllllllIIIIlIIlllIIlll, null, null);
    }

    public static ParticleSystem loadConfiguredSystem(InputStream lllllllllllllllllIIIIlIIlllIllIl) throws IOException {
        return ParticleIO.loadConfiguredSystem(lllllllllllllllllIIIIlIIlllIllIl, null, null, null);
    }

    private static Element emitterToElement(Document lllllllllllllllllIIIIIllIIIlIIII, ConfigurableEmitter lllllllllllllllllIIIIIllIIIlIlll) {
        Element lllllllllllllllllIIIIIllIIIlIllI = lllllllllllllllllIIIIIllIIIlIIII.createElement("emitter");
        lllllllllllllllllIIIIIllIIIlIllI.setAttribute("name", lllllllllllllllllIIIIIllIIIlIlll.name);
        lllllllllllllllllIIIIIllIIIlIllI.setAttribute("imageName", lllllllllllllllllIIIIIllIIIlIlll.imageName == null ? "" : lllllllllllllllllIIIIIllIIIlIlll.imageName);
        lllllllllllllllllIIIIIllIIIlIllI.setAttribute("useOriented", lllllllllllllllllIIIIIllIIIlIlll.useOriented ? "true" : "false");
        lllllllllllllllllIIIIIllIIIlIllI.setAttribute("useAdditive", lllllllllllllllllIIIIIllIIIlIlll.useAdditive ? "true" : "false");
        if (lllllllllllllllllIIIIIllIIIlIlll.usePoints == 1) {
            lllllllllllllllllIIIIIllIIIlIllI.setAttribute("renderType", "inherit");
        }
        if (lllllllllllllllllIIIIIllIIIlIlll.usePoints == 2) {
            lllllllllllllllllIIIIIllIIIlIllI.setAttribute("renderType", "points");
        }
        if (lllllllllllllllllIIIIIllIIIlIlll.usePoints == 3) {
            lllllllllllllllllIIIIIllIIIlIllI.setAttribute("renderType", "quads");
        }
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "spawnInterval", lllllllllllllllllIIIIIllIIIlIlll.spawnInterval));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "spawnCount", lllllllllllllllllIIIIIllIIIlIlll.spawnCount));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "initialLife", lllllllllllllllllIIIIIllIIIlIlll.initialLife));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "initialSize", lllllllllllllllllIIIIIllIIIlIlll.initialSize));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "xOffset", lllllllllllllllllIIIIIllIIIlIlll.xOffset));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "yOffset", lllllllllllllllllIIIIIllIIIlIlll.yOffset));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "initialDistance", lllllllllllllllllIIIIIllIIIlIlll.initialDistance));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "speed", lllllllllllllllllIIIIIllIIIlIlll.speed));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "length", lllllllllllllllllIIIIIllIIIlIlll.length));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createRangeElement(lllllllllllllllllIIIIIllIIIlIIII, "emitCount", lllllllllllllllllIIIIIllIIIlIlll.emitCount));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "spread", lllllllllllllllllIIIIIllIIIlIlll.spread));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "angularOffset", lllllllllllllllllIIIIIllIIIlIlll.angularOffset));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "growthFactor", lllllllllllllllllIIIIIllIIIlIlll.growthFactor));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "gravityFactor", lllllllllllllllllIIIIIllIIIlIlll.gravityFactor));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "windFactor", lllllllllllllllllIIIIIllIIIlIlll.windFactor));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "startAlpha", lllllllllllllllllIIIIIllIIIlIlll.startAlpha));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "endAlpha", lllllllllllllllllIIIIIllIIIlIlll.endAlpha));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "alpha", lllllllllllllllllIIIIIllIIIlIlll.alpha));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "size", lllllllllllllllllIIIIIllIIIlIlll.size));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "velocity", lllllllllllllllllIIIIIllIIIlIlll.velocity));
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(ParticleIO.createValueElement(lllllllllllllllllIIIIIllIIIlIIII, "scaleY", lllllllllllllllllIIIIIllIIIlIlll.scaleY));
        Element lllllllllllllllllIIIIIllIIIlIlII = lllllllllllllllllIIIIIllIIIlIIII.createElement("color");
        ArrayList lllllllllllllllllIIIIIllIIIlIIlI = lllllllllllllllllIIIIIllIIIlIlll.colors;
        for (int lllllllllllllllllIIIIIllIIIlllII = 0; lllllllllllllllllIIIIIllIIIlllII < lllllllllllllllllIIIIIllIIIlIIlI.size(); ++lllllllllllllllllIIIIIllIIIlllII) {
            ConfigurableEmitter.ColorRecord lllllllllllllllllIIIIIllIIlIIIII = (ConfigurableEmitter.ColorRecord)lllllllllllllllllIIIIIllIIIlIIlI.get(lllllllllllllllllIIIIIllIIIlllII);
            Element lllllllllllllllllIIIIIllIIIllllI = lllllllllllllllllIIIIIllIIIlIIII.createElement("step");
            lllllllllllllllllIIIIIllIIIllllI.setAttribute("offset", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIllIIlIIIII.pos)));
            lllllllllllllllllIIIIIllIIIllllI.setAttribute("r", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIllIIlIIIII.col.r)));
            lllllllllllllllllIIIIIllIIIllllI.setAttribute("g", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIllIIlIIIII.col.g)));
            lllllllllllllllllIIIIIllIIIllllI.setAttribute("b", String.valueOf(new StringBuilder().append("").append(lllllllllllllllllIIIIIllIIlIIIII.col.b)));
            lllllllllllllllllIIIIIllIIIlIlII.appendChild(lllllllllllllllllIIIIIllIIIllllI);
        }
        lllllllllllllllllIIIIIllIIIlIllI.appendChild(lllllllllllllllllIIIIIllIIIlIlII);
        return lllllllllllllllllIIIIIllIIIlIllI;
    }
}

