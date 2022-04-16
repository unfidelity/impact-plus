/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.util.rainbow;

import java.util.ArrayList;
import me.axua.impactplus.util.Timer;
import me.axua.impactplus.util.rainbow.ColorUtil;

public class SalRainbowUtil {
    private /* synthetic */ Timer RainbowSpeed;
    private /* synthetic */ ArrayList<Integer> RainbowArrayList;
    private /* synthetic */ int m_Timer;
    private /* synthetic */ ArrayList<Integer> CurrentRainbowIndexes;

    public SalRainbowUtil(int lllllllllllllllIlllIIlIlIIIlIlll) {
        SalRainbowUtil lllllllllllllllIlllIIlIlIIIllIII;
        lllllllllllllllIlllIIlIlIIIllIII.CurrentRainbowIndexes = new ArrayList();
        lllllllllllllllIlllIIlIlIIIllIII.RainbowArrayList = new ArrayList();
        lllllllllllllllIlllIIlIlIIIllIII.RainbowSpeed = new Timer();
        lllllllllllllllIlllIIlIlIIIllIII.m_Timer = lllllllllllllllIlllIIlIlIIIlIlll;
        for (int lllllllllllllllIlllIIlIlIIIllIIl = 0; lllllllllllllllIlllIIlIlIIIllIIl < 360; ++lllllllllllllllIlllIIlIlIIIllIIl) {
            lllllllllllllllIlllIIlIlIIIllIII.RainbowArrayList.add(ColorUtil.GetRainbowColor(lllllllllllllllIlllIIlIlIIIllIIl, 90.0f, 50.0f, 1.0f).getRGB());
            lllllllllllllllIlllIIlIlIIIllIII.CurrentRainbowIndexes.add(lllllllllllllllIlllIIlIlIIIllIIl);
        }
    }

    public int GetRainbowColorAt(int lllllllllllllllIlllIIlIlIIIlIIII) {
        SalRainbowUtil lllllllllllllllIlllIIlIlIIIIllll;
        if (lllllllllllllllIlllIIlIlIIIlIIII > lllllllllllllllIlllIIlIlIIIIllll.CurrentRainbowIndexes.size() - 1) {
            lllllllllllllllIlllIIlIlIIIlIIII = lllllllllllllllIlllIIlIlIIIIllll.CurrentRainbowIndexes.size() - 1;
        }
        return lllllllllllllllIlllIIlIlIIIIllll.RainbowArrayList.get(lllllllllllllllIlllIIlIlIIIIllll.CurrentRainbowIndexes.get(lllllllllllllllIlllIIlIlIIIlIIII));
    }

    private void MoveListToNextColor() {
        SalRainbowUtil lllllllllllllllIlllIIlIlIIIIIIII;
        if (lllllllllllllllIlllIIlIlIIIIIIII.CurrentRainbowIndexes.isEmpty()) {
            return;
        }
        lllllllllllllllIlllIIlIlIIIIIIII.CurrentRainbowIndexes.remove(lllllllllllllllIlllIIlIlIIIIIIII.CurrentRainbowIndexes.get(0));
        int lllllllllllllllIlllIIlIlIIIIIIIl = lllllllllllllllIlllIIlIlIIIIIIII.CurrentRainbowIndexes.get(lllllllllllllllIlllIIlIlIIIIIIII.CurrentRainbowIndexes.size() - 1) + 1;
        if (lllllllllllllllIlllIIlIlIIIIIIIl >= lllllllllllllllIlllIIlIlIIIIIIII.RainbowArrayList.size() - 1) {
            lllllllllllllllIlllIIlIlIIIIIIIl = 0;
        }
        lllllllllllllllIlllIIlIlIIIIIIII.CurrentRainbowIndexes.add(lllllllllllllllIlllIIlIlIIIIIIIl);
    }

    public void OnRender() {
        SalRainbowUtil lllllllllllllllIlllIIlIlIIIIIllI;
        if (lllllllllllllllIlllIIlIlIIIIIllI.RainbowSpeed.passed(lllllllllllllllIlllIIlIlIIIIIllI.m_Timer)) {
            lllllllllllllllIlllIIlIlIIIIIllI.RainbowSpeed.reset();
            lllllllllllllllIlllIIlIlIIIIIllI.MoveListToNextColor();
        }
    }

    public void SetTimer(int lllllllllllllllIlllIIlIlIIIIlIlI) {
        lllllllllllllllIlllIIlIlIIIIlIll.m_Timer = lllllllllllllllIlllIIlIlIIIIlIlI;
    }
}

