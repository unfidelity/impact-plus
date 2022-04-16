/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.input.Controller
 *  org.lwjgl.input.Controllers
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.Display
 */
package org.newdawn.slick;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.ControlledInputReciever;
import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

public class Input {
    public static final /* synthetic */ int KEY_APPS;
    public static final /* synthetic */ int KEY_F14;
    protected /* synthetic */ HashSet allListeners;
    public static final /* synthetic */ int KEY_F11;
    public static final /* synthetic */ int KEY_I;
    public static final /* synthetic */ int KEY_DOWN;
    public static final /* synthetic */ int KEY_HOME;
    public static final /* synthetic */ int KEY_NUMPAD5;
    public static final /* synthetic */ int KEY_SUBTRACT;
    private static final /* synthetic */ int BUTTON10;
    public static final /* synthetic */ int KEY_NUMPAD4;
    public static final /* synthetic */ int KEY_B;
    private /* synthetic */ float scaleY;
    public static final /* synthetic */ int KEY_RBRACKET;
    public static final /* synthetic */ int KEY_KANJI;
    private /* synthetic */ boolean[][] controls;
    public static final /* synthetic */ int KEY_F4;
    public static final /* synthetic */ int KEY_F12;
    public static final /* synthetic */ int KEY_SYSRQ;
    public static final /* synthetic */ int KEY_KANA;
    public static final /* synthetic */ int KEY_F10;
    public static final /* synthetic */ int KEY_BACK;
    public static final /* synthetic */ int KEY_F8;
    public static final /* synthetic */ int KEY_J;
    public static final /* synthetic */ int KEY_BACKSLASH;
    private static final /* synthetic */ int BUTTON6;
    public static final /* synthetic */ int KEY_UP;
    public static final /* synthetic */ int KEY_2;
    private /* synthetic */ int lastMouseY;
    public static final /* synthetic */ int KEY_T;
    public static final /* synthetic */ int KEY_F;
    public static final /* synthetic */ int KEY_NUMPAD8;
    public static final /* synthetic */ int KEY_RETURN;
    public static final /* synthetic */ int KEY_MULTIPLY;
    public static final /* synthetic */ int KEY_DELETE;
    public static final /* synthetic */ int KEY_N;
    private /* synthetic */ int mouseClickTolerance;
    public static final /* synthetic */ int KEY_SLEEP;
    public static final /* synthetic */ int KEY_NUMPAD3;
    private /* synthetic */ int clickX;
    public static final /* synthetic */ int KEY_RIGHT;
    private /* synthetic */ boolean[][] controllerPressed;
    public static final /* synthetic */ int KEY_YEN;
    public static final /* synthetic */ int KEY_LBRACKET;
    public static final /* synthetic */ int MOUSE_RIGHT_BUTTON;
    public static final /* synthetic */ int KEY_SCROLL;
    public static final /* synthetic */ int KEY_9;
    private /* synthetic */ int clickY;
    public static final /* synthetic */ int KEY_DECIMAL;
    private /* synthetic */ boolean keyRepeat;
    public static final /* synthetic */ int KEY_LCONTROL;
    private static final /* synthetic */ int BUTTON8;
    public static final /* synthetic */ int KEY_NUMPAD1;
    public static final /* synthetic */ int KEY_3;
    public static final /* synthetic */ int KEY_F5;
    public static final /* synthetic */ int KEY_POWER;
    protected /* synthetic */ ArrayList keyListenersToAdd;
    public static final /* synthetic */ int KEY_AT;
    private static final /* synthetic */ int BUTTON2;
    public static final /* synthetic */ int KEY_U;
    protected /* synthetic */ ArrayList mouseListeners;
    private static final /* synthetic */ int BUTTON4;
    public static final /* synthetic */ int KEY_O;
    public static final /* synthetic */ int KEY_NUMPAD7;
    public static final /* synthetic */ int KEY_M;
    private /* synthetic */ int keyRepeatInterval;
    public static final /* synthetic */ int KEY_W;
    public static final /* synthetic */ int KEY_LWIN;
    public static final /* synthetic */ int KEY_NUMLOCK;
    public static final /* synthetic */ int KEY_Z;
    public static final /* synthetic */ int KEY_LMENU;
    protected /* synthetic */ ArrayList mouseListenersToAdd;
    private /* synthetic */ int doubleClickDelay;
    public static final /* synthetic */ int KEY_NOCONVERT;
    private /* synthetic */ int height;
    public static final /* synthetic */ int KEY_L;
    public static final /* synthetic */ int KEY_V;
    protected /* synthetic */ ArrayList controllerListeners;
    public static final /* synthetic */ int KEY_4;
    private /* synthetic */ int pressedX;
    private static /* synthetic */ boolean controllersInited;
    protected /* synthetic */ long[] nextRepeat;
    public static final /* synthetic */ int KEY_INSERT;
    public static final /* synthetic */ int KEY_7;
    public static final /* synthetic */ int KEY_NUMPAD9;
    public static final /* synthetic */ int KEY_UNLABELED;
    public static final /* synthetic */ int KEY_X;
    public static final /* synthetic */ int KEY_PAUSE;
    public static final /* synthetic */ int KEY_Q;
    private /* synthetic */ int lastMouseX;
    public static final /* synthetic */ int KEY_RMENU;
    private /* synthetic */ float yoffset;
    public static final /* synthetic */ int KEY_NUMPADEQUALS;
    public static final /* synthetic */ int KEY_K;
    public static final /* synthetic */ int KEY_SEMICOLON;
    public static final /* synthetic */ int KEY_COLON;
    private static final /* synthetic */ int BUTTON5;
    public static final /* synthetic */ int KEY_LALT;
    public static final /* synthetic */ int KEY_5;
    private /* synthetic */ int wheel;
    private static /* synthetic */ ArrayList controllers;
    public static final /* synthetic */ int KEY_C;
    public static final /* synthetic */ int KEY_E;
    public static final /* synthetic */ int KEY_PRIOR;
    private static final /* synthetic */ int UP;
    public static final /* synthetic */ int KEY_RCONTROL;
    public static final /* synthetic */ int KEY_SPACE;
    public static final /* synthetic */ int KEY_F9;
    private static final /* synthetic */ int BUTTON7;
    public static final /* synthetic */ int KEY_STOP;
    public static final /* synthetic */ int KEY_MINUS;
    public static final /* synthetic */ int KEY_ADD;
    public static final /* synthetic */ int KEY_F7;
    public static final /* synthetic */ int KEY_H;
    public static final /* synthetic */ int KEY_CIRCUMFLEX;
    public static final /* synthetic */ int KEY_8;
    private /* synthetic */ float xoffset;
    protected /* synthetic */ ArrayList keyListeners;
    public static final /* synthetic */ int KEY_F3;
    public static final /* synthetic */ int MOUSE_LEFT_BUTTON;
    public static final /* synthetic */ int KEY_CONVERT;
    private /* synthetic */ int pressedY;
    public static final /* synthetic */ int KEY_ENTER;
    private /* synthetic */ boolean paused;
    private static final /* synthetic */ int DOWN;
    public static final /* synthetic */ int KEY_AX;
    public static final /* synthetic */ int KEY_CAPITAL;
    public static final /* synthetic */ int KEY_NEXT;
    private /* synthetic */ float scaleX;
    private static final /* synthetic */ int LEFT;
    public static final /* synthetic */ int KEY_UNDERLINE;
    protected /* synthetic */ boolean[] mousePressed;
    public static final /* synthetic */ int KEY_APOSTROPHE;
    public static final /* synthetic */ int KEY_A;
    public static final /* synthetic */ int KEY_RSHIFT;
    public static final /* synthetic */ int KEY_F1;
    private /* synthetic */ int keyRepeatInitial;
    public static final /* synthetic */ int KEY_NUMPADENTER;
    private static final /* synthetic */ int BUTTON9;
    private /* synthetic */ long doubleClickTimeout;
    public static final /* synthetic */ int KEY_NUMPAD6;
    public static final /* synthetic */ int KEY_COMMA;
    public static final /* synthetic */ int KEY_RALT;
    private /* synthetic */ int clickButton;
    public static final /* synthetic */ int KEY_END;
    public static final /* synthetic */ int KEY_1;
    public static final /* synthetic */ int KEY_LSHIFT;
    public static final /* synthetic */ int KEY_LEFT;
    public static final /* synthetic */ int KEY_RWIN;
    public static final /* synthetic */ int KEY_F13;
    public static final /* synthetic */ int KEY_GRAVE;
    public static final /* synthetic */ int KEY_NUMPAD0;
    public static final /* synthetic */ int KEY_DIVIDE;
    public static final /* synthetic */ int KEY_G;
    public static final /* synthetic */ int KEY_ESCAPE;
    public static final /* synthetic */ int ANY_CONTROLLER;
    public static final /* synthetic */ int KEY_EQUALS;
    private static final /* synthetic */ int BUTTON3;
    public static final /* synthetic */ int KEY_F2;
    public static final /* synthetic */ int KEY_SLASH;
    private /* synthetic */ boolean displayActive;
    public static final /* synthetic */ int KEY_NUMPADCOMMA;
    private static final /* synthetic */ int RIGHT;
    protected /* synthetic */ boolean[] pressed;
    public static final /* synthetic */ int MOUSE_MIDDLE_BUTTON;
    public static final /* synthetic */ int KEY_PERIOD;
    public static final /* synthetic */ int KEY_Y;
    private static final /* synthetic */ int BUTTON1;
    public static final /* synthetic */ int KEY_0;
    public static final /* synthetic */ int KEY_6;
    private static final /* synthetic */ int MAX_BUTTONS;
    public static final /* synthetic */ int KEY_F6;
    protected /* synthetic */ char[] keys;
    public static final /* synthetic */ int KEY_NUMPAD2;
    public static final /* synthetic */ int KEY_S;
    protected /* synthetic */ boolean consumed;
    public static final /* synthetic */ int KEY_D;
    public static final /* synthetic */ int KEY_R;
    public static final /* synthetic */ int KEY_TAB;
    public static final /* synthetic */ int KEY_P;
    public static final /* synthetic */ int KEY_F15;

