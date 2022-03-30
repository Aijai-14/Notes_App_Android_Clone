package com.example.passwordprotecteddiaryapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MenuOfNotes extends AppCompatActivity
{
    public static final List<NoteEditor> noteList = new ArrayList<>();
    public static final List<String> notes = new ArrayList<>();

    int counter = 0;
    List<String> names_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_of_notes);
        ListView listview = (ListView) findViewById(R.id.listView);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, names_list);

        listview.setAdapter(arrayAdapter);
    }

    public void openTitleScreen(View view)
    {
        Intent intent = new Intent(MenuOfNotes.this, MainActivity.class);
        startActivity(intent);
    }

    public void createAddNoteDialog(View v)
    {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View popup = getLayoutInflater().inflate(R.layout.add_note_prompt, null);

        EditText title = (EditText) popup.findViewById(R.id.enterTitle);
        Button confirm = (Button) popup.findViewById(R.id.confirm3);
        TextView errorMessage = (TextView) popup.findViewById(R.id.titleErrorMessage);

        dialogBuilder.setView(popup);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        confirm.setOnClickListener(view -> {

            if (title.getText().toString().equals(""))
            {
                errorMessage.setText("Please Enter a Name for Your Note");
            }
            else
            {
                // Create new instance of the note editor
                NoteEditor note = new NoteEditor(title.getText().toString());

                //  noteName.setText(title.getText().toString());

                // Add the instance into an arraylist
                noteList.add(note);
                notes.add(title.getText().toString());

                // Write the name of the file into names.txt
                String s = title.getText().toString();

                Intent intent = new Intent(MenuOfNotes.this, NoteEditor.class);
                startActivity(intent);
            }
        });
    }


    public File checkFileExists(File[] parent_files, String fileName)
    {
        for (int i = 0; i < parent_files.length; i++)
        {
            if (parent_files[i].getName() == fileName);
            {
                return parent_files[i];
            }
        }
        return null;
    }

    public void openDeletionScreen(View view)
    {
        Intent intent = new Intent(MenuOfNotes.this, NoteDeleter.class);
        startActivity(intent);
    }
}