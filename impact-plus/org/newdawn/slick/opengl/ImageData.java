/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.opengl;

import java.nio.ByteBuffer;

public interface ImageData {
    public int getTexWidth();

    public int getHeight();

    public ByteBuffer getImageBufferData();

    public int getTexHeight();

    public int getWidth();

    public int getDepth();
}

