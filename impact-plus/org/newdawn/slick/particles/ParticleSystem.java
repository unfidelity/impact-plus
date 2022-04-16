/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.particles;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.HashMap;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.renderer.Renderer;
import org.newdawn.slick.opengl.renderer.SGL;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.Particle;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.util.Log;

public class ParticleSystem {
    private /* synthetic */ float y;
    public static final /* synthetic */ int BLEND_ADDITIVE;
    public static final /* synthetic */ int BLEND_COMBINE;
    protected /* synthetic */ Particle dummy;
    private /* synthetic */ int pCount;
    private /* synthetic */ float x;
    private /* synthetic */ Image sprite;
    protected /* synthetic */ SGL GL;
    private /* synthetic */ boolean visible;
    private /* synthetic */ boolean usePoints;
    private /* synthetic */ boolean removeCompletedEmitters;
    private /* synthetic */ ArrayList removeMe;
    protected /* synthetic */ HashMap particlesByEmitter;
    private /* synthetic */ String defaultImageName;
    private /* synthetic */ int blendingMode;
    private /* synthetic */ Color mask;
    private static final /* synthetic */ int DEFAULT_PARTICLES;
    protected /* synthetic */ ArrayList emitters;
    protected /* synthetic */ int maxParticlesPerEmitter;

    public void addEmitter(ParticleEmitter lllllllllllllllIllllllIllIIIIIlI) {
        ParticleSystem lllllllllllllllIllllllIllIIIIIll;
        lllllllllllllllIllllllIllIIIIIll.emitters.add(lllllllllllllllIllllllIllIIIIIlI);
        ParticlePool lllllllllllllllIllllllIllIIIIlII = lllllllllllllllIllllllIllIIIIIll.new ParticlePool(lllllllllllllllIllllllIllIIIIIll, lllllllllllllllIllllllIllIIIIIll.maxParticlesPerEmitter);
        lllllllllllllllIllllllIllIIIIIll.particlesByEmitter.put(lllllllllllllllIllllllIllIIIIIlI, lllllllllllllllIllllllIllIIIIlII);
    }

