package com.veinat.calculated;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.veinat.calculated.Adapter.FragmentsAdapter;
import com.veinat.calculated.Fragment.Fragment1_MenuConverter;
import com.veinat.calculated.Fragment.Fragment2_StandardCalculator;
import com.veinat.calculated.Fragment.Fragment3_ScientificCalculator;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TabLayout tabs;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs = findViewById(R.id.tabs);
        pager = findViewById(R.id.pager);

        FragmentsAdapter adapter = new FragmentsAdapter(getSupportFragmentManager(),
                tabs.getTabCount(),
                new Fragment1_MenuConverter(),
                new Fragment2_StandardCalculator(),
                new Fragment3_ScientificCalculator());

        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Objects.requireNonNull(tabs.getTabAt(1)).select();
        pager.setCurrentItem(1);
    }
}
