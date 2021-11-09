package com.example.gamlab.database;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOSchedule {

    private DatabaseReference databaseReference;
    public DAOSchedule(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(schedule.class.getSimpleName());
    }

    public Task<Void> add(schedule s){
        return databaseReference.push().setValue(s);
    }

    //you should be able to use here to modify the reservation date.

}
