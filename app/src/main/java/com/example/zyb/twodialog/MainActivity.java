package com.example.zyb.twodialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Dialog dialog;
    private Dialog dialog1;
    private EditText x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = (EditText) findViewById(R.id.x);
        y = (EditText) findViewById(R.id.y);
    }

    public void show(View view) {
        if (dialog == null) {
            dialog = new Dialog(this, R.style.dialog_two);
            dialog.setContentView(R.layout.dialog_one);
            dialog.setCancelable(false);
        }
        dialog.show();
        dialog.findViewById(R.id.dialog_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

    public void showTwo(View view) {
        if (dialog1 == null) {
            dialog1 = new Dialog(MainActivity.this, R.style.CustomDialog);
            dialog1.setContentView(R.layout.dialog_two);
            dialog1.setCancelable(false);
        }
        Window dialogWindow = dialog1.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        String x = this.x.getText().toString().trim();
        String y = this.y.getText().toString().trim();
        if (x.isEmpty()||y.isEmpty()){
            lp.x = 0;
            lp.y = 0;
        }else {
            lp.x = Integer.parseInt(x);
            lp.y = Integer.parseInt(y);
        }
        dialogWindow.setGravity(Gravity.RIGHT | Gravity.BOTTOM);
        dialogWindow.setAttributes(lp);

        dialog1.show();
        dialog1.findViewById(R.id.dialog_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
    }
}
