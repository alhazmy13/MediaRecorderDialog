package net.alhazmy13.mediarecorderdialog;

import android.content.Context;

/**
 * Created by Alhazmy13 on 12/24/15.
 */
class GenralAtteribute {
    protected static Context context;
    protected static String title="";
    protected static String message="";
    protected static MediaRecorderDialog.OutputFormat outPutFormat;
    protected static MediaRecorderDialog.AudioEncoder audioEncoder;
    protected static OnSaveButtonClickListener onSaveButtonClickListener;
    public static int length = -1;
}
