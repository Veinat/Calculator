package com.veinat.calculated;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Fragment3_MenuCalculator extends Fragment {

    List<Сalcs> Calc = new ArrayList<>();

    public Fragment3_MenuCalculator() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3_menucalculator, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onCreate(savedInstanceState);

        setInitialData();
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.rv);
        RecyclerViewAdapter_2 adapter = new RecyclerViewAdapter_2(getContext(), Calc);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {

        Calc.clear();

        Calc.add(new Сalcs(0,"Инженерный калькулятор", R.drawable.icon_sciencecalulator));
        Calc.add(new Сalcs(1,"Постфиксный калькулятор", R.drawable.icon_post));
        Calc.add(new Сalcs(2,"Префиксный калькулятор", R.drawable.icon_prev));
    }
}

