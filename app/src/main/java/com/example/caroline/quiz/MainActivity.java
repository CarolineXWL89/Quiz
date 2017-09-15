package com.example.caroline.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private Button trueAns, falseAns, nextButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
    }

    private void wireWidgets() {
        trueAns = (Button) findViewById(R.id.button_true);
        falseAns = (Button) findViewById(R.id.button_false);
        nextButton = (Button) findViewById(R.id.button_next_question);
        question = (TextView) findViewById(R.id.text_view_text_question);
    }
}
