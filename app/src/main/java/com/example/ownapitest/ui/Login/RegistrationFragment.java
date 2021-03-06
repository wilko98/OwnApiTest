package com.example.ownapitest.ui.Login;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ownapitest.ApplicationSingleton;
import com.example.ownapitest.Model.User;
import com.example.ownapitest.Network.NetworkService;
import com.example.ownapitest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationFragment extends Fragment {

    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private Button mButton;
    private TextView mSecondPassword;

    public static RegistrationFragment newInstance() {
        Bundle args = new Bundle();
        RegistrationFragment fragment = new RegistrationFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fr_registration,container,false);
        mName = v.findViewById(R.id.et_name);
        mEmail = v.findViewById(R.id.et_email);
        mPassword = v.findViewById(R.id.et_password);
        mSecondPassword = v.findViewById(R.id.et_password_again);
        mButton = v.findViewById(R.id.btn_sign_in);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mName.getText())){
                    mName.setError("Name is empty");
                }
                else if (TextUtils.isEmpty(mEmail.getText())){
                    mEmail.setError("Email is empty");
                }
                else if (TextUtils.isEmpty(mPassword.getText())){
                    mPassword.setError("Password is empty");
                }
                else if(mPassword.getText().length()<8){
                    mPassword.setError("Password should be at least 8 characters long");
                }
                else if(!TextUtils.equals(mPassword.getText(),mSecondPassword.getText())){
                    mSecondPassword.setError("Passwords are not the same");
                } else {
                    User cu = new User(mEmail.getText().toString(), mName.getText().toString(), mPassword.getText().toString());
                    LoginActivity.changeFragment(LoginFragment.Companion.newInstance(cu));
                }
            }
        });
    }


}
