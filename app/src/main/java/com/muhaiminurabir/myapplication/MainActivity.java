package com.muhaiminurabir.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.example_1)
    Button example1;
    @BindView(R.id.example_2)
    Button example2;
    @BindView(R.id.example_3)
    Button example3;
    @BindView(R.id.example_4)
    Button example4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //new Send_data_task().execute("my string parameter");
    }

    @OnClick({R.id.example_1, R.id.example_2, R.id.example_3, R.id.example_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.example_1:
                new Example_ONE().execute("my string parameter");
                break;
            case R.id.example_2:
                new Example_Two().execute("my string parameter");
                break;
            case R.id.example_3:
                new Example_Three().execute("my string parameter");
                break;
            case R.id.example_4:
                new Example_Four().execute("my string parameter");
                break;
        }
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

            progressDialog4 = ProgressDialog.show(MainActivity.this, "ProgressDialog", "Wait!");

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
                while (running) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (i-- == 0) {
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
            } catch (Exception e) {
                Log.d("Paisi send data 2", e.toString());
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

    private class Example_ONE extends AsyncTask<String, Integer, String> {
        ProgressDialog example_one;
        boolean running;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Do something like display a progress bar
            running = true;
            example_one = ProgressDialog.show(MainActivity.this, "EXAMPLE ONE", "Wait!");
            example_one.setCanceledOnTouchOutside(false);
        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {
            try {
                int i = 10;
                while (running) {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (i-- == 0) {
                        running = false;
                    }

                    //publishProgress(i);

                }
            } catch (Exception e) {
                Log.d("Paisi send data 2", e.toString());
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
            example_one.dismiss();
            // Do things like hide the progress bar or change a TextView
        }
    }

    private class Example_Two extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        CustomProgressBar example_two;
        boolean running;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            example_two = new CustomProgressBar();
            example_two.show(MainActivity.this, "EXAMPLE TWO..");
            // Do something like display a progress bar
            running = true;
        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {
            try {
                int i = 10;
                while (running) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (i-- == 0) {
                        running = false;
                    }

                    //publishProgress(i);

                }
            } catch (Exception e) {
                Log.d("Paisi send data 2", e.toString());
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
            example_two.getDialog().dismiss();
            //progressDialog2.cancel();
            //progressDialog3.dismiss();
            /*Toast.makeText(MainActivity.this,
                    "Progress Ended",
                    Toast.LENGTH_LONG).show();*/
            // Do things like hide the progress bar or change a TextView
        }
    }

    private class Example_Three extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        DelayedProgressDialog example_three;
        boolean running;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            example_three = new DelayedProgressDialog();
            example_three.show(getSupportFragmentManager(), "tag");
            example_three.setCancelable(false);
            // Do something like display a progress bar
            running = true;
        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {
            try {
                int i = 10;
                while (running) {
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i-- == 0) {
                        running = false;
                    }

                    //publishProgress(i);

                }
            } catch (Exception e) {
                Log.d("Paisi send data 2", e.toString());
            }

            return "this string is passed to onPostExecute";
        }

        // This is called from background thread but runs in UI
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // Do things like update the progress bar
        }

        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            example_three.cancel();
            // Do things like hide the progress bar or change a TextView
        }
    }

    private class Example_Four extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        ProgressDialog example_four;
        boolean running;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            example_four = new ProgressDialog(MainActivity.this);
            example_four.setMessage("Example Four");
            example_four.setCancelable(false);
            example_four.show();
            // Do something like display a progress bar
            running = true;
            example_four.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    running = false;
                }
            });
        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {
            try {
                int i = 10;
                while (running) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (i-- == 0) {
                        running = false;
                    }

                    //publishProgress(i);

                }
            } catch (Exception e) {
                Log.d("Paisi send data 2", e.toString());
            }

            return "this string is passed to onPostExecute";
        }

        // This is called from background thread but runs in UI
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // Do things like update the progress bar
        }

        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            example_four.dismiss();
            /*Toast.makeText(MainActivity.this,
                    "Progress Ended",
                    Toast.LENGTH_LONG).show();*/
        }
    }
}
