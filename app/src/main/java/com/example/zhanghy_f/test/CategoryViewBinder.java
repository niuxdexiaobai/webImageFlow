package com.example.zhanghy_f.test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * Created by zhanghy-f on 2017/8/7.
 */

public class CategoryViewBinder
		extends ItemViewBinder<Category, CategoryViewBinder.ViewHolder> {
	@NonNull
	@Override
	protected CategoryViewBinder.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
		View root = inflater.inflate(R.layout.item_category, parent, false);
		return new ViewHolder(root);
	}

	//用于绑定数据到 Views
	@Override
	protected void onBindViewHolder(@NonNull CategoryViewBinder.ViewHolder holder, @NonNull Category item) {
		holder.category.setText(item.text);
	}

	static class ViewHolder extends RecyclerView.ViewHolder {

		@NonNull private final TextView category;

		ViewHolder(@NonNull View itemView) {
			super(itemView);
			this.category = (TextView) itemView.findViewById(R.id.category);
		}
	}
}
