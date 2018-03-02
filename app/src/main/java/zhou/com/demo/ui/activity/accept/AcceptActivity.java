package zhou.com.demo.ui.activity.accept;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.demo.R;
import zhou.com.demo.base.BaseActivity;
import zhou.com.demo.ui.adapter.MyViewPagerAdapter;
import zhou.com.demo.ui.fragment.accept.AcceptFragment;

public class AcceptActivity extends BaseActivity  implements TabLayout.OnTabSelectedListener{

    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.tabLayout) TabLayout tabLayout;
    private List<String> mDatas;
    private List<Fragment> mTabContents;
    private MyViewPagerAdapter mAdapter;

    @Override
    public int getLayout() {
        return R.layout.activity_accept;
    }

    @Override
    public void configView() {

    }

    @Override
    public void initDatas() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.accept_tab));
        mTabContents = new ArrayList<>();
        for (int i=0;i<mDatas.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(mDatas.get(i)));
        }
        tabLayout.setOnTabSelectedListener(this);
        mTabContents.add(AcceptFragment.newInstance("0"));
        mTabContents.add(AcceptFragment.newInstance("2"));
        mTabContents.add(AcceptFragment.newInstance("3"));
        mTabContents.add(AcceptFragment.newInstance("ALL"));
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mDatas, mTabContents);
        //ViewPager设置适配器
        viewPager.setAdapter(mAdapter);
        //TabLayout与ViewPager建立关联
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ab_back));
        mCommonToolbar.setTitle("");
        tvHead.setText("收文办理");
    }

    /**
     * 选择
     * @param position
     */
    public void setCurrentItem(int position) {
        viewPager.setCurrentItem(position);
    }
    /**
     * 显示toolbar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.accept_menu,menu);
        return true;
    }

    /**
     * 为每一个id这是点击功能
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                startToActivity(SearchActivity.class);
                //设置切换动画，从右边进入，左边退出
                overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
                break;
            case R.id.action_more:
                setCurrentItem(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
