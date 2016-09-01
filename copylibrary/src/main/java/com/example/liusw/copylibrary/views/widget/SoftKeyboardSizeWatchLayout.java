package com.example.liusw.copylibrary.views.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liusw on 2016/9/1.
 */
public class SoftKeyboardSizeWatchLayout extends RelativeLayout
{
    private Context mContext;
    private int mOldh = -1;
    private int mNowh = -1;
    protected int mScreenHeight = 0;
    protected boolean mIsSoftKeyboardPop = false;
    private List<OnResizeListener> mListenerList;
    public SoftKeyboardSizeWatchLayout(Context context) {
        super(context);
    }

    public SoftKeyboardSizeWatchLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            @Override
            public void onGlobalLayout() {
                Rect r = new Rect();//画的矩形（120,120, 130,150）
                ((Activity)mContext).getWindow().getDecorView().getWindowVisibleDisplayFrame(r);
                if (mScreenHeight == 0){
                    mScreenHeight = r.bottom;
                }
                mNowh = mScreenHeight - r.bottom;
                if (mOldh != -1 && mNowh != mOldh){
                    if (mNowh>0){
                        mIsSoftKeyboardPop = true;
                        if (mListenerList != null){
                            for (OnResizeListener l:mListenerList){
                                l.OnSoftPop(mNowh);
                            }
                        }
                    }else {
                        mIsSoftKeyboardPop = false;
                        if (mListenerList != null){
                            for (OnResizeListener l:mListenerList){
                                l.OnSoftClose();
                            }
                        }
                    }
                }

                mOldh = mNowh;
            }
        });
    }

    public SoftKeyboardSizeWatchLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SoftKeyboardSizeWatchLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public boolean ismIsSoftKeyboardPop(){
        return mIsSoftKeyboardPop;
    }

    public void addOnResizeListener(OnResizeListener l){
        if (mListenerList == null){
            mListenerList = new ArrayList<>();
        }
        mListenerList.add(l);
    }

    public interface OnResizeListener{
        /**
         * 软键盘弹起
         */
        void OnSoftPop(int height);

        /**
         * 软键盘关闭
         */
        void OnSoftClose();
    }

}
