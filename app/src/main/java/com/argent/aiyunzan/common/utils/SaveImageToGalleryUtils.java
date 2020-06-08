package com.argent.aiyunzan.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import com.jess.arms.utils.ArmsUtils;

import java.io.File;
import java.io.FileOutputStream;

import static com.argent.aiyunzan.MyApplication.getContext;

/**
 * @author
 * @description: 保存图片
 * @date :
 */
public class SaveImageToGalleryUtils {

    public static void saveImage(Context context, Bitmap bmp) {
        // 首先保存图片 创建文件夹
        File appDir = new File(Environment.getExternalStorageDirectory(), "shy");
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        //图片文件名称
        String fileName = "shy_" + System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        // 其次把文件插入到系统图库
//        String path = file.getAbsolutePath();
//        try {
//            MediaStore.Images.Media.insertImage(context.getContentResolver(), path, fileName, null);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        // 最后通知图库更新
        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri uri = Uri.fromFile(file);
        intent.setData(uri);
        context.sendBroadcast(intent);
        ArmsUtils.makeText(getContext(), "保存成功");
    }

    public static Bitmap capture(Activity activity) {
        activity.getWindow().getDecorView().setDrawingCacheEnabled(true);
        Bitmap bmp = activity.getWindow().getDecorView().getDrawingCache();
        return bmp;
    }
}
