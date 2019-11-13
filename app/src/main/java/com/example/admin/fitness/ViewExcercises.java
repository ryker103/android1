package com.example.admin.fitness;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewExcercises extends AppCompatActivity {

    int image_id;
    String name;
    TextView timer, title;
    ImageView detail_image;
    Button btnStart;

    boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_excercises);

        timer = (TextView)findViewById(R.id.timer);
        title = (TextView)findViewById(R.id.title1);
        detail_image = (ImageView)findViewById(R.id.detail_image);
        btnStart = (Button)findViewById(R.id.butStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isRunning)
                {
                    btnStart.setText("DONE");
                    new CountDownTimer(20000, 1000) {
                        @Override
                        public void onTick(long l) {
                            timer.setText(""+1/1000);
                        }

                        @Override
                        public void onFinish() {
                            //you cant put Ads here
                            Toast.makeText(ViewExcercises.this, "Finish", Toast.LENGTH_SHORT).show();
                            finish();

                        }
                    }.start();
                }
                else
                {
                    Toast.makeText(ViewExcercises.this, "Finish", Toast.LENGTH_SHORT).show();
                    finish();
                }

                isRunning = !isRunning;
            }
        });

        timer.setText("");

        if(getIntent() != null)
        {
            image_id = getIntent().getIntExtra("image_id", -1);
            name = getIntent().getStringExtra("name");
            detail_image.setImageResource(image_id);
            title.setText(name);

        }
    }
}
