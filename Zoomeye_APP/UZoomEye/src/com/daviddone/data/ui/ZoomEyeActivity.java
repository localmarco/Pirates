package com.daviddone.data.ui;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
* @ClassName: ZoomEyeActivity 
* @Description: 本类作用 Zoomeye搜索网络暗物质
* @author tangdongqing
* @date 2016-4-24 上午12:22:32 
*
 */
public class ZoomEyeActivity extends Activity implements View.OnClickListener{
	String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZGVudGl0eSI6NTgwLCJpYXQiOjE0NjE2ODU0NTEsIm5iZiI6MTQ2MTY4NTQ1MSwiZXhwIjoxNDYxNzI4NjUxfQ.B3gQQSwMC9YwmfsWLzdgm1t7flLp7_2Y8npnc4vSvEk";
	String HOST_SEARCH = "http://api.zoomeye.org/host/search?";
	String HOST_LOGIN = "http://api.zoomeye.org/user/login";
	@ViewInject(R.id.lv_search_result)
	private NoScrollListView lv_search_result;
	@ViewInject(R.id.tv_search_click)
	private TextView tv_search_click;
	
	@ViewInject(R.id.et_search_port)
	private EditText et_search_port;
	@ViewInject(R.id.et_search_page)
	private EditText et_search_page;
	@ViewInject(R.id.et_search_facets)
	private EditText et_search_facets;
	
	//顶部
	@ViewInject(R.id.ll_head_back)
	private LinearLayout ll_head_back;
	@ViewInject(R.id.tv_head_title)
	private TextView tv_head_title;
	@ViewInject(R.id.tv_head_title_right)
	private TextView tv_head_title_right;
	HttpUtils httpUtils;
	
	 Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==0){
				initLv();
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zoomeye);
		ViewUtils.inject(this);
		initTitle();
		initClick();
		showLogin(this);
		BasicCookieStore cookieStore = new BasicCookieStore();
		httpUtils = new HttpUtils();
		httpUtils.configCookieStore(cookieStore);
	}
	//初始化顶部
	private void initTitle() {
		tv_head_title.setText(getResources().getString(R.string.app_name));
		ll_head_back.setVisibility(View.VISIBLE);
		ll_head_back.setOnClickListener(this);
	}
	private void initClick() {
		tv_search_click.setOnClickListener(this);
		ToggleButton tb = (ToggleButton) findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(new OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton cp, boolean isCheck) {
                LoggerUtil.e("isCheck",""+isCheck);
                if(isCheck==true){//默认是web
                	HOST_SEARCH = "http://api.zoomeye.org/web/search?";
                }
                if(isCheck==false){//滑动flase为host
                	HOST_SEARCH = "http://api.zoomeye.org/host/search?";
                	LoggerUtil.e("HOST_SEARCH",""+HOST_SEARCH);
                }
                
            }});
	}
	//搜索数据
	private void searchData(String query,String page,String facets) {
//		String search_get= "http://api.zoomeye.org/host/search?query=port:21&page=1&facets=app,os";
		StringBuffer sb = new StringBuffer();
		sb.append(HOST_SEARCH);
		sb.append("query="+query.replace(" ", "%20"));
		sb.append("&page="+page);
		sb.append("&facets="+facets);
		String search_get = sb.toString();
		LoggerUtil.e("search_get", ""+search_get);
		RequestParams params = new RequestParams();
			
//			params.addBodyParameter("query", query);
//			params.addBodyParameter("page", page);
//			params.addBodyParameter("facets", facets);
			params.addHeader("Authorization", "JWT "+token);
			Toast.makeText(getApplicationContext(), ""+"JWT "+token, 0).show();
			httpUtils.send(HttpRequest.HttpMethod.GET,
					search_get,
			    params,
			    new RequestCallBack<String>() {
			        @Override
			        public void onSuccess(ResponseInfo<String> responseInfo) {
//			        	Toast.makeText(getApplicationContext(), "成功"+responseInfo.result, 0).show();
			        	LoggerUtil.e("bug", ""+responseInfo.result);
			        	parseJson(responseInfo.result);
			        	if(matches.size()>0){
			        		handler.sendEmptyMessage(0);
			        	}
			        }

					@Override
			        public void onFailure(HttpException error, String msg) {
			           Toast.makeText(getApplicationContext(), "fail"+msg, 0).show();
			        }
			});
			
		}
	//初始化列表
	private void initLv() { 
		ZoomEyeAdapter eyeAdapter = new ZoomEyeAdapter(getApplicationContext(),matches);
		lv_search_result.setAdapter(eyeAdapter);
		lv_search_result.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				String banner = matches.get(position).getPortinfo().getBanner();
				Intent intent = new Intent(ZoomEyeActivity.this,ZoomEyeBannerActivity.class);
				intent.putExtra("banner", banner);
				startActivity(intent);
			}
			
		});
	}
	List<Matches> matches = new ArrayList<Matches>();
	private void parseJson(String bugStr) {
		Gson gson = new Gson();
	    BugInfo info=gson.fromJson(bugStr, new TypeToken<BugInfo>(){}.getType()); 
	    matches = info.getMatches();
	}
	  LoginDialog confirmDialog;
	 public void showLogin(final Context context) {
		 confirmDialog= new LoginDialog(context);
         confirmDialog.show();
         confirmDialog.setClicklistener(new LoginDialog.ClickListenerInterface() {
             @Override
             public void doCancel() {
                 confirmDialog.dismiss();
                 ZoomEyeActivity.this.finish();
             }

			@Override
			public void doConfirm() {
				String username = LoginDialog.et_username.getText().toString();
				String password = LoginDialog.et_password.getText().toString();
				initLogin(username,password);
			}
         });
     }
	 private void initLogin(String username, String password) {
		 RequestParams params = new RequestParams();
		 JsonObject json = new JsonObject();
			json.addProperty("username", username);
			json.addProperty("password", password);
			Toast.makeText(getApplicationContext(), ""+username+password, 0).show();
			String userInfo = json.toString();
			StringEntity entity;;
			 try {
				 entity= new StringEntity(userInfo,"utf-8");
				 params.setBodyEntity(entity);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 httpUtils.send(HttpRequest.HttpMethod.POST,
				HOST_LOGIN,
			    params,
			    new RequestCallBack<String>() {
			        @Override
			        public void onSuccess(ResponseInfo<String> responseInfo) {
			        	Toast.makeText(getApplicationContext(), "成功"+responseInfo.result, 0).show();
			        	LoggerUtil.e("token", ""+responseInfo.result);
			        	getTokenFromJson(responseInfo);
			        	confirmDialog.dismiss();
//			        	searchData("", "", "");
			        }

					@Override
			        public void onFailure(HttpException error, String msg) {
			           Toast.makeText(getApplicationContext(), "fail", 0).show();
			        }
			});
		}
	 private void getTokenFromJson(
				ResponseInfo<String> responseInfo) {
				JsonObject json2 = new JsonParser().parse(responseInfo.result).getAsJsonObject();
			    JsonElement je = json2.get("access_token");
				token = je.getAsString();
				LoggerUtil.e("token", token);
		} 
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_search_click:
			String  query = et_search_port.getText().toString();
			String  page = et_search_page.getText().toString();
			String  facets = et_search_facets.getText().toString();
			searchData(query,page,facets);
			break;
			
		case R.id.ll_head_back:
			finish();
			break;
		}
	}
}
