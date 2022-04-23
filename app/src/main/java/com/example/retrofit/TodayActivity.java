package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit.Model.Today;
import com.example.retrofit.ViewModel.TodayViewModel;

public class TodayActivity extends AppCompatActivity {

    TodayViewModel viewModel;
    TextView internalDeath, internalTreating, internalCases, internalRecovered;
    TextView worldwideDeath, worldwideTreating, worldwideCases, worldwideRecovered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        establishControl();
        establish();
    }

    private void establishControl() {
        internalDeath = findViewById(R.id.todayInternalDeath);
        internalTreating = findViewById(R.id.todayInternalTreating);
        internalCases = findViewById(R.id.todayInternalCases);
        internalRecovered = findViewById(R.id.todayInternalRecovered);

        worldwideDeath = findViewById(R.id.todayWorldwideDeath);
        worldwideTreating = findViewById(R.id.todayWorldwideTreating);
        worldwideCases = findViewById(R.id.todayWorldwideCases);
        worldwideRecovered = findViewById(R.id.todayWorldwideRecovered);
    }

    private void establish() {
        viewModel = new ViewModelProvider(this).get(TodayViewModel.class);

        viewModel.instanciate();

        viewModel.getToday().observe(this, new Observer<Today>() {
            @Override
            public void onChanged(Today today) {

                /** VIETNAM **/
                String internalDeaths = String.valueOf( today.getInternal().getDeath() );
                String internalTreatings = String.valueOf( today.getInternal().getTreating() );
                String internalCasess = String.valueOf( today.getInternal().getCases() );
                String internalRecovereds = String.valueOf( today.getInternal().getRecovered() );


                internalDeath.setText( internalDeaths  );
                internalTreating.setText( internalTreatings );
                internalCases.setText( internalCasess );
                internalRecovered.setText( internalRecovereds );

                /** WORLDWIDE**/
                String worldwideDeaths = String.valueOf( today.getWorldwide().getDeath() );
                String worldwideTreatings = String.valueOf( today.getWorldwide().getTreating() );
                String worldwideCasess = String.valueOf( today.getWorldwide().getCases() );
                String worldwideRecovereds = String.valueOf( today.getWorldwide().getRecovered() );


                worldwideDeath.setText( worldwideDeaths  );
                worldwideTreating.setText( worldwideTreatings );
                worldwideCases.setText( worldwideCasess );
                worldwideRecovered.setText( worldwideRecovereds );
            }
        });
    }
}