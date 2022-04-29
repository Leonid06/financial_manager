package com.example.individualresearchprojectbyiscandarovleonid.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

//import com.anychart.anychart.AnyChartView;
//import com.anychart.AnyChart;
//import com.anychart.AnyChartView;
//import com.anychart.chart.common.dataentry.DataEntry;
//import com.anychart.charts.Pie;
import com.example.individualresearchprojectbyiscandarovleonid.Adapters.PieChartAdapter;
import com.example.individualresearchprojectbyiscandarovleonid.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class StatsFragment extends Fragment {

    PieChart chartView1;
    ImageButton rightButton1 ;
    ImageButton goToStatsButton1;





    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public StatsFragment() {
    }
    public static StatsFragment newInstance(String param1, String param2) {
        StatsFragment fragment = new StatsFragment();
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


         View view = inflater.inflate(R.layout.fragment_stats, container, false);

         chartView1 =  view.findViewById(R.id.chartView1) ;

         rightButton1 = view.findViewById(R.id.rightButton1) ;

         goToStatsButton1 = view.findViewById(R.id.toStatsButton1);

         setUpNavButtons();


         setUpNavButtons();

         PieChartAdapter.setUpPieChart(requireContext() , chartView1 , 12 , 2021);







        return view;
    }

    private void setUpNavButtons() {
        rightButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_stats_to_statsFragment2);
            }
        });

        goToStatsButton1.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_navigation_stats_to_navigation_prediction);
            }
        });
    }

//    private void setUpChart(){
//        ArrayList<Integer> colors = new ArrayList<>() ;
//        for(int color : ColorTemplate.MATERIAL_COLORS){
//            colors.add(color) ;
//        }
//        for(int color : ColorTemplate.VORDIPLOM_COLORS){
//            colors.add(color) ;
//        }
//
//
//        PieDataSet pieDataSet = new PieDataSet(PieChartAdapter.uploadData(12 , requireContext()) ,
//                "");
//
//        pieDataSet.setColors(colors);
//
//
//        PieData pieData = new PieData(pieDataSet);
//
//        pieData.setValueFormatter(new PercentFormatter());
//        pieData.setValueTextSize(12f);
//
//        chartView1.setData(pieData);
//        chartView1.setUsePercentValues(true);
//        chartView1.setDrawHoleEnabled(true);
//        chartView1.setEntryLabelColor(Color.BLACK);
//        chartView1.setCenterText("Декабрь 2021");
//        chartView1.setCenterTextSize(25f);
//
//    }


}