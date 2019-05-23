package com.sdi.joyers.activities

import android.content.Context
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sdi.joyers.BR
import com.sdi.joyers.R
import com.sdi.joyers.data.UserModel
import com.sdi.joyers.databinding.ActivitySignUpBinding
import com.sdi.joyers.viewModel.UserViewModel

class SignUpActivity : BaseActivity<ActivitySignUpBinding, UserViewModel>() {

    override val bindingVariable: Int
        get() = BR.mViewModel

    override val layoutId: Int
        get() = R.layout.activity_sign_up

    override val viewModel: UserViewModel
        get() = ViewModelProviders.of(this).get(UserViewModel::class.java)

    override val context: Context
        get() = this@SignUpActivity

    override fun onCreate() {
        viewModel.getUser().observe(this, object : Observer<UserModel> {
            override fun onChanged(@Nullable loginUser: UserModel) {
                viewDataBinding!!.lblEmailAnswer.text = loginUser.email
                viewDataBinding!!.lblPasswordAnswer.text = loginUser.name

            }
        })
    }

}