    public void initControllers() throws SlickException {
        if (controllersInited) {
            return;
        }
        controllersInited = true;
        try {
            Controllers.create();
            int lllllllllllllllllIIlIIllIlllIlIl = Controllers.getControllerCount();
            for (int lllllllllllllllllIIlIIllIlllIlll = 0; lllllllllllllllllIIlIIllIlllIlll < lllllllllllllllllIIlIIllIlllIlIl; ++lllllllllllllllllIIlIIllIlllIlll) {
                Controller lllllllllllllllllIIlIIllIllllIII = Controllers.getController((int)lllllllllllllllllIIlIIllIlllIlll);
                if (lllllllllllllllllIIlIIllIllllIII.getButtonCount() < 3 || lllllllllllllllllIIlIIllIllllIII.getButtonCount() >= 100) continue;
                controllers.add(lllllllllllllllllIIlIIllIllllIII);
            }
            Log.info(String.valueOf(new StringBuilder().append("Found ").append(controllers.size()).append(" controllers")));
            for (int lllllllllllllllllIIlIIllIlllIllI = 0; lllllllllllllllllIIlIIllIlllIllI < controllers.size(); ++lllllllllllllllllIIlIIllIlllIllI) {
                Log.info(String.valueOf(new StringBuilder().append(lllllllllllllllllIIlIIllIlllIllI).append(" : ").append(((Controller)controllers.get(lllllllllllllllllIIlIIllIlllIllI)).getName())));
            }
        }
        catch (LWJGLException lllllllllllllllllIIlIIllIlllIlII) {
            if (lllllllllllllllllIIlIIllIlllIlII.getCause() instanceof ClassNotFoundException) {
                throw new SlickException("Unable to create controller - no jinput found - add jinput.jar to your classpath");
            }
            throw new SlickException("Unable to create controllers");
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            // empty catch block
        }
    }

    private void fireControlPress(int lllllllllllllllllIIlIIllIIIllIlI, int lllllllllllllllllIIlIIllIIIllIIl) {
        Input lllllllllllllllllIIlIIllIIIllIII;
        lllllllllllllllllIIlIIllIIIllIII.consumed = false;
        for (int lllllllllllllllllIIlIIllIIIlllII = 0; lllllllllllllllllIIlIIllIIIlllII < lllllllllllllllllIIlIIllIIIllIII.controllerListeners.size(); ++lllllllllllllllllIIlIIllIIIlllII) {
            ControllerListener lllllllllllllllllIIlIIllIIIlllIl = (ControllerListener)lllllllllllllllllIIlIIllIIIllIII.controllerListeners.get(lllllllllllllllllIIlIIllIIIlllII);
            if (!lllllllllllllllllIIlIIllIIIlllIl.isAcceptingInput()) continue;
            switch (lllllllllllllllllIIlIIllIIIllIlI) {
                case 0: {
                    lllllllllllllllllIIlIIllIIIlllIl.controllerLeftPressed(lllllllllllllllllIIlIIllIIIllIIl);
                    break;
                }
                case 1: {
                    lllllllllllllllllIIlIIllIIIlllIl.controllerRightPressed(lllllllllllllllllIIlIIllIIIllIIl);
                    break;
                }
                case 2: {
                    lllllllllllllllllIIlIIllIIIlllIl.controllerUpPressed(lllllllllllllllllIIlIIllIIIllIIl);
                    break;
                }
                case 3: {
                    lllllllllllllllllIIlIIllIIIlllIl.controllerDownPressed(lllllllllllllllllIIlIIllIIIllIIl);
                    break;
                }
                default: {
                    lllllllllllllllllIIlIIllIIIlllIl.controllerButtonPressed(lllllllllllllllllIIlIIllIIIllIIl, lllllllllllllllllIIlIIllIIIllIlI - 4 + 1);
                }
            }
            if (lllllllllllllllllIIlIIllIIIllIII.consumed) break;
        }
    }

    public void removeAllKeyListeners() {
        Input lllllllllllllllllIIlIlIIIlIIIIII;
        lllllllllllllllllIIlIlIIIlIIIIII.allListeners.removeAll(lllllllllllllllllIIlIlIIIlIIIIII.keyListeners);
        lllllllllllllllllIIlIlIIIlIIIIII.keyListeners.clear();
    }

    public void setDoubleClickInterval(int lllllllllllllllllIIlIlIIlIlllIIl) {
        lllllllllllllllllIIlIlIIlIlllIlI.doubleClickDelay = lllllllllllllllllIIlIlIIlIlllIIl;
    }

    public void removeAllControllerListeners() {
        Input lllllllllllllllllIIlIlIIIIlllIll;
        lllllllllllllllllIIlIlIIIIlllIll.allListeners.removeAll(lllllllllllllllllIIlIlIIIIlllIll.controllerListeners);
        lllllllllllllllllIIlIlIIIIlllIll.controllerListeners.clear();
    }

    public String getAxisName(int lllllllllllllllllIIlIIllllIIIIIl, int lllllllllllllllllIIlIIlllIlllllI) {
        return ((Controller)controllers.get(lllllllllllllllllIIlIIllllIIIIIl)).getAxisName(lllllllllllllllllIIlIIlllIlllllI);
    }

    public void removeAllMouseListeners() {
        Input lllllllllllllllllIIlIlIIIIlllllI;
        lllllllllllllllllIIlIlIIIIlllllI.allListeners.removeAll(lllllllllllllllllIIlIlIIIIlllllI.mouseListeners);
        lllllllllllllllllIIlIlIIIIlllllI.mouseListeners.clear();
    }

    public boolean isControllerUp(int lllllllllllllllllIIlIIlllIlIIllI) {
        Input lllllllllllllllllIIlIIlllIlIIlll;
        if (lllllllllllllllllIIlIIlllIlIIllI >= lllllllllllllllllIIlIIlllIlIIlll.getControllerCount()) {
            return false;
        }
        if (lllllllllllllllllIIlIIlllIlIIllI == -1) {
            for (int lllllllllllllllllIIlIIlllIlIlIII = 0; lllllllllllllllllIIlIIlllIlIlIII < controllers.size(); ++lllllllllllllllllIIlIIlllIlIlIII) {
                if (!lllllllllllllllllIIlIIlllIlIIlll.isControllerUp(lllllllllllllllllIIlIIlllIlIlIII)) continue;
                return true;
            }
            return false;
        }
        return ((Controller)controllers.get(lllllllllllllllllIIlIIlllIlIIllI)).getYAxisValue() < -0.5f || ((Controller)controllers.get(lllllllllllllllllIIlIIlllIlIIllI)).getPovY() < -0.5f;
    }

    public void setMouseClickTolerance(int lllllllllllllllllIIlIlIIlIllIIll) {
        lllllllllllllllllIIlIlIIlIllIlII.mouseClickTolerance = lllllllllllllllllIIlIlIIlIllIIll;
    }

    private void addMouseListenerImpl(MouseListener lllllllllllllllllIIlIlIIIlIlIIlI) {
        Input lllllllllllllllllIIlIlIIIlIlIIII;
        if (lllllllllllllllllIIlIlIIIlIlIIII.mouseListeners.contains(lllllllllllllllllIIlIlIIIlIlIIlI)) {
            return;
        }
        lllllllllllllllllIIlIlIIIlIlIIII.mouseListeners.add(lllllllllllllllllIIlIlIIIlIlIIlI);
        lllllllllllllllllIIlIlIIIlIlIIII.allListeners.add(lllllllllllllllllIIlIlIIIlIlIIlI);
    }

    public int getMouseY() {
        Input lllllllllllllllllIIlIIllllIlllll;
        return (int)((float)lllllllllllllllllIIlIIllllIlllll.getAbsoluteMouseY() * lllllllllllllllllIIlIIllllIlllll.scaleY + lllllllllllllllllIIlIIllllIlllll.yoffset);
    }

    public void setOffset(float lllllllllllllllllIIlIlIIlIlIIlIl, float lllllllllllllllllIIlIlIIlIlIIIIl) {
        lllllllllllllllllIIlIlIIlIlIIIll.xoffset = lllllllllllllllllIIlIlIIlIlIIlIl;
        lllllllllllllllllIIlIlIIlIlIIIll.yoffset = lllllllllllllllllIIlIlIIlIlIIIIl;
    }

    public int getControllerCount() {
        try {
            Input lllllllllllllllllIIlIIllllIlIIIl;
            lllllllllllllllllIIlIIllllIlIIIl.initControllers();
        }
        catch (SlickException lllllllllllllllllIIlIIllllIlIIll) {
            throw new RuntimeException("Failed to initialise controllers");
        }
        return controllers.size();
    }

