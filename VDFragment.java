/*
 * Copyright (c) 2021.  Foysaldev Development Studios
 */

package com.Himal.Browser.model;

import androidx.fragment.app.Fragment;

import com.Himal.Browser.VDApp;
import com.Himal.Browser.activity.MainActivity;

public class VDFragment extends Fragment {

    public MainActivity getVDActivity() {
        return (MainActivity) getActivity();
    }

    public VDApp getVDApp() {
        return (VDApp) getActivity().getApplication();
    }
}
