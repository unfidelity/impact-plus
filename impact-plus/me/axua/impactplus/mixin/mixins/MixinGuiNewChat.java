/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Lists
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.ChatLine
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiNewChat
 *  net.minecraft.client.gui.GuiUtilRenderComponents
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.text.ITextComponent
 */
package me.axua.impactplus.mixin.mixins;

import com.google.common.collect.Lists;
import java.util.List;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.chat.ChatTweaks;
import me.axua.impactplus.module.modules.render.NoRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={GuiNewChat.class})
public abstract class MixinGuiNewChat {
    /* synthetic */ ChatTweaks mod;
    @Shadow
    public /* synthetic */ boolean isScrolled;
    @Shadow
    public /* synthetic */ int scrollPos;
    @Shadow
    public final /* synthetic */ List<ChatLine> field_146253_i;
    @Shadow
    public final /* synthetic */ List<ChatLine> chatLines;

    @Redirect(method={"drawChat"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/GuiNewChat;drawRect(IIIII)V"))
    private void drawRectBackgroundClean(int llllllllllllllllIIIIIIlIIIllllIl, int llllllllllllllllIIIIIIlIIIllllII, int llllllllllllllllIIIIIIlIIIlllIll, int llllllllllllllllIIIIIIlIIIllIlIl, int llllllllllllllllIIIIIIlIIIlllIIl) {
        if (!ModuleManager.isModuleEnabled("NoRender") || !((NoRender)ModuleManager.getModuleByName((String)"NoRender")).clearBkg.getValue()) {
            Gui.drawRect((int)llllllllllllllllIIIIIIlIIIllllIl, (int)llllllllllllllllIIIIIIlIIIllllII, (int)llllllllllllllllIIIIIIlIIIlllIll, (int)llllllllllllllllIIIIIIlIIIllIlIl, (int)llllllllllllllllIIIIIIlIIIlllIIl);
        }
    }

    public MixinGuiNewChat() {
        MixinGuiNewChat llllllllllllllllIIIIIIlIIlIIIlII;
        llllllllllllllllIIIIIIlIIlIIIlII.chatLines = Lists.newArrayList();
        llllllllllllllllIIIIIIlIIlIIIlII.field_146253_i = Lists.newArrayList();
        llllllllllllllllIIIIIIlIIlIIIlII.mod = (ChatTweaks)ModuleManager.getModuleByName("ChatTweaks");
    }

    @Inject(method={"setChatLine"}, at={@At(value="HEAD")}, cancellable=true)
    private void setChatLine(ITextComponent llllllllllllllllIIIIIIlIIIIllIIl, int llllllllllllllllIIIIIIlIIIIllIII, int llllllllllllllllIIIIIIlIIIIlllIl, boolean llllllllllllllllIIIIIIlIIIIlllII, CallbackInfo llllllllllllllllIIIIIIlIIIIllIll) {
        MixinGuiNewChat llllllllllllllllIIIIIIlIIIlIIIII;
        if (llllllllllllllllIIIIIIlIIIlIIIII.mod != null && llllllllllllllllIIIIIIlIIIlIIIII.mod.isEnabled() && llllllllllllllllIIIIIIlIIIlIIIII.mod.InfiniteChatLength.getValue()) {
            llllllllllllllllIIIIIIlIIIIllIll.cancel();
            int llllllllllllllllIIIIIIlIIIlIIlIl = 1000000;
            GuiNewChat llllllllllllllllIIIIIIlIIIlIIlII = (GuiNewChat)llllllllllllllllIIIIIIlIIIlIIIII;
            if (llllllllllllllllIIIIIIlIIIIllIII != 0) {
                llllllllllllllllIIIIIIlIIIlIIlII.deleteChatLine(llllllllllllllllIIIIIIlIIIIllIII);
            }
            int llllllllllllllllIIIIIIlIIIlIIIll = MathHelper.floor_float((float)((float)llllllllllllllllIIIIIIlIIIlIIlII.getChatWidth() / llllllllllllllllIIIIIIlIIIlIIlII.getChatScale()));
            List llllllllllllllllIIIIIIlIIIlIIIlI = GuiUtilRenderComponents.func_178908_a((ITextComponent)llllllllllllllllIIIIIIlIIIIllIIl, (int)llllllllllllllllIIIIIIlIIIlIIIll, (FontRenderer)Minecraft.getMinecraft().fontRendererObj, (boolean)false, (boolean)false);
            boolean llllllllllllllllIIIIIIlIIIlIIIIl = llllllllllllllllIIIIIIlIIIlIIlII.getChatOpen();
            for (ITextComponent llllllllllllllllIIIIIIlIIIlIIllI : llllllllllllllllIIIIIIlIIIlIIIlI) {
                if (llllllllllllllllIIIIIIlIIIlIIIIl && llllllllllllllllIIIIIIlIIIlIIIII.scrollPos > 0) {
                    llllllllllllllllIIIIIIlIIIlIIIII.isScrolled = true;
                    llllllllllllllllIIIIIIlIIIlIIlII.scroll(1);
                }
                llllllllllllllllIIIIIIlIIIlIIIII.field_146253_i.add(0, new ChatLine(llllllllllllllllIIIIIIlIIIIlllIl, llllllllllllllllIIIIIIlIIIlIIllI, llllllllllllllllIIIIIIlIIIIllIII));
            }
            while (llllllllllllllllIIIIIIlIIIlIIIII.field_146253_i.size() > llllllllllllllllIIIIIIlIIIlIIlIl) {
                llllllllllllllllIIIIIIlIIIlIIIII.field_146253_i.remove(llllllllllllllllIIIIIIlIIIlIIIII.field_146253_i.size() - 1);
            }
            if (!llllllllllllllllIIIIIIlIIIIlllII) {
                llllllllllllllllIIIIIIlIIIlIIIII.chatLines.add(0, new ChatLine(llllllllllllllllIIIIIIlIIIIlllIl, llllllllllllllllIIIIIIlIIIIllIIl, llllllllllllllllIIIIIIlIIIIllIII));
                while (llllllllllllllllIIIIIIlIIIlIIIII.chatLines.size() > llllllllllllllllIIIIIIlIIIlIIlIl) {
                    llllllllllllllllIIIIIIlIIIlIIIII.chatLines.remove(llllllllllllllllIIIIIIlIIIlIIIII.chatLines.size() - 1);
                }
            }
        }
    }
}

