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

public class OutlineZigzagEffect
extends OutlineEffect {
    private /* synthetic */ float wavelength;
    private /* synthetic */ float amplitude;

    public float getWavelength() {
        OutlineZigzagEffect lllllllllllllllllllIIIllIIlllllI;
        return lllllllllllllllllllIIIllIIlllllI.wavelength;
    }

    @Override
    public String toString() {
        return "Outline (Zigzag)";
    }

    public float getAmplitude() {
        OutlineZigzagEffect lllllllllllllllllllIIIllIIllIIll;
        return lllllllllllllllllllIIIllIIllIIll.amplitude;
    }

    public OutlineZigzagEffect(int lllllllllllllllllllIIIllIIIllIII, Color lllllllllllllllllllIIIllIIIlIlII) {
        super(lllllllllllllllllllIIIllIIIllIII, lllllllllllllllllllIIIllIIIlIlII);
        OutlineZigzagEffect lllllllllllllllllllIIIllIIIllIIl;
        lllllllllllllllllllIIIllIIIllIIl.amplitude = 1.0f;
        lllllllllllllllllllIIIllIIIllIIl.wavelength = 3.0f;
    }

    public OutlineZigzagEffect() {
        OutlineZigzagEffect lllllllllllllllllllIIIllIlIIIIlI;
        lllllllllllllllllllIIIllIlIIIIlI.amplitude = 1.0f;
        lllllllllllllllllllIIIllIlIIIIlI.wavelength = 3.0f;
        lllllllllllllllllllIIIllIlIIIIlI.setStroke(lllllllllllllllllllIIIllIlIIIIlI.new ZigzagStroke());
    }

    public void setAmplitude(float lllllllllllllllllllIIIllIIlIIIlI) {
        lllllllllllllllllllIIIllIIlIIlII.amplitude = lllllllllllllllllllIIIllIIlIIIlI;
    }

    public void setWavelength(float lllllllllllllllllllIIIllIIlllIII) {
        lllllllllllllllllllIIIllIIlllIll.wavelength = lllllllllllllllllllIIIllIIlllIII;
    }

    @Override
    public void setValues(List lllllllllllllllllllIIIllIIIIIlIl) {
        OutlineZigzagEffect lllllllllllllllllllIIIllIIIIIlII;
        super.setValues(lllllllllllllllllllIIIllIIIIIlIl);
        for (ConfigurableEffect.Value lllllllllllllllllllIIIllIIIIlIII : lllllllllllllllllllIIIllIIIIIlIl) {
            if (lllllllllllllllllllIIIllIIIIlIII.getName().equals("Wavelength")) {
                lllllllllllllllllllIIIllIIIIIlII.wavelength = ((Float)lllllllllllllllllllIIIllIIIIlIII.getObject()).floatValue();
                continue;
            }
            if (!lllllllllllllllllllIIIllIIIIlIII.getName().equals("Amplitude")) continue;
            lllllllllllllllllllIIIllIIIIIlII.amplitude = ((Float)lllllllllllllllllllIIIllIIIIlIII.getObject()).floatValue();
        }
    }

    @Override
    public List getValues() {
        OutlineZigzagEffect lllllllllllllllllllIIIllIIIlIIII;
        List lllllllllllllllllllIIIllIIIIllll = super.getValues();
        lllllllllllllllllllIIIllIIIIllll.add(EffectUtil.floatValue("Wavelength", lllllllllllllllllllIIIllIIIlIIII.wavelength, 1.0f, 100.0f, "This setting controls the wavelength of the outline. The smaller the value, the more segments will be used to draw the outline."));
        lllllllllllllllllllIIIllIIIIllll.add(EffectUtil.floatValue("Amplitude", lllllllllllllllllllIIIllIIIlIIII.amplitude, 0.5f, 50.0f, "This setting controls the amplitude of the outline. The bigger the value, the more the zigzags will vary."));
        return lllllllllllllllllllIIIllIIIIllll;
    }

    private class ZigzagStroke
    implements Stroke {
        private static final /* synthetic */ float FLATNESS = 1.0f;

        private ZigzagStroke() {
            ZigzagStroke llllllllllllllllIlIIIlllIIlIlIII;
        }

        @Override
        public Shape createStrokedShape(Shape llllllllllllllllIlIIIllIllllllII) {
            ZigzagStroke llllllllllllllllIlIIIlllIIIIlIll;
            GeneralPath llllllllllllllllIlIIIlllIIIIlIIl = new GeneralPath();
            FlatteningPathIterator llllllllllllllllIlIIIlllIIIIlIII = new FlatteningPathIterator(llllllllllllllllIlIIIllIllllllII.getPathIterator(null), 1.0);
            float[] llllllllllllllllIlIIIlllIIIIIlll = new float[6];
            float llllllllllllllllIlIIIlllIIIIIllI = 0.0f;
            float llllllllllllllllIlIIIlllIIIIIlIl = 0.0f;
            float llllllllllllllllIlIIIlllIIIIIlII = 0.0f;
            float llllllllllllllllIlIIIlllIIIIIIll = 0.0f;
            float llllllllllllllllIlIIIlllIIIIIIlI = 0.0f;
            float llllllllllllllllIlIIIlllIIIIIIIl = 0.0f;
            int llllllllllllllllIlIIIlllIIIIIIII = 0;
            float llllllllllllllllIlIIIllIllllllll = 0.0f;
            int llllllllllllllllIlIIIllIlllllllI = 0;
            while (!llllllllllllllllIlIIIlllIIIIlIII.isDone()) {
                llllllllllllllllIlIIIlllIIIIIIII = llllllllllllllllIlIIIlllIIIIlIII.currentSegment(llllllllllllllllIlIIIlllIIIIIlll);
                switch (llllllllllllllllIlIIIlllIIIIIIII) {
                    case 0: {
                        llllllllllllllllIlIIIlllIIIIIllI = llllllllllllllllIlIIIlllIIIIIlII = llllllllllllllllIlIIIlllIIIIIlll[0];
                        llllllllllllllllIlIIIlllIIIIIlIl = llllllllllllllllIlIIIlllIIIIIIll = llllllllllllllllIlIIIlllIIIIIlll[1];
                        llllllllllllllllIlIIIlllIIIIlIIl.moveTo(llllllllllllllllIlIIIlllIIIIIllI, llllllllllllllllIlIIIlllIIIIIlIl);
                        llllllllllllllllIlIIIllIllllllll = llllllllllllllllIlIIIlllIIIIlIll.OutlineZigzagEffect.this.wavelength / 2.0f;
                        break;
                    }
                    case 4: {
                        llllllllllllllllIlIIIlllIIIIIlll[0] = llllllllllllllllIlIIIlllIIIIIllI;
                        llllllllllllllllIlIIIlllIIIIIlll[1] = llllllllllllllllIlIIIlllIIIIIlIl;
                    }
                    case 1: {
                        llllllllllllllllIlIIIlllIIIIIIlI = llllllllllllllllIlIIIlllIIIIIlll[0];
                        llllllllllllllllIlIIIlllIIIIIIIl = llllllllllllllllIlIIIlllIIIIIlll[1];
                        float llllllllllllllllIlIIIlllIIIIlllI = llllllllllllllllIlIIIlllIIIIIIlI - llllllllllllllllIlIIIlllIIIIIlII;
                        float llllllllllllllllIlIIIlllIIIIllIl = llllllllllllllllIlIIIlllIIIIIIIl - llllllllllllllllIlIIIlllIIIIIIll;
                        float llllllllllllllllIlIIIlllIIIIllII = (float)Math.sqrt(llllllllllllllllIlIIIlllIIIIlllI * llllllllllllllllIlIIIlllIIIIlllI + llllllllllllllllIlIIIlllIIIIllIl * llllllllllllllllIlIIIlllIIIIllIl);
                        if (llllllllllllllllIlIIIlllIIIIllII >= llllllllllllllllIlIIIllIllllllll) {
                            float llllllllllllllllIlIIIlllIIIIllll = 1.0f / llllllllllllllllIlIIIlllIIIIllII;
                            while (llllllllllllllllIlIIIlllIIIIllII >= llllllllllllllllIlIIIllIllllllll) {
                                float llllllllllllllllIlIIIlllIIIlIIIl = llllllllllllllllIlIIIlllIIIIIlII + llllllllllllllllIlIIIllIllllllll * llllllllllllllllIlIIIlllIIIIlllI * llllllllllllllllIlIIIlllIIIIllll;
                                float llllllllllllllllIlIIIlllIIIlIIII = llllllllllllllllIlIIIlllIIIIIIll + llllllllllllllllIlIIIllIllllllll * llllllllllllllllIlIIIlllIIIIllIl * llllllllllllllllIlIIIlllIIIIllll;
                                if (!(llllllllllllllllIlIIIllIlllllllI & true)) {
                                    llllllllllllllllIlIIIlllIIIIlIIl.lineTo(llllllllllllllllIlIIIlllIIIlIIIl + llllllllllllllllIlIIIlllIIIIlIll.OutlineZigzagEffect.this.amplitude * llllllllllllllllIlIIIlllIIIIllIl * llllllllllllllllIlIIIlllIIIIllll, llllllllllllllllIlIIIlllIIIlIIII - llllllllllllllllIlIIIlllIIIIlIll.OutlineZigzagEffect.this.amplitude * llllllllllllllllIlIIIlllIIIIlllI * llllllllllllllllIlIIIlllIIIIllll);
                                } else {
                                    llllllllllllllllIlIIIlllIIIIlIIl.lineTo(llllllllllllllllIlIIIlllIIIlIIIl - llllllllllllllllIlIIIlllIIIIlIll.OutlineZigzagEffect.this.amplitude * llllllllllllllllIlIIIlllIIIIllIl * llllllllllllllllIlIIIlllIIIIllll, llllllllllllllllIlIIIlllIIIlIIII + llllllllllllllllIlIIIlllIIIIlIll.OutlineZigzagEffect.this.amplitude * llllllllllllllllIlIIIlllIIIIlllI * llllllllllllllllIlIIIlllIIIIllll);
                                }
                                llllllllllllllllIlIIIllIllllllll += llllllllllllllllIlIIIlllIIIIlIll.OutlineZigzagEffect.this.wavelength;
                                ++llllllllllllllllIlIIIllIlllllllI;
                            }
                        }
                        llllllllllllllllIlIIIllIllllllll -= llllllllllllllllIlIIIlllIIIIllII;
                        llllllllllllllllIlIIIlllIIIIIlII = llllllllllllllllIlIIIlllIIIIIIlI;
                        llllllllllllllllIlIIIlllIIIIIIll = llllllllllllllllIlIIIlllIIIIIIIl;
                        if (llllllllllllllllIlIIIlllIIIIIIII != 4) break;
                        llllllllllllllllIlIIIlllIIIIlIIl.closePath();
                    }
                }
                llllllllllllllllIlIIIlllIIIIlIII.next();
            }
            return new BasicStroke(llllllllllllllllIlIIIlllIIIIlIll.OutlineZigzagEffect.this.getWidth(), 2, llllllllllllllllIlIIIlllIIIIlIll.OutlineZigzagEffect.this.getJoin()).createStrokedShape(llllllllllllllllIlIIIlllIIIIlIIl);
        }
    }
}

