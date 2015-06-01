package android.mobile.datacvg.semp.Models;

import android.mobile.datacvg.semp.R;

/**
 * Created by Administrator on 2015/5/20.
 */
public enum ChartType {
    text("text", R.mipmap.tree_icon_text),
    bar("bar_chart",R.mipmap.tree_icon_bar),
    line("line_chart",R.mipmap.tree_icon_line);

    private String charType;
    private int charTypeIconId;

    private ChartType(String charType, int charTypeIconId){
        this.charType = charType;
        this.charTypeIconId = charTypeIconId;
    }

    public static ChartType setUpChartType(String strCharType){
        switch (strCharType) {
            case "text":
                return ChartType.text;
            case "bar_chart":
                return  ChartType.bar;
            case "line_chart":
                return ChartType.line;
            default:
                return ChartType.bar;
        }
    }

    public int getIconId(){
        return charTypeIconId;
    }
}
