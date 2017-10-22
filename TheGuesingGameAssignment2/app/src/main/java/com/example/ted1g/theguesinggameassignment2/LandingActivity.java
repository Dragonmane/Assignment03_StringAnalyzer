package com.example.ted1g.theguesinggameassignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    public void onStartClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), GuessingActivity.class);
        startActivity(intent);
    }
}
