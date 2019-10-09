package com.example.fiilismittari;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ProfileActivity_1 extends AppCompatActivity {
    private CheckBox checkBox;
    private Button aButton;
    private SharedPreferences aPreference;
    private SharedPreferences.Editor aEditor;
    private EditText aName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_1);
        checkBox = (CheckBox)findViewById(R.id.rememberMe);
        aButton = (Button)findViewById(R.id.okButton);
        aName = (EditText)findViewById(R.id.name);
        aPreference = PreferenceManager.getDefaultSharedPreferences(this);
        aEditor = aPreference.edit();

        checkSharedPreferences();


        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    aEditor.putString(getString(R.string.remember_me),"True");
                    aEditor.apply();

                    //this saves the name
                    String name = aName.getText().toString();
                    aEditor.putString(getString(R.string.user), name);
                    aEditor.commit();
                }else{
                    aEditor.putString(getString(R.string.remember_me),"False");
                    aEditor.commit();

                    //this don't save the name
                    aEditor.putString(getString(R.string.user)," ");
                    aEditor.commit();
                }
            }
        });

    }
    private void checkSharedPreferences(){
        String checkbox = aPreference.getString(getString(R.string.remember_me), "false");
        String name = aPreference.getString(getString(R.string.user), " ");

        aName.setText(name);

        if(checkbox.equals("True")){
            checkBox.setChecked(true);
        }else{
            checkBox.setChecked(false);
        }

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
