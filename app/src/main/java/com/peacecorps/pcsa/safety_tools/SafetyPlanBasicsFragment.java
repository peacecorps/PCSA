package com.peacecorps.pcsa.safety_tools;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.peacecorps.pcsa.R;

/*
 * Safety Plan, Main Fragment
 *
 * @author rohan
 * @since 2016-07-08
 */
public class SafetyPlanBasicsFragment extends Fragment {

    Button mainReasons,cannot,purpose,tips;
    public static final String TAG = SafetyPlanBasicsFragment.class.getSimpleName();
    public static final String TITLE_KEY = "title";
    public static final String CONTENT_KEY = "content";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_safety_basics,container,false);
        mainReasons = (Button)rootView.findViewById(R.id.mainReasons);
        cannot = (Button)rootView.findViewById(R.id.plansCannot);
        purpose = (Button)rootView.findViewById(R.id.purposePlan);
        tips = (Button)rootView.findViewById(R.id.tips);
        mainReasons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(getString(R.string.basics_main),getString(R.string.safety_plan_basics_1));
            }
        });
        purpose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(getString(R.string.basics_purpose),getString(R.string.safety_plan_basics_2));
            }
        });
        cannot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(getString(R.string.basics_cannot),getString(R.string.safety_plan_basics_3));
            }
        });
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(getString(R.string.basics_tips),getString(R.string.safety_plan_basics_4));
            }
        });
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(R.string.safety_plan_basics);
        return rootView;
    }

    /**
     * Populates the required data for the dialog box which appears
     * @param title title of the dialog box
     * @param contentToShow  data to be displayed
     */
    private void showDialog(String title,String contentToShow)
    {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        SafetyPlanBasicsContentFragment safetyPlanBasicsContentFragment = new SafetyPlanBasicsContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE_KEY,title);
        bundle.putString(CONTENT_KEY,contentToShow);
        safetyPlanBasicsContentFragment.setArguments(bundle);
        safetyPlanBasicsContentFragment.show(fm,getString(R.string.sample_fragment));
    }
}
