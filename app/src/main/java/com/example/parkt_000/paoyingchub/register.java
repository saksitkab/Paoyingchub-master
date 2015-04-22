package com.example.parkt_000.paoyingchub;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class register extends ActionBarActivity {

    private EditText musername;
    private EditText mpassword;
    private EditText msecretpassword;
    private RadioGroup mavatar;
    private Button confirm;

    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mContext = this;
        musername = (EditText) findViewById(R.id.id_box);
        mpassword = (EditText) findViewById(R.id.password_box);
        msecretpassword = (EditText) findViewById(R.id.secret_box);
        mavatar = (RadioGroup)findViewById(R.id.avatar_group);
        confirm = (Button)findViewById(R.id.confirm_bot);

    }






        public void ClickRegister (View v){

            Intent i;

        String username = musername.getText().toString().trim().toLowerCase();
        String password = mpassword.getText().toString();
        String secretpassword = msecretpassword.getText().toString();
        int avatar = 0;
        avatar = mavatar.getCheckedRadioButtonId();

        int SetNumber = 0;


        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.put("avatar", avatar);
        user.put("secretpassword", secretpassword);
            user.put("No_game", SetNumber);
            user.put("No_win", SetNumber);
            user.put("No_lose", SetNumber);
            user.put("No_winstreak",SetNumber);

            ParseObject player = new ParseObject("Player");
            player.put("id_player", username);
            player.put("password_player", password);
            player.put("avatar", avatar);
           player.put("secretpassword", secretpassword);

            player.put("No_game", SetNumber);
            player.put("No_win", SetNumber);
            player.put("No_lose", SetNumber);
            player.put("No_winstreak",SetNumber);


        if (username !=""  && password != "" & secretpassword != "" && avatar != 0) {
            player.saveInBackground();
            user.signUpInBackground(new SignUpCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        // Register Completed!

                        finish();
                    } else {
                        // Some Errors!
                    }
                }
            });

        } else {


            Toast.makeText(getApplicationContext(), "Please fill all the empty field.",
                    Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
