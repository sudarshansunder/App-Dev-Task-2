package com.gdg.task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText firstname = (EditText) findViewById(R.id.firstname);
        final EditText lastname = (EditText) findViewById(R.id.lastname);
        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first = firstname.getText().toString();
                String last = lastname.getText().toString();
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("firstname", first);
                intent.putExtra("lastname", last);
                startActivityForResult(intent, 69);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 69) {
            Toast.makeText(this, data.getStringExtra("message"), Toast.LENGTH_SHORT).show();
        }
    }
}
