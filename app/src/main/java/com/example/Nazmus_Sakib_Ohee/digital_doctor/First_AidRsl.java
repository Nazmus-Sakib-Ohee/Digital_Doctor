package com.example.Nazmus_Sakib_Ohee.digital_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class First_AidRsl extends AppCompatActivity {

    private Button cmn_dss,accidntl_fst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first__aid_rsl);

        cmn_dss = (Button)findViewById(R.id.cmn_dss);
        cmn_dss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First_AidRsl.this,Cmn_Diseases.class);
                startActivity(intent);
            }
        });

        accidntl_fst = (Button)findViewById(R.id.accdntal_fst);
        accidntl_fst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(First_AidRsl.this,Accidental_Fst.class);
                startActivity(intent);
            }
        });


    }
}
