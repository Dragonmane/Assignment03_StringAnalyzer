package com.example.ted1g.theguesinggameassignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GuessingActivity extends AppCompatActivity
{
    Button buttonCheck;
    TextView enterNumber;
    Random numRandom = new Random();

    int hideRandom = numRandom.nextInt(20) +1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        final Button buttonCheck = (Button)findViewById(R.id.buttonCheck);
        Bundle extras = this.getIntent().getExtras();
        int upperLimit = extras.getInt("upperLimit");

        final int randomNumber = (int)(Math.random()*upperLimit + 1);

        buttonCheck.setOnClickListener(new View.OnClickListener()
        {
            int clickCount = 0;


            @Override
            public void onClick(View view)
            {
                EditText enterNumberEditText = (EditText) findViewById(R.id.enterNumber);
                int enterNumber = Integer.parseInt(enterNumberEditText.getText().toString());

                String message;

                if (enterNumber == randomNumber)
                {
                    Toast.makeText(GuessingActivity.this, "Congratulations! You guessed the correct number", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(GuessingActivity.this, ResultsActivity.class);
                    intent.putExtra("clicks", clickCount);
                }
                else if (enterNumber < randomNumber)
                {
                    Toast.makeText(GuessingActivity.this, "To high, please pick a number that is smaller", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GuessingActivity.this, "To low, please pick a higher number", Toast.LENGTH_SHORT).show();
                }

                clickCount = clickCount + 1;
            }
        });
    }
}
