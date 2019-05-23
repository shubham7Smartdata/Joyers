package com.sdi.joyers.activities

import android.content.Context
import android.view.View
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdi.joyers.R
import com.sdi.joyers.data.UserModel
import com.sdi.joyers.viewModel.UserViewModel
import kotlinx.android.synthetic.main.activity_sign_up.*


class SignUpActivity : BaseActivity<UserViewModel>(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.activity_sign_up

    override val viewModel: UserViewModel
        get() = ViewModelProviders.of(this).get(UserViewModel::class.java)

    override val context: Context
        get() = this@SignUpActivity

    override fun onCreate() {
        mViewModel!!.getUser().observe(this, object : Observer<UserModel> {
            override fun onChanged(@Nullable loginUser: UserModel) {
                lblEmailAnswer.text = loginUser.email
                lblPasswordAnswer.text = loginUser.name
            }
        })
    }

    override fun initListeners() {
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnLogin -> {
                mViewModel!!.setLoginData(
                    UserModel(
                        "1", txtEmailAddress.text.toString(),
                        txtPassword.text.toString())
                )
            }
//            R.id.btn_fb_login -> {
//
//            }

//            R.id.btn_google_login -> {
//
//            }
        }
    }

}

