/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 */
package org.spongepowered.asm.mixin.injection.struct;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.Group;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.throwables.InjectionValidationException;
import org.spongepowered.asm.util.Annotations;

public class InjectorGroupInfo {
    private /* synthetic */ int minCallbackCount;
    private /* synthetic */ int maxCallbackCount;
    private final /* synthetic */ List<InjectionInfo> members;
    private final /* synthetic */ String name;
    private final /* synthetic */ boolean isDefault;

    public InjectorGroupInfo add(InjectionInfo llllllllllllllllIIIIIlIllllllIII) {
        InjectorGroupInfo llllllllllllllllIIIIIlIllllllIIl;
        llllllllllllllllIIIIIlIllllllIIl.members.add(llllllllllllllllIIIIIlIllllllIII);
        return llllllllllllllllIIIIIlIllllllIIl;
    }

    public int getMinRequired() {
        InjectorGroupInfo llllllllllllllllIIIIIllIIIIIllll;
        return Math.max(llllllllllllllllIIIIIllIIIIIllll.minCallbackCount, 1);
    }

    public boolean isDefault() {
        InjectorGroupInfo llllllllllllllllIIIIIllIIIIlIlII;
        return llllllllllllllllIIIIIllIIIIlIlII.isDefault;
    }

    public String getName() {
        InjectorGroupInfo llllllllllllllllIIIIIllIIIIlIIlI;
        return llllllllllllllllIIIIIllIIIIlIIlI.name;
    }

    public String toString() {
        InjectorGroupInfo llllllllllllllllIIIIIllIIIIllIII;
        return String.format("@Group(name=%s, min=%d, max=%d)", llllllllllllllllIIIIIllIIIIllIII.getName(), llllllllllllllllIIIIIllIIIIllIII.getMinRequired(), llllllllllllllllIIIIIllIIIIllIII.getMaxAllowed());
    }

