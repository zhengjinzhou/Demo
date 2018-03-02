package zhou.com.demo.ui.activity.accept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import zhou.com.demo.R;
import zhou.com.demo.base.BaseActivity;

public class SearchActivity extends BaseActivity {

    @Override
    public int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void configView() {

    }

    @Override
    public void initDatas() {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onBackPressed() {
        Log.d("", "onBackPressed: ");
        super.onBackPressed();
        overridePendingTransition(R.anim.xxx,R.anim.yyy);
    }
}
