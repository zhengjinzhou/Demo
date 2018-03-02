package zhou.com.demo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zhou on 2018/2/27.
 * Viewpager与TabLayout
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> titles;
    public MyViewPagerAdapter(FragmentManager fm, List<String> titles, List<Fragment> fragments) {
        super(fm);
        this.titles = titles;
        this.fragments = fragments;
    }

    @Override

    public int getCount() {
        //fragment数量(总页数)
        return fragments.size();
    }
    @Override

    public Fragment getItem(int position) {
        //每一页fragment
        return fragments.get(position);
    }

    @Override

    public CharSequence getPageTitle(int position) {
        // 每一页对应标签
        return titles.get(position);
    }

}
