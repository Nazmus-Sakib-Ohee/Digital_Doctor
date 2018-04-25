package com.example.Nazmus_Sakib_Ohee.digital_doctor;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.Nazmus_Sakib_Ohee.digital_doctor.R.id.patiant;
public class Serial extends AppCompatActivity {

    DatePickerDialog.OnDateSetListener date;
    EditText editText1,editText2,editText3,editText4;
     Calendar myCalendar;
    TextView txt;
    long w=1;
    String a;
    String b;
    String c;
    StringBuilder k;
    int hlw=0;
    String doc;
    String r;
    private int _day;
    private int _month;
    private int _Year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial);
        final String id = getIntent().getStringExtra("id");
        doc=getIntent().getStringExtra("docname");


       myCalendar= Calendar.getInstance();

        editText4 = findViewById(R.id.date);

         date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                _Year = year;
                _month = monthOfYear;
                _day = dayOfMonth;

                updateLabel();
            }

        };

        editText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Serial.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



       final Button btn=(Button)findViewById(R.id.getserial);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (InternetConnection.checkConnection(getApplicationContext())) {



                editText1 = findViewById(R.id.date);
                editText2 = findViewById(patiant);
                editText3 = findViewById(R.id.editTextphonenumber);

                a = editText1.getText().toString();
                b = editText2.getText().toString();
                c = editText3.getText().toString();

                if (a.equals("") || b.equals("") || c.equals("")) {
                   Toast.makeText(Serial.this, "Fill Full Form", Toast.LENGTH_SHORT).show();
                } else {
                   // Toast.makeText(Serial.this, ""+doc+"\n" + b + "\n" + c + "\n" + a + "\n", Toast.LENGTH_SHORT).show();
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    int doctorid = Integer.parseInt(id);




                    long date = new Date().getTime();
                    DatabaseReference ref = GetFirebaseInstance.GetInstance().getReference("serial").child(id).child(r);


                    ref.child(String.valueOf(date)).child("Patient Name").setValue(b);
                    ref.child(String.valueOf(date)).child("Number").setValue(c);


                    ref.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            //Toast.makeText(Serial.this, dataSnapshot.getKey()+" Val"+String.valueOf(dataSnapshot.getChildrenCount()), Toast.LENGTH_SHORT).show();
                            hlw = Integer.valueOf(String.valueOf(dataSnapshot.getChildrenCount()));
                            Toast.makeText(Serial.this, "Serial No: "+hlw, Toast.LENGTH_SHORT).show();

                            next(hlw);
                        }


                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }

            }
            else{
                    Toast.makeText(Serial.this, "No Internet", Toast.LENGTH_SHORT).show();
                }


        }

        });





    }
    private void updateLabel() {


         StringBuilder s=new StringBuilder().append(_day).append("/").append(_month + 1).append("/").append(_Year).append(" ");
         k=new StringBuilder().append(_day).append("cut").append(_month + 1).append("cut").append(_Year);
         r=k.toString();
        editText4.setText(s);


    }
    private void next(int nu){

        SharedPreferences sharedPreferences=getSharedPreferences("Appointment", Context.MODE_PRIVATE);

        String uk=sharedPreferences.getString("Myappointment","No Appointment Yet");
          SharedPreferences.Editor editor = sharedPreferences.edit();
          int nr=nu;
          int time=360;
          for(int i=1;i<nr;i++){
              time=time+15;
          }
         int appointtime=time/60;
        long minnutesRemaining = time % 60;
        DecimalFormat fr= new DecimalFormat("00");
        String r=appointtime+":"+fr.format(minnutesRemaining);


        // String r=appointtime+":"+minnutesRemaining;

        String okk =uk+ "\n\nPatient Name: " + b + "\nDoctor Name: " + doc + "\nAppointment Date: " + a + "\nPhone Number: " + c + "\nSerial Number: " + nr+ "\n"+"Appointment Time : "+r+" PM\n";
            editor.putString("Myappointment",okk);
            editor.commit();

            Intent intent = new Intent(Serial.this, MyAppointment.class);
            startActivity(intent);


    }


    }