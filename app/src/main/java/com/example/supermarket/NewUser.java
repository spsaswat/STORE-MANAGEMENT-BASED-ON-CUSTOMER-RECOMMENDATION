package com.example.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class NewUser extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText f_n,m_n,l_n,age,email,p_no,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        myDb =new DatabaseHelper(this);
        f_n=(EditText)findViewById(R.id.editText);
        m_n=(EditText)findViewById(R.id.editText2);
        l_n=(EditText)findViewById(R.id.editText3);
        age=(EditText)findViewById(R.id.editText8);
        email=(EditText)findViewById(R.id.editText9);
        p_no=(EditText)findViewById(R.id.editText10);
        password=(EditText)findViewById(R.id.editText11);
    }
    public void back1(View view) {
        Intent intent = new Intent(NewUser.this, MainActivity.class);
        startActivity(intent);
    }

    public void insert1(View view) {
        String f, m, l, e, pass;
        int a;
        long pn;


        f = f_n.getText().toString();
        m = m_n.getText().toString();
        l = l_n.getText().toString();
        e = email.getText().toString();
        pass = password.getText().toString();



        if (f.isEmpty() || l.isEmpty() || Integer.parseInt(age.getText().toString())<5 || Integer.parseInt(age.getText().toString())>100 || e.isEmpty() || (p_no.getText().toString()).length()!=10 || pass.length()<5 || (e.indexOf('@',2)==-1 ) || (e.indexOf('.',3)==-1)){
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setMessage("All details are mandatory Middle name is optional  though. Kindly ensure your values satisfy the given constraint. And provide email in proper format");
            builder1.show();
        }
        else {
            a = Integer.parseInt(age.getText().toString());
            pn = Long.parseLong(p_no.getText().toString());
            boolean isin = myDb.insertData(f, m, l, a, e, pn, pass);
            if (isin == true)
                Toast.makeText(this, "Registered Successfully", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Registration not successful", Toast.LENGTH_LONG).show();
        }

    }


    public void showuid1(View view) {
        Intent intent = new Intent(NewUser.this, UID.class);
        startActivity(intent);
    }
}
