/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.spongepowered.asm.lib.signature.SignatureReader;
import org.spongepowered.asm.lib.signature.SignatureVisitor;
import org.spongepowered.asm.lib.signature.SignatureWriter;
import org.spongepowered.asm.lib.tree.ClassNode;

public class ClassSignature {
    private final /* synthetic */ Deque<String> rawInterfaces;
    private final /* synthetic */ List<Token> interfaces;
    private final /* synthetic */ Map<TypeVar, TokenHandle> types;
    private /* synthetic */ Token superClass;
    protected static final /* synthetic */ String OBJECT;

    private ClassSignature read(String lIlllIlllIIIll) {
        ClassSignature lIlllIlllIIIlI;
        if (lIlllIlllIIIll != null) {
            try {
                new SignatureReader(lIlllIlllIIIll).accept(lIlllIlllIIIlI.new SignatureParser());
            }
            catch (Exception lIlllIlllIIlIl) {
                lIlllIlllIIlIl.printStackTrace();
            }
        }
        return lIlllIlllIIIlI;
    }

    protected String getTypeVar(TokenHandle lIlllIlIlllllI) {
        ClassSignature lIlllIlIllllll;
        for (Map.Entry<TypeVar, TokenHandle> lIlllIllIIIIII : lIlllIlIllllll.types.entrySet()) {
            TypeVar lIlllIllIIIIlI = lIlllIllIIIIII.getKey();
            TokenHandle lIlllIllIIIIIl = lIlllIllIIIIII.getValue();
            if (lIlllIlIlllllI != lIlllIllIIIIIl && lIlllIlIlllllI.asToken() != lIlllIllIIIIIl.asToken()) continue;
            return String.valueOf(new StringBuilder().append("T").append(lIlllIllIIIIlI).append(";"));
        }
        return lIlllIlIlllllI.token.asType();
    }

    public ClassSignature wake() {
        ClassSignature lIlllIIIIlllIl;
        return lIlllIIIIlllIl;
    }

    private String findUniqueName(String lIlllIIlIlIllI, Set<String> lIlllIIlIllIIl) {
        ClassSignature lIlllIIlIlIlll;
        String lIlllIIlIlllII;
        if (!lIlllIIlIllIIl.contains(lIlllIIlIlIllI)) {
            return lIlllIIlIlIllI;
        }
        if (lIlllIIlIlIllI.length() == 1 && (lIlllIIlIlllII = lIlllIIlIlIlll.findOffsetName(lIlllIIlIlIllI.charAt(0), lIlllIIlIllIIl)) != null) {
            return lIlllIIlIlllII;
        }
        String lIlllIIlIllIII = lIlllIIlIlIlll.findOffsetName('T', lIlllIIlIllIIl, "", lIlllIIlIlIllI);
        if (lIlllIIlIllIII != null) {
            return lIlllIIlIllIII;
        }
        lIlllIIlIllIII = lIlllIIlIlIlll.findOffsetName('T', lIlllIIlIllIIl, lIlllIIlIlIllI, "");
        if (lIlllIIlIllIII != null) {
            return lIlllIIlIllIII;
        }
        lIlllIIlIllIII = lIlllIIlIlIlll.findOffsetName('T', lIlllIIlIllIIl, "T", lIlllIIlIlIllI);
        if (lIlllIIlIllIII != null) {
            return lIlllIIlIllIII;
        }
        lIlllIIlIllIII = lIlllIIlIlIlll.findOffsetName('T', lIlllIIlIllIIl, "", String.valueOf(new StringBuilder().append(lIlllIIlIlIllI).append("Type")));
        if (lIlllIIlIllIII != null) {
            return lIlllIIlIllIII;
        }
        throw new IllegalStateException(String.valueOf(new StringBuilder().append("Failed to conform type var: ").append(lIlllIIlIlIllI)));
    }

    private static ClassSignature generate(ClassNode lIlllIIIIIlllI) {
        ClassSignature lIlllIIIIIllIl = new ClassSignature();
        lIlllIIIIIllIl.setSuperClass(new Token(lIlllIIIIIlllI.superName != null ? lIlllIIIIIlllI.superName : "java/lang/Object"));
        for (String lIlllIIIIIllll : lIlllIIIIIlllI.interfaces) {
            lIlllIIIIIllIl.addInterface(new Token(lIlllIIIIIllll));
        }
        return lIlllIIIIIllIl;
    }

    public String toString() {
        ClassSignature lIlllIIIlIlIII;
        while (lIlllIIIlIlIII.rawInterfaces.size() > 0) {
            lIlllIIIlIlIII.addRawInterface(lIlllIIIlIlIII.rawInterfaces.remove());
        }
        StringBuilder lIlllIIIlIIlll = new StringBuilder();
        if (lIlllIIIlIlIII.types.size() > 0) {
            boolean lIlllIIIlIlIll = false;
            StringBuilder lIlllIIIlIlIlI = new StringBuilder();
            for (Map.Entry<TypeVar, TokenHandle> lIlllIIIlIllII : lIlllIIIlIlIII.types.entrySet()) {
                String lIlllIIIlIllIl = lIlllIIIlIllII.getValue().asBound();
                if (lIlllIIIlIllIl.isEmpty()) continue;
                lIlllIIIlIlIlI.append(lIlllIIIlIllII.getKey()).append(':').append(lIlllIIIlIllIl);
                lIlllIIIlIlIll = true;
            }
            if (lIlllIIIlIlIll) {
                lIlllIIIlIIlll.append('<').append((CharSequence)lIlllIIIlIlIlI).append('>');
            }
        }
        lIlllIIIlIIlll.append(lIlllIIIlIlIII.superClass.asType());
        for (Token lIlllIIIlIlIIl : lIlllIIIlIlIII.interfaces) {
            lIlllIIIlIIlll.append(lIlllIIIlIlIIl.asType());
        }
        return String.valueOf(lIlllIIIlIIlll);
    }

