/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.lib.tree.analysis.Value;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public abstract class Interpreter<V extends Value> {
    protected final /* synthetic */ int api;

    public abstract V merge(V var1, V var2);

    public abstract V copyOperation(AbstractInsnNode var1, V var2) throws AnalyzerException;

    public abstract V newOperation(AbstractInsnNode var1) throws AnalyzerException;

    public abstract V ternaryOperation(AbstractInsnNode var1, V var2, V var3, V var4) throws AnalyzerException;

    public abstract V unaryOperation(AbstractInsnNode var1, V var2) throws AnalyzerException;

    public abstract V naryOperation(AbstractInsnNode var1, List<? extends V> var2) throws AnalyzerException;

    public abstract V binaryOperation(AbstractInsnNode var1, V var2, V var3) throws AnalyzerException;

    protected Interpreter(int llllIIIII) {
        Interpreter llllIIIlI;
        llllIIIlI.api = llllIIIII;
    }

    public abstract V newValue(Type var1);

    public abstract void returnOperation(AbstractInsnNode var1, V var2, V var3) throws AnalyzerException;
}

