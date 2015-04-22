package com.example.parkt_000.paoyingchub;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.parse.ParseUser;


public class newmain extends ActionBarActivity {

    TextView msgUsertext;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newmain);
        ParseUser user = ParseUser.getCurrentUser();
            msgUsertext  = (TextView) findViewById(R.id.msgtouser_text);
        msgUsertext.setText("Hello" + " " + user.getUsername());
        player=MediaPlayer.create(newmain.this,R.raw.main);
    }


    protected void onResume() {
        super.onResume();
    }

    public void buttonClickednewmain(View v) {
        int id = v.getId();
        Intent i;

        switch (id) {
            case R.id.playon_bot:


                //timer();
                i = new Intent(this, game_login.class);
                startActivity(i);
                break;

            case R.id.world_bot:
                break;
            case R.id.showon_bot:
                i = new Intent(this, Player_statistic.class);
                startActivity(i);

                break;


        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_newmain, menu);
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
