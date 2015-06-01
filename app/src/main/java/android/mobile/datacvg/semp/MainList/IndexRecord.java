package android.mobile.datacvg.semp.MainList;

import android.mobile.datacvg.semp.BaseResponse;
import android.mobile.datacvg.semp.Models.JudgeType;
import android.mobile.datacvg.semp.Models.ChartType;

/**
 * Created by Administrator on 2015/5/14.
 */
public class IndexRecord extends BaseResponse{
    String name;
    JudgeType judgeType;
    ChartType chartType;
    String indexData;
    String chartUnit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JudgeType getJudgeType() {
        return judgeType;
    }

    public void setJudgeType(String threshold_flag) {
        judgeType = JudgeType.setUpJudegeType(threshold_flag);
    }

    public ChartType getChartType() {
        return chartType;
    }

    public void setChartType(String str_char_type){
        chartType = ChartType.setUpChartType(str_char_type);
    }

    public String getIndexData() {
        return indexData;
    }

    public void setIndexData(String indexData) {
        this.indexData = indexData;
    }

    public String getChartUnit() {
        return chartUnit;
    }

    public void setChartUnit(String chartUnit) {
        this.chartUnit = chartUnit;
    }

    public String dataShow(){
        return ""+indexData+chartUnit;
    }
}
