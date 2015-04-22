package com.example.parkt_000.paoyingchub;

/**
 * Created by parkt_000 on 2/24/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ProgressBar;

public class Splash_screen extends ActionBarActivity {
    public static final int sec=8;
    public static final int milli =sec*8;
    public static final int delay=2;
    private ProgressBar progressBar;


    private final int SPLASH_DISPLAY_LENGTH = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash_screen.this,bgame.class);
                Splash_screen.this.startActivity(mainIntent);
                Splash_screen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(max_progress());
        //animation();





    }
    public void animation(){

        new CountDownTimer(milli,10000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress(estimate_progress(millisUntilFinished));

            }

            @Override
            public void onFinish() {
                Intent moveto=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(moveto);
                finish();
            }
        }.start();
    }

    public int estimate_progress(long miliseconds){

        return (int)((milli-miliseconds)/1000);
    }

    public int max_progress(){
        return sec-delay;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
