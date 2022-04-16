/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.Sys
 *  org.lwjgl.input.Cursor
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.openal.AL
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.DisplayMode
 *  org.lwjgl.opengl.Drawable
 *  org.lwjgl.opengl.PixelFormat
 */
package org.newdawn.slick;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.Drawable;
import org.lwjgl.opengl.PixelFormat;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.opengl.CursorLoader;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.ImageIOImageData;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.opengl.TGAImageData;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

public class AppGameContainer
extends GameContainer {
    protected /* synthetic */ boolean alphaSupport;
    protected /* synthetic */ DisplayMode originalDisplayMode;
    protected /* synthetic */ boolean updateOnlyOnVisible;
    protected /* synthetic */ DisplayMode targetDisplayMode;

    @Override
    public void setIcons(String[] lllllllllllllllllIlIlIlIlIlllllI) throws SlickException {
        ByteBuffer[] lllllllllllllllllIlIlIlIlIllllIl = new ByteBuffer[lllllllllllllllllIlIlIlIlIlllllI.length];
        for (int lllllllllllllllllIlIlIlIllIIIIII = 0; lllllllllllllllllIlIlIlIllIIIIII < lllllllllllllllllIlIlIlIlIlllllI.length; ++lllllllllllllllllIlIlIlIllIIIIII) {
            ImageIOImageData lllllllllllllllllIlIlIlIllIIIIlI;
            boolean lllllllllllllllllIlIlIlIllIIIIIl = true;
            if (lllllllllllllllllIlIlIlIlIlllllI[lllllllllllllllllIlIlIlIllIIIIII].endsWith(".tga")) {
                TGAImageData lllllllllllllllllIlIlIlIllIIIlII = new TGAImageData();
            } else {
                lllllllllllllllllIlIlIlIllIIIIIl = false;
                lllllllllllllllllIlIlIlIllIIIIlI = new ImageIOImageData();
            }
            try {
                lllllllllllllllllIlIlIlIlIllllIl[lllllllllllllllllIlIlIlIllIIIIII] = lllllllllllllllllIlIlIlIllIIIIlI.loadImage(ResourceLoader.getResourceAsStream(lllllllllllllllllIlIlIlIlIlllllI[lllllllllllllllllIlIlIlIllIIIIII]), lllllllllllllllllIlIlIlIllIIIIIl, false, null);
                continue;
            }
            catch (Exception lllllllllllllllllIlIlIlIllIIIIll) {
                Log.error(lllllllllllllllllIlIlIlIllIIIIll);
                throw new SlickException("Failed to set the icon");
            }
        }
        Display.setIcon((ByteBuffer[])lllllllllllllllllIlIlIlIlIllllIl);
    }

    public boolean supportsAlphaInBackBuffer() {
        AppGameContainer lllllllllllllllllIlIllIIllIlIlII;
        return lllllllllllllllllIlIllIIllIlIlII.alphaSupport;
    }

    @Override
    public int getScreenHeight() {
        AppGameContainer lllllllllllllllllIlIlIllIIIIIIIl;
        return lllllllllllllllllIlIlIllIIIIIIIl.originalDisplayMode.getHeight();
    }

    public void setTitle(String lllllllllllllllllIlIllIIllIIlllI) {
        Display.setTitle((String)lllllllllllllllllIlIllIIllIIlllI);
    }

    @Override
    public int getScreenWidth() {
        AppGameContainer lllllllllllllllllIlIlIlIllllllIl;
        return lllllllllllllllllIlIlIlIllllllIl.originalDisplayMode.getWidth();
    }

    @Override
    public void setMouseCursor(Image lllllllllllllllllIlIlIllllIlllll, int lllllllllllllllllIlIlIllllIlIlIl, int lllllllllllllllllIlIlIllllIllIll) throws SlickException {
        try {
            AppGameContainer lllllllllllllllllIlIlIllllIllIIl;
            Image lllllllllllllllllIlIlIlllllIlIII = new Image(lllllllllllllllllIlIlIllllIllIIl.get2Fold(lllllllllllllllllIlIlIllllIlllll.getWidth()), lllllllllllllllllIlIlIllllIllIIl.get2Fold(lllllllllllllllllIlIlIllllIlllll.getHeight()));
            Graphics lllllllllllllllllIlIlIlllllIIlll = lllllllllllllllllIlIlIlllllIlIII.getGraphics();
            ByteBuffer lllllllllllllllllIlIlIlllllIIllI = BufferUtils.createByteBuffer((int)(lllllllllllllllllIlIlIlllllIlIII.getWidth() * lllllllllllllllllIlIlIlllllIlIII.getHeight() * 4));
            lllllllllllllllllIlIlIlllllIIlll.drawImage(lllllllllllllllllIlIlIllllIlllll.getFlippedCopy(false, true), 0.0f, 0.0f);
            lllllllllllllllllIlIlIlllllIIlll.flush();
            lllllllllllllllllIlIlIlllllIIlll.getArea(0, 0, lllllllllllllllllIlIlIlllllIlIII.getWidth(), lllllllllllllllllIlIlIlllllIlIII.getHeight(), lllllllllllllllllIlIlIlllllIIllI);
            Cursor lllllllllllllllllIlIlIlllllIIlII = CursorLoader.get().getCursor(lllllllllllllllllIlIlIlllllIIllI, lllllllllllllllllIlIlIllllIlIlIl, lllllllllllllllllIlIlIllllIllIll, lllllllllllllllllIlIlIlllllIlIII.getWidth(), lllllllllllllllllIlIlIlllllIlIII.getHeight());
            Mouse.setNativeCursor((Cursor)lllllllllllllllllIlIlIlllllIIlII);
        }
        catch (Throwable lllllllllllllllllIlIlIlllllIIIll) {
            Log.error("Failed to load and apply cursor.", lllllllllllllllllIlIlIlllllIIIll);
            throw new SlickException("Failed to set mouse cursor", lllllllllllllllllIlIlIlllllIIIll);
        }
    }

    @Override
    public void setFullscreen(boolean lllllllllllllllllIlIllIIlIIIllII) throws SlickException {
        AppGameContainer lllllllllllllllllIlIllIIlIIIllIl;
        if (lllllllllllllllllIlIllIIlIIIllIl.isFullscreen() == lllllllllllllllllIlIllIIlIIIllII) {
            return;
        }
        if (!lllllllllllllllllIlIllIIlIIIllII) {
            try {
                Display.setFullscreen((boolean)lllllllllllllllllIlIllIIlIIIllII);
            }
            catch (LWJGLException lllllllllllllllllIlIllIIlIIIlllI) {
                throw new SlickException(String.valueOf(new StringBuilder().append("Unable to set fullscreen=").append(lllllllllllllllllIlIllIIlIIIllII)), lllllllllllllllllIlIllIIlIIIlllI);
            }
        } else {
            lllllllllllllllllIlIllIIlIIIllIl.setDisplayMode(lllllllllllllllllIlIllIIlIIIllIl.width, lllllllllllllllllIlIllIIlIIIllIl.height, lllllllllllllllllIlIllIIlIIIllII);
        }
        lllllllllllllllllIlIllIIlIIIllIl.getDelta();
    }

    @Override
    public boolean isMouseGrabbed() {
        return Mouse.isGrabbed();
    }

    static {
        AccessController.doPrivileged(new PrivilegedAction(){
            {
                1 lllllllllllllllllllIIlIlIIlIlIII;
            }

            public Object run() {
                try {
                    Display.getDisplayMode();
                }
                catch (Exception lllllllllllllllllllIIlIlIIlIIlIl) {
                    Log.error(lllllllllllllllllllIIlIlIIlIIlIl);
                }
                return null;
            }
        });
    }

    protected void setup() throws SlickException {
        AppGameContainer lllllllllllllllllIlIlIlllIIlllll;
        if (lllllllllllllllllIlIlIlllIIlllll.targetDisplayMode == null) {
            lllllllllllllllllIlIlIlllIIlllll.setDisplayMode(640, 480, false);
        }
        Display.setTitle((String)lllllllllllllllllIlIlIlllIIlllll.game.getTitle());
        Log.info(String.valueOf(new StringBuilder().append("LWJGL Version: ").append(Sys.getVersion())));
        Log.info(String.valueOf(new StringBuilder().append("OriginalDisplayMode: ").append(lllllllllllllllllIlIlIlllIIlllll.originalDisplayMode)));
        Log.info(String.valueOf(new StringBuilder().append("TargetDisplayMode: ").append(lllllllllllllllllIlIlIlllIIlllll.targetDisplayMode)));
        AccessController.doPrivileged(new PrivilegedAction(){

            public Object run() {
                2 lllllllllllllllllllIllIIIllllIll;
                try {
                    PixelFormat lllllllllllllllllllIllIIlIIIIIIl = new PixelFormat(8, 8, GameContainer.stencil ? 8 : 0, lllllllllllllllllllIllIIIllllIll.AppGameContainer.this.samples);
                    lllllllllllllllllllIllIIIllllIll.AppGameContainer.this.tryCreateDisplay(lllllllllllllllllllIllIIlIIIIIIl);
                    lllllllllllllllllllIllIIIllllIll.AppGameContainer.this.supportsMultiSample = true;
                }
                catch (Exception lllllllllllllllllllIllIIIlllllIl) {
                    Display.destroy();
                    try {
                        PixelFormat lllllllllllllllllllIllIIlIIIIIII = new PixelFormat(8, 8, GameContainer.stencil ? 8 : 0);
                        lllllllllllllllllllIllIIIllllIll.AppGameContainer.this.tryCreateDisplay(lllllllllllllllllllIllIIlIIIIIII);
                        lllllllllllllllllllIllIIIllllIll.AppGameContainer.this.alphaSupport = false;
                    }
                    catch (Exception lllllllllllllllllllIllIIIllllllI) {
                        Display.destroy();
                        try {
                            lllllllllllllllllllIllIIIllllIll.AppGameContainer.this.tryCreateDisplay(new PixelFormat());
                        }
                        catch (Exception lllllllllllllllllllIllIIIlllllll) {
                            Log.error(lllllllllllllllllllIllIIIlllllll);
                        }
                    }
                }
                return null;
            }
            {
                2 lllllllllllllllllllIllIIlIIIlIII;
            }
        });
        if (!Display.isCreated()) {
            throw new SlickException("Failed to initialise the LWJGL display");
        }
        lllllllllllllllllIlIlIlllIIlllll.initSystem();
        lllllllllllllllllIlIlIlllIIlllll.enterOrtho();
        try {
            lllllllllllllllllIlIlIlllIIlllll.getInput().initControllers();
        }
        catch (SlickException lllllllllllllllllIlIlIlllIlIIlIl) {
            Log.info("Controllers not available");
        }
        catch (Throwable lllllllllllllllllIlIlIlllIlIIIll) {
            Log.info("Controllers not available");
        }
        try {
            lllllllllllllllllIlIlIlllIIlllll.game.init(lllllllllllllllllIlIlIlllIIlllll);
        }
        catch (SlickException lllllllllllllllllIlIlIlllIlIIIlI) {
            Log.error(lllllllllllllllllIlIlIlllIlIIIlI);
            lllllllllllllllllIlIlIlllIIlllll.running = false;
        }
    }

    @Override
    public void setIcon(String lllllllllllllllllIlIlIllIIlIIIll) throws SlickException {
        AppGameContainer lllllllllllllllllIlIlIllIIlIIllI;
        lllllllllllllllllIlIlIllIIlIIllI.setIcons(new String[]{lllllllllllllllllIlIlIllIIlIIIll});
    }

    @Override
    public boolean isFullscreen() {
        return Display.isFullscreen();
    }

    @Override
    public void reinit() throws SlickException {
        AppGameContainer lllllllllllllllllIlIlIlllIllllll;
        InternalTextureLoader.get().clear();
        SoundStore.get().clear();
        lllllllllllllllllIlIlIlllIllllll.initSystem();
        lllllllllllllllllIlIlIlllIllllll.enterOrtho();
        try {
            lllllllllllllllllIlIlIlllIllllll.game.init(lllllllllllllllllIlIlIlllIllllll);
        }
        catch (SlickException lllllllllllllllllIlIlIllllIIIIIl) {
            Log.error(lllllllllllllllllIlIlIllllIIIIIl);
            lllllllllllllllllIlIlIlllIllllll.running = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start() throws SlickException {
        AppGameContainer lllllllllllllllllIlIlIlllIlIlIIl;
        try {
            lllllllllllllllllIlIlIlllIlIlIIl.setup();
            lllllllllllllllllIlIlIlllIlIlIIl.getDelta();
            while (lllllllllllllllllIlIlIlllIlIlIIl.running()) {
                lllllllllllllllllIlIlIlllIlIlIIl.gameLoop();
            }
        }
        finally {
            lllllllllllllllllIlIlIlllIlIlIIl.destroy();
        }
        if (lllllllllllllllllIlIlIlllIlIlIIl.forceExit) {
            System.exit(0);
        }
    }

    @Override
    public boolean isUpdatingOnlyWhenVisible() {
        AppGameContainer lllllllllllllllllIlIlIllIIlllIll;
        return lllllllllllllllllIlIlIllIIlllIll.updateOnlyOnVisible;
    }

    @Override
    public void setDefaultMouseCursor() {
        try {
            Mouse.setNativeCursor(null);
        }
        catch (LWJGLException lllllllllllllllllIlIlIlIlIIllllI) {
            Log.error("Failed to reset mouse cursor", lllllllllllllllllIlIlIlIlIIllllI);
        }
    }

    protected void gameLoop() throws SlickException {
        AppGameContainer lllllllllllllllllIlIlIllIlIlllll;
        int lllllllllllllllllIlIlIllIlIlllIl = lllllllllllllllllIlIlIllIlIlllll.getDelta();
        if (!Display.isVisible() && lllllllllllllllllIlIlIllIlIlllll.updateOnlyOnVisible) {
            try {
                Thread.sleep(100L);
            }
            catch (Exception lllllllllllllllllIlIlIllIllIIIll) {}
        } else {
            try {
                lllllllllllllllllIlIlIllIlIlllll.updateAndRender(lllllllllllllllllIlIlIllIlIlllIl);
            }
            catch (SlickException lllllllllllllllllIlIlIllIllIIIIl) {
                Log.error(lllllllllllllllllIlIlIllIllIIIIl);
                lllllllllllllllllIlIlIllIlIlllll.running = false;
                return;
            }
        }
        lllllllllllllllllIlIlIllIlIlllll.updateFPS();
        Display.update();
        if (Display.isCloseRequested() && lllllllllllllllllIlIlIllIlIlllll.game.closeRequested()) {
            lllllllllllllllllIlIlIllIlIlllll.running = false;
        }
    }

    public void destroy() {
        Display.destroy();
        AL.destroy();
    }

    @Override
    public void setUpdateOnlyWhenVisible(boolean lllllllllllllllllIlIlIllIlIIIIll) {
        lllllllllllllllllIlIlIllIlIIIIlI.updateOnlyOnVisible = lllllllllllllllllIlIlIllIlIIIIll;
    }

    @Override
    public void setMouseCursor(ImageData lllllllllllllllllIlIllIIIlIlIIlI, int lllllllllllllllllIlIllIIIlIlIIIl, int lllllllllllllllllIlIllIIIlIlIIll) throws SlickException {
        try {
            Cursor lllllllllllllllllIlIllIIIlIllIII = CursorLoader.get().getCursor(lllllllllllllllllIlIllIIIlIlIIlI, lllllllllllllllllIlIllIIIlIlIIIl, lllllllllllllllllIlIllIIIlIlIIll);
            Mouse.setNativeCursor((Cursor)lllllllllllllllllIlIllIIIlIllIII);
        }
        catch (Throwable lllllllllllllllllIlIllIIIlIlIlll) {
            Log.error("Failed to load and apply cursor.", lllllllllllllllllIlIllIIIlIlIlll);
            throw new SlickException("Failed to set mouse cursor", lllllllllllllllllIlIllIIIlIlIlll);
        }
    }

    private void tryCreateDisplay(PixelFormat lllllllllllllllllIlIlIlllIlIllIl) throws LWJGLException {
        if (SHARED_DRAWABLE == null) {
            Display.create((PixelFormat)lllllllllllllllllIlIlIlllIlIllIl);
        } else {
            Display.create((PixelFormat)lllllllllllllllllIlIlIlllIlIllIl, (Drawable)SHARED_DRAWABLE);
        }
    }

    public AppGameContainer(Game lllllllllllllllllIlIllIIllIllllI, int lllllllllllllllllIlIllIIllIlllIl, int lllllllllllllllllIlIllIIllIlllII, boolean lllllllllllllllllIlIllIIllIllIll) throws SlickException {
        super(lllllllllllllllllIlIllIIllIllllI);
        AppGameContainer lllllllllllllllllIlIllIIllIllIlI;
        lllllllllllllllllIlIllIIllIllIlI.updateOnlyOnVisible = true;
        lllllllllllllllllIlIllIIllIllIlI.alphaSupport = false;
        lllllllllllllllllIlIllIIllIllIlI.originalDisplayMode = Display.getDisplayMode();
        lllllllllllllllllIlIllIIllIllIlI.setDisplayMode(lllllllllllllllllIlIllIIllIlllIl, lllllllllllllllllIlIllIIllIlllII, lllllllllllllllllIlIllIIllIllIll);
    }

    @Override
    public void setMouseCursor(Cursor lllllllllllllllllIlIllIIIIlIllIl, int lllllllllllllllllIlIllIIIIllIIll, int lllllllllllllllllIlIllIIIIlIllll) throws SlickException {
        try {
            Mouse.setNativeCursor((Cursor)lllllllllllllllllIlIllIIIIlIllIl);
        }
        catch (Throwable lllllllllllllllllIlIllIIIIlllIlI) {
            Log.error("Failed to load and apply cursor.", lllllllllllllllllIlIllIIIIlllIlI);
            throw new SlickException("Failed to set mouse cursor", lllllllllllllllllIlIllIIIIlllIlI);
        }
    }

    @Override
    public void setMouseCursor(String lllllllllllllllllIlIllIIIllIllll, int lllllllllllllllllIlIllIIIlllIIIl, int lllllllllllllllllIlIllIIIllIllIl) throws SlickException {
        try {
            Cursor lllllllllllllllllIlIllIIIllllIlI = CursorLoader.get().getCursor(lllllllllllllllllIlIllIIIllIllll, lllllllllllllllllIlIllIIIlllIIIl, lllllllllllllllllIlIllIIIllIllIl);
            Mouse.setNativeCursor((Cursor)lllllllllllllllllIlIllIIIllllIlI);
        }
        catch (Throwable lllllllllllllllllIlIllIIIllllIII) {
            Log.error("Failed to load and apply cursor.", lllllllllllllllllIlIllIIIllllIII);
            throw new SlickException("Failed to set mouse cursor", lllllllllllllllllIlIllIIIllllIII);
        }
    }

    public AppGameContainer(Game lllllllllllllllllIlIllIIlllIlllI) throws SlickException {
        lllllllllllllllllIlIllIIllllIlII(lllllllllllllllllIlIllIIlllIlllI, 640, 480, false);
        AppGameContainer lllllllllllllllllIlIllIIllllIlII;
    }

    @Override
    public void setMouseGrabbed(boolean lllllllllllllllllIlIlIllIIIlIIll) {
        Mouse.setGrabbed((boolean)lllllllllllllllllIlIlIllIIIlIIll);
    }

    public void setDisplayMode(int lllllllllllllllllIlIllIIlIlIlIlI, int lllllllllllllllllIlIllIIlIlIlIII, boolean lllllllllllllllllIlIllIIlIIlllll) throws SlickException {
        AppGameContainer lllllllllllllllllIlIllIIlIlIllII;
        if (lllllllllllllllllIlIllIIlIlIllII.width == lllllllllllllllllIlIllIIlIlIlIlI && lllllllllllllllllIlIllIIlIlIllII.height == lllllllllllllllllIlIllIIlIlIlIII && lllllllllllllllllIlIllIIlIlIllII.isFullscreen() == lllllllllllllllllIlIllIIlIIlllll) {
            return;
        }
        try {
            lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode = null;
            if (lllllllllllllllllIlIllIIlIIlllll) {
                DisplayMode[] lllllllllllllllllIlIllIIlIllIIll = Display.getAvailableDisplayModes();
                int lllllllllllllllllIlIllIIlIllIIII = 0;
                for (int lllllllllllllllllIlIllIIlIllIlII = 0; lllllllllllllllllIlIllIIlIllIlII < lllllllllllllllllIlIllIIlIllIIll.length; ++lllllllllllllllllIlIllIIlIllIlII) {
                    DisplayMode lllllllllllllllllIlIllIIlIllIllI = lllllllllllllllllIlIllIIlIllIIll[lllllllllllllllllIlIllIIlIllIlII];
                    if (lllllllllllllllllIlIllIIlIllIllI.getWidth() != lllllllllllllllllIlIllIIlIlIlIlI || lllllllllllllllllIlIllIIlIllIllI.getHeight() != lllllllllllllllllIlIllIIlIlIlIII) continue;
                    if (!(lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode != null && lllllllllllllllllIlIllIIlIllIllI.getFrequency() < lllllllllllllllllIlIllIIlIllIIII || lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode != null && lllllllllllllllllIlIllIIlIllIllI.getBitsPerPixel() <= lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode.getBitsPerPixel())) {
                        lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode = lllllllllllllllllIlIllIIlIllIllI;
                        lllllllllllllllllIlIllIIlIllIIII = lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode.getFrequency();
                    }
                    if (lllllllllllllllllIlIllIIlIllIllI.getBitsPerPixel() != lllllllllllllllllIlIllIIlIlIllII.originalDisplayMode.getBitsPerPixel() || lllllllllllllllllIlIllIIlIllIllI.getFrequency() != lllllllllllllllllIlIllIIlIlIllII.originalDisplayMode.getFrequency()) continue;
                    lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode = lllllllllllllllllIlIllIIlIllIllI;
                    break;
                }
            } else {
                lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode = new DisplayMode(lllllllllllllllllIlIllIIlIlIlIlI, lllllllllllllllllIlIllIIlIlIlIII);
            }
            if (lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode == null) {
                throw new SlickException(String.valueOf(new StringBuilder().append("Failed to find value mode: ").append(lllllllllllllllllIlIllIIlIlIlIlI).append("x").append(lllllllllllllllllIlIllIIlIlIlIII).append(" fs=").append(lllllllllllllllllIlIllIIlIIlllll)));
            }
            lllllllllllllllllIlIllIIlIlIllII.width = lllllllllllllllllIlIllIIlIlIlIlI;
            lllllllllllllllllIlIllIIlIlIllII.height = lllllllllllllllllIlIllIIlIlIlIII;
            Display.setDisplayMode((DisplayMode)lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode);
            Display.setFullscreen((boolean)lllllllllllllllllIlIllIIlIIlllll);
            if (Display.isCreated()) {
                lllllllllllllllllIlIllIIlIlIllII.initGL();
                lllllllllllllllllIlIllIIlIlIllII.enterOrtho();
            }
            if (lllllllllllllllllIlIllIIlIlIllII.targetDisplayMode.getBitsPerPixel() == 16) {
                InternalTextureLoader.get().set16BitMode();
            }
        }
        catch (LWJGLException lllllllllllllllllIlIllIIlIlIlllI) {
            throw new SlickException(String.valueOf(new StringBuilder().append("Unable to setup mode ").append(lllllllllllllllllIlIllIIlIlIlIlI).append("x").append(lllllllllllllllllIlIllIIlIlIlIII).append(" fullscreen=").append(lllllllllllllllllIlIllIIlIIlllll)), lllllllllllllllllIlIllIIlIlIlllI);
        }
        lllllllllllllllllIlIllIIlIlIllII.getDelta();
    }

    @Override
    public boolean hasFocus() {
        return Display.isActive();
    }

    private int get2Fold(int lllllllllllllllllIlIllIIIIlIIIIl) {
        int lllllllllllllllllIlIllIIIIIlllll;
        for (lllllllllllllllllIlIllIIIIIlllll = 2; lllllllllllllllllIlIllIIIIIlllll < lllllllllllllllllIlIllIIIIlIIIIl; lllllllllllllllllIlIllIIIIIlllll *= 2) {
        }
        return lllllllllllllllllIlIllIIIIIlllll;
    }

    private class NullOutputStream
    extends OutputStream {
        private NullOutputStream() {
            NullOutputStream llIlIlIlIlIlIIl;
        }

        @Override
        public void write(int llIlIlIlIlIIllI) throws IOException {
        }
    }
}

