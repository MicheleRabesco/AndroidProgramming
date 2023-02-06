package it.unisa.calcolatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView operationDisplay;
    private TextView resultDisplay;
    private TextView memoryDisplay;

    private Boolean equalJustPressed = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        resultDisplay = findViewById(R.id.resultDisplay);
        operationDisplay = findViewById(R.id.operationDisplay);
        findViewById(R.id.n0).setOnClickListener(this);
        findViewById(R.id.n1).setOnClickListener(this);
        findViewById(R.id.n2).setOnClickListener(this);
        findViewById(R.id.n3).setOnClickListener(this);
        findViewById(R.id.n4).setOnClickListener(this);
        findViewById(R.id.n5).setOnClickListener(this);
        findViewById(R.id.n6).setOnClickListener(this);
        findViewById(R.id.n7).setOnClickListener(this);
        findViewById(R.id.n8).setOnClickListener(this);
        findViewById(R.id.n9).setOnClickListener(this);
        findViewById(R.id.sum).setOnClickListener(this);
        findViewById(R.id.subtract).setOnClickListener(this);
        findViewById(R.id.multi).setOnClickListener(this);
        findViewById(R.id.divide).setOnClickListener(this);
        findViewById(R.id.equal).setOnClickListener(this);
        findViewById(R.id.clear).setOnClickListener(this);
        findViewById(R.id.cambia_activity).setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.n0:
            case R.id.n1:
            case R.id.n2:
            case R.id.n3:
            case R.id.n4:
            case R.id.n5:
            case R.id.n6:
            case R.id.n7:
            case R.id.n8:
            case R.id.n9:
                operationDisplay.append(((Button) v).getText());
                break;
            case R.id.sum:
            case R.id.subtract:
            case R.id.multi:
            case R.id.divide:
                operationDisplay.append(" " + ((Button) v).getText() + " ");
                break;
            case R.id.equal:
                String equation = operationDisplay.getText().toString();

                String[] operands = equation.split("[\\+\\-\\*\\/]");
                int op1 = Integer.parseInt(operands[0].trim());
                int op2 = Integer.parseInt(operands[1].trim());
                float result = 0;

                if (equation.contains("+")) {
                    result = op1 + op2;
                    //resultDisplay.setText(Float.toString(result));
                    equalJustPressed = true;
                } else if (equation.contains("-")) {
                    result = op1 - op2;
                    //resultDisplay.setText(Float.toString(result));
                    equalJustPressed = true;
                } else if (equation.contains("*")) {
                    result = op1 * op2;
                    //resultDisplay.setText(Float.toString(result));
                    equalJustPressed = true;
                } else if (equation.contains("/")) {
                    result = op1 / op2;
                    //resultDisplay.setText(Float.toString(result));
                    equalJustPressed = true;
                }
                resultDisplay.setText(String.valueOf(result));
                break;
            case R.id.clear:
                operationDisplay.setText("");
                resultDisplay.setText("");
                break;
            case R.id.cambia_activity:
                sendMessage(v);

        }
        /*
        if (equalJustPressed) {
            switch (v.getId()) {
                case R.id.n0:
                case R.id.n1:
                case R.id.n2:
                case R.id.n3:
                case R.id.n4:
                case R.id.n5:
                case R.id.n6:
                case R.id.n7:
                case R.id.n8:
                case R.id.n9:
                    operationDisplay.append(((Button) v).getText());
                    break;
                case R.id.sum:
                case R.id.subtract:
                case R.id.multi:
                case R.id.divide:
                    operationDisplay.append(" " + ((Button) v).getText() + " ");
                    break;
                case R.id.equal:
                    String equation = operationDisplay.getText().toString();

                    String[] operands = equation.split("[\\+\\-\\*\\/]");
                    int op1 = Integer.parseInt(operands[0].trim());
                    int op2 = Integer.parseInt(operands[1].trim());
                    float result = 0;

                    if (equation.contains("+")) {
                        result = op1 + op2;
                        //resultDisplay.setText(Float.toString(result));
                        equalJustPressed = true;
                    } else if (equation.contains("-")) {
                        result = op1 - op2;
                        //resultDisplay.setText(Float.toString(result));
                        equalJustPressed = true;
                    } else if (equation.contains("*")) {
                        result = op1 * op2;
                        //resultDisplay.setText(Float.toString(result));
                        equalJustPressed = true;
                    } else if (equation.contains("/")) {
                        result = op1 / op2;
                        //resultDisplay.setText(Float.toString(result));
                        equalJustPressed = true;
                    }
                    resultDisplay.setText(String.valueOf(result));
                    break;
                case R.id.clear:
                    operationDisplay.setText("");
                    resultDisplay.setText("");
                    break;
            }

        }
        */
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