    public void render(float lllllllllllllllIllllllIlIIlIlIll, float lllllllllllllllIllllllIlIIlIllIl) {
        ParticleSystem lllllllllllllllIllllllIlIIlIllll;
        if (lllllllllllllllIllllllIlIIlIllll.sprite == null && lllllllllllllllIllllllIlIIlIllll.defaultImageName != null) {
            lllllllllllllllIllllllIlIIlIllll.loadSystemParticleImage();
        }
        if (!lllllllllllllllIllllllIlIIlIllll.visible) {
            return;
        }
        lllllllllllllllIllllllIlIIlIllll.GL.glTranslatef(lllllllllllllllIllllllIlIIlIlIll, lllllllllllllllIllllllIlIIlIllIl, 0.0f);
        if (lllllllllllllllIllllllIlIIlIllll.blendingMode == 1) {
            lllllllllllllllIllllllIlIIlIllll.GL.glBlendFunc(770, 1);
        }
        if (lllllllllllllllIllllllIlIIlIllll.usePoints()) {
            lllllllllllllllIllllllIlIIlIllll.GL.glEnable(2832);
            TextureImpl.bindNone();
        }
        for (int lllllllllllllllIllllllIlIIllIIII = 0; lllllllllllllllIllllllIlIIllIIII < lllllllllllllllIllllllIlIIlIllll.emitters.size(); ++lllllllllllllllIllllllIlIIllIIII) {
            ParticleEmitter lllllllllllllllIllllllIlIIllIllI = (ParticleEmitter)lllllllllllllllIllllllIlIIlIllll.emitters.get(lllllllllllllllIllllllIlIIllIIII);
            if (!lllllllllllllllIllllllIlIIllIllI.isEnabled()) continue;
            if (lllllllllllllllIllllllIlIIllIllI.useAdditive()) {
                lllllllllllllllIllllllIlIIlIllll.GL.glBlendFunc(770, 1);
            }
            ParticlePool lllllllllllllllIllllllIlIIllIlII = (ParticlePool)lllllllllllllllIllllllIlIIlIllll.particlesByEmitter.get(lllllllllllllllIllllllIlIIllIllI);
            Image lllllllllllllllIllllllIlIIllIIlI = lllllllllllllllIllllllIlIIllIllI.getImage();
            if (lllllllllllllllIllllllIlIIllIIlI == null) {
                lllllllllllllllIllllllIlIIllIIlI = lllllllllllllllIllllllIlIIlIllll.sprite;
            }
            if (!lllllllllllllllIllllllIlIIllIllI.isOriented() && !lllllllllllllllIllllllIlIIllIllI.usePoints(lllllllllllllllIllllllIlIIlIllll)) {
                lllllllllllllllIllllllIlIIllIIlI.startUse();
            }
            for (int lllllllllllllllIllllllIlIIlllIIl = 0; lllllllllllllllIllllllIlIIlllIIl < lllllllllllllllIllllllIlIIllIlII.particles.length; ++lllllllllllllllIllllllIlIIlllIIl) {
                if (!lllllllllllllllIllllllIlIIllIlII.particles[lllllllllllllllIllllllIlIIlllIIl].inUse()) continue;
                lllllllllllllllIllllllIlIIllIlII.particles[lllllllllllllllIllllllIlIIlllIIl].render();
            }
            if (!lllllllllllllllIllllllIlIIllIllI.isOriented() && !lllllllllllllllIllllllIlIIllIllI.usePoints(lllllllllllllllIllllllIlIIlIllll)) {
                lllllllllllllllIllllllIlIIllIIlI.endUse();
            }
            if (!lllllllllllllllIllllllIlIIllIllI.useAdditive()) continue;
            lllllllllllllllIllllllIlIIlIllll.GL.glBlendFunc(770, 771);
        }
        if (lllllllllllllllIllllllIlIIlIllll.usePoints()) {
            lllllllllllllllIllllllIlIIlIllll.GL.glDisable(2832);
        }
        if (lllllllllllllllIllllllIlIIlIllll.blendingMode == 1) {
            lllllllllllllllIllllllIlIIlIllll.GL.glBlendFunc(770, 771);
        }
        Color.white.bind();
        lllllllllllllllIllllllIlIIlIllll.GL.glTranslatef(-lllllllllllllllIllllllIlIIlIlIll, -lllllllllllllllIllllllIlIIlIllIl, 0.0f);
    }

    public Particle getNewParticle(ParticleEmitter lllllllllllllllIllllllIIllIIIIII, float lllllllllllllllIllllllIIlIlllllI) {
        ParticleSystem lllllllllllllllIllllllIIlIllIlll;
        ParticlePool lllllllllllllllIllllllIIlIllllIl = (ParticlePool)lllllllllllllllIllllllIIlIllIlll.particlesByEmitter.get(lllllllllllllllIllllllIIllIIIIII);
        ArrayList lllllllllllllllIllllllIIlIlllIlI = lllllllllllllllIllllllIIlIllllIl.available;
        if (lllllllllllllllIllllllIIlIlllIlI.size() > 0) {
            Particle lllllllllllllllIllllllIIllIIIlII = (Particle)lllllllllllllllIllllllIIlIlllIlI.remove(lllllllllllllllIllllllIIlIlllIlI.size() - 1);
            lllllllllllllllIllllllIIllIIIlII.init(lllllllllllllllIllllllIIllIIIIII, lllllllllllllllIllllllIIlIlllllI);
            lllllllllllllllIllllllIIllIIIlII.setImage(lllllllllllllllIllllllIIlIllIlll.sprite);
            return lllllllllllllllIllllllIIllIIIlII;
        }
        Log.warn("Ran out of particles (increase the limit)!");
        return lllllllllllllllIllllllIIlIllIlll.dummy;
    }

    public static void setRelativePath(String lllllllllllllllIlllllllIIIIlIIll) {
        ConfigurableEmitter.setRelativePath(lllllllllllllllIlllllllIIIIlIIll);
    }

