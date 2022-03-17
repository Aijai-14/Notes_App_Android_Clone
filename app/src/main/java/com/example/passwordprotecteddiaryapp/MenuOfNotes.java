package com.example.passwordprotecteddiaryapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuOfNotes extends AppCompatActivity
{
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_of_notes);
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

            //else
        });
    }

    public void openDeletionScreen(View view)
    {
        Intent intent = new Intent(MenuOfNotes.this, NoteDeleter.class);
        startActivity(intent);
    }





    /*searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);
        list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Pineapple");
        list.add("Orange");
        list.add("Mango");
        list.add("Grapes");
        list.add("Lemon");
        list.add("Melon");
        list.add("Watermelon");
        list.add("Papaya");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(MenuOfNotes.this, "No Match found",Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });*/
}