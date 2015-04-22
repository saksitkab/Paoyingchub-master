package com.example.parkt_000.paoyingchub;
import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

/**
 * Created by parkt_000 on 4/19/2015.
 */
public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Add your initialization code here
        Parse.initialize(this, "pO0d2uczhZvqzcZTnNQbfFcuEXVai2MCez4RQFDb", "fJbzHP9omggIiliFp8Hw9q0XTgGXetDQzc7OWMUx");


    }
}
