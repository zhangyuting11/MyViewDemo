package com.example.yuting.myviewdemo.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yuting.myviewdemo.R;
import com.example.yuting.myviewdemo.fragment.ChartFragment;
import com.example.yuting.myviewdemo.fragment.LeaveCarframent;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {


    private int pos;

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        pos = getIntent().getIntExtra("tag", 0);

        fragments.add(new ChartFragment());
        fragments.add(new LeaveCarframent());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragments.get(pos))
                .commit();
    }
}
