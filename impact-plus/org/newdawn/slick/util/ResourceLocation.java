/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util;

import java.io.InputStream;
import java.net.URL;

public interface ResourceLocation {
    public URL getResource(String var1);

    public InputStream getResourceAsStream(String var1);
}

