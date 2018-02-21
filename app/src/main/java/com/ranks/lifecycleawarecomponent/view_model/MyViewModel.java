package com.ranks.lifecycleawarecomponent.view_model;

import android.arch.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private String currentTime;

    public String getCurrentTime() {

        if (currentTime == null) {
            currentTime=fetchCurrentTime();
        }
        return currentTime;
    }

    private String fetchCurrentTime() {
        return String.valueOf(System.currentTimeMillis());
    }

}
