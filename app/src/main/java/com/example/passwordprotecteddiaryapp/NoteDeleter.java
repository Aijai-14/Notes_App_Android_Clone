package com.example.passwordprotecteddiaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NoteDeleter extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletion_menu);
    }

    public void openMenuOfNotes(View view)
    {
        Intent intent = new Intent(NoteDeleter.this, MenuOfNotes.class);
        startActivity(intent);
    }
}
