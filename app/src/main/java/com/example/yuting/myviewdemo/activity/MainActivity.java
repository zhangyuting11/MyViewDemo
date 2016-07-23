package com.example.yuting.myviewdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yuting.myviewdemo.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected RecyclerView recyclerView;
    protected List<String> list = new ArrayList<>();
    protected MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add("自定义View之--饼状图");
        mainAdapter = new MainAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);
    }

    class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        @Override
        public MainHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main_layout_item, parent, false);
            return new MainHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
            if (holder instanceof MainHolder) {
                ((MainHolder) holder).textView.setText(list.get(position));
                ((MainHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("tag", position);
                        startActivity(intent);
                    }
                });
            }

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

    }

    class MainHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MainHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tvText);
        }
    }
}
