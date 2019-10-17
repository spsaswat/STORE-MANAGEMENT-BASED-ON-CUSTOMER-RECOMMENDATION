package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class updatelogin extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText password;
    public static EditText uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatelogin);
        uid=(EditText)findViewById(R.id.editText37);
        password=(EditText)findViewById(R.id.editText43);
        myDb =new DatabaseHelper(this);
    }
    public void validate(View view) {
        String u_id = uid.getText().toString();

        String pass =password.getText().toString();
        int r=myDb.check(u_id,pass);
        if(r==1) {
            Intent intent = new Intent(updatelogin.this, updateuser.class);
            startActivity(intent);
        }
        else
            Toast.makeText(updatelogin.this,"Login error!",Toast.LENGTH_LONG).show();


    }
}
