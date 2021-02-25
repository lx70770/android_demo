package org.devio.as.proj.main;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

import org.devio.as.proj.common.ui.component.HiBaseActivity;
import org.devio.as.proj.main.logic.MainActivityLogic;
import org.devio.as.ui.tab.top.HiTabTopInfo;
import org.devio.as.ui.tab.top.HiTabTopLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends HiBaseActivity implements MainActivityLogic.ActivityProvider {

    private MainActivityLogic activityLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityLogic = new MainActivityLogic(this, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        activityLogic.onSaveInstanceState(outState);
    }


}