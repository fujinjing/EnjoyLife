package com.shmily.fujinjing.enjoylife.presentation.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fujinjing on 2017/10/31.
 * 所有activity的基类
 */

public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        onCreatePresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 用于实现presenter接口
     */
    public abstract void onCreatePresenter();
}
