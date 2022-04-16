/*
 * Decompiled with CFR 0.152.
 */
package org.newdawn.slick.util.xml;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import org.newdawn.slick.util.Log;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.util.xml.SlickXMLException;
import org.newdawn.slick.util.xml.XMLElement;
import org.newdawn.slick.util.xml.XMLElementList;
import org.newdawn.slick.util.xml.XMLParser;

public class ObjectTreeParser {
    private /* synthetic */ String defaultPackage;
    private /* synthetic */ HashMap nameToClass;
    private /* synthetic */ ArrayList ignored;
    private /* synthetic */ String addMethod;

    public ObjectTreeParser() {
        ObjectTreeParser llllIllllIIl;
        llllIllllIIl.nameToClass = new HashMap();
        llllIllllIIl.ignored = new ArrayList();
        llllIllllIIl.addMethod = "add";
    }

    public void setAddMethodName(String llllIlIIlllI) {
        llllIlIIllll.addMethod = llllIlIIlllI;
    }

    public Object parseOnto(String llllIIIIlIlI, Object llllIIIIlIIl) throws SlickXMLException {
        ObjectTreeParser llllIIIIlIll;
        return llllIIIIlIll.parseOnto(llllIIIIlIlI, ResourceLoader.getResourceAsStream(llllIIIIlIlI), llllIIIIlIIl);
    }

