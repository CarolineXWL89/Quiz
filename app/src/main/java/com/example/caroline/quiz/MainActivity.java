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
    }

    private void onClickListeners(){
        trueAns.setOnClickListener(this);
        falseAns.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    private void createQuestions(){
        questionList.add(new Question("The annual French bike competition is called Le Voyage de France", false));
        questionList.add(new Question("Is it legal for the man to marry his widow's sister in Germany?", false));
        questionList.add(new Question("The Holy See is a country in it's own right.", true));
        questionList.add(new Question("Potatoes include a poison known as solanine that can kill you if you pet them.", true));
        questionList.add(new Question("Were lobsters used as fertiliser and pig feed in the 19th century?", true));
        questionList.add(new Question("There is a cannibal living free and with celebrity status in Japan.", false));
        questionList.add(new Question("The LSD sect of Christianity practices cult-like behaviour.", false));
        questionList.add(new Question("Austria is different from Australia.", true));
    }

    private void wireWidgets() {
        trueAns = (Button) findViewById(R.id.button_true);
        falseAns = (Button) findViewById(R.id.button_false);
        nextButton = (Button) findViewById(R.id.button_next_question);
        question = (TextView) findViewById(R.id.text_view_text_question);
    }

    public void checkAnswer(){
        //check answers against the arraylist
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
