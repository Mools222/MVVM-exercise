package com.mools.mvvm_exercise.b_model_view_viewmodel.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mools.mvvm_exercise.R;
import com.mools.mvvm_exercise.b_model_view_viewmodel.model.MyObserver;

public class Main2Activity extends AppCompatActivity implements MyObserver {
    private TextView textView;
    private EditText editText;
    private LowerCasePresenter lowerCasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        setupViewModel();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowerCasePresenter.transformAndNotify(editText.getText().toString());
            }
        });
    }

    private void setupViewModel() {
        lowerCasePresenter = new LowerCasePresenter();
        lowerCasePresenter.observe(this);
    }

    @Override
    public void update(Object arg) {
        textView.setText((String) arg);
    }
}