    public float getPositionX() {
        ParticleSystem lllllllllllllllIllllllIlIlllIIII;
        return lllllllllllllllIllllllIlIlllIIII.x;
    }

    public boolean usePoints() {
        ParticleSystem lllllllllllllllIllllllIllllIIIll;
        return lllllllllllllllIllllllIllllIIIll.usePoints;
    }

    public void releaseAll(ParticleEmitter lllllllllllllllIllllllIIlIIIIIll) {
        ParticleSystem lllllllllllllllIllllllIIlIIIIIIl;
        if (!lllllllllllllllIllllllIIlIIIIIIl.particlesByEmitter.isEmpty()) {
            for (ParticlePool lllllllllllllllIllllllIIlIIIlIIl : lllllllllllllllIllllllIIlIIIIIIl.particlesByEmitter.values()) {
                for (int lllllllllllllllIllllllIIlIIIlIll = 0; lllllllllllllllIllllllIIlIIIlIll < lllllllllllllllIllllllIIlIIIlIIl.particles.length; ++lllllllllllllllIllllllIIlIIIlIll) {
                    if (!lllllllllllllllIllllllIIlIIIlIIl.particles[lllllllllllllllIllllllIIlIIIlIll].inUse() || lllllllllllllllIllllllIIlIIIlIIl.particles[lllllllllllllllIllllllIIlIIIlIll].getEmitter() != lllllllllllllllIllllllIIlIIIIIll) continue;
                    lllllllllllllllIllllllIIlIIIlIIl.particles[lllllllllllllllIllllllIIlIIIlIll].setLife(-1.0f);
                    lllllllllllllllIllllllIIlIIIIIIl.release(lllllllllllllllIllllllIIlIIIlIIl.particles[lllllllllllllllIllllllIIlIIIlIll]);
                }
            }
        }
    }

    public ParticleSystem(Image lllllllllllllllIlllllllIIIIIllll) {
        lllllllllllllllIlllllllIIIIIlllI(lllllllllllllllIlllllllIIIIIllll, 100);
        ParticleSystem lllllllllllllllIlllllllIIIIIlllI;
    }

    public void removeAllEmitters() {
        ParticleSystem lllllllllllllllIllllllIlIlllIlII;
        for (int lllllllllllllllIllllllIlIlllIllI = 0; lllllllllllllllIllllllIlIlllIllI < lllllllllllllllIllllllIlIlllIlII.emitters.size(); ++lllllllllllllllIllllllIlIlllIllI) {
            lllllllllllllllIllllllIlIlllIlII.removeEmitter((ParticleEmitter)lllllllllllllllIllllllIlIlllIlII.emitters.get(lllllllllllllllIllllllIlIlllIllI));
            --lllllllllllllllIllllllIlIlllIllI;
        }
    }

    public void setBlendingMode(int lllllllllllllllIllllllIllIlIlIll) {
        lllllllllllllllIllllllIllIlIlIlI.blendingMode = lllllllllllllllIllllllIllIlIlIll;
    }

    public void reset() {
        ParticleSystem lllllllllllllllIllllllIlllllllll;
        for (ParticlePool lllllllllllllllIlllllllIIIIIIIlI : lllllllllllllllIllllllIlllllllll.particlesByEmitter.values()) {
            lllllllllllllllIlllllllIIIIIIIlI.reset(lllllllllllllllIllllllIlllllllll);
        }
        for (int lllllllllllllllIlllllllIIIIIIIII = 0; lllllllllllllllIlllllllIIIIIIIII < lllllllllllllllIllllllIlllllllll.emitters.size(); ++lllllllllllllllIlllllllIIIIIIIII) {
            ParticleEmitter lllllllllllllllIlllllllIIIIIIIIl = (ParticleEmitter)lllllllllllllllIllllllIlllllllll.emitters.get(lllllllllllllllIlllllllIIIIIIIII);
            lllllllllllllllIlllllllIIIIIIIIl.resetState();
        }
    }

    public ParticleEmitter getEmitter(int lllllllllllllllIllllllIllIIlIlll) {
        ParticleSystem lllllllllllllllIllllllIllIIllIII;
        return (ParticleEmitter)lllllllllllllllIllllllIllIIllIII.emitters.get(lllllllllllllllIllllllIllIIlIlll);
    }

