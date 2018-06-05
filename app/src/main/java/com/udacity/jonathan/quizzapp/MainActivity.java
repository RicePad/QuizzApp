package com.udacity.jonathan.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        submitScore = (Button) findViewById(R.id.submitScore);
        submitScore.setOnClickListener( submitScoreButton);

    }


    Button submitScore;
    int totalRightAnswers = 0;



    private void verifyQuestions(){
        verifyQ1Answer();
        verifyQ2Answer();
        verifyQ3EditTextInput();
        verifyQ4Answer();
        verifyQ5EditTextInput();
    }

    private void resetScoreboard(){
        totalRightAnswers = 0;
    }

    final View.OnClickListener submitScoreButton = new View.OnClickListener() {
      public void onClick(final View v){
          verifyQuestions();
          Toast.makeText(MainActivity.this, "Right Answers: " + totalRightAnswers + "/5", Toast.LENGTH_LONG).show();
          resetScoreboard();
      }
    };

    private void verifyQ1Answer(){
        RadioButton radioButton5Years = (RadioButton) findViewById(R.id.radio_button_5_years);
        boolean radioButton5YearsSelected = radioButton5Years.isChecked();
        if(radioButton5YearsSelected){
            totalRightAnswers += 1;
        }
    }



    private void verifyQ2Answer(){
        RadioButton radioButton50States = (RadioButton) findViewById(R.id.radio_button_50_states);
        boolean radioButton50StatesSelected  = radioButton50States.isChecked();
        if(radioButton50StatesSelected){
            totalRightAnswers += 1;
        }
    }

    private String Q3EditTextInput(){
        EditText checkUserPresidentNameInput = (EditText) findViewById(R.id.edit_text_first_president);
        String presidentFullName = checkUserPresidentNameInput.getText().toString();
        return presidentFullName;
    }

    private void verifyQ3EditTextInput(){
        String fullName = Q3EditTextInput();
        if(fullName.trim().equalsIgnoreCase("George Washington")){
            totalRightAnswers += 1;
        }
    }

    private void verifyQ4Answer(){
        CheckBox freedomSpeech = (CheckBox) findViewById(R.id.freedom_speech);
        CheckBox freedomPet = (CheckBox) findViewById(R.id.freedom_pet);
        CheckBox freedomReligion = (CheckBox) findViewById(R.id.freedom_religion);

        boolean freedomSpeechChecked = freedomSpeech.isChecked();
        boolean freedomPetChecked = freedomPet.isChecked();
        boolean freedomReligionChecked = freedomReligion.isChecked();

        if(freedomSpeechChecked && !freedomPetChecked && freedomReligionChecked){
            totalRightAnswers += 1;
        }
    }


    private String Q5EditTextInput(){
        EditText check44thPresidentNameInput = (EditText) findViewById(R.id.edit_text_44th_president);
        String presidentFullName = check44thPresidentNameInput.getText().toString();
        return presidentFullName;
    }

    private void verifyQ5EditTextInput(){
        String fullName = Q5EditTextInput();
        if(fullName.trim().equalsIgnoreCase("Barack Obama")){
            totalRightAnswers += 1;
        }
    }



}
