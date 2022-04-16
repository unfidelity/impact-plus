/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding.heuristics;

import org.newdawn.slick.util.pathfinding.AStarHeuristic;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.TileBasedMap;

public class ClosestHeuristic
implements AStarHeuristic {
    @Override
    public float getCost(TileBasedMap lllllllllllllllllIIllIlllIlIllII, Mover lllllllllllllllllIIllIlllIlIlIll, int lllllllllllllllllIIllIlllIlIIIll, int lllllllllllllllllIIllIlllIlIIIlI, int lllllllllllllllllIIllIlllIlIlIII, int lllllllllllllllllIIllIlllIlIIlll) {
        float lllllllllllllllllIIllIlllIlIIllI = lllllllllllllllllIIllIlllIlIlIII - lllllllllllllllllIIllIlllIlIIIll;
        float lllllllllllllllllIIllIlllIlIIlIl = lllllllllllllllllIIllIlllIlIIlll - lllllllllllllllllIIllIlllIlIIIlI;
        float lllllllllllllllllIIllIlllIlIIlII = (float)Math.sqrt(lllllllllllllllllIIllIlllIlIIllI * lllllllllllllllllIIllIlllIlIIllI + lllllllllllllllllIIllIlllIlIIlIl * lllllllllllllllllIIllIlllIlIIlIl);
        return lllllllllllllllllIIllIlllIlIIlII;
    }

    public ClosestHeuristic() {
        ClosestHeuristic lllllllllllllllllIIllIlllIllIlIl;
    }
}

