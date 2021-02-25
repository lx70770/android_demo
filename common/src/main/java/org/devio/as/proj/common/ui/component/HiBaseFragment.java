package org.devio.as.proj.common.ui.component;/*
 * @Author: lixiang16@corp.netease.com
 * @Date: 2021/2/22
 * @FilePath: org.devio.as.proj.common.ui.component
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class HiBaseFragment extends Fragment {
    protected View layoutView;

    public abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutView = inflater.inflate(getLayoutId(), container, false);
        return layoutView;
    }
}
