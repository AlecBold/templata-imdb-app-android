package com.example.imdbapplication.popup;

import android.content.Context;
import android.widget.Toast;

public class PopUpErrorHelper {

    public static boolean showToastIfErrorMessage(Context context, String errorMessage) {
        if (errorMessage == null || !errorMessage.equals("")) {
            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

}
