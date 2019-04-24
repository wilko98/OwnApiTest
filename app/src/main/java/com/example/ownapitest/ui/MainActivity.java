package com.example.ownapitest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toolbar;

import com.example.ownapitest.R;
import com.example.ownapitest.ui.Profile.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    private static FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        fm = getSupportFragmentManager();
        changeFragment(ProfileFragment.newInstance());
    }

    public static void changeFragment(Fragment fragment) {
        fm.beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in,
                        R.anim.design_bottom_sheet_slide_out)
                .add(R.id.container, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

}
