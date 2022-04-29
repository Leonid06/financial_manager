package com.example.individualresearchprojectbyiscandarovleonid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.individualresearchprojectbyiscandarovleonid.Database.Additional.Selectors;
import com.example.individualresearchprojectbyiscandarovleonid.Database.DBHelper;
import com.example.individualresearchprojectbyiscandarovleonid.Database.Models.CategoryModel;
import com.example.individualresearchprojectbyiscandarovleonid.Database.Models.RequestModel;
import com.example.individualresearchprojectbyiscandarovleonid.Fragments.Dialogs.MyDatePicker;
import com.example.individualresearchprojectbyiscandarovleonid.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment{


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        AutoCompleteTextView autoCompleteTextView = view.findViewById(R.id.autoCompleteTextView);
        EditText priceInput = view.findViewById(R.id.priceInput);
        EditText nameInput = view.findViewById(R.id.nameInput);
        Button submitButton = view.findViewById(R.id.submit_button);
        Button datePickButton = view.findViewById(R.id.datePickButton) ;
        Button addCategoryButton = view.findViewById(R.id.addCategoryButton);
        Selectors selectors = new Selectors() ;

        MyDatePicker datePicker = new MyDatePicker(datePickButton , requireContext());


        datePickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.showDatePickerDialog();
            }
        });



        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DBHelper dbHelper = new DBHelper(requireContext()) ;

                String categoryName = adapterView.getItemAtPosition(i).toString() ;

                selectors.setIdSelectedByUser(dbHelper.getIdByCategoryName(categoryName)) ;
                selectors.setCategorySelectedByUser(categoryName);
            }
        });

        submitButton.setOnClickListener(view1 -> {
            RequestModel requestModel;
            CategoryModel categoryModel ;
            try{
                 requestModel = new RequestModel(-1 ,
                        datePicker.day , datePicker.month,
                        datePicker.year, nameInput.getText().toString() , -1 ,
                        Integer.parseInt(priceInput.getText().toString())
                );
                 categoryModel =  new CategoryModel(
                         Integer.parseInt(selectors.getIdSelectedByUser()),
                         selectors.getCategorySelectedByUser());

            }catch (Exception e){
                Toast.makeText(requireContext() , "Error in request", Toast.LENGTH_SHORT).show();
                requestModel = new RequestModel(-1 , -1 , -1 , -1 , "error" , -1 ,
                        -1) ;
                categoryModel = new CategoryModel(-1 , "error") ;
                Log.e("ERROR" , e.toString());
                ;
            }
            DBHelper dbHelper = new DBHelper(requireContext());

            boolean success = dbHelper.addNewRequest(requestModel , categoryModel);

            Toast.makeText(requireContext(), "Success = " + success, Toast.LENGTH_SHORT).show();
        });

        addCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_home_to_category);
            }
        });







        DBHelper dbHelper = new DBHelper(requireContext()) ;
        ArrayList<String> categories = new ArrayList<>(dbHelper.getCategories().
                values());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext() , R.layout.drop_down_item ,
                categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        autoCompleteTextView.setAdapter(adapter);




        return view;
    }

}