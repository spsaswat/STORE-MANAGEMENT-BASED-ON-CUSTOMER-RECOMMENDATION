package com.example.supermarket;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Carts extends AppCompatActivity {
    DatabaseHelper myDb;
    MainActivity Uid;
    String U_I_D,a,b;
    int i=4;
    long total;
    TextView[] tv = new TextView[21];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carts);
        myDb=new DatabaseHelper(this);
        Uid=new MainActivity();
        U_I_D=Uid.uid.getText().toString();
        tv[0]=(TextView)findViewById(R.id.textView22);
        tv[1]=(TextView)findViewById(R.id.textView29);
        tv[2]=(TextView)findViewById(R.id.textView30);
        tv[3]=(TextView)findViewById(R.id.textView31);
        tv[4]=(TextView)findViewById(R.id.textView32);
        tv[5]=(TextView)findViewById(R.id.textView33);
        tv[6]=(TextView)findViewById(R.id.textView34);
        tv[7]=(TextView)findViewById(R.id.textView35);
        tv[8]=(TextView)findViewById(R.id.textView36);
        tv[9]=(TextView)findViewById(R.id.textView37);
        tv[10]=(TextView)findViewById(R.id.textView38);
        tv[11]=(TextView)findViewById(R.id.textView39);
        tv[12]=(TextView)findViewById(R.id.textView40);
        tv[13]=(TextView)findViewById(R.id.textView41);
        tv[14]=(TextView)findViewById(R.id.textView42);
        tv[15]=(TextView)findViewById(R.id.textView43);
        tv[16]=(TextView)findViewById(R.id.textView44);
        tv[17]=(TextView)findViewById(R.id.textView45);
        tv[18]=(TextView)findViewById(R.id.textView46);
        tv[19]=(TextView)findViewById(R.id.textView47);
        tv[20]=(TextView)findViewById(R.id.textView48);
        display();
    }



    public void empty_c(View view) {
        int r=myDb.empty_cart(U_I_D);
        if(r==0)
            Toast.makeText(this,"Cart could not be Emptied",Toast.LENGTH_SHORT).show();
        else{
            Toast.makeText(this,"Cart Emptied",Toast.LENGTH_SHORT).show();
            tv[0].setText(" The cart is empty");
            while(i!=0)
            {
                tv[i].setText("");
                i--;
            }
            if(i!=4)
                i=4;
            tv[19].setText(" ");
            tv[20].setText(" ");
        }


    }

    public void clear() {
        int r=myDb.empty_cart(U_I_D);
        if(r>0) {
            Toast.makeText(this, "Cart Emptied size limit exceeded", Toast.LENGTH_LONG).show();
            tv[0].setText(" The cart is empty");
            while (i != 0) {
                tv[i].setText("");
                i--;
            }
            if (i != 4)
                i = 4;
        }


    }


   public void display(){

        Cursor res=myDb.get_cart_data(U_I_D);
        if(res.getCount()==0){
            tv[0].setText(" The cart is empty");
            return;
        }
        tv[0].setText("<- click to empty cart");
        tv[1].setText("Quantiy ");
        tv[2].setText("Price(₹) ");
        tv[3].setText("Product details");
        while (res.moveToNext()){
            if(i<19)
            {
                a=res.getString(3);
                tv[i].setText(res.getString(3)+" ");
                b=res.getString(2).substring(1);
                tv[i+1].setText(res.getString(2)+" ");
                tv[i+2].setText(res.getString(1));
                total+=(Long.parseLong(b)*Long.parseLong(a));
            i+=3;
            }
            else
            {i++;break;}
        }
        tv[19].setText("Estimated Total");
        tv[20].setText("₹"+total);
        if(i>19)
            clear();

    }

}
