package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit.Model.Today;
import com.example.retrofit.Model.Total;
import com.example.retrofit.ViewModel.TodayViewModel;
import com.example.retrofit.ViewModel.TotalViewModel;

public class TotalActivity extends AppCompatActivity {

    TotalViewModel viewModel;
    TextView internalDeath, internalTreating, internalCases, internalRecovered;
    TextView worldwideDeath, worldwideTreating, worldwideCases, worldwideRecovered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        establishControl();
        establish();
    }

    private void establishControl() {
        internalDeath = findViewById(R.id.totalInternalDeath);
        internalTreating = findViewById(R.id.totalInternalTreating);
        internalCases = findViewById(R.id.totalInternalCases);
        internalRecovered = findViewById(R.id.totalInternalRecovered);

        worldwideDeath = findViewById(R.id.totalWorldwideDeath);
        worldwideTreating = findViewById(R.id.totalWorldwideTreating);
        worldwideCases = findViewById(R.id.totalWorldwideCases);
        worldwideRecovered = findViewById(R.id.totalWorldwideRecovered);
    }

    private void establish() {
        viewModel = new ViewModelProvider(this).get(TotalViewModel.class);

        viewModel.instanciate();

        viewModel.getTotal().observe(this, new Observer<Total>() {
            @Override
            public void onChanged(Total total) {

                /** VIETNAM **/
                String internalDeaths = String.valueOf(total.getInternal().getDeath());
                String internalTreatings = String.valueOf(total.getInternal().getTreating());
                String internalCasess = String.valueOf(total.getInternal().getCases());
                String internalRecovereds = String.valueOf(total.getInternal().getRecovered());


                internalDeath.setText(internalDeaths);
                internalTreating.setText(internalTreatings);
                internalCases.setText(internalCasess);
                internalRecovered.setText(internalRecovereds);

                /** WORLDWIDE**/
                String worldwideDeaths = String.valueOf(total.getWorldwide().getDeath());
                String worldwideTreatings = String.valueOf(total.getWorldwide().getTreating());
                String worldwideCasess = String.valueOf(total.getWorldwide().getCases());
                String worldwideRecovereds = String.valueOf(total.getWorldwide().getRecovered());


                worldwideDeath.setText(worldwideDeaths);
                worldwideTreating.setText(worldwideTreatings);
                worldwideCases.setText(worldwideCasess);
                worldwideRecovered.setText(worldwideRecovereds);
            }
        });
    }
}