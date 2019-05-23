package com.sdi.joyers.viewModel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sdi.joyers.data.UserModel
import com.sdi.joyers.repositories.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: UserRepository = UserRepository(application)

    private var mUserModel: MutableLiveData<UserModel>? = null

    var email: MutableLiveData<String> = MutableLiveData()
    var name: MutableLiveData<String> = MutableLiveData()

    fun getUser(): MutableLiveData<UserModel> {
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
        }
        return mUserModel as MutableLiveData<UserModel>
    }

    fun onClick(view: View) {
        val loginUser = UserModel("1", email.value, name.value)
        mUserModel!!.value = loginUser
    }

}