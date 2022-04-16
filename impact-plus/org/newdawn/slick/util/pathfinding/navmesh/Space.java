/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding.navmesh;

import java.util.ArrayList;
import java.util.HashMap;
import org.newdawn.slick.util.pathfinding.navmesh.Link;
import org.newdawn.slick.util.pathfinding.navmesh.NavPath;

public class Space {
    private /* synthetic */ HashMap links;
    private /* synthetic */ float y;
    private /* synthetic */ float width;
    private /* synthetic */ ArrayList linksList;
    private /* synthetic */ float height;
    private /* synthetic */ float x;
    private /* synthetic */ float cost;

    public boolean canMerge(Space lIlIIllIllIIlIl) {
        Space lIlIIllIllIIIll;
        if (!lIlIIllIllIIIll.hasJoinedEdge(lIlIIllIllIIlIl)) {
            return false;
        }
        if (lIlIIllIllIIIll.x == lIlIIllIllIIlIl.x && lIlIIllIllIIIll.width == lIlIIllIllIIlIl.width) {
            return true;
        }
        return lIlIIllIllIIIll.y == lIlIIllIllIIlIl.y && lIlIIllIllIIIll.height == lIlIIllIllIIlIl.height;
    }

    public boolean contains(float lIlIIllIIllIIll, float lIlIIllIIllIlIl) {
        Space lIlIIllIIllIlII;
        return lIlIIllIIllIIll >= lIlIIllIIllIlII.x && lIlIIllIIllIIll < lIlIIllIIllIlII.x + lIlIIllIIllIlII.width && lIlIIllIIllIlIl >= lIlIIllIIllIlII.y && lIlIIllIIllIlIl < lIlIIllIIllIlII.y + lIlIIllIIllIlII.height;
    }

    public void link(Space lIlIlIIIIIlIIII) {
        Space lIlIlIIIIIlIIIl;
        if (lIlIlIIIIIlIIIl.inTolerance(lIlIlIIIIIlIIIl.x, lIlIlIIIIIlIIII.x + lIlIlIIIIIlIIII.width) || lIlIlIIIIIlIIIl.inTolerance(lIlIlIIIIIlIIIl.x + lIlIlIIIIIlIIIl.width, lIlIlIIIIIlIIII.x)) {
            float lIlIlIIIIlIIIIl = lIlIlIIIIIlIIIl.x;
            if (lIlIlIIIIIlIIIl.x + lIlIlIIIIIlIIIl.width == lIlIlIIIIIlIIII.x) {
                lIlIlIIIIlIIIIl = lIlIlIIIIIlIIIl.x + lIlIlIIIIIlIIIl.width;
            }
            float lIlIlIIIIIlllll = Math.max(lIlIlIIIIIlIIIl.y, lIlIlIIIIIlIIII.y);
            float lIlIlIIIIIlllIl = Math.min(lIlIlIIIIIlIIIl.y + lIlIlIIIIIlIIIl.height, lIlIlIIIIIlIIII.y + lIlIlIIIIIlIIII.height);
            float lIlIlIIIIIllIlI = lIlIlIIIIIlllll + (lIlIlIIIIIlllIl - lIlIlIIIIIlllll) / 2.0f;
            Link lIlIlIIIIIlIlll = new Link(lIlIlIIIIlIIIIl, lIlIlIIIIIllIlI, lIlIlIIIIIlIIII);
            lIlIlIIIIIlIIIl.links.put(lIlIlIIIIIlIIII, lIlIlIIIIIlIlll);
            lIlIlIIIIIlIIIl.linksList.add(lIlIlIIIIIlIlll);
        }
        if (lIlIlIIIIIlIIIl.inTolerance(lIlIlIIIIIlIIIl.y, lIlIlIIIIIlIIII.y + lIlIlIIIIIlIIII.height) || lIlIlIIIIIlIIIl.inTolerance(lIlIlIIIIIlIIIl.y + lIlIlIIIIIlIIIl.height, lIlIlIIIIIlIIII.y)) {
            float lIlIlIIIIIlIllI = lIlIlIIIIIlIIIl.y;
            if (lIlIlIIIIIlIIIl.y + lIlIlIIIIIlIIIl.height == lIlIlIIIIIlIIII.y) {
                lIlIlIIIIIlIllI = lIlIlIIIIIlIIIl.y + lIlIlIIIIIlIIIl.height;
            }
            float lIlIlIIIIIlIlIl = Math.max(lIlIlIIIIIlIIIl.x, lIlIlIIIIIlIIII.x);
            float lIlIlIIIIIlIlII = Math.min(lIlIlIIIIIlIIIl.x + lIlIlIIIIIlIIIl.width, lIlIlIIIIIlIIII.x + lIlIlIIIIIlIIII.width);
            float lIlIlIIIIIlIIll = lIlIlIIIIIlIlIl + (lIlIlIIIIIlIlII - lIlIlIIIIIlIlIl) / 2.0f;
            Link lIlIlIIIIIlIIlI = new Link(lIlIlIIIIIlIIll, lIlIlIIIIIlIllI, lIlIlIIIIIlIIII);
            lIlIlIIIIIlIIIl.links.put(lIlIlIIIIIlIIII, lIlIlIIIIIlIIlI);
            lIlIlIIIIIlIIIl.linksList.add(lIlIlIIIIIlIIlI);
        }
    }

