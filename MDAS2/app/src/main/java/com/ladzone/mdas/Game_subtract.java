package com.ladzone.mdas;

import java.util.ArrayList;
import java.util.List;

public class Game_subtract {


    private List<Question_subtract> questions ;



    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestion;
    private int score;
    private  Question_subtract currentQuestion;


    public Game_subtract(){
        numberCorrect= 0;
        numberIncorrect =0;
        totalQuestion = 0;
        score = 0;
        currentQuestion = new Question_subtract(10);
        questions = new ArrayList<Question_subtract>();
    }
    public void makeNewQuestion(){
        currentQuestion = new Question_subtract(totalQuestion * 2 + 5);
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



    public List<Question_subtract> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question_subtract> questions) {
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

    public Question_subtract getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question_subtract currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
