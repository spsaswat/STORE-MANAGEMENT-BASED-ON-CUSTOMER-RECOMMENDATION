package com.example.supermarket;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class admin_page extends AppCompatActivity {
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        myDb =new DatabaseHelper(this);
    }
    public void all_users_Information(View view){
        Cursor res=myDb.showAllData_admin();

        if(res.getCount()==0){
            showMessage("Oops!","No users have registered yet.");
            return;
        }
        StringBuffer buffer=new StringBuffer();


        while (res.moveToNext()){
            buffer.append("UID: "+res.getString(0)+"\n");
            buffer.append("first name: "+res.getString(1)+"\n");
            if(!(res.getString(2).isEmpty()))
                buffer.append("middle name: "+res.getString(2)+"\n");
            buffer.append("last name: "+res.getString(3)+"\n");
            buffer.append("age: "+res.getString(4)+"\n");
            buffer.append("email: "+res.getString(5)+"\n");
            buffer.append("phone no: "+res.getString(6)+"\n\n");
        }

        showMessage("ALL USERS",buffer.toString());
    }
    public void showMessage(String Title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
    }

}
