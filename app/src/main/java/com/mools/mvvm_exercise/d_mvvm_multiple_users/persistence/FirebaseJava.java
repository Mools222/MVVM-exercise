package com.mools.mvvm_exercise.d_mvvm_multiple_users.persistence;

// https://firebase.google.com/docs/admin/setup

//import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileInputStream;

/**
 * You can't do this in the same project
 * https://stackoverflow.com/questions/42097740/firebase-admin-sdk-for-android-methods-not-found
 */

public class FirebaseJava {
//    public FirebaseJava() {
//        try {
//            FileInputStream serviceAccount = new FileInputStream("mvvmexercise-firebase-adminsdk-jsokc-d2924a604f.json");
//
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//                    .setDatabaseUrl("https://mvvmexercise.firebaseio.com")
//                    .build();
//
//            FirebaseApp.initializeApp(options);
//
//            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("text");
//
//            ref.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    Object document = dataSnapshot.getValue();
//                    System.out.println(document);
//                }
//
//                @Override
//                public void onCancelled(DatabaseError error) {
//                }
//            });
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
