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
        textview.setText(R.string.question_text1);
        setButtons(true);

        textview.setText(R.string.question_text2);
        setButtons(true);

        textview.setText(R.string.question_text3);
        setButtons(false);

        textview.setText(R.string.question_text4);
        setButtons(true);

        textview.setText(R.string.question_text5);
        setButtons(false);

        textview.setText(R.string.finish_game);

    }
}