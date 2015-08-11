package com.pcsa.views.reporting;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.pcsa.beans.reporting.LocationDetails;
import com.pcsa.R;

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

    LocationDetails selectedLocationDetails;
    private static final Map<String, LocationDetails> locationDetails;
    static {
        locationDetails = new HashMap<>();
        //TODO: Add correct values here
        locationDetails.put("Uganda", new LocationDetails("Uganda", "1111", "2222", "3333"));
        locationDetails.put("Syria", new LocationDetails("Syria", "4444", "5555", "6666"));
        locationDetails.put("Tunisia", new LocationDetails("Tunisia","7777", "8888", "9999"));
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

        contact_pcmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog(v, selectedLocationDetails.getPcmo_contact());
            }
        });

        contact_ssm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog(v, selectedLocationDetails.getSsm_contact());
            }
        });

        contact_sarl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog(v, selectedLocationDetails.getSarl_contact());
            }
        });

        Spinner locationList = (Spinner) findViewById(R.id.reporting_locationlist);
        locationList.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.locations_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationList.setAdapter(adapter);
    }

    /**
     * Creates a Dialog for the user to choose Dialer app or SMS app
     * @param v the view clicked
     * @param numberToContact contact number corresponding to the view
     */
    private void createDialog(View v, final String numberToContact){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                contactStaff(which, numberToContact);
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(v.getContext(), R.style.pcsaAlertDialogStyle));
        builder.setMessage("Contact Via").setPositiveButton("Voice Call", dialogClickListener)
                .setNegativeButton("Send Message", dialogClickListener).show();
    }

    /**
     * Opens Dialer or SMS
     * @param action which app to open
     * @param contactNumber the contact number of the selected person
     */
    private void contactStaff(int action, String contactNumber){
        switch (action){
            case DialogInterface.BUTTON_POSITIVE:
                Intent callingIntent = new Intent(Intent.ACTION_CALL);
                callingIntent.setData(Uri.parse("tel:"+contactNumber));
                startActivity(callingIntent);
                break;

            case DialogInterface.BUTTON_NEGATIVE:
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("sms:"+contactNumber));
                startActivity(smsIntent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String selectedItem = (String) parent.getItemAtPosition(position);
        current_location.setText(getResources().getString(R.string.reporting_current_location) + " " + selectedItem);

        // selectedLocationDetails holds all details about the location selected by the user
        selectedLocationDetails = locationDetails.get(selectedItem);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
