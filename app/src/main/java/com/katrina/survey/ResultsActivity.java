package com.katrina.survey;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ResultsActivity extends AppCompatActivity {

    private static final String CHRISTMAS_RESULT = "com.katrina.surveyactivity.christmasresult";
    private static final String THANKSGIVING_RESULT = "com.katrina.surveyactivity.thanksgivingresult";

    private int mChristmasResult;
    private int mThanksgivingResult;

    public static Intent newIntent(Context packageContext, int christmasResults, int thanksgivingResults) {
        Intent i = new Intent(packageContext, ResultsActivity.class);
        i.putExtra(CHRISTMAS_RESULT, christmasResults);
        i.putExtra(THANKSGIVING_RESULT, thanksgivingResults);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mChristmasResult = getIntent().getIntExtra(CHRISTMAS_RESULT, 0);
        mThanksgivingResult = getIntent().getIntExtra(THANKSGIVING_RESULT, 0);
    }
}
