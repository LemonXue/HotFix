package com.xuewenhui.hotfix;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 类描述：版本工具类
 * 创建人：yekh
 * 创建时间：17.8.31 20:29
 */
public class VersionUtils {
    public static String getVersionName(Context context) {
        String versionName = "1.0.0";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }
}
