package zhou.com.demo.utils;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zhou.com.demo.base.App;
import zhou.com.demo.base.Constant;
import zhou.com.demo.ui.adapter.MainAdapter;

/**
 * Created by zhou on 2018/3/2.
 */

public class NumUtil {
    public static void setText(final TextView view, String GetSWHandleNum) {
        String activeCode = App.getInstance().getLoginBean().getActiveCode();
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody build = new FormBody.Builder()
                .add("Action", GetSWHandleNum)
                .add("jsonRequest", "{\"ActiveCode\":\"" + activeCode + "\"}")
                .build();
        Request request = new Request.Builder().url(Constant.SW_URL).post(build).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.d("", "onResponse: "+string);
                /*if (!string.equals("0")){
                    view.setText(string);
                }*/
            }
        });
    }
}
