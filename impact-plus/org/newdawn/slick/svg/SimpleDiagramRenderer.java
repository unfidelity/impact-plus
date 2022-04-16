/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.svg;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.ShapeRenderer;
import org.newdawn.slick.geom.TexCoordGenerator;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.svg.Diagram;
import org.newdawn.slick.svg.Figure;
import org.newdawn.slick.svg.Gradient;
import org.newdawn.slick.svg.LinearGradientFill;
import org.newdawn.slick.svg.RadialGradientFill;

public class SimpleDiagramRenderer {
    public /* synthetic */ int list;
    public /* synthetic */ Diagram diagram;
    protected static /* synthetic */ SGL GL;

    public void render(Graphics llllllllllllllllllllIllIlIIIIlIl) {
        SimpleDiagramRenderer llllllllllllllllllllIllIlIIIIllI;
        if (llllllllllllllllllllIllIlIIIIllI.list == -1) {
            llllllllllllllllllllIllIlIIIIllI.list = GL.glGenLists(1);
            GL.glNewList(llllllllllllllllllllIllIlIIIIllI.list, 4864);
            SimpleDiagramRenderer.render(llllllllllllllllllllIllIlIIIIlIl, llllllllllllllllllllIllIlIIIIllI.diagram);
            GL.glEndList();
        }
        GL.glCallList(llllllllllllllllllllIllIlIIIIllI.list);
        TextureImpl.bindNone();
    }

    static {
        GL = Renderer.get();
    }

    public static void render(Graphics llllllllllllllllllllIllIIlllIIlI, Diagram llllllllllllllllllllIllIIlllIIIl) {
        for (int llllllllllllllllllllIllIIlllIlIl = 0; llllllllllllllllllllIllIIlllIlIl < llllllllllllllllllllIllIIlllIIIl.getFigureCount(); ++llllllllllllllllllllIllIIlllIlIl) {
            Figure llllllllllllllllllllIllIIlllIllI = llllllllllllllllllllIllIIlllIIIl.getFigure(llllllllllllllllllllIllIIlllIlIl);
            if (llllllllllllllllllllIllIIlllIllI.getData().isFilled()) {
                String llllllllllllllllllllIllIIlllIlll;
                if (llllllllllllllllllllIllIIlllIllI.getData().isColor("fill")) {
                    llllllllllllllllllllIllIIlllIIlI.setColor(llllllllllllllllllllIllIIlllIllI.getData().getAsColor("fill"));
                    llllllllllllllllllllIllIIlllIIlI.fill(llllllllllllllllllllIllIIlllIIIl.getFigure(llllllllllllllllllllIllIIlllIlIl).getShape());
                    llllllllllllllllllllIllIIlllIIlI.setAntiAlias(true);
                    llllllllllllllllllllIllIIlllIIlI.draw(llllllllllllllllllllIllIIlllIIIl.getFigure(llllllllllllllllllllIllIIlllIlIl).getShape());
                    llllllllllllllllllllIllIIlllIIlI.setAntiAlias(false);
                }
                if (llllllllllllllllllllIllIIlllIIIl.getPatternDef(llllllllllllllllllllIllIIlllIlll = llllllllllllllllllllIllIIlllIllI.getData().getAsReference("fill")) != null) {
                    System.out.println("PATTERN");
                }
                if (llllllllllllllllllllIllIIlllIIIl.getGradient(llllllllllllllllllllIllIIlllIlll) != null) {
                    Gradient llllllllllllllllllllIllIIllllIlI = llllllllllllllllllllIllIIlllIIIl.getGradient(llllllllllllllllllllIllIIlllIlll);
                    Shape llllllllllllllllllllIllIIllllIIl = llllllllllllllllllllIllIIlllIIIl.getFigure(llllllllllllllllllllIllIIlllIlIl).getShape();
                    TexCoordGenerator llllllllllllllllllllIllIIllllIII = null;
                    llllllllllllllllllllIllIIllllIII = llllllllllllllllllllIllIIllllIlI.isRadial() ? new RadialGradientFill(llllllllllllllllllllIllIIllllIIl, llllllllllllllllllllIllIIlllIIIl.getFigure(llllllllllllllllllllIllIIlllIlIl).getTransform(), llllllllllllllllllllIllIIllllIlI) : new LinearGradientFill(llllllllllllllllllllIllIIllllIIl, llllllllllllllllllllIllIIlllIIIl.getFigure(llllllllllllllllllllIllIIlllIlIl).getTransform(), llllllllllllllllllllIllIIllllIlI);
                    Color.white.bind();
                    ShapeRenderer.texture(llllllllllllllllllllIllIIllllIIl, llllllllllllllllllllIllIIllllIlI.getImage(), llllllllllllllllllllIllIIllllIII);
                }
            }
            if (!llllllllllllllllllllIllIIlllIllI.getData().isStroked() || !llllllllllllllllllllIllIIlllIllI.getData().isColor("stroke")) continue;
            llllllllllllllllllllIllIIlllIIlI.setColor(llllllllllllllllllllIllIIlllIllI.getData().getAsColor("stroke"));
            llllllllllllllllllllIllIIlllIIlI.setLineWidth(llllllllllllllllllllIllIIlllIllI.getData().getAsFloat("stroke-width"));
            llllllllllllllllllllIllIIlllIIlI.setAntiAlias(true);
            llllllllllllllllllllIllIIlllIIlI.draw(llllllllllllllllllllIllIIlllIIIl.getFigure(llllllllllllllllllllIllIIlllIlIl).getShape());
            llllllllllllllllllllIllIIlllIIlI.setAntiAlias(false);
            llllllllllllllllllllIllIIlllIIlI.resetLineWidth();
        }
    }

    public SimpleDiagramRenderer(Diagram llllllllllllllllllllIllIlIIIlIll) {
        SimpleDiagramRenderer llllllllllllllllllllIllIlIIIlIlI;
        llllllllllllllllllllIllIlIIIlIlI.list = -1;
        llllllllllllllllllllIllIlIIIlIlI.diagram = llllllllllllllllllllIllIlIIIlIll;
    }
}

