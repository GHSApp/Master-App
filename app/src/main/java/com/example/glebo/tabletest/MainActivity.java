package com.example.glebo.tabletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button button1;
    public Button button2;
    public TextView results = (TextView) findViewById(R.id.result);

    EditText UsernameEt, PasswordEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText)findViewById(R.id.etUsername);
        PasswordEt = (EditText)findViewById(R.id.etPassword);
        //init();
    }

    public void OnLogin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type = "login";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);

        String newMeme = "";
        // newMeme = BackgroundWorker.meme;
        if (newMeme != null) {
            results.setText("woah, hey guys");
        }
    }

    // this method will open the schedules activity
    public void goToSchedules(View view) {
        Intent intent = new Intent(this, Schedules.class); //
        startActivity(intent);
    }

    public void goToTestHTTP(View view) {
        Intent intent = new Intent(this, TestHTTP.class); //
        startActivity(intent);
    }

    /*public void open_schedules(View view)
    {
        Intent myIntent = new Intent(MainActivity.this, Schedules.class);
        myIntent.putExtra("key", value); //Optional parameters
        MainActivity.this.startActivity(myIntent);
    }*/
    /*public void buttonClickFunction(View v)
    {
        Intent intent = new Intent(getApplicationContext(), Schedules.class);
        startActivity(intent);
    }*/
}
