package com.meysam.toastsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.meysam.mytoast.ShowToast;


public class MainActivity extends AppCompatActivity {

    Button showToastBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToastBtn=findViewById(R.id.show_toast);
        showToastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShowToast.with(MainActivity.this)
                        .setTypeFace("IRANSansMobile.ttf")
                        .setBackground(R.drawable.green_background)
                        .setRightIcon(R.drawable.ic_error)
                        .setRightIconTint(R.color.Red)
                        .setLeftIcon(R.drawable.ic_error)
                        .setLeftIconTint(R.color.Aqua)
                        .setPadding(20)
                        .setLength(ShowToast.LENGTH_LONG)
                        .show("This is test toast");

            }
        });
    }
}
