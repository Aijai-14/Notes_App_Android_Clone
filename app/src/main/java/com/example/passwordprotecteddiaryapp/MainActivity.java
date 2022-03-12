package com.example.passwordprotecteddiaryapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
{
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNotesMenu()
    {
        Intent intent = new Intent(MainActivity.this, MenuOfNotes.class);
        startActivity(intent);
    }

    public void openChangePassword()
    {
        Intent intent = new Intent(MainActivity.this, Password.class);
        startActivity(intent);
    }

    public void createChangePasswordDialog(View v) throws IOException {
        dialogBuilder = new AlertDialog.Builder(this);
        final View popup = getLayoutInflater().inflate(R.layout.change_password_prompt, null);

        EditText password = (EditText) popup.findViewById(R.id.editTextTextPassword2);
        Button confirm = (Button) popup.findViewById(R.id.confirm2);
        TextView message = (TextView) popup.findViewById(R.id.password_message);

        dialogBuilder.setView(popup);
        dialog = dialogBuilder.create();
        dialog.show();

        if (password.getText().toString().length() == 0 || password.getText().toString().length() > 15 || password.getText().toString().equals(""))
        {
            confirm.setOnClickListener(view -> message.setText("Invalid Password"));
        }

        else
        {
            File root = new File(Environment.getExternalStorageDirectory(), "/Users/aijay/AndroidStudioProjects/Tridroid-Developers-Password-Protected-Diary-1022-Project");
            if (!root.exists())
            {
                root.mkdir();
            }

            File path = new File(root, "Password.txt");

            FileWriter filewriter = new FileWriter(path);
            filewriter.append(password.getText().toString());
            filewriter.flush();
            filewriter.close();

            confirm.setOnClickListener(view -> message.setText("Successful Password Change"));
            Password pass = new Password();
            confirm.setOnClickListener(view -> pass.openTitleScreen());
        }
    }
}