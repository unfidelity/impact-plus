/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.LWJGLException
 *  org.lwjgl.opengl.Display
 */
package org.newdawn.slick;

import java.awt.Canvas;
import javax.swing.SwingUtilities;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.util.Log;

public class CanvasGameContainer
extends Canvas {
    protected /* synthetic */ Container container;
    protected /* synthetic */ Game game;

    public CanvasGameContainer(Game llllllllllllllllIIIIllIlllllIlIl) throws SlickException {
        llllllllllllllllIIIIllIlllllIllI(llllllllllllllllIIIIllIlllllIlIl, false);
        CanvasGameContainer llllllllllllllllIIIIllIlllllIllI;
    }

    public CanvasGameContainer(Game llllllllllllllllIIIIllIllllIlllI, boolean llllllllllllllllIIIIllIllllIlIlI) throws SlickException {
        CanvasGameContainer llllllllllllllllIIIIllIllllIllII;
        llllllllllllllllIIIIllIllllIllII.game = llllllllllllllllIIIIllIllllIlllI;
        llllllllllllllllIIIIllIllllIllII.setIgnoreRepaint(true);
        llllllllllllllllIIIIllIllllIllII.requestFocus();
        llllllllllllllllIIIIllIllllIllII.setSize(500, 500);
        llllllllllllllllIIIIllIllllIllII.container = llllllllllllllllIIIIllIllllIllII.new Container(llllllllllllllllIIIIllIllllIlllI, llllllllllllllllIIIIllIllllIlIlI);
        llllllllllllllllIIIIllIllllIllII.container.setForceExit(false);
    }

    private void scheduleUpdate() {
        CanvasGameContainer llllllllllllllllIIIIllIllllIIlII;
        if (!llllllllllllllllIIIIllIllllIIlII.isVisible()) {
            return;
        }
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                2 lllllllllllllllIllllIlIIllIIlIll;
                try {
                    lllllllllllllllIllllIlIIllIIlIll.CanvasGameContainer.this.container.gameLoop();
                }
                catch (SlickException lllllllllllllllIllllIlIIllIIllII) {
                    lllllllllllllllIllllIlIIllIIllII.printStackTrace();
                }
                lllllllllllllllIllllIlIIllIIlIll.CanvasGameContainer.this.container.checkDimensions();
                lllllllllllllllIllllIlIIllIIlIll.CanvasGameContainer.this.scheduleUpdate();
            }
            {
                2 lllllllllllllllIllllIlIIllIlIlIl;
            }
        });
    }

    public void dispose() {
    }

    public void start() throws SlickException {
        CanvasGameContainer llllllllllllllllIIIIllIllllIlIII;
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    1 llllllllllllllllIIlllllIIlIlIlII;
                    Input.disableControllers();
                    try {
                        Display.setParent((Canvas)llllllllllllllllIIlllllIIlIlIlII.CanvasGameContainer.this);
                    }
                    catch (LWJGLException llllllllllllllllIIlllllIIlIlIllI) {
                        throw new SlickException("Failed to setParent of canvas", llllllllllllllllIIlllllIIlIlIllI);
                    }
                    llllllllllllllllIIlllllIIlIlIlII.CanvasGameContainer.this.container.setup();
                    llllllllllllllllIIlllllIIlIlIlII.CanvasGameContainer.this.scheduleUpdate();
                }
                catch (SlickException llllllllllllllllIIlllllIIlIlIlIl) {
                    llllllllllllllllIIlllllIIlIlIlIl.printStackTrace();
                    System.exit(0);
                }
            }
            {
                1 llllllllllllllllIIlllllIIlIllIlI;
            }
        });
    }

    public GameContainer getContainer() {
        CanvasGameContainer llllllllllllllllIIIIllIllllIIIII;
        return llllllllllllllllIIIIllIllllIIIII.container;
    }

    private class Container
    extends AppGameContainer {
        public void checkDimensions() {
            Container llllllllllllllllIIIIIIIIIllIlIll;
            if (llllllllllllllllIIIIIIIIIllIlIll.width != llllllllllllllllIIIIIIIIIllIlIll.CanvasGameContainer.this.getWidth() || llllllllllllllllIIIIIIIIIllIlIll.height != llllllllllllllllIIIIIIIIIllIlIll.CanvasGameContainer.this.getHeight()) {
                try {
                    llllllllllllllllIIIIIIIIIllIlIll.setDisplayMode(llllllllllllllllIIIIIIIIIllIlIll.CanvasGameContainer.this.getWidth(), llllllllllllllllIIIIIIIIIllIlIll.CanvasGameContainer.this.getHeight(), false);
                }
                catch (SlickException llllllllllllllllIIIIIIIIIllIllII) {
                    Log.error(llllllllllllllllIIIIIIIIIllIllII);
                }
            }
        }

        @Override
        protected boolean running() {
            Container llllllllllllllllIIIIIIIIIlllIllI;
            return super.running() && llllllllllllllllIIIIIIIIIlllIllI.CanvasGameContainer.this.isDisplayable();
        }

        @Override
        protected void updateFPS() {
            Container llllllllllllllllIIIIIIIIIllllIII;
            super.updateFPS();
        }

        @Override
        public int getWidth() {
            Container llllllllllllllllIIIIIIIIIlllIIII;
            return llllllllllllllllIIIIIIIIIlllIIII.CanvasGameContainer.this.getWidth();
        }

        @Override
        public int getHeight() {
            Container llllllllllllllllIIIIIIIIIlllIIll;
            return llllllllllllllllIIIIIIIIIlllIIll.CanvasGameContainer.this.getHeight();
        }

        public Container(Game llllllllllllllllIIIIIIIIlIIIIIII, boolean llllllllllllllllIIIIIIIIIllllIll) throws SlickException {
            Container llllllllllllllllIIIIIIIIIllllllI;
            super(llllllllllllllllIIIIIIIIlIIIIIII, llllllllllllllllIIIIIIIIIllllllI.CanvasGameContainer.this.getWidth(), llllllllllllllllIIIIIIIIIllllllI.CanvasGameContainer.this.getHeight(), false);
            llllllllllllllllIIIIIIIIIllllllI.width = llllllllllllllllIIIIIIIIIllllllI.CanvasGameContainer.this.getWidth();
            llllllllllllllllIIIIIIIIIllllllI.height = llllllllllllllllIIIIIIIIIllllllI.CanvasGameContainer.this.getHeight();
            if (llllllllllllllllIIIIIIIIIllllIll) {
                Container.enableSharedContext();
            }
        }
    }
}

