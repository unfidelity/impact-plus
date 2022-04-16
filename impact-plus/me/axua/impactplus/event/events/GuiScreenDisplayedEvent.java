/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package me.axua.impactplus.event.events;

import me.axua.impactplus.event.ImpactPlusEvent;
import net.minecraft.client.gui.GuiScreen;

public class GuiScreenDisplayedEvent
extends ImpactPlusEvent {
    private final /* synthetic */ GuiScreen guiScreen;

    public GuiScreenDisplayedEvent(GuiScreen llIllIIIIIlIlII) {
        GuiScreenDisplayedEvent llIllIIIIIlIlll;
        llIllIIIIIlIlll.guiScreen = llIllIIIIIlIlII;
    }

    public GuiScreen getScreen() {
        GuiScreenDisplayedEvent llIllIIIIIlIIlI;
        return llIllIIIIIlIIlI.guiScreen;
    }
}

