package cn.sqw;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



/**
 * 作者：沈钦伟
 * 时间：2017/11/23
 * 功能：工单详情
 */

public class TaobaoDeatilActivity extends AppCompatActivity implements MyScrollView.ScrollViewListener, View.OnClickListener {

    private MyScrollView tv_myScrollView;
    private  RelativeLayout llTitle;
    private LinearLayout tab_layout;
    private ImageView iv_headView;
    private LinearLayout ll_ticket_tab;
    private LinearLayout ll_dealWith_tab;
    private LinearLayout ll_overInfo_tab;
    private LinearLayout ll_comment_tab;
    private ImageView iv_ticket_tab;
    private TextView tv_ticket_tab;
    private ImageView iv_dealWith_tab;
    private TextView tv_dealWith_tab;
    private ImageView iv_overInfo_tab;
    private TextView tv_overInfo_tab;
    private ImageView iv_comment_tab;
    private TextView tv_comment_tab;
    private ImageView iv_ticketHead;
    private int height;
    private LinearLayout ll_tv_DealWithTitle;
    private LinearLayout ll_over_info;
    private LinearLayout ll_comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets_detail);
        tv_myScrollView= (MyScrollView) findViewById(R.id.tv_myScrollView);
        iv_ticketHead= (ImageView) findViewById(R.id.iv_ticketHead);
        ll_tv_DealWithTitle= (LinearLayout) findViewById(R.id.ll_tv_DealWithTitle);
        ll_comment= (LinearLayout) findViewById(R.id.ll_comment);
        ll_over_info= (LinearLayout) findViewById(R.id.ll_over_info);
        llTitle= (RelativeLayout) findViewById(R.id.ll_good_detail);
        tab_layout=(LinearLayout) findViewById(R.id.tab_layout);
        iv_headView=(ImageView)findViewById(R.id.iv_headView);
        ll_ticket_tab=(LinearLayout) findViewById(R.id.ll_ticket_tab);
        ll_dealWith_tab=(LinearLayout) findViewById(R.id.ll_dealWith_tab);
        ll_overInfo_tab=(LinearLayout) findViewById(R.id.ll_overInfo_tab);
        ll_comment_tab=(LinearLayout) findViewById(R.id.ll_comment_tab);
        iv_ticket_tab= (ImageView) findViewById(R.id.iv_ticket_tab);
        tv_ticket_tab= (TextView) findViewById(R.id.tv_ticket_tab);
        iv_dealWith_tab= (ImageView) findViewById(R.id.iv_dealWith_tab);
        tv_dealWith_tab= (TextView) findViewById(R.id.tv_dealWith_tab);
        iv_overInfo_tab= (ImageView) findViewById(R.id.iv_overInfo_tab);
        tv_overInfo_tab= (TextView) findViewById(R.id.tv_overInfo_tab);
        iv_comment_tab= (ImageView) findViewById(R.id.iv_comment_tab);
        tv_comment_tab= (TextView) findViewById(R.id.tv_comment_tab);
        ll_ticket_tab.setOnClickListener(this);
        ll_dealWith_tab.setOnClickListener(this);
        ll_overInfo_tab.setOnClickListener(this);
        ll_comment_tab.setOnClickListener(this);
        iv_headView.setAlpha(0.001f);
        tab_layout.setAlpha(0.001f);
        llTitle.setAlpha(0.001f);
        TicketTabColor();
        ViewTreeObserver vto = iv_ticketHead.getViewTreeObserver();

        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                llTitle.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
                height = iv_ticketHead.getHeight();

                tv_myScrollView.setScrollViewListener(TaobaoDeatilActivity.this);
            }
        });
    }




    @Override
    public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 0) {   //设置标题的背景颜色
            llTitle.setBackgroundColor(Color.argb((int) 0, 255, 255, 255));
            tab_layout.setBackgroundColor(Color.argb((int) 0, 255, 255, 255));
         /*   ll_dealWith_tab.setBackgroundColor(Color.argb((int) 0, 255,255,255));
            ll_ticket_tab.setBackgroundColor(Color.argb((int) 0, 255,255,255));
            ll_overInfo_tab.setBackgroundColor(Color.argb((int) 0, 255,255,255));
            ll_comment_tab.setBackgroundColor(Color.argb((int) 0, 255,255,255));
            iv_headView.setBackgroundColor(Color.argb((int) 0, 255,255,255));
            tv_ticket_tab.setTextColor(Color.argb((int) 0, 255,255,255));
            iv_ticket_tab.setBackgroundColor(Color.argb((int) 0, 255,255,255));*/
            iv_headView.setAlpha(0.01f);
            tab_layout.setAlpha(0.01f);
        } else if (y > 0 && y <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
            float scale = (float) y / height;
            float alpha = (255 * scale);
            // tv_good_detail_title_good.setTextColor(Color.argb((int) alpha, 1,24,28));
            llTitle.setAlpha(scale);
            tab_layout.setBackgroundColor(Color.argb((int) 0, 255, 255, 255));
            ll_ticket_tab.setAlpha(scale);
            ll_dealWith_tab.setAlpha(scale);
            ll_overInfo_tab.setAlpha(scale);
            ll_comment_tab.setAlpha(scale);
            iv_headView.setAlpha(scale);
            iv_headView.setAlpha(scale);
            tab_layout.setAlpha(scale);
            tv_ticket_tab.setAlpha(scale);
            iv_ticket_tab.setAlpha(scale);
        } else {    //滑动到banner下面设置普通颜色
            tab_layout.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
            ll_ticket_tab.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
            ll_dealWith_tab.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
            ll_overInfo_tab.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
            ll_comment_tab.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
            llTitle.setBackgroundColor(Color.argb((int) 255, 255, 255, 255));
        }

        if (y < ll_tv_DealWithTitle.getTop() - llTitle.getHeight()) {
            TicketTabColor();
        } else if (y >= ll_tv_DealWithTitle.getTop() - llTitle.getHeight() && y < ll_over_info.getTop() - llTitle.getHeight()) {
            TabDealWithColor();
        } else if (y >= ll_over_info.getTop() - llTitle.getHeight() && y < ll_comment.getTop() - llTitle.getHeight()) {
            TabOverInfoColor();
        } else if (y >= ll_comment.getTop() - llTitle.getHeight()) {
            TabCommentColor();
        }
    }
    private void TabCommentColor() {
        iv_ticket_tab.setVisibility(View.INVISIBLE);
        tv_ticket_tab.setTextColor(getResources().getColor(R.color.gray_33));
        iv_dealWith_tab.setVisibility(View.INVISIBLE);
        tv_dealWith_tab.setTextColor(getResources().getColor(R.color.gray_33));
        iv_overInfo_tab.setVisibility(View.INVISIBLE);
        tv_overInfo_tab.setTextColor(getResources().getColor(R.color.gray_33));
        iv_comment_tab.setVisibility(View.VISIBLE);
        tv_comment_tab.setTextColor(getResources().getColor(R.color.blue));
    }

    private void TabOverInfoColor() {
        iv_ticket_tab.setVisibility(View.INVISIBLE);
        tv_ticket_tab.setTextColor(getResources().getColor(R.color.gray_33));
        iv_dealWith_tab.setVisibility(View.INVISIBLE);
        tv_dealWith_tab.setTextColor(getResources().getColor(R.color.gray_33));
        iv_overInfo_tab.setVisibility(View.VISIBLE);
        tv_overInfo_tab.setTextColor(getResources().getColor(R.color.blue));
        iv_comment_tab.setVisibility(View.INVISIBLE);
        tv_comment_tab.setTextColor(getResources().getColor(R.color.gray_33));
    }

    private void TabDealWithColor() {
        iv_ticket_tab.setVisibility(View.INVISIBLE);
        tv_ticket_tab.setTextColor(getResources().getColor(R.color.gray_33));
        iv_dealWith_tab.setVisibility(View.VISIBLE);
        tv_dealWith_tab.setTextColor(getResources().getColor(R.color.blue));
        iv_overInfo_tab.setVisibility(View.INVISIBLE);
        tv_overInfo_tab.setTextColor(getResources().getColor(R.color.gray_33));
        iv_comment_tab.setVisibility(View.INVISIBLE);
        tv_comment_tab.setTextColor(getResources().getColor(R.color.gray_33));
    }

    private void TicketTabColor() {
        iv_ticket_tab.setVisibility(View.VISIBLE);
        tv_ticket_tab.setTextColor(getResources().getColor(R.color.blue));
        iv_dealWith_tab.setVisibility(View.INVISIBLE);
        tv_dealWith_tab.setTextColor(getResources().getColor(R.color.gray_33));
        iv_overInfo_tab.setVisibility(View.INVISIBLE);
        tv_overInfo_tab.setTextColor(getResources().getColor(R.color.gray_33));
        iv_comment_tab.setVisibility(View.INVISIBLE);
        tv_comment_tab.setTextColor(getResources().getColor(R.color.gray_33));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_ticket_tab:
                tv_myScrollView.smoothScrollTo(0, 0);
                TicketTabColor();
                break;
            case R.id.ll_dealWith_tab:
                tv_myScrollView.smoothScrollTo(0, ll_tv_DealWithTitle.getTop() - llTitle.getHeight());
                TabDealWithColor();
                break;
            case R.id.ll_overInfo_tab:
                tv_myScrollView.smoothScrollTo(0, ll_over_info.getTop() - llTitle.getHeight());
                TabOverInfoColor();
                break;
            case R.id.ll_comment_tab:
                tv_myScrollView.smoothScrollTo(0, ll_comment.getTop() - llTitle.getHeight());
                TabCommentColor();
                break;

        }
    }
}