    public void removeMouseListener(MouseListener lllllllllllllllllIIlIlIIIIIllllI) {
        Input lllllllllllllllllIIlIlIIIIIlllIl;
        lllllllllllllllllIIlIlIIIIIlllIl.mouseListeners.remove(lllllllllllllllllIIlIlIIIIIllllI);
        lllllllllllllllllIIlIlIIIIIlllIl.mouseListenersToAdd.remove(lllllllllllllllllIIlIlIIIIIllllI);
        if (!lllllllllllllllllIIlIlIIIIIlllIl.controllerListeners.contains(lllllllllllllllllIIlIlIIIIIllllI) && !lllllllllllllllllIIlIlIIIIIlllIl.keyListeners.contains(lllllllllllllllllIIlIlIIIIIllllI)) {
            lllllllllllllllllIIlIlIIIIIlllIl.allListeners.remove(lllllllllllllllllIIlIlIIIIIllllI);
        }
    }

    public static void disableControllers() {
        controllersInited = true;
    }

    public void clearControlPressedRecord() {
        for (int lllllllllllllllllIIlIIllllllIlIl = 0; lllllllllllllllllIIlIIllllllIlIl < controllers.size(); ++lllllllllllllllllIIlIIllllllIlIl) {
            Input lllllllllllllllllIIlIIllllllIlII;
            Arrays.fill(lllllllllllllllllIIlIIllllllIlII.controllerPressed[lllllllllllllllllIIlIIllllllIlIl], false);
        }
    }

    public void considerDoubleClick(int lllllllllllllllllIIlIIllIlIlllll, int lllllllllllllllllIIlIIllIlIllIlI, int lllllllllllllllllIIlIIllIlIllIIl) {
        Input lllllllllllllllllIIlIIllIlIlllII;
        if (lllllllllllllllllIIlIIllIlIlllII.doubleClickTimeout == 0L) {
            lllllllllllllllllIIlIIllIlIlllII.clickX = lllllllllllllllllIIlIIllIlIllIlI;
            lllllllllllllllllIIlIIllIlIlllII.clickY = lllllllllllllllllIIlIIllIlIllIIl;
            lllllllllllllllllIIlIIllIlIlllII.clickButton = lllllllllllllllllIIlIIllIlIlllll;
            lllllllllllllllllIIlIIllIlIlllII.doubleClickTimeout = System.currentTimeMillis() + (long)lllllllllllllllllIIlIIllIlIlllII.doubleClickDelay;
            lllllllllllllllllIIlIIllIlIlllII.fireMouseClicked(lllllllllllllllllIIlIIllIlIlllll, lllllllllllllllllIIlIIllIlIllIlI, lllllllllllllllllIIlIIllIlIllIIl, 1);
        } else if (lllllllllllllllllIIlIIllIlIlllII.clickButton == lllllllllllllllllIIlIIllIlIlllll && System.currentTimeMillis() < lllllllllllllllllIIlIIllIlIlllII.doubleClickTimeout) {
            lllllllllllllllllIIlIIllIlIlllII.fireMouseClicked(lllllllllllllllllIIlIIllIlIlllll, lllllllllllllllllIIlIIllIlIllIlI, lllllllllllllllllIIlIIllIlIllIIl, 2);
            lllllllllllllllllIIlIIllIlIlllII.doubleClickTimeout = 0L;
        }
    }

    public void consumeEvent() {
        lllllllllllllllllIIlIIllIllIllIl.consumed = true;
    }

    public boolean isMousePressed(int lllllllllllllllllIIlIlIIIIIIlIIl) {
        Input lllllllllllllllllIIlIlIIIIIIlIlI;
        if (lllllllllllllllllIIlIlIIIIIIlIlI.mousePressed[lllllllllllllllllIIlIlIIIIIIlIIl]) {
            lllllllllllllllllIIlIlIIIIIIlIlI.mousePressed[lllllllllllllllllIIlIlIIIIIIlIIl] = false;
            return true;
        }
        return false;
    }

    public void resetInputTransform() {
        Input lllllllllllllllllIIlIlIIlIIlllll;
        lllllllllllllllllIIlIlIIlIIlllll.setOffset(0.0f, 0.0f);
        lllllllllllllllllIIlIlIIlIIlllll.setScale(1.0f, 1.0f);
    }

    public boolean isButton3Pressed(int lllllllllllllllllIIlIIllIllllllI) {
        Input lllllllllllllllllIIlIIllIlllllll;
        return lllllllllllllllllIIlIIllIlllllll.isButtonPressed(2, lllllllllllllllllIIlIIllIllllllI);
    }

    public void removeAllListeners() {
        Input lllllllllllllllllIIlIlIIIlIIIIll;
        lllllllllllllllllIIlIlIIIlIIIIll.removeAllKeyListeners();
        lllllllllllllllllIIlIlIIIlIIIIll.removeAllMouseListeners();
        lllllllllllllllllIIlIlIIIlIIIIll.removeAllControllerListeners();
    }

    private void fireControlRelease(int lllllllllllllllllIIlIIllIIIIlIII, int lllllllllllllllllIIlIIllIIIIIlll) {
        Input lllllllllllllllllIIlIIllIIIIlIIl;
        lllllllllllllllllIIlIIllIIIIlIIl.consumed = false;
        for (int lllllllllllllllllIIlIIllIIIIllIl = 0; lllllllllllllllllIIlIIllIIIIllIl < lllllllllllllllllIIlIIllIIIIlIIl.controllerListeners.size(); ++lllllllllllllllllIIlIIllIIIIllIl) {
            ControllerListener lllllllllllllllllIIlIIllIIIIlllI = (ControllerListener)lllllllllllllllllIIlIIllIIIIlIIl.controllerListeners.get(lllllllllllllllllIIlIIllIIIIllIl);
            if (!lllllllllllllllllIIlIIllIIIIlllI.isAcceptingInput()) continue;
            switch (lllllllllllllllllIIlIIllIIIIlIII) {
                case 0: {
                    lllllllllllllllllIIlIIllIIIIlllI.controllerLeftReleased(lllllllllllllllllIIlIIllIIIIIlll);
                    break;
                }
                case 1: {
                    lllllllllllllllllIIlIIllIIIIlllI.controllerRightReleased(lllllllllllllllllIIlIIllIIIIIlll);
                    break;
                }
                case 2: {
                    lllllllllllllllllIIlIIllIIIIlllI.controllerUpReleased(lllllllllllllllllIIlIIllIIIIIlll);
                    break;
                }
                case 3: {
                    lllllllllllllllllIIlIIllIIIIlllI.controllerDownReleased(lllllllllllllllllIIlIIllIIIIIlll);
                    break;
                }
                default: {
                    lllllllllllllllllIIlIIllIIIIlllI.controllerButtonReleased(lllllllllllllllllIIlIIllIIIIIlll, lllllllllllllllllIIlIIllIIIIlIII - 4 + 1);
                }
            }
            if (lllllllllllllllllIIlIIllIIIIlIIl.consumed) break;
        }
    }

    public boolean isButtonPressed(int lllllllllllllllllIIlIIlllIIlIIll, int lllllllllllllllllIIlIIlllIIIllll) {
        Input lllllllllllllllllIIlIIlllIIlIlII;
        if (lllllllllllllllllIIlIIlllIIIllll >= lllllllllllllllllIIlIIlllIIlIlII.getControllerCount()) {
            return false;
        }
        if (lllllllllllllllllIIlIIlllIIIllll == -1) {
            for (int lllllllllllllllllIIlIIlllIIlIlIl = 0; lllllllllllllllllIIlIIlllIIlIlIl < controllers.size(); ++lllllllllllllllllIIlIIlllIIlIlIl) {
                if (!lllllllllllllllllIIlIIlllIIlIlII.isButtonPressed(lllllllllllllllllIIlIIlllIIlIIll, lllllllllllllllllIIlIIlllIIlIlIl)) continue;
                return true;
            }
            return false;
        }
        return ((Controller)controllers.get(lllllllllllllllllIIlIIlllIIIllll)).isButtonPressed(lllllllllllllllllIIlIIlllIIlIIll);
    }

    public int getAxisCount(int lllllllllllllllllIIlIIllllIIllII) {
        return ((Controller)controllers.get(lllllllllllllllllIIlIIllllIIllII)).getAxisCount();
    }

    public void resume() {
        lllllllllllllllllIIlIIlIllllIlll.paused = false;
    }

    public boolean isControllerLeft(int lllllllllllllllllIIlIIlllIlllIII) {
        Input lllllllllllllllllIIlIIlllIllIlll;
        if (lllllllllllllllllIIlIIlllIlllIII >= lllllllllllllllllIIlIIlllIllIlll.getControllerCount()) {
            return false;
        }
        if (lllllllllllllllllIIlIIlllIlllIII == -1) {
            for (int lllllllllllllllllIIlIIlllIlllIlI = 0; lllllllllllllllllIIlIIlllIlllIlI < controllers.size(); ++lllllllllllllllllIIlIIlllIlllIlI) {
                if (!lllllllllllllllllIIlIIlllIllIlll.isControllerLeft(lllllllllllllllllIIlIIlllIlllIlI)) continue;
                return true;
            }
            return false;
        }
        return ((Controller)controllers.get(lllllllllllllllllIIlIIlllIlllIII)).getXAxisValue() < -0.5f || ((Controller)controllers.get(lllllllllllllllllIIlIIlllIlllIII)).getPovX() < -0.5f;
    }

