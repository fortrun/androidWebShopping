package com.lava.music.ui.base;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.google.gson.JsonArray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private final String TAG = CrashHandler.class.getSimpleName();
    private Thread.UncaughtExceptionHandler mDefaultCrashHandler;

    private static CrashHandler mInstance;

    private SimpleDateFormat format;

    private StringBuilder mVersionInfo;

    private Context mAppContext;

    public static synchronized CrashHandler getInstance() {
        if (mInstance == null) {
            mInstance = new CrashHandler();
        }
        return mInstance;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if(!handleException(e) && mDefaultCrashHandler != null){
            mDefaultCrashHandler.uncaughtException(t, e);
        } else {
            try {
                Thread.sleep(3* 1000);
            } catch ( InterruptedException ex){
                Log.e(TAG, "crash erro: ", ex);
            }
        }
    }

    public void init(Context ctx){
        mAppContext = ctx;

        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        // init this when initial
        mVersionInfo = new StringBuilder();
        collectDeviceInfo(ctx);

        format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    }

    private String getStackStr(Throwable ex) {
        Writer w = new StringWriter();
        PrintWriter printWriter = new PrintWriter(w);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause !=null){
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        return w.toString();
    }

    private boolean handleException(Throwable ex) {
        if(ex == null) return false;
        addCustomInfo();
        String file = saveEX2File(ex);
        return file != null;
    }

    private String saveEX2File(Throwable ex) {
        StringBuilder sb = new StringBuilder();
        sb.append(mVersionInfo);
        sb.append(getStackStr(ex));
        // @Todo permission check of writhe file
        try {
            long timeStamp = System.currentTimeMillis();
            String time = format.format(new Date());
            String fileName = "crash-"+time+"-"+timeStamp+".log";
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/crash/";
                File dir = new File(path);
                if(!dir.exists()){
                    dir.mkdir();
                }
                OutputStream os = new FileOutputStream(path+fileName);
                os.write(sb.toString().getBytes());
                os.close();
            }
            return fileName;
        } catch (IOException e){

        }
        return null;
    }

    private void collectDeviceInfo(Context ctx){
        try {
            PackageManager pkm = ctx.getPackageManager();
            PackageInfo packageInfo = pkm.getPackageInfo(ctx.getPackageName(),
                    PackageManager.GET_ACTIVITIES);
            if(packageInfo != null){
                String version = packageInfo.versionName;
                String version_code = packageInfo.versionCode + "";
                JsonArray jsonArray = new JsonArray();
                jsonArray.add("versioName");
                jsonArray.add( version);
                jsonArray.add("versionCode");
                jsonArray.add(version_code);
                mVersionInfo.append(jsonArray.toString());
                mVersionInfo.append("\n");
            }
        } catch (PackageManager.NameNotFoundException e){
            Log.e(TAG, "error in crash handle when get package info", e);
        }
        Field[] fields = Build.class.getDeclaredFields();
        for (Field field : fields) {
            try{
                field.setAccessible(true);
                mVersionInfo.append(field.getName()).append(field.get(null).toString());
                mVersionInfo.append("\n");
            } catch (IllegalAccessException e){
                Log.e(TAG, "an error occured when collect crash info", e);
            }
        }
    }

    private void addCustomInfo(){
        Log.i(TAG, "addCustomInfo ,app is crashed");
    }
}
