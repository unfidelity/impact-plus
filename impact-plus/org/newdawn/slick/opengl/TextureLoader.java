/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl;

import java.io.IOException;
import java.io.InputStream;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.Texture;

public class TextureLoader {
    public static Texture getTexture(String llllllllllllllllIlIlIlIllIIlIllI, InputStream llllllllllllllllIlIlIlIllIIlIIll) throws IOException {
        return TextureLoader.getTexture(llllllllllllllllIlIlIlIllIIlIllI, llllllllllllllllIlIlIlIllIIlIIll, false, 9729);
    }

    public static Texture getTexture(String llllllllllllllllIlIlIlIlIllllIII, InputStream llllllllllllllllIlIlIlIlIlllIlll, boolean llllllllllllllllIlIlIlIlIlllIllI, int llllllllllllllllIlIlIlIlIlllIlIl) throws IOException {
        return InternalTextureLoader.get().getTexture(llllllllllllllllIlIlIlIlIlllIlll, String.valueOf(new StringBuilder().append(llllllllllllllllIlIlIlIlIlllIlll.toString()).append(".").append(llllllllllllllllIlIlIlIlIllllIII)), llllllllllllllllIlIlIlIlIlllIllI, llllllllllllllllIlIlIlIlIlllIlIl);
    }

    public static Texture getTexture(String llllllllllllllllIlIlIlIllIIIIIll, InputStream llllllllllllllllIlIlIlIllIIIIIlI, int llllllllllllllllIlIlIlIllIIIIIIl) throws IOException {
        return TextureLoader.getTexture(llllllllllllllllIlIlIlIllIIIIIll, llllllllllllllllIlIlIlIllIIIIIlI, false, llllllllllllllllIlIlIlIllIIIIIIl);
    }

    public static Texture getTexture(String llllllllllllllllIlIlIlIllIIIllll, InputStream llllllllllllllllIlIlIlIllIIIlllI, boolean llllllllllllllllIlIlIlIllIIIllIl) throws IOException {
        return TextureLoader.getTexture(llllllllllllllllIlIlIlIllIIIllll, llllllllllllllllIlIlIlIllIIIlllI, llllllllllllllllIlIlIlIllIIIllIl, 9729);
    }

    public TextureLoader() {
        TextureLoader llllllllllllllllIlIlIlIllIIllIlI;
    }
}

