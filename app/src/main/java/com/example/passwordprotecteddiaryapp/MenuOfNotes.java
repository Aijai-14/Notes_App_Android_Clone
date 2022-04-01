package com.example.passwordprotecteddiaryapp;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuOfNotes extends AppCompatActivity
{
    public static int count = -1;

    public static ArrayList<String> names_list = new ArrayList<>(Arrays.asList("Note 1", "Note 2", "Note 3", "Note 4", "Note 5", "Note 6", "Note 7", "Note 8", "Note 9", "Note 10",
            "Note 11", "Note 12", "Note 13", "Note 14", "Note 15", "Note 16", "Note 17", "Note 18", "Note 19", "Note 20", "Note 21", "Note 22", "Note 23", "Note 24", "Note 25", ""));

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_of_notes);
        ListView listview = findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, names_list);

        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener((adapterView, view, i, l) -> {
            count = i;
            int num = count + 1;

            Toast.makeText(MenuOfNotes.this, "Opening Note " + num, Toast.LENGTH_SHORT).show();
            openNoteEditor();
        });

        SearchView sV = (SearchView) findViewById(R.id.TextSearch);

        sV.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
// do something on text submit
                String queryValue = sV.getQuery().toString();

                if (names_list.contains(queryValue))
                {
                    count = names_list.indexOf(queryValue);
                    Toast.makeText(MenuOfNotes.this, "Opening Note " + (count + 1), Toast.LENGTH_SHORT).show();
                    openNoteEditor();
                }
                else
                {
                    Toast.makeText(MenuOfNotes.this, queryValue + " Does Not Exist", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
// do something when text changes
                String queryValue = sV.getQuery().toString();
                return false;
            }
        });
    }

    public void openTitleScreen(View view)
    {
        Intent intent = new Intent(MenuOfNotes.this, MainActivity.class);
        startActivity(intent);
    }

    public void openNoteEditor()
    {
        Intent intent = new Intent(MenuOfNotes.this, NoteEditor.class);
        startActivity(intent);
    }
}