package com.example.ownapitest.ui.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ownapitest.ApplicationSingleton;
import com.example.ownapitest.Model.User;
import com.example.ownapitest.R;
import com.example.ownapitest.ui.MainActivity;

public class ProfileFragment extends Fragment {

    private TextView profileName;
    private TextView profileEmail;
    private Button settingsBtn;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fr_profile,container,false);
        profileName = v.findViewById(R.id.user_name);
        profileEmail = v.findViewById(R.id.user_email);
        settingsBtn = v.findViewById(R.id.btn_settings);

        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        User user = ((ApplicationSingleton)getActivity().getApplicationContext()).getCurrentUser();
        profileName.setText("Name: "+user.getName());
        profileEmail.setText("Email: "+user.getEmail());
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.changeFragment(SettingsFragment.Companion.newInstanse());
            }
        });

//        settingsBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
    }
}
