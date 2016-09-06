package com.katrina.survey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SurveyActivity extends AppCompatActivity {

    Button mChristmas;
    Button mThanksgiving;
    TextView mChristmasOutcome;
    TextView mThanksgivingOutcome;

    private int mChristmasStartOutcome = 0;
    private int mThanksgivingStartOutcome = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        mChristmas = (Button) findViewById(R.id.christmasButton);
        mThanksgiving = (Button) findViewById(R.id.thanksgivingButton);
        mChristmasOutcome = (TextView) findViewById(R.id.christmasOutcome);
        mThanksgivingOutcome = (TextView) findViewById(R.id.thanksgivingOutcome);

        mChristmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                mChristmasStartOutcome =+ 1;
            }
        });

        mThanksgiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                mThanksgivingStartOutcome += 1;
            }
        });
    }

    private void updateOutcomes() {
        mChristmasOutcome.setText(mChristmasStartOutcome);
        mThanksgivingOutcome.setText(mThanksgivingStartOutcome);
    }
}
