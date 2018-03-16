package com.example.android.hogwartsquiz;

import android.content.Context;
import android.database.CursorJoiner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    int questionOnePoint = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean questionOne() {
        RadioButton radioOne = (RadioButton) findViewById(R.id.question_one);
        boolean isCorrect = radioOne.isChecked();
        return isCorrect;
    }

    public boolean questionTwo() {

        String questionTwo;
        int questionTwoInt;

        EditText editTwo = (EditText) findViewById(R.id.question_two);

        questionTwo = editTwo.getText().toString();
        questionTwoInt = Integer.parseInt(questionTwo);
        if (questionTwoInt == 10) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean questionThree() {
        RadioButton radioThree = (RadioButton) findViewById(R.id.question_three);
        boolean isCorrect = radioThree.isChecked();
        return isCorrect;
    }

    public boolean questionFour() {
        CheckBox bicorn = (CheckBox) findViewById(R.id.bicorn);
        boolean bicornIsChecked = bicorn.isChecked();
        CheckBox hair = (CheckBox) findViewById(R.id.hair);
        boolean hairIsChecked = hair.isChecked();
        CheckBox leeches = (CheckBox) findViewById(R.id.leeches);
        boolean leechesIsChecked = leeches.isChecked();
        CheckBox knotgrass = (CheckBox) findViewById(R.id.knotgrass);
        boolean knotgrassIsChecked = knotgrass.isChecked();
        CheckBox lacewing = (CheckBox) findViewById(R.id.lacewing);
        boolean lacewingIsChecked = lacewing.isChecked();
        CheckBox fluxweed = (CheckBox) findViewById(R.id.fluxweed);
        boolean fluxweedIsChecked = fluxweed.isChecked();
        CheckBox bloomslang = (CheckBox) findViewById(R.id.bloomslang);
        boolean bloomslangIsChecked = bloomslang.isChecked();

        if (bicornIsChecked && hairIsChecked && leechesIsChecked && knotgrassIsChecked &&
                lacewingIsChecked && fluxweedIsChecked && bloomslangIsChecked) {
            return true;
        } else {
            return false;
        }
    }

    public boolean questionFive() {
        CheckBox baron = (CheckBox) findViewById(R.id.baron);
        boolean baronIsChecked = baron.isChecked();
        CheckBox nick = (CheckBox) findViewById(R.id.nick);
        boolean nickIsChecked = nick.isChecked();
        CheckBox theGreyLady = (CheckBox) findViewById(R.id.the_grey_lady);
        boolean theGreyLadyIsChecked = theGreyLady.isChecked();

        if (baronIsChecked && nickIsChecked && theGreyLadyIsChecked) {
            return true;
        } else {
            return false;
        }
    }


    public int submitQuiz(View view) {

        boolean questionOne = questionOne();
        boolean questionTwo = questionTwo();
        boolean questionThree = questionThree();
        boolean questionFour = questionFour();
        boolean questionFive = questionFive();

        if (questionOne) {
            score += 1;
        }

        if (questionTwo){
            score += 1;
        }

        if (questionThree) {
            score += 1;
        }

        if (questionFour) {
            score += 1;
        }

        if (questionFive) {
            score += 1;
        }

        displayScore(score);
        return score;
    }

    public void displayScore(int score){
        TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        scoreTextView.setText("" + score + "/5");
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text = getString(R.string.score_toast) + " " + score + " " +getString(R.string.score_toast_two);
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
