package android.mobile.datacvg.semp.TreeDetail;

import android.app.Activity;
import android.mobile.datacvg.semp.Models.ChartType;
import android.mobile.datacvg.semp.TreeDetail.ChartUtils.ChartFactory;
import android.os.Bundle;
import android.mobile.datacvg.semp.R;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lecho.lib.hellocharts.view.AbstractChartView;

public class DetailActivity extends Activity {
    private AbstractChartView mChartView;
    private RelativeLayout rlt_content;
    private ListView mDimensionList;
    private SimpleAdapter mDimensionAdapter;
    private TextView mDescriptionTxv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        rlt_content = (RelativeLayout)findViewById(R.id.rlt_detail_content);

        mDimensionList = (ListView)findViewById(R.id.list_report_summary);
        mDimensionAdapter = new SimpleAdapter(this,
                getInterpretData(getDimensionDefaultData()),
                R.layout.item_dimension,
                new String[]{"value","description"},
                new int[]{R.id.txv_dimension_data,R.id.txv_dimension_description});
        mDimensionList.setAdapter(mDimensionAdapter);

        mDescriptionTxv = (TextView)findViewById(R.id.txv_detail_description);
        mDescriptionTxv.setText("功能描述：eg 扣除成本的指标和企业利润的关系");

        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,600);
        lp.addRule(RelativeLayout.BELOW,R.id.rlt_description_content);
        mChartView = ChartFactory.createChartView(ChartType.line,this, getDefaultData());
        mChartView.setLayoutParams(lp);
        mChartView.setViewportCalculationEnabled(false);
        mChartView.setZoomEnabled(false);
        rlt_content.addView(mChartView);
    }

    private List<Map<String,String>> getInterpretData(List<DetailDimension> dims){
        List<Map<String,String>> itemList = new ArrayList<>();
        for (int i=0; i<dims.size();++i){
            Map<String,String> item = new HashMap<>();
            DetailDimension dim = dims.get(i);
            item.put("value", dim.getValue() + dim.getValueUnit());
            item.put("description", dim.getValueDescription());
            itemList.add(item);
        }
        return itemList;
    }

    private List<ChartRecord> getDefaultData(){
        List<ChartRecord> records = new ArrayList<ChartRecord>();
        for (int i = 0; i < 7; ++i){
            ChartRecord chartRecord = new ChartRecord();
            chartRecord.setIndexId("INDEX_0044");
            chartRecord.setTimeMonth(201500 + i);
            chartRecord.setValueMnt("0.01");
            chartRecord.setIndexData((float) Math.random() * 50f + 5);
            chartRecord.setMntDescription("百分比");
            chartRecord.setValueFmt("###,###.##");
            chartRecord.setValueUnit("%");
            records.add(chartRecord);
        }
        return records;
    }

    private List<DetailDimension> getDimensionDefaultData(){
        List<DetailDimension> dimensions = new ArrayList<DetailDimension>();
        for (int i = 0; i<3 ;++i){
            DetailDimension dimension = new DetailDimension();
            dimension.setValueFmt("###,###.##");
            dimension.setValue((float) Math.random() * 50f + 7);
            dimension.setMntDescription("百万");
            dimension.setIndexId("INDEX_0036");
            dimension.setValueMnt("1000000");
            dimension.setValueDescription("月同期");
            dimension.setValueType("8");
            dimension.setValueUnit("元");
            dimensions.add(dimension);
        }
        return dimensions;
    }



}
