package com.example.retrofit.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.Helper.Helper;
import com.example.retrofit.Model.Overview;
import com.example.retrofit.R;

import java.util.ArrayList;

public class OverviewRecycleView extends RecyclerView.Adapter<OverviewRecycleView.ViewHolder> {

    private ArrayList<Overview> overviews = new ArrayList<>();
    private Context context;

    public OverviewRecycleView(Context context, ArrayList<Overview> overviews)
    {
        this.context = context;
        this.overviews = overviews;
    }


    @NonNull
    @Override
    public OverviewRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.activity_overview_element, parent, false);



        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String date = overviews.get(position).getDate();
        String deaths = Helper.formatCardNumber(overviews.get(position).getDeath() );
        String treating = Helper.formatCardNumber( overviews.get(position).getTreating() );
        String recovered = Helper.formatCardNumber( overviews.get(position).getRecovered());

        holder.date.setText(date);
        holder.deaths.setText(deaths);
        holder.treating.setText(treating);
        holder.recovered.setText(recovered);
        holder.parentLayout.setOnClickListener(view -> {
            Toast.makeText(context, date, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return overviews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView date, deaths, treating, recovered;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            setControl(itemView);
        }

        private void setControl(View itemView)
        {
            date = itemView.findViewById(R.id.overviewDate);
            deaths = itemView.findViewById(R.id.overviewDeaths);
            treating = itemView.findViewById(R.id.overviewTreating);
            recovered = itemView.findViewById(R.id.overviewRecovered);

            parentLayout = itemView.findViewById(R.id.overviewParentLayout);
        }
    }
}
