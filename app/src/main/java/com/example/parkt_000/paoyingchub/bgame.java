package com.example.parkt_000.paoyingchub;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * Created by parkt_000 on 2/24/2015.
 */
public class bgame extends ActionBarActivity {


    DBgame helper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.bgame);
    }

    public void buttonClicked(View v) {
        int id = v.getId();
         EditText name = (EditText)findViewById(R.id.name);

        Intent i;

        switch (id) {
            case R.id.enter:{
                if(name == null){
                    break;
                }

                else {




                   String ssname = name.getText().toString();


                    i = new Intent(this, game.class);
                    i.putExtra("Ename",ssname);

                    startActivityForResult(i, 88);
                    break;
                }
            }



            case R.id.reset:
                name.setText("");



                break;

            case R.id.main:
                i = new Intent(this, MainActivity.class);
                startActivity(i);




                break;


        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 88) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                int score = data.getIntExtra("score", 0);

                Log.d("user",""+score);


                helper = new DBgame(this.getApplicationContext());
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues r = new ContentValues();

                r.put("name",name);
                r.put("score",score);

                long new_id = db.insert("dbscore",null,r);


            }
        }

        Log.d("dbscore", "onActivityResult");
    }




    @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_high_score, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
