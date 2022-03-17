package com.example.passwordprotecteddiaryapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.ContentView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class NoteEditer extends AppCompatActivity
{
    private String name;

    public NoteEditer(String name)
    {
        this.name = name;
    }

    public NoteEditer() {}

    protected void onCreate()
    {
        super.onCreate(Bundle.EMPTY);
        setContentView(R.layout.blank_note_editer);
    }
}
