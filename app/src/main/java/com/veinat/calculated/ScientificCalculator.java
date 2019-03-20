package com.veinat.calculated;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class ScientificCalculator extends AppCompatActivity implements View.OnClickListener {

    private EditText input;
    private TextView result;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btndel, btnsin, btndot, btncos, btntan, btnsqrroot, btnexp, btnlog, btnsqr, btncube;
    private Toolbar toolbar;
    private int count1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific_calculator);

        initializeButtons();
        setOnclick();

        input.setRawInputType(InputType.TYPE_NULL);

        toolbar = findViewById(R.id.toolbar_temp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Инеженерный калькулятор");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btndel = (Button) findViewById(R.id.btndel);

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
        this.input = findViewById(R.id.input);
        this.result = findViewById(R.id.result);
        this.btn0 = findViewById(R.id.btn0);
        this.btn1 = findViewById(R.id.btn1);
        this.btn2 = findViewById(R.id.btn2);
        this.btn3 = findViewById(R.id.btn3);
        this.btn4 = findViewById(R.id.btn4);
        this.btn5 = findViewById(R.id.btn5);
        this.btn6 = findViewById(R.id.btn6);
        this.btn7 = findViewById(R.id.btn7);
        this.btn8 = findViewById(R.id.btn8);
        this.btn9 = findViewById(R.id.btn9);
        this.btndot = findViewById(R.id.btndot);
        this.btnsin = findViewById(R.id.btnsin);
        this.btncos = findViewById(R.id.btncos);
        this.btntan = findViewById(R.id.btntan);
        this.btnexp = findViewById(R.id.btnexp);
        this.btnlog = findViewById(R.id.btnlog);
        this.btnsqr = findViewById(R.id.btnsqr);
        this.btncube = findViewById(R.id.btncube);
        this.btnsqrroot = findViewById(R.id.btnsqrroot);

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
        switch (v.getId()) {
            case R.id.num0:
                input.setText(input.getText() + "0");
                break;

            case R.id.num1:
                input.setText(input.getText() + "1");
                break;

            case R.id.num2:
                input.setText(input.getText() + "2");
                break;

            case R.id.num3:
                input.setText(input.getText() + "3");
                break;

            case R.id.num4:
                input.setText(input.getText() + "4");
                break;

            case R.id.num5:
                input.setText(input.getText() + "5");
                break;

            case R.id.num6:
                input.setText(input.getText() + "6");
                break;

            case R.id.num7:
                input.setText(input.getText() + "7");
                break;

            case R.id.num8:
                input.setText(input.getText() + "8");
                break;

            case R.id.num9:
                input.setText(input.getText() + "9");
                break;

            case R.id.dot:
                if (count1 == 0) {
                    input.setText(input.getText() + ".");
                    count1++;
                }
                break;
        }
    }

//    public void updateScreen(){
//        t1.setText(display);
//        e1.setText(display);
//    }
//    public void updateScreenx(){
//        e1.setText(display);
//
//    }
//    public void Sin(View view){
//        double n,m;
//        n=Double.parseDouble(e1.getText().toString());
//        m=Math.sin(n);
//        t1.setText("Sin\t\n"+m);
//    }
//    public void Cos(View view){
//        double n,m;
//        n=Double.parseDouble(e1.getText().toString());
//        m=Math.cos(n);
//        t1.setText("Cosine\t\n"+m);
//    }
//    public void Tan(View view){
//        double n,m;
//        n=Double.parseDouble(e1.getText().toString());
//        m=Math.tan(n);
//        t1.setText("Tan\t\n"+m);
//    }
//    public void Log(View view){
//        double n,m;
//        n=Double.parseDouble(e1.getText().toString());
//        m=Math.log(n);
//        t1.setText("Log\t\n"+m);
//    }
//    public void Exp(View view){
//        double n,m;
//        n=Double.parseDouble(e1.getText().toString());
//        m=Math.exp(n);
//        t1.setText("EXPONENT\t\n"+m);
//    }
//    public void Square(View view){
//        double n,m;
//        n=Double.parseDouble(e1.getText().toString());
//        m=n*n;
//        t1.setText("Square\t\n"+m);
//    }
//    public void Cube(View view){
//        double n,m;
//        n=Double.parseDouble(e1.getText().toString());
//        m=n*n*n;
//        t1.setText("Cube\t\n"+m);
//    }
//    public void Sqroot(View view){
//        double n,m;
//        n=Double.parseDouble(e1.getText().toString());
//        m=Math.sqrt(n);
//        t1.setText("SquareRoot\t\n"+m);
//    }
}
