package com.peacecorps.pcsa.support_services;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peacecorps.pcsa.R;

/**
 * Frequently Asked Questions (FAQ) page implemented as a list
 *
 * @author Buddhiprabha Erabadda
 * @since 07-08-2015
 */
public class FAQFragment extends ListFragment {

    public final static String TAG = FAQFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_coping,container,false);
        TextView subtitle = (TextView)rootView.findViewById(R.id.subtitle);
        subtitle.setText(getString(R.string.title_activity_faq));

        String[] values = new String[] {
                getResources().getString(R.string.reporting_faq1),getResources().getString(R.string.reporting_faq2),
                getResources().getString(R.string.reporting_faq3),getResources().getString(R.string.reporting_faq4),
                getResources().getString(R.string.reporting_faq5),getResources().getString(R.string.reporting_faq6)
        };

        String[] titles = new String[]{
                getResources().getString(R.string.reporting_faq1_header), getResources().getString(R.string.reporting_faq2_header),
                getResources().getString(R.string.reporting_faq3_header), getResources().getString(R.string.reporting_faq4_header),
                getResources().getString(R.string.reporting_faq5_header), getResources().getString(R.string.reporting_faq6_header)
        };
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.reporting_types);

        FAQArrayAdapter faqArrayAdapter = new FAQArrayAdapter(getActivity(), titles, values);
        setListAdapter(faqArrayAdapter);
        return rootView;
    }
}


