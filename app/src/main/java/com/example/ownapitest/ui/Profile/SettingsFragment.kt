package com.example.ownapitest.ui.Profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ownapitest.ApplicationSingleton
import com.example.ownapitest.Model.User
import com.example.ownapitest.Network.NetworkService
import com.example.ownapitest.R
import kotlinx.android.synthetic.main.fr_profile.*
import kotlinx.android.synthetic.main.fr_settings.*
import retrofit2.Call
import retrofit2.Response

class SettingsFragment : Fragment(){

    companion object{
        fun newInstanse():SettingsFragment{
            return SettingsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_settings,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val user = (activity!!.applicationContext as ApplicationSingleton).getCurrentUser()
        et_email.setText(user.email)
        et_name.setText(user.name)
        et_password.setText(user.password)
        btn_change.setOnClickListener {
            val newUser = User(et_email.text.toString(),et_name.text.toString(),et_password.text.toString())
            NetworkService.getInstance().networkApi.change(newUser,user).enqueue(object :retrofit2.Callback<User>{
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })

        }
    }


}