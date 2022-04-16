/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.input.Cursor
 *  org.lwjgl.input.Mouse
 *  org.lwjgl.opengl.Display
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.PixelFormat
 */
package org.newdawn.slick;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Cursor;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.SoundStore;
import org.newdawn.slick.opengl.CursorLoader;
import org.newdawn.slick.opengl.ImageData;
import org.newdawn.slick.opengl.InternalTextureLoader;
import org.newdawn.slick.util.Log;

public class AppletGameContainer
extends Applet {
    protected /* synthetic */ Canvas displayParent;
    protected /* synthetic */ ContainerPanel canvas;
    protected /* synthetic */ Container container;
    protected /* synthetic */ boolean alphaSupport;
    protected /* synthetic */ Thread gameThread;

    public void startLWJGL() {
        AppletGameContainer llllllllllllllllllIlIllllIIIIllI;
        if (llllllllllllllllllIlIllllIIIIllI.gameThread != null) {
            return;
        }
        llllllllllllllllllIlIllllIIIIllI.gameThread = new Thread(){

            @Override
            public void run() {
                1 lllllllllllllllllIIIIIIIllIlIlll;
                try {
                    lllllllllllllllllIIIIIIIllIlIlll.AppletGameContainer.this.canvas.start();
                }
                catch (Exception lllllllllllllllllIIIIIIIllIllIII) {
                    lllllllllllllllllIIIIIIIllIllIII.printStackTrace();
                    if (Display.isCreated()) {
                        Display.destroy();
                    }
                    lllllllllllllllllIIIIIIIllIlIlll.AppletGameContainer.this.displayParent.setVisible(false);
                    lllllllllllllllllIIIIIIIllIlIlll.AppletGameContainer.this.add(new ConsolePanel(lllllllllllllllllIIIIIIIllIllIII));
                    lllllllllllllllllIIIIIIIllIlIlll.AppletGameContainer.this.validate();
                }
            }
            {
                1 lllllllllllllllllIIIIIIIlllIIllI;
            }
        };
        llllllllllllllllllIlIllllIIIIllI.gameThread.start();
    }

    @Override
    public void destroy() {
        AppletGameContainer llllllllllllllllllIlIllllIIlllII;
        if (llllllllllllllllllIlIllllIIlllII.displayParent != null) {
            llllllllllllllllllIlIllllIIlllII.remove(llllllllllllllllllIlIllllIIlllII.displayParent);
        }
        super.destroy();
        Log.info("Clear up");
    }

    @Override
    public void stop() {
    }

    @Override
    public void start() {
    }

    private void destroyLWJGL() {
        AppletGameContainer llllllllllllllllllIlIllllIIIllII;
        llllllllllllllllllIlIllllIIIllII.container.stopApplet();
        try {
            llllllllllllllllllIlIllllIIIllII.gameThread.join();
        }
        catch (InterruptedException llllllllllllllllllIlIllllIIIlllI) {
            Log.error(llllllllllllllllllIlIllllIIIlllI);
        }
    }

    public GameContainer getContainer() {
        AppletGameContainer llllllllllllllllllIlIlllIllIIllI;
        return llllllllllllllllllIlIlllIllIIllI.container;
    }

    public AppletGameContainer() {
        AppletGameContainer llllllllllllllllllIlIllllIlIIIII;
        llllllllllllllllllIlIllllIlIIIII.alphaSupport = true;
    }

    @Override
    public void init() {
        AppletGameContainer llllllllllllllllllIlIlllIlllIIIl;
        llllllllllllllllllIlIlllIlllIIIl.removeAll();
        llllllllllllllllllIlIlllIlllIIIl.setLayout(new BorderLayout());
        llllllllllllllllllIlIlllIlllIIIl.setIgnoreRepaint(true);
        try {
            Game llllllllllllllllllIlIlllIlllIIll = (Game)Class.forName(llllllllllllllllllIlIlllIlllIIIl.getParameter("game")).newInstance();
            llllllllllllllllllIlIlllIlllIIIl.container = llllllllllllllllllIlIlllIlllIIIl.new Container(llllllllllllllllllIlIlllIlllIIll);
            llllllllllllllllllIlIlllIlllIIIl.canvas = llllllllllllllllllIlIlllIlllIIIl.new ContainerPanel(llllllllllllllllllIlIlllIlllIIIl.container);
            llllllllllllllllllIlIlllIlllIIIl.displayParent = new Canvas(){

                @Override
                public final void removeNotify() {
                    2 lIlllIIlllIII;
                    lIlllIIlllIII.AppletGameContainer.this.destroyLWJGL();
                    super.removeNotify();
                }

                @Override
                public final void addNotify() {
                    2 lIlllIIlllIll;
                    super.addNotify();
                    lIlllIIlllIll.AppletGameContainer.this.startLWJGL();
                }
                {
                    2 lIlllIlIIIIII;
                }
            };
            llllllllllllllllllIlIlllIlllIIIl.displayParent.setSize(llllllllllllllllllIlIlllIlllIIIl.getWidth(), llllllllllllllllllIlIlllIlllIIIl.getHeight());
            llllllllllllllllllIlIlllIlllIIIl.add(llllllllllllllllllIlIlllIlllIIIl.displayParent);
            llllllllllllllllllIlIlllIlllIIIl.displayParent.setFocusable(true);
            llllllllllllllllllIlIlllIlllIIIl.displayParent.requestFocus();
            llllllllllllllllllIlIlllIlllIIIl.displayParent.setIgnoreRepaint(true);
            llllllllllllllllllIlIlllIlllIIIl.setVisible(true);
        }
        catch (Exception llllllllllllllllllIlIlllIlllIIlI) {
            Log.error(llllllllllllllllllIlIlllIlllIIlI);
            throw new RuntimeException("Unable to create game container");
        }
    }

    public class ConsolePanel
    extends Panel {
        /* synthetic */ TextArea textArea;

        public ConsolePanel(Exception llllllllllllllllIlIlIlllllIlIIll) {
            ConsolePanel llllllllllllllllIlIlIlllllIlllIl;
            llllllllllllllllIlIlIlllllIlllIl.textArea = new TextArea();
            llllllllllllllllIlIlIlllllIlllIl.setLayout(new BorderLayout());
            llllllllllllllllIlIlIlllllIlllIl.setBackground(Color.black);
            llllllllllllllllIlIlIlllllIlllIl.setForeground(Color.white);
            Font llllllllllllllllIlIlIlllllIllIll = new Font("Arial", 1, 14);
            Label llllllllllllllllIlIlIlllllIllIlI = new Label("SLICK CONSOLE", 1);
            llllllllllllllllIlIlIlllllIllIlI.setFont(llllllllllllllllIlIlIlllllIllIll);
            llllllllllllllllIlIlIlllllIlllIl.add((Component)llllllllllllllllIlIlIlllllIllIlI, "First");
            StringWriter llllllllllllllllIlIlIlllllIllIIl = new StringWriter();
            llllllllllllllllIlIlIlllllIlIIll.printStackTrace(new PrintWriter(llllllllllllllllIlIlIlllllIllIIl));
            llllllllllllllllIlIlIlllllIlllIl.textArea.setText(llllllllllllllllIlIlIlllllIllIIl.toString());
            llllllllllllllllIlIlIlllllIlllIl.textArea.setEditable(false);
            llllllllllllllllIlIlIlllllIlllIl.add((Component)llllllllllllllllIlIlIlllllIlllIl.textArea, "Center");
            llllllllllllllllIlIlIlllllIlllIl.add((Component)new Panel(), "Before");
            llllllllllllllllIlIlIlllllIlllIl.add((Component)new Panel(), "After");
            Panel llllllllllllllllIlIlIlllllIllIII = new Panel();
            llllllllllllllllIlIlIlllllIllIII.setLayout(new GridLayout(0, 1));
            Label llllllllllllllllIlIlIlllllIlIlll = new Label("An error occured while running the applet.", 1);
            Label llllllllllllllllIlIlIlllllIlIllI = new Label("Plese contact support to resolve this issue.", 1);
            llllllllllllllllIlIlIlllllIlIlll.setFont(llllllllllllllllIlIlIlllllIllIll);
            llllllllllllllllIlIlIlllllIlIllI.setFont(llllllllllllllllIlIlIlllllIllIll);
            llllllllllllllllIlIlIlllllIllIII.add(llllllllllllllllIlIlIlllllIlIlll);
            llllllllllllllllIlIlIlllllIllIII.add(llllllllllllllllIlIlIlllllIlIllI);
            llllllllllllllllIlIlIlllllIlllIl.add((Component)llllllllllllllllIlIlIlllllIllIII, "Last");
        }
    }

    public class ContainerPanel {
        private /* synthetic */ Container container;

        private void createDisplay() throws Exception {
            try {
                Display.create((PixelFormat)new PixelFormat(8, 8, GameContainer.stencil ? 8 : 0));
                lllllllllllllllllllIIIIlllIllllI.AppletGameContainer.this.alphaSupport = true;
            }
            catch (Exception lllllllllllllllllllIIIIlllIlllll) {
                lllllllllllllllllllIIIIlllIllllI.AppletGameContainer.this.alphaSupport = false;
                Display.destroy();
                Display.create();
            }
        }

        public ContainerPanel(Container lllllllllllllllllllIIIIllllIIlIl) {
            ContainerPanel lllllllllllllllllllIIIIllllIIllI;
            lllllllllllllllllllIIIIllllIIllI.container = lllllllllllllllllllIIIIllllIIlIl;
        }

        protected void initGL() {
            ContainerPanel lllllllllllllllllllIIIIlllIIlIlI;
            try {
                InternalTextureLoader.get().clear();
                SoundStore.get().clear();
                lllllllllllllllllllIIIIlllIIlIlI.container.initApplet();
            }
            catch (Exception lllllllllllllllllllIIIIlllIIllll) {
                Log.error(lllllllllllllllllllIIIIlllIIllll);
                lllllllllllllllllllIIIIlllIIlIlI.container.stopApplet();
            }
        }

        public void start() throws Exception {
            ContainerPanel lllllllllllllllllllIIIIlllIllIII;
            Display.setParent((Canvas)lllllllllllllllllllIIIIlllIllIII.AppletGameContainer.this.displayParent);
            Display.setVSyncEnabled((boolean)true);
            try {
                lllllllllllllllllllIIIIlllIllIII.createDisplay();
            }
            catch (LWJGLException lllllllllllllllllllIIIIlllIllIIl) {
                lllllllllllllllllllIIIIlllIllIIl.printStackTrace();
                Thread.sleep(1000L);
                lllllllllllllllllllIIIIlllIllIII.createDisplay();
            }
            lllllllllllllllllllIIIIlllIllIII.initGL();
            lllllllllllllllllllIIIIlllIllIII.AppletGameContainer.this.displayParent.requestFocus();
            lllllllllllllllllllIIIIlllIllIII.container.runloop();
        }
    }

    public class Container
    extends GameContainer {
        @Override
        public void setMouseCursor(Image llllllllllllllllIIIlIIIllIlIlIll, int llllllllllllllllIIIlIIIllIlIIllI, int llllllllllllllllIIIlIIIllIlIlIIl) throws SlickException {
            try {
                Container llllllllllllllllIIIlIIIllIlIlIII;
                Image llllllllllllllllIIIlIIIllIllIIIl = new Image(llllllllllllllllIIIlIIIllIlIlIII.get2Fold(llllllllllllllllIIIlIIIllIlIlIll.getWidth()), llllllllllllllllIIIlIIIllIlIlIII.get2Fold(llllllllllllllllIIIlIIIllIlIlIll.getHeight()));
                Graphics llllllllllllllllIIIlIIIllIllIIII = llllllllllllllllIIIlIIIllIllIIIl.getGraphics();
                ByteBuffer llllllllllllllllIIIlIIIllIlIllll = BufferUtils.createByteBuffer((int)(llllllllllllllllIIIlIIIllIllIIIl.getWidth() * llllllllllllllllIIIlIIIllIllIIIl.getHeight() * 4));
                llllllllllllllllIIIlIIIllIllIIII.drawImage(llllllllllllllllIIIlIIIllIlIlIll.getFlippedCopy(false, true), 0.0f, 0.0f);
                llllllllllllllllIIIlIIIllIllIIII.flush();
                llllllllllllllllIIIlIIIllIllIIII.getArea(0, 0, llllllllllllllllIIIlIIIllIllIIIl.getWidth(), llllllllllllllllIIIlIIIllIllIIIl.getHeight(), llllllllllllllllIIIlIIIllIlIllll);
                Cursor llllllllllllllllIIIlIIIllIlIlllI = CursorLoader.get().getCursor(llllllllllllllllIIIlIIIllIlIllll, llllllllllllllllIIIlIIIllIlIIllI, llllllllllllllllIIIlIIIllIlIlIIl, llllllllllllllllIIIlIIIllIllIIIl.getWidth(), llllllllllllllllIIIlIIIllIllIIIl.getHeight());
                Mouse.setNativeCursor((Cursor)llllllllllllllllIIIlIIIllIlIlllI);
            }
            catch (Throwable llllllllllllllllIIIlIIIllIlIllIl) {
                Log.error("Failed to load and apply cursor.", llllllllllllllllIIIlIIIllIlIllIl);
                throw new SlickException("Failed to set mouse cursor", llllllllllllllllIIIlIIIllIlIllIl);
            }
        }

        private int get2Fold(int llllllllllllllllIIIlIIIlllIIIIIl) {
            int llllllllllllllllIIIlIIIlllIIIIII;
            for (llllllllllllllllIIIlIIIlllIIIIII = 2; llllllllllllllllIIIlIIIlllIIIIII < llllllllllllllllIIIlIIIlllIIIIIl; llllllllllllllllIIIlIIIlllIIIIII *= 2) {
            }
            return llllllllllllllllIIIlIIIlllIIIIII;
        }

        @Override
        public void setMouseGrabbed(boolean llllllllllllllllIIIlIIIllllIIlII) {
            Mouse.setGrabbed((boolean)llllllllllllllllIIIlIIIllllIIlII);
        }

        public Container(Game llllllllllllllllIIIlIIlIIIIlllII) {
            Container llllllllllllllllIIIlIIlIIIIllllI;
            super(llllllllllllllllIIIlIIlIIIIlllII);
            llllllllllllllllIIIlIIlIIIIllllI.width = llllllllllllllllIIIlIIlIIIIllllI.AppletGameContainer.this.getWidth();
            llllllllllllllllIIIlIIlIIIIllllI.height = llllllllllllllllIIIlIIlIIIIllllI.AppletGameContainer.this.getHeight();
        }

        @Override
        public boolean isFullscreen() {
            return Display.isFullscreen();
        }

        @Override
        public int getScreenWidth() {
            return 0;
        }

        @Override
        public void setMouseCursor(ImageData llllllllllllllllIIIlIIIllIIlIlII, int llllllllllllllllIIIlIIIllIIlIIll, int llllllllllllllllIIIlIIIllIIlIlIl) throws SlickException {
            try {
                Cursor llllllllllllllllIIIlIIIllIIllIlI = CursorLoader.get().getCursor(llllllllllllllllIIIlIIIllIIlIlII, llllllllllllllllIIIlIIIllIIlIIll, llllllllllllllllIIIlIIIllIIlIlIl);
                Mouse.setNativeCursor((Cursor)llllllllllllllllIIIlIIIllIIllIlI);
            }
            catch (Throwable llllllllllllllllIIIlIIIllIIllIIl) {
                Log.error("Failed to load and apply cursor.", llllllllllllllllIIIlIIIllIIllIIl);
                throw new SlickException("Failed to set mouse cursor", llllllllllllllllIIIlIIIllIIllIIl);
            }
        }

        public void initApplet() throws SlickException {
            Container llllllllllllllllIIIlIIlIIIIIllII;
            llllllllllllllllIIIlIIlIIIIIllII.initSystem();
            llllllllllllllllIIIlIIlIIIIIllII.enterOrtho();
            try {
                llllllllllllllllIIIlIIlIIIIIllII.getInput().initControllers();
            }
            catch (SlickException llllllllllllllllIIIlIIlIIIIlIIII) {
                Log.info("Controllers not available");
            }
            catch (Throwable llllllllllllllllIIIlIIlIIIIIlllI) {
                Log.info("Controllers not available");
            }
            llllllllllllllllIIIlIIlIIIIIllII.game.init(llllllllllllllllIIIlIIlIIIIIllII);
            llllllllllllllllIIIlIIlIIIIIllII.getDelta();
        }

        @Override
        public void setDefaultMouseCursor() {
        }

        public boolean supportsAlphaInBackBuffer() {
            Container llllllllllllllllIIIlIIIlllllIIlI;
            return llllllllllllllllIIIlIIIlllllIIlI.AppletGameContainer.this.alphaSupport;
        }

        @Override
        public int getScreenHeight() {
            return 0;
        }

        @Override
        public void setIcons(String[] llllllllllllllllIIIlIIIllIIlllll) throws SlickException {
        }

        @Override
        public void setIcon(String llllllllllllllllIIIlIIIllllIllII) throws SlickException {
        }

        @Override
        public boolean isMouseGrabbed() {
            return Mouse.isGrabbed();
        }

        public void stopApplet() {
            llllllllllllllllIIIlIIIllllllIll.running = false;
        }

        @Override
        public void setFullscreen(boolean llllllllllllllllIIIlIIIlIllIllll) throws SlickException {
            Container llllllllllllllllIIIlIIIlIllIlllI;
            if (llllllllllllllllIIIlIIIlIllIllll == llllllllllllllllIIIlIIIlIllIlllI.isFullscreen()) {
                return;
            }
            try {
                if (llllllllllllllllIIIlIIIlIllIllll) {
                    int llllllllllllllllIIIlIIIlIlllIlII;
                    int llllllllllllllllIIIlIIIlIlllIlIl;
                    int llllllllllllllllIIIlIIIlIllllIII;
                    float llllllllllllllllIIIlIIIlIlllIlll = (float)llllllllllllllllIIIlIIIlIllIlllI.width / (float)llllllllllllllllIIIlIIIlIllIlllI.height;
                    int llllllllllllllllIIIlIIIlIllllIIl = Display.getDisplayMode().getWidth();
                    float llllllllllllllllIIIlIIIlIlllIllI = (float)llllllllllllllllIIIlIIIlIllllIIl / (float)(llllllllllllllllIIIlIIIlIllllIII = Display.getDisplayMode().getHeight());
                    if (llllllllllllllllIIIlIIIlIlllIlll >= llllllllllllllllIIIlIIIlIlllIllI) {
                        int llllllllllllllllIIIlIIIlIllllIll = llllllllllllllllIIIlIIIlIllllIIl;
                        int llllllllllllllllIIIlIIIlIllllIlI = (int)((float)llllllllllllllllIIIlIIIlIllIlllI.height / ((float)llllllllllllllllIIIlIIIlIllIlllI.width / (float)llllllllllllllllIIIlIIIlIllllIIl));
                    } else {
                        llllllllllllllllIIIlIIIlIlllIlIl = (int)((float)llllllllllllllllIIIlIIIlIllIlllI.width / ((float)llllllllllllllllIIIlIIIlIllIlllI.height / (float)llllllllllllllllIIIlIIIlIllllIII));
                        llllllllllllllllIIIlIIIlIlllIlII = llllllllllllllllIIIlIIIlIllllIII;
                    }
                    int llllllllllllllllIIIlIIIlIlllIIll = (llllllllllllllllIIIlIIIlIllllIIl - llllllllllllllllIIIlIIIlIlllIlIl) / 2;
                    int llllllllllllllllIIIlIIIlIlllIIlI = (llllllllllllllllIIIlIIIlIllllIII - llllllllllllllllIIIlIIIlIlllIlII) / 2;
                    GL11.glViewport((int)llllllllllllllllIIIlIIIlIlllIIll, (int)llllllllllllllllIIIlIIIlIlllIIlI, (int)llllllllllllllllIIIlIIIlIlllIlIl, (int)llllllllllllllllIIIlIIIlIlllIlII);
                    llllllllllllllllIIIlIIIlIllIlllI.enterOrtho();
                    llllllllllllllllIIIlIIIlIllIlllI.getInput().setOffset((float)(-llllllllllllllllIIIlIIIlIlllIIll) * (float)llllllllllllllllIIIlIIIlIllIlllI.width / (float)llllllllllllllllIIIlIIIlIlllIlIl, (float)(-llllllllllllllllIIIlIIIlIlllIIlI) * (float)llllllllllllllllIIIlIIIlIllIlllI.height / (float)llllllllllllllllIIIlIIIlIlllIlII);
                    llllllllllllllllIIIlIIIlIllIlllI.getInput().setScale((float)llllllllllllllllIIIlIIIlIllIlllI.width / (float)llllllllllllllllIIIlIIIlIlllIlIl, (float)llllllllllllllllIIIlIIIlIllIlllI.height / (float)llllllllllllllllIIIlIIIlIlllIlII);
                    llllllllllllllllIIIlIIIlIllIlllI.width = llllllllllllllllIIIlIIIlIllllIIl;
                    llllllllllllllllIIIlIIIlIllIlllI.height = llllllllllllllllIIIlIIIlIllllIII;
                    Display.setFullscreen((boolean)true);
                } else {
                    llllllllllllllllIIIlIIIlIllIlllI.getInput().setOffset(0.0f, 0.0f);
                    llllllllllllllllIIIlIIIlIllIlllI.getInput().setScale(1.0f, 1.0f);
                    llllllllllllllllIIIlIIIlIllIlllI.width = llllllllllllllllIIIlIIIlIllIlllI.AppletGameContainer.this.getWidth();
                    llllllllllllllllIIIlIIIlIllIlllI.height = llllllllllllllllIIIlIIIlIllIlllI.AppletGameContainer.this.getHeight();
                    GL11.glViewport((int)0, (int)0, (int)llllllllllllllllIIIlIIIlIllIlllI.width, (int)llllllllllllllllIIIlIIIlIllIlllI.height);
                    llllllllllllllllIIIlIIIlIllIlllI.enterOrtho();
                    Display.setFullscreen((boolean)false);
                }
            }
            catch (LWJGLException llllllllllllllllIIIlIIIlIlllIIIl) {
                Log.error(llllllllllllllllIIIlIIIlIlllIIIl);
            }
        }

        public Applet getApplet() {
            Container llllllllllllllllIIIlIIIllllIllll;
            return llllllllllllllllIIIlIIIllllIllll.AppletGameContainer.this;
        }

        public boolean isRunning() {
            Container llllllllllllllllIIIlIIlIIIIIIIll;
            return llllllllllllllllIIIlIIlIIIIIIIll.running;
        }

        public void runloop() throws Exception {
            Container llllllllllllllllIIIlIIIlIllIIIIl;
            while (llllllllllllllllIIIlIIIlIllIIIIl.running) {
                int llllllllllllllllIIIlIIIlIllIIIlI = llllllllllllllllIIIlIIIlIllIIIIl.getDelta();
                llllllllllllllllIIIlIIIlIllIIIIl.updateAndRender(llllllllllllllllIIIlIIIlIllIIIlI);
                llllllllllllllllIIIlIIIlIllIIIIl.updateFPS();
                Display.update();
            }
            Display.destroy();
        }

        @Override
        public void setMouseCursor(String llllllllllllllllIIIlIIIlllIIlllI, int llllllllllllllllIIIlIIIlllIlIIIl, int llllllllllllllllIIIlIIIlllIIllII) throws SlickException {
            try {
                Cursor llllllllllllllllIIIlIIIlllIlIllI = CursorLoader.get().getCursor(llllllllllllllllIIIlIIIlllIIlllI, llllllllllllllllIIIlIIIlllIlIIIl, llllllllllllllllIIIlIIIlllIIllII);
                Mouse.setNativeCursor((Cursor)llllllllllllllllIIIlIIIlllIlIllI);
            }
            catch (Throwable llllllllllllllllIIIlIIIlllIlIlIl) {
                Log.error("Failed to load and apply cursor.", llllllllllllllllIIIlIIIlllIlIlIl);
                throw new SlickException("Failed to set mouse cursor", llllllllllllllllIIIlIIIlllIlIlIl);
            }
        }

        @Override
        public boolean hasFocus() {
            return true;
        }

        @Override
        public void setMouseCursor(Cursor llllllllllllllllIIIlIIIllIIIlIIl, int llllllllllllllllIIIlIIIllIIIlIll, int llllllllllllllllIIIlIIIllIIIlIlI) throws SlickException {
            try {
                Mouse.setNativeCursor((Cursor)llllllllllllllllIIIlIIIllIIIlIIl);
            }
            catch (Throwable llllllllllllllllIIIlIIIllIIIlllI) {
                Log.error("Failed to load and apply cursor.", llllllllllllllllIIIlIIIllIIIlllI);
                throw new SlickException("Failed to set mouse cursor", llllllllllllllllIIIlIIIllIIIlllI);
            }
        }
    }
}

