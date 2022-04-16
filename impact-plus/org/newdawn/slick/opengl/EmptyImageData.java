/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package org.newdawn.slick.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.InternalTextureLoader;

public class EmptyImageData
implements ImageData {
    private /* synthetic */ int height;
    private /* synthetic */ int width;

    @Override
    public ByteBuffer getImageBufferData() {
        EmptyImageData llllllllllllllllIlIllIIlIllIllII;
        return BufferUtils.createByteBuffer((int)(llllllllllllllllIlIllIIlIllIllII.getTexWidth() * llllllllllllllllIlIllIIlIllIllII.getTexHeight() * 4));
    }

    @Override
    public int getTexWidth() {
        EmptyImageData llllllllllllllllIlIllIIlIllIIlll;
        return InternalTextureLoader.get2Fold(llllllllllllllllIlIllIIlIllIIlll.width);
    }

    @Override
    public int getWidth() {
        EmptyImageData llllllllllllllllIlIllIIlIllIIIll;
        return llllllllllllllllIlIllIIlIllIIIll.width;
    }

    @Override
    public int getTexHeight() {
        EmptyImageData llllllllllllllllIlIllIIlIllIlIIl;
        return InternalTextureLoader.get2Fold(llllllllllllllllIlIllIIlIllIlIIl.height);
    }

    @Override
    public int getDepth() {
        return 32;
    }

    @Override
    public int getHeight() {
        EmptyImageData llllllllllllllllIlIllIIlIllIllll;
        return llllllllllllllllIlIllIIlIllIllll.height;
    }

    public EmptyImageData(int llllllllllllllllIlIllIIlIlllIlII, int llllllllllllllllIlIllIIlIlllIIll) {
        EmptyImageData llllllllllllllllIlIllIIlIllllIII;
        llllllllllllllllIlIllIIlIllllIII.width = llllllllllllllllIlIllIIlIlllIlII;
        llllllllllllllllIlIllIIlIllllIII.height = llllllllllllllllIlIllIIlIlllIIll;
    }
}