    public void setMinRequired(int llllllllllllllllIIIIIllIIIIIIlII) {
        InjectorGroupInfo llllllllllllllllIIIIIllIIIIIIIll;
        if (llllllllllllllllIIIIIllIIIIIIlII < 1) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Cannot set zero or negative value for injector group min count. Attempted to set min=").append(llllllllllllllllIIIIIllIIIIIIlII).append(" on ").append(llllllllllllllllIIIIIllIIIIIIIll)));
        }
        if (llllllllllllllllIIIIIllIIIIIIIll.minCallbackCount > 0 && llllllllllllllllIIIIIllIIIIIIIll.minCallbackCount != llllllllllllllllIIIIIllIIIIIIlII) {
            LogManager.getLogger((String)"mixin").warn("Conflicting min value '{}' on @Group({}), previously specified {}", new Object[]{llllllllllllllllIIIIIllIIIIIIlII, llllllllllllllllIIIIIllIIIIIIIll.name, llllllllllllllllIIIIIllIIIIIIIll.minCallbackCount});
        }
        llllllllllllllllIIIIIllIIIIIIIll.minCallbackCount = Math.max(llllllllllllllllIIIIIllIIIIIIIll.minCallbackCount, llllllllllllllllIIIIIllIIIIIIlII);
    }

    public void setMaxAllowed(int llllllllllllllllIIIIIlIlllllllII) {
        InjectorGroupInfo llllllllllllllllIIIIIlIlllllllll;
        if (llllllllllllllllIIIIIlIlllllllII < 1) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Cannot set zero or negative value for injector group max count. Attempted to set max=").append(llllllllllllllllIIIIIlIlllllllII).append(" on ").append(llllllllllllllllIIIIIlIlllllllll)));
        }
        if (llllllllllllllllIIIIIlIlllllllll.maxCallbackCount < Integer.MAX_VALUE && llllllllllllllllIIIIIlIlllllllll.maxCallbackCount != llllllllllllllllIIIIIlIlllllllII) {
            LogManager.getLogger((String)"mixin").warn("Conflicting max value '{}' on @Group({}), previously specified {}", new Object[]{llllllllllllllllIIIIIlIlllllllII, llllllllllllllllIIIIIlIlllllllll.name, llllllllllllllllIIIIIlIlllllllll.maxCallbackCount});
        }
        llllllllllllllllIIIIIlIlllllllll.maxCallbackCount = Math.min(llllllllllllllllIIIIIlIlllllllll.maxCallbackCount, llllllllllllllllIIIIIlIlllllllII);
    }

    public Collection<InjectionInfo> getMembers() {
        InjectorGroupInfo llllllllllllllllIIIIIllIIIIIlIII;
        return Collections.unmodifiableCollection(llllllllllllllllIIIIIllIIIIIlIII.members);
    }

    public InjectorGroupInfo validate() throws InjectionValidationException {
        InjectorGroupInfo llllllllllllllllIIIIIlIlllllIIII;
        if (llllllllllllllllIIIIIlIlllllIIII.members.size() == 0) {
            return llllllllllllllllIIIIIlIlllllIIII;
        }
        int llllllllllllllllIIIIIlIllllIllll = 0;
        for (InjectionInfo llllllllllllllllIIIIIlIlllllIIIl : llllllllllllllllIIIIIlIlllllIIII.members) {
            llllllllllllllllIIIIIlIllllIllll += llllllllllllllllIIIIIlIlllllIIIl.getInjectedCallbackCount();
        }
        int llllllllllllllllIIIIIlIllllIlllI = llllllllllllllllIIIIIlIlllllIIII.getMinRequired();
        int llllllllllllllllIIIIIlIllllIllIl = llllllllllllllllIIIIIlIlllllIIII.getMaxAllowed();
        if (llllllllllllllllIIIIIlIllllIllll < llllllllllllllllIIIIIlIllllIlllI) {
            throw new InjectionValidationException(llllllllllllllllIIIIIlIlllllIIII, String.format("expected %d invocation(s) but only %d succeeded", llllllllllllllllIIIIIlIllllIlllI, llllllllllllllllIIIIIlIllllIllll));
        }
        if (llllllllllllllllIIIIIlIllllIllll > llllllllllllllllIIIIIlIllllIllIl) {
            throw new InjectionValidationException(llllllllllllllllIIIIIlIlllllIIII, String.format("maximum of %d invocation(s) allowed but %d succeeded", llllllllllllllllIIIIIlIllllIllIl, llllllllllllllllIIIIIlIllllIllll));
        }
        return llllllllllllllllIIIIIlIlllllIIII;
    }

    public InjectorGroupInfo(String llllllllllllllllIIIIIllIIIlIIlIl) {
        llllllllllllllllIIIIIllIIIlIIlII(llllllllllllllllIIIIIllIIIlIIlIl, false);
        InjectorGroupInfo llllllllllllllllIIIIIllIIIlIIlII;
    }

    InjectorGroupInfo(String llllllllllllllllIIIIIllIIIIllIll, boolean llllllllllllllllIIIIIllIIIIllIlI) {
        InjectorGroupInfo llllllllllllllllIIIIIllIIIIlllII;
        llllllllllllllllIIIIIllIIIIlllII.members = new ArrayList<InjectionInfo>();
        llllllllllllllllIIIIIllIIIIlllII.minCallbackCount = -1;
        llllllllllllllllIIIIIllIIIIlllII.maxCallbackCount = Integer.MAX_VALUE;
        llllllllllllllllIIIIIllIIIIlllII.name = llllllllllllllllIIIIIllIIIIllIll;
        llllllllllllllllIIIIIllIIIIlllII.isDefault = llllllllllllllllIIIIIllIIIIllIlI;
    }

    public int getMaxAllowed() {
        InjectorGroupInfo llllllllllllllllIIIIIllIIIIIlIll;
        return Math.min(llllllllllllllllIIIIIllIIIIIlIll.maxCallbackCount, Integer.MAX_VALUE);
    }

    public static final class Map
    extends HashMap<String, InjectorGroupInfo> {
        private static final /* synthetic */ long serialVersionUID = 1L;
        private static final /* synthetic */ InjectorGroupInfo NO_GROUP;

        public InjectorGroupInfo forName(String lllllllllllllllllIIllIIlllIlIIII) {
            Map lllllllllllllllllIIllIIlllIlIIIl;
            InjectorGroupInfo lllllllllllllllllIIllIIlllIIllll = (InjectorGroupInfo)super.get(lllllllllllllllllIIllIIlllIlIIII);
            if (lllllllllllllllllIIllIIlllIIllll == null) {
                lllllllllllllllllIIllIIlllIIllll = new InjectorGroupInfo(lllllllllllllllllIIllIIlllIlIIII);
                lllllllllllllllllIIllIIlllIlIIIl.put(lllllllllllllllllIIllIIlllIlIIII, lllllllllllllllllIIllIIlllIIllll);
            }
            return lllllllllllllllllIIllIIlllIIllll;
        }

        public InjectorGroupInfo parseGroup(AnnotationNode lllllllllllllllllIIllIIllIlllIlI, String lllllllllllllllllIIllIIllIlllIIl) {
            Integer lllllllllllllllllIIllIIllIllIlIl;
            Map lllllllllllllllllIIllIIllIllIlII;
            if (lllllllllllllllllIIllIIllIlllIlI == null) {
                return NO_GROUP;
            }
            String lllllllllllllllllIIllIIllIlllIII = (String)Annotations.getValue(lllllllllllllllllIIllIIllIlllIlI, "name");
            if (lllllllllllllllllIIllIIllIlllIII == null || lllllllllllllllllIIllIIllIlllIII.isEmpty()) {
                lllllllllllllllllIIllIIllIlllIII = lllllllllllllllllIIllIIllIlllIIl;
            }
            InjectorGroupInfo lllllllllllllllllIIllIIllIllIlll = lllllllllllllllllIIllIIllIllIlII.forName(lllllllllllllllllIIllIIllIlllIII);
            Integer lllllllllllllllllIIllIIllIllIllI = (Integer)Annotations.getValue(lllllllllllllllllIIllIIllIlllIlI, "min");
            if (lllllllllllllllllIIllIIllIllIllI != null && lllllllllllllllllIIllIIllIllIllI != -1) {
                lllllllllllllllllIIllIIllIllIlll.setMinRequired(lllllllllllllllllIIllIIllIllIllI);
            }
            if ((lllllllllllllllllIIllIIllIllIlIl = (Integer)Annotations.getValue(lllllllllllllllllIIllIIllIlllIlI, "max")) != null && lllllllllllllllllIIllIIllIllIlIl != -1) {
                lllllllllllllllllIIllIIllIllIlll.setMaxAllowed(lllllllllllllllllIIllIIllIllIlIl);
            }
            return lllllllllllllllllIIllIIllIllIlll;
        }

        static {
            NO_GROUP = new InjectorGroupInfo("NONE", true);
        }

        @Override
        public InjectorGroupInfo get(Object lllllllllllllllllIIllIIlllIlIlll) {
            Map lllllllllllllllllIIllIIlllIllIII;
            return lllllllllllllllllIIllIIlllIllIII.forName(lllllllllllllllllIIllIIlllIlIlll.toString());
        }

        public Map() {
            Map lllllllllllllllllIIllIIlllIlllII;
        }

        public InjectorGroupInfo parseGroup(MethodNode lllllllllllllllllIIllIIlllIIIlII, String lllllllllllllllllIIllIIlllIIIllI) {
            Map lllllllllllllllllIIllIIlllIIIlIl;
            return lllllllllllllllllIIllIIlllIIIlIl.parseGroup(Annotations.getInvisible(lllllllllllllllllIIllIIlllIIIlII, Group.class), lllllllllllllllllIIllIIlllIIIllI);
        }

        public void validateAll() throws InjectionValidationException {
            Map lllllllllllllllllIIllIIllIlIlIII;
            for (InjectorGroupInfo lllllllllllllllllIIllIIllIlIlIlI : lllllllllllllllllIIllIIllIlIlIII.values()) {
                lllllllllllllllllIIllIIllIlIlIlI.validate();
            }
        }
    }
}