    private Object typeValue(String lllIIIllIlII, Class lllIIIllIIII) throws SlickXMLException {
        if (lllIIIllIIII == String.class) {
            return lllIIIllIlII;
        }
        try {
            ObjectTreeParser lllIIIllIlIl;
            lllIIIllIIII = lllIIIllIlIl.mapPrimitive(lllIIIllIIII);
            return lllIIIllIIII.getConstructor(String.class).newInstance(lllIIIllIlII);
        }
        catch (Exception lllIIIllIllI) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Failed to convert: ").append(lllIIIllIlII).append(" to the expected primitive type: ").append(lllIIIllIIII)), lllIIIllIllI);
        }
    }

    private Method findMethod(Class llIllllIIlIl, String llIllllIIIll) {
        Method[] llIllllIIlll = llIllllIIlIl.getDeclaredMethods();
        for (int llIllllIllll = 0; llIllllIllll < llIllllIIlll.length; ++llIllllIllll) {
            Method llIlllllIIll;
            Class<?>[] llIlllllIIIl;
            if (!llIllllIIlll[llIllllIllll].getName().equalsIgnoreCase(llIllllIIIll) || (llIlllllIIIl = (llIlllllIIll = llIllllIIlll[llIllllIllll]).getParameterTypes()).length != 1) continue;
            return llIlllllIIll;
        }
        return null;
    }

    public Object parseOnto(String lllIlllllIII, InputStream lllIllllllIl, Object lllIllllllII) throws SlickXMLException {
        ObjectTreeParser lllIllllllll;
        XMLParser lllIlllllIll = new XMLParser();
        XMLElement lllIlllllIlI = lllIlllllIll.parse(lllIlllllIII, lllIllllllIl);
        return lllIllllllll.traverse(lllIlllllIlI, lllIllllllII);
    }

    public ObjectTreeParser(String llllIllIlIll) {
        ObjectTreeParser llllIllIllII;
        llllIllIllII.nameToClass = new HashMap();
        llllIllIllII.ignored = new ArrayList();
        llllIllIllII.addMethod = "add";
        llllIllIllII.defaultPackage = llllIllIlIll;
    }

    public void setDefaultPackage(String llllIIllIllI) {
        llllIIllllll.defaultPackage = llllIIllIllI;
    }

    public Object parse(String llllIIIlIlll, InputStream llllIIIlIllI) throws SlickXMLException {
        ObjectTreeParser llllIIIllIII;
        XMLParser llllIIIlIlIl = new XMLParser();
        XMLElement llllIIIlIlII = llllIIIlIlIl.parse(llllIIIlIlll, llllIIIlIllI);
        return llllIIIllIII.traverse(llllIIIlIlII);
    }

    private Class getClassForElementName(String lllIlIlIIIlI) {
        ObjectTreeParser lllIlIlIIIll;
        Class lllIlIlIIIIl = (Class)lllIlIlIIIll.nameToClass.get(lllIlIlIIIlI);
        if (lllIlIlIIIIl != null) {
            return lllIlIlIIIIl;
        }
        if (lllIlIlIIIll.defaultPackage != null) {
            try {
                return Class.forName(String.valueOf(new StringBuilder().append(lllIlIlIIIll.defaultPackage).append(".").append(lllIlIlIIIlI)));
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
        }
        return null;
    }

    private Field findField(Class lllIIIIIIlIl, String lllIIIIIIlII) {
        Field[] lllIIIIIIIll = lllIIIIIIlIl.getDeclaredFields();
        for (int lllIIIIIIlll = 0; lllIIIIIIlll < lllIIIIIIIll.length; ++lllIIIIIIlll) {
            if (!lllIIIIIIIll[lllIIIIIIlll].getName().equalsIgnoreCase(lllIIIIIIlII)) continue;
            if (lllIIIIIIIll[lllIIIIIIlll].getType().isPrimitive()) {
                return lllIIIIIIIll[lllIIIIIIlll];
            }
            if (lllIIIIIIIll[lllIIIIIIlll].getType() != String.class) continue;
            return lllIIIIIIIll[lllIIIIIIlll];
        }
        return null;
    }

    private Method findMethod(Class llIlllIIIIll, String llIllIlllllI, Class llIllIllllIl) {
        Method[] llIlllIIIIII = llIlllIIIIll.getDeclaredMethods();
        for (int llIlllIIIlIl = 0; llIlllIIIlIl < llIlllIIIIII.length; ++llIlllIIIlIl) {
            Method llIlllIIlIIl;
            Class<?>[] llIlllIIIlll;
            if (!llIlllIIIIII[llIlllIIIlIl].getName().equalsIgnoreCase(llIllIlllllI) || (llIlllIIIlll = (llIlllIIlIIl = llIlllIIIIII[llIlllIIIlIl]).getParameterTypes()).length != 1 || !llIlllIIlIIl.getParameterTypes()[0].isAssignableFrom(llIllIllllIl)) continue;
            return llIlllIIlIIl;
        }
        return null;
    }

    public Object parse(String llllIIlIlIll) throws SlickXMLException {
        ObjectTreeParser llllIIllIIII;
        return llllIIllIIII.parse(llllIIlIlIll, ResourceLoader.getResourceAsStream(llllIIlIlIll));
    }

    public void addIgnoredElement(String llllIlIllIlI) {
        ObjectTreeParser llllIlIlllIl;
        llllIlIlllIl.ignored.add(llllIlIllIlI);
    }

    private void invoke(Method llIIlIlIIIII, Object llIIlIIlllll, Object[] llIIlIlIIIlI) throws SlickXMLException {
        try {
            llIIlIlIIIII.setAccessible(true);
            llIIlIlIIIII.invoke(llIIlIIlllll, llIIlIlIIIlI);
        }
        catch (IllegalArgumentException llIIlIlIlIlI) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Failed to invoke: ").append(llIIlIlIIIII).append(" for an XML attribute, is it valid?")), llIIlIlIlIlI);
        }
        catch (IllegalAccessException llIIlIlIlIIl) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Failed to invoke: ").append(llIIlIlIIIII).append(" for an XML attribute, is it valid?")), llIIlIlIlIIl);
        }
        catch (InvocationTargetException llIIlIlIlIII) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Failed to invoke: ").append(llIIlIlIIIII).append(" for an XML attribute, is it valid?")), llIIlIlIlIII);
        }
        finally {
            llIIlIlIIIII.setAccessible(false);
        }
    }

    private Object traverse(XMLElement lllIIlIIIlIl, Object lllIIlIIIlII) throws SlickXMLException {
        Class<?> lllIIlIIIlll;
        ObjectTreeParser lllIIlIIlIll;
        String lllIIlIIlIII = lllIIlIIIlIl.getName();
        if (lllIIlIIlIll.ignored.contains(lllIIlIIlIII)) {
            return null;
        }
        if (lllIIlIIIlII == null) {
            Class lllIIlIlllll = lllIIlIIlIll.getClassForElementName(lllIIlIIlIII);
        } else {
            lllIIlIIIlll = lllIIlIIIlII.getClass();
        }
        if (lllIIlIIIlll == null) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Unable to map element ").append(lllIIlIIlIII).append(" to a class, define the mapping")));
        }
        try {
            if (lllIIlIIIlII == null) {
                Method lllIIlIlllIl;
                lllIIlIIIlII = lllIIlIIIlll.newInstance();
                Method lllIIlIllllI = lllIIlIIlIll.getMethod(lllIIlIIIlll, "setXMLElementName", new Class[]{String.class});
                if (lllIIlIllllI != null) {
                    lllIIlIIlIll.invoke(lllIIlIllllI, lllIIlIIIlII, new Object[]{lllIIlIIlIII});
                }
                if ((lllIIlIlllIl = lllIIlIIlIll.getMethod(lllIIlIIIlll, "setXMLElementContent", new Class[]{String.class})) != null) {
                    lllIIlIIlIll.invoke(lllIIlIlllIl, lllIIlIIIlII, new Object[]{lllIIlIIIlIl.getContent()});
                }
            }
            String[] lllIIlIIllll = lllIIlIIIlIl.getAttributeNames();
            for (int lllIIlIlIlIl = 0; lllIIlIlIlIl < lllIIlIIllll.length; ++lllIIlIlIlIl) {
                String lllIIlIlIlll = String.valueOf(new StringBuilder().append("set").append(lllIIlIIllll[lllIIlIlIlIl]));
                Method lllIIlIlIllI = lllIIlIIlIll.findMethod(lllIIlIIIlll, lllIIlIlIlll);
                if (lllIIlIlIllI == null) {
                    Field lllIIlIllIlI = lllIIlIIlIll.findField(lllIIlIIIlll, lllIIlIIllll[lllIIlIlIlIl]);
                    if (lllIIlIllIlI != null) {
                        String lllIIlIlllII = lllIIlIIIlIl.getAttribute(lllIIlIIllll[lllIIlIlIlIl]);
                        Object lllIIlIllIll = lllIIlIIlIll.typeValue(lllIIlIlllII, lllIIlIllIlI.getType());
                        lllIIlIIlIll.setField(lllIIlIllIlI, lllIIlIIIlII, lllIIlIllIll);
                        continue;
                    }
                    Log.info(String.valueOf(new StringBuilder().append("Unable to find property on: ").append(lllIIlIIIlll).append(" for attribute: ").append(lllIIlIIllll[lllIIlIlIlIl])));
                    continue;
                }
                String lllIIlIllIIl = lllIIlIIIlIl.getAttribute(lllIIlIIllll[lllIIlIlIlIl]);
                Object lllIIlIllIII = lllIIlIIlIll.typeValue(lllIIlIllIIl, lllIIlIlIllI.getParameterTypes()[0]);
                lllIIlIIlIll.invoke(lllIIlIlIllI, lllIIlIIIlII, new Object[]{lllIIlIllIII});
            }
            XMLElementList lllIIlIIlllI = lllIIlIIIlIl.getChildren();
            for (int lllIIlIlIIII = 0; lllIIlIlIIII < lllIIlIIlllI.size(); ++lllIIlIlIIII) {
                XMLElement lllIIlIlIIlI = lllIIlIIlllI.get(lllIIlIlIIII);
                Object lllIIlIlIIIl = lllIIlIIlIll.traverse(lllIIlIlIIlI);
                if (lllIIlIlIIIl == null) continue;
                String lllIIlIlIlII = lllIIlIIlIll.addMethod;
                Method lllIIlIlIIll = lllIIlIIlIll.findMethod(lllIIlIIIlll, lllIIlIlIlII, lllIIlIlIIIl.getClass());
                if (lllIIlIlIIll == null) {
                    Log.info(String.valueOf(new StringBuilder().append("Unable to find method to add: ").append(lllIIlIlIIIl).append(" to ").append(lllIIlIIIlll)));
                    continue;
                }
                lllIIlIIlIll.invoke(lllIIlIlIIll, lllIIlIIIlII, new Object[]{lllIIlIlIIIl});
            }
            return lllIIlIIIlII;
        }
        catch (InstantiationException lllIIlIIllIl) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Unable to instance ").append(lllIIlIIIlll).append(" for element ").append(lllIIlIIlIII).append(", no zero parameter constructor?")), lllIIlIIllIl);
        }
        catch (IllegalAccessException lllIIlIIllII) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Unable to instance ").append(lllIIlIIIlll).append(" for element ").append(lllIIlIIlIII).append(", no zero parameter constructor?")), lllIIlIIllII);
        }
    }

    public void addElementMapping(String llllIllIIIIl, Class llllIllIIIll) {
        ObjectTreeParser llllIllIIlIl;
        llllIllIIlIl.nameToClass.put(llllIllIIIIl, llllIllIIIll);
    }

    private Object traverse(XMLElement lllIlIIlIlll) throws SlickXMLException {
        ObjectTreeParser lllIlIIllIlI;
        return lllIlIIllIlI.traverse(lllIlIIlIlll, null);
    }

    private void setField(Field llIIllIIIlIl, Object llIIllIIlIII, Object llIIllIIIlll) throws SlickXMLException {
        try {
            llIIllIIIlIl.setAccessible(true);
            llIIllIIIlIl.set(llIIllIIlIII, llIIllIIIlll);
        }
        catch (IllegalArgumentException llIIllIIlllI) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Failed to set: ").append(llIIllIIIlIl).append(" for an XML attribute, is it valid?")), llIIllIIlllI);
        }
        catch (IllegalAccessException llIIllIIllIl) {
            throw new SlickXMLException(String.valueOf(new StringBuilder().append("Failed to set: ").append(llIIllIIIlIl).append(" for an XML attribute, is it valid?")), llIIllIIllIl);
        }
        finally {
            llIIllIIIlIl.setAccessible(false);
        }
    }

    private Method getMethod(Class llIIlIIIllll, String llIIlIIIlllI, Class[] llIIlIIIllIl) {
        try {
            return llIIlIIIllll.getMethod(llIIlIIIlllI, llIIlIIIllIl);
        }
        catch (SecurityException llIIlIIlIIlI) {
            return null;
        }
        catch (NoSuchMethodException llIIlIIlIIIl) {
            return null;
        }
    }

    private Class mapPrimitive(Class lllIIIlIIlII) {
        if (lllIIIlIIlII == Integer.TYPE) {
            return Integer.class;
        }
        if (lllIIIlIIlII == Double.TYPE) {
            return Double.class;
        }
        if (lllIIIlIIlII == Float.TYPE) {
            return Float.class;
        }
        if (lllIIIlIIlII == Boolean.TYPE) {
            return Boolean.class;
        }
        if (lllIIIlIIlII == Long.TYPE) {
            return Long.class;
        }
        throw new RuntimeException(String.valueOf(new StringBuilder().append("Unsupported primitive: ").append(lllIIIlIIlII)));
    }
}

