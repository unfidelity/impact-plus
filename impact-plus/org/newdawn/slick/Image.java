/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.ImageBuffer;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.pbuffer.GraphicsFactory;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.Log;

public class Image
implements Renderable {
    protected /* synthetic */ Color[] corners;
    protected /* synthetic */ float angle;
    protected /* synthetic */ String name;
    protected static /* synthetic */ SGL GL;
    protected static /* synthetic */ Image inUse;
    protected /* synthetic */ float centerX;
    public static final /* synthetic */ int BOTTOM_RIGHT;
    protected /* synthetic */ boolean destroyed;
    protected /* synthetic */ int height;
    public static final /* synthetic */ int TOP_LEFT;
    protected /* synthetic */ float alpha;
    protected /* synthetic */ Texture texture;
    private /* synthetic */ Color transparent;
    private /* synthetic */ boolean flipped;
    protected /* synthetic */ float textureOffsetX;
    protected /* synthetic */ float textureHeight;
    public static final /* synthetic */ int FILTER_NEAREST;
    protected /* synthetic */ float textureOffsetY;
    public static final /* synthetic */ int BOTTOM_LEFT;
    protected /* synthetic */ String ref;
    public static final /* synthetic */ int FILTER_LINEAR;
    protected /* synthetic */ byte[] pixelData;
    protected /* synthetic */ int width;
    protected /* synthetic */ boolean inited;
    public static final /* synthetic */ int TOP_RIGHT;
    protected /* synthetic */ float textureWidth;
    protected /* synthetic */ float centerY;
    private /* synthetic */ int filter;

    public void setTexture(Texture llllllllllllllllllIllIIIlllIIlll) {
        Image llllllllllllllllllIllIIIlllIlIII;
        llllllllllllllllllIllIIIlllIlIII.texture = llllllllllllllllllIllIIIlllIIlll;
        llllllllllllllllllIllIIIlllIlIII.reinit();
    }

    public void setFilter(int llllllllllllllllllIlllIIIlllIIIl) {
        Image llllllllllllllllllIlllIIIlllIIlI;
        llllllllllllllllllIlllIIIlllIIlI.filter = llllllllllllllllllIlllIIIlllIIIl == 1 ? 9729 : 9728;
        llllllllllllllllllIlllIIIlllIIlI.texture.bind();
        GL.glTexParameteri(3553, 10241, llllllllllllllllllIlllIIIlllIIlI.filter);
        GL.glTexParameteri(3553, 10240, llllllllllllllllllIlllIIIlllIIlI.filter);
    }

    public void draw(float llllllllllllllllllIllIllIIlllllI, float llllllllllllllllllIllIllIlIIIIIl, float llllllllllllllllllIllIllIlIIIIII) {
        Image llllllllllllllllllIllIllIIllllll;
        llllllllllllllllllIllIllIIllllll.init();
        llllllllllllllllllIllIllIIllllll.draw(llllllllllllllllllIllIllIIlllllI, llllllllllllllllllIllIllIlIIIIIl, (float)llllllllllllllllllIllIllIIllllll.width * llllllllllllllllllIllIllIlIIIIII, (float)llllllllllllllllllIllIllIIllllll.height * llllllllllllllllllIllIllIlIIIIII, Color.white);
    }

    protected void initImpl() {
    }

    public int getFilter() {
        Image llllllllllllllllllIlllIIIIIIllIl;
        return llllllllllllllllllIlllIIIIIIllIl.filter;
    }

    public Image(String llllllllllllllllllIlllIIlIlIIIII, Color llllllllllllllllllIlllIIlIlIIIlI) throws SlickException {
        llllllllllllllllllIlllIIlIlIIlII(llllllllllllllllllIlllIIlIlIIIII, false, 1, llllllllllllllllllIlllIIlIlIIIlI);
        Image llllllllllllllllllIlllIIlIlIIlII;
    }

    public Image getScaledCopy(float llllllllllllllllllIllIIlIIllIIIl) {
        Image llllllllllllllllllIllIIlIIllIIlI;
        llllllllllllllllllIllIIlIIllIIlI.init();
        return llllllllllllllllllIllIIlIIllIIlI.getScaledCopy((int)((float)llllllllllllllllllIllIIlIIllIIlI.width * llllllllllllllllllIllIIlIIllIIIl), (int)((float)llllllllllllllllllIllIIlIIllIIlI.height * llllllllllllllllllIllIIlIIllIIIl));
    }

    public String toString() {
        Image llllllllllllllllllIllIIIllllIIII;
        llllllllllllllllllIllIIIllllIIII.init();
        return String.valueOf(new StringBuilder().append("[Image ").append(llllllllllllllllllIllIIIllllIIII.ref).append(" ").append(llllllllllllllllllIllIIIllllIIII.width).append("x").append(llllllllllllllllllIllIIIllllIIII.height).append("  ").append(llllllllllllllllllIllIIIllllIIII.textureOffsetX).append(",").append(llllllllllllllllllIllIIIllllIIII.textureOffsetY).append(",").append(llllllllllllllllllIllIIIllllIIII.textureWidth).append(",").append(llllllllllllllllllIllIIIllllIIII.textureHeight).append("]"));
    }

    public Texture getTexture() {
        Image llllllllllllllllllIllIIIlllIlllI;
        return llllllllllllllllllIllIIIlllIlllI.texture;
    }

    public void setImageColor(float llllllllllllllllllIllIllllllIlIl, float llllllllllllllllllIllIllllllIIII, float llllllllllllllllllIllIllllllIIll) {
        Image llllllllllllllllllIllIllllllIllI;
        llllllllllllllllllIllIllllllIllI.setColor(0, llllllllllllllllllIllIllllllIlIl, llllllllllllllllllIllIllllllIIII, llllllllllllllllllIllIllllllIIll);
        llllllllllllllllllIllIllllllIllI.setColor(1, llllllllllllllllllIllIllllllIlIl, llllllllllllllllllIllIllllllIIII, llllllllllllllllllIllIllllllIIll);
        llllllllllllllllllIllIllllllIllI.setColor(3, llllllllllllllllllIllIllllllIlIl, llllllllllllllllllIllIllllllIIII, llllllllllllllllllIllIllllllIIll);
        llllllllllllllllllIllIllllllIllI.setColor(2, llllllllllllllllllIllIllllllIlIl, llllllllllllllllllIllIllllllIIII, llllllllllllllllllIllIllllllIIll);
    }

    public Image(String llllllllllllllllllIlllIIlIlIlIlI) throws SlickException {
        llllllllllllllllllIlllIIlIlIlIIl(llllllllllllllllllIlllIIlIlIlIlI, false);
        Image llllllllllllllllllIlllIIlIlIlIIl;
    }

    public float getTextureOffsetX() {
        Image llllllllllllllllllIllIllIlIllIII;
        llllllllllllllllllIllIllIlIllIII.init();
        return llllllllllllllllllIllIllIlIllIII.textureOffsetX;
    }

    public void drawCentered(float llllllllllllllllllIllIlllIIllIIl, float llllllllllllllllllIllIlllIIllIII) {
        Image llllllllllllllllllIllIlllIIllIlI;
        llllllllllllllllllIllIlllIIllIlI.draw(llllllllllllllllllIllIlllIIllIIl - (float)(llllllllllllllllllIllIlllIIllIlI.getWidth() / 2), llllllllllllllllllIllIlllIIllIII - (float)(llllllllllllllllllIllIlllIIllIlI.getHeight() / 2));
    }

    public void clampTexture() {
        if (GL.canTextureMirrorClamp()) {
            GL.glTexParameteri(3553, 10242, 34627);
            GL.glTexParameteri(3553, 10243, 34627);
        } else {
            GL.glTexParameteri(3553, 10242, 10496);
            GL.glTexParameteri(3553, 10243, 10496);
        }
    }

    protected void reinit() {
        Image llllllllllllllllllIllIlllIlIIllI;
        llllllllllllllllllIllIlllIlIIllI.inited = false;
        llllllllllllllllllIllIlllIlIIllI.init();
    }

    @Override
    public void draw(float llllllllllllllllllIllIlIllIlIlll, float llllllllllllllllllIllIlIllIlIlIl, float llllllllllllllllllIllIlIllIIlIIl, float llllllllllllllllllIllIlIllIIlIII, Color llllllllllllllllllIllIlIllIIIlll) {
        Image llllllllllllllllllIllIlIllIIlllI;
        if (llllllllllllllllllIllIlIllIIlllI.alpha != 1.0f) {
            if (llllllllllllllllllIllIlIllIIIlll == null) {
                llllllllllllllllllIllIlIllIIIlll = Color.white;
            }
            llllllllllllllllllIllIlIllIIIlll = new Color(llllllllllllllllllIllIlIllIIIlll);
            llllllllllllllllllIllIlIllIIIlll.a *= llllllllllllllllllIllIlIllIIlllI.alpha;
        }
        if (llllllllllllllllllIllIlIllIIIlll != null) {
            llllllllllllllllllIllIlIllIIIlll.bind();
        }
        llllllllllllllllllIllIlIllIIlllI.texture.bind();
        GL.glTranslatef(llllllllllllllllllIllIlIllIlIlll, llllllllllllllllllIllIlIllIlIlIl, 0.0f);
        if (llllllllllllllllllIllIlIllIIlllI.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIlIllIIlllI.centerX, llllllllllllllllllIllIlIllIIlllI.centerY, 0.0f);
            GL.glRotatef(llllllllllllllllllIllIlIllIIlllI.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIlIllIIlllI.centerX, -llllllllllllllllllIllIlIllIIlllI.centerY, 0.0f);
        }
        GL.glBegin(7);
        llllllllllllllllllIllIlIllIIlllI.drawEmbedded(0.0f, 0.0f, llllllllllllllllllIllIlIllIIlIIl, llllllllllllllllllIllIlIllIIlIII);
        GL.glEnd();
        if (llllllllllllllllllIllIlIllIIlllI.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIlIllIIlllI.centerX, llllllllllllllllllIllIlIllIIlllI.centerY, 0.0f);
            GL.glRotatef(-llllllllllllllllllIllIlIllIIlllI.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIlIllIIlllI.centerX, -llllllllllllllllllIllIlIllIIlllI.centerY, 0.0f);
        }
        GL.glTranslatef(-llllllllllllllllllIllIlIllIlIlll, -llllllllllllllllllIllIlIllIlIlIl, 0.0f);
    }

    public void drawEmbedded(float llllllllllllllllllIllIllIllIIIll, float llllllllllllllllllIllIllIllIIIlI, float llllllllllllllllllIllIllIllIIlll, float llllllllllllllllllIllIllIllIIllI) {
        Image llllllllllllllllllIllIllIllIIlIl;
        llllllllllllllllllIllIllIllIIlIl.init();
        if (llllllllllllllllllIllIllIllIIlIl.corners == null) {
            GL.glTexCoord2f(llllllllllllllllllIllIllIllIIlIl.textureOffsetX, llllllllllllllllllIllIllIllIIlIl.textureOffsetY);
            GL.glVertex3f(llllllllllllllllllIllIllIllIIIll, llllllllllllllllllIllIllIllIIIlI, 0.0f);
            GL.glTexCoord2f(llllllllllllllllllIllIllIllIIlIl.textureOffsetX, llllllllllllllllllIllIllIllIIlIl.textureOffsetY + llllllllllllllllllIllIllIllIIlIl.textureHeight);
            GL.glVertex3f(llllllllllllllllllIllIllIllIIIll, llllllllllllllllllIllIllIllIIIlI + llllllllllllllllllIllIllIllIIllI, 0.0f);
            GL.glTexCoord2f(llllllllllllllllllIllIllIllIIlIl.textureOffsetX + llllllllllllllllllIllIllIllIIlIl.textureWidth, llllllllllllllllllIllIllIllIIlIl.textureOffsetY + llllllllllllllllllIllIllIllIIlIl.textureHeight);
            GL.glVertex3f(llllllllllllllllllIllIllIllIIIll + llllllllllllllllllIllIllIllIIlll, llllllllllllllllllIllIllIllIIIlI + llllllllllllllllllIllIllIllIIllI, 0.0f);
            GL.glTexCoord2f(llllllllllllllllllIllIllIllIIlIl.textureOffsetX + llllllllllllllllllIllIllIllIIlIl.textureWidth, llllllllllllllllllIllIllIllIIlIl.textureOffsetY);
            GL.glVertex3f(llllllllllllllllllIllIllIllIIIll + llllllllllllllllllIllIllIllIIlll, llllllllllllllllllIllIllIllIIIlI, 0.0f);
        } else {
            llllllllllllllllllIllIllIllIIlIl.corners[0].bind();
            GL.glTexCoord2f(llllllllllllllllllIllIllIllIIlIl.textureOffsetX, llllllllllllllllllIllIllIllIIlIl.textureOffsetY);
            GL.glVertex3f(llllllllllllllllllIllIllIllIIIll, llllllllllllllllllIllIllIllIIIlI, 0.0f);
            llllllllllllllllllIllIllIllIIlIl.corners[3].bind();
            GL.glTexCoord2f(llllllllllllllllllIllIllIllIIlIl.textureOffsetX, llllllllllllllllllIllIllIllIIlIl.textureOffsetY + llllllllllllllllllIllIllIllIIlIl.textureHeight);
            GL.glVertex3f(llllllllllllllllllIllIllIllIIIll, llllllllllllllllllIllIllIllIIIlI + llllllllllllllllllIllIllIllIIllI, 0.0f);
            llllllllllllllllllIllIllIllIIlIl.corners[2].bind();
            GL.glTexCoord2f(llllllllllllllllllIllIllIllIIlIl.textureOffsetX + llllllllllllllllllIllIllIllIIlIl.textureWidth, llllllllllllllllllIllIllIllIIlIl.textureOffsetY + llllllllllllllllllIllIllIllIIlIl.textureHeight);
            GL.glVertex3f(llllllllllllllllllIllIllIllIIIll + llllllllllllllllllIllIllIllIIlll, llllllllllllllllllIllIllIllIIIlI + llllllllllllllllllIllIllIllIIllI, 0.0f);
            llllllllllllllllllIllIllIllIIlIl.corners[1].bind();
            GL.glTexCoord2f(llllllllllllllllllIllIllIllIIlIl.textureOffsetX + llllllllllllllllllIllIllIllIIlIl.textureWidth, llllllllllllllllllIllIllIllIIlIl.textureOffsetY);
            GL.glVertex3f(llllllllllllllllllIllIllIllIIIll + llllllllllllllllllIllIllIllIIlll, llllllllllllllllllIllIllIllIIIlI, 0.0f);
        }
    }

    public void setImageColor(float llllllllllllllllllIlllIIIIIIIIll, float llllllllllllllllllIlllIIIIIIIIlI, float llllllllllllllllllIllIllllllllII, float llllllllllllllllllIllIlllllllIll) {
        Image llllllllllllllllllIllIllllllllll;
        llllllllllllllllllIllIllllllllll.setColor(0, llllllllllllllllllIlllIIIIIIIIll, llllllllllllllllllIlllIIIIIIIIlI, llllllllllllllllllIllIllllllllII, llllllllllllllllllIllIlllllllIll);
        llllllllllllllllllIllIllllllllll.setColor(1, llllllllllllllllllIlllIIIIIIIIll, llllllllllllllllllIlllIIIIIIIIlI, llllllllllllllllllIllIllllllllII, llllllllllllllllllIllIlllllllIll);
        llllllllllllllllllIllIllllllllll.setColor(3, llllllllllllllllllIlllIIIIIIIIll, llllllllllllllllllIlllIIIIIIIIlI, llllllllllllllllllIllIllllllllII, llllllllllllllllllIllIlllllllIll);
        llllllllllllllllllIllIllllllllll.setColor(2, llllllllllllllllllIlllIIIIIIIIll, llllllllllllllllllIlllIIIIIIIIlI, llllllllllllllllllIllIllllllllII, llllllllllllllllllIllIlllllllIll);
    }

    public void setCenterOfRotation(float llllllllllllllllllIllIlIlIllIIIl, float llllllllllllllllllIllIlIlIlIllII) {
        llllllllllllllllllIllIlIlIlIllll.centerX = llllllllllllllllllIllIlIlIllIIIl;
        llllllllllllllllllIllIlIlIlIllll.centerY = llllllllllllllllllIllIlIlIlIllII;
    }

    public void draw(float llllllllllllllllllIllIlIIlIIIIII, float llllllllllllllllllIllIlIIIlllIII, float llllllllllllllllllIllIlIIIllIlll, float llllllllllllllllllIllIlIIIllIllI, float llllllllllllllllllIllIlIIIllIlIl, float llllllllllllllllllIllIlIIIlllIll) {
        Image llllllllllllllllllIllIlIIlIIIIIl;
        llllllllllllllllllIllIlIIlIIIIIl.draw(llllllllllllllllllIllIlIIlIIIIII, llllllllllllllllllIllIlIIIlllIII, llllllllllllllllllIllIlIIlIIIIII + (float)llllllllllllllllllIllIlIIlIIIIIl.width, llllllllllllllllllIllIlIIIlllIII + (float)llllllllllllllllllIllIlIIlIIIIIl.height, llllllllllllllllllIllIlIIIllIlll, llllllllllllllllllIllIlIIIllIllI, llllllllllllllllllIllIlIIIllIlIl, llllllllllllllllllIllIlIIIlllIll);
    }

    @Override
    public void draw(float llllllllllllllllllIllIllIlllllll, float llllllllllllllllllIllIllIllllllI, Color llllllllllllllllllIllIlllIIIIIIl) {
        Image llllllllllllllllllIllIlllIIIIIII;
        llllllllllllllllllIllIlllIIIIIII.init();
        llllllllllllllllllIllIlllIIIIIII.draw(llllllllllllllllllIllIllIlllllll, llllllllllllllllllIllIllIllllllI, llllllllllllllllllIllIlllIIIIIII.width, llllllllllllllllllIllIlllIIIIIII.height, llllllllllllllllllIllIlllIIIIIIl);
    }

    private void load(InputStream llllllllllllllllllIllIlllIllIIII, String llllllllllllllllllIllIlllIlIllll, boolean llllllllllllllllllIllIlllIlIlllI, int llllllllllllllllllIllIlllIllIIll, Color llllllllllllllllllIllIlllIlIllII) throws SlickException {
        llllllllllllllllllIllIlllIllIIIl.filter = llllllllllllllllllIllIlllIllIIll == 1 ? 9729 : 9728;
        try {
            Image llllllllllllllllllIllIlllIllIIIl;
            llllllllllllllllllIllIlllIllIIIl.ref = llllllllllllllllllIllIlllIlIllll;
            int[] llllllllllllllllllIllIlllIlllIIl = null;
            if (llllllllllllllllllIllIlllIlIllII != null) {
                llllllllllllllllllIllIlllIlllIIl = new int[]{(int)(llllllllllllllllllIllIlllIlIllII.r * 255.0f), (int)(llllllllllllllllllIllIlllIlIllII.g * 255.0f), (int)(llllllllllllllllllIllIlllIlIllII.b * 255.0f)};
            }
            llllllllllllllllllIllIlllIllIIIl.texture = InternalTextureLoader.get().getTexture(llllllllllllllllllIllIlllIllIIII, llllllllllllllllllIllIlllIlIllll, llllllllllllllllllIllIlllIlIlllI, llllllllllllllllllIllIlllIllIIIl.filter, llllllllllllllllllIllIlllIlllIIl);
        }
        catch (IOException llllllllllllllllllIllIlllIlllIII) {
            Log.error(llllllllllllllllllIllIlllIlllIII);
            throw new SlickException(String.valueOf(new StringBuilder().append("Failed to load image from: ").append(llllllllllllllllllIllIlllIlIllll)), llllllllllllllllllIllIlllIlllIII);
        }
    }

    public Image getSubImage(int llllllllllllllllllIllIlIIlIlIIIl, int llllllllllllllllllIllIlIIlIlIIII, int llllllllllllllllllIllIlIIlIIllll, int llllllllllllllllllIllIlIIlIllIII) {
        Image llllllllllllllllllIllIlIIlIlIIlI;
        llllllllllllllllllIllIlIIlIlIIlI.init();
        float llllllllllllllllllIllIlIIlIlIlll = (float)llllllllllllllllllIllIlIIlIlIIIl / (float)llllllllllllllllllIllIlIIlIlIIlI.width * llllllllllllllllllIllIlIIlIlIIlI.textureWidth + llllllllllllllllllIllIlIIlIlIIlI.textureOffsetX;
        float llllllllllllllllllIllIlIIlIlIllI = (float)llllllllllllllllllIllIlIIlIlIIII / (float)llllllllllllllllllIllIlIIlIlIIlI.height * llllllllllllllllllIllIlIIlIlIIlI.textureHeight + llllllllllllllllllIllIlIIlIlIIlI.textureOffsetY;
        float llllllllllllllllllIllIlIIlIlIlIl = (float)llllllllllllllllllIllIlIIlIIllll / (float)llllllllllllllllllIllIlIIlIlIIlI.width * llllllllllllllllllIllIlIIlIlIIlI.textureWidth;
        float llllllllllllllllllIllIlIIlIlIlII = (float)llllllllllllllllllIllIlIIlIllIII / (float)llllllllllllllllllIllIlIIlIlIIlI.height * llllllllllllllllllIllIlIIlIlIIlI.textureHeight;
        Image llllllllllllllllllIllIlIIlIlIIll = new Image();
        llllllllllllllllllIllIlIIlIlIIll.inited = true;
        llllllllllllllllllIllIlIIlIlIIll.texture = llllllllllllllllllIllIlIIlIlIIlI.texture;
        llllllllllllllllllIllIlIIlIlIIll.textureOffsetX = llllllllllllllllllIllIlIIlIlIlll;
        llllllllllllllllllIllIlIIlIlIIll.textureOffsetY = llllllllllllllllllIllIlIIlIlIllI;
        llllllllllllllllllIllIlIIlIlIIll.textureWidth = llllllllllllllllllIllIlIIlIlIlIl;
        llllllllllllllllllIllIlIIlIlIIll.textureHeight = llllllllllllllllllIllIlIIlIlIlII;
        llllllllllllllllllIllIlIIlIlIIll.width = llllllllllllllllllIllIlIIlIIllll;
        llllllllllllllllllIllIlIIlIlIIll.height = llllllllllllllllllIllIlIIlIllIII;
        llllllllllllllllllIllIlIIlIlIIll.ref = llllllllllllllllllIllIlIIlIlIIlI.ref;
        llllllllllllllllllIllIlIIlIlIIll.centerX = llllllllllllllllllIllIlIIlIIllll / 2;
        llllllllllllllllllIllIlIIlIlIIll.centerY = llllllllllllllllllIllIlIIlIllIII / 2;
        return llllllllllllllllllIllIlIIlIlIIll;
    }

    protected final void init() {
        Image llllllllllllllllllIllIlllIlIIIlI;
        if (llllllllllllllllllIllIlllIlIIIlI.inited) {
            return;
        }
        llllllllllllllllllIllIlllIlIIIlI.inited = true;
        if (llllllllllllllllllIllIlllIlIIIlI.texture != null) {
            llllllllllllllllllIllIlllIlIIIlI.width = llllllllllllllllllIllIlllIlIIIlI.texture.getImageWidth();
            llllllllllllllllllIllIlllIlIIIlI.height = llllllllllllllllllIllIlllIlIIIlI.texture.getImageHeight();
            llllllllllllllllllIllIlllIlIIIlI.textureOffsetX = 0.0f;
            llllllllllllllllllIllIlllIlIIIlI.textureOffsetY = 0.0f;
            llllllllllllllllllIllIlllIlIIIlI.textureWidth = llllllllllllllllllIllIlllIlIIIlI.texture.getWidth();
            llllllllllllllllllIllIlllIlIIIlI.textureHeight = llllllllllllllllllIllIlllIlIIIlI.texture.getHeight();
        }
        llllllllllllllllllIllIlllIlIIIlI.initImpl();
        llllllllllllllllllIllIlllIlIIIlI.centerX = llllllllllllllllllIllIlllIlIIIlI.width / 2;
        llllllllllllllllllIllIlllIlIIIlI.centerY = llllllllllllllllllIllIlllIlIIIlI.height / 2;
    }

    public float getCenterOfRotationY() {
        Image llllllllllllllllllIllIlIlIIlllll;
        llllllllllllllllllIllIlIlIIlllll.init();
        return llllllllllllllllllIllIlIlIIlllll.centerY;
    }

    public String getResourceReference() {
        Image llllllllllllllllllIlllIIIIIIlIlI;
        return llllllllllllllllllIlllIIIIIIlIlI.ref;
    }

    public float getAlpha() {
        Image llllllllllllllllllIllIlIIlllIlII;
        return llllllllllllllllllIllIlIIlllIlII.alpha;
    }

    static {
        FILTER_LINEAR = 1;
        TOP_RIGHT = 1;
        FILTER_NEAREST = 2;
        TOP_LEFT = 0;
        BOTTOM_LEFT = 3;
        BOTTOM_RIGHT = 2;
        GL = Renderer.get();
    }

    public void ensureInverted() {
        Image llllllllllllllllllIllIIlIIIllIIl;
        if (llllllllllllllllllIllIIlIIIllIIl.textureHeight > 0.0f) {
            llllllllllllllllllIllIIlIIIllIIl.textureOffsetY += llllllllllllllllllIllIIlIIIllIIl.textureHeight;
            llllllllllllllllllIllIIlIIIllIIl.textureHeight = -llllllllllllllllllIllIIlIIIllIIl.textureHeight;
        }
    }

    public Image(String llllllllllllllllllIlllIIlIIIllII, boolean llllllllllllllllllIlllIIlIIIlIll, int llllllllllllllllllIlllIIlIIIlIlI) throws SlickException {
        llllllllllllllllllIlllIIlIIlIIIl(llllllllllllllllllIlllIIlIIIllII, llllllllllllllllllIlllIIlIIIlIll, llllllllllllllllllIlllIIlIIIlIlI, null);
        Image llllllllllllllllllIlllIIlIIlIIIl;
    }

    public void drawFlash(float llllllllllllllllllIllIlIlIIlIIlI, float llllllllllllllllllIllIlIlIIIlIll, float llllllllllllllllllIllIlIlIIIlIlI, float llllllllllllllllllIllIlIlIIIlIIl, Color llllllllllllllllllIllIlIlIIIlIII) {
        Image llllllllllllllllllIllIlIlIIlIIll;
        llllllllllllllllllIllIlIlIIlIIll.init();
        llllllllllllllllllIllIlIlIIIlIII.bind();
        llllllllllllllllllIllIlIlIIlIIll.texture.bind();
        if (GL.canSecondaryColor()) {
            GL.glEnable(33880);
            GL.glSecondaryColor3ubEXT((byte)(llllllllllllllllllIllIlIlIIIlIII.r * 255.0f), (byte)(llllllllllllllllllIllIlIlIIIlIII.g * 255.0f), (byte)(llllllllllllllllllIllIlIlIIIlIII.b * 255.0f));
        }
        GL.glTexEnvi(8960, 8704, 8448);
        GL.glTranslatef(llllllllllllllllllIllIlIlIIlIIlI, llllllllllllllllllIllIlIlIIIlIll, 0.0f);
        if (llllllllllllllllllIllIlIlIIlIIll.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIlIlIIlIIll.centerX, llllllllllllllllllIllIlIlIIlIIll.centerY, 0.0f);
            GL.glRotatef(llllllllllllllllllIllIlIlIIlIIll.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIlIlIIlIIll.centerX, -llllllllllllllllllIllIlIlIIlIIll.centerY, 0.0f);
        }
        GL.glBegin(7);
        llllllllllllllllllIllIlIlIIlIIll.drawEmbedded(0.0f, 0.0f, llllllllllllllllllIllIlIlIIIlIlI, llllllllllllllllllIllIlIlIIIlIIl);
        GL.glEnd();
        if (llllllllllllllllllIllIlIlIIlIIll.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIlIlIIlIIll.centerX, llllllllllllllllllIllIlIlIIlIIll.centerY, 0.0f);
            GL.glRotatef(-llllllllllllllllllIllIlIlIIlIIll.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIlIlIIlIIll.centerX, -llllllllllllllllllIllIlIlIIlIIll.centerY, 0.0f);
        }
        GL.glTranslatef(-llllllllllllllllllIllIlIlIIlIIlI, -llllllllllllllllllIllIlIlIIIlIll, 0.0f);
        if (GL.canSecondaryColor()) {
            GL.glDisable(33880);
        }
    }

    public Image(Texture llllllllllllllllllIlllIIlIlIlllI) {
        Image llllllllllllllllllIlllIIlIlIllll;
        llllllllllllllllllIlllIIlIlIllll.alpha = 1.0f;
        llllllllllllllllllIlllIIlIlIllll.inited = false;
        llllllllllllllllllIlllIIlIlIllll.filter = 9729;
        llllllllllllllllllIlllIIlIlIllll.texture = llllllllllllllllllIlllIIlIlIlllI;
        llllllllllllllllllIlllIIlIlIllll.ref = llllllllllllllllllIlllIIlIlIlllI.toString();
        llllllllllllllllllIlllIIlIlIllll.clampTexture();
    }

    public void startUse() {
        Image llllllllllllllllllIllIIIllllIIll;
        if (inUse != null) {
            throw new RuntimeException("Attempt to start use of a sprite sheet before ending use with another - see endUse()");
        }
        inUse = llllllllllllllllllIllIIIllllIIll;
        llllllllllllllllllIllIIIllllIIll.init();
        Color.white.bind();
        llllllllllllllllllIllIIIllllIIll.texture.bind();
        GL.glBegin(7);
    }

    public Image getFlippedCopy(boolean llllllllllllllllllIllIIIlllllllI, boolean llllllllllllllllllIllIIlIIIIIIIl) {
        Image llllllllllllllllllIllIIlIIIIIIll;
        llllllllllllllllllIllIIlIIIIIIll.init();
        Image llllllllllllllllllIllIIlIIIIIIII = llllllllllllllllllIllIIlIIIIIIll.copy();
        if (llllllllllllllllllIllIIIlllllllI) {
            llllllllllllllllllIllIIlIIIIIIII.textureOffsetX = llllllllllllllllllIllIIlIIIIIIll.textureOffsetX + llllllllllllllllllIllIIlIIIIIIll.textureWidth;
            llllllllllllllllllIllIIlIIIIIIII.textureWidth = -llllllllllllllllllIllIIlIIIIIIll.textureWidth;
        }
        if (llllllllllllllllllIllIIlIIIIIIIl) {
            llllllllllllllllllIllIIlIIIIIIII.textureOffsetY = llllllllllllllllllIllIIlIIIIIIll.textureOffsetY + llllllllllllllllllIllIIlIIIIIIll.textureHeight;
            llllllllllllllllllIllIIlIIIIIIII.textureHeight = -llllllllllllllllllIllIIlIIIIIIll.textureHeight;
        }
        return llllllllllllllllllIllIIlIIIIIIII;
    }

    public void drawSheared(float llllllllllllllllllIllIlIllllIIlI, float llllllllllllllllllIllIlIlllllIlI, float llllllllllllllllllIllIlIlllllIIl, float llllllllllllllllllIllIlIllllIlll, Color llllllllllllllllllIllIlIlllIllII) {
        Image llllllllllllllllllIllIlIllllllll;
        if (llllllllllllllllllIllIlIllllllll.alpha != 1.0f) {
            if (llllllllllllllllllIllIlIlllIllII == null) {
                llllllllllllllllllIllIlIlllIllII = Color.white;
            }
            llllllllllllllllllIllIlIlllIllII = new Color(llllllllllllllllllIllIlIlllIllII);
            llllllllllllllllllIllIlIlllIllII.a *= llllllllllllllllllIllIlIllllllll.alpha;
        }
        if (llllllllllllllllllIllIlIlllIllII != null) {
            llllllllllllllllllIllIlIlllIllII.bind();
        }
        llllllllllllllllllIllIlIllllllll.texture.bind();
        GL.glTranslatef(llllllllllllllllllIllIlIllllIIlI, llllllllllllllllllIllIlIlllllIlI, 0.0f);
        if (llllllllllllllllllIllIlIllllllll.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIlIllllllll.centerX, llllllllllllllllllIllIlIllllllll.centerY, 0.0f);
            GL.glRotatef(llllllllllllllllllIllIlIllllllll.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIlIllllllll.centerX, -llllllllllllllllllIllIlIllllllll.centerY, 0.0f);
        }
        GL.glBegin(7);
        llllllllllllllllllIllIlIllllllll.init();
        GL.glTexCoord2f(llllllllllllllllllIllIlIllllllll.textureOffsetX, llllllllllllllllllIllIlIllllllll.textureOffsetY);
        GL.glVertex3f(0.0f, 0.0f, 0.0f);
        GL.glTexCoord2f(llllllllllllllllllIllIlIllllllll.textureOffsetX, llllllllllllllllllIllIlIllllllll.textureOffsetY + llllllllllllllllllIllIlIllllllll.textureHeight);
        GL.glVertex3f(llllllllllllllllllIllIlIlllllIIl, llllllllllllllllllIllIlIllllllll.height, 0.0f);
        GL.glTexCoord2f(llllllllllllllllllIllIlIllllllll.textureOffsetX + llllllllllllllllllIllIlIllllllll.textureWidth, llllllllllllllllllIllIlIllllllll.textureOffsetY + llllllllllllllllllIllIlIllllllll.textureHeight);
        GL.glVertex3f((float)llllllllllllllllllIllIlIllllllll.width + llllllllllllllllllIllIlIlllllIIl, (float)llllllllllllllllllIllIlIllllllll.height + llllllllllllllllllIllIlIllllIlll, 0.0f);
        GL.glTexCoord2f(llllllllllllllllllIllIlIllllllll.textureOffsetX + llllllllllllllllllIllIlIllllllll.textureWidth, llllllllllllllllllIllIlIllllllll.textureOffsetY);
        GL.glVertex3f(llllllllllllllllllIllIlIllllllll.width, llllllllllllllllllIllIlIllllIlll, 0.0f);
        GL.glEnd();
        if (llllllllllllllllllIllIlIllllllll.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIlIllllllll.centerX, llllllllllllllllllIllIlIllllllll.centerY, 0.0f);
            GL.glRotatef(-llllllllllllllllllIllIlIllllllll.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIlIllllllll.centerX, -llllllllllllllllllIllIlIllllllll.centerY, 0.0f);
        }
        GL.glTranslatef(-llllllllllllllllllIllIlIllllIIlI, -llllllllllllllllllIllIlIlllllIlI, 0.0f);
    }

    public void drawEmbedded(float llllllllllllllllllIllIIllllIIlII, float llllllllllllllllllIllIIllllIIIll, float llllllllllllllllllIllIIllllIIIlI, float llllllllllllllllllIllIIlllIllIII, float llllllllllllllllllIllIIlllIlIlll, float llllllllllllllllllIllIIlllIlllll, float llllllllllllllllllIllIIlllIlIlIl, float llllllllllllllllllIllIIlllIlIlII) {
        Image llllllllllllllllllIllIIlllIlllII;
        llllllllllllllllllIllIIlllIlllII.drawEmbedded(llllllllllllllllllIllIIllllIIlII, llllllllllllllllllIllIIllllIIIll, llllllllllllllllllIllIIllllIIIlI, llllllllllllllllllIllIIlllIllIII, llllllllllllllllllIllIIlllIlIlll, llllllllllllllllllIllIIlllIlllll, llllllllllllllllllIllIIlllIlIlIl, llllllllllllllllllIllIIlllIlIlII, null);
    }

    public void destroy() throws SlickException {
        Image llllllllllllllllllIllIIIllIIlIll;
        if (llllllllllllllllllIllIIIllIIlIll.isDestroyed()) {
            return;
        }
        llllllllllllllllllIllIIIllIIlIll.destroyed = true;
        llllllllllllllllllIllIIIllIIlIll.texture.release();
        GraphicsFactory.releaseGraphicsForImage(llllllllllllllllllIllIIIllIIlIll);
    }

    public void draw() {
        Image llllllllllllllllllIllIlllIIlllll;
        llllllllllllllllllIllIlllIIlllll.draw(0.0f, 0.0f);
    }

    public void draw(float llllllllllllllllllIllIIlllllllII, float llllllllllllllllllIllIIllllllIll, float llllllllllllllllllIllIlIIIIIIlIl, float llllllllllllllllllIllIIlllllIlll, float llllllllllllllllllIllIlIIIIIIIll, float llllllllllllllllllIllIlIIIIIIIlI, float llllllllllllllllllIllIlIIIIIIIIl, float llllllllllllllllllIllIlIIIIIIIII, Color llllllllllllllllllIllIIlllllIIII) {
        Image llllllllllllllllllIllIIllllllllI;
        llllllllllllllllllIllIIllllllllI.init();
        if (llllllllllllllllllIllIIllllllllI.alpha != 1.0f) {
            if (llllllllllllllllllIllIIlllllIIII == null) {
                llllllllllllllllllIllIIlllllIIII = Color.white;
            }
            llllllllllllllllllIllIIlllllIIII = new Color(llllllllllllllllllIllIIlllllIIII);
            llllllllllllllllllIllIIlllllIIII.a *= llllllllllllllllllIllIIllllllllI.alpha;
        }
        llllllllllllllllllIllIIlllllIIII.bind();
        llllllllllllllllllIllIIllllllllI.texture.bind();
        GL.glTranslatef(llllllllllllllllllIllIIlllllllII, llllllllllllllllllIllIIllllllIll, 0.0f);
        if (llllllllllllllllllIllIIllllllllI.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIIllllllllI.centerX, llllllllllllllllllIllIIllllllllI.centerY, 0.0f);
            GL.glRotatef(llllllllllllllllllIllIIllllllllI.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIIllllllllI.centerX, -llllllllllllllllllIllIIllllllllI.centerY, 0.0f);
        }
        GL.glBegin(7);
        llllllllllllllllllIllIIllllllllI.drawEmbedded(0.0f, 0.0f, llllllllllllllllllIllIlIIIIIIlIl - llllllllllllllllllIllIIlllllllII, llllllllllllllllllIllIIlllllIlll - llllllllllllllllllIllIIllllllIll, llllllllllllllllllIllIlIIIIIIIll, llllllllllllllllllIllIlIIIIIIIlI, llllllllllllllllllIllIlIIIIIIIIl, llllllllllllllllllIllIlIIIIIIIII);
        GL.glEnd();
        if (llllllllllllllllllIllIIllllllllI.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIIllllllllI.centerX, llllllllllllllllllIllIIllllllllI.centerY, 0.0f);
            GL.glRotatef(-llllllllllllllllllIllIIllllllllI.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIIllllllllI.centerX, -llllllllllllllllllIllIIllllllllI.centerY, 0.0f);
        }
        GL.glTranslatef(-llllllllllllllllllIllIIlllllllII, -llllllllllllllllllIllIIllllllIll, 0.0f);
    }

    @Override
    public void draw(float llllllllllllllllllIllIllIIlIIIIl, float llllllllllllllllllIllIllIIlIIIII, float llllllllllllllllllIllIllIIlIIlII, float llllllllllllllllllIllIllIIlIIIll) {
        Image llllllllllllllllllIllIllIIlIIlll;
        llllllllllllllllllIllIllIIlIIlll.init();
        llllllllllllllllllIllIllIIlIIlll.draw(llllllllllllllllllIllIllIIlIIIIl, llllllllllllllllllIllIllIIlIIIII, llllllllllllllllllIllIllIIlIIlII, llllllllllllllllllIllIllIIlIIIll, Color.white);
    }

    public void drawFlash(float llllllllllllllllllIllIlIlIIIIIll, float llllllllllllllllllIllIlIlIIIIIlI) {
        Image llllllllllllllllllIllIlIlIIIIlII;
        llllllllllllllllllIllIlIlIIIIlII.drawFlash(llllllllllllllllllIllIlIlIIIIIll, llllllllllllllllllIllIlIlIIIIIlI, llllllllllllllllllIllIlIlIIIIlII.getWidth(), llllllllllllllllllIllIlIlIIIIlII.getHeight());
    }

    public void drawSheared(float llllllllllllllllllIllIllIIIlIIlI, float llllllllllllllllllIllIllIIIlIllI, float llllllllllllllllllIllIllIIIlIlIl, float llllllllllllllllllIllIllIIIIllll) {
        Image llllllllllllllllllIllIllIIIllIII;
        llllllllllllllllllIllIllIIIllIII.drawSheared(llllllllllllllllllIllIllIIIlIIlI, llllllllllllllllllIllIllIIIlIllI, llllllllllllllllllIllIllIIIlIlIl, llllllllllllllllllIllIllIIIIllll, Color.white);
    }

    public Color getColor(int llllllllllllllllllIllIIIllIllIll, int llllllllllllllllllIllIIIllIllIlI) {
        Image llllllllllllllllllIllIIIllIlIllI;
        if (llllllllllllllllllIllIIIllIlIllI.pixelData == null) {
            llllllllllllllllllIllIIIllIlIllI.pixelData = llllllllllllllllllIllIIIllIlIllI.texture.getTextureData();
        }
        int llllllllllllllllllIllIIIllIllIIl = (int)(llllllllllllllllllIllIIIllIlIllI.textureOffsetX * (float)llllllllllllllllllIllIIIllIlIllI.texture.getTextureWidth());
        int llllllllllllllllllIllIIIllIllIII = (int)(llllllllllllllllllIllIIIllIlIllI.textureOffsetY * (float)llllllllllllllllllIllIIIllIlIllI.texture.getTextureHeight());
        llllllllllllllllllIllIIIllIllIll = llllllllllllllllllIllIIIllIlIllI.textureWidth < 0.0f ? llllllllllllllllllIllIIIllIllIIl - llllllllllllllllllIllIIIllIllIll : llllllllllllllllllIllIIIllIllIIl + llllllllllllllllllIllIIIllIllIll;
        llllllllllllllllllIllIIIllIllIlI = llllllllllllllllllIllIIIllIlIllI.textureHeight < 0.0f ? llllllllllllllllllIllIIIllIllIII - llllllllllllllllllIllIIIllIllIlI : llllllllllllllllllIllIIIllIllIII + llllllllllllllllllIllIIIllIllIlI;
        int llllllllllllllllllIllIIIllIlIlll = (llllllllllllllllllIllIIIllIllIll %= llllllllllllllllllIllIIIllIlIllI.texture.getTextureWidth()) + (llllllllllllllllllIllIIIllIllIlI %= llllllllllllllllllIllIIIllIlIllI.texture.getTextureHeight()) * llllllllllllllllllIllIIIllIlIllI.texture.getTextureWidth();
        llllllllllllllllllIllIIIllIlIlll *= llllllllllllllllllIllIIIllIlIllI.texture.hasAlpha() ? 4 : 3;
        if (llllllllllllllllllIllIIIllIlIllI.texture.hasAlpha()) {
            return new Color(llllllllllllllllllIllIIIllIlIllI.translate(llllllllllllllllllIllIIIllIlIllI.pixelData[llllllllllllllllllIllIIIllIlIlll]), llllllllllllllllllIllIIIllIlIllI.translate(llllllllllllllllllIllIIIllIlIllI.pixelData[llllllllllllllllllIllIIIllIlIlll + 1]), llllllllllllllllllIllIIIllIlIllI.translate(llllllllllllllllllIllIIIllIlIllI.pixelData[llllllllllllllllllIllIIIllIlIlll + 2]), llllllllllllllllllIllIIIllIlIllI.translate(llllllllllllllllllIllIIIllIlIllI.pixelData[llllllllllllllllllIllIIIllIlIlll + 3]));
        }
        return new Color(llllllllllllllllllIllIIIllIlIllI.translate(llllllllllllllllllIllIIIllIlIllI.pixelData[llllllllllllllllllIllIIIllIlIlll]), llllllllllllllllllIllIIIllIlIllI.translate(llllllllllllllllllIllIIIllIlIllI.pixelData[llllllllllllllllllIllIIIllIlIlll + 1]), llllllllllllllllllIllIIIllIlIllI.translate(llllllllllllllllllIllIIIllIlIllI.pixelData[llllllllllllllllllIllIIIllIlIlll + 2]));
    }

    public void draw(float llllllllllllllllllIllIllIIllIIII, float llllllllllllllllllIllIllIIllIlII, float llllllllllllllllllIllIllIIllIIll, Color llllllllllllllllllIllIllIIllIIlI) {
        Image llllllllllllllllllIllIllIIllIllI;
        llllllllllllllllllIllIllIIllIllI.init();
        llllllllllllllllllIllIllIIllIllI.draw(llllllllllllllllllIllIllIIllIIII, llllllllllllllllllIllIllIIllIlII, (float)llllllllllllllllllIllIllIIllIllI.width * llllllllllllllllllIllIllIIllIIll, (float)llllllllllllllllllIllIllIIllIllI.height * llllllllllllllllllIllIllIIllIIll, llllllllllllllllllIllIllIIllIIlI);
    }

    public void drawWarped(float llllllllllllllllllIllIIlIlIllIlI, float llllllllllllllllllIllIIlIlIllIIl, float llllllllllllllllllIllIIlIlIIllll, float llllllllllllllllllIllIIlIlIlIlll, float llllllllllllllllllIllIIlIlIIllII, float llllllllllllllllllIllIIlIlIlIlIl, float llllllllllllllllllIllIIlIlIlIlII, float llllllllllllllllllIllIIlIlIlIIll) {
        Image llllllllllllllllllIllIIlIlIllIll;
        Color.white.bind();
        llllllllllllllllllIllIIlIlIllIll.texture.bind();
        GL.glTranslatef(llllllllllllllllllIllIIlIlIllIlI, llllllllllllllllllIllIIlIlIllIIl, 0.0f);
        if (llllllllllllllllllIllIIlIlIllIll.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIIlIlIllIll.centerX, llllllllllllllllllIllIIlIlIllIll.centerY, 0.0f);
            GL.glRotatef(llllllllllllllllllIllIIlIlIllIll.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIIlIlIllIll.centerX, -llllllllllllllllllIllIIlIlIllIll.centerY, 0.0f);
        }
        GL.glBegin(7);
        llllllllllllllllllIllIIlIlIllIll.init();
        GL.glTexCoord2f(llllllllllllllllllIllIIlIlIllIll.textureOffsetX, llllllllllllllllllIllIIlIlIllIll.textureOffsetY);
        GL.glVertex3f(0.0f, 0.0f, 0.0f);
        GL.glTexCoord2f(llllllllllllllllllIllIIlIlIllIll.textureOffsetX, llllllllllllllllllIllIIlIlIllIll.textureOffsetY + llllllllllllllllllIllIIlIlIllIll.textureHeight);
        GL.glVertex3f(llllllllllllllllllIllIIlIlIIllll - llllllllllllllllllIllIIlIlIllIlI, llllllllllllllllllIllIIlIlIlIlll - llllllllllllllllllIllIIlIlIllIIl, 0.0f);
        GL.glTexCoord2f(llllllllllllllllllIllIIlIlIllIll.textureOffsetX + llllllllllllllllllIllIIlIlIllIll.textureWidth, llllllllllllllllllIllIIlIlIllIll.textureOffsetY + llllllllllllllllllIllIIlIlIllIll.textureHeight);
        GL.glVertex3f(llllllllllllllllllIllIIlIlIIllII - llllllllllllllllllIllIIlIlIllIlI, llllllllllllllllllIllIIlIlIlIlIl - llllllllllllllllllIllIIlIlIllIIl, 0.0f);
        GL.glTexCoord2f(llllllllllllllllllIllIIlIlIllIll.textureOffsetX + llllllllllllllllllIllIIlIlIllIll.textureWidth, llllllllllllllllllIllIIlIlIllIll.textureOffsetY);
        GL.glVertex3f(llllllllllllllllllIllIIlIlIlIlII - llllllllllllllllllIllIIlIlIllIlI, llllllllllllllllllIllIIlIlIlIIll - llllllllllllllllllIllIIlIlIllIIl, 0.0f);
        GL.glEnd();
        if (llllllllllllllllllIllIIlIlIllIll.angle != 0.0f) {
            GL.glTranslatef(llllllllllllllllllIllIIlIlIllIll.centerX, llllllllllllllllllIllIIlIlIllIll.centerY, 0.0f);
            GL.glRotatef(-llllllllllllllllllIllIIlIlIllIll.angle, 0.0f, 0.0f, 1.0f);
            GL.glTranslatef(-llllllllllllllllllIllIIlIlIllIll.centerX, -llllllllllllllllllIllIIlIlIllIll.centerY, 0.0f);
        }
        GL.glTranslatef(-llllllllllllllllllIllIIlIlIllIlI, -llllllllllllllllllIllIIlIlIllIIl, 0.0f);
    }

    public void setAlpha(float llllllllllllllllllIllIlIIllIllll) {
        llllllllllllllllllIllIlIIlllIIII.alpha = llllllllllllllllllIllIlIIllIllll;
    }

    public Image(InputStream llllllllllllllllllIlllIIIlIIllII, String llllllllllllllllllIlllIIIlIIIlIl, boolean llllllllllllllllllIlllIIIlIIIlII) throws SlickException {
        llllllllllllllllllIlllIIIlIIlllI(llllllllllllllllllIlllIIIlIIllII, llllllllllllllllllIlllIIIlIIIlIl, llllllllllllllllllIlllIIIlIIIlII, 1);
        Image llllllllllllllllllIlllIIIlIIlllI;
    }

    public float getTextureHeight() {
        Image llllllllllllllllllIllIllIlIIlIIl;
        llllllllllllllllllIllIllIlIIlIIl.init();
        return llllllllllllllllllIllIllIlIIlIIl.textureHeight;
    }

    public Graphics getGraphics() throws SlickException {
        Image llllllllllllllllllIllIllllIIIIIl;
        return GraphicsFactory.getGraphicsForImage(llllllllllllllllllIllIllllIIIIIl);
    }

    public float getRotation() {
        Image llllllllllllllllllIllIlIIlllIlll;
        return llllllllllllllllllIllIlIIlllIlll.angle;
    }

    Image(ImageBuffer llllllllllllllllllIlllIIIIlIIllI, int llllllllllllllllllIlllIIIIlIIIlI) {
        llllllllllllllllllIlllIIIIlIIlII((ImageData)llllllllllllllllllIlllIIIIlIIllI, llllllllllllllllllIlllIIIIlIIIlI);
        Image llllllllllllllllllIlllIIIIlIIlII;
        TextureImpl.bindNone();
    }

    public void draw(float llllllllllllllllllIllIlIIIlIlIIl, float llllllllllllllllllIllIlIIIlIlIII, float llllllllllllllllllIllIlIIIIllllI, float llllllllllllllllllIllIlIIIIlllIl, float llllllllllllllllllIllIlIIIlIIlIl, float llllllllllllllllllIllIlIIIlIIlII, float llllllllllllllllllIllIlIIIIllIlI, float llllllllllllllllllIllIlIIIIllIIl) {
        Image llllllllllllllllllIllIlIIIlIlIlI;
        llllllllllllllllllIllIlIIIlIlIlI.draw(llllllllllllllllllIllIlIIIlIlIIl, llllllllllllllllllIllIlIIIlIlIII, llllllllllllllllllIllIlIIIIllllI, llllllllllllllllllIllIlIIIIlllIl, llllllllllllllllllIllIlIIIlIIlIl, llllllllllllllllllIllIlIIIlIIlII, llllllllllllllllllIllIlIIIIllIlI, llllllllllllllllllIllIlIIIIllIIl, Color.white);
    }

    @Override
    public void draw(float llllllllllllllllllIllIlllIIIllIl, float llllllllllllllllllIllIlllIIIlIIl) {
        Image llllllllllllllllllIllIlllIIIllll;
        llllllllllllllllllIllIlllIIIllll.init();
        llllllllllllllllllIllIlllIIIllll.draw(llllllllllllllllllIllIlllIIIllIl, llllllllllllllllllIllIlllIIIlIIl, (float)llllllllllllllllllIllIlllIIIllll.width, llllllllllllllllllIllIlllIIIllll.height);
    }

    public void setName(String llllllllllllllllllIllIllllIIIlll) {
        llllllllllllllllllIllIllllIIlIII.name = llllllllllllllllllIllIllllIIIlll;
    }

    public boolean isDestroyed() {
        Image llllllllllllllllllIllIIIllIIllll;
        return llllllllllllllllllIllIIIllIIllll.destroyed;
    }

    protected Image(Image llllllllllllllllllIlllIIlIllIlll) {
        Image llllllllllllllllllIlllIIlIlllIlI;
        llllllllllllllllllIlllIIlIlllIlI.alpha = 1.0f;
        llllllllllllllllllIlllIIlIlllIlI.inited = false;
        llllllllllllllllllIlllIIlIlllIlI.filter = 9729;
        llllllllllllllllllIlllIIlIlllIlI.width = llllllllllllllllllIlllIIlIllIlll.getWidth();
        llllllllllllllllllIlllIIlIlllIlI.height = llllllllllllllllllIlllIIlIllIlll.getHeight();
        llllllllllllllllllIlllIIlIlllIlI.texture = llllllllllllllllllIlllIIlIllIlll.texture;
        llllllllllllllllllIlllIIlIlllIlI.textureWidth = llllllllllllllllllIlllIIlIllIlll.textureWidth;
        llllllllllllllllllIlllIIlIlllIlI.textureHeight = llllllllllllllllllIlllIIlIllIlll.textureHeight;
        llllllllllllllllllIlllIIlIlllIlI.ref = llllllllllllllllllIlllIIlIllIlll.ref;
        llllllllllllllllllIlllIIlIlllIlI.textureOffsetX = llllllllllllllllllIlllIIlIllIlll.textureOffsetX;
        llllllllllllllllllIlllIIlIlllIlI.textureOffsetY = llllllllllllllllllIlllIIlIllIlll.textureOffsetY;
        llllllllllllllllllIlllIIlIlllIlI.centerX = llllllllllllllllllIlllIIlIlllIlI.width / 2;
        llllllllllllllllllIlllIIlIlllIlI.centerY = llllllllllllllllllIlllIIlIlllIlI.height / 2;
        llllllllllllllllllIlllIIlIlllIlI.inited = true;
    }

    Image(ImageBuffer llllllllllllllllllIlllIIIIlIllIl) {
        llllllllllllllllllIlllIIIIlIllII(llllllllllllllllllIlllIIIIlIllIl, 1);
        Image llllllllllllllllllIlllIIIIlIllII;
        TextureImpl.bindNone();
    }

    public void drawFlash(float llllllllllllllllllIllIlIllIIIIII, float llllllllllllllllllIllIlIlIllllll, float llllllllllllllllllIllIlIlIlllIIl, float llllllllllllllllllIllIlIlIlllIII) {
        Image llllllllllllllllllIllIlIlIllllII;
        llllllllllllllllllIllIlIlIllllII.drawFlash(llllllllllllllllllIllIlIllIIIIII, llllllllllllllllllIllIlIlIllllll, llllllllllllllllllIllIlIlIlllIIl, llllllllllllllllllIllIlIlIlllIII, Color.white);
    }

    public Image getScaledCopy(int llllllllllllllllllIllIIlIIlIIlII, int llllllllllllllllllIllIIlIIlIlIII) {
        Image llllllllllllllllllIllIIlIIlIlIlI;
        llllllllllllllllllIllIIlIIlIlIlI.init();
        Image llllllllllllllllllIllIIlIIlIIlll = llllllllllllllllllIllIIlIIlIlIlI.copy();
        llllllllllllllllllIllIIlIIlIIlll.width = llllllllllllllllllIllIIlIIlIIlII;
        llllllllllllllllllIllIIlIIlIIlll.height = llllllllllllllllllIllIIlIIlIlIII;
        llllllllllllllllllIllIIlIIlIIlll.centerX = llllllllllllllllllIllIIlIIlIIlII / 2;
        llllllllllllllllllIllIIlIIlIIlll.centerY = llllllllllllllllllIllIIlIIlIlIII / 2;
        llllllllllllllllllIllIIlIIlIIlll.textureOffsetX *= (float)llllllllllllllllllIllIIlIIlIIlII / (float)llllllllllllllllllIllIIlIIlIlIlI.width;
        llllllllllllllllllIllIIlIIlIIlll.textureOffsetY *= (float)llllllllllllllllllIllIIlIIlIlIII / (float)llllllllllllllllllIllIIlIIlIlIlI.height;
        llllllllllllllllllIllIIlIIlIIlll.textureWidth *= (float)llllllllllllllllllIllIIlIIlIIlII / (float)llllllllllllllllllIllIIlIIlIlIlI.width;
        llllllllllllllllllIllIIlIIlIIlll.textureHeight *= (float)llllllllllllllllllIllIIlIIlIlIII / (float)llllllllllllllllllIllIIlIIlIlIlI.height;
        return llllllllllllllllllIllIIlIIlIIlll;
    }

    public String getName() {
        Image llllllllllllllllllIllIllllIIIlII;
        return llllllllllllllllllIllIllllIIIlII.name;
    }

    protected Image() {
        Image llllllllllllllllllIlllIIlIllIlII;
        llllllllllllllllllIlllIIlIllIlII.alpha = 1.0f;
        llllllllllllllllllIlllIIlIllIlII.inited = false;
        llllllllllllllllllIlllIIlIllIlII.filter = 9729;
    }

    public void setRotation(float llllllllllllllllllIllIlIIllllIIl) {
        llllllllllllllllllIllIlIIlllllII.angle = llllllllllllllllllIllIlIIllllIIl % 360.0f;
    }

    public float getTextureOffsetY() {
        Image llllllllllllllllllIllIllIlIlIIll;
        llllllllllllllllllIllIllIlIlIIll.init();
        return llllllllllllllllllIllIllIlIlIIll.textureOffsetY;
    }

    public void endUse() {
        Image llllllllllllllllllIllIIIllllIlll;
        if (inUse != llllllllllllllllllIllIIIllllIlll) {
            throw new RuntimeException("The sprite sheet is not currently in use");
        }
        inUse = null;
        GL.glEnd();
    }

    public void setColor(int llllllllllllllllllIllIllllIlIIIl, float llllllllllllllllllIllIllllIlIlIl, float llllllllllllllllllIllIllllIIllll, float llllllllllllllllllIllIllllIlIIll) {
        Image llllllllllllllllllIllIllllIlIlll;
        if (llllllllllllllllllIllIllllIlIlll.corners == null) {
            llllllllllllllllllIllIllllIlIlll.corners = new Color[]{new Color(1.0f, 1.0f, 1.0f, 1.0f), new Color(1.0f, 1.0f, 1.0f, 1.0f), new Color(1.0f, 1.0f, 1.0f, 1.0f), new Color(1.0f, 1.0f, 1.0f, 1.0f)};
        }
        llllllllllllllllllIllIllllIlIlll.corners[llllllllllllllllllIllIllllIlIIIl].r = llllllllllllllllllIllIllllIlIlIl;
        llllllllllllllllllIllIllllIlIlll.corners[llllllllllllllllllIllIllllIlIIIl].g = llllllllllllllllllIllIllllIIllll;
        llllllllllllllllllIllIllllIlIlll.corners[llllllllllllllllllIllIllllIlIIIl].b = llllllllllllllllllIllIllllIlIIll;
    }

    public Image(String llllllllllllllllllIlllIIlIIIIIII, boolean llllllllllllllllllIlllIIIllllIlI, int llllllllllllllllllIlllIIIllllIIl, Color llllllllllllllllllIlllIIIllllIII) throws SlickException {
        Image llllllllllllllllllIlllIIIlllllII;
        llllllllllllllllllIlllIIIlllllII.alpha = 1.0f;
        llllllllllllllllllIlllIIIlllllII.inited = false;
        llllllllllllllllllIlllIIIlllllII.filter = 9729;
        llllllllllllllllllIlllIIIlllllII.filter = llllllllllllllllllIlllIIIllllIIl == 1 ? 9729 : 9728;
        llllllllllllllllllIlllIIIlllllII.transparent = llllllllllllllllllIlllIIIllllIII;
        llllllllllllllllllIlllIIIlllllII.flipped = llllllllllllllllllIlllIIIllllIlI;
        try {
            llllllllllllllllllIlllIIIlllllII.ref = llllllllllllllllllIlllIIlIIIIIII;
            int[] llllllllllllllllllIlllIIlIIIIIll = null;
            if (llllllllllllllllllIlllIIIllllIII != null) {
                llllllllllllllllllIlllIIlIIIIIll = new int[]{(int)(llllllllllllllllllIlllIIIllllIII.r * 255.0f), (int)(llllllllllllllllllIlllIIIllllIII.g * 255.0f), (int)(llllllllllllllllllIlllIIIllllIII.b * 255.0f)};
            }
            llllllllllllllllllIlllIIIlllllII.texture = InternalTextureLoader.get().getTexture(llllllllllllllllllIlllIIlIIIIIII, llllllllllllllllllIlllIIIllllIlI, llllllllllllllllllIlllIIIlllllII.filter, llllllllllllllllllIlllIIlIIIIIll);
        }
        catch (IOException llllllllllllllllllIlllIIlIIIIIlI) {
            Log.error(llllllllllllllllllIlllIIlIIIIIlI);
            throw new SlickException(String.valueOf(new StringBuilder().append("Failed to load image from: ").append(llllllllllllllllllIlllIIlIIIIIII)), llllllllllllllllllIlllIIlIIIIIlI);
        }
    }

    public float getCenterOfRotationX() {
        Image llllllllllllllllllIllIlIlIlIIlIl;
        llllllllllllllllllIllIlIlIlIIlIl.init();
        return llllllllllllllllllIllIlIlIlIIlIl.centerX;
    }

    public int getWidth() {
        Image llllllllllllllllllIllIIlIlIIIIll;
        llllllllllllllllllIllIIlIlIIIIll.init();
        return llllllllllllllllllIllIIlIlIIIIll.width;
    }

    public void bind() {
        Image llllllllllllllllllIllIlllIlIlIII;
        llllllllllllllllllIllIlllIlIlIII.texture.bind();
    }

    public float getTextureWidth() {
        Image llllllllllllllllllIllIllIlIIllIl;
        llllllllllllllllllIllIllIlIIllIl.init();
        return llllllllllllllllllIllIllIlIIllIl.textureWidth;
    }

    private int translate(byte llllllllllllllllllIllIIIlllIIIll) {
        if (llllllllllllllllllIllIIIlllIIIll < 0) {
            return 256 + llllllllllllllllllIllIIIlllIIIll;
        }
        return llllllllllllllllllIllIIIlllIIIll;
    }

    public Image(int llllllllllllllllllIlllIIIllIlIIl, int llllllllllllllllllIlllIIIllIlIll) throws SlickException {
        llllllllllllllllllIlllIIIllIllIl(llllllllllllllllllIlllIIIllIlIIl, llllllllllllllllllIlllIIIllIlIll, 2);
        Image llllllllllllllllllIlllIIIllIllIl;
    }

    public Image(InputStream llllllllllllllllllIlllIIIIllIlII, String llllllllllllllllllIlllIIIIllIIll, boolean llllllllllllllllllIlllIIIIllIIlI, int llllllllllllllllllIlllIIIIllIllI) throws SlickException {
        Image llllllllllllllllllIlllIIIIllIlIl;
        llllllllllllllllllIlllIIIIllIlIl.alpha = 1.0f;
        llllllllllllllllllIlllIIIIllIlIl.inited = false;
        llllllllllllllllllIlllIIIIllIlIl.filter = 9729;
        llllllllllllllllllIlllIIIIllIlIl.load(llllllllllllllllllIlllIIIIllIlII, llllllllllllllllllIlllIIIIllIIll, llllllllllllllllllIlllIIIIllIIlI, llllllllllllllllllIlllIIIIllIllI, null);
    }

    public void setColor(int llllllllllllllllllIllIlllllIIlll, float llllllllllllllllllIllIlllllIIIII, float llllllllllllllllllIllIlllllIIlIl, float llllllllllllllllllIllIlllllIIlII, float llllllllllllllllllIllIllllIlllIl) {
        Image llllllllllllllllllIllIlllllIlIII;
        if (llllllllllllllllllIllIlllllIlIII.corners == null) {
            llllllllllllllllllIllIlllllIlIII.corners = new Color[]{new Color(1.0f, 1.0f, 1.0f, 1.0f), new Color(1.0f, 1.0f, 1.0f, 1.0f), new Color(1.0f, 1.0f, 1.0f, 1.0f), new Color(1.0f, 1.0f, 1.0f, 1.0f)};
        }
        llllllllllllllllllIllIlllllIlIII.corners[llllllllllllllllllIllIlllllIIlll].r = llllllllllllllllllIllIlllllIIIII;
        llllllllllllllllllIllIlllllIlIII.corners[llllllllllllllllllIllIlllllIIlll].g = llllllllllllllllllIllIlllllIIlIl;
        llllllllllllllllllIllIlllllIlIII.corners[llllllllllllllllllIllIlllllIIlll].b = llllllllllllllllllIllIlllllIIlII;
        llllllllllllllllllIllIlllllIlIII.corners[llllllllllllllllllIllIlllllIIlll].a = llllllllllllllllllIllIllllIlllIl;
    }

    public Image(ImageData llllllllllllllllllIlllIIIIIllllI) {
        llllllllllllllllllIlllIIIIIlllll(llllllllllllllllllIlllIIIIIllllI, 1);
        Image llllllllllllllllllIlllIIIIIlllll;
    }

    public Image copy() {
        Image llllllllllllllllllIllIIlIIllIllI;
        llllllllllllllllllIllIIlIIllIllI.init();
        return llllllllllllllllllIllIIlIIllIllI.getSubImage(0, 0, llllllllllllllllllIllIIlIIllIllI.width, llllllllllllllllllIllIIlIIllIllI.height);
    }

    public Image(String llllllllllllllllllIlllIIlIIllIlI, boolean llllllllllllllllllIlllIIlIIlIllI) throws SlickException {
        llllllllllllllllllIlllIIlIIllIII(llllllllllllllllllIlllIIlIIllIlI, llllllllllllllllllIlllIIlIIlIllI, 1);
        Image llllllllllllllllllIlllIIlIIllIII;
    }

    public void rotate(float llllllllllllllllllIllIlIIllIIlll) {
        llllllllllllllllllIllIlIIllIlIlI.angle += llllllllllllllllllIllIlIIllIIlll;
        llllllllllllllllllIllIlIIllIlIlI.angle %= 360.0f;
    }

    public void flushPixelData() {
        llllllllllllllllllIllIIIllIIlIIl.pixelData = null;
    }

    public Image(ImageData llllllllllllllllllIlllIIIIIlIlIl, int llllllllllllllllllIlllIIIIIlIIIl) {
        Image llllllllllllllllllIlllIIIIIlIIll;
        llllllllllllllllllIlllIIIIIlIIll.alpha = 1.0f;
        llllllllllllllllllIlllIIIIIlIIll.inited = false;
        llllllllllllllllllIlllIIIIIlIIll.filter = 9729;
        try {
            llllllllllllllllllIlllIIIIIlIIll.filter = llllllllllllllllllIlllIIIIIlIIIl == 1 ? 9729 : 9728;
            llllllllllllllllllIlllIIIIIlIIll.texture = InternalTextureLoader.get().getTexture(llllllllllllllllllIlllIIIIIlIlIl, llllllllllllllllllIlllIIIIIlIIll.filter);
            llllllllllllllllllIlllIIIIIlIIll.ref = llllllllllllllllllIlllIIIIIlIIll.texture.toString();
        }
        catch (IOException llllllllllllllllllIlllIIIIIlIlll) {
            Log.error(llllllllllllllllllIlllIIIIIlIlll);
        }
    }

    public void drawEmbedded(float llllllllllllllllllIllIIllIIIIllI, float llllllllllllllllllIllIIllIIIIlIl, float llllllllllllllllllIllIIllIIIIlII, float llllllllllllllllllIllIIllIIllIIl, float llllllllllllllllllIllIIllIIlIlll, float llllllllllllllllllIllIIllIIlIlIl, float llllllllllllllllllIllIIllIIlIlII, float llllllllllllllllllIllIIllIIlIIlI, Color llllllllllllllllllIllIIllIIlIIII) {
        Image llllllllllllllllllIllIIllIlIIIII;
        if (llllllllllllllllllIllIIllIIlIIII != null) {
            llllllllllllllllllIllIIllIIlIIII.bind();
        }
        float llllllllllllllllllIllIIllIIIllll = llllllllllllllllllIllIIllIIIIlII - llllllllllllllllllIllIIllIIIIllI;
        float llllllllllllllllllIllIIllIIIlllI = llllllllllllllllllIllIIllIIllIIl - llllllllllllllllllIllIIllIIIIlIl;
        float llllllllllllllllllIllIIllIIIllIl = llllllllllllllllllIllIIllIIlIlII - llllllllllllllllllIllIIllIIlIlll;
        float llllllllllllllllllIllIIllIIIllII = llllllllllllllllllIllIIllIIlIIlI - llllllllllllllllllIllIIllIIlIlIl;
        float llllllllllllllllllIllIIllIIIlIll = llllllllllllllllllIllIIllIIlIlll / (float)llllllllllllllllllIllIIllIlIIIII.width * llllllllllllllllllIllIIllIlIIIII.textureWidth + llllllllllllllllllIllIIllIlIIIII.textureOffsetX;
        float llllllllllllllllllIllIIllIIIlIlI = llllllllllllllllllIllIIllIIlIlIl / (float)llllllllllllllllllIllIIllIlIIIII.height * llllllllllllllllllIllIIllIlIIIII.textureHeight + llllllllllllllllllIllIIllIlIIIII.textureOffsetY;
        float llllllllllllllllllIllIIllIIIlIIl = llllllllllllllllllIllIIllIIIllIl / (float)llllllllllllllllllIllIIllIlIIIII.width * llllllllllllllllllIllIIllIlIIIII.textureWidth;
        float llllllllllllllllllIllIIllIIIlIII = llllllllllllllllllIllIIllIIIllII / (float)llllllllllllllllllIllIIllIlIIIII.height * llllllllllllllllllIllIIllIlIIIII.textureHeight;
        GL.glTexCoord2f(llllllllllllllllllIllIIllIIIlIll, llllllllllllllllllIllIIllIIIlIlI);
        GL.glVertex3f(llllllllllllllllllIllIIllIIIIllI, llllllllllllllllllIllIIllIIIIlIl, 0.0f);
        GL.glTexCoord2f(llllllllllllllllllIllIIllIIIlIll, llllllllllllllllllIllIIllIIIlIlI + llllllllllllllllllIllIIllIIIlIII);
        GL.glVertex3f(llllllllllllllllllIllIIllIIIIllI, llllllllllllllllllIllIIllIIIIlIl + llllllllllllllllllIllIIllIIIlllI, 0.0f);
        GL.glTexCoord2f(llllllllllllllllllIllIIllIIIlIll + llllllllllllllllllIllIIllIIIlIIl, llllllllllllllllllIllIIllIIIlIlI + llllllllllllllllllIllIIllIIIlIII);
        GL.glVertex3f(llllllllllllllllllIllIIllIIIIllI + llllllllllllllllllIllIIllIIIllll, llllllllllllllllllIllIIllIIIIlIl + llllllllllllllllllIllIIllIIIlllI, 0.0f);
        GL.glTexCoord2f(llllllllllllllllllIllIIllIIIlIll + llllllllllllllllllIllIIllIIIlIIl, llllllllllllllllllIllIIllIIIlIlI);
        GL.glVertex3f(llllllllllllllllllIllIIllIIIIllI + llllllllllllllllllIllIIllIIIllll, llllllllllllllllllIllIIllIIIIlIl, 0.0f);
    }

    public Image(int llllllllllllllllllIlllIIIllIIIII, int llllllllllllllllllIlllIIIlIlllll, int llllllllllllllllllIlllIIIlIllllI) throws SlickException {
        Image llllllllllllllllllIlllIIIlIlllIl;
        llllllllllllllllllIlllIIIlIlllIl.alpha = 1.0f;
        llllllllllllllllllIlllIIIlIlllIl.inited = false;
        llllllllllllllllllIlllIIIlIlllIl.filter = 9729;
        llllllllllllllllllIlllIIIlIlllIl.ref = super.toString();
        llllllllllllllllllIlllIIIlIlllIl.filter = llllllllllllllllllIlllIIIlIllllI == 1 ? 9729 : 9728;
        try {
            llllllllllllllllllIlllIIIlIlllIl.texture = InternalTextureLoader.get().createTexture(llllllllllllllllllIlllIIIllIIIII, llllllllllllllllllIlllIIIlIlllll, llllllllllllllllllIlllIIIlIlllIl.filter);
        }
        catch (IOException llllllllllllllllllIlllIIIllIIIlI) {
            Log.error(llllllllllllllllllIlllIIIllIIIlI);
            throw new SlickException(String.valueOf(new StringBuilder().append("Failed to create empty image ").append(llllllllllllllllllIlllIIIllIIIII).append("x").append(llllllllllllllllllIlllIIIlIlllll)));
        }
        llllllllllllllllllIlllIIIlIlllIl.init();
    }

    public int getHeight() {
        Image llllllllllllllllllIllIIlIIlllllI;
        llllllllllllllllllIllIIlIIlllllI.init();
        return llllllllllllllllllIllIIlIIlllllI.height;
    }
}

