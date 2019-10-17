package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Audio_devices extends AppCompatActivity {
    DatabaseHelper myDb;
    MainActivity user;
    EditText QUANT_1,QUANT_2,QUANT_3;
    String UId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_devices);
        myDb =new DatabaseHelper(this);
        user=new MainActivity();
        QUANT_1=(EditText)findViewById(R.id.editText7);
        QUANT_2=(EditText)findViewById(R.id.editText8);
        QUANT_3=(EditText)findViewById(R.id.editText9);
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

    public void proa_1(View view) {
        String pid="21";
        String pro_name="boAt BassHeads, in-Ear";
        String price="₹379";
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

    public void proa_2(View view) {
        String pid="22";
        String pro_name="Boat BassHeads, with Mic";
        String price="₹749";
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

    public void proa_3(View view) {
        String pid="23";
        String pro_name="Echo Dot with Alexa";
        String price="₹3999";
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


    public void display(String msg){
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(msg);
        builder2.show();
    }
}
