package com.ladzone.mdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {
    private Button add,subtract,multiply,divide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        add =(Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openADD();
            }
        });



        subtract =(Button) findViewById(R.id.Subtract);
        subtract.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            openSubtract();
        }
    });

        multiply = (Button) findViewById(R.id.Multiply);
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            openMultiply();
            }
        });

        divide = (Button) findViewById(R.id.Divide);
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDivide();
            }
        });
}
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.manu, menu);
        return true;
    }


 */
    public void openADD(){
        Intent intent = new Intent(this, Add.class);
        startActivity(intent);
    }

    public void openSubtract(){
        Intent intent = new Intent(this, Subtract.class);
        startActivity(intent);
    }


    public void openMultiply(){
        Intent intent = new Intent(this, Multiply.class);
        startActivity(intent);
    }
    public void openDivide(){
        Intent intent = new Intent(this, Divide.class);
        startActivity(intent);
    }

}