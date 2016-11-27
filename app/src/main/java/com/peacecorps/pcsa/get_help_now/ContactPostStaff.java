package com.peacecorps.pcsa.get_help_now;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.peacecorps.pcsa.MainActivity;
import com.peacecorps.pcsa.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Allows the user to call Post Staff in case of crime. The details for the
 * current location will be set by changing the location
 *
 * @author Buddhiprabha Erabadda
 * @since 07-08-2015
 */
public class ContactPostStaff extends Fragment implements AdapterView.OnItemClickListener {

    public static final String TAG = ContactPostStaff.class.getSimpleName() ;

    SharedPreferences sharedPreferences;

    TextView currentLocation;
    LocationDetails selectedLocationDetails;
    private String numberToContact;

    private static final Map<String, LocationDetails> locationDetails;
    static {
        locationDetails = new HashMap<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reporting_contact_post_staff,container,false);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        locationDetails.put(getResources().getString(R.string.loc1_name), new LocationDetails(getResources().getString(R.string.loc1_name), getResources().getString(R.string.loc1_pcmo), getResources().getString(R.string.loc1_ssm), getResources().getString(R.string.loc1_sarl)));
        locationDetails.put(getResources().getString(R.string.loc2_name), new LocationDetails(getResources().getString(R.string.loc2_name), getResources().getString(R.string.loc2_pcmo), getResources().getString(R.string.loc2_ssm), getResources().getString(R.string.loc2_sarl)));
        locationDetails.put(getResources().getString(R.string.loc3_name), new LocationDetails(getResources().getString(R.string.loc3_name), getResources().getString(R.string.loc3_pcmo), getResources().getString(R.string.loc3_ssm), getResources().getString(R.string.loc3_sarl)));

        Button contactPcmo = (Button) rootView.findViewById(R.id.post_staff_pcmo);
        Button contactSsm = (Button) rootView.findViewById(R.id.post_staff_ssm);
        Button contactSarl = (Button) rootView.findViewById(R.id.post_staff_sarl);
        currentLocation = (TextView) rootView.findViewById(R.id.post_staff_current_location);
        currentLocation.setText(getString(R.string.reporting_current_location) + " " + sharedPreferences.getString(getString(R.string.key_country),"") + getString(R.string.reporting_current_post));
        ImageView contactOtherStaff = (ImageView) rootView.findViewById(R.id.link_to_other_staff);

        contactPcmo.setText(R.string.contact_pcmo);
        contactSsm.setText(R.string.contact_ssm);
        contactSarl.setText(R.string.contact_sarl);

        contactPcmo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberToContact = selectedLocationDetails.getPcmoContact();
                ContactOptionsDialogBox contactOptionsDialogBox = ContactOptionsDialogBox.newInstance(getString(R.string.contact_pcmo_via),
                        getActivity(),ContactPostStaff.this);
                contactOptionsDialogBox.show(getActivity().getSupportFragmentManager(),getString(R.string.dialog_tag));
            }
        });

        contactSsm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberToContact = selectedLocationDetails.getSsmContact();
                ContactOptionsDialogBox contactOptionsDialogBox = ContactOptionsDialogBox.newInstance(getString(R.string.contact_ssm_via),
                        getActivity(),ContactPostStaff.this);
                contactOptionsDialogBox.show(getActivity().getSupportFragmentManager(), getString(R.string.dialog_tag));
            }
        });

        contactSarl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberToContact = selectedLocationDetails.getSarlContact();
                ContactOptionsDialogBox contactOptionsDialogBox = ContactOptionsDialogBox.newInstance(getString(R.string.contact_sarl_via),
                        getActivity(),ContactPostStaff.this);
                contactOptionsDialogBox.show(getActivity().getSupportFragmentManager(), getString(R.string.dialog_tag));
            }
        });
        
        contactOtherStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Swapping ContactOtherStaff into the fragment container dynamically
                Fragment contactOtherStaffFragment = new ContactOtherStaff();
                MainActivity.swapFragmentIn(getActivity(),contactOtherStaffFragment,ContactOtherStaff.TAG,true);
            }
        });
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.reporting_get_help);

        return rootView;
    }
    
    /**
     * Interface definition for a callback to be invoked when an item in this AdapterView has been clicked.
     *
     * @param parent The AdapterView where the click happened.
     * @param view  The view within the AdapterView that was clicked (this will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //For Voice Call
        if(position == 1)
        {
            Intent callingIntent = new Intent(Intent.ACTION_CALL);
            callingIntent.setData(Uri.parse("tel:" + numberToContact));
            startActivity(callingIntent);
        }
        //For Message
        else if(position == 2) {
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("sms:" + numberToContact));
            startActivity(smsIntent);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        selectedLocationDetails = locationDetails.get(sharedPreferences.getString(getString(R.string.key_country),getString(R.string.country_default)));
        if(currentLocation != null)
            currentLocation.setText(getString(R.string.reporting_current_location) + " " + sharedPreferences.getString(getString(R.string.key_country),"")+ getString(R.string.reporting_current_post));
    }
}
