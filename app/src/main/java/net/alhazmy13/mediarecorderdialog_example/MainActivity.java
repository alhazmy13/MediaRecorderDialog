package net.alhazmy13.mediarecorderdialog_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.alhazmy13.mediarecorderdialog.MediaRecorderDialog;
import net.alhazmy13.mediarecorderdialog.OnSaveButtonClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                new MediaRecorderDialog.Builder(MainActivity.this)
                        .setOutputFormat(MediaRecorderDialog.OutputFormat.MPEG_4)
                        .setAudioEncoder(MediaRecorderDialog.AudioEncoder.AAC)
                        .setTitle("Recording,,,")
                        .setMessage("Press the button")
                        .setOnSaveButtonClickListener(new OnSaveButtonClickListener() {
                            @Override
                            public void onSucceed(String path) {
                                Toast.makeText(MainActivity.this,path,Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure() {
                                //Toast.makeText(MainActivity.this,"onFailure",Toast.LENGTH_SHORT).show();

                            }
                        })
                        .show();



            }
        });


    }
}
