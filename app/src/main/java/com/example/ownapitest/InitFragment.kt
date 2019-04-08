package com.example.ownapitest

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fr_init.*

class InitFragment : Fragment() {
    companion object {
        public fun newInstance(): InitFragment {
            return InitFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_init, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btn_sign_in.setOnClickListener { v ->
            run {
                LoginActivity.changeFragment(LoginFragment.newInstance())
            }
        }
        btn_sign_up.setOnClickListener { v ->
            run {
                LoginActivity.changeFragment(RegistrationFragment.newInstance())
            }
        }


    }


}