    public void removeKeyListener(KeyListener lllllllllllllllllIIlIlIIIIlIlIlI) {
        Input lllllllllllllllllIIlIlIIIIlIlIIl;
        lllllllllllllllllIIlIlIIIIlIlIIl.keyListeners.remove(lllllllllllllllllIIlIlIIIIlIlIlI);
        lllllllllllllllllIIlIlIIIIlIlIIl.keyListenersToAdd.remove(lllllllllllllllllIIlIlIIIIlIlIlI);
        if (!lllllllllllllllllIIlIlIIIIlIlIIl.mouseListeners.contains(lllllllllllllllllIIlIlIIIIlIlIlI) && !lllllllllllllllllIIlIlIIIIlIlIIl.controllerListeners.contains(lllllllllllllllllIIlIlIIIIlIlIlI)) {
            lllllllllllllllllIIlIlIIIIlIlIIl.allListeners.remove(lllllllllllllllllIIlIlIIIIlIlIlI);
        }
    }

    public boolean isKeyPressed(int lllllllllllllllllIIlIlIIIIIIllIl) {
        Input lllllllllllllllllIIlIlIIIIIlIIII;
        if (lllllllllllllllllIIlIlIIIIIlIIII.pressed[lllllllllllllllllIIlIlIIIIIIllIl]) {
            lllllllllllllllllIIlIlIIIIIlIIII.pressed[lllllllllllllllllIIlIlIIIIIIllIl] = false;
            return true;
        }
        return false;
    }

    public float getAxisValue(int lllllllllllllllllIIlIIllllIIlIII, int lllllllllllllllllIIlIIllllIIIlll) {
        return ((Controller)controllers.get(lllllllllllllllllIIlIIllllIIlIII)).getAxisValue(lllllllllllllllllIIlIIllllIIIlll);
    }

    public boolean isControllerDown(int lllllllllllllllllIIlIIlllIIlllIl) {
        Input lllllllllllllllllIIlIIlllIIllllI;
        if (lllllllllllllllllIIlIIlllIIlllIl >= lllllllllllllllllIIlIIlllIIllllI.getControllerCount()) {
            return false;
        }
        if (lllllllllllllllllIIlIIlllIIlllIl == -1) {
            for (int lllllllllllllllllIIlIIlllIIlllll = 0; lllllllllllllllllIIlIIlllIIlllll < controllers.size(); ++lllllllllllllllllIIlIIlllIIlllll) {
                if (!lllllllllllllllllIIlIIlllIIllllI.isControllerDown(lllllllllllllllllIIlIIlllIIlllll)) continue;
                return true;
            }
            return false;
        }
        return ((Controller)controllers.get(lllllllllllllllllIIlIIlllIIlllIl)).getYAxisValue() > 0.5f || ((Controller)controllers.get(lllllllllllllllllIIlIIlllIIlllIl)).getPovY() > 0.5f;
    }

    private boolean isControlDwn(int lllllllllllllllllIIlIIllIIIIIIII, int lllllllllllllllllIIlIIlIllllllII) {
        Input lllllllllllllllllIIlIIllIIIIIIIl;
        switch (lllllllllllllllllIIlIIllIIIIIIII) {
            case 0: {
                return lllllllllllllllllIIlIIllIIIIIIIl.isControllerLeft(lllllllllllllllllIIlIIlIllllllII);
            }
            case 1: {
                return lllllllllllllllllIIlIIllIIIIIIIl.isControllerRight(lllllllllllllllllIIlIIlIllllllII);
            }
            case 2: {
                return lllllllllllllllllIIlIIllIIIIIIIl.isControllerUp(lllllllllllllllllIIlIIlIllllllII);
            }
            case 3: {
                return lllllllllllllllllIIlIIllIIIIIIIl.isControllerDown(lllllllllllllllllIIlIIlIllllllII);
            }
        }
        if (lllllllllllllllllIIlIIllIIIIIIII >= 4) {
            return lllllllllllllllllIIlIIllIIIIIIIl.isButtonPressed(lllllllllllllllllIIlIIllIIIIIIII - 4, lllllllllllllllllIIlIIlIllllllII);
        }
        throw new RuntimeException("Unknown control index");
    }

    public void addListener(InputListener lllllllllllllllllIIlIlIIlIIIllIl) {
        Input lllllllllllllllllIIlIlIIlIIlIIll;
        lllllllllllllllllIIlIlIIlIIlIIll.addKeyListener(lllllllllllllllllIIlIlIIlIIIllIl);
        lllllllllllllllllIIlIlIIlIIlIIll.addMouseListener(lllllllllllllllllIIlIlIIlIIIllIl);
        lllllllllllllllllIIlIlIIlIIlIIll.addControllerListener(lllllllllllllllllIIlIlIIlIIIllIl);
    }

    public boolean isControlPressed(int lllllllllllllllllIIlIIlllllllIIl, int lllllllllllllllllIIlIIlllllllIll) {
        Input lllllllllllllllllIIlIIllllllllIl;
        if (lllllllllllllllllIIlIIllllllllIl.controllerPressed[lllllllllllllllllIIlIIlllllllIll][lllllllllllllllllIIlIIlllllllIIl]) {
            lllllllllllllllllIIlIIllllllllIl.controllerPressed[lllllllllllllllllIIlIIlllllllIll][lllllllllllllllllIIlIIlllllllIIl] = false;
            return true;
        }
        return false;
    }

    private int resolveEventKey(int lllllllllllllllllIIlIIllIllIIllI, char lllllllllllllllllIIlIIllIllIIlIl) {
        if (lllllllllllllllllIIlIIllIllIIlIl == '=' || lllllllllllllllllIIlIIllIllIIllI == 0) {
            return 13;
        }
        return lllllllllllllllllIIlIIllIllIIllI;
    }

    public boolean isMouseButtonDown(int lllllllllllllllllIIlIIllllIllIll) {
        return Mouse.isButtonDown((int)lllllllllllllllllIIlIIllllIllIll);
    }

    public boolean isKeyRepeatEnabled() {
        return Keyboard.areRepeatEventsEnabled();
    }

    public void clearKeyPressedRecord() {
        Input lllllllllllllllllIIlIIllllllIIII;
        Arrays.fill(lllllllllllllllllIIlIIllllllIIII.pressed, false);
    }

    public int getAbsoluteMouseY() {
        Input lllllllllllllllllIIlIIlllllIIlII;
        return lllllllllllllllllIIlIIlllllIIlII.height - Mouse.getY() - 1;
    }

    private void addKeyListenerImpl(KeyListener lllllllllllllllllIIlIlIIIlllIlll) {
        Input lllllllllllllllllIIlIlIIIlllIlIl;
        if (lllllllllllllllllIIlIlIIIlllIlIl.keyListeners.contains(lllllllllllllllllIIlIlIIIlllIlll)) {
            return;
        }
        lllllllllllllllllIIlIlIIIlllIlIl.keyListeners.add(lllllllllllllllllIIlIlIIIlllIlll);
        lllllllllllllllllIIlIlIIIlllIlIl.allListeners.add(lllllllllllllllllIIlIlIIIlllIlll);
    }

    public boolean isControlPressed(int lllllllllllllllllIIlIlIIIIIIIIIl) {
        Input lllllllllllllllllIIlIlIIIIIIIIlI;
        return lllllllllllllllllIIlIlIIIIIIIIlI.isControlPressed(lllllllllllllllllIIlIlIIIIIIIIIl, 0);
    }

    public void addControllerListener(ControllerListener lllllllllllllllllIIlIlIIIlIIIllI) {
        Input lllllllllllllllllIIlIlIIIlIIlIIl;
        if (lllllllllllllllllIIlIlIIIlIIlIIl.controllerListeners.contains(lllllllllllllllllIIlIlIIIlIIIllI)) {
            return;
        }
        lllllllllllllllllIIlIlIIIlIIlIIl.controllerListeners.add(lllllllllllllllllIIlIlIIIlIIIllI);
        lllllllllllllllllIIlIlIIIlIIlIIl.allListeners.add(lllllllllllllllllIIlIlIIIlIIIllI);
    }

    void init(int lllllllllllllllllIIlIlIIIIIllIII) {
        Input lllllllllllllllllIIlIlIIIIIllIIl;
        lllllllllllllllllIIlIlIIIIIllIIl.height = lllllllllllllllllIIlIlIIIIIllIII;
        lllllllllllllllllIIlIlIIIIIllIIl.lastMouseX = lllllllllllllllllIIlIlIIIIIllIIl.getMouseX();
        lllllllllllllllllIIlIlIIIIIllIIl.lastMouseY = lllllllllllllllllIIlIlIIIIIllIIl.getMouseY();
    }

