/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.pathfinding;

import java.io.Serializable;
import java.util.ArrayList;

public class Path
implements Serializable {
    private static final /* synthetic */ long serialVersionUID = 1L;
    private /* synthetic */ ArrayList steps;

    public Path() {
        Path lIIIlIIlIl;
        lIIIlIIlIl.steps = new ArrayList();
    }

    public int getLength() {
        Path lIIIlIIIlI;
        return lIIIlIIIlI.steps.size();
    }

    public Step getStep(int lIIIIlllII) {
        Path lIIIIlllIl;
        return (Step)lIIIIlllIl.steps.get(lIIIIlllII);
    }

    public int getX(int lIIIIlIllI) {
        Path lIIIIllIIl;
        return lIIIIllIIl.getStep(lIIIIlIllI).x;
    }

    public void appendStep(int lIIIIIlIII, int lIIIIIIlll) {
        Path lIIIIIlIIl;
        lIIIIIlIIl.steps.add(lIIIIIlIIl.new Step(lIIIIIlIII, lIIIIIIlll));
    }

    public boolean contains(int llllllIIl, int lllllIlIl) {
        Path llllllIlI;
        return llllllIlI.steps.contains(llllllIlI.new Step(llllllIIl, lllllIlIl));
    }

    public int getY(int lIIIIlIIlI) {
        Path lIIIIlIIll;
        return lIIIIlIIll.getStep(lIIIIlIIlI).y;
    }

    public void prependStep(int lIIIIIIIlI, int llllllllI) {
        Path lIIIIIIIII;
        lIIIIIIIII.steps.add(0, lIIIIIIIII.new Step(lIIIIIIIlI, llllllllI));
    }

    public class Step
    implements Serializable {
        private /* synthetic */ int y;
        private /* synthetic */ int x;

        public int hashCode() {
            Step lllllllllllllllllllIIIIlIlIllIII;
            return lllllllllllllllllllIIIIlIlIllIII.x * lllllllllllllllllllIIIIlIlIllIII.y;
        }

        public boolean equals(Object lllllllllllllllllllIIIIlIlIlIIlI) {
            if (lllllllllllllllllllIIIIlIlIlIIlI instanceof Step) {
                Step lllllllllllllllllllIIIIlIlIlIIIl;
                Step lllllllllllllllllllIIIIlIlIlIlII = (Step)lllllllllllllllllllIIIIlIlIlIIlI;
                return lllllllllllllllllllIIIIlIlIlIlII.x == lllllllllllllllllllIIIIlIlIlIIIl.x && lllllllllllllllllllIIIIlIlIlIlII.y == lllllllllllllllllllIIIIlIlIlIIIl.y;
            }
            return false;
        }

        public int getY() {
            Step lllllllllllllllllllIIIIlIlIlllII;
            return lllllllllllllllllllIIIIlIlIlllII.y;
        }

        public Step(int lllllllllllllllllllIIIIlIllIllll, int lllllllllllllllllllIIIIlIllIlllI) {
            Step lllllllllllllllllllIIIIlIlllIIII;
            lllllllllllllllllllIIIIlIlllIIII.x = lllllllllllllllllllIIIIlIllIllll;
            lllllllllllllllllllIIIIlIlllIIII.y = lllllllllllllllllllIIIIlIllIlllI;
        }

        public int getX() {
            Step lllllllllllllllllllIIIIlIllIIIII;
            return lllllllllllllllllllIIIIlIllIIIII.x;
        }
    }
}

