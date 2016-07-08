package com.peacecorps.pcsa.safety_tools;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.peacecorps.pcsa.R;

/*
 * One Fragment which acts like a placeholder for every different screens of Safety Plan Basics
 *
 * @author rohan
 * @since 2016-07-08
 */
public class SafetyPlanBasicsContentFragment extends DialogFragment {

    TextView contenttoDisplay,titleToDisplay;
    LinearLayout parentView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_safety_plan_basics_content, container, false);
        parentView = (LinearLayout) rootView.findViewById(R.id.myView);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        contenttoDisplay = (TextView) rootView.findViewById(R.id.safety_plan_basics_content);
        titleToDisplay = (TextView) rootView.findViewById(R.id.safety_plan_basics_title);
        String title = getArguments().getString(SafetyPlanBasicsFragment.TITLE_KEY);
        String content = getArguments().getString(SafetyPlanBasicsFragment.CONTENT_KEY);
        contenttoDisplay.setText(Html.fromHtml(content));
        contenttoDisplay.setMovementMethod(new ScrollingMovementMethod());
        titleToDisplay.setText(Html.fromHtml(title));
        titleToDisplay.setTypeface(null,Typeface.BOLD);
        titleToDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
        titleToDisplay.setGravity(Gravity.CENTER);
        getDialog().setTitle(title);
        return rootView;
    }
}