    public boolean hasJoinedEdge(Space lIlIIllllIlllll) {
        Space lIlIIlllllIIlIl;
        if (lIlIIlllllIIlIl.inTolerance(lIlIIlllllIIlIl.x, lIlIIllllIlllll.x + lIlIIllllIlllll.width) || lIlIIlllllIIlIl.inTolerance(lIlIIlllllIIlIl.x + lIlIIlllllIIlIl.width, lIlIIllllIlllll.x)) {
            if (lIlIIlllllIIlIl.y >= lIlIIllllIlllll.y && lIlIIlllllIIlIl.y <= lIlIIllllIlllll.y + lIlIIllllIlllll.height) {
                return true;
            }
            if (lIlIIlllllIIlIl.y + lIlIIlllllIIlIl.height >= lIlIIllllIlllll.y && lIlIIlllllIIlIl.y + lIlIIlllllIIlIl.height <= lIlIIllllIlllll.y + lIlIIllllIlllll.height) {
                return true;
            }
            if (lIlIIllllIlllll.y >= lIlIIlllllIIlIl.y && lIlIIllllIlllll.y <= lIlIIlllllIIlIl.y + lIlIIlllllIIlIl.height) {
                return true;
            }
            if (lIlIIllllIlllll.y + lIlIIllllIlllll.height >= lIlIIlllllIIlIl.y && lIlIIllllIlllll.y + lIlIIllllIlllll.height <= lIlIIlllllIIlIl.y + lIlIIlllllIIlIl.height) {
                return true;
            }
        }
        if (lIlIIlllllIIlIl.inTolerance(lIlIIlllllIIlIl.y, lIlIIllllIlllll.y + lIlIIllllIlllll.height) || lIlIIlllllIIlIl.inTolerance(lIlIIlllllIIlIl.y + lIlIIlllllIIlIl.height, lIlIIllllIlllll.y)) {
            if (lIlIIlllllIIlIl.x >= lIlIIllllIlllll.x && lIlIIlllllIIlIl.x <= lIlIIllllIlllll.x + lIlIIllllIlllll.width) {
                return true;
            }
            if (lIlIIlllllIIlIl.x + lIlIIlllllIIlIl.width >= lIlIIllllIlllll.x && lIlIIlllllIIlIl.x + lIlIIlllllIIlIl.width <= lIlIIllllIlllll.x + lIlIIllllIlllll.width) {
                return true;
            }
            if (lIlIIllllIlllll.x >= lIlIIlllllIIlIl.x && lIlIIllllIlllll.x <= lIlIIlllllIIlIl.x + lIlIIlllllIIlIl.width) {
                return true;
            }
            if (lIlIIllllIlllll.x + lIlIIllllIlllll.width >= lIlIIlllllIIlIl.x && lIlIIllllIlllll.x + lIlIIllllIlllll.width <= lIlIIlllllIIlIl.x + lIlIIlllllIIlIl.width) {
                return true;
            }
        }
        return false;
    }

    public float getCost() {
        Space lIlIIlIlllIIIII;
        return lIlIIlIlllIIIII.cost;
    }

    public boolean pickLowestCost(Space lIlIIlIlIlllIIl, NavPath lIlIIlIlIllllII) {
        Space lIlIIlIlIlllllI;
        if (lIlIIlIlIlllIIl == lIlIIlIlIlllllI) {
            return true;
        }
        if (lIlIIlIlIlllllI.links.size() == 0) {
            return false;
        }
        Link lIlIIlIlIlllIll = null;
        for (int lIlIIlIlIllllll = 0; lIlIIlIlIllllll < lIlIIlIlIlllllI.getLinkCount(); ++lIlIIlIlIllllll) {
            Link lIlIIlIllIIIIII = lIlIIlIlIlllllI.getLink(lIlIIlIlIllllll);
            if (lIlIIlIlIlllIll != null && !(lIlIIlIllIIIIII.getTarget().getCost() < lIlIIlIlIlllIll.getTarget().getCost())) continue;
            lIlIIlIlIlllIll = lIlIIlIllIIIIII;
        }
        lIlIIlIlIllllII.push(lIlIIlIlIlllIll);
        return lIlIIlIlIlllIll.getTarget().pickLowestCost(lIlIIlIlIlllIIl, lIlIIlIlIllllII);
    }

