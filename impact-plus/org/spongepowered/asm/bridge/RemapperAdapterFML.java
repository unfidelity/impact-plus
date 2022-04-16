/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.objectweb.asm.commons.Remapper
 */
package org.spongepowered.asm.bridge;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.objectweb.asm.commons.Remapper;
import org.spongepowered.asm.bridge.RemapperAdapter;
import org.spongepowered.asm.mixin.extensibility.IRemapper;

public final class RemapperAdapterFML
extends RemapperAdapter {
    private static final /* synthetic */ String DEOBFUSCATING_REMAPPER_CLASS;
    private static final /* synthetic */ String DEOBFUSCATING_REMAPPER_CLASS_LEGACY;
    private final /* synthetic */ Method mdUnmap;
    private static final /* synthetic */ String UNMAP_METHOD;
    private static final /* synthetic */ String DEOBFUSCATING_REMAPPER_CLASS_FORGE;
    private static final /* synthetic */ String INSTANCE_FIELD;

    static {
        DEOBFUSCATING_REMAPPER_CLASS_LEGACY = "cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper";
        DEOBFUSCATING_REMAPPER_CLASS = "fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper";
        INSTANCE_FIELD = "INSTANCE";
        UNMAP_METHOD = "unmap";
        DEOBFUSCATING_REMAPPER_CLASS_FORGE = "net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper";
    }

    @Override
    public String unmap(String lllIlIIIIllIlll) {
        try {
            RemapperAdapterFML lllIlIIIIlllIII;
            return lllIlIIIIlllIII.mdUnmap.invoke(lllIlIIIIlllIII.remapper, lllIlIIIIllIlll).toString();
        }
        catch (Exception lllIlIIIIlllIll) {
            return lllIlIIIIllIlll;
        }
    }

    private RemapperAdapterFML(Remapper lllIlIIIlIIIIII, Method lllIlIIIIllllll) {
        super(lllIlIIIlIIIIII);
        RemapperAdapterFML lllIlIIIlIIIIIl;
        lllIlIIIlIIIIIl.logger.info("Initialised Mixin FML Remapper Adapter with {}", new Object[]{lllIlIIIlIIIIII});
        lllIlIIIlIIIIIl.mdUnmap = lllIlIIIIllllll;
    }

    private static Class<?> getFMLDeobfuscatingRemapper() throws ClassNotFoundException {
        try {
            return Class.forName("net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper");
        }
        catch (ClassNotFoundException lllIlIIIIlIIlll) {
            return Class.forName("cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper");
        }
    }

    public static IRemapper create() {
        try {
            Class<?> lllIlIIIIllIIIl = RemapperAdapterFML.getFMLDeobfuscatingRemapper();
            Field lllIlIIIIllIIII = lllIlIIIIllIIIl.getDeclaredField("INSTANCE");
            Method lllIlIIIIlIllll = lllIlIIIIllIIIl.getDeclaredMethod("unmap", String.class);
            Remapper lllIlIIIIlIlllI = (Remapper)lllIlIIIIllIIII.get(null);
            return new RemapperAdapterFML(lllIlIIIIlIlllI, lllIlIIIIlIllll);
        }
        catch (Exception lllIlIIIIlIllIl) {
            lllIlIIIIlIllIl.printStackTrace();
            return null;
        }
    }
}

