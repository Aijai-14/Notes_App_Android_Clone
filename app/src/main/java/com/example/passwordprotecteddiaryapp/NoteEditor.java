package com.example.passwordprotecteddiaryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NoteEditor extends AppCompatActivity
{
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_note_editer);
        File parent = getApplicationContext().getFilesDir();

        File[] notes = parent.listFiles();
        File thisNote = null;
        String noteName = "Note " + MenuOfNotes.count + ".txt";

        // Look for the note with noteName
        for (File note: notes)
        {
            if (note.toString().equals(noteName))
            {
                thisNote = note;
                break;
            }
        }

        assert thisNote != null;
    }



    public NoteEditor(String name)
    {
        this.name = name;
    }

    public NoteEditor()
    {
        this.name = "New Note";
    }

    public String getName()
    {
        return this.name;
    }

    public void openMenuScreen(View view)
    {
        Intent intent = new Intent(NoteEditor.this, MenuOfNotes.class);
        startActivity(intent);
    }

    public void saveText(View view)
    {
        TextView noteName = (TextView) findViewById(R.id.noteName);
        TextView noteText = (TextView) findViewById(R.id.noteText);

        Context context = getApplicationContext();
        File parent =  context.getFilesDir();
        File note_names = new File(parent, noteName.getText().toString()+".txt");

        String[] words = noteText.getText().toString().split(" ");

        FileOutputStream stream;
        try
        {
            stream = new FileOutputStream(note_names);
            for (String s : words)
            {
                String string = s + " ";
                stream.write(string.getBytes());
            }
            stream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
