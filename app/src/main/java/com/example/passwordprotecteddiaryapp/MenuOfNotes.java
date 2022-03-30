package com.example.passwordprotecteddiaryapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuOfNotes extends AppCompatActivity
{
    public static final List<NoteEditor> noteList = new ArrayList<>();
    public static final List<String> notes = new ArrayList<>();
    public static int count = -1;

    public static ArrayList<String> names_list = new ArrayList<>(Arrays.asList("Note 1", "Note 2", "Note 3", "Note 4", "Note 5", "Note 6", "Note 7", "Note 8", "Note 9", "Note 10"));
    public static ArrayList<NoteEditor> notes_objects = new ArrayList<>(Arrays.asList(new NoteEditor("Note 1"), new NoteEditor("Note 2"), new NoteEditor("Note 3"), new NoteEditor("Note 4"), new NoteEditor("Note 5"), new NoteEditor("Note 6"), new NoteEditor("Note 7"), new NoteEditor("Note 8"), new NoteEditor("Note 9"), new NoteEditor("Note 10")));

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_of_notes);
        ListView listview = (ListView) findViewById(R.id.listView);

        Context context = getApplicationContext();
        File parent = context.getFilesDir();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, names_list);

        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener((adapterView, view, i, l) -> {
            count = i;
            Object note = listview.getItemAtPosition(i);

            File file = checkFileExists(parent.listFiles(), note.toString()+".txt");

            if (file == null)
            {
                file = new File(parent, note.toString()+".txt");
                Toast.makeText(MenuOfNotes.this, "made ", Toast.LENGTH_LONG).show();
            }

            Intent intent = new Intent(MenuOfNotes.this, NoteEditor.class);
            startActivity(intent);
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

                Intent intent = new Intent(MenuOfNotes.this, NoteEditor.class);
                startActivity(intent);
            }
        });
    }

    public File checkFileExists(File[] parent_files, String fileName)
    {
        for (File parent_file : parent_files) {
            if (parent_file.getName().equals(fileName))
            {
                return parent_file;
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