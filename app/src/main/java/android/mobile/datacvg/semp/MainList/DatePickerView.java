package android.mobile.datacvg.semp.MainList;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.mobile.datacvg.semp.MainActivity;
import android.mobile.datacvg.semp.R;
import android.support.v7.widget.GridLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Administrator on 2015/5/22.
 */
public class DatePickerView {
    public Boolean opened = false;
    private PopupWindow popwindow;
    private Context mContext;
    private Date pickedDate;

    public DatePickerView(Context context){
        this.mContext = context;
    }

    public void initialView(){
        View contentView = LayoutInflater.from(mContext).inflate(R.layout.data_picker,null);
        opened = false;

       /* GridLayout grd_month_content = (GridLayout) contentView.findViewById(R.id.grd_month_content);

        for (int i = 0; i < 12; i++){
            Button btnMonth = new Button(mContext);

            btnMonth.setBackgroundResource(R.drawable.shape_dark_blue_round_bound_btn_bg);
            btnMonth.setText((i + 1) + "月");
            *//*btnMonth.setWidth(itemWidth-30);
            btnMonth.setHeight(5);*//*
            GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
            lp.setMargins(30,15,0,0);


            *//*GridLayout.Spec row=GridLayout.spec(i/3+1);
            GridLayout.Spec column=GridLayout.spec(i%3+1);*//*
            grd_month_content.addView(btnMonth,lp);
        }*/

        String[] strs = new String[]{"2008","2009","2010","2011","2012","2013","2014","2015"};
        ListView yearList = (ListView) contentView.findViewById(R.id.lsv_year);
        yearList.setAdapter(new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, strs));

        Button btn_test = (Button) contentView.findViewById(R.id.btn_date_picker_for_cancel);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeDatePickerView();
            }
        });
        popwindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popwindow.setFocusable(true);
        popwindow.setTouchable(true);
        /*popwindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("mengdd", "onTouch : ");
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });*/
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        popwindow.setBackgroundDrawable(new ColorDrawable(0x00000000));//此处设置透明背景
    }

    /**
     * close the data picker view
     */
    public void closeDatePickerView(){
        if (opened == true){
            popwindow.dismiss();
            opened = false;
        }
    }

    /**
     * open the data picker view
     */
    public void openDatePickerView(View view){
        if (opened == false){
            popwindow.showAsDropDown(view);
            opened = true;
        }
    }
}
