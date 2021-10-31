package com.example.androidassignments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.androidassignments.databinding.ActivityTestToolbarBinding;

public class TestToolbar extends AppCompatActivity {

    private ActivityTestToolbarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTestToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello There", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public boolean onCreateOptionsMenu (Menu m){
        getMenuInflater().inflate(R.menu.toolbar_menu, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        switch(mi.getItemId()) {
            default:
                Log.d("TestToolbar","No action selected");
                break;

            case R.id.action_one:
                Log.d("Toolbar", "Action 1 selected");
                Snackbar.make(findViewById(R.id.action_one), "You selected item 1", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;

            case R.id.action_two:
                Log.d("TestToolbar", "Action 2 selected");
                AlertDialog.Builder builder = new AlertDialog.Builder(TestToolbar.this);
                builder.setTitle(R.string.dialogBuilder);

                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("TestToolbar","ok");
                        Intent i = new Intent(TestToolbar.this, MainActivity.class);
                        startActivityForResult(i, 10);
                    }
                });

                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("TestToolbar","cancel");
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
                break;

            case R.id.action_three:
                Log.d("TestToolbar", "Action 3 selected");

                AlertDialog.Builder builderNM = new AlertDialog.Builder(TestToolbar.this);
                builderNM.setTitle(R.string.dialogBuilder);

                builderNM.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("TestToolbar","ok");
                        Intent i = new Intent(TestToolbar.this, MainActivity.class);
                        startActivityForResult(i, 10);
                    }
                });

                builderNM.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("TestToolbar","cancel");
                    }
                });

                AlertDialog dialogNM = builderNM.create();
                dialogNM.show();


                break;

            case R.id.about:
                Log.d("TestToolbar","About selected");
                CharSequence t = "Version 1.0, by Kevin Lin";
                Toast toast = Toast.makeText(TestToolbar.this,t,Toast.LENGTH_LONG);
                toast.show();
                break;
        }
        return true;
    }

}