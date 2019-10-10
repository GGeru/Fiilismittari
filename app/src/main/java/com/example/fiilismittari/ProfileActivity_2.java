package com.example.fiilismittari;

import androidx.appcompat.app.AppCompatActivity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;



// by Onika Åberg

/**
 * Class for saving user profile on the app.
 */
public class ProfileActivity_2 extends AppCompatActivity {
    private CheckBox checkBox;
    private SharedPreferences aPreference;
    private SharedPreferences.Editor aEditor;
    private EditText aName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_2);
        checkBox = findViewById(R.id.rememberMe);
        aName = findViewById(R.id.user);
        aPreference = PreferenceManager.getDefaultSharedPreferences(this);
        aEditor = aPreference.edit();

        checkSharedPreferences();

        /**
         * new OnClickListener is created. when the value of checkBox is true, in other words,
         * checkBox is checked it saves the name
         */

        checkBox.setOnClickListener(new View.OnClickListener() {
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

    /**
     * this method saves the name even when the app is closed and opened again
     */
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
}
