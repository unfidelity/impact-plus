/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer.debug;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.spongepowered.asm.mixin.transformer.debug.RuntimeDecompiler;

public class RuntimeDecompilerAsync
extends RuntimeDecompiler
implements Thread.UncaughtExceptionHandler,
Runnable {
    private final /* synthetic */ BlockingQueue<File> queue;
    private /* synthetic */ boolean run;
    private final /* synthetic */ Thread thread;

    @Override
    public void decompile(File llllllllllllllllIIIIIlllIllIIllI) {
        RuntimeDecompilerAsync llllllllllllllllIIIIIlllIllIIlII;
        if (llllllllllllllllIIIIIlllIllIIlII.run) {
            llllllllllllllllIIIIIlllIllIIlII.queue.offer(llllllllllllllllIIIIIlllIllIIllI);
        } else {
            super.decompile(llllllllllllllllIIIIIlllIllIIllI);
        }
    }

    @Override
    public void uncaughtException(Thread llllllllllllllllIIIIIlllIlIIlllI, Throwable llllllllllllllllIIIIIlllIlIIllIl) {
        RuntimeDecompilerAsync llllllllllllllllIIIIIlllIlIIllII;
        llllllllllllllllIIIIIlllIlIIllII.logger.error("Async decompiler encountered an error and will terminate. Further decompile requests will be handled synchronously. {} {}", new Object[]{llllllllllllllllIIIIIlllIlIIllIl.getClass().getName(), llllllllllllllllIIIIIlllIlIIllIl.getMessage()});
        llllllllllllllllIIIIIlllIlIIllII.flush();
    }

    private void flush() {
        RuntimeDecompilerAsync llllllllllllllllIIIIIlllIlIIIlll;
        File llllllllllllllllIIIIIlllIlIIlIII;
        llllllllllllllllIIIIIlllIlIIIlll.run = false;
        while ((llllllllllllllllIIIIIlllIlIIlIII = (File)llllllllllllllllIIIIIlllIlIIIlll.queue.poll()) != null) {
            llllllllllllllllIIIIIlllIlIIIlll.decompile(llllllllllllllllIIIIIlllIlIIlIII);
        }
    }

    @Override
    public void run() {
        RuntimeDecompilerAsync llllllllllllllllIIIIIlllIlIlIlII;
        while (llllllllllllllllIIIIIlllIlIlIlII.run) {
            try {
                File llllllllllllllllIIIIIlllIlIlIlll = llllllllllllllllIIIIIlllIlIlIlII.queue.take();
                super.decompile(llllllllllllllllIIIIIlllIlIlIlll);
            }
            catch (InterruptedException llllllllllllllllIIIIIlllIlIlIllI) {
                llllllllllllllllIIIIIlllIlIlIlII.run = false;
            }
            catch (Exception llllllllllllllllIIIIIlllIlIlIlIl) {
                llllllllllllllllIIIIIlllIlIlIlIl.printStackTrace();
            }
        }
    }

    public RuntimeDecompilerAsync(File llllllllllllllllIIIIIlllIllIllll) {
        super(llllllllllllllllIIIIIlllIllIllll);
        RuntimeDecompilerAsync llllllllllllllllIIIIIlllIllIlllI;
        llllllllllllllllIIIIIlllIllIlllI.queue = new LinkedBlockingQueue<File>();
        llllllllllllllllIIIIIlllIllIlllI.run = true;
        llllllllllllllllIIIIIlllIllIlllI.thread = new Thread((Runnable)llllllllllllllllIIIIIlllIllIlllI, "Decompiler thread");
        llllllllllllllllIIIIIlllIllIlllI.thread.setDaemon(true);
        llllllllllllllllIIIIIlllIllIlllI.thread.setPriority(1);
        llllllllllllllllIIIIIlllIllIlllI.thread.setUncaughtExceptionHandler(llllllllllllllllIIIIIlllIllIlllI);
        llllllllllllllllIIIIIlllIllIlllI.thread.start();
    }
}

