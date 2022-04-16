/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface Game {
    public void update(GameContainer var1, int var2) throws SlickException;

    public void init(GameContainer var1) throws SlickException;

    public void render(GameContainer var1, Graphics var2) throws SlickException;

    public String getTitle();

    public boolean closeRequested();
}

