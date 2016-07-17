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
 * PCs commitment to Victims
 * @author rohan
 * @since 2016-07-17
 */
public class CommitmentFragment extends Fragment {

    public static final String TAG = CommitmentFragment.class.getSimpleName();
    TextView commitmentContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_commitment,container,false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.commitment);
        commitmentContent = (TextView) rootView.findViewById(R.id.commitment_content);
        commitmentContent.setText(R.string.commitment_info);
        commitmentContent.setMovementMethod(new ScrollingMovementMethod());
        return rootView;
    }

}
