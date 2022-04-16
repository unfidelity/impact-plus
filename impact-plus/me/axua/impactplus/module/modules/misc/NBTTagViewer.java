/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.gameevent.InputEvent$MouseInputEvent
 *  org.lwjgl.input.Mouse
 */
package me.axua.impactplus.module.modules.misc;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Mouse;

public class NBTTagViewer
extends Module {
    /* synthetic */ String myString;
    public /* synthetic */ Setting.b Chat;
    private /* synthetic */ int delay;
    public /* synthetic */ Setting.b Clipboard;
    @EventHandler
    private /* synthetic */ Listener<InputEvent.MouseInputEvent> listener;

    @Override
    public void onDisable() {
        NBTTagViewer llllllllllllllllIlllIlIlllIIlIlI;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIlllIlIlllIIlIlI);
    }

    @Override
    public void setup() {
        NBTTagViewer llllllllllllllllIlllIlIlllIlIIll;
        llllllllllllllllIlllIlIlllIlIIll.Chat = llllllllllllllllIlllIlIlllIlIIll.registerB("Chat", true);
        llllllllllllllllIlllIlIlllIlIIll.Clipboard = llllllllllllllllIlllIlIlllIlIIll.registerB("Clipboard", false);
    }

    public NBTTagViewer() {
        super("NBTTagViewer", Module.Category.MISC, "Middle Click Entitys to see the NBTTag");
        NBTTagViewer llllllllllllllllIlllIlIlllIlIllI;
        llllllllllllllllIlllIlIlllIlIllI.delay = 0;
        llllllllllllllllIlllIlIlllIlIllI.listener = new Listener<InputEvent.MouseInputEvent>(llllllllllllllllIlllIlIllIllIlIl -> {
            NBTTagViewer llllllllllllllllIlllIlIllIllIlll;
            if (NBTTagViewer.mc.objectMouseOver.typeOfHit.equals((Object)RayTraceResult.Type.ENTITY) && Mouse.getEventButton() == 2 && llllllllllllllllIlllIlIllIllIlll.delay == 0) {
                NBTTagCompound llllllllllllllllIlllIlIllIlllIIl = new NBTTagCompound();
                NBTTagViewer.mc.objectMouseOver.entityHit.func_189511_e(llllllllllllllllIlllIlIllIlllIIl);
                if (llllllllllllllllIlllIlIllIllIlll.Chat.getValue()) {
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append("Entity Tags:\n").append(llllllllllllllllIlllIlIllIlllIIl).append("")));
                }
                if (llllllllllllllllIlllIlIllIllIlll.Clipboard.getValue()) {
                    llllllllllllllllIlllIlIllIllIlll.myString = llllllllllllllllIlllIlIllIlllIIl.toString();
                    StringSelection llllllllllllllllIlllIlIllIlllllI = new StringSelection(llllllllllllllllIlllIlIllIllIlll.myString);
                    Clipboard llllllllllllllllIlllIlIllIlllIll = Toolkit.getDefaultToolkit().getSystemClipboard();
                    llllllllllllllllIlllIlIllIlllIll.setContents(llllllllllllllllIlllIlIllIlllllI, null);
                    Command.sendClientMessage("Copied NBTTags to clipboard.");
                }
            }
        }, new Predicate[0]);
    }

    @Override
    public void onEnable() {
        NBTTagViewer llllllllllllllllIlllIlIlllIIllIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIlllIlIlllIIllIl);
    }

    @Override
    public void onUpdate() {
        NBTTagViewer llllllllllllllllIlllIlIlllIIllll;
        if (llllllllllllllllIlllIlIlllIIllll.delay > 0) {
            --llllllllllllllllIlllIlIlllIIllll.delay;
        }
    }
}