    private void conform(Set<String> lIlllIIllIIllI) {
        ClassSignature lIlllIIllIIlll;
        for (TypeVar lIlllIIllIlIII : lIlllIIllIIlll.types.keySet()) {
            String lIlllIIllIlIIl = lIlllIIllIIlll.findUniqueName(lIlllIIllIlIII.getOriginalName(), lIlllIIllIIllI);
            lIlllIIllIlIII.rename(lIlllIIllIlIIl);
            lIlllIIllIIllI.add(lIlllIIllIlIIl);
        }
    }

    protected void addRawInterface(String lIlllIlIIIlIII) {
        ClassSignature lIlllIlIIIIlIl;
        Token lIlllIlIIIIlll = new Token(lIlllIlIIIlIII);
        String lIlllIlIIIIllI = lIlllIlIIIIlll.asType(true);
        for (Token lIlllIlIIIlIlI : lIlllIlIIIIlIl.interfaces) {
            if (!lIlllIlIIIlIlI.asType(true).equals(lIlllIlIIIIllI)) continue;
            return;
        }
        lIlllIlIIIIlIl.interfaces.add(lIlllIlIIIIlll);
    }

    protected TypeVar getTypeVar(String lIlllIllIlIlll) {
        ClassSignature lIlllIllIllIII;
        for (TypeVar lIlllIllIllIll : lIlllIllIllIII.types.keySet()) {
            if (!lIlllIllIllIll.matches(lIlllIllIlIlll)) continue;
            return lIlllIllIllIll;
        }
        return null;
    }

    public static ClassSignature of(ClassNode lIlllIIIIllIII) {
        if (lIlllIIIIllIII.signature != null) {
            return ClassSignature.of(lIlllIIIIllIII.signature);
        }
        return ClassSignature.generate(lIlllIIIIllIII);
    }

    public void merge(ClassSignature lIlllIIlllIlII) {
        ClassSignature lIlllIIlllIlIl;
        try {
            HashSet<String> lIlllIIllllIIl = new HashSet<String>();
            for (TypeVar lIlllIIllllIlI : lIlllIIlllIlIl.types.keySet()) {
                lIlllIIllllIIl.add(lIlllIIllllIlI.toString());
            }
            lIlllIIlllIlII.conform(lIlllIIllllIIl);
        }
        catch (IllegalStateException lIlllIIllllIII) {
            lIlllIIllllIII.printStackTrace();
            return;
        }
        for (Map.Entry<TypeVar, TokenHandle> lIlllIIlllIlll : lIlllIIlllIlII.types.entrySet()) {
            lIlllIIlllIlIl.addTypeVar(lIlllIIlllIlll.getKey(), lIlllIIlllIlll.getValue());
        }
        for (Token lIlllIIlllIllI : lIlllIIlllIlII.interfaces) {
            lIlllIIlllIlIl.addInterface(lIlllIIlllIllI);
        }
    }

    ClassSignature() {
        ClassSignature lIlllIlllIlIIl;
        lIlllIlllIlIIl.types = new LinkedHashMap<TypeVar, TokenHandle>();
        lIlllIlllIlIIl.superClass = new Token("java/lang/Object");
        lIlllIlllIlIIl.interfaces = new ArrayList<Token>();
        lIlllIlllIlIIl.rawInterfaces = new LinkedList<String>();
    }

    public String getSuperClass() {
        ClassSignature lIlllIlIlIIllI;
        return lIlllIlIlIIllI.superClass.asType(true);
    }

    protected TokenHandle getType(String lIlllIllIIlIll) {
        ClassSignature lIlllIllIIllII;
        for (TypeVar lIlllIllIlIIII : lIlllIllIIllII.types.keySet()) {
            if (!lIlllIllIlIIII.matches(lIlllIllIIlIll)) continue;
            return lIlllIllIIllII.types.get(lIlllIllIlIIII);
        }
        TokenHandle lIlllIllIIllIl = lIlllIllIIllII.new TokenHandle();
        lIlllIllIIllII.types.put(new TypeVar(lIlllIllIIlIll), lIlllIllIIllIl);
        return lIlllIllIIllIl;
    }

