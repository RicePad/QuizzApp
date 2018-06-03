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

    Button submitScore;
    int totalRghtAnswers = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        submitScore = (Button) findViewById(R.id.submitScore);

    }


    private void verifyQ1Answer(){
        RadioButton radioButton5Years = (RadioButton) findViewById(R.id.radio_button_5_years);
        boolean radioButton5YearsSelected = radioButton5Years.isChecked();
        if(radioButton5YearsSelected){
            totalRghtAnswers += 1;
        }
    }



    private void verifyQ2Answer(){
        RadioButton radioButton50States = (RadioButton) findViewById(R.id.radio_button_50_states);
        boolean radioButton50States = radioButton50States.isChecked();
        if(radioButton50States){
            totalRghtAnswers += 1;
        }
    }

    private String Q3EditTextInput(){
        EditText checkUserPresidentInput = (EditText) findViewById(R.id.edit_text_first_president);
        String presidentFullName = checkUserPresidentInput.getText().toString();
        return presidentFullName;
    }

    private void verifyQ3EditTextInput(){
        String fullName = Q3EditTextInput();
        if(fullName.trim().equalsIgnoreCase("George Washington")){
            totalRghtAnswers += 1;
        }
    }
}
