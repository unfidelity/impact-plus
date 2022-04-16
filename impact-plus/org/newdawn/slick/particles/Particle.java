/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.particles;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleSystem;

public class Particle {
    protected /* synthetic */ float vely;
    protected /* synthetic */ int type;
    protected /* synthetic */ float size;
    protected /* synthetic */ float x;
    protected static /* synthetic */ SGL GL;
    protected /* synthetic */ boolean oriented;
    protected /* synthetic */ float velx;
    protected /* synthetic */ float life;
    public static final /* synthetic */ int USE_POINTS;
    public static final /* synthetic */ int INHERIT_POINTS;
    protected /* synthetic */ float scaleY;
    public static final /* synthetic */ int USE_QUADS;
    private /* synthetic */ ParticleSystem engine;
    protected /* synthetic */ int usePoints;
    protected /* synthetic */ Image image;
    protected /* synthetic */ float originalLife;
    protected /* synthetic */ Color color;
    private /* synthetic */ ParticleEmitter emitter;
    protected /* synthetic */ float y;

    public void adjustColor(int llllIIlIIIIIl, int llllIIlIIIIII, int llllIIIllllll, int llllIIlIIIIll) {
        Particle llllIIlIIIIlI;
        if (llllIIlIIIIlI.color == Color.white) {
            llllIIlIIIIlI.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        }
        llllIIlIIIIlI.color.r += (float)llllIIlIIIIIl / 255.0f;
        llllIIlIIIIlI.color.g += (float)llllIIlIIIIII / 255.0f;
        llllIIlIIIIlI.color.b += (float)llllIIIllllll / 255.0f;
        llllIIlIIIIlI.color.a += (float)llllIIlIIIIll / 255.0f;
    }

    public String toString() {
        Particle llllIIIllIIII;
        return String.valueOf(new StringBuilder().append(super.toString()).append(" : ").append(llllIIIllIIII.life));
    }

    public Color getColor() {
        Particle lllllIIIIlIII;
        return lllllIIIIlIII.color;
    }

    public void setSpeed(float llllIIllIllll) {
        Particle llllIIlllIIII;
        float llllIIlllIIIl = (float)Math.sqrt(llllIIlllIIII.velx * llllIIlllIIII.velx + llllIIlllIIII.vely * llllIIlllIIII.vely);
        llllIIlllIIII.velx *= llllIIllIllll;
        llllIIlllIIII.vely *= llllIIllIllll;
        llllIIlllIIII.velx /= llllIIlllIIIl;
        llllIIlllIIII.vely /= llllIIlllIIIl;
    }

    public float getOriginalLife() {
        Particle llllIllllllll;
        return llllIllllllll.originalLife;
    }

    public void init(ParticleEmitter llllIlllIIIlI, float llllIlllIIIIl) {
        Particle llllIlllIIIll;
        llllIlllIIIll.x = 0.0f;
        llllIlllIIIll.emitter = llllIlllIIIlI;
        llllIlllIIIll.y = 0.0f;
        llllIlllIIIll.velx = 0.0f;
        llllIlllIIIll.vely = 0.0f;
        llllIlllIIIll.size = 10.0f;
        llllIlllIIIll.type = 0;
        llllIlllIIIll.originalLife = llllIlllIIIll.life = llllIlllIIIIl;
        llllIlllIIIll.oriented = false;
        llllIlllIIIll.scaleY = 1.0f;
    }

    public void setLife(float llllIlIlIIllI) {
        llllIlIlIIlll.life = llllIlIlIIllI;
    }

    public float getSize() {
        Particle lllllIIIIlIll;
        return lllllIIIIlIll.size;
    }

