/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl;

public interface Texture {
    public byte[] getTextureData();

    public int getTextureWidth();

    public void bind();

    public float getWidth();

    public int getTextureHeight();

    public void release();

    public int getImageHeight();

    public void setTextureFilter(int var1);

    public float getHeight();

    public int getImageWidth();

    public boolean hasAlpha();

    public String getTextureRef();

    public int getTextureID();
}

