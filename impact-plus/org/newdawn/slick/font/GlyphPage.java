/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.Glyph;
import org.newdawn.slick.font.effects.Effect;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;

public class GlyphPage {
    private /* synthetic */ int pageX;
    private final /* synthetic */ int pageHeight;
    private final /* synthetic */ List pageGlyphs;
    private static /* synthetic */ ByteBuffer scratchByteBuffer;
    private final /* synthetic */ int pageWidth;
    private /* synthetic */ boolean orderAscending;
    private /* synthetic */ int pageY;
    private final /* synthetic */ Image pageImage;
    private static /* synthetic */ BufferedImage scratchImage;
    public static final /* synthetic */ int MAX_GLYPH_SIZE;
    private static /* synthetic */ IntBuffer scratchIntBuffer;
    public static /* synthetic */ FontRenderContext renderContext;
    private /* synthetic */ int rowHeight;
    private final /* synthetic */ UnicodeFont unicodeFont;
    private static final /* synthetic */ SGL GL;
    private static /* synthetic */ Graphics2D scratchGraphics;

    public static Graphics2D getScratchGraphics() {
        return scratchGraphics;
    }

    public List getGlyphs() {
        GlyphPage llIIlIIlllllI;
        return llIIlIIlllllI.pageGlyphs;
    }

    private void renderGlyph(Glyph llIIlIlIlIlII, int llIIlIlIlIIll, int llIIlIlIlIIlI) throws SlickException {
        GlyphPage llIIlIlIlIlIl;
        scratchGraphics.setComposite(AlphaComposite.Clear);
        scratchGraphics.fillRect(0, 0, 256, 256);
        scratchGraphics.setComposite(AlphaComposite.SrcOver);
        scratchGraphics.setColor(java.awt.Color.white);
        Iterator llIIlIlIlIlll = llIIlIlIlIlIl.unicodeFont.getEffects().iterator();
        while (llIIlIlIlIlll.hasNext()) {
            ((Effect)llIIlIlIlIlll.next()).draw(scratchImage, scratchGraphics, llIIlIlIlIlIl.unicodeFont, llIIlIlIlIlII);
        }
        llIIlIlIlIlII.setShape(null);
        WritableRaster llIIlIlIlIIIl = scratchImage.getRaster();
        int[] llIIlIlIlIIII = new int[llIIlIlIlIIll];
        for (int llIIlIlIlIllI = 0; llIIlIlIlIllI < llIIlIlIlIIlI; ++llIIlIlIlIllI) {
            llIIlIlIlIIIl.getDataElements(0, llIIlIlIlIllI, llIIlIlIlIIll, 1, llIIlIlIlIIII);
            scratchIntBuffer.put(llIIlIlIlIIII);
        }
        GL.glTexSubImage2D(3553, 0, llIIlIlIlIlIl.pageX, llIIlIlIlIlIl.pageY, llIIlIlIlIIll, llIIlIlIlIIlI, 32993, 5121, scratchByteBuffer);
        scratchIntBuffer.clear();
        llIIlIlIlIlII.setImage(llIIlIlIlIlIl.pageImage.getSubImage(llIIlIlIlIlIl.pageX, llIIlIlIlIlIl.pageY, llIIlIlIlIIll, llIIlIlIlIIlI));
    }

    public Image getImage() {
        GlyphPage llIIlIIlllIlI;
        return llIIlIIlllIlI.pageImage;
    }

    private Iterator getIterator(List llIIlIlIIIlII) {
        GlyphPage llIIlIlIIIlIl;
        if (llIIlIlIIIlIl.orderAscending) {
            return llIIlIlIIIlII.iterator();
        }
        final ListIterator llIIlIlIIIIll = llIIlIlIIIlII.listIterator(llIIlIlIIIlII.size());
        return new Iterator(){
            {
                1 llllllllllllllllllIIllIllIlIIlII;
            }

            public Object next() {
                1 llllllllllllllllllIIllIllIIllIll;
                return llllllllllllllllllIIllIllIIllIll.llIIlIlIIIIll.previous();
            }

            @Override
            public boolean hasNext() {
                1 llllllllllllllllllIIllIllIIllllI;
                return llllllllllllllllllIIllIllIIllllI.llIIlIlIIIIll.hasPrevious();
            }

            @Override
            public void remove() {
                1 llllllllllllllllllIIllIllIIllIII;
                llllllllllllllllllIIllIllIIllIII.llIIlIlIIIIll.remove();
            }
        };
    }

