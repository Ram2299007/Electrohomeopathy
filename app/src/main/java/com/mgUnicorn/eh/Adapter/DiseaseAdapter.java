package com.mgUnicorn.eh.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mgUnicorn.eh.R;
import com.mgUnicorn.eh.models.DiseaseModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class DiseaseAdapter extends FirebaseRecyclerAdapter<DiseaseModel, DiseaseAdapter.myviewholder>{
    Context context;

    public DiseaseAdapter(@NonNull FirebaseRecyclerOptions<DiseaseModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull DiseaseModel model) {
        holder.text.setText(model.getName());
        holder.treatment.setText(model.getTreatment());

       // Glide.with(holder.img.getContext()).load(model.getImageUrl()).placeholder(R.drawable.backgroundbox).into(holder.img);



    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.diseas_row,parent,false);
        return new myviewholder(view);
    }

    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView text,treatment;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img=(ImageView) itemView.findViewById(R.id.m_image);
            text=(TextView) itemView.findViewById(R.id.diseasnameDiseas);
            treatment=(TextView) itemView.findViewById(R.id.treatmentDiseas);
        }
    }
}