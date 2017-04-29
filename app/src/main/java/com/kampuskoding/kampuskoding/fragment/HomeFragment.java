package com.kampuskoding.kampuskoding.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kampuskoding.kampuskoding.R;


public class HomeFragment extends Fragment {
    private FragmentTabHost mTabhost;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mTabhost = (FragmentTabHost)view.findViewById(android.R.id.tabhost);
        mTabhost.setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);
        mTabhost.addTab(mTabhost.newTabSpec("post").setIndicator("Post"), FriendFragment.class,null);
        mTabhost.addTab(mTabhost.newTabSpec("search").setIndicator("Search"), ExploreFragment.class,null);
        return view;
    }
}
