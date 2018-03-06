package zhou.com.demo.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuyh.easyadapter.glide.GlideRoundTransform;
import com.yuyh.easyadapter.recyclerview.EasyRVAdapter;
import com.yuyh.easyadapter.recyclerview.EasyRVHolder;

import java.io.IOException;
import java.util.List;
import java.util.logging.Handler;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zhou.com.demo.R;
import zhou.com.demo.base.App;
import zhou.com.demo.base.Constant;
import zhou.com.demo.bean.MainBean;
import zhou.com.demo.commno.OnRvItemClickListener;
import zhou.com.demo.utils.NumUtil;
import zhou.com.demo.utils.SharedPreferencesUtil;

/**
 * Created by zhou on 2018/2/26.
 */

public class MainAdapter extends EasyRVAdapter<MainBean>{

    private OnRvItemClickListener itemClickListener;

    public MainAdapter(Context context, List<MainBean> list,OnRvItemClickListener listener) {
        super(context, list, R.layout.item_main);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder holder, final int position, final MainBean item) {
        TextView text = holder.getView(R.id.tvNum);

        holder.setText(R.id.tvName, item.getName());
        ImageView ivIcon = holder.getView(R.id.ivIcon);
        Glide.with(mContext).load(item.getIcon()).transform(new GlideRoundTransform(mContext,5)).into(ivIcon);
        holder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(holder.getItemView(), position, item);
            }
        });
        if (position==0 && !SharedPreferencesUtil.getInstance().getString("GetSWHandleNum").equals("0")){
            text.setVisibility(View.VISIBLE);
            text.setText(SharedPreferencesUtil.getInstance().getString("GetSWHandleNum"));
        }

    }
}
