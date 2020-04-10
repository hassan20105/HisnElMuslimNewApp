package com.hisnElMuslem.myapplication.Utilities;

import android.content.SharedPreferences;

public class SharedPrefrenceUtilities {
    public static String MyPREFERENCES = "shared-pref";
    public static String vibrateValue = "vibrateVale";
    public static String soundValue = "soundValue";
    public static boolean isSharedDataFound(SharedPreferences sharedPref) {
        if (sharedPref != null)
            return true;
        else
            return false;
    }
}
