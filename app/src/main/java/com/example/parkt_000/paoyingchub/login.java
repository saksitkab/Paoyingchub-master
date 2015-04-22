package com.example.parkt_000.paoyingchub;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class login extends ActionBarActivity {

    MediaPlayer player ;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    private Context mContext;

    EditText musername;
    EditText mpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;

        player=MediaPlayer.create(login.this,R.raw.main);
        player.setLooping(true);

        player.start();

        btn1 = (Button)findViewById(R.id.login_bot);
        btn2 = (Button)findViewById(R.id.regis_bot);
        btn3 = (Button)findViewById(R.id.confirm_bot);
        btn4 = (Button)findViewById(R.id.forget_bot);
        btn5 = (Button)findViewById(R.id.guest_bot);

        musername = (EditText)findViewById(R.id.id_text);
        mpassword = (EditText)findViewById(R.id.pass_text);
    }


    public void buttonClickedloginpage(View v) {
        int id = v.getId();
        Intent i;

        switch (id) {
            case R.id.login_bot:

                btn1.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.INVISIBLE);
                btn3.setVisibility(View.VISIBLE);
                btn4.setVisibility(View.VISIBLE);
                btn5.setVisibility(View.INVISIBLE);

                musername.setVisibility(View.VISIBLE);
                mpassword.setVisibility(View.VISIBLE);

                break;

            case R.id.regis_bot:
                i = new Intent(this, register.class);
                startActivity(i);
                break;


            case R.id.confirm_bot:
                checkLogin();


                break;

            case R.id.forget_bot:
                i = new Intent(this, forgetpassword.class);
                startActivity(i);

                break;

            case R.id.guest_bot:
                i = new Intent(this, MainActivity.class);
                startActivity(i);

                break;



        }
    }

    private void checkLogin() {
        String username = musername.getText().toString().trim().toLowerCase();
        String password = mpassword.getText().toString().trim();

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null) {
                    Intent intent = new Intent(mContext, newmain.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(),
                            e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }




                @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
