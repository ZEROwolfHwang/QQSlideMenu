package com.example.zerow.qqslidemenu;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by ZEROw on 2017/1/5.
 */

public class SlideMenu extends FrameLayout {

    private ViewDragHelper mViewDragHelper;
    private View mMenuView;
    private View mMainView;

    public SlideMenu(Context context) {
        super(context);
        init();
    }

    public SlideMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlideMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public SlideMenu(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    /**
     * 得到子View
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mMainView = getChildAt(0);
        mMenuView = getChildAt(1);

    }

    private void init() {
        mViewDragHelper = ViewDragHelper.create(this, mCallback);

    }

    private ViewDragHelper.Callback mCallback = new ViewDragHelper.Callback() {
        /**
         * 用于判断是否捕获view
         *
         * @param child
         * @param pointerId
         * @return
         */
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return child == mMainView || child == mMenuView;
        }

        @Override
        public void onViewDragStateChanged(int state) {
            super.onViewDragStateChanged(state);
        }

        @Override
        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            super.onViewPositionChanged(changedView, left, top, dx, dy);
        }

        /**抬起时执行的动作
         * @param releasedChild
         * @param xvel
         * @param yvel
         */
        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
        }

        /**水平方向的拖拽范围
         * @param child
         * @return 最好不要返回0
         */
        @Override
        public int getViewHorizontalDragRange(View child) {
            return (int) (getMeasuredWidth()*0.6f);
        }

        /**
         * 控制child在水平方向上的移动
         */
        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return super.clampViewPositionHorizontal(child, left, dx);

        }
    };

}



