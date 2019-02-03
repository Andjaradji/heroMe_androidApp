package com.rds.andjaradji.herome.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.rds.andjaradji.herome.Fragments.BackStoryFragment;
import com.rds.andjaradji.herome.Fragments.MainFragment;
import com.rds.andjaradji.herome.Fragments.PickPowerFragment;
import com.rds.andjaradji.herome.R;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener,
        PickPowerFragment.PickPowerInteractionListener, BackStoryFragment.OnBackStoryFragmentInteractionListener {

    public static int  srcPower;
    public static int  primaryPower;

    public static String strPrimaryPower;
    public static String  secondaryPower;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        //check if there is already a fragment
        Fragment fragment = manager.findFragmentById(R.id.fragmentContainerID);

        //if no fragment found
        if (fragment == null){
            fragment = new MainFragment();
            manager.beginTransaction().add(R.id.fragmentContainerID,fragment).commit();
        }

    }

    public void loadPickPowerScreen () {
        PickPowerFragment pickPowerFragment = new PickPowerFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerID,pickPowerFragment)
        .addToBackStack(null).commit();

    }

    public void loadBackStoryScreen () {
        generateSecondaryPower();
        BackStoryFragment backStoryFragment = new BackStoryFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerID,backStoryFragment)
        .addToBackStack(null).commit();
    }

    public void loadSourcePowerScreen (){
        MainFragment  mainFragment = new MainFragment();
        this.getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerID,mainFragment).commit();
    }

    private void generateSecondaryPower (){

        switch (srcPower){
            case 1:
                switch (primaryPower){
                    case 1:
                        secondaryPower="Thick Skin";
                        break;
                    case 2:
                        secondaryPower="Speedy as Fuck";
                        break;
                    case 3:
                        secondaryPower="Wings Spread";
                        break;
                    case 4:
                        secondaryPower="Acrobatic Moves";
                        break;
                    case 5:
                        secondaryPower="Heat Vision";
                        break;
                    case 6:
                        secondaryPower="Bump A Head";
                        break;
                }
                break;
            case 2:
                switch (primaryPower){
                    case 1:
                        secondaryPower="Thick Skin";
                        break;
                    case 2:
                        secondaryPower="Speedy as Fuck";
                        break;
                    case 3:
                        secondaryPower="Wings Spread";
                        break;
                    case 4:
                        secondaryPower="Acrobatic Moves";
                        break;
                    case 5:
                        secondaryPower="Heat Vision";
                        break;
                    case 6:
                        secondaryPower="Bump A Head";
                        break;
                }
                break;

            case 3:
                switch (primaryPower){
                    case 1:
                        secondaryPower="Thick Skin";
                        break;
                    case 2:
                        secondaryPower="Speedy as Fuck";
                        break;
                    case 3:
                        secondaryPower="Wings Spread";
                        break;
                    case 4:
                        secondaryPower="Acrobatic Moves";
                        break;
                    case 5:
                        secondaryPower="Heat Vision";
                        break;
                    case 6:
                        secondaryPower="Bump A Head";
                        break;
                }
                break;

        }

    }


    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void PickPowerInteraction(Uri uri) {

    }

    @Override
    public void onBackStoryFragmentInteraction(Uri uri) {

    }
}
