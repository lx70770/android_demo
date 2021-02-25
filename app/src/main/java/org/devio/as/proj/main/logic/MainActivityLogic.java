package org.devio.as.proj.main.logic;/*
 * @Author: lixiang16@corp.netease.com
 * @Date: 2021/2/22
 * @FilePath: org.devio.as.proj.main.logic
 */

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import org.devio.as.proj.common.tab.HiFragmentTabView;
import org.devio.as.proj.common.tab.HiTabViewAdapter;
import org.devio.as.proj.main.MainActivity;
import org.devio.as.proj.main.R;
import org.devio.as.proj.main.fragment.CategoryFragment;
import org.devio.as.proj.main.fragment.FavoriteFragment;
import org.devio.as.proj.main.fragment.HomePageFragment;
import org.devio.as.proj.main.fragment.ProfileFragment;
import org.devio.as.proj.main.fragment.RecommendFragment;
import org.devio.as.ui.tab.bottom.HiTabBottomInfo;
import org.devio.as.ui.tab.bottom.HiTabBottomLayout;
import org.devio.as.ui.tab.common.IHiTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivityLogic {
    public static final String SAVED_CURRENT_ID = "SAVED_CURRENT_ID";

    private HiFragmentTabView fragmentTabView;
    private HiTabBottomLayout hiTabBottomLayout;
    private List<HiTabBottomInfo<?>> infoList;
    private ActivityProvider activityProvider;
    private int currentItemIndex;

    public MainActivityLogic(ActivityProvider activityProvider, Bundle savedInstanceState) {
        this.activityProvider = activityProvider;
        if (savedInstanceState != null) {
            // 解决开启不保留活动导致fragment重叠的问题
            currentItemIndex = savedInstanceState.getInt(SAVED_CURRENT_ID);
        }
        initTabBottom();
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SAVED_CURRENT_ID, currentItemIndex);
    }

    public HiFragmentTabView getFragmentTabView() {
        return fragmentTabView;
    }

    public HiTabBottomLayout getHiTabBottomLayout() {
        return hiTabBottomLayout;
    }

    public List<HiTabBottomInfo<?>> getInfoList() {
        return infoList;
    }

    private void initTabBottom() {
        hiTabBottomLayout = activityProvider.findViewById(R.id.tab_bottom_layout);
        hiTabBottomLayout.setBottomAlpha(0.85f);
        infoList = new ArrayList<>();
        int defaultColor = ContextCompat.getColor(activityProvider.getApplicationContext(), R.color.tabBottomDefaultColor);
        int tintColor = ContextCompat.getColor(activityProvider.getApplicationContext(), R.color.tabBottomTintColor);
        HiTabBottomInfo homeInfo = new HiTabBottomInfo<Integer>(
                "首页",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_home),
                null,
                defaultColor,
                tintColor
        );
        homeInfo.fragment = HomePageFragment.class;
        HiTabBottomInfo infoFavorite = new HiTabBottomInfo<Integer>(
                "收藏",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_favorite),
                null,
                defaultColor,
                tintColor
        );
        infoFavorite.fragment = FavoriteFragment.class;
        HiTabBottomInfo infoCategory = new HiTabBottomInfo<Integer>(
                "分类",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_category),
                null,
                defaultColor,
                tintColor
        );
        infoCategory.fragment = CategoryFragment.class;
        HiTabBottomInfo infoRecommend = new HiTabBottomInfo<Integer>(
                "推荐",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_recommend),
                null,
                defaultColor,
                tintColor
        );
        infoRecommend.fragment = RecommendFragment.class;
        HiTabBottomInfo infoProfile = new HiTabBottomInfo<Integer>(
                "我的",
                "fonts/iconfont.ttf",
                activityProvider.getString(R.string.if_profile),
                null,
                defaultColor,
                tintColor
        );
        infoProfile.fragment = ProfileFragment.class;
        infoList.add(homeInfo);
        infoList.add(infoFavorite);
        infoList.add(infoCategory);
        infoList.add(infoRecommend);
        infoList.add(infoProfile);
        hiTabBottomLayout.inflateInfo(infoList);
        initFragmentTabView();
        hiTabBottomLayout.addTabSelectedChangeListener((index, prevInfo, nextInfo) -> {
            fragmentTabView.setCurrentItem(index);
            MainActivityLogic.this.currentItemIndex = index;
        });
        hiTabBottomLayout.defaultSelected(infoList.get(currentItemIndex));
    }

    private void initFragmentTabView() {
        HiTabViewAdapter hiTabViewAdapter = new HiTabViewAdapter(activityProvider.getSupportFragmentManager(), infoList);
        fragmentTabView = activityProvider.findViewById(R.id.fragment_tab_view);
        fragmentTabView.setAdapter(hiTabViewAdapter);
    }

    public interface ActivityProvider {
        <T extends View> T findViewById(@IdRes int id);

        Resources getResources();

        Context getApplicationContext();

        FragmentManager getSupportFragmentManager();

        String getString(@StringRes int resId);
    }
}

