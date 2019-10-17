package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class snacks extends AppCompatActivity {
    DatabaseHelper myDb;
    MainActivity user;
    EditText QUANT_1,QUANT_2,QUANT_3,QUANT_4,QUANT_5;
    String UId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
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


    public void display(String msg){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(msg);
        builder2.show();
    }

    public void pros_1(View view) {
        String pid="11";
        String pro_name="LAY's Potato Chips, 90g";
        String price="₹34";
        String quant=QUANT_1.getText().toString();
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

    public void pros_2(View view) {
        String pid="12";
        String pro_name="Red Bull, 250ml, 4 pack";
        String price="₹370";
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

    public void pros_3(View view) {
        String pid="13";
        String pro_name="ACT II Nachoz, Tomato, 150g";
        String price="₹62";
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

    public void pros_4(View view) {
        String pid="14";
        String pro_name="B Natural, Mixed Fruit";
        String price="₹32";
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

    public void pros_5(View view) {
        String pid="15";
        String pro_name="Dark Fantasy, 75g";
        String price="₹29";
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


}
