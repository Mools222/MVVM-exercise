package com.mools.mvvm_exercise.c_mvvm_persistence.persistence.firebase;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Firebase {
    private DatabaseReference databaseReference;
    private String lastText;
    private boolean waitingForResult = true;

    public Firebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("text");
        addSingleEventListener();
    }

    public void addSingleEventListener() {
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lastText = (String) dataSnapshot.getValue();
                waitingForResult = false;
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public String getLastText() {
        return lastText;
    }

    public void insert(String text) {
        databaseReference.setValue(text);
    }

    public boolean isWaitingForResult() {
        return waitingForResult;
    }
}
