package com.example.traveller;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    private AllToursFragment allF;
    private FavoriteToursFragment favF;
    FragmentTransaction transF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allF = new AllToursFragment();
        favF = new FavoriteToursFragment();
        FragmentManager fragMan = getSupportFragmentManager();
        transF = fragMan.beginTransaction();
        transF.add(R.id.container, allF);
        transF.detach(allF);
        transF.add(R.id.container, favF);
        transF.detach(favF);
        transF.commit();

        ActionBar ab = getSupportActionBar();
        if(ab!=null) {
            ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
            ActionBar.Tab tab1 = ab.newTab();
            tab1.setText("ALL");
            tab1.setTabListener(this);
            ab.addTab(tab1);
            ActionBar.Tab tab2 = ab.newTab();
            tab2.setText("FAVORITES");
            tab2.setTabListener(this);
            ab.addTab(tab2);
        }
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft = getSupportFragmentManager().beginTransaction();
        int pos = tab.getPosition();
        switch (pos){
            case 0:
                ft.attach(allF);
                break;
            case 1:
                ft.attach(favF);
                break;
        }
        ft.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        ft = getSupportFragmentManager().beginTransaction();
        int pos = tab.getPosition();
        switch (pos){
            case 0:
                ft.detach(allF);
                break;
            case 1:
                ft.detach(favF);
                break;
        }
        ft.commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}