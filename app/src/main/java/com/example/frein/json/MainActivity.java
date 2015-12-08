package com.example.frein.json;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private TextView displayTV;
    private String thisJSON;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.thisJSON = "";
        JSON_core.stackJSON = new Stack<String>();
        //System.out.println(JSON_core.stackJSON.peek());
        JSON_core.stackJSON.push(thisJSON);

        this.displayTV = (TextView)this.findViewById(R.id.displayTV);
        this.displayTV.setText("{\n\n}");
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        this.thisJSON = JSON_core.stackJSON.peek();
        this.displayTV.setText("{\n" + this.thisJSON + "\n}");
    }

    public void refreshButtonPressed(View v)
    {
        this.thisJSON = JSON_core.stackJSON.peek();
        this.displayTV.setText("{\n" + this.thisJSON + "\n}");
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
}
