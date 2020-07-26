package com.ladzone.mdas;

import java.text.DecimalFormat;
import java.util.Random;

public class Question_divide {
    private  double firstNumer;
    private  double secondNumer;
    private  double answer;
    //4 choice from the user to pick
    private  double [] answerArray;

    // position 0-3
    private double answerPosition;

    // max value
    private  double upperLimit;

    //string out put
    private  String  questionPhrase;


    //generate a new rendom question

    public Question_divide(double upperLimit){
        this.upperLimit = upperLimit;
        Random randomNumberMaker = new Random();
       // this.firstNumer = randomNumberMaker.nextInt((int) upperLimit);
       // while (firstNumer%2 ==0)
        // this.firstNumer = randomNumberMaker.nextInt((100 +2 - 50)+50);
       // while (firstNumer%2 ==0)
                this.firstNumer = randomNumberMaker.nextInt(5);
                  double fn = (firstNumer*2+4)*2;
       // while (firstNumer%2 ==0)
            //this.secondNumer = randomNumberMaker.nextInt((int) upperLimit);

                   this.secondNumer = randomNumberMaker.nextInt(3);
                    double sn = secondNumer*2+4;

        this.answer = (fn) / (sn);

        this.questionPhrase = (fn+ "/" + sn+" = ");



        this.answerPosition = randomNumberMaker.nextInt(4);
        this.answerArray = new double[]{0,1,2,3};
        DecimalFormat df = new DecimalFormat("#.#");
        answer = Double.valueOf(df.format(answer));
        this.answerArray[0]= answer+1 ;
        this.answerArray[1]= answer+2;
        this.answerArray[2]= answer+3 ;
        this.answerArray[3]= answer+4 ;

        this.answerArray = shuffleArray(this.answerArray);
        answerArray[(int) answerPosition] = answer;
    }


    private  double [] shuffleArray(double[] array) {
        double index, temp;
        Random randomNumberGenerator = new Random();
        for (double i = array.length - 1; i> 0; i--){
            index = randomNumberGenerator.nextInt((int) (i+1));
            temp = array[(int) index];
            array[(int) index] = array[(int) i];
            array[(int) i] = temp;
        }
        return array;
    }

    public double getFirstNumer() {
        return firstNumer;
    }

    public void setFirstNumer(double firstNumer) {
        this.firstNumer = firstNumer;
    }

    public double getSecondNumer() {
        return secondNumer;
    }

    public void setSecondNumer(double secondNumer) {
        this.secondNumer = secondNumer;
    }

    public double getAnswer() {
        return answer;
    }

    public void setAnswer(double answer) {
        this.answer = answer;
    }

    public double [] getAnswerArray() {
        return answerArray;
    }

    public void setAnswerArray(double[] answerArray) {
        this.answerArray = answerArray;
    }

    public double getAnswerPosition() {
        return answerPosition;
    }

    public void setAnswerPosition(double answerPosition) {
        this.answerPosition = answerPosition;
    }

    public double getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(double upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getQuestionPhrase() {
        return questionPhrase;
    }

    public void setQuestionPhrase(String questionPhrase) {
        this.questionPhrase = questionPhrase;
    }
}
