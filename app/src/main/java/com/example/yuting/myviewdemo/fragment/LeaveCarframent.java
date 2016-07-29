package com.example.yuting.myviewdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yuting.myviewdemo.R;
import com.example.yuting.myviewdemo.widget.LeaveCarView;

/**
 * 饼状图
 * Created by yuting on 2016/7/23.
 */
public class LeaveCarframent extends Fragment {

    private LeaveCarView testView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leave_car, container, false);
        testView = (LeaveCarView) view.findViewById(R.id.view);
        testView.start();
        return view;
    }
}
