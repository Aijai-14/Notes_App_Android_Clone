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
    private final List<NoteEditor> noteList = new ArrayList<>();
    private final List<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_of_notes);

        ListView listview = (ListView) findViewById(R.id.listView);

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
            if (title.getText().toString().equals(""))
            {
                errorMessage.setText("Please Enter a Name for Your Note");
            }

            else
            {
                NoteEditor note = new NoteEditor(title.getText().toString());
                View editor = getLayoutInflater().inflate(R.layout.blank_note_editer, null);

                TextView noteName = (TextView) editor.findViewById(R.id.Notename);

                noteName.setText(title.getText().toString());

                noteList.add(note);
                notes.add(title.getText().toString());

                Intent intent = new Intent(MenuOfNotes.this, NoteEditor.class);
                startActivity(intent);
            }
        });
    }

    public void openDeletionScreen(View view)
    {
        Intent intent = new Intent(MenuOfNotes.this, NoteDeleter.class);
        startActivity(intent);
    }
}