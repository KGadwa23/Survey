//by Katrina Gadwa x

package com.katrina.survey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SurveyActivity extends AppCompatActivity {

    private static final String CHRISTMAS_INDEX = "Christmas index";        //for keeping track of votes when rotating
    private static final String THANKSGIVING_INDEX = "Thanksgiving index";

    Button mChristmas;              //List of all buttons and textview boxes
    Button mThanksgiving;
    Button mResults;
    Button mReset;
    TextView mChristmasOutcome;
    TextView mThanksgivingOutcome;

    private int mChristmasStartOutcome = 0;     //starting value of zero for total counts
    private int mThanksgivingStartOutcome = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        mChristmas = (Button) findViewById(R.id.christmasButton);
        mThanksgiving = (Button) findViewById(R.id.thanksgivingButton);
        mResults = (Button) findViewById(R.id.resultsButton);
        mReset = (Button) findViewById(R.id.resetButton);
        mChristmasOutcome = (TextView) findViewById(R.id.christmasOutcome);
        mThanksgivingOutcome = (TextView) findViewById(R.id.thanksgivingOutcome);

        mChristmas.setOnClickListener(new View.OnClickListener() {      //when Christmas button is clicked, Christmas outcome is increased by 1
            @Override
            public void onClick (View v) {
                mChristmasStartOutcome += 1;
            }
        });
        mThanksgiving.setOnClickListener(new View.OnClickListener() {   //When THanksgiving button is clicked, Thanksgiving outcome is increased by 1
            @Override
            public void onClick (View v) {mThanksgivingStartOutcome += 1;
            }
        });

        mResults.setOnClickListener(new View.OnClickListener() {    //when Results button is clicked, the accumulated Christmas and Thanksgiving outcomes are shown on the screen
            @Override
            public void onClick (View v) {
                mChristmasOutcome.setText("Christmas: " + String.valueOf(mChristmasStartOutcome) + "        ");
                mThanksgivingOutcome.setText("Thanksgiving: " + String.valueOf(mThanksgivingStartOutcome));
            }
        });

        mReset.setOnClickListener(new View.OnClickListener() {      //When reset button is clicked, the accumulated Christmas and Thanksgiving outcomes return to zero and the new outcomes (zero) are shown on the screen
            @Override
            public void onClick (View v) {
                mChristmasStartOutcome = 0;
                mThanksgivingStartOutcome = 0;
                mChristmasOutcome.setText("Christmas: " + String.valueOf(mChristmasStartOutcome) + "        ");
                mThanksgivingOutcome.setText("Thanksgiving: " + String.valueOf(mThanksgivingStartOutcome));
            }
        });

        if (savedInstanceState != null) {       //for keeping track of votes when rotating
            mChristmasStartOutcome = savedInstanceState.getInt(CHRISTMAS_INDEX, 0);
            mThanksgivingStartOutcome = savedInstanceState.getInt(THANKSGIVING_INDEX, 0);
        }
    }

    @Override       //for keeping track of votes when rotating
    public void onSaveInstanceState (Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(CHRISTMAS_INDEX, mChristmasStartOutcome);
        savedInstanceState.putInt(THANKSGIVING_INDEX, mThanksgivingStartOutcome);
    }
}