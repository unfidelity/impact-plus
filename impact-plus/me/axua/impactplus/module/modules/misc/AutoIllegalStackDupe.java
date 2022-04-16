/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.passive.EntityMule
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketUseEntity
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.module.modules.misc;

import java.util.Comparator;
import java.util.Timer;
import java.util.TimerTask;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.setting.Setting;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;

public class AutoIllegalStackDupe
extends Module {
    /* synthetic */ int once19;
    /* synthetic */ int once18;
    /* synthetic */ int once14;
    /* synthetic */ int once10;
    /* synthetic */ int once4;
    public /* synthetic */ Setting.i ToggleOnDelay;
    public /* synthetic */ Setting.b DebugMsgs;
    private /* synthetic */ Timer _Timer2;
    /* synthetic */ int once8;
    /* synthetic */ int bruh;
    /* synthetic */ int once1;
    /* synthetic */ int chestslot;
    /* synthetic */ int once5;
    /* synthetic */ int once12;
    /* synthetic */ int once6;
    /* synthetic */ int once9;
    public /* synthetic */ Setting.b On;
    /* synthetic */ int once20;
    /* synthetic */ int once17;
    /* synthetic */ int once7;
    /* synthetic */ int bruh2;
    /* synthetic */ int once3;
    /* synthetic */ int once2;
    /* synthetic */ int once15;
    /* synthetic */ int once11;
    /* synthetic */ int once13;
    /* synthetic */ int once16;
    private /* synthetic */ Timer _Timer;

    public AutoIllegalStackDupe() {
        super("AutoIllegalStackDupe", Module.Category.MISC, "Auto Illegal Stack Dupe");
        AutoIllegalStackDupe llllllllllllllllIIIIIlIllIlIIIll;
        llllllllllllllllIIIIIlIllIlIIIll._Timer = new Timer();
        llllllllllllllllIIIIIlIllIlIIIll._Timer2 = new Timer();
    }

    @Override
    public void onEnable() {
        Entity llllllllllllllllIIIIIlIllIIlIllI;
        AutoIllegalStackDupe llllllllllllllllIIIIIlIllIIlIlIl;
        llllllllllllllllIIIIIlIllIIlIlIl.chestslot = -1;
        llllllllllllllllIIIIIlIllIIlIlIl.once1 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once2 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once3 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once4 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once5 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once6 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once7 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once8 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once9 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once10 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once11 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once12 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once13 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once14 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once15 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once16 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once17 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once18 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once19 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.once20 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.bruh = 0;
        llllllllllllllllIIIIIlIllIIlIlIl.bruh2 = 0;
        llllllllllllllllIIIIIlIllIIlIlIl._Timer.cancel();
        llllllllllllllllIIIIIlIllIIlIlIl._Timer = new Timer();
        if (AutoIllegalStackDupe.mc.thePlayer.func_184218_aH()) {
            return;
        }
        for (int llllllllllllllllIIIIIlIllIIllIII = 0; llllllllllllllllIIIIIlIllIIllIII < 9 && llllllllllllllllIIIIIlIllIIlIlIl.chestslot == -1; ++llllllllllllllllIIIIIlIllIIllIII) {
            Block llllllllllllllllIIIIIlIllIIllIIl;
            ItemStack llllllllllllllllIIIIIlIllIIllIlI = AutoIllegalStackDupe.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIIIIlIllIIllIII);
            if (llllllllllllllllIIIIIlIllIIllIlI == ItemStack.field_190927_a || !(llllllllllllllllIIIIIlIllIIllIlI.getItem() instanceof ItemBlock) || (llllllllllllllllIIIIIlIllIIllIIl = ((ItemBlock)llllllllllllllllIIIIIlIllIIllIlI.getItem()).getBlock()) != Blocks.chest) continue;
            llllllllllllllllIIIIIlIllIIlIlIl.chestslot = llllllllllllllllIIIIIlIllIIllIII;
        }
        if (llllllllllllllllIIIIIlIllIIlIlIl.chestslot == -1) {
            Command.sendClientMessage("no chests in hotbar");
            llllllllllllllllIIIIIlIllIIlIlIl.disable();
            return;
        }
        if (llllllllllllllllIIIIIlIllIIlIlIl.DebugMsgs.getValue()) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append("switching to chest in slot ").append(llllllllllllllllIIIIIlIllIIlIlIl.chestslot)));
        }
        AutoIllegalStackDupe.mc.thePlayer.inventory.currentItem = llllllllllllllllIIIIIlIllIIlIlIl.chestslot;
        if (llllllllllllllllIIIIIlIllIIlIlIl.DebugMsgs.getValue()) {
            Command.sendClientMessage("mount");
        }
        if ((llllllllllllllllIIIIIlIllIIlIllI = (Entity)AutoIllegalStackDupe.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIIIIIlIllIIIIIlI -> {
            AutoIllegalStackDupe llllllllllllllllIIIIIlIllIIIIIll;
            return llllllllllllllllIIIIIlIllIIIIIll.isValidEntity((Entity)llllllllllllllllIIIIIlIllIIIIIlI);
        }).min(Comparator.comparing(llllllllllllllllIIIIIlIllIIIIlll -> Float.valueOf(AutoIllegalStackDupe.mc.thePlayer.getDistanceToEntity(llllllllllllllllIIIIIlIllIIIIlll)))).orElse(null)) != null) {
            AutoIllegalStackDupe.mc.playerController.func_187097_a((EntityPlayer)AutoIllegalStackDupe.mc.thePlayer, llllllllllllllllIIIIIlIllIIlIllI, EnumHand.MAIN_HAND);
            AutoIllegalStackDupe.mc.playerController.func_187097_a((EntityPlayer)AutoIllegalStackDupe.mc.thePlayer, llllllllllllllllIIIIIlIllIIlIllI, EnumHand.MAIN_HAND);
        } else {
            if (llllllllllllllllIIIIIlIllIIlIlIl.DebugMsgs.getValue()) {
                Command.sendClientMessage("IT FUCKED UP LMAO!!!!");
            }
            ++llllllllllllllllIIIIIlIllIIlIlIl.bruh2;
            llllllllllllllllIIIIIlIllIIlIlIl.bruh = 1000;
            llllllllllllllllIIIIIlIllIIlIlIl._Timer.schedule(new TimerTask(){

                @Override
                public void run() {
                    1 llllllllllllllllllIIIIIIlllIIlIl;
                    if (!ModuleManager.isModuleEnabled("AutoIllegalStackDupe")) {
                        return;
                    }
                    if (llllllllllllllllllIIIIIIlllIIlIl.AutoIllegalStackDupe.this.once9 > 0) {
                        return;
                    }
                    ++llllllllllllllllllIIIIIIlllIIlIl.AutoIllegalStackDupe.this.once9;
                    Entity llllllllllllllllllIIIIIIlllIIlII = mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllllIIIIIIllIllIll -> {
                        1 llllllllllllllllllIIIIIIllIllIlI;
                        return llllllllllllllllllIIIIIIllIllIlI.AutoIllegalStackDupe.this.isValidEntity(llllllllllllllllllIIIIIIllIllIll);
                    }).min(Comparator.comparing(llllllllllllllllllIIIIIIlllIIIII -> Float.valueOf(mc.thePlayer.getDistanceToEntity(llllllllllllllllllIIIIIIlllIIIII)))).orElse(null);
                    if (llllllllllllllllllIIIIIIlllIIlII != null) {
                        mc.playerController.func_187097_a((EntityPlayer)mc.thePlayer, llllllllllllllllllIIIIIIlllIIlII, EnumHand.MAIN_HAND);
                        mc.playerController.func_187097_a((EntityPlayer)mc.thePlayer, llllllllllllllllllIIIIIIlllIIlII, EnumHand.MAIN_HAND);
                    }
                }
                {
                    1 llllllllllllllllllIIIIIIlllIlIll;
                }
            }, 600L);
        }
        llllllllllllllllIIIIIlIllIIlIlIl._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                2 llllIllIIlIlllI;
                if (!ModuleManager.isModuleEnabled("AutoIllegalStackDupe")) {
                    return;
                }
                if (llllIllIIlIlllI.AutoIllegalStackDupe.this.once1 > 0) {
                    return;
                }
                ++llllIllIIlIlllI.AutoIllegalStackDupe.this.once1;
                if (llllIllIIlIlllI.AutoIllegalStackDupe.this.DebugMsgs.getValue()) {
                    Command.sendClientMessage("open inv");
                }
                mc.thePlayer.sendHorseInventory();
            }
            {
                2 llllIllIIllIIIl;
            }
        }, 200 + llllllllllllllllIIIIIlIllIIlIlIl.bruh);
        llllllllllllllllIIIIIlIllIIlIlIl._Timer.schedule(new TimerTask(){
            {
                3 lllllllllllllllllIlIlIIlIIlIllII;
            }

            @Override
            public void run() {
                3 lllllllllllllllllIlIlIIlIIIlIIII;
                if (!ModuleManager.isModuleEnabled("AutoIllegalStackDupe")) {
                    return;
                }
                if (lllllllllllllllllIlIlIIlIIIlIIII.AutoIllegalStackDupe.this.once2 > 0) {
                    return;
                }
                ++lllllllllllllllllIlIlIIlIIIlIIII.AutoIllegalStackDupe.this.once2;
                for (int lllllllllllllllllIlIlIIlIIIlIIlI = 17; lllllllllllllllllIlIlIIlIIIlIIlI < 32; ++lllllllllllllllllIlIlIIlIIIlIIlI) {
                    mc.playerController.func_187098_a(mc.thePlayer.openContainer.windowId, lllllllllllllllllIlIlIIlIIIlIIlI, 0, ClickType.QUICK_MOVE, (EntityPlayer)mc.thePlayer);
                }
                if (lllllllllllllllllIlIlIIlIIIlIIII.AutoIllegalStackDupe.this.DebugMsgs.getValue()) {
                    Command.sendClientMessage("move items");
                }
            }
        }, 400 + llllllllllllllllIIIIIlIllIIlIlIl.bruh);
        llllllllllllllllIIIIIlIllIIlIlIl._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                4 lllllllllllllllllIlIlllIllIIIIII;
                if (!ModuleManager.isModuleEnabled("AutoIllegalStackDupe")) {
                    return;
                }
                if (lllllllllllllllllIlIlllIllIIIIII.AutoIllegalStackDupe.this.once3 > 0) {
                    return;
                }
                ++lllllllllllllllllIlIlllIllIIIIII.AutoIllegalStackDupe.this.once3;
                Entity lllllllllllllllllIlIlllIllIIIIIl = mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllllIlIlllIlIllIlIl -> {
                    4 lllllllllllllllllIlIlllIlIllIllI;
                    return lllllllllllllllllIlIlllIlIllIllI.AutoIllegalStackDupe.this.isValidEntity(lllllllllllllllllIlIlllIlIllIlIl);
                }).min(Comparator.comparing(lllllllllllllllllIlIlllIlIlllIll -> Float.valueOf(mc.thePlayer.getDistanceToEntity(lllllllllllllllllIlIlllIlIlllIll)))).orElse(null);
                if (lllllllllllllllllIlIlllIllIIIIIl != null) {
                    CPacketUseEntity lllllllllllllllllIlIlllIllIIIIll = new CPacketUseEntity(lllllllllllllllllIlIlllIllIIIIIl, EnumHand.MAIN_HAND, new Vec3d(0.0, 0.0, 0.0));
                    mc.thePlayer.sendQueue.addToSendQueue((Packet)lllllllllllllllllIlIlllIllIIIIll);
                }
                Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = true;
                if (lllllllllllllllllIlIlllIllIIIIII.AutoIllegalStackDupe.this.DebugMsgs.getValue()) {
                    Command.sendClientMessage("remove chest");
                }
            }
            {
                4 lllllllllllllllllIlIlllIllIIlIII;
            }
        }, 600 + llllllllllllllllIIIIIlIllIIlIlIl.bruh);
        llllllllllllllllIIIIIlIllIIlIlIl._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                5 llllllllllllllllllIlIlIIlIllllII;
                if (!ModuleManager.isModuleEnabled("AutoIllegalStackDupe")) {
                    return;
                }
                if (llllllllllllllllllIlIlIIlIllllII.AutoIllegalStackDupe.this.once4 > 0) {
                    return;
                }
                ++llllllllllllllllllIlIlIIlIllllII.AutoIllegalStackDupe.this.once4;
                for (int llllllllllllllllllIlIlIIlIllllIl = 2; llllllllllllllllllIlIlIIlIllllIl < 17; ++llllllllllllllllllIlIlIIlIllllIl) {
                    mc.playerController.func_187098_a(mc.thePlayer.openContainer.windowId, llllllllllllllllllIlIlIIlIllllIl, 0, ClickType.THROW, (EntityPlayer)mc.thePlayer);
                }
                if (llllllllllllllllllIlIlIIlIllllII.AutoIllegalStackDupe.this.DebugMsgs.getValue()) {
                    Command.sendClientMessage("throw out items");
                }
            }
            {
                5 llllllllllllllllllIlIlIIllIIIIll;
            }
        }, 800 + llllllllllllllllIIIIIlIllIIlIlIl.bruh);
        llllllllllllllllIIIIIlIllIIlIlIl._Timer.schedule(new TimerTask(){
            {
                6 llllllllllllllllllIIllIIlIIIllIl;
            }

            @Override
            public void run() {
                6 llllllllllllllllllIIllIIlIIIlIlI;
                if (!ModuleManager.isModuleEnabled("AutoIllegalStackDupe")) {
                    return;
                }
                if (llllllllllllllllllIIllIIlIIIlIlI.AutoIllegalStackDupe.this.once5 > 0) {
                    return;
                }
                ++llllllllllllllllllIIllIIlIIIlIlI.AutoIllegalStackDupe.this.once5;
                mc.thePlayer.closeScreen();
                Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = true;
                if (llllllllllllllllllIIllIIlIIIlIlI.AutoIllegalStackDupe.this.DebugMsgs.getValue()) {
                    Command.sendClientMessage("dismount");
                }
            }
        }, 1000 + llllllllllllllllIIIIIlIllIIlIlIl.bruh);
        llllllllllllllllIIIIIlIllIIlIlIl._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                7 llIllIlIIlIllIl;
                if (!ModuleManager.isModuleEnabled("AutoIllegalStackDupe")) {
                    return;
                }
                if (llIllIlIIlIllIl.AutoIllegalStackDupe.this.once6 > 0) {
                    return;
                }
                ++llIllIlIIlIllIl.AutoIllegalStackDupe.this.once6;
                mc.thePlayer.closeScreen();
                Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = false;
            }
            {
                7 llIllIlIIllIIlI;
            }
        }, 1200 + llllllllllllllllIIIIIlIllIIlIlIl.bruh);
        llllllllllllllllIIIIIlIllIIlIlIl._Timer.schedule(new TimerTask(){
            {
                8 lIIIlllIIlllI;
            }

            @Override
            public void run() {
                8 lIIIllIlllllI;
                if (!ModuleManager.isModuleEnabled("AutoIllegalStackDupe")) {
                    return;
                }
                if (lIIIllIlllllI.AutoIllegalStackDupe.this.once7 > 0) {
                    return;
                }
                ++lIIIllIlllllI.AutoIllegalStackDupe.this.once7;
                lIIIllIlllllI.AutoIllegalStackDupe.this.disable();
                lIIIllIlllllI.AutoIllegalStackDupe.this._Timer2.cancel();
                lIIIllIlllllI.AutoIllegalStackDupe.this._Timer2 = new Timer();
                if (lIIIllIlllllI.AutoIllegalStackDupe.this.On.getValue()) {
                    lIIIllIlllllI.AutoIllegalStackDupe.this._Timer2.schedule(new TimerTask(){

                        @Override
                        public void run() {
                            1 lllllllllllllllllllIlllIlIIlIIll;
                            if (lllllllllllllllllllIlllIlIIlIIll.AutoIllegalStackDupe.this.once8 > 0) {
                                return;
                            }
                            ++lllllllllllllllllllIlllIlIIlIIll.AutoIllegalStackDupe.this.once8;
                            lllllllllllllllllllIlllIlIIlIIll.AutoIllegalStackDupe.this.enable();
                            if (lllllllllllllllllllIlllIlIIlIIll.AutoIllegalStackDupe.this.DebugMsgs.getValue()) {
                                Command.sendClientMessage("re-enable");
                            }
                        }
                        {
                            1 lllllllllllllllllllIlllIlIIlIllI;
                        }
                    }, lIIIllIlllllI.AutoIllegalStackDupe.this.ToggleOnDelay.getValue());
                }
            }
        }, 1400 + llllllllllllllllIIIIIlIllIIlIlIl.bruh);
    }

    @Override
    public void setup() {
        AutoIllegalStackDupe llllllllllllllllIIIIIlIllIIlllll;
        llllllllllllllllIIIIIlIllIIlllll.ToggleOnDelay = llllllllllllllllIIIIIlIllIIlllll.registerI("ToggleOnDelay", 0, 0, 8000);
        llllllllllllllllIIIIIlIllIIlllll.DebugMsgs = llllllllllllllllIIIIIlIllIIlllll.registerB("DebugMsgs", true);
        llllllllllllllllIIIIIlIllIIlllll.On = llllllllllllllllIIIIIlIllIIlllll.registerB("On", true);
    }

    private boolean isValidEntity(Entity llllllllllllllllIIIIIlIllIIIlIll) {
        EntityLlama llllllllllllllllIIIIIlIllIIIllIl;
        EntityMule llllllllllllllllIIIIIlIllIIIlllI;
        EntityDonkey llllllllllllllllIIIIIlIllIIIllll;
        if (llllllllllllllllIIIIIlIllIIIlIll.getDistanceToEntity((Entity)AutoIllegalStackDupe.mc.thePlayer) > 10.0f) {
            return false;
        }
        if (llllllllllllllllIIIIIlIllIIIlIll instanceof EntityDonkey && !(llllllllllllllllIIIIIlIllIIIllll = (EntityDonkey)llllllllllllllllIIIIIlIllIIIlIll).isChild()) {
            return true;
        }
        if (llllllllllllllllIIIIIlIllIIIlIll instanceof EntityMule && !(llllllllllllllllIIIIIlIllIIIlllI = (EntityMule)llllllllllllllllIIIIIlIllIIIlIll).isChild()) {
            return true;
        }
        return llllllllllllllllIIIIIlIllIIIlIll instanceof EntityLlama && !(llllllllllllllllIIIIIlIllIIIllIl = (EntityLlama)llllllllllllllllIIIIIlIllIIIlIll).isChild();
    }
}

