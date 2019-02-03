package com.rds.andjaradji.herome.Fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rds.andjaradji.herome.Activities.MainActivity;
import com.rds.andjaradji.herome.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private PickPowerInteractionListener mListener;

    private Button turtlePowerBtn;
    private Button lightningPowerBtn;
    private Button flightPowerBtn;
    private Button webSlingingBtn;
    private Button laserVisionBtn;
    private Button superStrengthBtn;
    private Button backStoryBtn;



    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PickPowerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PickPowerFragment newInstance(String param1, String param2) {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);
        turtlePowerBtn = (Button)view.findViewById(R.id.turtlePowerBtnID);
        lightningPowerBtn = (Button)view.findViewById(R.id.lightningPowerBtnID);
        flightPowerBtn = (Button)view.findViewById(R.id.flightPowerBtnID);
        laserVisionBtn = (Button)view.findViewById(R.id.laserVisionPowerBtnID);
        webSlingingBtn = (Button)view.findViewById(R.id.webPowerBtnID);
        superStrengthBtn = (Button)view.findViewById(R.id.superStrengthPowerBtnID);
        backStoryBtn = (Button)view.findViewById(R.id.backStoryBtnID);

        turtlePowerBtn.setOnClickListener(this);
        lightningPowerBtn.setOnClickListener(this);
        flightPowerBtn.setOnClickListener(this);
        laserVisionBtn.setOnClickListener(this);
        webSlingingBtn.setOnClickListener(this);
        superStrengthBtn.setOnClickListener(this);
        backStoryBtn.setOnClickListener(this);

        backStoryBtn.setEnabled(false);
        backStoryBtn.getBackground().setAlpha(128);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.PickPowerInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button)view;

        if (btn != backStoryBtn){
            backStoryBtn.setEnabled(true);
            backStoryBtn.getBackground().setAlpha(255);

            turtlePowerBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
            lightningPowerBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer,0,0,0);
            flightPowerBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,0,0);
            webSlingingBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
            laserVisionBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
            superStrengthBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,0,0);

            int leftDrawable = 0;

            switch (btn.getId()){
                case R.id.turtlePowerBtnID:
                    leftDrawable = R.drawable.turtle_power;
                    MainActivity.primaryPower = 1;
                    MainActivity.strPrimaryPower = getString(R.string.turtle_power);
                    break;
                case R.id.lightningPowerBtnID:
                    leftDrawable = R.drawable.thors_hammer;
                    MainActivity.primaryPower = 2;
                    MainActivity.strPrimaryPower = getString(R.string.lightning);
                    break;
                case R.id.flightPowerBtnID:
                    leftDrawable = R.drawable.super_man_crest;
                    MainActivity.primaryPower = 3;
                    MainActivity.strPrimaryPower = getString(R.string.flight);
                    break;
                case R.id.webPowerBtnID:
                    leftDrawable = R.drawable.spider_web;
                    MainActivity.primaryPower = 4;
                    MainActivity.strPrimaryPower = getString(R.string.web_slinging);
                    break;
                case R.id.laserVisionPowerBtnID:
                    leftDrawable = R.drawable.laser_vision;
                    MainActivity.primaryPower = 5;
                    MainActivity.strPrimaryPower = getString(R.string.laser_vision);
                    break;
                case R.id.superStrengthPowerBtnID:
                    leftDrawable = R.drawable.super_strength;
                    MainActivity.primaryPower = 6;
                    MainActivity.strPrimaryPower = getString(R.string.super_strength);
                    break;
            }
            btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.item_selected, 0);

        } else {
            MainActivity mainActivity = (MainActivity)getActivity();
           mainActivity.loadBackStoryScreen();

        }


    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        // TODO: Update argument type and name
        void PickPowerInteraction(Uri uri);
    }
}
