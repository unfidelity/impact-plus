/*
 * Decompiled with CFR 0.152.
 */
package me.zero.alpine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import me.zero.alpine.EventBus;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;

public class EventManager
implements EventBus {
    private final /* synthetic */ Map<Class<?>, List<Listener>> SUBSCRIPTION_MAP;
    private final /* synthetic */ List<EventBus> ATTACHED_BUSES;
    private final /* synthetic */ Map<Object, List<Listener>> SUBSCRIPTION_CACHE;

    @Override
    public void subscribe(Object ... lllllllllllllllllIIIlIIlIIlIIlII) {
        EventManager lllllllllllllllllIIIlIIlIIlIIIll;
        Arrays.stream(lllllllllllllllllIIIlIIlIIlIIlII).forEach(lllllllllllllllllIIIlIIlIIlIIIll::subscribe);
    }

    private static Listener asListener(Object lllllllllllllllllIIIlIIIlllIIlll, Field lllllllllllllllllIIIlIIIlllIIllI) {
        try {
            boolean lllllllllllllllllIIIlIIIlllIlIlI = lllllllllllllllllIIIlIIIlllIIllI.isAccessible();
            lllllllllllllllllIIIlIIIlllIIllI.setAccessible(true);
            Listener lllllllllllllllllIIIlIIIlllIlIIl = (Listener)lllllllllllllllllIIIlIIIlllIIllI.get(lllllllllllllllllIIIlIIIlllIIlll);
            lllllllllllllllllIIIlIIIlllIIllI.setAccessible(lllllllllllllllllIIIlIIIlllIlIlI);
            if (lllllllllllllllllIIIlIIIlllIlIIl == null) {
                return null;
            }
            if (lllllllllllllllllIIIlIIIlllIlIIl.getPriority() > 5 || lllllllllllllllllIIIlIIIlllIlIIl.getPriority() < 1) {
                throw new RuntimeException("Event Priority out of bounds! %s");
            }
            return lllllllllllllllllIIIlIIIlllIlIIl;
        }
        catch (IllegalAccessException lllllllllllllllllIIIlIIIlllIlIII) {
            return null;
        }
    }

    @Override
    public void unsubscribe(Iterable<Object> lllllllllllllllllIIIlIIlIIIIIlll) {
        EventManager lllllllllllllllllIIIlIIlIIIIlIII;
        lllllllllllllllllIIIlIIlIIIIIlll.forEach(lllllllllllllllllIIIlIIlIIIIlIII::unsubscribe);
    }

    @Override
    public void unsubscribe(Object lllllllllllllllllIIIlIIlIIIlIlII) {
        EventManager lllllllllllllllllIIIlIIlIIIllIII;
        List<Listener> lllllllllllllllllIIIlIIlIIIlIllI = lllllllllllllllllIIIlIIlIIIllIII.SUBSCRIPTION_CACHE.get(lllllllllllllllllIIIlIIlIIIlIlII);
        if (lllllllllllllllllIIIlIIlIIIlIllI == null) {
            return;
        }
        lllllllllllllllllIIIlIIlIIIllIII.SUBSCRIPTION_MAP.values().forEach(lllllllllllllllllIIIlIIIlIllllIl -> lllllllllllllllllIIIlIIIlIllllIl.removeIf(lllllllllllllllllIIIlIIlIIIlIllI::contains));
        if (!lllllllllllllllllIIIlIIlIIIllIII.ATTACHED_BUSES.isEmpty()) {
            lllllllllllllllllIIIlIIlIIIllIII.ATTACHED_BUSES.forEach(lllllllllllllllllIIIlIIIllIIIIll -> lllllllllllllllllIIIlIIIllIIIIll.unsubscribe(lllllllllllllllllIIIlIIlIIIlIlII));
        }
    }

    private void subscribe(Listener lllllllllllllllllIIIlIIIllIlllII) {
        int lllllllllllllllllIIIlIIIllIllIlI;
        EventManager lllllllllllllllllIIIlIIIllIllIIl;
        List lllllllllllllllllIIIlIIIllIllIll = lllllllllllllllllIIIlIIIllIllIIl.SUBSCRIPTION_MAP.computeIfAbsent(lllllllllllllllllIIIlIIIllIlllII.getTarget(), lllllllllllllllllIIIlIIIllIlIlIl -> new ArrayList());
        for (lllllllllllllllllIIIlIIIllIllIlI = 0; lllllllllllllllllIIIlIIIllIllIlI < lllllllllllllllllIIIlIIIllIllIll.size() && lllllllllllllllllIIIlIIIllIlllII.getPriority() >= ((Listener)lllllllllllllllllIIIlIIIllIllIll.get(lllllllllllllllllIIIlIIIllIllIlI)).getPriority(); ++lllllllllllllllllIIIlIIIllIllIlI) {
        }
        lllllllllllllllllIIIlIIIllIllIll.add(lllllllllllllllllIIIlIIIllIllIlI, lllllllllllllllllIIIlIIIllIlllII);
    }

    @Override
    public void subscribe(Iterable<Object> lllllllllllllllllIIIlIIlIIIlllII) {
        EventManager lllllllllllllllllIIIlIIlIIIlllIl;
        lllllllllllllllllIIIlIIlIIIlllII.forEach(lllllllllllllllllIIIlIIlIIIlllIl::subscribe);
    }

    @Override
    public void unsubscribe(Object ... lllllllllllllllllIIIlIIlIIIIllll) {
        EventManager lllllllllllllllllIIIlIIlIIIlIIII;
        Arrays.stream(lllllllllllllllllIIIlIIlIIIIllll).forEach(lllllllllllllllllIIIlIIlIIIlIIII::unsubscribe);
    }

    @Override
    public void detach(EventBus lllllllllllllllllIIIlIIIllllIIlI) {
        EventManager lllllllllllllllllIIIlIIIllllIlIl;
        if (lllllllllllllllllIIIlIIIllllIlIl.ATTACHED_BUSES.contains(lllllllllllllllllIIIlIIIllllIIlI)) {
            lllllllllllllllllIIIlIIIllllIlIl.ATTACHED_BUSES.remove(lllllllllllllllllIIIlIIIllllIIlI);
        }
    }

    public EventManager() {
        EventManager lllllllllllllllllIIIlIIlIIllIIlI;
        lllllllllllllllllIIIlIIlIIllIIlI.SUBSCRIPTION_CACHE = new HashMap<Object, List<Listener>>();
        lllllllllllllllllIIIlIIlIIllIIlI.SUBSCRIPTION_MAP = new HashMap();
        lllllllllllllllllIIIlIIlIIllIIlI.ATTACHED_BUSES = new ArrayList<EventBus>();
    }

    @Override
    public void subscribe(Object lllllllllllllllllIIIlIIlIIlIllII) {
        EventManager lllllllllllllllllIIIlIIlIIlIlIlI;
        List lllllllllllllllllIIIlIIlIIlIlIll = lllllllllllllllllIIIlIIlIIlIlIlI.SUBSCRIPTION_CACHE.computeIfAbsent(lllllllllllllllllIIIlIIlIIlIllII, lllllllllllllllllIIIlIIIlIllIlII -> Arrays.stream(lllllllllllllllllIIIlIIIlIllIlII.getClass().getDeclaredFields()).filter(EventManager::isValidField).map(lllllllllllllllllIIIlIIIlIllIIII -> EventManager.asListener(lllllllllllllllllIIIlIIIlIllIlII, lllllllllllllllllIIIlIIIlIllIIII)).filter(Objects::nonNull).collect(Collectors.toList()));
        lllllllllllllllllIIIlIIlIIlIlIll.forEach(lllllllllllllllllIIIlIIlIIlIlIlI::subscribe);
        if (!lllllllllllllllllIIIlIIlIIlIlIlI.ATTACHED_BUSES.isEmpty()) {
            lllllllllllllllllIIIlIIlIIlIlIlI.ATTACHED_BUSES.forEach(lllllllllllllllllIIIlIIIlIllIlll -> lllllllllllllllllIIIlIIIlIllIlll.subscribe(lllllllllllllllllIIIlIIlIIlIllII));
        }
    }

    @Override
    public void post(Object lllllllllllllllllIIIlIIlIIIIIIlI) {
        EventManager lllllllllllllllllIIIlIIlIIIIIIII;
        List<Listener> lllllllllllllllllIIIlIIlIIIIIIIl = lllllllllllllllllIIIlIIlIIIIIIII.SUBSCRIPTION_MAP.get(lllllllllllllllllIIIlIIlIIIIIIlI.getClass());
        if (lllllllllllllllllIIIlIIlIIIIIIIl != null) {
            lllllllllllllllllIIIlIIlIIIIIIIl.forEach(lllllllllllllllllIIIlIIIllIIlIIl -> lllllllllllllllllIIIlIIIllIIlIIl.invoke(lllllllllllllllllIIIlIIlIIIIIIlI));
        }
        if (!lllllllllllllllllIIIlIIlIIIIIIII.ATTACHED_BUSES.isEmpty()) {
            lllllllllllllllllIIIlIIlIIIIIIII.ATTACHED_BUSES.forEach(lllllllllllllllllIIIlIIIllIlIIIl -> lllllllllllllllllIIIlIIIllIlIIIl.post(lllllllllllllllllIIIlIIlIIIIIIlI));
        }
    }

    private static boolean isValidField(Field lllllllllllllllllIIIlIIIllllIIII) {
        return lllllllllllllllllIIIlIIIllllIIII.isAnnotationPresent(EventHandler.class) && Listener.class.isAssignableFrom(lllllllllllllllllIIIlIIIllllIIII.getType());
    }

    @Override
    public void attach(EventBus lllllllllllllllllIIIlIIIlllllIlI) {
        EventManager lllllllllllllllllIIIlIIIlllllIll;
        if (!lllllllllllllllllIIIlIIIlllllIll.ATTACHED_BUSES.contains(lllllllllllllllllIIIlIIIlllllIlI)) {
            lllllllllllllllllIIIlIIIlllllIll.ATTACHED_BUSES.add(lllllllllllllllllIIIlIIIlllllIlI);
        }
    }
}

