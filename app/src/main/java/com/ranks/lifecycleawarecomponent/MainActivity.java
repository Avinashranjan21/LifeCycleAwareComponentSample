package com.ranks.lifecycleawarecomponent;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ranks.lifecycleawarecomponent.lca_component.MyComponent;
import com.ranks.lifecycleawarecomponent.view_model.MyViewModel;

public class MainActivity extends AppCompatActivity {

    private MyComponent mMyComponent;
    private TextView tvHelloWorld;
    private Button btnSecondActivity;
    private MyViewModel mMyViewModel;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvHelloWorld = findViewById(R.id.tv_hello_world);
        btnSecondActivity = findViewById(R.id.btn_secondActivity);
        mMyComponent = new MyComponent(this);
        mMyComponent.getCurrentStateOfLifeCycleComponent();

//        Old way to get data from model
       /* mMyViewModel = new MyViewModel();
        Log.d(TAG, "onCreate: " + mMyViewModel.getCurrentTime());
        tvHelloWorld.setText(mMyViewModel.getCurrentTime());*/


//        using View model library
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getCurrentTime(false).observe(this, time -> tvHelloWorld.setText(time));

        btnSecondActivity.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,SecondActivity.class)));

    }
}
