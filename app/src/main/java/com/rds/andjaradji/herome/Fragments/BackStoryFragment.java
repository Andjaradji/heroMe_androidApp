package com.rds.andjaradji.herome.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rds.andjaradji.herome.Activities.MainActivity;
import com.rds.andjaradji.herome.R;

import java.sql.BatchUpdateException;

import static com.rds.andjaradji.herome.Activities.MainActivity.secondaryPower;
import static com.rds.andjaradji.herome.Activities.MainActivity.strPrimaryPower;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BackStoryFragment.OnBackStoryFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BackStoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BackStoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnBackStoryFragmentInteractionListener mListener;
    private TextView heroesName;
    private ImageView heroesLogo;
    private TextView backStory;

    private Button primaryPowerBtn;
    private Button secondaryPowerBtn;
    private Button startOverBtn;



    public BackStoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BackStoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BackStoryFragment newInstance(String param1, String param2) {
        BackStoryFragment fragment = new BackStoryFragment();
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

        View view = inflater.inflate(R.layout.fragment_back_story, container, false);

        primaryPowerBtn = (Button)view.findViewById(R.id.primaryPowerBtnID);
        secondaryPowerBtn = (Button)view.findViewById(R.id.secondaryPowerBtnID);

        startOverBtn = (Button)view.findViewById(R.id.startOverBtnID);
        startOverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity)getActivity();
                mainActivity.loadSourcePowerScreen();
            }
        });

        primaryPowerBtn.setText(strPrimaryPower);
        secondaryPowerBtn.setText(secondaryPower);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onBackStoryFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBackStoryFragmentInteractionListener) {
            mListener = (OnBackStoryFragmentInteractionListener) context;
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
    public interface OnBackStoryFragmentInteractionListener {
        // TODO: Update argument type and name
        void onBackStoryFragmentInteraction(Uri uri);
    }
}
