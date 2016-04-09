package com.ivchen.guessnumberapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber; // Global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        randomNumber = random.nextInt(1001);
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

    public void onClickGuessNumber(View view) {

        // Created and used the guessField - converted value from textfield to a string
        // and then from a string to an integer
        EditText editText = (EditText) findViewById(R.id.guessField);
        String guessedNumberString =  editText.getText().toString();
        int guessedNumberInt = Integer.parseInt(guessedNumberString);

        Log.i("Log", "a number was guessed");

        if(guessedNumberInt > randomNumber){
            Toast.makeText(getApplicationContext(), "Your guess is too high. Guess again!", Toast.LENGTH_SHORT).show();
        } else if (guessedNumberInt < randomNumber){
            Toast.makeText(getApplicationContext(), "Your guess is too low. Guess again!", Toast.LENGTH_SHORT).show();
        } else if(guessedNumberInt == randomNumber){
            Toast.makeText(getApplicationContext(), "*** NOICE! YOU GOT THE NUMBER! WINNER!!! *** ", Toast.LENGTH_SHORT).show();
        }

    }
}