    static {
        KEY_APOSTROPHE = 40;
        KEY_4 = 5;
        KEY_APPS = 221;
        KEY_3 = 4;
        KEY_GRAVE = 41;
        KEY_H = 35;
        BUTTON2 = 5;
        KEY_LWIN = 219;
        KEY_COLON = 146;
        KEY_ENTER = 28;
        KEY_F = 33;
        KEY_NOCONVERT = 123;
        KEY_HOME = 199;
        BUTTON6 = 9;
        KEY_F6 = 64;
        KEY_PRIOR = 201;
        KEY_NUMPAD5 = 76;
        KEY_PAUSE = 197;
        KEY_B = 48;
        KEY_LALT = 56;
        KEY_RETURN = 28;
        KEY_UNLABELED = 151;
        KEY_MULTIPLY = 55;
        KEY_KANJI = 148;
        KEY_EQUALS = 13;
        KEY_I = 23;
        KEY_C = 46;
        KEY_F13 = 100;
        KEY_INSERT = 210;
        KEY_KANA = 112;
        KEY_NUMPAD2 = 80;
        KEY_CIRCUMFLEX = 144;
        KEY_COMMA = 51;
        KEY_F3 = 61;
        KEY_RCONTROL = 157;
        KEY_K = 37;
        KEY_F15 = 102;
        KEY_END = 207;
        KEY_V = 47;
        BUTTON4 = 7;
        KEY_UNDERLINE = 147;
        KEY_NUMPAD6 = 77;
        KEY_SEMICOLON = 39;
        KEY_P = 25;
        KEY_A = 30;
        KEY_F9 = 67;
        KEY_U = 22;
        KEY_F2 = 60;
        KEY_F10 = 68;
        KEY_N = 49;
        KEY_F11 = 87;
        KEY_SUBTRACT = 74;
        KEY_O = 24;
        ANY_CONTROLLER = -1;
        KEY_POWER = 222;
        KEY_SCROLL = 70;
        KEY_TAB = 15;
        KEY_F1 = 59;
        KEY_DELETE = 211;
        KEY_NUMPADEQUALS = 141;
        KEY_CONVERT = 121;
        KEY_RBRACKET = 27;
        BUTTON8 = 11;
        KEY_M = 50;
        KEY_SLASH = 53;
        KEY_R = 19;
        LEFT = 0;
        KEY_NUMPAD1 = 79;
        KEY_T = 20;
        KEY_SYSRQ = 183;
        KEY_X = 45;
        KEY_STOP = 149;
        KEY_5 = 6;
        KEY_BACKSLASH = 43;
        KEY_D = 32;
        KEY_F5 = 63;
        BUTTON9 = 12;
        KEY_G = 34;
        KEY_9 = 10;
        KEY_2 = 3;
        BUTTON10 = 13;
        KEY_0 = 11;
        KEY_DIVIDE = 181;
        BUTTON3 = 6;
        KEY_RIGHT = 205;
        KEY_J = 36;
        KEY_NUMPAD3 = 81;
        KEY_UP = 200;
        KEY_NUMLOCK = 69;
        KEY_YEN = 125;
        KEY_F4 = 62;
        KEY_RSHIFT = 54;
        KEY_NUMPADENTER = 156;
        KEY_F7 = 65;
        KEY_1 = 2;
        RIGHT = 1;
        KEY_LBRACKET = 26;
        KEY_NUMPADCOMMA = 179;
        UP = 2;
        KEY_NUMPAD9 = 73;
        MOUSE_RIGHT_BUTTON = 1;
        KEY_BACK = 14;
        KEY_8 = 9;
        KEY_LSHIFT = 42;
        KEY_F14 = 101;
        KEY_L = 38;
        KEY_ESCAPE = 1;
        KEY_S = 31;
        KEY_DECIMAL = 83;
        KEY_NUMPAD8 = 72;
        KEY_NEXT = 209;
        BUTTON7 = 10;
        KEY_RALT = 184;
        KEY_Y = 21;
        KEY_DOWN = 208;
        KEY_W = 17;
        KEY_LCONTROL = 29;
        KEY_SPACE = 57;
        KEY_F8 = 66;
        KEY_NUMPAD7 = 71;
        MAX_BUTTONS = 100;
        KEY_NUMPAD4 = 75;
        KEY_7 = 8;
        DOWN = 3;
        KEY_SLEEP = 223;
        KEY_F12 = 88;
        KEY_RMENU = 184;
        KEY_Z = 44;
        KEY_E = 18;
        KEY_AX = 150;
        BUTTON1 = 4;
        BUTTON5 = 8;
        KEY_ADD = 78;
        KEY_LEFT = 203;
        KEY_CAPITAL = 58;
        MOUSE_LEFT_BUTTON = 0;
        KEY_RWIN = 220;
        MOUSE_MIDDLE_BUTTON = 2;
        KEY_MINUS = 12;
        KEY_AT = 145;
        KEY_6 = 7;
        KEY_Q = 16;
        KEY_PERIOD = 52;
        KEY_LMENU = 56;
        KEY_NUMPAD0 = 82;
        controllersInited = false;
        controllers = new ArrayList();
    }

    public void addKeyListener(KeyListener lllllllllllllllllIIlIlIIlIIIlIII) {
        Input lllllllllllllllllIIlIlIIlIIIIlll;
        lllllllllllllllllIIlIlIIlIIIIlll.keyListenersToAdd.add(lllllllllllllllllIIlIlIIlIIIlIII);
    }

    public boolean isButton2Pressed(int lllllllllllllllllIIlIIlllIIIIIlI) {
        Input lllllllllllllllllIIlIIlllIIIIIll;
        return lllllllllllllllllIIlIIlllIIIIIll.isButtonPressed(1, lllllllllllllllllIIlIIlllIIIIIlI);
    }

    public void addMouseListener(MouseListener lllllllllllllllllIIlIlIIIllIIIlI) {
        Input lllllllllllllllllIIlIlIIIllIIlIl;
        lllllllllllllllllIIlIlIIIllIIlIl.mouseListenersToAdd.add(lllllllllllllllllIIlIlIIIllIIIlI);
    }

    public boolean isKeyDown(int lllllllllllllllllIIlIIlllllIlIIl) {
        return Keyboard.isKeyDown((int)lllllllllllllllllIIlIIlllllIlIIl);
    }

    public void removeControllerListener(ControllerListener lllllllllllllllllIIlIlIIIIlIIIlI) {
        Input lllllllllllllllllIIlIlIIIIlIIlIl;
        lllllllllllllllllIIlIlIIIIlIIlIl.controllerListeners.remove(lllllllllllllllllIIlIlIIIIlIIIlI);
        if (!lllllllllllllllllIIlIlIIIIlIIlIl.mouseListeners.contains(lllllllllllllllllIIlIlIIIIlIIIlI) && !lllllllllllllllllIIlIlIIIIlIIlIl.keyListeners.contains(lllllllllllllllllIIlIlIIIIlIIIlI)) {
            lllllllllllllllllIIlIlIIIIlIIlIl.allListeners.remove(lllllllllllllllllIIlIlIIIIlIIIlI);
        }
    }

    private boolean anyMouseDown() {
        for (int lllllllllllllllllIIlIIllllIllIII = 0; lllllllllllllllllIIlIIllllIllIII < 3; ++lllllllllllllllllIIlIIllllIllIII) {
            if (!Mouse.isButtonDown((int)lllllllllllllllllIIlIIllllIllIII)) continue;
            return true;
        }
        return false;
    }

    public void addPrimaryListener(InputListener lllllllllllllllllIIlIlIIIIllIlII) {
        Input lllllllllllllllllIIlIlIIIIllIlll;
        lllllllllllllllllIIlIlIIIIllIlll.removeListener(lllllllllllllllllIIlIlIIIIllIlII);
        lllllllllllllllllIIlIlIIIIllIlll.keyListeners.add(0, lllllllllllllllllIIlIlIIIIllIlII);
        lllllllllllllllllIIlIlIIIIllIlll.mouseListeners.add(0, lllllllllllllllllIIlIlIIIIllIlII);
        lllllllllllllllllIIlIlIIIIllIlll.controllerListeners.add(0, lllllllllllllllllIIlIlIIIIllIlII);
        lllllllllllllllllIIlIlIIIIllIlll.allListeners.add(lllllllllllllllllIIlIlIIIIllIlII);
    }

    public void pause() {
        Input lllllllllllllllllIIlIIlIlllllIIl;
        lllllllllllllllllIIlIIlIlllllIIl.paused = true;
        lllllllllllllllllIIlIIlIlllllIIl.clearKeyPressedRecord();
        lllllllllllllllllIIlIIlIlllllIIl.clearMousePressedRecord();
        lllllllllllllllllIIlIIlIlllllIIl.clearControlPressedRecord();
    }

    public void enableKeyRepeat() {
        Keyboard.enableRepeatEvents((boolean)true);
    }

    public int getMouseX() {
        Input lllllllllllllllllIIlIIlllllIIIlI;
        return (int)((float)lllllllllllllllllIIlIIlllllIIIlI.getAbsoluteMouseX() * lllllllllllllllllIIlIIlllllIIIlI.scaleX + lllllllllllllllllIIlIIlllllIIIlI.xoffset);
    }

    public boolean isButton1Pressed(int lllllllllllllllllIIlIIlllIIIlIII) {
        Input lllllllllllllllllIIlIIlllIIIlIIl;
        return lllllllllllllllllIIlIIlllIIIlIIl.isButtonPressed(0, lllllllllllllllllIIlIIlllIIIlIII);
    }

