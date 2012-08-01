package com.rallat.bufferapp.ui.fragment;

public class AnalyticsFragment extends BaseFragment {
	public static AnalyticsFragment newInstance(String title){
		return new AnalyticsFragment(title);
	}
	public AnalyticsFragment(String title){
		super.title=title;
	}
	
}
