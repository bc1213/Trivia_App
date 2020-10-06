package com.trivia.android.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.trivia.android.R;
import com.trivia.android.core.model.Report;

import java.io.Serializable;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    public List<Report> moviesList;
    public static final int PAGE_SIZE = 9;
    public static final int PAGINATION_POSITION = PAGE_SIZE/2;

    private int selectedPosition = -1;

    private Context mContext;

    private FolderClickListener mFolderClickListener;
    public interface FolderClickListener extends Serializable {

        void onScrollEnd(int lastPosition);
        void onPatientClicked(int position);
        void onQRCodeclicked(String  checkPointName, Bitmap bMap);

    }

    public HistoryAdapter(Context context, List<Report> moviesList, FolderClickListener folderClickListener) {
        this.moviesList = moviesList;
        this.mContext = context;
        this.mFolderClickListener = folderClickListener;
    }

    public void add(Report mc) {
        moviesList.add(mc);
        notifyItemInserted(moviesList.size() - 1);
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView name, datetime, cricket, flag;



        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.psName);
            datetime = view.findViewById(R.id.psDatetime);
            cricket = view.findViewById(R.id.psCricket);
            flag = view.findViewById(R.id.psFlag);
        }
    }

    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_list, parent, false);

        return new HistoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final HistoryAdapter.MyViewHolder holder, int position) {
        final Report data = moviesList.get(position);

        holder.name.setText(""+data.getUserName());
        holder.datetime.setText(""+data.getDateTime());
        holder.cricket.setText(""+data.getCrickter());
        holder.flag.setText(""+data.getColorSelected());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
