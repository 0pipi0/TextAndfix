package com.martian.andfix.base;

import android.app.Application;
import android.os.Environment;
import com.alipay.euler.andfix.patch.PatchManager;
import com.martian.andfix.util.AppInfoUtil;
import java.io.IOException;

/**
 * @author martian on 2017/12/26.
 */

public class MyApplication extends Application {

  private static final String APATCH_PACH = "/fix.apatch";

  private  PatchManager mPatchManager;

  private static MyApplication instance;

  public static MyApplication getInstance() {
    return instance;
  }

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    initAndfix();
  }

  /**
   * 初始化Andfix
   */
  private void initAndfix() {
    // 初始化patch管理类
    mPatchManager = new PatchManager(this);
    // 初始化patch版本
    mPatchManager.init(String.valueOf(AppInfoUtil.getVersionCode(this)));
    mPatchManager.loadPatch();

  }


  public void addPatch(){
    try {
      String patchFileString = Environment.getExternalStorageDirectory().getAbsolutePath()+APATCH_PACH;
      mPatchManager.addPatch(patchFileString);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public  PatchManager  getPatchManager(){
    if(mPatchManager == null){
      mPatchManager = new PatchManager(this);
    }
    return mPatchManager;
  }
}
