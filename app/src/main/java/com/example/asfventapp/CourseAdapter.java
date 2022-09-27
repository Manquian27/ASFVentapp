package com.example.asfventapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{

    ArrayList<String> listDatos;

    public CourseAdapter(ArrayList<String>listDatos) {
        this.listDatos = listDatos;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.noticias_list,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        holder.asignarDatos(listDatos.get(position));

    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dato;

        public ViewHolder( View itemView) {
            super(itemView);
            dato=itemView.findViewById(R.id.text1);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
}
