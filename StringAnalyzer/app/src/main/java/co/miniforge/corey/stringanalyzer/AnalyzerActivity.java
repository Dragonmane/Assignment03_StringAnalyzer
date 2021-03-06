package co.miniforge.corey.stringanalyzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AnalyzerActivity extends AppCompatActivity {

    String message = "";

    TextView messageTextView;
    Button backToInputButton;

    TextAnalyzerUtil textUtil;

    TextView uniqueWords;
    TextView characterCount;
    TextView wordCount;
    TextView uniqueCharacters;
    TextView longestWord;
    TextView specialCharactersCount;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyzer);

        getIntentData();

        textUtil = new TextAnalyzerUtil(message);

        locateViews();

        bindData();
    }

    public void locateViews() {
        this.messageTextView = (TextView) findViewById(R.id.messageTextView);
        this.characterCount = (TextView) findViewById(R.id.characterCount);
        this.wordCount = (TextView) findViewById(R.id.wordCount);
        this.uniqueCharacters = (TextView) findViewById(R.id.uniqueCharacters);
        this.uniqueWords = (TextView) findViewById(R.id.uniqueWords);
        this.longestWord = (TextView) findViewById(R.id.longestWord);
        this.specialCharactersCount = (TextView) findViewById(R.id.specialCharactersCount);
        this.backToInputButton = (Button) findViewById(R.id.backToInputButton);
    }

    public void getIntentData(){
        if(getIntent().hasExtra(InputActivity.intentTag)){
            this.message = getIntent().getStringExtra(InputActivity.intentTag);

            //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public void bindData(){
        messageTextView.setText(message);

        characterCount.setText(String.format("Character Count: %d", textUtil.getTextCharacterCount()));
        wordCount.setText(String.format("Word Count: %d", textUtil.getWordCount()));
        uniqueWords.setText(String.format("Unique Words: %d", textUtil.getUniqueWords()));
        longestWord.setText(String.format("Longest word: %d", textUtil.getLongestWord()));
        uniqueCharacters.setText(String.format("Unique Characters: %d", textUtil.getUniqueCharacters()));
        specialCharactersCount.setText(String.format("Special Characters: %d", textUtil.getSpecialCharacterCount()));
    }

    public void onClickListener(View view)
    {
        Intent intent = new Intent(AnalyzerActivity.this, InputActivity.class);
        startActivity(intent);
    }
}
