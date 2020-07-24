package com.example.smartshopdemoapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScreensListAdapter extends RecyclerView.Adapter<ScreensListAdapter.ScreensListViewHolder>{


    List<DummyImagesModel> mDummyImagesModelList;
    ScreenImageListener mScreenImageListener;
    int new_position;

//    public ScreensListAdapter(List<DummyImagesModel> dummyImagesModelList) {
//        mDummyImagesModelList = dummyImagesModelList;
//    }


    public ScreensListAdapter(List<DummyImagesModel> dummyImagesModelList, ScreenImageListener screenImageListener) {
        mDummyImagesModelList = dummyImagesModelList;
        mScreenImageListener = screenImageListener;
    }

    public void updateScreens(List<DummyImagesModel> new_list)
    {
        mDummyImagesModelList.clear();
        mDummyImagesModelList.addAll(new_list);
        notifyDataSetChanged();
    }

    public void newPosition(int position){
        new_position = position;
    }

    @NonNull
    @Override
    public ScreensListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dumy_images_list_view,parent,false);
        return new ScreensListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScreensListViewHolder holder, final int position) {
        if (new_position != 0 && new_position <= 14) {
            holder.imageView.setImageResource(mDummyImagesModelList.get(new_position).getImage_view());
        }else {
            holder.imageView.setImageResource(mDummyImagesModelList.get(0).getImage_view());
            new_position = 0;
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mScreenImageListener.onItemClick(new_position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDummyImagesModelList.size();
    }

    public class ScreensListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;

        public ScreensListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View view) {
            if (mScreenImageListener != null)
            {
                mScreenImageListener.onItemClick(getAdapterPosition());
            }
        }
    }

    public interface ScreenImageListener{

        void onItemClick(int position);
    }
}
