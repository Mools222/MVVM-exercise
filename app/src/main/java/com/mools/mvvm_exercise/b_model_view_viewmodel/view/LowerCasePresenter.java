package com.mools.mvvm_exercise.b_model_view_viewmodel.view;

import com.mools.mvvm_exercise.b_model_view_viewmodel.model.Model;
import com.mools.mvvm_exercise.b_model_view_viewmodel.model.MyObserver;

public class LowerCasePresenter {
    private Model model;

    public LowerCasePresenter() {
        model = new Model();
    }

    public void observe(MyObserver myObserver) {
        model.addObserver(myObserver);
    }

    public void transformAndNotify(String text) {
        String transformedText = text.toLowerCase();
        model.setText(transformedText);
    }
}
