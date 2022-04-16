/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.lib.tree.analysis.BasicValue;
import org.spongepowered.asm.lib.tree.analysis.BasicVerifier;
import org.spongepowered.asm.lib.tree.analysis.Value;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class SimpleVerifier
extends BasicVerifier {
    private final /* synthetic */ Type currentClass;
    private final /* synthetic */ boolean isInterface;
    private /* synthetic */ ClassLoader loader;
    private final /* synthetic */ List<Type> currentClassInterfaces;
    private final /* synthetic */ Type currentSuperClass;

    public void setClassLoader(ClassLoader llllllllllllllllllIIllllllIllIll) {
        llllllllllllllllllIIllllllIllllI.loader = llllllllllllllllllIIllllllIllIll;
    }

    public SimpleVerifier(Type llllllllllllllllllIlIIIIIIIIIlII, Type llllllllllllllllllIlIIIIIIIIIlll, boolean llllllllllllllllllIlIIIIIIIIIllI) {
        llllllllllllllllllIlIIIIIIIIlIIl(llllllllllllllllllIlIIIIIIIIIlII, llllllllllllllllllIlIIIIIIIIIlll, null, llllllllllllllllllIlIIIIIIIIIllI);
        SimpleVerifier llllllllllllllllllIlIIIIIIIIlIIl;
    }

    @Override
    protected boolean isSubTypeOf(BasicValue llllllllllllllllllIIlllllIIIlllI, BasicValue llllllllllllllllllIIlllllIIlIIlI) {
        Type llllllllllllllllllIIlllllIIlIIIl = llllllllllllllllllIIlllllIIlIIlI.getType();
        Type llllllllllllllllllIIlllllIIlIIII = llllllllllllllllllIIlllllIIIlllI.getType();
        switch (llllllllllllllllllIIlllllIIlIIIl.getSort()) {
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                return llllllllllllllllllIIlllllIIlIIII.equals(llllllllllllllllllIIlllllIIlIIIl);
            }
            case 9: 
            case 10: {
                if ("Lnull;".equals(llllllllllllllllllIIlllllIIlIIII.getDescriptor())) {
                    return true;
                }
                if (llllllllllllllllllIIlllllIIlIIII.getSort() == 10 || llllllllllllllllllIIlllllIIlIIII.getSort() == 9) {
                    SimpleVerifier llllllllllllllllllIIlllllIIlIlII;
                    return llllllllllllllllllIIlllllIIlIlII.isAssignableFrom(llllllllllllllllllIIlllllIIlIIIl, llllllllllllllllllIIlllllIIlIIII);
                }
                return false;
            }
        }
        throw new Error("Internal error");
    }

    public SimpleVerifier(Type llllllllllllllllllIIlllllllllIll, Type llllllllllllllllllIIlllllllllIlI, List<Type> llllllllllllllllllIIlllllllllIIl, boolean llllllllllllllllllIIllllllllIIll) {
        llllllllllllllllllIIllllllllIlll(327680, llllllllllllllllllIIlllllllllIll, llllllllllllllllllIIlllllllllIlI, llllllllllllllllllIIlllllllllIIl, llllllllllllllllllIIllllllllIIll);
        SimpleVerifier llllllllllllllllllIIllllllllIlll;
    }

    protected boolean isInterface(Type llllllllllllllllllIIllllIllllIII) {
        SimpleVerifier llllllllllllllllllIIllllIlllIlll;
        if (llllllllllllllllllIIllllIlllIlll.currentClass != null && llllllllllllllllllIIllllIllllIII.equals(llllllllllllllllllIIllllIlllIlll.currentClass)) {
            return llllllllllllllllllIIllllIlllIlll.isInterface;
        }
        return llllllllllllllllllIIllllIlllIlll.getClass(llllllllllllllllllIIllllIllllIII).isInterface();
    }

    protected Type getSuperClass(Type llllllllllllllllllIIllllIllIlllI) {
        SimpleVerifier llllllllllllllllllIIllllIllIllll;
        if (llllllllllllllllllIIllllIllIllll.currentClass != null && llllllllllllllllllIIllllIllIlllI.equals(llllllllllllllllllIIllllIllIllll.currentClass)) {
            return llllllllllllllllllIIllllIllIllll.currentSuperClass;
        }
        Class<?> llllllllllllllllllIIllllIlllIIII = llllllllllllllllllIIllllIllIllll.getClass(llllllllllllllllllIIllllIllIlllI).getSuperclass();
        return llllllllllllllllllIIllllIlllIIII == null ? null : Type.getType(llllllllllllllllllIIllllIlllIIII);
    }

    protected boolean isAssignableFrom(Type llllllllllllllllllIIllllIllIIlII, Type llllllllllllllllllIIllllIllIIIll) {
        SimpleVerifier llllllllllllllllllIIllllIllIIlIl;
        if (llllllllllllllllllIIllllIllIIlII.equals(llllllllllllllllllIIllllIllIIIll)) {
            return true;
        }
        if (llllllllllllllllllIIllllIllIIlIl.currentClass != null && llllllllllllllllllIIllllIllIIlII.equals(llllllllllllllllllIIllllIllIIlIl.currentClass)) {
            if (llllllllllllllllllIIllllIllIIlIl.getSuperClass(llllllllllllllllllIIllllIllIIIll) == null) {
                return false;
            }
            if (llllllllllllllllllIIllllIllIIlIl.isInterface) {
                return llllllllllllllllllIIllllIllIIIll.getSort() == 10 || llllllllllllllllllIIllllIllIIIll.getSort() == 9;
            }
            return llllllllllllllllllIIllllIllIIlIl.isAssignableFrom(llllllllllllllllllIIllllIllIIlII, llllllllllllllllllIIllllIllIIlIl.getSuperClass(llllllllllllllllllIIllllIllIIIll));
        }
        if (llllllllllllllllllIIllllIllIIlIl.currentClass != null && llllllllllllllllllIIllllIllIIIll.equals(llllllllllllllllllIIllllIllIIlIl.currentClass)) {
            if (llllllllllllllllllIIllllIllIIlIl.isAssignableFrom(llllllllllllllllllIIllllIllIIlII, llllllllllllllllllIIllllIllIIlIl.currentSuperClass)) {
                return true;
            }
            if (llllllllllllllllllIIllllIllIIlIl.currentClassInterfaces != null) {
                for (int llllllllllllllllllIIllllIllIIllI = 0; llllllllllllllllllIIllllIllIIllI < llllllllllllllllllIIllllIllIIlIl.currentClassInterfaces.size(); ++llllllllllllllllllIIllllIllIIllI) {
                    Type llllllllllllllllllIIllllIllIIlll = llllllllllllllllllIIllllIllIIlIl.currentClassInterfaces.get(llllllllllllllllllIIllllIllIIllI);
                    if (!llllllllllllllllllIIllllIllIIlIl.isAssignableFrom(llllllllllllllllllIIllllIllIIlII, llllllllllllllllllIIllllIllIIlll)) continue;
                    return true;
                }
            }
            return false;
        }
        Class<Object> llllllllllllllllllIIllllIllIIIlI = llllllllllllllllllIIllllIllIIlIl.getClass(llllllllllllllllllIIllllIllIIlII);
        if (llllllllllllllllllIIllllIllIIIlI.isInterface()) {
            llllllllllllllllllIIllllIllIIIlI = Object.class;
        }
        return llllllllllllllllllIIllllIllIIIlI.isAssignableFrom(llllllllllllllllllIIllllIllIIlIl.getClass(llllllllllllllllllIIllllIllIIIll));
    }

    protected SimpleVerifier(int llllllllllllllllllIIlllllllIlIll, Type llllllllllllllllllIIlllllllIIlII, Type llllllllllllllllllIIlllllllIIIll, List<Type> llllllllllllllllllIIlllllllIlIII, boolean llllllllllllllllllIIlllllllIIlll) {
        super(llllllllllllllllllIIlllllllIlIll);
        SimpleVerifier llllllllllllllllllIIlllllllIIllI;
        llllllllllllllllllIIlllllllIIllI.loader = llllllllllllllllllIIlllllllIIllI.getClass().getClassLoader();
        llllllllllllllllllIIlllllllIIllI.currentClass = llllllllllllllllllIIlllllllIIlII;
        llllllllllllllllllIIlllllllIIllI.currentSuperClass = llllllllllllllllllIIlllllllIIIll;
        llllllllllllllllllIIlllllllIIllI.currentClassInterfaces = llllllllllllllllllIIlllllllIlIII;
        llllllllllllllllllIIlllllllIIllI.isInterface = llllllllllllllllllIIlllllllIIlll;
    }

    @Override
    public BasicValue merge(BasicValue llllllllllllllllllIIlllllIIIIIlI, BasicValue llllllllllllllllllIIllllIllllllI) {
        if (!llllllllllllllllllIIlllllIIIIIlI.equals(llllllllllllllllllIIllllIllllllI)) {
            Type llllllllllllllllllIIlllllIIIIlIl = llllllllllllllllllIIlllllIIIIIlI.getType();
            Type llllllllllllllllllIIlllllIIIIlII = llllllllllllllllllIIllllIllllllI.getType();
            if (!(llllllllllllllllllIIlllllIIIIlIl == null || llllllllllllllllllIIlllllIIIIlIl.getSort() != 10 && llllllllllllllllllIIlllllIIIIlIl.getSort() != 9 || llllllllllllllllllIIlllllIIIIlII == null || llllllllllllllllllIIlllllIIIIlII.getSort() != 10 && llllllllllllllllllIIlllllIIIIlII.getSort() != 9)) {
                SimpleVerifier llllllllllllllllllIIlllllIIIIIll;
                if ("Lnull;".equals(llllllllllllllllllIIlllllIIIIlIl.getDescriptor())) {
                    return llllllllllllllllllIIllllIllllllI;
                }
                if ("Lnull;".equals(llllllllllllllllllIIlllllIIIIlII.getDescriptor())) {
                    return llllllllllllllllllIIlllllIIIIIlI;
                }
                if (llllllllllllllllllIIlllllIIIIIll.isAssignableFrom(llllllllllllllllllIIlllllIIIIlIl, llllllllllllllllllIIlllllIIIIlII)) {
                    return llllllllllllllllllIIlllllIIIIIlI;
                }
                if (llllllllllllllllllIIlllllIIIIIll.isAssignableFrom(llllllllllllllllllIIlllllIIIIlII, llllllllllllllllllIIlllllIIIIlIl)) {
                    return llllllllllllllllllIIllllIllllllI;
                }
                do {
                    if (llllllllllllllllllIIlllllIIIIlIl != null && !llllllllllllllllllIIlllllIIIIIll.isInterface(llllllllllllllllllIIlllllIIIIlIl)) continue;
                    return BasicValue.REFERENCE_VALUE;
                } while (!llllllllllllllllllIIlllllIIIIIll.isAssignableFrom(llllllllllllllllllIIlllllIIIIlIl = llllllllllllllllllIIlllllIIIIIll.getSuperClass(llllllllllllllllllIIlllllIIIIlIl), llllllllllllllllllIIlllllIIIIlII));
                return llllllllllllllllllIIlllllIIIIIll.newValue(llllllllllllllllllIIlllllIIIIlIl);
            }
            return BasicValue.UNINITIALIZED_VALUE;
        }
        return llllllllllllllllllIIlllllIIIIIlI;
    }

    @Override
    protected boolean isArrayValue(BasicValue llllllllllllllllllIIllllllIIIIII) {
        Type llllllllllllllllllIIllllllIIIIIl = llllllllllllllllllIIllllllIIIIII.getType();
        return llllllllllllllllllIIllllllIIIIIl != null && ("Lnull;".equals(llllllllllllllllllIIllllllIIIIIl.getDescriptor()) || llllllllllllllllllIIllllllIIIIIl.getSort() == 9);
    }

    @Override
    protected BasicValue getElementValue(BasicValue llllllllllllllllllIIlllllIllIIII) throws AnalyzerException {
        Type llllllllllllllllllIIlllllIllIlII = llllllllllllllllllIIlllllIllIIII.getType();
        if (llllllllllllllllllIIlllllIllIlII != null) {
            if (llllllllllllllllllIIlllllIllIlII.getSort() == 9) {
                SimpleVerifier llllllllllllllllllIIlllllIllIIlI;
                return llllllllllllllllllIIlllllIllIIlI.newValue(Type.getType(llllllllllllllllllIIlllllIllIlII.getDescriptor().substring(1)));
            }
            if ("Lnull;".equals(llllllllllllllllllIIlllllIllIlII.getDescriptor())) {
                return llllllllllllllllllIIlllllIllIIII;
            }
        }
        throw new Error("Internal error");
    }

    protected Class<?> getClass(Type llllllllllllllllllIIllllIlIlIlll) {
        try {
            SimpleVerifier llllllllllllllllllIIllllIlIllIII;
            if (llllllllllllllllllIIllllIlIlIlll.getSort() == 9) {
                return Class.forName(llllllllllllllllllIIllllIlIlIlll.getDescriptor().replace('/', '.'), false, llllllllllllllllllIIllllIlIllIII.loader);
            }
            return Class.forName(llllllllllllllllllIIllllIlIlIlll.getClassName(), false, llllllllllllllllllIIllllIlIllIII.loader);
        }
        catch (ClassNotFoundException llllllllllllllllllIIllllIlIllIIl) {
            throw new RuntimeException(llllllllllllllllllIIllllIlIllIIl.toString());
        }
    }

    @Override
    public BasicValue newValue(Type llllllllllllllllllIIllllllIlIIIl) {
        SimpleVerifier llllllllllllllllllIIllllllIIlllI;
        Value llllllllllllllllllIIllllllIIllll;
        boolean llllllllllllllllllIIllllllIlIIII;
        if (llllllllllllllllllIIllllllIlIIIl == null) {
            return BasicValue.UNINITIALIZED_VALUE;
        }
        boolean bl = llllllllllllllllllIIllllllIlIIII = llllllllllllllllllIIllllllIlIIIl.getSort() == 9;
        if (llllllllllllllllllIIllllllIlIIII) {
            switch (llllllllllllllllllIIllllllIlIIIl.getElementType().getSort()) {
                case 1: 
                case 2: 
                case 3: 
                case 4: {
                    return new BasicValue(llllllllllllllllllIIllllllIlIIIl);
                }
            }
        }
        if (BasicValue.REFERENCE_VALUE.equals(llllllllllllllllllIIllllllIIllll = super.newValue(llllllllllllllllllIIllllllIlIIIl))) {
            if (llllllllllllllllllIIllllllIlIIII) {
                llllllllllllllllllIIllllllIIllll = llllllllllllllllllIIllllllIIlllI.newValue(llllllllllllllllllIIllllllIlIIIl.getElementType());
                String llllllllllllllllllIIllllllIlIIll = ((BasicValue)llllllllllllllllllIIllllllIIllll).getType().getDescriptor();
                for (int llllllllllllllllllIIllllllIlIlII = 0; llllllllllllllllllIIllllllIlIlII < llllllllllllllllllIIllllllIlIIIl.getDimensions(); ++llllllllllllllllllIIllllllIlIlII) {
                    llllllllllllllllllIIllllllIlIIll = String.valueOf(new StringBuilder().append('[').append(llllllllllllllllllIIllllllIlIIll));
                }
                llllllllllllllllllIIllllllIIllll = new BasicValue(Type.getType(llllllllllllllllllIIllllllIlIIll));
            } else {
                llllllllllllllllllIIllllllIIllll = new BasicValue(llllllllllllllllllIIllllllIlIIIl);
            }
        }
        return llllllllllllllllllIIllllllIIllll;
    }

    public SimpleVerifier() {
        llllllllllllllllllIlIIIIIIIIllll(null, null, false);
        SimpleVerifier llllllllllllllllllIlIIIIIIIIllll;
    }
}

