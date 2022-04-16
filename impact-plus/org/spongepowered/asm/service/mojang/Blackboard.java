/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.Launch
 */
package org.spongepowered.asm.service.mojang;

import net.minecraft.launchwrapper.Launch;
import org.spongepowered.asm.service.IGlobalPropertyService;

public class Blackboard
implements IGlobalPropertyService {
    @Override
    public final String getPropertyString(String lllllllllllllllllllIIlIlIIIIIIll, String lllllllllllllllllllIIlIlIIIIIIlI) {
        Object lllllllllllllllllllIIlIlIIIIIlII = Launch.blackboard.get(lllllllllllllllllllIIlIlIIIIIIll);
        return lllllllllllllllllllIIlIlIIIIIlII != null ? lllllllllllllllllllIIlIlIIIIIlII.toString() : lllllllllllllllllllIIlIlIIIIIIlI;
    }

    @Override
    public final void setProperty(String lllllllllllllllllllIIlIlIIIlIllI, Object lllllllllllllllllllIIlIlIIIlIlll) {
        Launch.blackboard.put(lllllllllllllllllllIIlIlIIIlIllI, lllllllllllllllllllIIlIlIIIlIlll);
    }

    @Override
    public final <T> T getProperty(String lllllllllllllllllllIIlIlIIIlIIII, T lllllllllllllllllllIIlIlIIIIllll) {
        Object lllllllllllllllllllIIlIlIIIIlllI = Launch.blackboard.get(lllllllllllllllllllIIlIlIIIlIIII);
        return (T)(lllllllllllllllllllIIlIlIIIIlllI != null ? lllllllllllllllllllIIlIlIIIIlllI : lllllllllllllllllllIIlIlIIIIllll);
    }

    @Override
    public final <T> T getProperty(String lllllllllllllllllllIIlIlIIIlllII) {
        return (T)Launch.blackboard.get(lllllllllllllllllllIIlIlIIIlllII);
    }

    public Blackboard() {
        Blackboard lllllllllllllllllllIIlIlIIlIIIII;
    }
}

