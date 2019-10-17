package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class mens extends AppCompatActivity {
    DatabaseHelper myDb;
    MainActivity user;
    EditText QUANT_1,QUANT_2,QUANT_3,QUANT_4,QUANT_5;
    String UId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens);
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

    public void prom_1(View view) {
        String pid="1";
        String pro_name="NIVEA MEN Shampoo, 250 ml";
        String price="₹123";
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

    public void prom_2(View view) {
        String pid="2";
        String pro_name="ETHICS Clogs, Rubber";
        String price="₹167";
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

    public void prom_3(View view) {
        String pid="3";
        String pro_name="WildHorn® Wallet, Leather";
        String price="₹498";
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

    public void prom_4(View view) {
        String pid="4";
        String pro_name="Lotto Shoes, Black";
        String price="₹848";
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

    public void prom_5(View view) {
        String pid="5";
        String pro_name="Engage Perfume,120 ml";
        String price="₹139";
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
}
