package com.example.Nazmus_Sakib_Ohee.digital_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Appointment extends AppCompatActivity {

     Button Surgery,cardiology;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        cardiology=(Button)findViewById(R.id.ohee);
        Surgery = (Button)findViewById(R.id.surgery);

        Surgery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Appointment.this,Surgery.class);
                startActivity(intent);
            }
        }); cardiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Appointment.this,ListView.class);

                startActivity(intent);
            }
        });

    }



}
