package com.example.Nazmus_Sakib_Ohee.digital_doctor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyAppointment extends AppCompatActivity {
   private Button btn;
   private TextView txt1;

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(MyAppointment.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_appointment);

        btn=findViewById(R.id.clear);
        txt1=findViewById(R.id.txt);
        SharedPreferences sharedPreferences = getSharedPreferences("Appointment", Context.MODE_PRIVATE);
           String a=sharedPreferences.getString("Myappointment","No Appointment Yet");
           txt1.setText(a);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPreferences=getSharedPreferences("Appointment", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String okk="";
                editor.putString("Myappointment",okk);
                editor.commit();

                txt1.setText("No Appointment Yet");

            }
        });
    }
}
