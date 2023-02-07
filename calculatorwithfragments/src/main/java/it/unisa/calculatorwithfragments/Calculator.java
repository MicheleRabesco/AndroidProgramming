package it.unisa.calculatorwithfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends Fragment implements View.OnClickListener {

    private TextView operationDisplay;
    private TextView resultDisplay;
    private TextView memoryDisplay;

    private Boolean equalJustPressed = false;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_calculator, container, false);

        resultDisplay = v.findViewById(R.id.resultDisplay);
        operationDisplay = v.findViewById(R.id.operationDisplay);
        v.findViewById(R.id.n0).setOnClickListener(this);
        v.findViewById(R.id.n1).setOnClickListener(this);
        v.findViewById(R.id.n2).setOnClickListener(this);
        v.findViewById(R.id.n3).setOnClickListener(this);
        v.findViewById(R.id.n4).setOnClickListener(this);
        v.findViewById(R.id.n5).setOnClickListener(this);
        v.findViewById(R.id.n6).setOnClickListener(this);
        v.findViewById(R.id.n7).setOnClickListener(this);
        v.findViewById(R.id.n8).setOnClickListener(this);
        v.findViewById(R.id.n9).setOnClickListener(this);
        v.findViewById(R.id.sum).setOnClickListener(this);
        v.findViewById(R.id.subtract).setOnClickListener(this);
        v.findViewById(R.id.multi).setOnClickListener(this);
        v.findViewById(R.id.divide).setOnClickListener(this);
        v.findViewById(R.id.equal).setOnClickListener(this);
        v.findViewById(R.id.clear).setOnClickListener(this);

        return v;
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
            //case R.id.cambia_activity:
            //changeActivity(v);

        }
    }

    @NonNull
    @Override
    public CreationExtras getDefaultViewModelCreationExtras() {
        return super.getDefaultViewModelCreationExtras();
    }
}