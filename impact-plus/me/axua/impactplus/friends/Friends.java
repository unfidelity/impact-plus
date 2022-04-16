/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.friends;

import java.util.ArrayList;
import java.util.List;
import me.axua.impactplus.friends.Friend;

public class Friends {
    public static /* synthetic */ List<Friend> friends;

    public void delFriend(String llllllllllllllllIlIIllIllIlIIIII) {
        Friends llllllllllllllllIlIIllIllIlIIIll;
        friends.remove(llllllllllllllllIlIIllIllIlIIIll.getFriendByName(llllllllllllllllIlIIllIllIlIIIII));
    }

    public static List<Friend> getFriends() {
        return friends;
    }

    public static boolean isFriend(String llllllllllllllllIlIIllIllIlllIIl) {
        boolean llllllllllllllllIlIIllIllIlllIlI = false;
        for (Friend llllllllllllllllIlIIllIllIllllII : Friends.getFriends()) {
            if (!llllllllllllllllIlIIllIllIllllII.getName().equalsIgnoreCase(llllllllllllllllIlIIllIllIlllIIl)) continue;
            llllllllllllllllIlIIllIllIlllIlI = true;
        }
        return llllllllllllllllIlIIllIllIlllIlI;
    }

    public void addFriend(String llllllllllllllllIlIIllIllIlIIlll) {
        friends.add(new Friend(llllllllllllllllIlIIllIllIlIIlll));
    }

    public Friends() {
        Friends llllllllllllllllIlIIllIlllIIIIIl;
        friends = new ArrayList<Friend>();
    }

    public Friend getFriendByName(String llllllllllllllllIlIIllIllIlIllll) {
        Friend llllllllllllllllIlIIllIllIlIlllI = null;
        for (Friend llllllllllllllllIlIIllIllIllIIIl : Friends.getFriends()) {
            if (!llllllllllllllllIlIIllIllIllIIIl.getName().equalsIgnoreCase(llllllllllllllllIlIIllIllIlIllll)) continue;
            llllllllllllllllIlIIllIllIlIlllI = llllllllllllllllIlIIllIllIllIIIl;
        }
        return llllllllllllllllIlIIllIllIlIlllI;
    }
}

