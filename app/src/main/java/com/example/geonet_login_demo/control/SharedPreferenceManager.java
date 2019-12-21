package com.example.geonet_login_demo.control;

import android.content.Context;

import com.example.geonet_login_demo.R;

public class SharedPreferenceManager {
    private static String LoggedInUserID = "LoggedInUserID";

    private static String readPreference(Context context, String preferenceName) {
        return context.getSharedPreferences(context.getResources().getString(R.string.app_name), Context.MODE_PRIVATE).getString(preferenceName, "");
    }

    private static void writePreference(Context context, String preferenceName, String value) {
        context.getSharedPreferences(context.getResources().getString(R.string.app_name), Context.MODE_PRIVATE).edit().putString(preferenceName, value).apply();
    }

    public static boolean isLoggedIn(Context context) {
        return !String.valueOf(readPreference(context, LoggedInUserID)).equalsIgnoreCase("");
    }

    public static void setLoggedInUserID(Context context, String userID) {
        writePreference(context, LoggedInUserID, userID);
    }

    public static String getLoggedInUserID(Context context) {
        return readPreference(context, LoggedInUserID);
    }

}
