package com.housemate.android;

import android.app.Activity;
import android.os.Bundle;
import com.bonsai.android.R;

public class HousemateActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}