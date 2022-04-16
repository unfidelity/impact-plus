/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonParser
 */
package me.axua.impactplus.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

interface GsonConstant {
    public static final /* synthetic */ Gson GSON_PRETTY;
    public static final /* synthetic */ Gson GSON;
    public static final /* synthetic */ JsonParser PARSER;

    static {
        GSON = new Gson();
        GSON_PRETTY = new GsonBuilder().setPrettyPrinting().create();
        PARSER = new JsonParser();
    }
}

