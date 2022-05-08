package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StateAdapter extends ArrayAdapter<State> {
    public StateAdapter (Context context, int resource, List<State> stateList){
        super(context, resource, stateList);
    }

    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        State state = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.dogname);
        TextView textView2 = convertView.findViewById(R.id.dogdescription);
        TextView textView3 = convertView.findViewById(R.id.dogsecondporoda);
        ImageView imageView = convertView.findViewById(R.id.picture);

        textView.setText(state.getPoroda());
        textView2.setText(state.getDescription());
        textView3.setText(state.getSecondporoda());
        imageView.setImageResource(state.getImagedog());



        return convertView;
    }
}
