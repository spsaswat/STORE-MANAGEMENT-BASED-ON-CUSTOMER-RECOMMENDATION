package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class womens extends AppCompatActivity {
    DatabaseHelper myDb;
    MainActivity user;
    EditText QUANT_1,QUANT_2,QUANT_3,QUANT_4,QUANT_5;
    String UId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_womens);
        myDb =new DatabaseHelper(this);
        user=new MainActivity();
        QUANT_1=(EditText)findViewById(R.id.editText7);
        QUANT_2=(EditText)findViewById(R.id.editText8);
        QUANT_3=(EditText)findViewById(R.id.editText9);
        QUANT_4=(EditText)findViewById(R.id.editText10);
        QUANT_5=(EditText)findViewById(R.id.editText11);
        UId=user.uid.getText().toString();
    }

    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.carties) {
            // do something here
            Intent intent = new Intent(this, Carts.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    public void pro_1(View view) {
        String pid="6";
        String pro_name="Lakme Lipstick, 4.7g";
        String price="₹198";
        String quant=QUANT_2.getText().toString();
        int q=Integer.parseInt(quant);
        if(q!=0) {
            if (myDb.insertData_cart(pid,pro_name,price,quant,UId)) ;
            {
                display("Added to cart");
            }
        }
        else {
            display("Data could not be added to cart! \n Please enter valid data.");
        }
    }

    public void pro_2(View view) {
        String pid="7";
        String pro_name="Fogg Scent, 100ml";
        String price="₹324";
        String quant=QUANT_2.getText().toString();
        int q=Integer.parseInt(quant);
        if(q!=0) {
            if (myDb.insertData_cart(pid,pro_name,price,quant,UId)) ;
            {
                display("Added to cart");
            }
        }
        else {
            display("Data could not be added to cart! \n Please enter valid data.");
        }
    }

    public void pro_3(View view) {
        String pid="8";
        String pro_name="BFC Fancy Sling Bag";
        String price="₹275";
        String quant=QUANT_3.getText().toString();
        int q=Integer.parseInt(quant);
        if(q!=0) {
            if (myDb.insertData_cart(pid,pro_name,price,quant,UId)) ;
            {
                display("Added to cart");
            }
        }
        else {
            display("Data could not be added to cart! \n Please enter valid data.");
        }
    }

    public void pro_4(View view) {
        String pid="9";
        String pro_name="Sparx Shoes, Mesh";
        String price="₹749";
        String quant=QUANT_4.getText().toString();
        int q=Integer.parseInt(quant);
        if(q!=0) {
            if (myDb.insertData_cart(pid,pro_name,price,quant,UId)) ;
            {
                display("Added to cart");
            }
        }
        else {
            display("Data could not be added to cart! \n Please enter valid data.");
        }
    }

    public void pro_5(View view) {
        String pid="10";
        String pro_name="TRESemme Shampoo, 580 ml";
        String price="₹287";
        String quant=QUANT_5.getText().toString();
        int q=Integer.parseInt(quant);
        if(q!=0) {
            if (myDb.insertData_cart(pid,pro_name,price,quant,UId)) ;
            {
                display("Added to cart");
            }
        }
        else {
            display("Data could not be added to cart! \n Please enter valid data.");
        }
    }

    public void display(String msg){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(msg);
        builder2.show();
    }
}
