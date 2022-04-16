/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding.heuristics;

import org.newdawn.slick.util.pathfinding.AStarHeuristic;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class ClosestSquaredHeuristic
implements AStarHeuristic {
    @Override
    public float getCost(TileBasedMap llllllllllllllllllIlIlllllllIIII, Mover llllllllllllllllllIlIllllllIllll, int llllllllllllllllllIlIllllllIlIII, int llllllllllllllllllIlIllllllIIlll, int llllllllllllllllllIlIllllllIIllI, int llllllllllllllllllIlIllllllIIlIl) {
        float llllllllllllllllllIlIllllllIlIlI = llllllllllllllllllIlIllllllIIllI - llllllllllllllllllIlIllllllIlIII;
        float llllllllllllllllllIlIllllllIlIIl = llllllllllllllllllIlIllllllIIlIl - llllllllllllllllllIlIllllllIIlll;
        return llllllllllllllllllIlIllllllIlIlI * llllllllllllllllllIlIllllllIlIlI + llllllllllllllllllIlIllllllIlIIl * llllllllllllllllllIlIllllllIlIIl;
    }

    public ClosestSquaredHeuristic() {
        ClosestSquaredHeuristic llllllllllllllllllIlIllllllllIIl;
    }
}

