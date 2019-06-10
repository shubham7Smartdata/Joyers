package com.sdi.joyers.repositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.sdi.joyers.data.UserModel
import com.sdi.joyers.network.RetrofitClient
import com.sdi.joyers.room.DaoAccess
import com.sdi.joyers.room.RoomDb
import com.sdi.joyers.utils.LoadingDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(application: Application) {
    private val daoAccess: DaoAccess
    private var mUserModel: UserModel? = null

    init {
        val database = RoomDb.getInstance(application)
        daoAccess = database.noteDao()
        mUserModel = UserModel()
    }


    fun registerUser(email: String, password: String): UserModel? {
        RetrofitClient.instance!!.register_user(email, password).enqueue(
                object : Callback<UserModel> {
                    override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                        Log.d("mresponse", response.toString())
                        mUserModel = response.body()
                        LoadingDialog.getLoader().dismissLoader()
                    }
                    override fun onFailure(call: Call<UserModel>, t: Throwable) {
                        Log.d("mresponse", t.toString())
                        LoadingDialog.getLoader().dismissLoader()
                    }
                })
        return mUserModel
    }

}
