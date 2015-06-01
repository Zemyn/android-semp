package android.mobile.datacvg.semp.TreeDetail.ChartUtils;

import android.content.Context;
import android.mobile.datacvg.semp.TreeDetail.ChartRecord;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.AbstractChartView;
import lecho.lib.hellocharts.view.ColumnChartView;

/**
 * Used for set up Column chart view.
 */
public class ColumnChartSetUp implements IChart {
    private Context mContext;
    private ColumnChartView columnChartView;
    private ColumnChartData mColumnChartData;
    private List<ChartRecord> mData;

    ColumnChartSetUp(Context context,List<ChartRecord> list_data){
        this.mContext = context;
        this.mData = list_data;
        setUpData();
    }

    public void setUpData(){
        List<Column> columns = new ArrayList<Column>();
        List<SubcolumnValue> values;
        for (int i = 0; i < mData.size(); ++i){
            values = new ArrayList<SubcolumnValue>();
            values.add(new SubcolumnValue((float) Math.random() * 50f + 5, ChartUtils.pickColor()));
            /*for (int j = 0; j < numSubcolumns; ++j) {
                values.add(new SubcolumnValue((float) Math.random() * 50f + 5, ChartUtils.pickColor()));
            }*/
            Column column = new Column(values);
            column.setHasLabelsOnlyForSelected(true);
            columns.add(column);
        }//end for
        mColumnChartData = new ColumnChartData(columns);

        Axis axisX = new Axis();
        Axis axisY = new Axis().setHasLines(true);
        if (true) {
            axisX.setName("Axis X");
            axisY.setName("Axis Y");
        }
        mColumnChartData.setAxisXBottom(axisX);
        mColumnChartData.setAxisYLeft(axisY);
    }

    public AbstractChartView getChartView() {
        columnChartView = new ColumnChartView(mContext);
        columnChartView.setColumnChartData(mColumnChartData);
        return columnChartView;
    }
}
