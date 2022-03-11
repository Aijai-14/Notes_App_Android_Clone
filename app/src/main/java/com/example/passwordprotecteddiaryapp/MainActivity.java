package com.example.passwordprotecteddiaryapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.enter_password);
        button.setOnClickListener(view -> openNotesMenu());
    }

    public void openNotesMenu()
    {
        Intent intent = new Intent(MainActivity.this, MenuOfNotes.class);
        startActivity(intent);
    }

    public void createEnterPasswordDialog()
    {
        dialogBuilder = new AlertDialog.Builder(this);
        View popup = getLayoutInflater().inflate(R.layout.enter_password_prompt, null);

        EditText password = (EditText) popup.findViewById(R.id.editTextTextPassword);
        Button confirm = (Button) popup.findViewById(R.id.confirm);

        dialogBuilder.setView(popup);
        dialog = dialogBuilder.create();
        dialog.show();

        confirm.setOnClickListener(view -> openNotesMenu());



    }


}