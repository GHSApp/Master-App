package com.example.glebo.tabletest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class TestHTTP extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.http_test);

        try {
            URL url = new URL("http://foothillertech.com/student/globalit/2016/04_04/tinker/android/easy.php");
            HttpURLConnection mUrlConnection = (HttpURLConnection) url.openConnection();
            mUrlConnection.setDoInput(true);

            InputStream is = new BufferedInputStream(mUrlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"));
            //String s = readLine(is);
            String line = "";
            String result = "";
            while((line = bufferedReader.readLine()) != null) {
                result += line;
            }
            bufferedReader.close();
            is.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
