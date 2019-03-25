package com.veinat.calculated.Converter;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.veinat.calculated.R;

public class NumbConverter extends AppCompatActivity implements View.OnClickListener {
    private Spinner spinConversionSelection;
    private int spinPosition;
    private EditText dec, bin, oct, hex;
    private TextView input, binary, decimal, octal, hexa;
    private View linedec, linebin, lineoct, linehex;
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, numa, numb, numc, numd, nume, numf, backspace;
    private ImageButton calculate;
    private Toolbar toolbar;
    private int count1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_converter);


        initializeButtons();
        setOnclick();

        backspace = (Button)findViewById(R.id.backSpace);

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.length() != 0) {
                    String text = input.getText().toString();
                    if (text.endsWith("."))
                        count1 = 0;
                    String newText = text.substring(0, text.length() - 1);
                    input.setText(newText);
                }
                input.setError(null);
            }
        });

        backspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                input.setText("");
                decimal.setText("");
                binary.setText("");
                octal.setText("");
                hexa.setText("");
                count1 = 0;
                input.setError(null);
                return true;
            }
        });


        toolbar = findViewById(R.id.toolbar_temp);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Конвертер систем счисления");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        input = (TextView) findViewById(R.id.input2);
        linedec = (View) findViewById(R.id.linedec);
        linebin = (View) findViewById(R.id.linebin);
        lineoct = (View) findViewById(R.id.lineoct);
        linehex = (View) findViewById(R.id.linehex);
        dec = (EditText) findViewById(R.id.viewDecimal);
        bin = (EditText) findViewById(R.id.viewBinary);
        oct = (EditText) findViewById(R.id.viewOctal);
        hex = (EditText) findViewById(R.id.viewHexa);
        binary = (TextView) findViewById(R.id.textBinary);
        decimal = (TextView) findViewById(R.id.textDecimal);
        octal = (TextView) findViewById(R.id.textOctal);
        hexa = (TextView) findViewById(R.id.textHexa);

        spinConversionSelection = (Spinner) findViewById(R.id.spinConversionSelection);

        spinConversionSelection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinPosition = i;

                input.setText("");
                decimal.setText("");
                binary.setText("");
                octal.setText("");
                hexa.setText("");
                input.setError(null);

                switch (spinPosition) {
                    case 0:
                        numa.setClickable(false);
                        numb.setClickable(false);
                        numc.setClickable(false);
                        numd.setClickable(false);
                        nume.setClickable(false);
                        numf.setClickable(false);
                        num0.setClickable(true);
                        num1.setClickable(true);
                        num2.setClickable(true);
                        num3.setClickable(true);
                        num4.setClickable(true);
                        num5.setClickable(true);
                        num6.setClickable(true);
                        num7.setClickable(true);
                        num8.setClickable(true);
                        num9.setClickable(true);

                        numa.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numc.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numd.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        nume.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numf.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num0.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num1.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num2.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num3.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num4.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num5.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num6.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num7.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num8.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num9.setTextColor(getResources().getColor(R.color.equl_text_color));

                        dec.setVisibility(View.GONE);
                        bin.setVisibility(View.VISIBLE);
                        oct.setVisibility(View.VISIBLE);
                        hex.setVisibility(View.VISIBLE);
                        linedec.setVisibility(View.GONE);
                        linebin.setVisibility(View.VISIBLE);
                        lineoct.setVisibility(View.VISIBLE);
                        linehex.setVisibility(View.VISIBLE);
                        decimal.setVisibility(View.GONE);
                        binary.setVisibility(View.VISIBLE);
                        octal.setVisibility(View.VISIBLE);
                        hexa.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        numa.setClickable(false);
                        numb.setClickable(false);
                        numc.setClickable(false);
                        numd.setClickable(false);
                        nume.setClickable(false);
                        numf.setClickable(false);
                        num0.setClickable(true);
                        num1.setClickable(true);
                        num2.setClickable(false);
                        num3.setClickable(false);
                        num4.setClickable(false);
                        num5.setClickable(false);
                        num6.setClickable(false);
                        num7.setClickable(false);
                        num8.setClickable(false);
                        num9.setClickable(false);

                        numa.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numc.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numd.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        nume.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numf.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num0.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num1.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num2.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num3.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num4.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num5.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num6.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num7.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num8.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num9.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                        dec.setVisibility(View.VISIBLE);
                        bin.setVisibility(View.GONE);
                        oct.setVisibility(View.VISIBLE);
                        hex.setVisibility(View.VISIBLE);
                        linedec.setVisibility(View.VISIBLE);
                        linebin.setVisibility(View.GONE);
                        lineoct.setVisibility(View.VISIBLE);
                        linehex.setVisibility(View.VISIBLE);
                        decimal.setVisibility(View.VISIBLE);
                        binary.setVisibility(View.GONE);
                        octal.setVisibility(View.VISIBLE);
                        hexa.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        numa.setClickable(false);
                        numb.setClickable(false);
                        numc.setClickable(false);
                        numd.setClickable(false);
                        nume.setClickable(false);
                        numf.setClickable(false);
                        num0.setClickable(true);
                        num1.setClickable(true);
                        num2.setClickable(true);
                        num3.setClickable(true);
                        num4.setClickable(true);
                        num5.setClickable(true);
                        num6.setClickable(true);
                        num7.setClickable(true);
                        num8.setClickable(false);
                        num9.setClickable(false);

                        numa.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numb.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numc.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numd.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        nume.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        numf.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num0.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num1.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num2.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num3.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num4.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num5.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num6.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num7.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num8.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                        num9.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

                        dec.setVisibility(View.VISIBLE);
                        bin.setVisibility(View.VISIBLE);
                        oct.setVisibility(View.GONE);
                        hex.setVisibility(View.VISIBLE);
                        linedec.setVisibility(View.VISIBLE);
                        linebin.setVisibility(View.VISIBLE);
                        lineoct.setVisibility(View.GONE);
                        linehex.setVisibility(View.VISIBLE);
                        decimal.setVisibility(View.VISIBLE);
                        binary.setVisibility(View.VISIBLE);
                        octal.setVisibility(View.GONE);
                        hexa.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        numa.setClickable(true);
                        numb.setClickable(true);
                        numc.setClickable(true);
                        numd.setClickable(true);
                        nume.setClickable(true);
                        numf.setClickable(true);
                        num0.setClickable(true);
                        num1.setClickable(true);
                        num2.setClickable(true);
                        num3.setClickable(true);
                        num4.setClickable(true);
                        num5.setClickable(true);
                        num6.setClickable(true);
                        num7.setClickable(true);
                        num8.setClickable(true);
                        num9.setClickable(true);

                        numa.setTextColor(getResources().getColor(R.color.equl_text_color));
                        numb.setTextColor(getResources().getColor(R.color.equl_text_color));
                        numc.setTextColor(getResources().getColor(R.color.equl_text_color));
                        numd.setTextColor(getResources().getColor(R.color.equl_text_color));
                        nume.setTextColor(getResources().getColor(R.color.equl_text_color));
                        numf.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num0.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num1.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num2.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num3.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num4.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num5.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num6.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num7.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num8.setTextColor(getResources().getColor(R.color.equl_text_color));
                        num9.setTextColor(getResources().getColor(R.color.equl_text_color));

                        dec.setVisibility(View.VISIBLE);
                        bin.setVisibility(View.VISIBLE);
                        oct.setVisibility(View.VISIBLE);
                        hex.setVisibility(View.GONE);
                        linedec.setVisibility(View.VISIBLE);
                        linebin.setVisibility(View.VISIBLE);
                        lineoct.setVisibility(View.VISIBLE);
                        linehex.setVisibility(View.GONE);
                        decimal.setVisibility(View.VISIBLE);
                        binary.setVisibility(View.VISIBLE);
                        octal.setVisibility(View.VISIBLE);
                        hexa.setVisibility(View.GONE);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void initializeButtons() {
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
        this.numa = findViewById(R.id.numa);
        this.numb = findViewById(R.id.numb);
        this.numc = findViewById(R.id.numc);
        this.numd = findViewById(R.id.numd);
        this.nume = findViewById(R.id.nume);
        this.numf = findViewById(R.id.numf);
        this.calculate = findViewById(R.id.calculate);
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
        this.numa.setOnClickListener(this);
        this.numb.setOnClickListener(this);
        this.numc.setOnClickListener(this);
        this.numd.setOnClickListener(this);
        this.nume.setOnClickListener(this);
        this.numf.setOnClickListener(this);
        this.calculate.setOnClickListener(this);
    }

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

            case R.id.numa:
                input.setText(input.getText() + "a");
                break;

            case R.id.numb:
                input.setText(input.getText() + "b");
                break;

            case R.id.numc:
                input.setText(input.getText() + "c");
                break;

            case R.id.numd:
                input.setText(input.getText() + "d");
                break;

            case R.id.nume:
                input.setText(input.getText() + "e");
                break;

            case R.id.numf:
                input.setText(input.getText() + "f");
                break;

            case R.id.calculate:
                if (!isEmpty()) {
                calculation();
                }
                break;
        }
    }


    private void calculation() {


        calculateDecimal();
        calculateBinary();
        calculateOctal();
        calculateHexa();

    }

    private void calculateDecimal() {
        String value = input.getText().toString();

        if (!isEmpty()) {
            switch (spinPosition) {
                case 0:
                    try {
                        decimal.setText(value);
                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
                case 1:
                    try {
                        decimal.setText("" + Long.parseLong(value, 2));
                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
                case 2:
                    try {
                        decimal.setText("" + Long.parseLong(value, 8));
                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
                case 3:
                    try {
                        decimal.setText("" +  Long.parseLong(value, 16));
                    } catch (Exception e) {
                        input.setError("");
                    }

                    break;
            }
        }


    }

    private void calculateBinary() {
        String value = input.getText().toString();

        if (!isEmpty()) {
            switch (spinPosition) {
                case 0:
                    try {
                        binary.setText("" + Long.toBinaryString(Long.valueOf(value)));
                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
                case 1:
                    try {
                        binary.setText(value);
                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
                case 2:
                    try {
                        binary.setText("" + Long.toBinaryString(Long.parseLong(value, 8)));
                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
                case 3:
                    try {
                        binary.setText("" + Long.toBinaryString(Long.parseLong(value, 16)));
                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
            }
        }
    }

    private void calculateOctal() {
        String value = input.getText().toString();

        if (!isEmpty()) {
            switch (spinPosition) {
                case 0:
                    try {
                        octal.setText("" + Long.toOctalString(Long.valueOf(value)));
                    } catch (Exception e) {
                        input.setError("");
                    }

                    break;
                case 1:
                    try {
                        octal.setText("" + Long.toOctalString(Long.parseLong(value, 8)));

                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
                case 2:
                    try {
                        octal.setText(value);

                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
                case 3:
                    try {
                        octal.setText("" + Long.toOctalString(Long.parseLong(value, 16)));

                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
            }
        }
    }

    private void calculateHexa() {
        String value = input.getText().toString();

        if (!isEmpty()) {
            switch (spinPosition) {
                case 0:
                    try {
                        hexa.setText("" + Long.toHexString(Long.valueOf(value)));
                    } catch (Exception e) {
                        input.setError("");
                    }

                    break;
                case 1:
                    try {
                        hexa.setText("" + Long.toHexString(Long.parseLong(value, 2)));
                    } catch (Exception e) {
                        input.setError("");
                    }

                    break;
                case 2:
                    try {
                        hexa.setText("" + Long.toHexString(Long.parseLong(value, 8)));
                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
                case 3:
                    try {
                        hexa.setText(value);
                    } catch (Exception e) {
                        input.setError("");
                    }
                    break;
            }
        }
    }

    private boolean isEmpty() {
        return this.input.getText().toString().isEmpty();
    }


}