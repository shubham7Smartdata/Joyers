package com.sdi.joyers.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.sdi.joyers.data.UserModel
import com.sdi.joyers.repositories.UserRepository


class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: UserRepository = UserRepository(application)

    private var mUserModel: MutableLiveData<UserModel>? = null
    private var mLoading: MutableLiveData<Boolean>? = null

    fun getUser(): MutableLiveData<UserModel> {
        if (mUserModel == null) {
            mUserModel = MutableLiveData()
        }
        return mUserModel as MutableLiveData<UserModel>
    }

    fun getLoading(): MutableLiveData<Boolean> {
        if (mLoading == null) {
            mLoading = MutableLiveData()
        }
        return mLoading as MutableLiveData<Boolean>
    }

    fun setLoginData(email: String, password: String) {
        mLoading!!.value=true
        mUserModel!!.value = mRepository.registerUser(email = email, password = password)
    }

}