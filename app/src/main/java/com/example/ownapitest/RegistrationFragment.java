package com.example.ownapitest;

import android.content.Intent;
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
                    mPassword.setError("Password shod be at least 8 characters long");
                }
                else if(!TextUtils.equals(mPassword.getText(),mSecondPassword.getText())){
                    mSecondPassword.setError("Passwords are not the same");
                } else {
                    registrateUser(new User(mEmail.getText().toString(), mName.getText().toString(), mPassword.getText().toString()));
                }
            }
        });
    }


    private void registrateUser(User user) {
        NetworkService.getInstance()
                .getNetworkApi()
                .registration(user)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Toast.makeText(getActivity(), response.body().toString(), Toast.LENGTH_SHORT).show();
                        ((ApplicationSingleton)getActivity().getApplicationContext()).setCurrentUser(response.body());
                        User cu = response.body();
                        Toast.makeText(getActivity(), cu.toString(), Toast.LENGTH_SHORT).show();
                        ((ApplicationSingleton)getActivity().getApplicationContext()).setCurrentUser(cu);
                        Intent intent = new Intent(getActivity(),MainActivity.class);
                        startActivity(intent);

                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(getActivity(), "Fail: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
