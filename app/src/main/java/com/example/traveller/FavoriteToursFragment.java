package com.example.traveller;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class FavoriteToursFragment extends Fragment {

    AppCompatActivity activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (AppCompatActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_favorite_tours, container, false);
        ArrayList<TourItem> items = new ArrayList<>();
        for(int i = 0; i<Data.getItems().length; i++){
            if(Data.getItems()[i].isFavorite()){
                items.add(Data.getItems()[i]);
            }
        }
        ListAdapter tourAdapter = new ListAdapter(items, activity);
        ListView tours = (ListView)rootView.findViewById(R.id.favorite_tours_list);
        tours.setAdapter(tourAdapter);
        return rootView;
    }
}