package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Global Variable
     */
    int numberOfCoffees = 0;
    int pricePerCup = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // creating object of checkbox
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        // checking if the checkbox Whipped Cream is checked or not
        boolean hasWhippedCream = whippedCream.isChecked();

        // creating object of checkbox
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        // checking if the checkbox chocolate is checked or not
        boolean hasChocolate = chocolate.isChecked();

        // logging to the console the value of the boolean variable
        //Log.v("toppings", String.valueOf(hasWhippedCream));

        // Creating Object for the input field
        EditText inputName =  (EditText) findViewById(R.id.name_input) ;
        // Storing data input to string
        String hasName = inputName.getText().toString();

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        String priceMessage = orderSummary(price, hasWhippedCream, hasChocolate, hasName);
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        // avoiding the user to choose value bigger than 100
        if ( numberOfCoffees == 100) return;
        numberOfCoffees++;
        display(numberOfCoffees);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        // avoiding the user to choose negative value
        if ( numberOfCoffees <= 1) return;
        numberOfCoffees--;
        display(numberOfCoffees);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method calculates price.
     *
     * @param addWhippedCream to determine if the customer need extra whipped cream to add
     * @param addChocolate to determine if the customer need extra chocolate to add
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int price = pricePerCup;
        // add one dollar if the user wants whipped cream
        if ( addWhippedCream ) price ++;
        // add two dollars if the user wants chocolate
        if ( addChocolate ) price += 2;

        return numberOfCoffees * price;
    }

    /**
     * This method is called when the order button is clicked.
     *
     * @param price is for the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @param price of the order
     * @return text summary
     */
    public String orderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {
        return "Name: " + name
                + "\nAdd Whipped Cream ? " + addWhippedCream
                + "\nAdd Chocolate ? " + addChocolate
                + "\nQuantity: " + numberOfCoffees
                + "\nTotal: $ " + price + "\nThank you!";

    }

}