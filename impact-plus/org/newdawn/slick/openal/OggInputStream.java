/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.jcraft.jogg.Packet
 *  com.jcraft.jogg.Page
 *  com.jcraft.jogg.StreamState
 *  com.jcraft.jogg.SyncState
 *  com.jcraft.jorbis.Block
 *  com.jcraft.jorbis.Comment
 *  com.jcraft.jorbis.DspState
 *  com.jcraft.jorbis.Info
 *  org.lwjgl.BufferUtils
 */
package org.newdawn.slick.openal;

import com.jcraft.jogg.Packet;
import com.jcraft.jogg.Page;
import com.jcraft.jogg.StreamState;
import com.jcraft.jogg.SyncState;
import com.jcraft.jorbis.Block;
import com.jcraft.jorbis.Comment;
import com.jcraft.jorbis.DspState;
import com.jcraft.jorbis.Info;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.lwjgl.BufferUtils;
import org.newdawn.slick.openal.AudioInputStream;
import org.newdawn.slick.util.Log;

public class OggInputStream
extends InputStream
implements AudioInputStream {
    private /* synthetic */ Info oggInfo;
    /* synthetic */ boolean inited;
    private /* synthetic */ byte[] convbuffer;
    private /* synthetic */ int total;
    private /* synthetic */ boolean endOfStream;
    private /* synthetic */ ByteBuffer pcmBuffer;
    private /* synthetic */ DspState dspState;
    private /* synthetic */ Packet packet;
    private /* synthetic */ int convsize;
    private /* synthetic */ Block vorbisBlock;
    /* synthetic */ boolean endOfBitStream;
    /* synthetic */ int bytes;
    /* synthetic */ byte[] buffer;
    private /* synthetic */ InputStream input;
    private /* synthetic */ Page page;
    private /* synthetic */ int readIndex;
    private /* synthetic */ StreamState streamState;
    private /* synthetic */ Comment comment;
    private /* synthetic */ SyncState syncState;
    /* synthetic */ boolean bigEndian;

    private void readPCM() throws IOException {
        OggInputStream llIIlIlIIIIIIll;
        boolean llIIlIlIIIIIIlI = false;
        while (true) {
            if (llIIlIlIIIIIIll.endOfBitStream) {
                if (!llIIlIlIIIIIIll.getPageAndPacket()) break;
                llIIlIlIIIIIIll.endOfBitStream = false;
            }
            if (!llIIlIlIIIIIIll.inited) {
                llIIlIlIIIIIIll.inited = true;
                return;
            }
            float[][][] llIIlIlIIIIIlIl = new float[1][][];
            int[] llIIlIlIIIIIlII = new int[llIIlIlIIIIIIll.oggInfo.channels];
            while (!llIIlIlIIIIIIll.endOfBitStream) {
                int llIIlIlIIIIlIII;
                while (!llIIlIlIIIIIIll.endOfBitStream && (llIIlIlIIIIlIII = llIIlIlIIIIIIll.syncState.pageout(llIIlIlIIIIIIll.page)) != 0) {
                    if (llIIlIlIIIIlIII == -1) {
                        Log.error("Corrupt or missing data in bitstream; continuing...");
                        continue;
                    }
                    llIIlIlIIIIIIll.streamState.pagein(llIIlIlIIIIIIll.page);
                    while ((llIIlIlIIIIlIII = llIIlIlIIIIIIll.streamState.packetout(llIIlIlIIIIIIll.packet)) != 0) {
                        int llIIlIlIIIIlIIl;
                        if (llIIlIlIIIIlIII == -1) continue;
                        if (llIIlIlIIIIIIll.vorbisBlock.synthesis(llIIlIlIIIIIIll.packet) == 0) {
                            llIIlIlIIIIIIll.dspState.synthesis_blockin(llIIlIlIIIIIIll.vorbisBlock);
                        }
                        while ((llIIlIlIIIIlIIl = llIIlIlIIIIIIll.dspState.synthesis_pcmout((float[][][])llIIlIlIIIIIlIl, llIIlIlIIIIIlII)) > 0) {
                            float[][] llIIlIlIIIIllII = llIIlIlIIIIIlIl[0];
                            int llIIlIlIIIIlIll = llIIlIlIIIIlIIl < llIIlIlIIIIIIll.convsize ? llIIlIlIIIIlIIl : llIIlIlIIIIIIll.convsize;
                            for (int llIIlIlIIIIllIl = 0; llIIlIlIIIIllIl < llIIlIlIIIIIIll.oggInfo.channels; ++llIIlIlIIIIllIl) {
                                int llIIlIlIIIIllll = llIIlIlIIIIllIl * 2;
                                int llIIlIlIIIIlllI = llIIlIlIIIIIlII[llIIlIlIIIIllIl];
                                for (int llIIlIlIIIlIIII = 0; llIIlIlIIIlIIII < llIIlIlIIIIlIll; ++llIIlIlIIIlIIII) {
                                    int llIIlIlIIIlIIIl = (int)((double)llIIlIlIIIIllII[llIIlIlIIIIllIl][llIIlIlIIIIlllI + llIIlIlIIIlIIII] * 32767.0);
                                    if (llIIlIlIIIlIIIl > Short.MAX_VALUE) {
                                        llIIlIlIIIlIIIl = Short.MAX_VALUE;
                                    }
                                    if (llIIlIlIIIlIIIl < Short.MIN_VALUE) {
                                        llIIlIlIIIlIIIl = Short.MIN_VALUE;
                                    }
                                    if (llIIlIlIIIlIIIl < 0) {
                                        llIIlIlIIIlIIIl |= 0x8000;
                                    }
                                    if (llIIlIlIIIIIIll.bigEndian) {
                                        llIIlIlIIIIIIll.convbuffer[llIIlIlIIIIllll] = (byte)(llIIlIlIIIlIIIl >>> 8);
                                        llIIlIlIIIIIIll.convbuffer[llIIlIlIIIIllll + 1] = (byte)llIIlIlIIIlIIIl;
                                    } else {
                                        llIIlIlIIIIIIll.convbuffer[llIIlIlIIIIllll] = (byte)llIIlIlIIIlIIIl;
                                        llIIlIlIIIIIIll.convbuffer[llIIlIlIIIIllll + 1] = (byte)(llIIlIlIIIlIIIl >>> 8);
                                    }
                                    llIIlIlIIIIllll += 2 * llIIlIlIIIIIIll.oggInfo.channels;
                                }
                            }
                            int llIIlIlIIIIlIlI = 2 * llIIlIlIIIIIIll.oggInfo.channels * llIIlIlIIIIlIll;
                            if (llIIlIlIIIIlIlI >= llIIlIlIIIIIIll.pcmBuffer.remaining()) {
                                Log.warn(String.valueOf(new StringBuilder().append("Read block from OGG that was too big to be buffered: ").append(llIIlIlIIIIlIlI)));
                            } else {
                                llIIlIlIIIIIIll.pcmBuffer.put(llIIlIlIIIIIIll.convbuffer, 0, llIIlIlIIIIlIlI);
                            }
                            llIIlIlIIIIIIlI = true;
                            llIIlIlIIIIIIll.dspState.synthesis_read(llIIlIlIIIIlIll);
                        }
                    }
                    if (llIIlIlIIIIIIll.page.eos() != 0) {
                        llIIlIlIIIIIIll.endOfBitStream = true;
                    }
                    if (llIIlIlIIIIIIll.endOfBitStream || !llIIlIlIIIIIIlI) continue;
                    return;
                }
                if (llIIlIlIIIIIIll.endOfBitStream) continue;
                llIIlIlIIIIIIll.bytes = 0;
                int llIIlIlIIIIIllI = llIIlIlIIIIIIll.syncState.buffer(4096);
                if (llIIlIlIIIIIllI >= 0) {
                    llIIlIlIIIIIIll.buffer = llIIlIlIIIIIIll.syncState.data;
                    try {
                        llIIlIlIIIIIIll.bytes = llIIlIlIIIIIIll.input.read(llIIlIlIIIIIIll.buffer, llIIlIlIIIIIllI, 4096);
                    }
                    catch (Exception llIIlIlIIIIIlll) {
                        Log.error("Failure during vorbis decoding");
                        Log.error(llIIlIlIIIIIlll);
                        llIIlIlIIIIIIll.endOfStream = true;
                        return;
                    }
                } else {
                    llIIlIlIIIIIIll.bytes = 0;
                }
                llIIlIlIIIIIIll.syncState.wrote(llIIlIlIIIIIIll.bytes);
                if (llIIlIlIIIIIIll.bytes != 0) continue;
                llIIlIlIIIIIIll.endOfBitStream = true;
            }
            llIIlIlIIIIIIll.streamState.clear();
            llIIlIlIIIIIIll.vorbisBlock.clear();
            llIIlIlIIIIIIll.dspState.clear();
            llIIlIlIIIIIIll.oggInfo.clear();
        }
        llIIlIlIIIIIIll.syncState.clear();
        llIIlIlIIIIIIll.endOfStream = true;
    }

    @Override
    public int read(byte[] llIIlIIllIllllI, int llIIlIIlllIIIIl, int llIIlIIllIlllIl) throws IOException {
        for (int llIIlIIlllIIlII = 0; llIIlIIlllIIlII < llIIlIIllIlllIl; ++llIIlIIlllIIlII) {
            try {
                OggInputStream llIIlIIlllIIIll;
                int llIIlIIlllIIllI = llIIlIIlllIIIll.read();
                if (llIIlIIlllIIllI < 0) {
                    if (llIIlIIlllIIlII == 0) {
                        return -1;
                    }
                    return llIIlIIlllIIlII;
                }
                llIIlIIllIllllI[llIIlIIlllIIlII] = (byte)llIIlIIlllIIllI;
                continue;
            }
            catch (IOException llIIlIIlllIIlIl) {
                Log.error(llIIlIIlllIIlIl);
                return llIIlIIlllIIlII;
            }
        }
        return llIIlIIllIlllIl;
    }

    @Override
    public boolean atEnd() {
        OggInputStream llIIlIIlllIllII;
        return llIIlIIlllIllII.endOfStream && llIIlIIlllIllII.readIndex >= llIIlIIlllIllII.pcmBuffer.position();
    }

    public OggInputStream(InputStream llIIlIlIlIIIlII) throws IOException {
        OggInputStream llIIlIlIlIIIIll;
        llIIlIlIlIIIIll.convsize = 16384;
        llIIlIlIlIIIIll.convbuffer = new byte[llIIlIlIlIIIIll.convsize];
        llIIlIlIlIIIIll.oggInfo = new Info();
        llIIlIlIlIIIIll.syncState = new SyncState();
        llIIlIlIlIIIIll.streamState = new StreamState();
        llIIlIlIlIIIIll.page = new Page();
        llIIlIlIlIIIIll.packet = new Packet();
        llIIlIlIlIIIIll.comment = new Comment();
        llIIlIlIlIIIIll.dspState = new DspState();
        llIIlIlIlIIIIll.vorbisBlock = new Block(llIIlIlIlIIIIll.dspState);
        llIIlIlIlIIIIll.bytes = 0;
        llIIlIlIlIIIIll.bigEndian = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
        llIIlIlIlIIIIll.endOfBitStream = true;
        llIIlIlIlIIIIll.inited = false;
        llIIlIlIlIIIIll.pcmBuffer = BufferUtils.createByteBuffer((int)2048000);
        llIIlIlIlIIIIll.input = llIIlIlIlIIIlII;
        llIIlIlIlIIIIll.total = llIIlIlIlIIIlII.available();
        llIIlIlIlIIIIll.init();
    }

    @Override
    public int read(byte[] llIIlIIllIlIlIl) throws IOException {
        OggInputStream llIIlIIllIlIllI;
        return llIIlIIllIlIllI.read(llIIlIIllIlIlIl, 0, llIIlIIllIlIlIl.length);
    }

    private void initVorbis() {
        OggInputStream llIIlIlIIllIIII;
        llIIlIlIIllIIII.syncState.init();
    }

    @Override
    public int read() throws IOException {
        OggInputStream llIIlIIllllIIlI;
        if (llIIlIIllllIIlI.readIndex >= llIIlIIllllIIlI.pcmBuffer.position()) {
            llIIlIIllllIIlI.pcmBuffer.clear();
            llIIlIIllllIIlI.readPCM();
            llIIlIIllllIIlI.readIndex = 0;
        }
        if (llIIlIIllllIIlI.readIndex >= llIIlIIllllIIlI.pcmBuffer.position()) {
            return -1;
        }
        int llIIlIIllllIIIl = llIIlIIllllIIlI.pcmBuffer.get(llIIlIIllllIIlI.readIndex);
        if (llIIlIIllllIIIl < 0) {
            llIIlIIllllIIIl = 256 + llIIlIIllllIIIl;
        }
        ++llIIlIIllllIIlI.readIndex;
        return llIIlIIllllIIIl;
    }

    private void init() throws IOException {
        OggInputStream llIIlIlIIllIllI;
        llIIlIlIIllIllI.initVorbis();
        llIIlIlIIllIllI.readPCM();
    }

    @Override
    public int available() {
        OggInputStream llIIlIlIIllIlII;
        return llIIlIlIIllIlII.endOfStream ? 0 : 1;
    }

    private boolean getPageAndPacket() {
        OggInputStream llIIlIlIIlIIlIl;
        int llIIlIlIIlIIlII = llIIlIlIIlIIlIl.syncState.buffer(4096);
        llIIlIlIIlIIlIl.buffer = llIIlIlIIlIIlIl.syncState.data;
        if (llIIlIlIIlIIlIl.buffer == null) {
            llIIlIlIIlIIlIl.endOfStream = true;
            return false;
        }
        try {
            llIIlIlIIlIIlIl.bytes = llIIlIlIIlIIlIl.input.read(llIIlIlIIlIIlIl.buffer, llIIlIlIIlIIlII, 4096);
        }
        catch (Exception llIIlIlIIlIlIII) {
            Log.error("Failure reading in vorbis");
            Log.error(llIIlIlIIlIlIII);
            llIIlIlIIlIIlIl.endOfStream = true;
            return false;
        }
        llIIlIlIIlIIlIl.syncState.wrote(llIIlIlIIlIIlIl.bytes);
        if (llIIlIlIIlIIlIl.syncState.pageout(llIIlIlIIlIIlIl.page) != 1) {
            if (llIIlIlIIlIIlIl.bytes < 4096) {
                return false;
            }
            Log.error("Input does not appear to be an Ogg bitstream.");
            llIIlIlIIlIIlIl.endOfStream = true;
            return false;
        }
        llIIlIlIIlIIlIl.streamState.init(llIIlIlIIlIIlIl.page.serialno());
        llIIlIlIIlIIlIl.oggInfo.init();
        llIIlIlIIlIIlIl.comment.init();
        if (llIIlIlIIlIIlIl.streamState.pagein(llIIlIlIIlIIlIl.page) < 0) {
            Log.error("Error reading first page of Ogg bitstream data.");
            llIIlIlIIlIIlIl.endOfStream = true;
            return false;
        }
        if (llIIlIlIIlIIlIl.streamState.packetout(llIIlIlIIlIIlIl.packet) != 1) {
            Log.error("Error reading initial header packet.");
            llIIlIlIIlIIlIl.endOfStream = true;
            return false;
        }
        if (llIIlIlIIlIIlIl.oggInfo.synthesis_headerin(llIIlIlIIlIIlIl.comment, llIIlIlIIlIIlIl.packet) < 0) {
            Log.error("This Ogg bitstream does not contain Vorbis audio data.");
            llIIlIlIIlIIlIl.endOfStream = true;
            return false;
        }
        int llIIlIlIIlIIIll = 0;
        while (llIIlIlIIlIIIll < 2) {
            int llIIlIlIIlIIlll;
            while (llIIlIlIIlIIIll < 2 && (llIIlIlIIlIIlll = llIIlIlIIlIIlIl.syncState.pageout(llIIlIlIIlIIlIl.page)) != 0) {
                if (llIIlIlIIlIIlll != 1) continue;
                llIIlIlIIlIIlIl.streamState.pagein(llIIlIlIIlIIlIl.page);
                while (llIIlIlIIlIIIll < 2 && (llIIlIlIIlIIlll = llIIlIlIIlIIlIl.streamState.packetout(llIIlIlIIlIIlIl.packet)) != 0) {
                    if (llIIlIlIIlIIlll == -1) {
                        Log.error("Corrupt secondary header.  Exiting.");
                        llIIlIlIIlIIlIl.endOfStream = true;
                        return false;
                    }
                    llIIlIlIIlIIlIl.oggInfo.synthesis_headerin(llIIlIlIIlIIlIl.comment, llIIlIlIIlIIlIl.packet);
                    ++llIIlIlIIlIIIll;
                }
            }
            llIIlIlIIlIIlII = llIIlIlIIlIIlIl.syncState.buffer(4096);
            llIIlIlIIlIIlIl.buffer = llIIlIlIIlIIlIl.syncState.data;
            try {
                llIIlIlIIlIIlIl.bytes = llIIlIlIIlIIlIl.input.read(llIIlIlIIlIIlIl.buffer, llIIlIlIIlIIlII, 4096);
            }
            catch (Exception llIIlIlIIlIIllI) {
                Log.error("Failed to read Vorbis: ");
                Log.error(llIIlIlIIlIIllI);
                llIIlIlIIlIIlIl.endOfStream = true;
                return false;
            }
            if (llIIlIlIIlIIlIl.bytes == 0 && llIIlIlIIlIIIll < 2) {
                Log.error("End of file before finding all Vorbis headers!");
                llIIlIlIIlIIlIl.endOfStream = true;
                return false;
            }
            llIIlIlIIlIIlIl.syncState.wrote(llIIlIlIIlIIlIl.bytes);
        }
        llIIlIlIIlIIlIl.convsize = 4096 / llIIlIlIIlIIlIl.oggInfo.channels;
        llIIlIlIIlIIlIl.dspState.synthesis_init(llIIlIlIIlIIlIl.oggInfo);
        llIIlIlIIlIIlIl.vorbisBlock.init(llIIlIlIIlIIlIl.dspState);
        return true;
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public int getRate() {
        OggInputStream llIIlIlIIlllIlI;
        return llIIlIlIIlllIlI.oggInfo.rate;
    }

    @Override
    public int getChannels() {
        OggInputStream llIIlIlIIllllII;
        return llIIlIlIIllllII.oggInfo.channels;
    }

    public int getLength() {
        OggInputStream llIIlIlIIllllll;
        return llIIlIlIIllllll.total;
    }
}