    private void loadSystemParticleImage() {
        ParticleSystem lllllllllllllllIllllllIlIIIllIII;
        AccessController.doPrivileged(new PrivilegedAction(){
            {
                1 lllllllllllllllllIlllllIllIlIIll;
            }

            public Object run() {
                1 lllllllllllllllllIlllllIlIllIIIl;
                try {
                    if (lllllllllllllllllIlllllIlIllIIIl.ParticleSystem.this.mask != null) {
                        lllllllllllllllllIlllllIlIllIIIl.ParticleSystem.this.sprite = new Image(lllllllllllllllllIlllllIlIllIIIl.ParticleSystem.this.defaultImageName, lllllllllllllllllIlllllIlIllIIIl.ParticleSystem.this.mask);
                    } else {
                        lllllllllllllllllIlllllIlIllIIIl.ParticleSystem.this.sprite = new Image(lllllllllllllllllIlllllIlIllIIIl.ParticleSystem.this.defaultImageName);
                    }
                }
                catch (SlickException lllllllllllllllllIlllllIlIllIIll) {
                    Log.error(lllllllllllllllllIlllllIlIllIIll);
                    lllllllllllllllllIlllllIlIllIIIl.ParticleSystem.this.defaultImageName = null;
                }
                return null;
            }
        });
    }

    public ParticleSystem duplicate() throws SlickException {
        ParticleSystem lllllllllllllllIllllllIIIIlIllIl;
        for (int lllllllllllllllIllllllIIIIllIlII = 0; lllllllllllllllIllllllIIIIllIlII < lllllllllllllllIllllllIIIIlIllIl.emitters.size(); ++lllllllllllllllIllllllIIIIllIlII) {
            if (lllllllllllllllIllllllIIIIlIllIl.emitters.get(lllllllllllllllIllllllIIIIllIlII) instanceof ConfigurableEmitter) continue;
            throw new SlickException("Only systems contianing configurable emitters can be duplicated");
        }
        ParticleSystem lllllllllllllllIllllllIIIIlIllII = null;
        try {
            ByteArrayOutputStream lllllllllllllllIllllllIIIIllIIlI = new ByteArrayOutputStream();
            ParticleIO.saveConfiguredSystem(lllllllllllllllIllllllIIIIllIIlI, lllllllllllllllIllllllIIIIlIllIl);
            ByteArrayInputStream lllllllllllllllIllllllIIIIllIIIl = new ByteArrayInputStream(lllllllllllllllIllllllIIIIllIIlI.toByteArray());
            lllllllllllllllIllllllIIIIlIllII = ParticleIO.loadConfiguredSystem(lllllllllllllllIllllllIIIIllIIIl);
        }
        catch (IOException lllllllllllllllIllllllIIIIlIlllI) {
            Log.error("Failed to duplicate particle system");
            throw new SlickException("Unable to duplicated particle system", lllllllllllllllIllllllIIIIlIlllI);
        }
        return lllllllllllllllIllllllIIIIlIllII;
    }

    public int getParticleCount() {
        ParticleSystem lllllllllllllllIllllllIIllIlIllI;
        return lllllllllllllllIllllllIIllIlIllI.pCount;
    }

    public float getPositionY() {
        ParticleSystem lllllllllllllllIllllllIlIllIlllI;
        return lllllllllllllllIllllllIlIllIlllI.y;
    }

    static {
        BLEND_COMBINE = 2;
        BLEND_ADDITIVE = 1;
        DEFAULT_PARTICLES = 100;
    }

    public void setVisible(boolean lllllllllllllllIllllllIlllllIIll) {
        lllllllllllllllIllllllIlllllIlII.visible = lllllllllllllllIllllllIlllllIIll;
    }

    public void removeEmitter(ParticleEmitter lllllllllllllllIllllllIlIllllIll) {
        ParticleSystem lllllllllllllllIllllllIlIllllIlI;
        lllllllllllllllIllllllIlIllllIlI.emitters.remove(lllllllllllllllIllllllIlIllllIll);
        lllllllllllllllIllllllIlIllllIlI.particlesByEmitter.remove(lllllllllllllllIllllllIlIllllIll);
    }

