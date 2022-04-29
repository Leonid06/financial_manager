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


public class StatsFragment2 extends Fragment {
    ImageButton rightButton2 , leftButton2 , goToStatsButton2 ;
    PieChart chartView2 ;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public StatsFragment2() {

    }


    public static StatsFragment2 newInstance(String param1, String param2) {
        StatsFragment2 fragment = new StatsFragment2();
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
        View view = inflater.inflate(R.layout.fragment_stats2, container, false) ;

        chartView2 = view.findViewById(R.id.chartView2);

        rightButton2 = view.findViewById(R.id.rightButton2);

        leftButton2 = view.findViewById(R.id.leftButton2) ;

        goToStatsButton2 = view.findViewById(R.id.toStatsButton2);

        setUpNavButtons();

        PieChartAdapter.setUpPieChart(requireContext() , chartView2 , 1 , 2022);

        return  view ;
    }

    private void setUpNavButtons() {
        rightButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_statsFragment2_to_statsFragment3);

            }
        });
        leftButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_statsFragment2_to_navigation_stats);

            }
        });

        goToStatsButton2.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_statsFragment2_to_navigation_prediction);
            }
        });


    }
}