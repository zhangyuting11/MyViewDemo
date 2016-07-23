package com.example.yuting.myviewdemo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.yuting.myviewdemo.R;
import com.example.yuting.myviewdemo.widget.PieChartView;

/**
 * 饼状图
 * Created by yuting on 2016/7/23.
 */
public class ChartFragment extends Fragment {

    private SeekBar seekBar1, seekBar2;
    private PieChartView pieChartView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        seekBar1 = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) view.findViewById(R.id.seekBar2);
        pieChartView = (PieChartView) view.findViewById(R.id.myView);
        seekBar1.setOnSeekBarChangeListener(onSeekBarChangeListener);
        seekBar2.setOnSeekBarChangeListener(onSeekBarChangeListener);
        return view;
    }

    SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (seekBar.getId() == R.id.seekBar) {
                seekBar1.setProgress(progress);
                seekBar2.setProgress(100 - progress);
            } else {
                seekBar2.setProgress(progress);
                seekBar1.setProgress(100 - progress);
            }
            pieChartView.setPercent((float) (1.0 * seekBar2.getProgress() / 100));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };
}
