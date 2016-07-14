package com.peacecorps.pcsa.safety_tools;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.peacecorps.pcsa.R;

/*
 * Common Fragment for all 3 screens of ByStander Intervention
 *
 * @author rohan
 * @since 2016-07-08
 */
public class BystanderInterventionCommonFragment extends Fragment {

    TextView subtitle,content;
    public static final String TAG = BystanderInterventionCommonFragment.class.getSimpleName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_bystander_common,container,false);
        String subtitleString = getArguments().getString(BystanderInterventionFragment.SUBTITLE_KEY);
        String contentString = getArguments().getString(BystanderInterventionFragment.CONTENT_KEY);
        subtitle = (TextView) rootView.findViewById(R.id.bystander_common_subtitle);
        content = (TextView) rootView.findViewById(R.id.bystander_common_content);
        subtitle.setText(Html.fromHtml(subtitleString));
        content.setMovementMethod(new ScrollingMovementMethod());
        content.setText(Html.fromHtml(contentString));
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.bystander_intervention);
        return rootView;
    }
}
