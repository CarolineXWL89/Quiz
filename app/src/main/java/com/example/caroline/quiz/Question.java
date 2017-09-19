package com.example.caroline.quiz;

import java.util.ArrayList;

/**
 * Created by princ on 15/09/2017.
 */

public class Question {
    private String question;
    private boolean answer;

    public Question(String question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isAnswer() {
        return answer;
    }

    //write the check answer method that returns whether or not the supplied boolean answer matches the real answer
    /**
     * @param userAnswer what the user selected
     * @return true if answers match, false otherwise
     */
    public boolean checkAnswer(boolean userAnswer){
        return answer == userAnswer;
    }
}
