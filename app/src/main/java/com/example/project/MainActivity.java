package com.example.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    // in My MainActivity class
    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                //intent.putExtra("text", "Ronya Rövardotter:\nBlodet ska rinna!"); // Optional
                //intent.putExtra("number", 888); // Optional
                startActivity(intent);
            }
        });




        //myPreferenceRef = getPreferences(MODE_PRIVATE);
        //myPreferenceEditor = myPreferenceRef.edit();
        myPreferenceRef =  getSharedPreferences("MyPreferenceName", MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();



        //TextView prefTextRef= new TextView(this);
        //prefTextRef=(TextView)findViewById(R.id.prefText);
        //prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "bUTTON"));
    }

    public void onResume(){
        super.onResume();
        TextView prefTextRef= new TextView(this);
        prefTextRef=(TextView)findViewById(R.id.prefText);
        prefTextRef.setText(myPreferenceRef.getString("MyAppPreferenceString", "No preference found."));
    }
}
