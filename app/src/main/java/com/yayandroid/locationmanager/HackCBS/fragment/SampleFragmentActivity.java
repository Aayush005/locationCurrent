package com.yayandroid.locationmanager.HackCBS.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yayandroid.locationmanager.HackCBS.R;

public class SampleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_fragment);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dispatchToFragment(requestCode, resultCode, data);
    }

    /**
     * This is required because GooglePlayServicesApi and SettingsApi requires Activity,
     * and they call startActivityForResult from the activity, not fragment,
     * fragment doesn't receive onActivityResult callback. We need to call/redirect manually.
     */
    private void dispatchToFragment(int requestCode, int resultCode, Intent data) {
        SampleFragment sampleFragment = (SampleFragment) getSupportFragmentManager()
              .findFragmentById(R.id.sample_fragment);
        if (sampleFragment != null) {
            sampleFragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
