/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.newdawn.slick.opengl.ImageIOImageData;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.Renderer;

public class BufferedImageUtil {
    public static Texture getTexture(String lIIIIllIIllIl, BufferedImage lIIIIllIIllII, int lIIIIlIllllll, int lIIIIlIlllllI, int lIIIIlIllllIl, int lIIIIlIllllII) throws IOException {
        ImageIOImageData lIIIIllIIIlll = new ImageIOImageData();
        int lIIIIllIIIllI = 0;
        int lIIIIllIIIlIl = InternalTextureLoader.createTextureID();
        TextureImpl lIIIIllIIIlII = new TextureImpl(lIIIIllIIllIl, lIIIIlIllllll, lIIIIllIIIlIl);
        Renderer.get().glEnable(3553);
        Renderer.get().glBindTexture(lIIIIlIllllll, lIIIIllIIIlIl);
        BufferedImage lIIIIllIIIIll = lIIIIllIIllII;
        lIIIIllIIIlII.setWidth(lIIIIllIIIIll.getWidth());
        lIIIIllIIIlII.setHeight(lIIIIllIIIIll.getHeight());
        lIIIIllIIIllI = lIIIIllIIIIll.getColorModel().hasAlpha() ? 6408 : 6407;
        ByteBuffer lIIIIllIIIIlI = lIIIIllIIIlll.imageToByteBuffer(lIIIIllIIIIll, false, false, null);
        lIIIIllIIIlII.setTextureHeight(lIIIIllIIIlll.getTexHeight());
        lIIIIllIIIlII.setTextureWidth(lIIIIllIIIlll.getTexWidth());
        lIIIIllIIIlII.setAlpha(lIIIIllIIIlll.getDepth() == 32);
        if (lIIIIlIllllll == 3553) {
            Renderer.get().glTexParameteri(lIIIIlIllllll, 10241, lIIIIlIllllIl);
            Renderer.get().glTexParameteri(lIIIIlIllllll, 10240, lIIIIlIllllII);
            if (Renderer.get().canTextureMirrorClamp()) {
                Renderer.get().glTexParameteri(3553, 10242, 34627);
                Renderer.get().glTexParameteri(3553, 10243, 34627);
            } else {
                Renderer.get().glTexParameteri(3553, 10242, 10496);
                Renderer.get().glTexParameteri(3553, 10243, 10496);
            }
        }
        Renderer.get().glTexImage2D(lIIIIlIllllll, 0, lIIIIlIlllllI, lIIIIllIIIlII.getTextureWidth(), lIIIIllIIIlII.getTextureHeight(), 0, lIIIIllIIIllI, 5121, lIIIIllIIIIlI);
        return lIIIIllIIIlII;
    }

    private static void copyArea(BufferedImage lIIIIlIlIIlIl, int lIIIIlIlIllII, int lIIIIlIlIlIll, int lIIIIlIlIIIlI, int lIIIIlIlIIIIl, int lIIIIlIlIIIII, int lIIIIlIlIIlll) {
        Graphics2D lIIIIlIlIIllI = (Graphics2D)lIIIIlIlIIlIl.getGraphics();
        lIIIIlIlIIllI.drawImage((Image)lIIIIlIlIIlIl.getSubimage(lIIIIlIlIllII, lIIIIlIlIlIll, lIIIIlIlIIIlI, lIIIIlIlIIIIl), lIIIIlIlIllII + lIIIIlIlIIIII, lIIIIlIlIlIll + lIIIIlIlIIlll, null);
    }

    public BufferedImageUtil() {
        BufferedImageUtil lIIIIllllIIII;
    }

    public static Texture getTexture(String lIIIIllIlllIl, BufferedImage lIIIIllIlllII, int lIIIIllIllIll) throws IOException {
        Texture lIIIIllIllllI = BufferedImageUtil.getTexture(lIIIIllIlllIl, lIIIIllIlllII, 3553, 6408, lIIIIllIllIll, lIIIIllIllIll);
        return lIIIIllIllllI;
    }

    public static Texture getTexture(String lIIIIlllIlIII, BufferedImage lIIIIlllIIlll) throws IOException {
        Texture lIIIIlllIlIIl = BufferedImageUtil.getTexture(lIIIIlllIlIII, lIIIIlllIIlll, 3553, 6408, 9729, 9729);
        return lIIIIlllIlIIl;
    }
}

