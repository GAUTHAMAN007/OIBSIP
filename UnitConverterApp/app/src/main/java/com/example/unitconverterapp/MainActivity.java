package com.example.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valueEditText;
    private Spinner sourceUnitSpinner;
    private Spinner destinationUnitSpinner;
    private Button convertButton;
    private TextView resultTextView;

    private String[] lengthUnits = {"Centimeters", "Meters", "Kilometers", "Inches", "Feet", "Yards", "Miles"};
    private double[] lengthUnitValues = {1, 0.01, 0.00001, 0.393701, 0.0328084, 0.0109361, 0.00000621371};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        valueEditText = findViewById(R.id.valueEditText);
        sourceUnitSpinner = findViewById(R.id.sourceUnitSpinner);
        destinationUnitSpinner = findViewById(R.id.destinationUnitSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultTextView = findViewById(R.id.resultTextView);

        // Set up the spinners
        ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lengthUnits);
        unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sourceUnitSpinner.setAdapter(unitAdapter);
        destinationUnitSpinner.setAdapter(unitAdapter);

        // Set a listener for the Convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        String inputValueString = valueEditText.getText().toString().trim();
        if (inputValueString.isEmpty()) {
            resultTextView.setText("Please enter a value");
            return;
        }

        double inputValue = Double.parseDouble(inputValueString);
        int sourceUnitIndex = sourceUnitSpinner.getSelectedItemPosition();
        int destinationUnitIndex = destinationUnitSpinner.getSelectedItemPosition();

        double sourceValue = inputValue / lengthUnitValues[sourceUnitIndex];
        double resultValue = sourceValue * lengthUnitValues[destinationUnitIndex];

        String resultString = String.format("%.4f %s", resultValue, lengthUnits[destinationUnitIndex]);
        resultTextView.setText(resultString);
    }
}
