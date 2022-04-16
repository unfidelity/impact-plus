/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  javax.annotation.Nullable
 *  net.minecraft.client.Minecraft
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Post
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package me.axua.impactplus.hud;

import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.hud.components.ArrayListComponent;
import me.axua.impactplus.hud.components.BedsComponent;
import me.axua.impactplus.hud.components.BiomeComponent;
import me.axua.impactplus.hud.components.BpsComponent;
import me.axua.impactplus.hud.components.BrownmanClientComponent;
import me.axua.impactplus.hud.components.ClosestComponent;
import me.axua.impactplus.hud.components.CoordsComponent;
import me.axua.impactplus.hud.components.DimensionComponent;
import me.axua.impactplus.hud.components.DirectionComponent;
import me.axua.impactplus.hud.components.DurabilityComponent;
import me.axua.impactplus.hud.components.FpsComponent;
import me.axua.impactplus.hud.components.GamemodeComponent;
import me.axua.impactplus.hud.components.ImageComponent;
import me.axua.impactplus.hud.components.InventoryComponent;
import me.axua.impactplus.hud.components.IpComponent;
import me.axua.impactplus.hud.components.LagComponent;
import me.axua.impactplus.hud.components.OnlineComponent;
import me.axua.impactplus.hud.components.PingComponent;
import me.axua.impactplus.hud.components.PlayerComponent;
import me.axua.impactplus.hud.components.ShulkerSpyComponent;
import me.axua.impactplus.hud.components.TotemsComponent;
import me.axua.impactplus.hud.components.TpsComponent;
import me.axua.impactplus.hud.components.WatermarkComponent;
import me.axua.impactplus.hud.components.WelcomeComponent;
import me.axua.impactplus.hudgui.HudGui;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HudComponentManager {
    /* synthetic */ Minecraft mc;
    private /* synthetic */ List<HudComponent> components;

    @SubscribeEvent
    public void onRender2D(RenderGameOverlayEvent.Post llIIllllII) {
        HudComponentManager llIIlllIll;
        if (!Minecraft.getMinecraft().gameSettings.showDebugInfo && llIIllllII.getType().equals((Object)RenderGameOverlayEvent.ElementType.HOTBAR) && !(llIIlllIll.mc.currentScreen instanceof HudGui)) {
            for (HudComponent llIIlllllI : llIIlllIll.components) {
                if (llIIlllllI.isInvisible()) continue;
                llIIlllllI.render();
            }
        }
    }

    public HudComponentManager() {
        HudComponentManager llIlIlIIlI;
        llIlIlIIlI.mc = Minecraft.getMinecraft();
        llIlIlIIlI.components = Lists.newArrayList((Object[])new HudComponent[]{new WatermarkComponent(), new WelcomeComponent(), new FpsComponent(), new TpsComponent(), new BpsComponent(), new PingComponent(), new DurabilityComponent(), new OnlineComponent(), new IpComponent(), new BiomeComponent(), new DimensionComponent(), new GamemodeComponent(), new ArrayListComponent(), new BrownmanClientComponent(), new InventoryComponent(), new PlayerComponent(), new CoordsComponent(), new DirectionComponent(), new TotemsComponent(), new BedsComponent(), new ClosestComponent(), new LagComponent(), new ShulkerSpyComponent(), new ImageComponent()});
        MinecraftForge.EVENT_BUS.register((Object)llIlIlIIlI);
    }

    @Nullable
    public HudComponent getComponentByName(String llIlIIIlIl) {
        HudComponentManager llIlIIIllI;
        for (HudComponent llIlIIlIIl : llIlIIIllI.components) {
            if (!llIlIIlIIl.getName().equalsIgnoreCase(llIlIIIlIl)) continue;
            return llIlIIlIIl;
        }
        return null;
    }

    public List<HudComponent> getComponents() {
        HudComponentManager llIlIIllll;
        return llIlIIllll.components;
    }
}

