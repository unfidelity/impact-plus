/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.biome.Biome
 *  net.minecraft.world.chunk.Chunk
 */
package me.axua.impactplus.hud.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.hud.Biome;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class BiomeComponent
extends HudComponent<Biome> {
    /* synthetic */ HudColours mod;
    /* synthetic */ Minecraft mc;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ int fort;

    @Override
    public void render() {
        Color lllllllllllllllllIllllIlIlIIlIlI;
        BiomeComponent lllllllllllllllllIllllIlIlIIIIII;
        super.render();
        if (lllllllllllllllllIllllIlIlIIIIII.mod.rainbow.getValue()) {
            Color lllllllllllllllllIllllIlIlIIllIl = Rainbow.getColorWithOpacity(255);
        } else {
            lllllllllllllllllIllllIlIlIIlIlI = new Color(lllllllllllllllllIllllIlIlIIIIII.mod.red.getValue(), lllllllllllllllllIllllIlIlIIIIII.mod.green.getValue(), lllllllllllllllllIllllIlIlIIIIII.mod.blue.getValue(), 255);
        }
        Minecraft lllllllllllllllllIllllIlIlIIlIIl = Minecraft.getMinecraft();
        BlockPos lllllllllllllllllIllllIlIlIIIlll = lllllllllllllllllIllllIlIlIIlIIl.thePlayer.getPosition();
        Chunk lllllllllllllllllIllllIlIlIIIlIl = lllllllllllllllllIllllIlIlIIlIIl.theWorld.getChunkFromBlockCoords(lllllllllllllllllIllllIlIlIIIlll);
        net.minecraft.world.biome.Biome lllllllllllllllllIllllIlIlIIIlII = lllllllllllllllllIllllIlIlIIIlIl.getBiome(lllllllllllllllllIllllIlIlIIIlll, lllllllllllllllllIllllIlIlIIlIIl.theWorld.getWorldChunkManager());
        String lllllllllllllllllIllllIlIlIIIIlI = String.valueOf(new StringBuilder().append("Biome ").append(ChatFormatting.getByName((String)lllllllllllllllllIllllIlIlIIIIII.mod.color.getValue())).append(lllllllllllllllllIllllIlIlIIIlII.func_185359_l()));
        lllllllllllllllllIllllIlIlIIIIII.fort = lllllllllllllllllIllllIlIlIIIIII.y < 1 ? 1 : lllllllllllllllllIllllIlIlIIIIII.y;
        if (lllllllllllllllllIllllIlIlIIIIII.fort > 355) {
            lllllllllllllllllIllllIlIlIIIIII.fort = lllllllllllllllllIllllIlIlIIIIII.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(lllllllllllllllllIllllIlIlIIIIlI, lllllllllllllllllIllllIlIlIIIIII.x, lllllllllllllllllIllllIlIlIIIIII.y - 2, lllllllllllllllllIllllIlIlIIIIII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllllllllllllllllIllllIlIlIIIIII.Rainbow1.GetRainbowColorAt(lllllllllllllllllIllllIlIlIIIIII.fort) : lllllllllllllllllIllllIlIlIIlIlI.getRGB());
            lllllllllllllllllIllllIlIlIIIIII.width = (int)ImpactPlus.CustomFont.getStringWidth(lllllllllllllllllIllllIlIlIIIIlI) + 2;
        } else {
            lllllllllllllllllIllllIlIlIIlIIl.fontRendererObj.drawStringWithShadow(lllllllllllllllllIllllIlIlIIIIlI, (float)lllllllllllllllllIllllIlIlIIIIII.x, (float)lllllllllllllllllIllllIlIlIIIIII.y, lllllllllllllllllIllllIlIlIIIIII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllllllllllllllllIllllIlIlIIIIII.Rainbow1.GetRainbowColorAt(lllllllllllllllllIllllIlIlIIIIII.fort) : lllllllllllllllllIllllIlIlIIlIlI.getRGB());
            lllllllllllllllllIllllIlIlIIIIII.width = lllllllllllllllllIllllIlIlIIlIIl.fontRendererObj.getStringWidth(lllllllllllllllllIllllIlIlIIIIlI);
        }
    }

    public BiomeComponent() {
        super("Biome", 2, 112, Biome.INSTANCE);
        BiomeComponent lllllllllllllllllIllllIllIIIlllI;
        lllllllllllllllllIllllIllIIIlllI.mc = Minecraft.getMinecraft();
        lllllllllllllllllIllllIllIIIlllI.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        lllllllllllllllllIllllIllIIIlllI.Rainbow1 = Rainbow.getbruh();
    }
}

