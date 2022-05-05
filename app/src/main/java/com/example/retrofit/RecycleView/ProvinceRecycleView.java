package com.example.retrofit.RecycleView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit.Helper.Helper;
import com.example.retrofit.Model.Location;
import com.example.retrofit.Model.Today;
import com.example.retrofit.R;

import java.util.ArrayList;

public class ProvinceRecycleView extends RecyclerView.Adapter<ProvinceRecycleView.ViewHolder> {

    private static final String TAG = "ProvinceRecycleView";
    private ArrayList<Location> locations = new ArrayList<>();
    private Context context;



    public ProvinceRecycleView(Context context, ArrayList<Location> locations) {
        this.locations = locations;
        this.context = context;
    }

    /**
     * onCreateViewHolder, onBindViewHolder, getItemCount are methods created automatically
     *
     * onCreateViewHolder is the same for every situation,it never changes
     *
     * @return*/
    @NonNull
    @Override
    public ProvinceRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.activity_province_element, parent, false);

         ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         String name = locations.get(position).getName();
         String death = Helper.formatCardNumber( locations.get(position).getDeath() );
         String cases = Helper.formatCardNumber( locations.get(position).getCases() );
         String casesToday = Helper.formatCardNumber( locations.get(position).getTodayCases() );

         holder.name.setText(name);
         holder.death.setText(death);
         holder.cases.setText(cases);
         holder.casesToday.setText(casesToday);

         holder.parentLayout.setOnClickListener(view -> Toast.makeText(context, name, Toast.LENGTH_LONG).show());
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }


    /***
     * ViewHolder holder widgets in memory for each element(activity_main_element.xml)
     *
     * parentLayoutElement attaches each element into recycle view
     */
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        TextView death;
        TextView cases;
        TextView casesToday;
        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            setControl(itemView);
        }

        private void setControl(View itemView)
        {
            name = itemView.findViewById(R.id.provinceElementName);
            death = itemView.findViewById(R.id.provinceElementDeath);
            cases = itemView.findViewById(R.id.provinceElementCases);
            casesToday = itemView.findViewById(R.id.provinceElementCasesToday);
            parentLayout = itemView.findViewById(R.id.provinceParentLayout);
        }
    }
}
