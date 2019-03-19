package com.veinat.calculated;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Converts> Convert;
    private Context context;

    RecyclerViewAdapter(Context context, List<Converts> Convert) {
        this.Convert = Convert;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        final Converts convert = Convert.get(position);
        holder.imageView.setImageResource(convert.getImage());
        holder.nameView.setText(convert.getName());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (convert.getId()){
                    case 0:
                      context.startActivity(new Intent(context, TempConverter.class));
                      break;
                    case 1:
                        context.startActivity(new Intent(context, LengthConverter.class));
                        break;
                    case 2:
                        context.startActivity(new Intent(context, WeightConverter.class));
                        break;
                    case 3:
                        context.startActivity(new Intent(context, NumbConverter.class));
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return Convert.size();
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