    public void adjustColor(float llllIIlIlIIII, float llllIIlIlIlII, float llllIIlIIlllI, float llllIIlIlIIlI) {
        Particle llllIIlIlIllI;
        if (llllIIlIlIllI.color == Color.white) {
            llllIIlIlIllI.color = new Color(1.0f, 1.0f, 1.0f, 1.0f);
        }
        llllIIlIlIllI.color.r += llllIIlIlIIII;
        llllIIlIlIllI.color.g += llllIIlIlIlII;
        llllIIlIlIllI.color.b += llllIIlIIlllI;
        llllIIlIlIllI.color.a += llllIIlIlIIlI;
    }

    public int getType() {
        Particle llllIllIlIIII;
        return llllIllIlIIII.type;
    }

    public void setType(int llllIllIllIll) {
        llllIllIllllI.type = llllIllIllIll;
    }

    public boolean inUse() {
        Particle llllIlllllIIl;
        return llllIlllllIIl.life > 0.0f;
    }

    public float getX() {
        Particle lllllIIIllIlI;
        return lllllIIIllIlI.x;
    }

    public void setUsePoint(int llllIllIlIlIl) {
        llllIllIllIII.usePoints = llllIllIlIlIl;
    }

    public void adjustVelocity(float llllIIIllIllI, float llllIIIlllIII) {
        llllIIIlllIlI.velx += llllIIIllIllI;
        llllIIIlllIlI.vely += llllIIIlllIII;
    }

    public ParticleEmitter getEmitter() {
        Particle llllIIIllIIlI;
        return llllIIIllIIlI.emitter;
    }

    public void setVelocity(float llllIIllllIIl, float llllIIllllIII, float llllIIllllIll) {
        llllIIllllllI.velx = llllIIllllIIl * llllIIllllIll;
        llllIIllllllI.vely = llllIIllllIII * llllIIllllIll;
    }

    public void setOriented(boolean llllIIIlIIllI) {
        llllIIIlIlIIl.oriented = llllIIIlIIllI;
    }

    public float getY() {
        Particle lllllIIIllIII;
        return lllllIIIllIII.y;
    }

    public void setVelocity(float llllIIllIIllI, float llllIIllIlIII) {
        Particle llllIIllIIlll;
        llllIIllIIlll.setVelocity(llllIIllIIllI, llllIIllIlIII, 1.0f);
    }

    public void setScaleY(float llllIIIIlllIl) {
        llllIIIlIIIII.scaleY = llllIIIIlllIl;
    }

    public void move(float lllllIIIlIIlI, float lllllIIIIlllI) {
        lllllIIIlIIII.x += lllllIIIlIIlI;
        lllllIIIlIIII.y += lllllIIIIlllI;
    }

    static {
        USE_QUADS = 3;
        INHERIT_POINTS = 1;
        USE_POINTS = 2;
        GL = Renderer.get();
    }

    public Particle(ParticleSystem lllllIIIlllll) {
        Particle lllllIIlIIIII;
        lllllIIlIIIII.size = 10.0f;
        lllllIIlIIIII.color = Color.white;
        lllllIIlIIIII.usePoints = 1;
        lllllIIlIIIII.oriented = false;
        lllllIIlIIIII.scaleY = 1.0f;
        lllllIIlIIIII.engine = lllllIIIlllll;
    }

    public void setSize(float llllIllIIIIII) {
        llllIllIIIllI.size = llllIllIIIIII;
    }

    public void adjustSize(float llllIlIllIIII) {
        Particle llllIlIllIIIl;
        llllIlIllIIIl.size += llllIlIllIIII;
        llllIlIllIIIl.size = Math.max(0.0f, llllIlIllIIIl.size);
    }

    public void adjustPosition(float llllIIlIlllIl, float llllIIlIlllII) {
        llllIIlIllllI.x += llllIIlIlllIl;
        llllIIlIllllI.y += llllIIlIlllII;
    }

