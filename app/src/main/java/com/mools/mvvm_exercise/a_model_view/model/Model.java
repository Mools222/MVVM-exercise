package com.mools.mvvm_exercise.a_model_view.model;

public class Model extends MyObservable {
    private String text;

    public void setText(String text) {
        this.text = text;
        notifyObservers(this.text);
    }
}
