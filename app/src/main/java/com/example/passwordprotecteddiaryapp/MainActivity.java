package com.example.passwordprotecteddiaryapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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

    public void createChangePasswordDialog(View v)
    {
        dialogBuilder = new AlertDialog.Builder(this);
        final View popup = getLayoutInflater().inflate(R.layout.change_password_prompt, null);

        EditText password = (EditText) popup.findViewById(R.id.editTextTextPassword2);
        Button confirm = (Button) popup.findViewById(R.id.confirm2);
        TextView message = (TextView) popup.findViewById(R.id.password_message);

        dialogBuilder.setView(popup);
        dialog = dialogBuilder.create();
        dialog.show();

        confirm.setOnClickListener(view -> {
            Context context = getApplicationContext();
            File location =  context.getFilesDir();
            File password_file = new File(location, "Password.txt");

            if (!password.getText().toString().equals(""))
            {
                FileOutputStream stream;
                try
                {
                    stream = new FileOutputStream(password_file);
                    stream.write(password.getText().toString().getBytes());
                    stream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                message.setText("Successful Password Change");
            }

            else
            {
                message.setText("Please Enter a Password");
            }
        }
        );
    }

    public void createEnterPasswordDialog(View v)
    {
        dialogBuilder = new AlertDialog.Builder(this);
        final View popup = getLayoutInflater().inflate(R.layout.enter_password_prompt, null);

        EditText password = (EditText) popup.findViewById(R.id.editTextTextPassword);
        Button confirm = (Button) popup.findViewById(R.id.confirm);
        TextView message = (TextView) popup.findViewById(R.id.passwordErrorMessage);

        dialogBuilder.setView(popup);
        dialog = dialogBuilder.create();
        dialog.show();

        confirm.setOnClickListener(new View.OnClickListener()
        {
            final Context context = getApplicationContext();
            final File location =  context.getFilesDir();
            final File password_file = new File(location, "Password.txt");

            public void onClick(View view)
            {
                int length = (int) password_file.length();

                byte[] bytes = new byte[length];

                FileInputStream reader;
                try {
                    reader = new FileInputStream(password_file);
                    reader.read(bytes);
                    reader.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }

                String current_password = new String(bytes);

                if (password.getText().toString().equals(current_password))
                {
                    Intent intent = new Intent(MainActivity.this, MenuOfNotes.class);
                    startActivity(intent);
                }

                else
                {
                    message.setText("Incorrect Password: Please Try Again");
                }
            }
        }
        );
    }
}