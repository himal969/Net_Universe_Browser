/*
 * Copyright (c) 2021.  Foysaldev Development Studios
 */

package com.Himal.Browser.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.Himal.Browser.R;
import com.Himal.Browser.model.VDFragment;

public class Settings extends VDFragment implements MainActivity.OnBackPressedListener, View.OnClickListener {
    private View view;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);

        if (view == null) {
            view = inflater.inflate(R.layout.settings, container, false);

            getVDActivity().setOnBackPressedListener(this);
            final SharedPreferences prefs = getActivity().getSharedPreferences("settings", 0);

            //Back
            ImageView btnSettingsBack = view.findViewById(R.id.btn_settings_back);
            btnSettingsBack.setOnClickListener(this);

            // Switch vibrate switch
            Switch vibrateSwitch = view.findViewById(R.id.vibrateSwitch);
            boolean vibrateON = prefs.getBoolean(getString(R.string.vibrateON), true);
            vibrateSwitch.setChecked(vibrateON);
            vibrateSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    prefs.edit().putBoolean(getString(R.string.vibrateON), isChecked).commit();
                }
            });

            // Switch sound switch
            Switch soundSwitch = view.findViewById(R.id.soundSwitch);
            boolean soundON = prefs.getBoolean(getString(R.string.soundON), true);
            soundSwitch.setChecked(soundON);
            soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    prefs.edit().putBoolean(getString(R.string.soundON), isChecked).commit();
                }
            });

            // Switch ad blocker switch
            Switch adBlockerSwitch = view.findViewById(R.id.adBlockerSwitch);
            boolean adBlockOn = prefs.getBoolean(getString(R.string.adBlockON), true);
            adBlockerSwitch.setChecked(adBlockOn);
            adBlockerSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    prefs.edit().putBoolean(getString(R.string.adBlockON), isChecked).commit();
                }
            });

            view.findViewById(R.id.history).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getVDActivity(), HistoryActivity.class);
                    startActivity(intent);
                }
            });

            //Rate app
            TextView btnRateApp = view.findViewById(R.id.rateApp);
            btnRateApp.setOnClickListener(this);

            //Share app
            TextView btnShareApp = view.findViewById(R.id.shareApp);
            btnShareApp.setOnClickListener(this);

            //More app
            TextView btnMoreApp = view.findViewById(R.id.moreApp);
            btnMoreApp.setOnClickListener(this);

            //Privacy Policy
            TextView btnPrivacyPolicy = view.findViewById(R.id.privacyPolicy);
            btnPrivacyPolicy.setOnClickListener(this);

        }
        return view;
    }

    @Override
    public void onBackpressed() {
        getVDActivity().getBrowserManager().unhideCurrentWindow();
        getFragmentManager().beginTransaction().remove(this).commit();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_settings_back:
                getActivity().onBackPressed();
                break;

            case R.id.moreApp:
                Toast.makeText(getContext(), "Nothing yet", Toast.LENGTH_SHORT).show();
                break;
            case R.id.privacyPolicy:
                privacyPolicyClicked();
                break;
            default:
                break;
        }
    }

    private void privacyPolicyClicked(){
        Toast.makeText(getContext(), "Nothing yet", Toast.LENGTH_SHORT).show();
    }






}
