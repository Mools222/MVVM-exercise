package com.mools.mvvm_exercise.d_mvvm_multiple_users.view;

import com.mools.mvvm_exercise.d_mvvm_multiple_users.model.Model;
import com.mools.mvvm_exercise.d_mvvm_multiple_users.model.MyObserver;
import com.mools.mvvm_exercise.d_mvvm_multiple_users.persistence.FirebaseAndroid;
import com.mools.mvvm_exercise.d_mvvm_multiple_users.persistence.FirebaseJava;

public class LowerCasePresenter {
    private Model model;
    private FirebaseAndroid firebaseAndroid;
//    private FirebaseJava firebaseJava;

    public LowerCasePresenter() {
        model = new Model();

        firebaseAndroid = new FirebaseAndroid(model);
//        firebaseJava = new FirebaseJava();
    }

    public void observe(MyObserver myObserver) {
        model.addObserver(myObserver);
    }

    public void persist(String text) {
        firebaseAndroid.insert(text);
    }
}
