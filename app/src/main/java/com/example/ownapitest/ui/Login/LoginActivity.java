package com.example.ownapitest.ui.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.ownapitest.R;

public class LoginActivity extends AppCompatActivity {

    private static FragmentManager fm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_container);
        fm = getSupportFragmentManager();
        if (savedInstanceState == null) {
            fm.beginTransaction()
                    .add(R.id.container, InitFragment.Companion.newInstance())
                    .commit();
        }

    }

    public static void changeFragment(Fragment fragment) {
        fm.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_left,0,0, R.anim.slide_out_right)
                .replace(R.id.container, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }
}
