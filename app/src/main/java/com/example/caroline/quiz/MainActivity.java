package com.example.caroline.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView questionText;
    private Button trueAns, falseAns, nextButton;
    private ArrayList<Question> questionList = new ArrayList();
    private String question;
    private int qNum = 0;
    private Question q;

    public static final String TAG = "MainActivity"; //TAG helps send things to log b/c convenetion
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
        questionText = (TextView) findViewById(R.id.text_view_text_question);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_true:
                String yN = checkAnswer(true);
                Toast.makeText(this, yN, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_false:
                String yn = checkAnswer(false);
                Toast.makeText(this, yn, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_next_question:
                switchQuestion(qNum);
                break;
        }
    }

    public String checkAnswer(boolean correct) {
        q = questionList.get(qNum);
        boolean tF = q.isAnswer();
        if (correct == tF) {
            qNum++;
            return "You're correct!";
        } else {
            qNum++;
            return "Wrong!!!";
        }
    }

    public Question switchQuestion(int qNum){
        question = questionList.get(qNum).getQuestion();
        q = questionList.get(qNum);
        return q;
    }

    //Android Lifecycle Methods
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: method fired");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: method fired");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: method fired");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: method fired");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: method fired");
    }


}
