/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.particles.effects;

import org.newdawn.slick.Image;
import org.newdawn.slick.particles.Particle;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleSystem;

public class FireEmitter
implements ParticleEmitter {
    private /* synthetic */ int x;
    private /* synthetic */ int y;
    private /* synthetic */ float size;
    private /* synthetic */ int interval;
    private /* synthetic */ int timer;

    public FireEmitter(int llllllllllllllllIlIlIIllIllllIlI, int llllllllllllllllIlIlIIllIlllIllI) {
        FireEmitter llllllllllllllllIlIlIIllIllllIII;
        llllllllllllllllIlIlIIllIllllIII.interval = 50;
        llllllllllllllllIlIlIIllIllllIII.size = 40.0f;
        llllllllllllllllIlIlIIllIllllIII.x = llllllllllllllllIlIlIIllIllllIlI;
        llllllllllllllllIlIlIIllIllllIII.y = llllllllllllllllIlIlIIllIlllIllI;
    }

    @Override
    public void resetState() {
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public void wrapUp() {
    }

    @Override
    public boolean useAdditive() {
        return false;
    }

    public FireEmitter() {
        FireEmitter llllllllllllllllIlIlIIllIlllllll;
        llllllllllllllllIlIlIIllIlllllll.interval = 50;
        llllllllllllllllIlIlIIllIlllllll.size = 40.0f;
    }

    @Override
    public void updateParticle(Particle llllllllllllllllIlIlIIllIlIlIIlI, int llllllllllllllllIlIlIIllIlIIllIl) {
        if (llllllllllllllllIlIlIIllIlIlIIlI.getLife() > 600.0f) {
            llllllllllllllllIlIlIIllIlIlIIlI.adjustSize(0.07f * (float)llllllllllllllllIlIlIIllIlIIllIl);
        } else {
            FireEmitter llllllllllllllllIlIlIIllIlIIllll;
            llllllllllllllllIlIlIIllIlIlIIlI.adjustSize(-0.04f * (float)llllllllllllllllIlIlIIllIlIIllIl * (llllllllllllllllIlIlIIllIlIIllll.size / 40.0f));
        }
        float llllllllllllllllIlIlIIllIlIlIIII = 0.002f * (float)llllllllllllllllIlIlIIllIlIIllIl;
        llllllllllllllllIlIlIIllIlIlIIlI.adjustColor(0.0f, -llllllllllllllllIlIlIIllIlIlIIII / 2.0f, -llllllllllllllllIlIlIIllIlIlIIII * 2.0f, -llllllllllllllllIlIlIIllIlIlIIII / 4.0f);
    }

    @Override
    public boolean usePoints(ParticleSystem llllllllllllllllIlIlIIllIlIIIlII) {
        return false;
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public void update(ParticleSystem llllllllllllllllIlIlIIllIlIlllll, int llllllllllllllllIlIlIIllIlIllIll) {
        FireEmitter llllllllllllllllIlIlIIllIllIIIII;
        llllllllllllllllIlIlIIllIllIIIII.timer -= llllllllllllllllIlIlIIllIlIllIll;
        if (llllllllllllllllIlIlIIllIllIIIII.timer <= 0) {
            llllllllllllllllIlIlIIllIllIIIII.timer = llllllllllllllllIlIlIIllIllIIIII.interval;
            Particle llllllllllllllllIlIlIIllIllIIIll = llllllllllllllllIlIlIIllIlIlllll.getNewParticle(llllllllllllllllIlIlIIllIllIIIII, 1000.0f);
            llllllllllllllllIlIlIIllIllIIIll.setColor(1.0f, 1.0f, 1.0f, 0.5f);
            llllllllllllllllIlIlIIllIllIIIll.setPosition(llllllllllllllllIlIlIIllIllIIIII.x, llllllllllllllllIlIlIIllIllIIIII.y);
            llllllllllllllllIlIlIIllIllIIIll.setSize(llllllllllllllllIlIlIIllIllIIIII.size);
            float llllllllllllllllIlIlIIllIllIIIlI = (float)((double)-0.02f + Math.random() * (double)0.04f);
            float llllllllllllllllIlIlIIllIllIIIIl = (float)(-(Math.random() * (double)0.15f));
            llllllllllllllllIlIlIIllIllIIIll.setVelocity(llllllllllllllllIlIlIIllIllIIIlI, llllllllllllllllIlIlIIllIllIIIIl, 1.1f);
        }
    }

    @Override
    public boolean isOriented() {
        return false;
    }

    @Override
    public boolean completed() {
        return false;
    }

    @Override
    public void setEnabled(boolean llllllllllllllllIlIlIIllIlIIlIIl) {
    }

    public FireEmitter(int llllllllllllllllIlIlIIllIlllIIII, int llllllllllllllllIlIlIIllIllIllll, float llllllllllllllllIlIlIIllIllIlIlI) {
        FireEmitter llllllllllllllllIlIlIIllIllIllIl;
        llllllllllllllllIlIlIIllIllIllIl.interval = 50;
        llllllllllllllllIlIlIIllIllIllIl.size = 40.0f;
        llllllllllllllllIlIlIIllIllIllIl.x = llllllllllllllllIlIlIIllIlllIIII;
        llllllllllllllllIlIlIIllIllIllIl.y = llllllllllllllllIlIlIIllIllIllll;
        llllllllllllllllIlIlIIllIllIllIl.size = llllllllllllllllIlIlIIllIllIlIlI;
    }
}

