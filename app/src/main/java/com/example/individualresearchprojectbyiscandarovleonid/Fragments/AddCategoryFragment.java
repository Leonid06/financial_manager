package com.example.individualresearchprojectbyiscandarovleonid.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.individualresearchprojectbyiscandarovleonid.Database.DBHelper;
import com.example.individualresearchprojectbyiscandarovleonid.Database.Models.CategoryModel;
import com.example.individualresearchprojectbyiscandarovleonid.Debug.Tags;
import com.example.individualresearchprojectbyiscandarovleonid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCategoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddCategoryFragment() {
    }
    public static AddCategoryFragment newInstance(String param1, String param2) {
        AddCategoryFragment fragment = new AddCategoryFragment();
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
        View view = inflater.inflate(R.layout.fragment_add_category, container, false);

        ImageButton checkButton = view.findViewById(R.id.checkButton) ;

        EditText categoryInputView = view.findViewById(R.id.category_name_input_view) ;

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DBHelper dbHelper = new DBHelper(requireContext()) ;
                    CategoryModel categoryModel= new CategoryModel(-1 , categoryInputView.getText().toString());
                    dbHelper.addCategory(categoryModel);

                    Navigation.findNavController(view).navigate(R.id.action_category_to_home);
                }catch (Exception e){
                    Log.e(Tags.ERROR , e.toString()) ;
                }

            }
        });

        return view;
    }
}