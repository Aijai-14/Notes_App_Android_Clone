package com.example.passwordprotecteddiaryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.annotation.NonNull;
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
        TextView n = (TextView) findViewById(R.id.noteName);

        int num = MenuOfNotes.count+1;
        addOnContextAvailableListener(new OnContextAvailableListener() {
            @Override
            public void onContextAvailable(@NonNull Context context) {
                String s = "Note " + num;
                n.setText(s);
            }
        });
    }

    public NoteEditor(String name)
    {
        this.name = name;
    }

    public NoteEditor()
    {
        this.name = "";
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
        File parent = getApplicationContext().getFilesDir();
        File[] notes = parent.listFiles();
        File thisNote = null;
        String noteName = "Note " + (MenuOfNotes.count + 1) + ".txt";

        // Look for the note with noteName
        for (File note: notes)
        {
            if (note.toString().equals(noteName))
            {
                thisNote = note;
                break;
            }
        }

        FileOutputStream stream;
        try
        {
            stream = new FileOutputStream(thisNote);
            stream.write(thisNote.getText().toString().getBytes());
            stream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
