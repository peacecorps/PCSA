package com.peacecorps.pcsa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    private Toolbar toolbar;
    private Button loginButton;
    private EditText name;
    private Spinner country;
    private String selected_country;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editor = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit();
        editor.putBoolean(getString(R.string.first_time),false);
        editor.commit();

        if(!getIntent().getBooleanExtra(getString(R.string.first_time),true))
        {
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }

        loginButton = (Button)findViewById(R.id.loginButton);
        name = (EditText)findViewById(R.id.edit_name);

        country = (Spinner) findViewById(R.id.spinner_country);
        String[] countries = getResources().getStringArray(R.array.countryArray);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, R.layout.textview, countries);
        adapter.setDropDownViewResource(R.layout.textview);
        country.setAdapter(adapter);
        country.setOnItemSelectedListener(this);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals(""))
                    Toast.makeText(LoginActivity.this, R.string.prompt_please,Toast.LENGTH_SHORT).show();
                else {
                    editor.putBoolean(getString(R.string.first_aide), false);
                    editor.putString(getString(R.string.key_country), selected_country);
                    editor.putString(getString(R.string.key_name), name.getText().toString());
                    editor.commit();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selected_country = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
