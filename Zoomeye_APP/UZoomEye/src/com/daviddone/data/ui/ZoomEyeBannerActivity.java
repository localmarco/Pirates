package com.daviddone.data.ui;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.daviddone.adapter.ZoomEyeAdapter;
import com.daviddone.data.R;
import com.daviddone.voa.customview.LoginDialog;
import com.daviddone.voa.customview.NoScrollListView;
import com.daviddone.voa.util.LoggerUtil;
import com.daviddone.zoomeye.result.bean.BugInfo;
import com.daviddone.zoomeye.result.bean.Matches;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 
* @ClassName: ZoomEyeBannerActivity 
* @Description: 本类作用 展示Banner详情
* @author tangdongqing
* @date 2016-4-27 下午10:26:14 
*
 */
public class ZoomEyeBannerActivity extends Activity implements View.OnClickListener{
	@ViewInject(R.id.lv_search_result)
	private NoScrollListView lv_search_result;
	@ViewInject(R.id.tv_search_click)
	private TextView tv_search_click;
	//顶部
	@ViewInject(R.id.ll_head_back)
	private LinearLayout ll_head_back;
	@ViewInject(R.id.tv_head_title)
	private TextView tv_head_title;
	@ViewInject(R.id.tv_head_title_right)
	private TextView tv_head_title_right;
	
	@ViewInject(R.id.tv_zoomeye_banner)
	private TextView tv_zoomeye_banner;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zoomeye_banner);
		ViewUtils.inject(this);
		initTitle();
		String banner = getIntent().getStringExtra("banner");
		tv_zoomeye_banner.setText(banner);
	}

	//初始化顶部
	private void initTitle() {
		tv_head_title.setText(getResources().getString(R.string.app_name));
		ll_head_back.setVisibility(View.VISIBLE);
		ll_head_back.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_head_back:
			finish();
			break;
		default:
			break;
		}
	}
	
}
