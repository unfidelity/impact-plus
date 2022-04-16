/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.Sys
 *  org.lwjgl.input.Cursor
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.Drawable
 *  org.lwjgl.opengl.Pbuffer
 *  org.lwjgl.opengl.PixelFormat
 */
package org.newdawn.slick;

import java.io.IOException;
import java.util.Properties;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Cursor;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.Drawable;
import org.lwjgl.opengl.Pbuffer;
import org.lwjgl.opengl.PixelFormat;
import org.newdawn.slick.Font;
import org.newdawn.slick.Game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.InputListener;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.opengl.CursorLoader;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;

public abstract class GameContainer
implements GUIContext {
    protected /* synthetic */ Input input;
    protected /* synthetic */ boolean vsync;
    protected static /* synthetic */ boolean stencil;
    protected /* synthetic */ int fps;
    protected /* synthetic */ boolean forceExit;
    protected /* synthetic */ long storedDelta;
    protected static /* synthetic */ SGL GL;
    protected /* synthetic */ int samples;
    protected /* synthetic */ int width;
    private /* synthetic */ Graphics graphics;
    protected /* synthetic */ int recordedFPS;
    protected /* synthetic */ boolean alwaysRender;
    protected /* synthetic */ boolean supportsMultiSample;
    protected /* synthetic */ boolean smoothDeltas;
    protected /* synthetic */ long maximumLogicInterval;
    protected /* synthetic */ Game lastGame;
    protected /* synthetic */ boolean paused;
    protected /* synthetic */ Game game;
    private /* synthetic */ boolean showFPS;
    protected /* synthetic */ boolean running;
    protected static /* synthetic */ Drawable SHARED_DRAWABLE;
    protected /* synthetic */ int height;
    protected /* synthetic */ int targetFPS;
    private /* synthetic */ Font defaultFont;
    protected /* synthetic */ boolean clearEachFrame;
    protected /* synthetic */ long lastFPS;
    protected /* synthetic */ long lastFrame;
    protected /* synthetic */ long minimumLogicInterval;

    @Override
    public abstract void setDefaultMouseCursor();

    @Override
    public abstract int getScreenHeight();

    public void setMaximumLogicUpdateInterval(int lllllllllllllllIlllllIIIllIIIlIl) {
        lllllllllllllllIlllllIIIllIIIlII.maximumLogicInterval = lllllllllllllllIlllllIIIllIIIlIl;
    }

    public void setForceExit(boolean lllllllllllllllIlllllIIlIlIllIlI) {
        lllllllllllllllIlllllIIlIlIllIll.forceExit = lllllllllllllllIlllllIIlIlIllIlI;
    }

    public boolean getAlwaysRender() {
        GameContainer lllllllllllllllIlllllIIlIIllIIlI;
        return lllllllllllllllIlllllIIlIIllIIlI.alwaysRender;
    }

    public Graphics getGraphics() {
        GameContainer lllllllllllllllIlllllIIIIlIlIIII;
        return lllllllllllllllIlllllIIIIlIlIIII.graphics;
    }

    protected void updateAndRender(int lllllllllllllllIlllllIIIlIllIllI) throws SlickException {
        GameContainer lllllllllllllllIlllllIIIlIlllIIl;
        if (lllllllllllllllIlllllIIIlIlllIIl.smoothDeltas && lllllllllllllllIlllllIIIlIlllIIl.getFPS() != 0) {
            lllllllllllllllIlllllIIIlIllIllI = 1000 / lllllllllllllllIlllllIIIlIlllIIl.getFPS();
        }
        lllllllllllllllIlllllIIIlIlllIIl.input.poll(lllllllllllllllIlllllIIIlIlllIIl.width, lllllllllllllllIlllllIIIlIlllIIl.height);
        Music.poll(lllllllllllllllIlllllIIIlIllIllI);
        if (!lllllllllllllllIlllllIIIlIlllIIl.paused) {
            lllllllllllllllIlllllIIIlIlllIIl.storedDelta += (long)lllllllllllllllIlllllIIIlIllIllI;
            if (lllllllllllllllIlllllIIIlIlllIIl.storedDelta >= lllllllllllllllIlllllIIIlIlllIIl.minimumLogicInterval) {
                try {
                    if (lllllllllllllllIlllllIIIlIlllIIl.maximumLogicInterval != 0L) {
                        long lllllllllllllllIlllllIIIlIllllIl = lllllllllllllllIlllllIIIlIlllIIl.storedDelta / lllllllllllllllIlllllIIIlIlllIIl.maximumLogicInterval;
                        int lllllllllllllllIlllllIIIlIlllllI = 0;
                        while ((long)lllllllllllllllIlllllIIIlIlllllI < lllllllllllllllIlllllIIIlIllllIl) {
                            lllllllllllllllIlllllIIIlIlllIIl.game.update(lllllllllllllllIlllllIIIlIlllIIl, (int)lllllllllllllllIlllllIIIlIlllIIl.maximumLogicInterval);
                            ++lllllllllllllllIlllllIIIlIlllllI;
                        }
                        int lllllllllllllllIlllllIIIlIllllII = (int)(lllllllllllllllIlllllIIIlIlllIIl.storedDelta % lllllllllllllllIlllllIIIlIlllIIl.maximumLogicInterval);
                        if ((long)lllllllllllllllIlllllIIIlIllllII > lllllllllllllllIlllllIIIlIlllIIl.minimumLogicInterval) {
                            lllllllllllllllIlllllIIIlIlllIIl.game.update(lllllllllllllllIlllllIIIlIlllIIl, (int)((long)lllllllllllllllIlllllIIIlIllllII % lllllllllllllllIlllllIIIlIlllIIl.maximumLogicInterval));
                            lllllllllllllllIlllllIIIlIlllIIl.storedDelta = 0L;
                        }
                        lllllllllllllllIlllllIIIlIlllIIl.storedDelta = lllllllllllllllIlllllIIIlIllllII;
                    }
                    lllllllllllllllIlllllIIIlIlllIIl.game.update(lllllllllllllllIlllllIIIlIlllIIl, (int)lllllllllllllllIlllllIIIlIlllIIl.storedDelta);
                    lllllllllllllllIlllllIIIlIlllIIl.storedDelta = 0L;
                }
                catch (Throwable lllllllllllllllIlllllIIIlIlllIll) {
                    Log.error(lllllllllllllllIlllllIIIlIlllIll);
                    throw new SlickException("Game.update() failure - check the game code.");
                }
            }
        } else {
            lllllllllllllllIlllllIIIlIlllIIl.game.update(lllllllllllllllIlllllIIIlIlllIIl, 0);
        }
        if (lllllllllllllllIlllllIIIlIlllIIl.hasFocus() || lllllllllllllllIlllllIIIlIlllIIl.getAlwaysRender()) {
            if (lllllllllllllllIlllllIIIlIlllIIl.clearEachFrame) {
                GL.glClear(16640);
            }
            GL.glLoadIdentity();
            lllllllllllllllIlllllIIIlIlllIIl.graphics.resetTransform();
            lllllllllllllllIlllllIIIlIlllIIl.graphics.resetFont();
            lllllllllllllllIlllllIIIlIlllIIl.graphics.resetLineWidth();
            lllllllllllllllIlllllIIIlIlllIIl.graphics.setAntiAlias(false);
            try {
                lllllllllllllllIlllllIIIlIlllIIl.game.render(lllllllllllllllIlllllIIIlIlllIIl, lllllllllllllllIlllllIIIlIlllIIl.graphics);
            }
            catch (Throwable lllllllllllllllIlllllIIIlIlllIlI) {
                Log.error(lllllllllllllllIlllllIIIlIlllIlI);
                throw new SlickException("Game.render() failure - check the game code.");
            }
            lllllllllllllllIlllllIIIlIlllIIl.graphics.resetTransform();
            if (lllllllllllllllIlllllIIIlIlllIIl.showFPS) {
                lllllllllllllllIlllllIIIlIlllIIl.defaultFont.drawString(10.0f, 10.0f, String.valueOf(new StringBuilder().append("FPS: ").append(lllllllllllllllIlllllIIIlIlllIIl.recordedFPS)));
            }
            GL.flush();
        }
        if (lllllllllllllllIlllllIIIlIlllIIl.targetFPS != -1) {
            Display.sync((int)lllllllllllllllIlllllIIIlIlllIIl.targetFPS);
        }
    }

    @Override
    public int getWidth() {
        GameContainer lllllllllllllllIlllllIIlIIIIllII;
        return lllllllllllllllIlllllIIlIIIIllII.width;
    }

    public void setMultiSample(int lllllllllllllllIlllllIIlIllIlIII) {
        lllllllllllllllIlllllIIlIllIlIIl.samples = lllllllllllllllIlllllIIlIllIlIII;
    }

    public boolean isSoundOn() {
        return SoundStore.get().soundsOn();
    }

    @Override
    public abstract void setMouseCursor(Cursor var1, int var2, int var3) throws SlickException;

    public boolean isPaused() {
        GameContainer lllllllllllllllIlllllIIlIIlllIll;
        return lllllllllllllllIlllllIIlIIlllIll.paused;
    }

    public void setVSync(boolean lllllllllllllllIlllllIIIIlllIIlI) {
        lllllllllllllllIlllllIIIIlllIlIl.vsync = lllllllllllllllIlllllIIIIlllIIlI;
        Display.setVSyncEnabled((boolean)lllllllllllllllIlllllIIIIlllIIlI);
    }

    public int getSamples() {
        GameContainer lllllllllllllllIlllllIIlIllIIIIl;
        return lllllllllllllllIlllllIIlIllIIIIl.samples;
    }

    static {
        GL = Renderer.get();
    }

    public abstract boolean hasFocus();

    public void setMinimumLogicUpdateInterval(int lllllllllllllllIlllllIIIllIIlIll) {
        lllllllllllllllIlllllIIIllIIllII.minimumLogicInterval = lllllllllllllllIlllllIIIllIIlIll;
    }

    public void setSmoothDeltas(boolean lllllllllllllllIlllllIIlIlIlIllI) {
        lllllllllllllllIlllllIIlIlIlIlIl.smoothDeltas = lllllllllllllllIlllllIIlIlIlIllI;
    }

    public static Drawable getSharedContext() {
        return SHARED_DRAWABLE;
    }

    public void setSoundOn(boolean lllllllllllllllIlllllIIlIIIllIIl) {
        SoundStore.get().setSoundsOn(lllllllllllllllIlllllIIlIIIllIIl);
    }

    @Override
    public Input getInput() {
        GameContainer lllllllllllllllIlllllIIIllIlllll;
        return lllllllllllllllIlllllIIIllIlllll.input;
    }

    public boolean isFullscreen() {
        return false;
    }

    public abstract void setMouseGrabbed(boolean var1);

    public void setClearEachFrame(boolean lllllllllllllllIlllllIIlIlIIIlIl) {
        lllllllllllllllIlllllIIlIlIIIllI.clearEachFrame = lllllllllllllllIlllllIIlIlIIIlIl;
    }

    public void setTargetFrameRate(int lllllllllllllllIlllllIIIIlllllIl) {
        lllllllllllllllIlllllIIIIllllllI.targetFPS = lllllllllllllllIlllllIIIIlllllIl;
    }

    @Override
    public long getTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    @Override
    public int getHeight() {
        GameContainer lllllllllllllllIlllllIIlIIIIlIIl;
        return lllllllllllllllIlllllIIlIIIIlIIl.height;
    }

    public boolean isUpdatingOnlyWhenVisible() {
        return true;
    }

    public void setMusicVolume(float lllllllllllllllIlllllIIlIIIIllll) {
        SoundStore.get().setMusicVolume(lllllllllllllllIlllllIIlIIIIllll);
    }

    public static void enableSharedContext() throws SlickException {
        try {
            SHARED_DRAWABLE = new Pbuffer(64, 64, new PixelFormat(8, 0, 0), null);
        }
        catch (LWJGLException lllllllllllllllIlllllIIlIlIIllII) {
            throw new SlickException("Unable to create the pbuffer used for shard context, buffers not supported", lllllllllllllllIlllllIIlIlIIllII);
        }
    }

    public void setAlwaysRender(boolean lllllllllllllllIlllllIIlIIlIllII) {
        lllllllllllllllIlllllIIlIIlIllll.alwaysRender = lllllllllllllllIlllllIIlIIlIllII;
    }

    public void resume() {
        GameContainer lllllllllllllllIlllllIIlIIlllllI;
        lllllllllllllllIlllllIIlIIlllllI.setPaused(false);
    }

    @Override
    public abstract int getScreenWidth();

    protected boolean running() {
        GameContainer lllllllllllllllIlllllIIIIllIIlIl;
        return lllllllllllllllIlllllIIIIllIIlIl.running;
    }

    public boolean isShowingFPS() {
        GameContainer lllllllllllllllIlllllIIIlIIIIllI;
        return lllllllllllllllIlllllIIIlIIIIllI.showFPS;
    }

    public void reinit() throws SlickException {
    }

    public void setPaused(boolean lllllllllllllllIlllllIIlIIllIlIl) {
        lllllllllllllllIlllllIIlIIlllIII.paused = lllllllllllllllIlllllIIlIIllIlIl;
    }

    protected GameContainer(Game lllllllllllllllIlllllIIlIlllIlII) {
        GameContainer lllllllllllllllIlllllIIlIlllIIll;
        lllllllllllllllIlllllIIlIlllIIll.running = true;
        lllllllllllllllIlllllIIlIlllIIll.targetFPS = -1;
        lllllllllllllllIlllllIIlIlllIIll.showFPS = true;
        lllllllllllllllIlllllIIlIlllIIll.minimumLogicInterval = 1L;
        lllllllllllllllIlllllIIlIlllIIll.maximumLogicInterval = 0L;
        lllllllllllllllIlllllIIlIlllIIll.clearEachFrame = true;
        lllllllllllllllIlllllIIlIlllIIll.forceExit = true;
        lllllllllllllllIlllllIIlIlllIIll.game = lllllllllllllllIlllllIIlIlllIlII;
        lllllllllllllllIlllllIIlIlllIIll.lastFrame = lllllllllllllllIlllllIIlIlllIIll.getTime();
        GameContainer.getBuildVersion();
        Log.checkVerboseLogSetting();
    }

    public void setDefaultFont(Font lllllllllllllllIlllllIIlIllIllII) {
        if (lllllllllllllllIlllllIIlIllIllII != null) {
            lllllllllllllllIlllllIIlIllIllIl.defaultFont = lllllllllllllllIlllllIIlIllIllII;
        } else {
            Log.warn("Please provide a non null font");
        }
    }

    public void setMusicOn(boolean lllllllllllllllIlllllIIlIIIlllIl) {
        SoundStore.get().setMusicOn(lllllllllllllllIlllllIIlIIIlllIl);
    }

    public void setVerbose(boolean lllllllllllllllIlllllIIIIllIIIII) {
        Log.setVerbose(lllllllllllllllIlllllIIIIllIIIII);
    }

    public void pause() {
        GameContainer lllllllllllllllIlllllIIlIlIIIIlI;
        lllllllllllllllIlllllIIlIlIIIIlI.setPaused(true);
    }

    public float getMusicVolume() {
        return SoundStore.get().getMusicVolume();
    }

    public void setShowFPS(boolean lllllllllllllllIlllllIIIlIIIlllI) {
        lllllllllllllllIlllllIIIlIIlIIII.showFPS = lllllllllllllllIlllllIIIlIIIlllI;
    }

    public boolean isMusicOn() {
        return SoundStore.get().musicOn();
    }

    public abstract void setIcon(String var1) throws SlickException;

    protected void updateFPS() {
        GameContainer lllllllllllllllIlllllIIIllIlIIII;
        if (lllllllllllllllIlllllIIIllIlIIII.getTime() - lllllllllllllllIlllllIIIllIlIIII.lastFPS > 1000L) {
            lllllllllllllllIlllllIIIllIlIIII.lastFPS = lllllllllllllllIlllllIIIllIlIIII.getTime();
            lllllllllllllllIlllllIIIllIlIIII.recordedFPS = lllllllllllllllIlllllIIIllIlIIII.fps;
            lllllllllllllllIlllllIIIllIlIIII.fps = 0;
        }
        ++lllllllllllllllIlllllIIIllIlIIII.fps;
    }

    public void exit() {
        lllllllllllllllIlllllIIIIlIlIllI.running = false;
    }

    protected void enterOrtho() {
        GameContainer lllllllllllllllIlllllIIIlIIllIII;
        lllllllllllllllIlllllIIIlIIllIII.enterOrtho(lllllllllllllllIlllllIIIlIIllIII.width, lllllllllllllllIlllllIIIlIIllIII.height);
    }

    public void setAnimatedMouseCursor(String lllllllllllllllIlllllIIIlllIlllI, int lllllllllllllllIlllllIIIlllIllIl, int lllllllllllllllIlllllIIIlllIIlIl, int lllllllllllllllIlllllIIIlllIlIll, int lllllllllllllllIlllllIIIlllIIIll, int[] lllllllllllllllIlllllIIIlllIlIIl) throws SlickException {
        try {
            GameContainer lllllllllllllllIlllllIIIlllIllll;
            Cursor lllllllllllllllIlllllIIIllllIIlI = CursorLoader.get().getAnimatedCursor(lllllllllllllllIlllllIIIlllIlllI, lllllllllllllllIlllllIIIlllIllIl, lllllllllllllllIlllllIIIlllIIlIl, lllllllllllllllIlllllIIIlllIlIll, lllllllllllllllIlllllIIIlllIIIll, lllllllllllllllIlllllIIIlllIlIIl);
            lllllllllllllllIlllllIIIlllIllll.setMouseCursor(lllllllllllllllIlllllIIIllllIIlI, lllllllllllllllIlllllIIIlllIllIl, lllllllllllllllIlllllIIIlllIIlIl);
        }
        catch (IOException lllllllllllllllIlllllIIIllllIIIl) {
            throw new SlickException("Failed to set mouse cursor", lllllllllllllllIlllllIIIllllIIIl);
        }
        catch (LWJGLException lllllllllllllllIlllllIIIllllIIII) {
            throw new SlickException("Failed to set mouse cursor", lllllllllllllllIlllllIIIllllIIII);
        }
    }

    public boolean supportsMultiSample() {
        GameContainer lllllllllllllllIlllllIIlIllIIIll;
        return lllllllllllllllIlllllIIlIllIIIll.supportsMultiSample;
    }

    public float getSoundVolume() {
        return SoundStore.get().getSoundVolume();
    }

    protected void initSystem() throws SlickException {
        GameContainer lllllllllllllllIlllllIIIlIIllllI;
        lllllllllllllllIlllllIIIlIIllllI.initGL();
        lllllllllllllllIlllllIIIlIIllllI.setMusicVolume(1.0f);
        lllllllllllllllIlllllIIIlIIllllI.setSoundVolume(1.0f);
        lllllllllllllllIlllllIIIlIIllllI.graphics = new Graphics(lllllllllllllllIlllllIIIlIIllllI.width, lllllllllllllllIlllllIIIlIIllllI.height);
        lllllllllllllllIlllllIIIlIIllllI.defaultFont = lllllllllllllllIlllllIIIlIIllllI.graphics.getFont();
    }

    public void setSoundVolume(float lllllllllllllllIlllllIIlIIIlIIlI) {
        SoundStore.get().setSoundVolume(lllllllllllllllIlllllIIlIIIlIIlI);
    }

    public abstract void setMouseCursor(Image var1, int var2, int var3) throws SlickException;

    public abstract void setIcons(String[] var1) throws SlickException;

    public abstract boolean isMouseGrabbed();

    public void setUpdateOnlyWhenVisible(boolean lllllllllllllllIlllllIIIlIllIIlI) {
    }

    public float getAspectRatio() {
        GameContainer lllllllllllllllIlllllIIlIlIlIIII;
        return lllllllllllllllIlllllIIlIlIlIIII.getWidth() / lllllllllllllllIlllllIIlIlIlIIII.getHeight();
    }

    public static int getBuildVersion() {
        try {
            Properties lllllllllllllllIlllllIIlIIlIlIIl = new Properties();
            lllllllllllllllIlllllIIlIIlIlIIl.load(ResourceLoader.getResourceAsStream("version"));
            int lllllllllllllllIlllllIIlIIlIlIII = Integer.parseInt(lllllllllllllllIlllllIIlIIlIlIIl.getProperty("build"));
            Log.info(String.valueOf(new StringBuilder().append("Slick Build #").append(lllllllllllllllIlllllIIlIIlIlIII)));
            return lllllllllllllllIlllllIIlIIlIlIII;
        }
        catch (Exception lllllllllllllllIlllllIIlIIlIIlll) {
            Log.error("Unable to determine Slick build number");
            return -1;
        }
    }

    protected void enterOrtho(int lllllllllllllllIlllllIIIIlIIIlIl, int lllllllllllllllIlllllIIIIlIIIIll) {
        GL.enterOrtho(lllllllllllllllIlllllIIIIlIIIlIl, lllllllllllllllIlllllIIIIlIIIIll);
    }

    public static void enableStencil() {
        stencil = true;
    }

    @Override
    public Font getDefaultFont() {
        GameContainer lllllllllllllllIlllllIIlIIlIIIlI;
        return lllllllllllllllIlllllIIlIIlIIIlI.defaultFont;
    }

    @Override
    public abstract void setMouseCursor(ImageData var1, int var2, int var3) throws SlickException;

    protected int getDelta() {
        GameContainer lllllllllllllllIlllllIIIllIlIlll;
        long lllllllllllllllIlllllIIIllIlIllI = lllllllllllllllIlllllIIIllIlIlll.getTime();
        int lllllllllllllllIlllllIIIllIlIlIl = (int)(lllllllllllllllIlllllIIIllIlIllI - lllllllllllllllIlllllIIIllIlIlll.lastFrame);
        lllllllllllllllIlllllIIIllIlIlll.lastFrame = lllllllllllllllIlllllIIIllIlIllI;
        return lllllllllllllllIlllllIIIllIlIlIl;
    }

    public int getFPS() {
        GameContainer lllllllllllllllIlllllIIIllIllIll;
        return lllllllllllllllIlllllIIIllIllIll.recordedFPS;
    }

    protected void initGL() {
        GameContainer lllllllllllllllIlllllIIIlIlIlIII;
        Log.info(String.valueOf(new StringBuilder().append("Starting display ").append(lllllllllllllllIlllllIIIlIlIlIII.width).append("x").append(lllllllllllllllIlllllIIIlIlIlIII.height)));
        GL.initDisplay(lllllllllllllllIlllllIIIlIlIlIII.width, lllllllllllllllIlllllIIIlIlIlIII.height);
        if (lllllllllllllllIlllllIIIlIlIlIII.input == null) {
            lllllllllllllllIlllllIIIlIlIlIII.input = new Input(lllllllllllllllIlllllIIIlIlIlIII.height);
        }
        lllllllllllllllIlllllIIIlIlIlIII.input.init(lllllllllllllllIlllllIIIlIlIlIII.height);
        if (lllllllllllllllIlllllIIIlIlIlIII.game instanceof InputListener) {
            lllllllllllllllIlllllIIIlIlIlIII.input.removeListener((InputListener)((Object)lllllllllllllllIlllllIIIlIlIlIII.game));
            lllllllllllllllIlllllIIIlIlIlIII.input.addListener((InputListener)((Object)lllllllllllllllIlllllIIIlIlIlIII.game));
        }
        if (lllllllllllllllIlllllIIIlIlIlIII.graphics != null) {
            lllllllllllllllIlllllIIIlIlIlIII.graphics.setDimensions(lllllllllllllllIlllllIIIlIlIlIII.getWidth(), lllllllllllllllIlllllIIIlIlIlIII.getHeight());
        }
        lllllllllllllllIlllllIIIlIlIlIII.lastGame = lllllllllllllllIlllllIIIlIlIlIII.game;
    }

    public void sleep(int lllllllllllllllIlllllIIlIIIIIIII) {
        GameContainer lllllllllllllllIlllllIIlIIIIIIIl;
        long lllllllllllllllIlllllIIIllllllll = lllllllllllllllIlllllIIlIIIIIIIl.getTime() + (long)lllllllllllllllIlllllIIlIIIIIIII;
        while (lllllllllllllllIlllllIIlIIIIIIIl.getTime() < lllllllllllllllIlllllIIIllllllll) {
            try {
                Thread.sleep(1L);
            }
            catch (Exception lllllllllllllllIlllllIIlIIIIIIlI) {}
        }
    }

    public void setFullscreen(boolean lllllllllllllllIlllllIIlIlIIlllI) throws SlickException {
    }

    @Override
    public abstract void setMouseCursor(String var1, int var2, int var3) throws SlickException;

    public boolean isVSyncRequested() {
        GameContainer lllllllllllllllIlllllIIIIllIllIl;
        return lllllllllllllllIlllllIIIIllIllIl.vsync;
    }
}

