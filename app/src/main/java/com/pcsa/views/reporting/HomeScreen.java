package com.pcsa.views.reporting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pcsa.R;

/**
 * @author Buddhiprabha Erabadda
 *
 * Landing page of Reporting which has links for Reporting functinalities
 */
public class HomeScreen extends Activity {

    Button reporting_steps;
    Button reporting_types;
    Button reporting_more_resources;
    Button reporting_confidentiality;
    Button reporting_contact_staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting_homescreen);

        reporting_steps = (Button) findViewById(R.id.reporting_steps);
        reporting_types = (Button) findViewById(R.id.reporting_types);
        reporting_more_resources = (Button) findViewById(R.id.reporting_resources);
        reporting_confidentiality = (Button) findViewById(R.id.reporting_confidentiality);
        reporting_contact_staff  = (Button) findViewById(R.id.reporting_contact);

        reporting_steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent steps = new Intent(HomeScreen.this, Steps.class);
                startActivity(steps);
            }
        });

        reporting_types.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent types = new Intent(HomeScreen.this, Types.class);
                startActivity(types);
            }
        });

        reporting_more_resources.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent types = new Intent(HomeScreen.this, Resources.class);
                startActivity(types);
            }
        });

        reporting_confidentiality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent types = new Intent(HomeScreen.this, Confidentiality.class);
                startActivity(types);
            }
        });

        reporting_contact_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent types = new Intent(HomeScreen.this, ContactPostStaff.class);
                startActivity(types);
            }
        });

    }
}
