package com.example.admin.fitness;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.fitness.Adapter.RecyclerViewAdapter;
import com.example.admin.fitness.Model.Excercises;

import java.util.ArrayList;
import java.util.List;

public class ListExcersesActivity extends AppCompatActivity
{
    List<Excercises> excercisesList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_excerses);

        initData();

        recyclerView = (RecyclerView)findViewById(R.id.list_ds);
        adapter = new RecyclerViewAdapter(excercisesList, getBaseContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initData()
    {
        excercisesList.add(new Excercises(R.drawable.easy_pose, "Easy_Post"));
        excercisesList.add(new Excercises(R.drawable.cobra_pose, "Cobra_Pose"));
        excercisesList.add(new Excercises(R.drawable.downward_facing_dog, "Downward_Facing_Dog"));
        excercisesList.add(new Excercises(R.drawable.boat_pose, "Boat_Pose"));
        excercisesList.add(new Excercises(R.drawable.half_pigeon, "Half_Pigeon"));
        excercisesList.add(new Excercises(R.drawable.low_lunge, "Low_Lunge"));
        excercisesList.add(new Excercises(R.drawable.upward_bow, "Upward_Bow"));
        excercisesList.add(new Excercises(R.drawable.crescent_lunge, "Crescent_Lunge"));
        excercisesList.add(new Excercises(R.drawable.warrior_pose, "Warrior_Pose"));
        excercisesList.add(new Excercises(R.drawable.bow_pose, "Bow_Pose"));
        excercisesList.add(new Excercises(R.drawable.warrior_pose_2, "Warrior_Pose_2"));

    }
}
