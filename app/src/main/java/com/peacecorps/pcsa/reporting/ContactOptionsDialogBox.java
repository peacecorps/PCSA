package com.peacecorps.pcsa.reporting;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.peacecorps.pcsa.R;

/**
 * Created by Rohan on 13-03-2016.
 */
public class ContactOptionsDialogBox extends DialogFragment {

    private static Context context;
    private Dialog listDialog;
    public static ContactOptionsDialogBox newInstance(String title, Activity activity)
    {
        context = (Context)activity;
        ContactOptionsDialogBox customAlertDialogFragment = new ContactOptionsDialogBox();
        Bundle args = new Bundle();
        args.putString("title",title);
        customAlertDialogFragment.setArguments(args);
        return customAlertDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        String title = getArguments().getString("title");
        //Initialising the dialog box
        listDialog = new Dialog(context);
        listDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        listDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //Initialising the listview
        View view = layoutInflater.inflate(R.layout.dialog_list, null);
        listDialog.setContentView(view);
        ListView list1 = (ListView) listDialog.findViewById(R.id.dialog_listview);

        //Adding the header(title) to the dialog box
        TextView textView = new TextView(context);
        textView.setText(title);
        textView.setTextColor(context.getResources().getColor(R.color.primary_text_default_material_dark));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        textView.setGravity(Gravity.CENTER);
        list1.addHeaderView(textView);

        list1.setAdapter(new CustomAdapter(context));

        //Providing functionality to the listitems (Call and Message)
        list1.setOnItemClickListener((AdapterView.OnItemClickListener) context);

        return listDialog;
    }
}
