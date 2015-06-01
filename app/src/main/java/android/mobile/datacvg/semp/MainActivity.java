package android.mobile.datacvg.semp;

import android.app.Activity;
import android.content.Intent;
import android.mobile.datacvg.semp.Login.LoginActivity;
import android.mobile.datacvg.semp.MainList.DatePickerView;
import android.mobile.datacvg.semp.MainList.IndexListAdapter;
import android.mobile.datacvg.semp.MainList.IndexRecord;
import android.mobile.datacvg.semp.Widget.RoundImageView;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.simonvt.menudrawer.MenuDrawer;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private MenuDrawer left_side_menu_drawer;

    private RecyclerView recycle_list;
    private IndexListAdapter main_list_adapter;

    private ImageView mUserImg;
    private TextView mUserNameTxv;
    private TextView mDepartLabel;
    private TextView mDepartName;

    private DatePickerView data_picker = new DatePickerView(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

       //在activity 中才能获取windowManager
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;  // 屏幕宽度（像素）
        int height = metric.heightPixels;  // 屏幕高度（像素）

        left_side_menu_drawer = MenuDrawer.attach(this);
        left_side_menu_drawer.setMenuSize(width * 2 / 3);// set the width of the Menu size
        left_side_menu_drawer.setContentView(R.layout.activity_main);//the content at the right side of the menu
        left_side_menu_drawer.setMenuView(R.layout.left_side_drawer_menu);

        //the subviews of the menu layout
        mUserImg = (RoundImageView)findViewById(R.id.img_user);
        mUserImg.setImageResource(R.mipmap.userimg);
        mUserNameTxv = (TextView)findViewById(R.id.txv_user_name);
        mUserNameTxv.setText("datacvg");
        mDepartLabel = (TextView)findViewById(R.id.txv_department_label);
        mDepartLabel.setText("组织部门：");
        mDepartName = (TextView)findViewById(R.id.txv_department_name);
        mDepartName.setText("上海数聚软件股份有限公司");

        data_picker.initialView();

        //the views at the main layout
        recycle_list = ( RecyclerView) findViewById(R.id.main_recycle_list);
        recycle_list.setLayoutManager(new LinearLayoutManager(this));
        main_list_adapter = new IndexListAdapter(getTestDate(),this);
        recycle_list.setAdapter(main_list_adapter);
    }

    private List<IndexRecord> getTestDate(){
        List<IndexRecord> record_list = new ArrayList<>();
        IndexRecord record;
        for (int i = 0; i<20; i++){
            record = new IndexRecord();
            record.setName("测试指数: "+i);
            record.setJudgeType("blue");
            record.setChartType("text");
            record.setIndexData("0.0"+i);
            record.setChartUnit("%");
            record_list.add(record);
        }
        return record_list;
    }

    /**
     * shift between main layout and left side menu drawer layout
     */
    public void menuDrawerToggle(View view){
        left_side_menu_drawer.toggleMenu();
    }

    /**
     * the pop up window trigger
     */
    public void dataPickerToggle(View v){
        if (!data_picker.opened){
            data_picker.openDatePickerView(v);
        }else {
            data_picker.closeDatePickerView();
        }
    }

   public void changeUser(View v){
       Intent in_to_login = new Intent(this, LoginActivity.class);
       startActivity(in_to_login);
       finish();
   }
}
