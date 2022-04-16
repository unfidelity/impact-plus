/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.ItemShulkerBox
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.NonNullList
 */
package me.axua.impactplus.hud.components;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.modules.hud.ShulkerSpy;
import me.axua.impactplus.module.modules.player.AutoBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

public class ShulkerSpyComponent
extends HudComponent<ShulkerSpy> {
    /* synthetic */ int x2;
    /* synthetic */ int y3;
    public /* synthetic */ Map<EntityPlayer, ItemStack> spiedPlayers;
    /* synthetic */ Minecraft mc;
    /* synthetic */ int t4;
    /* synthetic */ int y2;

    public void renderShulkerToolTip(ItemStack lIIlIlIllIIIIll, int lIIlIlIllIIlIII, int lIIlIlIllIIIlll, String lIIlIlIlIllllll) {
        NBTTagCompound lIIlIlIllIIlIll;
        NBTTagCompound lIIlIlIllIIIlII = lIIlIlIllIIIIll.getTagCompound();
        if (lIIlIlIllIIIlII != null && lIIlIlIllIIIlII.hasKey("BlockEntityTag", 10) && (lIIlIlIllIIlIll = lIIlIlIllIIIlII.getCompoundTag("BlockEntityTag")).hasKey("Items", 9)) {
            NonNullList lIIlIlIllIIllII = NonNullList.func_191197_a((int)27, (Object)ItemStack.field_190927_a);
            ItemStackHelper.func_191283_b((NBTTagCompound)lIIlIlIllIIlIll, (NonNullList)lIIlIlIllIIllII);
            Minecraft.getMinecraft().getRenderItem().zLevel = 300.0f;
            Gui.drawRect((int)lIIlIlIllIIlIII, (int)lIIlIlIllIIIlll, (int)(lIIlIlIllIIlIII + 146), (int)(lIIlIlIllIIIlll + 60), (int)AutoBuilder.ColourConverter.rgbToInt(9, 9, 9, 160));
            Gui.drawRect((int)(lIIlIlIllIIlIII + 1), (int)(lIIlIlIllIIIlll + 1), (int)(lIIlIlIllIIlIII + 145), (int)(lIIlIlIllIIIlll + 11), (int)AutoBuilder.ColourConverter.rgbToInt(9, 9, 9, 160));
            ImpactPlus.CustomFont.drawStringWithShadow(String.valueOf(new StringBuilder().append(lIIlIlIlIllllll).append(" - ").append(lIIlIlIllIIIIll.getDisplayName())), lIIlIlIllIIlIII + 2, lIIlIlIllIIIlll, 0xFFFFFF);
            for (int lIIlIlIllIIllIl = 0; lIIlIlIllIIllIl < lIIlIlIllIIllII.size(); ++lIIlIlIllIIllIl) {
                int lIIlIlIllIlIIII = lIIlIlIllIIlIII + 1 + lIIlIlIllIIllIl % 9 * 16;
                int lIIlIlIllIIllll = lIIlIlIllIIIlll + 1 + (lIIlIlIllIIllIl / 9 - 1) * 16 + 26;
                ItemStack lIIlIlIllIIlllI = (ItemStack)lIIlIlIllIIllII.get(lIIlIlIllIIllIl);
                RenderHelper.enableGUIStandardItemLighting();
                Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(lIIlIlIllIIlllI, lIIlIlIllIlIIII, lIIlIlIllIIllll);
                Minecraft.getMinecraft().getRenderItem().renderItemOverlayIntoGUI(Minecraft.getMinecraft().fontRendererObj, lIIlIlIllIIlllI, lIIlIlIllIlIIII, lIIlIlIllIIllll, null);
                RenderHelper.disableStandardItemLighting();
            }
        }
    }

    @Override
    public void render() {
        ShulkerSpyComponent lIIlIlIllIlllll;
        super.render();
        lIIlIlIllIlllll.spiedPlayers.clear();
        for (EntityPlayer lIIlIlIlllIIIIl : lIIlIlIllIlllll.mc.theWorld.playerEntities) {
            if (lIIlIlIllIlllll.mc.thePlayer == lIIlIlIlllIIIIl || lIIlIlIlllIIIIl == null || lIIlIlIlllIIIIl.func_184614_ca() == null || !(lIIlIlIlllIIIIl.func_184614_ca().getItem() instanceof ItemShulkerBox)) continue;
            ItemStack lIIlIlIlllIIIlI = lIIlIlIlllIIIIl.func_184614_ca();
            lIIlIlIllIlllll.spiedPlayers.put(lIIlIlIlllIIIIl, lIIlIlIlllIIIlI);
        }
        lIIlIlIllIlllll.x2 = lIIlIlIllIlllll.x;
        lIIlIlIllIlllll.y2 = lIIlIlIllIlllll.y;
        lIIlIlIllIlllll.y3 = 0;
        lIIlIlIllIlllll.t4 = 0;
        lIIlIlIllIlllll.spiedPlayers.forEach((lIIlIlIlIIlIIIl, lIIlIlIlIIlIIII) -> {
            ShulkerSpyComponent lIIlIlIlIIllIII;
            lIIlIlIlIIllIII.renderShulkerToolTip((ItemStack)lIIlIlIlIIlIIII, lIIlIlIlIIllIII.x2, lIIlIlIlIIllIII.y2, lIIlIlIlIIlIIIl.getName());
            lIIlIlIlIIllIII.y2 += 62;
            lIIlIlIlIIllIII.y3 += 62;
            ++lIIlIlIlIIllIII.t4;
        });
        lIIlIlIllIlllll.width = 146;
        lIIlIlIllIlllll.height = lIIlIlIllIlllll.t4 > 0 ? lIIlIlIllIlllll.y3 - 2 : 60;
    }

    public ShulkerSpyComponent() {
        super("ShulkerSpy", 812, 2, ShulkerSpy.INSTANCE);
        ShulkerSpyComponent lIIlIlIlllIlIII;
        lIIlIlIlllIlIII.mc = Minecraft.getMinecraft();
        lIIlIlIlllIlIII.spiedPlayers = new ConcurrentHashMap<EntityPlayer, ItemStack>();
    }
}

