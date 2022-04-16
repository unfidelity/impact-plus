/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  com.google.common.util.concurrent.FutureCallback
 *  com.google.common.util.concurrent.Futures
 *  com.google.common.util.concurrent.ListenableFuture
 *  com.google.common.util.concurrent.ListeningExecutorService
 *  com.google.common.util.concurrent.MoreExecutors
 *  javax.annotation.Nullable
 *  joptsimple.internal.Strings
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.util;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import joptsimple.internal.Strings;
import me.axua.impactplus.util.Immutables;
import me.axua.impactplus.util.PlayerInfo;
import net.minecraft.client.Minecraft;

public class PlayerInfoHelper {
    private static final /* synthetic */ Map<String, PlayerInfo> NAME_TO_INFO;
    private static final /* synthetic */ ListeningExecutorService EXECUTOR_SERVICE;
    public static final /* synthetic */ int MAX_NAME_LENGTH;
    private static final /* synthetic */ Map<UUID, PlayerInfo> UUID_TO_INFO;
    private static final /* synthetic */ int THREAD_COUNT;

    public static List<PlayerInfo> getOnlinePlayers() {
        return Minecraft.getMinecraft().getNetHandler() == null ? Collections.emptyList() : Minecraft.getMinecraft().getNetHandler().getPlayerInfoMap().stream().map(lllllllllllllllllllIllIllIlIllll -> {
            PlayerInfo lllllllllllllllllllIllIllIllIIIl = PlayerInfoHelper.get(lllllllllllllllllllIllIllIlIllll.getGameProfile().getName());
            return lllllllllllllllllllIllIllIllIIIl == null ? PlayerInfoHelper.offlineUser(lllllllllllllllllllIllIllIlIllll.getGameProfile().getName()) : lllllllllllllllllllIllIllIllIIIl;
        }).collect(Collectors.toList());
    }

    public static boolean generateOfflineWithCallback(String lllllllllllllllllllIllIlllIlllII, FutureCallback<PlayerInfo> lllllllllllllllllllIllIlllIllIll) {
        ListenableFuture lllllllllllllllllllIllIlllIlllIl = Futures.immediateFuture((Object)PlayerInfoHelper.offlineUser(lllllllllllllllllllIllIlllIlllII));
        Futures.addCallback((ListenableFuture)lllllllllllllllllllIllIlllIlllIl, lllllllllllllllllllIllIlllIllIll);
        return false;
    }

    public static boolean registerWithCallback(UUID lllllllllllllllllllIllIllllIlllI, FutureCallback<PlayerInfo> lllllllllllllllllllIllIllllIllIl) {
        PlayerInfo lllllllllllllllllllIllIllllIllll = PlayerInfoHelper.get(lllllllllllllllllllIllIllllIlllI);
        if (lllllllllllllllllllIllIllllIllll == null) {
            Futures.addCallback((ListenableFuture)EXECUTOR_SERVICE.submit(() -> PlayerInfoHelper.register(lllllllllllllllllllIllIllllIlllI)), lllllllllllllllllllIllIllllIllIl);
            return true;
        }
        Futures.addCallback((ListenableFuture)Futures.immediateFuture((Object)lllllllllllllllllllIllIllllIllll), lllllllllllllllllllIllIllllIllIl);
        return false;
    }

    public static PlayerInfo get(String lllllllllllllllllllIlllIIIIIlllI) {
        return Strings.isNullOrEmpty((String)lllllllllllllllllllIlllIIIIIlllI) ? null : NAME_TO_INFO.get(lllllllllllllllllllIlllIIIIIlllI.toLowerCase());
    }

    public static PlayerInfo lookup(UUID lllllllllllllllllllIllIlllllllll) throws IOException {
        PlayerInfo lllllllllllllllllllIlllIIIIIIIII = PlayerInfoHelper.get(lllllllllllllllllllIllIlllllllll);
        if (lllllllllllllllllllIlllIIIIIIIII == null) {
            return PlayerInfoHelper.register(lllllllllllllllllllIllIlllllllll);
        }
        return lllllllllllllllllllIlllIIIIIIIII;
    }

    private static PlayerInfo register(UUID lllllllllllllllllllIlllIIIIlIlII) throws IOException {
        PlayerInfo lllllllllllllllllllIlllIIIIlIlIl = new PlayerInfo(lllllllllllllllllllIlllIIIIlIlII);
        NAME_TO_INFO.put(lllllllllllllllllllIlllIIIIlIlIl.getName().toLowerCase(), lllllllllllllllllllIlllIIIIlIlIl);
        UUID_TO_INFO.put(lllllllllllllllllllIlllIIIIlIlIl.getId(), lllllllllllllllllllIlllIIIIlIlIl);
        return lllllllllllllllllllIlllIIIIlIlIl;
    }

    private static PlayerInfo register(String lllllllllllllllllllIlllIIIIlllII) throws IOException {
        if (Strings.isNullOrEmpty((String)lllllllllllllllllllIlllIIIIlllII) || lllllllllllllllllllIlllIIIIlllII.length() > 16) {
            return null;
        }
        PlayerInfo lllllllllllllllllllIlllIIIIllIll = new PlayerInfo(lllllllllllllllllllIlllIIIIlllII);
        NAME_TO_INFO.put(lllllllllllllllllllIlllIIIIllIll.getName().toLowerCase(), lllllllllllllllllllIlllIIIIllIll);
        UUID_TO_INFO.put(lllllllllllllllllllIlllIIIIllIll.getId(), lllllllllllllllllllIlllIIIIllIll);
        return lllllllllllllllllllIlllIIIIllIll;
    }