    public void moveAll(ParticleEmitter lllllllllllllllIllllllIIIlIlIIlI, float lllllllllllllllIllllllIIIlIlIllI, float lllllllllllllllIllllllIIIlIIlllI) {
        ParticleSystem lllllllllllllllIllllllIIIlIllIlI;
        ParticlePool lllllllllllllllIllllllIIIlIlIlII = (ParticlePool)lllllllllllllllIllllllIIIlIllIlI.particlesByEmitter.get(lllllllllllllllIllllllIIIlIlIIlI);
        for (int lllllllllllllllIllllllIIIlIlllIl = 0; lllllllllllllllIllllllIIIlIlllIl < lllllllllllllllIllllllIIIlIlIlII.particles.length; ++lllllllllllllllIllllllIIIlIlllIl) {
            if (!lllllllllllllllIllllllIIIlIlIlII.particles[lllllllllllllllIllllllIIIlIlllIl].inUse()) continue;
            lllllllllllllllIllllllIIIlIlIlII.particles[lllllllllllllllIllllllIIIlIlllIl].move(lllllllllllllllIllllllIIIlIlIllI, lllllllllllllllIllllllIIIlIIlllI);
        }
    }

    public void release(Particle lllllllllllllllIllllllIIlIlIIlII) {
        ParticleSystem lllllllllllllllIllllllIIlIlIIIll;
        if (lllllllllllllllIllllllIIlIlIIlII != lllllllllllllllIllllllIIlIlIIIll.dummy) {
            ParticlePool lllllllllllllllIllllllIIlIlIIllI = (ParticlePool)lllllllllllllllIllllllIIlIlIIIll.particlesByEmitter.get(lllllllllllllllIllllllIIlIlIIlII.getEmitter());
            lllllllllllllllIllllllIIlIlIIllI.available.add(lllllllllllllllIllllllIIlIlIIlII);
        }
    }

    public int getBlendingMode() {
        ParticleSystem lllllllllllllllIllllllIllIllllII;
        return lllllllllllllllIllllllIllIllllII.blendingMode;
    }

    protected Particle createParticle(ParticleSystem lllllllllllllllIllllllIllIllIlll) {
        return new Particle(lllllllllllllllIllllllIllIllIlll);
    }

    public ParticleSystem(Image lllllllllllllllIllllllIlllIIIlIl, int lllllllllllllllIllllllIlllIIIlII) {
        ParticleSystem lllllllllllllllIllllllIlllIIlIIl;
        lllllllllllllllIllllllIlllIIlIIl.GL = Renderer.get();
        lllllllllllllllIllllllIlllIIlIIl.removeMe = new ArrayList();
        lllllllllllllllIllllllIlllIIlIIl.particlesByEmitter = new HashMap();
        lllllllllllllllIllllllIlllIIlIIl.emitters = new ArrayList();
        lllllllllllllllIllllllIlllIIlIIl.blendingMode = 2;
        lllllllllllllllIllllllIlllIIlIIl.removeCompletedEmitters = true;
        lllllllllllllllIllllllIlllIIlIIl.visible = true;
        lllllllllllllllIllllllIlllIIlIIl.maxParticlesPerEmitter = lllllllllllllllIllllllIlllIIIlII;
        lllllllllllllllIllllllIlllIIlIIl.sprite = lllllllllllllllIllllllIlllIIIlIl;
        lllllllllllllllIllllllIlllIIlIIl.dummy = lllllllllllllllIllllllIlllIIlIIl.createParticle(lllllllllllllllIllllllIlllIIlIIl);
    }

    public ParticleSystem(String lllllllllllllllIllllllIlllIllIlI, int lllllllllllllllIllllllIlllIlllII) {
        lllllllllllllllIllllllIlllIllIll(lllllllllllllllIllllllIlllIllIlI, lllllllllllllllIllllllIlllIlllII, null);
        ParticleSystem lllllllllllllllIllllllIlllIllIll;
    }

