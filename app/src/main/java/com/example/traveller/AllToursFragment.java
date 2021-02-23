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


public class AllToursFragment extends Fragment {

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
        View rootView =  inflater.inflate(R.layout.fragment_all_tours, container, false);
        ArrayList<TourItem> items = new ArrayList<>(Arrays.asList(Data.getItems()));
        ListAdapter tourAdapter = new ListAdapter(items, activity);
        ListView tours = (ListView)rootView.findViewById(R.id.all_tours_list);
        tours.setAdapter(tourAdapter);
        return rootView;
    }


}