package com.example.frein.json;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddArray extends AppCompatActivity {
    private TextView displayTV;
    private String thisJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_array);

        this.thisJSON = "";
        JSON_core.stackJSON.push(this.thisJSON);

        this.displayTV = (TextView)this.findViewById(R.id.displayTV);
        this.displayTV.setText("[\n" + this.thisJSON + "\n]");
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        this.thisJSON = JSON_core.stackJSON.peek();
        this.displayTV.setText("[\n" + this.thisJSON + "\n]");
    }

    public void refreshButtonPressed(View v)
    {
        this.thisJSON = JSON_core.stackJSON.peek();
        this.displayTV.setText("[\n" + this.thisJSON + "\n]");
    }

    public void addStringButtonPressed(View v)
    {
        Intent i = new Intent(this, AddString.class);
        this.startActivity(i);
    }

    public void addNumberButtonPressed(View v)
    {
        Intent i = new Intent(this, AddNumber.class);
        this.startActivity(i);
    }

    public void addObjButtonPressed(View v)
    {
        Intent i = new Intent(this, AddObjActivity.class);
        this.startActivity(i);
    }

    public void addArrayButtonPressed(View v)
    {
        Intent i = new Intent(this, AddArray.class);
        this.startActivity(i);
    }

    public void addButtonPressed(View v)
    {
        this.thisJSON = JSON_core.stackJSON.pop();
        String previousJSON = JSON_core.stackJSON.pop();
        if (!previousJSON.equals(""))
        {
            previousJSON += ",\n";
        }
        String result = previousJSON + "[\n" + this.thisJSON + "\n]";
        JSON_core.stackJSON.push(result);
        this.onBackPressed();
    }
}