    public void update(int lllllllllllllllIllllllIIlllIIllI) {
        ParticleSystem lllllllllllllllIllllllIIlllIIlll;
        if (lllllllllllllllIllllllIIlllIIlll.sprite == null && lllllllllllllllIllllllIIlllIIlll.defaultImageName != null) {
            lllllllllllllllIllllllIIlllIIlll.loadSystemParticleImage();
        }
        lllllllllllllllIllllllIIlllIIlll.removeMe.clear();
        ArrayList lllllllllllllllIllllllIIlllIIlIl = new ArrayList(lllllllllllllllIllllllIIlllIIlll.emitters);
        for (int lllllllllllllllIllllllIIlllIlllI = 0; lllllllllllllllIllllllIIlllIlllI < lllllllllllllllIllllllIIlllIIlIl.size(); ++lllllllllllllllIllllllIIlllIlllI) {
            ParticleEmitter lllllllllllllllIllllllIIllllIIII = (ParticleEmitter)lllllllllllllllIllllllIIlllIIlIl.get(lllllllllllllllIllllllIIlllIlllI);
            if (!lllllllllllllllIllllllIIllllIIII.isEnabled()) continue;
            lllllllllllllllIllllllIIllllIIII.update(lllllllllllllllIllllllIIlllIIlll, lllllllllllllllIllllllIIlllIIllI);
            if (!lllllllllllllllIllllllIIlllIIlll.removeCompletedEmitters || !lllllllllllllllIllllllIIllllIIII.completed()) continue;
            lllllllllllllllIllllllIIlllIIlll.removeMe.add(lllllllllllllllIllllllIIllllIIII);
            lllllllllllllllIllllllIIlllIIlll.particlesByEmitter.remove(lllllllllllllllIllllllIIllllIIII);
        }
        lllllllllllllllIllllllIIlllIIlll.emitters.removeAll(lllllllllllllllIllllllIIlllIIlll.removeMe);
        lllllllllllllllIllllllIIlllIIlll.pCount = 0;
        if (!lllllllllllllllIllllllIIlllIIlll.particlesByEmitter.isEmpty()) {
            for (ParticleEmitter lllllllllllllllIllllllIIlllIlIIl : lllllllllllllllIllllllIIlllIIlll.particlesByEmitter.keySet()) {
                if (!lllllllllllllllIllllllIIlllIlIIl.isEnabled()) continue;
                ParticlePool lllllllllllllllIllllllIIlllIlIlI = (ParticlePool)lllllllllllllllIllllllIIlllIIlll.particlesByEmitter.get(lllllllllllllllIllllllIIlllIlIIl);
                for (int lllllllllllllllIllllllIIlllIlIll = 0; lllllllllllllllIllllllIIlllIlIll < lllllllllllllllIllllllIIlllIlIlI.particles.length; ++lllllllllllllllIllllllIIlllIlIll) {
                    if (!(lllllllllllllllIllllllIIlllIlIlI.particles[lllllllllllllllIllllllIIlllIlIll].life > 0.0f)) continue;
                    lllllllllllllllIllllllIIlllIlIlI.particles[lllllllllllllllIllllllIIlllIlIll].update(lllllllllllllllIllllllIIlllIIllI);
                    ++lllllllllllllllIllllllIIlllIIlll.pCount;
                }
            }
        }
    }

    public void setRemoveCompletedEmitters(boolean lllllllllllllllIllllllIllllIllIl) {
        lllllllllllllllIllllllIllllIlllI.removeCompletedEmitters = lllllllllllllllIllllllIllllIllIl;
    }

    public void setUsePoints(boolean lllllllllllllllIllllllIllllIIlll) {
        lllllllllllllllIllllllIllllIIllI.usePoints = lllllllllllllllIllllllIllllIIlll;
    }

    public void setDefaultImageName(String lllllllllllllllIllllllIlllIIIIII) {
        lllllllllllllllIllllllIllIllllll.defaultImageName = lllllllllllllllIllllllIlllIIIIII;
        lllllllllllllllIllllllIllIllllll.sprite = null;
    }