    protected void addTypeVar(TypeVar lIlllIlIllIIII, TokenHandle lIlllIlIllIIlI) throws IllegalArgumentException {
        ClassSignature lIlllIlIllIlII;
        if (lIlllIlIllIlII.types.containsKey(lIlllIlIllIIII)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("TypeVar ").append(lIlllIlIllIIII).append(" is already present on ").append(lIlllIlIllIlII)));
        }
        lIlllIlIllIlII.types.put(lIlllIlIllIIII, lIlllIlIllIIlI);
    }

    private String findOffsetName(char lIlllIIlIIllll, Set<String> lIlllIIlIIlllI) {
        ClassSignature lIlllIIlIIllIl;
        return lIlllIIlIIllIl.findOffsetName(lIlllIIlIIllll, lIlllIIlIIlllI, "", "");
    }

    public SignatureVisitor getRemapper() {
        ClassSignature lIlllIIIllIllI;
        return lIlllIIIllIllI.new SignatureRemapper();
    }

    public static ClassSignature of(String lIlllIIIIllIll) {
        return new ClassSignature().read(lIlllIIIIllIll);
    }

    public void addInterface(String lIlllIlIIlIIll) {
        ClassSignature lIlllIlIIlIIlI;
        lIlllIlIIlIIlI.rawInterfaces.add(lIlllIlIIlIIll);
    }

    static {
        OBJECT = "java/lang/Object";
    }

    public static ClassSignature ofLazy(ClassNode lIlllIIIIlIlII) {
        if (lIlllIIIIlIlII.signature != null) {
            return new Lazy(lIlllIIIIlIlII.signature);
        }
        return ClassSignature.generate(lIlllIIIIlIlII);
    }

    protected void setSuperClass(Token lIlllIlIlIlIll) {
        lIlllIlIlIlIlI.superClass = lIlllIlIlIlIll;
    }

    private String findOffsetName(char lIlllIIIllllIl, Set<String> lIlllIIlIIIIIl, String lIlllIIlIIIIII, String lIlllIIIlllIlI) {
        String lIlllIIIlllllI = String.format("%s%s%s", lIlllIIlIIIIII, Character.valueOf(lIlllIIIllllIl), lIlllIIIlllIlI);
        if (!lIlllIIlIIIIIl.contains(lIlllIIIlllllI)) {
            return lIlllIIIlllllI;
        }
        if (lIlllIIIllllIl > '@' && lIlllIIIllllIl < '[') {
            int lIlllIIlIIIlII = lIlllIIIllllIl - 64;
            while (lIlllIIlIIIlII + 65 != lIlllIIIllllIl) {
                lIlllIIIlllllI = String.format("%s%s%s", lIlllIIlIIIIII, Character.valueOf((char)(lIlllIIlIIIlII + 65)), lIlllIIIlllIlI);
                if (!lIlllIIlIIIIIl.contains(lIlllIIIlllllI)) {
                    return lIlllIIIlllllI;
                }
                ++lIlllIIlIIIlII;
                lIlllIIlIIIlII %= 26;
            }
        }
        return null;
    }

    protected void addInterface(Token lIlllIlIIllIlI) {
        ClassSignature lIlllIlIIlllIl;
        if (!lIlllIlIIllIlI.isRaw()) {
            String lIlllIlIIllllI = lIlllIlIIllIlI.asType(true);
            ListIterator<Token> lIlllIlIIlllll = lIlllIlIIlllIl.interfaces.listIterator();
            while (lIlllIlIIlllll.hasNext()) {
                Token lIlllIlIlIIIII = lIlllIlIIlllll.next();
                if (!lIlllIlIlIIIII.isRaw() || !lIlllIlIlIIIII.asType(true).equals(lIlllIlIIllllI)) continue;
                lIlllIlIIlllll.set(lIlllIlIIllIlI);
                return;
            }
        }
        lIlllIlIIlllIl.interfaces.add(lIlllIlIIllIlI);
    }

    static class TypeVar
    implements Comparable<TypeVar> {
        private /* synthetic */ String currentName;
        private final /* synthetic */ String originalName;

        TypeVar(String lllIllIlIlIIl) {
            TypeVar lllIllIlIlIII;
            lllIllIlIlIII.currentName = lllIllIlIlIII.originalName = lllIllIlIlIIl;
        }

        String getOriginalName() {
            TypeVar lllIllIIlIIll;
            return lllIllIIlIIll.originalName;
        }

        void rename(String lllIllIIIlIll) {
            lllIllIIIlllI.currentName = lllIllIIIlIll;
        }

        public boolean matches(String lllIllIIIIIll) {
            TypeVar lllIllIIIIlII;
            return lllIllIIIIlII.originalName.equals(lllIllIIIIIll);
        }

        public int hashCode() {
            TypeVar lllIlIllllIlI;
            return lllIlIllllIlI.currentName.hashCode();
        }

        public String toString() {
            TypeVar lllIllIIllIll;
            return lllIllIIllIll.currentName;
        }

        @Override
        public int compareTo(TypeVar lllIllIlIIIII) {
            TypeVar lllIllIlIIIIl;
            return lllIllIlIIIIl.currentName.compareTo(lllIllIlIIIII.currentName);
        }

        public boolean equals(Object lllIlIlllllIl) {
            TypeVar lllIlIllllllI;
            return lllIlIllllllI.currentName.equals(lllIlIlllllIl);
        }
    }

    class SignatureParser
    extends SignatureVisitor {
        private /* synthetic */ FormalParamElement param;

        @Override
        public void visitFormalTypeParameter(String llllllllllllllllIlllIIIIIlIllIIl) {
            SignatureParser llllllllllllllllIlllIIIIIlIlllII;
            llllllllllllllllIlllIIIIIlIlllII.param = llllllllllllllllIlllIIIIIlIlllII.new FormalParamElement(llllllllllllllllIlllIIIIIlIllIIl);
        }

        SignatureParser() {
            SignatureParser llllllllllllllllIlllIIIIIllIIIII;
            super(327680);
        }

        @Override
        public SignatureVisitor visitInterface() {
            SignatureParser llllllllllllllllIlllIIIIIlIIlllI;
            return llllllllllllllllIlllIIIIIlIIlllI.new InterfaceElement();
        }

        @Override
        public SignatureVisitor visitInterfaceBound() {
            SignatureParser llllllllllllllllIlllIIIIIlIlIlII;
            return llllllllllllllllIlllIIIIIlIlIlII.param.visitInterfaceBound();
        }

        @Override
        public SignatureVisitor visitClassBound() {
            SignatureParser llllllllllllllllIlllIIIIIlIlIlll;
            return llllllllllllllllIlllIIIIIlIlIlll.param.visitClassBound();
        }

        @Override
        public SignatureVisitor visitSuperclass() {
            SignatureParser llllllllllllllllIlllIIIIIlIlIIIl;
            return llllllllllllllllIlllIIIIIlIlIIIl.new SuperClassElement();
        }

        class SuperClassElement
        extends TokenElement {
            SuperClassElement() {
                SuperClassElement lllllllllllllllllIIIllIlIIIlIIIl;
            }

            @Override
            public void visitEnd() {
                SuperClassElement lllllllllllllllllIIIllIlIIIIlIIl;
                lllllllllllllllllIIIllIlIIIIlIIl.ClassSignature.this.setSuperClass(lllllllllllllllllIIIllIlIIIIlIIl.token);
            }
        }

        class BoundElement
        extends TokenElement {
            private final /* synthetic */ TokenElement type;
            private final /* synthetic */ boolean classBound;

            @Override
            public void visitClassType(String lIllIIllllIllIl) {
                BoundElement lIllIIllllIlllI;
                lIllIIllllIlllI.token = lIllIIllllIlllI.type.token.addBound(lIllIIllllIllIl, lIllIIllllIlllI.classBound);
            }

            BoundElement(TokenElement lIllIIlllllIIll, boolean lIllIIlllllIIIl) {
                BoundElement lIllIIllllllIlI;
                lIllIIllllllIlI.type = lIllIIlllllIIll;
                lIllIIllllllIlI.classBound = lIllIIlllllIIIl;
            }

            @Override
            public void visitTypeArgument() {
                BoundElement lIllIIllllIlIII;
                lIllIIllllIlIII.token.addTypeArgument('*');
            }

            @Override
            public SignatureVisitor visitTypeArgument(char lIllIIllllIIIlI) {
                BoundElement lIllIIllllIIlIl;
                return new TypeArgElement(lIllIIllllIIlIl, lIllIIllllIIIlI);
            }
        }

        abstract class TokenElement
        extends SignatureElement {
            private /* synthetic */ boolean array;
            protected /* synthetic */ Token token;

            IToken addTypeArgument(TokenHandle lllIIlIlIlIII) {
                TokenElement lllIIlIlIlIIl;
                return lllIIlIlIlIIl.token.addTypeArgument(lllIIlIlIlIII).setArray(lllIIlIlIlIIl.getArray());
            }

            protected void setArray() {
                lllIIlllllIlI.array = true;
            }

            IToken addTypeArgument(char lllIIllIIIllI) {
                TokenElement lllIIllIIIlII;
                return lllIIllIIIlII.token.addTypeArgument(lllIIllIIIllI).setArray(lllIIllIIIlII.getArray());
            }

            private boolean getArray() {
                TokenElement lllIIllllIllI;
                boolean lllIIllllIlIl = lllIIllllIllI.array;
                lllIIllllIllI.array = false;
                return lllIIllllIlIl;
            }

            @Override
            public void visitInnerClassType(String lllIIlllIIIIl) {
                TokenElement lllIIlllIIIlI;
                lllIIlllIIIlI.token.addInnerClass(lllIIlllIIIIl);
            }

            IToken addTypeArgument(String lllIIlIllIllI) {
                TokenElement lllIIlIllIlIl;
                return lllIIlIllIlIl.token.addTypeArgument(lllIIlIllIllI).setArray(lllIIlIllIlIl.getArray());
            }

            Token addTypeArgument() {
                TokenElement lllIIllIlIIll;
                return lllIIllIlIIll.token.addTypeArgument('*').asToken();
            }

            TokenElement() {
                TokenElement lllIlIIIIIIII;
            }

            @Override
            public SignatureVisitor visitInterfaceBound() {
                TokenElement lllIIlllIlIII;
                lllIIlllIlIII.getToken();
                return new BoundElement(lllIIlllIlIII, false);
            }

            @Override
            public SignatureVisitor visitArrayType() {
                TokenElement lllIIllIlllll;
                lllIIllIlllll.setArray();
                return lllIIllIlllll;
            }

            @Override
            public SignatureVisitor visitClassBound() {
                TokenElement lllIIlllIlIlI;
                lllIIlllIlIlI.getToken();
                return new BoundElement(lllIIlllIlIlI, true);
            }

            @Override
            public SignatureVisitor visitTypeArgument(char lllIIllIlIlIl) {
                TokenElement lllIIllIllIII;
                return new TypeArgElement(lllIIllIllIII, lllIIllIlIlIl);
            }

            public Token getToken() {
                TokenElement lllIIllllllII;
                if (lllIIllllllII.token == null) {
                    lllIIllllllII.token = new Token();
                }
                return lllIIllllllII.token;
            }

            @Override
            public void visitClassType(String lllIIlllIllIl) {
                TokenElement lllIIllllIIII;
                lllIIllllIIII.getToken().setType(lllIIlllIllIl);
            }

            IToken addTypeArgument(Token lllIIlIlIlllI) {
                TokenElement lllIIlIlIllll;
                return lllIIlIlIllll.token.addTypeArgument(lllIIlIlIlllI).setArray(lllIIlIlIllll.getArray());
            }
        }

        class TypeArgElement
        extends TokenElement {
            private final /* synthetic */ char wildcard;
            private final /* synthetic */ TokenElement type;

            @Override
            public void visitBaseType(char llllllllllllllllIllIlIlllllIIllI) {
                TypeArgElement llllllllllllllllIllIlIlllllIlIIl;
                llllllllllllllllIllIlIlllllIlIIl.token = llllllllllllllllIllIlIlllllIlIIl.type.addTypeArgument(llllllllllllllllIllIlIlllllIIllI).asToken();
            }

            TypeArgElement(TokenElement llllllllllllllllIllIlIllllllIIII, char llllllllllllllllIllIlIllllllIIll) {
                TypeArgElement llllllllllllllllIllIlIllllllIIlI;
                llllllllllllllllIllIlIllllllIIlI.type = llllllllllllllllIllIlIllllllIIII;
                llllllllllllllllIllIlIllllllIIlI.wildcard = llllllllllllllllIllIlIllllllIIll;
            }

            @Override
            public void visitTypeArgument() {
                TypeArgElement llllllllllllllllIllIlIllllIlIlIl;
                llllllllllllllllIllIlIllllIlIlIl.token.addTypeArgument('*');
            }

            @Override
            public void visitClassType(String llllllllllllllllIllIlIllllIlIlll) {
                TypeArgElement llllllllllllllllIllIlIllllIllIII;
                llllllllllllllllIllIlIllllIllIII.token = llllllllllllllllIllIlIllllIllIII.type.addTypeArgument(llllllllllllllllIllIlIllllIlIlll).setWildcard(llllllllllllllllIllIlIllllIllIII.wildcard).asToken();
            }

            @Override
            public SignatureVisitor visitArrayType() {
                TypeArgElement llllllllllllllllIllIlIlllllIllII;
                llllllllllllllllIllIlIlllllIllII.type.setArray();
                return llllllllllllllllIllIlIlllllIllII;
            }

            @Override
            public void visitTypeVariable(String llllllllllllllllIllIlIlllllIIIIl) {
                TypeArgElement llllllllllllllllIllIlIllllIlllll;
                TokenHandle llllllllllllllllIllIlIlllllIIIII = llllllllllllllllIllIlIllllIlllll.ClassSignature.this.getType(llllllllllllllllIllIlIlllllIIIIl);
                llllllllllllllllIllIlIllllIlllll.token = llllllllllllllllIllIlIllllIlllll.type.addTypeArgument(llllllllllllllllIllIlIlllllIIIII).setWildcard(llllllllllllllllIllIlIllllIlllll.wildcard).asToken();
            }

            @Override
            public void visitEnd() {
            }

            @Override
            public SignatureVisitor visitTypeArgument(char llllllllllllllllIllIlIllllIIlllI) {
                TypeArgElement llllllllllllllllIllIlIllllIIllll;
                return new TypeArgElement(llllllllllllllllIllIlIllllIIllll, llllllllllllllllIllIlIllllIIlllI);
            }
        }

        class FormalParamElement
        extends TokenElement {
            private final /* synthetic */ TokenHandle handle;

            FormalParamElement(String llllllllllllllllIlllIIlllllIIlIl) {
                FormalParamElement llllllllllllllllIlllIIlllllIIlll;
                llllllllllllllllIlllIIlllllIIlll.handle = llllllllllllllllIlllIIlllllIIlll.ClassSignature.this.getType(llllllllllllllllIlllIIlllllIIlIl);
                llllllllllllllllIlllIIlllllIIlll.token = llllllllllllllllIlllIIlllllIIlll.handle.asToken();
            }
        }

        class InterfaceElement
        extends TokenElement {
            @Override
            public void visitEnd() {
                InterfaceElement llllllllllllllllllIIlIIIIIIlIlll;
                llllllllllllllllllIIlIIIIIIlIlll.ClassSignature.this.addInterface(llllllllllllllllllIIlIIIIIIlIlll.token);
            }

            InterfaceElement() {
                InterfaceElement llllllllllllllllllIIlIIIIIIllIlI;
            }
        }

        abstract class SignatureElement
        extends SignatureVisitor {
            public SignatureElement() {
                SignatureElement llllllllllllllllIIIIIlIIIIllIIII;
                super(327680);
            }
        }
    }

    class TokenHandle
    implements IToken {
        /* synthetic */ char wildcard;
        final /* synthetic */ Token token;
        /* synthetic */ boolean array;

        @Override
        public IToken setArray(boolean lllllllllllllllllIIlIllllIIlIIII) {
            TokenHandle lllllllllllllllllIIlIllllIIlIIll;
            lllllllllllllllllIIlIllllIIlIIll.array |= lllllllllllllllllIIlIllllIIlIIII;
            return lllllllllllllllllIIlIllllIIlIIll;
        }

        TokenHandle(Token lllllllllllllllllIIlIllllIIllllI) {
            TokenHandle lllllllllllllllllIIlIllllIlIIIII;
            lllllllllllllllllIIlIllllIlIIIII.token = lllllllllllllllllIIlIllllIIllllI;
        }

        TokenHandle() {
            lllllllllllllllllIIlIllllIlIllII(new Token());
            TokenHandle lllllllllllllllllIIlIllllIlIllII;
        }

        @Override
        public IToken setWildcard(char lllllllllllllllllIIlIlllIllllIIl) {
            TokenHandle lllllllllllllllllIIlIlllIllllIlI;
            if ("+-".indexOf(lllllllllllllllllIIlIlllIllllIIl) > -1) {
                lllllllllllllllllIIlIlllIllllIlI.wildcard = lllllllllllllllllIIlIlllIllllIIl;
            }
            return lllllllllllllllllIIlIlllIllllIlI;
        }

        @Override
        public String asType() {
            TokenHandle lllllllllllllllllIIlIlllIllIIIlI;
            StringBuilder lllllllllllllllllIIlIlllIllIIIll = new StringBuilder();
            if (lllllllllllllllllIIlIlllIllIIIlI.wildcard > '\u0000') {
                lllllllllllllllllIIlIlllIllIIIll.append(lllllllllllllllllIIlIlllIllIIIlI.wildcard);
            }
            if (lllllllllllllllllIIlIlllIllIIIlI.array) {
                lllllllllllllllllIIlIlllIllIIIll.append('[');
            }
            return String.valueOf(lllllllllllllllllIIlIlllIllIIIll.append(lllllllllllllllllIIlIlllIllIIIlI.ClassSignature.this.getTypeVar(lllllllllllllllllIIlIlllIllIIIlI)));
        }

        @Override
        public String asBound() {
            TokenHandle lllllllllllllllllIIlIlllIlllIIll;
            return lllllllllllllllllIIlIlllIlllIIll.token.asBound();
        }

        public String toString() {
            TokenHandle lllllllllllllllllIIlIlllIlIllIII;
            return lllllllllllllllllIIlIlllIlIllIII.token.toString();
        }

        @Override
        public Token asToken() {
            TokenHandle lllllllllllllllllIIlIlllIlIlllIl;
            return lllllllllllllllllIIlIlllIlIlllIl.token;
        }

        public TokenHandle clone() {
            TokenHandle lllllllllllllllllIIlIlllIlIIllll;
            return new TokenHandle(lllllllllllllllllIIlIlllIlIIllll.token);
        }
    }

    static interface IToken {
        public static final /* synthetic */ String WILDCARDS;

        static {
            WILDCARDS = "+-";
        }

        public IToken setArray(boolean var1);

        public String asBound();

        public Token asToken();

        public String asType();

        public IToken setWildcard(char var1);
    }

    class SignatureRemapper
    extends SignatureWriter {
        private final /* synthetic */ Set<String> localTypeVars;

        @Override
        public void visitTypeVariable(String llIIllIIlllllII) {
            TypeVar llIIllIlIIIIIII;
            SignatureRemapper llIIllIIlllllll;
            if (!llIIllIIlllllll.localTypeVars.contains(llIIllIIlllllII) && (llIIllIlIIIIIII = llIIllIIlllllll.ClassSignature.this.getTypeVar(llIIllIIlllllII)) != null) {
                super.visitTypeVariable(llIIllIlIIIIIII.toString());
                return;
            }
            super.visitTypeVariable(llIIllIIlllllII);
        }

        SignatureRemapper() {
            SignatureRemapper llIIllIlIIllIlI;
            llIIllIlIIllIlI.localTypeVars = new HashSet<String>();
        }

        @Override
        public void visitFormalTypeParameter(String llIIllIlIIlIIIl) {
            SignatureRemapper llIIllIlIIlIIlI;
            llIIllIlIIlIIlI.localTypeVars.add(llIIllIlIIlIIIl);
            super.visitFormalTypeParameter(llIIllIlIIlIIIl);
        }
    }

    static class Token
    implements IToken {
        private /* synthetic */ String type;
        private /* synthetic */ Token tail;
        private /* synthetic */ List<Token> ifaceBound;
        static final /* synthetic */ String SYMBOLS;
        private final /* synthetic */ boolean inner;
        private /* synthetic */ List<Token> classBound;
        private /* synthetic */ List<IToken> signature;
        private /* synthetic */ boolean array;
        private /* synthetic */ List<IToken> suffix;
        private /* synthetic */ char symbol;

        IToken addTypeArgument(String lllllllllllllllllIlIIIllIIIIlIIl) {
            Token lllllllllllllllllIlIIIllIIIIlIlI;
            if (lllllllllllllllllIlIIIllIIIIlIlI.tail != null) {
                return lllllllllllllllllIlIIIllIIIIlIlI.tail.addTypeArgument(lllllllllllllllllIlIIIllIIIIlIIl);
            }
            Token lllllllllllllllllIlIIIllIIIIlIII = new Token(lllllllllllllllllIlIIIllIIIIlIIl);
            lllllllllllllllllIlIIIllIIIIlIlI.getSignature().add(lllllllllllllllllIlIIIllIIIIlIII);
            return lllllllllllllllllIlIIIllIIIIlIII;
        }

        Token() {
            lllllllllllllllllIlIIIllIlllIIII(false);
            Token lllllllllllllllllIlIIIllIlllIIII;
        }

        @Override
        public String asType() {
            Token lllllllllllllllllIlIIIlIllIIIIll;
            return lllllllllllllllllIlIIIlIllIIIIll.asType(false);
        }

        Token setSymbol(char lllllllllllllllllIlIIIllIlIIllll) {
            Token lllllllllllllllllIlIIIllIlIlIIII;
            if (lllllllllllllllllIlIIIllIlIlIIII.symbol == '\u0000' && "+-*".indexOf(lllllllllllllllllIlIIIllIlIIllll) > -1) {
                lllllllllllllllllIlIIIllIlIlIIII.symbol = lllllllllllllllllIlIIIllIlIIllll;
            }
            return lllllllllllllllllIlIIIllIlIlIIII;
        }

        Token(String lllllllllllllllllIlIIIllIlIllIIl, boolean lllllllllllllllllIlIIIllIlIllIII) {
            Token lllllllllllllllllIlIIIllIlIllIlI;
            lllllllllllllllllIlIIIllIlIllIlI.symbol = '\u0000';
            lllllllllllllllllIlIIIllIlIllIlI.inner = lllllllllllllllllIlIIIllIlIllIII;
            lllllllllllllllllIlIIIllIlIllIlI.type = lllllllllllllllllIlIIIllIlIllIIl;
        }

        Token(String lllllllllllllllllIlIIIllIllIllII) {
            lllllllllllllllllIlIIIllIllIlIll(lllllllllllllllllIlIIIllIllIllII, false);
            Token lllllllllllllllllIlIIIllIllIlIll;
        }

        @Override
        public IToken setArray(boolean lllllllllllllllllIlIIIllIIllIlll) {
            Token lllllllllllllllllIlIIIllIIlllIII;
            lllllllllllllllllIlIIIllIIlllIII.array |= lllllllllllllllllIlIIIllIIllIlll;
            return lllllllllllllllllIlIIIllIIlllIII;
        }

        private List<IToken> getSignature() {
            Token lllllllllllllllllIlIIIllIIIllIlI;
            if (lllllllllllllllllIlIIIllIIIllIlI.signature == null) {
                lllllllllllllllllIlIIIllIIIllIlI.signature = new ArrayList<IToken>();
            }
            return lllllllllllllllllIlIIIllIIIllIlI.signature;
        }

        boolean isRaw() {
            Token lllllllllllllllllIlIIIlIlIllIIlI;
            return lllllllllllllllllIlIIIlIlIllIIlI.signature == null;
        }

        public String asType(boolean lllllllllllllllllIlIIIlIlIllIlll) {
            Token lllllllllllllllllIlIIIlIlIlllIII;
            StringBuilder lllllllllllllllllIlIIIlIlIlllIIl = new StringBuilder();
            if (lllllllllllllllllIlIIIlIlIlllIII.array) {
                lllllllllllllllllIlIIIlIlIlllIIl.append('[');
            }
            if (lllllllllllllllllIlIIIlIlIlllIII.symbol != '\u0000') {
                lllllllllllllllllIlIIIlIlIlllIIl.append(lllllllllllllllllIlIIIlIlIlllIII.symbol);
            }
            if (lllllllllllllllllIlIIIlIlIlllIII.type == null) {
                return String.valueOf(lllllllllllllllllIlIIIlIlIlllIIl);
            }
            if (!lllllllllllllllllIlIIIlIlIlllIII.inner) {
                lllllllllllllllllIlIIIlIlIlllIIl.append('L');
            }
            lllllllllllllllllIlIIIlIlIlllIIl.append(lllllllllllllllllIlIIIlIlIlllIII.type);
            if (!lllllllllllllllllIlIIIlIlIllIlll) {
                if (lllllllllllllllllIlIIIlIlIlllIII.signature != null) {
                    lllllllllllllllllIlIIIlIlIlllIIl.append('<');
                    for (IToken lllllllllllllllllIlIIIlIlIllllIl : lllllllllllllllllIlIIIlIlIlllIII.signature) {
                        lllllllllllllllllIlIIIlIlIlllIIl.append(lllllllllllllllllIlIIIlIlIllllIl.asType());
                    }
                    lllllllllllllllllIlIIIlIlIlllIIl.append('>');
                }
                if (lllllllllllllllllIlIIIlIlIlllIII.suffix != null) {
                    for (IToken lllllllllllllllllIlIIIlIlIllllII : lllllllllllllllllIlIIIlIlIlllIII.suffix) {
                        lllllllllllllllllIlIIIlIlIlllIIl.append('.').append(lllllllllllllllllIlIIIlIlIllllII.asType());
                    }
                }
            }
            if (!lllllllllllllllllIlIIIlIlIlllIII.inner) {
                lllllllllllllllllIlIIIlIlIlllIIl.append(';');
            }
            return String.valueOf(lllllllllllllllllIlIIIlIlIlllIIl);
        }

        Token setType(String lllllllllllllllllIlIIIllIlIIlIll) {
            Token lllllllllllllllllIlIIIllIlIIlIlI;
            if (lllllllllllllllllIlIIIllIlIIlIlI.type == null) {
                lllllllllllllllllIlIIIllIlIIlIlI.type = lllllllllllllllllIlIIIllIlIIlIll;
            }
            return lllllllllllllllllIlIIIllIlIIlIlI;
        }

        Token(boolean lllllllllllllllllIlIIIllIlIllllI) {
            lllllllllllllllllIlIIIllIlIlllll(null, lllllllllllllllllIlIIIllIlIllllI);
            Token lllllllllllllllllIlIIIllIlIlllll;
        }

        IToken addTypeArgument(Token lllllllllllllllllIlIIIlIllllllll) {
            Token lllllllllllllllllIlIIIllIIIIIIlI;
            if (lllllllllllllllllIlIIIllIIIIIIlI.tail != null) {
                return lllllllllllllllllIlIIIllIIIIIIlI.tail.addTypeArgument(lllllllllllllllllIlIIIlIllllllll);
            }
            lllllllllllllllllIlIIIllIIIIIIlI.getSignature().add(lllllllllllllllllIlIIIlIllllllll);
            return lllllllllllllllllIlIIIlIllllllll;
        }

        private List<Token> getClassBound() {
            Token lllllllllllllllllIlIIIllIIlIIIlI;
            if (lllllllllllllllllIlIIIllIIlIIIlI.classBound == null) {
                lllllllllllllllllIlIIIllIIlIIIlI.classBound = new ArrayList<Token>();
            }
            return lllllllllllllllllIlIIIllIIlIIIlI.classBound;
        }

        private List<Token> getIfaceBound() {
            Token lllllllllllllllllIlIIIllIIIllllI;
            if (lllllllllllllllllIlIIIllIIIllllI.ifaceBound == null) {
                lllllllllllllllllIlIIIllIIIllllI.ifaceBound = new ArrayList<Token>();
            }
            return lllllllllllllllllIlIIIllIIIllllI.ifaceBound;
        }

        boolean hasInterfaceBound() {
            Token lllllllllllllllllIlIIIllIlIIIIIl;
            return lllllllllllllllllIlIIIllIlIIIIIl.ifaceBound != null;
        }

        static {
            SYMBOLS = "+-*";
        }

        String getClassType() {
            Token lllllllllllllllllIlIIIlIlIlIllll;
            return lllllllllllllllllIlIIIlIlIlIllll.type != null ? lllllllllllllllllIlIIIlIlIlIllll.type : "java/lang/Object";
        }

        Token addInterfaceBound(String lllllllllllllllllIlIIIlIllIlllII) {
            Token lllllllllllllllllIlIIIlIlllIIIII;
            Token lllllllllllllllllIlIIIlIllIllllI = new Token(lllllllllllllllllIlIIIlIllIlllII);
            lllllllllllllllllIlIIIlIlllIIIII.getIfaceBound().add(lllllllllllllllllIlIIIlIllIllllI);
            return lllllllllllllllllIlIIIlIllIllllI;
        }

        boolean hasClassBound() {
            Token lllllllllllllllllIlIIIllIlIIIlll;
            return lllllllllllllllllIlIIIllIlIIIlll.classBound != null;
        }

        public String toString() {
            Token lllllllllllllllllIlIIIlIllIlIIlI;
            return lllllllllllllllllIlIIIlIllIlIIlI.asType();
        }

        private List<IToken> getSuffix() {
            Token lllllllllllllllllIlIIIllIIIlIlll;
            if (lllllllllllllllllIlIIIllIIIlIlll.suffix == null) {
                lllllllllllllllllIlIIIllIIIlIlll.suffix = new ArrayList<IToken>();
            }
            return lllllllllllllllllIlIIIllIIIlIlll.suffix;
        }

        IToken addTypeArgument(char lllllllllllllllllIlIIIllIIIIllll) {
            Token lllllllllllllllllIlIIIllIIIlIIll;
            if (lllllllllllllllllIlIIIllIIIlIIll.tail != null) {
                return lllllllllllllllllIlIIIllIIIlIIll.tail.addTypeArgument(lllllllllllllllllIlIIIllIIIIllll);
            }
            Token lllllllllllllllllIlIIIllIIIlIIIl = new Token(lllllllllllllllllIlIIIllIIIIllll);
            lllllllllllllllllIlIIIllIIIlIIll.getSignature().add(lllllllllllllllllIlIIIllIIIlIIIl);
            return lllllllllllllllllIlIIIllIIIlIIIl;
        }

        IToken addTypeArgument(TokenHandle lllllllllllllllllIlIIIlIllllIlll) {
            Token lllllllllllllllllIlIIIlIlllllIII;
            if (lllllllllllllllllIlIIIlIlllllIII.tail != null) {
                return lllllllllllllllllIlIIIlIlllllIII.tail.addTypeArgument(lllllllllllllllllIlIIIlIllllIlll);
            }
            Object lllllllllllllllllIlIIIlIlllllIIl = lllllllllllllllllIlIIIlIllllIlll.clone();
            lllllllllllllllllIlIIIlIlllllIII.getSignature().add((IToken)lllllllllllllllllIlIIIlIlllllIIl);
            return lllllllllllllllllIlIIIlIlllllIIl;
        }

        Token addInnerClass(String lllllllllllllllllIlIIIlIllIlIlll) {
            Token lllllllllllllllllIlIIIlIllIlIllI;
            lllllllllllllllllIlIIIlIllIlIllI.tail = new Token(lllllllllllllllllIlIIIlIllIlIlll, true);
            lllllllllllllllllIlIIIlIllIlIllI.getSuffix().add(lllllllllllllllllIlIIIlIllIlIllI.tail);
            return lllllllllllllllllIlIIIlIllIlIllI.tail;
        }

        @Override
        public IToken setWildcard(char lllllllllllllllllIlIIIllIIlIlllI) {
            Token lllllllllllllllllIlIIIllIIlIllIl;
            if ("+-".indexOf(lllllllllllllllllIlIIIllIIlIlllI) == -1) {
                return lllllllllllllllllIlIIIllIIlIllIl;
            }
            return lllllllllllllllllIlIIIllIIlIllIl.setSymbol(lllllllllllllllllIlIIIllIIlIlllI);
        }

        Token addClassBound(String lllllllllllllllllIlIIIlIlllIlIII) {
            Token lllllllllllllllllIlIIIlIlllIIllI;
            Token lllllllllllllllllIlIIIlIlllIIlll = new Token(lllllllllllllllllIlIIIlIlllIlIII);
            lllllllllllllllllIlIIIlIlllIIllI.getClassBound().add(lllllllllllllllllIlIIIlIlllIIlll);
            return lllllllllllllllllIlIIIlIlllIIlll;
        }

        Token addBound(String lllllllllllllllllIlIIIlIllllIIIl, boolean lllllllllllllllllIlIIIlIllllIIII) {
            Token lllllllllllllllllIlIIIlIlllIllll;
            if (lllllllllllllllllIlIIIlIllllIIII) {
                return lllllllllllllllllIlIIIlIlllIllll.addClassBound(lllllllllllllllllIlIIIlIllllIIIl);
            }
            return lllllllllllllllllIlIIIlIlllIllll.addInterfaceBound(lllllllllllllllllIlIIIlIllllIIIl);
        }

        Token(char lllllllllllllllllIlIIIllIllIIlII) {
            lllllllllllllllllIlIIIllIllIIlll();
            Token lllllllllllllllllIlIIIllIllIIlll;
            lllllllllllllllllIlIIIllIllIIlll.symbol = lllllllllllllllllIlIIIllIllIIlII;
        }

        @Override
        public Token asToken() {
            Token lllllllllllllllllIlIIIlIlIlIllII;
            return lllllllllllllllllIlIIIlIlIlIllII;
        }

        @Override
        public String asBound() {
            Token lllllllllllllllllIlIIIlIllIIlIll;
            StringBuilder lllllllllllllllllIlIIIlIllIIlIlI = new StringBuilder();
            if (lllllllllllllllllIlIIIlIllIIlIll.type != null) {
                lllllllllllllllllIlIIIlIllIIlIlI.append(lllllllllllllllllIlIIIlIllIIlIll.type);
            }
            if (lllllllllllllllllIlIIIlIllIIlIll.classBound != null) {
                for (Token lllllllllllllllllIlIIIlIllIIllIl : lllllllllllllllllIlIIIlIllIIlIll.classBound) {
                    lllllllllllllllllIlIIIlIllIIlIlI.append(lllllllllllllllllIlIIIlIllIIllIl.asType());
                }
            }
            if (lllllllllllllllllIlIIIlIllIIlIll.ifaceBound != null) {
                for (Token lllllllllllllllllIlIIIlIllIIllII : lllllllllllllllllIlIIIlIllIIlIll.ifaceBound) {
                    lllllllllllllllllIlIIIlIllIIlIlI.append(':').append(lllllllllllllllllIlIIIlIllIIllII.asType());
                }
            }
            return String.valueOf(lllllllllllllllllIlIIIlIllIIlIlI);
        }
    }

    static class Lazy
    extends ClassSignature {
        private /* synthetic */ ClassSignature generated;
        private final /* synthetic */ String sig;

        Lazy(String lIIIlIIIlIIIIll) {
            Lazy lIIIlIIIlIIIIlI;
            lIIIlIIIlIIIIlI.sig = lIIIlIIIlIIIIll;
        }

        @Override
        public ClassSignature wake() {
            Lazy lIIIlIIIIllllll;
            if (lIIIlIIIIllllll.generated == null) {
                lIIIlIIIIllllll.generated = ClassSignature.of(lIIIlIIIIllllll.sig);
            }
            return lIIIlIIIIllllll.generated;
        }
    }
}

