package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private boolean questionAnswered = false;

    private boolean assignAnswer (int questionNumber) {

        boolean answer = true;

        switch (questionNumber) {

            case 0:
                answer = true;
                break;

            case 1:
                answer = true;
                break;

            case 2:
                answer = false;
                break;

            case 3:
                answer = true;
                break;

            case 4:
                answer = false;
                break;

        }

        return answer;

    }

    private int assignQuestion (int questionNumber) {

        int question = 0;

        switch (questionNumber) {

            case 0:
                question = R.string.question_text1;
                break;

            case 1:
                question = R.string.question_text2;
                break;

            case 2:
                question = R.string.question_text3;
                break;

            case 3:
                question = R.string.question_text4;
                break;

            case 4:
                question = R.string.question_text5;
                break;
            
        }

        return question;

    }

    private void setButtons(boolean answer) {

        Toast correctToast = Toast.makeText(MainActivity.this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT);
        correctToast.setGravity(Gravity.TOP, 0, 500);

        Toast incorrectToast = Toast.makeText(MainActivity.this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT);
        incorrectToast.setGravity(Gravity.TOP, 0, 500);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAnswered = true;
                if (answer) {
                    correctToast.show();
                } else {
                    incorrectToast.show();
                }
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionAnswered = true;
                if (answer) {
                    incorrectToast.show();
                } else {
                    correctToast.show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TextView textview = (TextView) findViewById(R.id.questionToShow);

        for (int i = 0; i < 5; i++) {

            textview.setText(assignQuestion(i));
            setButtons(assignAnswer(i));

        }

        textview.setText(R.string.finish_game);

    }
}