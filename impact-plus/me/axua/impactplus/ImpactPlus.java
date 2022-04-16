/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.Mod$Instance
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPostInitializationEvent
 *  net.minecraftforge.fml.common.event.FMLPreInitializationEvent
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.lwjgl.opengl.Display
 */
package me.axua.impactplus;

import me.axua.impactplus.ShutDownHook;
import me.axua.impactplus.command.CommandManager;
import me.axua.impactplus.event.EventProcessor;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.gui.ClickGUI;
import me.axua.impactplus.guiscreens.AntiDisconnect;
import me.axua.impactplus.hud.HudComponentManager;
import me.axua.impactplus.hudgui.HudGui;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.setting.SettingManager;
import me.axua.impactplus.util.ConfigUtils;
import me.axua.impactplus.util.TpsUtils;
import me.axua.impactplus.util.font.SalFontRenderer;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.zero.alpine.EventBus;
import me.zero.alpine.EventManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

@Mod(modid="impactplus", name="Impact+", version="1.2.9", clientSideOnly=true)
public class ImpactPlus {
    public /* synthetic */ HudGui hudGui;
    public /* synthetic */ ModuleManager moduleManager;
    public static /* synthetic */ SalFontRenderer CustomFont2;
    public static final /* synthetic */ String MODVER;
    @Mod.Instance
    private static /* synthetic */ ImpactPlus INSTANCE;
    /* synthetic */ EventProcessor eventProcessor;
    public static final /* synthetic */ EventBus EVENT_BUS;
    public /* synthetic */ AntiDisconnect antiDisconnect;
    public static final /* synthetic */ String MODID;
    public static /* synthetic */ SalFontRenderer CustomFont3;
    public static final /* synthetic */ String FORGENAME;
    public /* synthetic */ Friends friends;
    public /* synthetic */ ClickGUI clickGui;
    public static /* synthetic */ SalFontRenderer CustomFont;
    public static final /* synthetic */ Logger log;
    public /* synthetic */ SettingManager settingsManager;
    public /* synthetic */ ConfigUtils configUtils;
    public static /* synthetic */ String MODNAME;
    public /* synthetic */ HudComponentManager hudComponentManager;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent lllllllllllllllllIlIIlIIlIllllll) {
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent lllllllllllllllllIlIIlIIlIllIllI) {
        Display.setTitle((String)"Impact+ 1.2.9");
        log.info("PostInitialization complete!\n");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent lllllllllllllllllIlIIlIIlIlllIll) throws Exception {
        ImpactPlus lllllllllllllllllIlIIlIIlIlllIIl;
        lllllllllllllllllIlIIlIIlIlllIIl.eventProcessor = new EventProcessor();
        lllllllllllllllllIlIIlIIlIlllIIl.eventProcessor.init();
        TpsUtils lllllllllllllllllIlIIlIIlIlllIlI = new TpsUtils();
        Rainbow.Init();
        lllllllllllllllllIlIIlIIlIlllIIl.settingsManager = new SettingManager();
        log.info("Settings initialized!");
        lllllllllllllllllIlIIlIIlIlllIIl.friends = new Friends();
        log.info("Friends initialized!");
        lllllllllllllllllIlIIlIIlIlllIIl.moduleManager = new ModuleManager();
        log.info("Modules initialized!");
        lllllllllllllllllIlIIlIIlIlllIIl.clickGui = new ClickGUI();
        log.info("ClickGUI initialized!");
        lllllllllllllllllIlIIlIIlIlllIIl.hudComponentManager = new HudComponentManager();
        lllllllllllllllllIlIIlIIlIlllIIl.hudGui = new HudGui();
        lllllllllllllllllIlIIlIIlIlllIIl.antiDisconnect = new AntiDisconnect();
        log.info("HudEditorGui initialized!");
        lllllllllllllllllIlIIlIIlIlllIIl.configUtils = new ConfigUtils();
        Runtime.getRuntime().addShutdownHook(new ShutDownHook());
        log.info("Config loaded!");
        CommandManager.initCommands();
        log.info("Commands initialized!");
        CustomFont = new SalFontRenderer("assets/font/font.ttf", 18.0f);
        CustomFont2 = new SalFontRenderer("assets/font/font.ttf", 20.0f);
        CustomFont3 = new SalFontRenderer("assets/font/font.ttf", 35.0f);
        log.info("Font initialized!");
        log.info("Initialization complete!\n");
    }

    static {
        MODVER = "1.2.9";
        MODID = "impactplus";
        FORGENAME = "Impact+";
        MODNAME = "impactplus";
        log = LogManager.getLogger((String)MODNAME);
        EVENT_BUS = new EventManager();
    }

    public static ImpactPlus getInstance() {
        return INSTANCE;
    }

    public ImpactPlus() {
        ImpactPlus lllllllllllllllllIlIIlIIllIIIIlI;
        INSTANCE = lllllllllllllllllIlIIlIIllIIIIlI;
    }
}

