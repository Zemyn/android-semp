package android.mobile.datacvg.semp.MainList;

import android.content.Context;
import android.content.Intent;
import android.mobile.datacvg.semp.MainActivity;
import android.mobile.datacvg.semp.R;
import android.mobile.datacvg.semp.TreeDetail.DetailActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/5/14.
 */
public class IndexListAdapter extends  RecyclerView.Adapter<IndexListAdapter.ListViewHolder>{
    List<IndexRecord> mData = new ArrayList<>();
    Context mContext;

    public IndexListAdapter(List<IndexRecord> dataSet, Context context){
        this.mData = dataSet;
        this.mContext = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_record_item, parent, false);
        ListViewHolder holder = new ListViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        /*deal with item showing stuff and data*/
        IndexRecord i_record = mData.get(position);
        holder.rlt_content.setBackgroundResource(i_record.getJudgeType().getBgStyle());
        holder.txv_name.setText(i_record.getName());
        holder.imv_type.setBackgroundResource(i_record.getJudgeType().getChartTypeBg());
        holder.imv_type.setImageResource(i_record.chartType.getIconId());
        holder.txv_index_data.setText(i_record.dataShow());
        holder.txv_judege.setText(i_record.getJudgeType().getJudge());
    }

    @Override
    public int getItemCount() {
        return mData == null? 0:mData.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout rlt_content;
        TextView txv_name;
        ImageView imv_type;
        ImageView imv_icon;
        TextView txv_judege;
        TextView txv_index_data;

        public ListViewHolder(View itemView) {
            super(itemView);
            rlt_content = (RelativeLayout)itemView.findViewById(R.id.main_list_item_content);
            txv_name = (TextView)itemView.findViewById(R.id.main_list_item_name);
            imv_type = (ImageView)itemView.findViewById(R.id.main_list_item_chart_type);
            txv_index_data = (TextView)itemView.findViewById(R.id.main_list_index_data);
            txv_judege = (TextView)itemView.findViewById(R.id.main_list_item_judge);
            imv_icon = (ImageView)itemView.findViewById(R.id.main_list_item_icon);
            //we need to set item on click listener here, inside the view holder
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //todo
                    Intent int_to_detail = new Intent(mContext,DetailActivity.class);
                    mContext.startActivity(int_to_detail);
                }
            });
        }
    }
}
