package com.acadgild.dailogexamplesession11demo;

import android.app.AlertDialog;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /** What do you mean by a Dailog:
     * Any alert you see oon the screen is acalled a Dailox Vox ::
     *
     * Alert Dailog Box : When the exiting the application
     * Are you sure you want to exit ? Yes/No/Cancel
     * @param savedInstanceState
     */
    FragmentManager fm=getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.dbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAlertDailogBox();
            }
        });

        Button alertfrgbutton=(Button) findViewById(R.id.alertfragbutton);
        alertfrgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDFragment alertDFragment = new AlertDFragment();

                alertDFragment.show(fm,"Alert Fragment");
               // alertDFragment.show(fm,"Alert Dialog Fragment");
            }
        });
    }

    public void openAlertDailogBox(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Exit App")
                .setMessage("Are you sure you want to exit the App ?")
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"NO Clicked",Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"User is Exiting",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                })

                .setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Operation Cancelled",Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                })
                .setIcon(R.mipmap.ic_launcher)
                .show();

    }
}
