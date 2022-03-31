package com.example.passwordprotecteddiaryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        TextView text = (TextView) findViewById(R.id.noteText);

        int num = MenuOfNotes.count+1;
        String noteName = "Note " + (MenuOfNotes.count + 1) + ".txt";

        Context context = getApplicationContext();
        File location =  context.getFilesDir();
        File note_file = new File(location, noteName);

        addOnContextAvailableListener(new OnContextAvailableListener() {
            @Override
            public void onContextAvailable(@NonNull Context context) {
                String b = "";

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

//                try
//                {
//                    byte[] bytes = new byte[1024];
//
//                    FileInputStream fis = openFileInput(noteName);
//
//                    fis.read(bytes);
//                    fis.close();
//
//                    b = new String(bytes);
//
//                }
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }

                String s = "Note " + num;
                n.setText(s);
                text.setText(current_note);
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

    public void saveText(View view) {
        String noteName = "Note " + (MenuOfNotes.count + 1) + ".txt";
        TextView text = (TextView) findViewById(R.id.noteText);

        Context context = getApplicationContext();
        File location =  context.getFilesDir();
        File password_file = new File(location, noteName);

        FileOutputStream stream;
        try
        {
            stream = new FileOutputStream(password_file);
            stream.write(text.getText().toString().getBytes());
            stream.close();
            Toast.makeText(NoteEditor.this, text.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//
//        FileOutputStream stream = openFileOutput(noteName, MODE_PRIVATE);
//
//        try
//        {
//            new FileOutputStream(getFilesDir().getAbsolutePath()).close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try
//        {
//            stream.write(text.getText().toString().getBytes());
//            stream.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
