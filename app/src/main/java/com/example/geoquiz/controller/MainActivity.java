package com.example.geoquiz.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.geoquiz.R;
import com.example.geoquiz.model.Question;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button nextQuestion;
    private Button previousQuestion;
    private int questionNumber = 0;
    private int correctAnswers = 0;
    private ArrayList<Question> questionArrayList = new ArrayList<>();

    private void setQuestions () {

        questionArrayList.add(new Question(R.string.question_text1, true));
        questionArrayList.add(new Question(R.string.question_text2, true));
        questionArrayList.add(new Question(R.string.question_text3, false));
        questionArrayList.add(new Question(R.string.question_text4, true));
        questionArrayList.add(new Question(R.string.question_text5, false));

    }

    private void goPreviousQuestion () {

        TextView textview = findViewById(R.id.questionToShow);

        if (questionNumber > 0) {
            textview.setText(questionArrayList.get(questionNumber).getQuestionId());
            setButtons(questionArrayList.get(questionNumber).isAnswer());
            nextQuestion.setVisibility(View.VISIBLE);
            questionNumber--;

        } else {

            previousQuestion.setVisibility(View.GONE);

        }
    }

    private void nextQuestion () {

        TextView textview = findViewById(R.id.questionToShow);

        if (questionNumber < 5) {
            textview.setText(questionArrayList.get(questionNumber).getQuestionId());
            setButtons(questionArrayList.get(questionNumber).isAnswer());
            previousQuestion.setVisibility(View.VISIBLE);
            questionNumber++;

            if (questionNumber == 4) {
                nextQuestion.setVisibility(View.GONE);
            }

        } else {

            mTrueButton.setVisibility(View.GONE);
            mFalseButton.setVisibility(View.GONE);

            if (correctAnswers > 2) {
                textview.setText(R.string.finish_gameW);
            } else {
                textview.setText(R.string.finish_gameL);
            }
        }
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
                if (answer) {
                    correctToast.show();
                    correctAnswers++;
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
                    correctAnswers++;
                }
            }
        });
    }

    private void moveQuestion () {

        nextQuestion = (Button) findViewById(R.id.next_question);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextQuestion();
            }
        });

        previousQuestion = (Button) findViewById(R.id.previous_question);
        previousQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goPreviousQuestion();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setQuestions();
        setContentView(R.layout.activity_main);
        nextQuestion();
        moveQuestion();

    }
}