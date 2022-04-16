/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.ActiveRenderInfo
 *  net.minecraft.entity.Entity
 *  net.minecraft.network.play.server.SPacketPlayerListItem
 *  net.minecraft.network.play.server.SPacketPlayerListItem$Action
 *  net.minecraft.network.play.server.SPacketPlayerListItem$AddPlayerData
 *  net.minecraft.world.World
 *  net.minecraftforge.client.event.ClientChatEvent
 *  net.minecraftforge.client.event.ClientChatReceivedEvent
 *  net.minecraftforge.client.event.DrawBlockHighlightEvent
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FogColors
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.client.event.RenderBlockOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Post
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.event.entity.living.LivingDamageEvent
 *  net.minecraftforge.event.entity.living.LivingDeathEvent
 *  net.minecraftforge.event.entity.living.LivingEntityUseItemEvent$Finish
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.event.world.WorldEvent$Load
 *  net.minecraftforge.event.world.WorldEvent$Unload
 *  net.minecraftforge.fml.common.eventhandler.EventPriority
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$MouseInputEvent
 *  net.minecraftforge.fml.common.gameevent.PlayerEvent$PlayerRespawnEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.apache.commons.io.IOUtils
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 */
package me.axua.impactplus.event;

import com.google.common.collect.Maps;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.command.CommandManager;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.event.events.PlayerJoinEvent;
import me.axua.impactplus.event.events.PlayerLeaveEvent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.render.SkyColour;
import me.axua.impactplus.util.Wrapper;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.DrawBlockHighlightEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class EventProcessor {
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Receive> receiveListener;
    public static /* synthetic */ EventProcessor INSTANCE;
    private final /* synthetic */ Map<String, String> uuidNameCache;
    /* synthetic */ int speed;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    private static final /* synthetic */ Map<String, String> uuidNameCache2;
    /* synthetic */ float hue;
    /* synthetic */ Minecraft mc;
    /* synthetic */ CommandManager commandManager;
    public /* synthetic */ Color c;
    /* synthetic */ int rgb;

    public int getRainbowSpeed() {
        EventProcessor llllllllllllllllIIIIIIIIIIIllIll;
        return llllllllllllllllIIIIIIIIIIIllIll.speed;
    }

    @SubscribeEvent
    public void onWorldRender(RenderWorldLastEvent lllllllllllllllIllllllllllllIlII) {
        if (lllllllllllllllIllllllllllllIlII.isCanceled()) {
            return;
        }
        ModuleManager.onWorldRender(lllllllllllllllIllllllllllllIlII);
    }

    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void onChatSent(ClientChatEvent lllllllllllllllIlllllllllllIIIlI) {
        if (lllllllllllllllIlllllllllllIIIlI.getMessage().startsWith(Command.getPrefix())) {
            lllllllllllllllIlllllllllllIIIlI.setCanceled(true);
            try {
                EventProcessor lllllllllllllllIlllllllllllIIIIl;
                lllllllllllllllIlllllllllllIIIIl.mc.ingameGUI.getChatGUI().addToSentMessages(lllllllllllllllIlllllllllllIIIlI.getMessage());
                lllllllllllllllIlllllllllllIIIIl.commandManager.callCommand(lllllllllllllllIlllllllllllIIIlI.getMessage().substring(1));
            }
            catch (Exception lllllllllllllllIlllllllllllIIlII) {
                lllllllllllllllIlllllllllllIIlII.printStackTrace();
                Wrapper.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.DARK_RED).append("Error: ").append(lllllllllllllllIlllllllllllIIlII.getMessage())));
            }
        }
    }

    static {
        uuidNameCache2 = Maps.newConcurrentMap();
    }

    @SubscribeEvent
    public void onLivingEntityUseItemFinish(LivingEntityUseItemEvent.Finish lllllllllllllllIlllllllllIllllll) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIlllllllllIllllll);
    }

    @SubscribeEvent
    public void onRenderScreen(RenderGameOverlayEvent.Text lllllllllllllllIllllllllllIlllII) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIllllllllllIlllII);
    }

    @SubscribeEvent
    public void onInputUpdate(InputUpdateEvent lllllllllllllllIlllllllllIlllIll) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIlllllllllIlllIll);
    }

    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onKeyInput(InputEvent.KeyInputEvent lllllllllllllllIlllllllllllIllII) {
        if (Keyboard.getEventKeyState()) {
            if (Keyboard.getEventKey() == 0 || Keyboard.getEventKey() == 0) {
                return;
            }
            ModuleManager.onBind(Keyboard.getEventKey());
        }
    }

    @SubscribeEvent(priority=EventPriority.HIGHEST)
    public void fogColorEvent(EntityViewRenderEvent.FogColors llllllllllllllllIIIIIIIIIIIIIIIl) {
        SkyColour llllllllllllllllIIIIIIIIIIIIIIII = (SkyColour)ModuleManager.getModuleByName("SkyColour");
        if (ModuleManager.isModuleEnabled("SkyColour")) {
            EventProcessor llllllllllllllllIIIIIIIIIIIIIIlI;
            IBlockState llllllllllllllllIIIIIIIIIIIIIlll = ActiveRenderInfo.func_186703_a((World)llllllllllllllllIIIIIIIIIIIIIIIl.getEntity().worldObj, (Entity)llllllllllllllllIIIIIIIIIIIIIIIl.getEntity(), (float)((float)llllllllllllllllIIIIIIIIIIIIIIIl.getRenderPartialTicks()));
            if (llllllllllllllllIIIIIIIIIIIIIlll.func_185904_a() == Material.lava || llllllllllllllllIIIIIIIIIIIIIlll.func_185904_a() == Material.water) {
                return;
            }
            int llllllllllllllllIIIIIIIIIIIIIllI = llllllllllllllllIIIIIIIIIIIIIIlI.mc.thePlayer.dimension;
            float llllllllllllllllIIIIIIIIIIIIIlIl = 0.0f;
            float llllllllllllllllIIIIIIIIIIIIIlII = 0.0f;
            float llllllllllllllllIIIIIIIIIIIIIIll = 0.0f;
            if (llllllllllllllllIIIIIIIIIIIIIllI == 0) {
                llllllllllllllllIIIIIIIIIIIIIlIl = (float)llllllllllllllllIIIIIIIIIIIIIIII.owred.getValue();
                llllllllllllllllIIIIIIIIIIIIIlII = (float)llllllllllllllllIIIIIIIIIIIIIIII.owgreen.getValue();
                llllllllllllllllIIIIIIIIIIIIIIll = (float)llllllllllllllllIIIIIIIIIIIIIIII.owblue.getValue();
            } else if (llllllllllllllllIIIIIIIIIIIIIllI == -1) {
                llllllllllllllllIIIIIIIIIIIIIlIl = (float)llllllllllllllllIIIIIIIIIIIIIIII.netherred.getValue();
                llllllllllllllllIIIIIIIIIIIIIlII = (float)llllllllllllllllIIIIIIIIIIIIIIII.nethergreen.getValue();
                llllllllllllllllIIIIIIIIIIIIIIll = (float)llllllllllllllllIIIIIIIIIIIIIIII.netherblue.getValue();
            } else if (llllllllllllllllIIIIIIIIIIIIIllI == 1) {
                llllllllllllllllIIIIIIIIIIIIIlIl = 0.0f;
                llllllllllllllllIIIIIIIIIIIIIlII = 0.0f;
                llllllllllllllllIIIIIIIIIIIIIIll = 0.0f;
            }
            llllllllllllllllIIIIIIIIIIIIIIIl.setRed(llllllllllllllllIIIIIIIIIIIIIlIl);
            llllllllllllllllIIIIIIIIIIIIIIIl.setGreen(llllllllllllllllIIIIIIIIIIIIIlII);
            llllllllllllllllIIIIIIIIIIIIIIIl.setBlue(llllllllllllllllIIIIIIIIIIIIIIll);
        }
    }

    public EventProcessor() {
        EventProcessor llllllllllllllllIIIIIIIIIIlIlIll;
        llllllllllllllllIIIIIIIIIIlIlIll.mc = Minecraft.getMinecraft();
        llllllllllllllllIIIIIIIIIIlIlIll.commandManager = new CommandManager();
        llllllllllllllllIIIIIIIIIIlIlIll.hue = 0.0f;
        llllllllllllllllIIIIIIIIIIlIlIll.speed = 2;
        llllllllllllllllIIIIIIIIIIlIlIll.Rainbow1 = new SalRainbowUtil(9);
        llllllllllllllllIIIIIIIIIIlIlIll.receiveListener = new Listener<PacketEvent.Receive>(lllllllllllllllIllllllllIlllllll -> {
            if (lllllllllllllllIllllllllIlllllll.getPacket() instanceof SPacketPlayerListItem) {
                EventProcessor lllllllllllllllIlllllllllIIIIIII;
                SPacketPlayerListItem lllllllllllllllIlllllllllIIIIIIl = (SPacketPlayerListItem)lllllllllllllllIllllllllIlllllll.getPacket();
                if (lllllllllllllllIlllllllllIIIIIIl.func_179768_b() == SPacketPlayerListItem.Action.ADD_PLAYER) {
                    for (SPacketPlayerListItem.AddPlayerData lllllllllllllllIlllllllllIIIIIll : lllllllllllllllIlllllllllIIIIIIl.func_179767_a()) {
                        if (lllllllllllllllIlllllllllIIIIIll.getProfile().getId() == lllllllllllllllIlllllllllIIIIIII.mc.session.getProfile().getId()) continue;
                        new Thread(() -> {
                            EventProcessor lllllllllllllllIllllllllIllIllIl;
                            String lllllllllllllllIllllllllIllIlIll = lllllllllllllllIllllllllIllIllIl.resolveName(lllllllllllllllIlllllllllIIIIIll.getProfile().getId().toString());
                            if (lllllllllllllllIllllllllIllIlIll != null && lllllllllllllllIllllllllIllIllIl.mc.thePlayer != null && lllllllllllllllIllllllllIllIllIl.mc.thePlayer.ticksExisted >= 1000) {
                                ImpactPlus.EVENT_BUS.post(new PlayerJoinEvent(lllllllllllllllIllllllllIllIlIll));
                            }
                        }).start();
                    }
                }
                if (lllllllllllllllIlllllllllIIIIIIl.func_179768_b() == SPacketPlayerListItem.Action.REMOVE_PLAYER) {
                    for (SPacketPlayerListItem.AddPlayerData lllllllllllllllIlllllllllIIIIIlI : lllllllllllllllIlllllllllIIIIIIl.func_179767_a()) {
                        if (lllllllllllllllIlllllllllIIIIIlI.getProfile().getId() == lllllllllllllllIlllllllllIIIIIII.mc.session.getProfile().getId()) continue;
                        new Thread(() -> {
                            EventProcessor lllllllllllllllIllllllllIlllIllI;
                            String lllllllllllllllIllllllllIlllIlII = lllllllllllllllIllllllllIlllIllI.resolveName(lllllllllllllllIlllllllllIIIIIlI.getProfile().getId().toString());
                            if (lllllllllllllllIllllllllIlllIlII != null && lllllllllllllllIllllllllIlllIllI.mc.thePlayer != null && lllllllllllllllIllllllllIlllIllI.mc.thePlayer.ticksExisted >= 1000) {
                                ImpactPlus.EVENT_BUS.post(new PlayerLeaveEvent(lllllllllllllllIllllllllIlllIlII));
                            }
                        }).start();
                    }
                }
            }
        }, new Predicate[0]);
        llllllllllllllllIIIIIIIIIIlIlIll.uuidNameCache = Maps.newConcurrentMap();
        INSTANCE = llllllllllllllllIIIIIIIIIIlIlIll;
    }

    public static String resolveName2(String lllllllllllllllIlllllllllIIlIIII) {
        if (uuidNameCache2.containsKey(lllllllllllllllIlllllllllIIlIIII = lllllllllllllllIlllllllllIIlIIII.replace("-", ""))) {
            return uuidNameCache2.get(lllllllllllllllIlllllllllIIlIIII);
        }
        String lllllllllllllllIlllllllllIIlIIIl = String.valueOf(new StringBuilder().append("https://api.mojang.com/user/profiles/").append(lllllllllllllllIlllllllllIIlIIII).append("/names"));
        try {
            JSONObject lllllllllllllllIlllllllllIIlIllI;
            JSONArray lllllllllllllllIlllllllllIIlIlIl;
            String lllllllllllllllIlllllllllIIlIlII = IOUtils.toString((URL)new URL(lllllllllllllllIlllllllllIIlIIIl));
            if (lllllllllllllllIlllllllllIIlIlII != null && lllllllllllllllIlllllllllIIlIlII.length() > 0 && (lllllllllllllllIlllllllllIIlIlIl = (JSONArray)JSONValue.parseWithException(lllllllllllllllIlllllllllIIlIlII)) != null && (lllllllllllllllIlllllllllIIlIllI = (JSONObject)lllllllllllllllIlllllllllIIlIlIl.get(lllllllllllllllIlllllllllIIlIlIl.size() - 1)) != null) {
                return lllllllllllllllIlllllllllIIlIllI.get("name").toString();
            }
        }
        catch (IOException | ParseException lllllllllllllllIlllllllllIIlIIll) {
            lllllllllllllllIlllllllllIIlIIll.printStackTrace();
        }
        return null;
    }

    @SubscribeEvent
    public void LivingEvent(LivingEvent.LivingUpdateEvent llllllllllllllllIIIIIIIIIIIlIIIl) {
        EventProcessor llllllllllllllllIIIIIIIIIIIlIIlI;
        if (llllllllllllllllIIIIIIIIIIIlIIlI.mc.thePlayer != null) {
            ModuleManager.onLivingEvent();
        }
    }

    @SubscribeEvent
    public void onAttackEntity(AttackEntityEvent lllllllllllllllIllllllllllIlIIll) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIllllllllllIlIIll);
    }

    @SubscribeEvent
    public void onDrawBlockHighlight(DrawBlockHighlightEvent lllllllllllllllIllllllllllIIlIll) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIllllllllllIIlIll);
    }

    @SubscribeEvent
    public void onRenderBlockOverlay(RenderBlockOverlayEvent lllllllllllllllIllllllllllIIlIII) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIllllllllllIIlIII);
    }

    public void setRainbowSpeed(int llllllllllllllllIIIIIIIIIIlIIIII) {
        llllllllllllllllIIIIIIIIIIlIIIIl.speed = llllllllllllllllIIIIIIIIIIlIIIII;
    }

    public void init() {
        EventProcessor lllllllllllllllIlllllllllIIIlIIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllllllllllllllIlllllllllIIIlIIl);
        MinecraftForge.EVENT_BUS.register((Object)lllllllllllllllIlllllllllIIIlIIl);
    }

    public int getRgb() {
        EventProcessor llllllllllllllllIIIIIIIIIIlIlIII;
        return llllllllllllllllIIIIIIIIIIlIlIII.rgb;
    }

    public SalRainbowUtil getRainbow1() {
        EventProcessor llllllllllllllllIIIIIIIIIIIllIII;
        return llllllllllllllllIIIIIIIIIIIllIII.Rainbow1;
    }

    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent lllllllllllllllIlllllllllIllIlll) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIlllllllllIllIlll);
    }

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload lllllllllllllllIlllllllllIllIIll) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIlllllllllIllIIll);
    }

    public String resolveName(String lllllllllllllllIlllllllllIlIIIII) {
        EventProcessor lllllllllllllllIlllllllllIlIIIIl;
        if (lllllllllllllllIlllllllllIlIIIIl.uuidNameCache.containsKey(lllllllllllllllIlllllllllIlIIIII = lllllllllllllllIlllllllllIlIIIII.replace("-", ""))) {
            return lllllllllllllllIlllllllllIlIIIIl.uuidNameCache.get(lllllllllllllllIlllllllllIlIIIII);
        }
        String lllllllllllllllIlllllllllIlIIIlI = String.valueOf(new StringBuilder().append("https://api.mojang.com/user/profiles/").append(lllllllllllllllIlllllllllIlIIIII).append("/names"));
        try {
            JSONObject lllllllllllllllIlllllllllIlIlIII;
            JSONArray lllllllllllllllIlllllllllIlIIlll;
            String lllllllllllllllIlllllllllIlIIllI = IOUtils.toString((URL)new URL(lllllllllllllllIlllllllllIlIIIlI));
            if (lllllllllllllllIlllllllllIlIIllI != null && lllllllllllllllIlllllllllIlIIllI.length() > 0 && (lllllllllllllllIlllllllllIlIIlll = (JSONArray)JSONValue.parseWithException(lllllllllllllllIlllllllllIlIIllI)) != null && (lllllllllllllllIlllllllllIlIlIII = (JSONObject)lllllllllllllllIlllllllllIlIIlll.get(lllllllllllllllIlllllllllIlIIlll.size() - 1)) != null) {
                return lllllllllllllllIlllllllllIlIlIII.get("name").toString();
            }
        }
        catch (IOException | ParseException lllllllllllllllIlllllllllIlIIlIl) {
            lllllllllllllllIlllllllllIlIIlIl.printStackTrace();
        }
        return null;
    }

    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent lllllllllllllllIllllllllllIlIlll) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIllllllllllIlIlll);
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load lllllllllllllllIlllllllllIlIllll) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIlllllllllIlIllll);
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent lllllllllllllllIllllllllllIIllll) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIllllllllllIIllll);
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post lllllllllllllllIllllllllllllIIII) {
        EventProcessor lllllllllllllllIllllllllllllIIIl;
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIllllllllllllIIII);
        lllllllllllllllIllllllllllllIIIl.Rainbow1.OnRender();
        if (lllllllllllllllIllllllllllllIIII.getType() == RenderGameOverlayEvent.ElementType.TEXT && !Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            ModuleManager.onRender();
        }
    }

    @SubscribeEvent
    public void onMouseInput(InputEvent.MouseInputEvent lllllllllllllllIlllllllllllIlIIl) {
        if (Mouse.getEventButtonState()) {
            ImpactPlus.EVENT_BUS.post(lllllllllllllllIlllllllllllIlIIl);
        }
    }

    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent lllllllllllllllIllllllllllIIIlII) {
        ImpactPlus.EVENT_BUS.post(lllllllllllllllIllllllllllIIIlII);
    }

    public Color getC() {
        EventProcessor llllllllllllllllIIIIIIIIIIlIIlII;
        return llllllllllllllllIIIIIIIIIIlIIlII.c;
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent llllllllllllllllIIIIIIIIIIIlIlIl) {
        EventProcessor llllllllllllllllIIIIIIIIIIIlIllI;
        llllllllllllllllIIIIIIIIIIIlIllI.c = Color.getHSBColor(llllllllllllllllIIIIIIIIIIIlIllI.hue, 1.0f, 1.0f);
        llllllllllllllllIIIIIIIIIIIlIllI.rgb = Color.HSBtoRGB(llllllllllllllllIIIIIIIIIIIlIllI.hue, 1.0f, 1.0f);
        llllllllllllllllIIIIIIIIIIIlIllI.hue += (float)llllllllllllllllIIIIIIIIIIIlIllI.speed / 2000.0f;
        ModuleManager.CoolonUpdate();
        if (llllllllllllllllIIIIIIIIIIIlIllI.mc.thePlayer != null) {
            ModuleManager.onUpdate();
        }
    }
}

