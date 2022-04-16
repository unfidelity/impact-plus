/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.util.EnumFacing
 */
package me.axua.impactplus.util.render;

import java.util.HashMap;
import net.minecraft.util.EnumFacing;

public final class GeometryMasks {
    public static final /* synthetic */ HashMap<EnumFacing, Integer> FACEMAP;

    static {
        FACEMAP = new HashMap();
        FACEMAP.put(EnumFacing.DOWN, 1);
        FACEMAP.put(EnumFacing.WEST, 16);
        FACEMAP.put(EnumFacing.NORTH, 4);
        FACEMAP.put(EnumFacing.SOUTH, 8);
        FACEMAP.put(EnumFacing.EAST, 32);
        FACEMAP.put(EnumFacing.UP, 2);
    }

    public GeometryMasks() {
        GeometryMasks lIIIlIIIlIl;
    }

    public static final class Line {
        public static final /* synthetic */ int UP_WEST;
        public static final /* synthetic */ int DOWN_NORTH;
        public static final /* synthetic */ int UP_EAST;
        public static final /* synthetic */ int NORTH_EAST;
        public static final /* synthetic */ int UP_NORTH;
        public static final /* synthetic */ int SOUTH_WEST;
        public static final /* synthetic */ int UP_SOUTH;
        public static final /* synthetic */ int NORTH_WEST;
        public static final /* synthetic */ int DOWN_EAST;
        public static final /* synthetic */ int ALL;
        public static final /* synthetic */ int DOWN_SOUTH;
        public static final /* synthetic */ int SOUTH_EAST;
        public static final /* synthetic */ int DOWN_WEST;

        static {
            UP_NORTH = 6;
            UP_WEST = 18;
            DOWN_EAST = 33;
            UP_EAST = 34;
            DOWN_SOUTH = 9;
            ALL = 63;
            NORTH_EAST = 36;
            UP_SOUTH = 10;
            NORTH_WEST = 20;
            SOUTH_EAST = 40;
            DOWN_WEST = 17;
            SOUTH_WEST = 24;
            DOWN_NORTH = 5;
        }

        public Line() {
            Line lllllllllllllllllIIlllllIIIlIlII;
        }
    }

    public static final class Quad {
        public static final /* synthetic */ int UP;
        public static final /* synthetic */ int ALL;
        public static final /* synthetic */ int SOUTH;
        public static final /* synthetic */ int DOWN;
        public static final /* synthetic */ int EAST;
        public static final /* synthetic */ int WEST;
        public static final /* synthetic */ int NORTH;

        public Quad() {
            Quad lllllIIIllll;
        }

        static {
            NORTH = 4;
            DOWN = 1;
            UP = 2;
            EAST = 32;
            SOUTH = 8;
            WEST = 16;
            ALL = 63;
        }
    }
}

