package app.naklab.assu.android.android_gifanimatedprogressdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    Button buttonCreateDialog;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreateDialog = findViewById(R.id.buttonCreateDialog);
        buttonCreateDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View dialogRoot = MainActivity.this.getLayoutInflater().inflate(R.layout.progress_dialog, null);
                ImageView imageView = dialogRoot.findViewById(R.id.imageViewProgressDisplay);
                Glide.with(MainActivity.this).load(R.drawable.radial_dark).into(imageView);

                Button buttonDismiss = dialogRoot.findViewById(R.id.buttonDismissDialog);
                buttonDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog = new AlertDialog.Builder(MainActivity.this)
                        .setView(dialogRoot)
                        .create();

                dialog.show();


                CountDown countDown = new CountDown(2000, 100);
                countDown.setOnFinishListener(new CountDown.OnFinishListener() {
                    @Override
                    public void onFinish() {
                        if (dialog.isShowing()) dialog.dismiss();
                    }
                });
                countDown.start();

            }
        });

    }
}
