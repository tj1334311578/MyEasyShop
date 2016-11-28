package com.example.administrator.myeasyshop.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.example.administrator.myeasyshop.R;
import com.example.administrator.myeasyshop.main.transforms.ForegroundToBackgroundTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GuideActivity extends AppCompatActivity {
	@BindView(R.id.viewpager)
	ViewPager mViewPager;
	private List<View> mViews;
	private int[] mImgIds;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_guide);
		ButterKnife.bind(this);
		initViews();
	}
	/**
	 * 初始化ViewPager
	 */
	private void initViews() {
//		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mImgIds = new int[]{R.mipmap.lead_1,R.mipmap.lead_2,R.mipmap.lead_3};
		mViews = new ArrayList<View>();
		for (int i = 0; i < mImgIds.length+1; i++) {
			ImageView imageView = new ImageView(this);
			if(i != mImgIds.length){
				imageView.setImageResource(mImgIds[i]);
				imageView.setScaleType(ScaleType.FIT_XY);
			}
			mViews.add(imageView);
		}
		final GuidePagerAdapter adapter = new GuidePagerAdapter(mViews);
		mViewPager.setAdapter(adapter);

		mViewPager.setPageTransformer(true,new ForegroundToBackgroundTransformer());
		//监听ViewPager的页面改变
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				//如果ViewPager选中最后一页，就跳转到主Activity
				if(arg0 == adapter.getCount()-1){
					startActivity(new Intent(GuideActivity.this, MainActivity.class));
					finish();
					overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
	}
}
