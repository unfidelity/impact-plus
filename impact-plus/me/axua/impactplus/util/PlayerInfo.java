/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.Lists
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 */
package me.axua.impactplus.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import me.axua.impactplus.util.GsonConstant;
import me.axua.impactplus.util.PlayerInfoHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class PlayerInfo
implements GsonConstant {
    private final /* synthetic */ UUID id;
    private final /* synthetic */ UUID offlineId;
    private final /* synthetic */ boolean isOfflinePlayer;
    private final /* synthetic */ List<Name> names;

    public boolean isLocalPlayer() {
        PlayerInfo llllllllllllllllllllIIllllIllllI;
        return String.CASE_INSENSITIVE_ORDER.compare(llllllllllllllllllllIIllllIllllI.getName(), Minecraft.getMinecraft().thePlayer.getName()) == 0;
    }

    public String getNameHistoryAsString() {
        PlayerInfo llllllllllllllllllllIIlllllllIIl;
        StringBuilder llllllllllllllllllllIIllllllllII = new StringBuilder();
        if (!llllllllllllllllllllIIlllllllIIl.names.isEmpty()) {
            Iterator<Name> llllllllllllllllllllIlIIIIIIIIIl = llllllllllllllllllllIIlllllllIIl.names.iterator();
            llllllllllllllllllllIlIIIIIIIIIl.next();
            while (llllllllllllllllllllIlIIIIIIIIIl.hasNext()) {
                Name llllllllllllllllllllIlIIIIIIIIll = llllllllllllllllllllIlIIIIIIIIIl.next();
                llllllllllllllllllllIIllllllllII.append(llllllllllllllllllllIlIIIIIIIIll.getName());
                if (!llllllllllllllllllllIlIIIIIIIIIl.hasNext()) continue;
                llllllllllllllllllllIIllllllllII.append(", ");
            }
        }
        return String.valueOf(llllllllllllllllllllIIllllllllII);
    }

    public PlayerInfo(String llllllllllllllllllllIlIIIlIIlIlI, boolean llllllllllllllllllllIlIIIlIIlIIl) {
        PlayerInfo llllllllllllllllllllIlIIIlIIlIII;
        llllllllllllllllllllIlIIIlIIlIII.id = EntityPlayerSP.getOfflineUUID((String)llllllllllllllllllllIlIIIlIIlIlI);
        llllllllllllllllllllIlIIIlIIlIII.names = Collections.singletonList(new Name(llllllllllllllllllllIlIIIlIIlIlI));
        llllllllllllllllllllIlIIIlIIlIII.offlineId = llllllllllllllllllllIlIIIlIIlIII.id;
        llllllllllllllllllllIlIIIlIIlIII.isOfflinePlayer = true;
    }

    public PlayerInfo(String llllllllllllllllllllIlIIIlIlIIlI) throws IOException, NullPointerException {
        PlayerInfo llllllllllllllllllllIlIIIlIlIIll;
        Objects.requireNonNull(llllllllllllllllllllIlIIIlIlIIlI);
        JsonArray llllllllllllllllllllIlIIIlIlIlll = new JsonArray();
        llllllllllllllllllllIlIIIlIlIlll.add(llllllllllllllllllllIlIIIlIlIIlI);
        JsonArray llllllllllllllllllllIlIIIlIlIllI = PlayerInfo.getResources(new URL("https://api.mojang.com/profiles/minecraft"), "POST", (JsonElement)llllllllllllllllllllIlIIIlIlIlll).getAsJsonArray();
        JsonObject llllllllllllllllllllIlIIIlIlIlIl = llllllllllllllllllllIlIIIlIlIllI.get(0).getAsJsonObject();
        UUID llllllllllllllllllllIlIIIlIlIlII = PlayerInfoHelper.getIdFromString(llllllllllllllllllllIlIIIlIlIlIl.get("id").getAsString());
        Objects.requireNonNull(llllllllllllllllllllIlIIIlIlIlII);
        llllllllllllllllllllIlIIIlIlIIll.id = llllllllllllllllllllIlIIIlIlIlII;
        llllllllllllllllllllIlIIIlIlIIll.names = ImmutableList.copyOf(PlayerInfo.lookupNames(llllllllllllllllllllIlIIIlIlIlII));
        llllllllllllllllllllIlIIIlIlIIll.offlineId = EntityPlayerSP.getOfflineUUID((String)llllllllllllllllllllIlIIIlIlIIlI);
        llllllllllllllllllllIlIIIlIlIIll.isOfflinePlayer = false;
    }

    public String toString() {
        PlayerInfo llllllllllllllllllllIIlllIlIlIll;
        return llllllllllllllllllllIIlllIlIlIll.id.toString();
    }

    public boolean equals(Object llllllllllllllllllllIIlllIllllII) {
        PlayerInfo llllllllllllllllllllIIlllIllllll;
        return llllllllllllllllllllIIlllIllllII instanceof PlayerInfo && llllllllllllllllllllIIlllIllllll.id.equals(((PlayerInfo)llllllllllllllllllllIIlllIllllII).id);
    }

    public int hashCode() {
        PlayerInfo llllllllllllllllllllIIlllIlIllIl;
        return llllllllllllllllllllIIlllIlIllIl.id.hashCode();
    }

    public UUID getOfflineId() {
        PlayerInfo llllllllllllllllllllIlIIIIlIlIll;
        return llllllllllllllllllllIlIIIIlIlIll.offlineId;
    }

    public UUID getId() {
        PlayerInfo llllllllllllllllllllIlIIIIlIlllI;
        return llllllllllllllllllllIlIIIIlIlllI.id;
    }

    public boolean isOfflinePlayer() {
        PlayerInfo llllllllllllllllllllIlIIIIlIIlll;
        return llllllllllllllllllllIlIIIIlIIlll.isOfflinePlayer;
    }

    public String getName() {
        PlayerInfo llllllllllllllllllllIlIIIIlIIlII;
        if (!llllllllllllllllllllIlIIIIlIIlII.names.isEmpty()) {
            return llllllllllllllllllllIlIIIIlIIlII.names.get(0).getName();
        }
        return null;
    }

    public boolean matches(UUID llllllllllllllllllllIIllllIlIIlI) {
        PlayerInfo llllllllllllllllllllIIllllIlIIll;
        return llllllllllllllllllllIIllllIlIIlI != null && (llllllllllllllllllllIIllllIlIIlI.equals(llllllllllllllllllllIIllllIlIIll.getOfflineId()) || llllllllllllllllllllIIllllIlIIlI.equals(llllllllllllllllllllIIllllIlIIll.getId()));
    }

    public List<Name> getNameHistory() {
        PlayerInfo llllllllllllllllllllIlIIIIlIIIlI;
        return llllllllllllllllllllIlIIIIlIIIlI.names;
    }

    private static JsonElement getResources(URL llllllllllllllllllllIIllIIIlIlIl, String llllllllllllllllllllIIllIIIlIllI) throws IOException {
        return PlayerInfo.getResources(llllllllllllllllllllIIllIIIlIlIl, llllllllllllllllllllIIllIIIlIllI, null);
    }

    private static List<Name> lookupNames(UUID llllllllllllllllllllIlIIIIlllIlI) throws IOException {
        JsonArray llllllllllllllllllllIlIIIIlllIIl = PlayerInfo.getResources(new URL(String.valueOf(new StringBuilder().append("https://api.mojang.com/user/profiles/").append(PlayerInfoHelper.getIdNoHyphens(llllllllllllllllllllIlIIIIlllIlI)).append("/names"))), "GET").getAsJsonArray();
        ArrayList llllllllllllllllllllIlIIIIlllIII = Lists.newArrayList();
        for (JsonElement llllllllllllllllllllIlIIIIlllIll : llllllllllllllllllllIlIIIIlllIIl) {
            JsonObject llllllllllllllllllllIlIIIIlllllI = llllllllllllllllllllIlIIIIlllIll.getAsJsonObject();
            String llllllllllllllllllllIlIIIIllllIl = llllllllllllllllllllIlIIIIlllllI.get("name").getAsString();
            long llllllllllllllllllllIlIIIIllllII = llllllllllllllllllllIlIIIIlllllI.has("changedToAt") ? llllllllllllllllllllIlIIIIlllllI.get("changedToAt").getAsLong() : 0L;
            llllllllllllllllllllIlIIIIlllIII.add(new Name(llllllllllllllllllllIlIIIIllllIl, llllllllllllllllllllIlIIIIllllII));
        }
        Collections.sort(llllllllllllllllllllIlIIIIlllIII);
        return llllllllllllllllllllIlIIIIlllIII;
    }

    public PlayerInfo(UUID llllllllllllllllllllIlIIIllIIIlI) throws IOException {
        PlayerInfo llllllllllllllllllllIlIIIllIIIIl;
        Objects.requireNonNull(llllllllllllllllllllIlIIIllIIIlI);
        llllllllllllllllllllIlIIIllIIIIl.id = llllllllllllllllllllIlIIIllIIIlI;
        llllllllllllllllllllIlIIIllIIIIl.names = ImmutableList.copyOf(PlayerInfo.lookupNames(llllllllllllllllllllIlIIIllIIIlI));
        llllllllllllllllllllIlIIIllIIIIl.offlineId = EntityPlayerSP.getOfflineUUID((String)llllllllllllllllllllIlIIIllIIIIl.getName());
        llllllllllllllllllllIlIIIllIIIIl.isOfflinePlayer = false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * WARNING - void declaration
     */
    private static JsonElement getResources(URL llllllllllllllllllllIIllIlIIllIl, String llllllllllllllllllllIIllIlIIllII, JsonElement llllllllllllllllllllIIllIlIIIllI) throws IOException {
        void llllllllllllllllllllIIllIlIIlIlI;
        HttpsURLConnection llllllllllllllllllllIIllIlIIlIIl = null;
        try {
            llllllllllllllllllllIIllIlIIlIIl = (HttpsURLConnection)llllllllllllllllllllIIllIlIIllIl.openConnection();
            llllllllllllllllllllIIllIlIIlIIl.setDoOutput(true);
            llllllllllllllllllllIIllIlIIlIIl.setRequestMethod(llllllllllllllllllllIIllIlIIllII);
            llllllllllllllllllllIIllIlIIlIIl.setRequestProperty("Content-Type", "application/json");
            if (llllllllllllllllllllIIllIlIIIllI != null) {
                DataOutputStream llllllllllllllllllllIIllIlIllIIl = new DataOutputStream(llllllllllllllllllllIIllIlIIlIIl.getOutputStream());
                llllllllllllllllllllIIllIlIllIIl.writeBytes(GSON.toJson(llllllllllllllllllllIIllIlIIIllI));
                llllllllllllllllllllIIllIlIllIIl.close();
            }
            Scanner llllllllllllllllllllIIllIlIlIllI = new Scanner(llllllllllllllllllllIIllIlIIlIIl.getInputStream());
            StringBuilder llllllllllllllllllllIIllIlIlIIll = new StringBuilder();
            while (llllllllllllllllllllIIllIlIlIllI.hasNextLine()) {
                llllllllllllllllllllIIllIlIlIIll.append(llllllllllllllllllllIIllIlIlIllI.nextLine());
                llllllllllllllllllllIIllIlIlIIll.append('\n');
            }
            llllllllllllllllllllIIllIlIlIllI.close();
            String llllllllllllllllllllIIllIlIlIIIl = String.valueOf(llllllllllllllllllllIIllIlIlIIll);
            JsonElement llllllllllllllllllllIIllIlIIllll = PARSER.parse(llllllllllllllllllllIIllIlIlIIIl);
        }
        finally {
            if (llllllllllllllllllllIIllIlIIlIIl != null) {
                llllllllllllllllllllIIllIlIIlIIl.disconnect();
            }
        }
        return llllllllllllllllllllIIllIlIIlIlI;
    }

    public static class Name
    implements Comparable<Name> {
        private final /* synthetic */ long changedAt;
        private final /* synthetic */ String name;

        public String getName() {
            Name llllllllllllllllIIllIllllIIIIllI;
            return llllllllllllllllIIllIllllIIIIllI.name;
        }

        public Name(String llllllllllllllllIIllIllllIIIlIIl) {
            llllllllllllllllIIllIllllIIIllII(llllllllllllllllIIllIllllIIIlIIl, 0L);
            Name llllllllllllllllIIllIllllIIIllII;
        }

        public Name(String llllllllllllllllIIllIllllIIlIIll, long llllllllllllllllIIllIllllIIlIIlI) {
            Name llllllllllllllllIIllIllllIIlIlII;
            llllllllllllllllIIllIllllIIlIlII.name = llllllllllllllllIIllIllllIIlIIll;
            llllllllllllllllIIllIllllIIlIlII.changedAt = llllllllllllllllIIllIllllIIlIIlI;
        }

        public boolean equals(Object llllllllllllllllIIllIlllIllllIIl) {
            Name llllllllllllllllIIllIlllIllllIII;
            return llllllllllllllllIIllIlllIllllIIl instanceof Name && llllllllllllllllIIllIlllIllllIII.name.equalsIgnoreCase(((Name)llllllllllllllllIIllIlllIllllIIl).getName()) && llllllllllllllllIIllIlllIllllIII.changedAt == ((Name)llllllllllllllllIIllIlllIllllIIl).changedAt;
        }

        public long getTimeChanged() {
            Name llllllllllllllllIIllIllllIIIIlII;
            return llllllllllllllllIIllIllllIIIIlII.changedAt;
        }

        @Override
        public int compareTo(Name llllllllllllllllIIllIlllIlllllIl) {
            Name llllllllllllllllIIllIlllIllllllI;
            return Long.compare(llllllllllllllllIIllIlllIlllllIl.changedAt, llllllllllllllllIIllIlllIllllllI.changedAt);
        }

        public int hashCode() {
            Name llllllllllllllllIIllIlllIlllIlIl;
            return Objects.hash(llllllllllllllllIIllIlllIlllIlIl.name, llllllllllllllllIIllIlllIlllIlIl.changedAt);
        }
    }
}

