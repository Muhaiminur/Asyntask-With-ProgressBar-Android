package com.muhaiminurabir.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Send_data_task().execute("my string parameter");
    }
    private class Send_data_task extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        CustomProgressBar progressBar1;


        DelayedProgressDialog progressDialog2;
        ProgressDialog progressDialog3;
        ProgressDialog progressDialog4;
        boolean running;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //progressBar1 = new CustomProgressBar();
            //progressBar1.show(MainActivity.this,"Loading..");

            /*progressDialog2 = new DelayedProgressDialog();
            progressDialog2.show(getSupportFragmentManager(), "tag");
            progressDialog2.setCancelable(false);*/
            /*progressDialog3 = new ProgressDialog(MainActivity.this);
            progressDialog3.setMessage("Please Wait");
            progressDialog3.setCancelable(false);
            progressDialog3.show();


            */// Do something like display a progress bar

            running = true;

            progressDialog4 = ProgressDialog.show(MainActivity.this,"ProgressDialog","Wait!");

            progressDialog4.setCanceledOnTouchOutside(false);
            /*progressDialog3.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    running = false;
                }
            });*/

            /*Toast.makeText(MainActivity.this,
                    "Progress Start",
                    Toast.LENGTH_LONG).show();*/
        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {
            try {
                int i = 10;
                while(running){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(i-- == 0){
                        running = false;
                    }

                    //publishProgress(i);

                }


                /*Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // Actions to do after 10 seconds
                        Log.d("Ghumaisi","Bhitore");
                    }
                }, 10000);*/
            }catch (Exception e){
                Log.d("Paisi send data 2",e.toString());
            }

            return "this string is passed to onPostExecute";
        }

        // This is called from background thread but runs in UI
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            //progressDialog4.setMessage(String.valueOf(values[0]));
            // Do things like update the progress bar
        }

        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //progressBar1.getDialog().dismiss();
            //progressDialog2.cancel();
            //progressDialog3.dismiss();
            /*Toast.makeText(MainActivity.this,
                    "Progress Ended",
                    Toast.LENGTH_LONG).show();*/

            progressDialog4.dismiss();
            // Do things like hide the progress bar or change a TextView
        }
    }
}
