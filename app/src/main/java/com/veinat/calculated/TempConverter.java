package com.veinat.calculated;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class TempConverter extends AppCompatActivity implements View.OnClickListener {

    private EditText e1, e2;
    private Spinner s1, s2;
    private int count1 = 0;
    private Converting.Temperature ca;
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, dot, backspace;
    private ImageButton equal;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

        initializeButtons();
        setOnclick();
        e1.setRawInputType(InputType.TYPE_NULL);
        e2.setRawInputType(InputType.TYPE_NULL);
        ca = new Converting.Temperature();

        backspace = (Button)findViewById(R.id.backSpace);

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.length() != 0) {
                    String text = e1.getText().toString();
                    if (text.endsWith("."))
                        count1 = 0;
                    String newText = text.substring(0, text.length() - 1);
                    e1.setText(newText);
                }
            }
        });

        backspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                e1.setText("");
                e2.setText("");
                count1 = 0;
                return true;
            }
        });


        toolbar = findViewById(R.id.toolbar_temp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Конвертер Температуры");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initializeButtons() {
        this.e1 = findViewById(R.id.item1);
        this.e2 = findViewById(R.id.item2);
        this.s1 = findViewById(R.id.spinner1);
        this.s2 = findViewById(R.id.spinner2);
        this.num0 = findViewById(R.id.num0);
        this.num1 = findViewById(R.id.num1);
        this.num2 = findViewById(R.id.num2);
        this.num3 = findViewById(R.id.num3);
        this.num4 = findViewById(R.id.num4);
        this.num5 = findViewById(R.id.num5);
        this.num6 = findViewById(R.id.num6);
        this.num7 = findViewById(R.id.num7);
        this.num8 = findViewById(R.id.num8);
        this.num9 = findViewById(R.id.num9);
        this.dot = findViewById(R.id.dot);
        this.equal = findViewById(R.id.equal);
    }

    private void setOnclick() {
        this.num0.setOnClickListener(this);
        this.num1.setOnClickListener(this);
        this.num2.setOnClickListener(this);
        this.num3.setOnClickListener(this);
        this.num4.setOnClickListener(this);
        this.num5.setOnClickListener(this);
        this.num6.setOnClickListener(this);
        this.num7.setOnClickListener(this);
        this.num8.setOnClickListener(this);
        this.num9.setOnClickListener(this);
        this.dot.setOnClickListener(this);
        this.equal.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.num0:
                e1.setText(e1.getText() + "0");
                break;

            case R.id.num1:
                e1.setText(e1.getText() + "1");
                break;

            case R.id.num2:
                e1.setText(e1.getText() + "2");
                break;

            case R.id.num3:
                e1.setText(e1.getText() + "3");
                break;

            case R.id.num4:
                e1.setText(e1.getText() + "4");
                break;

            case R.id.num5:
                e1.setText(e1.getText() + "5");
                break;

            case R.id.num6:
                e1.setText(e1.getText() + "6");
                break;

            case R.id.num7:
                e1.setText(e1.getText() + "7");
                break;

            case R.id.num8:
                e1.setText(e1.getText() + "8");
                break;

            case R.id.num9:
                e1.setText(e1.getText() + "9");
                break;

            case R.id.dot:
                if (count1 == 0) {
                    e1.setText(e1.getText() + ".");
                    count1++;
                }
                break;

            case R.id.equal:
                int item1 = s1.getSelectedItemPosition();
                int item2 = s2.getSelectedItemPosition();
                double value1 = Double.parseDouble(e1.getText().toString());
                double result = evaluate(item1, item2, value1);
                e2.setText(result + "");

                break;
        }
    }

    public double evaluate(int item1,int item2,double value)
    {
        double temp=0.0;
        if(item1==item2)
            return value;
        else
        {
            switch (item1)
            {
                case 0:
                    temp=ca.CelsiTokelvin(value);
                    break;
                case 1:
                    temp=ca.FerToKelvin(value);
                    break;
                case 2:
                    temp=value;
                    break;
            }

            switch (item2)
            {
                case 0:
                    temp=ca.KelvinToCelsi(temp);
                    break;
                case 1:
                    temp=ca.KelvinToFer(temp);
                    break;
            }
            return temp;
        }
    }
}

