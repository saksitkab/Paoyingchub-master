package com.example.parkt_000.paoyingchub;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;


public class Player_statistic extends ActionBarActivity {

    int profile_wwinstreak;
    int profile_llose;
    int profile_wwin;
    int profile_ddraw;
    String profile_uusername;
    int profile_aavatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_statistic);

        ParseUser user = ParseUser.getCurrentUser();

        String username = user.getUsername();

        ParseQuery<ParseObject> query2 = ParseQuery.getQuery("Player");
        query2.whereEqualTo("id_player", username);
        query2.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (object == null) {
                    Toast.makeText(getApplicationContext(), "Error.",
                            Toast.LENGTH_SHORT).show();
                } else {
                    profile_wwinstreak  = object.getInt("winstreak");
                    profile_wwin  = object.getInt("win");
                    profile_llose  = object.getInt("lose");
                    profile_ddraw  = object.getInt("draw");
                    profile_aavatar  = object.getInt("avatar");

                    profile_uusername  = object.getString("id_player");

                    String winstreak_temp = String.valueOf(profile_wwinstreak);
                    String win_temp = String.valueOf(profile_wwin);
                    String lose_temp = String.valueOf(profile_llose);
                    String draw_temp = String.valueOf(profile_ddraw);
                    //String aavatar_temp = String.valueOf(profile_aavatar);

                    int allgamescore = profile_ddraw + profile_wwin + profile_llose;
                    String allgamescoreset = String.valueOf(allgamescore);

                    EditText profile_allgame = (EditText) findViewById(R.id.profile_allgame);
                    profile_allgame.setText(allgamescoreset);


                    EditText profile_ws = (EditText) findViewById(R.id.profile_winstreak);
                    profile_ws.setText(winstreak_temp);
                    EditText profile_w = (EditText) findViewById(R.id.profile_win);
                    profile_w.setText(win_temp);
                    EditText profile_d = (EditText) findViewById(R.id.profile_draw);
                    profile_d.setText(lose_temp);
                    EditText profile_l = (EditText) findViewById(R.id.profile_lose);
                    profile_l.setText(draw_temp);
                    EditText profile_u = (EditText) findViewById(R.id.profile_username);
                    profile_u.setText(profile_uusername);

                    ImageView profile_a = (ImageView) findViewById(R.id.profile_avatar);


                    if(profile_aavatar == 2131296386){
                        profile_a.setImageResource(R.drawable.pig);

                    }
                    else if(profile_aavatar == 2131296387){
                        profile_a.setImageResource(R.drawable.chickenja);

                    }
                    else if (profile_aavatar == 2131296389 ){
                        profile_a.setImageResource(R.drawable.cow);

                    }
                }
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player_statistic, menu);
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
