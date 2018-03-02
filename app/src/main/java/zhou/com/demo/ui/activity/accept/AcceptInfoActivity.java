package zhou.com.demo.ui.activity.accept;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.demo.R;
import zhou.com.demo.base.BaseActivity;
import zhou.com.demo.ui.adapter.MyViewPagerAdapter;
import zhou.com.demo.ui.fragment.accept.record.RecordFragment;
import zhou.com.demo.ui.fragment.accept.record.RecordManagerFragment;
import zhou.com.demo.ui.fragment.accept.record.RecordTurnFragment;

public class AcceptInfoActivity extends BaseActivity implements TabLayout.OnTabSelectedListener {

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
        mDatas = Arrays.asList(getResources().getStringArray(R.array.accept_info_tab));
        mTabContents = new ArrayList<>();
        for (int i=0;i<mDatas.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(mDatas.get(i)));
        }
        tabLayout.setOnTabSelectedListener(this);
        mTabContents.add(new RecordManagerFragment());//办理
        mTabContents.add(new RecordFragment());//办理记录
        mTabContents.add(new RecordTurnFragment());//转派记录
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
