package com.ranks.lifecycleawarecomponent.lca_component;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MyComponent implements LifecycleObserver {
    private static final String TAG = "MyComponent";

    private Context mContext;

    public MyComponent(Context mContext) {
        this.mContext = mContext;
        ((AppCompatActivity) this.mContext).getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreateComponent() {
        Log.d(TAG, "onCreateComponent: is called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStartComponent() {
        Log.d(TAG, "onStartComponent: is called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResumeComponent() {
        Log.d(TAG, "onResumeComponent: is called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPauseComponent() {
        Log.d(TAG, "onPauseComponent: is called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStopComponent() {
        Log.d(TAG, "onStopComponent: is called");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyComponent() {
        Log.d(TAG, "onDestroyComponent: is called");
//        Always remove the observer associated with the component
        ((AppCompatActivity) this.mContext).getLifecycle().removeObserver(this);
    }

//    This is used to know the current state of the app
    public void getCurrentStateOfLifeCycleComponent(){
        Lifecycle.State currentState = ((AppCompatActivity) this.mContext).getLifecycle().getCurrentState();
        Log.d(TAG, "getCurrentStateOfLifeCycleComponent: "+ currentState);
    }


}
