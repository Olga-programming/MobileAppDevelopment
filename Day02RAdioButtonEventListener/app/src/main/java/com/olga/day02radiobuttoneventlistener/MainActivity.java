package com.olga.day02radiobuttoneventlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    RadioGroup radioGroupSex, radioGroupSport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personinfo_radio);

        initialize();
    }

    private void initialize(){

        name = findViewById(R.id.edit_text_name);
        radioGroupSex = findViewById(R.id.rgroupe_sex);
        radioGroupSport = findViewById(R.id.rgroup_sport);

    }

    public void showPersonInfo(View view){
        String personName;
        String personSex ;
        String personSport="";

        int checked_radio_sex = radioGroupSex.getCheckedRadioButtonId();
        personName = name.getText().toString();
         if(checked_radio_sex == R.id.rbtn_sex_male){
             personSex = "Male";
         }else{
             personSex = "Female";
         }

        int checked_radio_sport = radioGroupSport.getCheckedRadioButtonId();

         switch (checked_radio_sport){
             case R.id.rbtn_sport_basketball:
                 personSport = "Baseball";
                 break;
             case R.id.rbtn_sport_hockey:
                 personSport = "Hockey";
                 break;
             case R.id.rbtn_sport_soccer:
                 personSport = "Soccer";
                 break;

         }

         String output = String.format("Person name is : %s/nPerson sex is : %s/nPerson sport is : %s", personName, personSex, personSport);
        Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
    }

}
