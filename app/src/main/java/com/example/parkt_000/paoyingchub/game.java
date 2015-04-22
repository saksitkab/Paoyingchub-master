package com.example.parkt_000.paoyingchub;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class game extends ActionBarActivity {

    ImageButton paper1;
    ImageButton sccissor1;
    ImageButton rock1;
    ImageButton en1;
    ImageButton en2;
    ImageButton en3;
    MediaPlayer player ;
    MediaPlayer player2 ;
    MediaPlayer player3 ;
    Button btn1;
    Button btn2;
    Button btn3;

    String choice;
    String opponent;
    int n ;
    int a ;
    int round;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        player=MediaPlayer.create(game.this,R.raw.play);
        player.setLooping(true);
        player.start();

        paper1 = (ImageButton)findViewById(R.id.paper1);
        sccissor1 = (ImageButton)findViewById(R.id.sccissor1);
        rock1 = (ImageButton)findViewById(R.id.rock1);
        en1 = (ImageButton)findViewById(R.id.en1);
        en2 = (ImageButton)findViewById(R.id.en2);
        en3 = (ImageButton)findViewById(R.id.en3);
        TextView Textround = (TextView)findViewById(R.id.round);
              round =1 ;
               Textround.setText("ROUND" + round);

        btn1 = (Button)findViewById(R.id.next);
        btn2 = (Button)findViewById(R.id.restart);
        btn3 = (Button)findViewById(R.id.over);

        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);


        Intent intent = getIntent();
        String sname = intent.getStringExtra("Ename");
        TextView Textname = (TextView)findViewById(R.id.sname);
            Textname.setText(sname);

    }

    protected void onResume() {
        super.onResume();
        TextView Textround = (TextView)findViewById(R.id.round);
        Textround.setText("ROUND" + round);

        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);


        paper1.setVisibility(View.VISIBLE);
        sccissor1.setVisibility(View.VISIBLE);
        rock1.setVisibility(View.VISIBLE);

        en1.setImageResource(R.drawable.enemies1resize);
        en2.setImageResource(R.drawable.enemies1resize);
        en3.setImageResource(R.drawable.enemies1resize);

        en1.setVisibility(View.VISIBLE);
        en2.setVisibility(View.VISIBLE);
        en3.setVisibility(View.VISIBLE);


    }


    public void buttonClicked(View v) {
        int id = v.getId();


        switch(id) {
            case R.id.rock1:


                paper1.setVisibility(View.INVISIBLE);


                sccissor1.setVisibility(View.INVISIBLE);

                choice = "rock";


                 n = new Random().nextInt(3); // Gives n such that 0 <= n < 20
                a = new Random().nextInt(3);

            if(n==0){

                en2.setVisibility(View.INVISIBLE);
                en3.setVisibility(View.INVISIBLE);

                if (a==0){
                    opponent = "rock";
                    en1.setImageResource(R.drawable.rockv1ja1);
                    checkwin();

                }

                else if(a==1){
                    opponent = "paper";
                    en1.setImageResource(R.drawable.paperv1ja1);
                    checkwin();
                }

                else if(a==2){
                    opponent = "sccissor";
                    en1.setImageResource(R.drawable.sccissorja1);
                    checkwin();
                }

            }

               else if(n==1){

                    en1.setVisibility(View.INVISIBLE);
                    en3.setVisibility(View.INVISIBLE);

                    if(a==0){
                        opponent = "rock";

                        en2.setImageResource(R.drawable.rockv1ja1);
                        checkwin();

                    }

                   else if(a==1){
                        opponent = "paper";
                        en2.setImageResource(R.drawable.paperv1ja1);
                        checkwin();
                    }

                    else if(a==2){
                        opponent = "sccissor";
                        en2.setImageResource(R.drawable.sccissorja1);
                        checkwin();
                    }
                }


               else if(n==2){

                    en1.setVisibility(View.INVISIBLE);
                    en2.setVisibility(View.INVISIBLE);

                    if(a==0){
                        opponent = "rock";
                        en3.setImageResource(R.drawable.rockv1ja1);
                        checkwin();
                    }

                   else if(a==1){
                        opponent = "paper";
                        en3.setImageResource(R.drawable.paperv1ja1);
                        checkwin();
                    }

                   else if(a==2){
                        opponent = "sccissor";
                        en3.setImageResource(R.drawable.sccissorja1);
                        checkwin();
                    }

                }





                break;

            case R.id.paper1:


                rock1.setVisibility(View.INVISIBLE);


                sccissor1.setVisibility(View.INVISIBLE);

                choice = "paper";

                n = new Random().nextInt(3); // Gives n such that 0 <= n < 20
                a = new Random().nextInt(3);

                if(n==0){

                    en2.setVisibility(View.INVISIBLE);
                    en3.setVisibility(View.INVISIBLE);


                    if(a==0){
                        opponent = "rock";
                        en1.setImageResource(R.drawable.rockv1ja1);
                        checkwin();
                    }

                   else if(a==1){
                        opponent = "paper";
                        en1.setImageResource(R.drawable.paperv1ja1);
                        checkwin();
                    }

                   else if(a==2){
                        opponent = "sccissor";
                        en1.setImageResource(R.drawable.sccissorja1);
                        checkwin();
                    } }

               else if(n==1){

                    en1.setVisibility(View.INVISIBLE);
                    en3.setVisibility(View.INVISIBLE);
                    if(a==0){
                        opponent = "rock";
                        en2.setImageResource(R.drawable.rockv1ja1);
                        checkwin();
                    }

                   else if(a==1){
                        opponent = "paper";
                        en2.setImageResource(R.drawable.paperv1ja1);
                        checkwin();
                    }

                  else  if(a==2){
                        opponent = "sccissor";
                        en2.setImageResource(R.drawable.sccissorja1);
                        checkwin();
                    }  }


               else if(n==2){

                    en1.setVisibility(View.INVISIBLE);
                    en2.setVisibility(View.INVISIBLE);
                    if(a==0){
                        opponent = "rock";
                        en3.setImageResource(R.drawable.rockv1ja1);
                        checkwin();
                    }

                  else  if(a==1){
                        opponent = "paper";
                        en3.setImageResource(R.drawable.paperv1ja1);
                        checkwin();
                    }

                 else   if(a==2){
                        opponent = "sccissor";
                        en3.setImageResource(R.drawable.sccissorja1);
                        checkwin();
                    }  }





                break;

            case R.id.sccissor1:


                paper1.setVisibility(View.INVISIBLE);


                rock1.setVisibility(View.INVISIBLE);

                choice = "sccissor";

                n = new Random().nextInt(3); // Gives n such that 0 <= n < 20
                a = new Random().nextInt(3);

                if(n==0){

                    en2.setVisibility(View.INVISIBLE);
                    en3.setVisibility(View.INVISIBLE);
                    if(a==0){
                        opponent = "rock";
                        en1.setImageResource(R.drawable.rockv1ja1);
                        checkwin();
                    }

                   else if(a==1){
                        opponent = "paper";
                        en1.setImageResource(R.drawable.paperv1ja1);
                        checkwin();
                    }

                   else if(a==2){
                        opponent = "sccissor";
                        en1.setImageResource(R.drawable.sccissorja1);
                        checkwin();
                    }


                }

              else  if(n==1){

                    en1.setVisibility(View.INVISIBLE);
                    en3.setVisibility(View.INVISIBLE);
                    if(a==0){
                        opponent = "rock";
                        en2.setImageResource(R.drawable.rockv1ja1);
                        checkwin();
                    }

                 else   if(a==1){
                        opponent = "paper";
                        en2.setImageResource(R.drawable.paperv1ja1);
                        checkwin();
                    }

                  else  if(a==2){
                        opponent = "sccissor";
                        en2.setImageResource(R.drawable.sccissorja1);
                        checkwin();
                    } }


              else  if(n==2){

                    en1.setVisibility(View.INVISIBLE);
                    en2.setVisibility(View.INVISIBLE);
                    if(a==0){
                        opponent = "rock";
                        en3.setImageResource(R.drawable.rockv1ja1);
                        checkwin();
                    }

                  else  if(a==1){
                        opponent = "paper";
                        en3.setImageResource(R.drawable.paperv1ja1);
                        checkwin();
                    }

                  else  if(a==2){
                        opponent = "sccissor";
                        en3.setImageResource(R.drawable.sccissorja1);
                        checkwin();
                    }  }


                break;

        }
    }


    public void checkwin(){
        if( (choice=="paper" && opponent=="paper") || (choice=="rock" && opponent=="rock") || (choice=="sccissor" && opponent=="sccissor") ) {



            draw();

        }

        else if (
                (choice=="paper" && opponent=="rock") || (choice=="rock" && opponent=="sccissor") || (choice=="sccissor" && opponent=="paper"))
        {
            win();
        }

        else if (
                ( choice=="paper" && opponent=="sccissor") || (choice=="sccissor" && opponent=="rock" )||( choice=="rock" && opponent=="paper"))
        {
            lose();
        }
    }



    public void draw(){


  // timer();
        //if(player!= null){
            //player.stop();
            //player.release();}


        //if(player2!= null){
            //player2.stop();
            //player2.release();}


        //if(player3!= null){
            //player3.stop();
            //player3.release();}


        Toast t = Toast.makeText(this.getApplicationContext(),
                "Draw.",
                Toast.LENGTH_SHORT);
        t.show();

       // en1.setVisibility(View.INVISIBLE);
       // en2.setVisibility(View.INVISIBLE);
       // en3.setVisibility(View.INVISIBLE);
       // paper1.setVisibility(View.INVISIBLE);
        //sccissor1.setVisibility(View.INVISIBLE);
        //rock1.setVisibility(View.INVISIBLE);


        onask();
    }

    public void win(){

      // timer();



        player3=MediaPlayer.create(game.this,R.raw.win);

        player3.start();

        Toast t = Toast.makeText(this.getApplicationContext(),
                "Win.",
                Toast.LENGTH_SHORT);

        t.show();
        round = round+1;
        //en1.setVisibility(View.INVISIBLE);
        //en2.setVisibility(View.INVISIBLE);
       // en3.setVisibility(View.INVISIBLE);
        //paper1.setVisibility(View.INVISIBLE);
        //sccissor1.setVisibility(View.INVISIBLE);
        //rock1.setVisibility(View.INVISIBLE);
        onask();

    }

    public void lose(){


     //  timer();


        if(player!= null){
            player.stop();
            player.release();}

        if(player3!= null){
        player3.stop();
        player3.release();}

        player2=MediaPlayer.create(game.this,R.raw.lose);

       player2.start();


        Toast t = Toast.makeText(this.getApplicationContext(),
                "Lose.",
                Toast.LENGTH_SHORT);
        t.show();
       // en1.setVisibility(View.INVISIBLE);
        //en2.setVisibility(View.INVISIBLE);
        //en3.setVisibility(View.INVISIBLE);
        //paper1.setVisibility(View.INVISIBLE);
        //sccissor1.setVisibility(View.INVISIBLE);
        //rock1.setVisibility(View.INVISIBLE);

        onask2();

        //Intent i;
        //i = new Intent(this, bgame.class);

        //Intent intent = getIntent();

        //String sname = intent.getStringExtra("Ename");

        //i.putExtra("name", sname);
        //i.putExtra("score",round);
        //this.setResult(RESULT_OK, i);

        //this.finish();
        //startActivity(i);



    }


    public void buttonClicked2(View v) {
        int id = v.getId();
        Intent i;

        switch (id) {
            case R.id.next:

              onResume();

                break;

            case R.id.restart:




                round = 1;

                onResume();

                break;

            case R.id.over:


                i = new Intent(this, bgame.class);

                Intent intent = getIntent();

                String sname = intent.getStringExtra("Ename");

                Log.d("user",""+round);
                score = round - 1;
                i.putExtra("name", sname);
                i.putExtra("score",score);
                this.setResult(RESULT_OK, i);

                this.finish();

                break;

        }

    }

    public void onask2(){

        btn3 = (Button)findViewById(R.id.over);
        btn2 = (Button)findViewById(R.id.restart);

        btn3.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);

    }

    public  void onask(){

        btn1 = (Button)findViewById(R.id.next);
        btn2 = (Button)findViewById(R.id.restart);

        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);

    }



 public void timer()   {
    long startTime = System.currentTimeMillis();

    while(System.currentTimeMillis() - startTime < 5000){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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
