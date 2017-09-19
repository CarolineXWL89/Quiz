package com.example.caroline.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView question;
    private Button trueAns, falseAns, nextButton;
    private ArrayList<Question> questionList = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        onClickListeners();
        createQuestions();
    }

    private void onClickListeners(){
        trueAns.setOnClickListener(this);
        falseAns.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    private void createQuestions(){ //link tags
        questionList.add(new Question(getString(R.string.bike_competition), false));
        questionList.add(new Question(getString(R.string.legal_widow), false));
        questionList.add(new Question(getString(R.string.Holy_See), true));
        questionList.add(new Question(getString(R.string.potato_poison), true));
        questionList.add(new Question(getString(R.string.lobster), true));
        questionList.add(new Question(getString(R.string.Japanese_cannibal), false));
        questionList.add(new Question(getString(R.string.LSD), false));
        questionList.add(new Question(getString(R.string.countries), true));
    }

    private void wireWidgets() {
        trueAns = (Button) findViewById(R.id.button_true);
        falseAns = (Button) findViewById(R.id.button_false);
        nextButton = (Button) findViewById(R.id.button_next_question);
        question = (TextView) findViewById(R.id.text_view_text_question);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_true:
                checkAnswer();
                break;
            case R.id.button_false:
                checkAnswer();
                break;
            case R.id.button_next_question:

                break;
        }
    }
}