    public float getWidth() {
        Space lIlIlIIIllIlIll;
        return lIlIlIIIllIlIll.width;
    }

    public float getX() {
        Space lIlIlIIIllIIIlI;
        return lIlIlIIIllIIIlI.x;
    }

    public Space(float lIlIlIIIllllIII, float lIlIlIIlIIIIIll, float lIlIlIIlIIIIIIl, float lIlIlIIIlllIIII) {
        Space lIlIlIIIllllIll;
        lIlIlIIIllllIll.links = new HashMap();
        lIlIlIIIllllIll.linksList = new ArrayList();
        lIlIlIIIllllIll.x = lIlIlIIIllllIII;
        lIlIlIIIllllIll.y = lIlIlIIlIIIIIll;
        lIlIlIIIllllIll.width = lIlIlIIlIIIIIIl;
        lIlIlIIIllllIll.height = lIlIlIIIlllIIII;
    }

    public float getY() {
        Space lIlIlIIIlIlIlll;
        return lIlIlIIIlIlIlll.y;
    }

    public void fill(Space lIlIIlIlllllIII, float lIlIIlIllllIlll, float lIlIIlIllllIIIl, float lIlIIlIllllIlIl) {
        Space lIlIIlIllllIlII;
        if (lIlIIlIllllIlIl >= lIlIIlIllllIlII.cost) {
            return;
        }
        lIlIIlIllllIlII.cost = lIlIIlIllllIlIl;
        if (lIlIIlIlllllIII == lIlIIlIllllIlII) {
            return;
        }
        for (int lIlIIlIlllllIlI = 0; lIlIIlIlllllIlI < lIlIIlIllllIlII.getLinkCount(); ++lIlIIlIlllllIlI) {
            Link lIlIIlIlllllllI = lIlIIlIllllIlII.getLink(lIlIIlIlllllIlI);
            float lIlIIlIllllllII = lIlIIlIlllllllI.distance2(lIlIIlIllllIlll, lIlIIlIllllIIIl);
            float lIlIIlIlllllIll = lIlIIlIllllIlIl + lIlIIlIllllllII;
            lIlIIlIlllllllI.getTarget().fill(lIlIIlIlllllIII, lIlIIlIlllllllI.getX(), lIlIIlIlllllllI.getY(), lIlIIlIlllllIll);
        }
    }

    private boolean inTolerance(float lIlIIlllllllIIl, float lIlIIlllllllIII) {
        return lIlIIlllllllIIl == lIlIIlllllllIII;
    }

    public float getHeight() {
        Space lIlIlIIIllIIllI;
        return lIlIlIIIllIIllI.height;
    }

    public int getLinkCount() {
        Space lIlIIllIlIllIll;
        return lIlIIllIlIllIll.linksList.size();
    }

    public void clearCost() {
        lIlIIlIlllIlIII.cost = Float.MAX_VALUE;
    }

    public String toString() {
        Space lIlIIlIlIlIIllI;
        return String.valueOf(new StringBuilder().append("[Space ").append(lIlIIlIlIlIIllI.x).append(",").append(lIlIIlIlIlIIllI.y).append(" ").append(lIlIIlIlIlIIllI.width).append(",").append(lIlIIlIlIlIIllI.height).append("]"));
    }

    public Link getLink(int lIlIIllIlIIIlll) {
        Space lIlIIllIlIIIlII;
        return (Link)lIlIIllIlIIIlII.linksList.get(lIlIIllIlIIIlll);
    }

    public Space merge(Space lIlIIlllIllIlII) {
        Space lIlIIlllIllIlIl;
        float lIlIIlllIllIIIl = Math.min(lIlIIlllIllIlIl.x, lIlIIlllIllIlII.x);
        float lIlIIlllIlIllll = Math.min(lIlIIlllIllIlIl.y, lIlIIlllIllIlII.y);
        float lIlIIlllIlIllIl = lIlIIlllIllIlIl.width + lIlIIlllIllIlII.width;
        float lIlIIlllIlIllII = lIlIIlllIllIlIl.height + lIlIIlllIllIlII.height;
        if (lIlIIlllIllIlIl.x == lIlIIlllIllIlII.x) {
            lIlIIlllIlIllIl = lIlIIlllIllIlIl.width;
        } else {
            lIlIIlllIlIllII = lIlIIlllIllIlIl.height;
        }
        return new Space(lIlIIlllIllIIIl, lIlIIlllIlIllll, lIlIIlllIlIllIl, lIlIIlllIlIllII);
    }
}

