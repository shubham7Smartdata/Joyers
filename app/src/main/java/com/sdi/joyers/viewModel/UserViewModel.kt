package com.sdi.joyers.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sdi.joyers.data.UserModel
import com.sdi.joyers.repositories.UserRepository


class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: UserRepository = UserRepository(application)

    private var mUserModel: MutableLiveData<UserModel>? = null

    fun getUser(): MutableLiveData<UserModel> {
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
        }
        return mUserModel as MutableLiveData<UserModel>
    }

    fun setLoginData(email: String, password: String){
        mUserModel!!.value = mRepository.registerUser(email = email, password = password)
    }

}