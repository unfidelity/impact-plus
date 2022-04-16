/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonParseException
 *  org.apache.commons.io.IOUtils
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.refmap;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.refmap.IReferenceMapper;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.MixinService;

public final class ReferenceMapper
implements Serializable,
IReferenceMapper {
    private final /* synthetic */ Map<String, Map<String, String>> mappings;
    private transient /* synthetic */ String context;
    public static final /* synthetic */ ReferenceMapper DEFAULT_MAPPER;
    private final transient /* synthetic */ boolean readOnly;
    private final /* synthetic */ Map<String, Map<String, Map<String, String>>> data;
    public static final /* synthetic */ String DEFAULT_RESOURCE;
    private transient /* synthetic */ String resource;
    private static final /* synthetic */ long serialVersionUID = 2L;

    public void write(Appendable lllllllllllllllIllIllIlIllIllllI) {
        ReferenceMapper lllllllllllllllIllIllIlIllIlllll;
        new GsonBuilder().setPrettyPrinting().create().toJson((Object)lllllllllllllllIllIllIlIllIlllll, lllllllllllllllIllIllIlIllIllllI);
    }

    @Override
    public String remap(String lllllllllllllllIllIllIllIIIllIll, String lllllllllllllllIllIllIllIIIllIlI) {
        ReferenceMapper lllllllllllllllIllIllIllIIIlllII;
        return lllllllllllllllIllIllIllIIIlllII.remapWithContext(lllllllllllllllIllIllIllIIIlllII.context, lllllllllllllllIllIllIllIIIllIll, lllllllllllllllIllIllIllIIIllIlI);
    }

    private static ReferenceMapper readJson(Reader lllllllllllllllIllIllIlIlIllIlll) {
        return (ReferenceMapper)new Gson().fromJson(lllllllllllllllIllIllIlIlIllIlll, ReferenceMapper.class);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Loose catch block
     */
    public static ReferenceMapper read(String lllllllllllllllIllIllIlIllIIlIll) {
        InputStreamReader lllllllllllllllIllIllIlIllIIllII;
        block6: {
            ReferenceMapper lllllllllllllllIllIllIlIllIIIlIl;
            Logger lllllllllllllllIllIllIlIllIIllIl = LogManager.getLogger((String)"mixin");
            lllllllllllllllIllIllIlIllIIllII = null;
            try {
                IMixinService lllllllllllllllIllIllIlIllIlIIlI = MixinService.getService();
                InputStream lllllllllllllllIllIllIlIllIlIIIl = lllllllllllllllIllIllIlIllIlIIlI.getResourceAsStream(lllllllllllllllIllIllIlIllIIlIll);
                if (lllllllllllllllIllIllIlIllIlIIIl == null) break block6;
                lllllllllllllllIllIllIlIllIIllII = new InputStreamReader(lllllllllllllllIllIllIlIllIlIIIl);
                ReferenceMapper lllllllllllllllIllIllIlIllIlIIll = ReferenceMapper.readJson(lllllllllllllllIllIllIlIllIIllII);
                lllllllllllllllIllIllIlIllIlIIll.setResourceName(lllllllllllllllIllIllIlIllIIlIll);
                lllllllllllllllIllIllIlIllIIIlIl = lllllllllllllllIllIllIlIllIlIIll;
            }
            catch (JsonParseException lllllllllllllllIllIllIlIllIlIIII) {
                lllllllllllllllIllIllIlIllIIllIl.error(String.valueOf(new StringBuilder().append("Invalid REFMAP JSON in ").append(lllllllllllllllIllIllIlIllIIlIll).append(": ").append(((Object)((Object)lllllllllllllllIllIllIlIllIlIIII)).getClass().getName()).append(" ").append(lllllllllllllllIllIllIlIllIlIIII.getMessage())));
                IOUtils.closeQuietly((Reader)lllllllllllllllIllIllIlIllIIllII);
            }
            catch (Exception lllllllllllllllIllIllIlIllIIllll) {
                lllllllllllllllIllIllIlIllIIllIl.error(String.valueOf(new StringBuilder().append("Failed reading REFMAP JSON from ").append(lllllllllllllllIllIllIlIllIIlIll).append(": ").append(lllllllllllllllIllIllIlIllIIllll.getClass().getName()).append(" ").append(lllllllllllllllIllIllIlIllIIllll.getMessage())));
                {
                    catch (Throwable lllllllllllllllIllIllIlIllIIIlII) {
                        IOUtils.closeQuietly(lllllllllllllllIllIllIlIllIIllII);
                        throw lllllllllllllllIllIllIlIllIIIlII;
                    }
                }
                IOUtils.closeQuietly((Reader)lllllllllllllllIllIllIlIllIIllII);
            }
            IOUtils.closeQuietly((Reader)lllllllllllllllIllIllIlIllIIllII);
            return lllllllllllllllIllIllIlIllIIIlIl;
        }
        IOUtils.closeQuietly(lllllllllllllllIllIllIlIllIIllII);
        return DEFAULT_MAPPER;
    }

    @Override
    public String getStatus() {
        ReferenceMapper lllllllllllllllIllIllIllIIlIlIIl;
        return lllllllllllllllIllIllIllIIlIlIIl.isDefault() ? "No refMap loaded." : String.valueOf(new StringBuilder().append("Using refmap ").append(lllllllllllllllIllIllIllIIlIlIIl.getResourceName()));
    }

    private String remap(Map<String, Map<String, String>> lllllllllllllllIllIllIlIlllllIll, String lllllllllllllllIllIllIlIllllllll, String lllllllllllllllIllIllIlIlllllIIl) {
        Map<String, String> lllllllllllllllIllIllIlIllllllIl;
        if (lllllllllllllllIllIllIlIllllllll == null) {
            for (Map<String, String> lllllllllllllllIllIllIllIIIIIIlI : lllllllllllllllIllIllIlIlllllIll.values()) {
                if (!lllllllllllllllIllIllIllIIIIIIlI.containsKey(lllllllllllllllIllIllIlIlllllIIl)) continue;
                return lllllllllllllllIllIllIllIIIIIIlI.get(lllllllllllllllIllIllIlIlllllIIl);
            }
        }
        if ((lllllllllllllllIllIllIlIllllllIl = lllllllllllllllIllIllIlIlllllIll.get(lllllllllllllllIllIllIlIllllllll)) == null) {
            return lllllllllllllllIllIllIlIlllllIIl;
        }
        String lllllllllllllllIllIllIlIllllllII = lllllllllllllllIllIllIlIllllllIl.get(lllllllllllllllIllIllIlIlllllIIl);
        return lllllllllllllllIllIllIlIllllllII != null ? lllllllllllllllIllIllIlIllllllII : lllllllllllllllIllIllIlIlllllIIl;
    }

    @Override
    public boolean isDefault() {
        ReferenceMapper lllllllllllllllIllIllIllIIllIlIl;
        return lllllllllllllllIllIllIllIIllIlIl.readOnly;
    }

    public String addMapping(String lllllllllllllllIllIllIlIlllIIlll, String lllllllllllllllIllIllIlIlllIllIl, String lllllllllllllllIllIllIlIlllIIlIl, String lllllllllllllllIllIllIlIlllIlIll) {
        Map<String, String> lllllllllllllllIllIllIlIlllIlIIl;
        ReferenceMapper lllllllllllllllIllIllIlIlllIllll;
        if (lllllllllllllllIllIllIlIlllIllll.readOnly || lllllllllllllllIllIllIlIlllIIlIl == null || lllllllllllllllIllIllIlIlllIlIll == null || lllllllllllllllIllIllIlIlllIIlIl.equals(lllllllllllllllIllIllIlIlllIlIll)) {
            return null;
        }
        HashMap lllllllllllllllIllIllIlIlllIlIlI = lllllllllllllllIllIllIlIlllIllll.mappings;
        if (lllllllllllllllIllIllIlIlllIIlll != null && (lllllllllllllllIllIllIlIlllIlIlI = lllllllllllllllIllIllIlIlllIllll.data.get(lllllllllllllllIllIllIlIlllIIlll)) == null) {
            lllllllllllllllIllIllIlIlllIlIlI = Maps.newHashMap();
            lllllllllllllllIllIllIlIlllIllll.data.put(lllllllllllllllIllIllIlIlllIIlll, lllllllllllllllIllIllIlIlllIlIlI);
        }
        if ((lllllllllllllllIllIllIlIlllIlIIl = lllllllllllllllIllIllIlIlllIlIlI.get(lllllllllllllllIllIllIlIlllIllIl)) == null) {
            lllllllllllllllIllIllIlIlllIlIIl = new HashMap<String, String>();
            lllllllllllllllIllIllIlIlllIlIlI.put(lllllllllllllllIllIllIlIlllIllIl, lllllllllllllllIllIllIlIlllIlIIl);
        }
        return lllllllllllllllIllIllIlIlllIlIIl.put(lllllllllllllllIllIllIlIlllIIlIl, lllllllllllllllIllIllIlIlllIlIll);
    }

    @Override
    public String remapWithContext(String lllllllllllllllIllIllIllIIIlIIII, String lllllllllllllllIllIllIllIIIIlIlI, String lllllllllllllllIllIllIllIIIIlllI) {
        ReferenceMapper lllllllllllllllIllIllIllIIIlIIIl;
        Map<String, Map<String, String>> lllllllllllllllIllIllIllIIIIllIl = lllllllllllllllIllIllIllIIIlIIIl.mappings;
        if (lllllllllllllllIllIllIllIIIlIIII != null && (lllllllllllllllIllIllIllIIIIllIl = lllllllllllllllIllIllIllIIIlIIIl.data.get(lllllllllllllllIllIllIllIIIlIIII)) == null) {
            lllllllllllllllIllIllIllIIIIllIl = lllllllllllllllIllIllIllIIIlIIIl.mappings;
        }
        return lllllllllllllllIllIllIllIIIlIIIl.remap(lllllllllllllllIllIllIllIIIIllIl, lllllllllllllllIllIllIllIIIIlIlI, lllllllllllllllIllIllIllIIIIlllI);
    }

    @Override
    public String getResourceName() {
        ReferenceMapper lllllllllllllllIllIllIllIIlIllIl;
        return lllllllllllllllIllIllIllIIlIllIl.resource;
    }

    public ReferenceMapper() {
        lllllllllllllllIllIllIllIlIIIIIl(false, "mixin.refmap.json");
        ReferenceMapper lllllllllllllllIllIllIllIlIIIIIl;
    }

    @Override
    public String getContext() {
        ReferenceMapper lllllllllllllllIllIllIllIIlIIllI;
        return lllllllllllllllIllIllIllIIlIIllI.context;
    }

    @Override
    public void setContext(String lllllllllllllllIllIllIllIIlIIIlI) {
        lllllllllllllllIllIllIllIIlIIIll.context = lllllllllllllllIllIllIllIIlIIIlI;
    }

    static {
        DEFAULT_RESOURCE = "mixin.refmap.json";
        DEFAULT_MAPPER = new ReferenceMapper(true, "invalid");
    }

    private void setResourceName(String lllllllllllllllIllIllIllIIlIllll) {
        ReferenceMapper lllllllllllllllIllIllIllIIllIIlI;
        if (!lllllllllllllllIllIllIllIIllIIlI.readOnly) {
            lllllllllllllllIllIllIllIIllIIlI.resource = lllllllllllllllIllIllIllIIlIllll != null ? lllllllllllllllIllIllIllIIlIllll : "<unknown resource>";
        }
    }

    public static ReferenceMapper read(Reader lllllllllllllllIllIllIlIlIllllII, String lllllllllllllllIllIllIlIlIllllIl) {
        try {
            ReferenceMapper lllllllllllllllIllIllIlIllIIIIII = ReferenceMapper.readJson(lllllllllllllllIllIllIlIlIllllII);
            lllllllllllllllIllIllIlIllIIIIII.setResourceName(lllllllllllllllIllIllIlIlIllllIl);
            return lllllllllllllllIllIllIlIllIIIIII;
        }
        catch (Exception lllllllllllllllIllIllIlIlIllllll) {
            return DEFAULT_MAPPER;
        }
    }

    private ReferenceMapper(boolean lllllllllllllllIllIllIllIIlllIIl, String lllllllllllllllIllIllIllIIlllIll) {
        ReferenceMapper lllllllllllllllIllIllIllIIlllIlI;
        lllllllllllllllIllIllIllIIlllIlI.mappings = Maps.newHashMap();
        lllllllllllllllIllIllIllIIlllIlI.data = Maps.newHashMap();
        lllllllllllllllIllIllIllIIlllIlI.context = null;
        lllllllllllllllIllIllIllIIlllIlI.readOnly = lllllllllllllllIllIllIllIIlllIIl;
        lllllllllllllllIllIllIllIIlllIlI.resource = lllllllllllllllIllIllIllIIlllIll;
    }
}

