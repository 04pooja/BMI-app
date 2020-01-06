package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        final EditText e1=(EditText) findViewById(R.id.et1);
        final EditText e2=(EditText) findViewById(R.id.et2);
        final TextView tv3=(TextView) findViewById(R.id.tv3);
        findViewById(R.id.ib1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1=e1.getText().toString();
                String str2=e2.getText().toString();
                if(TextUtils.isEmpty(str1)){
                    e1.setError("Please enter your weight");
                    e1.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(str2)){
                    e2.setError("Please enter your height");
                    e2.requestFocus();
                    return;
                }


                float weight=Float.parseFloat(str1);
                float height=Float.parseFloat(str2)/100;

                float bmivalue= calculateBMI(weight,height);
                String bmiInterpretation= interpretBMI(bmivalue);
                tv3.setText(String.valueOf( bmivalue +"-"+bmiInterpretation));

            }
        });
    }
    private float calculateBMI(float weight,float height){
        return (float)(weight/(height*height));
    }
    private String interpretBMI(float bmiValue){
        if(bmiValue<16){
            return "Severly underweight";

        }else if(bmiValue<18.5){
            return "Underweight";

        }else if(bmiValue<25){
            return "Normal";

        }else if(bmiValue<30){
            return "Overweight";
        }
        else{
            return "Obese";
        }
    }
}




