package com.ranks.lifecycleawarecomponent;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ranks.lifecycleawarecomponent.view_model.FragmentA;
import com.ranks.lifecycleawarecomponent.view_model.FragmentB;
import com.ranks.lifecycleawarecomponent.view_model.MyViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewModelActivity extends AppCompatActivity {


    @BindView(R.id.btn_fragment_A)
    Button btnFragmentA;
    @BindView(R.id.btn_fragment_B)
    Button btnFragmentB;
    @BindView(R.id.fl_fragment_Container)
    FrameLayout flFragmentContainer;
    @BindView(R.id.tv_result)
    TextView tvResult;
    private FragmentTransaction transaction;
    private static final String TAG = "ViewModelActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        tvResult.setText(viewModel.getCurrentTime());
    }

    @OnClick({R.id.btn_fragment_A, R.id.btn_fragment_B})
    public void onViewClicked(View view) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.btn_fragment_A:
                transaction.replace(R.id.fl_fragment_Container, FragmentA.newInstance());
                break;
            case R.id.btn_fragment_B:
                transaction.replace(R.id.fl_fragment_Container, FragmentB.newInstance());
                break;
        }
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }
}
