/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.openal;

import java.io.IOException;

interface AudioInputStream {
    public int read(byte[] var1, int var2, int var3) throws IOException;

    public boolean atEnd();

    public int getRate();

    public int getChannels();

    public int read(byte[] var1) throws IOException;

    public void close() throws IOException;

    public int read() throws IOException;
}

