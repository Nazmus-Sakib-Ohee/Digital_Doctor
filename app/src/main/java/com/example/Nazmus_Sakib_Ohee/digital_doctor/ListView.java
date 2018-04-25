package com.example.Nazmus_Sakib_Ohee.digital_doctor;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {
    UsersAdapter cse1_1;
    ArrayList<DataModel> ardata = new ArrayList<>();
    android.widget.ListView lv;
    DatabaseReference databaseReference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        init();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    for (DataSnapshot ds2 : ds.getChildren()) {
                        ardata.add(new DataModel(ds2.child("name").getValue().toString(),
                                ds2.child("spaciality").getValue().toString(),
                                ds2.child("designation").getValue().toString(),
                                ds2.child("chamber").getValue().toString(),
                                ds2.child("duration").getValue().toString(),
                                ds2.child("offday").getValue().toString(),
                                ds2.child("id").getValue().toString()));
                    }
                    cse1_1.notifyDataSetChanged();
                }
            }


            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ListView.this, "" + databaseError.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        lv = findViewById(R.id.list);
        cse1_1 = new UsersAdapter(getApplicationContext(), ardata);
        lv.setAdapter(cse1_1);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(ListView.this, Serial.class).putExtra("id",ardata.get(i).getId()).putExtra("docname",ardata.get(i).getName()));

              /*  Intent intent = new Intent(ListView.this, Serial.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();*/
            }
        });



    }

    private void init() {
       databaseReference = GetFirebaseInstance.GetInstance().getReference(NodeNames.DOCTORNODE);

    }

    public class UsersAdapter extends ArrayAdapter<DataModel> {
        // View lookup cache
        private class ViewHolder {
            TextView name;
            TextView sp, dsg, chmbr, visittime, offday;
        }

        public UsersAdapter(Context context, ArrayList<DataModel> users) {
            super(context, 0, users);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            DataModel user = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            ViewHolder viewHolder; // view lookup cache stored in tag
            if (convertView == null) {
                // If there's no view to re-use, inflate a brand new view for row
                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.doclistlayout, parent, false);
                viewHolder.name = (TextView) convertView.findViewById(R.id.docname);
                viewHolder.sp = (TextView) convertView.findViewById(R.id.docsp);
                viewHolder.dsg = (TextView) convertView.findViewById(R.id.docdesg);
                viewHolder.chmbr = (TextView) convertView.findViewById(R.id.docchmbr);

                viewHolder.visittime = (TextView) convertView.findViewById(R.id.docvtime);
                viewHolder.offday = (TextView) convertView.findViewById(R.id.docoff);

                // Cache the viewHolder object inside the fresh view
                convertView.setTag(viewHolder);

            } else {
                // View is being recycled, retrieve the viewHolder object from tag
                viewHolder = (ViewHolder) convertView.getTag();
            }
            // Populate the data from the data object via the viewHolder object
            // into the template view.
            viewHolder.name.setText( "Name :"+user.getName());
            viewHolder.sp.setText(user.getSpaciality());
            viewHolder.dsg.setText("Designation :"+user.getDesignation());
            viewHolder.chmbr.setText("Chamber :"+user.getChamber());
            viewHolder.visittime.setText("Visit Time :"+user.getDuration());
            viewHolder.offday.setText("Off Day :"+user.getOffday());







            // Return the completed view to render on screen
            return convertView;
        }
    }


}

