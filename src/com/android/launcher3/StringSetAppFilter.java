package com.android.launcher3;

import android.content.Context;
import android.preference.PreferenceManager;

import java.util.Set;

public class StringSetAppFilter implements AppFilter {

    @Override
    public boolean shouldShowApp(String packageName, Context context, boolean isWidgetPanel) {
        Set<String> hiddenApps = PreferenceManager.getDefaultSharedPreferences(context).getStringSet(Utilities.KEY_HIDDEN_APPS_SET, null);

        if (isWidgetPanel) {
            return !mBlackList.contains(packageName);
        }
        return !mBlackList.contains(packageName) && (hiddenApps == null || !hiddenApps.contains(packageName));
    }
}
