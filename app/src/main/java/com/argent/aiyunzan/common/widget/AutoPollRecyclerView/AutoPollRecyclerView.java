package com.argent.aiyunzan.common.widget.AutoPollRecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

import java.lang.ref.WeakReference;

/**
 * @author
 * @description: 广告recyclerView
 * @date :
 */
public class AutoPollRecyclerView extends RecyclerView {
    private static final long TIME_AUTO_POLL = 50;//速度越大越慢
    AutoPollTask autoPollTask;
    private boolean running; //表示是否正在自动轮询
    private boolean canRun;//表示是否可以自动轮询

    public AutoPollRecyclerView(Context context,AttributeSet attrs) {
        super(context, attrs);
        autoPollTask = new AutoPollTask(this);
    }

    static class AutoPollTask implements Runnable {
        private final WeakReference<AutoPollRecyclerView> mReference;

        //使用弱引用持有外部类引用->防止内存泄漏
        public AutoPollTask(AutoPollRecyclerView reference) {
            this.mReference = new WeakReference<AutoPollRecyclerView>(reference);
        }

        @Override
        public void run() {
            AutoPollRecyclerView recyclerView = mReference.get();
            if (recyclerView != null && recyclerView.running && recyclerView.canRun) {
                recyclerView.scrollBy(2, 2);
                recyclerView.postDelayed(recyclerView.autoPollTask, TIME_AUTO_POLL);
            }
        }
    }

    //开启:如果正在运行,先停止->再开启
    public void start() {
        if (running)
            stop();
        canRun = true;
        running = true;
        postDelayed(autoPollTask, TIME_AUTO_POLL);
    }

    public void stop() {
        running = false;
        removeCallbacks(autoPollTask);
    }


//    @Override
//    public boolean onTouchEvent(MotionEvent e) {
//        switch (e.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                if (running)
//                    stop();
//                break;
//            case MotionEvent.ACTION_UP:
//            case MotionEvent.ACTION_CANCEL:
//            case MotionEvent.ACTION_OUTSIDE:
//                if (canRun)
//                    start();
//                break;
//        }
//        return super.onTouchEvent(e);
//    }


    //去掉上面代码加入下面代码recyclerView不可触摸
    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return true;
    }
}
