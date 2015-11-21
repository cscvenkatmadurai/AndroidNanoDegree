package com.example.harish.myapplicationportfolio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    protected Button button[];
    protected int view[] = {R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6};
    protected String[]toastMessage = {"Spotify Streamer App","Scores App","Library App","Build It Bigger App","XYZ reader App","Capstone My App"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        createButtons();


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


    private void createButtons(){
        button = new Button[view.length];
        for (int i = 0; i < view.length; i++) {
            button[i] = (Button)findViewById(view[i]);
            button[i].setOnClickListener(this);
        }

    }
    @Override
    public void onClick(View v){
        boolean hasFindReqView = false;
        for (int i = 0; i < view.length && !hasFindReqView; i++) {
            if(v.getId() == view[i]){
                generateToast(toastMessage[i]);
                hasFindReqView = true;
            }
        }


    }
    public void generateToast(String toastMessage){
        Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
    }

}
