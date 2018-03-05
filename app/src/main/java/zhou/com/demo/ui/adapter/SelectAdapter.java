package zhou.com.demo.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import zhou.com.demo.R;
import zhou.com.demo.bean.KSUserBean;
import zhou.com.demo.bean.QZDWKSList;
import zhou.com.demo.commno.OnRvItemClickListener;

/**
 * Created by zhou on 2018/3/5.
 */

public class SelectAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private LayoutInflater inflater;

    private List<QZDWKSList.DatasBean> groupArray;
    private List<List<KSUserBean>> childArray;
    private OnRvItemClickListener<QZDWKSList.DatasBean> listener;

    public SelectAdapter(Context context, List<QZDWKSList.DatasBean> groupArray, List<List<KSUserBean>> childArray) {
        this.childArray = childArray;
        this.groupArray = groupArray;
        mContext = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return groupArray.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childArray.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupArray.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childArray.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, final boolean isExpanded, View convertView, ViewGroup parent) {
        final View group = inflater.inflate(R.layout.recycler_select, null);
        final ImageView ivArrow = group.findViewById(R.id.iv);
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClick(group, groupPosition, groupArray.get(groupPosition));
                    if (isExpanded) {
                        ivArrow.setImageResource(R.drawable.next);
                    } else {
                        ivArrow.setImageResource(R.drawable.bottom);
                    }
                }
            }
        });
        TextView tvName = group.findViewById(R.id.tvKSName);
        tvName.setText(groupArray.get(groupPosition).getKSName());
        return group;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final View child = inflater.inflate(R.layout.recycler_select_info_detail, null);

        TextView tvName = child.findViewById(R.id.tvName);
        tvName.setText(childArray.get(groupPosition).get(childPosition).getUserName());
        return child;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public void setItemClickListener(OnRvItemClickListener<QZDWKSList.DatasBean> listener) {
        this.listener = listener;
    }

}
