package com.olga.day02radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    RadioGroup radio_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_button_image);

        initialize();
    }

    private void initialize(){
        radio_group = findViewById(R.id.radioButtonGroup);
        image = findViewById(R.id.imageView);
    }

    public void changeImage(View view){
        int selectedRadioBtn = radio_group.getCheckedRadioButtonId();

        switch (selectedRadioBtn){
            case R.id.radioButton:
                image.setImageResource(R.drawable.positive);
                break;
            case R.id.radioButton2:
                image.setImageResource(R.drawable.emoji);
                break;
            case R.id.radioButton3:
                image.setImageResource(R.drawable.star);
                break;
        }
    }

}
