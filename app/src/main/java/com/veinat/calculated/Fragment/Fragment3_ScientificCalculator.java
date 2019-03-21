package com.veinat.calculated.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.veinat.calculated.R;

public class Fragment3_ScientificCalculator extends Fragment implements View.OnClickListener {

    private EditText input;
    private TextView result;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btndel, btnsin, btndot, btncos, btntan, btnsqrroot, btnexp, btnlog, btnsqr, btncube;
    private Toolbar toolbar;
    private int count1 = 0;

    public Fragment3_ScientificCalculator() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3_menucalculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeButtons();
        setOnclick();


        btndel = (Button) getView().findViewById(R.id.btndel);

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length() != 0) {
                    String text = input.getText().toString();
                    if (text.endsWith("."))
                        count1 = 0;
                    String newText = text.substring(0, text.length() - 1);
                    input.setText(newText);
                }
            }
        });

        btndel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                input.setText("");
                result.setText("");
                count1 = 0;
                return true;
            }
        });
    }


    private void initializeButtons() {
        this.input = getView().findViewById(R.id.input3);
        this.result = getView().findViewById(R.id.result3);
        this.btn0 = getView().findViewById(R.id.btn0);
        this.btn1 = getView().findViewById(R.id.btn1);
        this.btn2 = getView().findViewById(R.id.btn2);
        this.btn3 = getView().findViewById(R.id.btn3);
        this.btn4 = getView().findViewById(R.id.btn4);
        this.btn5 = getView().findViewById(R.id.btn5);
        this.btn6 = getView().findViewById(R.id.btn6);
        this.btn7 = getView().findViewById(R.id.btn7);
        this.btn8 = getView().findViewById(R.id.btn8);
        this.btn9 = getView().findViewById(R.id.btn9);
        this.btndot = getView().findViewById(R.id.btndot);
        this.btnsin = getView().findViewById(R.id.btnsin);
        this.btncos = getView().findViewById(R.id.btncos);
        this.btntan = getView().findViewById(R.id.btntan);
        this.btnexp = getView().findViewById(R.id.btnexp);
        this.btnlog = getView().findViewById(R.id.btnlog);
        this.btnsqr = getView().findViewById(R.id.btnsqr);
        this.btncube = getView().findViewById(R.id.btncube);
        this.btnsqrroot = getView().findViewById(R.id.btnsqrroot);

    }

    private void setOnclick() {
        this.btn0.setOnClickListener(this);
        this.btn1.setOnClickListener(this);
        this.btn2.setOnClickListener(this);
        this.btn3.setOnClickListener(this);
        this.btn4.setOnClickListener(this);
        this.btn5.setOnClickListener(this);
        this.btn6.setOnClickListener(this);
        this.btn7.setOnClickListener(this);
        this.btn8.setOnClickListener(this);
        this.btn9.setOnClickListener(this);
        this.btndot.setOnClickListener(this);
        this.btnsin.setOnClickListener(this);
        this.btncos.setOnClickListener(this);
        this.btntan.setOnClickListener(this);
        this.btnexp.setOnClickListener(this);
        this.btnlog.setOnClickListener(this);
        this.btnsqr.setOnClickListener(this);
        this.btncube.setOnClickListener(this);
        this.btnsqrroot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int Id = v.getId();
        switch (Id) {
            case R.id.btn0:
                append("0");
                break;
            case R.id.btn1:
                append("1");
                break;
            case R.id.btn2:
                append("2");
                break;
            case R.id.btn3:
                append("3");
                break;
            case R.id.btn4:
                append("4");
                break;
            case R.id.btn5:
                append("5");
                break;
            case R.id.btn6:
                append("6");
                break;
            case R.id.btn7:
                append("7");
                break;
            case R.id.btn8:
                append("8");
                break;
            case R.id.btn9:
                append("9");
                break;
            case R.id.btndot:
                if (count1 == 0) {
                    append(".");
                    count1 = 1;
                }
                break;
            case R.id.btncos:
                if (!isEmpty()) {
                    Cos();
                }
                break;
            case R.id.btnsin:
                if (!isEmpty()) {
                    Sin();
                }
                break;
            case R.id.btntan:
                if (!isEmpty()) {
                    Tan();
                }
                break;
            case R.id.btnlog:
                if (!isEmpty()) {
                    Log();
                }
                break;
            case R.id.btnexp:
                if (!isEmpty()) {
                    Exp();
                }
                break;
            case R.id.btnsqr:
                if (!isEmpty()) {
                    Square();
                }
                break;
            case R.id.btncube:
                if (!isEmpty()) {
                    Cube();
                }
                break;
            case R.id.btnsqrroot:
                if (!isEmpty()) {
                    Sqroot();
                }
                break;
        }
    }


    private boolean isEmpty() {
        return this.input.getText().toString().isEmpty();
    }

    private void append(String str) {
        input.getText().append(str);
    }


    public void Sin(){
        result.setText("Sin\t\n"+Math.sin(Double.parseDouble(input.getText().toString())));
    }
    public void Cos(){
        result.setText("Cos\t\n"+Math.cos(Double.parseDouble(input.getText().toString())));
    }
    public void Tan(){
        result.setText("Tan\t\n"+Math.tan(Double.parseDouble(input.getText().toString())));
    }
    public void Log(){
        result.setText("Log\t\n"+Math.log10(Double.parseDouble(input.getText().toString())));
    }
    public void Exp(){
        result.setText("Exp\t\n"+Math.exp(Double.parseDouble(input.getText().toString())));
    }
    public void Square(){
        result.setText("Square\t\n"+Math.pow(Double.parseDouble(input.getText().toString()), 2));
    }
    public void Cube(){
        result.setText("Cube\t\n"+Math.pow(Double.parseDouble(input.getText().toString()), 3));
    }
    public void Sqroot(){
        result.setText("SquareRoot\t\n"+Math.sqrt(Double.parseDouble(input.getText().toString())));
    }
}

