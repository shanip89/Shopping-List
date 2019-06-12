package com.example.ahova.shoppinglist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {


    List<ShoppingList> products;

    public ListAdapter(List<ShoppingList> products) {
        this.products = products;

    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.product.setText(products.get(i).getProduct());
        viewHolder.date.setText(products.get(i).getDatePurchased());
        viewHolder.dateExpired.setText(products.get(i).getExpired());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView product;
        public TextView date;
        public TextView dateExpired;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product = itemView.findViewById(R.id.product_list);
            date = itemView.findViewById(R.id.date_list);
            dateExpired = itemView.findViewById(R.id.date_expired);

        }
    }
}
