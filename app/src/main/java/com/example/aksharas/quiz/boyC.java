package com.example.aksharas.quiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aksharas.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class boyC extends AppCompatActivity
{
    public static final String SHARED_PREFS_POINTS = "sharedprefsp";
    public static final String SHARED_PREFS_CURRENCY = "sharedprefsc";
    public static final String SHARED_PREFS_RIGHT = "sharedprefsr";
    public static final String CURRENCY = "0";
    public static final String POINTS = "0";
    public static final String RIGHT = "0";
    String currency = "", points = "", right = "";
    TextView score1, score2;

    ImageButton boysound;
    Button back2,nxt;
    MediaPlayer boysoundbruh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boyc);

        currency = getIntent().getExtras().getString("currency");
        points = getIntent().getExtras().getString("points");
        points = Integer.toString(10 + Integer.parseInt(points));
        right = getIntent().getExtras().getString("right");

        save();
        load();
        updateViews();

        boysoundbruh = MediaPlayer.create(boyC.this, R.raw.boy);
        final MediaPlayer boysoundbruh = MediaPlayer.create(this, R.raw.boy);


        boysound = (ImageButton) findViewById(R.id.boysound);
        boysound.setOnClickListener(v -> playBoy());

        nxt = (Button) findViewById(R.id.nxt);
        nxt.setOnClickListener(v -> opennext());

    }


    public void playBoy(){
        boysoundbruh.start();
    }

    private void opennext(){
        Intent intent = new Intent(this, Question2.class);
        intent.putExtra("currency", currency);
        intent.putExtra("points", points);
        intent.putExtra("right", right);
        startActivity(intent);
    }


    public void save()
    {
        SharedPreferences sp1 = getSharedPreferences(SHARED_PREFS_POINTS, MODE_PRIVATE);
        SharedPreferences sp2 = getSharedPreferences(SHARED_PREFS_CURRENCY, MODE_PRIVATE);
        SharedPreferences sp3 = getSharedPreferences(SHARED_PREFS_RIGHT, MODE_PRIVATE);
        SharedPreferences.Editor e1 = sp1.edit();
        SharedPreferences.Editor e2 = sp2.edit();
        SharedPreferences.Editor e3 = sp3.edit();
        e1.putString(POINTS, points);
        e2.putString(CURRENCY, currency);
        e3.putString(RIGHT, right);
        e1.apply();
        e2.apply();
        e3.apply();
    }
    public void load()
    {
        SharedPreferences sp1 = getSharedPreferences(SHARED_PREFS_POINTS, MODE_PRIVATE);
        SharedPreferences sp2 = getSharedPreferences(SHARED_PREFS_CURRENCY, MODE_PRIVATE);
        SharedPreferences sp3 = getSharedPreferences(SHARED_PREFS_RIGHT, MODE_PRIVATE);
        points = sp1.getString(POINTS, "0");
        currency = sp2.getString(CURRENCY, "0");
        right = sp3.getString(RIGHT, "0");
    }
    public void updateViews()
    {
        score1 = (TextView)findViewById(R.id.score3);
        score2 = (TextView)findViewById(R.id.score4);
        score1.setText("Points: ".concat(points));
        score2.setText("Currency: ".concat(currency));
    }

}