package com.veinat.calculated.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.veinat.calculated.PostfixCalc;
import com.veinat.calculated.R;
import com.veinat.calculated.Calculator.Сalcs;

import java.util.List;

public class RecyclerViewAdapter_2 extends RecyclerView.Adapter<RecyclerViewAdapter_2.ViewHolder> {

    private LayoutInflater inflater;
    private List<Сalcs> Calc;
    private Context context;

    public RecyclerViewAdapter_2(Context context, List<Сalcs> Calc) {
        this.Calc = Calc;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }
    @Override
    public RecyclerViewAdapter_2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter_2.ViewHolder holder, int position) {
        final Сalcs calc = Calc.get(position);
        holder.imageView.setImageResource(calc.getImage());
        holder.nameView.setText(calc.getName());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (calc.getId()){
                    case 1:
                        context.startActivity(new Intent(context, PostfixCalc.class));
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return Calc.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameView;
        LinearLayout layout;
        ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.image);
            nameView = (TextView) view.findViewById(R.id.name);
            layout = view.findViewById(R.id.layout_item);
        }
    }
}