    public static boolean registerWithCallback(String lllllllllllllllllllIllIlllllIlll, FutureCallback<PlayerInfo> lllllllllllllllllllIllIllllllIIl) {
        PlayerInfo lllllllllllllllllllIllIllllllIII = PlayerInfoHelper.get(lllllllllllllllllllIllIlllllIlll);
        if (lllllllllllllllllllIllIllllllIII == null) {
            Futures.addCallback((ListenableFuture)EXECUTOR_SERVICE.submit(() -> PlayerInfoHelper.register(lllllllllllllllllllIllIlllllIlll)), lllllllllllllllllllIllIllllllIIl);
            return true;
        }
        Futures.addCallback((ListenableFuture)Futures.immediateFuture((Object)lllllllllllllllllllIllIllllllIII), lllllllllllllllllllIllIllllllIIl);
        return false;
    }

    public static String getIdNoHyphens(UUID lllllllllllllllllllIllIlllIIllII) {
        return lllllllllllllllllllIllIlllIIllII.toString().replaceAll("-", "");
    }

    public static List<PlayerInfo> getPlayers() {
        return Immutables.copyToList(UUID_TO_INFO.values());
    }

    public static PlayerInfo get(UUID lllllllllllllllllllIlllIIIIIlIlI) {
        return lllllllllllllllllllIlllIIIIIlIlI == null ? null : UUID_TO_INFO.get(lllllllllllllllllllIlllIIIIIlIlI);
    }

    public static UUID getIdFromString(String lllllllllllllllllllIllIlllIIllll) {
        if (lllllllllllllllllllIllIlllIIllll.contains("-")) {
            return UUID.fromString(lllllllllllllllllllIllIlllIIllll);
        }
        return UUID.fromString(lllllllllllllllllllIllIlllIIllll.replaceFirst("(\\p{XDigit}{8})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}{4})(\\p{XDigit}+)", "$1-$2-$3-$4-$5"));
    }

    static {
        MAX_NAME_LENGTH = 16;
        THREAD_COUNT = 1;
        EXECUTOR_SERVICE = MoreExecutors.listeningDecorator((ExecutorService)Executors.newFixedThreadPool(Math.max(1, 1)));
        NAME_TO_INFO = Maps.newConcurrentMap();
        UUID_TO_INFO = Maps.newConcurrentMap();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            EXECUTOR_SERVICE.shutdown();
            while (!EXECUTOR_SERVICE.isShutdown()) {
                try {
                    EXECUTOR_SERVICE.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
                }
                catch (InterruptedException lllllllllllllllllllIllIllIlIIllI) {}
            }
        }));
    }

    public PlayerInfoHelper() {
        PlayerInfoHelper lllllllllllllllllllIlllIIIlIIIII;
    }

    public static boolean registerWithCallback(UUID lllllllllllllllllllIllIllllIIlIl, final String lllllllllllllllllllIllIllllIIlII, final FutureCallback<PlayerInfo> lllllllllllllllllllIllIllllIIIll) {
        return PlayerInfoHelper.registerWithCallback(lllllllllllllllllllIllIllllIIlIl, new FutureCallback<PlayerInfo>(){
            {
                1 llllllllllllllllIlllIIlIIlllIlIl;
            }

            public void onFailure(Throwable llllllllllllllllIlllIIlIIlIlIIIl) {
                1 llllllllllllllllIlllIIlIIlIlIlII;
                PlayerInfoHelper.registerWithCallback(llllllllllllllllIlllIIlIIlIlIlII.lllllllllllllllllllIllIllllIIlII, (FutureCallback<PlayerInfo>)llllllllllllllllIlllIIlIIlIlIlII.lllllllllllllllllllIllIllllIIIll);
            }

            public void onSuccess(@Nullable PlayerInfo llllllllllllllllIlllIIlIIllIIlIl) {
                1 llllllllllllllllIlllIIlIIllIlIII;
                llllllllllllllllIlllIIlIIllIlIII.lllllllllllllllllllIllIllllIIIll.onSuccess((Object)llllllllllllllllIlllIIlIIllIIlIl);
            }
        });
    }

    private static PlayerInfo offlineUser(String lllllllllllllllllllIlllIIIIlIIII) {
        if (lllllllllllllllllllIlllIIIIlIIII.length() > 16) {
            return null;
        }
        return new PlayerInfo(lllllllllllllllllllIlllIIIIlIIII, true);
    }

    public static PlayerInfo lookup(String lllllllllllllllllllIlllIIIIIIlIl) throws IOException {
        PlayerInfo lllllllllllllllllllIlllIIIIIIllI = PlayerInfoHelper.get(lllllllllllllllllllIlllIIIIIIlIl);
        if (lllllllllllllllllllIlllIIIIIIllI == null) {
            return PlayerInfoHelper.register(lllllllllllllllllllIlllIIIIIIlIl);
        }
        return lllllllllllllllllllIlllIIIIIIllI;
    }
}

