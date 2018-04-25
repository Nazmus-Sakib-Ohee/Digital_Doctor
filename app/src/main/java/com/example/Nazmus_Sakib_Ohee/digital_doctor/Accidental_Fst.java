package com.example.Nazmus_Sakib_Ohee.digital_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accidental_Fst extends AppCompatActivity {

    private Button Animal_bites,Cuts_laceration,Heat_stroke,Muscle_strain,Thermal_burns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accidental__fst);


        Animal_bites = (Button)findViewById(R.id.AnimalBites);
        Cuts_laceration = (Button)findViewById(R.id.cuts_or_lac);
        Heat_stroke = (Button)findViewById(R.id.heat_stroke);
        Muscle_strain = (Button)findViewById(R.id.mucle_strain);
        Thermal_burns = (Button)findViewById(R.id.thermal_burns);

        Animal_bites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accidental_Fst.this,Animal_bites.class);
                startActivity(intent);
            }
        });

        Cuts_laceration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accidental_Fst.this, cuts_laceration.class);
                startActivity(intent);

            }
        });

        Heat_stroke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accidental_Fst.this,Heat_Stroke.class);
                startActivity(intent);

            }
        });

        Muscle_strain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accidental_Fst.this,Muscle_Strain.class);
                startActivity(intent);

            }
        });

        Thermal_burns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Accidental_Fst.this,Thermal_Burns.class);
                startActivity(intent);

            }
        });


    }
}
