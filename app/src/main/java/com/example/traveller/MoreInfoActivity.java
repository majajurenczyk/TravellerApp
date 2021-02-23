package com.example.traveller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MoreInfoActivity extends AppCompatActivity implements ChooseInfoFragment.OnOptionChoiceListener {

    private HotelInfoFragment hiF;
    private LocalisationInfoFragment liF;
    private TripsInfoFragment tiF;
    FragmentTransaction trans;

    private static final String TAG_HOTEL_INFO = "hotel";
    private static final String TAG_LOCAL_INFO = "local";
    private static final String TAG_TRIPS_INFO = "trips";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        if(savedInstanceState == null){
            hiF = new HotelInfoFragment();
            liF = new LocalisationInfoFragment();
            tiF = new TripsInfoFragment();
            FragmentManager fragMan = getSupportFragmentManager();
            trans = fragMan.beginTransaction();
            trans.add(R.id.info_container, hiF, TAG_HOTEL_INFO);
            trans.detach(hiF);
            trans.add(R.id.info_container, tiF, TAG_TRIPS_INFO);
            trans.detach(tiF);
            trans.add(R.id.info_container, liF, TAG_LOCAL_INFO);
            trans.detach(liF);
            trans.commit();
        }
        else {
            hiF = (HotelInfoFragment) getSupportFragmentManager().findFragmentByTag(TAG_HOTEL_INFO);
            tiF = (TripsInfoFragment) getSupportFragmentManager().findFragmentByTag(TAG_TRIPS_INFO);
            liF = (LocalisationInfoFragment) getSupportFragmentManager().findFragmentByTag(TAG_LOCAL_INFO);
        }
    }

    @Override
    public void onChoiceOption(int option) {
        FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
        switch (option){
            case 1:
                trans.detach(liF);
                trans.detach(tiF);
                trans.attach(hiF);
                break;
            case 2:
                trans.detach(tiF);
                trans.detach(hiF);
                trans.attach(liF);
                break;
            case 3:
                trans.detach(liF);
                trans.detach(hiF);
                trans.attach(tiF);
                break;
        }
        trans.commit();
    }
}