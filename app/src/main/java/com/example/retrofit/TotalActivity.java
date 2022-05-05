package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit.Helper.Helper;
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

    /**
     * @author Phong-Kaster
     * set up id with matched components
     * */
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

    /**
     * @author Phong-Kaster
     * send HTTP Request to API
     * */
    private void establish() {
        viewModel = new ViewModelProvider(this).get(TotalViewModel.class);

        viewModel.instanciate();

        viewModel.getTotal().observe(this, new Observer<Total>() {
            @Override
            public void onChanged(Total total) {

                /** VIETNAM **/
                String internalDeaths = Helper.formatCardNumber(total.getInternal().getDeath());
                String internalTreatings = Helper.formatCardNumber(total.getInternal().getTreating());
                String internalCasess = Helper.formatCardNumber(total.getInternal().getCases());
                String internalRecovereds = Helper.formatCardNumber(total.getInternal().getRecovered());


                internalDeath.setText(internalDeaths);
                internalTreating.setText(internalTreatings);
                internalCases.setText(internalCasess);
                internalRecovered.setText(internalRecovereds);

                /** WORLDWIDE**/
                String worldwideDeaths = Helper.formatCardNumber(total.getWorldwide().getDeath());
                String worldwideTreatings = Helper.formatCardNumber(total.getWorldwide().getTreating());
                String worldwideCasess = Helper.formatCardNumber(total.getWorldwide().getCases());
                String worldwideRecovereds = Helper.formatCardNumber(total.getWorldwide().getRecovered());


                worldwideDeath.setText(worldwideDeaths);
                worldwideTreating.setText(worldwideTreatings);
                worldwideCases.setText(worldwideCasess);
                worldwideRecovered.setText(worldwideRecovereds);
            }
        });
    }
}