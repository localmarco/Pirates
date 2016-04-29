package com.daviddone.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daviddone.bean.SeeBugHotInfo;
import com.daviddone.data.R;
import com.daviddone.zoomeye.result.bean.Matches;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;

public class ZoomEyeAdapter extends BaseAdapter{
	private Context mContext;
	List<Matches> matches;
	public ZoomEyeAdapter(Context mContext,List<Matches> matches) {
		this.mContext = mContext;
		this.matches = matches;
	}
	

	public int getCount() {
		return matches.size();
	}

	public Object getItem(int position) {
		return matches.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	public View getView(final int position, View view, ViewGroup arg2) {
		ViewHolder viewHolder = null;
		final Matches eachItem = matches.get(position);
		if (view == null) {
			viewHolder = new ViewHolder();
			view = LayoutInflater.from(mContext).inflate(R.layout.listitem_zoomeye, null);
			ViewUtils.inject(viewHolder, view);
			viewHolder.tv_search_result_ip = (TextView) view.findViewById(R.id.tv_search_result_ip);
			viewHolder.tv_search_result_address = (TextView) view.findViewById(R.id.tv_search_result_address);
			viewHolder.tv_search_result_product = (TextView) view.findViewById(R.id.tv_search_result_product);
			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		viewHolder.tv_search_result_ip.setText(eachItem.getIp()); 
		viewHolder.tv_search_result_address.setText(eachItem.getGeoinfo().getCountry().getNames().getEn()+ " " +eachItem.getGeoinfo().getCity().getNames().getEn()); 
		viewHolder.tv_search_result_product.setText(eachItem.getPortinfo().getProduct()+" "+eachItem.getPortinfo().getService()); 
		return view;
	}
	 class ViewHolder {
		TextView tv_search_result_ip;
		TextView tv_search_result_address;
		TextView tv_search_result_product;
	}
}
