/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.muffin;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import org.newdawn.slick.muffin.Muffin;
import org.newdawn.slick.util.Log;

public class FileMuffin
implements Muffin {
    @Override
    public void saveFile(HashMap llllllllllllllllIlllllIIlIIlIIll, String llllllllllllllllIlllllIIlIIIllll) throws IOException {
        String llllllllllllllllIlllllIIlIlIIIlI = System.getProperty("user.home");
        File llllllllllllllllIlllllIIlIIlllll = new File(llllllllllllllllIlllllIIlIlIIIlI);
        if (!(llllllllllllllllIlllllIIlIIlllll = new File(llllllllllllllllIlllllIIlIIlllll, ".java")).exists()) {
            llllllllllllllllIlllllIIlIIlllll.mkdir();
        }
        llllllllllllllllIlllllIIlIIlllll = new File(llllllllllllllllIlllllIIlIIlllll, llllllllllllllllIlllllIIlIIIllll);
        FileOutputStream llllllllllllllllIlllllIIlIIllIlI = new FileOutputStream(llllllllllllllllIlllllIIlIIlllll);
        ObjectOutputStream llllllllllllllllIlllllIIlIIlIllI = new ObjectOutputStream(llllllllllllllllIlllllIIlIIllIlI);
        llllllllllllllllIlllllIIlIIlIllI.writeObject(llllllllllllllllIlllllIIlIIlIIll);
        llllllllllllllllIlllllIIlIIlIllI.close();
    }

    public FileMuffin() {
        FileMuffin llllllllllllllllIlllllIlIIIIIlll;
    }

    @Override
    public HashMap loadFile(String llllllllllllllllIlllllIIIIIIlIlI) throws IOException {
        HashMap llllllllllllllllIlllllIIIIIIlIIl = new HashMap();
        String llllllllllllllllIlllllIIIIIIlIII = System.getProperty("user.home");
        File llllllllllllllllIlllllIIIIIIIlll = new File(llllllllllllllllIlllllIIIIIIlIII);
        llllllllllllllllIlllllIIIIIIIlll = new File(llllllllllllllllIlllllIIIIIIIlll, ".java");
        if ((llllllllllllllllIlllllIIIIIIIlll = new File(llllllllllllllllIlllllIIIIIIIlll, llllllllllllllllIlllllIIIIIIlIlI)).exists()) {
            try {
                FileInputStream llllllllllllllllIlllllIIIIIIllll = new FileInputStream(llllllllllllllllIlllllIIIIIIIlll);
                ObjectInputStream llllllllllllllllIlllllIIIIIIlllI = new ObjectInputStream(llllllllllllllllIlllllIIIIIIllll);
                llllllllllllllllIlllllIIIIIIlIIl = (HashMap)llllllllllllllllIlllllIIIIIIlllI.readObject();
                llllllllllllllllIlllllIIIIIIlllI.close();
            }
            catch (EOFException llllllllllllllllIlllllIIIIIIllIl) {
            }
            catch (ClassNotFoundException llllllllllllllllIlllllIIIIIIllII) {
                Log.error(llllllllllllllllIlllllIIIIIIllII);
                throw new IOException("Failed to pull state from store - class not found");
            }
        }
        return llllllllllllllllIlllllIIIIIIlIIl;
    }
}

