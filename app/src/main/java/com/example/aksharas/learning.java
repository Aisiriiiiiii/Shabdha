package com.example.aksharas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.aksharas.quiz.QuestionPage;
import com.example.aksharas.quiz3.greetings;
import com.example.aksharas.quiz5.chart_animals;

public class learning extends AppCompatActivity {

    public static final String SHARED_PREFS_RIGHT = "sharedprefsr";
    public static final String RIGHT = "0";
    TextView t;
    String right ="";


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this, homepage.class);
        startActivity(intent);
        finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);
        right = "0";
        save();
        load();
        Button button = (Button) findViewById(R.id.basics);
        Button button2 = (Button) findViewById(R.id.cardView23);
        Button button3 = (Button) findViewById(R.id.people);
        Button button4 = (Button) findViewById(R.id.learning1);
        Button button5= (Button) findViewById(R.id.learning2);

        button.setOnClickListener(v -> openquiz());
        button2.setOnClickListener(v -> openquiz2());
        button3.setOnClickListener(v -> openquiz3());
        button4.setOnClickListener(v -> openquiz4());
        button5.setOnClickListener(v -> openquiz5());


    }

    public void openquiz()
    {
        Intent intent = new Intent(this, QuestionPage.class);
        startActivity(intent);
    }

    public void openquiz2()
    {
        Intent intent = new Intent(this, basicsII.class);
        startActivity(intent);
    }

    public void openquiz3()
    {
        Intent intent = new Intent(this, greetings.class);
        startActivity(intent);
    }

    public void openquiz4(){
        Intent intent = new Intent(this, people1.class);
        startActivity(intent);
    }
    public void openquiz5(){
        Intent intent = new Intent(this, chart_animals.class);
        intent.putExtra("animals", "none");
        startActivity(intent);
    }


    public void save()
    {

        SharedPreferences sp3 = getSharedPreferences(SHARED_PREFS_RIGHT, MODE_PRIVATE);

        SharedPreferences.Editor e3 = sp3.edit();

        e3.putString(RIGHT, right);

        e3.apply();
    }

    public void load()
    {

        SharedPreferences sp3 = getSharedPreferences(SHARED_PREFS_RIGHT, MODE_PRIVATE);

        right = sp3.getString(RIGHT, "0");
    }
}

