package android.mobile.datacvg.semp.TreeDetail;

/**
 * Created by Administrator on 2015/5/26.
 */
public class ChartRecord {
    /*"time_month":201501,
    "mnt_description":"百分比",
    "index_id":"INDEX_0044",
    "value_fmt":"###,###.##",
    "value_mnt":"0.01",
    "index_data":0.7092,
    "value_unit":"%"}*/
    int timeMonth;
    String mntDescription;
    String indexId;
    String valueFmt;
    String valueMnt;
    float indexData;
    String valueUnit;

    public int getTimeMonth() {
        return timeMonth;
    }

    public void setTimeMonth(int timeMonth) {
        this.timeMonth = timeMonth;
    }

    public String getMntDescription() {
        return mntDescription;
    }

    public void setMntDescription(String mntDescription) {
        this.mntDescription = mntDescription;
    }

    public String getIndexId() {
        return indexId;
    }

    public void setIndexId(String indexId) {
        this.indexId = indexId;
    }

    public String getValueFmt() {
        return valueFmt;
    }

    public void setValueFmt(String valueFmt) {
        this.valueFmt = valueFmt;
    }

    public String getValueMnt() {
        return valueMnt;
    }

    public void setValueMnt(String valueMnt) {
        this.valueMnt = valueMnt;
    }

    public float getIndexData() {
        return indexData;
    }

    public void setIndexData(float indexData) {
        this.indexData = indexData;
    }

    public String getValueUnit() {
        return valueUnit;
    }

    public void setValueUnit(String valueUnit) {
        this.valueUnit = valueUnit;
    }
}
