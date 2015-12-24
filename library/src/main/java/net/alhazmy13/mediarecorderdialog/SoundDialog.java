package net.alhazmy13.mediarecorderdialog;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.skyfishjy.library.RippleBackground;
import com.truizlop.fabreveallayout.FABRevealLayout;
import com.truizlop.fabreveallayout.OnRevealChangeListener;

import net.alhazmy13.gota.Gota;
import net.alhazmy13.gota.GotaResponse;

import java.io.IOException;

/**
 * Created by Alhazmy13 on 12/21/15.
 */
class SoundDialog extends Dialog implements View.OnClickListener,SeekBar.OnSeekBarChangeListener,SoundDialogView,OnRevealChangeListener,DialogInterface.OnDismissListener {

    public Activity activity;
    private Runnable runnable;
    private SeekBar progressBar;
    private FABRevealLayout fab;
    private RippleBackground rippleBackground;
    private ImageView stopRecording,save,play,stopPlaing;
    private LinearLayout recrodLayout,playLayout;
    private TextView timer,title,msg;
    private Handler handler = new Handler();
    private AudioManager audioManager;
    private MediaPlayer mp;
    private MediaRecorder recorder;
    private String path;
    private boolean isSaved;
    public SoundDialog(Context a) {
        super(a);
        this.activity = (Activity) a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sound_dialog);
        new Gota(activity).checkPermission(new String[]{Manifest.permission.RECORD_AUDIO
                ,Manifest.permission.WRITE_EXTERNAL_STORAGE}, new Gota.OnRequestPermissionsBack() {
            @Override
            public void onRequestBack(GotaResponse goaResponse) {

            }
        });
        initViews();
        runnable = new MyCountDownTimer(this,handler);
        setListeners();
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(GenralAtteribute.outPutFormat);
        recorder.setAudioEncoder(GenralAtteribute.audioEncoder);
        path="/sdcard/Music/"+System.currentTimeMillis()+".3gp";
        recorder.setOutputFile(path);
        this.setOnDismissListener(this);

    }

    private void setListeners() {
        fab.setOnRevealChangeListener(this);
        progressBar.setOnSeekBarChangeListener(this);
        progressBar.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));
        stopRecording.setOnClickListener(this);
        play.setOnClickListener(this);
        stopPlaing.setOnClickListener(this);
        save.setOnClickListener(this);
    }



    private void initViews(){
        fab = (FABRevealLayout) findViewById(R.id.fab_reveal_layout);
        stopRecording = (ImageView) findViewById(R.id.stopRecording);
        stopPlaing = (ImageView) findViewById(R.id.stop);
        rippleBackground=(RippleBackground)findViewById(R.id.content);
        recrodLayout = (LinearLayout) findViewById(R.id.recordingLayout);
        playLayout = (LinearLayout) findViewById(R.id.playLayout);
        timer = (TextView) findViewById(R.id.timer);
        msg= (TextView) findViewById(R.id.msg);
        title = (TextView) findViewById(R.id.title);
        progressBar = (SeekBar) findViewById(R.id.record_progress_bar);
        play = (ImageView) findViewById(R.id.play);
        play.setTag(R.drawable.ic_play_arrow_black_24dp);
        audioManager = (AudioManager) activity.getSystemService(Activity.AUDIO_SERVICE);
        save = (ImageView) findViewById(R.id.save);
        title.setText(GenralAtteribute.title + "");
        msg.setText(GenralAtteribute.message + "");

    }

    @Override
    public void onClick(View view) {
       if(view == stopRecording){
            updateViews();
            rippleBackground.stopRippleAnimation();
            YoYo.with(Techniques.FadeIn)
                    .duration(700)
                    .playOn(playLayout);
           recorder.stop();
           mp=MediaPlayer.create(activity, Uri.parse(path));
           mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
               @Override
               public void onCompletion(MediaPlayer mediaPlayer) {
                   handler.removeCallbacks(runnable);
                   runnable=new MyCountDownTimer(SoundDialog.this,handler);
                   play.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_play_arrow_black_24dp));
                   play.setTag(R.drawable.ic_play_arrow_black_24dp);
               }
           });
        }else if(view == play){
            if((Integer)play.getTag() ==  R.drawable.ic_play_arrow_black_24dp) {
                play.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_pause_black_18dp));
                handler.postDelayed(runnable, 1000);
                play.setTag(R.drawable.ic_pause_black_18dp);
                mp.start();
            }else{
                play.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_play_arrow_black_24dp));
                handler.removeCallbacks(runnable);
                play.setTag(R.drawable.ic_play_arrow_black_24dp);
                mp.pause();
            }
        }else if(view == stopPlaing){
           handler.removeCallbacks(runnable);
           runnable=new MyCountDownTimer(SoundDialog.this,handler);
           play.setImageDrawable(activity.getResources().getDrawable(R.drawable.ic_play_arrow_black_24dp));
           play.setTag(R.drawable.ic_play_arrow_black_24dp);
           mp.stop();
       }else if(view == save){
           GenralAtteribute.onSaveButtonClickListener.onSucceed(path);
           isSaved=true;
           dismiss();
       }
    }

    private void updateViews() {
        recrodLayout.setVisibility(View.GONE);
        playLayout.setVisibility(View.VISIBLE);
        timer.setVisibility(View.VISIBLE);
        rippleBackground.setVisibility(View.GONE);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void updateTimer(String value) {
        timer.setText(value);
    }

    @Override
    public void onMainViewAppeared(FABRevealLayout fabRevealLayout, View mainView) {

    }

    @Override
    public void onSecondaryViewAppeared(FABRevealLayout fabRevealLayout, View secondaryView) {
        rippleBackground.startRippleAnimation();
        rippleBackground.setVisibility(View.VISIBLE);
        try {
            recorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        recorder.start();
    }




    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        if (!isSaved)
            GenralAtteribute.onSaveButtonClickListener.onFailure();

    }
}