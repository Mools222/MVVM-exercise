package com.mools.mvvm_exercise.b_model_view_viewmodel.model;

public class Model extends MyObservable {
    private String text;

    public void setText(String text) {
        this.text = text;
        notifyObservers(this.text);
    }
}
