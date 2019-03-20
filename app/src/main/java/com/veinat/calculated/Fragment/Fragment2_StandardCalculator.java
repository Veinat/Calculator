package com.veinat.calculated.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.veinat.calculated.R;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Locale;
import java.util.Objects;

public class Fragment2_StandardCalculator extends Fragment implements View.OnClickListener {

    private EditText inputtext;
    private TextView resulttext;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnbrs, btndel, btndiv, btndot, btnpm;
    private ImageButton btnplus, btnmin, btnmult, btneq;
    private boolean stateError, isNumber;
    private int count1 = 0;


    public Fragment2_StandardCalculator() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2_standardcalculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeButtons();
        setOnclick();
        inputtext.setRawInputType(InputType.TYPE_NULL);
        inputtext.addTextChangedListener(textWatcher);

        btndel = (Button)getView().findViewById(R.id.btndel);

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

        btndel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clear();
                return true;
            }
        });
    }

    private void initializeButtons() {
        this.inputtext = Objects.requireNonNull(getView()).findViewById(R.id.input);
        this.resulttext = getView().findViewById(R.id.result);
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
        this.btnplus = getView().findViewById(R.id.btnplus);
        this.btnmin = getView().findViewById(R.id.btnmin);
        this.btnmult = getView().findViewById(R.id.btnmult);
        this.btndiv = getView().findViewById(R.id.btndiv);
        this.btnbrs = getView().findViewById(R.id.btnbrs);
        this.btnpm = getView().findViewById(R.id.btnpm);
        this.btneq = getView().findViewById(R.id.btneq);
        this.btndot = getView().findViewById(R.id.btndot);

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
        this.btnplus.setOnClickListener(this);
        this.btnmult.setOnClickListener(this);
        this.btnmin.setOnClickListener(this);
        this.btndiv.setOnClickListener(this);
        this.btndot.setOnClickListener(this);
        this.btneq.setOnClickListener(this);
        this.btnpm.setOnClickListener(this);
        this.btnbrs.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        int Id = v.getId();
        switch (Id) {
            case R.id.btn0:
                append("0");
                isNumber = true;
                break;
            case R.id.btn1:
                append("1");
                isNumber = true;
                break;
            case R.id.btn2:
                append("2");
                isNumber = true;
                break;
            case R.id.btn3:
                append("3");
                isNumber = true;
                break;
            case R.id.btn4:
                append("4");
                isNumber = true;
                break;
            case R.id.btn5:
                append("5");
                isNumber = true;
                break;
            case R.id.btn6:
                append("6");
                isNumber = true;
                break;
            case R.id.btn7:
                append("7");
                isNumber = true;
                break;
            case R.id.btn8:
                append("8");
                isNumber = true;
                break;
            case R.id.btn9:
                append("9");
                isNumber = true;
                break;
            case R.id.btnplus:
                if (!isEmpty())
                    if (endsWithOperatore())
                        replace("+");
                    else
                        append("+");
                isNumber = false;
                count1 = 0;
                break;
            case R.id.btnmin:
                if (endsWithOperatore())
                    replace("-");
                else
                    append("-");
                isNumber = false;
                count1 = 0;
                break;
            case R.id.btnmult:
                if (!isEmpty())
                    if (endsWithOperatore())
                        replace("x");
                    else
                        append("x");
                isNumber = false;
                count1 = 0;
                break;
            case R.id.btndiv:
                if (!isEmpty())
                    if (endsWithOperatore())
                        replace("/");
                    else
                        append("/");
                isNumber = false;
                count1 = 0;
                break;
            case R.id.btndot:
                if (count1 == 0) {
                    append(".");
                    count1 = 1;
                }
                break;
            case R.id.btnbrs:
                brackets();
                break;
            case R.id.btneq:
                calcule(true);
                break;
            case R.id.btnpm:
                setSing();
                break;
            default:
                break;
        }

    }

    private void setSing() {
        if (isEmpty()){
            append("(-");
        }else if (isNumber && !endsWithOperatore()){
            int index1;
            int index2;
            int index3;
            int index4;
            int lastone = 0;
            index1 = getinput().lastIndexOf("x") + 1;
            index2 = getinput().lastIndexOf("+") + 1;
            index3 = getinput().lastIndexOf("-") + 1;
            index4 = getinput().lastIndexOf("/") + 1;
            if (index1 > index2 && index1 > index3 && index1 > index4)
                lastone = index1;
            else if (index2 > index1 && index2 > index3 && index2 > index4)
                lastone = index2;
            else if (index3 > index2 && index3 > index1 && index3 > index4)
                lastone = index1;
            else if (index4 > index1 && index4 > index3 && index4 > index2)
                lastone = index1;
            char ch=getinput().charAt(lastone);
            appendsing("(-" + String.valueOf(ch), lastone);

        }
    }

    private void appendsing(String str,int index) {

        inputtext.getText().replace(index,index+1,str);
    }


    private void brackets() {
        if ((!stateError && !isEmpty() && !endsWithbrs() && isNumber) || isclosed()) {
            append("x(");
        } else if (isEmpty() || endsWithOperatore() || endsWithbrs()) {
            append("(");
        } else if (!isEmpty() && !endsWithbrs()) {
            append(")");
        }
    }

    private boolean endsWithbrs() {
        return getinput().endsWith("(");
    }

    private boolean isclosed() {
        return getinput().endsWith(")");
    }

    private boolean endsWithOperatore() {
        return getinput().endsWith("+") || getinput().endsWith("-") || getinput().endsWith("/") || getinput().endsWith("x");
    }
    private void replace(String str) {
        inputtext.getText().replace(getinput().length() - 1, getinput().length(), str);
    }

    private void clear() {
        isNumber = false;
        stateError = false;
        inputtext.getText().clear();
        count1 = 0;
    }

    private void append(String str) {
        this.inputtext.getText().append(str);
    }

    private void delete() {
        if (!isEmpty()) {
            String text = inputtext.getText().toString();
            if (text.endsWith("."))
                count1 = 0;
            String newText = text.substring(0, text.length() - 1);
            inputtext.setText(newText);
        }
    }

    private String getinput() {
        return this.inputtext.getText().toString();
    }

    private boolean isEmpty() {
        return getinput().isEmpty();
    }

    private void calcule(boolean isequlclick) {

        String input = getinput();

        try {
            if (!isEmpty() && !endsWithOperatore()) {
                if (input.contains("x")) {
                    input = input.replaceAll("x", "*");
                }
                Expression expression = new ExpressionBuilder(input).build();
                double result = expression.evaluate();
                String str = String.format(Locale.ENGLISH,"%.4f", result);
                boolean k = true;
                do {
                    if (str.endsWith("0")) {
                        str = str.substring(0, str.length() -1);
                    } else {
                        k = false;
                    }
                } while (k);
                if (str.endsWith(".")) {
                    str = str.split("\\.")[0];
                }
                if (isequlclick) {
                    inputtext.setText(str);
                    resulttext.setText("");
                } else
                    resulttext.setText(str);
            } else resulttext.setText("");
        } catch (Exception e) {
            stateError = true;
            if (stateError = true) {
                resulttext.setText("Ошибка");
            }
            isNumber = false;
        }

    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            calcule(false);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}

