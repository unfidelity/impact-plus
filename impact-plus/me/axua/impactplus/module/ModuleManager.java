/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 */
package me.axua.impactplus.module;

import java.util.stream.Collectors;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.chat.AutoEz;
import me.axua.impactplus.module.modules.chat.AutoGreenText;
import me.axua.impactplus.module.modules.chat.AutoQMain;
import me.axua.impactplus.module.modules.chat.ChatSuffix;
import me.axua.impactplus.module.modules.chat.ChatTimeStamps;
import me.axua.impactplus.module.modules.chat.ChatTweaks;
import me.axua.impactplus.module.modules.chat.DeathCoords;
import me.axua.impactplus.module.modules.chat.PacketLogger;
import me.axua.impactplus.module.modules.chat.ToggleMsgs;
import me.axua.impactplus.module.modules.chat.TotemPopCounter;
import me.axua.impactplus.module.modules.chat.VisualRange;
import me.axua.impactplus.module.modules.chat.Welcomer;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.client.HudGuiModule;
import me.axua.impactplus.module.modules.combat.AntiBed;
import me.axua.impactplus.module.modules.combat.Aura32k;
import me.axua.impactplus.module.modules.combat.AutoAnvil;
import me.axua.impactplus.module.modules.combat.AutoChorus;
import me.axua.impactplus.module.modules.combat.AutoCity;
import me.axua.impactplus.module.modules.combat.AutoLog32k;
import me.axua.impactplus.module.modules.combat.AutoTotem;
import me.axua.impactplus.module.modules.combat.AutoTrap;
import me.axua.impactplus.module.modules.combat.AutoTrapBed;
import me.axua.impactplus.module.modules.combat.BedAura;
import me.axua.impactplus.module.modules.combat.CrystalAura;
import me.axua.impactplus.module.modules.combat.DispenserAuto32k;
import me.axua.impactplus.module.modules.combat.FastBow;
import me.axua.impactplus.module.modules.combat.FeetExp;
import me.axua.impactplus.module.modules.combat.SelfAnvil;
import me.axua.impactplus.module.modules.combat.SmartOffhand;
import me.axua.impactplus.module.modules.combat.Surround;
import me.axua.impactplus.module.modules.hud.ArrayList;
import me.axua.impactplus.module.modules.hud.Beds;
import me.axua.impactplus.module.modules.hud.Biome;
import me.axua.impactplus.module.modules.hud.Bps;
import me.axua.impactplus.module.modules.hud.BrownmanClient;
import me.axua.impactplus.module.modules.hud.Closest;
import me.axua.impactplus.module.modules.hud.Coords;
import me.axua.impactplus.module.modules.hud.Dimension;
import me.axua.impactplus.module.modules.hud.Direction;
import me.axua.impactplus.module.modules.hud.Durability;
import me.axua.impactplus.module.modules.hud.Fps;
import me.axua.impactplus.module.modules.hud.Gamemode;
import me.axua.impactplus.module.modules.hud.Image;
import me.axua.impactplus.module.modules.hud.Inventory;
import me.axua.impactplus.module.modules.hud.Ip;
import me.axua.impactplus.module.modules.hud.Lag;
import me.axua.impactplus.module.modules.hud.Online;
import me.axua.impactplus.module.modules.hud.Ping;
import me.axua.impactplus.module.modules.hud.Player;
import me.axua.impactplus.module.modules.hud.ShulkerSpy;
import me.axua.impactplus.module.modules.hud.Totems;
import me.axua.impactplus.module.modules.hud.Tps;
import me.axua.impactplus.module.modules.hud.Watermark;
import me.axua.impactplus.module.modules.hud.Welcome;
import me.axua.impactplus.module.modules.misc.AntiDisconnect;
import me.axua.impactplus.module.modules.misc.AntiNarrator;
import me.axua.impactplus.module.modules.misc.AutoIllegalStackDupe;
import me.axua.impactplus.module.modules.misc.AutoWither;
import me.axua.impactplus.module.modules.misc.AutoWither2;
import me.axua.impactplus.module.modules.misc.BookCrash;
import me.axua.impactplus.module.modules.misc.CopyCoords;
import me.axua.impactplus.module.modules.misc.CopyIp;
import me.axua.impactplus.module.modules.misc.DonkeyDupeHelper;
import me.axua.impactplus.module.modules.misc.DonkeyLogger;
import me.axua.impactplus.module.modules.misc.LawnMower;
import me.axua.impactplus.module.modules.misc.MiddleClickFriends;
import me.axua.impactplus.module.modules.misc.NBTTagViewer;
import me.axua.impactplus.module.modules.misc.Notifications;
import me.axua.impactplus.module.modules.misc.ReloadSound;
import me.axua.impactplus.module.modules.misc.StashFinder;
import me.axua.impactplus.module.modules.misc.TabFriends;
import me.axua.impactplus.module.modules.movement.AutoWalk;
import me.axua.impactplus.module.modules.movement.AutoWasp;
import me.axua.impactplus.module.modules.movement.ElytraFly;
import me.axua.impactplus.module.modules.movement.FastFall;
import me.axua.impactplus.module.modules.movement.HoleTp;
import me.axua.impactplus.module.modules.movement.Strafe;
import me.axua.impactplus.module.modules.player.AimBot;
import me.axua.impactplus.module.modules.player.AntiForceLook;
import me.axua.impactplus.module.modules.player.AntiToolBreak;
import me.axua.impactplus.module.modules.player.AutoBuilder;
import me.axua.impactplus.module.modules.player.BuildHeight;
import me.axua.impactplus.module.modules.player.ElytraSwap;
import me.axua.impactplus.module.modules.player.FastUse;
import me.axua.impactplus.module.modules.player.FreeCam;
import me.axua.impactplus.module.modules.player.HotbarReplenish;
import me.axua.impactplus.module.modules.player.LiquidInteract;
import me.axua.impactplus.module.modules.player.NoBreakAnimation;
import me.axua.impactplus.module.modules.player.NoEntityTrace;
import me.axua.impactplus.module.modules.player.NoSwing;
import me.axua.impactplus.module.modules.player.PacketMine;
import me.axua.impactplus.module.modules.player.SkinFlicker;
import me.axua.impactplus.module.modules.player.YawLock;
import me.axua.impactplus.module.modules.render.ArmorEnchantColour;
import me.axua.impactplus.module.modules.render.BlockHighlight;
import me.axua.impactplus.module.modules.render.Breadcrumbs;
import me.axua.impactplus.module.modules.render.Chams;
import me.axua.impactplus.module.modules.render.CityEsp;
import me.axua.impactplus.module.modules.render.CsgoESP;
import me.axua.impactplus.module.modules.render.FovModule;
import me.axua.impactplus.module.modules.render.HoleEsp;
import me.axua.impactplus.module.modules.render.MapBoundaries;
import me.axua.impactplus.module.modules.render.NameTags;
import me.axua.impactplus.module.modules.render.NoRender;
import me.axua.impactplus.module.modules.render.PearlViewer;
import me.axua.impactplus.module.modules.render.ShulkerPreview;
import me.axua.impactplus.module.modules.render.SkyColour;
import me.axua.impactplus.module.modules.render.ViewModel;
import me.axua.impactplus.module.modules.render.VoidEsp;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ModuleManager {
    public static /* synthetic */ java.util.ArrayList<Module> modules;

    public static void onRender() {
        modules.stream().filter(Module::isEnabled).forEach(Module::onRender);
    }

    public static java.util.ArrayList<Module> getModulesInCategory(Module.Category llllllllllllllllIlllIIIIIIlIlllI) {
        java.util.ArrayList llllllllllllllllIlllIIIIIIlIllll = (java.util.ArrayList)ModuleManager.getModules().stream().filter(llllllllllllllllIlllIIIIIIIIIIll -> llllllllllllllllIlllIIIIIIIIIIll.getCategory().equals((Object)llllllllllllllllIlllIIIIIIlIlllI)).collect(Collectors.toList());
        return llllllllllllllllIlllIIIIIIlIllll;
    }

    public static void addMod(Module llllllllllllllllIlllIIIIIIllllIl) {
        modules.add(llllllllllllllllIlllIIIIIIllllIl);
    }

    public static boolean isModuleEnabled(String llllllllllllllllIlllIIIIIIlIIIIl) {
        Module llllllllllllllllIlllIIIIIIlIIIII = ModuleManager.getModules().stream().filter(llllllllllllllllIlllIIIIIIIlIlll -> llllllllllllllllIlllIIIIIIIlIlll.getName().equalsIgnoreCase(llllllllllllllllIlllIIIIIIlIIIIl)).findFirst().orElse(null);
        return llllllllllllllllIlllIIIIIIlIIIII.isEnabled();
    }

    public static void CoolonUpdate() {
        modules.stream().filter(Module::isEnabled).forEach(Module::CoolonUpdate);
    }

    public static java.util.ArrayList<Module> getModules() {
        return modules;
    }

    public ModuleManager() {
        ModuleManager llllllllllllllllIlllIIIIIIllllll;
        modules = new java.util.ArrayList();
        ModuleManager.addMod(new AutoEz());
        ModuleManager.addMod(new AutoGreenText());
        ModuleManager.addMod(new AutoQMain());
        ModuleManager.addMod(new ChatSuffix());
        ModuleManager.addMod(new ChatTimeStamps());
        ModuleManager.addMod(new ChatTweaks());
        ModuleManager.addMod(new DeathCoords());
        ModuleManager.addMod(new PacketLogger());
        ModuleManager.addMod(new ToggleMsgs());
        ModuleManager.addMod(new TotemPopCounter());
        ModuleManager.addMod(new VisualRange());
        ModuleManager.addMod(new Welcomer());
        ModuleManager.addMod(new AntiBed());
        ModuleManager.addMod(new Aura32k());
        ModuleManager.addMod(new AutoAnvil());
        ModuleManager.addMod(new AutoChorus());
        ModuleManager.addMod(new AutoCity());
        ModuleManager.addMod(new AutoLog32k());
        ModuleManager.addMod(new AutoTotem());
        ModuleManager.addMod(new AutoTrap());
        ModuleManager.addMod(new AutoTrapBed());
        ModuleManager.addMod(new BedAura());
        ModuleManager.addMod(new CrystalAura());
        ModuleManager.addMod(new DispenserAuto32k());
        ModuleManager.addMod(new FastBow());
        ModuleManager.addMod(new FeetExp());
        ModuleManager.addMod(new SelfAnvil());
        ModuleManager.addMod(new SmartOffhand());
        ModuleManager.addMod(new Surround());
        ModuleManager.addMod(new ClickGuiModule());
        ModuleManager.addMod(new HudGuiModule());
        ModuleManager.addMod(new HudColours());
        ModuleManager.addMod(new AntiDisconnect());
        ModuleManager.addMod(new AntiNarrator());
        ModuleManager.addMod(new DonkeyDupeHelper());
        ModuleManager.addMod(new AutoIllegalStackDupe());
        ModuleManager.addMod(new AutoWither());
        ModuleManager.addMod(new AutoWither2());
        ModuleManager.addMod(new BookCrash());
        ModuleManager.addMod(new CopyCoords());
        ModuleManager.addMod(new CopyIp());
        ModuleManager.addMod(new DonkeyLogger());
        ModuleManager.addMod(new LawnMower());
        ModuleManager.addMod(new MiddleClickFriends());
        ModuleManager.addMod(new NBTTagViewer());
        ModuleManager.addMod(new Notifications());
        ModuleManager.addMod(new ReloadSound());
        ModuleManager.addMod(new StashFinder());
        ModuleManager.addMod(new TabFriends());
        ModuleManager.addMod(new AutoWalk());
        ModuleManager.addMod(new AutoWasp());
        ModuleManager.addMod(new ElytraFly());
        ModuleManager.addMod(new FastFall());
        ModuleManager.addMod(new HoleTp());
        ModuleManager.addMod(new Strafe());
        ModuleManager.addMod(new AimBot());
        ModuleManager.addMod(new AntiForceLook());
        ModuleManager.addMod(new AntiToolBreak());
        ModuleManager.addMod(new AutoBuilder());
        ModuleManager.addMod(new BuildHeight());
        ModuleManager.addMod(new ElytraSwap());
        ModuleManager.addMod(new FastUse());
        ModuleManager.addMod(new FreeCam());
        ModuleManager.addMod(new HotbarReplenish());
        ModuleManager.addMod(new LiquidInteract());
        ModuleManager.addMod(new NoBreakAnimation());
        ModuleManager.addMod(new NoEntityTrace());
        ModuleManager.addMod(new NoSwing());
        ModuleManager.addMod(new PacketMine());
        ModuleManager.addMod(new SkinFlicker());
        ModuleManager.addMod(new YawLock());
        ModuleManager.addMod(new ArmorEnchantColour());
        ModuleManager.addMod(new BlockHighlight());
        ModuleManager.addMod(new Breadcrumbs());
        ModuleManager.addMod(new Chams());
        ModuleManager.addMod(new CityEsp());
        ModuleManager.addMod(new CsgoESP());
        ModuleManager.addMod(new FovModule());
        ModuleManager.addMod(new HoleEsp());
        ModuleManager.addMod(new MapBoundaries());
        ModuleManager.addMod(new NameTags());
        ModuleManager.addMod(new NoRender());
        ModuleManager.addMod(new PearlViewer());
        ModuleManager.addMod(new ShulkerPreview());
        ModuleManager.addMod(new SkyColour());
        ModuleManager.addMod(new ViewModel());
        ModuleManager.addMod(new VoidEsp());
        ModuleManager.addMod(new ArrayList());
        ModuleManager.addMod(new Beds());
        ModuleManager.addMod(new Biome());
        ModuleManager.addMod(new Bps());
        ModuleManager.addMod(new BrownmanClient());
        ModuleManager.addMod(new Closest());
        ModuleManager.addMod(new Coords());
        ModuleManager.addMod(new Dimension());
        ModuleManager.addMod(new Direction());
        ModuleManager.addMod(new Durability());
        ModuleManager.addMod(new Fps());
        ModuleManager.addMod(new Gamemode());
        ModuleManager.addMod(new Image());
        ModuleManager.addMod(new Inventory());
        ModuleManager.addMod(new Ip());
        ModuleManager.addMod(new Lag());
        ModuleManager.addMod(new Online());
        ModuleManager.addMod(new Ping());
        ModuleManager.addMod(new Player());
        ModuleManager.addMod(new ShulkerSpy());
        ModuleManager.addMod(new Totems());
        ModuleManager.addMod(new Tps());
        ModuleManager.addMod(new Watermark());
        ModuleManager.addMod(new Welcome());
    }

    public static void onLivingEvent() {
        modules.stream().filter(Module::isEnabled).forEach(Module::onLivingEvent);
    }

    public static Module getModuleByName(String llllllllllllllllIlllIIIIIIlIIlll) {
        Module llllllllllllllllIlllIIIIIIlIIllI = ModuleManager.getModules().stream().filter(llllllllllllllllIlllIIIIIIIIllll -> llllllllllllllllIlllIIIIIIIIllll.getName().equalsIgnoreCase(llllllllllllllllIlllIIIIIIlIIlll)).findFirst().orElse(null);
        return llllllllllllllllIlllIIIIIIlIIllI;
    }

    public static void onBind(int llllllllllllllllIlllIIIIIIlIlIll) {
        if (llllllllllllllllIlllIIIIIIlIlIll == 0 || llllllllllllllllIlllIIIIIIlIlIll == 0) {
            return;
        }
        modules.forEach(llllllllllllllllIlllIIIIIIIIlIll -> {
            if (llllllllllllllllIlllIIIIIIIIlIll.getBind() == llllllllllllllllIlllIIIIIIlIlIll) {
                llllllllllllllllIlllIIIIIIIIlIll.toggle();
            }
        });
    }

    public static boolean isModuleEnabled(Module llllllllllllllllIlllIIIIIIIlllII) {
        return llllllllllllllllIlllIIIIIIIlllII.isEnabled();
    }

    public static void onWorldRender(RenderWorldLastEvent llllllllllllllllIlllIIIIIIlllIII) {
        Minecraft.getMinecraft().mcProfiler.startSection("impactplus");
        Minecraft.getMinecraft().mcProfiler.startSection("setup");
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        GlStateManager.shadeModel((int)7425);
        GlStateManager.disableDepth();
        GlStateManager.func_187441_d((float)1.0f);
        Vec3d llllllllllllllllIlllIIIIIIllIlll = ImpactPlusTessellator.getInterpolatedPos((Entity)Minecraft.getMinecraft().thePlayer, llllllllllllllllIlllIIIIIIlllIII.getPartialTicks());
        RenderEvent llllllllllllllllIlllIIIIIIllIllI = new RenderEvent(Tessellator.INSTANCE, llllllllllllllllIlllIIIIIIllIlll, llllllllllllllllIlllIIIIIIlllIII.getPartialTicks());
        llllllllllllllllIlllIIIIIIllIllI.resetTranslation();
        Minecraft.getMinecraft().mcProfiler.endSection();
        modules.stream().filter(llllllllllllllllIllIlllllllllIlI -> llllllllllllllllIllIlllllllllIlI.isEnabled()).forEach(llllllllllllllllIllIllllllllllll -> {
            Minecraft.getMinecraft().mcProfiler.startSection(llllllllllllllllIllIllllllllllll.getName());
            llllllllllllllllIllIllllllllllll.onWorldRender(llllllllllllllllIlllIIIIIIllIllI);
            Minecraft.getMinecraft().mcProfiler.endSection();
        });
        Minecraft.getMinecraft().mcProfiler.startSection("release");
        GlStateManager.func_187441_d((float)1.0f);
        GlStateManager.shadeModel((int)7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
        GlStateManager.enableDepth();
        GlStateManager.enableCull();
        Tessellator.releaseGL();
        Minecraft.getMinecraft().mcProfiler.endSection();
        Minecraft.getMinecraft().mcProfiler.endSection();
    }

    public static void onUpdate() {
        modules.stream().filter(Module::isEnabled).forEach(Module::onUpdate);
    }
}

