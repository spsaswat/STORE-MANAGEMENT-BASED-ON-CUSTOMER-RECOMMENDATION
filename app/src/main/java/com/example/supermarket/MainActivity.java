package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText password;
    String admin = "909090", pass_admin = "@proxy";

    public static EditText uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uid = (EditText) findViewById(R.id.editText4);
        password = (EditText) findViewById(R.id.editText5);
        myDb = new DatabaseHelper(this);

    }


    public void validate(View view) {
        String u_id = uid.getText().toString();

        String pass = password.getText().toString();
        int r = myDb.check(u_id, pass);
        if (r == 1) {
            Intent intent = new Intent(MainActivity.this, products.class);
            startActivity(intent);
        } else if (u_id.equals(admin) && pass.equals(pass_admin)) {
            Intent intent = new Intent(MainActivity.this, admin_page.class);
            startActivity(intent);

        } else
            Toast.makeText(MainActivity.this, "Login error!", Toast.LENGTH_LONG).show();


    }

    public void userpage(View view) {
        Intent intent = new Intent(MainActivity.this, NewUser.class);
        startActivity(intent);
    }

   public void updateloginpage(View view) {
        Intent intent = new Intent(MainActivity.this, updatelogin.class);
        startActivity(intent);
    }

}
