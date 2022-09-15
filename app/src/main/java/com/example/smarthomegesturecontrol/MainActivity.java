package com.example.smarthomegesturecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
{

    public String currgesture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView currView = findViewById(R.id.autoCompleteTextView);
        final String[] videoAddress = {""};
        String[] gesture = getResources().getStringArray(R.array.gestures);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, gesture);
        currView.setAdapter(adapter);
        currView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i)
                {
                    case 0:
                        currgesture = "Turn on lights";
                        break;
                    case 1:
                        currgesture = "Turn off lights";
                        break;
                    case 2:
                        currgesture = "Turn on fan";
                        break;
                    case 3:
                        currgesture = "Turn off fan";
                        break;
                    case 4:
                        currgesture= "Increase fan speed";
                        break;
                    case 5:
                        currgesture = "Decrease fan speed";
                        break;
                    case 6:
                        currgesture = "Set Thermostat to specified temperature";
                        break;
                    case 7:
                        currgesture = "0";
                        break;
                    case 8:
                        currgesture = "1";
                        break;
                    case 9:
                        currgesture= "2";
                        break;
                    case 10:
                        currgesture= "3";
                        break;
                    case 11:
                        currgesture= "4";
                        break;
                    case 12:
                        currgesture = "5";
                        break;
                    case 13:
                        currgesture = "6";
                        break;
                    case 14:
                        currgesture = "7";
                        break;
                    case 15:
                        currgesture= "8";
                        break;
                    case 16:
                        currgesture= "9";
                        break;
                    default:
                        currgesture= "";
                        break;
                }
                Toast.makeText(getApplicationContext(),currgesture,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Screen2.class);
                intent.putExtra("Gesture",currgesture);

                startActivity(intent);
                Log.d("onItemSelected", currgesture);
            }
        });


    }




}