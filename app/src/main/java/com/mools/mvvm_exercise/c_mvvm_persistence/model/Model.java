package com.mools.mvvm_exercise.c_mvvm_persistence.model;

public class Model extends MyObservable{
    private String text;

    public void setText(String text) {
        this.text = text;
        notifyObservers(this.text);
    }
}
