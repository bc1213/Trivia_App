package com.trivia.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.trivia.android.adapter.HistoryAdapter;
import com.trivia.android.core.db.TriviaDatabase;
import com.trivia.android.core.model.Report;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity implements HistoryAdapter.FolderClickListener {

    private HistoryAdapter mAdapter;
    private List<Report> mySGList = new ArrayList<>();

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        recyclerView = findViewById(R.id.recyclerView);

        mAdapter = new HistoryAdapter(getApplicationContext(),mySGList,this);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                mLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        loadData();
    }

    private void loadData() {

        List<Report> reports = TriviaDatabase.Companion.getDatabase().reportDao().getAllReports();
        if (reports.size() > 0) {
            for(int i=0;i<reports.size();i++) {
                mySGList.add(reports.get(i));
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onScrollEnd(int lastPosition) {

    }

    @Override
    public void onPatientClicked(int position) {

    }

    @Override
    public void onQRCodeclicked(String checkPointName, Bitmap bMap) {

    }
}