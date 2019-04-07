package com.example.ownapitest

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fr_login.*
import retrofit2.Call
import retrofit2.Response

class LoginFragment : Fragment() {

    companion object {
        public fun newInstance(): LoginFragment {
            return LoginFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_login,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btn_sign_in.setOnClickListener {
            v->
            run {
                NetworkService.getInstance()
                        .networkApi.login(User(et_email.text.toString(),et_password.text.toString()))
                        .enqueue(object :retrofit2.Callback<User>{
                            override fun onFailure(call: Call<User>, t: Throwable) {
                               Toast.makeText(context,t.localizedMessage,Toast.LENGTH_LONG).show()
                            }
                            override fun onResponse(call: Call<User>, response: Response<User>) {
                                Toast.makeText(context,response.body().toString(),Toast.LENGTH_LONG).show()
                                (activity!!.applicationContext as
                                        ApplicationSingleton).setCurrentUser(response.body())
                                val intent = Intent(context, MainActivity::class.java)
                                startActivity(intent)
                            }
                        })
            }
        }
        btn_sign_up.setOnClickListener { v ->
            run {
                LoginActivity.changeFragment(RegistrationFragment.newInstance())
            }
        }
    }
}
