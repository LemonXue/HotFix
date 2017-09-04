package com.xuewenhui.hotfix;

import android.content.Context;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：17.8.31 20:25
 */
public class AndfixPatchManager {
    private volatile static AndfixPatchManager instance;
    private  PatchManager patchManager;

    private AndfixPatchManager() {

    }

    public static AndfixPatchManager getInstance() {
        if (null == instance) {
            synchronized (PatchManager.class) {
                if (instance == null) {
                    instance = new AndfixPatchManager();
                }
            }
        }
        return instance;
    }

    public void initPatch(Context context) {
        patchManager = new PatchManager(context);
        patchManager.init(VersionUtils.getVersionName(context));//version的版本
        patchManager.loadPatch();

    }

    public void addPatch(String path) {
        try {
            if (patchManager != null) {
                patchManager.addPatch(path);
                Log.i(TAG, "patchManager: success");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