    public void render() {
        ParticleSystem lllllllllllllllIllllllIlIllIIIIl;
        lllllllllllllllIllllllIlIllIIIIl.render(lllllllllllllllIllllllIlIllIIIIl.x, lllllllllllllllIllllllIlIllIIIIl.y);
    }

    public boolean isVisible() {
        ParticleSystem lllllllllllllllIllllllIlllllIlll;
        return lllllllllllllllIllllllIlllllIlll.visible;
    }

    public int getEmitterCount() {
        ParticleSystem lllllllllllllllIllllllIllIlIIIlI;
        return lllllllllllllllIllllllIllIlIIIlI.emitters.size();
    }

    public ParticleSystem(String lllllllllllllllIllllllIlllIlIIll, int lllllllllllllllIllllllIlllIlIIlI, Color lllllllllllllllIllllllIlllIIllIl) {
        ParticleSystem lllllllllllllllIllllllIlllIlIlII;
        lllllllllllllllIllllllIlllIlIlII.GL = Renderer.get();
        lllllllllllllllIllllllIlllIlIlII.removeMe = new ArrayList();
        lllllllllllllllIllllllIlllIlIlII.particlesByEmitter = new HashMap();
        lllllllllllllllIllllllIlllIlIlII.emitters = new ArrayList();
        lllllllllllllllIllllllIlllIlIlII.blendingMode = 2;
        lllllllllllllllIllllllIlllIlIlII.removeCompletedEmitters = true;
        lllllllllllllllIllllllIlllIlIlII.visible = true;
        lllllllllllllllIllllllIlllIlIlII.maxParticlesPerEmitter = lllllllllllllllIllllllIlllIlIIlI;
        lllllllllllllllIllllllIlllIlIlII.mask = lllllllllllllllIllllllIlllIIllIl;
        lllllllllllllllIllllllIlllIlIlII.setDefaultImageName(lllllllllllllllIllllllIlllIlIIll);
        lllllllllllllllIllllllIlllIlIlII.dummy = lllllllllllllllIllllllIlllIlIlII.createParticle(lllllllllllllllIllllllIlllIlIlII);
    }

    public ParticleSystem(String lllllllllllllllIlllllllIIIIIlIIl) {
        lllllllllllllllIlllllllIIIIIlIlI(lllllllllllllllIlllllllIIIIIlIIl, 100);
        ParticleSystem lllllllllllllllIlllllllIIIIIlIlI;
    }

    public void setPosition(float lllllllllllllllIllllllIlIllIIlIl, float lllllllllllllllIllllllIlIllIIlII) {
        lllllllllllllllIllllllIlIllIIllI.x = lllllllllllllllIllllllIlIllIIlIl;
        lllllllllllllllIllllllIlIllIIllI.y = lllllllllllllllIllllllIlIllIIlII;
    }

    private class ParticlePool {
        public /* synthetic */ ArrayList available;
        public /* synthetic */ Particle[] particles;

        public ParticlePool(ParticleSystem lllIlllIllllI, int lllIlllIllIIl) {
            ParticlePool lllIlllIlllll;
            lllIlllIlllll.particles = new Particle[lllIlllIllIIl];
            lllIlllIlllll.available = new ArrayList();
            for (int lllIllllIIIII = 0; lllIllllIIIII < lllIlllIlllll.particles.length; ++lllIllllIIIII) {
                lllIlllIlllll.particles[lllIllllIIIII] = lllIlllIlllll.ParticleSystem.this.createParticle(lllIlllIllllI);
            }
            lllIlllIlllll.reset(lllIlllIllllI);
        }

        public void reset(ParticleSystem lllIlllIlIIll) {
            ParticlePool lllIlllIlIlII;
            lllIlllIlIlII.available.clear();
            for (int lllIlllIlIlIl = 0; lllIlllIlIlIl < lllIlllIlIlII.particles.length; ++lllIlllIlIlIl) {
                lllIlllIlIlII.available.add(lllIlllIlIlII.particles[lllIlllIlIlIl]);
            }
        }
    }
}

