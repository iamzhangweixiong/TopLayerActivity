package com.zhangwx.toplayeractivity;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.os.Build;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * Created by zhang on 2017/5/9.
 */

public class TopLayerUtils {

    public static String getTopLayerActivity(ActivityManager manager) {
        String[] activePackages;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT_WATCH) {
            activePackages = getActivePackages(manager);
        } else {
            activePackages = getActivePackagesCompat(manager);
        }
        return activePackages[0];
    }

    private static String[] getActivePackagesCompat(ActivityManager manager) {
        final List<ActivityManager.RunningTaskInfo> taskInfo = manager.getRunningTasks(1);
        final ComponentName componentName = taskInfo.get(0).topActivity;
        final String[] activePackages = new String[1];
        activePackages[0] = componentName.getPackageName();
        return activePackages;
    }

    private static String[] getActivePackages(ActivityManager manager) {
        final Set<String> activePackages = new HashSet<String>();
        final List<ActivityManager.RunningAppProcessInfo> processInfos = manager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo processInfo : processInfos) {
            if (processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                activePackages.addAll(Arrays.asList(processInfo.pkgList));
            }
        }
        return activePackages.toArray(new String[activePackages.size()]);
    }
}
