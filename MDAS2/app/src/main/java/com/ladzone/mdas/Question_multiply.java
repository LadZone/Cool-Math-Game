package com.ladzone.mdas;

import java.util.Random;

public class Question_multiply {


    private  int firstNumer;
    private  int secondNumer;
    private  int answer;
    //4 choice from the user to pick
    private  int [] answerArray;

    // position 0-3
    private int answerPosition;

    // max value
    private  int upperLimit;

    //string out put
    private  String  questionPhrase;


    //generate a new rendom question

    public Question_multiply(int upperLimit){
        this.upperLimit = upperLimit;
        Random randomNumberMaker = new Random();
        this.firstNumer = randomNumberMaker.nextInt(upperLimit);
        this.secondNumer = randomNumberMaker.nextInt(upperLimit);
        this.answer = this.firstNumer * this.secondNumer;

        this.questionPhrase = firstNumer + "X" + secondNumer +" = ";



        this.answerPosition = randomNumberMaker.nextInt(4);
        this.answerArray = new int[]{0,1,2,3};
        this.answerArray[0]= answer +1;
        this.answerArray[1]= answer +10;
        this.answerArray[2]= answer -5;
        this.answerArray[3]= answer -3;

        this.answerArray = shuffleArray(this.answerArray);
        answerArray[answerPosition] = answer;
    }


    private  int [] shuffleArray(int[] array) {
        int index, temp;
        Random randomNumberGenerator = new Random();
        for (int i = array.length - 1; i> 0; i--){
            index = randomNumberGenerator.nextInt(i+1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public int getFirstNumer() {
        return firstNumer;
    }

    public void setFirstNumer(int firstNumer) {
        this.firstNumer = firstNumer;
    }

    public int getSecondNumer() {
        return secondNumer;
    }

    public void setSecondNumer(int secondNumer) {
        this.secondNumer = secondNumer;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(int[] answerArray) {
        this.answerArray = answerArray;
    }

    public int getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(int answerPosition) {
        this.answerPosition = answerPosition;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }

}
