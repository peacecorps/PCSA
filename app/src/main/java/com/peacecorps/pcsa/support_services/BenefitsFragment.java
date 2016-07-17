package com.peacecorps.pcsa.support_services;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peacecorps.pcsa.R;

/**
 * Benefits of Seeking Staff Support
 * @author rohan
 * @since 2016-07-17
 */
public class BenefitsFragment extends Fragment {

    public static final String TAG = BenefitsFragment.class.getSimpleName();
    TextView benefitsContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_benefits,container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.benefits);
        benefitsContent = (TextView) rootView.findViewById(R.id.benefits_content);
        benefitsContent.setText(R.string.benefits_info);
        benefitsContent.setMovementMethod(new ScrollingMovementMethod());
        return rootView;
    }
}
