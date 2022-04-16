/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.geom;

import java.io.Serializable;

public interface Triangulator
extends Serializable {
    public int getTriangleCount();

    public void addPolyPoint(float var1, float var2);

    public float[] getTrianglePoint(int var1, int var2);

    public boolean triangulate();

    public void startHole();
}

