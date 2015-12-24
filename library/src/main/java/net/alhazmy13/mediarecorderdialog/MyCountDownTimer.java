package net.alhazmy13.mediarecorderdialog;

/**
 * Created by Alhazmy13 on 12/21/15.
 */
class MyCountDownTimer implements Runnable {

    private SoundDialogView mView;
    private android.os.Handler handler;
    private int sec,min;

    public MyCountDownTimer(SoundDialogView view, android.os.Handler handler){
        this.mView=view;
        this.handler=handler;
    }
    @Override
    public void run() {
        sec++;
        if (sec == 60) {
            min++;
            sec = 0;
        }
        mView.updateTimer(String.format("%02d", min) + ":" + String.format("%02d", sec));
        handler.postDelayed(this, 1000);
    }
}