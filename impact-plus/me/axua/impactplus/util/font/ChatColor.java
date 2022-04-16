/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.util.font;

import java.util.regex.Pattern;

public final class ChatColor
extends Enum<ChatColor> {
    public static final /* synthetic */ /* enum */ ChatColor ITALIC;
    public static final /* synthetic */ /* enum */ ChatColor RESET;
    private final /* synthetic */ char code;
    private final /* synthetic */ String toString;
    public static final /* synthetic */ /* enum */ ChatColor BOLD;
    public static final /* synthetic */ /* enum */ ChatColor UNDERLINE;
    public static final /* synthetic */ /* enum */ ChatColor BLACK;
    public static final /* synthetic */ /* enum */ ChatColor LIGHT_PURPLE;
    public static final /* synthetic */ /* enum */ ChatColor YELLOW;
    public static final /* synthetic */ /* enum */ ChatColor BLUE;
    public static final /* synthetic */ /* enum */ ChatColor WHITE;
    public static final /* synthetic */ char COLOR_CHAR;
    public static final /* synthetic */ /* enum */ ChatColor DARK_PURPLE;
    public static final /* synthetic */ /* enum */ ChatColor GREEN;
    public static final /* synthetic */ /* enum */ ChatColor DARK_BLUE;
    public static final /* synthetic */ /* enum */ ChatColor DARK_GREEN;
    public static final /* synthetic */ /* enum */ ChatColor DARK_RED;
    public static final /* synthetic */ /* enum */ ChatColor DARK_GRAY;
    public static final /* synthetic */ /* enum */ ChatColor STRIKETHROUGH;
    public static final /* synthetic */ /* enum */ ChatColor MAGIC;
    public static final /* synthetic */ /* enum */ ChatColor AQUA;
    private final /* synthetic */ boolean isFormat;
    public static final /* synthetic */ /* enum */ ChatColor GOLD;
    public static final /* synthetic */ /* enum */ ChatColor GRAY;
    public static final /* synthetic */ /* enum */ ChatColor RED;
    public static final /* synthetic */ /* enum */ ChatColor DARK_AQUA;
    private static final /* synthetic */ ChatColor[] $VALUES;

    public static String translateAlternateColorCodes(char lllllllllllllllIlllllIlllIlllllI, String lllllllllllllllIlllllIlllIlllIIl) {
        char[] lllllllllllllllIlllllIlllIllllII = lllllllllllllllIlllllIlllIlllIIl.toCharArray();
        int lllllllllllllllIlllllIlllIlllIll = lllllllllllllllIlllllIlllIllllII.length - 1;
        for (int lllllllllllllllIlllllIlllIllllll = 0; lllllllllllllllIlllllIlllIllllll < lllllllllllllllIlllllIlllIlllIll; ++lllllllllllllllIlllllIlllIllllll) {
            if (lllllllllllllllIlllllIlllIllllII[lllllllllllllllIlllllIlllIllllll] != lllllllllllllllIlllllIlllIlllllI || "0123456789AaBbCcDdEeFfKkLlMmNnOoRr".indexOf(lllllllllllllllIlllllIlllIllllII[lllllllllllllllIlllllIlllIllllll + 1]) <= -1) continue;
            lllllllllllllllIlllllIlllIllllII[lllllllllllllllIlllllIlllIllllll] = 167;
            lllllllllllllllIlllllIlllIllllII[lllllllllllllllIlllllIlllIllllll + 1] = Character.toLowerCase(lllllllllllllllIlllllIlllIllllII[lllllllllllllllIlllllIlllIllllll + 1]);
        }
        return new String(lllllllllllllllIlllllIlllIllllII);
    }

    private ChatColor(char lllllllllllllllIlllllIllllIIlIIl, boolean lllllllllllllllIlllllIllllIIllIl) {
        ChatColor lllllllllllllllIlllllIllllIIllll;
        lllllllllllllllIlllllIllllIIllll.code = lllllllllllllllIlllllIllllIIlIIl;
        lllllllllllllllIlllllIllllIIllll.isFormat = lllllllllllllllIlllllIllllIIllIl;
        lllllllllllllllIlllllIllllIIllll.toString = new String(new char[]{'\u00a7', lllllllllllllllIlllllIllllIIlIIl});
    }

    public char getChar() {
        ChatColor lllllllllllllllIlllllIlllIllIIll;
        return lllllllllllllllIlllllIlllIllIIll.code;
    }

    public String toString() {
        ChatColor lllllllllllllllIlllllIlllIllIIII;
        return lllllllllllllllIlllllIlllIllIIII.toString;
    }

    public boolean isColor() {
        ChatColor lllllllllllllllIlllllIlllIlIlIll;
        return !lllllllllllllllIlllllIlllIlIlIll.isFormat && lllllllllllllllIlllllIlllIlIlIll != RESET;
    }

    static {
        COLOR_CHAR = (char)167;
        BLACK = new ChatColor('0');
        DARK_BLUE = new ChatColor('1');
        DARK_GREEN = new ChatColor('2');
        DARK_AQUA = new ChatColor('3');
        DARK_RED = new ChatColor('4');
        DARK_PURPLE = new ChatColor('5');
        GOLD = new ChatColor('6');
        GRAY = new ChatColor('7');
        DARK_GRAY = new ChatColor('8');
        BLUE = new ChatColor('9');
        GREEN = new ChatColor('a');
        AQUA = new ChatColor('b');
        RED = new ChatColor('c');
        LIGHT_PURPLE = new ChatColor('d');
        YELLOW = new ChatColor('e');
        WHITE = new ChatColor('f');
        MAGIC = new ChatColor('k', true);
        BOLD = new ChatColor('l', true);
        STRIKETHROUGH = new ChatColor('m', true);
        UNDERLINE = new ChatColor('n', true);
        ITALIC = new ChatColor('o', true);
        RESET = new ChatColor('r');
        $VALUES = new ChatColor[]{BLACK, DARK_BLUE, DARK_GREEN, DARK_AQUA, DARK_RED, DARK_PURPLE, GOLD, GRAY, DARK_GRAY, BLUE, GREEN, AQUA, RED, LIGHT_PURPLE, YELLOW, WHITE, MAGIC, BOLD, STRIKETHROUGH, UNDERLINE, ITALIC, RESET};
    }

    public static String stripColor(String lllllllllllllllIlllllIllllIIIllI) {
        return lllllllllllllllIlllllIllllIIIllI == null ? null : Pattern.compile("(?i)\u00a7[0-9A-FK-OR]").matcher(lllllllllllllllIlllllIllllIIIllI).replaceAll("");
    }

    public static ChatColor[] values() {
        return (ChatColor[])$VALUES.clone();
    }

    public static ChatColor valueOf(String lllllllllllllllIlllllIllllIlllll) {
        return Enum.valueOf(ChatColor.class, lllllllllllllllIlllllIllllIlllll);
    }

    private ChatColor(char lllllllllllllllIlllllIllllIlIlIl) {
        lllllllllllllllIlllllIllllIllIII(lllllllllllllllIlllllIllllIlIlIl, false);
        ChatColor lllllllllllllllIlllllIllllIllIII;
    }

    public boolean isFormat() {
        ChatColor lllllllllllllllIlllllIlllIlIlllI;
        return lllllllllllllllIlllllIlllIlIlllI.isFormat;
    }
}

