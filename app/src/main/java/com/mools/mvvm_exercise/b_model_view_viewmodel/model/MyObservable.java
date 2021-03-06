package com.mools.mvvm_exercise.b_model_view_viewmodel.model;

import java.util.ArrayList;

public class MyObservable {
    private ArrayList<MyObserver> myObservers;

    public MyObservable() {
        myObservers = new ArrayList<>();
    }

    public void addObserver(MyObserver myObserver) {
        if (!myObservers.contains(myObserver))
            myObservers.add(myObserver);
    }

    public void notifyObservers(Object arg) {
        for (MyObserver myObserver : myObservers) {
            myObserver.update(arg);
        }
    }
}