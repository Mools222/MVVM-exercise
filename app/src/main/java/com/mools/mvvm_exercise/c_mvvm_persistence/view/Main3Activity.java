package com.mools.mvvm_exercise.c_mvvm_persistence.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mools.mvvm_exercise.R;
import com.mools.mvvm_exercise.c_mvvm_persistence.model.MyObserver;

public class Main3Activity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private LowerCasePresenter lowerCasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        setupViewModel();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowerCasePresenter.transformPersistAndNotify(editText.getText().toString());
            }
        });
    }

    private void setupViewModel() {
        lowerCasePresenter = new LowerCasePresenter(this);

        lowerCasePresenter.observe(new MyObserver() {
            @Override
            public void update(Object arg) {
                textView.setText((String) arg);
            }
        });
    }
}