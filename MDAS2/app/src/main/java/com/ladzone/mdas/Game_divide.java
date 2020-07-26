package com.ladzone.mdas;

import java.util.ArrayList;
import java.util.List;

public class Game_divide {
    private  List<Question_divide>questions ;
    private int numberCorrect;
    private int numberIncorrect;
    private int totalQuestion;
    private double score;
    private  Question_divide currentQuestion;



    public Game_divide(){
        numberCorrect= 0;
        numberIncorrect =0;
        totalQuestion = 0;
        score = 0;
        currentQuestion = new Question_divide(10);
        questions = new ArrayList<Question_divide>();
    }
    public void makeNewQuestion(){
        currentQuestion = new Question_divide(totalQuestion * 2 + 5);
        totalQuestion++;
        questions.add(currentQuestion);
    }


    public boolean checkAnswer(double submittedAnswer) {
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
    public List<Question_divide> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question_divide> questions) {
        this.questions = questions;
    }

    public int getNumberCorrect() {
        return numberCorrect;
    }

    public void setNumberCorrect(int numberCorrect) {
        this.numberCorrect = numberCorrect;
    }

    public double getNumberIncorrect() {
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
        return (int) score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Question_divide getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question_divide currentQuestion) {
        this.currentQuestion = currentQuestion;
    }
}
