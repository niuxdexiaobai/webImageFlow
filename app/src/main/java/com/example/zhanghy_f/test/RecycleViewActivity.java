package com.example.zhanghy_f.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * Created by zhanghy-f on 2017/8/7.
 */

public class RecycleViewActivity extends FragmentActivity {
	@BindView(R.id.rv) RecyclerView rv;
	private MultiTypeAdapter adapter;

	/* Items 等同于 ArrayList<Object> */
	private Items items;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recycleview);
		ButterKnife.bind(this);
		initView();

		adapter = new MultiTypeAdapter();

		/* 注册类型和 View 的对应关系 */
		adapter.register(Category.class, new CategoryViewBinder());
//		adapter.register(Song.class, new SongViewBinder());
		rv.setAdapter(adapter);

		initData();
	}

	private void initData() {
		/* 模拟加载数据，也可以稍后再加载，然后使用
         * adapter.notifyDataSetChanged() 刷新列表 */
		items = new Items();
		for (int i = 0; i < 20; i++) {
			items.add(new Category("Songs"));
//			items.add(new Song("小艾大人", R.drawable.avatar_dakeet));
//			items.add(new Song("许岑", R.drawable.avatar_cen));
		}
		adapter.setItems(items);
		adapter.notifyDataSetChanged();
	}

	private void initView() {
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
		linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		rv.setLayoutManager(linearLayoutManager);
	}
}
