/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.Sys
 */
package org.newdawn.slick;

import java.util.ArrayList;
import org.lwjgl.Sys;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.Renderable;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.util.Log;

public class Animation
implements Renderable {
    private /* synthetic */ boolean stopped;
    private /* synthetic */ boolean loop;
    private /* synthetic */ int direction;
    private /* synthetic */ long nextChange;
    private /* synthetic */ int currentFrame;
    private /* synthetic */ boolean firstUpdate;
    private /* synthetic */ long timeLeft;
    private /* synthetic */ boolean pingPong;
    private /* synthetic */ int stopAt;
    private /* synthetic */ ArrayList frames;
    private /* synthetic */ boolean autoUpdate;
    private /* synthetic */ SpriteSheet spriteSheet;
    private /* synthetic */ float speed;
    private /* synthetic */ long lastUpdate;

    public Animation() {
        lllIIlIIl(true);
        Animation lllIIlIIl;
    }

    public Image getImage(int lllIII) {
        Animation llIllI;
        Frame llIlll = (Frame)llIllI.frames.get(lllIII);
        return llIlll.image;
    }

    public void setLooping(boolean lllI) {
        llII.loop = lllI;
    }

    public Animation copy() {
        Animation llllllllllllllllllllllllllIlIIII;
        Animation llllllllllllllllllllllllllIIllll = new Animation();
        llllllllllllllllllllllllllIIllll.spriteSheet = llllllllllllllllllllllllllIlIIII.spriteSheet;
        llllllllllllllllllllllllllIIllll.frames = llllllllllllllllllllllllllIlIIII.frames;
        llllllllllllllllllllllllllIIllll.autoUpdate = llllllllllllllllllllllllllIlIIII.autoUpdate;
        llllllllllllllllllllllllllIIllll.direction = llllllllllllllllllllllllllIlIIII.direction;
        llllllllllllllllllllllllllIIllll.loop = llllllllllllllllllllllllllIlIIII.loop;
        llllllllllllllllllllllllllIIllll.pingPong = llllllllllllllllllllllllllIlIIII.pingPong;
        llllllllllllllllllllllllllIIllll.speed = llllllllllllllllllllllllllIlIIII.speed;
        return llllllllllllllllllllllllllIIllll;
    }

    public void setSpeed(float lllIllIl) {
        if (lllIllIl > 0.0f) {
            Animation lllIlllI;
            lllIlllI.nextChange = (long)((float)lllIlllI.nextChange * lllIlllI.speed / lllIllIl);
            lllIlllI.speed = lllIllIl;
        }
    }

    @Override
    public void draw(float llIIIIII, float llIIIIll, Color llIIIIlI) {
        Animation llIIIIIl;
        llIIIIIl.draw(llIIIIII, llIIIIll, llIIIIIl.getWidth(), llIIIIIl.getHeight(), llIIIIlI);
    }

    public void setPingPong(boolean llllIlII) {
        llllIlIl.pingPong = llllIlII;
    }

    public String toString() {
        Animation llllllllllllllllllllllllllIllIII;
        String llllllllllllllllllllllllllIlIlll = String.valueOf(new StringBuilder().append("[Animation (").append(llllllllllllllllllllllllllIllIII.frames.size()).append(") "));
        for (int llllllllllllllllllllllllllIllIIl = 0; llllllllllllllllllllllllllIllIIl < llllllllllllllllllllllllllIllIII.frames.size(); ++llllllllllllllllllllllllllIllIIl) {
            Frame llllllllllllllllllllllllllIllIlI = (Frame)llllllllllllllllllllllllllIllIII.frames.get(llllllllllllllllllllllllllIllIIl);
            llllllllllllllllllllllllllIlIlll = String.valueOf(new StringBuilder().append(llllllllllllllllllllllllllIlIlll).append(llllllllllllllllllllllllllIllIlI.duration).append(","));
        }
        llllllllllllllllllllllllllIlIlll = String.valueOf(new StringBuilder().append(llllllllllllllllllllllllllIlIlll).append("]"));
        return llllllllllllllllllllllllllIlIlll;
    }

    public int getHeight() {
        Animation lIIIIIII;
        return ((Frame)lIIIIIII.frames.get((int)lIIIIIII.currentFrame)).image.getHeight();
    }

    public void update(long lIIlIll) {
        Animation lIIllII;
        lIIllII.nextFrame(lIIlIll);
    }

    public void drawFlash(float llIIlIl, float lIlllIl, float llIIIll, float llIIIlI, Color lIllIlI) {
        Animation lIlllll;
        if (lIlllll.frames.size() == 0) {
            return;
        }
        if (lIlllll.autoUpdate) {
            long llIlIII = lIlllll.getTime();
            long llIIlll = llIlIII - lIlllll.lastUpdate;
            if (lIlllll.firstUpdate) {
                llIIlll = 0L;
                lIlllll.firstUpdate = false;
            }
            lIlllll.lastUpdate = llIlIII;
            lIlllll.nextFrame(llIIlll);
        }
        Frame llIIIII = (Frame)lIlllll.frames.get(lIlllll.currentFrame);
        llIIIII.image.drawFlash(llIIlIl, lIlllIl, llIIIll, llIIIlI, lIllIlI);
    }

    public void stopAt(int lII) {
        lll.stopAt = lII;
    }

    public Image getCurrentFrame() {
        Animation lIllII;
        Frame lIllIl = (Frame)lIllII.frames.get(lIllII.currentFrame);
        return lIllIl.image;
    }

    public void renderInUse(int lIIIllIl, int lIIIlIII) {
        Animation lIIIlIlI;
        if (lIIIlIlI.frames.size() == 0) {
            return;
        }
        if (lIIIlIlI.autoUpdate) {
            long lIIlIIII = lIIIlIlI.getTime();
            long lIIIllll = lIIlIIII - lIIIlIlI.lastUpdate;
            if (lIIIlIlI.firstUpdate) {
                lIIIllll = 0L;
                lIIIlIlI.firstUpdate = false;
            }
            lIIIlIlI.lastUpdate = lIIlIIII;
            lIIIlIlI.nextFrame(lIIIllll);
        }
        Frame lIIIlIll = (Frame)lIIIlIlI.frames.get(lIIIlIlI.currentFrame);
        lIIIlIlI.spriteSheet.renderInUse(lIIIllIl, lIIIlIII, lIIIlIll.x, lIIIlIll.y);
    }

    public void setDuration(int llllllllllllllllllllllllllllIllI, int llllllllllllllllllllllllllllIlIl) {
        ((Frame)lllllllllllllllllllllllllllllIlI.frames.get((int)llllllllllllllllllllllllllllIllI)).duration = llllllllllllllllllllllllllllIlIl;
    }

    public Animation(SpriteSheet lIIlllIlI, int lIIllIIII, int lIIlIllll, int lIIlIlllI, int lIIllIllI, boolean lIIlIllII, int lIIllIlII, boolean lIIllIIll) {
        Animation lIIllIIlI;
        lIIllIIlI.frames = new ArrayList();
        lIIllIIlI.currentFrame = -1;
        lIIllIIlI.nextChange = 0L;
        lIIllIIlI.stopped = false;
        lIIllIIlI.speed = 1.0f;
        lIIllIIlI.stopAt = -2;
        lIIllIIlI.firstUpdate = true;
        lIIllIIlI.autoUpdate = true;
        lIIllIIlI.direction = 1;
        lIIllIIlI.loop = true;
        lIIllIIlI.spriteSheet = null;
        lIIllIIlI.autoUpdate = lIIllIIll;
        if (!lIIlIllII) {
            for (int lIIlllllI = lIIllIIII; lIIlllllI <= lIIlIlllI; ++lIIlllllI) {
                for (int lIIllllll = lIIlIllll; lIIllllll <= lIIllIllI; ++lIIllllll) {
                    lIIllIIlI.addFrame(lIIlllIlI.getSprite(lIIlllllI, lIIllllll), lIIllIlII);
                }
            }
        } else {
            for (int lIIllllII = lIIlIllll; lIIllllII <= lIIllIllI; ++lIIllllII) {
                for (int lIIllllIl = lIIllIIII; lIIllllIl <= lIIlIlllI; ++lIIllllIl) {
                    lIIllIIlI.addFrame(lIIlllIlI.getSprite(lIIllllIl, lIIllllII), lIIllIlII);
                }
            }
        }
    }

    public void drawFlash(float llllIIl, float lllIIll, float lllIIlI, float lllIllI) {
        Animation llllIlI;
        llllIlI.drawFlash(llllIIl, lllIIll, lllIIlI, lllIllI, Color.white);
    }

    public int getWidth() {
        Animation lIIIIIll;
        return ((Frame)lIIIIIll.frames.get((int)lIIIIIll.currentFrame)).image.getWidth();
    }

    public Animation(Image[] llIIIIIll, int lIlllllII, boolean lIllllIll) {
        Animation llIIIIlII;
        llIIIIlII.frames = new ArrayList();
        llIIIIlII.currentFrame = -1;
        llIIIIlII.nextChange = 0L;
        llIIIIlII.stopped = false;
        llIIIIlII.speed = 1.0f;
        llIIIIlII.stopAt = -2;
        llIIIIlII.firstUpdate = true;
        llIIIIlII.autoUpdate = true;
        llIIIIlII.direction = 1;
        llIIIIlII.loop = true;
        llIIIIlII.spriteSheet = null;
        for (int llIIIIlIl = 0; llIIIIlIl < llIIIIIll.length; ++llIIIIlIl) {
            llIIIIlII.addFrame(llIIIIIll[llIIIIlIl], lIlllllII);
        }
        llIIIIlII.currentFrame = 0;
        llIIIIlII.autoUpdate = lIllllIll;
    }

    public void addFrame(Image llIlIlll, int llIlIllI) {
        Animation llIllIII;
        if (llIlIllI == 0) {
            Log.error(String.valueOf(new StringBuilder().append("Invalid duration: ").append(llIlIllI)));
            throw new RuntimeException(String.valueOf(new StringBuilder().append("Invalid duration: ").append(llIlIllI)));
        }
        if (llIllIII.frames.isEmpty()) {
            llIllIII.nextChange = (int)((float)llIlIllI / llIllIII.speed);
        }
        llIllIII.frames.add(llIllIII.new Frame(llIlIlll, llIlIllI));
        llIllIII.currentFrame = 0;
    }

    public void draw() {
        Animation llIlIIll;
        llIlIIll.draw(0.0f, 0.0f);
    }

    private void nextFrame(long llIII) {
        Animation llIIl;
        if (llIIl.stopped) {
            return;
        }
        if (llIIl.frames.size() == 0) {
            return;
        }
        llIIl.nextChange -= llIII;
        while (llIIl.nextChange < 0L && !llIIl.stopped) {
            if (llIIl.currentFrame == llIIl.stopAt) {
                llIIl.stopped = true;
                break;
            }
            if (llIIl.currentFrame == llIIl.frames.size() - 1 && !llIIl.loop && !llIIl.pingPong) {
                llIIl.stopped = true;
                break;
            }
            llIIl.currentFrame = (llIIl.currentFrame + llIIl.direction) % llIIl.frames.size();
            if (llIIl.pingPong) {
                if (llIIl.currentFrame <= 0) {
                    llIIl.currentFrame = 0;
                    llIIl.direction = 1;
                    if (!llIIl.loop) {
                        llIIl.stopped = true;
                        break;
                    }
                } else if (llIIl.currentFrame >= llIIl.frames.size() - 1) {
                    llIIl.currentFrame = llIIl.frames.size() - 1;
                    llIIl.direction = -1;
                }
            }
            int llIlI = (int)((float)((Frame)llIIl.frames.get((int)llIIl.currentFrame)).duration / llIIl.speed);
            llIIl.nextChange += (long)llIlI;
        }
    }

    @Override
    public void draw(float lIllIlll, float lIllIIIl, float lIllIIII, float lIllIlII) {
        Animation lIlllIII;
        lIlllIII.draw(lIllIlll, lIllIIIl, lIllIIII, lIllIlII, Color.white);
    }

    public Animation(boolean llIIllIII) {
        Animation llIIllllI;
        llIIllllI.frames = new ArrayList();
        llIIllllI.currentFrame = -1;
        llIIllllI.nextChange = 0L;
        llIIllllI.stopped = false;
        llIIllllI.speed = 1.0f;
        llIIllllI.stopAt = -2;
        llIIllllI.firstUpdate = true;
        llIIllllI.autoUpdate = true;
        llIIllllI.direction = 1;
        llIIllllI.loop = true;
        llIIllllI.spriteSheet = null;
        llIIllllI.currentFrame = 0;
        llIIllllI.autoUpdate = llIIllIII;
    }

    public Animation(SpriteSheet lIIIlIlll, int[] lIIIlIllI, int[] lIIIIllll) {
        Animation lIIIllIII;
        lIIIllIII.frames = new ArrayList();
        lIIIllIII.currentFrame = -1;
        lIIIllIII.nextChange = 0L;
        lIIIllIII.stopped = false;
        lIIIllIII.speed = 1.0f;
        lIIIllIII.stopAt = -2;
        lIIIllIII.firstUpdate = true;
        lIIIllIII.autoUpdate = true;
        lIIIllIII.direction = 1;
        lIIIllIII.loop = true;
        lIIIllIII.spriteSheet = null;
        lIIIllIII.spriteSheet = lIIIlIlll;
        int lIIIlIlII = -1;
        int lIIIlIIll = -1;
        for (int lIIIllIIl = 0; lIIIllIIl < lIIIlIllI.length / 2; ++lIIIllIIl) {
            lIIIlIlII = lIIIlIllI[lIIIllIIl * 2];
            lIIIlIIll = lIIIlIllI[lIIIllIIl * 2 + 1];
            lIIIllIII.addFrame(lIIIIllll[lIIIllIIl], lIIIlIlII, lIIIlIIll);
        }
    }

    public void restart() {
        Animation lllIIIII;
        if (lllIIIII.frames.size() == 0) {
            return;
        }
        lllIIIII.stopped = false;
        lllIIIII.currentFrame = 0;
        lllIIIII.nextChange = (int)((float)((Frame)lllIIIII.frames.get((int)0)).duration / lllIIIII.speed);
        lllIIIII.firstUpdate = true;
        lllIIIII.lastUpdate = 0L;
    }

    public void start() {
        Animation lllIIIlI;
        if (!lllIIIlI.stopped) {
            return;
        }
        if (lllIIIlI.frames.size() == 0) {
            return;
        }
        lllIIIlI.stopped = false;
        lllIIIlI.nextChange = lllIIIlI.timeLeft;
    }

    public void setAutoUpdate(boolean llllllII) {
        lllllIll.autoUpdate = llllllII;
    }

    public void setCurrentFrame(int llllll) {
        lIIIIII.currentFrame = llllll;
    }

    @Override
    public void draw(float llIIlllI, float llIIlIlI) {
        Animation llIIllll;
        llIIllll.draw(llIIlllI, llIIlIlI, llIIllll.getWidth(), llIIllll.getHeight());
    }

    public Animation(Image[] lllIIIIII, int llIllllll) {
        lllIIIlII(lllIIIIII, llIllllll, true);
        Animation lllIIIlII;
    }

    public Animation(Image[] lIllIIlll, int[] lIllIIIlI, boolean lIllIIIII) {
        Animation lIllIIlII;
        lIllIIlII.frames = new ArrayList();
        lIllIIlII.currentFrame = -1;
        lIllIIlII.nextChange = 0L;
        lIllIIlII.stopped = false;
        lIllIIlII.speed = 1.0f;
        lIllIIlII.stopAt = -2;
        lIllIIlII.firstUpdate = true;
        lIllIIlII.autoUpdate = true;
        lIllIIlII.direction = 1;
        lIllIIlII.loop = true;
        lIllIIlII.spriteSheet = null;
        lIllIIlII.autoUpdate = lIllIIIII;
        if (lIllIIlll.length != lIllIIIlI.length) {
            throw new RuntimeException("There must be one duration per frame");
        }
        for (int lIllIlIIl = 0; lIllIlIIl < lIllIIlll.length; ++lIllIlIIl) {
            lIllIIlII.addFrame(lIllIIlll[lIllIlIIl], lIllIIIlI[lIllIlIIl]);
        }
        lIllIIlII.currentFrame = 0;
    }

    public int getDuration(int lllllllllllllllllllllllllllllllI) {
        Animation llllllllllllllllllllllllllllllll;
        return ((Frame)llllllllllllllllllllllllllllllll.frames.get((int)lllllllllllllllllllllllllllllllI)).duration;
    }

    public float getSpeed() {
        Animation lllIlIIl;
        return lllIlIIl.speed;
    }

    public int getFrameCount() {
        Animation llIIlI;
        return llIIlI.frames.size();
    }

    @Override
    public void draw(float lIlIIIll, float lIlIIIlI, float lIlIIIIl, float lIIllIIl, Color lIIllIII) {
        Animation lIlIIlII;
        if (lIlIIlII.frames.size() == 0) {
            return;
        }
        if (lIlIIlII.autoUpdate) {
            long lIlIIllI = lIlIIlII.getTime();
            long lIlIIlIl = lIlIIllI - lIlIIlII.lastUpdate;
            if (lIlIIlII.firstUpdate) {
                lIlIIlIl = 0L;
                lIlIIlII.firstUpdate = false;
            }
            lIlIIlII.lastUpdate = lIlIIllI;
            lIlIIlII.nextFrame(lIlIIlIl);
        }
        Frame lIIllllI = (Frame)lIlIIlII.frames.get(lIlIIlII.currentFrame);
        lIIllllI.image.draw(lIlIIIll, lIlIIIlI, lIlIIIIl, lIIllIIl, lIIllIII);
    }

    public int getFrame() {
        Animation lIIIIll;
        return lIIIIll.currentFrame;
    }

    public boolean isStopped() {
        Animation llllIIlI;
        return llllIIlI.stopped;
    }

    public int[] getDurations() {
        Animation lllllllllllllllllllllllllllIlIIl;
        int[] lllllllllllllllllllllllllllIlIII = new int[lllllllllllllllllllllllllllIlIIl.frames.size()];
        for (int lllllllllllllllllllllllllllIlIlI = 0; lllllllllllllllllllllllllllIlIlI < lllllllllllllllllllllllllllIlIIl.frames.size(); ++lllllllllllllllllllllllllllIlIlI) {
            lllllllllllllllllllllllllllIlIII[lllllllllllllllllllllllllllIlIlI] = lllllllllllllllllllllllllllIlIIl.getDuration(lllllllllllllllllllllllllllIlIlI);
        }
        return lllllllllllllllllllllllllllIlIII;
    }

    private long getTime() {
        return Sys.getTime() * 1000L / Sys.getTimerResolution();
    }

    public void stop() {
        Animation lllIIlIl;
        if (lllIIlIl.frames.size() == 0) {
            return;
        }
        lllIIlIl.timeLeft = lllIIlIl.nextChange;
        lllIIlIl.stopped = true;
    }

    public Animation(Image[] llIlllIlI, int[] llIllIllI) {
        llIlllIII(llIlllIlI, llIllIllI, true);
        Animation llIlllIII;
    }

    public Animation(SpriteSheet lIlIIllll, int lIlIlIIlI) {
        lIlIlIIII(lIlIIllll, 0, 0, lIlIIllll.getHorizontalCount() - 1, lIlIIllll.getVerticalCount() - 1, true, lIlIlIIlI, true);
        Animation lIlIlIIII;
    }

    public void updateNoDraw() {
        Animation lIlIIlI;
        if (lIlIIlI.autoUpdate) {
            long lIlIlII = lIlIIlI.getTime();
            long lIlIIll = lIlIlII - lIlIIlI.lastUpdate;
            if (lIlIIlI.firstUpdate) {
                lIlIIll = 0L;
                lIlIIlI.firstUpdate = false;
            }
            lIlIIlI.lastUpdate = lIlIlII;
            lIlIIlI.nextFrame(lIlIIll);
        }
    }

    public void addFrame(int lIIIIIllI, int lIIIIIIIl, int lIIIIIIII) {
        Animation lIIIIIIll;
        if (lIIIIIllI == 0) {
            Log.error(String.valueOf(new StringBuilder().append("Invalid duration: ").append(lIIIIIllI)));
            throw new RuntimeException(String.valueOf(new StringBuilder().append("Invalid duration: ").append(lIIIIIllI)));
        }
        if (lIIIIIIll.frames.isEmpty()) {
            lIIIIIIll.nextChange = (int)((float)lIIIIIllI / lIIIIIIll.speed);
        }
        lIIIIIIll.frames.add(lIIIIIIll.new Frame(lIIIIIllI, lIIIIIIIl, lIIIIIIII));
        lIIIIIIll.currentFrame = 0;
    }

    private class Frame {
        public /* synthetic */ int x;
        public /* synthetic */ Image image;
        public /* synthetic */ int y;
        public /* synthetic */ int duration;

        public Frame(Image llllllllllllllllIlllIIlllIIIlIIl, int llllllllllllllllIlllIIlllIIIlIII) {
            Frame llllllllllllllllIlllIIlllIIIlllI;
            llllllllllllllllIlllIIlllIIIlllI.x = -1;
            llllllllllllllllIlllIIlllIIIlllI.y = -1;
            llllllllllllllllIlllIIlllIIIlllI.image = llllllllllllllllIlllIIlllIIIlIIl;
            llllllllllllllllIlllIIlllIIIlllI.duration = llllllllllllllllIlllIIlllIIIlIII;
        }

        public Frame(int llllllllllllllllIlllIIllIlllllII, int llllllllllllllllIlllIIlllIIIIIII, int llllllllllllllllIlllIIllIlllllll) {
            Frame llllllllllllllllIlllIIllIllllllI;
            llllllllllllllllIlllIIllIllllllI.x = -1;
            llllllllllllllllIlllIIllIllllllI.y = -1;
            llllllllllllllllIlllIIllIllllllI.image = llllllllllllllllIlllIIllIllllllI.Animation.this.spriteSheet.getSubImage(llllllllllllllllIlllIIlllIIIIIII, llllllllllllllllIlllIIllIlllllll);
            llllllllllllllllIlllIIllIllllllI.duration = llllllllllllllllIlllIIllIlllllII;
            llllllllllllllllIlllIIllIllllllI.x = llllllllllllllllIlllIIlllIIIIIII;
            llllllllllllllllIlllIIllIllllllI.y = llllllllllllllllIlllIIllIlllllll;
        }
    }
}

