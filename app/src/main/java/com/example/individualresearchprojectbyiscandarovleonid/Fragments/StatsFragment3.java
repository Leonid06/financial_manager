package com.example.individualresearchprojectbyiscandarovleonid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.individualresearchprojectbyiscandarovleonid.Adapters.PieChartAdapter;
import com.example.individualresearchprojectbyiscandarovleonid.R;
import com.github.mikephil.charting.charts.PieChart;

public class StatsFragment3 extends Fragment {
    ImageButton  leftButton3  , goToStatsButton3;
    PieChart chartView3;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public StatsFragment3() {

    }


    public static StatsFragment3 newInstance(String param1, String param2) {
        StatsFragment3 fragment = new StatsFragment3();
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

        View view =  inflater.inflate(R.layout.fragment_stats3, container, false);

        chartView3 = view.findViewById(R.id.chartView3);

        leftButton3 = view.findViewById(R.id.leftButton3) ;

        goToStatsButton3 = view.findViewById(R.id.toStatsButton3);

        setUpNavButtons();

        PieChartAdapter.setUpPieChart(requireContext() , chartView3 , 2 , 2022);


        return view ;

    }

    private void setUpNavButtons(){
        leftButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_statsFragment3_to_statsFragment2);

            }
        });

        goToStatsButton3.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_statsFragment3_to_navigation_prediction);
            }
        });


    }
}