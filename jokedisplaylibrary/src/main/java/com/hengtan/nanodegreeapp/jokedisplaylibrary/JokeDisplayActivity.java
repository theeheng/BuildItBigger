package com.hengtan.nanodegreeapp.jokedisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKEEXTRA = "JOKEEXTRA";

    private TextView jokeTxtView;
    private String jokeString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        jokeTxtView = (TextView) findViewById(R.id.JokeString);

        if(savedInstanceState == null)
        {
            if(getIntent().getExtras() != null) {

                jokeString = getIntent().getExtras().getString(JOKEEXTRA);
            }
        }
        else
        {
            jokeString = savedInstanceState.getString(JOKEEXTRA);
        }

        if (jokeString != null) {
            jokeTxtView.setText(jokeString);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_joke_display, menu);
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

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);
    }

}
