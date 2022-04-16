/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.Sys
 */
package org.newdawn.slick.gui;

import org.lwjgl.Sys;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.GUIContext;

public class TextField
extends AbstractComponent {
    private /* synthetic */ int oldCursorPos;
    private /* synthetic */ int lastKey;
    private /* synthetic */ int maxCharacter;
    private /* synthetic */ boolean visibleCursor;
    private /* synthetic */ String value;
    private /* synthetic */ Color text;
    private /* synthetic */ int width;
    private /* synthetic */ long repeatTimer;
    private /* synthetic */ String oldText;
    private static final /* synthetic */ int INITIAL_KEY_REPEAT_INTERVAL;
    protected /* synthetic */ int y;
    private static final /* synthetic */ int KEY_REPEAT_INTERVAL;
    private /* synthetic */ int height;
    private /* synthetic */ Color border;
    private /* synthetic */ Font font;
    private /* synthetic */ boolean consume;
    protected /* synthetic */ int x;
    private /* synthetic */ char lastChar;
    private /* synthetic */ int cursorPos;
    private /* synthetic */ Color background;

    @Override
    public int getY() {
        TextField lllIllIIllllIII;
        return lllIllIIllllIII.y;
    }

    @Override
    public void setLocation(int lllIllIlIIIIIlI, int lllIllIIllllllI) {
        lllIllIlIIIIIII.x = lllIllIlIIIIIlI;
        lllIllIlIIIIIII.y = lllIllIIllllllI;
    }

    protected void recordOldPosition() {
        TextField lllIllIIIlIIIll;
        lllIllIIIlIIIll.oldText = lllIllIIIlIIIll.getText();
        lllIllIIIlIIIll.oldCursorPos = lllIllIIIlIIIll.cursorPos;
    }

    public void setMaxLength(int lllIllIIIllIIIl) {
        TextField lllIllIIIllIIII;
        lllIllIIIllIIII.maxCharacter = lllIllIIIllIIIl;
        if (lllIllIIIllIIII.value.length() > lllIllIIIllIIII.maxCharacter) {
            lllIllIIIllIIII.value = lllIllIIIllIIII.value.substring(0, lllIllIIIllIIII.maxCharacter);
        }
    }

    @Override
    public int getWidth() {
        TextField lllIllIIlllIlIl;
        return lllIllIIlllIlIl.width;
    }

    public String getText() {
        TextField lllIllIIlIIlIII;
        return lllIllIIlIIlIII.value;
    }

    protected void doUndo(int lllIllIIIIllIll, String lllIllIIIIlllIl) {
        if (lllIllIIIIlllIl != null) {
            TextField lllIllIIIIlllII;
            lllIllIIIIlllII.setText(lllIllIIIIlllIl);
            lllIllIIIIlllII.setCursorPos(lllIllIIIIllIll);
        }
    }

    public void setBorderColor(Color lllIllIIllIlIII) {
        lllIllIIllIIlll.border = lllIllIIllIlIII;
    }

    @Override
    public int getHeight() {
        TextField lllIllIIlllIIlI;
        return lllIllIIlllIIlI.height;
    }

    @Override
    public int getX() {
        TextField lllIllIIlllllII;
        return lllIllIIlllllII.x;
    }

    public void setBackgroundColor(Color lllIllIIllIllII) {
        lllIllIIllIllIl.background = lllIllIIllIllII;
    }

    public TextField(GUIContext lllIllIlIIlllII, Font lllIllIlIIllIll, int lllIllIlIIllIlI, int lllIllIlIIllIIl, int lllIllIlIIllIII, int lllIllIlIIlIlll) {
        super(lllIllIlIIlllII);
        TextField lllIllIlIIlllIl;
        lllIllIlIIlllIl.maxCharacter = 10000;
        lllIllIlIIlllIl.value = "";
        lllIllIlIIlllIl.border = Color.white;
        lllIllIlIIlllIl.text = Color.white;
        lllIllIlIIlllIl.background = new Color(0.0f, 0.0f, 0.0f, 0.5f);
        lllIllIlIIlllIl.visibleCursor = true;
        lllIllIlIIlllIl.lastKey = -1;
        lllIllIlIIlllIl.lastChar = '\u0000';
        lllIllIlIIlllIl.consume = true;
        lllIllIlIIlllIl.font = lllIllIlIIllIll;
        lllIllIlIIlllIl.setLocation(lllIllIlIIllIlI, lllIllIlIIllIIl);
        lllIllIlIIlllIl.width = lllIllIlIIllIII;
        lllIllIlIIlllIl.height = lllIllIlIIlIlll;
    }

    public void setCursorPos(int lllIllIIIllllIl) {
        TextField lllIllIIIlllllI;
        lllIllIIIlllllI.cursorPos = lllIllIIIllllIl;
        if (lllIllIIIlllllI.cursorPos > lllIllIIIlllllI.value.length()) {
            lllIllIIIlllllI.cursorPos = lllIllIIIlllllI.value.length();
        }
    }

    public void setConsumeEvents(boolean lllIllIlIIIllII) {
        lllIllIlIIIlIll.consume = lllIllIlIIIllII;
    }

    public TextField(GUIContext lllIllIlIlIlIll, Font lllIllIlIlIlIlI, int lllIllIlIllIIIl, int lllIllIlIllIIII, int lllIllIlIlIllll, int lllIllIlIlIIllI, ComponentListener lllIllIlIlIllIl) {
        lllIllIlIllIlII(lllIllIlIlIlIll, lllIllIlIlIlIlI, lllIllIlIllIIIl, lllIllIlIllIIII, lllIllIlIlIllll, lllIllIlIlIIllI);
        TextField lllIllIlIllIlII;
        lllIllIlIllIlII.addListener(lllIllIlIlIllIl);
    }

    public void deactivate() {
        TextField lllIllIlIIIIlll;
        lllIllIlIIIIlll.setFocus(false);
    }

    public void setCursorVisible(boolean lllIllIIIllIlIl) {
        lllIllIIIllIllI.visibleCursor = lllIllIIIllIlIl;
    }

    public void setTextColor(Color lllIllIIllIIIlI) {
        lllIllIIllIIIIl.text = lllIllIIllIIIlI;
    }

    @Override
    public void setFocus(boolean lllIllIIIIIlIII) {
        TextField lllIllIIIIIlIIl;
        lllIllIIIIIlIIl.lastKey = -1;
        super.setFocus(lllIllIIIIIlIII);
    }

    public void setText(String lllIllIIlIIIIIl) {
        TextField lllIllIIlIIIIlI;
        lllIllIIlIIIIlI.value = lllIllIIlIIIIIl;
        if (lllIllIIlIIIIlI.cursorPos > lllIllIIlIIIIIl.length()) {
            lllIllIIlIIIIlI.cursorPos = lllIllIIlIIIIIl.length();
        }
    }

    static {
        INITIAL_KEY_REPEAT_INTERVAL = 400;
        KEY_REPEAT_INTERVAL = 50;
    }

    protected void doPaste(String lllIllIIIlIlIIl) {
        TextField lllIllIIIlIlIlI;
        lllIllIIIlIlIlI.recordOldPosition();
        for (int lllIllIIIlIlIll = 0; lllIllIIIlIlIll < lllIllIIIlIlIIl.length(); ++lllIllIIIlIlIll) {
            lllIllIIIlIlIlI.keyPressed(-1, lllIllIIIlIlIIl.charAt(lllIllIIIlIlIll));
        }
    }

    @Override
    public void render(GUIContext lllIllIIlIlIlll, Graphics lllIllIIlIlIllI) {
        TextField lllIllIIlIlIIII;
        if (lllIllIIlIlIIII.lastKey != -1) {
            if (lllIllIIlIlIIII.input.isKeyDown(lllIllIIlIlIIII.lastKey)) {
                if (lllIllIIlIlIIII.repeatTimer < System.currentTimeMillis()) {
                    lllIllIIlIlIIII.repeatTimer = System.currentTimeMillis() + 50L;
                    lllIllIIlIlIIII.keyPressed(lllIllIIlIlIIII.lastKey, lllIllIIlIlIIII.lastChar);
                }
            } else {
                lllIllIIlIlIIII.lastKey = -1;
            }
        }
        Rectangle lllIllIIlIlIlIl = lllIllIIlIlIllI.getClip();
        lllIllIIlIlIllI.setWorldClip(lllIllIIlIlIIII.x, lllIllIIlIlIIII.y, lllIllIIlIlIIII.width, lllIllIIlIlIIII.height);
        Color lllIllIIlIlIlII = lllIllIIlIlIllI.getColor();
        if (lllIllIIlIlIIII.background != null) {
            lllIllIIlIlIllI.setColor(lllIllIIlIlIIII.background.multiply(lllIllIIlIlIlII));
            lllIllIIlIlIllI.fillRect(lllIllIIlIlIIII.x, lllIllIIlIlIIII.y, lllIllIIlIlIIII.width, lllIllIIlIlIIII.height);
        }
        lllIllIIlIlIllI.setColor(lllIllIIlIlIIII.text.multiply(lllIllIIlIlIlII));
        Font lllIllIIlIlIIll = lllIllIIlIlIllI.getFont();
        int lllIllIIlIlIIlI = lllIllIIlIlIIII.font.getWidth(lllIllIIlIlIIII.value.substring(0, lllIllIIlIlIIII.cursorPos));
        int lllIllIIlIlIIIl = 0;
        if (lllIllIIlIlIIlI > lllIllIIlIlIIII.width) {
            lllIllIIlIlIIIl = lllIllIIlIlIIII.width - lllIllIIlIlIIlI - lllIllIIlIlIIII.font.getWidth("_");
        }
        lllIllIIlIlIllI.translate(lllIllIIlIlIIIl + 2, 0.0f);
        lllIllIIlIlIllI.setFont(lllIllIIlIlIIII.font);
        lllIllIIlIlIllI.drawString(lllIllIIlIlIIII.value, lllIllIIlIlIIII.x + 1, lllIllIIlIlIIII.y + 1);
        if (lllIllIIlIlIIII.hasFocus() && lllIllIIlIlIIII.visibleCursor) {
            lllIllIIlIlIllI.drawString("_", lllIllIIlIlIIII.x + 1 + lllIllIIlIlIIlI + 2, lllIllIIlIlIIII.y + 1);
        }
        lllIllIIlIlIllI.translate(-lllIllIIlIlIIIl - 2, 0.0f);
        if (lllIllIIlIlIIII.border != null) {
            lllIllIIlIlIllI.setColor(lllIllIIlIlIIII.border.multiply(lllIllIIlIlIlII));
            lllIllIIlIlIllI.drawRect(lllIllIIlIlIIII.x, lllIllIIlIlIIII.y, lllIllIIlIlIIII.width, lllIllIIlIlIIII.height);
        }
        lllIllIIlIlIllI.setColor(lllIllIIlIlIlII);
        lllIllIIlIlIllI.setFont(lllIllIIlIlIIll);
        lllIllIIlIlIllI.clearWorldClip();
        lllIllIIlIlIllI.setClip(lllIllIIlIlIlIl);
    }

    @Override
    public void keyPressed(int lllIllIIIIlIIll, char lllIllIIIIIllll) {
        TextField lllIllIIIIlIlII;
        if (lllIllIIIIlIlII.hasFocus()) {
            if (lllIllIIIIlIIll != -1) {
                if (lllIllIIIIlIIll == 47 && (lllIllIIIIlIlII.input.isKeyDown(29) || lllIllIIIIlIlII.input.isKeyDown(157))) {
                    String lllIllIIIIlIlIl = Sys.getClipboard();
                    if (lllIllIIIIlIlIl != null) {
                        lllIllIIIIlIlII.doPaste(lllIllIIIIlIlIl);
                    }
                    return;
                }
                if (lllIllIIIIlIIll == 44 && (lllIllIIIIlIlII.input.isKeyDown(29) || lllIllIIIIlIlII.input.isKeyDown(157))) {
                    if (lllIllIIIIlIlII.oldText != null) {
                        lllIllIIIIlIlII.doUndo(lllIllIIIIlIlII.oldCursorPos, lllIllIIIIlIlII.oldText);
                    }
                    return;
                }
                if (lllIllIIIIlIlII.input.isKeyDown(29) || lllIllIIIIlIlII.input.isKeyDown(157)) {
                    return;
                }
                if (lllIllIIIIlIlII.input.isKeyDown(56) || lllIllIIIIlIlII.input.isKeyDown(184)) {
                    return;
                }
            }
            if (lllIllIIIIlIlII.lastKey != lllIllIIIIlIIll) {
                lllIllIIIIlIlII.lastKey = lllIllIIIIlIIll;
                lllIllIIIIlIlII.repeatTimer = System.currentTimeMillis() + 400L;
            } else {
                lllIllIIIIlIlII.repeatTimer = System.currentTimeMillis() + 50L;
            }
            lllIllIIIIlIlII.lastChar = lllIllIIIIIllll;
            if (lllIllIIIIlIIll == 203) {
                if (lllIllIIIIlIlII.cursorPos > 0) {
                    --lllIllIIIIlIlII.cursorPos;
                }
                if (lllIllIIIIlIlII.consume) {
                    lllIllIIIIlIlII.container.getInput().consumeEvent();
                }
            } else if (lllIllIIIIlIIll == 205) {
                if (lllIllIIIIlIlII.cursorPos < lllIllIIIIlIlII.value.length()) {
                    ++lllIllIIIIlIlII.cursorPos;
                }
                if (lllIllIIIIlIlII.consume) {
                    lllIllIIIIlIlII.container.getInput().consumeEvent();
                }
            } else if (lllIllIIIIlIIll == 14) {
                if (lllIllIIIIlIlII.cursorPos > 0 && lllIllIIIIlIlII.value.length() > 0) {
                    lllIllIIIIlIlII.value = lllIllIIIIlIlII.cursorPos < lllIllIIIIlIlII.value.length() ? String.valueOf(new StringBuilder().append(lllIllIIIIlIlII.value.substring(0, lllIllIIIIlIlII.cursorPos - 1)).append(lllIllIIIIlIlII.value.substring(lllIllIIIIlIlII.cursorPos))) : lllIllIIIIlIlII.value.substring(0, lllIllIIIIlIlII.cursorPos - 1);
                    --lllIllIIIIlIlII.cursorPos;
                }
                if (lllIllIIIIlIlII.consume) {
                    lllIllIIIIlIlII.container.getInput().consumeEvent();
                }
            } else if (lllIllIIIIlIIll == 211) {
                if (lllIllIIIIlIlII.value.length() > lllIllIIIIlIlII.cursorPos) {
                    lllIllIIIIlIlII.value = String.valueOf(new StringBuilder().append(lllIllIIIIlIlII.value.substring(0, lllIllIIIIlIlII.cursorPos)).append(lllIllIIIIlIlII.value.substring(lllIllIIIIlIlII.cursorPos + 1)));
                }
                if (lllIllIIIIlIlII.consume) {
                    lllIllIIIIlIlII.container.getInput().consumeEvent();
                }
            } else if (lllIllIIIIIllll < '\u007f' && lllIllIIIIIllll > '\u001f' && lllIllIIIIlIlII.value.length() < lllIllIIIIlIlII.maxCharacter) {
                lllIllIIIIlIlII.value = lllIllIIIIlIlII.cursorPos < lllIllIIIIlIlII.value.length() ? String.valueOf(new StringBuilder().append(lllIllIIIIlIlII.value.substring(0, lllIllIIIIlIlII.cursorPos)).append(lllIllIIIIIllll).append(lllIllIIIIlIlII.value.substring(lllIllIIIIlIlII.cursorPos))) : String.valueOf(new StringBuilder().append(lllIllIIIIlIlII.value.substring(0, lllIllIIIIlIlII.cursorPos)).append(lllIllIIIIIllll));
                ++lllIllIIIIlIlII.cursorPos;
                if (lllIllIIIIlIlII.consume) {
                    lllIllIIIIlIlII.container.getInput().consumeEvent();
                }
            } else if (lllIllIIIIlIIll == 28) {
                lllIllIIIIlIlII.notifyListeners();
                if (lllIllIIIIlIlII.consume) {
                    lllIllIIIIlIlII.container.getInput().consumeEvent();
                }
            }
        }
    }
}

