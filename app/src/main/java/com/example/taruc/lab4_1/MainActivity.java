package com.example.taruc.lab4_1;

import android.content.*;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    private static String USERID = "userID";
    private static String PASSWORD = "password";

    EditText editTextUserID;
    EditText editTextPassword;

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String userID, password;

        userID = editTextUserID.getText().toString();
        password = editTextPassword.getText().toString();
        //Write Value to Shared Preference file
        editor.putString(USERID, userID);
        editor.putString(PASSWORD, password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextUserID = (EditText)findViewById(R.id.editTextUserID);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String userID, password;
        userID = sharedPreferences.getString(USERID, "");
        password = sharedPreferences.getString(PASSWORD, "");

        editTextUserID.setText(userID);
        editTextPassword.setText(password);
    }
}
