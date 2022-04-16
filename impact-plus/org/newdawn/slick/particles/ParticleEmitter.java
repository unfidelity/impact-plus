/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.particles;

import org.newdawn.slick.Image;
import org.newdawn.slick.particles.Particle;
import org.newdawn.slick.particles.ParticleSystem;

public interface ParticleEmitter {
    public boolean usePoints(ParticleSystem var1);

    public boolean isEnabled();

    public boolean isOriented();

    public void resetState();

    public boolean useAdditive();

    public boolean completed();

    public void updateParticle(Particle var1, int var2);

    public Image getImage();

    public void setEnabled(boolean var1);

    public void wrapUp();

    public void update(ParticleSystem var1, int var2);
}

