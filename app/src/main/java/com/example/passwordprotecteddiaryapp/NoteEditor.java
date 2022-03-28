package com.example.passwordprotecteddiaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteEditor extends AppCompatActivity
{
    private String name;
    private List<String> text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_note_editer);
    }

    public NoteEditor(String name)
    {
        this.name = name;
        text = new ArrayList<>();
    }

    public NoteEditor()
    {
        this.name = "New Note";
        text = new ArrayList<>();
    }

    public String getName()
    {
        return this.name;
    }

    public List<String> getText()
    {
        return this.text;
    }

    public void openMenuScreen(View view)
    {
        Intent intent = new Intent(NoteEditor.this, MenuOfNotes.class);
        startActivity(intent);
    }

    public void saveText(View view)
    {
        TextView noteText = (TextView) this.findViewById(R.id.Notetext);

        String[] words = noteText.getText().toString().split(" ");

        List<String> wordList = new ArrayList<>();

        Collections.addAll(wordList, words);

        this.text = wordList;
    }


}
