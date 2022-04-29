package com.example.individualresearchprojectbyiscandarovleonid.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.individualresearchprojectbyiscandarovleonid.Adapters.HistoryAdapter;
import com.example.individualresearchprojectbyiscandarovleonid.Database.DBHelper;
import com.example.individualresearchprojectbyiscandarovleonid.R;

import java.util.ArrayList;


public class HistoryFragment extends Fragment {




    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HistoryFragment() {

    }

    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        HistoryAdapter historyAdapter ;

        ArrayList<String> dates , amounts , categories ;
        setHasOptionsMenu(true);
        RecyclerView historyListView = view.findViewById(R.id.history_list);
        DBHelper dbHelper = new DBHelper(requireContext()) ;


        dates = dbHelper.getDates() ;
        amounts = dbHelper.getAmounts();
        categories = dbHelper.getCategoryNames();


        historyAdapter = new HistoryAdapter(requireContext(),dates, amounts ,categories);
        historyListView.setAdapter(historyAdapter);
        historyListView.setLayoutManager(new LinearLayoutManager(requireContext()));


        return view;
    }


//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.delete_menu , menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
////        if(item.getItemId() == R.id.delete_all_button){
////            Toast.makeText(requireContext() , "Delete button pressed" , Toast.LENGTH_SHORT).show();
////            DBHelper dataBaseHelper = new DBHelper(requireContext()) ;
////            dataBaseHelper.deleteAllData();
////            getActivity().recreate();
////        }
//        return super.onOptionsItemSelected(item);
//    }
}