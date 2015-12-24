package net.alhazmy13.mediarecorderdialog;

import android.content.Context;

/**
 * Created by Alhazmy13 on 12/23/15.
 */
public class MediaRecorderDialog  {

    public MediaRecorderDialog(){

    }
    public static class  Builder{
        public Builder(Context context) {
          GenralAtteribute.context=context;
            GenralAtteribute.title="";
            GenralAtteribute.message="";
            GenralAtteribute.outPutFormat=OutputFormat.MPEG_4;
            GenralAtteribute.audioEncoder=AudioEncoder.AAC;
        }
        public MediaRecorderDialog.Builder setTitle(String title) {
            GenralAtteribute.title=title;
            return this;
        }
        public MediaRecorderDialog.Builder setMessage(String msg) {
            GenralAtteribute.message=msg;
            return this;
        }
        public MediaRecorderDialog.Builder show(){
            new SoundDialog(GenralAtteribute.context).show();
            return this;
        }

        public MediaRecorderDialog.Builder setOutputFormat(int outputFormat){
            GenralAtteribute.outPutFormat=outputFormat;
            return this;
        }

        public MediaRecorderDialog.Builder setAudioEncoder(int audioEncoder){
            GenralAtteribute.audioEncoder=audioEncoder;
            return this;
        }

        public MediaRecorderDialog.Builder setOnSaveButtonClickListener(OnSaveButtonClickListener onSaveButtonClickListener){
            GenralAtteribute.onSaveButtonClickListener=onSaveButtonClickListener;
            return this;
        }

    }

    public final class OutputFormat {
        public static final int AAC_ADTS = 6;
        public static final int AMR_NB = 3;
        public static final int AMR_WB = 4;
        public static final int DEFAULT = 0;
        public static final int MPEG_4 = 2;
        /** @deprecated */
        @Deprecated
        public static final int RAW_AMR = 3;
        public static final int THREE_GPP = 1;
        public static final int WEBM = 9;

        OutputFormat() {
            throw new RuntimeException("Stub!");
        }
    }

    public final class AudioEncoder {
        public static final int AAC = 3;
        public static final int AAC_ELD = 5;
        public static final int AMR_NB = 1;
        public static final int AMR_WB = 2;
        public static final int DEFAULT = 0;
        public static final int HE_AAC = 4;
        public static final int VORBIS = 6;

        AudioEncoder() {
            throw new RuntimeException("Stub!");
        }
    }


}
