/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  org.lwjgl.input.Keyboard
 */
package me.axua.impactplus.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.EventProcessor;
import me.axua.impactplus.friends.Friend;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.chat.AutoEz;
import me.axua.impactplus.setting.Setting;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ConfigUtils {
    /* synthetic */ Minecraft mc;
    public /* synthetic */ File Settings;
    public /* synthetic */ File Fortnite;

    public void loadAutoEz() {
        try {
            String lIIIlIlIIIII;
            ConfigUtils lIIIlIIlllIl;
            File lIIIlIlIIlII = new File(lIIIlIIlllIl.Fortnite.getAbsolutePath(), "AutoEzMessage.txt");
            FileInputStream lIIIlIlIIIll = new FileInputStream(lIIIlIlIIlII.getAbsolutePath());
            DataInputStream lIIIlIlIIIlI = new DataInputStream(lIIIlIlIIIll);
            BufferedReader lIIIlIlIIIIl = new BufferedReader(new InputStreamReader(lIIIlIlIIIlI));
            while ((lIIIlIlIIIII = lIIIlIlIIIIl.readLine()) != null) {
                AutoEz.addAutoEzMessage(lIIIlIlIIIII);
            }
            lIIIlIlIIIIl.close();
        }
        catch (Exception lIIIlIIlllll) {
            lIIIlIIlllll.printStackTrace();
        }
    }

    public void saveHud() {
        try {
            ConfigUtils lIIIIIlIIlIl;
            File lIIIIIlIlIII = new File(lIIIIIlIIlIl.Fortnite.getAbsolutePath(), "HudComponents.txt");
            BufferedWriter lIIIIIlIIlll = new BufferedWriter(new FileWriter(lIIIIIlIlIII));
            for (HudComponent lIIIIIlIlIIl : ImpactPlus.getInstance().hudComponentManager.getComponents()) {
                lIIIIIlIIlll.write(String.valueOf(new StringBuilder().append(lIIIIIlIlIIl.getName()).append(":").append(lIIIIIlIlIIl.getX()).append(":").append(lIIIIIlIlIIl.getY())));
                lIIIIIlIIlll.write("\r\n");
            }
            lIIIIIlIIlll.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void savePrefix() {
        try {
            ConfigUtils lIIIIllIIIII;
            File lIIIIllIIIll = new File(lIIIIllIIIII.Fortnite.getAbsolutePath(), "CommandPrefix.txt");
            BufferedWriter lIIIIllIIIlI = new BufferedWriter(new FileWriter(lIIIIllIIIll));
            lIIIIllIIIlI.write(Command.getPrefix());
            lIIIIllIIIlI.write("\r\n");
            lIIIIllIIIlI.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public ConfigUtils() {
        ConfigUtils lIIIlllIlIIl;
        lIIIlllIlIIl.mc = Minecraft.getMinecraft();
        lIIIlllIlIIl.Fortnite = new File(String.valueOf(new StringBuilder().append(lIIIlllIlIIl.mc.mcDataDir).append(File.separator).append("Impact+")));
        if (!lIIIlllIlIIl.Fortnite.exists()) {
            lIIIlllIlIIl.Fortnite.mkdirs();
        }
        lIIIlllIlIIl.Settings = new File(String.valueOf(new StringBuilder().append(lIIIlllIlIIl.mc.mcDataDir).append(File.separator).append("Impact+").append(File.separator).append("Settings")));
        if (!lIIIlllIlIIl.Settings.exists()) {
            lIIIlllIlIIl.Settings.mkdirs();
        }
        lIIIlllIlIIl.loadMods();
        lIIIlllIlIIl.loadDrawn();
        lIIIlllIlIIl.loadSettingsList();
        lIIIlllIlIIl.loadBinds();
        lIIIlllIlIIl.loadFriends();
        lIIIlllIlIIl.loadPrefix();
        lIIIlllIlIIl.loadRainbow();
        lIIIlllIlIIl.loadHud();
        lIIIlllIlIIl.loadAutoEz();
    }

    public void loadSettingsList() {
        ConfigUtils lllIIllIIIl;
        try {
            String lllIlIIlIll;
            File lllIlIIllll = new File(lllIIllIIIl.Settings.getAbsolutePath(), "Number.txt");
            FileInputStream lllIlIIlllI = new FileInputStream(lllIlIIllll.getAbsolutePath());
            DataInputStream lllIlIIllIl = new DataInputStream(lllIlIIlllI);
            BufferedReader lllIlIIllII = new BufferedReader(new InputStreamReader(lllIlIIllIl));
            while ((lllIlIIlIll = lllIlIIllII.readLine()) != null) {
                String lllIlIlIIll = lllIlIIlIll.trim();
                String lllIlIlIIlI = lllIlIlIIll.split(":")[0];
                String lllIlIlIIIl = lllIlIlIIll.split(":")[1];
                String lllIlIlIIII = lllIlIlIIll.split(":")[2];
                for (Module lllIlIlIlII : ModuleManager.getModules()) {
                    if (lllIlIlIlII == null || !lllIlIlIlII.getName().equalsIgnoreCase(lllIlIlIIII)) continue;
                    Setting lllIlIlIlIl = ImpactPlus.getInstance().settingsManager.getSettingByNameAndMod(lllIlIlIIlI, lllIlIlIlII);
                    if (lllIlIlIlIl instanceof Setting.i) {
                        ((Setting.i)lllIlIlIlIl).setValue(Integer.parseInt(lllIlIlIIIl));
                        continue;
                    }
                    if (!(lllIlIlIlIl instanceof Setting.d)) continue;
                    ((Setting.d)lllIlIlIlIl).setValue(Double.parseDouble(lllIlIlIIIl));
                }
            }
            lllIlIIllII.close();
        }
        catch (Exception lllIlIIlIlI) {
            lllIlIIlIlI.printStackTrace();
        }
        try {
            String lllIIllllll;
            File lllIlIIIIll = new File(lllIIllIIIl.Settings.getAbsolutePath(), "Boolean.txt");
            FileInputStream lllIlIIIIlI = new FileInputStream(lllIlIIIIll.getAbsolutePath());
            DataInputStream lllIlIIIIIl = new DataInputStream(lllIlIIIIlI);
            BufferedReader lllIlIIIIII = new BufferedReader(new InputStreamReader(lllIlIIIIIl));
            while ((lllIIllllll = lllIlIIIIII.readLine()) != null) {
                String lllIlIIIlll = lllIIllllll.trim();
                String lllIlIIIllI = lllIlIIIlll.split(":")[0];
                String lllIlIIIlIl = lllIlIIIlll.split(":")[1];
                String lllIlIIIlII = lllIlIIIlll.split(":")[2];
                for (Module lllIlIIlIII : ModuleManager.getModules()) {
                    if (lllIlIIlIII == null || !lllIlIIlIII.getName().equalsIgnoreCase(lllIlIIIlII)) continue;
                    Setting lllIlIIlIIl = ImpactPlus.getInstance().settingsManager.getSettingByNameAndMod(lllIlIIIllI, lllIlIIlIII);
                    ((Setting.b)lllIlIIlIIl).setValue(Boolean.parseBoolean(lllIlIIIlIl));
                }
            }
            lllIlIIIIII.close();
        }
        catch (Exception lllIIlllllI) {
            lllIIlllllI.printStackTrace();
        }
        try {
            String lllIIllIIll;
            File lllIIllIlll = new File(lllIIllIIIl.Settings.getAbsolutePath(), "String.txt");
            FileInputStream lllIIllIllI = new FileInputStream(lllIIllIlll.getAbsolutePath());
            DataInputStream lllIIllIlIl = new DataInputStream(lllIIllIllI);
            BufferedReader lllIIllIlII = new BufferedReader(new InputStreamReader(lllIIllIlIl));
            while ((lllIIllIIll = lllIIllIlII.readLine()) != null) {
                String lllIIlllIll = lllIIllIIll.trim();
                String lllIIlllIlI = lllIIlllIll.split(":")[0];
                String lllIIlllIIl = lllIIlllIll.split(":")[1];
                String lllIIlllIII = lllIIlllIll.split(":")[2];
                for (Module lllIIllllII : ModuleManager.getModules()) {
                    if (lllIIllllII == null || !lllIIllllII.getName().equalsIgnoreCase(lllIIlllIII)) continue;
                    Setting lllIIllllIl = ImpactPlus.getInstance().settingsManager.getSettingByNameAndMod(lllIIlllIlI, lllIIllllII);
                    ((Setting.mode)lllIIllllIl).setValue(lllIIlllIIl);
                }
            }
            lllIIllIlII.close();
        }
        catch (Exception lllIIllIIlI) {
            lllIIllIIlI.printStackTrace();
        }
    }

    public void loadRainbow() {
        try {
            String lIIIIIllIlll;
            ConfigUtils lIIIIIllIlIl;
            File lIIIIIlllIll = new File(lIIIIIllIlIl.Fortnite.getAbsolutePath(), "RainbowSpeed.txt");
            FileInputStream lIIIIIlllIlI = new FileInputStream(lIIIIIlllIll.getAbsolutePath());
            DataInputStream lIIIIIlllIIl = new DataInputStream(lIIIIIlllIlI);
            BufferedReader lIIIIIlllIII = new BufferedReader(new InputStreamReader(lIIIIIlllIIl));
            while ((lIIIIIllIlll = lIIIIIlllIII.readLine()) != null) {
                EventProcessor.INSTANCE.setRainbowSpeed(Integer.parseInt(lIIIIIllIlll));
            }
            lIIIIIlllIII.close();
        }
        catch (Exception lIIIIIllIllI) {
            lIIIIIllIllI.printStackTrace();
        }
    }

    public void loadHud() {
        try {
            String lIIIIIIIlIlI;
            ConfigUtils lIIIIIIIIlll;
            File lIIIIIIIlllI = new File(lIIIIIIIIlll.Fortnite.getAbsolutePath(), "HudComponents.txt");
            FileInputStream lIIIIIIIllIl = new FileInputStream(lIIIIIIIlllI.getAbsolutePath());
            DataInputStream lIIIIIIIllII = new DataInputStream(lIIIIIIIllIl);
            BufferedReader lIIIIIIIlIll = new BufferedReader(new InputStreamReader(lIIIIIIIllII));
            while ((lIIIIIIIlIlI = lIIIIIIIlIll.readLine()) != null) {
                String lIIIIIIlIIlI = lIIIIIIIlIlI.trim();
                String lIIIIIIlIIIl = lIIIIIIlIIlI.split(":")[0];
                String lIIIIIIlIIII = lIIIIIIlIIlI.split(":")[1];
                String lIIIIIIIllll = lIIIIIIlIIlI.split(":")[2];
                for (HudComponent lIIIIIIlIIll : ImpactPlus.getInstance().hudComponentManager.getComponents()) {
                    if (!lIIIIIIlIIll.getName().equalsIgnoreCase(lIIIIIIlIIIl)) continue;
                    lIIIIIIlIIll.setX(Integer.parseInt(lIIIIIIlIIII));
                    lIIIIIIlIIll.setY(Integer.parseInt(lIIIIIIIllll));
                }
            }
            lIIIIIIIlIll.close();
        }
        catch (Exception lIIIIIIIlIIl) {
            lIIIIIIIlIIl.printStackTrace();
        }
    }

    public void saveBinds() {
        try {
            ConfigUtils lIIIllIlllll;
            File lIIIlllIIIlI = new File(lIIIllIlllll.Fortnite.getAbsolutePath(), "Binds.txt");
            BufferedWriter lIIIlllIIIIl = new BufferedWriter(new FileWriter(lIIIlllIIIlI));
            ImpactPlus impactPlus = ImpactPlus.getInstance();
            for (Module lIIIlllIIIll : impactPlus.moduleManager.getModules()) {
                lIIIlllIIIIl.write(String.valueOf(new StringBuilder().append(lIIIlllIIIll.getName()).append(":").append(Keyboard.getKeyName((int)lIIIlllIIIll.getBind()))));
                lIIIlllIIIIl.write("\r\n");
            }
            lIIIlllIIIIl.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void loadPrefix() {
        try {
            String lIIIIlIlIIll;
            ConfigUtils lIIIIlIlIIIl;
            File lIIIIlIlIlll = new File(lIIIIlIlIIIl.Fortnite.getAbsolutePath(), "CommandPrefix.txt");
            FileInputStream lIIIIlIlIllI = new FileInputStream(lIIIIlIlIlll.getAbsolutePath());
            DataInputStream lIIIIlIlIlIl = new DataInputStream(lIIIIlIlIllI);
            BufferedReader lIIIIlIlIlII = new BufferedReader(new InputStreamReader(lIIIIlIlIlIl));
            while ((lIIIIlIlIIll = lIIIIlIlIlII.readLine()) != null) {
                Command.setPrefix(lIIIIlIlIIll);
            }
            lIIIIlIlIlII.close();
        }
        catch (Exception lIIIIlIlIIlI) {
            lIIIIlIlIIlI.printStackTrace();
        }
    }

    public void saveFriends() {
        try {
            ConfigUtils lIIIIlllllll;
            File lIIIlIIIIIlI = new File(lIIIIlllllll.Fortnite.getAbsolutePath(), "Friends.txt");
            BufferedWriter lIIIlIIIIIIl = new BufferedWriter(new FileWriter(lIIIlIIIIIlI));
            for (Friend lIIIlIIIIIll : Friends.getFriends()) {
                lIIIlIIIIIIl.write(lIIIlIIIIIll.getName());
                lIIIlIIIIIIl.write("\r\n");
            }
            lIIIlIIIIIIl.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void loadDrawn() {
        try {
            String lllllIlIlll;
            ConfigUtils lllllIlIlII;
            File lllllIllIll = new File(lllllIlIlII.Fortnite.getAbsolutePath(), "Drawn.txt");
            FileInputStream lllllIllIlI = new FileInputStream(lllllIllIll.getAbsolutePath());
            DataInputStream lllllIllIIl = new DataInputStream(lllllIllIlI);
            BufferedReader lllllIllIII = new BufferedReader(new InputStreamReader(lllllIllIIl));
            while ((lllllIlIlll = lllllIllIII.readLine()) != null) {
                String lllllIlllll = lllllIlIlll.trim();
                String lllllIllllI = lllllIlllll.split(":")[0];
                String lllllIlllIl = lllllIlllll.split(":")[1];
                boolean lllllIlllII = Boolean.parseBoolean(lllllIlllIl);
                ImpactPlus impactPlus = ImpactPlus.getInstance();
                for (Module llllllIIIII : impactPlus.moduleManager.getModules()) {
                    if (!llllllIIIII.getName().equalsIgnoreCase(lllllIllllI)) continue;
                    llllllIIIII.setDrawn(lllllIlllII);
                }
            }
            lllllIllIII.close();
        }
        catch (Exception lllllIlIllI) {
            lllllIlIllI.printStackTrace();
        }
    }

    public void saveAutoEz() {
        try {
            ConfigUtils lIIIlIlIllll;
            File lIIIlIllIIlI = new File(lIIIlIlIllll.Fortnite.getAbsolutePath(), "AutoEzMessage.txt");
            BufferedWriter lIIIlIllIIIl = new BufferedWriter(new FileWriter(lIIIlIllIIlI));
            for (String lIIIlIllIIll : AutoEz.getAutoEzMessages()) {
                lIIIlIllIIIl.write(lIIIlIllIIll);
                lIIIlIllIIIl.write("\r\n");
            }
            lIIIlIllIIIl.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void saveRainbow() {
        try {
            ConfigUtils lIIIIlIIIlIl;
            File lIIIIlIIIlll = new File(lIIIIlIIIlIl.Fortnite.getAbsolutePath(), "RainbowSpeed.txt");
            BufferedWriter lIIIIlIIIllI = new BufferedWriter(new FileWriter(lIIIIlIIIlll));
            lIIIIlIIIllI.write(String.valueOf(new StringBuilder().append(EventProcessor.INSTANCE.getRainbowSpeed()).append("")));
            lIIIIlIIIllI.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void saveMods() {
        try {
            ConfigUtils lIIIlIIIllIl;
            File lIIIlIIlIIIl = new File(lIIIlIIIllIl.Fortnite.getAbsolutePath(), "EnabledModules.txt");
            BufferedWriter lIIIlIIlIIII = new BufferedWriter(new FileWriter(lIIIlIIlIIIl));
            ImpactPlus impactPlus = ImpactPlus.getInstance();
            for (Module lIIIlIIlIIlI : impactPlus.moduleManager.getModules()) {
                if (!lIIIlIIlIIlI.isEnabled()) continue;
                lIIIlIIlIIII.write(lIIIlIIlIIlI.getName());
                lIIIlIIlIIII.write("\r\n");
            }
            lIIIlIIlIIII.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void saveSettingsList() {
        ConfigUtils llllIIlllII;
        try {
            File llllIlIlIII = new File(llllIIlllII.Settings.getAbsolutePath(), "Number.txt");
            BufferedWriter llllIlIIlll = new BufferedWriter(new FileWriter(llllIlIlIII));
            for (Setting llllIlIlIIl : ImpactPlus.getInstance().settingsManager.getSettings()) {
                if (llllIlIlIIl.getType() == Setting.Type.DOUBLE) {
                    llllIlIIlll.write(String.valueOf(new StringBuilder().append(llllIlIlIIl.getName()).append(":").append(((Setting.d)llllIlIlIIl).getValue()).append(":").append(llllIlIlIIl.getParent().getName()).append("\r\n")));
                }
                if (llllIlIlIIl.getType() != Setting.Type.INT) continue;
                llllIlIIlll.write(String.valueOf(new StringBuilder().append(llllIlIlIIl.getName()).append(":").append(((Setting.i)llllIlIlIIl).getValue()).append(":").append(llllIlIlIIl.getParent().getName()).append("\r\n")));
            }
            llllIlIIlll.close();
        }
        catch (Exception llllIIlIlll) {
            // empty catch block
        }
        try {
            File llllIlIIlII = new File(llllIIlllII.Settings.getAbsolutePath(), "Boolean.txt");
            BufferedWriter llllIlIIIll = new BufferedWriter(new FileWriter(llllIlIIlII));
            for (Setting llllIlIIlIl : ImpactPlus.getInstance().settingsManager.getSettings()) {
                if (llllIlIIlIl.getType() != Setting.Type.BOOLEAN) continue;
                llllIlIIIll.write(String.valueOf(new StringBuilder().append(llllIlIIlIl.getName()).append(":").append(((Setting.b)llllIlIIlIl).getValue()).append(":").append(llllIlIIlIl.getParent().getName()).append("\r\n")));
            }
            llllIlIIIll.close();
        }
        catch (Exception llllIIlIlll) {
            // empty catch block
        }
        try {
            File llllIlIIIII = new File(llllIIlllII.Settings.getAbsolutePath(), "String.txt");
            BufferedWriter llllIIlllll = new BufferedWriter(new FileWriter(llllIlIIIII));
            for (Setting llllIlIIIIl : ImpactPlus.getInstance().settingsManager.getSettings()) {
                if (llllIlIIIIl.getType() != Setting.Type.MODE) continue;
                llllIIlllll.write(String.valueOf(new StringBuilder().append(llllIlIIIIl.getName()).append(":").append(((Setting.mode)llllIlIIIIl).getValue()).append(":").append(llllIlIIIIl.getParent().getName()).append("\r\n")));
            }
            llllIIlllll.close();
        }
        catch (Exception llllIIlIlll) {
            // empty catch block
        }
    }

    public void loadBinds() {
        try {
            String lIIIllIIIllI;
            ConfigUtils lIIIllIIIlII;
            File lIIIllIIlIlI = new File(lIIIllIIIlII.Fortnite.getAbsolutePath(), "Binds.txt");
            FileInputStream lIIIllIIlIIl = new FileInputStream(lIIIllIIlIlI.getAbsolutePath());
            DataInputStream lIIIllIIlIII = new DataInputStream(lIIIllIIlIIl);
            BufferedReader lIIIllIIIlll = new BufferedReader(new InputStreamReader(lIIIllIIlIII));
            while ((lIIIllIIIllI = lIIIllIIIlll.readLine()) != null) {
                String lIIIllIIllIl = lIIIllIIIllI.trim();
                String lIIIllIIllII = lIIIllIIllIl.split(":")[0];
                String lIIIllIIlIll = lIIIllIIllIl.split(":")[1];
                ImpactPlus impactPlus = ImpactPlus.getInstance();
                for (Module lIIIllIIlllI : impactPlus.moduleManager.getModules()) {
                    if (lIIIllIIlllI == null || !lIIIllIIlllI.getName().equalsIgnoreCase(lIIIllIIllII)) continue;
                    lIIIllIIlllI.setBind(Keyboard.getKeyIndex((String)lIIIllIIlIll));
                }
            }
            lIIIllIIIlll.close();
        }
        catch (Exception lIIIllIIIlIl) {
            lIIIllIIIlIl.printStackTrace();
        }
    }

    public void saveDrawn() {
        try {
            ConfigUtils lllllllIIIl;
            File lllllllIlIl = new File(lllllllIIIl.Fortnite.getAbsolutePath(), "Drawn.txt");
            BufferedWriter lllllllIlII = new BufferedWriter(new FileWriter(lllllllIlIl));
            ImpactPlus impactPlus = ImpactPlus.getInstance();
            for (Module lllllllIllI : impactPlus.moduleManager.getModules()) {
                lllllllIlII.write(String.valueOf(new StringBuilder().append(lllllllIllI.getName()).append(":").append(lllllllIllI.isDrawn())));
                lllllllIlII.write("\r\n");
            }
            lllllllIlII.close();
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    public void loadMods() {
        try {
            String llllIlllIlI;
            ConfigUtils llllIlllIII;
            File llllIlllllI = new File(llllIlllIII.Fortnite.getAbsolutePath(), "EnabledModules.txt");
            FileInputStream llllIllllIl = new FileInputStream(llllIlllllI.getAbsolutePath());
            DataInputStream llllIllllII = new DataInputStream(llllIllllIl);
            BufferedReader llllIlllIll = new BufferedReader(new InputStreamReader(llllIllllII));
            while ((llllIlllIlI = llllIlllIll.readLine()) != null) {
                for (Module lllllIIIIII : ModuleManager.getModules()) {
                    if (!lllllIIIIII.getName().equals(llllIlllIlI)) continue;
                    lllllIIIIII.enable();
                }
            }
            llllIlllIll.close();
        }
        catch (Exception llllIlllIIl) {
            llllIlllIIl.printStackTrace();
        }
    }

    public void loadFriends() {
        try {
            String lIIIIllIllll;
            ConfigUtils lIIIIllIllII;
            File lIIIIlllIIll = new File(lIIIIllIllII.Fortnite.getAbsolutePath(), "Friends.txt");
            FileInputStream lIIIIlllIIlI = new FileInputStream(lIIIIlllIIll.getAbsolutePath());
            DataInputStream lIIIIlllIIIl = new DataInputStream(lIIIIlllIIlI);
            BufferedReader lIIIIlllIIII = new BufferedReader(new InputStreamReader(lIIIIlllIIIl));
            Friends.friends.clear();
            while ((lIIIIllIllll = lIIIIlllIIII.readLine()) != null) {
                ImpactPlus.getInstance().friends.addFriend(lIIIIllIllll);
            }
            lIIIIlllIIII.close();
        }
        catch (Exception lIIIIllIlllI) {
            lIIIIllIlllI.printStackTrace();
        }
    }
}

