/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import java.util.ArrayList;
import java.util.HashMap;
import org.newdawn.slick.svg.Figure;
import org.newdawn.slick.svg.Gradient;
import org.newdawn.slick.svg.InkscapeLoader;

public class Diagram {
    private /* synthetic */ float height;
    private /* synthetic */ HashMap figureMap;
    private /* synthetic */ HashMap patterns;
    private /* synthetic */ HashMap gradients;
    private /* synthetic */ ArrayList figures;
    private /* synthetic */ float width;

    public float getHeight() {
        Diagram lIIlIIIlllllllI;
        return lIIlIIIlllllllI.height;
    }

    public Figure getFigure(int lIIlIIIllIIIIII) {
        Diagram lIIlIIIllIIIIIl;
        return (Figure)lIIlIIIllIIIIIl.figures.get(lIIlIIIllIIIIII);
    }

    public Gradient getGradient(String lIIlIIIllIlllll) {
        Diagram lIIlIIIlllIIIlI;
        return (Gradient)lIIlIIIlllIIIlI.gradients.get(lIIlIIIllIlllll);
    }

    public Diagram(float lIIlIIlIIIIIlII, float lIIlIIlIIIIIIll) {
        Diagram lIIlIIlIIIIlIII;
        lIIlIIlIIIIlIII.figures = new ArrayList();
        lIIlIIlIIIIlIII.patterns = new HashMap();
        lIIlIIlIIIIlIII.gradients = new HashMap();
        lIIlIIlIIIIlIII.figureMap = new HashMap();
        lIIlIIlIIIIlIII.width = lIIlIIlIIIIIlII;
        lIIlIIlIIIIlIII.height = lIIlIIlIIIIIIll;
    }

    public String[] getPatternDefNames() {
        Diagram lIIlIIIllIlllIl;
        return lIIlIIIllIlllIl.patterns.keySet().toArray(new String[0]);
    }

    public int getFigureCount() {
        Diagram lIIlIIIllIIIlII;
        return lIIlIIIllIIIlII.figures.size();
    }

    public void addFigure(Figure lIIlIIIllIIlllI) {
        Diagram lIIlIIIllIIllll;
        lIIlIIIllIIllll.figures.add(lIIlIIIllIIlllI);
        lIIlIIIllIIllll.figureMap.put(lIIlIIIllIIlllI.getData().getAttribute("id"), lIIlIIIllIIlllI);
        String lIIlIIIllIIllIl = lIIlIIIllIIlllI.getData().getAsReference("fill");
        Gradient lIIlIIIllIIllII = lIIlIIIllIIllll.getGradient(lIIlIIIllIIllIl);
        if (lIIlIIIllIIllII != null && lIIlIIIllIIllII.isRadial()) {
            for (int lIIlIIIllIlIIII = 0; lIIlIIIllIlIIII < InkscapeLoader.RADIAL_TRIANGULATION_LEVEL; ++lIIlIIIllIlIIII) {
                lIIlIIIllIIlllI.getShape().increaseTriangulation();
            }
        }
    }

    public String getPatternDef(String lIIlIIIlllIIlIl) {
        Diagram lIIlIIIlllIIllI;
        return (String)lIIlIIIlllIIllI.patterns.get(lIIlIIIlllIIlIl);
    }

    public float getWidth() {
        Diagram lIIlIIlIIIIIIIl;
        return lIIlIIlIIIIIIIl.width;
    }

    public void addGradient(String lIIlIIIlllIllll, Gradient lIIlIIIlllIlllI) {
        Diagram lIIlIIIllllIIII;
        lIIlIIIllllIIII.gradients.put(lIIlIIIlllIllll, lIIlIIIlllIlllI);
    }

    public Figure getFigureByID(String lIIlIIIllIlIllI) {
        Diagram lIIlIIIllIlIlll;
        return (Figure)lIIlIIIllIlIlll.figureMap.get(lIIlIIIllIlIllI);
    }

    public void addPatternDef(String lIIlIIIlllllIII, String lIIlIIIllllIlII) {
        Diagram lIIlIIIllllIllI;
        lIIlIIIllllIllI.patterns.put(lIIlIIIlllllIII, lIIlIIIllllIlII);
    }

    public void removeFigure(Figure lIIlIIIlIlllIII) {
        Diagram lIIlIIIlIlllIll;
        lIIlIIIlIlllIll.figures.remove(lIIlIIIlIlllIII);
        lIIlIIIlIlllIll.figureMap.remove(lIIlIIIlIlllIII.getData().getAttribute("id"));
    }
}