    public void render() {
        Particle llllIllllIlIl;
        if (llllIllllIlIl.engine.usePoints() && llllIllllIlIl.usePoints == 1 || llllIllllIlIl.usePoints == 2) {
            TextureImpl.bindNone();
            GL.glEnable(2832);
            GL.glPointSize(llllIllllIlIl.size / 2.0f);
            llllIllllIlIl.color.bind();
            GL.glBegin(0);
            GL.glVertex2f(llllIllllIlIl.x, llllIllllIlIl.y);
            GL.glEnd();
        } else if (llllIllllIlIl.oriented || llllIllllIlIl.scaleY != 1.0f) {
            GL.glPushMatrix();
            GL.glTranslatef(llllIllllIlIl.x, llllIllllIlIl.y, 0.0f);
            if (llllIllllIlIl.oriented) {
                float llllIllllIllI = (float)(Math.atan2(llllIllllIlIl.y, llllIllllIlIl.x) * 180.0 / Math.PI);
                GL.glRotatef(llllIllllIllI, 0.0f, 0.0f, 1.0f);
            }
            GL.glScalef(1.0f, llllIllllIlIl.scaleY, 1.0f);
            llllIllllIlIl.image.draw((int)(-(llllIllllIlIl.size / 2.0f)), (int)(-(llllIllllIlIl.size / 2.0f)), (int)llllIllllIlIl.size, (int)llllIllllIlIl.size, llllIllllIlIl.color);
            GL.glPopMatrix();
        } else {
            llllIllllIlIl.color.bind();
            llllIllllIlIl.image.drawEmbedded((int)(llllIllllIlIl.x - llllIllllIlIl.size / 2.0f), (int)(llllIllllIlIl.y - llllIllllIlIl.size / 2.0f), (int)llllIllllIlIl.size, (int)llllIllllIlIl.size);
        }
    }

    public boolean isOriented() {
        Particle llllIIIlIllII;
        return llllIIIlIllII.oriented;
    }

    public void adjustLife(float llllIlIlIIIII) {
        llllIlIlIIIIl.life += llllIlIlIIIII;
    }

    public void update(int llllIlllIllIl) {
        Particle llllIllllIIII;
        llllIllllIIII.emitter.updateParticle(llllIllllIIII, llllIlllIllIl);
        llllIllllIIII.life -= (float)llllIlllIllIl;
        if (llllIllllIIII.life > 0.0f) {
            llllIllllIIII.x += (float)llllIlllIllIl * llllIllllIIII.velx;
            llllIllllIIII.y += (float)llllIlllIllIl * llllIllllIIII.vely;
        } else {
            llllIllllIIII.engine.release(llllIllllIIII);
        }
    }

    public void setImage(Image lllllIIIIIIlI) {
        lllllIIIIIIll.image = lllllIIIIIIlI;
    }

    public void kill() {
        llllIlIIllIll.life = 1.0f;
    }

    public float getLife() {
        Particle llllIllllllII;
        return llllIllllllII.life;
    }

    public float getScaleY() {
        Particle llllIIIlIIlII;
        return llllIIIlIIlII.scaleY;
    }

    public void setColor(float llllIlIIlIlII, float llllIlIIIlllI, float llllIlIIIllIl, float llllIlIIlIIIl) {
        Particle llllIlIIlIIII;
        if (llllIlIIlIIII.color == Color.white) {
            llllIlIIlIIII.color = new Color(llllIlIIlIlII, llllIlIIIlllI, llllIlIIIllIl, llllIlIIlIIIl);
        } else {
            llllIlIIlIIII.color.r = llllIlIIlIlII;
            llllIlIIlIIII.color.g = llllIlIIIlllI;
            llllIlIIlIIII.color.b = llllIlIIIllIl;
            llllIlIIlIIII.color.a = llllIlIIlIIIl;
        }
    }

    public void setPosition(float llllIlIIIIlII, float llllIlIIIIllI) {
        llllIlIIIlIII.x = llllIlIIIIlII;
        llllIlIIIlIII.y = llllIlIIIIllI;
    }
}

