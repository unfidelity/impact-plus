/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public final class MathUtil {
    public static Vec3d direction(float llllllllllllllllIIllIIIIlIllllll) {
        return new Vec3d(Math.cos(MathUtil.degToRad(llllllllllllllllIIllIIIIlIllllll + 90.0f)), 0.0, Math.sin(MathUtil.degToRad(llllllllllllllllIIllIIIIlIllllll + 90.0f)));
    }

    public static double calculateAngle(double llllllllllllllllIIllIIIIIIIIlIll, double llllllllllllllllIIllIIIIIIIIllll, double llllllllllllllllIIllIIIIIIIIlIIl, double llllllllllllllllIIllIIIIIIIIlIII) {
        double llllllllllllllllIIllIIIIIIIIllII = Math.toDegrees(Math.atan2(llllllllllllllllIIllIIIIIIIIlIIl - llllllllllllllllIIllIIIIIIIIlIll, llllllllllllllllIIllIIIIIIIIlIII - llllllllllllllllIIllIIIIIIIIllll));
        llllllllllllllllIIllIIIIIIIIllII += Math.ceil(-llllllllllllllllIIllIIIIIIIIllII / 360.0) * 360.0;
        return llllllllllllllllIIllIIIIIIIIllII;
    }

    public static double getDistance(Vec3d llllllllllllllllIIllIIIIIIlllllI, double llllllllllllllllIIllIIIIIIllllIl, double llllllllllllllllIIllIIIIIIllIlIl, double llllllllllllllllIIllIIIIIIllIlII) {
        double llllllllllllllllIIllIIIIIIlllIlI = llllllllllllllllIIllIIIIIIlllllI.xCoord - llllllllllllllllIIllIIIIIIllllIl;
        double llllllllllllllllIIllIIIIIIlllIIl = llllllllllllllllIIllIIIIIIlllllI.yCoord - llllllllllllllllIIllIIIIIIllIlIl;
        double llllllllllllllllIIllIIIIIIlllIII = llllllllllllllllIIllIIIIIIlllllI.zCoord - llllllllllllllllIIllIIIIIIllIlII;
        return MathHelper.sqrt_double((double)(llllllllllllllllIIllIIIIIIlllIlI * llllllllllllllllIIllIIIIIIlllIlI + llllllllllllllllIIllIIIIIIlllIIl * llllllllllllllllIIllIIIIIIlllIIl + llllllllllllllllIIllIIIIIIlllIII * llllllllllllllllIIllIIIIIIlllIII));
    }

    public static Vec3d div(Vec3d llllllllllllllllIIllIIIIIlllllII, float llllllllllllllllIIllIIIIIllllIll) {
        return new Vec3d(llllllllllllllllIIllIIIIIlllllII.xCoord / (double)llllllllllllllllIIllIIIIIllllIll, llllllllllllllllIIllIIIIIlllllII.yCoord / (double)llllllllllllllllIIllIIIIIllllIll, llllllllllllllllIIllIIIIIlllllII.zCoord / (double)llllllllllllllllIIllIIIIIllllIll);
    }

    public static double round(double llllllllllllllllIIllIIIIIlllIlII, int llllllllllllllllIIllIIIIIlllIIll) {
        if (llllllllllllllllIIllIIIIIlllIIll < 0) {
            return llllllllllllllllIIllIIIIIlllIlII;
        }
        return new BigDecimal(llllllllllllllllIIllIIIIIlllIlII).setScale(llllllllllllllllIIllIIIIIlllIIll, RoundingMode.HALF_UP).doubleValue();
    }

    public static float[] calcAngle(Vec3d llllllllllllllllIIllIIIIlIllIlll, Vec3d llllllllllllllllIIllIIIIlIllIIII) {
        double llllllllllllllllIIllIIIIlIllIlIl = llllllllllllllllIIllIIIIlIllIIII.xCoord - llllllllllllllllIIllIIIIlIllIlll.xCoord;
        double llllllllllllllllIIllIIIIlIllIlII = (llllllllllllllllIIllIIIIlIllIIII.yCoord - llllllllllllllllIIllIIIIlIllIlll.yCoord) * -1.0;
        double llllllllllllllllIIllIIIIlIllIIll = llllllllllllllllIIllIIIIlIllIIII.zCoord - llllllllllllllllIIllIIIIlIllIlll.zCoord;
        double llllllllllllllllIIllIIIIlIllIIlI = MathHelper.sqrt_double((double)(llllllllllllllllIIllIIIIlIllIlIl * llllllllllllllllIIllIIIIlIllIlIl + llllllllllllllllIIllIIIIlIllIIll * llllllllllllllllIIllIIIIlIllIIll));
        return new float[]{(float)MathHelper.wrapAngleTo180_double((double)(Math.toDegrees(Math.atan2(llllllllllllllllIIllIIIIlIllIIll, llllllllllllllllIIllIIIIlIllIlIl)) - 90.0)), (float)MathHelper.wrapAngleTo180_double((double)Math.toDegrees(Math.atan2(llllllllllllllllIIllIIIIlIllIlII, llllllllllllllllIIllIIIIlIllIIlI)))};
    }

    public static double linear(double llllllllllllllllIIllIIIIIlIlIlII, double llllllllllllllllIIllIIIIIlIlIIll, double llllllllllllllllIIllIIIIIlIlIIlI) {
        return llllllllllllllllIIllIIIIIlIlIlII < llllllllllllllllIIllIIIIIlIlIIll - llllllllllllllllIIllIIIIIlIlIIlI ? llllllllllllllllIIllIIIIIlIlIlII + llllllllllllllllIIllIIIIIlIlIIlI : (llllllllllllllllIIllIIIIIlIlIlII > llllllllllllllllIIllIIIIIlIlIIll + llllllllllllllllIIllIIIIIlIlIIlI ? llllllllllllllllIIllIIIIIlIlIlII - llllllllllllllllIIllIIIIIlIlIIlI : llllllllllllllllIIllIIIIIlIlIIll);
    }

    public static Vec3d div(Vec3d llllllllllllllllIIllIIIIlIIIIIII, Vec3d llllllllllllllllIIllIIIIIlllllll) {
        return new Vec3d(llllllllllllllllIIllIIIIlIIIIIII.xCoord / llllllllllllllllIIllIIIIIlllllll.xCoord, llllllllllllllllIIllIIIIlIIIIIII.yCoord / llllllllllllllllIIllIIIIIlllllll.yCoord, llllllllllllllllIIllIIIIlIIIIIII.zCoord / llllllllllllllllIIllIIIIIlllllll.zCoord);
    }

    public static float clamp(float llllllllllllllllIIllIIIIIllIllll, float llllllllllllllllIIllIIIIIllIlIll, float llllllllllllllllIIllIIIIIllIlIlI) {
        if (llllllllllllllllIIllIIIIIllIllll <= llllllllllllllllIIllIIIIIllIlIll) {
            llllllllllllllllIIllIIIIIllIllll = llllllllllllllllIIllIIIIIllIlIll;
        }
        if (llllllllllllllllIIllIIIIIllIllll >= llllllllllllllllIIllIIIIIllIlIlI) {
            llllllllllllllllIIllIIIIIllIllll = llllllllllllllllIIllIIIIIllIlIlI;
        }
        return llllllllllllllllIIllIIIIIllIllll;
    }

    public static Vec3d interpolateEntity(Entity llllllllllllllllIIllIIIIllIIlIII, float llllllllllllllllIIllIIIIllIIlIIl) {
        return new Vec3d(llllllllllllllllIIllIIIIllIIlIII.lastTickPosX + (llllllllllllllllIIllIIIIllIIlIII.posX - llllllllllllllllIIllIIIIllIIlIII.lastTickPosX) * (double)llllllllllllllllIIllIIIIllIIlIIl, llllllllllllllllIIllIIIIllIIlIII.lastTickPosY + (llllllllllllllllIIllIIIIllIIlIII.posY - llllllllllllllllIIllIIIIllIIlIII.lastTickPosY) * (double)llllllllllllllllIIllIIIIllIIlIIl, llllllllllllllllIIllIIIIllIIlIII.lastTickPosZ + (llllllllllllllllIIllIIIIllIIlIII.posZ - llllllllllllllllIIllIIIIllIIlIII.lastTickPosZ) * (double)llllllllllllllllIIllIIIIllIIlIIl);
    }

    public static Vec3d mult(Vec3d llllllllllllllllIIllIIIIlIIIllII, Vec3d llllllllllllllllIIllIIIIlIIIllIl) {
        return new Vec3d(llllllllllllllllIIllIIIIlIIIllII.xCoord * llllllllllllllllIIllIIIIlIIIllIl.xCoord, llllllllllllllllIIllIIIIlIIIllII.yCoord * llllllllllllllllIIllIIIIlIIIllIl.yCoord, llllllllllllllllIIllIIIIlIIIllII.zCoord * llllllllllllllllIIllIIIIlIIIllIl.zCoord);
    }

    public static double degToRad(double llllllllllllllllIIllIIIIllIIIIIl) {
        return llllllllllllllllIIllIIIIllIIIIIl * 0.01745329238474369;
    }

    public static double parabolic(double llllllllllllllllIIllIIIIIlIIlIII, double llllllllllllllllIIllIIIIIlIIlIlI, double llllllllllllllllIIllIIIIIlIIIllI) {
        return llllllllllllllllIIllIIIIIlIIlIII + (llllllllllllllllIIllIIIIIlIIlIlI - llllllllllllllllIIllIIIIIlIIlIII) / llllllllllllllllIIllIIIIIlIIIllI;
    }

    public MathUtil() {
        MathUtil llllllllllllllllIIllIIIIllIIlllI;
    }

    public static double[] calcIntersection(double[] llllllllllllllllIIllIIIIIIIllllI, double[] llllllllllllllllIIllIIIIIIIlllIl) {
        double llllllllllllllllIIllIIIIIIlIIlIl = llllllllllllllllIIllIIIIIIIllllI[3] - llllllllllllllllIIllIIIIIIIllllI[1];
        double llllllllllllllllIIllIIIIIIlIIlII = llllllllllllllllIIllIIIIIIIllllI[0] - llllllllllllllllIIllIIIIIIIllllI[2];
        double llllllllllllllllIIllIIIIIIlIIIll = llllllllllllllllIIllIIIIIIlIIlIl * llllllllllllllllIIllIIIIIIIllllI[0] + llllllllllllllllIIllIIIIIIlIIlII * llllllllllllllllIIllIIIIIIIllllI[1];
        double llllllllllllllllIIllIIIIIIlIIIlI = llllllllllllllllIIllIIIIIIIlllIl[3] - llllllllllllllllIIllIIIIIIIlllIl[1];
        double llllllllllllllllIIllIIIIIIlIIIIl = llllllllllllllllIIllIIIIIIIlllIl[0] - llllllllllllllllIIllIIIIIIIlllIl[2];
        double llllllllllllllllIIllIIIIIIlIIIII = llllllllllllllllIIllIIIIIIlIIIlI * llllllllllllllllIIllIIIIIIIlllIl[0] + llllllllllllllllIIllIIIIIIlIIIIl * llllllllllllllllIIllIIIIIIIlllIl[1];
        double llllllllllllllllIIllIIIIIIIlllll = llllllllllllllllIIllIIIIIIlIIlIl * llllllllllllllllIIllIIIIIIlIIIIl - llllllllllllllllIIllIIIIIIlIIIlI * llllllllllllllllIIllIIIIIIlIIlII;
        return new double[]{(llllllllllllllllIIllIIIIIIlIIIIl * llllllllllllllllIIllIIIIIIlIIIll - llllllllllllllllIIllIIIIIIlIIlII * llllllllllllllllIIllIIIIIIlIIIII) / llllllllllllllllIIllIIIIIIIlllll, (llllllllllllllllIIllIIIIIIlIIlIl * llllllllllllllllIIllIIIIIIlIIIII - llllllllllllllllIIllIIIIIIlIIIlI * llllllllllllllllIIllIIIIIIlIIIll) / llllllllllllllllIIllIIIIIIIlllll};
    }

    public static Vec3d mult(Vec3d llllllllllllllllIIllIIIIlIIIlIII, float llllllllllllllllIIllIIIIlIIIIlll) {
        return new Vec3d(llllllllllllllllIIllIIIIlIIIlIII.xCoord * (double)llllllllllllllllIIllIIIIlIIIIlll, llllllllllllllllIIllIIIIlIIIlIII.yCoord * (double)llllllllllllllllIIllIIIIlIIIIlll, llllllllllllllllIIllIIIIlIIIlIII.zCoord * (double)llllllllllllllllIIllIIIIlIIIIlll);
    }

    public static double radToDeg(double llllllllllllllllIIllIIIIllIIIlII) {
        return llllllllllllllllIIllIIIIllIIIlII * (double)57.29578f;
    }

    public static double map(double llllllllllllllllIIllIIIIIlIlllII, double llllllllllllllllIIllIIIIIlIllIll, double llllllllllllllllIIllIIIIIlIlllll, double llllllllllllllllIIllIIIIIlIllIIl, double llllllllllllllllIIllIIIIIlIllIII) {
        llllllllllllllllIIllIIIIIlIlllII = (llllllllllllllllIIllIIIIIlIlllII - llllllllllllllllIIllIIIIIlIllIll) / (llllllllllllllllIIllIIIIIlIlllll - llllllllllllllllIIllIIIIIlIllIll);
        return llllllllllllllllIIllIIIIIlIllIIl + llllllllllllllllIIllIIIIIlIlllII * (llllllllllllllllIIllIIIIIlIllIII - llllllllllllllllIIllIIIIIlIllIIl);
    }

    public static float wrap(float llllllllllllllllIIllIIIIIllIlIII) {
        if ((llllllllllllllllIIllIIIIIllIlIII %= 360.0f) >= 180.0f) {
            llllllllllllllllIIllIIIIIllIlIII -= 360.0f;
        }
        if (llllllllllllllllIIllIIIIIllIlIII < -180.0f) {
            llllllllllllllllIIllIIIIIllIlIII += 360.0f;
        }
        return llllllllllllllllIIllIIIIIllIlIII;
    }

    public static double[] directionSpeed(double llllllllllllllllIIllIIIIlIlIIIlI) {
        Minecraft llllllllllllllllIIllIIIIlIlIIIIl = Minecraft.getMinecraft();
        float llllllllllllllllIIllIIIIlIlIIIII = llllllllllllllllIIllIIIIlIlIIIIl.thePlayer.movementInput.field_192832_b;
        float llllllllllllllllIIllIIIIlIIlllll = llllllllllllllllIIllIIIIlIlIIIIl.thePlayer.movementInput.moveStrafe;
        float llllllllllllllllIIllIIIIlIIllllI = llllllllllllllllIIllIIIIlIlIIIIl.thePlayer.prevRotationYaw + (llllllllllllllllIIllIIIIlIlIIIIl.thePlayer.rotationYaw - llllllllllllllllIIllIIIIlIlIIIIl.thePlayer.prevRotationYaw) * llllllllllllllllIIllIIIIlIlIIIIl.func_184121_ak();
        if (llllllllllllllllIIllIIIIlIlIIIII != 0.0f) {
            if (llllllllllllllllIIllIIIIlIIlllll > 0.0f) {
                llllllllllllllllIIllIIIIlIIllllI += (float)(llllllllllllllllIIllIIIIlIlIIIII > 0.0f ? -45 : 45);
            } else if (llllllllllllllllIIllIIIIlIIlllll < 0.0f) {
                llllllllllllllllIIllIIIIlIIllllI += (float)(llllllllllllllllIIllIIIIlIlIIIII > 0.0f ? 45 : -45);
            }
            llllllllllllllllIIllIIIIlIIlllll = 0.0f;
            if (llllllllllllllllIIllIIIIlIlIIIII > 0.0f) {
                llllllllllllllllIIllIIIIlIlIIIII = 1.0f;
            } else if (llllllllllllllllIIllIIIIlIlIIIII < 0.0f) {
                llllllllllllllllIIllIIIIlIlIIIII = -1.0f;
            }
        }
        double llllllllllllllllIIllIIIIlIIlllIl = Math.sin(Math.toRadians(llllllllllllllllIIllIIIIlIIllllI + 90.0f));
        double llllllllllllllllIIllIIIIlIIlllII = Math.cos(Math.toRadians(llllllllllllllllIIllIIIIlIIllllI + 90.0f));
        double llllllllllllllllIIllIIIIlIIllIll = (double)llllllllllllllllIIllIIIIlIlIIIII * llllllllllllllllIIllIIIIlIlIIIlI * llllllllllllllllIIllIIIIlIIlllII + (double)llllllllllllllllIIllIIIIlIIlllll * llllllllllllllllIIllIIIIlIlIIIlI * llllllllllllllllIIllIIIIlIIlllIl;
        double llllllllllllllllIIllIIIIlIIllIlI = (double)llllllllllllllllIIllIIIIlIlIIIII * llllllllllllllllIIllIIIIlIlIIIlI * llllllllllllllllIIllIIIIlIIlllIl - (double)llllllllllllllllIIllIIIIlIIlllll * llllllllllllllllIIllIIIIlIlIIIlI * llllllllllllllllIIllIIIIlIIlllII;
        return new double[]{llllllllllllllllIIllIIIIlIIllIll, llllllllllllllllIIllIIIIlIIllIlI};
    }
}

