/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font.effects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.GeneralPath;
import java.util.List;
import org.newdawn.slick.font.effects.ConfigurableEffect;
import org.newdawn.slick.font.effects.EffectUtil;
import org.newdawn.slick.font.effects.OutlineEffect;

public class OutlineWobbleEffect
extends OutlineEffect {
    private /* synthetic */ float amplitude;
    private /* synthetic */ float detail;

    public void setAmplitude(float llllllllllllllllIllIIllIIIllIIlI) {
        llllllllllllllllIllIIllIIIllIlIl.amplitude = llllllllllllllllIllIIllIIIllIIlI;
    }

    @Override
    public String toString() {
        return "Outline (Wobble)";
    }

    @Override
    public List getValues() {
        OutlineWobbleEffect llllllllllllllllIllIIllIIIlIIIll;
        List llllllllllllllllIllIIllIIIlIIlII = super.getValues();
        llllllllllllllllIllIIllIIIlIIlII.remove(2);
        llllllllllllllllIllIIllIIIlIIlII.add(EffectUtil.floatValue("Detail", llllllllllllllllIllIIllIIIlIIIll.detail, 1.0f, 50.0f, "This setting controls how detailed the outline will be. Smaller numbers cause the outline to have more detail."));
        llllllllllllllllIllIIllIIIlIIlII.add(EffectUtil.floatValue("Amplitude", llllllllllllllllIllIIllIIIlIIIll.amplitude, 0.5f, 50.0f, "This setting controls the amplitude of the outline."));
        return llllllllllllllllIllIIllIIIlIIlII;
    }

    public OutlineWobbleEffect(int llllllllllllllllIllIIllIIIlIlIlI, Color llllllllllllllllIllIIllIIIlIlIIl) {
        super(llllllllllllllllIllIIllIIIlIlIlI, llllllllllllllllIllIIllIIIlIlIIl);
        OutlineWobbleEffect llllllllllllllllIllIIllIIIlIlIll;
        llllllllllllllllIllIIllIIIlIlIll.detail = 1.0f;
        llllllllllllllllIllIIllIIIlIlIll.amplitude = 1.0f;
    }

    public float getAmplitude() {
        OutlineWobbleEffect llllllllllllllllIllIIllIIIlllIII;
        return llllllllllllllllIllIIllIIIlllIII.amplitude;
    }

    public OutlineWobbleEffect() {
        OutlineWobbleEffect llllllllllllllllIllIIllIIlIIIlII;
        llllllllllllllllIllIIllIIlIIIlII.detail = 1.0f;
        llllllllllllllllIllIIllIIlIIIlII.amplitude = 1.0f;
        llllllllllllllllIllIIllIIlIIIlII.setStroke(llllllllllllllllIllIIllIIlIIIlII.new WobbleStroke());
    }

    public void setDetail(float llllllllllllllllIllIIllIIIlllIll) {
        llllllllllllllllIllIIllIIIlllllI.detail = llllllllllllllllIllIIllIIIlllIll;
    }

    @Override
    public void setValues(List llllllllllllllllIllIIllIIIIllIII) {
        OutlineWobbleEffect llllllllllllllllIllIIllIIIIllIll;
        super.setValues(llllllllllllllllIllIIllIIIIllIII);
        for (ConfigurableEffect.Value llllllllllllllllIllIIllIIIIlllIl : llllllllllllllllIllIIllIIIIllIII) {
            if (llllllllllllllllIllIIllIIIIlllIl.getName().equals("Detail")) {
                llllllllllllllllIllIIllIIIIllIll.detail = ((Float)llllllllllllllllIllIIllIIIIlllIl.getObject()).floatValue();
                continue;
            }
            if (!llllllllllllllllIllIIllIIIIlllIl.getName().equals("Amplitude")) continue;
            llllllllllllllllIllIIllIIIIllIll.amplitude = ((Float)llllllllllllllllIllIIllIIIIlllIl.getObject()).floatValue();
        }
    }

    public float getDetail() {
        OutlineWobbleEffect llllllllllllllllIllIIllIIlIIIIIl;
        return llllllllllllllllIllIIllIIlIIIIIl.detail;
    }

    private class WobbleStroke
    implements Stroke {
        private static final /* synthetic */ float FLATNESS = 1.0f;

        private WobbleStroke() {
            WobbleStroke llllllllllllllllllIIIllIlIllllll;
        }

        private float randomize(float llllllllllllllllllIIIllIIIIlllll) {
            WobbleStroke llllllllllllllllllIIIllIIIlIIlII;
            return llllllllllllllllllIIIllIIIIlllll + (float)Math.random() * llllllllllllllllllIIIllIIIlIIlII.OutlineWobbleEffect.this.amplitude * 2.0f - 1.0f;
        }

        @Override
        public Shape createStrokedShape(Shape llllllllllllllllllIIIllIIlIllIIl) {
            WobbleStroke llllllllllllllllllIIIllIIlIllIll;
            GeneralPath llllllllllllllllllIIIllIIlIlIlll = new GeneralPath();
            llllllllllllllllllIIIllIIlIllIIl = new BasicStroke(llllllllllllllllllIIIllIIlIllIll.OutlineWobbleEffect.this.getWidth(), 2, llllllllllllllllllIIIllIIlIllIll.OutlineWobbleEffect.this.getJoin()).createStrokedShape(llllllllllllllllllIIIllIIlIllIIl);
            FlatteningPathIterator llllllllllllllllllIIIllIIlIlIlIl = new FlatteningPathIterator(llllllllllllllllllIIIllIIlIllIIl.getPathIterator(null), 1.0);
            float[] llllllllllllllllllIIIllIIlIlIIll = new float[6];
            float llllllllllllllllllIIIllIIlIlIIIl = 0.0f;
            float llllllllllllllllllIIIllIIlIIllll = 0.0f;
            float llllllllllllllllllIIIllIIlIIllIl = 0.0f;
            float llllllllllllllllllIIIllIIlIIlIll = 0.0f;
            float llllllllllllllllllIIIllIIlIIlIlI = 0.0f;
            float llllllllllllllllllIIIllIIlIIlIIl = 0.0f;
            int llllllllllllllllllIIIllIIlIIlIII = 0;
            float llllllllllllllllllIIIllIIlIIIlll = 0.0f;
            while (!llllllllllllllllllIIIllIIlIlIlIl.isDone()) {
                llllllllllllllllllIIIllIIlIIlIII = llllllllllllllllllIIIllIIlIlIlIl.currentSegment(llllllllllllllllllIIIllIIlIlIIll);
                switch (llllllllllllllllllIIIllIIlIIlIII) {
                    case 0: {
                        llllllllllllllllllIIIllIIlIlIIIl = llllllllllllllllllIIIllIIlIIllIl = llllllllllllllllllIIIllIIlIllIll.randomize(llllllllllllllllllIIIllIIlIlIIll[0]);
                        llllllllllllllllllIIIllIIlIIllll = llllllllllllllllllIIIllIIlIIlIll = llllllllllllllllllIIIllIIlIllIll.randomize(llllllllllllllllllIIIllIIlIlIIll[1]);
                        llllllllllllllllllIIIllIIlIlIlll.moveTo(llllllllllllllllllIIIllIIlIlIIIl, llllllllllllllllllIIIllIIlIIllll);
                        llllllllllllllllllIIIllIIlIIIlll = 0.0f;
                        break;
                    }
                    case 4: {
                        llllllllllllllllllIIIllIIlIlIIll[0] = llllllllllllllllllIIIllIIlIlIIIl;
                        llllllllllllllllllIIIllIIlIlIIll[1] = llllllllllllllllllIIIllIIlIIllll;
                    }
                    case 1: {
                        llllllllllllllllllIIIllIIlIIlIlI = llllllllllllllllllIIIllIIlIllIll.randomize(llllllllllllllllllIIIllIIlIlIIll[0]);
                        llllllllllllllllllIIIllIIlIIlIIl = llllllllllllllllllIIIllIIlIllIll.randomize(llllllllllllllllllIIIllIIlIlIIll[1]);
                        float llllllllllllllllllIIIllIIllIIIIl = llllllllllllllllllIIIllIIlIIlIlI - llllllllllllllllllIIIllIIlIIllIl;
                        float llllllllllllllllllIIIllIIlIlllll = llllllllllllllllllIIIllIIlIIlIIl - llllllllllllllllllIIIllIIlIIlIll;
                        float llllllllllllllllllIIIllIIlIlllIl = (float)Math.sqrt(llllllllllllllllllIIIllIIllIIIIl * llllllllllllllllllIIIllIIllIIIIl + llllllllllllllllllIIIllIIlIlllll * llllllllllllllllllIIIllIIlIlllll);
                        if (llllllllllllllllllIIIllIIlIlllIl >= llllllllllllllllllIIIllIIlIIIlll) {
                            float llllllllllllllllllIIIllIIllIIIll = 1.0f / llllllllllllllllllIIIllIIlIlllIl;
                            while (llllllllllllllllllIIIllIIlIlllIl >= llllllllllllllllllIIIllIIlIIIlll) {
                                float llllllllllllllllllIIIllIIllIIllI = llllllllllllllllllIIIllIIlIIllIl + llllllllllllllllllIIIllIIlIIIlll * llllllllllllllllllIIIllIIllIIIIl * llllllllllllllllllIIIllIIllIIIll;
                                float llllllllllllllllllIIIllIIllIIlIl = llllllllllllllllllIIIllIIlIIlIll + llllllllllllllllllIIIllIIlIIIlll * llllllllllllllllllIIIllIIlIlllll * llllllllllllllllllIIIllIIllIIIll;
                                llllllllllllllllllIIIllIIlIlIlll.lineTo(llllllllllllllllllIIIllIIlIllIll.randomize(llllllllllllllllllIIIllIIllIIllI), llllllllllllllllllIIIllIIlIllIll.randomize(llllllllllllllllllIIIllIIllIIlIl));
                                llllllllllllllllllIIIllIIlIIIlll += llllllllllllllllllIIIllIIlIllIll.OutlineWobbleEffect.this.detail;
                            }
                        }
                        llllllllllllllllllIIIllIIlIIIlll -= llllllllllllllllllIIIllIIlIlllIl;
                        llllllllllllllllllIIIllIIlIIllIl = llllllllllllllllllIIIllIIlIIlIlI;
                        llllllllllllllllllIIIllIIlIIlIll = llllllllllllllllllIIIllIIlIIlIIl;
                    }
                }
                llllllllllllllllllIIIllIIlIlIlIl.next();
            }
            return llllllllllllllllllIIIllIIlIlIlll;
        }
    }
}

