package com.example.admin.fitness.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.fitness.Interface.ItemClickListener;
import com.example.admin.fitness.Model.Excercises;
import com.example.admin.fitness.R;
import com.example.admin.fitness.ViewExcercises;

import java.util.List;

class  RecyclerViewholder extends RecyclerView.ViewHolder implements View.OnClickListener
{

    public ImageView image;
    public TextView text;
    public ItemClickListener itemClickListener;

    public RecyclerViewholder(@NonNull View itemView) {
        super(itemView);
        image = (ImageView)itemView.findViewById(R.id.ex_img);
        text = (TextView) itemView.findViewById(R.id.ex_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void onClick(View View)
    {
        itemClickListener.onClick(View, getAdapterPosition());
    }
}
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewholder>
{
    private List<Excercises> excercisesList;
    private Context context;

    public RecyclerViewAdapter(List<Excercises> excercisesList, Context context) {
        this.excercisesList = excercisesList;
        this.context = context;
    }

    @Override
    public RecyclerViewholder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_excercises, parent, false);

        return new RecyclerViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewholder holder, int position)
    {
        holder.image.setImageResource(excercisesList.get(position).getImage_id());
        holder.text.setText(excercisesList.get(position).getName());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View View, int position) {
                //call to new Activity
                Intent intent = new Intent(context, ViewExcercises.class);
                intent.putExtra("image_id", excercisesList.get(position).getImage_id());
                intent.putExtra("name", excercisesList.get(position).getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return excercisesList.size();
    }
}
