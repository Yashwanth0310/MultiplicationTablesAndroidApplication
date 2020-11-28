package com.example.multiplicationtablesandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    public void generateFunction(int tableNumber){
        ArrayList<String> myTimeTables = new ArrayList<String>();
        for (int j = 1; j<=20; j++)
        {
            myTimeTables.add(Integer.toString(j*tableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, myTimeTables);
        myListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar tableSeekBar = (SeekBar) findViewById(R.id.seekBar);
        myListView = (ListView) findViewById(R.id.tablesListView);
        int maxi = 20;
        int startingPosition = 1;
        tableSeekBar.setMax(maxi);
        tableSeekBar.setProgress(startingPosition);
        generateFunction(startingPosition);
        tableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int tableNumber;
                if (i<min)
                {
                    tableNumber = min;
                    tableSeekBar.setProgress(min);
                }
                else {
                 tableNumber = i;
                }
                Log.i("Seek Bar Value", Integer.toString(tableNumber));
                generateFunction(tableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}