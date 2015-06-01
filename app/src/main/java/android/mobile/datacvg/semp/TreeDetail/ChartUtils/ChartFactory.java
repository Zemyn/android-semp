package android.mobile.datacvg.semp.TreeDetail.ChartUtils;

import android.content.Context;
import android.mobile.datacvg.semp.Models.ChartType;
import android.mobile.datacvg.semp.TreeDetail.ChartRecord;

import java.util.List;

import lecho.lib.hellocharts.view.AbstractChartView;

/**
 * Used for create chart view
 */
public class ChartFactory {
    public static AbstractChartView createChartView(ChartType type,Context context, List<ChartRecord> list_chat_data){
        switch (type){
            case bar:
                ColumnChartSetUp columnChartSetUp = new ColumnChartSetUp(context, list_chat_data);
                return columnChartSetUp.getChartView();
            case line:
                LineChartSetUp lineChartSetUp = new LineChartSetUp(context, list_chat_data);
                return lineChartSetUp.getChartView();
            default:
                return null;
        }
    }
}
