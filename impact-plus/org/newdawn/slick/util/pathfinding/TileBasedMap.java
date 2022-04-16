/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding;

import org.newdawn.slick.util.pathfinding.PathFindingContext;

public interface TileBasedMap {
    public int getWidthInTiles();

    public float getCost(PathFindingContext var1, int var2, int var3);

    public boolean blocked(PathFindingContext var1, int var2, int var3);

    public void pathFinderVisited(int var1, int var2);

    public int getHeightInTiles();
}

