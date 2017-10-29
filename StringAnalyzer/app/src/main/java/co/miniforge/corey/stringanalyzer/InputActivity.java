package co.miniforge.corey.stringanalyzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity
{
    public static String intentTag = "inputData";

    EditText input;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        locateViews();

        bindFunctionality();
    }

    public void locateViews()
    {
        input = (EditText) findViewById(R.id.stringToAnalyzeEditText);
        submit = (Button) findViewById(R.id.submitButton);
    }

    public void bindFunctionality()
    {
        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //inputMessage = input.getText().toString();
                if (input.getText().toString().matches(""))
                {
                    Toast.makeText(InputActivity.this, "Please enter a message", Toast.LENGTH_SHORT).show();
                } else
                {
                    Intent intent = new Intent(getApplicationContext(), AnalyzerActivity.class);
                    intent.putExtra(intentTag, input.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
