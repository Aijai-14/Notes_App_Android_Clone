package com.example.passwordprotecteddiaryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class NoteEditor extends AppCompatActivity
{
    private boolean changed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_note_editer);
        TextView n = findViewById(R.id.noteName);
        TextView text = findViewById(R.id.noteText);

        int num = MenuOfNotes.count+1;
        String noteName = "Note " + (MenuOfNotes.count + 1) + ".txt";

        Context context = getApplicationContext();
        File location =  context.getFilesDir();
        File note_file = new File(location, noteName);

        addOnContextAvailableListener(context1 -> {
            int length = (int) note_file.length();

            byte[] bytes = new byte[length];

            FileInputStream reader;
            try
            {
                reader = new FileInputStream(note_file);
                reader.read(bytes);
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            String current_note = new String(bytes);

            String s = "Note " + num;
            n.setText(s);
            text.setText(current_note);
        });
    }

    public void openMenuScreen(View view)
    {
        if (changed)
        {
            Intent intent = new Intent(NoteEditor.this, MenuOfNotes.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(NoteEditor.this, "Please Save Your Work", Toast.LENGTH_SHORT).show();
        }
    }

    public void saveText(View view)
    {
        String noteName = "Note " + (MenuOfNotes.count + 1) + ".txt";
        TextView text = findViewById(R.id.noteText);

        Context context = getApplicationContext();
        File location =  context.getFilesDir();
        File password_file = new File(location, noteName);

        FileOutputStream stream;
        try
        {
            stream = new FileOutputStream(password_file);
            stream.write(text.getText().toString().getBytes());
            stream.close();
            Toast.makeText(NoteEditor.this, "Updated Note " + (MenuOfNotes.count + 1), Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        changed = true;
    }
}
