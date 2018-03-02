package zhou.com.demo.ui.activity.send;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.demo.R;
import zhou.com.demo.base.BaseActivity;
import zhou.com.demo.ui.adapter.MyViewPagerAdapter;
import zhou.com.demo.ui.fragment.send.SendAllFragment;
import zhou.com.demo.ui.fragment.send.SendNeedFragment;
import zhou.com.demo.ui.fragment.send.SendPreviewFragment;
import zhou.com.demo.ui.fragment.send.SendedFragment;

public class SendActivity extends BaseActivity implements TabLayout.OnTabSelectedListener{

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
        mDatas = Arrays.asList(getResources().getStringArray(R.array.send_tab));
        mTabContents = new ArrayList<>();
        for (int i=0;i<mDatas.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(mDatas.get(i)));
        }
        tabLayout.setOnTabSelectedListener(this);
        mTabContents.add(new SendNeedFragment());
        mTabContents.add(new SendedFragment());
        mTabContents.add(new SendAllFragment());
        mTabContents.add(new SendPreviewFragment());
        mAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), mDatas, mTabContents);
        //ViewPager设置适配器
        viewPager.setAdapter(mAdapter);
        //TabLayout与ViewPager建立关联
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle("");
        mCommonToolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ab_back));
        tvHead.setText("发文办理");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.send_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_send:
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
