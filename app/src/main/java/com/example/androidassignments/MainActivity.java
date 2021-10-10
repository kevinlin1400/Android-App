package com.example.androidassignments;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "MainActivity";

    Button button, chat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        button = (Button) findViewById(R.id.button);
        chat = (Button) findViewById(R.id.start_chat);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListItemsActivity.class);
                try {
                    startActivityForResult(intent, 10);
                } catch (ActivityNotFoundException e) {
                    Log.i(ACTIVITY_NAME, "No Activity Found!");
                }
            }
        });

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME, "User clicked Start Chat");
                Intent intent = new Intent(MainActivity.this, ChatWindow.class);
                try {
                    startActivityForResult(intent, 10);
                } catch (ActivityNotFoundException e) {
                    Log.i(ACTIVITY_NAME, "No Activity Found!");
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        if(requestCode  == 10){
            Log.i(ACTIVITY_NAME, "Returned to MainActivity.onActivityResult");
        }

        if(responseCode == Activity.RESULT_OK) {
            String messagePassed = data.getStringExtra("Response");

            CharSequence text = ListItemsActivity.ACTIVITY_NAME + " passed: " + messagePassed;
            Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG);
            toast.show();
        }
    }


    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}