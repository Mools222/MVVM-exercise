package com.mools.mvvm_exercise.a_model_view.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mools.mvvm_exercise.a_model_view.model.Model;
import com.mools.mvvm_exercise.a_model_view.model.MyObserver;
import com.mools.mvvm_exercise.R;

public class MainActivity extends AppCompatActivity implements MyObserver {
    private TextView textView;
    private EditText editText;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        model = new Model();
        model.addObserver(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.setText(editText.getText().toString());
            }
        });
    }

    @Override
    public void update(Object arg) {
        String transformedText = ((String) arg).toLowerCase();
        textView.setText(transformedText);
    }
}
