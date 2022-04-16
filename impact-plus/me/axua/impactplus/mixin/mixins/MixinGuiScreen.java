/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.inventory.ItemStackHelper
 *  net.minecraft.item.ItemShulkerBox
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.NonNullList
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.player.AutoBuilder;
import me.axua.impactplus.module.modules.render.NoRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiScreen.class}, priority=9999)
public class MixinGuiScreen {
    @Shadow
    public /* synthetic */ Minecraft mc;

    public MixinGuiScreen() {
        MixinGuiScreen llllllllllllllllIIIIIlllIIIlIllI;
    }

    @Inject(method={"Lnet/minecraft/client/gui/GuiScreen;drawWorldBackground(I)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void drawWorldBackgroundWrapper(int llllllllllllllllIIIIIlllIIIlIIII, CallbackInfo llllllllllllllllIIIIIlllIIIIllII) {
        MixinGuiScreen llllllllllllllllIIIIIlllIIIlIIIl;
        NoRender llllllllllllllllIIIIIlllIIIIlllI = (NoRender)ModuleManager.getModuleByName("NoRender");
        if (llllllllllllllllIIIIIlllIIIlIIIl.mc.theWorld != null && ModuleManager.isModuleEnabled("NoRender") && llllllllllllllllIIIIIlllIIIIlllI.nobackground.getValue()) {
            llllllllllllllllIIIIIlllIIIIllII.cancel();
        }
    }

    @Inject(method={"renderToolTip"}, at={@At(value="HEAD")}, cancellable=true)
    public void renderToolTip(ItemStack llllllllllllllllIIIIIllIllllIIIl, int llllllllllllllllIIIIIllIllllIlII, int llllllllllllllllIIIIIllIllllIIll, CallbackInfo llllllllllllllllIIIIIllIlllIlllI) {
        NBTTagCompound llllllllllllllllIIIIIllIlllllIII;
        NBTTagCompound llllllllllllllllIIIIIllIllllIlll;
        if (ModuleManager.isModuleEnabled("ShulkerPreview") && llllllllllllllllIIIIIllIllllIIIl.getItem() instanceof ItemShulkerBox && (llllllllllllllllIIIIIllIllllIlll = llllllllllllllllIIIIIllIllllIIIl.getTagCompound()) != null && llllllllllllllllIIIIIllIllllIlll.hasKey("BlockEntityTag", 10) && (llllllllllllllllIIIIIllIlllllIII = llllllllllllllllIIIIIllIllllIlll.getCompoundTag("BlockEntityTag")).hasKey("Items", 9)) {
            llllllllllllllllIIIIIllIlllIlllI.cancel();
            NonNullList llllllllllllllllIIIIIllIlllllIlI = NonNullList.func_191197_a((int)27, (Object)ItemStack.field_190927_a);
            ItemStackHelper.func_191283_b((NBTTagCompound)llllllllllllllllIIIIIllIlllllIII, (NonNullList)llllllllllllllllIIIIIllIlllllIlI);
            GlStateManager.enableBlend();
            GlStateManager.disableRescaleNormal();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.disableDepth();
            int llllllllllllllllIIIIIllIlllllIIl = Math.max(144, Minecraft.getMinecraft().fontRendererObj.getStringWidth(llllllllllllllllIIIIIllIllllIIIl.getDisplayName()) + 3);
            Minecraft.getMinecraft().getRenderItem().zLevel = 300.0f;
            Gui.drawRect((int)(llllllllllllllllIIIIIllIllllIlII + 9), (int)(llllllllllllllllIIIIIllIllllIIll - 13), (int)(llllllllllllllllIIIIIllIllllIlII + 155), (int)(llllllllllllllllIIIIIllIllllIIll + 48), (int)AutoBuilder.ColourConverter.rgbToInt(9, 9, 9, 160));
            Gui.drawRect((int)(llllllllllllllllIIIIIllIllllIlII + 10), (int)(llllllllllllllllIIIIIllIllllIIll - 12), (int)(llllllllllllllllIIIIIllIllllIlII + 154), (int)(llllllllllllllllIIIIIllIllllIIll - 2), (int)AutoBuilder.ColourConverter.rgbToInt(9, 9, 9, 160));
            GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIIIIIllIllllIIIl.getDisplayName(), llllllllllllllllIIIIIllIllllIlII + 11, llllllllllllllllIIIIIllIllllIIll - 13, 0xFFFFFF);
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableTexture2D();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableGUIStandardItemLighting();
            for (int llllllllllllllllIIIIIllIlllllIll = 0; llllllllllllllllIIIIIllIlllllIll < llllllllllllllllIIIIIllIlllllIlI.size(); ++llllllllllllllllIIIIIllIlllllIll) {
                int llllllllllllllllIIIIIllIlllllllI = llllllllllllllllIIIIIllIllllIlII + 1 + llllllllllllllllIIIIIllIlllllIll % 9 * 16 + 8;
                int llllllllllllllllIIIIIllIllllllIl = llllllllllllllllIIIIIllIllllIIll + 1 + (llllllllllllllllIIIIIllIlllllIll / 9 - 1) * 16 + 13;
                ItemStack llllllllllllllllIIIIIllIllllllII = (ItemStack)llllllllllllllllIIIIIllIlllllIlI.get(llllllllllllllllIIIIIllIlllllIll);
                Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllllIIIIIllIllllllII, llllllllllllllllIIIIIllIlllllllI, llllllllllllllllIIIIIllIllllllIl);
                Minecraft.getMinecraft().getRenderItem().renderItemOverlayIntoGUI(Minecraft.getMinecraft().fontRendererObj, llllllllllllllllIIIIIllIllllllII, llllllllllllllllIIIIIllIlllllllI, llllllllllllllllIIIIIllIllllllIl, null);
            }
            RenderHelper.disableStandardItemLighting();
            Minecraft.getMinecraft().getRenderItem().zLevel = 0.0f;
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.enableRescaleNormal();
        }
    }
}

