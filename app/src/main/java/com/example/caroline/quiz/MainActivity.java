package com.example.caroline.quiz;

import android.content.Intent;
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
    private Button trueAns, falseAns, nextButton, switchActivity;
    private ArrayList<Question> questionList = new ArrayList();
    //private String question;
    private int qNum = 0;
    private Question q;

    public static final String FINAL_SCORE = "finalScore";
    public static final String TAG = "MainActivity"; //TAG helps send things to log b/c convention
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        onClickListeners();
        createQuestions();



        //check if we're resuming from a previous state
        if(savedInstanceState != null){
            qNum = savedInstanceState.getInt("question number", 0);
        }
        //load first question
        questionText.setText(questionList.get(qNum).getQuestion());
    }

    private void onClickListeners(){
        trueAns.setOnClickListener(this);
        falseAns.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        switchActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                /*to change activiities, you make an Intent
                The intent describes where you're coming from, where you're going, and what if any info you're taking with you.
                */
                Intent i = new Intent(MainActivity.this, ScoreActivity.class);
                //packing our bags - putting data into the intent
                i.putExtra("message1", "Hello from main activity");
                //once the bags are packed, start the trip
                startActivity(i);
            }
        });

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
        switchActivity = (Button) findViewById(R.id.button_switch_activity);

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
            case R.id.button_switch_activity:

                break;
        }
    }

    /**
     * Checks the input answer against the real answer
     * @param correct User answer from the buttons
     * @return a string to make into a toast
     */
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

    /**
     * Returns the next question
     * @param qNum is the current number you're on
     * @return the question the next question is supposed to be
     */
    public Question switchQuestion(int qNum){
        //question = questionList.get(qNum).getQuestion();
        q = questionList.get(qNum + 1);
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

    //To prevent resetting during rotation, we use SavedInstaceState 

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: method fired");
        //saves the current question number
        outState.putInt("question number", qNum);
    }
}
