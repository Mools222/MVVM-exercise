package com.mools.mvvm_exercise.c_mvvm_persistence.view;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.mools.mvvm_exercise.c_mvvm_persistence.model.Model;
import com.mools.mvvm_exercise.c_mvvm_persistence.model.MyObserver;
import com.mools.mvvm_exercise.c_mvvm_persistence.persistence.firebase.Firebase;
import com.mools.mvvm_exercise.c_mvvm_persistence.persistence.sqlite.AppDatabase;
import com.mools.mvvm_exercise.c_mvvm_persistence.persistence.sqlite.Text;

public class LowerCasePresenter {
    private Model model;
    private AppDatabase appDatabase;
    private Firebase firebase;

    public LowerCasePresenter(Context context) {
        model = new Model();

        // Pick 1 and comment the other out
//        pickSQLite(context);
        pickFirebase();
    }

    private void pickSQLite(Context context) {
        AsyncTask.execute(() -> {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "text-database").build();
            Text lastText = appDatabase.textDao().getLastText();
            if (lastText != null)
                model.setText(lastText.textMessage);
        });
    }

    private void pickFirebase() {
        AsyncTask.execute(() -> {
            firebase = new Firebase();

            try {
                while (firebase.isWaitingForResult())
                    Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }

            String lastText = firebase.getLastText();
            if (lastText != null)
                model.setText(lastText);
        });
    }

    public void observe(MyObserver myObserver) {
        model.addObserver(myObserver);
    }

    public void transformPersistAndNotify(String text) {
        String transformedText = text.toLowerCase();

        if (appDatabase != null)
            AsyncTask.execute(() -> {
                Text textForDb = new Text();
                textForDb.textMessage = text;
                appDatabase.textDao().insert(textForDb);
            });
        else {
            firebase.insert(transformedText);
        }

        model.notifyObservers(transformedText);
    }
}
