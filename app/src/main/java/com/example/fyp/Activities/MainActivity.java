package com.example.fyp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fyp.Activities.ClassFinder;
import com.example.fyp.Activities.CommunitySection;
import com.example.fyp.Activities.Jobs;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start of bottom nav
        // declaring the bottom nav https://stackoverflow.com/questions/40202294/set-selected-item-in-android-bottomnavigationview
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.btm_home);
        //bringing user to selected activity, reference https://suragch.medium.com/how-to-add-a-bottom-navigation-bar-in-android-958ed728ef6c
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btm_home:
                        //activity already active
                        break;
                    case R.id.btm_dashboard:
                        Intent startCommunityIntent = new Intent(getApplicationContext(), CommunitySection.class);
                        startActivity(startCommunityIntent);
                        break;
                    case R.id.btm_maps:
                        Intent startClassIntent = new Intent(getApplicationContext(), ClassFinder.class);
                        startActivity(startClassIntent);
                        break;
                }
                return true;
            }
        });
        //end of bottom nav


        //toolbar
        toolbar=findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);






        //initialising buttons
        final Button btnCommunity = (Button) findViewById(R.id.btnCommunity);
        final Button btnClassFinder = (Button) findViewById(R.id.btnClassFinder);



        btnCommunity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), CommunitySection.class);
                startActivity(startIntent);
            }
        });

        btnClassFinder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ClassFinder.class);
                startActivity(startIntent);
            }
        });


    }


    //using inflater to show the items in the menu (toolbar)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }



    //toolbar
    // tutorial 2 mobile
    //https://www.youtube.com/watch?v=Pmsd2x-Bksk
    //using intents to to allow items in the menu to complete a task
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())

        {
            case R.id.delete:
                finish();
                Toast.makeText(this, "Delete function pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.dropdown1:
                Intent startIntent1 = new Intent(getApplicationContext(), Jobs.class);
                startActivity(startIntent1);
                Toast.makeText(this, "dropdown1 function pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btm_home:
                Intent startIntent3 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent3);
                Toast.makeText(this, "dropdown2 function pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btm_maps:
                Intent startIntent4 = new Intent(getApplicationContext(), ClassFinder.class);
                startActivity(startIntent4);
                Toast.makeText(this, "dropdown2 function pressed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btm_dashboard:
                Intent startIntent5 = new Intent(getApplicationContext(), CommunitySection.class);
                startActivity(startIntent5);
                Toast.makeText(this, "dropdown2 function pressed", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}



