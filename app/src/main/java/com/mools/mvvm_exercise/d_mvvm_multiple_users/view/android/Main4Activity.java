package com.mools.mvvm_exercise.d_mvvm_multiple_users.view.android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mools.mvvm_exercise.R;
import com.mools.mvvm_exercise.d_mvvm_multiple_users.view.LowerCasePresenter;

public class Main4Activity extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private LowerCasePresenter lowerCasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        setupViewModel();

        button.setOnClickListener(v -> lowerCasePresenter.persist(editText.getText().toString()));
    }

    private void setupViewModel() {
        lowerCasePresenter = new LowerCasePresenter();
        lowerCasePresenter.observe(arg -> textView.setText((String) arg));
    }
}
