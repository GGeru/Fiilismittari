package com.example.fiilismittari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_1);
    }
    public void putName(View v) {
        TextView tv = findViewById(R.id.yourName);
        EditText editText = (EditText) findViewById(R.id.user);
        String name = editText.getText().toString();
        tv.setText(name);

        //you write your name on user-text box and its put on yourName box
        //yourName box doesn't have anything on it before name is put
    }
}
