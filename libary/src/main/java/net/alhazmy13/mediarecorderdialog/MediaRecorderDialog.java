package net.alhazmy13.mediarecorderdialog;

import android.Manifest;
import android.content.Context;

import net.alhazmy13.gota.Gota;
import net.alhazmy13.gota.GotaResponse;

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
           // new SoundDialog(GenralAtteribute.context).show();
            new Gota(GenralAtteribute.context).checkPermission(new String[]{Manifest.permission.RECORD_AUDIO
                    ,Manifest.permission.WRITE_EXTERNAL_STORAGE}, new Gota.OnRequestPermissionsBack() {
                @Override
                public void onRequestBack(GotaResponse goaResponse) {
                    new SoundDialog(GenralAtteribute.context).show();
                }
            });

            return this;
        }

        public MediaRecorderDialog.Builder setOutputFormat(OutputFormat outputFormat){
            GenralAtteribute.outPutFormat=outputFormat;
            return this;
        }

        public MediaRecorderDialog.Builder setAudioEncoder(AudioEncoder audioEncoder){
            GenralAtteribute.audioEncoder=audioEncoder;
            return this;
        }

        public MediaRecorderDialog.Builder setOnSaveButtonClickListener(OnSaveButtonClickListener onSaveButtonClickListener){
            GenralAtteribute.onSaveButtonClickListener=onSaveButtonClickListener;
            return this;
        }

        public MediaRecorderDialog.Builder setMaxLength(TimeUnit timeUnit,int length){
            GenralAtteribute.length = length*timeUnit.getValue() ;
            return this;
        }

    }

    public enum  OutputFormat {
        AAC_ADTS(6),AMR_NB(3),AMR_WB(4),DEFAULT(0),MPEG_4(2);
        private final int value;

        OutputFormat(int value){

            this.value = value;
        }
        public int getValue(){
            return value;
        }

    }

    public enum  AudioEncoder {
        AAC (3),AAC_ELD(5),AMR_NB(1),AMR_WB(2),DEFAULT(0),HE_AAC(4),VORBIS(6);

        private final int value;

        AudioEncoder(int value){

            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public enum  TimeUnit {
        MINUTES(60),SECONDS(1);

        private final int value;

        TimeUnit(int value){

            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
