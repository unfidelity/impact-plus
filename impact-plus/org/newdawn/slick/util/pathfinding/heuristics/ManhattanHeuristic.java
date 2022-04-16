/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding.heuristics;

import org.newdawn.slick.util.pathfinding.AStarHeuristic;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class ManhattanHeuristic
implements AStarHeuristic {
    private /* synthetic */ int minimumCost;

    @Override
    public float getCost(TileBasedMap llllllllllllllllIIlIllllIIllIlll, Mover llllllllllllllllIIlIllllIIllIllI, int llllllllllllllllIIlIllllIIllIIII, int llllllllllllllllIIlIllllIIllIlII, int llllllllllllllllIIlIllllIIlIlllI, int llllllllllllllllIIlIllllIIlIllIl) {
        ManhattanHeuristic llllllllllllllllIIlIllllIIllIIIl;
        return llllllllllllllllIIlIllllIIllIIIl.minimumCost * (Math.abs(llllllllllllllllIIlIllllIIllIIII - llllllllllllllllIIlIllllIIlIlllI) + Math.abs(llllllllllllllllIIlIllllIIllIlII - llllllllllllllllIIlIllllIIlIllIl));
    }

    public ManhattanHeuristic(int llllllllllllllllIIlIllllIlIIIIII) {
        ManhattanHeuristic llllllllllllllllIIlIllllIlIIIIIl;
        llllllllllllllllIIlIllllIlIIIIIl.minimumCost = llllllllllllllllIIlIllllIlIIIIII;
    }
}

