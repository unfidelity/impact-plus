/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.jnlp.ServiceManager
 */
package org.newdawn.slick;

import java.io.IOException;
import java.util.HashMap;
import javax.jnlp.ServiceManager;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.muffin.FileMuffin;
import org.newdawn.slick.muffin.Muffin;
import org.newdawn.slick.muffin.WebstartMuffin;
import org.newdawn.slick.util.Log;

public class SavedState {
    private /* synthetic */ HashMap numericData;
    private /* synthetic */ HashMap stringData;
    private /* synthetic */ String fileName;
    private /* synthetic */ Muffin muffin;

    public String getString(String llllllllllllllllIllllIlIlIIIlIlI) {
        SavedState llllllllllllllllIllllIlIlIIIlIll;
        return llllllllllllllllIllllIlIlIIIlIll.getString(llllllllllllllllIllllIlIlIIIlIlI, null);
    }

    public void setString(String llllllllllllllllIllllIlIIlIlIlIl, String llllllllllllllllIllllIlIIlIllIII) {
        SavedState llllllllllllllllIllllIlIIlIlllIl;
        llllllllllllllllIllllIlIIlIlllIl.stringData.put(llllllllllllllllIllllIlIIlIlIlIl, llllllllllllllllIllllIlIIlIllIII);
    }

    public void load() throws IOException {
        SavedState llllllllllllllllIllllIlIIIllllIl;
        llllllllllllllllIllllIlIIIllllIl.numericData = llllllllllllllllIllllIlIIIllllIl.muffin.loadFile(String.valueOf(new StringBuilder().append(llllllllllllllllIllllIlIIIllllIl.fileName).append("_Number")));
        llllllllllllllllIllllIlIIIllllIl.stringData = llllllllllllllllIllllIlIIIllllIl.muffin.loadFile(String.valueOf(new StringBuilder().append(llllllllllllllllIllllIlIIIllllIl.fileName).append("_String")));
    }

    public void save() throws IOException {
        SavedState llllllllllllllllIllllIlIIlIIIllI;
        llllllllllllllllIllllIlIIlIIIllI.muffin.saveFile(llllllllllllllllIllllIlIIlIIIllI.numericData, String.valueOf(new StringBuilder().append(llllllllllllllllIllllIlIIlIIIllI.fileName).append("_Number")));
        llllllllllllllllIllllIlIIlIIIllI.muffin.saveFile(llllllllllllllllIllllIlIIlIIIllI.stringData, String.valueOf(new StringBuilder().append(llllllllllllllllIllllIlIIlIIIllI.fileName).append("_String")));
    }

    public double getNumber(String llllllllllllllllIllllIlIlIllllIl) {
        SavedState llllllllllllllllIllllIlIlIllllll;
        return llllllllllllllllIllllIlIlIllllll.getNumber(llllllllllllllllIllllIlIlIllllIl, 0.0);
    }

    private boolean isWebstartAvailable() {
        try {
            Class.forName("javax.jnlp.ServiceManager");
            ServiceManager.lookup((String)"javax.jnlp.PersistenceService");
            Log.info("Webstart detected using Muffins");
        }
        catch (Exception llllllllllllllllIllllIlIIIllIlll) {
            Log.info("Using Local File System");
            return false;
        }
        return true;
    }

    public void clear() {
        SavedState llllllllllllllllIllllIlIIIlllIIl;
        llllllllllllllllIllllIlIIIlllIIl.numericData.clear();
        llllllllllllllllIllllIlIIIlllIIl.stringData.clear();
    }

    public String getString(String llllllllllllllllIllllIlIIlllIIIl, String llllllllllllllllIllllIlIIlllIIII) {
        SavedState llllllllllllllllIllllIlIIllllIll;
        String llllllllllllllllIllllIlIIlllIIll = (String)llllllllllllllllIllllIlIIllllIll.stringData.get(llllllllllllllllIllllIlIIlllIIIl);
        if (llllllllllllllllIllllIlIIlllIIll == null) {
            return llllllllllllllllIllllIlIIlllIIII;
        }
        return llllllllllllllllIllllIlIIlllIIll;
    }

    public SavedState(String llllllllllllllllIllllIlIllIIIllI) throws SlickException {
        SavedState llllllllllllllllIllllIlIllIIlIIl;
        llllllllllllllllIllllIlIllIIlIIl.numericData = new HashMap();
        llllllllllllllllIllllIlIllIIlIIl.stringData = new HashMap();
        llllllllllllllllIllllIlIllIIlIIl.fileName = llllllllllllllllIllllIlIllIIIllI;
        llllllllllllllllIllllIlIllIIlIIl.muffin = llllllllllllllllIllllIlIllIIlIIl.isWebstartAvailable() ? new WebstartMuffin() : new FileMuffin();
        try {
            llllllllllllllllIllllIlIllIIlIIl.load();
        }
        catch (IOException llllllllllllllllIllllIlIllIIlIll) {
            throw new SlickException("Failed to load state on startup", llllllllllllllllIllllIlIllIIlIll);
        }
    }

    public double getNumber(String llllllllllllllllIllllIlIlIllIIIl, double llllllllllllllllIllllIlIlIlIlIll) {
        SavedState llllllllllllllllIllllIlIlIllIIlI;
        Double llllllllllllllllIllllIlIlIlIlllI = (Double)llllllllllllllllIllllIlIlIllIIlI.numericData.get(llllllllllllllllIllllIlIlIllIIIl);
        if (llllllllllllllllIllllIlIlIlIlllI == null) {
            return llllllllllllllllIllllIlIlIlIlIll;
        }
        return llllllllllllllllIllllIlIlIlIlllI;
    }

    public void setNumber(String llllllllllllllllIllllIlIlIIlIlll, double llllllllllllllllIllllIlIlIIllIll) {
        SavedState llllllllllllllllIllllIlIlIIllIIl;
        llllllllllllllllIllllIlIlIIllIIl.numericData.put(llllllllllllllllIllllIlIlIIlIlll, new Double(llllllllllllllllIllllIlIlIIllIll));
    }
}