    public void clearMousePressedRecord() {
        Input lllllllllllllllllIIlIIlllllIllII;
        Arrays.fill(lllllllllllllllllIIlIIlllllIllII.mousePressed, false);
    }

    public static String getKeyName(int lllllllllllllllllIIlIlIIIIIlIlII) {
        return Keyboard.getKeyName((int)lllllllllllllllllIIlIlIIIIIlIlII);
    }

    public boolean isControllerRight(int lllllllllllllllllIIlIIlllIlIllll) {
        Input lllllllllllllllllIIlIIlllIlIlllI;
        if (lllllllllllllllllIIlIIlllIlIllll >= lllllllllllllllllIIlIIlllIlIlllI.getControllerCount()) {
            return false;
        }
        if (lllllllllllllllllIIlIIlllIlIllll == -1) {
            for (int lllllllllllllllllIIlIIlllIllIIIl = 0; lllllllllllllllllIIlIIlllIllIIIl < controllers.size(); ++lllllllllllllllllIIlIIlllIllIIIl) {
                if (!lllllllllllllllllIIlIIlllIlIlllI.isControllerRight(lllllllllllllllllIIlIIlllIllIIIl)) continue;
                return true;
            }
            return false;
        }
        return ((Controller)controllers.get(lllllllllllllllllIIlIIlllIlIllll)).getXAxisValue() > 0.5f || ((Controller)controllers.get(lllllllllllllllllIIlIIlllIlIllll)).getPovX() > 0.5f;
    }

    public void removeListener(InputListener lllllllllllllllllIIlIlIIIIlIlllI) {
        Input lllllllllllllllllIIlIlIIIIllIIIl;
        lllllllllllllllllIIlIlIIIIllIIIl.removeKeyListener(lllllllllllllllllIIlIlIIIIlIlllI);
        lllllllllllllllllIIlIlIIIIllIIIl.removeMouseListener(lllllllllllllllllIIlIlIIIIlIlllI);
        lllllllllllllllllIIlIlIIIIllIIIl.removeControllerListener(lllllllllllllllllIIlIlIIIIlIlllI);
    }

    public int getAbsoluteMouseX() {
        return Mouse.getX();
    }

    public Input(int lllllllllllllllllIIlIlIIllIIIIIl) {
        Input lllllllllllllllllIIlIlIIllIIIIlI;
        lllllllllllllllllIIlIlIIllIIIIlI.mousePressed = new boolean[10];
        lllllllllllllllllIIlIlIIllIIIIlI.controllerPressed = new boolean[100][100];
        lllllllllllllllllIIlIlIIllIIIIlI.keys = new char[1024];
        lllllllllllllllllIIlIlIIllIIIIlI.pressed = new boolean[1024];
        lllllllllllllllllIIlIlIIllIIIIlI.nextRepeat = new long[1024];
        lllllllllllllllllIIlIlIIllIIIIlI.controls = new boolean[10][110];
        lllllllllllllllllIIlIlIIllIIIIlI.consumed = false;
        lllllllllllllllllIIlIlIIllIIIIlI.allListeners = new HashSet();
        lllllllllllllllllIIlIlIIllIIIIlI.keyListeners = new ArrayList();
        lllllllllllllllllIIlIlIIllIIIIlI.keyListenersToAdd = new ArrayList();
        lllllllllllllllllIIlIlIIllIIIIlI.mouseListeners = new ArrayList();
        lllllllllllllllllIIlIlIIllIIIIlI.mouseListenersToAdd = new ArrayList();
        lllllllllllllllllIIlIlIIllIIIIlI.controllerListeners = new ArrayList();
        lllllllllllllllllIIlIlIIllIIIIlI.displayActive = true;
        lllllllllllllllllIIlIlIIllIIIIlI.scaleX = 1.0f;
        lllllllllllllllllIIlIlIIllIIIIlI.scaleY = 1.0f;
        lllllllllllllllllIIlIlIIllIIIIlI.xoffset = 0.0f;
        lllllllllllllllllIIlIlIIllIIIIlI.yoffset = 0.0f;
        lllllllllllllllllIIlIlIIllIIIIlI.doubleClickDelay = 250;
        lllllllllllllllllIIlIlIIllIIIIlI.doubleClickTimeout = 0L;
        lllllllllllllllllIIlIlIIllIIIIlI.pressedX = -1;
        lllllllllllllllllIIlIlIIllIIIIlI.pressedY = -1;
        lllllllllllllllllIIlIlIIllIIIIlI.mouseClickTolerance = 5;
        lllllllllllllllllIIlIlIIllIIIIlI.init(lllllllllllllllllIIlIlIIllIIIIIl);
    }

    public void setScale(float lllllllllllllllllIIlIlIIlIlIlllI, float lllllllllllllllllIIlIlIIlIlIllIl) {
        lllllllllllllllllIIlIlIIlIlIllll.scaleX = lllllllllllllllllIIlIlIIlIlIlllI;
        lllllllllllllllllIIlIlIIlIlIllll.scaleY = lllllllllllllllllIIlIlIIlIlIllIl;
    }

    public void disableKeyRepeat() {
        Keyboard.enableRepeatEvents((boolean)false);
    }

    public void enableKeyRepeat(int lllllllllllllllllIIlIIllIIlIIlll, int lllllllllllllllllIIlIIllIIlIIllI) {
        Keyboard.enableRepeatEvents((boolean)true);
    }

    private void fireMouseClicked(int lllllllllllllllllIIlIIlIlllIlIll, int lllllllllllllllllIIlIIlIlllIIlIl, int lllllllllllllllllIIlIIlIlllIlIIl, int lllllllllllllllllIIlIIlIlllIlIII) {
        Input lllllllllllllllllIIlIIlIlllIIlll;
        lllllllllllllllllIIlIIlIlllIIlll.consumed = false;
        for (int lllllllllllllllllIIlIIlIlllIllIl = 0; lllllllllllllllllIIlIIlIlllIllIl < lllllllllllllllllIIlIIlIlllIIlll.mouseListeners.size(); ++lllllllllllllllllIIlIIlIlllIllIl) {
            MouseListener lllllllllllllllllIIlIIlIlllIlllI = (MouseListener)lllllllllllllllllIIlIIlIlllIIlll.mouseListeners.get(lllllllllllllllllIIlIIlIlllIllIl);
            if (!lllllllllllllllllIIlIIlIlllIlllI.isAcceptingInput()) continue;
            lllllllllllllllllIIlIIlIlllIlllI.mouseClicked(lllllllllllllllllIIlIIlIlllIlIll, lllllllllllllllllIIlIIlIlllIIlIl, lllllllllllllllllIIlIIlIlllIlIIl, lllllllllllllllllIIlIIlIlllIlIII);
            if (lllllllllllllllllIIlIIlIlllIIlll.consumed) break;
        }
    }

