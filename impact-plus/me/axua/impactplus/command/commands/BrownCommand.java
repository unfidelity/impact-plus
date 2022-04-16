/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Timer;
import java.util.TimerTask;
import me.axua.impactplus.command.Command;
import net.minecraft.client.Minecraft;

public class BrownCommand
extends Command {
    /* synthetic */ String bruh;
    /* synthetic */ Minecraft mc;
    private /* synthetic */ Timer _Timer;

    @Override
    public void onCommand(String lllllllllllllllIllllllllIIIIlllI, String[] lllllllllllllllIllllllllIIIIllIl) throws Exception {
        BrownCommand lllllllllllllllIllllllllIIIIllII;
        if (lllllllllllllllIllllllllIIIIllIl[0] == "") {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("brown <name> <delay in ms>")));
        }
        if (lllllllllllllllIllllllllIIIIllIl[1] == "") {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("brown <name> <delay in ms>")));
        }
        lllllllllllllllIllllllllIIIIllII.bruh = lllllllllllllllIllllllllIIIIllIl[0];
        lllllllllllllllIllllllllIIIIllII._Timer.cancel();
        lllllllllllllllIllllllllIIIIllII._Timer = new Timer();
        lllllllllllllllIllllllllIIIIllII.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllIllllllllIIIIllII.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2880\u28e0\u28e4\u28f4\u28f6\u28f6\u28fe\u28fe\u28ff\u28ff\u28ff\u28ff\u28f7\u28f7\u28f6\u28f6\u28e4\u28e4\u2840\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                1 lllllllllllllllllIIIIllllIIllllI;
                lllllllllllllllllIIIIllllIIllllI.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllllIIIIllllIIllllI.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28c0\u28e4\u28fe\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28e6\u28c4\u2840\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                1 lllllllllllllllllIIIIllllIlIIIll;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                2 lllllllllllllllIlllllIIlllIllIIl;
                lllllllllllllllIlllllIIlllIllIIl.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllIlllllIIlllIllIIl.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2880\u28f0\u28fe\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28f6\u2840\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                2 lllllllllllllllIlllllIIllllIIIII;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 2);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                3 llllllllllllllllIIIIIlllIlllIlll;
            }

            @Override
            public void run() {
                3 llllllllllllllllIIIIIlllIlllIIll;
                llllllllllllllllIIIIIlllIlllIIll.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllIIIIIlllIlllIIll.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28a0\u28fe\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28e7\u2840\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 3);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                4 lllllllllllllllIlllIIIlllllIIIlI;
                lllllllllllllllIlllIIIlllllIIIlI.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllIlllIIIlllllIIIlI.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28f4\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28c4\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                4 lllllllllllllllIlllIIIlllllIlIII;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 4);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                5 lllllllllllllllIlllIIIIllIIllIIl;
            }

            @Override
            public void run() {
                5 lllllllllllllllIlllIIIIllIIlIlIl;
                lllllllllllllllIlllIIIIllIIlIlIl.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllIlllIIIIllIIlIlIl.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u28b0\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2844\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 5);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                6 lllllllllllllllllIIlIllIllIIlIll;
            }

            @Override
            public void run() {
                6 lllllllllllllllllIIlIllIllIIIlll;
                lllllllllllllllllIIlIllIllIIIlll.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllllIIlIllIllIIIlll.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2880\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28bf\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2840\u2804\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 6);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                7 lllllllllllllllIlllIIlIIIIIlllIl;
            }

            @Override
            public void run() {
                7 lllllllllllllllIlllIIlIIIIIlIlll;
                lllllllllllllllIlllIIlIIIIIlIlll.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllIlllIIlIIIIIlIlll.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u28b8\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28bf\u289d\u287d\u28f9\u28bd\u28bf\u28ff\u28ff\u28ff\u28ff\u28bf\u28ff\u28ff\u28ff\u28ff\u28bf\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2846\u2804\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 7);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                8 lllllllllllllllIllllIllIlIIllIII;
            }

            @Override
            public void run() {
                8 lllllllllllllllIllllIllIlIIlIlII;
                lllllllllllllllIllllIllIlIIlIlII.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllIllllIllIlIIlIlII.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u28b8\u28ff\u28ff\u28ff\u28ff\u28ff\u28af\u2873\u28dd\u28ae\u2873\u28dd\u285e\u286e\u28fb\u287b\u28fb\u2895\u28d7\u28bf\u28bf\u28ff\u28d7\u28d7\u28bd\u289d\u28df\u28df\u28bf\u28bf\u28bf\u287f\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u2847\u2804\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 8);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                9 llllllllllllllllIIIIIIIIIlIlIlll;
                llllllllllllllllIIIIIIIIIlIlIlll.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllIIIIIIIIIlIlIlll.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2898\u28ff\u28ff\u28ff\u287f\u28f3\u28b3\u289d\u286e\u28f3\u289d\u28de\u28ae\u28af\u28fa\u286a\u28d7\u28bd\u28ea\u2873\u28dd\u28de\u28dd\u28ae\u28eb\u2873\u28d5\u28d7\u28bd\u2895\u28b7\u289d\u28de\u28ae\u28bf\u28ff\u28ff\u28ff\u28ff\u2807\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                9 llllllllllllllllIIIIIIIIIlIllIlI;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 9);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                10 llIllIllIIlIl;
                llIllIllIIlIl.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llIllIllIIlIl.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u28fb\u28ff\u28ff\u28fb\u286a\u286f\u28f3\u289d\u286e\u28f3\u2873\u28dd\u28de\u28bc\u286a\u28d7\u28dd\u28ae\u287a\u28d5\u28a7\u2873\u28dd\u28ae\u287a\u28d5\u28d7\u28bd\u289d\u287d\u28d5\u2897\u287d\u28f9\u28fb\u28ff\u28ff\u28ff\u2801\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                10 llIllIlllIIII;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 10);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                11 lIlIlIIlIIIlII;
            }

            @Override
            public void run() {
                11 lIlIlIIIllllll;
                lIlIlIIIllllll.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lIlIlIIIllllll.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2880\u28ae\u287b\u28ff\u28ff\u286a\u28de\u28dd\u28ae\u2873\u28dd\u28de\u28ae\u28ff\u28fe\u28d7\u28bd\u287a\u28ea\u2897\u287d\u28ea\u2897\u287d\u28ea\u2897\u28fd\u28fe\u28ff\u2875\u28eb\u289e\u28ae\u2873\u28dd\u285e\u28ee\u28fb\u28ff\u28ff\u2863\u2844\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 11);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                12 llllllllllllllllIIlllIllIlIIIIII;
            }

            @Override
            public void run() {
                12 llllllllllllllllIIlllIllIIlIlIIl;
                llllllllllllllllIIlllIllIIlIlIIl.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllIIlllIllIIlIlIIl.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u28b8\u2895\u286f\u28fa\u28b5\u289d\u286e\u286e\u28f3\u289d\u28de\u28bc\u28bd\u28ff\u28ff\u28ef\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u2873\u28fd\u28ff\u28ff\u28df\u28ae\u286b\u28d7\u28bd\u287a\u28fa\u286a\u28de\u28bd\u28b5\u289d\u2846\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 12);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                13 lllllllllllllllllIIIlIlIIIllIllI;
            }

            @Override
            public void run() {
                13 lllllllllllllllllIIIlIlIIIllIIII;
                lllllllllllllllllIIIlIlIIIllIIII.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllllIIIlIlIIIllIIII.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u28b1\u286b\u28de\u28b5\u28eb\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u286b\u286f\u28ff\u28ff\u2897\u287d\u28ea\u2897\u287d\u287a\u28d5\u28af\u2873\u28dd\u28ae\u287b\u28ff\u28ff\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u28af\u287a\u28d5\u2847\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 13);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                14 llllllllllllllllIllIlIIIlIIlIlII;
            }

            @Override
            public void run() {
                14 llllllllllllllllIllIlIIIlIIIllIl;
                llllllllllllllllIllIlIIIlIIIllIl.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllIllIlIIIlIIIllIl.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2838\u28f9\u286a\u28d7\u28a7\u287b\u28ea\u2897\u287d\u28ea\u2897\u287d\u28dd\u28ae\u287a\u28d5\u28af\u287a\u28d5\u28af\u286b\u28de\u28b5\u286b\u28de\u28b5\u286b\u28de\u28ae\u287a\u28d5\u28af\u287a\u28d5\u28af\u287a\u28d5\u28af\u2873\u28dd\u289e\u2806\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 14);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                15 lIlIIIIlIIIlllI;
            }

            @Override
            public void run() {
                15 lIlIIIIlIIIlIII;
                lIlIIIIlIIIlIII.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lIlIIIIlIIIlIII.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2818\u289a\u28ae\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u28f3\u28bd\u28fa\u28d7\u28ff\u28fa\u28d7\u28ef\u287a\u28d5\u28af\u287a\u28d5\u28af\u287a\u28d5\u28af\u287a\u28d5\u28af\u287a\u28d5\u28af\u283a\u2801\u2804\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 15);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                16 lIllIlIllIlIlll;
                lIllIlIllIlIlll.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lIllIlIllIlIlll.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28b1\u286b\u28de\u28b5\u28eb\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u2873\u28f3\u28fb\u287a\u28d7\u28af\u2897\u287d\u28ea\u2897\u287d\u28ea\u2897\u287d\u28ea\u2897\u28af\u287a\u28d5\u28af\u287a\u2855\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                16 lIllIlIllIllIll;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 16);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                17 llllllllllllllllIIIIlIllIIllIlII;
                llllllllllllllllIIIIlIllIIllIlII.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllIIIIlIllIIllIlII.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u285f\u28ee\u2873\u2873\u28dd\u28ae\u28af\u287a\u28d5\u28af\u287a\u28f5\u28ff\u28fe\u28f7\u28f7\u28ff\u28fe\u28ff\u28f7\u28ff\u28fe\u2873\u28dd\u28ae\u2873\u28dd\u28ae\u28af\u2873\u28dd\u28de\u28b5\u286b\u2802\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                17 llllllllllllllllIIIIlIllIIlllIlI;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 17);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                18 lllllllllllllllllIIllIlIlIIlIlll;
            }

            @Override
            public void run() {
                18 lllllllllllllllllIIllIlIlIIlIlII;
                lllllllllllllllllIIllIlIlIIlIlII.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllllllllllllllllIIllIlIlIIlIlII.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2818\u28de\u28ae\u287b\u28ea\u288f\u28d7\u28fd\u28ee\u28f7\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28f7\u28fd\u28f5\u28eb\u2873\u28dd\u289e\u28ae\u2873\u284d\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 18);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                19 llllllllllllllllIIllIIIllIlIlIII;
                llllllllllllllllIIllIIIllIlIlIII.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllIIllIIIllIlIlIII.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u28b1\u2873\u28dd\u28ae\u2873\u28ff\u28ff\u28ff\u287f\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28ff\u28bf\u28ff\u28ff\u28ff\u28af\u287a\u28dd\u28b5\u284b\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                19 llllllllllllllllIIllIIIllIlIlIll;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 19);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                20 llllllllllllllllllllIIlllIllllIl;
                llllllllllllllllllllIIlllIllllIl.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllllllIIlllIllllIl.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2839\u28ea\u2897\u28af\u286b\u28cf\u28d7\u28dd\u28bf\u28bf\u28df\u289f\u28df\u287f\u28df\u28bf\u28bf\u287b\u287d\u28fb\u28bf\u28df\u2897\u28d7\u28bd\u2895\u28b7\u289d\u286e\u2807\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                20 llllllllllllllllllllIIllllIIllII;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 20);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                21 llllllllllllllllIlllIIllIIIIlIII;
                llllllllllllllllIlllIIllIIIIlIII.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllIlllIIllIIIIlIII.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2818\u289d\u2875\u28eb\u289e\u28ae\u28ae\u28eb\u2873\u28d5\u28af\u28fa\u286a\u28d7\u28bd\u2895\u286f\u28eb\u289e\u2875\u2873\u28dd\u28ae\u286b\u28cf\u28b7\u289d\u280a\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                21 llllllllllllllllIlllIIllIIIlIIIl;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 21);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                22 llllllllllllllllllIllIIllllllIII;
                llllllllllllllllllIllIIllllllIII.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllllIllIIllllllIII.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2819\u28ae\u28eb\u28f3\u28b3\u2873\u28dd\u28ae\u28f3\u2863\u286f\u287a\u28dd\u28b5\u286b\u28de\u28b5\u286b\u286f\u28fa\u2895\u286f\u287a\u2815\u2801\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                22 llllllllllllllllllIllIlIIIIIllll;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 22);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){
            {
                23 llllllllllllllllllllIIIllllIIlIl;
            }

            @Override
            public void run() {
                23 llllllllllllllllllllIIIlllIlllll;
                llllllllllllllllllllIIIlllIlllll.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(llllllllllllllllllllIIIlllIlllll.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2818\u282a\u28f3\u289d\u286e\u28f3\u2863\u286f\u28eb\u28af\u287a\u28d5\u28af\u287a\u28d5\u28af\u286b\u28de\u2815\u2809\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 23);
        lllllllllllllllIllllllllIIIIllII._Timer.schedule(new TimerTask(){

            @Override
            public void run() {
                24 lllIlllIIIllIIl;
                lllIlllIIIllIIl.BrownCommand.this.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("/msg ").append(lllIlllIIIllIIl.BrownCommand.this.bruh).append(" \u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2801\u2819\u281a\u282e\u282f\u28ae\u2873\u28dd\u28ae\u2833\u283d\u282a\u2803\u2809\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804\u2804")));
            }
            {
                24 lllIlllIIlIlIII;
            }
        }, Integer.parseInt(lllllllllllllllIllllllllIIIIllIl[1]) * 1000 * 24);
        lllllllllllllllIllllllllIIIIllIl[0] = "";
        lllllllllllllllIllllllllIIIIllIl[1] = "";
    }

    public BrownCommand() {
        BrownCommand lllllllllllllllIllllllllIIIlIlIl;
        lllllllllllllllIllllllllIIIlIlIl.mc = Minecraft.getMinecraft();
        lllllllllllllllIllllllllIIIlIlIl._Timer = new Timer();
    }

    @Override
    public String[] getAlias() {
        return new String[]{"brown"};
    }

    @Override
    public String getSyntax() {
        return "brown <name> <delay in sec>";
    }
}

