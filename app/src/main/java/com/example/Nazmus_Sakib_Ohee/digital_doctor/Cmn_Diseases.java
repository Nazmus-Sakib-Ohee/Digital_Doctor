package com.example.Nazmus_Sakib_Ohee.digital_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Cmn_Diseases extends AppCompatActivity {

    private Button Fever,Cough,Cold,Allergies,Tension_headache,Vomiting,Back_pain,Depression,Blood_pressure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmn__diseases);

        //Button
        Fever = (Button)findViewById(R.id.fever);
        Cough = (Button)findViewById(R.id.cough);
        Cold = (Button)findViewById(R.id.cold);
        Allergies = (Button)findViewById(R.id.allergies);
        Tension_headache = (Button)findViewById(R.id.tension_headaches);
        Vomiting = (Button)findViewById(R.id.vomiting);
        Back_pain = (Button)findViewById(R.id.back_pain);
        Depression = (Button)findViewById(R.id.depression);
        Blood_pressure = (Button)findViewById(R.id.blood_pressure);

        //Button

        Fever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cmn_Diseases.this,Fever.class);
                startActivity(intent);
            }
        });

        Cough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cmn_Diseases.this,Cough.class);
                startActivity(intent);
            }
        });

        Cold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cmn_Diseases.this,Cold.class);
                startActivity(intent);
            }
        });

        Allergies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cmn_Diseases.this,Allergies.class);
                startActivity(intent);
            }
        });

        Tension_headache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cmn_Diseases.this,Tension_headache.class);
                startActivity(intent);
            }
        });

        Vomiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cmn_Diseases.this,Vomiting.class);
                startActivity(intent);
            }
        });

        Back_pain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cmn_Diseases.this,Back_pain.class);
                startActivity(intent);
            }
        });

        Depression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cmn_Diseases.this,Depression.class);
                startActivity(intent);
            }
        });

        Blood_pressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cmn_Diseases.this,Blood_pressure.class);
                startActivity(intent);
            }
        });


    }
}
