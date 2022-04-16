/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding.navmesh;

import java.util.ArrayList;
import org.newdawn.slick.util.pathfinding.navmesh.Link;
import org.newdawn.slick.util.pathfinding.navmesh.NavPath;
import org.newdawn.slick.util.pathfinding.navmesh.Space;

public class NavMesh {
    private /* synthetic */ ArrayList spaces;

    public int getSpaceCount() {
        NavMesh lIIIIIIIlIlllII;
        return lIIIIIIIlIlllII.spaces.size();
    }

    public NavPath findPath(float lllllllllllIIl, float lIIIIIIIIIIlIII, float lIIIIIIIIIIIlll, float llllllllllIlII, boolean lIIIIIIIIIIIIlI) {
        NavMesh lllllllllllIll;
        Space lIIIIIIIIIIIIII = lllllllllllIll.findSpace(lllllllllllIIl, lIIIIIIIIIIlIII);
        Space llllllllllllll = lllllllllllIll.findSpace(lIIIIIIIIIIIlll, llllllllllIlII);
        if (lIIIIIIIIIIIIII == null || llllllllllllll == null) {
            return null;
        }
        for (int lIIIIIIIIIIlIll = 0; lIIIIIIIIIIlIll < lllllllllllIll.spaces.size(); ++lIIIIIIIIIIlIll) {
            ((Space)lllllllllllIll.spaces.get(lIIIIIIIIIIlIll)).clearCost();
        }
        llllllllllllll.fill(lIIIIIIIIIIIIII, lIIIIIIIIIIIlll, llllllllllIlII, 0.0f);
        if (llllllllllllll.getCost() == Float.MAX_VALUE) {
            return null;
        }
        if (lIIIIIIIIIIIIII.getCost() == Float.MAX_VALUE) {
            return null;
        }
        NavPath llllllllllllIl = new NavPath();
        llllllllllllIl.push(new Link(lllllllllllIIl, lIIIIIIIIIIlIII, null));
        if (lIIIIIIIIIIIIII.pickLowestCost(llllllllllllll, llllllllllllIl)) {
            llllllllllllIl.push(new Link(lIIIIIIIIIIIlll, llllllllllIlII, null));
            if (lIIIIIIIIIIIIlI) {
                lllllllllllIll.optimize(llllllllllllIl);
            }
            return llllllllllllIl;
        }
        return null;
    }

    public Space findSpace(float lIIIIIIIIlllIIl, float lIIIIIIIIllIlll) {
        NavMesh lIIIIIIIIlllIll;
        for (int lIIIIIIIlIIIIlI = 0; lIIIIIIIlIIIIlI < lIIIIIIIIlllIll.spaces.size(); ++lIIIIIIIlIIIIlI) {
            Space lIIIIIIIlIIIIll = lIIIIIIIIlllIll.getSpace(lIIIIIIIlIIIIlI);
            if (!lIIIIIIIlIIIIll.contains(lIIIIIIIIlllIIl, lIIIIIIIIllIlll)) continue;
            return lIIIIIIIlIIIIll;
        }
        return null;
    }

    public NavMesh(ArrayList lIIIIIIIllIIIII) {
        NavMesh lIIIIIIIllIIIll;
        lIIIIIIIllIIIll.spaces = new ArrayList();
        lIIIIIIIllIIIll.spaces.addAll(lIIIIIIIllIIIII);
    }

    public void addSpace(Space lIIIIIIIlIIlllI) {
        NavMesh lIIIIIIIlIIllll;
        lIIIIIIIlIIllll.spaces.add(lIIIIIIIlIIlllI);
    }

    private boolean isClear(float lllllllIllIlll, float lllllllIlIllII, float lllllllIllIlIl, float lllllllIllIlII, float lllllllIlIlIIl) {
        float lllllllIllIIlI = lllllllIllIlIl - lllllllIllIlll;
        float lllllllIllIIIl = lllllllIllIlII - lllllllIlIllII;
        float lllllllIllIIII = (float)Math.sqrt(lllllllIllIIlI * lllllllIllIIlI + lllllllIllIIIl * lllllllIllIIIl);
        lllllllIllIIlI *= lllllllIlIlIIl;
        lllllllIllIIlI /= lllllllIllIIII;
        lllllllIllIIIl *= lllllllIlIlIIl;
        lllllllIllIIIl /= lllllllIllIIII;
        int lllllllIlIllll = (int)(lllllllIllIIII / lllllllIlIlIIl);
        for (int lllllllIlllIIl = 0; lllllllIlllIIl < lllllllIlIllll; ++lllllllIlllIIl) {
            NavMesh lllllllIlllIII;
            float lllllllIlllllI = lllllllIllIlll + lllllllIllIIlI * (float)lllllllIlllIIl;
            float lllllllIllllII = lllllllIlIllII + lllllllIllIIIl * (float)lllllllIlllIIl;
            if (lllllllIlllIII.findSpace(lllllllIlllllI, lllllllIllllII) != null) continue;
            return false;
        }
        return true;
    }

    public NavMesh() {
        NavMesh lIIIIIIIllIlIlI;
        lIIIIIIIllIlIlI.spaces = new ArrayList();
    }

    public Space getSpace(int lIIIIIIIlIlIlII) {
        NavMesh lIIIIIIIlIlIlIl;
        return (Space)lIIIIIIIlIlIlIl.spaces.get(lIIIIIIIlIlIlII);
    }

    private void optimize(NavPath llllllIlllIlll) {
        int llllllIllllIIl = 0;
        while (llllllIllllIIl < llllllIlllIlll.length() - 2) {
            float llllllIlllllII;
            float llllllIlllllIl;
            float llllllIllllllI;
            NavMesh llllllIllllIII;
            float llllllIlllllll = llllllIlllIlll.getX(llllllIllllIIl);
            if (llllllIllllIII.isClear(llllllIlllllll, llllllIllllllI = llllllIlllIlll.getY(llllllIllllIIl), llllllIlllllIl = llllllIlllIlll.getX(llllllIllllIIl + 2), llllllIlllllII = llllllIlllIlll.getY(llllllIllllIIl + 2), 0.1f)) {
                llllllIlllIlll.remove(llllllIllllIIl + 1);
                continue;
            }
            ++llllllIllllIIl;
        }
    }
}

