package com.xuewenhui.hotfix;

import android.app.Application;

import com.alipay.euler.andfix.patch.PatchManager;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：17.8.31 19:33
 */
public class AndFixApplication extends Application {
    public static PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        AndfixPatchManager.getInstance().initPatch(this);
    }
}
