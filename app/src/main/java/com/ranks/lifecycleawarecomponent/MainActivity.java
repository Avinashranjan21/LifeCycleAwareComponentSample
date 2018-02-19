package com.ranks.lifecycleawarecomponent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ranks.lifecycleawarecomponent.lca_component.MyComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyComponent(this);
    }
}
