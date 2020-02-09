package com.mools.mvvm_exercise.d_mvvm_multiple_users.persistence;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mools.mvvm_exercise.d_mvvm_multiple_users.model.Model;

public class FirebaseAndroid {
    private Model model;
    private DatabaseReference databaseReference;

    public FirebaseAndroid(Model model) {
        this.model = model;
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("text");
        addEventListener();
    }

    private void addEventListener() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                model.setText((String) dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public void insert(String text) {
        databaseReference.setValue(text);
    }
}
