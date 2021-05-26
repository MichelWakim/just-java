package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
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
        int price = calculatePrice();
        // creating object of checkbox
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        // checking if the checkbox Whipped Cream is checked or not
        boolean hasWhippedCream = whippedCream.isChecked();
        // logging to the console the value of the boolean variable
        Log.v("toppings", String.valueOf(hasWhippedCream));
        String priceMessage = orderSummary(price, hasWhippedCream);
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        numberOfCoffees++;
        display(numberOfCoffees);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
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
     * @return total price
     */
    private int calculatePrice() {
        return numberOfCoffees * pricePerCup;
    }

    /**
     * This method is called when the order button is clicked.
     *
     * @param price is for the order
     * @return the summary to be printed to the screen
     */
    public String orderSummary(int price, boolean hasWhippedCream) {
        return "Name: Micho"
                + "\nAdd Whipped Cream ? " + hasWhippedCream
                + "\nQuantity: " + numberOfCoffees
                + "\nTotal: $ " + price + "\nThank you!";

    }

}