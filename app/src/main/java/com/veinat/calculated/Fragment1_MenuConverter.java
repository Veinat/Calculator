package com.veinat.calculated;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class
Fragment1_MenuConverter extends Fragment {

    public Fragment1_MenuConverter() {
    }

    List<Converts> Convert = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1_menuconverter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onCreate(savedInstanceState);

        setInitialData();
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.rv);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), Convert);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData() {

        Convert.clear();

        Convert.add(new Converts(0,"Конвертер температуры",  R.drawable.icon_temperature));
        Convert.add(new Converts(1,"Конвертер длины", R.drawable.icon_length));
        Convert.add(new Converts(2,"Конвертер массы",  R.drawable.icon_weight));
        Convert.add(new Converts(3,"Конвертер систем счиления",  R.drawable.icon_bin));

    }
}

