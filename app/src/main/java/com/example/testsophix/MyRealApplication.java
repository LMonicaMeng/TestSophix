package com.example.testsophix;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

import java.util.ArrayList;
import java.util.List;

public class MyRealApplication extends Application {
    private final String TAG = "MyRealApplication";
    private static MyRealApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //增加tag为设备ID，以便及时修复指定设备的bug
        String  deviceId = null;
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
            deviceId = tm.getDeviceId();
        }
        List<String> tags = new ArrayList<>();
        tags.add(deviceId);
        Log.e(TAG, "initSophix: " + deviceId);
        SophixManager.getInstance().setTags(tags);
    }
}
