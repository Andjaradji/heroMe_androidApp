package com.rds.andjaradji.herome.Fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.rds.andjaradji.herome.Activities.MainActivity;
import com.rds.andjaradji.herome.R;

import java.sql.BatchUpdateException;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button powerByAccidentBtn;
    private Button powerByGeneticMutationBtn;
    private Button powerSinceBornBtn;
    private Button choosePowerBtn;

    private MainFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        powerByAccidentBtn = (Button)view.findViewById(R.id.byAccidentBtnID);
        powerByGeneticMutationBtn = (Button)view.findViewById(R.id.byMutationBtnID);
        powerSinceBornBtn = (Button)view.findViewById(R.id.byBornBtnID);
        choosePowerBtn = (Button)view.findViewById(R.id.choosePowerBtnID);

        powerByAccidentBtn.setOnClickListener(this);
        powerByGeneticMutationBtn.setOnClickListener(this);
        powerSinceBornBtn.setOnClickListener(this);
        choosePowerBtn.setOnClickListener(this);

        choosePowerBtn.setEnabled(false);
        choosePowerBtn.getBackground().setAlpha(128);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
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

        if (btn != choosePowerBtn) {

        choosePowerBtn.setEnabled(true);
        choosePowerBtn.getBackground().setAlpha(255);

        powerByAccidentBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);
        powerByGeneticMutationBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,0,0);
        powerSinceBornBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,0,0);

        int leftDrawable =0;

        switch (view.getId()){
            case R.id.byAccidentBtnID:
                leftDrawable = R.drawable.lightning;
                MainActivity.srcPower = 1;
                break;
            case R.id.byMutationBtnID:
                leftDrawable = R.drawable.atomic;
                MainActivity.srcPower = 2;
                break;
            case R.id.byBornBtnID:
                leftDrawable = R.drawable.rocket;
                MainActivity.srcPower = 3;
                break;
        }
            btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.item_selected, 0);
        } else {
            MainActivity mainActivity = (MainActivity)getActivity();
            mainActivity.loadPickPowerScreen();
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
    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);
    }
}
