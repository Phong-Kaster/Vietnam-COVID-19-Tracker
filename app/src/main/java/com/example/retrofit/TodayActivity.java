package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofit.Helper.Helper;
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

    /**
     * @author Phong-Kaster
     * set up id with matched components
     * */
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

    /**
     * @author Phong-Kaster
     * send HTTP Request to API
     * */
    private void establish() {
        viewModel = new ViewModelProvider(this).get(TodayViewModel.class);

        viewModel.instanciate();

        viewModel.getToday().observe(this, new Observer<Today>() {
            @Override
            public void onChanged(Today today) {

                /** VIETNAM **/
                String internalDeaths = Helper.formatCardNumber( today.getInternal().getDeath() );
                String internalTreatings = Helper.formatCardNumber( today.getInternal().getTreating() );
                String internalCasess = Helper.formatCardNumber(today.getInternal().getCases() );
                String internalRecovereds = Helper.formatCardNumber( today.getInternal().getRecovered() );


                internalDeath.setText( internalDeaths  );
                internalTreating.setText( internalTreatings );
                internalCases.setText( internalCasess );
                internalRecovered.setText( internalRecovereds );

                /** WORLDWIDE**/
                String worldwideDeaths = Helper.formatCardNumber(today.getWorldwide().getDeath() );
                String worldwideTreatings = Helper.formatCardNumber( today.getWorldwide().getTreating() );
                String worldwideCasess =Helper.formatCardNumber(today.getWorldwide().getCases() );
                String worldwideRecovereds = Helper.formatCardNumber(today.getWorldwide().getRecovered() );


                worldwideDeath.setText( worldwideDeaths  );
                worldwideTreating.setText( worldwideTreatings );
                worldwideCases.setText( worldwideCasess );
                worldwideRecovered.setText( worldwideRecovereds );
            }
        });
    }
}