/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding;

import org.newdawn.slick.util.pathfinding.Mover;

public interface PathFindingContext {
    public int getSourceX();

    public int getSearchDistance();

    public int getSourceY();

    public Mover getMover();
}

