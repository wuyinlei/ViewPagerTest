package com.example.viewpagertest;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wuyinlei on 2015/12/9.
 */
public class MyPagerApapter extends PagerAdapter {

    /**
     * 继承PagerAdapter必须实现以下的四个方法
     */
    public List<View> mListViews;

    public MyPagerApapter(List<View> mListViews) {
        this.mListViews = mListViews;
    }

    /**
     *
     * Remove a page for the given position. The adapter is responsible for
     * removing the view from its container,
     * although it only must ensure this is done by the time it returns from finishUpdate(View).
     * 移除给定位置的数据，适配器负责从container（容器）中取出，但是这个必须保证是在finishUpdate（view）
     * 返回的时间内完成
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mListViews.get(position));
    }

    /**
     * Return the number of views available.
     * 返回一个可以用的view的个数
     * @return
     */
    @Override
    public int getCount() {
        return mListViews.size();
    }

    /**
     * Create the page for the given position. The adapter is responsible for
     * adding the view to the container given here,
     * although it only must ensure this is done by the time it returns from finishUpdate(ViewGroup).
     * 这个同destroyItem（）相反，是对于给定的位置创建视图，适配器往container中添加
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mListViews.get(position));
        return mListViews.get(position);
    }

    /**
     * Determines whether a page View is associated with a specific key object as returned by
     * instantiateItem(ViewGroup, int). This method is required for
     * a PagerAdapter to function properly.
     * 确定是否一个页面视图中所返回的instantiateItem（ViewGroup中，INT）
     * 与特定键对象相关联。此方法需要一个PagerAdapter才能正常工作。
     * @param view
     * @param object
     * @return
     */

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
