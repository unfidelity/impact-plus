/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.font.effects;

import java.util.List;
import org.newdawn.slick.font.effects.Effect;

public interface ConfigurableEffect
extends Effect {
    public void setValues(List var1);

    public List getValues();

    public static interface Value {
        public void setString(String var1);

        public void showDialog();

        public Object getObject();

        public String getName();

        public String getString();
    }
}

