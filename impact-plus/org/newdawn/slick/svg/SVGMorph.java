/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import java.util.ArrayList;
import org.newdawn.slick.geom.MorphShape;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.Figure;

public class SVGMorph
extends Diagram {
    private /* synthetic */ ArrayList figures;

    public void setMorphTime(float lllllllllllllllllllllllIlllIIIlI) {
        SVGMorph lllllllllllllllllllllllIlllIIIll;
        for (int lllllllllllllllllllllllIlllIIllI = 0; lllllllllllllllllllllllIlllIIllI < lllllllllllllllllllllllIlllIIIll.figures.size(); ++lllllllllllllllllllllllIlllIIllI) {
            Figure lllllllllllllllllllllllIlllIlIII = (Figure)lllllllllllllllllllllllIlllIIIll.figures.get(lllllllllllllllllllllllIlllIIllI);
            MorphShape lllllllllllllllllllllllIlllIIlll = (MorphShape)lllllllllllllllllllllllIlllIlIII.getShape();
            lllllllllllllllllllllllIlllIIlll.setMorphTime(lllllllllllllllllllllllIlllIIIlI);
        }
    }

    public void addStep(Diagram llllllllllllllllllllllllIIIllIlI) {
        SVGMorph llllllllllllllllllllllllIIIllIll;
        if (llllllllllllllllllllllllIIIllIlI.getFigureCount() != llllllllllllllllllllllllIIIllIll.figures.size()) {
            throw new RuntimeException("Mismatched diagrams, missing ids");
        }
        block0: for (int llllllllllllllllllllllllIIIlllII = 0; llllllllllllllllllllllllIIIlllII < llllllllllllllllllllllllIIIllIlI.getFigureCount(); ++llllllllllllllllllllllllIIIlllII) {
            Figure llllllllllllllllllllllllIIIllllI = llllllllllllllllllllllllIIIllIlI.getFigure(llllllllllllllllllllllllIIIlllII);
            String llllllllllllllllllllllllIIIlllIl = llllllllllllllllllllllllIIIllllI.getData().getMetaData();
            for (int llllllllllllllllllllllllIIIlllll = 0; llllllllllllllllllllllllIIIlllll < llllllllllllllllllllllllIIIllIll.figures.size(); ++llllllllllllllllllllllllIIIlllll) {
                Figure llllllllllllllllllllllllIIlIIIII = (Figure)llllllllllllllllllllllllIIIllIll.figures.get(llllllllllllllllllllllllIIIlllll);
                if (!llllllllllllllllllllllllIIlIIIII.getData().getMetaData().equals(llllllllllllllllllllllllIIIlllIl)) continue;
                MorphShape llllllllllllllllllllllllIIlIIIIl = (MorphShape)llllllllllllllllllllllllIIlIIIII.getShape();
                llllllllllllllllllllllllIIlIIIIl.addShape(llllllllllllllllllllllllIIIllllI.getShape());
                continue block0;
            }
        }
    }

    public void setExternalDiagram(Diagram llllllllllllllllllllllllIIIIIIlI) {
        SVGMorph llllllllllllllllllllllllIIIIIlIl;
        block0: for (int llllllllllllllllllllllllIIIIIllI = 0; llllllllllllllllllllllllIIIIIllI < llllllllllllllllllllllllIIIIIlIl.figures.size(); ++llllllllllllllllllllllllIIIIIllI) {
            Figure llllllllllllllllllllllllIIIIIlll = (Figure)llllllllllllllllllllllllIIIIIlIl.figures.get(llllllllllllllllllllllllIIIIIllI);
            for (int llllllllllllllllllllllllIIIIlIII = 0; llllllllllllllllllllllllIIIIlIII < llllllllllllllllllllllllIIIIIIlI.getFigureCount(); ++llllllllllllllllllllllllIIIIlIII) {
                Figure llllllllllllllllllllllllIIIIlIIl = llllllllllllllllllllllllIIIIIIlI.getFigure(llllllllllllllllllllllllIIIIlIII);
                if (!llllllllllllllllllllllllIIIIlIIl.getData().getMetaData().equals(llllllllllllllllllllllllIIIIIlll.getData().getMetaData())) continue;
                MorphShape llllllllllllllllllllllllIIIIlIlI = (MorphShape)llllllllllllllllllllllllIIIIIlll.getShape();
                llllllllllllllllllllllllIIIIlIlI.setExternalFrame(llllllllllllllllllllllllIIIIlIIl.getShape());
                continue block0;
            }
        }
    }

    public SVGMorph(Diagram llllllllllllllllllllllllIIlIllll) {
        super(llllllllllllllllllllllllIIlIllll.getWidth(), llllllllllllllllllllllllIIlIllll.getHeight());
        SVGMorph llllllllllllllllllllllllIIlIlllI;
        llllllllllllllllllllllllIIlIlllI.figures = new ArrayList();
        for (int llllllllllllllllllllllllIIllIIIl = 0; llllllllllllllllllllllllIIllIIIl < llllllllllllllllllllllllIIlIllll.getFigureCount(); ++llllllllllllllllllllllllIIllIIIl) {
            Figure llllllllllllllllllllllllIIllIIll = llllllllllllllllllllllllIIlIllll.getFigure(llllllllllllllllllllllllIIllIIIl);
            Figure llllllllllllllllllllllllIIllIIlI = new Figure(llllllllllllllllllllllllIIllIIll.getType(), new MorphShape(llllllllllllllllllllllllIIllIIll.getShape()), llllllllllllllllllllllllIIllIIll.getData(), llllllllllllllllllllllllIIllIIll.getTransform());
            llllllllllllllllllllllllIIlIlllI.figures.add(llllllllllllllllllllllllIIllIIlI);
        }
    }

    @Override
    public int getFigureCount() {
        SVGMorph lllllllllllllllllllllllIllIlllIl;
        return lllllllllllllllllllllllIllIlllIl.figures.size();
    }

    public void updateMorphTime(float lllllllllllllllllllllllIllllIIll) {
        SVGMorph lllllllllllllllllllllllIllllIlII;
        for (int lllllllllllllllllllllllIllllIlIl = 0; lllllllllllllllllllllllIllllIlIl < lllllllllllllllllllllllIllllIlII.figures.size(); ++lllllllllllllllllllllllIllllIlIl) {
            Figure lllllllllllllllllllllllIllllIlll = (Figure)lllllllllllllllllllllllIllllIlII.figures.get(lllllllllllllllllllllllIllllIlIl);
            MorphShape lllllllllllllllllllllllIllllIllI = (MorphShape)lllllllllllllllllllllllIllllIlll.getShape();
            lllllllllllllllllllllllIllllIllI.updateMorphTime(lllllllllllllllllllllllIllllIIll);
        }
    }

    @Override
    public Figure getFigure(int lllllllllllllllllllllllIllIlIllI) {
        SVGMorph lllllllllllllllllllllllIllIlIlll;
        return (Figure)lllllllllllllllllllllllIllIlIlll.figures.get(lllllllllllllllllllllllIllIlIllI);
    }
}

