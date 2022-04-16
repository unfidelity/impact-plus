/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.block.Block
 *  net.minecraft.client.audio.ISound
 *  net.minecraft.client.audio.PositionedSoundRecord
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.AbstractChestHorse
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.SoundEvents
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.network.play.server.SPacketChunkData
 *  net.minecraft.tileentity.TileEntitySign
 *  net.minecraft.util.SoundEvent
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.ChunkPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3i
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.world.World
 *  net.minecraft.world.chunk.Chunk
 */
package me.axua.impactplus.module.modules.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.TrayIcon;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.EventProcessor;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.misc.Notifications;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.render.BoxRender;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.Block;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.AbstractChestHorse;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class StashFinder
extends Module {
    public /* synthetic */ List<BlockPos> signs;
    public /* synthetic */ List<ChunkPos> chunks;
    public /* synthetic */ List<UUID> donkeys;
    public /* synthetic */ Setting.b render;
    public /* synthetic */ Setting.b logactive;
    public /* synthetic */ ChunkPos nextChunk;
    public /* synthetic */ List<String> IllegalChunk;
    public /* synthetic */ Setting.mode mode;
    public /* synthetic */ Setting.i chests;
    public /* synthetic */ int range;
    public /* synthetic */ List<ChunkPos> nextChunks;
    public /* synthetic */ Setting.b flightactive;
    public /* synthetic */ Setting.i flygap;
    public /* synthetic */ File impact;
    public /* synthetic */ List<String> ShulkerChunk;
    public /* synthetic */ ChunkPos startChunk;
    public /* synthetic */ Setting.b playsound;
    public /* synthetic */ Setting.b exludeyellow;
    public /* synthetic */ Setting.b notfication;
    public /* synthetic */ Setting.b showcoordsinchat;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Receive> receiveListener;
    public /* synthetic */ List<String> ChestChunk;

    public String getServer() {
        return mc.getCurrentServerData() != null ? StashFinder.mc.getCurrentServerData().serverIP : "Singleplayer";
    }

    public StashFinder() {
        super("StashFinder", Module.Category.MISC);
        StashFinder lIIlIllIlIlIlll;
        lIIlIllIlIlIlll.chunks = new ArrayList<ChunkPos>();
        lIIlIllIlIlIlll.nextChunks = new ArrayList<ChunkPos>();
        lIIlIllIlIlIlll.range = 0;
        lIIlIllIlIlIlll.ChestChunk = new ArrayList<String>();
        lIIlIllIlIlIlll.IllegalChunk = new ArrayList<String>();
        lIIlIllIlIlIlll.ShulkerChunk = new ArrayList<String>();
        lIIlIllIlIlIlll.signs = new ArrayList<BlockPos>();
        lIIlIllIlIlIlll.donkeys = new ArrayList<UUID>();
        lIIlIllIlIlIlll.receiveListener = new Listener<PacketEvent.Receive>(lIIlIIllIIlIIlI -> {
            StashFinder lIIlIIllIIlIIIl;
            if (StashFinder.mc.theWorld == null || StashFinder.mc.thePlayer == null || !lIIlIIllIIlIIIl.logactive.getValue()) {
                return;
            }
            if (lIIlIIllIIlIIlI.getPacket() instanceof SPacketChunkData) {
                SPacketChunkData lIIlIIllIIlIlIl = (SPacketChunkData)lIIlIIllIIlIIlI.getPacket();
                lIIlIIllIIlIIIl.chests(lIIlIIllIIlIlIl);
                Chunk lIIlIIllIIlIlII = new Chunk((World)StashFinder.mc.theWorld, lIIlIIllIIlIlIl.getChunkX(), lIIlIIllIIlIlIl.getChunkZ());
                lIIlIIllIIlIIIl.illegal(lIIlIIllIIlIlIl, lIIlIIllIIlIlII);
                lIIlIIllIIlIIIl.shulker(lIIlIIllIIlIlIl, lIIlIIllIIlIlII);
            }
        }, new Predicate[0]);
    }

    @Override
    public void onUpdate() {
        int lIIlIllIIlllIlI;
        StashFinder lIIlIllIIlllIIl;
        lIIlIllIIlllIIl.log();
        if (StashFinder.mc.theWorld == null || StashFinder.mc.thePlayer == null || StashFinder.mc.thePlayer.onGround || !lIIlIllIIlllIIl.flightactive.getValue()) {
            return;
        }
        if (lIIlIllIIlllIIl.startChunk == null) {
            lIIlIllIIlllIIl.startChunk = new ChunkPos(StashFinder.mc.thePlayer.getPosition());
        }
        int lIIlIllIIllllIl = 16;
        int lIIlIllIIllllII = 1;
        boolean lIIlIllIIlllIll = false;
        for (lIIlIllIIlllIlI = -lIIlIllIIllllIl; lIIlIllIIlllIlI <= lIIlIllIIllllIl; lIIlIllIIlllIlI += 16) {
            for (int lIIlIllIlIIIIIl = -lIIlIllIIllllIl; lIIlIllIlIIIIIl <= lIIlIllIIllllIl; lIIlIllIlIIIIIl += 16) {
                ChunkPos lIIlIllIlIIIIlI = new ChunkPos(StashFinder.mc.thePlayer.getPosition().add(lIIlIllIIlllIlI, 0, lIIlIllIlIIIIIl));
                if (lIIlIllIIlllIIl.chunks.contains(lIIlIllIlIIIIlI)) continue;
                lIIlIllIIlllIIl.chunks.add(lIIlIllIlIIIIlI);
                if (!lIIlIllIIlllIIl.nextChunks.contains(lIIlIllIlIIIIlI)) continue;
                lIIlIllIIlllIIl.nextChunks.remove(lIIlIllIlIIIIlI);
                if (lIIlIllIIlllIll) continue;
                lIIlIllIIlllIIl.nextChunks.sort(Comparator.comparingDouble(lIIlIIllIIIlIII -> lIIlIIllIIIlIII.getBlock(8, 0, 8).distanceSq((Vec3i)StashFinder.mc.thePlayer.getPosition())));
                lIIlIllIIlllIll = true;
            }
        }
        if (lIIlIllIIlllIIl.nextChunks.isEmpty()) {
            lIIlIllIIlllIIl.chunks.clear();
            lIIlIllIIlllIIl.range += lIIlIllIIlllIIl.flygap.getValue();
            for (lIIlIllIIlllIlI = lIIlIllIIlllIIl.startChunk.chunkXPos - lIIlIllIIlllIIl.range; lIIlIllIIlllIlI <= lIIlIllIIlllIIl.startChunk.chunkXPos + lIIlIllIIlllIIl.range; ++lIIlIllIIlllIlI) {
                for (int lIIlIllIIllllll = lIIlIllIIlllIIl.startChunk.chunkZPos - lIIlIllIIlllIIl.range; lIIlIllIIllllll <= lIIlIllIIlllIIl.startChunk.chunkZPos + lIIlIllIIlllIIl.range; ++lIIlIllIIllllll) {
                    ChunkPos lIIlIllIlIIIIII;
                    if (Math.abs(lIIlIllIIlllIlI - lIIlIllIIlllIIl.startChunk.chunkXPos) <= lIIlIllIIlllIIl.range - lIIlIllIIllllII && Math.abs(lIIlIllIIllllll - lIIlIllIIlllIIl.startChunk.chunkZPos) <= lIIlIllIIlllIIl.range - lIIlIllIIllllII || lIIlIllIIlllIIl.chunks.contains(lIIlIllIlIIIIII = new ChunkPos(lIIlIllIIlllIlI, lIIlIllIIllllll))) continue;
                    lIIlIllIIlllIIl.nextChunks.add(lIIlIllIlIIIIII);
                }
            }
            lIIlIllIIlllIIl.nextChunks.sort(Comparator.comparingDouble(lIIlIIllIIIllII -> lIIlIIllIIIllII.getBlock(8, 0, 8).distanceSq((Vec3i)StashFinder.mc.thePlayer.getPosition())));
            return;
        }
        lIIlIllIIlllIIl.nextChunk = lIIlIllIIlllIIl.nextChunks.get(0);
        lIIlIllIIlllIIl.facePos(lIIlIllIIlllIIl.nextChunk.getXStart() + 8, lIIlIllIIlllIIl.nextChunk.getZStart() + 8);
        if (!StashFinder.mc.gameSettings.keyBindForward.isPressed()) {
            StashFinder.mc.gameSettings.keyBindForward.pressed = true;
        }
        StashFinder.mc.gameSettings.keyBindForward.pressed = true;
    }

    @Override
    public void setup() {
        StashFinder lIIlIllIlIlIIIl;
        ArrayList<String> lIIlIllIlIlIIlI = new ArrayList<String>();
        lIIlIllIlIlIIlI.add("0,0");
        lIIlIllIlIlIIlI.add("Current");
        lIIlIllIlIlIIIl.mode = lIIlIllIlIlIIIl.registerMode("Mode", lIIlIllIlIlIIlI, "Current");
        lIIlIllIlIlIIIl.flygap = lIIlIllIlIlIIIl.registerI("FlyGap", 9, 1, 10);
        lIIlIllIlIlIIIl.chests = lIIlIllIlIlIIIl.registerI("Chests", 9, 1, 10);
        lIIlIllIlIlIIIl.render = lIIlIllIlIlIIIl.registerB("Render", true);
        lIIlIllIlIlIIIl.flightactive = lIIlIllIlIlIIIl.registerB("FlightActive", true);
        lIIlIllIlIlIIIl.logactive = lIIlIllIlIlIIIl.registerB("LogActive", true);
        lIIlIllIlIlIIIl.showcoordsinchat = lIIlIllIlIlIIIl.registerB("HideCoords", false);
        lIIlIllIlIlIIIl.playsound = lIIlIllIlIlIIIl.registerB("PlaySound", true);
        lIIlIllIlIlIIIl.notfication = lIIlIllIlIlIIIl.registerB("Notfication", false);
        lIIlIllIlIlIIIl.exludeyellow = lIIlIllIlIlIIIl.registerB("ExludeYellowShulker", false);
    }

    private void chests(SPacketChunkData lIIlIlIIlIlllIl) {
        StashFinder lIIlIlIIlIllllI;
        int lIIlIlIIlIlllII = 0;
        for (NBTTagCompound lIIlIlIIllIIIll : lIIlIlIIlIlllIl.func_189554_f()) {
            String lIIlIlIIllIIlII = lIIlIlIIllIIIll.getString("id");
            if (!lIIlIlIIllIIlII.equals("minecraft:chest")) continue;
            ++lIIlIlIIlIlllII;
        }
        if (lIIlIlIIlIlllII >= lIIlIlIIlIllllI.chests.getValue()) {
            if (lIIlIlIIlIllllI.ChestChunk.contains(String.valueOf(new StringBuilder().append(lIIlIlIIlIlllII).append(".").append(lIIlIlIIlIlllIl.getChunkX() * 16).append(".").append(lIIlIlIIlIlllIl.getChunkZ() * 16)))) {
                return;
            }
            lIIlIlIIlIllllI.ChestChunk.add(String.valueOf(new StringBuilder().append(lIIlIlIIlIlllII).append(".").append(lIIlIlIIlIlllIl.getChunkX() * 16).append(".").append(lIIlIlIIlIlllIl.getChunkZ() * 16)));
            if (lIIlIlIIlIllllI.notfication.getValue()) {
                Notifications.sendNotification(String.valueOf(new StringBuilder().append(lIIlIlIIlIlllII).append(" chests located")), TrayIcon.MessageType.INFO);
            }
            if (lIIlIlIIlIllllI.playsound.getValue()) {
                mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.func_194007_a((SoundEvent)SoundEvents.field_187604_bf, (float)1.0f, (float)1.0f));
            }
            if (!lIIlIlIIlIllllI.showcoordsinchat.getValue()) {
                Command.sendClientMessage(String.format(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("%s chests located at: x%s, z%s")), lIIlIlIIlIlllII, lIIlIlIIlIlllIl.getChunkX() * 16, lIIlIlIIlIlllIl.getChunkZ() * 16));
            } else {
                Command.sendClientMessage(String.format(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("%s chests located at: x%s, z%s")), lIIlIlIIlIlllII, String.valueOf(new StringBuilder().append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET).append(ChatFormatting.GOLD)), String.valueOf(new StringBuilder().append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET))));
            }
            try {
                BufferedWriter lIIlIlIIllIIIlI = new BufferedWriter(new FileWriter("Impact+\\StashFinder.txt", true));
                Calendar lIIlIlIIllIIIIl = Calendar.getInstance();
                SimpleDateFormat lIIlIlIIllIIIII = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                lIIlIlIIllIIIlI.write(String.format("%s chests located at: x%s, z%s on %s at [%s]", lIIlIlIIlIlllII, lIIlIlIIlIlllIl.getChunkX() * 16, lIIlIlIIlIlllIl.getChunkZ() * 16, lIIlIlIIlIllllI.getServer(), lIIlIlIIllIIIII.format(lIIlIlIIllIIIIl.getTime())));
                lIIlIlIIllIIIlI.newLine();
                lIIlIlIIllIIIlI.close();
            }
            catch (IOException lIIlIlIIlIlllll) {
                lIIlIlIIlIlllll.printStackTrace();
            }
        }
    }

    @Override
    public void onEnable() {
        StashFinder lIIlIllIlIIllIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)lIIlIllIlIIllIl);
        lIIlIllIlIIllIl.impact = new File(String.valueOf(new StringBuilder().append(StashFinder.mc.mcDataDir).append(File.separator).append("Impact+")));
        if (!lIIlIllIlIIllIl.impact.exists()) {
            lIIlIllIlIIllIl.impact.mkdirs();
        }
        if (StashFinder.mc.theWorld == null || StashFinder.mc.thePlayer == null) {
            return;
        }
        if (lIIlIllIlIIllIl.startChunk != null) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append("StashFinder: Starting from ").append(lIIlIllIlIIllIl.startChunk.getXStart()).append(", ").append(lIIlIllIlIIllIl.startChunk.getZStart())));
            lIIlIllIlIIllIl.range = ((int)Math.max(Math.abs(StashFinder.mc.thePlayer.posX - (double)lIIlIllIlIIllIl.startChunk.getXStart()), Math.abs(StashFinder.mc.thePlayer.posZ - (double)lIIlIllIlIIllIl.startChunk.getZStart())) >> 4) - 1;
        } else if (lIIlIllIlIIllIl.mode.getValue().equalsIgnoreCase("0,0")) {
            lIIlIllIlIIllIl.range = ((int)Math.max(Math.abs(StashFinder.mc.thePlayer.posX), Math.abs(StashFinder.mc.thePlayer.posZ)) >> 4) - 1;
            if (lIIlIllIlIIllIl.range < 0) {
                lIIlIllIlIIllIl.range = 0;
            }
            lIIlIllIlIIllIl.startChunk = new ChunkPos(0, 0);
        } else {
            lIIlIllIlIIllIl.startChunk = new ChunkPos(StashFinder.mc.thePlayer.getPosition());
        }
    }

    public void log() {
        StashFinder lIIlIlIlIlIIIII;
        if (StashFinder.mc.theWorld == null || StashFinder.mc.thePlayer == null || !lIIlIlIlIlIIIII.logactive.getValue()) {
            return;
        }
        for (Object lIIlIlIlIlIlIll : StashFinder.mc.theWorld.loadedTileEntityList) {
            TileEntitySign lIIlIlIlIlIllII;
            if (!(lIIlIlIlIlIlIll instanceof TileEntitySign) || lIIlIlIlIlIIIII.signs.contains((lIIlIlIlIlIllII = (TileEntitySign)lIIlIlIlIlIlIll).getPos()) || lIIlIlIlIlIllII.signText == new ITextComponent[]{new TextComponentString(""), new TextComponentString(""), new TextComponentString(""), new TextComponentString("")} || lIIlIlIlIlIllII.signText[0].getUnformattedText().equalsIgnoreCase("") && lIIlIlIlIlIllII.signText[1].getUnformattedText().equalsIgnoreCase("") && lIIlIlIlIlIllII.signText[2].getUnformattedText().equalsIgnoreCase("") && lIIlIlIlIlIllII.signText[3].getUnformattedText().equalsIgnoreCase("") || lIIlIlIlIlIllII.signText[0].getUnformattedText().equalsIgnoreCase("") && lIIlIlIlIlIllII.signText[1].getUnformattedText().equalsIgnoreCase("<----") && lIIlIlIlIlIllII.signText[2].getUnformattedText().equalsIgnoreCase("---->") && lIIlIlIlIlIllII.signText[3].getUnformattedText().equalsIgnoreCase("")) continue;
            lIIlIlIlIlIIIII.signs.add(lIIlIlIlIlIllII.getPos());
            if (lIIlIlIlIlIIIII.notfication.getValue()) {
                Notifications.sendNotification("Sign located", TrayIcon.MessageType.INFO);
            }
            if (lIIlIlIlIlIIIII.playsound.getValue()) {
                mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.func_194007_a((SoundEvent)SoundEvents.field_187604_bf, (float)1.0f, (float)1.0f));
            }
            if (!lIIlIlIlIlIIIII.showcoordsinchat.getValue()) {
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("Sign \"").append(lIIlIlIlIlIllII.signText[0].getUnformattedText()).append(" / ").append(lIIlIlIlIlIllII.signText[1].getUnformattedText()).append(" / ").append(lIIlIlIlIlIllII.signText[2].getUnformattedText()).append(" / ").append(lIIlIlIlIlIllII.signText[3].getUnformattedText()).append("\" located at: x").append(lIIlIlIlIlIllII.getPos().getX()).append(", y").append(lIIlIlIlIlIllII.getPos().getY()).append(", z").append(lIIlIlIlIlIllII.getPos().getZ())));
            } else {
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("Sign \"").append(lIIlIlIlIlIllII.signText[0].getUnformattedText()).append(" / ").append(lIIlIlIlIlIllII.signText[1].getUnformattedText()).append(" / ").append(lIIlIlIlIlIllII.signText[2].getUnformattedText()).append(" / ").append(lIIlIlIlIlIllII.signText[3].getUnformattedText()).append("\" located at: x").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET).append(ChatFormatting.GOLD).append(", y").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET).append(ChatFormatting.GOLD).append(", z").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET)));
            }
            try {
                BufferedWriter lIIlIlIlIllIIII = new BufferedWriter(new FileWriter("Impact+\\StashFinder.txt", true));
                Calendar lIIlIlIlIlIllll = Calendar.getInstance();
                SimpleDateFormat lIIlIlIlIlIlllI = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                lIIlIlIlIllIIII.write(String.valueOf(new StringBuilder().append("Sign \"").append(lIIlIlIlIlIllII.signText[0].getUnformattedText()).append(" / ").append(lIIlIlIlIlIllII.signText[1].getUnformattedText()).append(" / ").append(lIIlIlIlIlIllII.signText[2].getUnformattedText()).append(" / ").append(lIIlIlIlIlIllII.signText[3].getUnformattedText()).append("\" located at: x").append(lIIlIlIlIlIllII.getPos().getX()).append(", y").append(lIIlIlIlIlIllII.getPos().getY()).append(", z").append(lIIlIlIlIlIllII.getPos().getZ()).append(" on ").append(lIIlIlIlIlIIIII.getServer()).append(" at [").append(lIIlIlIlIlIlllI.format(lIIlIlIlIlIllll.getTime())).append("]")));
                lIIlIlIlIllIIII.newLine();
                lIIlIlIlIllIIII.close();
            }
            catch (IOException lIIlIlIlIlIllIl) {
                lIIlIlIlIlIllIl.printStackTrace();
            }
        }
        for (Entity lIIlIlIlIlIIIll : StashFinder.mc.theWorld.loadedEntityList) {
            AbstractChestHorse lIIlIlIlIlIIllI;
            if (!(lIIlIlIlIlIIIll instanceof AbstractChestHorse) || !(lIIlIlIlIlIIllI = (AbstractChestHorse)lIIlIlIlIlIIIll).func_190695_dh() || lIIlIlIlIlIIIII.donkeys.contains(lIIlIlIlIlIIllI.getUniqueID())) continue;
            lIIlIlIlIlIIIII.donkeys.add(lIIlIlIlIlIIllI.getUniqueID());
            if (lIIlIlIlIlIIIII.notfication.getValue()) {
                Notifications.sendNotification(String.valueOf(new StringBuilder().append("Dupe ").append(lIIlIlIlIlIIllI.getDisplayName().getUnformattedText()).append(" located")), TrayIcon.MessageType.INFO);
            }
            if (lIIlIlIlIlIIIII.playsound.getValue()) {
                mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.func_194007_a((SoundEvent)SoundEvents.field_187604_bf, (float)1.0f, (float)1.0f));
            }
            lIIlIlIlIlIIllI = (AbstractChestHorse)lIIlIlIlIlIIIll;
            String lIIlIlIlIlIIlIl = lIIlIlIlIlIIllI.func_184780_dh().toString();
            String lIIlIlIlIlIIlII = EventProcessor.resolveName2(lIIlIlIlIlIIlIl);
            if (!lIIlIlIlIlIIIII.showcoordsinchat.getValue()) {
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("Dupe ").append(lIIlIlIlIlIIllI.getDisplayName().getUnformattedText()).append(" Owned by ").append(lIIlIlIlIlIIlII).append(" located at: x").append((int)lIIlIlIlIlIIllI.posX).append(", y").append((int)lIIlIlIlIlIIllI.posY).append(", z").append((int)lIIlIlIlIlIIllI.posZ)));
            } else {
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("Dupe ").append(lIIlIlIlIlIIllI.getDisplayName().getUnformattedText()).append(" Owned by ").append(lIIlIlIlIlIIlII).append(" located at: x").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET).append(ChatFormatting.GOLD).append(", y").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET).append(ChatFormatting.GOLD).append(", z").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET)));
            }
            try {
                BufferedWriter lIIlIlIlIlIlIlI = new BufferedWriter(new FileWriter("Impact+\\StashFinder.txt", true));
                Calendar lIIlIlIlIlIlIIl = Calendar.getInstance();
                SimpleDateFormat lIIlIlIlIlIlIII = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                lIIlIlIlIlIlIlI.write(String.valueOf(new StringBuilder().append("Dupe ").append(lIIlIlIlIlIIllI.getDisplayName().getUnformattedText()).append(" Owned by ").append(lIIlIlIlIlIIlII).append(" located at: x").append((int)lIIlIlIlIlIIllI.posX).append(", y").append((int)lIIlIlIlIlIIllI.posY).append(", z").append((int)lIIlIlIlIlIIllI.posZ).append(" on ").append(lIIlIlIlIlIIIII.getServer()).append(" at [").append(lIIlIlIlIlIlIII.format(lIIlIlIlIlIlIIl.getTime())).append("]")));
                lIIlIlIlIlIlIlI.newLine();
                lIIlIlIlIlIlIlI.close();
            }
            catch (IOException lIIlIlIlIlIIlll) {
                lIIlIlIlIlIIlll.printStackTrace();
            }
        }
    }

    private void shulker(SPacketChunkData lIIlIIllIllIIIl, Chunk lIIlIIllIllIIII) {
        lIIlIIllIllIIII.func_186033_a(lIIlIIllIllIIIl.func_186946_a(), lIIlIIllIllIIIl.getExtractedSize(), lIIlIIllIllIIIl.func_149274_i());
        List<Block> lIIlIIllIllIIll = Arrays.asList(Blocks.field_190985_dt, Blocks.field_190975_dA, Blocks.field_190988_dw, Blocks.field_190989_dx, Blocks.field_190986_du, Blocks.field_190984_ds, Blocks.field_190990_dy, Blocks.field_190980_do, Blocks.field_190982_dq, Blocks.field_190979_dn, Blocks.field_190978_dm, Blocks.field_190983_dr, Blocks.field_190987_dv, Blocks.field_190991_dz, Blocks.field_190977_dl, Blocks.field_190981_dp);
        for (int lIIlIIllIllIlll = 0; lIIlIIllIllIlll < 15; ++lIIlIIllIllIlll) {
            for (int lIIlIIllIlllIII = 0; lIIlIIllIlllIII < 255; ++lIIlIIllIlllIII) {
                for (int lIIlIIllIlllIIl = 0; lIIlIIllIlllIIl < 15; ++lIIlIIllIlllIIl) {
                    StashFinder lIIlIIllIllIllI;
                    Block lIIlIIllIlllIlI = lIIlIIllIllIIII.func_186032_a(lIIlIIllIllIlll, lIIlIIllIlllIII, lIIlIIllIlllIIl).getBlock();
                    if (!lIIlIIllIllIIll.contains(lIIlIIllIlllIlI) || lIIlIIllIllIllI.exludeyellow.getValue() && lIIlIIllIlllIlI.getLocalizedName().equalsIgnoreCase("Yellow Shulker Box") || lIIlIIllIllIllI.ShulkerChunk.contains(String.valueOf(new StringBuilder().append(lIIlIIllIllIIII.xPosition * 16 + lIIlIIllIllIlll).append(".").append(lIIlIIllIlllIII).append(".").append(lIIlIIllIllIIII.zPosition * 16 + lIIlIIllIlllIIl)))) continue;
                    lIIlIIllIllIllI.ShulkerChunk.add(String.valueOf(new StringBuilder().append(lIIlIIllIllIIII.xPosition * 16 + lIIlIIllIllIlll).append(".").append(lIIlIIllIlllIII).append(".").append(lIIlIIllIllIIII.zPosition * 16 + lIIlIIllIlllIIl)));
                    if (lIIlIIllIllIllI.notfication.getValue()) {
                        Notifications.sendNotification(String.valueOf(new StringBuilder().append(lIIlIIllIlllIlI.getLocalizedName()).append(" located")), TrayIcon.MessageType.INFO);
                    }
                    if (lIIlIIllIllIllI.playsound.getValue()) {
                        mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.func_194007_a((SoundEvent)SoundEvents.field_187604_bf, (float)1.0f, (float)1.0f));
                    }
                    if (!lIIlIIllIllIllI.showcoordsinchat.getValue()) {
                        Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append(lIIlIIllIlllIlI.getLocalizedName()).append(" located at: x").append(lIIlIIllIllIIII.xPosition * 16 + lIIlIIllIllIlll).append(", y").append(lIIlIIllIlllIII).append(", z").append(lIIlIIllIllIIII.zPosition * 16 + lIIlIIllIlllIIl)));
                    } else {
                        Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append(lIIlIIllIlllIlI.getLocalizedName()).append(" located at: x").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET).append(ChatFormatting.GOLD).append(", y").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET).append(ChatFormatting.GOLD).append(", z").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET)));
                    }
                    try {
                        BufferedWriter lIIlIIllIlllllI = new BufferedWriter(new FileWriter("Impact+\\StashFinder.txt", true));
                        Calendar lIIlIIllIllllIl = Calendar.getInstance();
                        SimpleDateFormat lIIlIIllIllllII = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        lIIlIIllIlllllI.write(String.valueOf(new StringBuilder().append(lIIlIIllIlllIlI.getLocalizedName()).append(" located at: x").append(lIIlIIllIllIIII.xPosition * 16 + lIIlIIllIllIlll).append(", y").append(lIIlIIllIlllIII).append(", z").append(lIIlIIllIllIIII.zPosition * 16 + lIIlIIllIlllIIl).append(" on ").append(lIIlIIllIllIllI.getServer()).append(" at [").append(lIIlIIllIllllII.format(lIIlIIllIllllIl.getTime())).append("]")));
                        lIIlIIllIlllllI.newLine();
                        lIIlIIllIlllllI.close();
                        continue;
                    }
                    catch (IOException lIIlIIllIlllIll) {
                        lIIlIIllIlllIll.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void onDisable() {
        StashFinder lIIlIllIlIIlIll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lIIlIllIlIIlIll);
        lIIlIllIlIIlIll.chunks = new ArrayList<ChunkPos>();
        lIIlIllIlIIlIll.nextChunks = new ArrayList<ChunkPos>();
        lIIlIllIlIIlIll.nextChunk = null;
        lIIlIllIlIIlIll.startChunk = null;
        lIIlIllIlIIlIll.ChestChunk.clear();
        lIIlIllIlIIlIll.IllegalChunk.clear();
        lIIlIllIlIIlIll.ShulkerChunk.clear();
        lIIlIllIlIIlIll.signs.clear();
        lIIlIllIlIIlIll.donkeys.clear();
        lIIlIllIlIIlIll.range = 0;
        StashFinder.mc.gameSettings.keyBindForward.pressed = false;
    }

    @Override
    public void onWorldRender(RenderEvent lIIlIllIIIlllIl) {
        StashFinder lIIlIllIIIllllI;
        if (!lIIlIllIIIllllI.render.getValue() || !lIIlIllIIIllllI.flightactive.getValue()) {
            return;
        }
        for (ChunkPos lIIlIllIIlIIIII : lIIlIllIIIllllI.chunks) {
            BoxRender.drawFilledBlockBox(new AxisAlignedBB(lIIlIllIIlIIIII.getBlock(0, 0, 0), lIIlIllIIlIIIII.getBlock(16, 0, 16)), 1.0f, 0.0f, 0.0f, 0.3f);
        }
        for (ChunkPos lIIlIllIIIlllll : lIIlIllIIIllllI.nextChunks) {
            BoxRender.drawFilledBlockBox(new AxisAlignedBB(lIIlIllIIIlllll.getBlock(0, 0, 0), lIIlIllIIIlllll.getBlock(16, 0, 16)), 0.0f, 0.0f, 1.0f, 0.3f);
        }
        if (lIIlIllIIIllllI.nextChunk != null) {
            BoxRender.drawFilledBlockBox(new AxisAlignedBB(lIIlIllIIIllllI.nextChunk.getBlock(0, 0, 0), lIIlIllIIIllllI.nextChunk.getBlock(16, 0, 16)), 0.0f, 1.0f, 0.0f, 0.3f);
        }
    }

    public void facePos(double lIIlIllIIIIllII, double lIIlIllIIIIIIIl) {
        double lIIlIllIIIIlIII = lIIlIllIIIIllII - StashFinder.mc.thePlayer.posX;
        double lIIlIllIIIIIllI = lIIlIllIIIIIIIl - StashFinder.mc.thePlayer.posZ;
        float lIIlIllIIIIIlII = (float)Math.toDegrees(Math.atan2(lIIlIllIIIIIllI, lIIlIllIIIIlIII)) - 90.0f;
        StashFinder.mc.thePlayer.rotationYaw += MathHelper.wrapAngleTo180_float((float)(lIIlIllIIIIIlII - StashFinder.mc.thePlayer.rotationYaw));
    }

    private void illegal(SPacketChunkData lIIlIlIIIIlIIIl, Chunk lIIlIlIIIIlIIII) {
        lIIlIlIIIIlIIII.func_186033_a(lIIlIlIIIIlIIIl.func_186946_a(), lIIlIlIIIIlIIIl.getExtractedSize(), lIIlIlIIIIlIIIl.func_149274_i());
        List<Block> lIIlIlIIIIIllll = Arrays.asList(Blocks.bedrock, Blocks.barrier, Blocks.end_portal_frame, Blocks.end_portal);
        for (int lIIlIlIIIIlIIll = 0; lIIlIlIIIIlIIll < 15; ++lIIlIlIIIIlIIll) {
            for (int lIIlIlIIIIlIlII = 0; lIIlIlIIIIlIlII < 255; ++lIIlIlIIIIlIlII) {
                for (int lIIlIlIIIIlIlIl = 0; lIIlIlIIIIlIlIl < 15; ++lIIlIlIIIIlIlIl) {
                    StashFinder lIIlIlIIIIIlllI;
                    Block lIIlIlIIIIlIlll = lIIlIlIIIIlIIII.func_186032_a(lIIlIlIIIIlIIll, lIIlIlIIIIlIlII, lIIlIlIIIIlIlIl).getBlock();
                    if (!lIIlIlIIIIIllll.contains(lIIlIlIIIIlIlll) || lIIlIlIIIIlIlll == Blocks.bedrock && lIIlIlIIIIlIlII <= 5 || lIIlIlIIIIlIlll == Blocks.bedrock && StashFinder.mc.thePlayer.dimension == -1 || lIIlIlIIIIIlllI.IllegalChunk.contains(String.valueOf(new StringBuilder().append(lIIlIlIIIIlIIII.xPosition * 16 + lIIlIlIIIIlIIll).append(".").append(lIIlIlIIIIlIlII).append(".").append(lIIlIlIIIIlIIII.zPosition * 16 + lIIlIlIIIIlIlIl)))) continue;
                    lIIlIlIIIIIlllI.IllegalChunk.add(String.valueOf(new StringBuilder().append(lIIlIlIIIIlIIII.xPosition * 16 + lIIlIlIIIIlIIll).append(".").append(lIIlIlIIIIlIlII).append(".").append(lIIlIlIIIIlIIII.zPosition * 16 + lIIlIlIIIIlIlIl)));
                    if (lIIlIlIIIIIlllI.notfication.getValue()) {
                        Notifications.sendNotification(String.valueOf(new StringBuilder().append(lIIlIlIIIIlIlll.getLocalizedName()).append(" located")), TrayIcon.MessageType.INFO);
                    }
                    if (lIIlIlIIIIIlllI.playsound.getValue()) {
                        mc.getSoundHandler().playSound((ISound)PositionedSoundRecord.func_194007_a((SoundEvent)SoundEvents.field_187604_bf, (float)1.0f, (float)1.0f));
                    }
                    if (!lIIlIlIIIIIlllI.showcoordsinchat.getValue()) {
                        Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("Illegal ").append(lIIlIlIIIIlIlll.getLocalizedName()).append(" located at: x").append(lIIlIlIIIIlIIII.xPosition * 16 + lIIlIlIIIIlIIll).append(", y").append(lIIlIlIIIIlIlII).append(", z").append(lIIlIlIIIIlIIII.zPosition * 16 + lIIlIlIIIIlIlIl)));
                    } else {
                        Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("Illegal ").append(lIIlIlIIIIlIlll.getLocalizedName()).append(" located at: x").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET).append(ChatFormatting.GOLD).append(", y").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET).append(ChatFormatting.GOLD).append(", z").append(ChatFormatting.OBFUSCATED).append("123").append(ChatFormatting.RESET)));
                    }
                    try {
                        BufferedWriter lIIlIlIIIIllllI = new BufferedWriter(new FileWriter("Impact+\\StashFinder.txt", true));
                        Calendar lIIlIlIIIIlllIl = Calendar.getInstance();
                        SimpleDateFormat lIIlIlIIIIllIll = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        lIIlIlIIIIllllI.write(String.valueOf(new StringBuilder().append("Illegal ").append(lIIlIlIIIIlIlll.getLocalizedName()).append(" located at: x").append(lIIlIlIIIIlIIII.xPosition * 16 + lIIlIlIIIIlIIll).append(", y").append(lIIlIlIIIIlIlII).append(", z").append(lIIlIlIIIIlIIII.zPosition * 16 + lIIlIlIIIIlIlIl).append(" on ").append(lIIlIlIIIIIlllI.getServer()).append(" at [").append(lIIlIlIIIIllIll.format(lIIlIlIIIIlllIl.getTime())).append("]")));
                        lIIlIlIIIIllllI.newLine();
                        lIIlIlIIIIllllI.close();
                        continue;
                    }
                    catch (IOException lIIlIlIIIIllIIl) {
                        lIIlIlIIIIllIIl.printStackTrace();
                    }
                }
            }
        }
    }
}

