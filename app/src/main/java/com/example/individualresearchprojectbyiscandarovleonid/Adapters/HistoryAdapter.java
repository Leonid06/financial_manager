package com.example.individualresearchprojectbyiscandarovleonid.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.individualresearchprojectbyiscandarovleonid.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private Context context ;
    private ArrayList<String> dates , amounts, categories;
    public HistoryAdapter(Context context, ArrayList<String> dates,
                          ArrayList<String> amounts,
                          ArrayList<String> categories
                         ){
        this.context = context ;
        this.dates = dates ;
        this.amounts = amounts ;
        this.categories = categories ;

    }
    @NonNull
    @Override
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_row_view , parent , false) ;
        return new HistoryAdapter.MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {
        holder.dateView.setText(dates.get(position));
        holder.amountView.setText(amounts.get(position));
        holder.categoryView.setText(categories.get(position));

    }

    @Override
    public int getItemCount() {
        return dates.size() ;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dateView , amountView , categoryView ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dateView = itemView.findViewById(R.id.dateView);
            amountView = itemView.findViewById(R.id.amountView);
            categoryView = itemView.findViewById(R.id.categoryView) ;
        }
    }
}
