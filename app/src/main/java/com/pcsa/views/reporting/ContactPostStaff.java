package com.pcsa.views.reporting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.pcsa.beans.reporting.LocationDetails;
import com.pcsabuddhi.R;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Buddhiprabha Erabadda
 *
 * Allows the user to call Post Staff in case of crime. The details for the
 * current location will be set by changing the location
 */
public class ContactPostStaff extends Activity implements AdapterView.OnItemSelectedListener {

    Button contact_pcmo;
    Button contact_ssm;
    Button contact_sarl;
    TextView current_location;
    private static final Map<String, LocationDetails> locationDetails;
    static {
        locationDetails = new HashMap<>();
        //TODO: Add correct values here
        locationDetails.put("Uganda", new LocationDetails("Uganda", 1111, 2222, 3333));
        locationDetails.put("Syria", new LocationDetails("Syria", 4444, 5555, 6666));
        locationDetails.put("Tunisia", new LocationDetails("Tunisia",7777, 8888, 9999));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting_contact_post_staff);

        contact_pcmo = (Button) findViewById(R.id.post_staff_pcmo);
        contact_ssm = (Button) findViewById(R.id.post_staff_ssm);
        contact_sarl = (Button) findViewById(R.id.post_staff_sarl);
        current_location = (TextView) findViewById(R.id.post_staff_current_location);

        contact_pcmo.setText(R.string.contact_pcmo);
        contact_ssm.setText(R.string.contact_ssm);
        contact_sarl.setText(R.string.contact_sarl);

        Spinner locationList = (Spinner) findViewById(R.id.reporting_locationlist);
        locationList.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.locations_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationList.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = (String) parent.getItemAtPosition(position);
        current_location.setText(getResources().getString(R.string.reporting_current_location) + " " + selectedItem);

        // selectedLocationDetails holds all details about the location selected by the user
        LocationDetails selectedLocationDetails = locationDetails.get(selectedItem);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
