/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding.navmesh;

import java.util.ArrayList;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;
import org.newdawn.slick.util.pathfinding.navmesh.NavMesh;
import org.newdawn.slick.util.pathfinding.navmesh.Space;

public class NavMeshBuilder
implements PathFindingContext {
    private /* synthetic */ float smallestSpace;
    private /* synthetic */ int sx;
    private /* synthetic */ boolean tileBased;
    private /* synthetic */ int sy;

    private void subsection(TileBasedMap llIlIIllIlIIl, Space llIlIIllIllII, ArrayList llIlIIllIlIll) {
        NavMeshBuilder llIlIIllIlllI;
        if (!llIlIIllIlllI.clear(llIlIIllIlIIl, llIlIIllIllII)) {
            float llIlIIlllIIII = llIlIIllIllII.getWidth() / 2.0f;
            float llIlIIllIllll = llIlIIllIllII.getHeight() / 2.0f;
            if (llIlIIlllIIII < llIlIIllIlllI.smallestSpace && llIlIIllIllll < llIlIIllIlllI.smallestSpace) {
                return;
            }
            llIlIIllIlllI.subsection(llIlIIllIlIIl, new Space(llIlIIllIllII.getX(), llIlIIllIllII.getY(), llIlIIlllIIII, llIlIIllIllll), llIlIIllIlIll);
            llIlIIllIlllI.subsection(llIlIIllIlIIl, new Space(llIlIIllIllII.getX(), llIlIIllIllII.getY() + llIlIIllIllll, llIlIIlllIIII, llIlIIllIllll), llIlIIllIlIll);
            llIlIIllIlllI.subsection(llIlIIllIlIIl, new Space(llIlIIllIllII.getX() + llIlIIlllIIII, llIlIIllIllII.getY(), llIlIIlllIIII, llIlIIllIllll), llIlIIllIlIll);
            llIlIIllIlllI.subsection(llIlIIllIlIIl, new Space(llIlIIllIllII.getX() + llIlIIlllIIII, llIlIIllIllII.getY() + llIlIIllIllll, llIlIIlllIIII, llIlIIllIllll), llIlIIllIlIll);
        } else {
            llIlIIllIlIll.add(llIlIIllIllII);
        }
    }

    @Override
    public int getSourceY() {
        NavMeshBuilder llIlIIlIlIIll;
        return llIlIIlIlIIll.sy;
    }

    public NavMesh build(TileBasedMap llIlIllIIlIIl, boolean llIlIllIIlIII) {
        NavMeshBuilder llIlIllIIlIlI;
        llIlIllIIlIlI.tileBased = llIlIllIIlIII;
        ArrayList<Space> llIlIllIIlIll = new ArrayList<Space>();
        if (llIlIllIIlIII) {
            for (int llIlIllIlIIII = 0; llIlIllIlIIII < llIlIllIIlIIl.getWidthInTiles(); ++llIlIllIlIIII) {
                for (int llIlIllIlIIIl = 0; llIlIllIlIIIl < llIlIllIIlIIl.getHeightInTiles(); ++llIlIllIlIIIl) {
                    if (llIlIllIIlIIl.blocked(llIlIllIIlIlI, llIlIllIlIIII, llIlIllIlIIIl)) continue;
                    llIlIllIIlIll.add(new Space(llIlIllIlIIII, llIlIllIlIIIl, 1.0f, 1.0f));
                }
            }
        } else {
            Space llIlIllIIllll = new Space(0.0f, 0.0f, llIlIllIIlIIl.getWidthInTiles(), llIlIllIIlIIl.getHeightInTiles());
            llIlIllIIlIlI.subsection(llIlIllIIlIIl, llIlIllIIllll, llIlIllIIlIll);
        }
        while (llIlIllIIlIlI.mergeSpaces(llIlIllIIlIll)) {
        }
        llIlIllIIlIlI.linkSpaces(llIlIllIIlIll);
        return new NavMesh(llIlIllIIlIll);
    }

    public NavMeshBuilder() {
        NavMeshBuilder llIllIIIIIIIl;
        llIllIIIIIIIl.smallestSpace = 0.2f;
    }

    @Override
    public int getSearchDistance() {
        return 0;
    }

    public NavMesh build(TileBasedMap llIlIlllIlIlI) {
        NavMeshBuilder llIlIlllIlllI;
        return llIlIlllIlllI.build(llIlIlllIlIlI, true);
    }

    @Override
    public int getSourceX() {
        NavMeshBuilder llIlIIlIlllll;
        return llIlIIlIlllll.sx;
    }

    @Override
    public Mover getMover() {
        return null;
    }

    private boolean mergeSpaces(ArrayList llIlIlIlllIIl) {
        for (int llIlIlIllllII = 0; llIlIlIllllII < llIlIlIlllIIl.size(); ++llIlIlIllllII) {
            Space llIlIlIllllIl = (Space)llIlIlIlllIIl.get(llIlIlIllllII);
            for (int llIlIlIlllllI = llIlIlIllllII + 1; llIlIlIlllllI < llIlIlIlllIIl.size(); ++llIlIlIlllllI) {
                Space llIlIlIllllll = (Space)llIlIlIlllIIl.get(llIlIlIlllllI);
                if (!llIlIlIllllIl.canMerge(llIlIlIllllll)) continue;
                llIlIlIlllIIl.remove(llIlIlIllllIl);
                llIlIlIlllIIl.remove(llIlIlIllllll);
                llIlIlIlllIIl.add(llIlIlIllllIl.merge(llIlIlIllllll));
                return true;
            }
        }
        return false;
    }

    private void linkSpaces(ArrayList llIlIlIlIlIlI) {
        for (int llIlIlIlIllII = 0; llIlIlIlIllII < llIlIlIlIlIlI.size(); ++llIlIlIlIllII) {
            Space llIlIlIlIllIl = (Space)llIlIlIlIlIlI.get(llIlIlIlIllII);
            for (int llIlIlIlIlllI = llIlIlIlIllII + 1; llIlIlIlIlllI < llIlIlIlIlIlI.size(); ++llIlIlIlIlllI) {
                Space llIlIlIlIllll = (Space)llIlIlIlIlIlI.get(llIlIlIlIlllI);
                if (!llIlIlIlIllIl.hasJoinedEdge(llIlIlIlIllll)) continue;
                llIlIlIlIllIl.link(llIlIlIlIllll);
                llIlIlIlIllll.link(llIlIlIlIllIl);
            }
        }
    }

    public boolean clear(TileBasedMap llIlIlIIlIIIl, Space llIlIlIIlIIII) {
        NavMeshBuilder llIlIlIIIllIl;
        if (llIlIlIIIllIl.tileBased) {
            return true;
        }
        float llIlIlIIIllll = 0.0f;
        boolean llIlIlIIIlllI = false;
        while (llIlIlIIIllll < llIlIlIIlIIII.getWidth()) {
            float llIlIlIIlIlII = 0.0f;
            boolean llIlIlIIlIIll = false;
            while (llIlIlIIlIlII < llIlIlIIlIIII.getHeight()) {
                llIlIlIIIllIl.sx = (int)(llIlIlIIlIIII.getX() + llIlIlIIIllll);
                llIlIlIIIllIl.sy = (int)(llIlIlIIlIIII.getY() + llIlIlIIlIlII);
                if (llIlIlIIlIIIl.blocked(llIlIlIIIllIl, llIlIlIIIllIl.sx, llIlIlIIIllIl.sy)) {
                    return false;
                }
                if (!((llIlIlIIlIlII += 0.1f) > llIlIlIIlIIII.getHeight()) || llIlIlIIlIIll) continue;
                llIlIlIIlIlII = llIlIlIIlIIII.getHeight();
                llIlIlIIlIIll = true;
            }
            if (!((llIlIlIIIllll += 0.1f) > llIlIlIIlIIII.getWidth()) || llIlIlIIIlllI) continue;
            llIlIlIIIllll = llIlIlIIlIIII.getWidth();
            llIlIlIIIlllI = true;
        }
        return true;
    }
}

