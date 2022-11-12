package com.example.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

//Needed packages
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyActivity extends AppCompatActivity {
    //Private data model
    private ShipItem shipItem;

    //View objects
    private EditText weightET;
    private TextView baseCostTV;
    private TextView addedCostTV;
    private TextView totalCostTV;

    //Setup
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //Create new data model, call constructor
        shipItem = new ShipItem();

        //Establish references to view objects
        weightET = (EditText) findViewById(R.id.editText1); //Editable text field
        baseCostTV = (TextView) findViewById(R.id.textView4); //Base cost text view
        addedCostTV = (TextView) findViewById(R.id.textView6); //Added cost text view
        totalCostTV = (TextView) findViewById(R.id.textView8); //Total cost text view

        //Register event listener to editable text field
        weightET.addTextChangedListener(weightTextWatcher);
    }

    //Private TextWatcher data member
    private TextWatcher weightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            //Try to update the model
            try {
                //Read text from editable field and convert to double, then cast to int and set model
                shipItem.setWeight((int) Double.parseDouble(charSequence.toString()));
            } catch (NumberFormatException e) {
                //If input is invalid reset weight to 0
                shipItem.setWeight(0);
            }

            displayShipping();
        }

        @Override
        public void afterTextChanged(Editable editable) { }
    };

    //Update the view
    private void displayShipping() {
        //Update base cost
        baseCostTV.setText("$" + String.format("%.02f", shipItem.getBaseCost()));

        //Update added cost
        addedCostTV.setText("$" + String.format("%.02f", shipItem.getAddedCost()));

        //Update total cost
        totalCostTV.setText("$" + String.format("%.02f", shipItem.getTotalCost()));
    }
}