package com.ranks.lifecycleawarecomponent;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ranks.lifecycleawarecomponent.lca_component.MyComponent;
import com.ranks.lifecycleawarecomponent.view_model.MyViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_hello_world)
    TextView tvHelloWorld;
    @BindView(R.id.btn_view_model)
    Button btnViewModel;
    @BindView(R.id.btn_live_data)
    Button btnLiveData;
    @BindView(R.id.btn_room_activity)
    Button btnRoomActivity;
    private MyComponent mMyComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMyComponent = new MyComponent(this);
        mMyComponent.getCurrentStateOfLifeCycleComponent();

//        Old way to get data from model
       /* mMyViewModel = new MyViewModel();
        Log.d(TAG, "onCreate: " + mMyViewModel.getCurrentTime());
        tvHelloWorld.setText(mMyViewModel.getCurrentTime());*/

//        using View model library
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        tvHelloWorld.setText(viewModel.getCurrentTime());
    }

    @OnClick({R.id.btn_view_model, R.id.btn_live_data,R.id.btn_room_activity})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_view_model:
                startActivity(new Intent(MainActivity.this, ViewModelActivity.class));
                break;
            case R.id.btn_live_data:
                startActivity(new Intent(MainActivity.this, LiveDataActivity.class));
                break;
            case R.id.btn_room_activity:
                startActivity(new Intent(MainActivity.this, RoomActivity.class));
                break;
        }
    }
}
