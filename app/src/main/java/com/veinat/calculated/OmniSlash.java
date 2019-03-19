package com.veinat.calculated;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OmniSlash {

    public static List<String> all = new ArrayList<>();

    public static String input;

    public OmniSlash(String input){
        this.input=input;
    }

    public OmniSlash(){

    }

    public static Double WoToFo(){
        Double result;

        Pattern pNum = Pattern.compile("\\d+\\.*\\d*|[+\\-*/]");
        Pattern pAct = Pattern.compile("");
        Pattern pDel = Pattern.compile("\\|");

        Matcher mNum = pNum.matcher(input);
        //Matcher mAct = pAct.matcher(input);
        Matcher mDel = pDel.matcher(input);



        while (mDel.find()){
            break;
        }

        while (mNum.find()){
            all.add(mNum.group());
        }

        /*while (mAct.find()){
            all.add(mAct.group());
        }*/
        result=AsmMaker(all);
        return result;
    }

    public static Double AsmMaker(List<String> all){

        Double result=null;
        Double res=null;
        String wow="";

        for (int i = 0; i<all.size(); i++){

            if (isAct(all.get(i))){
                double left=Double.parseDouble(all.get(i-2));
                double right=Double.parseDouble(all.get(i-1));
                res=WhatAct(all.get(i),left,right);
                wow=Double.toString(res);
                all.set(i,wow);
                all.remove(i-2);
                all.remove(i-2);
                i=0;
            }

        }

        result=res;
        return result;
    }



    public static boolean isAct (String act){
        boolean relevant = false;
        switch (act){
            case "+":
            case "-":
            case "*":
            case "/":
                relevant=true;
                break;
            default: break;
        }
        return relevant;
    }

    public static Double WhatAct (String act,Double left, Double right){
        Double action=null;
        switch (act){
            case "+":
                action = left+right;
                break;
            case "-":
                action = left-right;
                break;
            case "*":
                action = left*right;
                break;
            case "/":
                action = left/right;
                break;
            default: break;
        }
        return action;
    }


}
