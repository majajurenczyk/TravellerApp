package com.example.traveller;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import java.util.Objects;

public class ChooseInfoFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    public interface OnOptionChoiceListener{
        void onChoiceOption(int option);
    }

    AppCompatActivity activity;
    OnOptionChoiceListener listenerForInfo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((RadioGroup) Objects.requireNonNull(getActivity()).findViewById(R.id.radioGroup)).
                setOnCheckedChangeListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            activity = (AppCompatActivity) context;
            listenerForInfo = (OnOptionChoiceListener) context;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "OnOptionChoiceListener not implemented");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId) {
            case R.id.hotel_desc:
                listenerForInfo.onChoiceOption(1);
                break;
            case R.id.local_desc:
                listenerForInfo.onChoiceOption(2);
                break;
            case R.id.trips_desc:
                listenerForInfo.onChoiceOption(3);
                break;
        }
    }
}