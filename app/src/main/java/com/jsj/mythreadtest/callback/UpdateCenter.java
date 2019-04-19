package com.jsj.mythreadtest.callback;

import android.annotation.SuppressLint;
import android.util.Log;

public class UpdateCenter {

    private UpdateContext updateContext;

    public UpdateCenter(UpdateContext updateContext) {
        this.updateContext = updateContext;

        if (updateContext != null) {
//            this.mContext = updateContext.getApplicationContext();
        }
    }

    /**
     * 开始更新文件
     *
     * @param context
     */
    public static void update(UpdateContext context) {
        try {
            if (context != null) {
                Log.i("UpdateCenter", "Update center start execute");
                UpdateCenter updateCenter = new UpdateCenter(context);
                updateCenter.run();
            }
        } catch (Exception e) {
            Log.e("UpdateCenter", "Update error", e);
        }
    }

    @SuppressLint("DefaultLocale")
    private void run() {
        Log.i("UpdateCenter", "updater request before run ");
        //发起请求前回调，这里可以做更新请求参数
        if (updateContext != null && updateContext.updaterRequestBeforeListener != null) {
            updateContext.updaterRequestBeforeListener.updaterRequestBefore();
            Log.i("UpdateCenter", "updater request before ");
        }
    }

}
