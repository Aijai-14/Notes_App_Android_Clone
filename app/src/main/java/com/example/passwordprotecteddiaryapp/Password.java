package com.example.passwordprotecteddiaryapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Password extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password_prompt);
    }

    public void openTitleScreen()
    {
        Intent intent = new Intent(Password.this, MainActivity.class);
        startActivity(intent);
    }
}
