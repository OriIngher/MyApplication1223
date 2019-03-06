package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button Calculator;
    TextView the_last_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button Calculator = findViewById(R.id.Calculator);
        TextView the_last_result = findViewById(R.id.the_last_result);
        Intent gi = getIntent();
        double calculate_result = gi.getDoubleExtra("n",0);
        the_last_result.setText("the last calculate result is:"+calculate_result);
    }


    public void back_to_calculator(View view) {
        Intent si = new Intent(this,MainActivity.class);
               startActivity(si);

    }
}
