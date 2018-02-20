package com.ranks.lifecycleawarecomponent.view_model;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ranks.lifecycleawarecomponent.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class FragmentA extends Fragment {

    @BindView(R.id.tv_result_a)
    TextView tvResultA;
    Unbinder unbinder;
    @BindView(R.id.btn_reset)
    Button btnReset;

    public FragmentA() {
        // Required empty public constructor
    }

    public static FragmentA newInstance() {
        FragmentA fragment = new FragmentA();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MyViewModel viewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        viewModel.getCurrentTime(false).observe(getActivity(), time -> tvResultA.setText(time));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_reset)
    public void onViewClicked() {
        MyViewModel viewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        viewModel.getCurrentTime(true);
    }
}
