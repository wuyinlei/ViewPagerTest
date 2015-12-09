package com.example.viewpagertest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mPager;//页卡内容
    private List<View> listViews; // Tab页面列表
    private TextView t1, t2, t3;// 页卡头标

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTextView();
    }

    private void initTextView(){
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        t1.setOnClickListener(new MyOnClickListener(0));
        t2.setOnClickListener(new MyOnClickListener(1));
        t3.setOnClickListener(new MyOnClickListener(2));
    }


    /**
     * 初始化各种控件
     */
    private void initView(){
        mPager = (ViewPager) findViewById(R.id.viewPager);


        listViews = new ArrayList<>();
        LayoutInflater inflater = getLayoutInflater();
        listViews.add(inflater.inflate(R.layout.fragment_first,null));
        listViews.add(inflater.inflate(R.layout.fragment_second,null));
        listViews.add(inflater.inflate(R.layout.fragment_third,null));
        mPager.setAdapter(new MyPagerApapter(listViews));
        mPager.setCurrentItem(0);  //设置显示的是第几个view
        mPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    /**
     * 自定义的一个点击监听实现
     * Callback interface for responding to changing state of the selected page.
     * 回调接口，用于应对不断变化的所选页面的状态。
     */
    private static class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {



        /**
         * This method will be invoked when the current page is scrolled, either as part
         * of a programmatically initiated smooth scroll or a user initiated touch scroll.
         * 当页面滚动时该方法将被调用。
         * @param position    Position index of the first page currently being d
         *                    isplayed. Page position+1 will be visible
         *                    if positionOffset is nonzero.
         *                    当前正在显示的第一页的位置的索引。页面位置+1将是可见的，如果positionOffset非零。
         *
         * @param positionOffset     Value from [0, 1) indicating the offset from the page at position.
         *                           表示从[0，1）的值从在位置上的页的偏移量。
         * @param positionOffsetPixels     Value in pixels indicating the offset from position.
         *                                 以像素为单位，表示从位置偏移值。
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        /**
         * This method will be invoked when a new page becomes selected. Animation is not necessarily complete.
         * 当一个新的页面选择，这种方法将被调用。
         * @param position     Position index of the new selected page.
         *                            新选定的页面位置索引。
         */
        @Override
        public void onPageSelected(int position) {

        }

        /**
         * Called when the scroll state changes. Useful for discovering when the user begins dragging,
         * when the pager is automatically settling to the current page, or when it is fully stopped/idle.
         * 滚动状态，当夜面滚动的时候调用，当是当前页可见或者完全消失
         * @param state    The new scroll state.    新的滚动状态
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    private class MyOnClickListener implements View.OnClickListener {

        private int index = 0;
        public MyOnClickListener(int size){
            index = size;
        }
        @Override
        public void onClick(View v) {
            mPager.setCurrentItem(index);
        }
    }
}
