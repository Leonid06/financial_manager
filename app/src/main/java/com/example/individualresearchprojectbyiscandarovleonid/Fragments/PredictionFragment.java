package com.example.individualresearchprojectbyiscandarovleonid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.individualresearchprojectbyiscandarovleonid.Adapters.PieChartAdapter;
import com.example.individualresearchprojectbyiscandarovleonid.R;
import com.github.mikephil.charting.charts.PieChart;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PredictionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PredictionFragment extends Fragment {

    PieChart predictionChart ;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public PredictionFragment() {

    }
    public static PredictionFragment newInstance(String param1, String param2) {
        PredictionFragment fragment = new PredictionFragment();
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
        View view = inflater.inflate(R.layout.fragment_prediction, container, false);

        predictionChart = view.findViewById(R.id.predictionChart) ;

        PieChartAdapter.setUpPieChart(requireContext(), predictionChart);

        return view;
    }

}