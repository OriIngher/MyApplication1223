package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button Credit,Ac,divide,multiply,minus,plus,equal;
EditText my_input;
int op_type;
final int op_plus = 1;
final int op_minus = 2;
final int op_multiply = 3;
final int op_divide = 4;
final int op_no_op = 0;
double last_value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Credit = findViewById(R.id.Credit);
        Ac = findViewById(R.id.Ac);
        divide = findViewById(R.id.divide);
        multiply = findViewById(R.id.multiply);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        equal = findViewById(R.id.equal);
        my_input = findViewById(R.id.my_input);

        op_type = op_no_op;
    }

    public void plus_op(View view) {
        op_type = op_plus;
        last_value = new Double(my_input.getText().toString()).doubleValue();
        my_input.setText("+");
    }

    public void minus_op(View view) {
        op_type = op_minus;
        last_value = new Double(my_input.getText().toString()).doubleValue();
        my_input.setText("-");
    }

    public void multiply_op(View view) {
        op_type = op_multiply;
        last_value = new Double(my_input.getText().toString()).doubleValue();
        my_input.setText("*");
    }

    public void divide_op(View view) {
        op_type = op_divide;
        last_value = new Double(my_input.getText().toString()).doubleValue();
        my_input.setText("/");
    }

    public void ac_op(View view) {
        op_type = op_no_op;
        last_value = 0;
        my_input.setText("0");
    }

    public void equal_op(View view) {
        double curr_value = new Double(my_input.getText().toString()).doubleValue();
        switch (op_type)
        {
            case op_plus:
                last_value = last_value + curr_value;
                op_type = op_no_op;
                my_input.setText(new Double(last_value).toString());
                break;

            case op_minus:
                last_value = last_value - curr_value;
                op_type = op_no_op;
                my_input.setText(new Double(last_value).toString());
                break;

            case op_multiply:
                last_value = last_value * curr_value;
                op_type = op_no_op;
                my_input.setText(new Double(last_value).toString());
                break;

            case op_divide:
                if (curr_value==0)
                {
                    op_type = op_no_op;
                    my_input.setText("Not allowed to divide by zero");
                }
                else
                {
                    last_value = last_value / curr_value;
                    op_type = op_no_op;
                    my_input.setText(new Double(last_value).toString());
                }
                break;
        }

    }

    public void credit_op(View view) {
        Intent si = new Intent(this,Main2Activity.class);
        si.putExtra("n",last_value);
        startActivity(si);


    }
}
