package com.example.passwordprotecteddiaryapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuOfNotes extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_of_notes);
    }

    public void openTitleScreen(View view)
    {
        Intent intent = new Intent(MenuOfNotes.this, MainActivity.class);
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