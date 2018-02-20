package com.ranks.lifecycleawarecomponent.view_model;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> currentTime;

    public MutableLiveData<String> getCurrentTime(boolean forceUpdate) {

        if (currentTime == null || forceUpdate) {
            currentTime = new MutableLiveData<>();
            currentTime.setValue(fetchCurrentTime());
        }
        return currentTime;
    }

    private String fetchCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }

}
