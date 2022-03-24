package com.example.passwordprotecteddiaryapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MenuOfNotes extends AppCompatActivity
{
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private List<NoteEditor> noteList = new ArrayList<>();
    private ListView listview;
    private List<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_of_notes);

        listview = (ListView) findViewById(R.id.listView);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, notes);

        listview.setAdapter(arrayAdapter);
    }

    public void openTitleScreen(View view)
    {
        Intent intent = new Intent(MenuOfNotes.this, MainActivity.class);
        startActivity(intent);
    }

    public void createAddNoteDialog(View v)
    {
        dialogBuilder = new AlertDialog.Builder(this);
        final View popup = getLayoutInflater().inflate(R.layout.add_note_prompt, null);

        EditText title = (EditText) popup.findViewById(R.id.enterTitle);
        Button confirm = (Button) popup.findViewById(R.id.confirm3);
        TextView errorMessage = (TextView) popup.findViewById(R.id.titleErrorMessage);

        dialogBuilder.setView(popup);
        dialog = dialogBuilder.create();
        dialog.show();

        confirm.setOnClickListener(view -> {
            if (title.getText().toString().equals(""))
            {
                errorMessage.setText("Please Enter a Name for Your Note");
            }

            else
            {
                NoteEditor note = new NoteEditor(title.getText().toString());
                TextView noteName = (TextView) note.findViewById(R.id.Notename);

                noteName.setText(title.getText().toString());

                noteList.add(note);
                addNoteLabel(title.getText().toString());

                openNote(null);
            }
        });
    }

    public void openDeletionScreen(View view)
    {
        Intent intent = new Intent(MenuOfNotes.this, NoteDeleter.class);
        startActivity(intent);
    }

    public void openNote(View view)
    {
        Intent intent = new Intent(MenuOfNotes.this, NoteEditor.class);
        startActivity(intent);
    }

    public void addNoteLabel(String label)
    {
        notes.add(label);
    }
}