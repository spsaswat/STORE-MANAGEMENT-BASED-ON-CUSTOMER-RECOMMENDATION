package com.example.supermarket;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class updateuser extends AppCompatActivity {
    DatabaseHelper myDb;
    updatelogin u;
    EditText f_n,m_n,l_n,age,email,p_no,password,UID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateuser);
        myDb =new DatabaseHelper(this);
        u=new updatelogin();
        f_n=(EditText)findViewById(R.id.editText2);
        m_n=(EditText)findViewById(R.id.editText3);
        l_n=(EditText)findViewById(R.id.editText8);
        age=(EditText)findViewById(R.id.editText9);
        email=(EditText)findViewById(R.id.editText10);
        p_no=(EditText)findViewById(R.id.editText11);
        password=(EditText)findViewById(R.id.editText17);
    }
    public void back1(View view) {
        Intent intent = new Intent(updateuser.this, MainActivity.class);
        startActivity(intent);
    }

    public void update1(View view) {
        String f, m, l, e, pass,UID;
        int a;
        long pn;

        UID=u.uid.getText().toString();
        f = f_n.getText().toString();
        m = m_n.getText().toString();
        l = l_n.getText().toString();
        e = email.getText().toString();
        pass = password.getText().toString();



        if (f.isEmpty() || l.isEmpty() || Integer.parseInt(age.getText().toString())<5 || Integer.parseInt(age.getText().toString())>100 || e.isEmpty() || (p_no.getText().toString()).length()!=10 || pass.length()<5 || (e.indexOf('@',2)==-1 ) || (e.indexOf('.',3)==-1)){
            showMessage("All details are mandatory!", "Middle name is optional  though. Kindly ensure your values satisfy the given constraint. And provide email in proper format");
        }
        else {
            a = Integer.parseInt(age.getText().toString());
            pn = Long.parseLong(p_no.getText().toString());
            boolean isin = myDb.updateData(UID,f, m, l, a, e, pn, pass);
            if (isin == true)
                Toast.makeText(this, "Updation Successfull", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Updation not Successfull", Toast.LENGTH_LONG).show();
        }
    }

    public void myInformation(View view){
        UID=u.uid;
        Cursor res=myDb.showAllData(UID.getText().toString());
        if(res.getCount()==0){
            showMessage("Error","Nothing Fnd!");
            return;
        }

        while (res.moveToNext()){

            f_n.setText(res.getString(1));
            if(!(res.getString(2).isEmpty()))
                m_n.setText(res.getString(2));
            l_n.setText(res.getString(3));
            age.setText(res.getString(4));
            email.setText(res.getString(5));
            p_no.setText(res.getString(6));
            password.setText(res.getString(7));
        }

    }

    public void showMessage(String Title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
    }
}
