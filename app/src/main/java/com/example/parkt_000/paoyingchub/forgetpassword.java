package com.example.parkt_000.paoyingchub;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;


public class forgetpassword extends ActionBarActivity {


    EditText forgetusername;
    EditText forgetsecretpassword;

    protected void onResume() {
        super.onResume();}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

          forgetusername = (EditText) findViewById(R.id.idforget_text);
          forgetsecretpassword = (EditText)findViewById(R.id.secret_text);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forgetpassword, menu);
        return true;
    }


    public void onClickforget(View v) {

        String username = forgetusername.getText().toString().trim().toLowerCase();
        String secretpassword = forgetsecretpassword.getText().toString().trim();

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Player");
        query.whereEqualTo("id_player", username);
        query.whereEqualTo("secretpassword", secretpassword);
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            public void done(ParseObject object, ParseException e) {
                if (object == null) {
                    Toast.makeText(getApplicationContext(), "Please fill all the empty field.",
                            Toast.LENGTH_SHORT).show();

                } else {

                    EditText password = (EditText) findViewById(R.id.password_text);
                    String passwordja = object.getString("password_player");
                    password.setText(passwordja);
                }
            }
        });

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
