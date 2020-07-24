package com.example.smartshopdemoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ScreensListAdapter.ScreenImageListener {

    RecyclerView recyclerView;

    public static final Integer dummy_images[] = {

            R.drawable.first,
            R.drawable.second,
            R.drawable.third,
            R.drawable.fourth,
            R.drawable.fifth,
            R.drawable.sixth,
            R.drawable.seventh,
            R.drawable.eight,
            R.drawable.ninth,
            R.drawable.tenth,
            R.drawable.eleven,
            R.drawable.twelve,
            R.drawable.thirteen,
            R.drawable.sixteen,
            R.drawable.seventeen,

    };

    ScreensListAdapter mScreensListAdapter = new ScreensListAdapter(new ArrayList(),this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        recyclerView.setHasFixedSize(true);

        ArrayList<DummyImagesModel> recordsDataLists = prepareData();
        mScreensListAdapter.updateScreens(recordsDataLists);
        recyclerView.setAdapter(mScreensListAdapter);

    }

    private ArrayList<DummyImagesModel> prepareData() {

        ArrayList<DummyImagesModel> theImage = new ArrayList<>();
        for (int i = 0; i < dummy_images.length ; i++){
            DummyImagesModel createList = new DummyImagesModel();
            createList.setImage_view(dummy_images[i]);
            theImage.add(createList);
        }
        return theImage;
    }

    @Override
    public void onItemClick(int position) {

        mScreensListAdapter.newPosition(position + 1);
        mScreensListAdapter.notifyDataSetChanged();
    }
}