    public void poll(int lllllllllllllllllIIlIIllIIllIIll, int lllllllllllllllllIIlIIllIIlIlllI) {
        Input lllllllllllllllllIIlIIllIIllIlII;
        if (lllllllllllllllllIIlIIllIIllIlII.paused) {
            lllllllllllllllllIIlIIllIIllIlII.clearControlPressedRecord();
            lllllllllllllllllIIlIIllIIllIlII.clearKeyPressedRecord();
            lllllllllllllllllIIlIIllIIllIlII.clearMousePressedRecord();
            while (Keyboard.next()) {
            }
            while (Mouse.next()) {
            }
            return;
        }
        if (!Display.isActive()) {
            lllllllllllllllllIIlIIllIIllIlII.clearControlPressedRecord();
            lllllllllllllllllIIlIIllIIllIlII.clearKeyPressedRecord();
            lllllllllllllllllIIlIIllIIllIlII.clearMousePressedRecord();
        }
        for (int lllllllllllllllllIIlIIllIlIlIIIl = 0; lllllllllllllllllIIlIIllIlIlIIIl < lllllllllllllllllIIlIIllIIllIlII.keyListenersToAdd.size(); ++lllllllllllllllllIIlIIllIlIlIIIl) {
            lllllllllllllllllIIlIIllIIllIlII.addKeyListenerImpl((KeyListener)lllllllllllllllllIIlIIllIIllIlII.keyListenersToAdd.get(lllllllllllllllllIIlIIllIlIlIIIl));
        }
        lllllllllllllllllIIlIIllIIllIlII.keyListenersToAdd.clear();
        for (int lllllllllllllllllIIlIIllIlIlIIII = 0; lllllllllllllllllIIlIIllIlIlIIII < lllllllllllllllllIIlIIllIIllIlII.mouseListenersToAdd.size(); ++lllllllllllllllllIIlIIllIlIlIIII) {
            lllllllllllllllllIIlIIllIIllIlII.addMouseListenerImpl((MouseListener)lllllllllllllllllIIlIIllIIllIlII.mouseListenersToAdd.get(lllllllllllllllllIIlIIllIlIlIIII));
        }
        lllllllllllllllllIIlIIllIIllIlII.mouseListenersToAdd.clear();
        if (lllllllllllllllllIIlIIllIIllIlII.doubleClickTimeout != 0L && System.currentTimeMillis() > lllllllllllllllllIIlIIllIIllIlII.doubleClickTimeout) {
            lllllllllllllllllIIlIIllIIllIlII.doubleClickTimeout = 0L;
        }
        lllllllllllllllllIIlIIllIIllIlII.height = lllllllllllllllllIIlIIllIIlIlllI;
        for (ControlledInputReciever lllllllllllllllllIIlIIllIlIIllll : lllllllllllllllllIIlIIllIIllIlII.allListeners) {
            lllllllllllllllllIIlIIllIlIIllll.inputStarted();
        }
        block5: while (Keyboard.next()) {
            if (Keyboard.getEventKeyState()) {
                int lllllllllllllllllIIlIIllIlIIllII = lllllllllllllllllIIlIIllIIllIlII.resolveEventKey(Keyboard.getEventKey(), Keyboard.getEventCharacter());
                lllllllllllllllllIIlIIllIIllIlII.keys[lllllllllllllllllIIlIIllIlIIllII] = Keyboard.getEventCharacter();
                lllllllllllllllllIIlIIllIIllIlII.pressed[lllllllllllllllllIIlIIllIlIIllII] = true;
                lllllllllllllllllIIlIIllIIllIlII.nextRepeat[lllllllllllllllllIIlIIllIlIIllII] = System.currentTimeMillis() + (long)lllllllllllllllllIIlIIllIIllIlII.keyRepeatInitial;
                lllllllllllllllllIIlIIllIIllIlII.consumed = false;
                for (int lllllllllllllllllIIlIIllIlIIllIl = 0; lllllllllllllllllIIlIIllIlIIllIl < lllllllllllllllllIIlIIllIIllIlII.keyListeners.size(); ++lllllllllllllllllIIlIIllIlIIllIl) {
                    KeyListener lllllllllllllllllIIlIIllIlIIlllI = (KeyListener)lllllllllllllllllIIlIIllIIllIlII.keyListeners.get(lllllllllllllllllIIlIIllIlIIllIl);
                    if (!lllllllllllllllllIIlIIllIlIIlllI.isAcceptingInput()) continue;
                    lllllllllllllllllIIlIIllIlIIlllI.keyPressed(lllllllllllllllllIIlIIllIlIIllII, Keyboard.getEventCharacter());
                    if (lllllllllllllllllIIlIIllIIllIlII.consumed) continue block5;
                }
                continue;
            }
            int lllllllllllllllllIIlIIllIlIIlIIl = lllllllllllllllllIIlIIllIIllIlII.resolveEventKey(Keyboard.getEventKey(), Keyboard.getEventCharacter());
            lllllllllllllllllIIlIIllIIllIlII.nextRepeat[lllllllllllllllllIIlIIllIlIIlIIl] = 0L;
            lllllllllllllllllIIlIIllIIllIlII.consumed = false;
            for (int lllllllllllllllllIIlIIllIlIIlIlI = 0; lllllllllllllllllIIlIIllIlIIlIlI < lllllllllllllllllIIlIIllIIllIlII.keyListeners.size(); ++lllllllllllllllllIIlIIllIlIIlIlI) {
                KeyListener lllllllllllllllllIIlIIllIlIIlIll = (KeyListener)lllllllllllllllllIIlIIllIIllIlII.keyListeners.get(lllllllllllllllllIIlIIllIlIIlIlI);
                if (!lllllllllllllllllIIlIIllIlIIlIll.isAcceptingInput()) continue;
                lllllllllllllllllIIlIIllIlIIlIll.keyReleased(lllllllllllllllllIIlIIllIlIIlIIl, lllllllllllllllllIIlIIllIIllIlII.keys[lllllllllllllllllIIlIIllIlIIlIIl]);
                if (lllllllllllllllllIIlIIllIIllIlII.consumed) continue block5;
            }
        }
        block8: while (Mouse.next()) {
            if (Mouse.getEventButton() >= 0) {
                if (Mouse.getEventButtonState()) {
                    lllllllllllllllllIIlIIllIIllIlII.consumed = false;
                    lllllllllllllllllIIlIIllIIllIlII.mousePressed[Mouse.getEventButton()] = true;
                    lllllllllllllllllIIlIIllIIllIlII.pressedX = (int)(lllllllllllllllllIIlIIllIIllIlII.xoffset + (float)Mouse.getEventX() * lllllllllllllllllIIlIIllIIllIlII.scaleX);
                    lllllllllllllllllIIlIIllIIllIlII.pressedY = (int)(lllllllllllllllllIIlIIllIIllIlII.yoffset + (float)(lllllllllllllllllIIlIIllIIlIlllI - Mouse.getEventY() - 1) * lllllllllllllllllIIlIIllIIllIlII.scaleY);
                    for (int lllllllllllllllllIIlIIllIlIIIlll = 0; lllllllllllllllllIIlIIllIlIIIlll < lllllllllllllllllIIlIIllIIllIlII.mouseListeners.size(); ++lllllllllllllllllIIlIIllIlIIIlll) {
                        MouseListener lllllllllllllllllIIlIIllIlIIlIII = (MouseListener)lllllllllllllllllIIlIIllIIllIlII.mouseListeners.get(lllllllllllllllllIIlIIllIlIIIlll);
                        if (!lllllllllllllllllIIlIIllIlIIlIII.isAcceptingInput()) continue;
                        lllllllllllllllllIIlIIllIlIIlIII.mousePressed(Mouse.getEventButton(), lllllllllllllllllIIlIIllIIllIlII.pressedX, lllllllllllllllllIIlIIllIIllIlII.pressedY);
                        if (lllllllllllllllllIIlIIllIIllIlII.consumed) continue block8;
                    }
                    continue;
                }
                lllllllllllllllllIIlIIllIIllIlII.consumed = false;
                lllllllllllllllllIIlIIllIIllIlII.mousePressed[Mouse.getEventButton()] = false;
                int lllllllllllllllllIIlIIllIlIIIlII = (int)(lllllllllllllllllIIlIIllIIllIlII.xoffset + (float)Mouse.getEventX() * lllllllllllllllllIIlIIllIIllIlII.scaleX);
                int lllllllllllllllllIIlIIllIlIIIIll = (int)(lllllllllllllllllIIlIIllIIllIlII.yoffset + (float)(lllllllllllllllllIIlIIllIIlIlllI - Mouse.getEventY() - 1) * lllllllllllllllllIIlIIllIIllIlII.scaleY);
                if (lllllllllllllllllIIlIIllIIllIlII.pressedX != -1 && lllllllllllllllllIIlIIllIIllIlII.pressedY != -1 && Math.abs(lllllllllllllllllIIlIIllIIllIlII.pressedX - lllllllllllllllllIIlIIllIlIIIlII) < lllllllllllllllllIIlIIllIIllIlII.mouseClickTolerance && Math.abs(lllllllllllllllllIIlIIllIIllIlII.pressedY - lllllllllllllllllIIlIIllIlIIIIll) < lllllllllllllllllIIlIIllIIllIlII.mouseClickTolerance) {
                    lllllllllllllllllIIlIIllIIllIlII.considerDoubleClick(Mouse.getEventButton(), lllllllllllllllllIIlIIllIlIIIlII, lllllllllllllllllIIlIIllIlIIIIll);
                    lllllllllllllllllIIlIIllIIllIlII.pressedY = -1;
                    lllllllllllllllllIIlIIllIIllIlII.pressedX = -1;
                }
                for (int lllllllllllllllllIIlIIllIlIIIlIl = 0; lllllllllllllllllIIlIIllIlIIIlIl < lllllllllllllllllIIlIIllIIllIlII.mouseListeners.size(); ++lllllllllllllllllIIlIIllIlIIIlIl) {
                    MouseListener lllllllllllllllllIIlIIllIlIIIllI = (MouseListener)lllllllllllllllllIIlIIllIIllIlII.mouseListeners.get(lllllllllllllllllIIlIIllIlIIIlIl);
                    if (!lllllllllllllllllIIlIIllIlIIIllI.isAcceptingInput()) continue;
                    lllllllllllllllllIIlIIllIlIIIllI.mouseReleased(Mouse.getEventButton(), lllllllllllllllllIIlIIllIlIIIlII, lllllllllllllllllIIlIIllIlIIIIll);
                    if (lllllllllllllllllIIlIIllIIllIlII.consumed) continue block8;
                }
                continue;
            }
            if (Mouse.isGrabbed() && lllllllllllllllllIIlIIllIIllIlII.displayActive && (Mouse.getEventDX() != 0 || Mouse.getEventDY() != 0)) {
                lllllllllllllllllIIlIIllIIllIlII.consumed = false;
                for (int lllllllllllllllllIIlIIllIlIIIIIl = 0; lllllllllllllllllIIlIIllIlIIIIIl < lllllllllllllllllIIlIIllIIllIlII.mouseListeners.size(); ++lllllllllllllllllIIlIIllIlIIIIIl) {
                    MouseListener lllllllllllllllllIIlIIllIlIIIIlI = (MouseListener)lllllllllllllllllIIlIIllIIllIlII.mouseListeners.get(lllllllllllllllllIIlIIllIlIIIIIl);
                    if (!lllllllllllllllllIIlIIllIlIIIIlI.isAcceptingInput()) continue;
                    if (lllllllllllllllllIIlIIllIIllIlII.anyMouseDown()) {
                        lllllllllllllllllIIlIIllIlIIIIlI.mouseDragged(0, 0, Mouse.getEventDX(), -Mouse.getEventDY());
                    } else {
                        lllllllllllllllllIIlIIllIlIIIIlI.mouseMoved(0, 0, Mouse.getEventDX(), -Mouse.getEventDY());
                    }
                    if (lllllllllllllllllIIlIIllIIllIlII.consumed) break;
                }
            }
            int lllllllllllllllllIIlIIllIIlllllI = Mouse.getEventDWheel();
            lllllllllllllllllIIlIIllIIllIlII.wheel += lllllllllllllllllIIlIIllIIlllllI;
            if (lllllllllllllllllIIlIIllIIlllllI == 0) continue;
            lllllllllllllllllIIlIIllIIllIlII.consumed = false;
            for (int lllllllllllllllllIIlIIllIIllllll = 0; lllllllllllllllllIIlIIllIIllllll < lllllllllllllllllIIlIIllIIllIlII.mouseListeners.size(); ++lllllllllllllllllIIlIIllIIllllll) {
                MouseListener lllllllllllllllllIIlIIllIlIIIIII = (MouseListener)lllllllllllllllllIIlIIllIIllIlII.mouseListeners.get(lllllllllllllllllIIlIIllIIllllll);
                if (!lllllllllllllllllIIlIIllIlIIIIII.isAcceptingInput()) continue;
                lllllllllllllllllIIlIIllIlIIIIII.mouseWheelMoved(lllllllllllllllllIIlIIllIIlllllI);
                if (lllllllllllllllllIIlIIllIIllIlII.consumed) continue block8;
            }
        }
        if (!lllllllllllllllllIIlIIllIIllIlII.displayActive || Mouse.isGrabbed()) {
            lllllllllllllllllIIlIIllIIllIlII.lastMouseX = lllllllllllllllllIIlIIllIIllIlII.getMouseX();
            lllllllllllllllllIIlIIllIIllIlII.lastMouseY = lllllllllllllllllIIlIIllIIllIlII.getMouseY();
        } else if (lllllllllllllllllIIlIIllIIllIlII.lastMouseX != lllllllllllllllllIIlIIllIIllIlII.getMouseX() || lllllllllllllllllIIlIIllIIllIlII.lastMouseY != lllllllllllllllllIIlIIllIIllIlII.getMouseY()) {
            lllllllllllllllllIIlIIllIIllIlII.consumed = false;
            for (int lllllllllllllllllIIlIIllIIllllII = 0; lllllllllllllllllIIlIIllIIllllII < lllllllllllllllllIIlIIllIIllIlII.mouseListeners.size(); ++lllllllllllllllllIIlIIllIIllllII) {
                MouseListener lllllllllllllllllIIlIIllIIllllIl = (MouseListener)lllllllllllllllllIIlIIllIIllIlII.mouseListeners.get(lllllllllllllllllIIlIIllIIllllII);
                if (!lllllllllllllllllIIlIIllIIllllIl.isAcceptingInput()) continue;
                if (lllllllllllllllllIIlIIllIIllIlII.anyMouseDown()) {
                    lllllllllllllllllIIlIIllIIllllIl.mouseDragged(lllllllllllllllllIIlIIllIIllIlII.lastMouseX, lllllllllllllllllIIlIIllIIllIlII.lastMouseY, lllllllllllllllllIIlIIllIIllIlII.getMouseX(), lllllllllllllllllIIlIIllIIllIlII.getMouseY());
                } else {
                    lllllllllllllllllIIlIIllIIllllIl.mouseMoved(lllllllllllllllllIIlIIllIIllIlII.lastMouseX, lllllllllllllllllIIlIIllIIllIlII.lastMouseY, lllllllllllllllllIIlIIllIIllIlII.getMouseX(), lllllllllllllllllIIlIIllIIllIlII.getMouseY());
                }
                if (lllllllllllllllllIIlIIllIIllIlII.consumed) break;
            }
            lllllllllllllllllIIlIIllIIllIlII.lastMouseX = lllllllllllllllllIIlIIllIIllIlII.getMouseX();
            lllllllllllllllllIIlIIllIIllIlII.lastMouseY = lllllllllllllllllIIlIIllIIllIlII.getMouseY();
        }
        if (controllersInited) {
            for (int lllllllllllllllllIIlIIllIIlllIIl = 0; lllllllllllllllllIIlIIllIIlllIIl < lllllllllllllllllIIlIIllIIllIlII.getControllerCount(); ++lllllllllllllllllIIlIIllIIlllIIl) {
                int lllllllllllllllllIIlIIllIIlllIlI = ((Controller)controllers.get(lllllllllllllllllIIlIIllIIlllIIl)).getButtonCount() + 3;
                lllllllllllllllllIIlIIllIIlllIlI = Math.min(lllllllllllllllllIIlIIllIIlllIlI, 24);
                for (int lllllllllllllllllIIlIIllIIlllIll = 0; lllllllllllllllllIIlIIllIIlllIll <= lllllllllllllllllIIlIIllIIlllIlI; ++lllllllllllllllllIIlIIllIIlllIll) {
                    if (lllllllllllllllllIIlIIllIIllIlII.controls[lllllllllllllllllIIlIIllIIlllIIl][lllllllllllllllllIIlIIllIIlllIll] && !lllllllllllllllllIIlIIllIIllIlII.isControlDwn(lllllllllllllllllIIlIIllIIlllIll, lllllllllllllllllIIlIIllIIlllIIl)) {
                        lllllllllllllllllIIlIIllIIllIlII.controls[lllllllllllllllllIIlIIllIIlllIIl][lllllllllllllllllIIlIIllIIlllIll] = false;
                        lllllllllllllllllIIlIIllIIllIlII.fireControlRelease(lllllllllllllllllIIlIIllIIlllIll, lllllllllllllllllIIlIIllIIlllIIl);
                        continue;
                    }
                    if (lllllllllllllllllIIlIIllIIllIlII.controls[lllllllllllllllllIIlIIllIIlllIIl][lllllllllllllllllIIlIIllIIlllIll] || !lllllllllllllllllIIlIIllIIllIlII.isControlDwn(lllllllllllllllllIIlIIllIIlllIll, lllllllllllllllllIIlIIllIIlllIIl)) continue;
                    lllllllllllllllllIIlIIllIIllIlII.controllerPressed[lllllllllllllllllIIlIIllIIlllIIl][lllllllllllllllllIIlIIllIIlllIll] = true;
                    lllllllllllllllllIIlIIllIIllIlII.controls[lllllllllllllllllIIlIIllIIlllIIl][lllllllllllllllllIIlIIllIIlllIll] = true;
                    lllllllllllllllllIIlIIllIIllIlII.fireControlPress(lllllllllllllllllIIlIIllIIlllIll, lllllllllllllllllIIlIIllIIlllIIl);
                }
            }
        }
        if (lllllllllllllllllIIlIIllIIllIlII.keyRepeat) {
            block16: for (int lllllllllllllllllIIlIIllIIllIllI = 0; lllllllllllllllllIIlIIllIIllIllI < 1024; ++lllllllllllllllllIIlIIllIIllIllI) {
                if (!lllllllllllllllllIIlIIllIIllIlII.pressed[lllllllllllllllllIIlIIllIIllIllI] || lllllllllllllllllIIlIIllIIllIlII.nextRepeat[lllllllllllllllllIIlIIllIIllIllI] == 0L || System.currentTimeMillis() <= lllllllllllllllllIIlIIllIIllIlII.nextRepeat[lllllllllllllllllIIlIIllIIllIllI]) continue;
                lllllllllllllllllIIlIIllIIllIlII.nextRepeat[lllllllllllllllllIIlIIllIIllIllI] = System.currentTimeMillis() + (long)lllllllllllllllllIIlIIllIIllIlII.keyRepeatInterval;
                lllllllllllllllllIIlIIllIIllIlII.consumed = false;
                for (int lllllllllllllllllIIlIIllIIllIlll = 0; lllllllllllllllllIIlIIllIIllIlll < lllllllllllllllllIIlIIllIIllIlII.keyListeners.size(); ++lllllllllllllllllIIlIIllIIllIlll) {
                    KeyListener lllllllllllllllllIIlIIllIIlllIII = (KeyListener)lllllllllllllllllIIlIIllIIllIlII.keyListeners.get(lllllllllllllllllIIlIIllIIllIlll);
                    if (!lllllllllllllllllIIlIIllIIlllIII.isAcceptingInput()) continue;
                    lllllllllllllllllIIlIIllIIlllIII.keyPressed(lllllllllllllllllIIlIIllIIllIllI, lllllllllllllllllIIlIIllIIllIlII.keys[lllllllllllllllllIIlIIllIIllIllI]);
                    if (lllllllllllllllllIIlIIllIIllIlII.consumed) continue block16;
                }
            }
        }
        for (ControlledInputReciever lllllllllllllllllIIlIIllIIllIlIl : lllllllllllllllllIIlIIllIIllIlII.allListeners) {
            lllllllllllllllllIIlIIllIIllIlIl.inputEnded();
        }
        if (Display.isCreated()) {
            lllllllllllllllllIIlIIllIIllIlII.displayActive = Display.isActive();
        }
    }

    private class NullOutputStream
    extends OutputStream {
        @Override
        public void write(int llllllllllllllllIllIIIIllIllIllI) throws IOException {
        }

        private NullOutputStream() {
            NullOutputStream llllllllllllllllIllIIIIllIlllIlI;
        }
    }
}

