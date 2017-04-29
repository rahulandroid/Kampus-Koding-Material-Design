package com.kampuskoding.kampuskoding.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kampuskoding.kampuskoding.R;
import com.kampuskoding.kampuskoding.TambahTemanActivity;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class FriendFragment extends Fragment {
    public FriendFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TambahTemanActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
