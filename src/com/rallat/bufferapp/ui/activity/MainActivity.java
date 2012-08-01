package com.rallat.bufferapp.ui.activity;

import java.util.List;
import java.util.Vector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.rallat.bufferapp.R;
import com.rallat.bufferapp.ui.fragment.AnalyticsFragment;
import com.rallat.bufferapp.ui.fragment.BaseFragment;
import com.rallat.bufferapp.ui.fragment.BufferFragment;
import com.viewpagerindicator.TabPageIndicator;
import com.viewpagerindicator.TitleProvider;

public class MainActivity extends SherlockFragmentActivity {

	private ViewPager mPager;
	private TabPageIndicator mIndicator;
	private BufferAppAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mAdapter = new BufferAppAdapter(getSupportFragmentManager());
		mAdapter.add(new BufferFragment(getResources().getString(
				R.string.first_tab)));
		mAdapter.add(new AnalyticsFragment(getResources().getString(
				R.string.second_tab)));

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);

		mIndicator = (TabPageIndicator) findViewById(R.id.indicator);
		mIndicator.setViewPager(mPager);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	class BufferAppAdapter extends FragmentPagerAdapter implements
			TitleProvider {
		private List<BaseFragment> fragments;

		public BufferAppAdapter(FragmentManager fm) {
			super(fm);
			fragments = new Vector<BaseFragment>();
		}

		public void add(BaseFragment fragment) {
			fragments.add(fragment);
		}

		@Override
		public String getTitle(int position) {
			return fragments.get(position).title;
		}

		@Override
		public Fragment getItem(int arg0) {
			return fragments.get(arg0);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

	}

}
