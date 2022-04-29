package com.example.individualresearchprojectbyiscandarovleonid.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

//import com.anychart.chart.common.dataentry.DataEntry;
//import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.example.individualresearchprojectbyiscandarovleonid.Database.DBHelper;
import com.example.individualresearchprojectbyiscandarovleonid.Debug.Tags;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;

public class PieChartAdapter {
    static public ArrayList<PieEntry> uploadMonthData(int month  , Context context){
        DBHelper dbHelper = new DBHelper(context) ;
        ArrayList<PieEntry> dataEntries = new ArrayList<>();

        ArrayList<String> categoryNames  = new ArrayList(dbHelper.getCategories().values());

        ArrayList<Integer> categoryAmounts = new ArrayList<>();

        for(int i = 0 ; i < categoryNames.size() ; i++){
            int categoryId = Integer.parseInt(dbHelper.getIdByCategoryName(categoryNames.get(i)));
            int categoryAmount = dbHelper.getAmountByMonthAndCategory(month , categoryId) ;
            categoryAmounts.add(categoryAmount);
            Log.i(Tags.INFO , categoryNames.get(i) + " : " + categoryAmounts.get(i));
        }

        for(int i =0 ; i < categoryNames.size() ; i++){
            dataEntries.add(new PieEntry(categoryAmounts.get(i) ,categoryNames.get(i)
            ));
        }
        return dataEntries ;


    }

    static public ArrayList<PieEntry> uploadPredictionData(Context context) {
        DBHelper dbHelper = new DBHelper(context);

        ArrayList<PieEntry> entries = new ArrayList<>();

        ArrayList<String> categoryNames = new ArrayList(dbHelper.getCategories().values());

        ArrayList<Integer> categoryAmounts = new ArrayList<>();


        for (int i = 0; i < categoryNames.size(); i++) {
            int category_id = Integer.parseInt(dbHelper.getIdByCategoryName(categoryNames.get(i)));
            int categoryAmount = (int) Math.round(PieChartAdapter.getAverage
                    (dbHelper.getSumForMonthByCategoryId(12, category_id),
                            dbHelper.getSumForMonthByCategoryId(1, category_id),
                            dbHelper.getSumForMonthByCategoryId(2, category_id)));
            categoryAmounts.add(categoryAmount);
        }

        for (int i = 0; i < categoryNames.size(); i++) {
            entries.add(new PieEntry(categoryAmounts.get(i), categoryNames.get(i)
            ));
        }
        return entries;
    }
    static public void setUpPieChart(Context context , PieChart chartView , int month , int year ){

        PieDataSet pieDataSet ;

        ArrayList<Integer> colors = new ArrayList<>() ;
        for(int color : ColorTemplate.MATERIAL_COLORS){
            colors.add(color) ;
        }
        for(int color : ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color) ;
        }
        for(int color : ColorTemplate.COLORFUL_COLORS){
            colors.add(color) ;
        }


        pieDataSet = new PieDataSet(PieChartAdapter.uploadMonthData(month, context) ,
                    "");



        pieDataSet.setColors(colors);


        PieData pieData = new PieData(pieDataSet);

//        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(15f);

        chartView.setData(pieData);
//        chartView.setUsePercentValues(true);
        chartView.setDrawHoleEnabled(true);
        chartView.setEntryLabelColor(Color.BLACK);
        chartView.setCenterText(getMonth(month) + " " + year);
        chartView.setCenterTextSize(25f);
        chartView.getDescription().setEnabled(false);
    }

    static public void setUpPieChart(Context context , PieChart chartView ){

        PieDataSet pieDataSet ;

       ArrayList<Integer> colors = new ArrayList<>() ;

        for(int color : ColorTemplate.MATERIAL_COLORS){
            colors.add(color) ;
        }
        for(int color : ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color) ;
        }
        for(int color : ColorTemplate.COLORFUL_COLORS){
            colors.add(color) ;
        }


        pieDataSet = new PieDataSet(PieChartAdapter.uploadPredictionData(context) ,
                "");



        pieDataSet.setColors(colors);


        PieData pieData = new PieData(pieDataSet);

//        pieData.setValueFormatter(new PercentFormatter());
        pieData.setValueTextSize(15f);

        chartView.setData(pieData);
//        chartView.setUsePercentValues(true);
        chartView.setDrawHoleEnabled(true);
        chartView.setEntryLabelColor(Color.BLACK);
        chartView.setCenterText("Прогноз на следующий месяц");
        chartView.setCenterTextSize(25f);
        chartView.getDescription().setEnabled(false);
    }

    static String getMonth(int month){
        HashMap<Integer , String> months  = new HashMap<>();
        months.put(1 , "Январь") ;
        months.put(2 , "Февраль") ;
        months.put(3 , "Март") ;
        months.put(4 , "Апрель") ;
        months.put(5 , "Май") ;
        months.put(6 , "Июнь") ;
        months.put(7 , "Июль") ;
        months.put(8 , "Август") ;
        months.put(9 , "Сентябрь") ;
        months.put(10 , "Октябрь") ;
        months.put(11 , "Ноябрь") ;
        months.put(12 , "Декабрь") ;

         return months.get(month);
    }

    static public  double getAverage(int a , int b , int c){

        double average =  (a + b + c)/ 3;

        return average ;
    }
}
