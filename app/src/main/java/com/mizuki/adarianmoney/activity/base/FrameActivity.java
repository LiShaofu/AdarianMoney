package com.mizuki.adarianmoney.activity.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.mizuki.adarianmoney.R;
import com.mizuki.adarianmoney.view.SlideMenuItem;
import com.mizuki.adarianmoney.view.SlideMenuView;

/**
 * Created by Administrator on 2017/7/14.
 */

public class FrameActivity extends BaseActivity {
    private SlideMenuView slideMenuView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//设置无标题栏
        setContentView(R.layout.activity_main);
    }

    protected void appendMainBody(int resId) {
        LinearLayout mainBody = (LinearLayout) findViewById(R.id.main_body_ll);
        View view = LayoutInflater.from(this).inflate(resId, null);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        mainBody.addView(view, layoutParams);
    }

    //创建滑动菜单
    protected void createSlideMenu(int resId) {
        slideMenuView = new SlideMenuView(this);
        String[] menuItemArray=getResources().getStringArray(resId);//得到资源数组
        for (int i=0;i<menuItemArray.length;i++){
            SlideMenuItem item=new SlideMenuItem(i,menuItemArray[i]);
            slideMenuView.add(item);
        }
        slideMenuView.bindList();
    }
}
