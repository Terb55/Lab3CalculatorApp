package com.example.lab3simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private enum Operator{none, add, minus, multiply, divide}
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btn00Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "0");
    }

    public void btn01Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "1");
    }

    public void btn02Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "2");
    }

    public void btn03Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "3");
    }

    public void btn04Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "4");
    }

    public void btn05Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "5");
    }

    public void btn06Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "6");
    }

    public void btn07Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "7");
    }

    public void btn08Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "8");
    }

    public void btn09Click(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + "9");
    }

    public void btnAddClick(View view) {
        optr = Operator.add;
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(etext.getText().toString());
        etext.setText("");
    }

    public void btnMinusClick(View view) {
        optr = Operator.minus;
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(etext.getText().toString());
        etext.setText("");
    }

    public void btnDivideClick(View view) {
        optr = Operator.divide;
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(etext.getText().toString());
        etext.setText("");
    }

    public void btnMultiplyClick(View view) {
        optr = Operator.multiply;
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        data1 = Double.parseDouble(etext.getText().toString());
        etext.setText("");
    }

    public void btnCEClick(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText("");
    }

    public void btnDotClick(View view) {
        TextView etext = (TextView)findViewById(R.id.resultEdit);
        etext.setText(etext.getText() + ".");
    }

    public void btnResultClick(View view) {
        if (optr != Operator.none) {
            TextView etext = (TextView)findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(etext.getText().toString());
            double result = 0;
            if (optr == Operator.add) {
                result = data1 + data2;
            } else if (optr == Operator.minus) {
                result = data1 - data2;
            } else if (optr == Operator.multiply) {
                result = data1 * data2;
            } else if (optr == Operator.divide) {
                result = data1 / data2;
            }

            optr = Operator.none;

            data1 = result;
            if ((result - (int) result) != 0) {
                etext.setText(String.valueOf(result));
            } else {
                etext.setText(String.valueOf((int) result));
            }
        }
    }
}