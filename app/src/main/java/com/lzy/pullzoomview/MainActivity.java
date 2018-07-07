package com.lzy.pullzoomview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {

    private float sensitive;         //放大的敏感系数
    private int zoomTime;            //头部缩放时间，单位 毫秒
    private boolean isParallax;      //是否让头部具有视差动画
    private boolean isZoomEnable;    //是否允许头部放大

    private TextView tv_sensitive;
    private TextView tv_zoomTime;

    private String imageUrl = "http://static.v.xingyunyd.com/live/5d8502e2-3a4e-43ca-8e1a-60f15e44c994.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("PullScrollViewActivity");
        strings.add("PullListViewActivity");
        strings.add("PullGridViewActivity");
        strings.add("PullWebViewActivity");
        strings.add("PullRecyclerViewActivity");
        strings.add("PullViewActivity");
        strings.add("PullViewGroupActivity");

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings));
        listView.setOnItemClickListener(this);

        tv_sensitive = (TextView) findViewById(R.id.tv_sensitive);
        tv_zoomTime = (TextView) findViewById(R.id.tv_zoomTime);

        CheckBox cb_isParallax = (CheckBox) findViewById(R.id.cb_isParallax);
        cb_isParallax.setOnCheckedChangeListener(this);
        cb_isParallax.setChecked(true);
        CheckBox cb_isZoomEnable = (CheckBox) findViewById(R.id.cb_isZoomEnable);
        cb_isZoomEnable.setOnCheckedChangeListener(this);
        cb_isZoomEnable.setChecked(true);

        SeekBar sb_sensitive = (SeekBar) findViewById(R.id.sb_sensitive);
        sb_sensitive.setMax(30);
        sb_sensitive.setOnSeekBarChangeListener(this);
        sb_sensitive.setProgress(15);
        SeekBar sb_zoomTime = (SeekBar) findViewById(R.id.sb_zoomTime);
        sb_zoomTime.setMax(2000);
        sb_zoomTime.setOnSeekBarChangeListener(this);
        sb_zoomTime.setProgress(500);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        intent.putExtra("sensitive", sensitive);
        intent.putExtra("zoomTime", zoomTime);
        intent.putExtra("isParallax", isParallax);
        intent.putExtra("isZoomEnable", isZoomEnable);
        intent.putExtra("imageUrl", imageUrl);
        switch (position) {
            case 0:
                intent.setClass(this, PullScrollViewActivity.class);
                break;
            case 1:
                intent.setClass(this, PullListViewActivity.class);
                break;
            case 2:
                intent.setClass(this, PullGridViewActivity.class);
                break;
            case 3:
                intent.setClass(this, PullWebViewActivity.class);
                break;
            case 4:
                intent.setClass(this, PullRecyclerViewActivity.class);
                break;
            case 5:
                intent.setClass(this, PullViewActivity.class);
                break;
            case 6:
                intent.setClass(this, PullViewGroupActivity.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.cb_isParallax:
                isParallax = isChecked;
                break;
            case R.id.cb_isZoomEnable:
                isZoomEnable = isChecked;
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.sb_sensitive:
                sensitive = progress / 10.0f;
                tv_sensitive.setText(String.valueOf(sensitive));
                break;
            case R.id.sb_zoomTime:
                zoomTime = progress;
                tv_zoomTime.setText(String.valueOf(zoomTime));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
