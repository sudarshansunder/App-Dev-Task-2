package com.gdg.task2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView name = (TextView) findViewById(R.id.fullname);
        final EditText text = (EditText) findViewById(R.id.edittext);
        Button back = (Button) findViewById(R.id.result);
        String firstName = getIntent().getStringExtra("firstname");
        String lastName = getIntent().getStringExtra("lastname");
        name.setText("Hello, " + firstName + " " + lastName);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = text.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("message", str);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
