package com.example.aksharas;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class homepage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        CardView button = (CardView) findViewById(R.id.learning);
        button.setOnClickListener(v -> openlearning ());

        CardView button1 = (CardView) findViewById(R.id.button2);
        button1.setOnClickListener(v -> opendatabase ());

        CardView button3 = (CardView) findViewById(R.id.button3);
        button3.setOnClickListener(v -> openthesaurus ());

        ImageButton ava = (ImageButton) findViewById(R.id.imageView20);
        ava.setOnClickListener(v -> openava ());

    }


    public void openlearning () {
        Intent intent = new Intent(this, learning.class);
        startActivity(intent);
    }

    public void opendatabase () {
        Intent intent = new Intent(this, database.class);
        startActivity(intent);
    }

    public void openthesaurus () {
        Intent intent = new Intent(this, thesaurus.class);
        startActivity(intent);
    }
    public void openava () {
        Intent intent = new Intent(this, avatar.class);
        startActivity(intent);
    }

}



/*public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        TabLayout tabLayout = findViewById(R.id.tabLayout2);
        TabItem tabLearning = findViewById(R.id.learning);
        TabItem tabDatabase = findViewById(R.id.button2);
        TabItem tabThesaurus = findViewById(R.id.button3);
        ViewPager viewPager = findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter = new PagerAdapter (getSupportFragmentManager (), tabLayout.getTabCount ()  );

        viewPager.setAdapter ( pagerAdapter );

    }
} */



