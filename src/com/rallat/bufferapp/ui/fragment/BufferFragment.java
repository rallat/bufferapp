package com.rallat.bufferapp.ui.fragment;


public class BufferFragment extends BaseFragment {
	public static BufferFragment newInstance(String title){
		return new BufferFragment(title);
	}
	public BufferFragment(String title){
		super.title=title;
	}
	
}
