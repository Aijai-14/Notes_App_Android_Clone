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
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuOfNotes extends AppCompatActivity
{
    private final List<NoteEditor> noteList = new ArrayList<>();
    private final List<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_of_notes);

        ListView listview = (ListView) findViewById(R.id.listView);

        Context context = getApplicationContext();
        File parent = context.getFilesDir();
        File[] files = parent.listFiles();

        File note_names = checkTxtFileNames(files);
        // If note_names has not been updated, create a new txt file to store the names
        if (note_names == null)
        {
            note_names = new File(parent, "names.txt");
        }

        int length = (int) note_names.length();

        byte[] bytes = new byte[length];

        FileInputStream reader;
        try {
            reader = new FileInputStream(note_names);
            reader.read(bytes);
            reader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        String names = new String(bytes);
        String[] names_list = names.split(" ");

        notes.addAll(Arrays.asList(names_list));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, notes);

        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener((adapter, view, location, id) -> {
            for (NoteEditor n : noteList)
            {
                if (n.getName().equals(notes.get(location)))
                {
                    View editor = getLayoutInflater().inflate(R.layout.blank_note_editer, null);
                    TextView noteName = (TextView) editor.findViewById(R.id.Notename);
                    TextView notes = (TextView) editor.findViewById(R.id.Notetext);

                    noteName.setText(n.getName());

                    StringBuilder note = new StringBuilder();
                    for (String s : n.getText())
                    {
                        note.append(s).append(" ");
                    }

                    notes.setText(note);

                    Intent intent = new Intent(MenuOfNotes.this, NoteEditor.class);
                    startActivity(intent);
                    break;
                }
            }
        });
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
            Context context = getApplicationContext();
            File parent =  context.getFilesDir();

            File note_names = checkTxtFileNames(parent.listFiles());
            if (note_names == null)
            {
                note_names = new File(parent, "names.txt");
            }

            if (title.getText().toString().equals(""))
            {
                errorMessage.setText("Please Enter a Name for Your Note");
            }
            else
            {
                // Create a new file txt file for the new note
                File newNote = new File(parent, title.getText().toString() + ".txt" );

                // Create new instance of the note editor
                NoteEditor note = new NoteEditor(title.getText().toString());
                View editor = getLayoutInflater().inflate(R.layout.blank_note_editer, null);
                TextView noteName = (TextView) editor.findViewById(R.id.Notename);
                noteName.setText(title.getText().toString());

                // Add the instance into an arraylist
                noteList.add(note);

                // Write the name of the file into names.txt
                String s = title.getText().toString() + " ";
                FileOutputStream stream;
                try
                {
                    stream = new FileOutputStream(note_names);
                    stream.write(s.getBytes());
                    stream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MenuOfNotes.this, NoteEditor.class);
                startActivity(intent);
            }
        });
    }

    public File checkTxtFileNames(File[] parent_files)
    {
        for (int i = 0; i < parent_files.length; i++)
        {
            if (parent_files[i].getName() == "names.txt")
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