package com.example.supermarket;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class UID extends AppCompatActivity {
    EditText check_email;
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uid);
        myDb =new DatabaseHelper(this);

        check_email=(EditText)findViewById(R.id.editText6);
    }
    public void showuid(View view) {
        Cursor res=myDb.uidret(check_email.getText().toString());

        if (res.getCount() == 0) {
            showMessage("Error", "Nothing Fnd!");
            return;
        }
        StringBuffer buffer = new StringBuffer();

        while (res.moveToNext()) {
            buffer.append("Id: " + res.getString(0) + "\n");
        }
        showMessage("Enjoy Our app",buffer.toString());
    }



    public void showMessage(String Title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
    }
}
