/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.particles;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.particles.Particle;
import org.newdawn.slick.particles.ParticleEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.util.FastTrig;
import org.newdawn.slick.util.Log;

public class ConfigurableEmitter
implements ParticleEmitter {
    protected /* synthetic */ boolean wrapUp;
    public /* synthetic */ SimpleValue endAlpha;
    public /* synthetic */ int usePoints;
    public /* synthetic */ SimpleValue gravityFactor;
    public /* synthetic */ Range initialDistance;
    private /* synthetic */ ParticleSystem engine;
    public /* synthetic */ Range initialSize;
    public /* synthetic */ LinearInterpolator size;
    public /* synthetic */ LinearInterpolator alpha;
    private static /* synthetic */ String relativePath;
    public /* synthetic */ LinearInterpolator velocity;
    public /* synthetic */ Range xOffset;
    protected /* synthetic */ boolean completed;
    private /* synthetic */ float x;
    public /* synthetic */ RandomValue spread;
    public /* synthetic */ Range speed;
    private /* synthetic */ int timeout;
    public /* synthetic */ SimpleValue growthFactor;
    public /* synthetic */ boolean useAdditive;
    private /* synthetic */ int leftToEmit;
    public /* synthetic */ Range yOffset;
    public /* synthetic */ SimpleValue windFactor;
    private /* synthetic */ boolean enabled;
    public /* synthetic */ Range initialLife;
    private /* synthetic */ float y;
    public /* synthetic */ String name;
    public /* synthetic */ Range emitCount;
    public /* synthetic */ String imageName;
    public /* synthetic */ Range length;
    public /* synthetic */ boolean useOriented;
    protected /* synthetic */ float adjustx;
    public /* synthetic */ SimpleValue startAlpha;
    private /* synthetic */ boolean updateImage;
    public /* synthetic */ SimpleValue angularOffset;
    public /* synthetic */ Range spawnCount;
    private /* synthetic */ int nextSpawn;
    public /* synthetic */ LinearInterpolator scaleY;
    public /* synthetic */ ArrayList colors;
    public /* synthetic */ Range spawnInterval;
    private /* synthetic */ int particleCount;
    protected /* synthetic */ float adjusty;
    private /* synthetic */ Image image;
    protected /* synthetic */ boolean adjust;

    public float getX() {
        ConfigurableEmitter llllllllllllllllIIIlIIIIIIllllII;
        return llllllllllllllllIIIlIIIIIIllllII.x;
    }

    @Override
    public Image getImage() {
        ConfigurableEmitter llllllllllllllllIIIIlllllIlIIlll;
        return llllllllllllllllIIIIlllllIlIIlll.image;
    }

    @Override
    public boolean completed() {
        ConfigurableEmitter llllllllllllllllIIIIllllllIlIlIl;
        if (llllllllllllllllIIIIllllllIlIlIl.engine == null) {
            return false;
        }
        if (llllllllllllllllIIIIllllllIlIlIl.length.isEnabled()) {
            if (llllllllllllllllIIIIllllllIlIlIl.timeout > 0) {
                return false;
            }
            return llllllllllllllllIIIIllllllIlIlIl.completed;
        }
        if (llllllllllllllllIIIIllllllIlIlIl.emitCount.isEnabled()) {
            if (llllllllllllllllIIIIllllllIlIlIl.leftToEmit > 0) {
                return false;
            }
            return llllllllllllllllIIIIllllllIlIlIl.completed;
        }
        if (llllllllllllllllIIIIllllllIlIlIl.wrapUp) {
            return llllllllllllllllIIIIllllllIlIlIl.completed;
        }
        return false;
    }

    @Override
    public void resetState() {
        ConfigurableEmitter llllllllllllllllIIIIlllllIlIIIII;
        llllllllllllllllIIIIlllllIlIIIII.wrapUp = false;
        llllllllllllllllIIIIlllllIlIIIII.replay();
    }

    public void replayCheck() {
        ConfigurableEmitter llllllllllllllllIIIIllllllIIllII;
        if (llllllllllllllllIIIIllllllIIllII.completed() && llllllllllllllllIIIIllllllIIllII.engine != null && llllllllllllllllIIIIllllllIIllII.engine.getParticleCount() == 0) {
            llllllllllllllllIIIIllllllIIllII.replay();
        }
    }

    public ConfigurableEmitter(String llllllllllllllllIIIlIIIIIllIIIIl) {
        ConfigurableEmitter llllllllllllllllIIIlIIIIIllIIIlI;
        llllllllllllllllIIIlIIIIIllIIIlI.spawnInterval = llllllllllllllllIIIlIIIIIllIIIlI.new Range(100.0f, 100.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.spawnCount = llllllllllllllllIIIlIIIIIllIIIlI.new Range(5.0f, 5.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.initialLife = llllllllllllllllIIIlIIIIIllIIIlI.new Range(1000.0f, 1000.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.initialSize = llllllllllllllllIIIlIIIIIllIIIlI.new Range(10.0f, 10.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.xOffset = llllllllllllllllIIIlIIIIIllIIIlI.new Range(0.0f, 0.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.yOffset = llllllllllllllllIIIlIIIIIllIIIlI.new Range(0.0f, 0.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.spread = llllllllllllllllIIIlIIIIIllIIIlI.new RandomValue(360.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.angularOffset = llllllllllllllllIIIlIIIIIllIIIlI.new SimpleValue(0.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.initialDistance = llllllllllllllllIIIlIIIIIllIIIlI.new Range(0.0f, 0.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.speed = llllllllllllllllIIIlIIIIIllIIIlI.new Range(50.0f, 50.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.growthFactor = llllllllllllllllIIIlIIIIIllIIIlI.new SimpleValue(0.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.gravityFactor = llllllllllllllllIIIlIIIIIllIIIlI.new SimpleValue(0.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.windFactor = llllllllllllllllIIIlIIIIIllIIIlI.new SimpleValue(0.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.length = llllllllllllllllIIIlIIIIIllIIIlI.new Range(1000.0f, 1000.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.colors = new ArrayList();
        llllllllllllllllIIIlIIIIIllIIIlI.startAlpha = llllllllllllllllIIIlIIIIIllIIIlI.new SimpleValue(255.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.endAlpha = llllllllllllllllIIIlIIIIIllIIIlI.new SimpleValue(0.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.emitCount = llllllllllllllllIIIlIIIIIllIIIlI.new Range(1000.0f, 1000.0f);
        llllllllllllllllIIIlIIIIIllIIIlI.usePoints = 1;
        llllllllllllllllIIIlIIIIIllIIIlI.useOriented = false;
        llllllllllllllllIIIlIIIIIllIIIlI.useAdditive = false;
        llllllllllllllllIIIlIIIIIllIIIlI.imageName = "";
        llllllllllllllllIIIlIIIIIllIIIlI.enabled = true;
        llllllllllllllllIIIlIIIIIllIIIlI.nextSpawn = 0;
        llllllllllllllllIIIlIIIIIllIIIlI.wrapUp = false;
        llllllllllllllllIIIlIIIIIllIIIlI.completed = false;
        llllllllllllllllIIIlIIIIIllIIIlI.name = llllllllllllllllIIIlIIIIIllIIIIl;
        llllllllllllllllIIIlIIIIIllIIIlI.leftToEmit = (int)llllllllllllllllIIIlIIIIIllIIIlI.emitCount.random();
        llllllllllllllllIIIlIIIIIllIIIlI.timeout = (int)llllllllllllllllIIIlIIIIIllIIIlI.length.random();
        llllllllllllllllIIIlIIIIIllIIIlI.colors.add(llllllllllllllllIIIlIIIIIllIIIlI.new ColorRecord(0.0f, Color.white));
        llllllllllllllllIIIlIIIIIllIIIlI.colors.add(llllllllllllllllIIIlIIIIIllIIIlI.new ColorRecord(1.0f, Color.red));
        ArrayList<Vector2f> llllllllllllllllIIIlIIIIIllIIIll = new ArrayList<Vector2f>();
        llllllllllllllllIIIlIIIIIllIIIll.add(new Vector2f(0.0f, 0.0f));
        llllllllllllllllIIIlIIIIIllIIIll.add(new Vector2f(1.0f, 255.0f));
        llllllllllllllllIIIlIIIIIllIIIlI.alpha = llllllllllllllllIIIlIIIIIllIIIlI.new LinearInterpolator(llllllllllllllllIIIlIIIIIllIIIll, 0, 255);
        llllllllllllllllIIIlIIIIIllIIIll = new ArrayList();
        llllllllllllllllIIIlIIIIIllIIIll.add(new Vector2f(0.0f, 0.0f));
        llllllllllllllllIIIlIIIIIllIIIll.add(new Vector2f(1.0f, 255.0f));
        llllllllllllllllIIIlIIIIIllIIIlI.size = llllllllllllllllIIIlIIIIIllIIIlI.new LinearInterpolator(llllllllllllllllIIIlIIIIIllIIIll, 0, 255);
        llllllllllllllllIIIlIIIIIllIIIll = new ArrayList();
        llllllllllllllllIIIlIIIIIllIIIll.add(new Vector2f(0.0f, 0.0f));
        llllllllllllllllIIIlIIIIIllIIIll.add(new Vector2f(1.0f, 1.0f));
        llllllllllllllllIIIlIIIIIllIIIlI.velocity = llllllllllllllllIIIlIIIIIllIIIlI.new LinearInterpolator(llllllllllllllllIIIlIIIIIllIIIll, 0, 1);
        llllllllllllllllIIIlIIIIIllIIIll = new ArrayList();
        llllllllllllllllIIIlIIIIIllIIIll.add(new Vector2f(0.0f, 0.0f));
        llllllllllllllllIIIlIIIIIllIIIll.add(new Vector2f(1.0f, 1.0f));
        llllllllllllllllIIIlIIIIIllIIIlI.scaleY = llllllllllllllllIIIlIIIIIllIIIlI.new LinearInterpolator(llllllllllllllllIIIlIIIIIllIIIll, 0, 1);
    }

    public void reset() {
        ConfigurableEmitter llllllllllllllllIIIIllllllIIlllI;
        llllllllllllllllIIIIllllllIIlllI.completed = false;
        if (llllllllllllllllIIIIllllllIIlllI.engine != null) {
            llllllllllllllllIIIIllllllIIlllI.engine.releaseAll(llllllllllllllllIIIIllllllIIlllI);
        }
    }

    @Override
    public boolean usePoints(ParticleSystem llllllllllllllllIIIIlllllIlIlIll) {
        ConfigurableEmitter llllllllllllllllIIIIlllllIlIlIlI;
        return llllllllllllllllIIIIlllllIlIlIlI.usePoints == 1 && llllllllllllllllIIIIlllllIlIlIll.usePoints() || llllllllllllllllIIIIlllllIlIlIlI.usePoints == 2;
    }

    @Override
    public void wrapUp() {
        llllllllllllllllIIIIlllllIlIIlII.wrapUp = true;
    }

    public void setPosition(float llllllllllllllllIIIlIIIIIlIIllII, float llllllllllllllllIIIlIIIIIlIIlIll) {
        ConfigurableEmitter llllllllllllllllIIIlIIIIIlIlIIII;
        llllllllllllllllIIIlIIIIIlIlIIII.setPosition(llllllllllllllllIIIlIIIIIlIIllII, llllllllllllllllIIIlIIIIIlIIlIll, true);
    }

    public String getImageName() {
        ConfigurableEmitter llllllllllllllllIIIlIIIIIlIlIlll;
        return llllllllllllllllIIIlIIIIIlIlIlll.imageName;
    }

    public String toString() {
        ConfigurableEmitter llllllllllllllllIIIlIIIIIlIlIlII;
        return String.valueOf(new StringBuilder().append("[").append(llllllllllllllllIIIlIIIIIlIlIlII.name).append("]"));
    }

    @Override
    public boolean useAdditive() {
        ConfigurableEmitter llllllllllllllllIIIIlllllIllIIll;
        return llllllllllllllllIIIIlllllIllIIll.useAdditive;
    }

    @Override
    public void update(ParticleSystem llllllllllllllllIIIlIIIIIIIlIIll, int llllllllllllllllIIIlIIIIIIIIllll) {
        ConfigurableEmitter llllllllllllllllIIIlIIIIIIIlIIIl;
        llllllllllllllllIIIlIIIIIIIlIIIl.engine = llllllllllllllllIIIlIIIIIIIlIIll;
        if (!llllllllllllllllIIIlIIIIIIIlIIIl.adjust) {
            llllllllllllllllIIIlIIIIIIIlIIIl.adjustx = 0.0f;
            llllllllllllllllIIIlIIIIIIIlIIIl.adjusty = 0.0f;
        } else {
            llllllllllllllllIIIlIIIIIIIlIIIl.adjust = false;
        }
        if (llllllllllllllllIIIlIIIIIIIlIIIl.updateImage) {
            llllllllllllllllIIIlIIIIIIIlIIIl.updateImage = false;
            try {
                llllllllllllllllIIIlIIIIIIIlIIIl.image = new Image(String.valueOf(new StringBuilder().append(relativePath).append(llllllllllllllllIIIlIIIIIIIlIIIl.imageName)));
            }
            catch (SlickException llllllllllllllllIIIlIIIIIIlIIIIl) {
                llllllllllllllllIIIlIIIIIIIlIIIl.image = null;
                Log.error(llllllllllllllllIIIlIIIIIIlIIIIl);
            }
        }
        if ((llllllllllllllllIIIlIIIIIIIlIIIl.wrapUp || llllllllllllllllIIIlIIIIIIIlIIIl.length.isEnabled() && llllllllllllllllIIIlIIIIIIIlIIIl.timeout < 0 || llllllllllllllllIIIlIIIIIIIlIIIl.emitCount.isEnabled() && llllllllllllllllIIIlIIIIIIIlIIIl.leftToEmit <= 0) && llllllllllllllllIIIlIIIIIIIlIIIl.particleCount == 0) {
            llllllllllllllllIIIlIIIIIIIlIIIl.completed = true;
        }
        llllllllllllllllIIIlIIIIIIIlIIIl.particleCount = 0;
        if (llllllllllllllllIIIlIIIIIIIlIIIl.wrapUp) {
            return;
        }
        if (llllllllllllllllIIIlIIIIIIIlIIIl.length.isEnabled()) {
            if (llllllllllllllllIIIlIIIIIIIlIIIl.timeout < 0) {
                return;
            }
            llllllllllllllllIIIlIIIIIIIlIIIl.timeout -= llllllllllllllllIIIlIIIIIIIIllll;
        }
        if (llllllllllllllllIIIlIIIIIIIlIIIl.emitCount.isEnabled() && llllllllllllllllIIIlIIIIIIIlIIIl.leftToEmit <= 0) {
            return;
        }
        llllllllllllllllIIIlIIIIIIIlIIIl.nextSpawn -= llllllllllllllllIIIlIIIIIIIIllll;
        if (llllllllllllllllIIIlIIIIIIIlIIIl.nextSpawn < 0) {
            llllllllllllllllIIIlIIIIIIIlIIIl.nextSpawn = (int)llllllllllllllllIIIlIIIIIIIlIIIl.spawnInterval.random();
            int llllllllllllllllIIIlIIIIIIIlIlIl = (int)llllllllllllllllIIIlIIIIIIIlIIIl.spawnCount.random();
            for (int llllllllllllllllIIIlIIIIIIIlIllI = 0; llllllllllllllllIIIlIIIIIIIlIllI < llllllllllllllllIIIlIIIIIIIlIlIl; ++llllllllllllllllIIIlIIIIIIIlIllI) {
                Particle llllllllllllllllIIIlIIIIIIIllIlI = llllllllllllllllIIIlIIIIIIIlIIll.getNewParticle(llllllllllllllllIIIlIIIIIIIlIIIl, llllllllllllllllIIIlIIIIIIIlIIIl.initialLife.random());
                llllllllllllllllIIIlIIIIIIIllIlI.setSize(llllllllllllllllIIIlIIIIIIIlIIIl.initialSize.random());
                llllllllllllllllIIIlIIIIIIIllIlI.setPosition(llllllllllllllllIIIlIIIIIIIlIIIl.x + llllllllllllllllIIIlIIIIIIIlIIIl.xOffset.random(), llllllllllllllllIIIlIIIIIIIlIIIl.y + llllllllllllllllIIIlIIIIIIIlIIIl.yOffset.random());
                llllllllllllllllIIIlIIIIIIIllIlI.setVelocity(0.0f, 0.0f, 0.0f);
                float llllllllllllllllIIIlIIIIIIIllIIl = llllllllllllllllIIIlIIIIIIIlIIIl.initialDistance.random();
                float llllllllllllllllIIIlIIIIIIIllIII = llllllllllllllllIIIlIIIIIIIlIIIl.speed.random();
                if (llllllllllllllllIIIlIIIIIIIllIIl != 0.0f || llllllllllllllllIIIlIIIIIIIllIII != 0.0f) {
                    float llllllllllllllllIIIlIIIIIIlIIIII = llllllllllllllllIIIlIIIIIIIlIIIl.spread.getValue(0.0f);
                    float llllllllllllllllIIIlIIIIIIIlllll = llllllllllllllllIIIlIIIIIIlIIIII + llllllllllllllllIIIlIIIIIIIlIIIl.angularOffset.getValue(0.0f) - llllllllllllllllIIIlIIIIIIIlIIIl.spread.getValue() / 2.0f - 90.0f;
                    float llllllllllllllllIIIlIIIIIIIllllI = (float)FastTrig.cos(Math.toRadians(llllllllllllllllIIIlIIIIIIIlllll)) * llllllllllllllllIIIlIIIIIIIllIIl;
                    float llllllllllllllllIIIlIIIIIIIlllIl = (float)FastTrig.sin(Math.toRadians(llllllllllllllllIIIlIIIIIIIlllll)) * llllllllllllllllIIIlIIIIIIIllIIl;
                    llllllllllllllllIIIlIIIIIIIllIlI.adjustPosition(llllllllllllllllIIIlIIIIIIIllllI, llllllllllllllllIIIlIIIIIIIlllIl);
                    float llllllllllllllllIIIlIIIIIIIlllII = (float)FastTrig.cos(Math.toRadians(llllllllllllllllIIIlIIIIIIIlllll));
                    float llllllllllllllllIIIlIIIIIIIllIll = (float)FastTrig.sin(Math.toRadians(llllllllllllllllIIIlIIIIIIIlllll));
                    llllllllllllllllIIIlIIIIIIIllIlI.setVelocity(llllllllllllllllIIIlIIIIIIIlllII, llllllllllllllllIIIlIIIIIIIllIll, llllllllllllllllIIIlIIIIIIIllIII * 0.001f);
                }
                if (llllllllllllllllIIIlIIIIIIIlIIIl.image != null) {
                    llllllllllllllllIIIlIIIIIIIllIlI.setImage(llllllllllllllllIIIlIIIIIIIlIIIl.image);
                }
                ColorRecord llllllllllllllllIIIlIIIIIIIlIlll = (ColorRecord)llllllllllllllllIIIlIIIIIIIlIIIl.colors.get(0);
                llllllllllllllllIIIlIIIIIIIllIlI.setColor(llllllllllllllllIIIlIIIIIIIlIlll.col.r, llllllllllllllllIIIlIIIIIIIlIlll.col.g, llllllllllllllllIIIlIIIIIIIlIlll.col.b, llllllllllllllllIIIlIIIIIIIlIIIl.startAlpha.getValue(0.0f) / 255.0f);
                llllllllllllllllIIIlIIIIIIIllIlI.setUsePoint(llllllllllllllllIIIlIIIIIIIlIIIl.usePoints);
                llllllllllllllllIIIlIIIIIIIllIlI.setOriented(llllllllllllllllIIIlIIIIIIIlIIIl.useOriented);
                if (!llllllllllllllllIIIlIIIIIIIlIIIl.emitCount.isEnabled()) continue;
                --llllllllllllllllIIIlIIIIIIIlIIIl.leftToEmit;
                if (llllllllllllllllIIIlIIIIIIIlIIIl.leftToEmit <= 0) break;
            }
        }
    }

    public void setImageName(String llllllllllllllllIIIlIIIIIlIlllII) {
        if (llllllllllllllllIIIlIIIIIlIlllII.length() == 0) {
            llllllllllllllllIIIlIIIIIlIlllII = null;
        }
        llllllllllllllllIIIlIIIIIlIlllIl.imageName = llllllllllllllllIIIlIIIIIlIlllII;
        if (llllllllllllllllIIIlIIIIIlIlllII == null) {
            llllllllllllllllIIIlIIIIIlIlllIl.image = null;
        } else {
            llllllllllllllllIIIlIIIIIlIlllIl.updateImage = true;
        }
    }

    static {
        relativePath = "";
    }

    @Override
    public boolean isEnabled() {
        ConfigurableEmitter llllllllllllllllIIIlIIIIIIllIlll;
        return llllllllllllllllIIIlIIIIIIllIlll.enabled;
    }

    @Override
    public boolean isOriented() {
        ConfigurableEmitter llllllllllllllllIIIIlllllIllIIII;
        return llllllllllllllllIIIIlllllIllIIII.useOriented;
    }

    public void addColorPoint(float llllllllllllllllIIIIlllllIllIllI, Color llllllllllllllllIIIIlllllIlllIII) {
        ConfigurableEmitter llllllllllllllllIIIIlllllIllIlll;
        llllllllllllllllIIIIlllllIllIlll.colors.add(llllllllllllllllIIIIlllllIllIlll.new ColorRecord(llllllllllllllllIIIIlllllIllIllI, llllllllllllllllIIIIlllllIlllIII));
    }

    @Override
    public void setEnabled(boolean llllllllllllllllIIIlIIIIIIllIIlI) {
        llllllllllllllllIIIlIIIIIIllIIll.enabled = llllllllllllllllIIIlIIIIIIllIIlI;
    }

    public ConfigurableEmitter duplicate() {
        ConfigurableEmitter llllllllllllllllIIIIllllllIIIIlI = null;
        try {
            ConfigurableEmitter llllllllllllllllIIIIllllllIIIIIl;
            ByteArrayOutputStream llllllllllllllllIIIIllllllIIIllI = new ByteArrayOutputStream();
            ParticleIO.saveEmitter(llllllllllllllllIIIIllllllIIIllI, llllllllllllllllIIIIllllllIIIIIl);
            ByteArrayInputStream llllllllllllllllIIIIllllllIIIlIl = new ByteArrayInputStream(llllllllllllllllIIIIllllllIIIllI.toByteArray());
            llllllllllllllllIIIIllllllIIIIlI = ParticleIO.loadEmitter(llllllllllllllllIIIIllllllIIIlIl);
        }
        catch (IOException llllllllllllllllIIIIllllllIIIlII) {
            Log.error(String.valueOf(new StringBuilder().append("Slick: ConfigurableEmitter.duplicate(): caught exception ").append(llllllllllllllllIIIIllllllIIIlII.toString())));
            return null;
        }
        return llllllllllllllllIIIIllllllIIIIlI;
    }

    public float getY() {
        ConfigurableEmitter llllllllllllllllIIIlIIIIIIlllIlI;
        return llllllllllllllllIIIlIIIIIIlllIlI.y;
    }

    public static void setRelativePath(String llllllllllllllllIIIlIIIIIllIlIlI) {
        if (!llllllllllllllllIIIlIIIIIllIlIlI.endsWith("/")) {
            llllllllllllllllIIIlIIIIIllIlIlI = String.valueOf(new StringBuilder().append(llllllllllllllllIIIlIIIIIllIlIlI).append("/"));
        }
        relativePath = llllllllllllllllIIIlIIIIIllIlIlI;
    }

    public void setPosition(float llllllllllllllllIIIlIIIIIlIIIIIl, float llllllllllllllllIIIlIIIIIlIIIIII, boolean llllllllllllllllIIIlIIIIIIllllll) {
        if (llllllllllllllllIIIlIIIIIIllllll) {
            ConfigurableEmitter llllllllllllllllIIIlIIIIIlIIIIlI;
            llllllllllllllllIIIlIIIIIlIIIIlI.adjust = true;
            llllllllllllllllIIIlIIIIIlIIIIlI.adjustx -= llllllllllllllllIIIlIIIIIlIIIIlI.x - llllllllllllllllIIIlIIIIIlIIIIIl;
            llllllllllllllllIIIlIIIIIlIIIIlI.adjusty -= llllllllllllllllIIIlIIIIIlIIIIlI.y - llllllllllllllllIIIlIIIIIlIIIIII;
        }
        llllllllllllllllIIIlIIIIIlIIIIlI.x = llllllllllllllllIIIlIIIIIlIIIIIl;
        llllllllllllllllIIIlIIIIIlIIIIlI.y = llllllllllllllllIIIlIIIIIlIIIIII;
    }

    @Override
    public void updateParticle(Particle llllllllllllllllIIIIlllllllIIIlI, int llllllllllllllllIIIIlllllllIlIlI) {
        ConfigurableEmitter llllllllllllllllIIIIlllllllIIIll;
        ++llllllllllllllllIIIIlllllllIIIll.particleCount;
        llllllllllllllllIIIIlllllllIIIlI.x += llllllllllllllllIIIIlllllllIIIll.adjustx;
        llllllllllllllllIIIIlllllllIIIlI.y += llllllllllllllllIIIIlllllllIIIll.adjusty;
        llllllllllllllllIIIIlllllllIIIlI.adjustVelocity(llllllllllllllllIIIIlllllllIIIll.windFactor.getValue(0.0f) * 5.0E-5f * (float)llllllllllllllllIIIIlllllllIlIlI, llllllllllllllllIIIIlllllllIIIll.gravityFactor.getValue(0.0f) * 5.0E-5f * (float)llllllllllllllllIIIIlllllllIlIlI);
        float llllllllllllllllIIIIlllllllIlIIl = llllllllllllllllIIIIlllllllIIIlI.getLife() / llllllllllllllllIIIIlllllllIIIlI.getOriginalLife();
        float llllllllllllllllIIIIlllllllIlIII = 1.0f - llllllllllllllllIIIIlllllllIlIIl;
        float llllllllllllllllIIIIlllllllIIlll = 0.0f;
        float llllllllllllllllIIIIlllllllIIllI = 1.0f;
        Color llllllllllllllllIIIIlllllllIIlIl = null;
        Color llllllllllllllllIIIIlllllllIIlII = null;
        for (int llllllllllllllllIIIIllllllllIIll = 0; llllllllllllllllIIIIllllllllIIll < llllllllllllllllIIIIlllllllIIIll.colors.size() - 1; ++llllllllllllllllIIIIllllllllIIll) {
            ColorRecord llllllllllllllllIIIIllllllllIlIl = (ColorRecord)llllllllllllllllIIIIlllllllIIIll.colors.get(llllllllllllllllIIIIllllllllIIll);
            ColorRecord llllllllllllllllIIIIllllllllIlII = (ColorRecord)llllllllllllllllIIIIlllllllIIIll.colors.get(llllllllllllllllIIIIllllllllIIll + 1);
            if (!(llllllllllllllllIIIIlllllllIlIII >= llllllllllllllllIIIIllllllllIlIl.pos) || !(llllllllllllllllIIIIlllllllIlIII <= llllllllllllllllIIIIllllllllIlII.pos)) continue;
            llllllllllllllllIIIIlllllllIIlIl = llllllllllllllllIIIIllllllllIlIl.col;
            llllllllllllllllIIIIlllllllIIlII = llllllllllllllllIIIIllllllllIlII.col;
            float llllllllllllllllIIIIllllllllIllI = llllllllllllllllIIIIllllllllIlII.pos - llllllllllllllllIIIIllllllllIlIl.pos;
            llllllllllllllllIIIIlllllllIIlll = llllllllllllllllIIIIlllllllIlIII - llllllllllllllllIIIIllllllllIlIl.pos;
            llllllllllllllllIIIIlllllllIIlll /= llllllllllllllllIIIIllllllllIllI;
            llllllllllllllllIIIIlllllllIIlll = 1.0f - llllllllllllllllIIIIlllllllIIlll;
            llllllllllllllllIIIIlllllllIIllI = 1.0f - llllllllllllllllIIIIlllllllIIlll;
        }
        if (llllllllllllllllIIIIlllllllIIlIl != null) {
            float llllllllllllllllIIIIlllllllIlllI;
            float llllllllllllllllIIIIllllllllIIIl = llllllllllllllllIIIIlllllllIIlIl.r * llllllllllllllllIIIIlllllllIIlll + llllllllllllllllIIIIlllllllIIlII.r * llllllllllllllllIIIIlllllllIIllI;
            float llllllllllllllllIIIIllllllllIIII = llllllllllllllllIIIIlllllllIIlIl.g * llllllllllllllllIIIIlllllllIIlll + llllllllllllllllIIIIlllllllIIlII.g * llllllllllllllllIIIIlllllllIIllI;
            float llllllllllllllllIIIIlllllllIllll = llllllllllllllllIIIIlllllllIIlIl.b * llllllllllllllllIIIIlllllllIIlll + llllllllllllllllIIIIlllllllIIlII.b * llllllllllllllllIIIIlllllllIIllI;
            if (llllllllllllllllIIIIlllllllIIIll.alpha.isActive()) {
                float llllllllllllllllIIIIllllllllIIlI = llllllllllllllllIIIIlllllllIIIll.alpha.getValue(llllllllllllllllIIIIlllllllIlIII) / 255.0f;
            } else {
                llllllllllllllllIIIIlllllllIlllI = llllllllllllllllIIIIlllllllIIIll.startAlpha.getValue(0.0f) / 255.0f * llllllllllllllllIIIIlllllllIlIIl + llllllllllllllllIIIIlllllllIIIll.endAlpha.getValue(0.0f) / 255.0f * llllllllllllllllIIIIlllllllIlIII;
            }
            llllllllllllllllIIIIlllllllIIIlI.setColor(llllllllllllllllIIIIllllllllIIIl, llllllllllllllllIIIIllllllllIIII, llllllllllllllllIIIIlllllllIllll, llllllllllllllllIIIIlllllllIlllI);
        }
        if (llllllllllllllllIIIIlllllllIIIll.size.isActive()) {
            float llllllllllllllllIIIIlllllllIllIl = llllllllllllllllIIIIlllllllIIIll.size.getValue(llllllllllllllllIIIIlllllllIlIII);
            llllllllllllllllIIIIlllllllIIIlI.setSize(llllllllllllllllIIIIlllllllIllIl);
        } else {
            llllllllllllllllIIIIlllllllIIIlI.adjustSize((float)llllllllllllllllIIIIlllllllIlIlI * llllllllllllllllIIIIlllllllIIIll.growthFactor.getValue(0.0f) * 0.001f);
        }
        if (llllllllllllllllIIIIlllllllIIIll.velocity.isActive()) {
            llllllllllllllllIIIIlllllllIIIlI.setSpeed(llllllllllllllllIIIIlllllllIIIll.velocity.getValue(llllllllllllllllIIIIlllllllIlIII));
        }
        if (llllllllllllllllIIIIlllllllIIIll.scaleY.isActive()) {
            llllllllllllllllIIIIlllllllIIIlI.setScaleY(llllllllllllllllIIIIlllllllIIIll.scaleY.getValue(llllllllllllllllIIIIlllllllIlIII));
        }
    }

    public void replay() {
        ConfigurableEmitter llllllllllllllllIIIIllllllIlIIIl;
        llllllllllllllllIIIIllllllIlIIIl.reset();
        llllllllllllllllIIIIllllllIlIIIl.nextSpawn = 0;
        llllllllllllllllIIIIllllllIlIIIl.leftToEmit = (int)llllllllllllllllIIIIllllllIlIIIl.emitCount.random();
        llllllllllllllllIIIIllllllIlIIIl.timeout = (int)llllllllllllllllIIIIllllllIlIIIl.length.random();
    }

    public class SimpleValue
    implements Value {
        private /* synthetic */ float value;
        private /* synthetic */ float next;

        @Override
        public float getValue(float llllllllllllllllIllIIIIIlIlIIlIl) {
            SimpleValue llllllllllllllllIllIIIIIlIlIIllI;
            return llllllllllllllllIllIIIIIlIlIIllI.value;
        }

        private SimpleValue(float llllllllllllllllIllIIIIIlIlIllII) {
            SimpleValue llllllllllllllllIllIIIIIlIlIllll;
            llllllllllllllllIllIIIIIlIlIllll.value = llllllllllllllllIllIIIIIlIlIllII;
        }

        public void setValue(float llllllllllllllllIllIIIIIlIIllIll) {
            llllllllllllllllIllIIIIIlIIllIIl.value = llllllllllllllllIllIIIIIlIIllIll;
        }
    }

    public class ColorRecord {
        public /* synthetic */ Color col;
        public /* synthetic */ float pos;

        public ColorRecord(float llIIIIlIIIIllll, Color llIIIIlIIIIlllI) {
            ColorRecord llIIIIlIIIlIIII;
            llIIIIlIIIlIIII.pos = llIIIIlIIIIllll;
            llIIIIlIIIlIIII.col = llIIIIlIIIIlllI;
        }
    }

    public class RandomValue
    implements Value {
        private /* synthetic */ float value;

        @Override
        public float getValue(float lllllllllllllllllIIIlIIllIlIIlll) {
            RandomValue lllllllllllllllllIIIlIIllIlIlIII;
            return (float)(Math.random() * (double)lllllllllllllllllIIIlIIllIlIlIII.value);
        }

        private RandomValue(float lllllllllllllllllIIIlIIllIlIllIl) {
            RandomValue lllllllllllllllllIIIlIIllIlIlllI;
            lllllllllllllllllIIIlIIllIlIlllI.value = lllllllllllllllllIIIlIIllIlIllIl;
        }

        public void setValue(float lllllllllllllllllIIIlIIllIlIIIlI) {
            lllllllllllllllllIIIlIIllIlIIIIl.value = lllllllllllllllllIIIlIIllIlIIIlI;
        }

        public float getValue() {
            RandomValue lllllllllllllllllIIIlIIllIIllllI;
            return lllllllllllllllllIIIlIIllIIllllI.value;
        }
    }

    public class LinearInterpolator
    implements Value {
        private /* synthetic */ int min;
        private /* synthetic */ int max;
        private /* synthetic */ boolean active;
        private /* synthetic */ ArrayList curve;

        public ArrayList getCurve() {
            LinearInterpolator llIllIlIIIIIlII;
            return llIllIlIIIIIlII.curve;
        }

        public void setMax(int llIllIIllIlllIl) {
            llIllIIlllIIIII.max = llIllIIllIlllIl;
        }

        public int getMin() {
            LinearInterpolator llIllIIllIllIlI;
            return llIllIIllIllIlI.min;
        }

        @Override
        public float getValue(float llIllIIllllIlll) {
            LinearInterpolator llIllIIlllllIII;
            Vector2f llIllIIllllIllI = (Vector2f)llIllIIlllllIII.curve.get(0);
            for (int llIllIIlllllIIl = 1; llIllIIlllllIIl < llIllIIlllllIII.curve.size(); ++llIllIIlllllIIl) {
                Vector2f llIllIIlllllIlI = (Vector2f)llIllIIlllllIII.curve.get(llIllIIlllllIIl);
                if (llIllIIllllIlll >= llIllIIllllIllI.getX() && llIllIIllllIlll <= llIllIIlllllIlI.getX()) {
                    float llIllIIllllllII = (llIllIIllllIlll - llIllIIllllIllI.getX()) / (llIllIIlllllIlI.getX() - llIllIIllllIllI.getX());
                    float llIllIIlllllIll = llIllIIllllIllI.getY() + llIllIIllllllII * (llIllIIlllllIlI.getY() - llIllIIllllIllI.getY());
                    return llIllIIlllllIll;
                }
                llIllIIllllIllI = llIllIIlllllIlI;
            }
            return 0.0f;
        }

        public void setMin(int llIllIIllIlIlII) {
            llIllIIllIlIlIl.min = llIllIIllIlIlII;
        }

        public boolean isActive() {
            LinearInterpolator llIllIIlllIllIl;
            return llIllIIlllIllIl.active;
        }

        public int getMax() {
            LinearInterpolator llIllIIlllIIlII;
            return llIllIIlllIIlII.max;
        }

        public LinearInterpolator(ArrayList llIllIlIIIlIlII, int llIllIlIIIIlllI, int llIllIlIIIIllIl) {
            LinearInterpolator llIllIlIIIlIlIl;
            llIllIlIIIlIlIl.curve = llIllIlIIIlIlII;
            llIllIlIIIlIlIl.min = llIllIlIIIIlllI;
            llIllIlIIIlIlIl.max = llIllIlIIIIllIl;
            llIllIlIIIlIlIl.active = false;
        }

        public void setCurve(ArrayList llIllIlIIIIIlll) {
            llIllIlIIIIlIlI.curve = llIllIlIIIIIlll;
        }

        public void setActive(boolean llIllIIlllIIllI) {
            llIllIIlllIIlll.active = llIllIIlllIIllI;
        }
    }

    public static interface Value {
        public float getValue(float var1);
    }

    public class Range {
        private /* synthetic */ float min;
        private /* synthetic */ float max;
        private /* synthetic */ boolean enabled;

        public float random() {
            Range lllllllllllllllIllllIlllIlllIIll;
            return (float)((double)lllllllllllllllIllllIlllIlllIIll.min + Math.random() * (double)(lllllllllllllllIllllIlllIlllIIll.max - lllllllllllllllIllllIlllIlllIIll.min));
        }

        public float getMax() {
            Range lllllllllllllllIllllIlllIllIlIII;
            return lllllllllllllllIllllIlllIllIlIII.max;
        }

        public void setMin(float lllllllllllllllIllllIlllIlIllIII) {
            lllllllllllllllIllllIlllIlIllIll.min = lllllllllllllllIllllIlllIlIllIII;
        }

        public void setEnabled(boolean lllllllllllllllIllllIlllIllIlIlI) {
            lllllllllllllllIllllIlllIllIllIl.enabled = lllllllllllllllIllllIlllIllIlIlI;
        }

        public void setMax(float lllllllllllllllIllllIlllIllIIIll) {
            lllllllllllllllIllllIlllIllIIIlI.max = lllllllllllllllIllllIlllIllIIIll;
        }

        public boolean isEnabled() {
            Range lllllllllllllllIllllIlllIlllIIII;
            return lllllllllllllllIllllIlllIlllIIII.enabled;
        }

        private Range(float lllllllllllllllIllllIlllIllllIll, float lllllllllllllllIllllIlllIllllIlI) {
            Range lllllllllllllllIllllIlllIlllllII;
            lllllllllllllllIllllIlllIlllllII.enabled = false;
            lllllllllllllllIllllIlllIlllllII.min = lllllllllllllllIllllIlllIllllIll;
            lllllllllllllllIllllIlllIlllllII.max = lllllllllllllllIllllIlllIllllIlI;
        }

        public float getMin() {
            Range lllllllllllllllIllllIlllIlIllllI;
            return lllllllllllllllIllllIlllIlIllllI.min;
        }
    }
}

