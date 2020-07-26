package com.ladzone.mdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Divide extends AppCompatActivity {
    Button btn_start, btn_answer0, btn_answer1,btn_answer2, btn_answer3;
    TextView tv_score, tv_questions, tv_timer, tv_bottomMsg, tv_highScore;
    ProgressBar prog_timer;
    CountDownTimer countDownTimer;
    private InterstitialAd mInterstitialAd;

    Game_divide g = new Game_divide();
    double secondsRemaining= 30;

    CountDownTimer timer = new CountDownTimer( 30000, 1000) {
        @Override
        public void onTick(long l) {
            secondsRemaining--;
            tv_timer.setText(Double.toString(secondsRemaining) + " SEC");
            prog_timer.setProgress((int) (30.0 - secondsRemaining));
        }

        @Override
        public void onFinish() {
            btn_answer0.setEnabled(false);
            btn_answer1.setEnabled(false);
            btn_answer2.setEnabled(false);
            btn_answer3.setEnabled(false);
            tv_bottomMsg.setText("Time is up " + g.getNumberCorrect() + " / " + (g.getTotalQuestion() -1));



            if(countDownTimer!=null){
                countDownTimer.cancel();
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {

                }
            }

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    btn_start.setVisibility(View.VISIBLE);
                }
            },4000);


        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divide);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-4098906430114540/8325776721");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("DIVIDE");

        btn_start = findViewById(R.id.btn_start);
        btn_answer0 = findViewById(R.id.answer_1_div);
        btn_answer1 = findViewById(R.id.answer_2_div);
        btn_answer2 = findViewById(R.id.answer_3_div);
        btn_answer3 = findViewById(R.id.answer_4_div);
        prog_timer = findViewById(R.id.prog_time_div);

        tv_score = findViewById(R.id.tv_score_div);
        tv_questions = findViewById(R.id.tv_questions_div);
        tv_timer = findViewById(R.id.tv_timeer_div);
        tv_bottomMsg = findViewById(R.id.tv_bottomMsg_div);
        tv_highScore = findViewById(R.id.tv_HighScore);


        tv_score.setText("0 PTS");
        tv_questions.setText("");
        tv_timer.setText("0 SEC");
        tv_bottomMsg.setText("Press START");
        prog_timer.setProgress(0);
        tv_highScore.setText("HIGH SCORE");
        btn_start.setText("START");
        disableButtons();
        View.OnClickListener StartButtonClickListener=new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                if(countDownTimer!=null){
                    countDownTimer.cancel();
                }

                countDownTimer = new CountDownTimer(3000, 1000) {

                    @Override
                    public void onFinish() {


                        //
                        Button start_button = (Button) view;
                        start_button.setText("Go Again");
                        start_button.setVisibility(View.INVISIBLE);
                        secondsRemaining = 30;
                        g = new Game_divide();
                        highScore();
                        nextTurn();
                        timer.start();


                        // btn_start.setText("START");
                    }

                    @Override
                    public void onTick(long millisUntilFinished) {
                        btn_start.setText(String.valueOf(millisUntilFinished/1000));

                    }






                };

                countDownTimer.start();



            }
        };


        final View.OnClickListener answerButtonClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Button ButtenClick = (Button) view;

                double answerSelected =Double.parseDouble(ButtenClick.getText().toString());
                // Toast.makeText(Add.this, "Answer =" + answerSelected,Toast.LENGTH_SHORT).show();
                g.checkAnswer(answerSelected);
                tv_score.setText(Integer.toString(g.getScore()) + " PTS");
                highScore();
                nextTurn();

            }
        };



        btn_start.setOnClickListener(StartButtonClickListener);
        btn_answer0.setOnClickListener(answerButtonClickListener);
        btn_answer1.setOnClickListener(answerButtonClickListener);
        btn_answer2.setOnClickListener(answerButtonClickListener);
        btn_answer3.setOnClickListener(answerButtonClickListener);
    }

    private void nextTurn(){

        g.makeNewQuestion();
        double [] answer= g.getCurrentQuestion().getAnswerArray();
        btn_answer0.setText(Double.toString(answer[0]));
        btn_answer1.setText(Double.toString(answer[1]));
        btn_answer2.setText(Double.toString(answer[2]));
        btn_answer3.setText(Double.toString(answer[3]));

        btn_answer3.setEnabled(true);
        btn_answer0.setEnabled(true);
        btn_answer1.setEnabled(true);
        btn_answer2.setEnabled(true);



        tv_questions.setText(g.getCurrentQuestion().getQuestionPhrase());
        tv_bottomMsg.setText(g.getNumberCorrect() + "/" + (g.getTotalQuestion()-1));
    }
    public void disableButtons()
    {
        btn_answer0.setEnabled(false);
        btn_answer3.setEnabled(false);
        btn_answer1.setEnabled(false);
        btn_answer2.setEnabled(false);
    }

    private void highScore(){
        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE_DIVIDE", 0);
        if (g.getScore() > highScore){

            tv_highScore.setText("High Score: " + g.getScore());

            //save
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH_SCORE_DIVIDE", g.getScore());
            editor.commit();

        }else {

            tv_highScore.setText("High Score: " + highScore);
        }
    }
    }
