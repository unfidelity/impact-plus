/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package org.newdawn.slick;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.ImageData;

public class ImageBuffer
implements ImageData {
    private /* synthetic */ int width;
    private /* synthetic */ int texHeight;
    private /* synthetic */ byte[] rawData;
    private /* synthetic */ int texWidth;
    private /* synthetic */ int height;

    public ImageBuffer(int llllllllllllllllIlIllIIlIlIIIIIl, int llllllllllllllllIlIllIIlIlIIIIII) {
        ImageBuffer llllllllllllllllIlIllIIlIIllllll;
        llllllllllllllllIlIllIIlIIllllll.width = llllllllllllllllIlIllIIlIlIIIIIl;
        llllllllllllllllIlIllIIlIIllllll.height = llllllllllllllllIlIllIIlIlIIIIII;
        llllllllllllllllIlIllIIlIIllllll.texWidth = llllllllllllllllIlIllIIlIIllllll.get2Fold(llllllllllllllllIlIllIIlIlIIIIIl);
        llllllllllllllllIlIllIIlIIllllll.texHeight = llllllllllllllllIlIllIIlIIllllll.get2Fold(llllllllllllllllIlIllIIlIlIIIIII);
        llllllllllllllllIlIllIIlIIllllll.rawData = new byte[llllllllllllllllIlIllIIlIIllllll.texWidth * llllllllllllllllIlIllIIlIIllllll.texHeight * 4];
    }

    @Override
    public ByteBuffer getImageBufferData() {
        ImageBuffer llllllllllllllllIlIllIIlIIlIlIlI;
        ByteBuffer llllllllllllllllIlIllIIlIIlIlIIl = BufferUtils.createByteBuffer((int)llllllllllllllllIlIllIIlIIlIlIlI.rawData.length);
        llllllllllllllllIlIllIIlIIlIlIIl.put(llllllllllllllllIlIllIIlIIlIlIlI.rawData);
        llllllllllllllllIlIllIIlIIlIlIIl.flip();
        return llllllllllllllllIlIllIIlIIlIlIIl;
    }

    public Image getImage() {
        ImageBuffer llllllllllllllllIlIllIIlIIIIllIl;
        return new Image(llllllllllllllllIlIllIIlIIIIllIl);
    }

    public Image getImage(int llllllllllllllllIlIllIIlIIIIIllI) {
        ImageBuffer llllllllllllllllIlIllIIlIIIIlIIl;
        return new Image(llllllllllllllllIlIllIIlIIIIlIIl, llllllllllllllllIlIllIIlIIIIIllI);
    }

    @Override
    public int getHeight() {
        ImageBuffer llllllllllllllllIlIllIIlIIllIlll;
        return llllllllllllllllIlIllIIlIIllIlll.height;
    }

    @Override
    public int getDepth() {
        return 32;
    }

    @Override
    public int getTexHeight() {
        ImageBuffer llllllllllllllllIlIllIIlIIllIlII;
        return llllllllllllllllIlIllIIlIIllIlII.texHeight;
    }

    private int get2Fold(int llllllllllllllllIlIllIIlIIIIIIII) {
        int llllllllllllllllIlIllIIlIIIIIIIl;
        for (llllllllllllllllIlIllIIlIIIIIIIl = 2; llllllllllllllllIlIllIIlIIIIIIIl < llllllllllllllllIlIllIIlIIIIIIII; llllllllllllllllIlIllIIlIIIIIIIl *= 2) {
        }
        return llllllllllllllllIlIllIIlIIIIIIIl;
    }

    public byte[] getRGBA() {
        ImageBuffer llllllllllllllllIlIllIIlIIlllIll;
        return llllllllllllllllIlIllIIlIIlllIll.rawData;
    }

    @Override
    public int getWidth() {
        ImageBuffer llllllllllllllllIlIllIIlIIlIllIl;
        return llllllllllllllllIlIllIIlIIlIllIl.width;
    }

    @Override
    public int getTexWidth() {
        ImageBuffer llllllllllllllllIlIllIIlIIllIIIl;
        return llllllllllllllllIlIllIIlIIllIIIl.texWidth;
    }

    public void setRGBA(int llllllllllllllllIlIllIIlIIIlIlIl, int llllllllllllllllIlIllIIlIIIlllII, int llllllllllllllllIlIllIIlIIIllIll, int llllllllllllllllIlIllIIlIIIlIIlI, int llllllllllllllllIlIllIIlIIIllIIl, int llllllllllllllllIlIllIIlIIIllIII) {
        ImageBuffer llllllllllllllllIlIllIIlIIIllllI;
        if (llllllllllllllllIlIllIIlIIIlIlIl < 0 || llllllllllllllllIlIllIIlIIIlIlIl >= llllllllllllllllIlIllIIlIIIllllI.width || llllllllllllllllIlIllIIlIIIlllII < 0 || llllllllllllllllIlIllIIlIIIlllII >= llllllllllllllllIlIllIIlIIIllllI.height) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("Specified location: ").append(llllllllllllllllIlIllIIlIIIlIlIl).append(",").append(llllllllllllllllIlIllIIlIIIlllII).append(" outside of image")));
        }
        int llllllllllllllllIlIllIIlIIIlIlll = (llllllllllllllllIlIllIIlIIIlIlIl + llllllllllllllllIlIllIIlIIIlllII * llllllllllllllllIlIllIIlIIIllllI.texWidth) * 4;
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            llllllllllllllllIlIllIIlIIIllllI.rawData[llllllllllllllllIlIllIIlIIIlIlll] = (byte)llllllllllllllllIlIllIIlIIIllIIl;
            llllllllllllllllIlIllIIlIIIllllI.rawData[llllllllllllllllIlIllIIlIIIlIlll + 1] = (byte)llllllllllllllllIlIllIIlIIIlIIlI;
            llllllllllllllllIlIllIIlIIIllllI.rawData[llllllllllllllllIlIllIIlIIIlIlll + 2] = (byte)llllllllllllllllIlIllIIlIIIllIll;
            llllllllllllllllIlIllIIlIIIllllI.rawData[llllllllllllllllIlIllIIlIIIlIlll + 3] = (byte)llllllllllllllllIlIllIIlIIIllIII;
        } else {
            llllllllllllllllIlIllIIlIIIllllI.rawData[llllllllllllllllIlIllIIlIIIlIlll] = (byte)llllllllllllllllIlIllIIlIIIllIll;
            llllllllllllllllIlIllIIlIIIllllI.rawData[llllllllllllllllIlIllIIlIIIlIlll + 1] = (byte)llllllllllllllllIlIllIIlIIIlIIlI;
            llllllllllllllllIlIllIIlIIIllllI.rawData[llllllllllllllllIlIllIIlIIIlIlll + 2] = (byte)llllllllllllllllIlIllIIlIIIllIIl;
            llllllllllllllllIlIllIIlIIIllllI.rawData[llllllllllllllllIlIllIIlIIIlIlll + 3] = (byte)llllllllllllllllIlIllIIlIIIllIII;
        }
    }
}

