package com.example.zadatakjelov1masterfinal.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

import com.example.zadatakjelov1masterfinal.R;

public class AboutDialog extends AlertDialog.Builder {


    public AboutDialog(Context context) {
        super(context);

        setTitle(R.string.dialog_title);
        setMessage(R.string.dialog_message);
        setCancelable(false);

        setPositiveButton(R.string.dialog_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        setNegativeButton(R.string.dialog_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

    }

    public AlertDialog prepareDialog() {
       AlertDialog dialog = create();
        dialog.setCanceledOnTouchOutside(false);

        return dialog;
    }

}