    static {
        MAX_GLYPH_SIZE = 256;
        GL = Renderer.get();
        scratchByteBuffer = ByteBuffer.allocateDirect(262144);
        scratchByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        scratchIntBuffer = scratchByteBuffer.asIntBuffer();
        scratchImage = new BufferedImage(256, 256, 2);
        scratchGraphics = (Graphics2D)scratchImage.getGraphics();
        scratchGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        scratchGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        scratchGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        renderContext = scratchGraphics.getFontRenderContext();
    }

    public GlyphPage(UnicodeFont llIIllIIIIlII, int llIIllIIIIlll, int llIIllIIIIllI) throws SlickException {
        GlyphPage llIIllIIIlIIl;
        llIIllIIIlIIl.pageGlyphs = new ArrayList(32);
        llIIllIIIlIIl.unicodeFont = llIIllIIIIlII;
        llIIllIIIlIIl.pageWidth = llIIllIIIIlll;
        llIIllIIIlIIl.pageHeight = llIIllIIIIllI;
        llIIllIIIlIIl.pageImage = new Image(llIIllIIIIlll, llIIllIIIIllI);
    }

    public int loadGlyphs(List llIIlIllIIlll, int llIIlIllIIllI) throws SlickException {
        GlyphPage llIIlIllIlIII;
        if (llIIlIllIlIII.rowHeight != 0 && llIIlIllIIllI == -1) {
            int llIIlIlllIIll = llIIlIllIlIII.pageX;
            int llIIlIlllIIlI = llIIlIllIlIII.pageY;
            int llIIlIlllIIIl = llIIlIllIlIII.rowHeight;
            Iterator llIIlIlllIlII = llIIlIllIlIII.getIterator(llIIlIllIIlll);
            while (llIIlIlllIlII.hasNext()) {
                Glyph llIIlIlllIlll = (Glyph)llIIlIlllIlII.next();
                int llIIlIlllIllI = llIIlIlllIlll.getWidth();
                int llIIlIlllIlIl = llIIlIlllIlll.getHeight();
                if (llIIlIlllIIll + llIIlIlllIllI >= llIIlIllIlIII.pageWidth) {
                    llIIlIlllIIll = 0;
                    llIIlIlllIIlI += llIIlIlllIIIl;
                    llIIlIlllIIIl = llIIlIlllIlIl;
                } else if (llIIlIlllIlIl > llIIlIlllIIIl) {
                    llIIlIlllIIIl = llIIlIlllIlIl;
                }
                if (llIIlIlllIIlI + llIIlIlllIIIl >= llIIlIllIlIII.pageWidth) {
                    return 0;
                }
                llIIlIlllIIll += llIIlIlllIllI;
            }
        }
        Color.white.bind();
        llIIlIllIlIII.pageImage.bind();
        int llIIlIllIlIIl = 0;
        Iterator llIIlIllIllIl = llIIlIllIlIII.getIterator(llIIlIllIIlll);
        while (llIIlIllIllIl.hasNext()) {
            Glyph llIIlIlllIIII = (Glyph)llIIlIllIllIl.next();
            int llIIlIllIllll = Math.min(256, llIIlIlllIIII.getWidth());
            int llIIlIllIlllI = Math.min(256, llIIlIlllIIII.getHeight());
            if (llIIlIllIlIII.rowHeight == 0) {
                llIIlIllIlIII.rowHeight = llIIlIllIlllI;
            } else if (llIIlIllIlIII.pageX + llIIlIllIllll >= llIIlIllIlIII.pageWidth) {
                if (llIIlIllIlIII.pageY + llIIlIllIlIII.rowHeight + llIIlIllIlllI >= llIIlIllIlIII.pageHeight) break;
                llIIlIllIlIII.pageX = 0;
                llIIlIllIlIII.pageY += llIIlIllIlIII.rowHeight;
                llIIlIllIlIII.rowHeight = llIIlIllIlllI;
            } else if (llIIlIllIlllI > llIIlIllIlIII.rowHeight) {
                if (llIIlIllIlIII.pageY + llIIlIllIlllI >= llIIlIllIlIII.pageHeight) break;
                llIIlIllIlIII.rowHeight = llIIlIllIlllI;
            }
            llIIlIllIlIII.renderGlyph(llIIlIlllIIII, llIIlIllIllll, llIIlIllIlllI);
            llIIlIllIlIII.pageGlyphs.add(llIIlIlllIIII);
            llIIlIllIlIII.pageX += llIIlIllIllll;
            llIIlIllIllIl.remove();
            if (++llIIlIllIlIIl != llIIlIllIIllI) continue;
            llIIlIllIlIII.orderAscending = !llIIlIllIlIII.orderAscending;
            break;
        }
        TextureImpl.bindNone();
        llIIlIllIlIII.orderAscending = !llIIlIllIlIII.orderAscending;
        return llIIlIllIlIIl;
    }
}

