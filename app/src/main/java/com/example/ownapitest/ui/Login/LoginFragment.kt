package com.example.ownapitest.ui.Login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.ownapitest.ApplicationSingleton
import com.example.ownapitest.ui.MainActivity
import com.example.ownapitest.Model.User
import com.example.ownapitest.Network.NetworkService
import com.example.ownapitest.R
import kotlinx.android.synthetic.main.fr_login.*
import kotlinx.android.synthetic.main.fr_sign_in.*
import retrofit2.Call
import retrofit2.Response

class LoginFragment : Fragment() {

    lateinit var incompleteUser:User


    companion object {
        fun newInstance(user: User): LoginFragment {
            val fragment = LoginFragment()
            fragment.incompleteUser = user
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v:View = inflater.inflate(R.layout.fr_login,container,false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        et_login.setText(incompleteUser.email)
        et_login.requestFocus()
        btn_sign_up.setOnClickListener { v ->
            run {
                incompleteUser.login = et_login.text.toString()
                NetworkService.getInstance()
                        .networkApi
                        .registration(incompleteUser)
                        .enqueue(object : retrofit2.Callback<User> {
                            override fun onResponse(call: Call<User>, response: Response<User>) {
                                Toast.makeText(context, response.body().toString(), Toast.LENGTH_LONG).show()
                                (activity!!.applicationContext as
                                        ApplicationSingleton).setCurrentUser(response.body())
                                val intent = Intent(context, MainActivity::class.java)
                                startActivity(intent)
                            }
                            override fun onFailure(call: Call<User>, t: Throwable) {
                                Toast.makeText(context, t.localizedMessage, Toast.LENGTH_LONG).show()
                            }
                        })
            }
        }

    }

}