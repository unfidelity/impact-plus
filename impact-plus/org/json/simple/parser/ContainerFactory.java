/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple.parser;

import java.util.List;
import java.util.Map;

public interface ContainerFactory {
    public List creatArrayContainer();

    public Map createObjectContainer();
}

