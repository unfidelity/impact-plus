/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.newdawn.slick.util.pathfinding.AStarHeuristic;
import org.newdawn.slick.util.pathfinding.Mover;
import org.newdawn.slick.util.pathfinding.Path;
import org.newdawn.slick.util.pathfinding.PathFinder;
import org.newdawn.slick.util.pathfinding.PathFindingContext;
import org.newdawn.slick.util.pathfinding.TileBasedMap;
import org.newdawn.slick.util.pathfinding.heuristics.ClosestHeuristic;

public class AStarPathFinder
implements PathFinder,
PathFindingContext {
    private /* synthetic */ int sourceX;
    private /* synthetic */ Mover mover;
    private /* synthetic */ TileBasedMap map;
    private /* synthetic */ int distance;
    private /* synthetic */ AStarHeuristic heuristic;
    private /* synthetic */ PriorityList open;
    private /* synthetic */ Node[][] nodes;
    private /* synthetic */ Node current;
    private /* synthetic */ int maxSearchDistance;
    private /* synthetic */ boolean allowDiagMovement;
    private /* synthetic */ int sourceY;
    private /* synthetic */ ArrayList closed;

    protected boolean inClosedList(Node lllllllllllllllllIIIIllIllllIlII) {
        return lllllllllllllllllIIIIllIllllIlII.isClosed();
    }

    protected void removeFromOpen(Node lllllllllllllllllIIIIllIllllllll) {
        AStarPathFinder lllllllllllllllllIIIIlllIIIIIIII;
        lllllllllllllllllIIIIllIllllllll.setOpen(false);
        lllllllllllllllllIIIIlllIIIIIIII.open.remove(lllllllllllllllllIIIIllIllllllll);
    }

    @Override
    public int getSourceX() {
        AStarPathFinder lllllllllllllllllIIIIllIlIlIlIll;
        return lllllllllllllllllIIIIllIlIlIlIll.sourceX;
    }

    public int getCurrentY() {
        AStarPathFinder lllllllllllllllllIIIIlllIIIlIIlI;
        if (lllllllllllllllllIIIIlllIIIlIIlI.current == null) {
            return -1;
        }
        return lllllllllllllllllIIIIlllIIIlIIlI.current.y;
    }

    @Override
    public Path findPath(Mover lllllllllllllllllIIIIlllIllIIIIl, int lllllllllllllllllIIIIlllIlIllllI, int lllllllllllllllllIIIIlllIlIllIll, int lllllllllllllllllIIIIlllIlIllIII, int lllllllllllllllllIIIIlllIIlllllI) {
        AStarPathFinder lllllllllllllllllIIIIlllIlIIllII;
        lllllllllllllllllIIIIlllIlIIllII.current = null;
        lllllllllllllllllIIIIlllIlIIllII.mover = lllllllllllllllllIIIIlllIllIIIIl;
        lllllllllllllllllIIIIlllIlIIllII.sourceX = lllllllllllllllllIIIIlllIlIllIII;
        lllllllllllllllllIIIIlllIlIIllII.sourceY = lllllllllllllllllIIIIlllIIlllllI;
        lllllllllllllllllIIIIlllIlIIllII.distance = 0;
        if (lllllllllllllllllIIIIlllIlIIllII.map.blocked(lllllllllllllllllIIIIlllIlIIllII, lllllllllllllllllIIIIlllIlIllIII, lllllllllllllllllIIIIlllIIlllllI)) {
            return null;
        }
        for (int lllllllllllllllllIIIIlllIlllIllI = 0; lllllllllllllllllIIIIlllIlllIllI < lllllllllllllllllIIIIlllIlIIllII.map.getWidthInTiles(); ++lllllllllllllllllIIIIlllIlllIllI) {
            for (int lllllllllllllllllIIIIlllIllllIIl = 0; lllllllllllllllllIIIIlllIllllIIl < lllllllllllllllllIIIIlllIlIIllII.map.getHeightInTiles(); ++lllllllllllllllllIIIIlllIllllIIl) {
                lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIlllIllI][lllllllllllllllllIIIIlllIllllIIl].reset();
            }
        }
        lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIlIllllI][lllllllllllllllllIIIIlllIlIllIll].cost = 0.0f;
        lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIlIllllI][lllllllllllllllllIIIIlllIlIllIll].depth = 0;
        lllllllllllllllllIIIIlllIlIIllII.closed.clear();
        lllllllllllllllllIIIIlllIlIIllII.open.clear();
        lllllllllllllllllIIIIlllIlIIllII.addToOpen(lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIlIllllI][lllllllllllllllllIIIIlllIlIllIll]);
        lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIlIllIII][lllllllllllllllllIIIIlllIIlllllI].parent = null;
        int lllllllllllllllllIIIIlllIlIlIIlI = 0;
        while (lllllllllllllllllIIIIlllIlIlIIlI < lllllllllllllllllIIIIlllIlIIllII.maxSearchDistance && lllllllllllllllllIIIIlllIlIIllII.open.size() != 0) {
            int lllllllllllllllllIIIIlllIllIlIII = lllllllllllllllllIIIIlllIlIllllI;
            int lllllllllllllllllIIIIlllIllIIllI = lllllllllllllllllIIIIlllIlIllIll;
            if (lllllllllllllllllIIIIlllIlIIllII.current != null) {
                lllllllllllllllllIIIIlllIllIlIII = lllllllllllllllllIIIIlllIlIIllII.current.x;
                lllllllllllllllllIIIIlllIllIIllI = lllllllllllllllllIIIIlllIlIIllII.current.y;
            }
            lllllllllllllllllIIIIlllIlIIllII.current = lllllllllllllllllIIIIlllIlIIllII.getFirstInOpen();
            lllllllllllllllllIIIIlllIlIIllII.distance = lllllllllllllllllIIIIlllIlIIllII.current.depth;
            if (lllllllllllllllllIIIIlllIlIIllII.current == lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIlIllIII][lllllllllllllllllIIIIlllIIlllllI] && lllllllllllllllllIIIIlllIlIIllII.isValidLocation(lllllllllllllllllIIIIlllIllIIIIl, lllllllllllllllllIIIIlllIllIlIII, lllllllllllllllllIIIIlllIllIIllI, lllllllllllllllllIIIIlllIlIllIII, lllllllllllllllllIIIIlllIIlllllI)) break;
            lllllllllllllllllIIIIlllIlIIllII.removeFromOpen(lllllllllllllllllIIIIlllIlIIllII.current);
            lllllllllllllllllIIIIlllIlIIllII.addToClosed(lllllllllllllllllIIIIlllIlIIllII.current);
            for (int lllllllllllllllllIIIIlllIllIlIIl = -1; lllllllllllllllllIIIIlllIllIlIIl < 2; ++lllllllllllllllllIIIIlllIllIlIIl) {
                for (int lllllllllllllllllIIIIlllIllIlIll = -1; lllllllllllllllllIIIIlllIllIlIll < 2; ++lllllllllllllllllIIIIlllIllIlIll) {
                    if (lllllllllllllllllIIIIlllIllIlIIl == 0 && lllllllllllllllllIIIIlllIllIlIll == 0 || !lllllllllllllllllIIIIlllIlIIllII.allowDiagMovement && lllllllllllllllllIIIIlllIllIlIIl != 0 && lllllllllllllllllIIIIlllIllIlIll != 0) continue;
                    int lllllllllllllllllIIIIlllIllIllll = lllllllllllllllllIIIIlllIllIlIIl + lllllllllllllllllIIIIlllIlIIllII.current.x;
                    int lllllllllllllllllIIIIlllIllIllIl = lllllllllllllllllIIIIlllIllIlIll + lllllllllllllllllIIIIlllIlIIllII.current.y;
                    if (!lllllllllllllllllIIIIlllIlIIllII.isValidLocation(lllllllllllllllllIIIIlllIllIIIIl, lllllllllllllllllIIIIlllIlIIllII.current.x, lllllllllllllllllIIIIlllIlIIllII.current.y, lllllllllllllllllIIIIlllIllIllll, lllllllllllllllllIIIIlllIllIllIl)) continue;
                    float lllllllllllllllllIIIIlllIlllIIll = lllllllllllllllllIIIIlllIlIIllII.current.cost + lllllllllllllllllIIIIlllIlIIllII.getMovementCost(lllllllllllllllllIIIIlllIllIIIIl, lllllllllllllllllIIIIlllIlIIllII.current.x, lllllllllllllllllIIIIlllIlIIllII.current.y, lllllllllllllllllIIIIlllIllIllll, lllllllllllllllllIIIIlllIllIllIl);
                    Node lllllllllllllllllIIIIlllIlllIIIl = lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIllIllll][lllllllllllllllllIIIIlllIllIllIl];
                    lllllllllllllllllIIIIlllIlIIllII.map.pathFinderVisited(lllllllllllllllllIIIIlllIllIllll, lllllllllllllllllIIIIlllIllIllIl);
                    if (lllllllllllllllllIIIIlllIlllIIll < lllllllllllllllllIIIIlllIlllIIIl.cost) {
                        if (lllllllllllllllllIIIIlllIlIIllII.inOpenList(lllllllllllllllllIIIIlllIlllIIIl)) {
                            lllllllllllllllllIIIIlllIlIIllII.removeFromOpen(lllllllllllllllllIIIIlllIlllIIIl);
                        }
                        if (lllllllllllllllllIIIIlllIlIIllII.inClosedList(lllllllllllllllllIIIIlllIlllIIIl)) {
                            lllllllllllllllllIIIIlllIlIIllII.removeFromClosed(lllllllllllllllllIIIIlllIlllIIIl);
                        }
                    }
                    if (lllllllllllllllllIIIIlllIlIIllII.inOpenList(lllllllllllllllllIIIIlllIlllIIIl) || lllllllllllllllllIIIIlllIlIIllII.inClosedList(lllllllllllllllllIIIIlllIlllIIIl)) continue;
                    lllllllllllllllllIIIIlllIlllIIIl.cost = lllllllllllllllllIIIIlllIlllIIll;
                    lllllllllllllllllIIIIlllIlllIIIl.heuristic = lllllllllllllllllIIIIlllIlIIllII.getHeuristicCost(lllllllllllllllllIIIIlllIllIIIIl, lllllllllllllllllIIIIlllIllIllll, lllllllllllllllllIIIIlllIllIllIl, lllllllllllllllllIIIIlllIlIllIII, lllllllllllllllllIIIIlllIIlllllI);
                    lllllllllllllllllIIIIlllIlIlIIlI = Math.max(lllllllllllllllllIIIIlllIlIlIIlI, lllllllllllllllllIIIIlllIlllIIIl.setParent(lllllllllllllllllIIIIlllIlIIllII.current));
                    lllllllllllllllllIIIIlllIlIIllII.addToOpen(lllllllllllllllllIIIIlllIlllIIIl);
                }
            }
        }
        if (lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIlIllIII][lllllllllllllllllIIIIlllIIlllllI].parent == null) {
            return null;
        }
        Path lllllllllllllllllIIIIlllIlIlIIII = new Path();
        Node lllllllllllllllllIIIIlllIlIIlllI = lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIlIllIII][lllllllllllllllllIIIIlllIIlllllI];
        while (lllllllllllllllllIIIIlllIlIIlllI != lllllllllllllllllIIIIlllIlIIllII.nodes[lllllllllllllllllIIIIlllIlIllllI][lllllllllllllllllIIIIlllIlIllIll]) {
            lllllllllllllllllIIIIlllIlIlIIII.prependStep(lllllllllllllllllIIIIlllIlIIlllI.x, lllllllllllllllllIIIIlllIlIIlllI.y);
            lllllllllllllllllIIIIlllIlIIlllI = lllllllllllllllllIIIIlllIlIIlllI.parent;
        }
        lllllllllllllllllIIIIlllIlIlIIII.prependStep(lllllllllllllllllIIIIlllIlIllllI, lllllllllllllllllIIIIlllIlIllIll);
        return lllllllllllllllllIIIIlllIlIlIIII;
    }

    protected boolean inOpenList(Node lllllllllllllllllIIIIlllIIIIIlII) {
        return lllllllllllllllllIIIIlllIIIIIlII.isOpen();
    }

    protected void addToClosed(Node lllllllllllllllllIIIIllIlllllIIl) {
        AStarPathFinder lllllllllllllllllIIIIllIlllllIlI;
        lllllllllllllllllIIIIllIlllllIIl.setClosed(true);
        lllllllllllllllllIIIIllIlllllIlI.closed.add(lllllllllllllllllIIIIllIlllllIIl);
    }

    public int getCurrentX() {
        AStarPathFinder lllllllllllllllllIIIIlllIIIllIlI;
        if (lllllllllllllllllIIIIlllIIIllIlI.current == null) {
            return -1;
        }
        return lllllllllllllllllIIIIlllIIIllIlI.current.x;
    }

    @Override
    public int getSourceY() {
        AStarPathFinder lllllllllllllllllIIIIllIlIlIlIIl;
        return lllllllllllllllllIIIIllIlIlIlIIl.sourceY;
    }

    public float getMovementCost(Mover lllllllllllllllllIIIIllIllIlIIII, int lllllllllllllllllIIIIllIllIIllll, int lllllllllllllllllIIIIllIllIIlllI, int lllllllllllllllllIIIIllIllIIllIl, int lllllllllllllllllIIIIllIllIIIllI) {
        AStarPathFinder lllllllllllllllllIIIIllIllIIlIll;
        lllllllllllllllllIIIIllIllIIlIll.mover = lllllllllllllllllIIIIllIllIlIIII;
        lllllllllllllllllIIIIllIllIIlIll.sourceX = lllllllllllllllllIIIIllIllIIllll;
        lllllllllllllllllIIIIllIllIIlIll.sourceY = lllllllllllllllllIIIIllIllIIlllI;
        return lllllllllllllllllIIIIllIllIIlIll.map.getCost(lllllllllllllllllIIIIllIllIIlIll, lllllllllllllllllIIIIllIllIIllIl, lllllllllllllllllIIIIllIllIIIllI);
    }

    protected boolean isValidLocation(Mover lllllllllllllllllIIIIllIlllIIlII, int lllllllllllllllllIIIIllIllIlllII, int lllllllllllllllllIIIIllIlllIIIlI, int lllllllllllllllllIIIIllIllIllIlI, int lllllllllllllllllIIIIllIlllIIIII) {
        AStarPathFinder lllllllllllllllllIIIIllIlllIIlIl;
        boolean lllllllllllllllllIIIIllIllIlllll;
        boolean bl = lllllllllllllllllIIIIllIllIlllll = lllllllllllllllllIIIIllIllIllIlI < 0 || lllllllllllllllllIIIIllIlllIIIII < 0 || lllllllllllllllllIIIIllIllIllIlI >= lllllllllllllllllIIIIllIlllIIlIl.map.getWidthInTiles() || lllllllllllllllllIIIIllIlllIIIII >= lllllllllllllllllIIIIllIlllIIlIl.map.getHeightInTiles();
        if (!(lllllllllllllllllIIIIllIllIlllll || lllllllllllllllllIIIIllIllIlllII == lllllllllllllllllIIIIllIllIllIlI && lllllllllllllllllIIIIllIlllIIIlI == lllllllllllllllllIIIIllIlllIIIII)) {
            lllllllllllllllllIIIIllIlllIIlIl.mover = lllllllllllllllllIIIIllIlllIIlII;
            lllllllllllllllllIIIIllIlllIIlIl.sourceX = lllllllllllllllllIIIIllIllIlllII;
            lllllllllllllllllIIIIllIlllIIlIl.sourceY = lllllllllllllllllIIIIllIlllIIIlI;
            lllllllllllllllllIIIIllIllIlllll = lllllllllllllllllIIIIllIlllIIlIl.map.blocked(lllllllllllllllllIIIIllIlllIIlIl, lllllllllllllllllIIIIllIllIllIlI, lllllllllllllllllIIIIllIlllIIIII);
        }
        return !lllllllllllllllllIIIIllIllIlllll;
    }

    public AStarPathFinder(TileBasedMap lllllllllllllllllIIIIllllIllIIII, int lllllllllllllllllIIIIllllIllIlII, boolean lllllllllllllllllIIIIllllIlIlllI, AStarHeuristic lllllllllllllllllIIIIllllIlIllIl) {
        AStarPathFinder lllllllllllllllllIIIIllllIllIllI;
        lllllllllllllllllIIIIllllIllIllI.closed = new ArrayList();
        lllllllllllllllllIIIIllllIllIllI.open = lllllllllllllllllIIIIllllIllIllI.new PriorityList();
        lllllllllllllllllIIIIllllIllIllI.heuristic = lllllllllllllllllIIIIllllIlIllIl;
        lllllllllllllllllIIIIllllIllIllI.map = lllllllllllllllllIIIIllllIllIIII;
        lllllllllllllllllIIIIllllIllIllI.maxSearchDistance = lllllllllllllllllIIIIllllIllIlII;
        lllllllllllllllllIIIIllllIllIllI.allowDiagMovement = lllllllllllllllllIIIIllllIlIlllI;
        lllllllllllllllllIIIIllllIllIllI.nodes = new Node[lllllllllllllllllIIIIllllIllIIII.getWidthInTiles()][lllllllllllllllllIIIIllllIllIIII.getHeightInTiles()];
        for (int lllllllllllllllllIIIIllllIllIlll = 0; lllllllllllllllllIIIIllllIllIlll < lllllllllllllllllIIIIllllIllIIII.getWidthInTiles(); ++lllllllllllllllllIIIIllllIllIlll) {
            for (int lllllllllllllllllIIIIllllIlllIII = 0; lllllllllllllllllIIIIllllIlllIII < lllllllllllllllllIIIIllllIllIIII.getHeightInTiles(); ++lllllllllllllllllIIIIllllIlllIII) {
                lllllllllllllllllIIIIllllIllIllI.nodes[lllllllllllllllllIIIIllllIllIlll][lllllllllllllllllIIIIllllIlllIII] = lllllllllllllllllIIIIllllIllIllI.new Node(lllllllllllllllllIIIIllllIllIlll, lllllllllllllllllIIIIllllIlllIII);
            }
        }
    }

    public AStarPathFinder(TileBasedMap lllllllllllllllllIIIIlllllIIIIlI, int lllllllllllllllllIIIIlllllIIIIIl, boolean lllllllllllllllllIIIIlllllIIIlII) {
        lllllllllllllllllIIIIlllllIIIIll(lllllllllllllllllIIIIlllllIIIIlI, lllllllllllllllllIIIIlllllIIIIIl, lllllllllllllllllIIIIlllllIIIlII, new ClosestHeuristic());
        AStarPathFinder lllllllllllllllllIIIIlllllIIIIll;
    }

    public float getHeuristicCost(Mover lllllllllllllllllIIIIllIlIlllllI, int lllllllllllllllllIIIIllIlIllIlll, int lllllllllllllllllIIIIllIlIllIllI, int lllllllllllllllllIIIIllIlIllIlIl, int lllllllllllllllllIIIIllIlIlllIlI) {
        AStarPathFinder lllllllllllllllllIIIIllIlIllllll;
        return lllllllllllllllllIIIIllIlIllllll.heuristic.getCost(lllllllllllllllllIIIIllIlIllllll.map, lllllllllllllllllIIIIllIlIlllllI, lllllllllllllllllIIIIllIlIllIlll, lllllllllllllllllIIIIllIlIllIllI, lllllllllllllllllIIIIllIlIllIlIl, lllllllllllllllllIIIIllIlIlllIlI);
    }

    @Override
    public Mover getMover() {
        AStarPathFinder lllllllllllllllllIIIIllIlIllIIIl;
        return lllllllllllllllllIIIIllIlIllIIIl.mover;
    }

    protected Node getFirstInOpen() {
        AStarPathFinder lllllllllllllllllIIIIlllIIIIllll;
        return (Node)lllllllllllllllllIIIIlllIIIIllll.open.first();
    }

    protected void addToOpen(Node lllllllllllllllllIIIIlllIIIIIlll) {
        AStarPathFinder lllllllllllllllllIIIIlllIIIIlIII;
        lllllllllllllllllIIIIlllIIIIIlll.setOpen(true);
        lllllllllllllllllIIIIlllIIIIlIII.open.add(lllllllllllllllllIIIIlllIIIIIlll);
    }

    protected void removeFromClosed(Node lllllllllllllllllIIIIllIlllIllll) {
        AStarPathFinder lllllllllllllllllIIIIllIlllIlllI;
        lllllllllllllllllIIIIllIlllIllll.setClosed(false);
        lllllllllllllllllIIIIllIlllIlllI.closed.remove(lllllllllllllllllIIIIllIlllIllll);
    }

    @Override
    public int getSearchDistance() {
        AStarPathFinder lllllllllllllllllIIIIllIlIlIllll;
        return lllllllllllllllllIIIIllIlIlIllll.distance;
    }

    private class PriorityList {
        private /* synthetic */ List list;

        public void add(Object lllllllllllllllllIIIlIlIIIIIIlIl) {
            PriorityList lllllllllllllllllIIIlIlIIIIIlIIl;
            for (int lllllllllllllllllIIIlIlIIIIIlIll = 0; lllllllllllllllllIIIlIlIIIIIlIll < lllllllllllllllllIIIlIlIIIIIlIIl.list.size(); ++lllllllllllllllllIIIlIlIIIIIlIll) {
                if (((Comparable)lllllllllllllllllIIIlIlIIIIIlIIl.list.get(lllllllllllllllllIIIlIlIIIIIlIll)).compareTo(lllllllllllllllllIIIlIlIIIIIIlIl) <= 0) continue;
                lllllllllllllllllIIIlIlIIIIIlIIl.list.add(lllllllllllllllllIIIlIlIIIIIlIll, lllllllllllllllllIIIlIlIIIIIIlIl);
                break;
            }
            if (!lllllllllllllllllIIIlIlIIIIIlIIl.list.contains(lllllllllllllllllIIIlIlIIIIIIlIl)) {
                lllllllllllllllllIIIlIlIIIIIlIIl.list.add(lllllllllllllllllIIIlIlIIIIIIlIl);
            }
        }

        public String toString() {
            PriorityList lllllllllllllllllIIIlIIlllIlllll;
            String lllllllllllllllllIIIlIIlllIllllI = "{";
            for (int lllllllllllllllllIIIlIIllllIIIII = 0; lllllllllllllllllIIIlIIllllIIIII < lllllllllllllllllIIIlIIlllIlllll.size(); ++lllllllllllllllllIIIlIIllllIIIII) {
                lllllllllllllllllIIIlIIlllIllllI = String.valueOf(new StringBuilder().append(lllllllllllllllllIIIlIIlllIllllI).append(lllllllllllllllllIIIlIIlllIlllll.list.get(lllllllllllllllllIIIlIIllllIIIII).toString()).append(","));
            }
            lllllllllllllllllIIIlIIlllIllllI = String.valueOf(new StringBuilder().append(lllllllllllllllllIIIlIIlllIllllI).append("}"));
            return lllllllllllllllllIIIlIIlllIllllI;
        }

        private PriorityList() {
            PriorityList lllllllllllllllllIIIlIlIIIlIIIII;
            lllllllllllllllllIIIlIlIIIlIIIII.list = new LinkedList();
        }

        public void remove(Object lllllllllllllllllIIIlIIlllllIlll) {
            PriorityList lllllllllllllllllIIIlIIlllllllII;
            lllllllllllllllllIIIlIIlllllllII.list.remove(lllllllllllllllllIIIlIIlllllIlll);
        }

        public void clear() {
            PriorityList lllllllllllllllllIIIlIlIIIIllIIl;
            lllllllllllllllllIIIlIlIIIIllIIl.list.clear();
        }

        public boolean contains(Object lllllllllllllllllIIIlIIllllIlIlI) {
            PriorityList lllllllllllllllllIIIlIIllllIlIIl;
            return lllllllllllllllllIIIlIIllllIlIIl.list.contains(lllllllllllllllllIIIlIIllllIlIlI);
        }

        public int size() {
            PriorityList lllllllllllllllllIIIlIIlllllIIll;
            return lllllllllllllllllIIIlIIlllllIIll.list.size();
        }

        public Object first() {
            PriorityList lllllllllllllllllIIIlIlIIIIlllII;
            return lllllllllllllllllIIIlIlIIIIlllII.list.get(0);
        }
    }

    private class Node
    implements Comparable {
        private /* synthetic */ boolean closed;
        private /* synthetic */ float heuristic;
        private /* synthetic */ float cost;
        private /* synthetic */ int x;
        private /* synthetic */ int y;
        private /* synthetic */ int depth;
        private /* synthetic */ Node parent;
        private /* synthetic */ boolean open;

        public void setOpen(boolean lllllllllllllllllIIllllIllIIIIIl) {
            lllllllllllllllllIIllllIllIIIlII.open = lllllllllllllllllIIllllIllIIIIIl;
        }

        public boolean isClosed() {
            Node lllllllllllllllllIIllllIlIllIllI;
            return lllllllllllllllllIIllllIlIllIllI.closed;
        }

        public String toString() {
            Node lllllllllllllllllIIllllIlIllIIII;
            return String.valueOf(new StringBuilder().append("[Node ").append(lllllllllllllllllIIllllIlIllIIII.x).append(",").append(lllllllllllllllllIIllllIlIllIIII.y).append("]"));
        }

        public void setClosed(boolean lllllllllllllllllIIllllIlIlllIlI) {
            lllllllllllllllllIIllllIlIlllIIl.closed = lllllllllllllllllIIllllIlIlllIlI;
        }

        public Node(int lllllllllllllllllIIllllIlllIIIIl, int lllllllllllllllllIIllllIlllIIIII) {
            Node lllllllllllllllllIIllllIlllIIIlI;
            lllllllllllllllllIIllllIlllIIIlI.x = lllllllllllllllllIIllllIlllIIIIl;
            lllllllllllllllllIIllllIlllIIIlI.y = lllllllllllllllllIIllllIlllIIIII;
        }

        public int setParent(Node lllllllllllllllllIIllllIllIlIllI) {
            Node lllllllllllllllllIIllllIllIllIIl;
            lllllllllllllllllIIllllIllIllIIl.depth = lllllllllllllllllIIllllIllIlIllI.depth + 1;
            lllllllllllllllllIIllllIllIllIIl.parent = lllllllllllllllllIIllllIllIlIllI;
            return lllllllllllllllllIIllllIllIllIIl.depth;
        }

        public boolean isOpen() {
            Node lllllllllllllllllIIllllIlIlllllI;
            return lllllllllllllllllIIllllIlIlllllI.open;
        }

        public int compareTo(Object lllllllllllllllllIIllllIllIIlIlI) {
            Node lllllllllllllllllIIllllIllIIlIll;
            Node lllllllllllllllllIIllllIllIIlllI = (Node)lllllllllllllllllIIllllIllIIlIlI;
            float lllllllllllllllllIIllllIllIIllIl = lllllllllllllllllIIllllIllIIlIll.heuristic + lllllllllllllllllIIllllIllIIlIll.cost;
            float lllllllllllllllllIIllllIllIIllII = lllllllllllllllllIIllllIllIIlllI.heuristic + lllllllllllllllllIIllllIllIIlllI.cost;
            if (lllllllllllllllllIIllllIllIIllIl < lllllllllllllllllIIllllIllIIllII) {
                return -1;
            }
            if (lllllllllllllllllIIllllIllIIllIl > lllllllllllllllllIIllllIllIIllII) {
                return 1;
            }
            return 0;
        }

        public void reset() {
            lllllllllllllllllIIllllIlIllIIll.closed = false;
            lllllllllllllllllIIllllIlIllIIll.open = false;
            lllllllllllllllllIIllllIlIllIIll.cost = 0.0f;
            lllllllllllllllllIIllllIlIllIIll.depth = 0;
        }
    }
}

