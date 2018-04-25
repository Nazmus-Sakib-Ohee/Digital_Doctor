package com.example.Nazmus_Sakib_Ohee.digital_doctor;

import com.google.firebase.database.FirebaseDatabase;


public class GetFirebaseInstance {
    private static FirebaseDatabase firebaseDatabase;

    public static FirebaseDatabase GetInstance() {
        if (firebaseDatabase == null) {
            firebaseDatabase = FirebaseDatabase.getInstance();
            firebaseDatabase.setPersistenceEnabled(true);
            return firebaseDatabase;
        }
        return firebaseDatabase;
    }
}
