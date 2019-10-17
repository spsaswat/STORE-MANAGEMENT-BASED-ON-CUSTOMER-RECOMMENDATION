package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class products extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
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
                Intent intent = new Intent(products.this, Carts.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

    public void audios(View view){
        Intent intent=new Intent(products.this,Audio_devices.class);
        startActivity(intent);
    }

    public void women_(View view) {
        Intent intent=new Intent(products.this,womens.class);
        startActivity(intent);
    }

    public void men_(View view) {
        Intent intent=new Intent(products.this,mens.class);
        startActivity(intent);
    }

    public void snack(View view) {
        Intent intent=new Intent(products.this,snacks.class);
        startActivity(intent);
    }

    public void station(View view) {
        Intent intent=new Intent(products.this,stationery.class);
        startActivity(intent);
    }
}
