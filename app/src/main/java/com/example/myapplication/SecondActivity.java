package com.example.myapplication;

import static android.util.Log.println;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeText, luckyNumberText;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        welcomeText = findViewById(R.id.textView2);
        luckyNumberText = findViewById(R.id.textView3);
        share_btn = findViewById(R.id.button);

                //Receving Data From MainActivity
        Intent i = getIntent();
        String username = i.getStringExtra("name");//input var


        //generating Ramdom Numbers
        int random_num = randomNumberGenerated();
        luckyNumberText.setText(""+random_num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(username,
                        random_num);

            }
        });

    }

    public int randomNumberGenerated(){
        Random random = new Random();
        int upper_limit = 1000;
        int ramdomNumberGenerated = random.nextInt(upper_limit);
        return ramdomNumberGenerated;
    }

    public void shareData(String username, int randomNum){
        // Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        // Additional Info
        i.putExtra(Intent.EXTRA_SUBJECT,username + " got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is: "+randomNum);

        startActivity(Intent.createChooser(i,"Choose a Platform"));



    }
}