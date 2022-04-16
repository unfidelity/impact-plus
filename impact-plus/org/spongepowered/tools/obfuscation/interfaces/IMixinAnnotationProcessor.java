/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.interfaces;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import org.spongepowered.asm.util.ITokenProvider;
import org.spongepowered.tools.obfuscation.interfaces.IJavadocProvider;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationManager;
import org.spongepowered.tools.obfuscation.interfaces.IOptionProvider;
import org.spongepowered.tools.obfuscation.interfaces.ITypeHandleProvider;

public interface IMixinAnnotationProcessor
extends IOptionProvider,
Messager {
    public IJavadocProvider getJavadocProvider();

    public ITypeHandleProvider getTypeProvider();

    public IObfuscationManager getObfuscationManager();

    public ITokenProvider getTokenProvider();

    public ProcessingEnvironment getProcessingEnvironment();

    public CompilerEnvironment getCompilerEnvironment();

    public static enum CompilerEnvironment {
        JAVAC,
        JDT;


        private CompilerEnvironment() {
            CompilerEnvironment llllllllllllllllIlIlIIIIIIlIIIII;
        }
    }
}

