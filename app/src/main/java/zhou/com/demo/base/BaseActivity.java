package zhou.com.demo.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.ButterKnife;
import zhou.com.demo.R;
import zhou.com.demo.view.LoadDialog;

/**
 * Created by zhou on 2018/2/26.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public Toolbar mCommonToolbar;
    public TextView tvHead;
    public abstract int getLayout();
    public abstract void configView();
    public abstract void initDatas();
    public abstract void initToolBar();
    protected Context mContext;
    protected LoadDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mContext = this;
        ButterKnife.bind(this);
        dialog = new LoadDialog(this,false,getString(R.string.loading));
        mCommonToolbar = ButterKnife.findById(this, R.id.toolbar);
        tvHead = ButterKnife.findById(this,R.id.tvHead);
        if (mCommonToolbar != null) {
            initToolBar();
            setSupportActionBar(mCommonToolbar);
        }
        initDatas();
        configView();
    }

    public void startToActivity(Class cla){
        Intent intent = new Intent(mContext, cla);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
