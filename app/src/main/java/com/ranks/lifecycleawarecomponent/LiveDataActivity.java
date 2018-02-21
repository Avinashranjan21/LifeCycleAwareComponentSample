package com.ranks.lifecycleawarecomponent;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.ranks.lifecycleawarecomponent.live_data.LiveDataTimerViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveDataActivity extends AppCompatActivity {

    @BindView(R.id.tv_timer_text)
    TextView tvTimerText;

    private LiveDataTimerViewModel liveDataTimerViewModel;
    private static final String TAG = "LiveDataActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        ButterKnife.bind(this);
        liveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);
        subscribeElapsedTimeObserver();
    }

    private final Observer<Long> elapsedTimeObserver = newValue -> {
        displayTimerValue(String.valueOf(newValue) + " Seconds");
    };

    private void subscribeElapsedTimeObserver() {
        liveDataTimerViewModel.getElapsedTime().observe(this, elapsedTimeObserver);
    }

    private void displayTimerValue(String value) {
        tvTimerText.setText(String.valueOf(value));
    }
}
