package com.example.parkt_000.paoyingchub;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class HighScore extends ActionBarActivity
      {


   SimpleCursorAdapter adapter;
    DBgame helper;
    MediaPlayer player ;
    MediaPlayer player2 ;
    MediaPlayer player3 ;


          protected void onResume() {
              super.onResume();
              SQLiteDatabase db = helper.getReadableDatabase();

              Cursor cursor = db.rawQuery("SELECT _id,name,score FROM dbscore ORDER by score DESC ;", null);

              SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                      android.R.layout.simple_list_item_2, // A textview
                      cursor, // cursor to a data collection
                      new String[] {"name","score"}, // column to be displayed
                      new int[] {android.R.id.text1,android.R.id.text2}, // ID of textview to display
                      0);

              ListView lv = (ListView)findViewById(R.id.name);
              lv.setAdapter(adapter);
          }

          @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        player=MediaPlayer.create(HighScore.this,R.raw.rank);
        player.setLooping(true);
        player.start();
        setContentView(R.layout.activity_high_score);

        helper = new DBgame(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT _id,name,score FROM dbscore ORDER by score DESC  ;", null);
        cursor.moveToFirst();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2, // A textview
                cursor, // cursor to a data collection
                new String[] {"name","score"}, // column to be displayed
                new int[] {android.R.id.text1,android.R.id.text2}, // ID of textview to display
                0);

        ListView lv = (ListView)findViewById(R.id.name);
        lv.setAdapter(adapter);








          }





    public void buttonClicked(View v) {
        int id = v.getId();
        Intent i;

        switch(id) {
            case R.id.btmain:

                player.stop();
                player2=MediaPlayer.create(HighScore.this,R.raw.click);
                player2.start();
                i = new Intent(this, MainActivity.class);
                startActivityForResult(i, 88);
                break;



            case R.id.button3:
                player3=MediaPlayer.create(HighScore.this,R.raw.lose);
                player3.start();

                SQLiteDatabase db = helper.getWritableDatabase();
                int n_rows = db.delete("dbscore", "", null);
                onResume();
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_high_score, menu);
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
