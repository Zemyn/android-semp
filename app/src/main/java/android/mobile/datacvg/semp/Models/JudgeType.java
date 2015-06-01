package android.mobile.datacvg.semp.Models;

import android.mobile.datacvg.semp.R;

/**
 * Created by Administrator on 2015/5/19.
 */
public enum JudgeType {
    Good("Good", R.drawable.shape_blue_round_corner,R.drawable.shape_blue_round_btn_bg),
    Warning("Warning",R.drawable.shape_yellow_round_corner,R.drawable.shape_yellow_round_btn_bg),
    Bad("Bad",R.drawable.shape_red_round_corner,R.drawable.shape_red_round_btn_bg);

    private String judgeStr;
    private int bgStyle;
    private int chartTypeBg;

    private JudgeType(String judgeStr, int bgStyle, int chartTypeBg){
        this.judgeStr = judgeStr;
        this.bgStyle = bgStyle;
        this.chartTypeBg = chartTypeBg;
    }

    public String getJudge(){
        return  judgeStr;
    }

    public static JudgeType setUpJudegeType(String strFlag){
        switch (strFlag){
            case "yellow":
                return JudgeType.Warning;
            case "blue":
                return JudgeType.Good;
            case "red":
                return JudgeType.Bad;
            default:
                return JudgeType.Bad;
        }
    }

    public int getBgStyle(){
        return bgStyle;
    }

    public int getChartTypeBg() {
        return chartTypeBg;
    }
}
