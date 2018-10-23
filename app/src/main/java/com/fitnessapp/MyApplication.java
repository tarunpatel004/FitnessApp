package com.fitnessapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

/**
 * Created by abc on 9/26/2017.
 */

public class MyApplication extends MultiDexApplication {
    private static Application _instance;
    private static SharedPreferences _preferences;

    public static Application get() {
        return _instance;
    }

    /**
     * Gets shared preferences.
     *
     * @return the shared preferences
     */
    private static SharedPreferences getSharedPreferences() {
        if (_preferences == null)
            _preferences = PreferenceManager.getDefaultSharedPreferences(_instance);
        return _preferences;
    }

    public static void clearPrefrences() {
        getSharedPreferences().edit().clear().commit();
    }

    /**
     * Sets shared preferences.
     *
     * @return the shared preferences
     */
    public static void setPreferences(String key, String value) {
        getSharedPreferences().edit().putString(key, value).commit();
    }

    public static void setPreferences(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).commit();
    }

    public static void setPreferencesBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).commit();
    }

    public static String getPrefranceData(String key) {
        return getSharedPreferences().getString(key, "");
    }

    public static int getPrefranceDataInt(String key) {
        return getSharedPreferences().getInt(key, -1);
    }

    public static boolean getPrefranceDataBoolean(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

    /**
     * Gets typeface of the FontAwesome
     *
     * @return the typeface
     */
    public static Typeface getTypeface(Context context, String font) {
        return Typeface.createFromAsset(context.getAssets(), font);
    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        try {
            _instance = this;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
