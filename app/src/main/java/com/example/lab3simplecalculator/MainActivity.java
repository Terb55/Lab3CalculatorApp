package com.example.lab3simplecalculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private enum Operator{none, add, minus, multiply, divide, eq}
    private double data1 = 0, data2 = 0;
    private Operator optr = Operator.none;
    private boolean requiresCleaning = false, hasDot = false;
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

    public void onClickNumericalButton(View view) {
        int pressID = view.getId();

        TextView curText = (TextView) findViewById(R.id.resultEdit);

        if (optr == Operator.eq) {
            optr = Operator.none;
            curText.setText("");
        }

        if (requiresCleaning) {
            requiresCleaning = false;
            curText.setText("");
        }

        switch (pressID) {
            case R.id.button00:
                curText.setText(curText.getText() + "0");
                break;
            case R.id.button01:
                curText.setText(curText.getText() + "1");
                break;
            case R.id.button02:
                curText.setText(curText.getText() + "2");
                break;
            case R.id.button03:
                curText.setText(curText.getText() + "3");
                break;
            case R.id.button04:
                curText.setText(curText.getText() + "4");
                break;
            case R.id.button05:
                curText.setText(curText.getText() + "5");
                break;
            case R.id.button06:
                curText.setText(curText.getText() + "6");
                break;
            case R.id.button07:
                curText.setText(curText.getText() + "7");
                break;
            case R.id.button08:
                curText.setText(curText.getText() + "8");
                break;
            case R.id.button09:
                curText.setText(curText.getText() + "9");
                break;
            case R.id.buttonDot:
                if (!hasDot) {
                    curText.setText(curText.getText() + ".");
                    hasDot = true;
                }
                break;
            default:
                curText.setText("ERROR");
                Log.d("Error", "Error: Unknown Button pressed");
                break;
        }
    }

    public void onClickFunctionButton(View view) {
        int pressID = view.getId();

        TextView curText = (TextView) findViewById(R.id.resultEdit);

        if (pressID == R.id.buttonCE) {
            optr = Operator.none;
            curText.setText("");
            data1 = 0;
            data2 = 0;
            requiresCleaning = false;
            return;
        }
        String dataText = curText.getText().toString();
        double numberVal = dataText.length() > 0 ? Double.parseDouble(dataText) : 0;

        if (optr == Operator.none) {
            data1 = numberVal;
            requiresCleaning = true;

            switch (pressID) {
                case R.id.buttonEq:
                    optr = Operator.eq;
                    data1 = 0;
                    break;
                case R.id.buttonAdd:
                    optr = Operator.add;
                    break;
                case R.id.buttonSub:
                    optr = Operator.minus;
                    break;
                case R.id.buttonMult:
                    optr = Operator.multiply;
                    break;
                case R.id.buttonDiv:
                    optr = Operator.divide;
                    break;
                case R.id.buttonCE:
                    optr = Operator.none;
                    break;
            }
        } else {
            double result = 0;
            data2 = numberVal;
            switch (optr) {
                case eq:
                    break;
                case none:
                    break;
                case add:
                    result = data1 + data2;
                    break;
                case minus:
                    result = data1 - data2;
                    break;
                case divide:
                    result = data1 / data2;
                    break;
                case multiply:
                    result = data1 * data2;
                    break;
            }
            data1 = result;
            optr = Operator.none;
            if ((result - (int) result) != 0) {
                curText.setText(String.valueOf(result));
            } else {
                curText.setText(String.valueOf((int) result));
            }
        }
    }
}