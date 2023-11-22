package com.example.coocking;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    private String login = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClick(View v) {
        EditText text = (EditText)findViewById(R.id.loginText);
        TextView button = (TextView)findViewById(R.id.button);
        if(String.valueOf(text.getText()).equals("")) {
            Toast.makeText(MainActivity.this, R.string.loginHint, Toast.LENGTH_LONG).show();
            return;
        }
        login = String.valueOf(text.getText());
        text.setText("");
        button.setText("Вход...");
        button.setBackgroundColor(Color.GREEN);
        openBasicMenu();
    }
    public void openBasicMenu() {
        Intent intent = new Intent(this, BasicMenu.class);
        startActivity(intent);
    }
    public void onExitButtonClick(View v) {
        AlertDialog.Builder abuilder = new AlertDialog.Builder(MainActivity.this);
        abuilder.setMessage(R.string.exitAlert).setCancelable(true).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = abuilder.create();
        alert.setTitle(R.string.close);
        alert.show();
    }
}