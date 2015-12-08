package com.example.frein.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddString extends AppCompatActivity {
    private EditText nameTF;
    private EditText valueTF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_string);

        this.nameTF = (EditText)this.findViewById(R.id.nameTF);
        this.valueTF = (EditText)this.findViewById(R.id.valueTF);
    }

    public void addButtonPressed(View v)
    {
        String temp = "\"" + this.nameTF.getText().toString() + "\": " + "\"" + this.valueTF.getText().toString() + "\"";
        String currentString = JSON_core.stackJSON.pop();
        if (!currentString.equals(""))
        {
            currentString += ",\n";
        }
        currentString += temp;
        JSON_core.stackJSON.push(currentString);
        System.out.println(JSON_core.stackJSON.peek());
        this.onBackPressed();
    }
}
