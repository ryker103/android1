package com.example.admin.fitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YogaActivity extends AppCompatActivity {

    Button btnExercise, btnSetting, btnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        btnExercise = findViewById(R.id.butExercises);
        btnSetting = findViewById(R.id.butSetting);
        btnCalendar = findViewById(R.id.butLich);

        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YogaActivity.this, ListExcersesActivity.class);
                startActivity(intent);
            }
        });
    }
}
