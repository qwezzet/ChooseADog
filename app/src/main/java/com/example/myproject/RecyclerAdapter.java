package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    Context context;
    List<ClassForRecycler> recycler_list;

    public RecyclerAdapter(Context context, List<ClassForRecycler> recycler_list) {
        this.context = context;
        this.recycler_list = recycler_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (recycler_list != null && recycler_list.size() > 0) {
            ClassForRecycler model = recycler_list.get(position);
            holder.desctb_nm.setText(model.getSize());
            holder.desctb_1.setText(model.getDesc_1());
            holder.desctb_2.setText(model.getDesc_2());
            holder.desctb_3.setText(model.getDesc_3());
        } else {
            return;
        }
    }


    @Override
    public int getItemCount() {
        return recycler_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView desctb_nm, desctb_1, desctb_2, desctb_3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            desctb_nm = itemView.findViewById(R.id.desctb_nm);
            desctb_1 = itemView.findViewById(R.id.desctb_1);
            desctb_2 = itemView.findViewById(R.id.desctb_2);
            desctb_3 = itemView.findViewById(R.id.desctb_3);

        }
    }
}
