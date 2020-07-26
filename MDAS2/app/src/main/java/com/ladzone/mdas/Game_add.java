package com.ladzone.mdas;

import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class Game_add {

    private  List<Question_add>questions ;
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestion;
    private int score;
    private  Question_add currentQuestion;


    public Game_add(){
    numberCorrect= 0;
    numberIncorrect =0;
    totalQuestion = 0;
    score = 0;
    currentQuestion = new Question_add(10);
    questions = new ArrayList<Question_add>();
    }
    public void makeNewQuestion(){
        currentQuestion = new Question_add(totalQuestion * 2 + 5);
        totalQuestion++;
        questions.add(currentQuestion);
    }


    public boolean checkAnswer(int submittedAnswer) {
        boolean isCorrect;
        if (currentQuestion.getAnswer() == submittedAnswer) {
            numberCorrect++;
            isCorrect = true;
        } else {
            numberIncorrect++;
            isCorrect = false;
        }
        score = numberCorrect * 10 - numberIncorrect *30;
        return  isCorrect;
    }
    public List<Question_add> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question_add> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public int getNumberIncorrect() {
        return numberIncorrect;
    }

    public void setNumberIncorrect(int numberIncorrect) {
        this.numberIncorrect = numberIncorrect;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question_add getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question_add currentQuestion) {
        this.currentQuestion = currentQuestion;
    }



}
