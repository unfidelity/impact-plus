/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.jnlp.BasicService
 *  javax.jnlp.FileContents
 *  javax.jnlp.PersistenceService
 *  javax.jnlp.ServiceManager
 */
package org.newdawn.slick.muffin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;
import javax.jnlp.BasicService;
import javax.jnlp.FileContents;
import javax.jnlp.PersistenceService;
import javax.jnlp.ServiceManager;
import org.newdawn.slick.muffin.Muffin;
import org.newdawn.slick.util.Log;

public class WebstartMuffin
implements Muffin {
    public WebstartMuffin() {
        WebstartMuffin lllllllllllllllllIIIlllIIIIllllI;
    }

    @Override
    public HashMap loadFile(String lllllllllllllllllIIIllIllIIIllIl) throws IOException {
        HashMap<String, Object> lllllllllllllllllIIIllIllIIIlllI = new HashMap<String, Object>();
        try {
            PersistenceService lllllllllllllllllIIIllIllIlIIIII = (PersistenceService)ServiceManager.lookup((String)"javax.jnlp.PersistenceService");
            BasicService lllllllllllllllllIIIllIllIIllllI = (BasicService)ServiceManager.lookup((String)"javax.jnlp.BasicService");
            URL lllllllllllllllllIIIllIllIIlllII = lllllllllllllllllIIIllIllIIllllI.getCodeBase();
            URL lllllllllllllllllIIIllIllIIllIlI = new URL(lllllllllllllllllIIIllIllIIlllII, lllllllllllllllllIIIllIllIIIllIl);
            FileContents lllllllllllllllllIIIllIllIIllIIl = lllllllllllllllllIIIllIllIlIIIII.get(lllllllllllllllllIIIllIllIIllIlI);
            DataInputStream lllllllllllllllllIIIllIllIIllIII = new DataInputStream(lllllllllllllllllIIIllIllIIllIIl.getInputStream());
            if (lllllllllllllllllIIIllIllIIIllIl.endsWith("Number")) {
                String lllllllllllllllllIIIllIllIlIIlII;
                while ((lllllllllllllllllIIIllIllIlIIlII = lllllllllllllllllIIIllIllIIllIII.readUTF()) != null) {
                    double lllllllllllllllllIIIllIllIlIIllI = lllllllllllllllllIIIllIllIIllIII.readDouble();
                    lllllllllllllllllIIIllIllIIIlllI.put(lllllllllllllllllIIIllIllIlIIlII, new Double(lllllllllllllllllIIIllIllIlIIllI));
                }
            } else {
                String lllllllllllllllllIIIllIllIIlIllI;
                while ((lllllllllllllllllIIIllIllIIlIllI = lllllllllllllllllIIIllIllIIllIII.readUTF()) != null) {
                    String lllllllllllllllllIIIllIllIlIIIlI = lllllllllllllllllIIIllIllIIllIII.readUTF();
                    lllllllllllllllllIIIllIllIIIlllI.put(lllllllllllllllllIIIllIllIIlIllI, lllllllllllllllllIIIllIllIlIIIlI);
                }
            }
            lllllllllllllllllIIIllIllIIllIII.close();
        }
        catch (EOFException lllllllllllllllllIIIllIllIIlIlII) {
        }
        catch (IOException lllllllllllllllllIIIllIllIIlIIlI) {
        }
        catch (Exception lllllllllllllllllIIIllIllIIlIIIl) {
            Log.error(lllllllllllllllllIIIllIllIIlIIIl);
            throw new IOException("Failed to load state from webstart muffin");
        }
        return lllllllllllllllllIIIllIllIIIlllI;
    }

    @Override
    public void saveFile(HashMap lllllllllllllllllIIIllIlllIllIll, String lllllllllllllllllIIIllIllllIIIlI) throws IOException {
        URL lllllllllllllllllIIIllIlllIlllII;
        PersistenceService lllllllllllllllllIIIllIllllIIIII;
        try {
            lllllllllllllllllIIIllIllllIIIII = (PersistenceService)ServiceManager.lookup((String)"javax.jnlp.PersistenceService");
            BasicService lllllllllllllllllIIIllIlllIllllI = (BasicService)ServiceManager.lookup((String)"javax.jnlp.BasicService");
            URL lllllllllllllllllIIIllIlllllIIIl = lllllllllllllllllIIIllIlllIllllI.getCodeBase();
            lllllllllllllllllIIIllIlllIlllII = new URL(lllllllllllllllllIIIllIlllllIIIl, lllllllllllllllllIIIllIllllIIIlI);
        }
        catch (Exception lllllllllllllllllIIIllIlllllIIII) {
            Log.error(lllllllllllllllllIIIllIlllllIIII);
            throw new IOException("Failed to save state: ");
        }
        try {
            lllllllllllllllllIIIllIllllIIIII.delete(lllllllllllllllllIIIllIlllIlllII);
        }
        catch (Exception lllllllllllllllllIIIllIllllIllll) {
            Log.info("No exisiting Muffin Found - First Save");
        }
        try {
            lllllllllllllllllIIIllIllllIIIII.create(lllllllllllllllllIIIllIlllIlllII, 1024L);
            FileContents lllllllllllllllllIIIllIllllIlIlI = lllllllllllllllllIIIllIllllIIIII.get(lllllllllllllllllIIIllIlllIlllII);
            DataOutputStream lllllllllllllllllIIIllIllllIlIIl = new DataOutputStream(lllllllllllllllllIIIllIllllIlIlI.getOutputStream(false));
            Set lllllllllllllllllIIIllIllllIlIII = lllllllllllllllllIIIllIlllIllIll.keySet();
            for (String lllllllllllllllllIIIllIllllIllII : lllllllllllllllllIIIllIllllIlIII) {
                lllllllllllllllllIIIllIllllIlIIl.writeUTF(lllllllllllllllllIIIllIllllIllII);
                if (lllllllllllllllllIIIllIllllIIIlI.endsWith("Number")) {
                    double lllllllllllllllllIIIllIllllIlllI = (Double)lllllllllllllllllIIIllIlllIllIll.get(lllllllllllllllllIIIllIllllIllII);
                    lllllllllllllllllIIIllIllllIlIIl.writeDouble(lllllllllllllllllIIIllIllllIlllI);
                    continue;
                }
                String lllllllllllllllllIIIllIllllIllIl = (String)lllllllllllllllllIIIllIlllIllIll.get(lllllllllllllllllIIIllIllllIllII);
                lllllllllllllllllIIIllIllllIlIIl.writeUTF(lllllllllllllllllIIIllIllllIllIl);
            }
            lllllllllllllllllIIIllIllllIlIIl.flush();
            lllllllllllllllllIIIllIllllIlIIl.close();
        }
        catch (Exception lllllllllllllllllIIIllIllllIIlll) {
            Log.error(lllllllllllllllllIIIllIllllIIlll);
            throw new IOException("Failed to store map of state data");
        }
    }
}

