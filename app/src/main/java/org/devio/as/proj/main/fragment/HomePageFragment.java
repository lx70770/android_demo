package org.devio.as.proj.main.fragment;/*
 * @Author: lixiang16@corp.netease.com
 * @Date: 2021/2/22
 * @FilePath: org.devio.as.proj.main.fragment
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;

import org.devio.as.proj.common.ui.component.HiBaseFragment;
import org.devio.as.proj.main.R;
import org.devio.as.proj.main.demo.HiTabTopDemoActivity;

public class HomePageFragment extends HiBaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        layoutView.findViewById(R.id.button_profile).setOnClickListener(v -> {
            navigation("/profile/detail");
        });

        layoutView.findViewById(R.id.button_vip).setOnClickListener(v -> {
            navigation("/profile/vip");
        });

        layoutView.findViewById(R.id.button_user).setOnClickListener(v -> {
            navigation("/profile/authentication");
        });

        layoutView.findViewById(R.id.button_error).setOnClickListener(v -> {
            navigation("/profile/unknow");
        });
    }

    private void navigation(String s) {
        ARouter.getInstance().build(s).navigation(getContext());
    }
}
