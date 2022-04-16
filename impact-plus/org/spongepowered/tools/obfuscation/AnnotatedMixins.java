/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 */
package org.spongepowered.tools.obfuscation;

import com.google.common.collect.ImmutableList;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.util.ITokenProvider;
import org.spongepowered.tools.obfuscation.AnnotatedMixin;
import org.spongepowered.tools.obfuscation.ObfuscationManager;
import org.spongepowered.tools.obfuscation.TargetMap;
import org.spongepowered.tools.obfuscation.interfaces.IJavadocProvider;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IMixinValidator;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationManager;
import org.spongepowered.tools.obfuscation.interfaces.ITypeHandleProvider;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandleSimulated;
import org.spongepowered.tools.obfuscation.mirror.TypeReference;
import org.spongepowered.tools.obfuscation.struct.InjectorRemap;
import org.spongepowered.tools.obfuscation.validation.ParentValidator;
import org.spongepowered.tools.obfuscation.validation.TargetValidator;

final class AnnotatedMixins
implements ITokenProvider,
ITypeHandleProvider,
IJavadocProvider,
IMixinAnnotationProcessor {
    private final /* synthetic */ List<AnnotatedMixin> mixinsForPass;
    private final /* synthetic */ TargetMap targets;
    private final /* synthetic */ List<IMixinValidator> validators;
    private final /* synthetic */ ProcessingEnvironment processingEnv;
    private final /* synthetic */ Map<String, Integer> tokenCache;
    private static final /* synthetic */ String MAPID_SYSTEM_PROPERTY;
    private static /* synthetic */ Map<ProcessingEnvironment, AnnotatedMixins> instances;
    private final /* synthetic */ Map<String, AnnotatedMixin> mixins;
    private final /* synthetic */ IMixinAnnotationProcessor.CompilerEnvironment env;
    private final /* synthetic */ IObfuscationManager obf;
    private /* synthetic */ Properties properties;

    static {
        MAPID_SYSTEM_PROPERTY = "mixin.target.mapid";
        instances = new HashMap<ProcessingEnvironment, AnnotatedMixins>();
    }

    private void initTokenCache(String lllllllllllllllllllIllIIIIIIIIll) {
        if (lllllllllllllllllllIllIIIIIIIIll != null) {
            String[] lllllllllllllllllllIllIIIIIIIlIl;
            Pattern lllllllllllllllllllIllIIIIIIIllI = Pattern.compile("^([A-Z0-9\\-_\\.]+)=([0-9]+)$");
            for (String lllllllllllllllllllIllIIIIIIIlll : lllllllllllllllllllIllIIIIIIIlIl = lllllllllllllllllllIllIIIIIIIIll.replaceAll("\\s", "").toUpperCase().split("[;,]")) {
                AnnotatedMixins lllllllllllllllllllIllIIIIIIIIlI;
                Matcher lllllllllllllllllllIllIIIIIIlIII = lllllllllllllllllllIllIIIIIIIllI.matcher(lllllllllllllllllllIllIIIIIIIlll);
                if (!lllllllllllllllllllIllIIIIIIlIII.matches()) continue;
                lllllllllllllllllllIllIIIIIIIIlI.tokenCache.put(lllllllllllllllllllIllIIIIIIlIII.group(1), Integer.parseInt(lllllllllllllllllllIllIIIIIIlIII.group(2)));
            }
        }
    }

    public Properties getProperties() {
        AnnotatedMixins lllllllllllllllllllIlIllllIIlIII;
        if (lllllllllllllllllllIlIllllIIlIII.properties == null) {
            lllllllllllllllllllIlIllllIIlIII.properties = new Properties();
            try {
                Filer lllllllllllllllllllIlIllllIIlIll = lllllllllllllllllllIlIllllIIlIII.processingEnv.getFiler();
                FileObject lllllllllllllllllllIlIllllIIlIlI = lllllllllllllllllllIlIllllIIlIll.getResource(StandardLocation.SOURCE_PATH, "", "mixin.properties");
                if (lllllllllllllllllllIlIllllIIlIlI != null) {
                    InputStream lllllllllllllllllllIlIllllIIllII = lllllllllllllllllllIlIllllIIlIlI.openInputStream();
                    lllllllllllllllllllIlIllllIIlIII.properties.load(lllllllllllllllllllIlIllllIIllII);
                    lllllllllllllllllllIlIllllIIllII.close();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return lllllllllllllllllllIlIllllIIlIII.properties;
    }

    @Override
    public ProcessingEnvironment getProcessingEnvironment() {
        AnnotatedMixins lllllllllllllllllllIlIlllllIllII;
        return lllllllllllllllllllIlIlllllIllII.processingEnv;
    }

    @Override
    public String getJavadoc(Element lllllllllllllllllllIlIlIlIIIllll) {
        AnnotatedMixins lllllllllllllllllllIlIlIlIIIllIl;
        Elements lllllllllllllllllllIlIlIlIIIlllI = lllllllllllllllllllIlIlIlIIIllIl.processingEnv.getElementUtils();
        return lllllllllllllllllllIlIlIlIIIlllI.getDocComment(lllllllllllllllllllIlIlIlIIIllll);
    }

    @Override
    public String getOption(String lllllllllllllllllllIlIllllIlIlIl) {
        AnnotatedMixins lllllllllllllllllllIlIllllIlIIll;
        if (lllllllllllllllllllIlIllllIlIlIl == null) {
            return null;
        }
        String lllllllllllllllllllIlIllllIlIlII = lllllllllllllllllllIlIllllIlIIll.processingEnv.getOptions().get(lllllllllllllllllllIlIllllIlIlIl);
        if (lllllllllllllllllllIlIllllIlIlII != null) {
            return lllllllllllllllllllIlIllllIlIlII;
        }
        return lllllllllllllllllllIlIllllIlIIll.getProperties().getProperty(lllllllllllllllllllIlIllllIlIlIl);
    }

    @Override
    public IObfuscationManager getObfuscationManager() {
        AnnotatedMixins lllllllllllllllllllIlIllllllIIIl;
        return lllllllllllllllllllIlIllllllIIIl.obf;
    }

    @Override
    public ITypeHandleProvider getTypeProvider() {
        AnnotatedMixins lllllllllllllllllllIlIlllllllIII;
        return lllllllllllllllllllIlIlllllllIII;
    }

    public void writeMappings() {
        AnnotatedMixins lllllllllllllllllllIlIlllIllllll;
        lllllllllllllllllllIlIlllIllllll.obf.writeMappings();
    }

    public void registerSoftImplements(TypeElement lllllllllllllllllllIlIllIIlIIIlI, AnnotationHandle lllllllllllllllllllIlIllIIlIIIIl) {
        AnnotatedMixins lllllllllllllllllllIlIllIIlIIlll;
        AnnotatedMixin lllllllllllllllllllIlIllIIlIIlII = lllllllllllllllllllIlIllIIlIIlll.getMixin(lllllllllllllllllllIlIllIIlIIIlI);
        if (lllllllllllllllllllIlIllIIlIIlII == null) {
            lllllllllllllllllllIlIllIIlIIlll.printMessage(Diagnostic.Kind.ERROR, "Found @Implements annotation on a non-mixin class");
            return;
        }
        lllllllllllllllllllIlIllIIlIIlII.registerSoftImplements(lllllllllllllllllllIlIllIIlIIIIl);
    }

    public AnnotatedMixin getMixin(TypeElement lllllllllllllllllllIlIlllIlIlIII) {
        AnnotatedMixins lllllllllllllllllllIlIlllIlIIlll;
        return lllllllllllllllllllIlIlllIlIIlll.getMixin(lllllllllllllllllllIlIlllIlIlIII.getQualifiedName().toString());
    }

    public AnnotatedMixin getMixin(String lllllllllllllllllllIlIlllIlIIIlI) {
        AnnotatedMixins lllllllllllllllllllIlIlllIlIIIll;
        return lllllllllllllllllllIlIlllIlIIIll.mixins.get(lllllllllllllllllllIlIlllIlIIIlI);
    }

    private IMixinAnnotationProcessor.CompilerEnvironment detectEnvironment(ProcessingEnvironment lllllllllllllllllllIlIllllIIIIlI) {
        if (lllllllllllllllllllIlIllllIIIIlI.getClass().getName().contains("jdt")) {
            return IMixinAnnotationProcessor.CompilerEnvironment.JDT;
        }
        return IMixinAnnotationProcessor.CompilerEnvironment.JAVAC;
    }

    public Collection<TypeMirror> getMixinsTargeting(TypeElement lllllllllllllllllllIlIlllIIlIIII) {
        AnnotatedMixins lllllllllllllllllllIlIlllIIlIIIl;
        ArrayList<TypeMirror> lllllllllllllllllllIlIlllIIIllll = new ArrayList<TypeMirror>();
        for (TypeReference lllllllllllllllllllIlIlllIIlIIlI : lllllllllllllllllllIlIlllIIlIIIl.targets.getMixinsTargeting(lllllllllllllllllllIlIlllIIlIIII)) {
            TypeHandle lllllllllllllllllllIlIlllIIlIIll = lllllllllllllllllllIlIlllIIlIIlI.getHandle(lllllllllllllllllllIlIlllIIlIIIl.processingEnv);
            if (lllllllllllllllllllIlIlllIIlIIll == null) continue;
            lllllllllllllllllllIlIlllIIIllll.add(lllllllllllllllllllIlIlllIIlIIll.getType());
        }
        return lllllllllllllllllllIlIlllIIIllll;
    }

    public void registerAccessor(TypeElement lllllllllllllllllllIlIllIlllllIl, ExecutableElement lllllllllllllllllllIlIllIlllllII) {
        AnnotatedMixins lllllllllllllllllllIlIllIllllllI;
        AnnotatedMixin lllllllllllllllllllIlIlllIIIIIII = lllllllllllllllllllIlIllIllllllI.getMixin(lllllllllllllllllllIlIllIlllllIl);
        if (lllllllllllllllllllIlIlllIIIIIII == null) {
            lllllllllllllllllllIlIllIllllllI.printMessage(Diagnostic.Kind.ERROR, "Found @Accessor annotation on a non-mixin method", lllllllllllllllllllIlIllIlllllII);
            return;
        }
        AnnotationHandle lllllllllllllllllllIlIllIlllllll = AnnotationHandle.of(lllllllllllllllllllIlIllIlllllII, Accessor.class);
        lllllllllllllllllllIlIlllIIIIIII.registerAccessor(lllllllllllllllllllIlIllIlllllII, lllllllllllllllllllIlIllIlllllll, lllllllllllllllllllIlIllIllllllI.shouldRemap(lllllllllllllllllllIlIlllIIIIIII, lllllllllllllllllllIlIllIlllllll));
    }

    @Override
    public Integer getToken(String lllllllllllllllllllIlIllllIlllIl) {
        AnnotatedMixins lllllllllllllllllllIlIllllIllllI;
        if (lllllllllllllllllllIlIllllIllllI.tokenCache.containsKey(lllllllllllllllllllIlIllllIlllIl)) {
            return lllllllllllllllllllIlIllllIllllI.tokenCache.get(lllllllllllllllllllIlIllllIlllIl);
        }
        String lllllllllllllllllllIlIlllllIIIII = lllllllllllllllllllIlIllllIllllI.getOption(lllllllllllllllllllIlIllllIlllIl);
        Integer lllllllllllllllllllIlIllllIlllll = null;
        try {
            lllllllllllllllllllIlIllllIlllll = Integer.parseInt(lllllllllllllllllllIlIlllllIIIII);
        }
        catch (Exception lllllllllllllllllllIlIllllIllIlI) {
            // empty catch block
        }
        lllllllllllllllllllIlIllllIllllI.tokenCache.put(lllllllllllllllllllIlIllllIlllIl, lllllllllllllllllllIlIllllIlllll);
        return lllllllllllllllllllIlIllllIlllll;
    }

    private boolean shouldRemap(AnnotatedMixin lllllllllllllllllllIlIllIIIIlllI, AnnotationHandle lllllllllllllllllllIlIllIIIIllIl) {
        return lllllllllllllllllllIlIllIIIIllIl.getBoolean("remap", lllllllllllllllllllIlIllIIIIlllI.remap());
    }

    @Override
    public IJavadocProvider getJavadocProvider() {
        AnnotatedMixins lllllllllllllllllllIlIlllllIlllI;
        return lllllllllllllllllllIlIlllllIlllI;
    }

    @Override
    public ITokenProvider getTokenProvider() {
        AnnotatedMixins lllllllllllllllllllIlIllllllIlIl;
        return lllllllllllllllllllIlIllllllIlIl;
    }

    public void registerOverwrite(TypeElement lllllllllllllllllllIlIllIlIlllll, ExecutableElement lllllllllllllllllllIlIllIlIllllI) {
        AnnotatedMixins lllllllllllllllllllIlIllIllIIlIl;
        AnnotatedMixin lllllllllllllllllllIlIllIllIIIlI = lllllllllllllllllllIlIllIllIIlIl.getMixin(lllllllllllllllllllIlIllIlIlllll);
        if (lllllllllllllllllllIlIllIllIIIlI == null) {
            lllllllllllllllllllIlIllIllIIlIl.printMessage(Diagnostic.Kind.ERROR, "Found @Overwrite annotation on a non-mixin method", lllllllllllllllllllIlIllIlIllllI);
            return;
        }
        AnnotationHandle lllllllllllllllllllIlIllIllIIIIl = AnnotationHandle.of(lllllllllllllllllllIlIllIlIllllI, Overwrite.class);
        lllllllllllllllllllIlIllIllIIIlI.registerOverwrite(lllllllllllllllllllIlIllIlIllllI, lllllllllllllllllllIlIllIllIIIIl, lllllllllllllllllllIlIllIllIIlIl.shouldRemap(lllllllllllllllllllIlIllIllIIIlI, lllllllllllllllllllIlIllIllIIIIl));
    }

    protected TargetMap initTargetMap() {
        AnnotatedMixins lllllllllllllllllllIllIIIIIllIII;
        TargetMap lllllllllllllllllllIllIIIIIlIlll = TargetMap.create(System.getProperty("mixin.target.mapid"));
        System.setProperty("mixin.target.mapid", lllllllllllllllllllIllIIIIIlIlll.getSessionId());
        String lllllllllllllllllllIllIIIIIlIllI = lllllllllllllllllllIllIIIIIllIII.getOption("dependencyTargetsFile");
        if (lllllllllllllllllllIllIIIIIlIllI != null) {
            try {
                lllllllllllllllllllIllIIIIIlIlll.readImports(new File(lllllllllllllllllllIllIIIIIlIllI));
            }
            catch (IOException lllllllllllllllllllIllIIIIIllIIl) {
                lllllllllllllllllllIllIIIIIllIII.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append("Could not read from specified imports file: ").append(lllllllllllllllllllIllIIIIIlIllI)));
            }
        }
        return lllllllllllllllllllIllIIIIIlIlll;
    }

    @Override
    public TypeHandle getTypeHandle(String lllllllllllllllllllIlIlIlIllllll) {
        String lllllllllllllllllllIlIlIllIIIlll;
        PackageElement lllllllllllllllllllIlIlIllIIIllI;
        int lllllllllllllllllllIlIlIllIIIIIl;
        AnnotatedMixins lllllllllllllllllllIlIlIllIIIlIl;
        lllllllllllllllllllIlIlIlIllllll = lllllllllllllllllllIlIlIlIllllll.replace('/', '.');
        Elements lllllllllllllllllllIlIlIllIIIIll = lllllllllllllllllllIlIlIllIIIlIl.processingEnv.getElementUtils();
        TypeElement lllllllllllllllllllIlIlIllIIIIlI = lllllllllllllllllllIlIlIllIIIIll.getTypeElement(lllllllllllllllllllIlIlIlIllllll);
        if (lllllllllllllllllllIlIlIllIIIIlI != null) {
            try {
                return new TypeHandle(lllllllllllllllllllIlIlIllIIIIlI);
            }
            catch (NullPointerException lllllllllllllllllllIlIlIlIllllII) {
                // empty catch block
            }
        }
        if ((lllllllllllllllllllIlIlIllIIIIIl = lllllllllllllllllllIlIlIlIllllll.lastIndexOf(46)) > -1 && (lllllllllllllllllllIlIlIllIIIllI = lllllllllllllllllllIlIlIllIIIIll.getPackageElement(lllllllllllllllllllIlIlIllIIIlll = lllllllllllllllllllIlIlIlIllllll.substring(0, lllllllllllllllllllIlIlIllIIIIIl))) != null) {
            return new TypeHandle(lllllllllllllllllllIlIlIllIIIllI, lllllllllllllllllllIlIlIlIllllll);
        }
        return null;
    }

    private AnnotatedMixins(ProcessingEnvironment lllllllllllllllllllIllIIIIIllllI) {
        AnnotatedMixins lllllllllllllllllllIllIIIIlIIIIl;
        lllllllllllllllllllIllIIIIlIIIIl.mixins = new HashMap<String, AnnotatedMixin>();
        lllllllllllllllllllIllIIIIlIIIIl.mixinsForPass = new ArrayList<AnnotatedMixin>();
        lllllllllllllllllllIllIIIIlIIIIl.tokenCache = new HashMap<String, Integer>();
        lllllllllllllllllllIllIIIIlIIIIl.env = lllllllllllllllllllIllIIIIlIIIIl.detectEnvironment(lllllllllllllllllllIllIIIIIllllI);
        lllllllllllllllllllIllIIIIlIIIIl.processingEnv = lllllllllllllllllllIllIIIIIllllI;
        lllllllllllllllllllIllIIIIlIIIIl.printMessage(Diagnostic.Kind.NOTE, "SpongePowered MIXIN Annotation Processor Version=0.7.4");
        lllllllllllllllllllIllIIIIlIIIIl.targets = lllllllllllllllllllIllIIIIlIIIIl.initTargetMap();
        lllllllllllllllllllIllIIIIlIIIIl.obf = new ObfuscationManager(lllllllllllllllllllIllIIIIlIIIIl);
        lllllllllllllllllllIllIIIIlIIIIl.obf.init();
        lllllllllllllllllllIllIIIIlIIIIl.validators = ImmutableList.of((Object)new ParentValidator(lllllllllllllllllllIllIIIIlIIIIl), (Object)new TargetValidator(lllllllllllllllllllIllIIIIlIIIIl));
        lllllllllllllllllllIllIIIIlIIIIl.initTokenCache(lllllllllllllllllllIllIIIIlIIIIl.getOption("tokens"));
    }

    public void registerInjector(TypeElement lllllllllllllllllllIlIllIIllIIII, ExecutableElement lllllllllllllllllllIlIllIIlIllll, AnnotationHandle lllllllllllllllllllIlIllIIlIlllI) {
        AnnotatedMixins lllllllllllllllllllIlIllIIllIIIl;
        AnnotatedMixin lllllllllllllllllllIlIllIIllIIll = lllllllllllllllllllIlIllIIllIIIl.getMixin(lllllllllllllllllllIlIllIIllIIII);
        if (lllllllllllllllllllIlIllIIllIIll == null) {
            lllllllllllllllllllIlIllIIllIIIl.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("Found ").append(lllllllllllllllllllIlIllIIlIlllI).append(" annotation on a non-mixin method")), lllllllllllllllllllIlIllIIlIllll);
            return;
        }
        InjectorRemap lllllllllllllllllllIlIllIIllIIlI = new InjectorRemap(lllllllllllllllllllIlIllIIllIIIl.shouldRemap(lllllllllllllllllllIlIllIIllIIll, lllllllllllllllllllIlIllIIlIlllI));
        lllllllllllllllllllIlIllIIllIIll.registerInjector(lllllllllllllllllllIlIllIIlIllll, lllllllllllllllllllIlIllIIlIlllI, lllllllllllllllllllIlIllIIllIIlI);
        lllllllllllllllllllIlIllIIllIIlI.dispatchPendingMessages(lllllllllllllllllllIlIllIIllIIIl);
    }

    @Override
    public void printMessage(Diagnostic.Kind lllllllllllllllllllIlIllIIIIIllI, CharSequence lllllllllllllllllllIlIllIIIIIlIl) {
        AnnotatedMixins lllllllllllllllllllIlIllIIIIIlII;
        if (lllllllllllllllllllIlIllIIIIIlII.env == IMixinAnnotationProcessor.CompilerEnvironment.JAVAC || lllllllllllllllllllIlIllIIIIIllI != Diagnostic.Kind.NOTE) {
            lllllllllllllllllllIlIllIIIIIlII.processingEnv.getMessager().printMessage(lllllllllllllllllllIlIllIIIIIllI, lllllllllllllllllllIlIllIIIIIlIl);
        }
    }

    public void onPassCompleted(RoundEnvironment lllllllllllllllllllIlIllIIIlIlII) {
        AnnotatedMixins lllllllllllllllllllIlIllIIIlIlIl;
        if (!"true".equalsIgnoreCase(lllllllllllllllllllIlIllIIIlIlIl.getOption("disableTargetExport"))) {
            lllllllllllllllllllIlIllIIIlIlIl.targets.write(true);
        }
        for (AnnotatedMixin lllllllllllllllllllIlIllIIIllIII : lllllllllllllllllllIlIllIIIlIlII.processingOver() ? lllllllllllllllllllIlIllIIIlIlIl.mixins.values() : lllllllllllllllllllIlIllIIIlIlIl.mixinsForPass) {
            lllllllllllllllllllIlIllIIIllIII.runValidators(lllllllllllllllllllIlIllIIIlIlII.processingOver() ? IMixinValidator.ValidationPass.FINAL : IMixinValidator.ValidationPass.LATE, lllllllllllllllllllIlIllIIIlIlIl.validators);
        }
    }

    public void writeReferences() {
        AnnotatedMixins lllllllllllllllllllIlIlllIllllII;
        lllllllllllllllllllIlIlllIllllII.obf.writeReferences();
    }

    @Override
    public void printMessage(Diagnostic.Kind lllllllllllllllllllIlIlIllllllII, CharSequence lllllllllllllllllllIlIlIlllllIll, Element lllllllllllllllllllIlIlIllllIllI) {
        AnnotatedMixins lllllllllllllllllllIlIlIlllllIIl;
        lllllllllllllllllllIlIlIlllllIIl.processingEnv.getMessager().printMessage(lllllllllllllllllllIlIlIllllllII, lllllllllllllllllllIlIlIlllllIll, lllllllllllllllllllIlIlIllllIllI);
    }

    @Override
    public void printMessage(Diagnostic.Kind lllllllllllllllllllIlIlIllIlllll, CharSequence lllllllllllllllllllIlIlIllIllllI, Element lllllllllllllllllllIlIlIllIlllIl, AnnotationMirror lllllllllllllllllllIlIlIllIlIIll, AnnotationValue lllllllllllllllllllIlIlIllIlIIlI) {
        AnnotatedMixins lllllllllllllllllllIlIlIllIllIIl;
        lllllllllllllllllllIlIlIllIllIIl.processingEnv.getMessager().printMessage(lllllllllllllllllllIlIlIllIlllll, lllllllllllllllllllIlIlIllIllllI, lllllllllllllllllllIlIlIllIlllIl, lllllllllllllllllllIlIlIllIlIIll, lllllllllllllllllllIlIlIllIlIIlI);
    }

    @Override
    public IMixinAnnotationProcessor.CompilerEnvironment getCompilerEnvironment() {
        AnnotatedMixins lllllllllllllllllllIlIlllllIlIIl;
        return lllllllllllllllllllIlIlllllIlIIl.env;
    }

    public void registerShadow(TypeElement lllllllllllllllllllIlIllIlIlIIII, VariableElement lllllllllllllllllllIlIllIlIlIlII, AnnotationHandle lllllllllllllllllllIlIllIlIlIIll) {
        AnnotatedMixins lllllllllllllllllllIlIllIlIlIIIl;
        AnnotatedMixin lllllllllllllllllllIlIllIlIlIIlI = lllllllllllllllllllIlIllIlIlIIIl.getMixin(lllllllllllllllllllIlIllIlIlIIII);
        if (lllllllllllllllllllIlIllIlIlIIlI == null) {
            lllllllllllllllllllIlIllIlIlIIIl.printMessage(Diagnostic.Kind.ERROR, "Found @Shadow annotation on a non-mixin field", lllllllllllllllllllIlIllIlIlIlII);
            return;
        }
        lllllllllllllllllllIlIllIlIlIIlI.registerShadow(lllllllllllllllllllIlIllIlIlIlII, lllllllllllllllllllIlIllIlIlIIll, lllllllllllllllllllIlIllIlIlIIIl.shouldRemap(lllllllllllllllllllIlIllIlIlIIlI, lllllllllllllllllllIlIllIlIlIIll));
    }

    public void registerInvoker(TypeElement lllllllllllllllllllIlIllIllIlllI, ExecutableElement lllllllllllllllllllIlIllIlllIIlI) {
        AnnotatedMixins lllllllllllllllllllIlIllIlllIlII;
        AnnotatedMixin lllllllllllllllllllIlIllIlllIIIl = lllllllllllllllllllIlIllIlllIlII.getMixin(lllllllllllllllllllIlIllIllIlllI);
        if (lllllllllllllllllllIlIllIlllIIIl == null) {
            lllllllllllllllllllIlIllIlllIlII.printMessage(Diagnostic.Kind.ERROR, "Found @Accessor annotation on a non-mixin method", lllllllllllllllllllIlIllIlllIIlI);
            return;
        }
        AnnotationHandle lllllllllllllllllllIlIllIlllIIII = AnnotationHandle.of(lllllllllllllllllllIlIllIlllIIlI, Invoker.class);
        lllllllllllllllllllIlIllIlllIIIl.registerInvoker(lllllllllllllllllllIlIllIlllIIlI, lllllllllllllllllllIlIllIlllIIII, lllllllllllllllllllIlIllIlllIlII.shouldRemap(lllllllllllllllllllIlIllIlllIIIl, lllllllllllllllllllIlIllIlllIIII));
    }

    public static AnnotatedMixins getMixinsForEnvironment(ProcessingEnvironment lllllllllllllllllllIlIlIlIIIIllI) {
        AnnotatedMixins lllllllllllllllllllIlIlIlIIIIlll = instances.get(lllllllllllllllllllIlIlIlIIIIllI);
        if (lllllllllllllllllllIlIlIlIIIIlll == null) {
            lllllllllllllllllllIlIlIlIIIIlll = new AnnotatedMixins(lllllllllllllllllllIlIlIlIIIIllI);
            instances.put(lllllllllllllllllllIlIlIlIIIIllI, lllllllllllllllllllIlIlIlIIIIlll);
        }
        return lllllllllllllllllllIlIlIlIIIIlll;
    }

    public void registerShadow(TypeElement lllllllllllllllllllIlIllIlIIIllI, ExecutableElement lllllllllllllllllllIlIllIlIIIIII, AnnotationHandle lllllllllllllllllllIlIllIIllllll) {
        AnnotatedMixins lllllllllllllllllllIlIllIlIIIIlI;
        AnnotatedMixin lllllllllllllllllllIlIllIlIIIIll = lllllllllllllllllllIlIllIlIIIIlI.getMixin(lllllllllllllllllllIlIllIlIIIllI);
        if (lllllllllllllllllllIlIllIlIIIIll == null) {
            lllllllllllllllllllIlIllIlIIIIlI.printMessage(Diagnostic.Kind.ERROR, "Found @Shadow annotation on a non-mixin method", lllllllllllllllllllIlIllIlIIIIII);
            return;
        }
        lllllllllllllllllllIlIllIlIIIIll.registerShadow(lllllllllllllllllllIlIllIlIIIIII, lllllllllllllllllllIlIllIIllllll, lllllllllllllllllllIlIllIlIIIIlI.shouldRemap(lllllllllllllllllllIlIllIlIIIIll, lllllllllllllllllllIlIllIIllllll));
    }

    public void onPassStarted() {
        AnnotatedMixins lllllllllllllllllllIlIllIIIllllI;
        lllllllllllllllllllIlIllIIIllllI.mixinsForPass.clear();
    }

    public void clear() {
        AnnotatedMixins lllllllllllllllllllIlIlllIlllIII;
        lllllllllllllllllllIlIlllIlllIII.mixins.clear();
    }

    @Override
    public TypeHandle getSimulatedHandle(String lllllllllllllllllllIlIlIlIIllIII, TypeMirror lllllllllllllllllllIlIlIlIIllIll) {
        int lllllllllllllllllllIlIlIlIIllIlI = (lllllllllllllllllllIlIlIlIIllIII = lllllllllllllllllllIlIlIlIIllIII.replace('/', '.')).lastIndexOf(46);
        if (lllllllllllllllllllIlIlIlIIllIlI > -1) {
            AnnotatedMixins lllllllllllllllllllIlIlIlIIllIIl;
            String lllllllllllllllllllIlIlIlIIlllll = lllllllllllllllllllIlIlIlIIllIII.substring(0, lllllllllllllllllllIlIlIlIIllIlI);
            PackageElement lllllllllllllllllllIlIlIlIIllllI = lllllllllllllllllllIlIlIlIIllIIl.processingEnv.getElementUtils().getPackageElement(lllllllllllllllllllIlIlIlIIlllll);
            if (lllllllllllllllllllIlIlIlIIllllI != null) {
                return new TypeHandleSimulated(lllllllllllllllllllIlIlIlIIllllI, lllllllllllllllllllIlIlIlIIllIII, lllllllllllllllllllIlIlIlIIllIll);
            }
        }
        return new TypeHandleSimulated(lllllllllllllllllllIlIlIlIIllIII, lllllllllllllllllllIlIlIlIIllIll);
    }

    @Override
    public void printMessage(Diagnostic.Kind lllllllllllllllllllIlIlIlllIlIlI, CharSequence lllllllllllllllllllIlIlIlllIlllI, Element lllllllllllllllllllIlIlIlllIllIl, AnnotationMirror lllllllllllllllllllIlIlIlllIIlll) {
        AnnotatedMixins lllllllllllllllllllIlIlIlllIlIll;
        lllllllllllllllllllIlIlIlllIlIll.processingEnv.getMessager().printMessage(lllllllllllllllllllIlIlIlllIlIlI, lllllllllllllllllllIlIlIlllIlllI, lllllllllllllllllllIlIlIlllIllIl, lllllllllllllllllllIlIlIlllIIlll);
    }

    public Collection<TypeMirror> getMixinsTargeting(TypeMirror lllllllllllllllllllIlIlllIIlllII) {
        AnnotatedMixins lllllllllllllllllllIlIlllIIlllIl;
        return lllllllllllllllllllIlIlllIIlllIl.getMixinsTargeting((TypeElement)((DeclaredType)lllllllllllllllllllIlIlllIIlllII).asElement());
    }

    public void registerMixin(TypeElement lllllllllllllllllllIlIlllIllIIIl) {
        AnnotatedMixins lllllllllllllllllllIlIlllIlIllll;
        String lllllllllllllllllllIlIlllIllIIII = lllllllllllllllllllIlIlllIllIIIl.getQualifiedName().toString();
        if (!lllllllllllllllllllIlIlllIlIllll.mixins.containsKey(lllllllllllllllllllIlIlllIllIIII)) {
            AnnotatedMixin lllllllllllllllllllIlIlllIllIIll = new AnnotatedMixin(lllllllllllllllllllIlIlllIlIllll, lllllllllllllllllllIlIlllIllIIIl);
            lllllllllllllllllllIlIlllIlIllll.targets.registerTargets(lllllllllllllllllllIlIlllIllIIll);
            lllllllllllllllllllIlIlllIllIIll.runValidators(IMixinValidator.ValidationPass.EARLY, lllllllllllllllllllIlIlllIlIllll.validators);
            lllllllllllllllllllIlIlllIlIllll.mixins.put(lllllllllllllllllllIlIlllIllIIII, lllllllllllllllllllIlIlllIllIIll);
            lllllllllllllllllllIlIlllIlIllll.mixinsForPass.add(lllllllllllllllllllIlIlllIllIIll);
        }
    }
}

