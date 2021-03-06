package com.hisnElMuslem.myapplication.ui.Youtube;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hisnElMuslem.myapplication.Adapters.VideoRecyclerAdapter;
import com.hisnElMuslem.myapplication.R;

public class YoutubePageFragment extends Fragment {

    private RecyclerView video_rec;
    private VideoRecyclerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.youtube_fragment_layout,container,false);
         video_rec = view.findViewById(R.id.video_rec);
        video_rec.setHasFixedSize(true);
        //to use RecycleView, you need a layout manager. default is LinearLayoutManager
        if(isNetworkConnected()) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            video_rec.setLayoutManager(linearLayoutManager);
            adapter = new VideoRecyclerAdapter(getActivity());
            video_rec.setAdapter(adapter);
        }
        else
            Toast.makeText(getActivity(), "Check Internet Connection", Toast.LENGTH_SHORT).show();
        return view;
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}
