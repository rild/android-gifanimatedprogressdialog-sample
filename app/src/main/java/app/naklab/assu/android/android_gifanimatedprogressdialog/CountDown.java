package app.naklab.assu.android.android_gifanimatedprogressdialog;

import android.os.CountDownTimer;

public class CountDown extends CountDownTimer {

    //ここにリスナーを入れるための変数を宣言する
    OnFinishListener onFinishListener;
    OnTickListener onTickListener;

    public CountDown(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //毎秒呼ばれる (呼ばれる間隔は指定することができる)
        if (onTickListener != null) onTickListener.onTick(millisUntilFinished);
    }

    @Override
    public void onFinish() {
        //数え終わった時に呼ばれる
        if (onFinishListener != null) onFinishListener.onFinish();
    }

    public void setOnFinishListener(OnFinishListener onFinishListener) {
        this.onFinishListener = onFinishListener;
    }

    public void setOnTickListener(OnTickListener onTickListener) {
        this.onTickListener = onTickListener;
    }

    public interface OnFinishListener {
        void onFinish();
    }

    public interface OnTickListener {
        void onTick(long millisUntilFinished);
    }
}