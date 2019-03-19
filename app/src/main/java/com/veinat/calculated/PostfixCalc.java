package com.veinat.calculated;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PostfixCalc extends AppCompatActivity {

    TextView inputer;
    TextView result;
    TextView postfix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postfix_calc);

        inputer = (TextView) findViewById(R.id.inputer);
        result = (TextView) findViewById(R.id.result);
        postfix = (TextView) findViewById(R.id.postfix);
    }

    public void onClick(View view){
        Button button = (Button)view;
        inputer.append(button.getText());
    }

    public void onStartClick (View view){
        String exe = inputer.getText().toString();
        if (!exe.isEmpty()){
            String what = WhatIsThat(exe);
            OmniSlash aganim = new OmniSlash(what);
            double finale = aganim.WoToFo();
            result.setText(Double.toString(finale));
            postfix.setText(WoToFo(exe));
        }
        else {
            Toast toast = Toast.makeText(this,"input example",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    public void clear(View view){
        inputer.setText("");
    }

    public static String WoToFo(String input){
        String output;
        System.out.flush();
        // Создание объекта-преобразователя
        InToPost theTrans = new InToPost(input);
        output = theTrans.doTrans(); // Преобразование
        String result="Postfix is " + output + "\n";
        return result;

    }

    public static String WhatIsThat(String input){
        String output;
        System.out.flush();
        // Создание объекта-преобразователя
        InToPost theTrans = new InToPost(input);
        output = theTrans.doTrans(); // Преобразование
        String result=output;
        return result;

    }
}
