package com.mools.mvvm_exercise.d_mvvm_multiple_users.model;

public class Model extends MyObservable {
    private String text;

    public void setText(String text) {
        this.text = text;
        notifyObservers(this.text);
    }
}
