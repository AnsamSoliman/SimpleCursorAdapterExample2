package com.example.ansam.simplecursoradapterexample;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    SimpleCursorAdapter adapter;
    EditText name,email;
    Button add,show;
    ListView list;
    String Name,Email;
    String []from={"name","email"};
    int []to={R.id.nameA,R.id.emailA};
    HelperDB helper;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.etName);
        email=(EditText)findViewById(R.id.etEmail);
        add=(Button)findViewById(R.id.add);
        show=(Button)findViewById(R.id.show);
        list=(ListView)findViewById(R.id.listView);
        helper=new HelperDB(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name=name.getText().toString();
                Email=email.getText().toString();
                if(Name.equals("")||Email.equals("")){
                    Toast.makeText(getApplicationContext(),"please enter all fields!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean b= helper.insertStudent(Name,Email);
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                    name.setText("");
                    email.setText("");
                }

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c=helper.getData();
                c.moveToFirst();
                if(c.getCount()>0) {
                    adapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.adapter_layout,c,from,to,0);
                }
                list.setAdapter(adapter);
                list.setVisibility(View.VISIBLE);

            }


        });



    }
}
