package com.example.passwordprotecteddiaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // Test comment for commit
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.enter_password);
        button.setOnClickListener(view -> openNotesMenu());
    }

    public void openNotesMenu()
    {
        Intent intent = new Intent(MainActivity.this, MenuOfNotes.class);
        startActivity(intent);
    }
}