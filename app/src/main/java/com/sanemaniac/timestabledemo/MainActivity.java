package com.sanemaniac.timestabledemo;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvResults;

    public void generateTimesTable(int timesTableNums) {
        ArrayList<String> calcResults = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            calcResults.add(Integer.toString(i * timesTableNums));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                calcResults);

        lvResults.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvResults = findViewById(R.id.lvResults);

        final SeekBar sbNumbers = findViewById(R.id.sbNumbers);

        sbNumbers.setMax(120);
        sbNumbers.setProgress(10);

        int startingPos = 10;

        generateTimesTable(startingPos);

        sbNumbers.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int number;

                if (progress < min) {
                    number = min;
                    sbNumbers.setProgress(number);
                } else {
                    number = progress;
                }
                Log.i("Current No", Integer.toString(number));

                generateTimesTable(progress);
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