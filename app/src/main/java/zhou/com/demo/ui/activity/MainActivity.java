package zhou.com.demo.ui.activity;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import zhou.com.demo.R;
import zhou.com.demo.base.App;
import zhou.com.demo.base.BaseActivity;
import zhou.com.demo.base.Constant;
import zhou.com.demo.bean.MainBean;
import zhou.com.demo.commno.OnRvItemClickListener;
import zhou.com.demo.ui.activity.accept.AcceptActivity;
import zhou.com.demo.ui.activity.send.SendActivity;
import zhou.com.demo.ui.adapter.MainAdapter;
import zhou.com.demo.utils.NumUtil;
import zhou.com.demo.utils.ToastUtils;

public class MainActivity extends BaseActivity implements OnRvItemClickListener<MainBean> {

    private static final String TAG = "MainActivity";
    private List<MainBean> mList = new ArrayList<>();
    private MainAdapter mAdapter;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    // 退出时间
    private long currentBackPressedTime = 0;
    // 退出间隔
    private static final int BACK_PRESSED_INTERVAL = 2000;

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void configView() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, mCommonToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));

        mAdapter = new MainAdapter(mContext, mList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void initDatas() {

        mList.clear();
        List<String> mDatas = Arrays.asList(getResources().getStringArray(R.array.main_tab));
        mList.add(new MainBean(mDatas.get(0), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(1), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(2), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(3), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(4), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(5), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(6), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(7), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(8), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(9), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(10), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(11), R.drawable.ic_avatar));
        mList.add(new MainBean(mDatas.get(12), R.drawable.ic_avatar));
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle("");
        tvHead.setText("水务局移动办公网");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 再按一次退出程序
     *
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - currentBackPressedTime > BACK_PRESSED_INTERVAL) {
                currentBackPressedTime = System.currentTimeMillis();
                ToastUtils.showToast(getString(R.string.exit_tips));
                return true;
            } else {
                finish();
            }
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            final AlertDialog dialog = builder.create();
            View inflate = getLayoutInflater().inflate(R.layout.dialog_exit, null);
            dialog.setView(inflate,0,0,0,0);
            dialog.show();
            inflate.findViewById(R.id.tvSure).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    dialog.dismiss();
                }
            });
            inflate.findViewById(R.id.tvCancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(View view, int position, MainBean data) {
        switch (position){
            case 0:
                startToActivity(AcceptActivity.class);
                break;
            case 1:
                startToActivity(SendActivity.class);
                break;
            case 2:
                ToastUtils.showToast("3");
                break;
            case 3:
                ToastUtils.showToast("4");
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
        }
    }
}
