package android.mobile.datacvg.semp.TreeDetail.ChartUtils;

import android.content.Context;
import android.mobile.datacvg.semp.TreeDetail.ChartRecord;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.AbstractChartView;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Used for set up LineChart
 */
public class LineChartSetUp {
    private Context mContext;
    private LineChartView lineChartView;
    private LineChartData mLineChartData;
    private List<ChartRecord> mData;

    LineChartSetUp(Context context,List<ChartRecord> list_data){
        this.mContext = context;
        this.mData = list_data;
        setUpData();
    }

    public void setUpData(){
        List<Line> lines = new ArrayList<Line>();

        List<AxisValue> axisValues = new ArrayList<AxisValue>();

        List<PointValue> values = new ArrayList<PointValue>();
        for (int i = 0; i < mData.size(); ++i) {
            ChartRecord record= mData.get(i);
            int month = record.getTimeMonth()-201500;
            axisValues.add(new AxisValue(month));
            values.add(new PointValue(month,record.getIndexData()));
        }

        Line line = new Line(values);
        line.setColor(ChartUtils.pickColor());
        //line.setColor(ChartUtils.COLORS[i]);
        //line.setShape(shape);
        line.setCubic(false);
        line.setFilled(true);
        line.setHasLabelsOnlyForSelected(true);
        line.setHasLines(true);
        line.setHasPoints(true);
        lines.add(line);


        mLineChartData = new LineChartData(lines);

        if (true) {
            Axis axisX = new Axis(axisValues);
            Axis axisY = new Axis().setHasLines(true);
            axisX.setName("Axis X");
            axisY.setName("Axis Y");

            mLineChartData.setAxisXBottom(axisX);
            mLineChartData.setAxisYLeft(axisY);
        } else {
            mLineChartData.setAxisXBottom(null);
            mLineChartData.setAxisYLeft(null);
        }

        mLineChartData.setBaseValue(Float.NEGATIVE_INFINITY);
    }

    public AbstractChartView getChartView() {
        lineChartView = new LineChartView(mContext);
        lineChartView.setLineChartData(mLineChartData);
        return lineChartView;
    }
}
